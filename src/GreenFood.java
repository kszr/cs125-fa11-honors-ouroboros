/**
 * A subclass of Food, Defining the Green Food Block.
 * @author chattrj3, nayudu2, sgupta40
 *
 */
public class GreenFood extends Food {
	
	private static int points = 4;
	private int rand;
	
	//Constructor
	public GreenFood(int x, int y) {
		super(x, y);
		
		rand = (int)(2*Math.random());
	}
	
	//Return points, aka the increment in length of the snake.
	public int getPoints() {
		return points;
	}
	
	//Randomly draw a blue oval or square, to be used as food.
	public void draw() {
		Zen.setColor(10,250,10);
		
		if(rand == 0)
			Zen.fillOval(x, y, 20, 20);
		else
			Zen.fillRect(x, y, 20, 20);
	}

}
