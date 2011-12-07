
public class RandomPoints {

	private int size;
	private int x[];
	private int y[];
	
	public RandomPoints(int s) {
		
		size = s;
		x = new int[size];
		y = new int[size];
		
		for(int i = 0; i < size; i++)
		{
			x[i] = 20 + (int)(600*Math.random());
			y[i] = 20 + (int)(440*Math.random());
		}
		
	/*	for(int i = 0; i < size; i++)
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
	
	public int[] getX() {
		return x;
	}
	public int[] getY() {
		return y;
	}
}
