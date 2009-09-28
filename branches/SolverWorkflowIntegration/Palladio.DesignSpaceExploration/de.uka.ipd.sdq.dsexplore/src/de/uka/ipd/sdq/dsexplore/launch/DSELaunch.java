package de.uka.ipd.sdq.dsexplore.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jface.dialogs.MessageDialog;
import org.opt4j.config.visualization.Configurator;
import org.opt4j.core.DoubleValue;
import org.opt4j.core.Value;
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.start.Opt4J;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.algorithms.HillClimbingAlgorithm;
import de.uka.ipd.sdq.dsexplore.algorithms.IAlgorithm;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisProxy;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.cost.CostEvaluator;
import de.uka.ipd.sdq.dsexplore.helper.ConfigurationHelper;
import de.uka.ipd.sdq.dsexplore.helper.DSEMessageBox;
import de.uka.ipd.sdq.dsexplore.helper.DummyAnalysisResult;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.helper.GenotypeReader;
import de.uka.ipd.sdq.dsexplore.helper.LoggerHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.start.GivenInstanceEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.dsexplore.opt4j.start.PredefinedInstanceEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.start.RandomSearch;
import de.uka.ipd.sdq.pcm.cost.CostRepository;

/**
 * Launches multiple simulation runs. 
 * 
 * @author Anne
 *
 */
public class DSELaunch implements ILaunchConfigurationDelegate {
	
	/**
	 * A default to be overridden by the settings in the run dialog.
	 */
	private int maxIterations = Integer.MAX_VALUE;
	private double mrtRequirements = 0;
	private int individualsPerGeneration = 5;
	private double maxCost = 0;
	private double maxPOFOD = 0;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	/**
	 * Test for starting multiple simulations.
	 * @param configuration
	 * @param mode
	 * @param launch
	 * @param monitor
	 */
	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		//TODO use Workflow mechanism already provided by the codegen packages?
		/* Add jobs for simulation one by one --> no, too low level, need to start whole simulations. */
		
			//super.createRunCompositeJob(new SimuAttributesGetMethods(configuration), true, launch);
			//super.launch(configuration, mode, launch, monitor);
			LoggerHelper.initializeLogger(configuration);
			
			Long timestampMillis = System.currentTimeMillis();
		
			logger.debug("Starting...");
			logger.debug("Launch Configuration: "+configuration.getMemento());
			
			this.maxIterations = getIntAttribute(configuration, DSEConstantsContainer.MAX_ITERATIONS, "");
			this.mrtRequirements = getDoubleAttribute(configuration, DSEConstantsContainer.MRT_REQUIREMENTS, "");
			this.maxCost = getDoubleAttribute(configuration, DSEConstantsContainer.MAX_COST, "");
			this.individualsPerGeneration  = getIntAttribute(configuration, DSEConstantsContainer.INDIVIDUALS_PER_GENERATION, "");
			boolean newProblem = !configuration.getAttribute(DSEConstantsContainer.OPTIMISATION_ONLY, false);
			boolean optimise = !configuration.getAttribute(DSEConstantsContainer.DESIGN_DECISIONS_ONLY, false);
			
			logger.debug("\n Launching optimization with \n"+
					"maximal number of iterations: "+this.maxIterations+"\n"+
					"individuals per generation:" +this.individualsPerGeneration+"\n"+
					"offspring per generation: individuals per generation / 2 rounded up.");
			
