package loadingAlgorithms;

import java.util.ArrayList;

import basicTools.FillCargo;
import objectDefinitions.CargoSpaceIndividual;
import objectDefinitions.CargoGenerator;
import databases.Population;
import databases.ShapeData;
import databases.ShapesDefault;

public class FillCargoRandomly extends FillCargo {

	

	public FillCargoRandomly() {
		

	}
	
	public Population createRandomPopulation(int populationSize){
		Population aPopulation= new Population();
		for(int i=0; i<populationSize;i++){
			if(i%10000==0)
				System.out.println("population size: "+i);
			ShapesDefault shapes = new ShapesDefault("default");
			CargoSpaceIndividual cargoSpace = new CargoSpaceIndividual(5, 33, 8);
			
			fillCargoSpaceRandomly(cargoSpace,shapes);
			aPopulation.addCargoSpaceIndividual(cargoSpace);
		}
		
		return aPopulation;
	}

	public void fillCargoSpaceRandomly(CargoSpaceIndividual aCargoSpace,ShapeData shapeLoads) {

		ArrayList<CargoGenerator> ourShapes = shapeLoads.getShapeList();

		int[][][] space = aCargoSpace.getCargoSpace();

		for (int i = 0; i < space.length; i++) {
			for (int j = 0; j < space[0].length; j++) {
				for (int k = 0; k < space[0][0].length; k++) {
					if (space[i][j][k] == 0) {

						ArrayList<CargoGenerator> tempList = new ArrayList<CargoGenerator>(ourShapes);
						boolean somethingPlaced = false;
						// int counter=0;
						while (tempList.size() > 0 && somethingPlaced == false) {

							// counter ++;
							// System.out.println("trying"+ counter);

							int randomIndex = (int) (Math.random() * tempList.size());
							CargoGenerator shape = tempList.get(randomIndex);
							tempList.remove(randomIndex);

							if (collisionChecker(i, j, k, shape, aCargoSpace)) {
								shapePlacer(i, j, k, aCargoSpace, shape);
								aCargoSpace.setTotalWeight(aCargoSpace.getTotalWeight() + shape.getWeightTotal());
								ourShapes.get(randomIndex).setShapeIdentity(
										ourShapes.get(randomIndex).getShapeIdentity() * 10);
								// System.out.println(ourShapes.get(randomIndex).getShapeIdentity());
								somethingPlaced = true;
							}

						}
					}
				}
			}
		}
		aCargoSpace.setCargoSpace(space);
	}
}
