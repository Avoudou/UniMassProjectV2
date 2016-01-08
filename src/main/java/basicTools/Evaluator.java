package basicTools;

import objectDefinitions.CargoSpaceIndividual;
import databases.Population;
import databases.ShapeData;

public class Evaluator {

	public double getUtopianMaxWeight(CargoSpaceIndividual aCargoSpace, ShapeData cargoList) {

		return getCargoSpaceVolume(aCargoSpace) * getBestWeightPerUnit(cargoList);

	}

	public CargoSpaceIndividual findBestCargoSpace(Population aPopulation) {
		int listSize = aPopulation.getPopulationSize();
		CargoSpaceIndividual bestFilledSpace = aPopulation.getCargoSpaceIndividual(0);
		for (int i = 0; i < listSize; i++) {
			if (aPopulation.getCargoSpaceIndividual(i).getTotalWeight() > bestFilledSpace.getTotalWeight()) {
				bestFilledSpace = aPopulation.getCargoSpaceIndividual(i);
			}

		}
		return bestFilledSpace;

	}

	public int getCargoSpaceVolume(CargoSpaceIndividual aCargoSpaceIndividual) {
		int[][][] space = aCargoSpaceIndividual.getCargoSpace();
		int y = space.length;
		int x = space[0].length;
		int z = space[0][0].length;
		return y * x * z;
	}

	public double getBestWeightPerUnit(ShapeData cargoList) {
		int listSize = cargoList.getShapeList().size();
		double maxWeightPerUnit = 0;
		for (int i = 0; i < listSize; i++) {
			maxWeightPerUnit = Math.max(maxWeightPerUnit, cargoList.getShape(i).getWeightPerUnit());

		}

		return maxWeightPerUnit;
	}

}
