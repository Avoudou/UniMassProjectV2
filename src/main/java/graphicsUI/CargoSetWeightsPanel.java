package graphicsUI;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objectDefinitions.CargoGenerator;

public class CargoSetWeightsPanel extends JPanel {
	private ImageIcon imageA = new ImageIcon("Textures/DefaultA.jpg");
	private ImageIcon imageB = new ImageIcon("Textures/DefaultB.jpg");
	private ImageIcon imageC = new ImageIcon("Textures/DefaultC.jpg");
	private JLabel cargoALabel = new  JLabel("Cargo A weight");
	private JLabel cargoBLabel = new  JLabel("Cargo B weight");
	private JLabel cargoCLabel = new  JLabel("Cargo C weight");
	private JButton setWeightsButton = new JButton("Set Weights");
	private JButton  setShapeA = new JButton("set cargo A");
	private JButton  setShapeB = new JButton("set cargo B");
	private JButton  setShapeC = new JButton("set cargo C");
	private JTextField weightCargoA = new JTextField();;
	private JTextField weightCargoB= new JTextField();;
	private JTextField weightCargoC= new JTextField();;
	private int yCargoA;
	private int xCargoA;
	private int zCargoA;
	private int yCargoB;
	private int xCargoB;
	private int zCargoB;
	private int yCargoC;
	private int xCargoC;
	private int zCargoC;
	private JTextField shapeAY = new JTextField();
	private JTextField shapeAX = new JTextField();
	private	JTextField shapeAZ = new JTextField();
	private JTextField shapeBY = new JTextField();
	private JTextField shapeBX = new JTextField();
	private	JTextField shapeBZ = new JTextField();
	private JTextField shapeCY = new JTextField();
	private JTextField shapeCX = new JTextField();
	private	JTextField shapeCZ = new JTextField();
	private JLabel shapeAYlabel= new  JLabel("Xcoord");
	private JLabel shapeAXlabel= new  JLabel("Y coord");
	private JLabel shapeAZlabel= new  JLabel("Z coord");
	private JLabel shapeBYlabel= new  JLabel("Xcoord");
	private JLabel shapeBXlabel= new  JLabel("Y coord");
	private JLabel shapeBZlabel= new  JLabel("Z coord");
	private JLabel shapeCYlabel= new  JLabel("Xcoord");
	private JLabel shapeCXlabel= new  JLabel("Y coord");
	private JLabel shapeCZlabel= new  JLabel("Z coord");

	private RunTimeData runtimeData;
	
	
	public CargoSetWeightsPanel(RunTimeData runtimeData) {
		this.runtimeData = runtimeData;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		setWeightFields();
	}
	private void setWeightFields() {
		
		weightCargoA.setBounds(40, 20, 50, 20);
		cargoALabel.setBounds(30, 40, 120, 15);
		add(cargoALabel);
		add(weightCargoA);

		
		weightCargoB.setBounds(150, 20, 50, 20);
		cargoBLabel.setBounds(150, 40, 120, 15);
		add(weightCargoB);
		add(cargoBLabel);

	
		weightCargoC.setBounds(260, 20, 50, 20);
		cargoCLabel.setBounds(260, 40, 120, 15);
		add(weightCargoC);
		add(cargoCLabel);
		
		
		setWeightsButton.addActionListener(new WeightButtonListener());
		setWeightsButton.setBounds(450, 40, 160, 30);
		add(setWeightsButton);
	}

