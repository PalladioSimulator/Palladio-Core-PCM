import java.util.*;
import umontreal.iro.lecuyer.stat.*;
import umontreal.iro.lecuyer.simevents.*;
import umontreal.iro.lecuyer.rng.*;
import umontreal.iro.lecuyer.probdist.ExponentialDist;
import umontreal.iro.lecuyer.randvar.RandomVariateGen;

public class QueueObs {

   Tally waitingTimes = new Tally ("Waiting times");
   Tally averageWaits = new Tally ("Average wait");
   RandomVariateGen genArr;
   RandomVariateGen genServ;
   int cust;    // Number of the current customer.

   public QueueObs (double lambda, double mu, int step) {
      genArr = new RandomVariateGen (new MRG32k3a(), new ExponentialDist(lambda));
      genServ = new RandomVariateGen (new MRG32k3a(), new ExponentialDist (mu));
      waitingTimes.setBroadcasting (true);
      waitingTimes.addObserver (new ObservationTrace (step));
      waitingTimes.addObserver (new LargeWaitsCollector (2.0));
   }

   public double simulateOneRun (int numCust) {
      waitingTimes.init();
      double Wi = 0.0;
      waitingTimes.add (Wi);
      for (cust = 2; cust <= numCust; cust++) {
         Wi += genServ.nextDouble() - genArr.nextDouble();
         if (Wi < 0.0) Wi = 0.0;
         waitingTimes.add (Wi);
      }
      return waitingTimes.average();
   }

   public void simulateRuns (int n, int numCust) {
      averageWaits.init();
      for (int i=0; i<n; i++)
	  averageWaits.add (simulateOneRun (numCust));
   }

   public class ObservationTrace implements Observer {
      private int step;

      public ObservationTrace (int step) {
         this.step = step;
      }

      public void update (Observable o, Object x) {
         if (cust % step == 0)
            System.out.println ("Customer " + cust + " waited " 
                   + ((Double)x).doubleValue() + " time units.");
      }
   }

   public class LargeWaitsCollector implements Observer {
      double threshold;
      ArrayList largeWaits = new ArrayList();

      public LargeWaitsCollector (double threshold) {
         this.threshold = threshold;
      }

      public void update (Observable o, Object x) {
         double xx = ((Double)x).doubleValue();
         if (xx > threshold) largeWaits.add (x);
      }

      public String formatLargeWaits () {
	  // Should print the list largeWaits. 
	  return "not yet implemented...";
      }
   }

   public static void main (String[] args) { 
      QueueObs queue = new QueueObs (1.0, 2.0, 5);
      queue.simulateRuns (2, 100);
      System.out.println ("\n\n" + queue.averageWaits.report());
   }
}
