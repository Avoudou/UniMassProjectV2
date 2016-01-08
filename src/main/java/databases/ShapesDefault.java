package databases;

import java.util.ArrayList;

import objectDefinitions.CargoGenerator;

public class ShapesDefault extends ShapeData {
	

	
		private CargoGenerator shapeA = new CargoGenerator(2,2,4,2);
		private CargoGenerator shapeB = new CargoGenerator(2,2,2,3);
		private CargoGenerator shapeC = new CargoGenerator(3,3,3,1);
		
		
		
		public ShapesDefault()
		{
			super.addShape(shapeA);
			super.addShape(shapeB);
			super.addShape(shapeC);
		}
		
	

}
