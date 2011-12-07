
/**
 * 
 * @author chattrj3, nayudu2
 *
 */
public class LifeFood extends Food {
	
	private static int life = 1;
	
	public LifeFood(int x, int y) {
		super(x, y);
	}
	
	public int getLife() {
		return life;
	}
	
	public void draw(){
		
		Zen.drawImage("Health Bar.png",x,y);
	}
}
