/**
 * A Class defines all GUI of the game, it contains:-
 * --Menu Screen
 * --Help Screen
 * --High Score Screen
 * --Choose your avatar Screen
 * --Scoreboard, Time Print
 * @author chattrj3, nayudu2, sgupta40
 *
 */
public class MenuOptions {

	public static long startTime; //The time at which the game begins, the snake begins to move.
	
	/**
	 * This method defines the starting screen, i.e The Menu Screen.
	 * @return
	 */
	public static boolean Menu(/*int[] ScoreArray, long[] TimeArray*/) 
	{

		String Title = "OUROBOROS";
		String CatchFlow  = "";
		int GetClickX = Zen.getMouseClickX(); // Mouse Click Variable, X
		int GetClickY = Zen.getMouseClickY(); // Mouse Click Variable, Y
		int GetPosX = Zen.getMouseX(); // Mouse Movement Variable, X
		int GetPosY = Zen.getMouseY(); // Mouse Movement Variable, Y
		int i = 0; // A counter variable. declared here to avoid scope problems.
		
		boolean done = false; // A boolean variable to stop the title from continuously flashing.
		
		boolean nowdone = false; // One way flag, stops the title and starts the option selected.

		while (Zen.isRunning() && !nowdone) 
		{
			/**
			 * A while loop to make the Title Flash.
			 */
			while(!done)
			{
				CatchFlow = "";
				Zen.setColor(0,0,0);
				Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());


				for(i = 0; i < Title.length(); i++)
				{
					Zen.setColor(255 - (10*i),255,10*i);
					Zen.setFont("Showcard Gothic-60");
					char c = Title.charAt(i);
					CatchFlow = CatchFlow + c;
					Zen.drawText(CatchFlow,260,50);
					Zen.sleep(30);
				}
				done = true;
			}

			/*
			 * Draw the Menu Screen, with options.
			 */
			Zen.setColor(255-(10*i), 255, 255+(10*i));
			Zen.setFont("Showcard Gothic-60");
			Zen.drawText(Title, 260, 50);
			Zen.setFont("Lucida Sans-50");
			Zen.setColor(255,255,255);
			Zen.drawText("PLAY GAME", 180+110, 200);
			Zen.drawText("HELP",260+110,270);
			Zen.drawText("HIGHSCORES", 170+110, 340);
			Zen.drawText("EXIT" , 265+110, 400);


			/**
			 * Refresh mouse positions.
			 */
			GetPosX = Zen.getMouseX();
			GetPosY = Zen.getMouseY();
			GetClickY = Zen.getMouseClickY();
			GetClickX = Zen.getMouseClickX();

			/*
			 * Highlight the text as the mouse hovers over the area.
			 */
			if((GetPosX >= 0 && GetPosX <= Zen.getZenWidth()) && (GetPosY >= 150 && GetPosY <= 200)) 
			{
				Zen.setColor(0,250,154);
				Zen.fillRect(0, 150, Zen.getZenWidth(), 50);
				Zen.setColor(255,0,0);
				Zen.drawText("PLAY GAME", 180+110, 200);
			}

			if((GetPosX >= 0 && GetPosX <= Zen.getZenWidth()) && (GetPosY >= 220 && GetPosY <= 270)) 
			{
				Zen.setColor(0,250,154);
				Zen.fillRect(0, 220, Zen.getZenWidth(), 50);
				Zen.setColor(255,0,0);
				Zen.drawText("HELP" , 260+110, 270);

			}
			if((GetPosX >= 0 && GetPosX <= Zen.getZenWidth()) && (GetPosY >= 290 && GetPosY <= 340)) 
			{
				Zen.setColor(0,250,154);
				Zen.fillRect(0, 290, Zen.getZenWidth(), 50);
				Zen.setColor(255,0,0);
				Zen.drawText("HIGHSCORES", 170+110, 340);
			}
			if((GetPosX >= 0 && GetPosX <= Zen.getZenWidth()) && (GetPosY >= 350 && GetPosY <= 400)) 
			{
				Zen.setColor(0,250,154);
				Zen.fillRect(0, 350, Zen.getZenWidth(), 50);
				Zen.setColor(255,0,0);
				Zen.drawText("EXIT" , 265+110, 400);

			}

			/*
			 * Define actions as the user clicks on the desired options.
			 * Each if block corresponds to a particular button on the menu.
			 */
			if((GetClickX >= 0 && GetClickX <= Zen.getZenWidth()) && (GetClickY >= 150 && GetClickY <= 200))
			{
				nowdone = true;
			}

			if((GetClickX >= 0 && GetClickX <= Zen.getZenWidth()) && (GetClickY >= 220 && GetClickY <= 270)) 
			{
				while(!Help());
			}

			if((GetClickX >= 0 && GetClickX <= Zen.getZenWidth()) && (GetClickY >= 290 && GetClickY <= 340)) 
			{
				while(!HighScore.DisplayScores());
			}
			
			if((GetClickX >= 0 && GetClickX <= Zen.getZenWidth()) && (GetClickY >= 350 && GetClickY <= 400))
			{
				Zen.closeWindow();
				break;
			}

			Zen.flipBuffer();

		}
		
