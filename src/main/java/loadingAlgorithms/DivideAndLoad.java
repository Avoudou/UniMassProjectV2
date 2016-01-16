package loadingAlgorithms;

import graphicsUI.RunTimeData;
import graphicsUI.UIWindow;
import objectDefinitions.CargoSpaceIndividual;
import basicTools.FillCargo;
import databases.CargoData;

public class DivideAndLoad extends FillCargo {

	private CargoData cargoData;
	private CargoSpaceIndividual initialCargoSpace;
	private int fixedDim = 4;
	private FillCargoRandomly randomLoader;
	private RunTimeData runtimeData;
	private UIWindow aWindow;

	public DivideAndLoad(RunTimeData runtimeData, UIWindow aWindow) {
		this.runtimeData = runtimeData;
		this.aWindow = aWindow;
		this.cargoData = runtimeData.getCargoData();
		this.initialCargoSpace = runtimeData.getACargoSpace();

	}

	public CargoSpaceIndividual dividerLoader() {
		return null;
	}

	private CargoSpaceIndividual getCargoSubspace() {
		int y = initialCargoSpace.getCargoSpace().length;
		int x = initialCargoSpace.getCargoSpace().length;
		int z = initialCargoSpace.getCargoSpace().length;

		int firstSmallDim = Math.min(y, x);
		int secondSmallDim = Math.min(x, z);

		CargoSpaceIndividual smallSpace = new CargoSpaceIndividual(firstSmallDim, fixedDim, secondSmallDim);

		return smallSpace;
	}

}
