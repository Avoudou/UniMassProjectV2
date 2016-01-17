package databases;

import objectDefinitions.CargoGenerator;
import basicTools.CargoSolidRot;

public class ShapesDefault extends CargoData {

	private CargoGenerator shapeA = new CargoGenerator(2, 4, 2, 1);
	private CargoGenerator shapeB = new CargoGenerator(3, 4, 2, 2);
	private CargoGenerator shapeC = new CargoGenerator(3, 3, 3, 3);

	public ShapesDefault() {
		super.addShape(shapeA);
		super.addShape(shapeB);
		super.addShape(shapeC);
	}

	public ShapesDefault(String anyStringResultsToweightedShapes) {
		shapeA.setWeightTotal(3);
		super.addShape(shapeA);
		shapeB.setWeightTotal(4);
		super.addShape(shapeB);
		shapeC.setWeightTotal(5);
		super.addShape(shapeC);
		super.setRotationIndex(CargoSolidRot.generateSolidCargoRot(shapeA));
		super.setRotationIndex(CargoSolidRot.generateSolidCargoRot(shapeB));
		super.setRotationIndex(CargoSolidRot.generateSolidCargoRot(shapeC));

	}

}
