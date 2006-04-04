package de.uka.ipd.sdq.simucom;

import java.util.Vector;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.Package;
import org.eclipse.uml2.UML2Package;

import com.sun.security.auth.login.ConfigFile;

import de.uka.ipd.sdq.simucom.user.User;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimTime;

public class SimuComModel extends Model {

	protected ModelSetup setup;
	protected static String configFile = null;
	Vector<User> users = null;
	
	public SimuComModel(Model arg0, String arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String description() {
		return "SimuCom Simulation";
	}

	@Override
	public void doInitialSchedules() {
		for (User u : users)
		{
			u.activate(new SimTime(0));
		}
	}

	@Override
	public void init() {
		setup =  new ModelSetup(this, configFile);
		users = setup.getUser();
	}

	/**
	 * Runs the model.
	 *
	 * @param args is an array of command-line arguments (will be ignored here)
	 */
	public static void main(java.lang.String[] args) {

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
	                         "SimuCom Model", true, true);
	    // null as first parameter because it is the main model and has no mastermodel
	   Experiment exp = new Experiment("SimuCom Experiment");
	    // ATTENTION, since the name of the experiment is used in the names of the 
	    // output files, you have to specify a string that's compatible with the 
	    // filename constraints of your computer's operating system.
	   model.connectToExperiment(exp);
	   	//	 set experiment parameters
	   exp.setShowProgressBar(true);  // display a progress bar (or not)
	   exp.stop(new SimTime(1500));   // set end of simulation at 1500 time units
	   exp.tracePeriod(new SimTime(0.0), new SimTime(1500));
	                                              // set the period of the trace
	   exp.debugPeriod(new SimTime(0.0), new SimTime(1500));   // and debug output
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
