package graphicsUI;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CargoSetWeightsPanel extends JPanel {

	private JLabel cargoALabel = new JLabel("Cargo A weight");
	private JLabel cargoBLabel = new JLabel("Cargo B weight");
	private JLabel cargoCLabel = new JLabel("Cargo C weight");
	private JButton setWeightsButton = new JButton("Set Weights");

	private JTextField weightCargoA = new JTextField();;
	private JTextField weightCargoB = new JTextField();;
	private JTextField weightCargoC = new JTextField();;

	private JTextField shapeAY = new JTextField();
	private JTextField shapeAX = new JTextField();
	private JTextField shapeAZ = new JTextField();

	private RunTimeData runtimeData;

	private WeightButtonListener weightsFIX = new WeightButtonListener();
	private int a = 0;
	private int b = 0;
	private int c = 0;

	public CargoSetWeightsPanel(RunTimeData runtimeData) {
		this.runtimeData = runtimeData;

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setWeightFields();

	}

	private void setWeightFields() {

		weightCargoA.setBounds(100, 20, 50, 20);
		cargoALabel.setBounds(100, 40, 120, 15);


		weightCargoB.setBounds(210, 20, 50, 20);
		cargoBLabel.setBounds(210, 40, 120, 15);


		weightCargoC.setBounds(320, 20, 50, 20);
		cargoCLabel.setBounds(320, 40, 120, 15);

		setWeightsButton.addActionListener(weightsFIX);
		setWeightsButton.setBounds(430, 20, 160, 30);
		add(cargoALabel);
		add(weightCargoA);
		add(weightCargoB);
		add(cargoBLabel);
		add(weightCargoC);
		add(cargoCLabel);

		add(setWeightsButton);

	}

	private class WeightButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Weights were set");

			if (weightCargoA.getText().length() > 0 && weightCargoB.getText().length() > 0
					&& weightCargoC.getText().length() > 0) {
				a = Integer.parseInt(weightCargoA.getText());
				b = Integer.parseInt(weightCargoB.getText());
				c = Integer.parseInt(weightCargoC.getText());
				System.out.println(runtimeData.getCargoData().getShapeList().get(0).getWeightTotal());
				runtimeData.getCargoData().getShapeList().get(0).setWeightTotal(a);
				runtimeData.getCargoData().getShapeList().get(1).setWeightTotal(b);
				runtimeData.getCargoData().getShapeList().get(2).setWeightTotal(c);
				runtimeData.setWeightCargoA(a);
				runtimeData.setWeightCargoA(b);
				runtimeData.setWeightCargoA(c);

			}

		}
	}

}
