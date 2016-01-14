package basicTools;

import java.util.ArrayList;

import objectDefinitions.CargoGenerator;
import objectDefinitions.CargoSpaceIndividual;

public class FillCargo {

	public void shapePlacer(int y, int x, int z, CargoSpaceIndividual cargo, CargoGenerator shape) {
		int[][][] space = cargo.getCargoSpace();

		for (int i = 0; i < shape.getShape().length; i++) {
			for (int j = 0; j < shape.getShape()[i].length; j++) {
				for (int k = 0; k < shape.getShape()[i][j].length; k++) {
					if (shape.getShape()[i][j][k] != 0) {
					space[y + i][x + j][z + k] = shape.getShapeIdentity();
					}
				}
			}
		}
		cargo.setCargoSpace(space);
	}

	/** Returns TRUE when a given shape CAN be placed in the given y ,x,z coordinated into the CargoSpace */
	public boolean collisionChecker(int y, int x, int z, CargoGenerator shape, CargoSpaceIndividual individual) {
	
		if (y + shape.getShape().length > individual.getCargoSpace().length) {
			return false;
	
		}
		if (x + shape.getShape()[0].length > individual.getCargoSpace()[0].length) {
			return false;
	
		}
		if (z + shape.getShape()[0][0].length > individual.getCargoSpace()[0][0].length) {
			return false;
	
		}
		for (int i = 0; i < shape.getShape().length; i++) {
			for (int j = 0; j < shape.getShape()[i].length; j++) {
				for (int k = 0; k < shape.getShape()[i][j].length; k++) {
					if (shape.getShape()[i][j][k] != 0) {
						if (individual.getCargoSpace()[i + y][j + x][k + z] != 0) {
							return false;
						}
					}
				}
			}
		}
	
		return true;
	}

	public CargoGenerator randomShapeChooser(ArrayList<CargoGenerator> shapes) {
		CargoGenerator shape;
		int i = (int) (Math.random() * shapes.size());
		shape = shapes.get(i);
		return shape;
	}

	public int[] findEmpty(CargoSpaceIndividual cargo, int y, int x, int z) {
		int[] coordinates = new int[3];
		for (int i = y; i < cargo.getCargoSpace().length; i++) {
			for (int j = x; j < cargo.getCargoSpace()[i].length; j++) {
				for (int k = z; k < cargo.getCargoSpace()[i][j].length; k++) {
					if (cargo.getCargoSpace()[i][j][k] == 0) {
						coordinates[0] = i;
						coordinates[1] = j;
						coordinates[2] = k;
						return coordinates;
					}
				}
			}
		}

		return coordinates;
	}

}
