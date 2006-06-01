package de.uka.ipd.sdq.simucom;

import java.util.ArrayList;

import PalladioCM.ResourceEnvironmentPackage.ResourceEnvironment;
import UsageModelPackage.UsageModel;
import UsageModelPackage.UsageScenario;
import de.uka.ipd.sdq.simucom.config.ConfigFileReaderFactory;
import de.uka.ipd.sdq.simucom.config.IConfig;
import desmoj.core.simulator.Model;

public class ModelSetup {
	
	protected Model m;
	protected IConfig myConfig = null;
	protected UsageModel myUsageModel = null;
	protected SystemPackage.System system = null;
	protected ResourceEnvironment resourceEnv = null;
	
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
			myUsageModel = ModelLoader.loadSimuComUsageModel(myConfig.getSimuComUsageModel());
			system = ModelLoader.loadSimuComSystem(myConfig.getSimuComSystem());
			resourceEnv = ModelLoader.loadSimuComResourceEnvironment(myConfig.getSimuComResourceEnvironment());
		} catch (Exception e){
			System.out.println("Error while loading simulation model: "+e.getLocalizedMessage());
			System.exit(-1);
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<UsageScenario> getScenarios()
	{
		return new ArrayList<UsageScenario>(myUsageModel.getUsageScenario_UsageModel());
	}
	
	public SystemPackage.System getSystem()
	{
		return system;
	}
	
	public ResourceEnvironment getResourceEnvironment()
	{
		return resourceEnv;
	}
}

