package loadingAlgorithms;

import graphicsUI.RunTimeData;
import graphicsUI.UIWindow;

import java.util.ArrayList;

import objectDefinitions.CargoGenerator;
import objectDefinitions.CargoSpaceIndividual;
import basicTools.FillCargo;
import databases.CargoData;

public class FillCargoRandomly extends FillCargo {
	private CargoSpaceIndividual cargoSpaceModel;
	private int y;
	private int x;
	private int z;
	private RunTimeData runtimeData;
	private UIWindow aUIWindow;

	public FillCargoRandomly(RunTimeData runtimeData, UIWindow aUIWindow) {
		this.runtimeData = runtimeData;
		this.aUIWindow = aUIWindow;
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

			CargoSpaceIndividual tempSpace = new CargoSpaceIndividual(y, x, z);
			fillCargoSpaceRandomly(tempSpace, shapes);
			int tempWeight = tempSpace.getTotalWeight();
			if (tempWeight > bestMaxWeight) {
				bestSpace = tempSpace;
				bestMaxWeight = tempWeight;

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

						while (tempList.size() > 0 && somethingPlaced == false) {
							int randomIndex = (int) (Math.random() * tempList.size());
							CargoGenerator cargo = tempList.get(randomIndex);
							tempList.remove(randomIndex);
							ArrayList<CargoGenerator> rotationList;

							rotationList = new ArrayList<CargoGenerator>(runtimeData.getCargoData().getRotationIndex(
									randomIndex));

							while (rotationList.size() > 0 && somethingPlaced == false) {
								int randomIndexRot = (int) (Math.random() * rotationList.size());
								CargoGenerator cargoRot = rotationList.get(randomIndexRot);
								rotationList.remove(randomIndexRot);

								if (collisionChecker(i, j, k, cargoRot, aCargoSpace)) {
									shapePlacer(i, j, k, aCargoSpace, cargoRot);
									aCargoSpace
											.setTotalWeight(aCargoSpace.getTotalWeight() + cargoRot.getWeightTotal());
									ourShapes.get(randomIndex).setShapeIdentity(
											ourShapes.get(randomIndex).getShapeIdentity() + 10);
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
}
