package de.uka.ipd.sdq.scheduler;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import umontreal.iro.lecuyer.simevents.Sim;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;

public class LoggingWrapper {
	
	public static Logger logger = Logger.getLogger("Scheduler");

	public static void activate(){
		logger.setLevel(Level.ALL);
	}
	
	public static void deactivate(){
		logger.setLevel(Level.OFF);
	}
	
	public static void log(String string) {
		logger.info(MathTools.round(Sim.time(), 0.01) + " " + string);
	}

}
