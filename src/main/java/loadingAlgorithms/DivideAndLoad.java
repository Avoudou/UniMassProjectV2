package loadingAlgorithms;

import graphicsUI.RunTimeData;
import graphicsUI.UIWindow;
import objectDefinitions.CargoSpaceIndividual;
import basicTools.FillCargo;
import databases.CargoData;

public class DivideAndLoad extends FillCargo {

	private CargoData cargoData;
	private CargoSpaceIndividual initialCargoSpace;
	private FillCargoRandomly randomLoader;
	private RunTimeData runtimeData;
	private UIWindow aWindow;
	private int freeSpacesEnd = 1;

	private int heightOfSubSpace;

	public DivideAndLoad(RunTimeData runtimeData, UIWindow aWindow) {
		this.runtimeData = runtimeData;
		this.aWindow = aWindow;
		this.cargoData = runtimeData.getCargoData();
		this.initialCargoSpace = runtimeData.getACargoSpace();
		this.randomLoader = new FillCargoRandomly(runtimeData, aWindow);

	}

	public CargoSpaceIndividual dividerLoader(CargoSpaceIndividual aCargoSpace, CargoData shapeLoads) {
		CargoSpaceIndividual bestSubSpace = getBestSubSpace(4);
		CargoSpaceIndividual hyperSpace = new CargoSpaceIndividual(bestSubSpace.getCargoSpace().length,
				getMaxSpaceDim(aCargoSpace), bestSubSpace.getCargoSpace()[0][0].length);
		insertSubspace(hyperSpace, bestSubSpace);

		return hyperSpace;
	}

	public CargoSpaceIndividual getBestSubSpace(int maxSizeFreeDim) {

		CargoSpaceIndividual bestSubSpace = new CargoSpaceIndividual(1, 1, 1);
		bestSubSpace.setTotalWeight(0);

		for (int i = 1; i <= maxSizeFreeDim; i++) {
			CargoSpaceIndividual pickedSpace = getCargoSubspace(i);
			CargoSpaceIndividual cargoSubTemp = randomLoader.createDivisorPopulation(10000, pickedSpace);
			if (cargoSubTemp.getWeightPerVolume() > bestSubSpace.getWeightPerVolume()) {
				bestSubSpace = cargoSubTemp;
			}

		}
		// System.out.println(bestSubSpace.getTotalWeight());
		System.out.println(bestSubSpace.getCargoSpace()[0].length);
		return bestSubSpace;
	}

	private CargoSpaceIndividual getCargoSubspace(int freeDimSize) {
		int y = initialCargoSpace.getCargoSpace().length;
		int x = initialCargoSpace.getCargoSpace()[0].length;
		int z = initialCargoSpace.getCargoSpace()[0][0].length;
		CargoSpaceIndividual smallSpace;
		if (y <= x && z <= x) {
			smallSpace = new CargoSpaceIndividual(y, freeDimSize, z);
			return smallSpace;
		}
		if (y <= z && x <= z) {
			smallSpace = new CargoSpaceIndividual(y, freeDimSize, x);
			return smallSpace;
		}
		if (x <= y && z <= y) {
			smallSpace = new CargoSpaceIndividual(x, freeDimSize, z);
			return smallSpace;
		} else {

			System.out.println("Problem");
			smallSpace = new CargoSpaceIndividual(y, x, z);
		}

		return smallSpace;
	}

	private int getMaxSpaceDim(CargoSpaceIndividual aCargoSpace) {
		int y = aCargoSpace.getCargoSpace().length;
		int x = aCargoSpace.getCargoSpace()[0].length;
		int z = aCargoSpace.getCargoSpace()[0][0].length;

		int maxXY = Math.max(y, x);
		int maxXZ = Math.max(x, z);

		return Math.max(maxXY, maxXZ);

	}

	private void insertSubspace(CargoSpaceIndividual hyperSpace, CargoSpaceIndividual subSpace) {
		int timesToRepeat = (int) (hyperSpace.getCargoSpace()[0].length - freeSpacesEnd)
				/ subSpace.getCargoSpace()[0].length;

		heightOfSubSpace = subSpace.getCargoSpace()[0].length;
		System.out.println("divideandload bestsubspace length test: " + subSpace.getCargoSpace()[0].length);

		for (int i = 0; i < hyperSpace.getCargoSpace().length; i++) {
			for (int j = 0; j < hyperSpace.getCargoSpace()[0].length - freeSpacesEnd; j++) {
				for (int k = 0; k < hyperSpace.getCargoSpace()[0][0].length; k++) {
					hyperSpace.getCargoSpace()[i][j][k] = subSpace.getCargoSpace()[i][j
							% subSpace.getCargoSpace()[0].length][k];
				}
			}
		}
		hyperSpace.setTotalWeight(timesToRepeat * subSpace.getTotalWeight());

	}

	public int getSubSpaceOutput() {
		return heightOfSubSpace;
	}

}
