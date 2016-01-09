package graphicsUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objectDefinitions.CargoSpaceIndividual;

public class CargoSpaceMenu extends JPanel{
	private JTextField xInput;
	private JTextField yInput;
	private JTextField zInput;
	private RunTimeData runtimeData;

 public CargoSpaceMenu(RunTimeData runtimeData) {
	 this.runtimeData=runtimeData;
	
		setLayout(new GridLayout(1, 7));
		String spaces = "   ";
		add(new JLabel(spaces + "Y Space size ="));
		yInput = new JTextField();
		add(yInput);
		add(new JLabel(spaces + "X Space size ="));
		xInput = new JTextField();
		add(xInput);
		add(new JLabel(spaces + "Z Space size ="));
		zInput = new JTextField();
		add(zInput);
		JButton startButton = new JButton("Set Space");
		startButton.addActionListener(new StartButtonListener());
		add(startButton);
	}
	class StartButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("coords of space were set");
			if (xInput.getText().length() > 0 && yInput.getText().length() > 0 && zInput.getText().length() > 0) {
			int 	y = Integer.parseInt(yInput.getText());
			int 	x = Integer.parseInt(xInput.getText());
			int 	z = Integer.parseInt(zInput.getText());
			
			runtimeData.setACargoSpace(new  CargoSpaceIndividual(y, x, z));
				
			}
		}

	}
}


