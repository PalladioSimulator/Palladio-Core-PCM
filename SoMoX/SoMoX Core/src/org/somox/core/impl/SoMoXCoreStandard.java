package org.somox.core.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.somox.analyzer.AnalysisResult;
import org.somox.analyzer.ModelAnalyzer;
import org.somox.configuration.ConfigurationDefinition;
import org.somox.core.SoMoXCore;
import org.somox.core.SoMoXCoreLogger;
import org.somox.extractor.ExtractionResult;
import org.somox.extractor.SoftwareExtractor;

import eu.qimpress.samm.staticstructure.Repository;
import eu.qimpress.samm.staticstructure.staticstructureFactory;

//import eu.qimpress.commonmodel.commonmodel.StaticStructure.Repository;
//import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructureFactory;


/**
 * Standard Implementation of the SoMoX Core.
 *
 * @author Benjamin Klatt
 *
 */
public class SoMoXCoreStandard implements SoMoXCore {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------

	/** The path inside the project to store the internal architecture model */
	private static final String PATH_INTERNAL_ARCHITECTUREMODEL = "/model/internal_architecture_model.staticstructure";

	/** The identifier for the project id configuration field */
	private static String CONFIGURATION_ID_PROJECT = "somox.core.project";

	// ---------------------------------
	// Data fields
	// ---------------------------------

	/** The map of all configured Software Extractors	 */
	private HashMap<String, SoftwareExtractor> softwareExtractorMap = new HashMap<String, SoftwareExtractor>();

	/** The map of all existing extraction results [etxractorID,resultObject]	 */
	private HashMap<String, ExtractionResult> extractionResultMap = new HashMap<String, ExtractionResult>();


	/** The model analyzer to be executed */
	private ModelAnalyzer modelAnalyzer= null;

	/** The list of executed software extractors */
	private List<SoftwareExtractor> executedList = new LinkedList<SoftwareExtractor>();

	/** The resource set of the core to work with */
	private ResourceSet resourceSet = null;


	// ---------------------------------
	// Constructor
	// ---------------------------------

	/**
	 * Default constructor preparing the ecore resource set
	 */
	public SoMoXCoreStandard() {
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry()
					.getExtensionToFactoryMap()
					.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	}

	// ---------------------------------
	// Business Methods
	// ---------------------------------

	@Override
	// TODO Handle multiple extractors
	public void runExtraction(IProgressMonitor progressMonitor,Preferences preferences) {
		SoMoXCoreLogger.logInfo("extraction started");
		Iterator<Entry<String, SoftwareExtractor>> iter = this.softwareExtractorMap.entrySet().iterator();;
		while(iter.hasNext()){
			Entry<String, SoftwareExtractor> entry = iter.next();
			ExtractionResult result = entry.getValue().runExtraction(entry.getKey(),preferences);
			this.extractionResultMap.put(entry.getKey(), result);
			executedList.add(entry.getValue());
		}
		SoMoXCoreLogger.logInfo("extraction finished");
	}

	@Override
	public void runAnalyzer(IProgressMonitor progressMonitor,Preferences preferences) {
		SoMoXCoreLogger.logInfo("analysis started");
		SoMoXCoreLogger.logInfo("analysis of results: "+this.extractionResultMap);

		// TODO Handle not installed model analyzer

		// load the current internal architecture model
		String projectIdentifier = preferences.getString(CONFIGURATION_ID_PROJECT);
		Repository internalArchitectureModel = null;
		try {
			getInternalArchitectureModel(projectIdentifier);
		} catch (IOException e) {
			SoMoXCoreLogger.logError("Model Resource load failed for Analyzer.",e);
			return;
		}

		// perform the analysis
		SoMoXCoreLogger.logInfo("Start model analyzer ("+modelAnalyzer+")");
		AnalysisResult result = modelAnalyzer.analyze(preferences,internalArchitectureModel,extractionResultMap);
		SoMoXCoreLogger.logInfo("Analysis finished with result: "+result.getResultStatus());

		// save the new internal architecture model
		try {
			saveInternalArchitectureModel(result.getInternalArchitectureModel(),projectIdentifier);
		} catch (IOException e) {
			SoMoXCoreLogger.logError("Model Analyzer failed.",e);
		}
	}

