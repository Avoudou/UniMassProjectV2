package runnables;

import static graphics3D.Constants.screenHeight;
import static graphics3D.Constants.screenWidth;
import loadingAlgorithms.FillCargoRandomly;
import objectDefinitions.CargoSpaceIndividual;
import objectDefinitions.CargoGenerator;
import graphics3D.CargoSpace3D;
import graphics3D.Shape3D;
import basicTools.FillCargo;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import databases.ShapesDefault;

public class MainTests3D {

	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = screenWidth;
		config.height = screenHeight;
		// ShapeGenerator shape = new ShapeGenerator (2, 2, 4, 1);
		// ShapeGenerator shape1 = new ShapeGenerator(3, 3, 3, 3);
		// ShapeGenerator shape2 = new ShapeGenerator(2, 3, 4, 2);
		//
		// CargoSpaceIndividual cargoSpace = new CargoSpaceIndividual(6, 6, 6);
		// FillCargo cargoLoader = new FillCargo();
		// cargoLoader.shapePlacer(0, 0, 0, cargoSpace, shape1);
		//
		// if(cargoLoader.collisionChecker(3, 0, 0, shape1, cargoSpace)){
		// cargoLoader.shapePlacer(3, 0, 0, cargoSpace, shape1);
		// }
		// if(cargoLoader.collisionChecker(3, 0, 0, shape2, cargoSpace)){
		// cargoLoader.shapePlacer(3, 0, 0, cargoSpace, shape2);
		// }
		// //cargoLoader.shapePlacer( 0, 0, 0,cargoSpace, shape1);
		// System.out.println(cargoLoader.collisionChecker(0, 0, 0,shape1, cargoSpace));
		//
		//
		//
		//
		// new LwjglApplication(new CargoSpace3D(cargoSpace), config);
		// new LwjglApplication(new Shape3D(new ShapesDefault().getShape(2)), config);

		ShapesDefault shapes = new ShapesDefault("default");
		CargoSpaceIndividual cargoSpace = new CargoSpaceIndividual(5, 32, 8);
		FillCargoRandomly randomLoader = new FillCargoRandomly(cargoSpace, shapes);
		randomLoader.fillCargoSpaceRandomly();
		System.out.println("tottal weight loaded :" + cargoSpace.getTotalWeight());

		new LwjglApplication(new CargoSpace3D(cargoSpace), config);

	}

}
