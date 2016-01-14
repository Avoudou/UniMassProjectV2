package databases;

import java.util.ArrayList;

import objectDefinitions.CargoGenerator;

public class CargoData {
	/**
	 * The arraylist containing the CargoGenerator
	 */
	private ArrayList<CargoGenerator> shapeList = new ArrayList<CargoGenerator>();

	public void addShape(CargoGenerator aShape) {
		shapeList.add(aShape);
	}
	public void replaceShape(CargoGenerator aShape, int index){
		shapeList.remove(index);
		shapeList.add(index, aShape);
	}

	public CargoGenerator getShape(int index) {
		return shapeList.get(index);
	}

	public ArrayList<CargoGenerator> getShapeList() {
		return shapeList;
	}

}
