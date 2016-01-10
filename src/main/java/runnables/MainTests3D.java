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
		 CargoGenerator shape = new CargoGenerator (2, 4, 2, 1);
		 CargoGenerator shape1 = new CargoGenerator(3, 4, 2, 3);
		 CargoGenerator shape2 = new CargoGenerator(3, 3, 3, 2);
		
		 CargoSpaceIndividual cargoSpace = new CargoSpaceIndividual(6, 6, 6);
		 FillCargo cargoLoader = new FillCargo();
		
		 cargoLoader.shapePlacer(0, 0, 0, cargoSpace, shape1);
		
		
		
		
		
		
		// new LwjglApplication(new CargoSpace3D(cargoSpace), config);
		 new LwjglApplication(new Shape3D(new ShapesDefault().getShape(2)), config);

		

	}

}
