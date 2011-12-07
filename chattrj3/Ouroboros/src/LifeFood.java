
/**
 * A subclass of Food, defining the Life Block.
 * @author chattrj3, nayudu2, sgupta40
 *
 */
public class LifeFood extends Food {
	
	private static int life = 1; // Default number of lives.
	
	//Constructor
	public LifeFood(int x, int y) {
		super(x, y);
	}
	
	//Returns the number of lives remaining.
	public int getLife() {
		return life;
	}
	
	//Draw the Health Block on the screen.
	public void draw(){
		
		Zen.drawImage("Health Bar.png",x,y);
	}
}
