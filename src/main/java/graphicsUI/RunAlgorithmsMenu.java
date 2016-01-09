package graphicsUI;

import static graphics3D.Constants.screenHeight;
import static graphics3D.Constants.screenWidth;
import graphics3D.CargoSpace3D;
import graphicsUI.CargoSpaceMenu.StartButtonListener;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import loadingAlgorithms.FillCargoRandomly;
import basicTools.Evaluator;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import databases.CargoData;
import databases.ShapesDefault;
import objectDefinitions.CargoSpaceIndividual;

public class RunAlgorithmsMenu extends JPanel {
	private RunTimeData runtimeData;

	public RunAlgorithmsMenu(RunTimeData runtimeData) {
		this.runtimeData = runtimeData;

		setLayout(new GridLayout(7, 1));

		add(new JLabel("Run Random Algorithm"));
		JButton startRandomButton = new JButton("RUN");
		startRandomButton.addActionListener(new StartButtonListener());
		add(startRandomButton);
		add(new JLabel("Run Greedy Algorith"));

	}

	class StartButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.forceExit = false;
			config.width = 1000;
			config.height = 800;
			
			FillCargoRandomly randomLoader = new FillCargoRandomly(runtimeData.getACargoSpace());

			CargoSpaceIndividual bestSolution = randomLoader.createRandomPopulation(10000);

			CargoData shapeList = runtimeData.getCargoData();
			Evaluator evaluator = new Evaluator();
			double utopiaWeight = evaluator.getUtopianMaxWeight(bestSolution, shapeList);
			int solutionWeight = bestSolution.getTotalWeight();

			System.out.println("ideal total weight= " + utopiaWeight);
			System.out.println("solution's total2 weight  = " + solutionWeight);

			// new UIWindow();

			new LwjglApplication(new CargoSpace3D(bestSolution), config);

		}
	}

}
