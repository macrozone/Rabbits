package ch.macrozone.dev.rapingRabbits;

public class Main {

	public static void main(String[] args)
	{
		int duration = 2000;
		
	
		GameLogic theGame = new GameLogic(duration);
		theGame.makeGameArea(100, 60);
		theGame.fillWithRandomRabbits(40);
		theGame.fillWithGrass();
		theGame.play();
		
		
	}
}