		startTime = System.currentTimeMillis();
		return nowdone; //Return the Flag every time we run through this block.
	}

	/**
	 * This Method block defines the help screen. The help screen provides
	 * information regarding the game, how to play and what each block means.
	 * @return
	 */
	public static boolean Help(){

		Zen.resetClick();
		boolean rdone = false; //One way flag.
		
		String HelpText1 = "++ Use the arrow keys to move the snake towards food.";
		String HelpText2 = "++ The Snake grows depending on the type of food he eats.";
		String HelpText3 = "++ The Game is over when the Snake hit's itself. Survive as long as possible!";

		int GetClickX = Zen.getMouseClickX(); // Mouse Click Variable, X
		int GetClickY = Zen.getMouseClickY(); // Mouse Click Variable, Y
		int GetPosX = Zen.getMouseX(); // Mouse Movement Variable, X
		int GetPosY = Zen.getMouseY(); // Mouse Movement Variable, Y

		Zen.setColor(0,0,0);
		Zen.fillRect(0,0,Zen.getZenWidth(), Zen.getZenHeight());

		while(Zen.isRunning() && !rdone){
			
			GetPosX = Zen.getMouseX();
			GetPosY = Zen.getMouseY();

			Zen.setColor(255,255,255);
			Zen.setFont("Showcard Gothic-60");
			Zen.drawText("HELP", 370, 50);
			Zen.setColor(255,255,255);
			Zen.setFont("Lucida Sans-20");
			Zen.drawText(HelpText1, 10, 100);
			Zen.drawText(HelpText2, 10,150);
			Zen.drawText(HelpText3, 10, 200);
			Zen.setFont("Lucida Sans-30");
			Zen.drawText("BACK TO MENU", 350, 340);
			GetClickX = Zen.getMouseClickX();
			GetClickY = Zen.getMouseClickY();
			
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
				rdone = true;
			}
			Zen.flipBuffer();

		}

		Zen.resetClick();
		return rdone;

	}
	
	/**
	 * This method block draws the score as the game progresses.
	 * @param length
	 * @param TIME
	 */
	public static void ScoreBoard(int length, long TIME){


		Zen.setColor(255,255,255);
		Zen.setFont("Lucida Sans-30");
		Zen.drawText("SCORE", 720, 50);
		Zen.setFont("Lucida Sans-20");
		Zen.drawText(""+length, 660, 100);
		Zen.drawText(DrawTime(TIME/1000), 660, 130);

	}

	/**
	 * This method block draws the time as the game progresses.
	 * @param TIME
	 * @return
	 */
	public static String DrawTime(long TIME){

		int seconds = (int)TIME%60;
		int min = (int)TIME/60;

		if(seconds < 10 && min < 10)
			return "0"+min+":0"+seconds;
		else if(min < 10)
			return "0"+min+":"+seconds;
		else if(seconds < 10)
			return min+":0"+seconds;
		else return min+":"+seconds;

	}

	/**
	 * Method defining the "Choose Your Avatar" screen , which occurs after the user
	 * clicks on the "Play Game" button. The method returns an int value corresponding
	 * to the snake the user clicked on.
	 * @return
	 */
	public static int SnakeChoice(){

		int isDone = -1; //One way flag.

		while(Zen.isRunning() && isDone == -1)
		{
			// Get mouse variables.
			int GetPosX = Zen.getMouseX();
			int GetPosY = Zen.getMouseY();
			int GetClickX = Zen.getMouseClickX();
			int GetClickY = Zen.getMouseClickY();

			//Draw the images on the screen.
			Zen.setColor(255,255,255);
			Zen.drawText("CHOOSE AN AVATAR", 210, 40);
			Zen.drawImage("SNAKE_GREEN.png", 150,60);
			Zen.drawImage("SNAKE_BLUE.png", 150, 240);

			//Define interaction with the user according to the position of the mouse.
			if((GetPosX >= 150 && GetPosX <= 750) && (GetPosY >= 60  && GetPosY <= 210))
			{
				Zen.drawImage("SNAKE_GREEN_SEL.png", 150, 60);
			}

			if((GetPosX >= 150 && GetPosX <= 750) && (GetPosY >= 240 && GetPosY <= 380))
			{
				Zen.drawImage("SNAKE_BLUE_SEL.png", 150, 240);
			}
			
			//Define interaction with the user as the user clicks on a snake.
			if((GetClickX >= 150 && GetClickX <= 750) && (GetClickY >= 70 && GetClickY <= 210))
			{
				isDone = 0;
				return 0;
			}
			if((GetClickX >= 150 && GetClickX <= 750) && (GetClickY >= 240 && GetClickY <= 380))
			{
				isDone = 1;
				return 1;
			}

			//Changes the screens.
			Zen.flipBuffer();

		}
		return isDone;

	}
	
	/**
	 * Useless method, was initially made so the user unknowingly
	 * reset the value of the mouse click values. The method is obsolete
	 * now as we defined a "resetClick()" method in Zen.java which resets
	 * the mouse click variables.
	 */
	public static void DrawInter(){
		
			
		while(Zen.isRunning()){
			
			Zen.flipBuffer();
			Zen.setColor(0,0,0);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
			Zen.setColor(255,255,255);
			Zen.setFont("Lucida Sans-30");
			Zen.drawText("CLICK HERE TO CONTINUE", 210, 240);
			if(Zen.getMouseClickY() > 200 && Zen.getMouseClickY() < 240)
			{
				break;
			}
		}

	}
	
	
	public static boolean HighScore(int[] sizex, long[] timex){
		
		int GetPosX = Zen.getMouseX();
		int GetPosY = Zen.getMouseY();
		int GetClickX = Zen.getMouseClickX();
		int GetClickY = Zen.getMouseClickY();
		
		boolean isDone = false;

		while(Zen.isRunning() && !isDone){
			
			GetPosX = Zen.getMouseX();
			GetPosY = Zen.getMouseY();
			GetClickY = Zen.getMouseClickY();
			GetClickX = Zen.getMouseClickX();

				Zen.flipBuffer();
				Zen.setColor(255,255,255);
				Zen.setFont("Lucida San-20");
				for(int i = 0; i < sizex.length; i++)
					Zen.drawText(i+" "+sizex[i]+"  "+timex[i], 80, 22*i);
				
				if((GetPosX >= 350 && GetPosX <= 900) && (GetPosY >= 360 && GetPosY <= 400))
				{
					Zen.setColor(0,255,155);
					Zen.fillRect(0, 300, Zen.getZenWidth(), 40);
					Zen.setColor(255,0,0);
					Zen.setFont("Lucida Sans-30");
					Zen.drawText("BACK TO MENU", 350, 400);
					
				}
				
				if((GetClickX >= 350 && GetClickX <= 900) && (GetClickY >= 360 && GetClickY <= 400))
				{
					isDone = true;
				}
		}
		return isDone;


	}
	

}
