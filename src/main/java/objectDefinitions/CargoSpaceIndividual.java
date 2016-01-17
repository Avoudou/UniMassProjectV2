package objectDefinitions;

/**
 * Instances of this class represent a 3D cargo space consisting of a number of basic elements(cubes) specified on the
 * constructor for each dimension
 */
public class CargoSpaceIndividual {
	/** Representation of the cargo space as 3d Array,0 for empty spaces Integer values for occupied places */

	private int[][][] cargoSpace;
	private int totalWeight;
	private double weightPerVolume;

	public CargoSpaceIndividual(int yElemUnits, int xElemUnits, int zElemUnits) {
		this.cargoSpace = new int[yElemUnits][xElemUnits][zElemUnits];
	}

	public int[][][] getCargoSpace() {
		return cargoSpace;
	}

	public void setCargoSpace(int[][][] space) {
		cargoSpace = space;

	}

	public int getTotalWeight() {

		return totalWeight;
	}

	public void setTotalWeight(int i) {
		totalWeight = i;
		weightPerVolume = (1.0000 * totalWeight) / (cargoSpace.length * cargoSpace[0].length * cargoSpace[0][0].length);
	}

	public double getWeightPerVolume() {
		return weightPerVolume;
	}

}
