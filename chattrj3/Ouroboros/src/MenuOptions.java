
public class MenuOptions {

	public static long startTime;

	public static boolean Menu() 
	{

		String Title = "OUROBOROS";
		String CatchFlow  = "";
		int GetClickX = Zen.getMouseClickX(); // Define Mouse Interface.
		int GetClickY = Zen.getMouseClickY();
		int GetPosX = Zen.getMouseX();
		int GetPosY = Zen.getMouseY();
		int i = 0;
		boolean done = false;
		boolean nowdone = false;

		while (Zen.isRunning() && !nowdone) 
		{

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

			Zen.setColor(255-(10*i), 255, 255+(10*i));
			Zen.setFont("Showcard Gothic-60");
			Zen.drawText(Title, 260, 50);
			Zen.setFont("Lucida Sans-50");
			Zen.setColor(255,255,255);
			Zen.drawText("PLAY GAME", 180+110, 200);
			Zen.drawText("HELP",260+110,270);
			Zen.drawText("HIGHSCORES", 170+110, 340);
			Zen.drawText("EXIT" , 265+110, 400);



			GetPosX = Zen.getMouseX();
			GetPosY = Zen.getMouseY();
			GetClickY = Zen.getMouseClickY();
			GetClickX = Zen.getMouseClickX();

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

			if((GetClickX >= 0 && GetClickX <= Zen.getZenWidth()) && (GetClickY >= 150 && GetClickY <= 200))
			{
				nowdone = true;
			}

			if((GetClickX >= 0 && GetClickX <= Zen.getZenWidth()) && (GetClickY >= 220 && GetClickY <= 270)) 
			{
				while(!Help());
			}


			if((GetClickX >= 0 && GetClickX <= Zen.getZenWidth()) && (GetClickY >= 350 && GetClickY <= 400))
			{
				//String a = "1";
				//int b = a.charAt(1); // Throw an exception when this is called.
				Zen.closeWindow();
				break;
			}

			Zen.flipBuffer();

		}
		startTime=System.currentTimeMillis();
		return nowdone;
	}

	public static boolean Help(){

		boolean rdone = false;
		String HelpText = "HELP";
		String HelpText1 = "++ Use the arrow keys to move the snake towards food.";
		String HelpText2 = "++ The Snake grows depending on the type of food he eats.";
		String HelpText3 = "++ The Game is over when the Snake hit's itself. Survive as long as possible!";

		int GetClickX = Zen.getMouseClickX(); // Define Mouse Interface.
		int GetClickY = Zen.getMouseClickY();

		Zen.setColor(0,0,0);
		Zen.fillRect(0,0,Zen.getZenWidth(), Zen.getZenHeight());

		while(Zen.isRunning() && !rdone){

			Zen.setColor(255,255,255);
			Zen.setFont("Showcard Gothic-60");
			Zen.drawText(HelpText, 200, 50);
			Zen.setColor(255,255,255);
			Zen.setFont("Lucida Sans-20");
			Zen.drawText(HelpText1, 10, 100);
			Zen.drawText(HelpText2, 10,150);
			Zen.drawText(HelpText3, 10, 200);
			Zen.drawText("BACK TO MENU", 700, 340);
			GetClickX = Zen.getMouseClickX();
			GetClickY = Zen.getMouseClickY();
			if((GetClickX >= 700 && GetClickX <= 900) && (GetClickY >= 300 && GetClickY <= 340))
			{
				rdone = true;
			}
			Zen.flipBuffer();

		}


		return rdone;

	}

	public static void ScoreBoard(int length, long TIME){


		Zen.setColor(255,255,255);
		Zen.setFont("Lucida Sans-30");
		Zen.drawText("SCORE", 720, 50);
		Zen.setFont("Lucida Sans-20");
		Zen.drawText(""+length, 660, 100);
		Zen.drawText(DrawTime(TIME/1000), 660, 130);

	}

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

	public static int SnakeChoice(){


		int isDone = -1;




		while(Zen.isRunning() && isDone == -1)
		{
			int GetPosX = Zen.getMouseX();
			int GetPosY = Zen.getMouseY();
			int GetClickX=Zen.getMouseClickX();
			int GetClickY=Zen.getMouseClickY();

			Zen.drawText("CHOOSE AN AVATAR", 300, 40);
			Zen.drawImage("SNAKE_GREEN.png", 150,60);
			Zen.drawImage("SNAKE_BLUE.png", 150, 240);


			if((GetPosX >= 150 && GetPosX <= 750) && (GetPosY >= 60  && GetPosY <= 210))
			{
				Zen.drawImage("SNAKE_GREEN_SEL.png", 150, 60);
			}

			if((GetPosX >= 150 && GetPosX <= 750) && (GetPosY >= 240 && GetPosY <= 380))
			{
				Zen.drawImage("SNAKE_BLUE_SEL.png", 150, 240);
			}
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

			//GetClickX = Zen.getMouseClickX();
			//GetClickY = Zen.getMouseClickY();

			Zen.flipBuffer();

		}
		return isDone;

	}
	
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
	

}
