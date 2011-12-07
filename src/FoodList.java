
/**
 * Creates a list of different, randomly selected types of Food objects.
 * @author chattrj3, nayudu2, sgupta40
 *
 */
public class FoodList {
	private Food[] omega = new Food[4];
	private boolean[] isEaten = new boolean[4];
	private static int size=4;
	private static RandomPoints points = new RandomPoints(size);

	public FoodList() {
		omega[0] = new LifeFood(points.getX()[0], points.getY()[0]);
		for(int i=1; i<size; i++)
			omega[i] = getRandomFoodObject(i);
	}

	/**
	 * To be used when all food objects have been eaten. The size of the arrays are increased every time
	 * this method is called.
	 */
	public void refreshList() {
		size++;
		points = new RandomPoints(size);
		omega = new Food[size];
		isEaten = new boolean[size];
		omega[0] = new LifeFood(points.getX()[0], points.getY()[0]);
		for(int i=1; i<size; i++)
			omega[i] = getRandomFoodObject(i);
	}

	/**
	 * Generates a random Food object - i.e., a red, blue, green, or life object. The method takes an integer
	 * value and returns the coordinates associated with it in the RandomPoints object points.
	 * @param a
	 * @return
	 */
	private static Food getRandomFoodObject(int a) {
		int r = (int)(3*Math.random());

		if(r==0) return new RedFood(points.getX()[a], points.getY()[a]);
		if(r==1) return new BlueFood(points.getX()[a], points.getY()[a]);
		return new GreenFood(points.getX()[a], points.getY()[a]);
	}

	/**
	 * 
	 * @return true, if every food object has been eaten.
	 */
	public boolean isEaten() {
		for(int i=0; i<size; i++)
			if(!isEaten[i]) return false;

		return true;
	}
	
	/**
	 * Return the snake object if the snake has eaten
	 * @param s
	 * @return
	 */
	public Food eaten(Snake s) {
		for(int i=0; i<omega.length; i++)
			if(omega[i].isEaten(s.getX(), s.getY()))
				return omega[i];
		
		return null;
		
	}
	
	/**
	 * Set the corresponding isEaten point to true or false if the snake has eaten
	 * @param x
	 * @param y
	 */
	public void setEaten(int x, int y) {
		for(int i=0; i<size; i++)
			if(Math.abs(x-points.getX()[i])<=21 && Math.abs(y-points.getY()[i])<=21) {
				isEaten[i]=true;
				break;
			}
	}
	
	/**
	 * Returns the Food object at a particular index location.
	 * @param a
	 * @return
	 */
	public Food getFoodAt(int a) {
		return omega[a];
	}

	public void draw() {
		for(int i=0; i<size; i++){
			if(!isEaten[i]) {
				if(omega[i] instanceof RedFood) ((RedFood)omega[i]).draw();
				if(omega[i] instanceof BlueFood) ((BlueFood)omega[i]).draw();
				if(omega[i] instanceof GreenFood) ((GreenFood)omega[i]).draw();
				if(omega[i] instanceof LifeFood) ((LifeFood)omega[i]).draw();
			}
		}
	}

	public int[] GetPointsX() {

		return points.getX();

	}

	public int[] GetPointsY() {

		return points.getY();

	}

	public int GetSize() {
		return size;
	}


}