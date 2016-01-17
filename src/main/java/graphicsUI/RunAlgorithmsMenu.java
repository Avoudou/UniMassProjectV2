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
import loadingAlgorithms.GreedyAlgorithm;
import objectDefinitions.CargoSpaceIndividual;
import basicTools.Evaluator;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import databases.CargoData;

public class RunAlgorithmsMenu extends JPanel {
	private RunTimeData runtimeData;
	private JButton startRandomButton = new JButton("RUN:Random Algorithm");
	private JButton startGreedyButton = new JButton("RUN:Greedy Algorithm");
	private JButton startDivideButton = new JButton("RUN:Divisor Algorithm");
	private JButton startModRandomButton = new JButton("RUN:Mod.Random Alg.");

	private JTextField populatioRunAlgorithms = new JTextField("1000");

	private UIWindow aWindow;

	public RunAlgorithmsMenu(RunTimeData runtimeData, UIWindow aWindow) {
		this.runtimeData = runtimeData;
		this.aWindow = aWindow;

		setLayout(new GridLayout(15, 1));

		add(new JLabel("Run-Algorithms Population :"));
		add(populatioRunAlgorithms);
		add(new JLabel(""));
		startRandomButton.addActionListener(new RunRandomButtonListener());
		add(startRandomButton);


		add(new JLabel(""));

		startGreedyButton.addActionListener(new RunGreedyButtonListener());
		add(startGreedyButton);

		add(new JLabel(""));

		add(startModRandomButton);
		add(new JLabel(""));
		add(startDivideButton);

	}

	private class RunRandomButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.forceExit = false;
			config.width = 1000;
			config.height = 800;

			FillCargoRandomly randomLoader = new FillCargoRandomly(runtimeData, aWindow);
			long start = System.currentTimeMillis();

			CargoSpaceIndividual bestSolution = randomLoader.createRandomPopulation(Integer.parseInt(populatioRunAlgorithms
					.getText()));
			double elapsedInMs = System.currentTimeMillis() - start;
			CargoData shapeList = runtimeData.getCargoData();
			Evaluator evaluator = new Evaluator();
			double utopiaWeight = evaluator.getUtopianMaxWeight(bestSolution, shapeList);
			int solutionWeight = bestSolution.getTotalWeight();

			runtimeData.setOutputInfo("Algorithm : random algorithm" + "\n" + "Cargo Used : "
					+ runtimeData.getCargoSetUsed() + "\n" + "Ideal total weight= " + utopiaWeight + "\n"
					+ "Solution's total weight  = " + solutionWeight + "\n" + "Algorithm runtime: " + elapsedInMs
					+ "ms");

			aWindow.disposeCentralPanel();
			aWindow.setCentralPanel();
			aWindow.setOutInfo();
			new LwjglApplication(new CargoSpace3D(bestSolution), config);

		}
	}

	private class RunGreedyButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.forceExit = false;
			config.width = 1000;
			config.height = 800;

			GreedyAlgorithm greedyLoader = new GreedyAlgorithm(runtimeData);
			long start = System.currentTimeMillis();
			CargoSpaceIndividual bestSolution = greedyLoader.createRandomPopulation(Integer.parseInt(populatioRunAlgorithms
					.getText()));
			double elapsedInMs = System.currentTimeMillis() - start;
			System.out.println(runtimeData.getCargoData().getShape(0).getWeightTotal());
			CargoData shapeList = runtimeData.getCargoData();
			Evaluator evaluator = new Evaluator();
			double utopiaWeight = evaluator.getUtopianMaxWeight(bestSolution, shapeList);
			int solutionWeight = bestSolution.getTotalWeight();

			System.out.println("ideal total weight= " + utopiaWeight);
			System.out.println("solution's total weight  = " + solutionWeight);

			runtimeData.setOutputInfo("Algorithm : Greedy algorithm" + "\n" + "Cargo Used : "
					+ runtimeData.getCargoSetName() + "\n" + "Ideal total weight= " + utopiaWeight + "\n"
					+ "Solution's total weight  = " + solutionWeight + "\n" + "Algorithm runtime: " + elapsedInMs
					+ "ms");

			aWindow.disposeCentralPanel();
			aWindow.setCentralPanel();
			aWindow.setOutInfo();
			new LwjglApplication(new CargoSpace3D(bestSolution), config);

		}
	}

}
