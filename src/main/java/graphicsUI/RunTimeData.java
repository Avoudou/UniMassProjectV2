package graphicsUI;

import lombok.Getter;
import lombok.Setter;
import objectDefinitions.CargoSpaceIndividual;
import databases.CargoData;
import databases.ShapesDefault;
@Getter
@Setter
public class RunTimeData {
	
	private CargoSpaceIndividual aCargoSpace;
	private CargoData cargoData = new ShapesDefault("weight");
	

}
