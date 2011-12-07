/**
 * A class defined to assign random valued points to it's instance variables.
 * It assigns random values between 20 and 600 for X, 20 to 440 for Y, to the 
 * integer arrays defined in the class.
 * @author chattrj3, nayudu2, sgupta40
 *
 */
public class RandomPoints {

	private int size; //Size of X and Y, increases as game progresses.
	private int x[]; //Array of X
	private int y[]; //Array of Y
	
	//Create random points based on the user specified size.
	//This method is a constructor.
	public RandomPoints(int s) {
		
		size = s;
		x = new int[size];
		y = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			x[i] = 20 + (int)(600*Math.random());
			y[i] = 20 + (int)(440*Math.random());
		}
		
		/**
		 * Initially block was created to test values of X and Y
		 * so that they were never within 20 pixels of each other,
		 * but this took way too much time and hanged the program.
		 */
		/*for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				while(Math.abs(x[i] - x[j]) <= 20){
					x[i] = 20 + (int)(619*Math.random());
				}
				while(Math.abs(y[i] - y[j]) <= 20){
					y[i] = 20 + (int)(459*Math.random());
				}
			}
		}*/
	}
	
	//Return the array of X
	public int[] getX() {
		return x;
	}
	
	//Return the array of Y
	public int[] getY() {
		return y;
	}
}
