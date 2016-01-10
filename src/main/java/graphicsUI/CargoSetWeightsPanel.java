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
import objectDefinitions.CargoSpaceIndividual;
import lombok.AllArgsConstructor;

public class CargoSetWeightsPanel extends JPanel {
	private ImageIcon imageA = new ImageIcon("Textures/DefaultA.jpg");
	private ImageIcon imageB = new ImageIcon("Textures/DefaultB.jpg");
	private ImageIcon imageC = new ImageIcon("Textures/DefaultC.jpg");
	private JLabel cargoALabel= new  JLabel("Cargo A weight");
	private JLabel cargoBLabel= new  JLabel("Cargo B weight");
	private JLabel cargoCLabel= new  JLabel("Cargo C weight");
	private JButton setWeightsButton = new JButton("Set Weights");
	private JButton  setShapeA= new JButton("set cargo A");
	private JTextField weightCargoA;
	private JTextField weightCargoB;
	private JTextField weightCargoC;
	private int 	y;
	private int 	x ;
	private int 	z ;
	private JTextField shapeAY = new JTextField();
	private JTextField shapeAX = new JTextField();
	private	JTextField shapeAZ = new JTextField();
	
	
	private boolean shapesSet= false;
	private RunTimeData runtimeData;
	
	
	public CargoSetWeightsPanel( RunTimeData runtimeData) {
		this.runtimeData=runtimeData;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
if(shapesSet){
		g.drawImage(imageA.getImage(), 75, 0, 125, 125, null);
		g.drawImage(imageB.getImage(), 200, 0, 125, 125, null);
		g.drawImage(imageC.getImage(), 325, 0, 125, 125, null);
}
setCustomShapeMenu();
//	setWeightFields();
	}
	private void setWeightFields() {
		weightCargoA = new JTextField();
		weightCargoA.setBounds(115, 130, 50, 20);
		cargoALabel.setBounds(90, 152, 120, 15);
		add(cargoALabel);
		add(weightCargoA);

		weightCargoB = new JTextField();
		weightCargoB.setBounds(240, 130, 50, 20);
		cargoBLabel.setBounds(215, 152, 120, 15);
		add(weightCargoB);
		add(cargoBLabel);

		weightCargoC = new JTextField();
		weightCargoC.setBounds(365, 130, 50, 20);
		cargoCLabel.setBounds(340, 152, 120, 15);
		add(weightCargoC);
		add(cargoCLabel);
		
		
		setWeightsButton.addActionListener(new WeightButtonListener());
		setWeightsButton.setBounds(500, 125, 160, 30);
		add(setWeightsButton);
	}
	private void setCustomShapeMenu() {
		
		JLabel shapeNamelabel= new  JLabel("Cargo A dimentions");
		shapeNamelabel.setBounds(235, 45, 120, 15);
		add(shapeNamelabel);
		
		
		shapeAY.setBounds(75, 40, 50, 20);
		JLabel shapeAYlabel= new  JLabel("Xcoord");
		shapeAYlabel.setBounds(75, 65, 120, 15);
		add(shapeAY);
		add(shapeAYlabel);

		
		
		shapeAX.setBounds(125,40, 50, 20);
		JLabel shapeAXlabel= new  JLabel("Y coord");
		shapeAXlabel.setBounds(125, 65, 120, 15);
		add(shapeAX);
		add(shapeAXlabel);

		
		
		shapeAZ.setBounds(175,40, 50, 20);
		JLabel shapeAZlabel= new  JLabel("Zxcoord");
		shapeAZlabel.setBounds(175, 65, 120, 15);
		add(shapeAZ);
		add(shapeAZlabel);
		
		
		 
		
		setShapeA.addActionListener(new SetShapeSetButtonListener());
		setShapeA.setBounds(375, 45, 120, 15);
		add(setShapeA);
	}
	class WeightButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Weights were set");
			
				
			}
		}
	class SetShapeSetButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Cargos were set");
			if (shapeAX.getText().length() > 0 && shapeAY.getText().length() > 0 && shapeAZ.getText().length() > 0) {
			y = Integer.parseInt(shapeAY.getText());
				x = Integer.parseInt(shapeAX.getText());
			z = Integer.parseInt(shapeAZ.getText());
				
						
				}
			runtimeData.getCargoData().getShapeList().remove(0);
			runtimeData.getCargoData().getShapeList().add(0,new CargoGenerator(y, x, z, 1));
				
			}
		}

	}
	
