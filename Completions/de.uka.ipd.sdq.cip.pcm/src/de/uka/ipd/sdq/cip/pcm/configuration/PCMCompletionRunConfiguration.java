package de.uka.ipd.sdq.cip.pcm.configuration;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

public class PCMCompletionRunConfiguration extends CompletionConfiguration {

	public static final String[] MetaModelPath = new String[]{
		"http://www.eclipse.org/emf/2002/Ecore",
		"platform:/plugin/de.uka.ipd.sdq.pcm/model/pcm.ecore",
		"platform:/plugin/de.uka.ipd.sdq.identifier/model/identifier.ecore",
		"platform:/plugin/de.uka.ipd.sdq.units/model/Units.ecore",
		"platform:/plugin/de.uka.ipd.sdq.probfunction/model/ProbabilityFunction.ecore",
		"platform:/plugin/de.uka.ipd.sdq.stoex/model/stoex.ecore",
		"platform:/plugin/de.uka.ipd.sdq.completions/model/completions.ecore",
		
	};
	
	ArrayList<Object> models = new ArrayList<Object>();
	
	public PCMCompletionRunConfiguration(AbstractCodeGenerationWorkflowRunConfiguration pcmconfig, Map<String, Object> configuration) {
		super(configuration);
		setInputPartitionName(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		setProjectID(pcmconfig.getPluginID());
		// TODO: SplitJob fails the pcm run when trying to manipulate the pcm configuration during the run
//		setAfterJobs(new IJob[]{new SplitJob(this,pcmconfig), new ValidatePCMModelsJob(pcmconfig),new LoadPCMModelsIntoBlackboardJob(pcmconfig)});
		setMetaModels(MetaModelPath);
	}
	
	private void setMetaModels(String[] metaModels) {
		//ArrayList<EPackage> packages = new ArrayList<EPackage>();
		ResourceSet rset = new ResourceSetImpl();
		for(String metamodel : metaModels) {
			if(metamodel.startsWith("http:")){
				EPackage  p = EPackage.Registry.INSTANCE.getEPackage(metamodel);
				if(p != null)
					models.add(p);
			}
			else
				rset.getResource(URI.createURI(metamodel), true);
		}
		EcoreUtil.resolveAll(rset);
		
		TreeIterator<?> objects = rset.getAllContents();
		
		while(objects.hasNext())
				models.add(objects.next());
		
		setMetaModels(models);
		
		
	}
}
