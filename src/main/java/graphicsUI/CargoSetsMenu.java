package graphicsUI;

import graphicsUI.CargoSpaceMenu.StartButtonListener;

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
	ImageIcon cargoBnew =new ImageIcon("Textures/ShapeSample.jpg");
	ImageIcon cargoC=new ImageIcon("Textures/ShapeSample.jpg");
	

	public CargoSetsMenu(RunTimeData runtimeData) {
		 this.runtimeData=runtimeData;
		
		 	setLayout(new GridLayout(1, 6));
			
			JButton defaultSetButton = new JButton("Set Default Cargo");
			JButton pentominoSetButton = new JButton("Set Pentomino Cargo");
			defaultSetButton.addActionListener(new DefaultButtonListener());
			defaultSetButton.addActionListener(new PentominosButtonListener());
			add(defaultSetButton);
			add(pentominoSetButton);
			//add( cargoA);
			
		}
		class DefaultButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					
				}
			}
		class PentominosButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					
				}
			}


}
