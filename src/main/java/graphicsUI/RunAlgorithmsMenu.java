package graphicsUI;

import graphics3D.CargoSpace3D;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import loadingAlgorithms.FillCargoRandomly;
import objectDefinitions.CargoSpaceIndividual;
import basicTools.Evaluator;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import databases.CargoData;

public class RunAlgorithmsMenu extends JPanel {
	private RunTimeData runtimeData;

	public RunAlgorithmsMenu(RunTimeData runtimeData) {
		this.runtimeData = runtimeData;

		setLayout(new GridLayout(7, 1));

		add(new JLabel("Run Random Algorithm"));
		JButton startRandomButton = new JButton("RUN");
		startRandomButton.addActionListener(new RunRandomButtonListener());
		add(startRandomButton);
		add(new JLabel("Run Greedy Algorith"));

	}

	class RunRandomButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.forceExit = false;
			config.width = 1000;
			config.height = 800;


			FillCargoRandomly randomLoader = new FillCargoRandomly(runtimeData);

			CargoSpaceIndividual bestSolution = randomLoader.createRandomPopulation(10000);

			CargoData shapeList = runtimeData.getCargoData();
			Evaluator evaluator = new Evaluator();
			double utopiaWeight = evaluator.getUtopianMaxWeight(bestSolution, shapeList);
			int solutionWeight = bestSolution.getTotalWeight();

			System.out.println("ideal total weight= " + utopiaWeight);
			System.out.println("solution's total2 weight  = " + solutionWeight);

			// new UIWindow();
			System.out.println(runtimeData.getCargoData().getShape(0).getShape().length);
			new LwjglApplication(new CargoSpace3D(bestSolution), config);

		}
	}

}
