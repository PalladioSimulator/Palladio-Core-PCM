import de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum;
import de.uka.ipd.sdq.measurement.strategies.activeresource.IDemandStrategy;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.*;

import org.apache.log4j.Logger;

public class test {
	public static void main(String[] args) {
		
		IDemandStrategy theStrategy;
		theStrategy = new MandelbrotDemand();
		theStrategy.initializeStrategy(DegreeOfAccuracyEnum.MEDIUM, 1000);
		theStrategy.consume(5);
		theStrategy.consume(50);
		theStrategy.consume(500);
		theStrategy.consume(5000);

//		int[] strat = { -3, -2, -1, 0, 1, 2, 3 }; // , 1
//		for (int i = 0; i < strat.length; i++) {
//			AbstractDemandStrategy theStrategy;
//			theStrategy = new FibonacciDemand();
//			theStrategy.initialiseStrategy(strat[i], 1000);
//			theStrategy.watchConsume(5);
//			theStrategy.watchConsume(50);
//			theStrategy.watchConsume(500);
//			theStrategy.watchConsume(5000);
//			theStrategy = null;
//			Logger.shutdown();
//		}
//
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
