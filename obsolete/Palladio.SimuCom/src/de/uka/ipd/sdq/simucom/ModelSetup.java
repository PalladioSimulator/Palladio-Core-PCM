package de.uka.ipd.sdq.simucom;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ocl.helper.HelperUtil;
import org.eclipse.emf.ocl.helper.IOCLHelper;
import org.eclipse.emf.ocl.helper.OCLParsingException;
import org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory;

import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.simucom.config.ConfigFileReaderFactory;
import de.uka.ipd.sdq.simucom.config.IConfig;
import desmoj.core.simulator.Model;

public class ModelSetup {
	
	protected Model m;
	protected IConfig myConfig = null;
	protected UsageModel myUsageModel = null;
	protected de.uka.ipd.sdq.pcm.system.System system = null;
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
		// setupOCLEnvironment();
	}

	private void setupOCLEnvironment() {
		
		IOCLHelper helper = HelperUtil.createOCLHelper(
				new EcoreEnvironmentFactory(EPackage.Registry.INSTANCE));
		helper.setContext(new Context());
		try {
			helper.define("CollectionParameter(name : String) : ParameterPackage::CollectionParameterUsage = self.derivedUsageContext.parameter->select(p|p.parameter_ParameterUsage.parameterName=name)->first().oclAsType(ParameterPackage::CollectionParameterUsage)");
			helper.define("PrimitiveParameter(name : String) : ParameterPackage::ParameterUsage = self.derivedUsageContext.parameter->select(p|p.parameter_ParameterUsage.parameterName=name)->first().oclAsType(ParameterPackage::ParameterUsage)");
		} catch (OCLParsingException e) {
			System.out.println("OCL definition failed: "+e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}

		helper.setContext(ParameterFactory.eINSTANCE.createCollectionParameterUsage());
		try {
			helper.define("collectionCharacterisationValue(type : ParameterPackage::CollectionParameterCharacterisationType) : OclAny = self.characterisation_CollectionParameterUsage->select(c|c.type = type)->first().value_CollectionParameterCharacterisation");
		} catch (OCLParsingException e) {
			System.out.println("OCL definition failed: "+e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}

		helper.setContext(ParameterFactory.eINSTANCE.createParameterUsage());
		try {
			helper.define("primitiveCharacterisationValue(type : ParameterPackage::PrimitiveParameterCharacterisationType) : OclAny = self.parameterCharacterisation_ParameterUsage->select(c|c.type = type)->first().value_PrimitiveParameterCharacterisation");
		} catch (OCLParsingException e) {
			System.out.println("OCL definition failed: "+e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<UsageScenario> getScenarios()
	{
		return new ArrayList<UsageScenario>(myUsageModel.getUsageScenario_UsageModel());
	}
	
	public de.uka.ipd.sdq.pcm.system.System getSystem()
	{
		return system;
	}
	
	public ResourceEnvironment getResourceEnvironment()
	{
		return resourceEnv;
	}
}

