package ch.macrozone.dev.rapingRabbits;



public abstract class Rabbit extends Animal {



	public Rabbit()
	{
		this.isDead = false;
	}

	public void eat(Grass theGrass)
	{
		if (theGrass != null)
		{
			int grassToEat = Math.min(theGrass.getGrasses(), this.hunger);
		
			//System.out.println(this+" has hunger "+this.hunger+" and eats "+grassToEat+" grasses");
			theGrass.getsEaten(grassToEat);
			this.hunger-= grassToEat;
			
		}
	}

	public void doOneTurn(GameField myField, GameArea wholeGameArea)
	{
		if (!this.turnDone)
		{
			if (!this.isDead)
			{
				if (myField.hasGrass())	this.eat(myField.getGrass());
			}

			super.doOneTurn(myField, wholeGameArea);
		}
	}
	
	protected void dies()
	{
		super.dies();
	}

}
