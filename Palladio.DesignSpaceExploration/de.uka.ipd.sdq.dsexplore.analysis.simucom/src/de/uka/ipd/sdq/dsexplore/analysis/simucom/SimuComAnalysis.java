package de.uka.ipd.sdq.dsexplore.analysis.simucom;

import javax.security.auth.login.Configuration;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuLaunchConfigurationDelegate;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;

public class SimuComAnalysis implements IAnalysis {

	public SimuComAnalysis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void analyse(PCMInstance pcmInstance, Configuration config) {
		pcmInstance.saveToFiles();
		System.out.println("Written pcm instance to files");
		
		//start SimuCom Workflow
		
		SimuLaunchConfigurationDelegate simuCom = new SimuLaunchConfigurationDelegate();
		//simuCom.hashCode();
		//simuCom.launch();

	}

}
