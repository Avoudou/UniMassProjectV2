package graphicsUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import databases.ShapesDefault;
import databases.ShapesPentomino3D;

public class CargoSetsMenu extends JPanel {
	private RunTimeData runtimeData;

	private JButton defaultSetButton = new JButton("Default Cargo");
	private JButton pentominoSetButton = new JButton("Pentomino Cargo");
	private JButton customSetButton = new JButton("Custom Cargo");
	private UIWindow aWindow;

	public CargoSetsMenu(RunTimeData runtimeData, UIWindow aWindow) {
		this.runtimeData = runtimeData;
		this.aWindow = aWindow;
		setLayout(new GridLayout(1, 6));

		defaultSetButton.addActionListener(new DefaultCargoButtonListener());
		pentominoSetButton.addActionListener(new PentominoCargoButtonListener());
		customSetButton.addActionListener(new ChooseCustomCargoButtonListener());
		add(new JLabel(""));
		add(new JLabel("  Set Cargo Set :  "));
		add(defaultSetButton);
		add(pentominoSetButton);
		add(customSetButton);
		add(new JLabel("      "));

	}

	private class DefaultCargoButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("pressed");
			runtimeData.setDefaultCargoMenu(true);
			runtimeData.setCustomCargoMenu(false);
			runtimeData.setPentominoCargoMenu(false);
			runtimeData.setCargoSetName("Default");
			runtimeData.setCargoData(new ShapesDefault("weighted"));
			aWindow.getContentPane().repaint();
		}
	}

	private class PentominoCargoButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			runtimeData.setDefaultCargoMenu(false);
			runtimeData.setCustomCargoMenu(false);
			runtimeData.setPentominoCargoMenu(true);
			runtimeData.setCargoSetName("Pentominos");
			runtimeData.setCargoData(new ShapesPentomino3D());
			aWindow.getContentPane().repaint();

		}
	}

	private class ChooseCustomCargoButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("pressed");
			runtimeData.setDefaultCargoMenu(false);
			runtimeData.setCustomCargoMenu(true);
			runtimeData.setPentominoCargoMenu(false);
			runtimeData.setCargoSetName("Custom");
			aWindow.getContentPane().repaint();

		}
	}

}
