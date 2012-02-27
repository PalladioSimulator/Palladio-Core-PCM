package de.uka.ipd.sdq.dsexplore.launch;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisQualityAttributeDeclaration;
import de.uka.ipd.sdq.dsexplore.helper.ExtensionHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer.QualityAttribute;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EvaluationAspectWithContext;
import de.uka.ipd.sdq.dsexplore.qml.pcm.reader.PCMDeclarationsReader;
import de.uka.ipd.sdq.dsexplore.qml.reader.QMLDimensionReader;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;

/**
 * The QMLManager component can be queried for getting the currently activated QML criteria. 
 * Based on the activated criteria, it de-/activates evaluators in the launch configuration 
 * tabs.
 *
 * @author martens, noorshams
 *
 */
 /*   
 * Probably it will be useful to create a default contract (not only contract 
 * type and declaration) that optimises performance, reliability and costs that 
 * can be referenced as a default. Put that one in PCMMODELS 
 * (cf. glassfish.repository, it is in 
 * https://sdqweb.ipd.uka.de/svn/code/Palladio.EMFComponentModel/trunk/de.uka.ipd.sdq.pcm.resources/defaultModels) 
 * ->
 * noorshams: Not possible since you need one profile for *every* UsageModel. See
 * https://sdqweb.ipd.uka.de/svn/code/Palladio.DesignSpaceExploration/trunk/de.uka.ipd.sdq.dsexplore.constrainthandling.qmldeclarations
 * for examples and default declarations
 */ 
 
public class QMLManager {
	
	protected List<DSEAnalysisMethodTab> tabs = new ArrayList<DSEAnalysisMethodTab>(); 
	
	/**
	 * Indicates if {@code processQMLFile(String, String)} was successful.
	 */
	protected boolean qmlLoaded = false;
	protected String diagnosis = null;
	protected PCMDeclarationsReader pcmReader;
	protected QMLDimensionReader dimensionReader = new QMLDimensionReader();
	protected String currentQMLPath = "";
	protected String currentUsageModelPath = "";
	
	
	protected DSEAnalysisMethodTab costTab = null;
	protected DSEAnalysisMethodTab pofodTab = null;
	protected DSEAnalysisMethodTab performanceTab = null;
	
	//Set to ensure uniqueness of entries
	protected Set<EvaluationAspectWithContext> objectives = Collections.synchronizedSet(new HashSet<EvaluationAspectWithContext>(4));
	
	public List<EvaluationAspectWithContext> getActivatedObjectives(){
		List<EvaluationAspectWithContext> returnList = new ArrayList<EvaluationAspectWithContext>(this.objectives);
		return returnList;
	}
	
	public boolean hasActivatedObjectives(){
		return (this.objectives.size() > 0);
	}

	/**
	 * Add tabs to be de-/activates here.
	 * 
	 * @param tabs
	 */
	public void addTabs(DSEAnalysisMethodTab... tabs) {
		for(DSEAnalysisMethodTab tab : tabs) {
			this.tabs.add(tab); 
			if(tab.getId().equals(QualityAttribute.PERFORMANCE_QUALITY.getName())) {
				performanceTab = tab;
			} else if(tab.getId().equals(QualityAttribute.COST_QUALITY.getName())) {
				costTab = tab;
			} else if(tab.getId().equals(QualityAttribute.RELIABILITY_QUALITY.getName())) {
				pofodTab = tab;
			}
		}
	}
	
