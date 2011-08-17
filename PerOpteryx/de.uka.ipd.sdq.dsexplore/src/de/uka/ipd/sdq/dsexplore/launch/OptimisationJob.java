package de.uka.ipd.sdq.dsexplore.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.helper.GenotypeReader;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.start.GivenInstanceEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.dsexplore.opt4j.start.PredefinedInstanceEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.start.RandomSearch;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;

public class OptimisationJob implements IJob, IBlackboardInteractingJob<MDSDBlackboard> {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.launch.OptimisationJob");

	private PCMInstance pcmInstance;
	private List<IAnalysis> evaluators;
	private Long startTimestampMillis;
	
	private MDSDBlackboard blackboard;
	
	private DSEWorkflowConfiguration dseConfig;
    	

	public OptimisationJob(DSEWorkflowConfiguration config, DSELaunch launch) {
		
		    this.dseConfig = config;
		    
		    this.evaluators = config.getEvaluators();
	}



	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		startTimestampMillis = System.currentTimeMillis();
		
		logger.debug("Starting...");

		try{
		logger.debug("\n Launching optimization with \n"+
				"maximal number of iterations: "+this.dseConfig.getMaxIterations()+"\n"+
				"individuals per generation:" +this.dseConfig.getIndividualsPerGeneration()+"\n"+
				"offspring per generation: individuals per generation / 2 rounded up.");
		
		pcmInstance = getPCMInstance();
	    List<PCMInstance> instances = new ArrayList<PCMInstance>();
	    instances.add(pcmInstance);
	    
	    //initialise the algorithm and analysis
	    //HillClimbingAlgorithm algorithm = new HillClimbingAlgorithm(mrtRequirements);
	    //IAlgorithm algorithm = new FullSearchAlgorithm();
			
	    //algorithm.initialise(instances, perfAnalysisTool,configuration);

	    Opt4JStarter.init(evaluators, this.dseConfig,getPCMInstance(), monitor, this.blackboard);
	    
	    if (this.dseConfig.hasCacheInstances()){
	    	fillCacheWithValues(this.dseConfig.getCacheInstancesFileName());
	    }
	    
		//TODO: extract this in a Builder?
	    if (this.dseConfig.isOptimise()){
	    	if (this.dseConfig.getMaxIterations() == 0 && dseConfig.hasPredefinedInstances()){
	    		//Only evaluate given instances
	    		PredefinedInstanceEvaluator gie = new GivenInstanceEvaluator(this.dseConfig);
	    		gie.start();

	    	} else if (dseConfig.isRandomSearch()){
	    		PredefinedInstanceEvaluator rie = new RandomSearch(this.dseConfig);
	    		rie.start();
	    	} else if (!dseConfig.hasPredefinedInstances()){
	    		Opt4JStarter.startOpt4J(evaluators, this.dseConfig, monitor,getPCMInstance());
	    	} else  {
	    		//use predefined instances as initial population
	    		String populationFilename = this.dseConfig.getPredefinedInstancesFileName();
	    		List<DesignDecisionGenotype> genotypes;
	    		if (!"".equals(populationFilename)){
	    			genotypes = GenotypeReader.getGenotypes(populationFilename);
	    		} else {
	    			genotypes = Collections.emptyList();
	    		}
	    		
	    		//read in all candidates file if there and add to cache
	    		String allCandidatesFilename = this.dseConfig.getPredefinedAllCandidatesFileName();
	    		List<DesignDecisionGenotype> allCandidates;
	    		if (!"".equals(allCandidatesFilename)){
	    			allCandidates = GenotypeReader.getGenotypes(allCandidatesFilename);
	    		} else {
	    			allCandidates = Collections.emptyList();
	    		}
	    		
	    		// read in archive candidates file if there and add to cache. 
	    		// Need to add them to Opt4J archive to ensure a proper continuation of an evolutionary search.
	    		// The addition is done by Opt4JStarter (see below)
	    		String archiveCandidatesFilename = this.dseConfig.getArchiveCandidateFileName();
	    		List<DesignDecisionGenotype> archiveCandidates;
	    		if (!"".equals(allCandidatesFilename)){
	    			archiveCandidates = GenotypeReader.getGenotypes(archiveCandidatesFilename);
	    		} else {
	    			archiveCandidates = Collections.emptyList();
	    		}	    		
	    		
	    		Opt4JStarter.runOpt4JWithPopulation(this.dseConfig, monitor, genotypes, allCandidates, archiveCandidates);
	    	}
	    }
		} catch (CoreException e){
			throw new JobFailedException(e);
	  		
		} finally {
		
			logger.warn("DSE launch done. It took "+((System.currentTimeMillis()-startTimestampMillis)/1000)+" seconds.");
			
			try {
				/* There was quite some memory allocation at this point (probably),
				 * which seemed caused an OutOfMemory quicker than the VM could get 
				 * more memory (max perm size had not been reached yet). Thus, make sure
				 * here that all memory is freed. */ 
				Runtime.getRuntime().gc();
				Opt4JStarter.closeTask();
				Opt4JStarter.tearDown();
				Runtime.getRuntime().gc();
			} catch (Exception e){
				e.printStackTrace();
			}

		}

	}


	private List<DSEIndividual> fillCacheWithValues(String cacheInstancesFileName) throws CoreException {
		return GenotypeReader.getIndividuals(cacheInstancesFileName);
	}



	@Override
	public String getName() {
		return this.getClass().getName();
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// TODO Auto-generated method stub

	}



	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
		
	}
	
	private PCMInstance getPCMInstance(){
		if (this.blackboard != null){
			return new PCMInstance((PCMResourceSetPartition)this.blackboard.getPartition(MoveInitialPCMModelPartitionJob.INITIAL_PCM_MODEL_PARTITION_ID));
		} else {
			String message = "Internal error: Cannot retrieve PCM model if blackboard is not set. ";
			logger.error(message);
			throw new UnsupportedOperationException(message);
		}
	}
	
}