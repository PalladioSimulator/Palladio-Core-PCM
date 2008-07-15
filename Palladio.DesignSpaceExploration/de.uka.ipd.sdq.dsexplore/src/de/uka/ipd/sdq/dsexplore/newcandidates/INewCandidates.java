package de.uka.ipd.sdq.dsexplore.newcandidates;

import java.util.List;

import de.uka.ipd.sdq.dsexplore.PCMInstance;

public interface INewCandidates {

	public abstract List<PCMInstance> generateNewCandidates(PCMInstance currentSolution);  
}