	private void setCustomCargoA(int x, int y, JButton aButton) {

		shapeAY.setBounds(75 + x, 40 + y, 50, 20);

		shapeAYlabel.setBounds(130 + x, 40 + y, 120, 15);
		add(shapeAY);
		add(shapeAYlabel);

		shapeAX.setBounds(75 + x, 60 + y, 50, 20);

		shapeAXlabel.setBounds(130 + x, 60 + y, 120, 15);
		add(shapeAX);
		add(shapeAXlabel);

		shapeAZ.setBounds(75 + x, 80 + y, 50, 20);

		shapeAZlabel.setBounds(130 + x, 80 + y, 120, 15);
		add(shapeAZ);
		add(shapeAZlabel);

		aButton.addActionListener(new SetCargoAButton());
		aButton.setBounds(75 + x, 100 + y, 120, 15);
		add(aButton);
	}
	private void setCustomCargoB(int x, int y, JButton aButton) {

		shapeBY.setBounds(75 + x, 40 + y, 50, 20);

		shapeBYlabel.setBounds(130 + x, 40 + y, 120, 15);
		add(shapeBY);
		add(shapeBYlabel);

		shapeBX.setBounds(75 + x, 60 + y, 50, 20);

		shapeBXlabel.setBounds(130 + x, 60 + y, 120, 15);
		add(shapeBX);
		add(shapeBXlabel);

		shapeBZ.setBounds(75 + x, 80 + y, 50, 20);

		shapeBZlabel.setBounds(130 + x, 80 + y, 120, 15);
		add(shapeBZ);
		add(shapeBZlabel);

		aButton.addActionListener(new SetCargoBButton());
		aButton.setBounds(75 + x, 100 + y, 120, 15);
		add(aButton);
	}
	private void setCustomCargoC(int x, int y, JButton aButton) {

		shapeCY.setBounds(75 + x, 40 + y, 50, 20);

		shapeCYlabel.setBounds(130 + x, 40 + y, 120, 15);
		add(shapeCY);
		add(shapeCYlabel);

		shapeCX.setBounds(75 + x, 60 + y, 50, 20);

		shapeCXlabel.setBounds(130 + x, 60 + y, 120, 15);
		add(shapeCX);
		add(shapeCXlabel);

		shapeCZ.setBounds(75 + x, 80 + y, 50, 20);

		shapeCZlabel.setBounds(130 + x, 80 + y, 120, 15);
		add(shapeCZ);
		add(shapeCZlabel);

		aButton.addActionListener(new SetCargoCButton());
		aButton.setBounds(75 + x, 100 + y, 120, 15);
		add(aButton);
	}
	class WeightButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Weights were set");
			
				
			}
		}
	class SetCargoAButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Cargos were set");
			if (shapeAX.getText().length() > 0 && shapeAY.getText().length() > 0 && shapeAZ.getText().length() > 0) {
			yCargoA = Integer.parseInt(shapeAY.getText());
			xCargoA = Integer.parseInt(shapeAX.getText());
			zCargoA = Integer.parseInt(shapeAZ.getText());
				//System.out.println(yCargoA);
		
				}
			runtimeData.getCargoData().getShapeList().remove(0);
			CargoGenerator newCargo= new CargoGenerator(yCargoA, xCargoA, zCargoA, 1);
			
			newCargo.setWeightTotal(runtimeData.getWeightCargoA());
			System.out.println(newCargo.getShape().length);
			runtimeData.getCargoData().getShapeList().add(0,newCargo);
				
						
			
			}
		}
	class SetCargoBButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Cargos were set");
			if (shapeBX.getText().length() > 0 && shapeBY.getText().length() > 0 && shapeBZ.getText().length() > 0) {
			yCargoB = Integer.parseInt(shapeBY.getText());
			xCargoB = Integer.parseInt(shapeBX.getText());
			zCargoB = Integer.parseInt(shapeBZ.getText());
				
						
				}
			runtimeData.getCargoData().getShapeList().remove(1);
			CargoGenerator newCargo= new CargoGenerator(yCargoB, xCargoB, zCargoB, 2);
			newCargo.setWeightTotal(runtimeData.getWeightCargoB());
			runtimeData.getCargoData().getShapeList().add(1,newCargo);
				
			}
		}
	class SetCargoCButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Cargos were set");
			if (shapeCX.getText().length() > 0 && shapeCY.getText().length() > 0 && shapeCZ.getText().length() > 0) {
			yCargoC = Integer.parseInt(shapeCY.getText());
			xCargoC = Integer.parseInt(shapeCX.getText());
			zCargoC = Integer.parseInt(shapeCZ.getText());
				
						
				}
			runtimeData.getCargoData().getShapeList().remove(2);
			CargoGenerator newCargo= new CargoGenerator(yCargoC, xCargoC, zCargoC, 3);
			newCargo.setWeightTotal(runtimeData.getWeightCargoC());
			runtimeData.getCargoData().getShapeList().add(2,newCargo);
			}
		}



	}
	
