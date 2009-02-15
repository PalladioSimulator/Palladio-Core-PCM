package de.uka.ipd.sdq.simucomframework;

import org.apache.log4j.Logger;

import umontreal.iro.lecuyer.rng.MRG32k3a;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;


public class SimuComDefaultRandomNumberGenerator implements IRandomGenerator {

	private static Logger logger = 
		Logger.getLogger(SimuComDefaultRandomNumberGenerator.class.getName());
	private static long streamCounter = 0;
	private long myID;
	private MRG32k3a rndNumberGenerator = null;
	
	public SimuComDefaultRandomNumberGenerator(long[] randomSeed){
		myID = streamCounter++;
		logger.debug("Initialising random number generator! [Stream ID = "+myID+"]");
		rndNumberGenerator = new MRG32k3a();
		if (randomSeed != null) {
			if (randomSeed.length == 6) {
				logger.debug("Setting fixed seed for random number generator! [Stream ID = "+myID+"]");
				rndNumberGenerator.setSeed(randomSeed);
			}
			else {
				throw new RuntimeException("Seed array must have length of six longs for initialising random number generator");
			}
		}
		logger.debug("Random number generator initialised! [Stream ID = "+myID+"]");
	}
	
	public double random() {
		logger.debug("Drawing a random number from random number stream ["+myID+"]!");
		double d = rndNumberGenerator.nextDouble();
		logger.debug("Number is: "+d);
		
		return d;
	}

}
