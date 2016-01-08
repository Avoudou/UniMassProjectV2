package runnables;

import static graphics3D.Constants.screenHeight;
import static graphics3D.Constants.screenWidth;
import graphics3D.CargoSpace3D;
import loadingAlgorithms.FillCargoRandomly;
import objectDefinitions.CargoSpaceIndividual;
import basicTools.Evaluator;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import databases.Population;
import databases.ShapesDefault;

public class RandomAlgorithTest {

	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = screenWidth;
		config.height = screenHeight;
		FillCargoRandomly randomLoader = new FillCargoRandomly();

		Population cargoList = randomLoader.createRandomPopulation(1000);
		Evaluator evaluator = new Evaluator();
		CargoSpaceIndividual bestSolution= evaluator.findBestCargoSpace(cargoList);
		
		double  utopiaWeight= evaluator.getUtopianMaxWeight(bestSolution, new ShapesDefault("default"));
		int  solutionWeight= bestSolution.getTotalWeight();
		
		System.out.println("ideal weight= "+ utopiaWeight);
		System.out.println("solutions weight total = "+ solutionWeight);

		new LwjglApplication(new CargoSpace3D(bestSolution), config);

	}

}
