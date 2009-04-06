package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.optimizer.ea.EvolutionaryAlgorithmModule;
import org.opt4j.start.Opt4J;
import org.opt4j.start.Opt4JTask;

import com.google.inject.Module;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.cost.CostEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEModule;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEProblem;
import de.uka.ipd.sdq.pcm.cost.CostRepository;

public class Opt4JStarter {
	
	public static IAnalysis analysisTool = null; 
	
	public static CostEvaluator costEvaluator = null;
	
	public static DSEProblem problem = null;

	public static void startOpt4J(IAnalysis analysisTool, PCMInstance pcmInstance, int maxIterations, CostRepository costs) throws CoreException{
		
		Opt4JStarter.analysisTool = analysisTool;
		Opt4JStarter.costEvaluator = new CostEvaluator(costs);
		Opt4JStarter.problem = new DSEProblem(pcmInstance);
		
		EvolutionaryAlgorithmModule ea = new EvolutionaryAlgorithmModule(); 
	    ea.setGenerations(maxIterations); 
	    ea.setAlpha(2);
	    ea.setLambda(2);
	 
	    DSEModule dseModule = new DSEModule(); 
	 
	    /*GUIModule gui = new GUIModule(); 
	    gui.setCloseOnStop(true);*/ 
	 
	    Collection<Module> modules = new ArrayList<Module>(); 
	    modules.add(ea); 
	    modules.add(dseModule);
	    //modules.add(dtlz);
	    //modules.add(gui); 
	 
	    Opt4JTask task = new Opt4JTask(false); 
	    task.init(modules); 
	 
	    try { 
	      task.execute(); 
	      Archive archive = task.getInstance(Archive.class); 
	 
	      System.out.println("Printing results (number is "+archive.size()+").");
	      for(Individual individual: archive){ 
	        System.out.println("One result is: "+individual.getObjectives().toString());
	      } 
	 
	    } catch (Exception e) { 
	      e.printStackTrace(); 
	    } finally { 
	      task.close(); 
	    } 
	}
	
	public static void sayHi(){}
	
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
