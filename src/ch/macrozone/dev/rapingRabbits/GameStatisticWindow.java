package ch.macrozone.dev.rapingRabbits;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class GameStatisticWindow extends JFrame
{
	private JLabel txtTurns;
	private JLabel txtGrasses;
	private JLabel txtRabbits;
	private JLabel txtDeadRabbits;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GameStatisticWindow()
	{
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.txtTurns = new JLabel("Turns");
		this.txtGrasses = new JLabel("Grasses");
		this.txtRabbits = new JLabel("Rabbits");
		this.txtDeadRabbits = new JLabel("DeadRabbits");
		
		
		this.setTitle("Statistics");
		this.setSize(new Dimension(200,200));
		setLayout (new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.add(this.txtTurns);
		this.add(this.txtGrasses);
		this.add(this.txtRabbits);
		this.add(this.txtDeadRabbits);
	}
	
	public void repaint()
	{
		txtTurns.setText("Turn "+GameStatistic.turn);
		txtGrasses.setText(GameStatistic.availableGrasses +" Grasses are aviable");
		txtRabbits.setText(GameStatistic.getLivingRabbits() +" Rabbits are aviable");
		txtDeadRabbits.setText(GameStatistic.getDeadRabbits() +" Rabbits have already died");
	}
	
}
