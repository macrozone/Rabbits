package ch.macrozone.dev.rapingRabbits;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameWindow extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public GameWindow()
	{
		this.setTitle("Raping Rabbits 1.0");
		this.setSize(new Dimension(1660,900));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		
	}
	
	public void addGameArea(GameAreaLogic theGameArea)
	{
		
		this.add(new DrawArea(theGameArea));
		
	}
	
}
