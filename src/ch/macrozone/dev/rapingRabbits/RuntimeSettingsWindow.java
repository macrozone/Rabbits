package ch.macrozone.dev.rapingRabbits;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

public class RuntimeSettingsWindow extends JFrame
{
	private static final long serialVersionUID = 1L;
	

	

	public RuntimeSettingsWindow()
	{
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("Runtime Settings");
		this.setSize(new Dimension(150, 150));
		JToggleButton btnShowRabbits = new JToggleButton("Show Rabbits");
		JToggleButton btnShowGrid = new JToggleButton("Show Grid");
		JToggleButton btnShowGrasses = new JToggleButton("Show Grass");
	
		btnShowRabbits.addActionListener(alShowRabbits);
		btnShowGrid.addActionListener(alShowGrid);
		btnShowGrasses.addActionListener(alShowGrasses);
		
		setLayout (new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.add(btnShowRabbits);
		this.add(btnShowGrid);
		this.add(btnShowGrasses);

	}
	
	ActionListener alShowRabbits = new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			if (((JToggleButton) ae.getSource()).isSelected())
			{
				RuntimeSettings.showRabbits = false;
			} else
			{
				RuntimeSettings.showRabbits = true;
			}

		}
	};
	
	ActionListener alShowGrid = new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			if (((JToggleButton) ae.getSource()).isSelected())
			{
				RuntimeSettings.showGrid = false;
			} else
			{
				RuntimeSettings.showGrid = true;
			}

		}
	};
	ActionListener alShowGrasses = new ActionListener()
	{
		public void actionPerformed(ActionEvent ae)
		{
			if (((JToggleButton) ae.getSource()).isSelected())
			{
				RuntimeSettings.showGrasses = false;
			} else
			{
				RuntimeSettings.showGrasses = true;
			}

		}
	};

}
