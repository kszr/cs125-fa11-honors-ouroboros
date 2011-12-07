
public class Borders {

	private static void verticalBlock(int a, int b){
		
		Zen.setColor(255,255,255);
		Zen.fillRect(a+2, b, 2, 10);
		Zen.fillRect(a+6, b, 2, 10);
		
	}
	
	private static void horizontalBlock(int a, int b){
		Zen.setColor(255,255,255);

		Zen.fillRect(a, b+2, 10, 2);
		Zen.fillRect(a, b+6, 10, 2);
		
	}
	//Various basic maze elements begin here.
	private static void verticalLine(int startX, int startY, int length){
		Zen.setColor(255,255,255);

		for(int i = 1; i <= length; i++)
		{
			verticalBlock(startX,startY);
			startY+=10;
		}
	}
	
	private static void horizontalLine(int startX, int startY, int length){
		Zen.setColor(255,255,255);

		for(int i = 1; i <= length; i++)
		{
			horizontalBlock(startX,startY);
			startX+=10;
		}
	}
	
	private static void corner1(int startX, int startY){
		Zen.setColor(255,255,255);

		Zen.fillRect(startX+2, startY+2, 8, 2);
		Zen.fillRect(startX+6, startY+6, 4, 2);
		Zen.fillRect(startX+2, startY+2, 2,8);
		Zen.fillRect(startX+6, startY+6, 2,4);
		
	}
	
	private static void corner2(int startX, int startY){
		Zen.setColor(255,255,255);

		Zen.fillRect(startX, startY+2, 8, 2);
		Zen.fillRect(startX, startY+6, 4, 2);
		Zen.fillRect(startX+6, startY+2, 2,8);
		Zen.fillRect(startX+2, startY+6, 2,4);
		
	}
	
	private static void corner3(int startX, int startY){
		Zen.setColor(255,255,255);

		Zen.fillRect(startX+2, startY+6, 8, 2);
		Zen.fillRect(startX+6, startY+2, 4, 2);
		Zen.fillRect(startX+2, startY, 2,8);
		Zen.fillRect(startX+6, startY, 2,4);
		
	}
	
	private static void corner4(int startX, int startY){
		Zen.setColor(255,255,255);

		Zen.fillRect(startX, startY+6, 8, 2);
		Zen.fillRect(startX, startY+2, 4, 2);
		Zen.fillRect(startX+6, startY, 2,8);
		Zen.fillRect(startX+2, startY, 2,4);
		}
	
	public static void createBox(int startX, int startY, int length, int breadth){
		Zen.setColor(255,255,255);

		corner1(startX,startY);
		verticalLine(startX, startY+10, breadth-2);
		corner3(startX, startY+10+(10*(breadth-2)));
		horizontalLine(startX+10, startY, length-2);
		horizontalLine(startX+10, startY+10+(10*(breadth-2)), length-2);
		corner4(startX+10+(10*(length-2)), startY+10+(10*(breadth-2)));
		corner2(startX+10+(10*(length-2)), startY);
		verticalLine(startX+10+(10*(length-2)), startY+10, breadth-2);
	}
	
	
}