	/**
	 * Load the internal architecture model. if none is present now create a new one
	 *
	 * @throws IOException
	 */
	private Repository getInternalArchitectureModel(String projectIdentifier) throws IOException {

		Repository result = null;

		Resource resource = getResource(projectIdentifier);

		if(resource.getContents().size() == 0){
			SoMoXCoreLogger.logError("The internal architecture model file does not contain a model.",
					new Exception("No internal architecture model repository available."));

		} else {
			EObject content = resource.getContents().get(0);
			if(content instanceof Repository){
				result = (Repository) content;
			} else {
				SoMoXCoreLogger.logError("The internal architecture model resource contains a model of a wrong type.",
						new Exception("Wrong emf model type in resource "+content));
			}
		}
		return result;
	}

	/**
	 * Save the internal architecture model
	 *
	 * @param internalArchitectureModel	The model to be saved
	 * @param projectIdentifier			The identifier for the project to save the model in
	 * @throws IOException	An exception about problems reading or writing the internal architecture model
	 */
	private void saveInternalArchitectureModel(Repository internalArchitectureModel, String projectIdentifier)
			throws IOException {
		Resource resource = getResource(projectIdentifier);
		resource.getContents().clear();
		resource.getContents().add(internalArchitectureModel);
		resource.save(null);
	}

	/**
	 * Get the EMF resource to work with
	 * @param projectIdentifier The identifier for the project to work with
	 * @return	The requested EMF resource
	 * @throws IOException
	 */
	private Resource getResource(String projectIdentifier) throws IOException {

		URI uri = URI.createURI("platform:/resource/"+projectIdentifier+PATH_INTERNAL_ARCHITECTUREMODEL);
		Resource resource = resourceSet.getResource(uri, false);

		// if the resource does not exist or is empty create a new one with
		// an appropriate model inside
		if(resource == null || resource.getContents().isEmpty()){
			resource = resourceSet.createResource(uri);
			Repository qimpressRepository = staticstructureFactory.eINSTANCE.createRepository();
			resource.getContents().add(qimpressRepository);
			resource.save(null);
		}

		return resource;
	}

	@Override
	public void runExport(IProgressMonitor progressMonitor) {
		// TODO implement the export
	}

	// ---------------------------------
	// Helper Methods
	// ---------------------------------

	@Override
	public void addSoftwareExtractor(String id, SoftwareExtractor extractor) {
		this.softwareExtractorMap.put(id,extractor);
	}

	@Override
	public void removeSoftwareExtractor(String id) {
		this.softwareExtractorMap.remove(id);
	}

	@Override
	public void setModelAnalyzer(ModelAnalyzer analyzer) {
		this.modelAnalyzer = analyzer;
	}

	// ---------------------------------
	// Getters / Setters
	// ---------------------------------

	@Override
	public List<SoftwareExtractor> getExecutedSoftwareExtractors() {
		return executedList;
	}

	@Override
	public LinkedList<ConfigurationDefinition> getConfigurationDefinitions() {
		LinkedList<ConfigurationDefinition> definitions = new LinkedList<ConfigurationDefinition>();

		// add core configurations
		definitions.addAll(getCoreConfigurationDefinitions());

		// add extractor configurations
		Iterator<SoftwareExtractor> extractors = softwareExtractorMap.values().iterator();
		while(extractors.hasNext()){
			definitions.addAll(extractors.next().getConfigurationDefinitions());
		}

		// add analyzer configurations
		definitions.addAll(modelAnalyzer.getConfigurationDefinitions());

		return definitions;
	}

	/**
	 * Get the list of required configuration settings for the core
	 *
	 * @return The list of configuration definition objects
	 */
	private Collection<ConfigurationDefinition> getCoreConfigurationDefinitions() {
		LinkedList<ConfigurationDefinition> configs = new LinkedList<ConfigurationDefinition>();
		ConfigurationDefinition projectID = new ConfigurationDefinition(CONFIGURATION_ID_PROJECT,"Project",ConfigurationDefinition.Type.STRING);
		configs.add(projectID);
		return configs;
	}
}
