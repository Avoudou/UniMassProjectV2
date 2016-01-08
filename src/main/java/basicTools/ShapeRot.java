package basicTools;

import objectDefinitions.CargoGenerator;

public class ShapeRot {

	public void rotateXPlane(CargoGenerator shape) {
		int[][][] aShape = shape.getShape();
		int[][] rotMatrix = { { 1, 0, 0 }, { 0, 0, -1 }, { 0, 1, 0 } };

		int[][][] rotatedShape = new int[aShape.length][aShape[0].length][aShape[0][0].length];
		int sum = 0;

		for (int i = 0; i < aShape.length; i++) {
			for (int j = 0; j < aShape[i].length; j++) {
				for (int k = 0; k < rotMatrix.length; k++) {
					for (int l = 0; l < rotMatrix[k].length; l++) {
						sum = sum + aShape[i][j][l] * rotMatrix[j][k];

					}

					rotatedShape[i][j][k] = sum;
					sum = 0;
				}
			}
		}
		shape.setShape(rotatedShape);

		// for(int i =0; i<aShape.length; i++)
		// {
		// System.out.print("x line"+i+": ");
		// for(int j =0; j<aShape[i].length;j++)
		// {
		// System.out.print("y line"+j+": ");
		// for ( int k = 0; k<aShape[i][j].length; k++)
		// {
		// System.out.println(aShape[i][j][k]+ " ");
		// }
		// }
		// System.out.println();
		// }
	}

	public void rotateYPlane(CargoGenerator shape) {

		int[][][] aShape = shape.getShape();
		int[][] rotMatrix = { { 0, 0, 1 }, { 0, 1, 0 }, { -1, 0, 0 } };

		int[][][] rotatedShape = new int[aShape.length][aShape[0].length][aShape[0][0].length];
		int sum = 0;

		for (int i = 0; i < aShape.length; i++) {
			for (int j = 0; j < aShape[i].length; j++) {
				for (int k = 0; k < rotMatrix.length; k++) {
					for (int l = 0; l < rotMatrix[k].length; l++) {
						sum = sum + aShape[i][j][l] * rotMatrix[j][k];

					}

					rotatedShape[i][j][k] = sum;
					sum = 0;
				}
			}
		}
		shape.setShape(rotatedShape);
	}

	public void rotateZPlane(CargoGenerator shape) {
		int[][][] aShape = shape.getShape();
		int[][] rotMatrix = { { 0, -1, 0 }, { 1, 0, 0 }, { 0, 0, 1 } };

		int[][][] rotatedShape = new int[aShape.length][aShape[0].length][aShape[0][0].length];
		int sum = 0;

		for (int i = 0; i < aShape.length; i++) {
			for (int j = 0; j < aShape[i].length; j++) {
				for (int k = 0; k < rotMatrix.length; k++) {
					for (int l = 0; l < rotMatrix[k].length; l++) {
						sum = sum + aShape[i][j][l] * rotMatrix[j][k];

					}

					rotatedShape[i][j][k] = sum;
					sum = 0;
				}
			}
		}
		shape.setShape(rotatedShape);
	}

}