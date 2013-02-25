package ch.macrozone.dev.rapingRabbits;

public class Grass extends GameEntity{

	private final static int MIN_GRASSES = 100;
	public final static int MAX_GRASSES = 100;
	private final static int MIN_GROW_SPEED = 1;
	private final static int MAX_GROW_SPEED = 1;


	private int growSpeed;
	private int grasses;


	public Grass()
	{
		this.grasses = Randomizer.getIntBetween(MIN_GRASSES,MAX_GRASSES);
		this.growSpeed = Randomizer.getIntBetween(MIN_GROW_SPEED,MAX_GROW_SPEED);
	}

	public void doOneTurn(GameField myField, GameArea wholeGameArea)
	{
		if (!this.turnDone)
		{
			if (this.grasses + this.growSpeed <=MAX_GRASSES)
				this.grasses += this.growSpeed;

			super.doOneTurn(myField, wholeGameArea);
		}
		//System.out.println(this +" has grown: "+(this.grasses-this.growSpeed)+" to "+ this.grasses);
	}

	public int getGrasses()
	{
		return this.grasses;
	}


	public void getsEaten(int bite)
	{
		//System.out.println(this +" gets eaten: "+bite);
		if (bite <= this.grasses)
			this.grasses -= bite;
		//System.out.println(this+"has been eaten, size now: "+this.grasses);
	}

}
