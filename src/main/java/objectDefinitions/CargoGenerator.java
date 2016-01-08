package objectDefinitions;

import lombok.Getter;
import lombok.Setter;

public class CargoGenerator {
	@Setter
 private int shapeIdentity;
 private int weightTotal;
 private double weightPerUnit;
 private int[][][] aShape;

	public CargoGenerator(int yElemUnits, int xElemUnits, int zElemUnits, int identity) {
		this.aShape = new int[yElemUnits][xElemUnits][zElemUnits];
		this.shapeIdentity= identity;
		for (int i = 0; i<aShape.length; i++)
		{
			for (int j = 0; j<aShape[i].length; j++)
			{
				for (int k = 0; k<aShape[i][j].length; k++)
				{
					aShape[i][j][k]=shapeIdentity;
				}
			}
		}
	}
	public int[][][] getShape(){
		return aShape;
		
	}
	public int getShapeIdentity(){
		return shapeIdentity;
	}
	public void setShape(int[][][] newShape) {
		aShape=newShape;
		
	}
}
