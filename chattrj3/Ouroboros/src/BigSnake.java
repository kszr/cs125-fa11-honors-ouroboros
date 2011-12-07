/**
 * A Class designed to implement all the methods regarding a snake.
 * @author chattrj3, nayudu2, sgupta40
 *
 */

public class BigSnake {
	private Snake[] snake = new Snake[0];
	private static int size=0; //Current length of the snake
	private static int current=0; //Stores the index of the last snake object.
	private static int lives = 1;
	private static boolean first = true;

	
	/**
	 * Creates a new Snake object and appends it to the end of the snake. The x- and y-coordinates
	 * of the new object are calculated using those of the last (current) Snake object.
	 */
	public void add() {
		size++;
		Snake[] temp = new Snake[size];
		if(size-1 > 0)
			temp[size-1] = new Snake(snake[current].getX() - 20, snake[current].getY());
		else temp[size-1] = new Snake();
		for(int i=0; i<snake.length; i++)
			temp[i] = snake[i];
		current = size-1;
		snake = temp;
	}
	
	/**
	 * Discards every Snake object after the object at the index returned by intersectsAt().
	 */
	public void discard() {
		int index = intersectsAt(); 
		
		if(index > 0) {
			Snake[] discarded = new Snake[index];

			for(int i=0; i<index; i++)
				discarded[i]=snake[i];
		
			snake = discarded;
			
			size = snake.length;
			current = snake.length-1;
		}
	}
	
	/**
	 * A method for the end-game screen
	 */
	public void kill() {
		
		while(Zen.isRunning()){
			Zen.flipBuffer();
			Zen.setColor(0,0,0);
			Zen.fillRect(0,0, Zen.getZenWidth(), Zen.getZenHeight());
			Zen.setColor(255,255,255);
			Zen.setFont("Lucida Sans-60");
			Zen.drawText("GAME OVER", 280,150);
			Zen.setFont("Lucida Sans-30");
			Zen.drawText("SNAKE LENGTH:", 240, 250);
			Zen.drawText(""+size, 600,250);	
		}
	}
	
	/**
	 * Moves the Snake object by assigning new coordinates to the head, and calling changeCoordinates()
	 * to change the coordinates of the rest of the Snake objects.
	 * @param Direction: 0=up; 1=right; 2=down; 3=left.
	 */
	public void move(int a) {

		Snake head = snake[0];

		if(a==0 && head.getY()>10) {
			changeCoordinates(snake);
			head.setY(head.getY()-20);
		}
		
		if(a==1 && head.getX()<630) {
			changeCoordinates(snake);
			head.setX(head.getX()+20);
		}

		if(a==2 && head.getY()<470) {
			changeCoordinates(snake);
			head.setY(head.getY()+20);
		}
		
		if(a==3 && head.getX()>10) {
			changeCoordinates(snake);
			head.setX(head.getX()-20);		
		}
		
		if(head.getX() < 11) head.setX(619);
		if(head.getX() > 619) head.setX(11);
		if(head.getY() < 11) head.setY(459);
		if(head.getY() > 459) head.setY(11);
	}
	
	/**
	 * 
	 * @return true, if the coordinates of the head match those of any other Snake in the array.
	 */
	
	public boolean intersects(int a) {
		Snake head = snake[0];
		
		for(int i=1; i<snake.length; i++){
			if(head.getX()==snake[i].getX() && head.getY()==snake[i].getY()){
				if(a == 3 && first){
					first = false;
					return false;
				}
				
					else return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @return the index at which the snake intersected itself. Returns -1, if the snake did not
	 * intersect itself.
	 */
	private int intersectsAt() {
		Snake head = snake[0];
		
		for(int i=1; i<snake.length; i++)
			if(head.getX()==snake[i].getX() && head.getY()==snake[i].getY())
				return i;
		
		return -1;
	}
	
	/**
	 * Coordinates at positions 0, 1, 2, ... are assigned to positions 1, 2, 3, ... etc. 
	 * New coordinates at position 0 need to be assigned separately.
	 * @param snake
	 */
	private static void changeCoordinates(Snake[] snake) {
		for(int i=snake.length-1; i>0; i--) {
			snake[i].setX(snake[i-1].getX());
			snake[i].setY(snake[i-1].getY());
		}
	}
	
	/**
	 * Draws the snake.
	 */
	public void draw(int species, int orient) {
		if(species==0) {
			if(orient == 0)
				Zen.drawImage("Snake Head.gif", snake[0].getX(), snake[0].getY());
			else if(orient == 1)
				Zen.drawImage("Snake Head1.gif", snake[0].getX(), snake[0].getY());
			else if(orient == 2)
				Zen.drawImage("Snake Head2.gif", snake[0].getX(), snake[0].getY());
			else if(orient == 3)
				Zen.drawImage("Snake Head3.gif", snake[0].getX(), snake[0].getY());

			for(int i=1; i<snake.length; i++)
				Zen.drawImage("Snake Body.gif", snake[i].getX(), snake[i].getY());
		}
		else if(species==1) {
			if(orient == 0)
				Zen.drawImage("Snake_Head.gif", snake[0].getX(), snake[0].getY());
			else if(orient == 1)
				Zen.drawImage("Snake_Head1.gif", snake[0].getX(), snake[0].getY());
			else if(orient == 2)
				Zen.drawImage("Snake_Head2.gif", snake[0].getX(), snake[0].getY());
			else if(orient == 3)
				Zen.drawImage("Snake_Head3.gif", snake[0].getX(), snake[0].getY());

			for(int i=1; i<snake.length; i++)
				Zen.drawImage("Snake_Body.gif", snake[i].getX(), snake[i].getY());
		}
	}
	
	/**
	 * 	
	 * @return the head of the snake - that is, the object at position 0.
	 */
	public Snake getHead() {
		if(snake.length>0) return snake[0];
		return null;
	}
	
	/**
	 * 
	 * @return the length of the snake.
	 */
	public int getSize() {
		return snake.length;
	}
	
	/**
	 * 
	 * @return the number of lives remaining.
	 */
	public int getLives() {
		return lives;
	}
	
	/**
	 * 
	 * @return true, if the snake is dead.
	 */
	public boolean isDead() {
		return lives==0;
	}
	
	/**
	 * Increases the number of lives the snake has by 1. 
	 */
	public void updateLives() {
		lives++;
	}
	
	/**
	 * Decreases the number of lives the snake has by 1.
	 */
	public void loseLife() {
		lives--;
	}
	
	/**
	 * Draw the lives on the screen, maximum lives being 3.
	 * @param x
	 * @param y
	 */
	public void drawLives(int x, int y) {

		if(lives >= 3) lives = 3;
		for(int i = 0; i < lives; i++){	
			Zen.drawImage("Health Bar.png", x + (25*i), y);
		}
	}

}