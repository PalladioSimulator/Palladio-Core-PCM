import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.measurement.strategies.activeresource.AbstractDemandStrategy;
import de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand;

public class test {
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.INFO);
		
		AbstractDemandStrategy theStrategy;
//		theStrategy = new ReadLargeChunksDemand();
//		theStrategy.initializeStrategy(DegreeOfAccuracyEnum.MEDIUM, 1000,"/Users/snowball/Documents/proto_calib");
//		theStrategy.watchConsume(5);
//		theStrategy.watchConsume(50);
//		theStrategy.watchConsume(500);
//		theStrategy.watchConsume(5000);

		for (DegreeOfAccuracyEnum degree : DegreeOfAccuracyEnum.values()) {
			theStrategy = new FibonacciDemand();
			theStrategy.initializeStrategy(degree, 1000, "/Users/snowball/Documents/proto_calib");
			theStrategy.watchConsume(5);
			theStrategy.watchConsume(50);
			theStrategy.watchConsume(500);
			theStrategy.watchConsume(5000);
			theStrategy = null;
		}

//		int[] strat1 = { -3, -2, -1, 0, 1, 2, 3 };
//		for (int i = 0; i < strat1.length; i++) {
//			AbstractDemandStrategy theStrategy;
//			theStrategy = new CalculatePrimesDemand();
//			theStrategy.initialiseStrategy(strat1[i], 1000);
//			theStrategy.watchConsume(5);
//			theStrategy.watchConsume(50);
//			theStrategy.watchConsume(500);
//			theStrategy.watchConsume(5000);
//			theStrategy = null;
//			Logger.shutdown();
//		}
//
//		int[] strat2 = { -3, -2, -1, 0, 1, 2, 3 };
//		for (int i = 0; i < strat2.length; i++) {
//			AbstractDemandStrategy theStrategy;
//			theStrategy = new CountNumbersDemand();
//			theStrategy.initialiseStrategy(strat2[i], 1000);
//			theStrategy.watchConsume(5);
//			theStrategy.watchConsume(50);
//			theStrategy.watchConsume(500);
//			theStrategy.watchConsume(5000);
//			theStrategy = null;
//			Logger.shutdown();
//		}
//
//		int[] strat3 = { -3, -2, -1, 0, 1, 2, 3 };
//		for (int i = 0; i < strat3.length; i++) {
//			AbstractDemandStrategy theStrategy;
//			theStrategy = new VoidDemand();
//			theStrategy.initialiseStrategy(strat3[i], 1000);
//			theStrategy.watchConsume(5);
//			theStrategy.watchConsume(50);
//			theStrategy.watchConsume(500);
//			theStrategy.watchConsume(5000);
//			theStrategy = null;
//			Logger.shutdown();
//		}
//
//		int[] strat4 = { -3, -2, -1, 0, 1, 2, 3 };
//		for (int i = 0; i < strat4.length; i++) {
//			AbstractDemandStrategy theStrategy;
//			theStrategy = new SortArrayDemand();
//			theStrategy.initialiseStrategy(strat4[i], 1000);
//			theStrategy.watchConsume(5);
//			theStrategy.watchConsume(50);
//			theStrategy.watchConsume(500);
//			theStrategy.watchConsume(5000);
//			theStrategy = null;
//			Logger.shutdown();
//		}
//
//		int[] strat5 = { -5, -4, -3, -2, -1, 0, 1 };
//		for (int i = 0; i < strat5.length; i++) {
//			AbstractDemandStrategy theStrategy;
//			theStrategy = new FFTDemand();
//			theStrategy.initialiseStrategy(strat5[i], 1000);
//			theStrategy.watchConsume(5);
//			theStrategy.watchConsume(50);
//			theStrategy.watchConsume(500);
//			theStrategy.watchConsume(5000);
//			theStrategy = null;
//			Logger.shutdown();
//		}
//
//		int[] strat6 = { -3, -2, -1, 0, 1, 2, 3 };
//		for (int i = 0; i < strat6.length; i++) {
//			AbstractDemandStrategy theStrategy;
//			theStrategy = new WaitDemand();
//			theStrategy.initialiseStrategy(strat6[i], 1000);
//			theStrategy.watchConsume(5);
//			theStrategy.watchConsume(50);
//			theStrategy.watchConsume(500);
//			theStrategy.watchConsume(5000);
//			theStrategy = null;
//			Logger.shutdown();
//		}
//
//		int[] strat7 = { -3, -2, -1, 0, 1, 2, 3 };
//		for (int i = 0; i < strat7.length; i++) {
//			AbstractDemandStrategy theStrategy;
//			theStrategy = new MandelbrotDemand();
//			theStrategy.initialiseStrategy(strat7[i], 1000);
//			theStrategy.watchConsume(5);
//			theStrategy.watchConsume(50);
//			theStrategy.watchConsume(500);
//			theStrategy.watchConsume(5000);
//			theStrategy = null;
//			Logger.shutdown();
//		}
	}
}
