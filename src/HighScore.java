/**
 * A Class designed to implement the "High Score" Function in the game.
 * The Class contains methods to..
 * - Get Elements from a file.
 * - Insert Elements into the file.
 * - Sort Elements from the file, and put them back in the file.
 * @author chattrj3, nayudu2, sgupta40
 *
 */
public class HighScore {

	public static int size = 0; //Current number of scores in the file.
	public static String[] HighString = new String[size]; // Store the values of each line from the file
	public static int[] HighSize = new int[size]; // Store the lengths of the snakes.
	public static long[] HighTime = new long[size]; // Store the durations of the respective lengths of the snake.
	
	//Default constructor
	public HighScore(){
	}
	
	/**
	 * A method to sort the scores in the file "HighScore.txt"
	 */
	public static void SetScoreArray(){
		
		size = CountLines(); //Assign number of lines by using CountLines() method
		HighString = new String[size]; 
		HighSize = new int[size];
		HighTime = new long[size];
		
		boolean done = false; // One Way Flag.
		String[] SizeTemp = new String[size]; //Temporary Arrays to use while sorting.
		String[] TimeTemp = new String[size];
		
		int index = 0; //Index to be used in the while loop
		if(size == 0) return;
		else
		{
			TextIO.readFile("HighScore.txt");
			while(!TextIO.eof()){
				HighString[index] = TextIO.getln();
				index++;				
			}
		}
		/*
		 * This for loop splits the lines into an integer part (length) and long part (time)
		 * Used a long "if" instead of some system function to check if the character is an integer.
		 */
		for(int i = 0; i < size; i++)
		{
			done = false;
			SizeTemp[i] = "";
			TimeTemp[i] = "";
			for(int j = 0; j < HighString[i].length(); j++)
			{
			if((HighString[i].charAt(j) == '1'
				|| HighString[i].charAt(j) == '2'
					|| HighString[i].charAt(j) == '3'
						|| HighString[i].charAt(j) == '4'
							|| HighString[i].charAt(j) == '5'
								|| HighString[i].charAt(j) == '6'
									|| HighString[i].charAt(j) == '7'
										|| HighString[i].charAt(j) == '8'
											|| HighString[i].charAt(j) == '9'
												|| HighString[i].charAt(j) == '0') && !done)
				{
					SizeTemp[i] = SizeTemp[i] + HighString[i].charAt(j); //Put lengths in
				}
			if(HighString[i].charAt(j) == ' '){
				
				done = true;
				for(int k = j+1; k < HighString[i].length(); k++ )
				{
				TimeTemp[i] = TimeTemp[i] + HighString[i].charAt(k); //Put Times in
				}
			}
			
			}
		}
		
		//Put the strings values into integer arrays using parse.
		for(int i = 0; i < size; i++){
			HighSize[i] = Integer.parseInt(SizeTemp[i]);
		}
		
		//Put the string values into integer arrays using parse.
		for(int i = 0; i < size; i++){
			HighTime[i] = Integer.parseInt(TimeTemp[i]);
		}
		
		//Sort the Lengths.
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++){
				if(HighSize[i] > HighSize[j]){
					int temp = HighSize[i];
					HighSize[i] = HighSize[j];
					HighSize[j] = temp;
				}
			}
		}
		
		//Sort the Times, but ensure to not mix up the times.
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++){
				if(HighSize[i] == HighSize[j]){ //Prevents mix-up
					if(HighTime[i] > HighTime[j]){
						long temp = HighTime[i];
						HighTime[i] = HighTime[j];
						HighTime[j] = temp;
					}
				}
				
			}
		}
		
		TextIO.writeFile("HighScore.txt");
		for(int i = 0; i < size; i++){
			TextIO.putln(HighSize[i] + " " + HighTime[i]);
		}
	}
	
	/**
	 * A method that inserts a given score into the HighScore.txt file
	 * @param len
	 * @param time
	 */
	public static void InsertScore(int len, long time){
		
		int index = 0;
		//for loop to find a point of insertion of the new data.
		for(int i = 0; i < size; i++){
			if(HighSize[i] > len)
				{
				index = i;
				break;
				}
		}
		
		//Temporary Arrays
		int[] atemp = new int[size+1];
		long[] btemp = new long[size+1];
		
		//Put the new data in
		for(int i = 0, j = 0; j < size; i++,j++){
			if(i == index){
				atemp[i] = len;
				i++;
				}
			
			atemp[i] = HighSize[j];
			}
		//Put the new data in
		for(int i = 0,j=0; j < size; i++,j++){
			if(i == index){
				btemp[i] = time;
				i++;
				}
			
			btemp[i] = HighTime[j];
			}
		
		//Redeclare and Reassign
		size++;
		HighSize = new int[size];
		HighTime = new long[size];
		HighSize = atemp;
		HighTime = btemp;
		
		//Write the contents to the file
		TextIO.writeFile("HighScore.txt");
		for(int i = 0; i < size; i++){
			TextIO.putln(HighSize[i] + " " + HighTime[i]);
		}
		
	}
	
	/**
	 * A method to count the number of lines (scores) in 
	 * HighScore.txt
	 * @return
	 */
	public static int CountLines(){
		
		int counter = 0;
		TextIO.readFile("HighScore.txt");
		while(!TextIO.eof()){
			
			String newline = TextIO.getln();
			if(!newline.equals("")) counter++;
		
		}
		return counter;
	}
	
	/**
	 * A simple Zen method to display scores on the screen, from the file
	 * @return
	 */
	public static boolean DisplayScores(){
		
		Zen.resetClick();
		int GetClickX = Zen.getMouseClickX(); // Mouse Click Variable, X
		int GetClickY = Zen.getMouseClickY(); // Mouse Click Variable, Y
		int GetPosX = Zen.getMouseX(); // Mouse Movement Variable, X
		int GetPosY = Zen.getMouseY(); // Mouse Movement Variable, Y
		
		SetScoreArray();
		boolean isdone = false;
		while(Zen.isRunning() && !isdone)
		{
			Zen.flipBuffer();
			Zen.setColor(255,255,255);
			Zen.setFont("Showcard Gothic-60");
			Zen.drawText("HIGHSCORES", 270, 50);
			Zen.setFont("Lucida Sans-30");
			Zen.drawText("LENGTH", 220, 100);
			Zen.drawText("DURATION", 520, 100);
			Zen.setFont("Lucida Sans-30");
			Zen.drawText("BACK TO MENU", 350, 340);
			
			for(int i = 0; i < size; i++){
				Zen.drawText(""+HighSize[i],240,150+(30*i));
				Zen.drawText(""+HighTime[i],550,150+(30*i));
			}
			
			GetClickX = Zen.getMouseClickX();
			GetClickY = Zen.getMouseClickY();
			GetPosX = Zen.getMouseX();
			GetPosY = Zen.getMouseY();
			
			if((GetPosX >= 350 && GetPosX <= 900) && (GetPosY >= 300 && GetPosY <= 340))
			{
				Zen.setColor(0,255,155);
				Zen.fillRect(0, 300, Zen.getZenWidth(), 40);
				Zen.setColor(255,0,0);
				Zen.setFont("Lucida Sans-30");
				Zen.drawText("BACK TO MENU", 350, 340);
				
			}
			
			if((GetClickX >= 350 && GetClickX <= 900) && (GetClickY >= 300 && GetClickY <= 340))
			{
				isdone = true;
			}
		}
		Zen.resetClick(); //I made that!
		return isdone;
	}
	
}
