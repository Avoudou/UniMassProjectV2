package databases;

import java.util.ArrayList;

import objectDefinitions.CargoSpaceIndividual;

public class Population {

	private ArrayList<CargoSpaceIndividual> population= new ArrayList<CargoSpaceIndividual>();
	
	public CargoSpaceIndividual getCargoSpaceIndividual(int index){
		return population.get(index);
	}
	public void addCargoSpaceIndividual(CargoSpaceIndividual aCargoSpace){
		population.add(aCargoSpace);
		
	}
	



}
