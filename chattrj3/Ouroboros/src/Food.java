
/**
 * Abstract class. There are three different types of food objects:
 * 1. Red: worth 1 point
 * 2. Blue: worth 2 points
 * 3. Green: worth 4 points
 * 
 *  * @author chattrj3, nayudu2
 *  
 */

public class Food {
	
	protected int x, y;
	protected boolean isEaten=false;
	
	public Food() {

	}
	
	public Food(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public boolean isEaten(int x, int y) {
		return Math.abs(this.x-x)<20 && Math.abs(this.y-y)<20;
	}
	public boolean getFlag() {
		return isEaten;
	}
	public void setFlag() {
		isEaten=true;
	}
	
}
