package de.uka.ipd.sdq.simucom;

import java.util.Vector;

import UsageModelPackage.UsageModel;
import UsageModelPackage.UsageScenario;

import de.uka.ipd.sdq.simucom.config.ConfigFileReaderFactory;
import de.uka.ipd.sdq.simucom.config.IConfig;
import desmoj.core.simulator.Model;

public class ModelSetup {
	
	protected Model m;
	protected IConfig myConfig = null;
	protected UsageModel myUsageModel = null;;
	
	public ModelSetup(Model m, String configFileName) {
		this.m = m;
		try {
			myConfig = new ConfigFileReaderFactory(configFileName).getConfig();
		} catch (Exception e) {
			System.out.println("Error reading config file "+e.getLocalizedMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		try{
			myUsageModel = ModelLoader.loadSimuComModel(myConfig.getSimuComModelURI());
		} catch (Exception e){
			System.out.println("Error while loading simulation model: "+e.getLocalizedMessage());
			System.exit(-1);
		}
	}
	
	public Vector<UsageScenario> getScenarios()
	{
		return new Vector<UsageScenario>(myUsageModel.getUsageScenario_UsageModel());
	}
}

