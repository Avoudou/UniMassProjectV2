package objectDefinitions;

import lombok.Getter;
import lombok.Setter;

public class CargoGenerator {
	@Setter
	private int shapeIdentity;

	@Getter
	private int weightTotal;
	@Getter
	private double weightPerUnit;
	private int[][][] aShape;

	public CargoGenerator(int yElemUnits, int xElemUnits, int zElemUnits, int identity) {
		this.aShape = new int[yElemUnits][xElemUnits][zElemUnits];
		this.shapeIdentity = identity;
		for (int i = 0; i < aShape.length; i++) {
			for (int j = 0; j < aShape[i].length; j++) {
				for (int k = 0; k < aShape[i][j].length; k++) {
					aShape[i][j][k] = shapeIdentity;
				}
			}
		}
	}

	public int[][][] getShape() {
		return aShape;

	}

	public int getShapeIdentity() {
		return shapeIdentity;
	}

	public void setShape(int[][][] newShape) {
		aShape = newShape;

	}

	public void setWeightTotal(int weight) {
		this.weightTotal = weight;
		this.weightPerUnit = 1.0000*weight / (aShape.length * aShape[0].length * aShape[0][0].length);
		
	}

}
