package loadingAlgorithms;

import graphicsUI.RunTimeData;
import graphicsUI.UIWindow;

import java.util.ArrayList;

import objectDefinitions.CargoGenerator;
import objectDefinitions.CargoSpaceIndividual;
import basicTools.FillCargo;
import databases.CargoData;

public class ModRandom extends FillCargo {
	private CargoSpaceIndividual cargoSpaceModel;
	private int y;
	private int x;
	private int z;
	private RunTimeData runtimeData;
	private UIWindow aUIWindow;

	public ModRandom(RunTimeData runtimeData, UIWindow aUIWindow) {
		this.runtimeData = runtimeData;
		this.aUIWindow = aUIWindow;
		this.cargoSpaceModel = runtimeData.getACargoSpace();
		y = cargoSpaceModel.getCargoSpace().length;
		x = cargoSpaceModel.getCargoSpace()[0].length;
		z = cargoSpaceModel.getCargoSpace()[0][0].length;

	}

	public CargoSpaceIndividual createRndRotAlignedPopulation(int populationSize) {

		CargoData shapes = runtimeData.getCargoData();
		CargoSpaceIndividual bestSpace = new CargoSpaceIndividual(y, x, z);
		fillRandomAllignedRots(bestSpace, shapes);
		int bestMaxWeight = bestSpace.getTotalWeight();

		for (int i = 0; i < populationSize; i++) {

			CargoSpaceIndividual tempSpace = new CargoSpaceIndividual(y, x, z);
			fillRandomAllignedRots(tempSpace, shapes);
			int tempWeight = tempSpace.getTotalWeight();
			if (tempWeight > bestMaxWeight) {
				bestSpace = tempSpace;
				bestMaxWeight = tempWeight;

			}

		}
		return bestSpace;
	}

	public void fillRandomAllignedRots(CargoSpaceIndividual aCargoSpace, CargoData shapeLoads) {

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
							// runtimeData.getCargoData().getRotList().remove(randomIndex);
							removeUnalignedRotations(aCargoSpace, rotationList);
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

	public CargoSpaceIndividual createModRandmPopulation(int populationSize, CargoSpaceIndividual aCargoSpace) {

		CargoData shapes = runtimeData.getCargoData();
		CargoSpaceIndividual bestSpace = aCargoSpace;
		fillRandomAllignedRots(bestSpace, shapes);
		int bestMaxWeight = bestSpace.getTotalWeight();

		for (int i = 0; i < populationSize; i++) {

			CargoSpaceIndividual tempSpace = new CargoSpaceIndividual(aCargoSpace.getCargoSpace().length,
					aCargoSpace.getCargoSpace()[0].length, aCargoSpace.getCargoSpace()[0][0].length);
			fillRandomAllignedRots(tempSpace, shapes);
			int tempWeight = tempSpace.getTotalWeight();
			if (tempWeight > bestMaxWeight) {
				bestSpace = tempSpace;
				bestMaxWeight = tempWeight;

			}

		}
		return bestSpace;
	}

	private void removeUnalignedRotations(CargoSpaceIndividual aSpace, ArrayList<CargoGenerator> rotationList) {
		int directionDesiredIndicator = getMaxSpaceDimDir(aSpace);

		for (int i = 0; i < rotationList.size(); i++) {
			if (getMaxCargoDimDir(rotationList.get(i)) != directionDesiredIndicator) {
				rotationList.remove(i);
			}
		}
	}

	private int getMaxSpaceDimDir(CargoSpaceIndividual aCargoSpace) {
		int y = aCargoSpace.getCargoSpace().length;
		int x = aCargoSpace.getCargoSpace()[0].length;
		int z = aCargoSpace.getCargoSpace()[0][0].length;

		int maxXY = Math.max(y, x);
		int maxXZ = Math.max(x, z);
		int maxDimSize = Math.max(maxXY, maxXZ);
		if (y == maxDimSize) {
			return 1;

		}
		if (x == maxDimSize) {
			return 2;

		} else {
			return 3;
		}

	}

	private int getMaxCargoDimDir(CargoGenerator aCargo) {
		int y = aCargo.getShape().length;
		int x = aCargo.getShape()[0].length;
		int z = aCargo.getShape()[0][0].length;

		int maxXY = Math.max(y, x);
		int maxXZ = Math.max(x, z);
		int maxDimSize = Math.max(maxXY, maxXZ);
		if (y == maxDimSize) {
			return 1;

		}
		if (x == maxDimSize) {
			return 2;

		} else {
			return 3;
		}

	}
}
