package de.uka.ipd.sdq.dsexplore.analysis.simucom;

import javax.security.auth.login.Configuration;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuLaunchConfigurationDelegate;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;

public class SimuComAnalysis implements IAnalysis {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	public SimuComAnalysis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void analyse(PCMInstance pcmInstance, Configuration config) {
		pcmInstance.saveToFiles();
		logger.debug("Written pcm instance to files");
		
		//start SimuCom Workflow
		
		SimuLaunchConfigurationDelegate simuCom = new SimuLaunchConfigurationDelegate();
		//simuCom.hashCode();
		//simuCom.launch();

	}

}
