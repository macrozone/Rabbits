package ch.macrozone.dev.rapingRabbits;

public class GameStatistic
{
	public static int turn = 0;
	public static int livingMaleRabbits= 0;
	public static int livingFemaleRabbits= 0;
	public static int availableGrasses= 0;
	
	public static int deadMaleRabbits= 0;
	public static int deadFemaleRabbits= 0;
	
	public GameStatistic()
	{
		
	}
	
	public static int getLivingRabbits()
	{
		return livingFemaleRabbits + livingMaleRabbits;
	}
	
	public static int getDeadRabbits()
	{
		return deadMaleRabbits+ deadFemaleRabbits;
	}
}
