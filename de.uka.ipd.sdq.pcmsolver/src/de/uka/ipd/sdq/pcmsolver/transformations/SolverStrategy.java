package de.uka.ipd.sdq.pcmsolver.transformations;

import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

public interface SolverStrategy {

	void transform(PCMInstance model);
	
	void solve();

	void loadTransformedModel(String fileName);
	
	void storeTransformedModel(String fileName);
}
