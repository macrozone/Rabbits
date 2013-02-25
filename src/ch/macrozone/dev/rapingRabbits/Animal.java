package ch.macrozone.dev.rapingRabbits;

import java.util.ArrayList;





public abstract class Animal extends GameEntity {

	private static final int MAX_HUNGER = 20;
	protected int age = 0;
	protected int maxAge;
	protected int id;
	protected int strength = 1;
	protected int maturity;
	protected int daysWithoutFood = 0;
	
	protected int hunger;
	protected int hungerFactor = 1;
	
	
	
	public void doOneTurn(GameField myField, GameArea wholeGameArea)
	{
		if (!this.turnDone)
		{
			if (!this.isDead)
			{
				this.grow();
				
				this.move(myField, wholeGameArea);
				this.checkForDead();
			
			}
			super.doOneTurn(myField, wholeGameArea);
		}
	}
	
	public void move(GameField myField, GameArea wholeGameArea)
	{
		ArrayList<GameField> fieldsToGo= wholeGameArea.getFieldsFromHere(myField);
		GameField destField = fieldsToGo.get(Randomizer.getIntBetween(0,fieldsToGo.size()-1));
		//System.out.println(this +" has moved to field from "+myField.get_x()+ " "+myField.get_y()+" to " +destField.get_x()+ " "+destField.get_y());
		wholeGameArea.moveOneEntity(this, myField, destField);
		
	}
	
	private void grow()
	{
		this.age++;
		this.strength++;
		this.hunger+=8;
		//System.out.println("this has grown: age now: "+this.age+", strength now: "+this.strength+", hunger now: "+this.hunger);
	}
	
	public int getMaxHunger()
	{
		int maxHunger = MAX_HUNGER;
		return maxHunger;
	}
	
	public void checkForDead()
	{
		if (this.age>maxAge)
		{
			System.out.println(this+" has died of Age!  "+ "(age was: "+ this.age);
			this.dies();
		}
		if (this.hunger >this.getMaxHunger())
		{
			System.out.println(this+" has died of Hunger! "+ "(hunger was: "+ this.hunger);
			this.dies();
		}
	}
	
	protected void dies()
	{
		this.isDead = true;
	}
	
	public boolean isAdult()
	{
		if (this.age>=this.maturity)
			return true;
		else 
			return false;
	}	

	
	
	
}
