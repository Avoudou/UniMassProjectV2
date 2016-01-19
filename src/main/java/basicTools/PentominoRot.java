package basicTools;

import java.util.ArrayList;

import objectDefinitions.CargoGenerator;

public class PentominoRot {

	public static ArrayList<CargoGenerator> generatePentominoCargoRot(CargoGenerator aCargo) {
		ArrayList<CargoGenerator> rotationList = new ArrayList<CargoGenerator>();
		CargoGenerator modelPentomino = aCargo;

		int[][] flipARot1 = extractPentomino2D(modelPentomino);
		int[][] flipARot2 = rotate2DArray90dgrs(flipARot1);
		int[][] flipARot3 = rotate2DArray90dgrs(flipARot2);
		int[][] flipARot4 = rotate2DArray90dgrs(flipARot3);
		// rotations for y-x plane
		CargoGenerator planeYXrot1flipA = constructPentomino3DYXplane(flipARot1, aCargo.getShapeIdentity());
		CargoGenerator planeYXrot2flipA = constructPentomino3DYXplane(flipARot2, aCargo.getShapeIdentity());
		CargoGenerator planeYXrot3flipA = constructPentomino3DYXplane(flipARot3, aCargo.getShapeIdentity());
		CargoGenerator planeYXrot4flipA = constructPentomino3DYXplane(flipARot4, aCargo.getShapeIdentity());
		// rotations for y-z plane
		CargoGenerator planeYZrot1flipA = constructPentomino3DYZplane(flipARot1, aCargo.getShapeIdentity());
		CargoGenerator planeYZrot2flipA = constructPentomino3DYZplane(flipARot2, aCargo.getShapeIdentity());
		CargoGenerator planeYZrot3flipA = constructPentomino3DYZplane(flipARot3, aCargo.getShapeIdentity());
		CargoGenerator planeYZrot4flipA = constructPentomino3DYZplane(flipARot4, aCargo.getShapeIdentity());
		// rotations for x-z plane
		CargoGenerator planeZXrot1flipA = constructPentomino3DXZplane(flipARot1, aCargo.getShapeIdentity());
		CargoGenerator planeZXrot2flipA = constructPentomino3DXZplane(flipARot2, aCargo.getShapeIdentity());
		CargoGenerator planeZXrot3flipA = constructPentomino3DXZplane(flipARot3, aCargo.getShapeIdentity());
		CargoGenerator planeZXrot4flipA = constructPentomino3DXZplane(flipARot4, aCargo.getShapeIdentity());

		rotationList.add(planeYXrot1flipA);
		rotationList.add(planeYXrot2flipA);
		rotationList.add(planeYXrot3flipA);
		rotationList.add(planeYXrot4flipA);
		rotationList.add(planeYZrot1flipA);
		rotationList.add(planeYZrot2flipA);
		rotationList.add(planeYZrot3flipA);
		rotationList.add(planeYZrot4flipA);
		rotationList.add(planeZXrot1flipA);
		rotationList.add(planeZXrot2flipA);
		rotationList.add(planeZXrot3flipA);
		rotationList.add(planeZXrot4flipA);
		for (int i = 0; i < rotationList.size(); i++) {
			rotationList.get(i).setWeightTotal(aCargo.getWeightTotal());
		}

		return rotationList;
	}

	public static int[][] extractPentomino2D(CargoGenerator aPentominoCargo) {
		int[][] pentomino2D = new int[aPentominoCargo.getShape().length][aPentominoCargo.getShape()[0].length];
		for (int i = 0; i < aPentominoCargo.getShape().length; i++) {
			for (int j = 0; j < aPentominoCargo.getShape()[0].length; j++) {
				pentomino2D[i][j] = aPentominoCargo.getShape()[i][j][0];

			}
		}
		return pentomino2D;
	}

	/** return a new array that is a rotated clone of the input */
	public static int[][] rotate2DArray90dgrs(int[][] anArray) {
		int[][] shapeRot = new int[anArray[0].length][anArray.length];
		for (int i = 0; i < shapeRot.length; i++) {
			for (int j = 0; j < shapeRot[0].length; j++) {
				shapeRot[i][j] = anArray[shapeRot[0].length - j - 1][i];
			}
		}
		return shapeRot;
	}



	public static CargoGenerator constructPentomino3DYXplane(int[][] anArray, int shapeId) {
		CargoGenerator newPentomino = new CargoGenerator(anArray.length, anArray[0].length, 1, shapeId);
		for (int i = 0; i < anArray.length; i++) {
			for (int j = 0; j < anArray[0].length; j++) {
				newPentomino.getShape()[i][j][0] = anArray[i][j];

			}
		}

		return newPentomino;

	}

	public static CargoGenerator constructPentomino3DYZplane(int[][] anArray, int shapeId) {
		CargoGenerator newPentomino = new CargoGenerator(anArray.length, 1, anArray[0].length, shapeId);
		for (int i = 0; i < anArray.length; i++) {
			for (int j = 0; j < anArray[0].length; j++) {
				newPentomino.getShape()[i][0][j] = anArray[i][j];

			}
		}

		return newPentomino;

	}

	public static CargoGenerator constructPentomino3DXZplane(int[][] anArray, int shapeId) {

		CargoGenerator newPentomino = new CargoGenerator(1, anArray.length, anArray[0].length, shapeId);
		for (int i = 0; i < anArray.length; i++) {
			for (int j = 0; j < anArray[0].length; j++) {
				newPentomino.getShape()[0][i][j] = anArray[i][j];

			}
		}

		return newPentomino;

	}

}
