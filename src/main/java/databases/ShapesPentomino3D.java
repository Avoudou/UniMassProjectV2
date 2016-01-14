package databases;

import objectDefinitions.CargoGenerator;

/**
 * This class contains an ArrayList with the pentomino shapes as CargoGenerators
 * 
 * @author Esther
 *
 */
public class ShapesPentomino3D extends CargoData {

	/**
	 * Constructor for the class Creates CargoGenerators for the pentominos, modifies them accordingly and adds them to
	 * the arraylist
	 */
	public ShapesPentomino3D() {
		CargoGenerator tPentomino = new CargoGenerator(3, 3, 1, 1);
		removeCube(tPentomino, 1, 0);
		removeCube(tPentomino, 2, 0);
		removeCube(tPentomino, 1, 2);
		removeCube(tPentomino, 2, 2);
		tPentomino.setWeightTotal(3);
		CargoGenerator lPentomino = new CargoGenerator(4, 2, 1, 2);
		removeCube(lPentomino, 0, 0);
		removeCube(lPentomino, 1, 0);
		removeCube(lPentomino, 2, 0);
		lPentomino.setWeightTotal(4);
		CargoGenerator pPentomino = new CargoGenerator(2, 3, 1, 3);
		removeCube(pPentomino, 0, 0);
		pPentomino.setWeightTotal(3);

		super.addShape(tPentomino);
		super.addShape(lPentomino);
		super.addShape(pPentomino);
	}

	/**
	 * method that sets the value of a cube (of coordinates from parameters and z=0) inside the array of a
	 * CargoGenerator to 0
	 * 
	 * @param shape
	 *            the CargoGenerator representing the shape
	 * @param indexY
	 *            y-coordinate of the cube
	 * @param indexX
	 *            x-coordinate of the cube
	 */
	public void removeCube(CargoGenerator shape, int indexY, int indexX) {
		int[][][] pentomino = shape.getShape();
		pentomino[indexY][indexX][0] = 0;
		shape.setShape(pentomino);
	}

}
