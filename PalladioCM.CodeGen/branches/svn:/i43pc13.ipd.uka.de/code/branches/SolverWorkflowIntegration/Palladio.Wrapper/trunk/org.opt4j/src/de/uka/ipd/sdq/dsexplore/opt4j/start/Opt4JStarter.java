package de.uka.ipd.sdq.dsexplore.opt4j.start;

//import org.opt4j.Opt4JPluginActivator;
import java.util.ArrayList;
import java.util.Collection;

import org.opt4j.benchmark.dtlz.DTLZModule;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.optimizer.ea.EvolutionaryAlgorithmModule;
import org.opt4j.start.Opt4J;
import org.opt4j.start.Opt4JTask;

import com.google.inject.Module;

public class Opt4JStarter {

	public static void startOpt4J(){
		
		EvolutionaryAlgorithmModule ea = new EvolutionaryAlgorithmModule(); 
	    //ea.setGenerations(500); 
	    //ea.setAlpha(100); 
	 
	    //DSEModule dseModule = new DSEModule(); 
	    DTLZModule dtlz = new DTLZModule(); 
	    dtlz.setFunction(DTLZModule.Function.DTLZ1);
	 
	    /*GUIModule gui = new GUIModule(); 
	    gui.setCloseOnStop(true);*/ 
	 
	    Collection<Module> modules = new ArrayList<Module>(); 
	    modules.add(ea); 
	    //modules.add(dseModule);
	    modules.add(dtlz);
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
