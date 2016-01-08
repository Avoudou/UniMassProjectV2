package loadingAlgorithms;

import java.util.ArrayList;

import basicTools.FillCargo;
import objectDefinitions.CargoSpaceIndividual;
import objectDefinitions.CargoGenerator;
import databases.ShapeData;

public class FillCargoRandomly extends FillCargo {

	private CargoSpaceIndividual aCargoSpace;
	private ShapeData shapeLoads;

	public FillCargoRandomly(CargoSpaceIndividual aCargoSpace, ShapeData shapeLoads) {
		this.aCargoSpace = aCargoSpace;
		this.shapeLoads = shapeLoads;

	}

	public void fillCargoSpaceRandomly() {

		ArrayList<CargoGenerator> ourShapes = shapeLoads.getShapeList();

		int[][][] space = aCargoSpace.getCargoSpace();

		for (int i = 0; i < space.length; i++) {
			for (int j = 0; j < space[0].length; j++) {
				for (int k = 0; k < space[0][0].length; k++) {
					if (space[i][j][k] == 0) {

						ArrayList<CargoGenerator> tempList = new ArrayList<CargoGenerator>(ourShapes);
						boolean somethingPlaced= false;
						while (tempList.size() > 0 && somethingPlaced==false) {
							System.out.println("trying");
							int randomIndex = (int) (Math.random() * tempList.size());
							CargoGenerator shape = ourShapes.get(randomIndex);
							tempList.remove(randomIndex);

							if (collisionChecker(i, j, k, shape, aCargoSpace)) {
								shapePlacer(i, j, k, aCargoSpace, shape);
								System.out.println("change identity");
								ourShapes.get(randomIndex).setShapeIdentity(ourShapes.get(randomIndex).getShapeIdentity()*10);
								//System.out.println(ourShapes.get(randomIndex).getShapeIdentity());
								somethingPlaced=true;
							}

						}
					}
				}
			}
		}
		aCargoSpace.setCargoSpace(space);
	}
}
