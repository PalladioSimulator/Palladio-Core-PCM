package de.uka.ipd.sdq.dsexplore.newcandidates.configurecomponents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.newcandidates.INewCandidates;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.system.System;

public class ConfigureComponents implements INewCandidates {

	/** Logger for log4j. */
	protected static Logger logger = Logger
			.getLogger("de.uka.ipd.sdq.dsexplore");

	public ConfigureComponents() {
	}

	@Override
	public List<PCMInstance> generateNewCandidates(
			IAnalysisResult currentSolution) throws CoreException {

		logger.debug("ConfigureComponents called");

		//try {

			List<PCMInstance> resultingPCMInstances = new ArrayList<PCMInstance>();

			PCMInstance currentPCMInstance = currentSolution.getPCMInstance();
			System s = currentPCMInstance.getSystem();

			List<AssemblyContext> assemblyContexts = getChildAssemblyContexts(s);
			
			for (Iterator<AssemblyContext> iterator = assemblyContexts
					.iterator(); iterator.hasNext();) {
				AssemblyContext assemblyContext = iterator.next();
				
			}
			
			String featureConfig = currentPCMInstance.getLaunchConfiguration().getAttribute(ConstantsContainer.FEATURE_CONFIG, "");
			Configuration conf = (Configuration)PCMInstance.loadFromXMIFile(featureConfig);
			
			logger.debug(conf.getName());
			
			//XXX: assuming here that there is only a default config
			Feature referencedFeature = ((Feature)conf.getDefaultConfig().getReferencedObject());
			
			logger.debug(referencedFeature.getName());
			
			//Get all options of this feature

			
			
			
			
			//TODO: Feature configs cannot be opened with the EMF editor, because the id cannot be found (FeatureNotFoundException).  

			return resultingPCMInstances;

			/*} catch (AnalysisFailedException e) {
			e.printStackTrace();
			Status st = new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", e
					.getMessage());
			throw new CoreException(st);
		}*/
	}

	/**
	 * Gets all {@link AssemblyContext}s included in this
	 * {@link ComposedStructure} by recursively entering in included
	 * {@link ComposedStructure}. Thus, creates the transitive closure of all
	 * included {@link AssemblyContext}s.
	 * 
	 * @param a
	 *            A {@link ComposedStructure} to get all included
	 *            {@link AssemblyContext}s from
	 * @return
	 */
	private List<AssemblyContext> getChildAssemblyContexts(ComposedStructure s) {
		List<AssemblyContext> results = s
				.getChildComponentContexts_ComposedStructure();

		// Check whether the encapsulated components are again composites, if
		// yes, call this method on them recursively
		for (Iterator<AssemblyContext> iterator = results.iterator(); iterator
				.hasNext();) {
			AssemblyContext assemblyContext = iterator.next();
			ProvidesComponentType encapsulated = assemblyContext
					.getEncapsulatedComponent_ChildComponentContext();
			if (encapsulated instanceof ComposedStructure) {
				results
						.addAll(getChildAssemblyContexts((ComposedStructure) encapsulated));
			}
		}
		return results;
	}

}
