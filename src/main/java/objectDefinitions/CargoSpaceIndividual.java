package objectDefinitions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**Instances of this   class represent  a 3D cargo space  consisting of  a number of basic elements(cubes) specified on the constructor for each dimension*/
public class CargoSpaceIndividual {
	/**Representation of the  cargo space as 3d Array,0 for empty spaces  Integer values for occupied places */
	@Getter
	private int[][][] cargoSpace;
	@Getter
	@Setter
	private double fitness;
	@Getter
	@Setter
	private int totalWeight;

	public CargoSpaceIndividual(int yElemUnits, int xElemUnits, int zElemUnits) {
		this.cargoSpace = new int[yElemUnits][xElemUnits][zElemUnits];
	}
	
	public int[][][] getCargoSpace(){
		return cargoSpace;
	}

	public void setCargoSpace(int[][][] space) {
		cargoSpace= space;
		
	}
	

}
