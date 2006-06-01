package de.uka.ipd.sdq.simucom;

import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.SimTime;

public class Main {
	private static final int SIMULATION_TIME = 15000;

	/**
	 * Runs the model.
	 *
	 * @param args is an array of command-line arguments (will be ignored here)
	 */
	public static void main(java.lang.String[] args) {
		String configFile = null;
		if (args.length != 1)
		{
			System.out.println("Usage: SimuCom <configfile.xml>");
			System.exit(-1);
		}
		else
		{
			configFile = args[0];
		}
		
		// create model and experiment
	   SimuComModel model = new SimuComModel(null, 
	                         "SimuCom Model", true, true, configFile);
	    // null as first parameter because it is the main model and has no mastermodel
	   Experiment exp = new Experiment("SimuCom Experiment");
	    // ATTENTION, since the name of the experiment is used in the names of the 
	    // output files, you have to specify a string that's compatible with the 
	    // filename constraints of your computer's operating system.
	   model.connectToExperiment(exp);
	   	//	 set experiment parameters
	   exp.setShowProgressBar(true);  // display a progress bar (or not)
	   exp.stop(new SimTime(SIMULATION_TIME));   // set end of simulation at 1500 time units
	   exp.tracePeriod(new SimTime(0.0), new SimTime(SIMULATION_TIME));
	                                              // set the period of the trace
	   exp.debugPeriod(new SimTime(0.0), new SimTime(SIMULATION_TIME));   // and debug output
	      // ATTENTION!
	      // Don't use too long periods. Otherwise a huge HTML page will
	      // be created which crashes Netscape :-)
	   exp.start();
	   
	   //	 generate the report (and other output files)
	   exp.report();

	   // stop all threads still alive and close all output files
	   exp.finish();	   
	}
}
