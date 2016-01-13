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
	private UIWindow aWindow;

	public RunAlgorithmsMenu(RunTimeData runtimeData, UIWindow aWindow) {
		this.runtimeData = runtimeData;
		this.aWindow = aWindow;

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


			FillCargoRandomly randomLoader = new FillCargoRandomly(runtimeData, aWindow);

			CargoSpaceIndividual bestSolution = randomLoader.createRandomPopulation(Integer.parseInt(population
					.getText()));

			CargoData shapeList = runtimeData.getCargoData();
			Evaluator evaluator = new Evaluator();
			double utopiaWeight = evaluator.getUtopianMaxWeight(bestSolution, shapeList);
			int solutionWeight = bestSolution.getTotalWeight();

			runtimeData.setOutputInfo("Algorithm : random algorithm" + "\n" + "Cargo Used : " + "Default" + "\n"
					+ "Ideal total weight= " + utopiaWeight + "\n" + "Solution's total weight  = "
					+ solutionWeight);
			// System.out.println(runtimeData.getOutputInfo());
			aWindow.setOutInfo();
			// aWindow.disposeCentralPanel();
			// aWindow.setCentralPanel();
			// System.out.println("solution's total weight  = " + solutionWeight);


			new LwjglApplication(new CargoSpace3D(bestSolution), config);

		}
	}

}
