package ch.macrozone.dev.rapingRabbits;

import java.util.ArrayList;
import java.util.Random;

public class Randomizer {

	public static int getIntBetween(int a, int b)
	{
		
		int delta = b-a+1;
		Random r = new Random();
		
		int retVal = a+r.nextInt(delta);
		
		return retVal;
	}
	
	public static boolean success(double chance)
	{
		Random r = new Random();
		if (Math.abs(r.nextDouble())<chance)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Object getRandomEntry(ArrayList<Object> theArrayList)
	{
		Object retVal = null;
		if (theArrayList.size()>0)
		{
			retVal = theArrayList.get(getIntBetween(0, theArrayList.size()-1));
			
		}
		return retVal;
	}
}
