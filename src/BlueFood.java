/**
 * A subclass of Food, defining the Blue Food block.
 * @author chattrj3, nayudu2, sgupta40
 *
 */
public class BlueFood extends Food {
	
	private static int points = 2;
	private int rand;
	
	//Constructor
	public BlueFood(int x, int y) {
		super(x, y);
		
		rand = (int)(2*Math.random());
	}
	
	//Return points, aka the increment in length of the snake.
	public int getPoints() {
		return points;
	}
	
	//Randomly draw a blue oval or square, to be used as food.
	public void draw() {
		Zen.setColor(10,10,250);
		
		if(rand == 0)
			Zen.fillOval(x, y, 20, 20);
		else
			Zen.fillRect(x, y, 20, 20);

	}

}