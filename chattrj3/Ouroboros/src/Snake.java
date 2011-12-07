
//An abstract class for the Snake.
public class Snake {
	
private int x, y, species;
	
	public Snake() {
		x = 250;
		y = 250;
	}
	
	public Snake(int a, int b) {
		x = a;
		y = b;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int a) {
		this.x=a;
	}
	public void setY(int a) {
		this.y=a;
	}
}
