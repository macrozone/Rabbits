/**
 * 
 */
package ch.macrozone.dev.rapingRabbits;

/**
 * @author macrozone
 *
 */
public abstract class GameEntity {

	//protected int _x;
	//protected int _y;
	protected boolean isDead;
	public boolean turnDone = false;
	
	public void initNewTurn()
	{
		//System.out.println(this +"starts a new turn");
		this.turnDone = false;
	}
	public void doOneTurn(GameField myField, GameArea wholeGameArea)
	{
		//System.out.println(this +"has done its turn");
		this.turnDone = true;
	}
	
	public boolean isDead()
	{
		return this.isDead;
	}


}
