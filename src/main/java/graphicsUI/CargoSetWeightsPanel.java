package graphicsUI;

import graphicsUI.CargoSpaceMenu.StartButtonListener;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objectDefinitions.CargoSpaceIndividual;
import lombok.AllArgsConstructor;

public class CargoSetWeightsPanel extends JPanel {
	private ImageIcon image = new ImageIcon("Textures/CargoSample.jpg");
	private JLabel cargoALabel= new  JLabel("Cargo A weight");
	private JLabel cargoBLabel= new  JLabel("Cargo B weight");
	private JLabel cargoCLabel= new  JLabel("Cargo C weight");
	private JTextField weightCargoA;
	private JTextField weightCargoB;
	private JTextField weightCargoC;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image.getImage(), 75, 0, 125, 125, null);
		g.drawImage(image.getImage(), 200, 0, 125, 125, null);
		g.drawImage(image.getImage(), 325, 0, 125, 125, null);

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
		
		JButton setWeightsButton = new JButton("Set Weights");
		setWeightsButton.addActionListener(new StartButtonListener());
		setWeightsButton.setBounds(500, 125, 160, 30);
		add(setWeightsButton);
	}
	class StartButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Weights were set");
			
				
			}
		}

	}
	
