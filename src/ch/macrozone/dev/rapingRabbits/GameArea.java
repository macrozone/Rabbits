package ch.macrozone.dev.rapingRabbits;

import java.util.ArrayList;

public abstract class GameArea {

	protected int width;
	protected int height;
	
	protected ArrayList<GameFieldLogic> theField;
	

	
	public ArrayList<GameField> getFieldsFromHere(GameField myField)
	{
		ArrayList<GameField> fieldsToWalk = new ArrayList<GameField>();
		
		int x = myField.get_x();
		int y = myField.get_y();
		
		fieldsToWalk.add(myField);
		if (this.getField(x-1,y)!= null)	fieldsToWalk.add(this.getField(x-1,y));
		if (this.getField(x,y-1)!= null)	fieldsToWalk.add(this.getField(x,y-1));
		if (this.getField(x+1,y)!= null)	fieldsToWalk.add(this.getField(x+1,y));
		if (this.getField(x,y+1)!= null)	fieldsToWalk.add(this.getField(x,y+1));
		
		return fieldsToWalk;
		
	}
	
	public void moveOneEntity(GameEntity theEntity, GameField source, GameField dest)
	{
		//System.out.println(theEntity +" moves from "+source+" to "+dest);
		dest.add(theEntity);
		source.remove(theEntity);
	}
	
	
	private GameField getField(int x, int y)
	{
		for(GameField oneField:this.theField)
		{
			if (oneField.get_x() == x && oneField.get_y() == y)
			{
				return oneField;
			}
		}
		return null;
	}
	
	
}
