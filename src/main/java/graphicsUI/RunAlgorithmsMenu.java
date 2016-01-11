package graphicsUI;

import graphics3D.CargoSpace3D;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import loadingAlgorithms.FillCargoRandomly;
import objectDefinitions.CargoSpaceIndividual;
import basicTools.Evaluator;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import databases.CargoData;

public class RunAlgorithmsMenu extends JPanel {
	private RunTimeData runtimeData;
	private JButton startRandomButton = new JButton("RUN:Random Algorithm");
	private JTextField population = new JTextField("10000");

	public RunAlgorithmsMenu(RunTimeData runtimeData) {
		this.runtimeData = runtimeData;


		setLayout(new GridLayout(15, 1));

		add(new JLabel("Random Algorithm Population :"));

		add(population);

		startRandomButton.addActionListener(new RunRandomButtonListener());
		add(startRandomButton);
		add(new JLabel("Run Greedy Algorithm"));

	}

	class RunRandomButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.forceExit = false;
			config.width = 1000;
			config.height = 800;


			FillCargoRandomly randomLoader = new FillCargoRandomly(runtimeData);

			CargoSpaceIndividual bestSolution = randomLoader.createRandomPopulation(Integer.parseInt(population
					.getText()));

			CargoData shapeList = runtimeData.getCargoData();
			Evaluator evaluator = new Evaluator();
			double utopiaWeight = evaluator.getUtopianMaxWeight(bestSolution, shapeList);
			int solutionWeight = bestSolution.getTotalWeight();

			System.out.println("ideal total weight= " + utopiaWeight);
			System.out.println("solution's total weight  = " + solutionWeight);

			// new UIWindow();
			System.out.println(runtimeData.getCargoData().getShape(0).getShape().length);
			new LwjglApplication(new CargoSpace3D(bestSolution), config);

		}
	}

}
