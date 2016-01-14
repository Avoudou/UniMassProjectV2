package graphicsUI;

import lombok.Getter;
import lombok.Setter;
import objectDefinitions.CargoSpaceIndividual;
import databases.CargoData;
import databases.ShapesPentomino3D;

@Getter
@Setter
public class RunTimeData {

	private String outputInfo = "test";

	private CargoSpaceIndividual aCargoSpace = new CargoSpaceIndividual(5, 33, 8);

	private CargoData cargoData = new ShapesPentomino3D();
	private String cargoSetUsed = "pentomino set";

	private double lastAlgorithmRuntime;

	private int weightCargoA = 3;
	private int weightCargoB = 4;
	private int weightCargoC = 5;

	private boolean defaultCargoSet = false;
	private boolean pentominoCargoSet = false;
	private boolean customCargoSet = true;
	private boolean weightbuttonadded = false;

	public void setDefaultCargoMenu(boolean aBoolean) {
		defaultCargoSet = aBoolean;
	}

	public void setPentominoCargoMenu(boolean aBoolean) {
		pentominoCargoSet = aBoolean;
	}

	public void setCustomCargoMenu(boolean aBoolean) {
		customCargoSet = aBoolean;
	}

	public CargoData getCargoData() {

		return cargoData;
	}

	public void setACargoSpace(CargoSpaceIndividual cargoSpaceIndividual) {
		aCargoSpace = cargoSpaceIndividual;

	}

	public boolean isCustomCargoSet() {

		return customCargoSet;
	}

	public CargoSpaceIndividual getACargoSpace() {

		return aCargoSpace;
	}

	public boolean isDefaultCargoSet() {

		return defaultCargoSet;
	}

	public int getWeightCargoA() {

		return weightCargoA;
	}

	public int getWeightCargoB() {

		return weightCargoB;
	}

	public int getWeightCargoC() {

		return weightCargoC;
	}

	public String getOutputInfo() {
		// System.out.println(outputInfo);
		return outputInfo;

	}

	public void setOutputInfo(String outString) {
		outputInfo = outString;
	}

	public boolean getIfWeightsButton() {
		// System.out.println(outputInfo);
		return weightbuttonadded;

	}

	public void setIfWeightsButton(Boolean aboolean) {
		weightbuttonadded = aboolean;
	}

	public void setCargoSetName(String whatSet) {
		this.cargoSetUsed = whatSet;
	}

	public String getCargoSetName() {
		return cargoSetUsed;
	}
}
