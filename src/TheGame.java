/**
 * @author chattrj3, nayudu 2
 */
import java.awt.event.*;

public class TheGame {

	private static int direction;

	public static void main(String[] args) {


		Zen.create(900, 480, "");

		BigSnake snake = new BigSnake();
		snake.add();

		Snake head = snake.getHead();

		while(!MenuOptions.Menu());
		MenuOptions.DrawInter();
		int SnakeType = MenuOptions.SnakeChoice();


		FoodList food = new FoodList();

		while(Zen.isRunning()) {

			snake.move(setDirection());
			snake.draw(SnakeType, direction);

			int points=0;

			Food eaten = food.eaten(head);

			if(eaten!=null && !eaten.getFlag()) {
				if(eaten instanceof LifeFood && snake.getLives()<5) snake.updateLives();
				else if(eaten instanceof RedFood) points = ((RedFood)eaten).getPoints();
				else if(eaten instanceof GreenFood) points = ((GreenFood)eaten).getPoints();
				else if(eaten instanceof BlueFood) points = ((BlueFood)eaten).getPoints();
				else points=0;
				System.out.println(points);
				eaten.setFlag();
			}


			for(int j=0; j<points; j++)
				snake.add();
			snake.drawLives(660, 200);
			food.setEaten(head.getX(), head.getY());
			
			/*int pointie=0;

			for(int i=0; i<food.GetSize(); i++) {
				Food now = food.getFoodAt(i);
	
				if(!now.isEaten(head.getX(), head.getY()) && !now.getFlag()) {
					if(now instanceof LifeFood && snake.getLives()<5) snake.updateLives();
					else if(now instanceof RedFood) pointie = ((RedFood)now).getPoints();
					else if(now instanceof GreenFood) pointie = ((GreenFood)now).getPoints();
					else if(now instanceof BlueFood) pointie = ((BlueFood)now).getPoints();
					now.setFlag();
					break;
				}
			}
			
			for(int j=0; j<pointie; j++)
				snake.add();*/

			if(food.isEaten())
				food.refreshList();

			food.draw();

			Borders.createBox(0,0,64,48);
			Borders.createBox(640,0,26,48);



			MenuOptions.ScoreBoard(snake.getSize(), System.currentTimeMillis() - MenuOptions.startTime);

			if(snake.intersects()) 
			{
				//WriteFile(snake.getSize(), System.currentTimeMillis() - MenuOptions.startTime);
				snake.loseLife();
				if(snake.getLives()==0) snake.kill();
				snake.discard();
			}

			Zen.flipBuffer();
			Zen.sleep(100);
		}
	}

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

	public static void WriteFile(int length, long time) {

		boolean done = false;
		String[] ScoreList = new String[10];
		String[] TimeList = new String[10];
		char[][] CharList = new char[10][];
		int[] Scores = new int[10];
		long[] Times = new long[10];



		while(!TextIO.eof()){

			TextIO.readFile("HighScore.txt");

			for(int i = 0; i < 10 ; i++)
			{
				CharList[i] = TextIO.getln().toCharArray();
				for(int j = 0; j < CharList[i].length; j++){

					if((CharList[i][j] == '1' || CharList[i][j] == '2' || CharList[i][j] == '3' 
						|| CharList[i][j] == '4' || CharList[i][j] == '5' || CharList[i][j] == '6' 
							|| CharList[i][j] == '7' || CharList[i][j] == '8' || CharList[i][j] == '9') && !done)
					{
						ScoreList[i] = ScoreList[i] + CharList[i][j];
					}

					if(CharList[i][j] == ' ')
					{
						done = true;
						for(int k = j; k < CharList[i].length; k++){

							TimeList[i] = TimeList[i] + CharList[i][k];

						}
					}
				}
			}
		}


		for(int i = 0; i < 10; i++)
		{
			Times[i] = Integer.parseInt(TimeList[i]);
		}

		for(int i = 0; i < 10; i++)
		{
			Scores[i] = Integer.parseInt(ScoreList[i]);
		}

		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(Scores[i] > Scores[j])
				{
					int temp = Scores[i];
					Scores[i] = Scores[j];
					Scores[j] = temp;
				}
			}
		}


		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(Scores[i] == Scores[j])
				{
					if(Times[i] > Times[j])
					{
						long temp = Times[i];
						Times[i] = Times[j];
						Times[j] = temp;
					}
				}
			}
		}

		int index=0;

		for(int i=0; i<10; i++)
			if(Scores[i]>length) {
				index=i;
				break;
			}

		int[] a = new int[10];
		long[] b = new long[10];

		a[index]=length;
		b[index]=time;

		for(int i=0; i<index; i++) {
			System.arraycopy(Scores, 0, a, 0, index);
			System.arraycopy(Times, 0, b, 0, index);
		}
		for(int i=index+1; i<10; i++) {
			System.arraycopy(Scores, index, a, index+1, 10-index-1);
			System.arraycopy(Times, index, b, index+1, 10-index-1);
		}

		Scores=a;
		Times=b;


		TextIO.writeFile("HighScore.txt");
		for(int i = 0; i < 10; i++)
		{
			TextIO.putln("\n" + Scores[i] + " " + Times[i]);
		}
	}

}
