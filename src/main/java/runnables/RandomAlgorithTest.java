package runnables;

import static graphics3D.Constants.screenHeight;
import static graphics3D.Constants.screenWidth;

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class RandomAlgorithTest {

	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = screenWidth;
		config.height = screenHeight;
		// FillCargoRandomly randomLoader = new FillCargoRandomly(new CargoSpaceIndividual(5, 33, 8));

		// CargoSpaceIndividual bestSolution= randomLoader.createRandomPopulation(10000);

		// ShapesDefault shapeList= new ShapesDefault("default");
		// Evaluator evaluator= new Evaluator();
		// double utopiaWeight= evaluator.getUtopianMaxWeight(bestSolution, shapeList);
		// int solutionWeight= bestSolution.getTotalWeight();
		//

		// System.out.println(shapeList.getShape(0).getWeightPerUnit());
		// System.out.println(shapeList.getShape(1).getWeightPerUnit());
		// System.out.println(shapeList.getShape(2).getWeightPerUnit());

		// System.out.println("ideal total weight= "+ utopiaWeight);
		// System.out.println("solution's total2 weight  = "+ solutionWeight);

		// new UIWindow();

		// new LwjglApplication(new CargoSpace3D(bestSolution), config);

	}

}
