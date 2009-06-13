package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.core.Individual;

public class NonListenableIndividual extends Individual {
	
	public NonListenableIndividual(){
		
	}
	
	@Override
	public void setState(State state){
		this.state = state;
	}

}
