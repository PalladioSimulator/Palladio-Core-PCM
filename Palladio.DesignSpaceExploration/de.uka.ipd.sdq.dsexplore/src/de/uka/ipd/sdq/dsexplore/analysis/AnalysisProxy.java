package de.uka.ipd.sdq.dsexplore.analysis;

import javax.security.auth.login.Configuration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.helper.ExtensionHelper;

public class AnalysisProxy implements IAnalysis {

	@Override
	public void analyse(PCMInstance pcmInstance, Configuration config) {
		IAnalysis ana = (IAnalysis)ExtensionHelper.loadExtension("de.uka.ipd.sdq.dsexplore.analysis");
		
		ana.analyse(pcmInstance, null);

	}

}
