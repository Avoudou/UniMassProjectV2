package basicTools;

import java.util.ArrayList;

import objectDefinitions.CargoGenerator;

public class CargoSolidRot {

	public static ArrayList<CargoGenerator> generateSolidCargoRot(CargoGenerator aCargo) {
		ArrayList<CargoGenerator> rotationList = new ArrayList<CargoGenerator>();
		int y = aCargo.getShape().length;
		int x = aCargo.getShape()[0].length;
		int z = aCargo.getShape()[0][0].length;

		if (x == y && z == x && y == z) {
			CargoGenerator rot1 = new CargoGenerator(y, x, z, aCargo.getShapeIdentity());
			rot1.setWeightTotal(aCargo.getWeightTotal());
			rotationList.add(rot1);
		} else if (x == y || z == x || y == z) {
			int dimDouble = 0;
			int dimSingle = 0;
			if (x == y) {
				dimDouble = x;
				dimSingle = z;
			}
			if (z == x) {
				dimDouble = x;
				dimSingle = y;
			}
			if (y == z) {
				dimDouble = y;
				dimSingle = x;
			}
			CargoGenerator rot1 = new CargoGenerator(dimSingle, dimDouble, dimDouble, aCargo.getShapeIdentity());
			rot1.setWeightTotal(aCargo.getWeightTotal());
			rotationList.add(rot1);
			CargoGenerator rot2 = new CargoGenerator(dimDouble, dimSingle, dimDouble, aCargo.getShapeIdentity());
			rot2.setWeightTotal(aCargo.getWeightTotal());
			rotationList.add(rot2);
			CargoGenerator rot3 = new CargoGenerator(dimDouble, dimDouble, dimSingle, aCargo.getShapeIdentity());
			rot3.setWeightTotal(aCargo.getWeightTotal());
			rotationList.add(rot3);

		} else {

			CargoGenerator rot1 = new CargoGenerator(y, x, z, aCargo.getShapeIdentity());
			rot1.setWeightTotal(aCargo.getWeightTotal());
			rotationList.add(rot1);
			CargoGenerator rot2 = new CargoGenerator(y, z, x, aCargo.getShapeIdentity());
			rot2.setWeightTotal(aCargo.getWeightTotal());
			rotationList.add(rot2);
			CargoGenerator rot3 = new CargoGenerator(x, y, z, aCargo.getShapeIdentity());
			rot3.setWeightTotal(aCargo.getWeightTotal());
			rotationList.add(rot3);
			CargoGenerator rot4 = new CargoGenerator(x, z, y, aCargo.getShapeIdentity());
			rot4.setWeightTotal(aCargo.getWeightTotal());
			rotationList.add(rot4);
			CargoGenerator rot5 = new CargoGenerator(z, y, x, aCargo.getShapeIdentity());
			rot5.setWeightTotal(aCargo.getWeightTotal());
			rotationList.add(rot5);
			CargoGenerator rot6 = new CargoGenerator(z, x, y, aCargo.getShapeIdentity());
			rot6.setWeightTotal(aCargo.getWeightTotal());
			rotationList.add(rot6);
		}

		return rotationList;

	}

}