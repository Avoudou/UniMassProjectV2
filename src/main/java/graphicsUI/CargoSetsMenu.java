package graphicsUI;



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CargoSetsMenu  extends JPanel{
	private RunTimeData runtimeData;
	
	private JButton defaultSetButton = new JButton("Default Cargo");
	private JButton pentominoSetButton = new JButton("Pentomino Cargo");
	private JButton customSetButton = new JButton("Custom Cargo");
	private CargoSetWeightsPanel mainPanel;

	public CargoSetsMenu(RunTimeData runtimeData, CargoSetWeightsPanel mainPanel) {
		 this.runtimeData=runtimeData;
		this.mainPanel = mainPanel;
		 	setLayout(new GridLayout(1, 6));
			

			defaultSetButton.addActionListener(new DefaultCargoButtonListener());
			defaultSetButton.addActionListener(new PentominoCargoButtonListener());
		add(new JLabel(""));
			add( new JLabel("  Set Cargo Set :  "));
			add(defaultSetButton);
			add(pentominoSetButton);
		add(customSetButton);
		add(new JLabel("      "));
		
			
		}
		class DefaultCargoButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
			runtimeData.setDefaultCargoMenu(true);
			runtimeData.setCustomCargoMenu(false);
			runtimeData.setPentominoCargoMenu(false);
			mainPanel.repaint();
					
				}
			}
		class PentominoCargoButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
			runtimeData.setDefaultCargoMenu(false);
			runtimeData.setCustomCargoMenu(false);
			runtimeData.setPentominoCargoMenu(true);
			mainPanel.repaint();
				
					
				}
			}

	class chooseCustomCargoButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			runtimeData.setDefaultCargoMenu(false);
			runtimeData.setCustomCargoMenu(true);
			runtimeData.setPentominoCargoMenu(false);
			// mainPanel.closeCustomCargoMenu();
			mainPanel.repaint();

		}
	}


}
