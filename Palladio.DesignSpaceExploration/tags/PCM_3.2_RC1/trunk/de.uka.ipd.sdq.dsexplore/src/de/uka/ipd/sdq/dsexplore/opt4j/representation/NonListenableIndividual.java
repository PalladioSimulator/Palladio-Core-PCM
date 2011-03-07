package de.uka.ipd.sdq.dsexplore.opt4j.representation;


public class NonListenableIndividual extends DSEIndividual {
	
	public NonListenableIndividual(){
		
	}
	
	@Override
	public void setState(State state){
		this.state = state;
	}

}
