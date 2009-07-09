package org.somox.analyzer.simplemodelanalyzer;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.URI;
import org.somox.analyzer.AnalysisResult;
import org.somox.analyzer.ModelAnalyzer;
import org.somox.analyzer.metriccomputation.TupleIterator;
import org.somox.configuration.ConfigurationDefinition;
import org.somox.core.SoMoXCoreLogger;
import org.somox.extractor.ExtractionResult;
import org.somox.metrics.init.Initialization;
import org.somox.softwareextractor.sissy.SISSyModelElementRepositoryWrapper;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;
import de.fzi.sissy.metamod.ModelElementList;
import de.fzi.sissy.metamod.ModelElementRepository;
import eu.qimpress.samm.staticstructure.CompositeComponent;
import eu.qimpress.samm.staticstructure.PrimitiveComponent;
import eu.qimpress.samm.staticstructure.Repository;
import eu.qimpress.samm.staticstructure.StaticstructureFactory;
import eu.qimpress.samm.staticstructure.SubcomponentInstance;



public class SimpleModelAnalyzer implements ModelAnalyzer {

	// ---------------------------------
	// Static Data Fields
	// ---------------------------------
	
	/** The output directory for the analyzer results*/
	private static String OUTPUT_DIRECTORY = "org.somox.analyzer.simplemodelanalyzer.outputdirectory";

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

		SoMoXCoreLogger.logInfo("SISSy Analyzer started with"
									+"\n preferences "+preferences
									+"\n internalArchitectureModel "+internalArchitectureModel
									+"\n extractionResultMap "+extractionResultMap);

		SimpleAnalysisResult analysisResult = new SimpleAnalysisResult(this);

		String inputFile = preferences.getString("org.somox.analyzer.inputfile");
		String platformPath = Platform.getInstanceLocation().getURL().getPath();
		platformPath = platformPath + inputFile;
		
		if (inputFile.endsWith("gast")) {
			URI fileURI = URI.createFileURI(new File(platformPath).getAbsolutePath());
			
			Initialization init = new Initialization();
			List<List<GASTClass>> elements = init.extractLists(fileURI);
			Root root = init.getRoot();
			
			TupleIterator tI = new TupleIterator();
			tI.configure(preferences);
			tI.initialize(root);
			
			List<ModelElement> elements1 = new LinkedList<ModelElement>();
			List<ModelElement> elements2 = new LinkedList<ModelElement>();
			
			System.out.println("TEST");
			
			if (elements.size() > 0) {
				int i=0;
				for (List<GASTClass> classTupel : elements) {
					for (GASTClass current : classTupel) {
						if (i<elements.size()/2) {
							elements1.add(current);
						} else {
							elements2.add(current);
						}
					}				
					i++;
				}
				System.out.println("SCORE: " + tI.compute(root, elements1, elements2));
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
		Repository qimpressRepository = StaticstructureFactory.eINSTANCE.createRepository();

		ModelElementList packageList = sissyRepository.getRoot().getPackages();
		Iterator<Object> packageIterator = packageList.iterator();
		while(packageIterator.hasNext()){
			de.fzi.sissy.metamod.Package packageElement = (de.fzi.sissy.metamod.Package) packageIterator.next();
			CompositeComponent packageComponent = StaticstructureFactory.eINSTANCE.createCompositeComponent();
			packageComponent.setId(packageElement.getQualifiedName());
			packageComponent.setName(packageElement.getSimpleName());
			ModelElementList elementList = packageElement.getClasses();
			Iterator<Object> elementIterator = elementList.iterator();
			while(elementIterator.hasNext()){
				de.fzi.sissy.metamod.Class classElement = (de.fzi.sissy.metamod.Class) elementIterator.next();
				PrimitiveComponent component = StaticstructureFactory.eINSTANCE.createPrimitiveComponent();
				component.setName(classElement.getSimpleName());
				component.setId(classElement.getQualifiedName());
				SubcomponentInstance subComponent = StaticstructureFactory.eINSTANCE.createSubcomponentInstance();
				subComponent.setRealizedBy(component);
				subComponent.setId(classElement.getQualifiedName());
				packageComponent.getSubcomponents().add(subComponent);
				qimpressRepository.getComponenttype().add(component);
			}
			qimpressRepository.getComponenttype().add(packageComponent);
		}



		return qimpressRepository;
	}

	public ModelAnalyzer.Status getStatus() {
		return status;
	}

	public LinkedList<ConfigurationDefinition> getConfigurationDefinitions() {
		// TODO Auto-generated method stub
		return null;
	}
}
