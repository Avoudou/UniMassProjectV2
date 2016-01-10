package graphicsUI;



import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objectDefinitions.CargoSpaceIndividual;

public class CargoSetsMenu  extends JPanel{
	private RunTimeData runtimeData;
	ImageIcon cargoA= new ImageIcon("Textures/ShapeSample.jpg");
	ImageIcon cargoB =new ImageIcon("Textures/ShapeSample.jpg");
	ImageIcon cargoC=new ImageIcon("Textures/ShapeSample.jpg");
	

	public CargoSetsMenu(RunTimeData runtimeData) {
		 this.runtimeData=runtimeData;
		
		 	setLayout(new GridLayout(1, 6));
			
			JButton defaultSetButton = new JButton("Default Cargo");
			JButton pentominoSetButton = new JButton("Pentomino Cargo");
			defaultSetButton.addActionListener(new DefaultCargoButtonListener());
			defaultSetButton.addActionListener(new PentominoCargoButtonListener());
			add(  new JLabel("        "));
			add( new JLabel("  Set Cargo Set :  "));
			add(defaultSetButton);
			add(pentominoSetButton);
			add( new JLabel("         "));
			add( new JLabel("        "));
		
			
		}
		class DefaultCargoButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					
				}
			}
		class PentominoCargoButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					
				}
			}


}
