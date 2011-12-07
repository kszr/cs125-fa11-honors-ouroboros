
/**
 * Abstract class. There are three different types of food objects:
 * 1. Red: worth 1 point
 * 2. Blue: worth 2 points
 * 3. Green: worth 4 points
 * 
 *  * @author chattrj3, nayudu2 , sgupta40
 *  
 */

public class Food {
	
	protected int x, y; // X,Y co-ordinates of the Food.
	protected boolean isEaten=false; // Is this food eaten by the snake? 
	
	public Food() {

	}
	//Constructor
	public Food(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//Check if snake is within eating distance.
	public boolean isEaten(int x, int y) {
		return Math.abs(this.x-x)<20 && Math.abs(this.y-y)<20;
	}
	//Return isEaten.
	public boolean getFlag() {
		return isEaten;
	}
	//Set isEaten = true, once the snake crosses over, aka eats the block.
	public void setFlag() {
		isEaten = true;
	}
	
}
