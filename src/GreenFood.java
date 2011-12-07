/**
 * 
 * @author chattrj3, nayudu2
 *
 */
public class GreenFood extends Food {
	
	private static int points=4;
	private int rand;
	
	public GreenFood(int x, int y) {
		super(x, y);
		
		rand = (int)(2*Math.random());
	}
	
	public int getPoints() {
		return points;
	}
	
	public void draw() {
		Zen.setColor(10,250,10);
		
		if(rand == 0)
			Zen.fillOval(x, y, 20, 20);
		else
			Zen.fillRect(x, y, 20, 20);
	}

}
