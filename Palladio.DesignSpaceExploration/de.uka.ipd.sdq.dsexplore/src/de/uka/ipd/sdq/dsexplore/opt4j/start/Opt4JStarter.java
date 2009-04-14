package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.opt4j.common.archive.ArchiveModule;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.optimizer.ea.EvolutionaryAlgorithmModule;
import org.opt4j.start.Opt4J;
import org.opt4j.start.Opt4JTask;

import com.google.inject.Module;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.cost.CostEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEModule;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEProblem;
import de.uka.ipd.sdq.pcm.cost.CostRepository;

public class Opt4JStarter {
	
	public static IAnalysis analysisTool = null; 
	
	public static CostEvaluator costEvaluator = null;
	
	public static DSEProblem problem = null;
	
	private static Opt4JTask task = null;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	public static void startOpt4J(IAnalysis analysisTool, PCMInstance pcmInstance, int maxIterations, int individualsPerGeneration, CostRepository costs) throws CoreException {
		
		Opt4JStarter.analysisTool = analysisTool;
		Opt4JStarter.costEvaluator = new CostEvaluator(costs);
		Opt4JStarter.problem = new DSEProblem(pcmInstance);
		
		EvolutionaryAlgorithmModule ea = new EvolutionaryAlgorithmModule(); 
	    ea.setGenerations(maxIterations); 
	    ea.setAlpha(individualsPerGeneration);
	    ea.setLambda((int)Math.floor(individualsPerGeneration/2.0+0.5));
	 
	    DSEModule dseModule = new DSEModule(); 
	 
	    /*GUIModule gui = new GUIModule(); 
	    gui.setCloseOnStop(true);*/ 
	    
	    ArchiveModule am = new ArchiveModule();
	    am.setType(ArchiveModule.Type.BASIC);
	    
	    Collection<Module> modules = new ArrayList<Module>(); 
	    modules.add(ea); 
	    modules.add(dseModule);
	    modules.add(am);
	    //modules.add(dtlz);
	    //modules.add(gui); 
	    
	    
 
	    Opt4JStarter.task = new Opt4JTask(false); 
	    task.init(modules); 
	    	 
	    try { 
	      task.execute(); 
	 
	      Archive archive = task.getInstance(Archive.class);
	      
	      logger.warn("------------ RESULTS ----------------------");
	      logger.warn("Printing results (number is "+archive.size()+").");
	      for(Individual individual: archive){ 
	    	  logger.warn("Result for individual "+individual.getGenotype().toString()+" is: "+individual.getObjectives().toString());
	      }
	      logger.warn("------------ CSV RESULTS ----------------------");
	      String output = "\n";
	      
	      {
	      //headline
	      //first objectives
	      Individual i = archive.iterator().next();
	      Objectives objs = i.getObjectives();
	      for (Entry<Objective, Value<?>> entry : objs) {
	    	  output += entry.getKey().getName() +"("+entry.getKey().getSign()+");";
		  }
	      //then genes
	      DoubleGenotype genes = (DoubleGenotype)i.getGenotype();
	      for (int j = 0; j < genes.size(); j++) {
			  output += "gene"+j+";";
		  }	      
	      output += "\n";
	      }
	      
	      //content
	      for (Individual ind : archive) {
			  //first objectives
		      Objectives objs = ind.getObjectives();
		      for (Entry<Objective, Value<?>> entry : objs) {
		    	  output += entry.getValue()+ ";";
			  }
		      DoubleGenotype genes = (DoubleGenotype)ind.getGenotype();
		      for (Double gene : genes) {
				output += gene+";";
			  }
			  output += "\n";	
		  }
	      logger.warn(output);
	      
	    } catch (CoreException e ){
	    	throw e;
	    } catch (Exception e) { 
	      throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, e.getMessage(), e)); 
	    } 
	}
	
	public static void closeTask(){
      Opt4JStarter.task.close(); 
	}
	
	@Deprecated
	public static void startOpt4JWithGUI(){
		//String id = Opt4JPluginActivator.PLUGIN_ID;
		
		try {
			Opt4J.main(new String[0]);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
