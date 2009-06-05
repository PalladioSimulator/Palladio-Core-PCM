import umontreal.iro.lecuyer.rng.*;
import umontreal.iro.lecuyer.randvar.*;
import umontreal.iro.lecuyer.probdist.PoissonDist;
import umontreal.iro.lecuyer.stat.Tally;
import umontreal.iro.lecuyer.util.*;

public class InventoryCRN extends Inventory {

   Tally statDiff = new Tally ("stats on difference");

   public InventoryCRN (double lambda, double c, double h, 
                        double K, double k, double p) {
      super (lambda, c, h, K, k, p);
   }

   public void simulateDiff (int n, int m, int s1, int S1, int s2, int S2) {
      double value1, value2;
      statDiff.init();
      for (int i=0; i<n; i++) {
         value1 = simulateOneRun (m, s1, S1);
         value2 = simulateOneRun (m, s2, S2);
         statDiff.add (value2 - value1);
      }
   }

   public void simulateDiffCRN (int n, int m, int s1, int S1, int s2, int S2) {
      double value1, value2;
      statDiff.init();
      streamDemand.resetStartStream();
      streamOrder.resetStartStream();
      for (int i=0; i<n; i++) {
         value1 = simulateOneRun (m, s1, S1);
         streamDemand.resetStartSubstream();
         streamOrder.resetStartSubstream();
         value2 = simulateOneRun (m, s2, S2);
         statDiff.add (value2 - value1);
         streamDemand.resetNextSubstream();
         streamOrder.resetNextSubstream();
      }
   }

   public static void main (String[] args) { 
      InventoryCRN system = new InventoryCRN 
          (100.0, 2.0, 0.1, 10.0, 1.0, 0.95); 

      Chrono timer = Chrono.createForSingleThread();
      system.simulateDiff (5000, 200, 80, 198, 80, 200);
      System.out.println (
          system.statDiff.reportAndConfidenceIntervalStudent (0.9, 3));
      double varianceIndep = system.statDiff.variance();
      System.out.println ("Total CPU time: " + timer.format() + "\n");

      timer.init();
      system.simulateDiffCRN (5000, 200, 80, 198, 80, 200);
      System.out.println (
          system.statDiff.reportAndConfidenceIntervalStudent (0.9, 3));
      double varianceCRN = system.statDiff.variance();
      System.out.println ("Total CPU time: " + timer.format());

      System.out.println ("Variance ratio:  " + 
           PrintfFormat.format (7, 4, 1, varianceIndep / varianceCRN));
   }
}
