package databases;

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

	public CargoSpaceIndividual(int xElemUnits, int yElemUnits, int zElemUnits) {
		this.cargoSpace = new int[xElemUnits][yElemUnits][zElemUnits];
	}

}
