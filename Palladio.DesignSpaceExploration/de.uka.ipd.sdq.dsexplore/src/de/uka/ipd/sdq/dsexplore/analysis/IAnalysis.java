package de.uka.ipd.sdq.dsexplore.analysis;

import javax.security.auth.login.Configuration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;

public interface IAnalysis {

	
	public abstract void analyse(PCMInstance pcmInstance, Configuration config);
}
