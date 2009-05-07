package de.uka.ipd.sdq.simucomframework;

import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import umontreal.iro.lecuyer.rng.MRG32k3a;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;


public class SimuComDefaultRandomNumberGenerator implements IRandomGenerator {

	private static final int MAX_PRODUCER_BUFFER_SIZE = 1000;
	private static Logger logger = 
		Logger.getLogger(SimuComDefaultRandomNumberGenerator.class.getName());
	private static long streamCounter = 0;
	private long myID;
	private MRG32k3a rndNumberGenerator = null;
	private LinkedBlockingQueue<Double> producerQueue = new LinkedBlockingQueue<Double>(MAX_PRODUCER_BUFFER_SIZE);
	private Thread producerThread;
	private boolean finished;
	
	public SimuComDefaultRandomNumberGenerator(long[] randomSeed){
		myID = streamCounter++; finished = false;
		logger.debug("Initialising random number generator! [Stream ID = "+myID+"]");
		rndNumberGenerator = new MRG32k3a();
		if (randomSeed != null) {
			if (randomSeed.length == 6) {
				logger.debug("Setting fixed seed for random number generator! [Stream ID = "+myID+"]");
				for (int i=0; i<6; i++) {
					logger.debug("Seed "+i+" = "+randomSeed[i]);
				}
				rndNumberGenerator.setSeed(randomSeed);
			}
			else {
				throw new RuntimeException("Seed array must have length of six longs for initialising random number generator");
			}
		}
		producerThread = new Thread(new Runnable(){
			public void run() {
				logger.debug("Random number producer started! [Stream ID = "+myID+"]");
				try {
					while (!finished) {
						producerQueue.put(rndNumberGenerator.nextDouble());
					}
				} catch (InterruptedException e) {
					logger.debug("Bad concurrency problem",e);
					throw new RuntimeException("Unexpected interruption of concurrent threads");
				}
				logger.debug("Random number producer stopped! [Stream ID = "+myID+"]");
			}
		});
		producerThread.start();
		logger.debug("Random number stream initialised! [Stream ID = "+myID+"]");
	}
	
	public double random() {
		logger.debug("Drawing a random number from random number stream ["+myID+"]!");
		double d;
		try {
			d = producerQueue.take();
		} catch (InterruptedException e) {
			throw new RuntimeException("Unexpected interruption of concurrent threads");
		}
		logger.debug("Number is: "+d);
		
		return d;
	}

	public void dispose() {
		finished = true;
		producerQueue.clear();
	}

}
