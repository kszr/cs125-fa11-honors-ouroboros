/**
 * 
 * @author chattrj3, nayudu2
 *
 */
public class BlueFood extends Food {
	
	private static int points=2;
	private int rand;
	
	public BlueFood(int x, int y) {
		super(x, y);
		
		rand = (int)(2*Math.random());
	}
	
	public int getPoints() {
		return points;
	}
	
	public void draw() {
		Zen.setColor(10,10,250);
		
		if(rand == 0)
			Zen.fillOval(x, y, 20, 20);
		else
			Zen.fillRect(x, y, 20, 20);

	}

}