	/**
	 * Reads QML definitions and activates or deactivates extensions in the tabs
	 * based on the definitions. If processing is successful, 
	 * {@code isQMLLoaded()} returns {@code true}. 
	 * 
	 * @param qmlFilePath
	 * @param usageModelFilePath
	 */
	public void processQMLFile(String qmlFilePath, String usageModelFilePath){
		
		if(currentQMLPath.equals(qmlFilePath) && currentUsageModelPath.equals(usageModelFilePath)) {
			return;
		}
		
		currentQMLPath = qmlFilePath;
		currentUsageModelPath = usageModelFilePath;
		
		qmlLoaded = false;
		objectives.clear();
		deactivateAllTabs();
		
		ResourceSet rs = new ResourceSetImpl();
		if(!fileExists(usageModelFilePath)) {
			diagnosis = "Could not load usage model! Please check the path!";
			return;
		}
		URI uri;
		if (URI.createURI(usageModelFilePath).isPlatform() || usageModelFilePath.indexOf("://") >= 0) { 
			uri = URI.createURI(usageModelFilePath);
		} else {
			uri = URI.createFileURI(usageModelFilePath);
		}
		Resource r = (Resource) rs.getResource(uri, true);
		List<?> contents = r.getContents();
		UsageModel usageModel = null;
		//Supposed to be exactly one element
		for (Iterator<?> iterator = contents.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if(object instanceof UsageModel) {
				usageModel = (UsageModel) object;
				break;
			}			
		}
		if(usageModel == null){
			diagnosis = "Could not load usage model! Please check the UsageModel file!";
			
			return;
		}
		
		if(!fileExists(qmlFilePath) || 
				!qmlFilePath.endsWith(DSEConstantsContainer.QML_DEFINITION_EXTENSION.substring(
						DSEConstantsContainer.QML_DEFINITION_EXTENSION.lastIndexOf('.'), 
						DSEConstantsContainer.QML_DEFINITION_EXTENSION.length()))) {
			diagnosis = "Could not load qml definition model! Please check the path!";
			return;
		}
		
		pcmReader = new PCMDeclarationsReader(qmlFilePath);		
		List<IExtension> exts = new ArrayList<IExtension>();
		int init;
		
		//Activate or deactivate Evalutators depending on the qml definitions
		//COST 
		{
			List<EvaluationAspectWithContext> costObjectives = pcmReader.getDimensionObjectiveContextsForUsageModel(usageModel, dimensionReader.getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_TOTAL_COST_DEFINITION_PATH).getId());
			costObjectives.addAll(pcmReader.getDimensionObjectiveContextsForUsageModel(usageModel, dimensionReader.getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_INITIAL_COST_DEFINITION_PATH).getId()));
			costObjectives.addAll(pcmReader.getDimensionObjectiveContextsForUsageModel(usageModel, dimensionReader.getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_OPERATING_COST_DEFINITION_PATH).getId()));
			List<EvaluationAspectWithContext> costConstraints = pcmReader.getDimensionConstraintContextsForUsageModel(usageModel, dimensionReader.getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_TOTAL_COST_DEFINITION_PATH).getId());
			costConstraints.addAll(pcmReader.getDimensionConstraintContextsForUsageModel(usageModel, dimensionReader.getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_INITIAL_COST_DEFINITION_PATH).getId()));
			costConstraints.addAll(pcmReader.getDimensionConstraintContextsForUsageModel(usageModel, dimensionReader.getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_OPERATING_COST_DEFINITION_PATH).getId()));
			List<EvaluationAspectWithContext> costCriteria = new ArrayList<EvaluationAspectWithContext>();
			costCriteria.addAll(costObjectives);
			costCriteria.addAll(costConstraints);
			exts.clear();
			init = 0;
			//Get evaluators that can evaluate every aspect
			for(EvaluationAspectWithContext aspect : costCriteria) {
				List<IExtension> tmp_exts = getExtensionsThatEvaluateAspect(aspect);			
				if(init == 0) {
					//initialize
					exts.addAll(tmp_exts);
					init++;
				} else {
					//calculate intersection
					List<IExtension> removeList = new ArrayList<IExtension>();
					for(IExtension e : exts) {					
						if(!tmp_exts.contains(e)){
							removeList.add(e);
						}					
					}
					exts.removeAll(removeList);
				}
			}
			if(costTab != null) {
				if(exts.size() == 0) {			
					costTab.deactivate();			
				} else  {
					costTab.activate(exts);
					this.objectives.addAll(costObjectives);
				}
			}
		}
		//POFOD 
		{
			List<EvaluationAspectWithContext> pofodObjectives = pcmReader.getDimensionObjectiveContextsForUsageModel(usageModel, dimensionReader.getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_POFOD_DEFINITION_PATH).getId());
			List<EvaluationAspectWithContext> pofodConstraints = pcmReader.getDimensionConstraintContextsForUsageModel(usageModel, dimensionReader.getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_POFOD_DEFINITION_PATH).getId());
			List<EvaluationAspectWithContext> pofodCriteria = new ArrayList<EvaluationAspectWithContext>();
			pofodCriteria.addAll(pofodObjectives);
			pofodCriteria.addAll(pofodConstraints);
			exts.clear();
			init = 0;
			//Get evaluators that can evaluate every aspect
			for(EvaluationAspectWithContext aspect : pofodCriteria) {
				List<IExtension> tmp_exts = getExtensionsThatEvaluateAspect(aspect);			
				if(init == 0) {
					//initialize
					exts.addAll(tmp_exts);
					init++;
				} else {
					//calculate intersection
					List<IExtension> removeList = new ArrayList<IExtension>();
					for(IExtension e : exts) {					
						if(!tmp_exts.contains(e)){
							removeList.add(e);
						}					
					}
					exts.removeAll(removeList);
				}
			}
			if(pofodTab != null) {
				if(exts.size() == 0) {			
					pofodTab.deactivate();			
				} else  {
					pofodTab.activate(exts);
					this.objectives.addAll(pofodObjectives);
				}
			}
		}
		//RESPONSE TIME bzw. Performance in general
		{			
			List<EvaluationAspectWithContext> performanceObjectives = 
				pcmReader.getDimensionObjectiveContextsForUsageModel(usageModel, dimensionReader.getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH).getId());
			performanceObjectives.addAll(
					pcmReader.getDimensionObjectiveContextsForUsageModel(usageModel, dimensionReader.getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_THROUGHPUT_DEFINITION_PATH).getId()));
			
			List<EvaluationAspectWithContext> performanceConstraints = 
				pcmReader.getDimensionConstraintContextsForUsageModel(usageModel, dimensionReader.getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH).getId());
			performanceConstraints.addAll(
					pcmReader.getDimensionObjectiveContextsForUsageModel(usageModel, dimensionReader.getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_THROUGHPUT_DEFINITION_PATH).getId()));
			
			List<EvaluationAspectWithContext> performanceCriteria = new ArrayList<EvaluationAspectWithContext>();
			performanceCriteria.addAll(performanceObjectives);
			performanceCriteria.addAll(performanceConstraints);
			exts.clear();
			init = 0;
			//Get evaluators that can evaluate every aspect
			for(EvaluationAspectWithContext aspect : performanceCriteria) {
				List<IExtension> tmp_exts = getExtensionsThatEvaluateAspect(aspect);			
				if(init == 0) {
					//initialize
					exts.addAll(tmp_exts);
					init++;
				} else {
					//calculate intersection
					List<IExtension> removeList = new ArrayList<IExtension>();
					for(IExtension e : exts) {					
						if(!tmp_exts.contains(e)){
							removeList.add(e);
						}					
					}
					exts.removeAll(removeList);
				}
			}
			if(performanceTab != null) {
				if(exts.size() == 0) {			
					performanceTab.deactivate();			
				} else  {
					performanceTab.activate(exts);
					this.objectives.addAll(performanceObjectives);
				}
			}
		}
		
		qmlLoaded = true;
	}
	
	protected void deactivateAllTabs(){
		for(DSEAnalysisMethodTab tab : tabs) {
			tab.deactivate();
		}
	}

	protected boolean fileExists(String path) {
		// if this is a platform URL, first resolve it to an absolute path
		if (path.startsWith("platform:")){
			try {
				URL solvedURL = FileLocator.resolve(new URL(path));
				path =  solvedURL.getPath();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} 
		} 
		File f = new File(path);
		return f.exists();
	}
	
	protected List<IExtension> getExtensionsThatEvaluateAspect(EvaluationAspectWithContext aspect) {
		List<IExtension> exts = ExtensionHelper.loadAnalysisExtensions(aspect.getDimension().getId());
		List<IExtension> return_list = new ArrayList<IExtension>(exts);
		for(IExtension ex : exts) {
			IConfigurationElement[] elements = ex.getConfigurationElements();
			for(IConfigurationElement e : elements) {
				IAnalysisQualityAttributeDeclaration attribute;
				try {
					attribute = (IAnalysisQualityAttributeDeclaration)ExtensionHelper.loadExecutableAttribute(e, "qualityAttributeHandler");
				} catch (CoreException e1) {
					return_list.clear();
					return return_list;
				}
				if(!attribute.canEvaluateAspectForDimension(aspect.getEvaluationAspect(), aspect.getDimension())){
					return_list.remove(ex);
				}
			}
		}
		return return_list;
	}
	
	/**
	 * Indicates if {@code processQMLFile(String, String)} was successful.
	 * 
	 * @return the QMLLoaded
	 */
	public boolean isQMLLoaded() {
		return qmlLoaded;
	}
	
	/**
	 * @return the diagnosis
	 */
	public String getDiagnosis() {
		return diagnosis;
	}

	
}


