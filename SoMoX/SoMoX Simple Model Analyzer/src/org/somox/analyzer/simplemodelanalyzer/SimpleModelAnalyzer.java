package org.somox.analyzer.simplemodelanalyzer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Preferences;
import org.somox.analyzer.AnalysisResult;
import org.somox.analyzer.ModelAnalyzer;
import org.somox.configuration.ConfigurationDefinition;
import org.somox.core.SoMoXCoreLogger;
import org.somox.extractor.ArtifactWrapper;
import org.somox.extractor.ExtractionResult;
import org.somox.extractor.SoftwareExtractor;
import org.somox.softwareextractor.sissy.SISSyModelElementRepositoryWrapper;

import de.fzi.sissy.metamod.ModelElementList;
import de.fzi.sissy.metamod.ModelElementRepository;
import eu.qimpress.samm.staticstructure.staticstructureFactory;
import eu.qimpress.samm.staticstructure.CompositeComponent;
import eu.qimpress.samm.staticstructure.PrimitiveComponent;
import eu.qimpress.samm.staticstructure.Repository;
import eu.qimpress.samm.staticstructure.SubcomponentInstance;



public class SimpleModelAnalyzer implements ModelAnalyzer {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------

	// ---------------------------------
	// Data fields
	// ---------------------------------

	/** The current status of the analyzer */
	private ModelAnalyzer.Status status = ModelAnalyzer.Status.READY;

	// ---------------------------------
	// Constructor
	// ---------------------------------

	/**
	 * Default constructor
	 */
	public SimpleModelAnalyzer() {}

	// ---------------------------------
	// Business Methods
	// ---------------------------------

	@Override
	public void init() {}

	@Override
	public AnalysisResult analyze(	Preferences preferences,
									Repository internalArchitectureModel,
									HashMap<String, ExtractionResult> extractionResultMap) {
		this.status = ModelAnalyzer.Status.RUNNING;

		SoMoXCoreLogger.logInfo("Simple Analyzer startet with\n"
									+"\n preferences "+preferences
									+"\n internalArchitectureModel "+internalArchitectureModel
									+"\n extractionResultMap "+extractionResultMap);

		SimpleAnalysisResult analysisResult = new SimpleAnalysisResult(this);

		Iterator<ExtractionResult> resultIterator = extractionResultMap.values().iterator();
		while(resultIterator.hasNext()){
			ExtractionResult result = resultIterator.next();
			SoftwareExtractor extractor = result.getSoftwareExtractor();
			List<ArtifactWrapper> artifacts = extractor.getSoftwareArtefacts();
			Iterator<ArtifactWrapper> artifactIterator = artifacts.iterator();
			while(artifactIterator.hasNext()){
				ArtifactWrapper wrapper = artifactIterator.next();
				if (wrapper instanceof SISSyModelElementRepositoryWrapper){
					SISSyModelElementRepositoryWrapper sissyWrapper = (SISSyModelElementRepositoryWrapper) wrapper;
					Repository newInternalArchitectureModel = processSISSyResult( sissyWrapper,preferences,internalArchitectureModel );
					analysisResult.setInternalArchitectureModel(newInternalArchitectureModel);
				}
			}
		}

		this.status = ModelAnalyzer.Status.FINISHED;
		analysisResult.setResultStatus(AnalysisResult.ResultStatus.SUCCESS);

		return analysisResult;
	}

	// ---------------------------------
	// Helper Methods
	// ---------------------------------

	// ---------------------------------
	// Getters / Setters
	// ---------------------------------

	@Override
	public LinkedList<ConfigurationDefinition> getConfigurationDefinitions() {
		LinkedList<ConfigurationDefinition> configs = new LinkedList<ConfigurationDefinition>();
		return configs;
	}

	/**
	 * Analyze the current model and the SISSy input to build a new internal architecture model
	 */
	@SuppressWarnings("unchecked")
	private Repository processSISSyResult(
			SISSyModelElementRepositoryWrapper sissyWrapper,
			Preferences preferences,
			Repository internalArchitectureModel) {

		ModelElementRepository sissyRepository = sissyWrapper.getModelElementRepository();

		//TODO: Implement the real analysis logic here
		// each class is turned into a simple component
		Repository qimpressRepository = staticstructureFactory.eINSTANCE.createRepository();

		ModelElementList packageList = sissyRepository.getRoot().getPackages();
		Iterator<Object> packageIterator = packageList.iterator();
		while(packageIterator.hasNext()){
			de.fzi.sissy.metamod.Package packageElement = (de.fzi.sissy.metamod.Package) packageIterator.next();
			CompositeComponent packageComponent = staticstructureFactory.eINSTANCE.createCompositeComponent();
			packageComponent.setId(packageElement.getQualifiedName());
			packageComponent.setName(packageElement.getSimpleName());
			ModelElementList elementList = packageElement.getClasses();
			Iterator<Object> elementIterator = elementList.iterator();
			while(elementIterator.hasNext()){
				de.fzi.sissy.metamod.Class classElement = (de.fzi.sissy.metamod.Class) elementIterator.next();
				PrimitiveComponent component = staticstructureFactory.eINSTANCE.createPrimitiveComponent();
				component.setName(classElement.getSimpleName());
				component.setId(classElement.getQualifiedName());
				SubcomponentInstance subComponent = staticstructureFactory.eINSTANCE.createSubcomponentInstance();
				subComponent.setRealizedBy(component);
				subComponent.setId(classElement.getQualifiedName());
				packageComponent.getSubcomponents().add(subComponent);
				qimpressRepository.getComponenttype().add(component);
			}
			qimpressRepository.getComponenttype().add(packageComponent);
		}



		return qimpressRepository;
	}

	@Override
	public ModelAnalyzer.Status getStatus() {
		return status;
	}
}
