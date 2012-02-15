package de.uka.ipd.sdq.dsexplore.opt4j.optimizer;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.WriterAppender;
import org.eclipse.core.runtime.CoreException;
import org.opt4j.core.Genotype;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualFactory;
import org.opt4j.core.optimizer.AbstractOptimizer;
import org.opt4j.core.optimizer.Archive;
//import org.opt4j.core.optimizer.IndividualCompleter;
import org.opt4j.core.optimizer.Control;
//import org.opt4j.core.optimizer.Iterations;
import org.opt4j.core.optimizer.IndividualCompleter;
import org.opt4j.core.optimizer.Iteration;
import org.opt4j.core.optimizer.Population;
import org.opt4j.core.optimizer.StopException;
import org.opt4j.core.optimizer.TerminationException;
//import org.opt4j.core.Genotype;
import org.opt4j.operator.copy.Copy;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.helper.FilterParetoOptimalIndividuals;
import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticOperatorsManager;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSECreator;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualFactory;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;

/**
 * 
 * @author martens
 *
 */
public class RuleBasedSearch extends AbstractOptimizer {

	private TacticOperatorsManager tacticsManager;
	private IndividualFactory individualFactory;
	
	private boolean fullSearch;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.opt4j.optimizer.RuleBasedSearch");

	@Inject
	public RuleBasedSearch(Population population, Archive archive,
			IndividualFactory individualFactory, IndividualCompleter completer,
			Control control, Copy<Genotype> copy, Iteration iteration,
			@Constant(value = "fullSearch", namespace = RuleBasedSearch.class) boolean fullSearch) {
		super(population, archive, completer, control, iteration);
		this.tacticsManager = new TacticOperatorsManager(copy, (DSEIndividualFactory)individualFactory);
		this.fullSearch = fullSearch;
		this.individualFactory = individualFactory;
	}

	@Override
	public void optimize() throws StopException, TerminationException {
		
		Individual ind = individualFactory.create();
		this.population.add(ind);
		
		try {
			DSECreator creator = Opt4JStarter.getDSECreator();
			// 		also take additional predefined candidates, if any
			int numberOfPredefinedOnes = creator.getNumberOfNotEvaluatedPredefinedOnes();
			for (int i = 1; i <= numberOfPredefinedOnes; i++) {
				Individual ind2 = individualFactory.create();
				this.population.add(ind2);
			}
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}

			
		
		nextIteration();
		
		int i = 0;
		while (iteration.value() < iteration.max()) {
			
			List<Individual> nextGeneration = new LinkedList<Individual>();
			
			for (Individual individual : this.population) {
				if (individual instanceof DSEIndividual){
					DSEIndividual dseIndividual = (DSEIndividual)individual;
					List<TacticsResultCandidate> candidateResults = this.tacticsManager.getAllCandidates(dseIndividual);
					nextGeneration.addAll(candidateResults);	
					
				} else {
					throw new RuntimeException("Encountered a non-DSEIndividual in rule based search that I cannot handle. Aborting.");
				}
				
			}
			
			//remove duplicates
			int nextGenerationSize = nextGeneration.size();
			nextGeneration.removeAll(population);
			nextGeneration.removeAll(archive);
			logger.info("Removed "+(nextGeneration.size() - nextGenerationSize)+" duplicate candidate (that were in the previous population or in the archive).");
			
			completer.complete(nextGeneration);
			
			this.population.clear();
			this.population.addAll(nextGeneration);
			
			if (!this.fullSearch){
				List<Individual> archiveAndNewUnion = new ArrayList<Individual>(this.archive.size() + nextGeneration.size());
				archiveAndNewUnion.addAll(nextGeneration);
				archiveAndNewUnion.addAll(archive);
				List<Individual> optimalCandidates = FilterParetoOptimalIndividuals.filterPareto(archiveAndNewUnion);
				this.population.retainAll(optimalCandidates);
			}
			
			
			
			if (this.population.size() == 0){
				logger.warn("No more individuals in population, aborting after iteration "+i);
				break;
			}
			
			nextIteration();
			
		}
		logger.warn("Finished rule-based search after "+i+" iterations.");
		if (iteration.value() == iteration.max()){
			logger.warn("Stop condition was the configured maximum number of iterations, more rule applications may be possible. There were "+population.size()+" candidates in the final population.");
		}
		
		ResultsWriter writer = new ResultsWriter(Opt4JStarter.getDSEWorkflowConfig().getResultFolder()+"rule-based search results");
		for (Individual individual : this.archive) {
			if (individual instanceof DSEIndividual){
				DSEIndividual dseIndiv = (DSEIndividual)individual;
				writer.writeIndividual(dseIndiv);
			} else {
				logger.warn("Encountered a non DSE-Individual in the rule based search, aborting to write results.");
			}
		}
		writer.flush();
		
		flushAllLogs();
	

	}
	
	public static void flushAllLogs()
	{
	    try
	    {
	        Set<WriterAppender> flushedFileAppenders = new HashSet<WriterAppender>();
	        Enumeration<?> currentLoggers = LogManager.getLoggerRepository().getCurrentLoggers();
	        while(currentLoggers.hasMoreElements())
	        {
	            Object nextLogger = currentLoggers.nextElement();
	            if(nextLogger instanceof Logger)
	            {
	                Logger currentLogger = (Logger) nextLogger;
	                Enumeration<?> allAppenders = currentLogger.getAllAppenders();
	                while(allAppenders.hasMoreElements())
	                {
	                    Object nextElement = allAppenders.nextElement();
	                    if(nextElement instanceof WriterAppender)
	                    {
	                    	WriterAppender fileAppender = (WriterAppender) nextElement;
	                        if(!flushedFileAppenders.contains(fileAppender) && !fileAppender.getImmediateFlush())
	                        {
	                            flushedFileAppenders.add(fileAppender);
	                            //log.info("Appender "+fileAppender.getName()+" is not doing immediateFlush ");
	                            fileAppender.setImmediateFlush(true);
	                            currentLogger.info("FLUSH");
	                            fileAppender.setImmediateFlush(false);
	                        }
	                        else
	                        {
	                            //log.info("fileAppender"+fileAppender.getName()+" is doing immediateFlush");
	                        }
	                    }
	                }
	            }
	        }
	    }
	    catch(RuntimeException e)
	    {
	        logger.error("Failed flushing logs",e);
	    }
	}



}
