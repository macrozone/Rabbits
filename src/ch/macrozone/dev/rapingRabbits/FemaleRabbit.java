package ch.macrozone.dev.rapingRabbits;

import java.util.ArrayList;

public class FemaleRabbit extends Rabbit{

	public static final int MIN_SIBLINGS = 1;
	public static final int MAX_SIBLINGS = 10;
	public static final double COPULATION_CHANCE = 1;

	public static final int MATURITY = 5;
	public static final int MAX_AGE = 200;
	public static final int MAX_GESTATION_TIME = 10;
	private int gestationTime = 0;
	ArrayList<Rabbit> siblings;

	public FemaleRabbit()
	{
		this.maxAge = MAX_AGE;
		this.siblings = new ArrayList<Rabbit>();
		this.maturity = MATURITY;
	}

	public void doOneTurn(GameField myField, GameArea wholeGameArea)
	{
		if (!this.turnDone)
		{
			if(!this.isDead)
			{
				
				if (!this.siblings.isEmpty())
				{
					this.gestationTime++;
					if (this.gestationTime==MAX_GESTATION_TIME)
						this.giveBirthOnField(myField);
				}
				
			}
			super.doOneTurn(myField, wholeGameArea);
		}
	}

	public void giveBirthOnField(GameField myField)
	{
		if (!this.siblings.isEmpty())
		{
			System.out.println(this + " has given Birth to "+this.siblings.size()+ " new rabbits!");
			for(Rabbit oneSibling:this.siblings)
			{
				myField.add(oneSibling);
			}
		}
		this.siblings.clear();
	}

	public void getsCopulated(MaleRabbit partner)
	{
		//System.out.println(this+" gets copulated by "+partner);
		if (this.siblings.isEmpty())
		{
			if (this.isAdult() && partner.isAdult())
			{
				
				if (Randomizer.success(COPULATION_CHANCE))
				{
					this.getsPregnant();
					
				}	
			}
		}

	}
	private void getsPregnant()
	{
		//System.out.println(this+" has got pregnant. Congratulations!");
		this.gestationTime=0;
		for (int i=0;i<Randomizer.getIntBetween(MIN_SIBLINGS, MAX_SIBLINGS);++i)
		{
			if (Randomizer.getIntBetween(0, 1)==0)
				this.siblings.add(new MaleRabbit());
			else
				this.siblings.add(new FemaleRabbit());
		}
	}
	
	protected void dies()
	{
		GameStatistic.deadFemaleRabbits++;
		super.dies();
	}
}
