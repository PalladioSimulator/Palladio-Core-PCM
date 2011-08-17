package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import de.uka.ipd.sdq.pcm.designdecision.Problem;


public class NonListenableIndividual extends DSEIndividual {
	
	public NonListenableIndividual(Problem problem){
		super(problem);
	}
	
	@Override
	public void setState(State state){
		this.state = state;
	}

}
