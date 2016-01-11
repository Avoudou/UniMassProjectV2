package graphicsUI;

import lombok.Getter;
import lombok.Setter;
import objectDefinitions.CargoSpaceIndividual;
import databases.CargoData;
import databases.ShapesDefault;

@Getter
@Setter
public class RunTimeData {

	private CargoSpaceIndividual aCargoSpace = new CargoSpaceIndividual(5, 33, 8);
	private CargoData cargoData = new ShapesDefault("weight");
	private int weightCargoA = 3;
	private int weightCargoB = 4;
	private int weightCargoC = 5;
	private boolean defaultCargoSet = false;
	private boolean pentominoCargoSet = false;
	private boolean customCargoSet = true;

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
		// TODO Auto-generated method stub
		return customCargoSet;
	}

	public CargoSpaceIndividual getACargoSpace() {
		
		return aCargoSpace;
	}

	public boolean isDefaultCargoSet() {
		// TODO Auto-generated method stub
		return defaultCargoSet;
	}

	public int getWeightCargoA() {
		// TODO Auto-generated method stub
		return weightCargoA;
	}

	public int getWeightCargoB() {
		// TODO Auto-generated method stub
		return weightCargoB;
	}

	public int getWeightCargoC() {
		// TODO Auto-generated method stub
		return weightCargoC;
	}

}
