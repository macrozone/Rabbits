package ch.macrozone.dev.rapingRabbits;

public class GameLogic {

	private GameAreaLogic gameAreaLogic;
	private int duration;
	private GameWindow gameWindow;
	private RuntimeSettingsWindow runtimeSettingsWindow;

	
	private GameStatisticWindow gameStatisticWindow;

	
	public GameLogic(int duration)
	{
		this.duration = duration;
		
	
	}
	
	public void makeGameArea(int width, int height)
	{
		this.gameAreaLogic = new GameAreaLogic(width, height);
		
		this.gameWindow = new GameWindow();
		
		this.runtimeSettingsWindow = new RuntimeSettingsWindow();
		this.gameWindow.addGameArea(this.gameAreaLogic);

		this.gameStatisticWindow = new GameStatisticWindow();
		
	}
	
	
	public void play()
	{
		this.gameWindow.show();
		this.runtimeSettingsWindow.show();
		this.gameStatisticWindow.show();
		
		for (int i=0; i<duration;++i)
		{
			GameStatistic.turn = i;
			System.out.println("Turn "+i+" ---------------------");
			this.gameAreaLogic.initNewTurn();
			
			this.gameAreaLogic.doOneTurn();
			this.gameAreaLogic.countGrass();
			if(this.gameAreaLogic.countLivingRabbits()==0) 
				break;
			
			this.gameWindow.repaint();
			this.gameStatisticWindow.repaint();
			{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
	
	public void fillWithRandomRabbits(int number)
	{
		this.gameAreaLogic.fillWithRandomRabbits(number);
	}
	public void fillWithGrass()
	{
		this.gameAreaLogic.fillWithGrass();
	}
	
}
