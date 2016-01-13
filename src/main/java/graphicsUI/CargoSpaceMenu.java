package graphicsUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objectDefinitions.CargoSpaceIndividual;

public class CargoSpaceMenu extends JPanel {
	private JTextField xInput = new JTextField();;
	private JTextField yInput = new JTextField();;
	private JTextField zInput = new JTextField();;
	private RunTimeData runtimeData;
	private JButton startButton = new JButton("Set Space");

	public CargoSpaceMenu(RunTimeData runtimeData) {
		this.runtimeData = runtimeData;

		setLayout(new GridLayout(1, 7));
		String spaces = "   ";
		add(new JLabel(spaces + "Y Space size ="));

		add(yInput);
		add(new JLabel(spaces + "X Space size ="));

		add(xInput);
		add(new JLabel(spaces + "Z Space size ="));

		add(zInput);

		startButton.addActionListener(new CargoSpaceButtonListener());
		add(startButton);
	}

	class CargoSpaceButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("coords of space were set");
			if (xInput.getText().length() > 0 && yInput.getText().length() > 0 && zInput.getText().length() > 0) {
				int y = Integer.parseInt(yInput.getText());
				int x = Integer.parseInt(xInput.getText());
				int z = Integer.parseInt(zInput.getText());

				runtimeData.setACargoSpace(new CargoSpaceIndividual(y, x, z));

			}
		}

	}
}
