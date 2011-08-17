package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.operator.Apply;
import org.opt4j.operator.neighbor.Neighbor;
import org.opt4j.operator.normalize.NormalizeDouble;
import org.opt4j.common.random.Rand;

import com.google.inject.Singleton;

import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;

@Singleton
@Apply(DesignDecisionGenotype.class)
public class DSENeighbor implements Neighbor<DesignDecisionGenotype> {
	
	public DSENeighbor(NormalizeDouble normalize, Rand random) {
		System.out.print("using DSENeighbor");
	}

	@Override
	public void neighbor(DesignDecisionGenotype genotype) {

		
		/*DesignDecisionGenotype vector = (DesignDecisionGenotype) genotype;

		int size = vector.size();

		int i = random.nextInt(size);
		
		

		if (Opt4JStarter.getProblem().getBounds().isInteger(i)){
			int currentValue = vector.get(i).intValue();
			
			//TODO: handle enums right
			
			if (Opt4JStarter.getProblem().getBounds().isEnum(i)){
				//handle enum: all are neighbors. Lower bound is 0, but maybe I change it later, so this is fool proof. 
				int choice = random.nextInt((int)(Opt4JStarter.getProblem().getBounds().getUpperBound(i) - Opt4JStarter.getProblem().getBounds().getLowerBound(i)));
				//shift one up if the value is larger than the current choice, as the current is no neighbor of itself and the upper bound cannot be produced by nextInt
				if (choice > currentValue){
					choice ++;
				}
				vector.set(i, new Double(choice+ Opt4JStarter.getProblem().getBounds().getLowerBound(i)));
				
			} 
			//handle ordered integer 
			else if (Opt4JStarter.getProblem().getBounds().getLowerBound(i) == currentValue){
				vector.set(i, new Double(currentValue + 1));
			} else if (Opt4JStarter.getProblem().getBounds().getUpperBound(i) == currentValue){
				vector.set(i, new Double(currentValue - 1));
			} else {
				//decide whether going up or down
				boolean add = (random.nextInt(2) != 0);
				if (add){
					vector.set(i, new Double(currentValue + 1));
				} else {
					vector.set(i, new Double(currentValue - 1));
				}
			}
			
			
		} else {
			//if double value, use the normal way
			//copied from superclass NeighborDouble
			double value = vector.get(i) + random.nextDouble() * 0.1 - 0.05;
			vector.set(i, value);

			normalize.normalize(vector);
		}
	*/
	throw new UnsupportedOperationException("DSE Neighbour operator has not been implemented yet.");	

	}

}
