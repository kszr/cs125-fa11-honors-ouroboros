/**
 * The Class that defines the game, and implements all of the classes.
 * @author chattrj3, nayudu2, sgupta40
 */
import java.awt.event.*;

public class TheGame {

	private static int direction;

	/**
	 * The main function that implements all the classes
	 * @param args
	 */
	public static void main(String[] args) {

		HighScore.SetScoreArray(); //Initialize the scores
		
		Zen.create(900, 480, ""); // Set the screen width and height

		BigSnake snake = new BigSnake(); // Define a new snake
		
		snake.add(); // Add one part to the snake

		Snake head = snake.getHead(); // Get the head of the snake

		while(!MenuOptions.Menu()); //Run menu till an option is selected
		Zen.resetClick(); //Reset the values of mouseclicks
		int SnakeType = MenuOptions.SnakeChoice(); //Open the avatar selection menu


		FoodList food = new FoodList(); //Make some new food

		/*
		 * Start Zen Graphics with the game.
		 */
		while(Zen.isRunning()) {

			snake.move(setDirection());
			snake.draw(SnakeType, direction);

			int points = 0;

			Food eaten = food.eaten(head);
			
			/*
			 * Check if the food is eaten
			 */
			if(eaten!=null && !eaten.getFlag()) {
				if(eaten instanceof LifeFood && snake.getLives()<5) snake.updateLives();
				else if(eaten instanceof RedFood) points = ((RedFood)eaten).getPoints();
				else if(eaten instanceof GreenFood) points = ((GreenFood)eaten).getPoints();
				else if(eaten instanceof BlueFood) points = ((BlueFood)eaten).getPoints();
				else points=0;
				eaten.setFlag();
			}

			//Increase the length of the snake based on points
			for(int j = 0; j < points; j++)
				snake.add();
			snake.drawLives(660, 200);
			food.setEaten(head.getX(), head.getY());
			
			//If all the food is eaten, make some new food
			if(food.isEaten())
				food.refreshList();

			food.draw();

			//Create the boxes to partition the space
			Borders.createBox(0,0,64,48);
			Borders.createBox(640,0,26,48);


			//Draw the scoreboard
			MenuOptions.ScoreBoard(snake.getSize(), System.currentTimeMillis() - MenuOptions.startTime);
			
			//What happens if the snake hit's itself? The below code block of course!
			if(snake.intersects(direction)) 
			{
				HighScore.InsertScore(snake.getSize(), System.currentTimeMillis() - MenuOptions.startTime);
				snake.loseLife();
				if(snake.getLives()==0) snake.kill();
				snake.discard();
			}

			Zen.flipBuffer(); //flipbuffer to smooth the graphics refresh
			Zen.sleep(100); //Essentially define the speed of the snake here
		}
	}

	/**
	 * Define the User Keyboard input as the game begins.
	 * Notice the "&& direction!=X", where X is the current
	 * orientation of the snake. This is so that the snake
	 * cannot move backwards.
	 * @return
	 */
	public static int setDirection() {
		if(Zen.isVirtualKeyPressed(KeyEvent.VK_UP) && direction!=2) {
			direction =0;
			return 0;
		}
		if(Zen.isVirtualKeyPressed(KeyEvent.VK_RIGHT) && direction!=3) {
			direction=1;
			return 1;
		}
		if(Zen.isVirtualKeyPressed(KeyEvent.VK_DOWN) && direction!=0) {
			direction=2;
			return 2;
		}
		if(Zen.isVirtualKeyPressed(KeyEvent.VK_LEFT) && direction!=1) {
			direction=3;
			return 3;
		}
		return direction;
	}

}
