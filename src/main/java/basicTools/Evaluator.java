package basicTools;

import java.util.ArrayList;

import objectDefinitions.CargoGenerator;
import objectDefinitions.CargoSpaceIndividual;
import databases.CargoData;

public class Evaluator {

	public double getUtopianMaxWeight(CargoSpaceIndividual aCargoSpace, CargoData cargoList) {

		return getCargoSpaceVolume(aCargoSpace) * getBestWeightPerUnit(cargoList);

	}

	public int getCargoSpaceVolume(CargoSpaceIndividual aCargoSpaceIndividual) {
		int[][][] space = aCargoSpaceIndividual.getCargoSpace();
		int y = space.length;
		int x = space[0].length;
		int z = space[0][0].length;
		return y * x * z;
	}

	public double getBestWeightPerUnit(CargoData cargoList) {
		int listSize = cargoList.getShapeList().size();
		double maxWeightPerUnit = 0;
		for (int i = 0; i < listSize; i++) {
			maxWeightPerUnit = Math.max(maxWeightPerUnit, cargoList.getShape(i).getWeightPerUnit());

		}

		return maxWeightPerUnit;
	}

	public int bestWeightPerUnitIndex(ArrayList<CargoGenerator> shapes) {
		CargoGenerator bestShape = shapes.get(0);
		int bestShapeIndex = 0;
		for (int i = 1; i < shapes.size(); i++) {
			if (shapes.get(i).getWeightPerUnit() > bestShape.getWeightPerUnit()) {
				bestShape = shapes.get(i);
				bestShapeIndex = i;
			}
		}
		return bestShapeIndex;
	}

	// public CargoSpaceIndividual findBestCargoSpace(PopulationCargoSpace aPopulation) {
	// int listSize = aPopulation.getPopulationSize();
	// CargoSpaceIndividual bestFilledSpace = aPopulation.getCargoSpaceIndividual(0);
	// for (int i = 0; i < listSize; i++) {
	// if (aPopulation.getCargoSpaceIndividual(i).getTotalWeight() > bestFilledSpace.getTotalWeight()) {
	// bestFilledSpace = aPopulation.getCargoSpaceIndividual(i);
	// }
	//
	// }
	// return bestFilledSpace;
	//
	// }

}
