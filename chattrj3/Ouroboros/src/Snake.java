/**
 * An abstract class for the Snake.
 * @author chattrj3, nayudu2, sgupta40
 *
 */
public class Snake {
	
	private int x, y; //X,Y co-ordinates of the snake.
	
	//Default intilization of the snake.
	public Snake() {
		x = 250;
		y = 250;
	}
	
	//Parameterized Constructor for the snake.
	public Snake(int a, int b) {
		x = a;
		y = b;
	}
	
	//Return snake's x location
	public int getX() {
		return x;
	}
	
	//Return snake's y location
	public int getY() {
		return y;
	}
	
	//Set the snakes current x location
	public void setX(int a) {
		this.x = a;
	}
	
	//Set the snakes current y location
	public void setY(int a) {
		this.y = a;
	}
}
