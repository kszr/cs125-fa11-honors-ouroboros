
public class TheMenu {
	
	//A function to print the Title of the Menu letter by letter.
	public static void Title(int x, int y){
		
		String Title = "O U R O B O R O S";
		int TitleLen = Title.length();
		String TitleDelay = "";
		for(int i = 0; i < TitleLen; i++)
		{
			TitleDelay = TitleDelay + Title.charAt(i);
			Zen.drawText(TitleDelay, x, y);
			Zen.sleep(10);
		}
	}
	
	//A function to implement Menu Options through the use of the mouse.
	public static void MenuOptions(){
		
		String Option1 = "PLAY GAME";
		String Option2 = "HIGH SCORES";
		String Option3 = "HOW-TO-PLAY";
		String Option4 = "EXIT";
		
		
	}

}
