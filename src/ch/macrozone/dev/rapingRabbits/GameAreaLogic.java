package ch.macrozone.dev.rapingRabbits;

import java.util.ArrayList;

public class GameAreaLogic extends GameArea{


	public GameAreaLogic(int width, int height)
	{
	
		this.width = width;
		this.height = height;
		
		this.theField = new ArrayList<GameFieldLogic>();
		
		for (int x=0;x<this.width; ++x)
		{
			for (int y=0;y<this.height;++y)
			{
				this.theField.add(new GameFieldLogic(x, y));
			}
		}
	}
	public void initNewTurn()
	{
		doStatistic();
		for (GameFieldLogic oneField:this.theField)
		{
			oneField.initNewTurn();
		}
		
	}
	
	public void doStatistic()
	{
		GameStatistic.livingMaleRabbits = this.countLivingMaleRabbits();
		GameStatistic.livingFemaleRabbits = this.countLivingFemaleRabbits();
		GameStatistic.availableGrasses = this.countGrass();
	}
	public void doOneTurn()
	{
		for (GameFieldLogic oneField:this.theField)
			oneField.doOneTurn((GameArea)this);
		
	}
	
	public void fillWithRandomRabbits(int number)
	{
		int fieldNr;
		for (int i= 0; i<number;++i)
		{
			fieldNr = Randomizer.getIntBetween(0, this.theField.size()-1);
			
			if (Randomizer.getIntBetween(0, 1)== 0)
				this.theField.get(fieldNr).add(new MaleRabbit());
			else
				this.theField.get(fieldNr).add(new FemaleRabbit());
			
		}
	}
	public void fillWithGrass()
	{
		for(GameField oneField:this.theField)
			oneField.add(new Grass());

		
	}
	
	public int countLivingRabbits()
	{
		int rabbitCounter = 0;
		
		for (GameFieldLogic oneField:this.theField)
		{
			rabbitCounter += oneField.countLivingRabbits();
		}
	
		return rabbitCounter;
	}
	public int countLivingFemaleRabbits()
	{
		int rabbitCounter = 0;
		
		for (GameFieldLogic oneField:this.theField)
		{
			rabbitCounter += oneField.countLivingFemaleRabbits();
		}
	
		return rabbitCounter;
	}
	public int countLivingMaleRabbits()
	{
		int rabbitCounter = 0;
		
		for (GameFieldLogic oneField:this.theField)
		{
			rabbitCounter += oneField.countLivingMaleRabbits();
		}
	
		return rabbitCounter;
	}
	public int countGrass()
	{
		
		int grassCounter = 0; 
		for (GameFieldLogic oneField:this.theField)
		{
			grassCounter += oneField.countGrasses();
			
		}
		
		return grassCounter;
	
	}
}