			try {
				
			//Get the initial PCM Instance
		    PCMInstance pcmInstance = new PCMInstance(configuration);
		    List<PCMInstance> instances = new ArrayList<PCMInstance>();
		    instances.add(pcmInstance);
		    
		    //initialise the algorithm and analysis
		    //HillClimbingAlgorithm algorithm = new HillClimbingAlgorithm(mrtRequirements);
		    //IAlgorithm algorithm = new FullSearchAlgorithm();
		    
		    ArrayList<Value<Double>> upperConstraints = new ArrayList<Value<Double>>();
		    
		    List<IAnalysis> evaluators = new ArrayList<IAnalysis>();
		    if (!configuration.getAttribute(DSEConstantsContainer.getAnalysisMethod(DSEConstantsContainer.PERFORMANCE), "").equals(DSEConstantsContainer.NONE)){
		    	evaluators.add(new AnalysisProxy(configuration, mode, launch, monitor, DSEConstantsContainer.PERFORMANCE));
		    	upperConstraints.add(new DoubleValue(mrtRequirements));
		    }
		    if (!configuration.getAttribute(DSEConstantsContainer.getAnalysisMethod(DSEConstantsContainer.RELIABILITY), "").equals(DSEConstantsContainer.NONE)){
		    	evaluators.add(new AnalysisProxy(configuration, mode, launch, monitor, DSEConstantsContainer.RELIABILITY));
		    	upperConstraints.add(new DoubleValue(maxPOFOD));
		    }
		    CostEvaluator costs = new CostEvaluator();
		    costs.initialise(configuration, mode, launch, monitor);
		    evaluators.add(costs);
		    upperConstraints.add(new DoubleValue(maxCost));
			
		    //algorithm.initialise(instances, perfAnalysisTool,configuration);

			
			//TODO: extract this in a Builder?
			if (!optimise){
				if (newProblem){
					Opt4JStarter.init(evaluators, upperConstraints, pcmInstance, newProblem);
				} else {
					throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "You cannot choose \"optimisation only\" and \"design decisions only\" at the same time", null));
				}
			} else if (!configuration.hasAttribute(DSEConstantsContainer.PREDEFINED_INSTANCES)
					|| configuration.getAttribute(DSEConstantsContainer.PREDEFINED_INSTANCES, "").equals("")
					){
				Opt4JStarter.initAndStartOpt4J(evaluators, pcmInstance, maxIterations, this.individualsPerGeneration, upperConstraints, monitor, newProblem);
			} else if (configuration.getAttribute(DSEConstantsContainer.PREDEFINED_INSTANCES, "").toLowerCase().equals("random")){
				Opt4JStarter.init(evaluators, upperConstraints, pcmInstance, newProblem);
				PredefinedInstanceEvaluator rie = new RandomSearch(maxIterations, individualsPerGeneration);
				rie.start();
			} else if (this.maxIterations == 0){
				//Only evaluate given instances
				//TODO: fix this dependency, GivenInstanceEvaluator will not work without init call. Refactor init part and how to evaluate part in two different classes 
				Opt4JStarter.init(evaluators, upperConstraints, pcmInstance, newProblem);
				PredefinedInstanceEvaluator gie = new GivenInstanceEvaluator(configuration);
				gie.start();
				
			} else {
				Opt4JStarter.init(evaluators, upperConstraints, pcmInstance, newProblem);
				//use predefined instances as initial population
				String filename = configuration.getAttribute(DSEConstantsContainer.PREDEFINED_INSTANCES, "");
				List<DoubleGenotype> genotypes = GenotypeReader.getGenotypes(filename);
				Opt4JStarter.runOpt4JWithPopulation(maxIterations, individualsPerGeneration, monitor, genotypes);
			}
		    
		  		
			} finally {
				//try to save the results as far as it got. 
/*				if (allCandidates != null && allResults != null){
				    long duration = System.currentTimeMillis() - timestampMillis;
				    Collections.sort(allCandidates);
				    Collections.sort(allResults);
			        try {
			        	String message = 
						"Here are the steepest-ascent results, sorted by response time: \n\n"
						+ resultsToString(allCandidates)
						+ "\n You find the corresponding run configuration in your "
						+ "run dialog, they show you all details on the candidates.\n\n "
						+ "The search took "
						+ duration / 1000.0 + " seconds. "
						+ allResults.size() + " candidates were analysed.\n\n" 
						+ "All candidates, sorted by response time: \n" 
						+ resultsToString(allResults);
				
						DSEMessageBox.showMessage("DSE results",message,MessageDialog.INFORMATION);
			        	logger.info(message);
					} catch (AnalysisFailedException e) {
						e.printStackTrace();
						logger.error("Could not print result dialog, analysis failed.");
					}
				}*/
				
				logger.warn("DSE launch done. It took "+((System.currentTimeMillis()-timestampMillis)/1000)+" seconds.");
				
				try {
					Opt4JStarter.closeTask();
					Opt4JStarter.tearDown();
				} catch (Exception e){
					e.printStackTrace();
				}

			}
	}



	/**
	 * Reads an attribute from the configurations and tries to parse it as an integer. 
	 * @param configuration The {@link ILaunchConfiguration}
	 * @param key The key under which the attribute is stored
	 * @param defaultValue A default value if the attribute is not found
	 * @return An integer value for the attribute, 0 if parsing was unsuccessful
	 * @throws CoreException thrown by {@link ILaunchConfiguration#getAttribute(String, String)}
	 */
	private int getIntAttribute(ILaunchConfiguration configuration, String key, String defaultValue)
			throws CoreException {
		String valueString = configuration.getAttribute(key, defaultValue);
		int result = 0;
		try{
			result = Integer.parseInt(valueString);
		} catch (Exception e){
				//ok, it was worth a try, so just keep the old value. 
				logger.debug("Could not parse "+key+" information: "+valueString);
		} 
		return result;
	}
	
	/**
	 * Reads an attribute from the configurations and tries to parse it as an integer. 
	 * @param configuration The {@link ILaunchConfiguration}
	 * @param key The key under which the attribute is stored
	 * @param defaultValue A default value if the attribute is not found
	 * @return An integer value for the attribute, 0 if parsing was unsuccessful
	 * @throws CoreException thrown by {@link ILaunchConfiguration#getAttribute(String, String)}
	 */
	private double getDoubleAttribute(ILaunchConfiguration configuration, String key, String defaultValue)
			throws CoreException {
		String valueString = configuration.getAttribute(key, defaultValue);
		double result = 0;
		try{
			result = Double.parseDouble(valueString);
		} catch (Exception e){
				//ok, it was worth a try, so just keep the old value. 
				logger.debug("Could not parse "+key+" information: "+valueString);
		} 
		return result;
	}

	private static String resultsToString(List<IAnalysisResult> population) throws AnalysisFailedException {
		String string = "";
		int count = 1;
		for (Iterator<IAnalysisResult> iterator = population.iterator(); iterator
				.hasNext();) {
			IAnalysisResult analysisResult = iterator.next();
			string += count + ".: ";
			string += "\t" + analysisResult.getPCMInstance().getName();
			string += "\t"+ analysisResult.getMeanValue()+" time units.\n"; 
			count ++;
		}
		return string;
	}
	
}



