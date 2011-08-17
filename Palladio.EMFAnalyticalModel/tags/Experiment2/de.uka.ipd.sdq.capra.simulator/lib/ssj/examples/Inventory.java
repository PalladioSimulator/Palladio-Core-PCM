import umontreal.iro.lecuyer.rng.*;
import umontreal.iro.lecuyer.randvar.*;
import umontreal.iro.lecuyer.probdist.PoissonDist;
import umontreal.iro.lecuyer.stat.Tally;
import umontreal.iro.lecuyer.util.Chrono;

public class Inventory {

   double lambda;  // Mean demand size.
   double c;       // Sale price.
   double h;       // Inventory cost per item per day.
   double K;       // Fixed ordering cost.
   double k;       // Marginal ordering cost per item.
   double p;       // Probability that an order arrives.

   RandomVariateGenInt genDemand;
   RandomStream streamDemand = new MRG32k3a();
   RandomStream streamOrder  = new MRG32k3a();
   Tally statProfit          = new Tally ("stats on profit");
 
   public Inventory (double lambda, double c, double h, 
                     double K, double k, double p) {
      this.lambda = lambda;  
      this.c = c;  this.h = h;  this.K = K;  this.k = k;  this.p = p;
      genDemand = new PoissonGen (streamDemand, new PoissonDist (lambda));
   }

   // Simulates the system for m days, with the (s,S) policy,
   // and returns the average profit per day.
   public double simulateOneRun (int m, int s, int S) {
       int Xj = S, Yj;         // Stock in the morning and in the evening.
       double profit = 0.0;    // Cumulated profit.
       for (int j=0; j<m; j++) {
	   Yj = Xj - genDemand.nextInt(); // Subtract demand for the day.
           if (Yj < 0) Yj = 0;            // Lost demand.
           profit += c * (Xj - Yj) - h * Yj;
           if ((Yj < s) && (streamOrder.nextDouble() < p)) { 
	       // We have a successful order.
	       profit -= K + k * (S - Yj);
	       Xj = S;
	   }
           else
	       Xj = Yj;
       }
       return profit / m;
   }

   // Performs n independent simulation runs of the system for m days,
   // with the (s,S) policy, and returns a report with a 90% confidence 
   // interval on the expected average profit per day.
   public void simulateRuns (int n, int m, int s, int S) {
      for (int i=0; i<n; i++)
	  statProfit.add (simulateOneRun (m, s, S));
   }

   public static void main (String[] args) { 
      Chrono timer = Chrono.createForSingleThread();
      Inventory system = new Inventory (100.0, 2.0, 0.1, 10.0, 1.0, 0.95); 
      system.simulateRuns (500, 2000, 80, 200);
      System.out.println (
          system.statProfit.reportAndConfidenceIntervalStudent (0.9, 3));
      System.out.println ("Total CPU time: " + timer.format());
   }
}