package loadingAlgorithms;

import graphicsUI.RunTimeData;

import java.util.ArrayList;

import objectDefinitions.CargoGenerator;
import objectDefinitions.CargoSpaceIndividual;
import basicTools.Evaluator;
import basicTools.FillCargo;
import databases.CargoData;

public class GreedyAlgorithm extends FillCargo {
	private CargoSpaceIndividual cargoSpaceModel;
	private int y;
	private int x;
	private int z;
	private RunTimeData runtimeData;
	private Evaluator evaluator = new Evaluator();

	public GreedyAlgorithm(RunTimeData runtimeData) {
		this.runtimeData = runtimeData;
		this.cargoSpaceModel = runtimeData.getACargoSpace();
		y = cargoSpaceModel.getCargoSpace().length;
		x = cargoSpaceModel.getCargoSpace()[0].length;
		z = cargoSpaceModel.getCargoSpace()[0][0].length;

	}

	public void fillCargoSpaceGreedy(CargoSpaceIndividual aCargoSpace, CargoData shapeLoads) {

		ArrayList<CargoGenerator> ourShapes = shapeLoads.getShapeList();

		int[][][] space = aCargoSpace.getCargoSpace();

		for (int i = 0; i < space.length; i++) {
			for (int j = 0; j < space[0].length; j++) {
				for (int k = 0; k < space[0][0].length; k++) {
					if (space[i][j][k] == 0) {

						ArrayList<CargoGenerator> tempList = new ArrayList<CargoGenerator>(ourShapes);
						boolean somethingPlaced = false;

						while (tempList.size() > 0 && somethingPlaced == false) {
							int bestIndex = evaluator.bestWeightPerUnitIndex(tempList);
							CargoGenerator shape = tempList.get(bestIndex);
							tempList.remove(bestIndex);

							ArrayList<CargoGenerator> rotationList = new ArrayList<CargoGenerator>(runtimeData
									.getCargoData().getRotationIndex(bestIndex));
							// runtimeData.getCargoData().getRotList().remove(bestIndex);
							while (rotationList.size() > 0 && somethingPlaced == false) {
								int randomIndexRot = (int) (Math.random() * rotationList.size());
								CargoGenerator cargoRot = rotationList.get(randomIndexRot);
								rotationList.remove(randomIndexRot);

								if (collisionChecker(i, j, k, cargoRot, aCargoSpace)) {
									shapePlacer(i, j, k, aCargoSpace, cargoRot);
									aCargoSpace.setTotalWeight(aCargoSpace.getTotalWeight() + shape.getWeightTotal());
									ourShapes.get(bestIndex).setShapeIdentity(
											ourShapes.get(bestIndex).getShapeIdentity() + 10);
									somethingPlaced = true;
								}
							}
						}
					}
				}
			}
		}
		aCargoSpace.setCargoSpace(space);
	}

	public CargoSpaceIndividual createRandomPopulation(int populationSize) {

		CargoData shapes = runtimeData.getCargoData();
		CargoSpaceIndividual bestSpace = new CargoSpaceIndividual(y, x, z);
		fillCargoSpaceGreedy(bestSpace, shapes);
		int bestMaxWeight = bestSpace.getTotalWeight();

		for (int i = 0; i < populationSize; i++) {

			CargoSpaceIndividual tempSpace = new CargoSpaceIndividual(y, x, z);
			fillCargoSpaceGreedy(tempSpace, shapes);
			int tempWeight = tempSpace.getTotalWeight();
			bestMaxWeight = tempWeight;
			bestSpace = tempSpace;

		}

		return bestSpace;
	}

}