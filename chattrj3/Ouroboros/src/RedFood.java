
/**
 * 
 * @author chattrj3
 *
 */
public class RedFood extends Food {
	
	private static int points = 1;
	private int rand;
	
	public RedFood(int x, int y) {
		super(x, y);
		
		rand = (int)(2*Math.random());
	}
	
	public int getPoints() {
		return points;
	}
	
	public void draw() {
		Zen.setColor(250,10,10);
		
		if(rand == 0)
			Zen.fillOval(x, y, 20, 20);
		else
			Zen.fillRect(x, y, 20, 20);
	}

}
