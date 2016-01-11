package loadingAlgorithms;

import graphicsUI.RunTimeData;

import java.util.ArrayList;

import basicTools.FillCargo;
import objectDefinitions.CargoSpaceIndividual;
import objectDefinitions.CargoGenerator;
import databases.Population;
import databases.CargoData;
import databases.ShapesDefault;

public class FillCargoRandomly extends FillCargo {
	private CargoSpaceIndividual cargoSpaceModel;
	private int y;
	private int x;
	private int z;
	private RunTimeData runtimeData;

	public FillCargoRandomly(RunTimeData runtimeData) {
		this.runtimeData = runtimeData;
		this.cargoSpaceModel = runtimeData.getACargoSpace();
		y = cargoSpaceModel.getCargoSpace().length;
		x = cargoSpaceModel.getCargoSpace()[0].length;
		z = cargoSpaceModel.getCargoSpace()[0][0].length;

	}

	public CargoSpaceIndividual createRandomPopulation(int populationSize) {

		CargoData shapes = runtimeData.getCargoData();
		CargoSpaceIndividual bestSpace = new CargoSpaceIndividual(y, x, z);
		fillCargoSpaceRandomly(bestSpace, shapes);
		int bestMaxWeight = bestSpace.getTotalWeight();

		for (int i = 0; i < populationSize; i++) {

			// System.out.println("population size: "+i);
			CargoSpaceIndividual tempSpace = new CargoSpaceIndividual(y, x, z);
			fillCargoSpaceRandomly(tempSpace, shapes);
			int tempWeight = tempSpace.getTotalWeight();
			if (tempWeight > bestMaxWeight) {
				bestSpace = tempSpace;
				bestMaxWeight = tempWeight;
				System.out.println("weight of best solution found : " + bestMaxWeight);
			}

		}

		return bestSpace;
	}

	public void fillCargoSpaceRandomly(CargoSpaceIndividual aCargoSpace, CargoData shapeLoads) {

		ArrayList<CargoGenerator> ourShapes = shapeLoads.getShapeList();

		int[][][] space = aCargoSpace.getCargoSpace();

		for (int i = 0; i < space.length; i++) {
			for (int j = 0; j < space[0].length; j++) {
				for (int k = 0; k < space[0][0].length; k++) {
					if (space[i][j][k] == 0) {

						ArrayList<CargoGenerator> tempList = new ArrayList<CargoGenerator>(ourShapes);
						boolean somethingPlaced = false;
						// int counter=0;
						while (tempList.size() > 0 && somethingPlaced == false) {

							// counter ++;
							// System.out.println("trying"+ counter);

							int randomIndex = (int) (Math.random() * tempList.size());
							CargoGenerator shape = tempList.get(randomIndex);
							tempList.remove(randomIndex);

							if (collisionChecker(i, j, k, shape, aCargoSpace)) {
								shapePlacer(i, j, k, aCargoSpace, shape);
								aCargoSpace.setTotalWeight(aCargoSpace.getTotalWeight() + shape.getWeightTotal());
								ourShapes.get(randomIndex).setShapeIdentity(
										ourShapes.get(randomIndex).getShapeIdentity() + 10);
								// System.out.println(ourShapes.get(randomIndex).getShapeIdentity());
								somethingPlaced = true;
							}

						}
					}
				}
			}
		}
		aCargoSpace.setCargoSpace(space);
	}
}
