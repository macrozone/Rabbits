package ch.macrozone.dev.rapingRabbits;

import java.awt.Graphics;

import javax.swing.JComponent;

public class DrawArea extends JComponent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameAreaLogic theGameArea;
	public DrawArea(GameAreaLogic theGameArea)
	{
		this.theGameArea = theGameArea;
	}
	
	public void paint(Graphics g)
	{
		for(GameFieldLogic oneField:this.theGameArea.theField)
		{
			oneField.paint(g);
		}
		
	}
}
