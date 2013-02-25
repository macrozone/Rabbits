package ch.macrozone.dev.rapingRabbits;

import java.util.ArrayList;

public abstract class GameField {

	private int _x;
	private int _y;
	protected ArrayList<GameEntity> entities;

	protected GameField(int _x, int _y)
	{
		this.entities = new ArrayList<GameEntity>();
		this._x = _x;
		this._y = _y;
	}
	public int get_x()
	{
		return this._x;
	}
	public int get_y()
	{
		return this._y;
	}
	
	public boolean hasGrass()
	{
		boolean retVal = false;
		for (GameEntity oneEntity:this.entities)
		{
			if (oneEntity.getClass() == Grass.class)
			{
				retVal = true;
				break;
			}
		}
		return retVal;
	}
	
	public Grass getGrass()
	{
		Grass theGrass = null;
		for (GameEntity oneEntity:this.entities)
		{
			if (oneEntity.getClass() == Grass.class)
			{
				theGrass = (Grass) oneEntity;
				break;
			}
		}
		return theGrass;
	
	}
	

	
	public ArrayList<MaleRabbit> getMaleRabbits()
	{
		ArrayList<MaleRabbit> rabbits = new ArrayList<MaleRabbit>();
		
		for (GameEntity oneEntity:this.entities)
		{
			if (oneEntity.getClass() == MaleRabbit.class)
			{
				rabbits.add((MaleRabbit) oneEntity);
			}
		}
		return rabbits;
	
	}
	
	public ArrayList<FemaleRabbit> getFemaleRabbits()
	{
		ArrayList<FemaleRabbit> rabbits = new ArrayList<FemaleRabbit>();
		
		for (GameEntity oneEntity:this.entities)
		{
			if (oneEntity.getClass() == FemaleRabbit.class)
			{
				rabbits.add((FemaleRabbit) oneEntity);
			}
		}
		return rabbits;
	
	}
	
	public void add(GameEntity theEntity)
	{
		//System.out.println(theEntity+" has been added to "+ this);
		this.entities.add(theEntity);
	}
	
	public void remove(GameEntity theEntity)
	{
		//System.out.println(theEntity+" has been removed from "+ this);
		//this.entities.set(this.entities.indexOf(theEntity), new Shadow());
		this.entities.remove(theEntity);

	}
	
}
