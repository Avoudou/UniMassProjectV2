package databases;

import java.util.ArrayList;

import objectDefinitions.CargoGenerator;

public class ShapeData {
	
	private ArrayList<CargoGenerator> shapeList = new ArrayList<CargoGenerator>();
	
	
	public void addShape(CargoGenerator aShape){
		shapeList.add(aShape);
	}
	
	public CargoGenerator getShape(int index){
		return shapeList.get(index);
	}
	
	public ArrayList<CargoGenerator> getShapeList(){
		return shapeList;
	}
	

}
