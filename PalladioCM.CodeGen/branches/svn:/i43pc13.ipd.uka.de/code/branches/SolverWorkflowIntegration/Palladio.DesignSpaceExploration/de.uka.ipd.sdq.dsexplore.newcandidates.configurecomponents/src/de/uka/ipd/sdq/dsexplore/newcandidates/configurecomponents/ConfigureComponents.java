package de.uka.ipd.sdq.dsexplore.newcandidates.configurecomponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.newcandidates.INewCandidates;
import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featuremodel.AttributeTypes;
import de.uka.ipd.sdq.featuremodel.ChildRelation;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.Simple;
import de.uka.ipd.sdq.featuremodel.impl.featuremodelFactoryImpl;
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
			
			//XXX: assuming here that there is only a default config (better make that override or write new overrides)
			Feature referencedFeature = ((Feature)conf.getDefaultConfig().getReferencedObject());
			
			logger.debug(referencedFeature.getName());
			
			//XXX assuming that we have a flat feature hierarchy: One Generation of simple, mandatory children. 
			//    They themselves can have XOR and simple children, but no deeper.
			//XXX Also assuming that there is no default that can be overridden. To be more specific: Nodes are either set or unset, not override.
			//XXX Also assuming that each first level feature has options to choose from and not just a mandatory child, for example. 
			
			
			ChildRelation childFeature = referencedFeature.getChildrelation();
	
			//go one hierachy level deeper
			if (childFeature instanceof Simple) {
				Simple childSimpleFeature = (Simple) childFeature;
				final List<Feature> featuresToChooseFrom = childSimpleFeature.getMandatoryChildren();
				
				//TODO this is just initial
				if (featuresToChooseFrom.size() > 0){
					Feature firstLevelFeature = featuresToChooseFrom.get((int)Math.random()*featuresToChooseFrom.size());
					logger.debug("Changing feature "+firstLevelFeature.getName());
					childFeature = firstLevelFeature.getChildrelation();
				} else {
					logger.error("Preliminary assumption failed: Feature "+referencedFeature.getName()+" must have mandatory children");
					throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "Preliminary assumption failed: Feature "+referencedFeature.getName()+" must have mandatory children", null));
				}
				
			} else {
				logger.error("Preliminary assumption failed: First child relation in feature model must be Simple");
				throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "Preliminary assumption failed: First child relation in feature model must be Simple", null));
			}
			
			Map<Feature,ConfigNode> mapping = getFeatureToNodeMapping(conf.getDefaultConfig()); 
						
			if (childFeature instanceof FeatureGroup){
				FeatureGroup groupChild = (FeatureGroup) childFeature;
				logger.debug("Found a feature group");
				
				//Assume XOR
				
				List<Feature> features = groupChild.getChildren();
				
				//Get the currently selected one
				List<ConfigNode> configNodes = conf.getDefaultConfig().getConfignode();
				
				List<ConfigNode> unselectedNodes = new ArrayList<ConfigNode>();
				ConfigNode selectedNode = null;
				
				
				for (Iterator<ConfigNode> iterator = configNodes.iterator(); iterator
						.hasNext();) {
					ConfigNode configNode = iterator.next();

					// only look at configs for our current features.
					if (features.contains(configNode.getOrigin())){
						if (!configNode.getConfigState().equals(ConfigState.SELECTED)){
							unselectedNodes.add(configNode);
							//must set explicitly to eliminated to avoid SELECTED in the default.  
							configNode.setConfigState(ConfigState.ELIMINATED);
						} else {
							logger.debug("Found selected feature "+configNode.getOrigin().getName());
							//Unset the selected node, if any
							selectedNode = configNode;
							selectedNode.setConfigState(ConfigState.ELIMINATED);
						}
						
					}
				}
				
				//Randomly pick one feature to select from the previously unselected
				ConfigNode newChoice = unselectedNodes.get((int)Math.random()*unselectedNodes.size());
				newChoice.setConfigState(ConfigState.SELECTED);
				
				logger.debug("Selected feature "+newChoice.getOrigin().getName()+".");
			
			}
			else if (childFeature instanceof Simple) {
				Simple simpleChild = (Simple) childFeature;
				logger.debug("Found a simple feature relation");
				final List <Feature> simpleChildren = simpleChild.getOptionalChildren();
				
				//pick any optional one and change its state
				Feature chosenFeature = simpleChildren.get((int)Math.random()*simpleChildren.size());
				
				ConfigNode selectedNode = mapping.get(chosenFeature);
				
				if (selectedNode.getConfigState().equals(ConfigState.SELECTED)){
					selectedNode.setConfigState(ConfigState.ELIMINATED);
					logger.debug("Set optional feature "+selectedNode+" as ELIMINATED");
				} else { 
					selectedNode.setConfigState(ConfigState.SELECTED);
					logger.debug("Set optional feature "+selectedNode+" as SELECTED");
				}

			}
			
			//TODO: Feature configs cannot be opened with the EMF editor, because the id cannot be found (FeatureNotFoundException).  

			return resultingPCMInstances;

			/*} catch (AnalysisFailedException e) {
			e.printStackTrace();
			Status st = new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", e
					.getMessage());
			throw new CoreException(st);
		}*/
	}

	private Map<Feature, ConfigNode> getFeatureToNodeMapping(
			FeatureConfig config) {
		Map<Feature, ConfigNode> result =  new HashMap<Feature,ConfigNode>();
		
		List<ConfigNode> list = config.getConfignode();
		for (Iterator<ConfigNode> iterator = list.iterator(); iterator
				.hasNext();) {
			ConfigNode configNode = iterator.next();
			result.put(configNode.getOrigin(), configNode);
		}

		
		return null;
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
