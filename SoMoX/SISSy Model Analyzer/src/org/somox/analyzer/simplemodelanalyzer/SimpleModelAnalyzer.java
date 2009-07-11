package org.somox.analyzer.simplemodelanalyzer;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.emf.common.util.URI;
import org.somox.analyzer.AnalysisResult;
import org.somox.analyzer.ModelAnalyzer;
import org.somox.analyzer.metriccomputation.ClusteringRelation;
import org.somox.analyzer.metriccomputation.TupleIterator;
import org.somox.configuration.ConfigurationDefinition;
import org.somox.core.SoMoXCoreLogger;
import org.somox.extractor.ExtractionResult;
import org.somox.metrics.init.Initialization;
import org.somox.softwareextractor.sissy.SISSyModelElementRepositoryWrapper;

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
			List<List<GASTClass>> components = init.extractLists(fileURI);
			Root root = init.getRoot();
			
			TupleIterator tI = new TupleIterator();
			tI.configure(preferences);
			tI.initialize(root);
			
			/*#######################
			 * Start clustering
			 * ###################### */
			
			int componentCount = components.size();
			boolean newComponentsFound = true;
			
			int iteration = 0;
			
			while (newComponentsFound) {
				
				iteration++;
				
				System.out.println("Clustering iteration nr.: " + iteration);
				
				//compute all metrics
				List<ClusteringRelation> results = new LinkedList<ClusteringRelation>();
				ListIterator<List<GASTClass>> firstIterator = components.listIterator();
				ListIterator<List<GASTClass>> secondIterator;
				
				System.out.println(components.size());
				
				while (firstIterator.hasNext()) {
					secondIterator = components.listIterator(firstIterator.nextIndex());
					List<GASTClass> currentFirst = firstIterator.next();
					while (secondIterator.hasNext()) {
						List<GASTClass> currentSecond = secondIterator.next();
						ClusteringRelation currentRelation = new ClusteringRelation(currentFirst, currentSecond);
						currentRelation.setResult(tI.compute(root, currentFirst, currentSecond));
						System.out.println("OVERALL: " + currentRelation.getResult());
						results.add(currentRelation);
					}
				}
				
				//TODO: Define threshold elsewhere (preferences, through tabs)
				double threshold = 0.5;
				
				//clustering
				components = doClustering(results, threshold);
				
				if (components.size() == componentCount) {
					newComponentsFound = false;
				}
				
			}
			//System.out.println("SCORE: " + tI.compute(root, elements1, elements2));
			
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


	private List<List<GASTClass>> doClustering(
			List<ClusteringRelation> results, double threshold) {
		
		List<List<GASTClass>> newComponents = new LinkedList<List<GASTClass>>();
		
		List<List<GASTClass>> alreadyUsed = new LinkedList<List<GASTClass>>();
		
		ClusteringRelation maxRelation = null;
		double maxResult = 0.0;
		boolean found = true;
		
		if (found) {
			ListIterator<ClusteringRelation> resultIterator = results.listIterator();
			while (resultIterator.hasNext()) {
				ClusteringRelation currentRelation = resultIterator.next();
				if (alreadyUsed.contains(currentRelation.getComponentA()) || alreadyUsed.contains(currentRelation.getComponentB())) {
					resultIterator.remove();
				} else {
					if (currentRelation.getResult() >= maxResult) {
						maxResult = currentRelation.getResult();
						maxRelation = currentRelation;					
					}
				}
			}

			if (maxResult > threshold) {
				List<GASTClass> foundComponent = new LinkedList<GASTClass>();
				foundComponent.addAll(maxRelation.getComponentA());
				foundComponent.addAll(maxRelation.getComponentB());
				newComponents.add(foundComponent);
				alreadyUsed.add(maxRelation.getComponentA());
				alreadyUsed.add(maxRelation.getComponentB());
			} else {
				found = false;
			}
		}
		
		ListIterator<ClusteringRelation> resultIterator = results.listIterator();
		while (resultIterator.hasNext()) {
			ClusteringRelation currentRelation = resultIterator.next();
			if (alreadyUsed.contains(currentRelation.getComponentA()) || alreadyUsed.contains(currentRelation.getComponentB())) {
				resultIterator.remove();
			} else {
				newComponents.add(maxRelation.getComponentA());
				newComponents.add(maxRelation.getComponentB());
				alreadyUsed.add(maxRelation.getComponentA());
				alreadyUsed.add(maxRelation.getComponentB());
			}
		}
		
		return newComponents;
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
