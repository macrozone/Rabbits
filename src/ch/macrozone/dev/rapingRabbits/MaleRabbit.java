package ch.macrozone.dev.rapingRabbits;

import java.util.ArrayList;

public class MaleRabbit extends Rabbit{

	public static final int MATURITY = 3;
	public static final int MAX_AGE= 100;

	public MaleRabbit()
	{

		this.maxAge = MAX_AGE;
		this.maturity = MATURITY;
	}

	public void doOneTurn(GameField myField, GameArea wholeGameArea)
	{
		if (!this.turnDone)
		{
			if(!this.isDead)
			{
				this.beHorny(myField);
				
			}
			super.doOneTurn(myField, wholeGameArea);
		}
	}
	private void beHorny(GameField myField)
	{
		if (this.isAdult())
		{
			// check for Female Rabbits
			ArrayList<FemaleRabbit> femaleRabbits = myField.getFemaleRabbits();
			if (!femaleRabbits.isEmpty())
			{
				for(FemaleRabbit oneFemaleRabbit:femaleRabbits)
				{
					
					oneFemaleRabbit.getsCopulated(this);
					
				}
			}
		}
	
	}
	
	protected void dies()
	{
		GameStatistic.deadFemaleRabbits++;
		super.dies();
	}

}
