import umontreal.iro.lecuyer.rng.*;
import umontreal.iro.lecuyer.hups.*;
import umontreal.iro.lecuyer.randvar.NormalGen;
import umontreal.iro.lecuyer.probdist.NormalDist;
import umontreal.iro.lecuyer.stat.Tally;
import umontreal.iro.lecuyer.util.*;

public class AsianQMC extends Asian {

   public AsianQMC (double r, double sigma, double strike, 
                    double s0, int s, double[] zeta) {
       super (r, sigma, strike, s0, s, zeta);
   }

   // Makes m independent randomizations of the digital net p using stream 
   // noise. For each of them, performs one simulation run for each point 
   // of p, and adds the average over these points to the collector statQMC.
   public void simulateQMC (int m, DigitalNet p, 
                            RandomStream noise, Tally statQMC) {
      Tally statValue  = new Tally ("stat on value of Asian option");
      PointSetIterator stream = p.iterator ();
      for (int j=0; j<m; j++) {
          p.leftMatrixScramble (noise);
          p.addRandomShift (0, p.getDimension(), noise);
          stream.resetStartStream();
	  simulateRuns (p.getNumPoints(), stream, statValue);
          statQMC.add (statValue.average());
      }
   }


   public static void main (String[] args) { 
      int s = 12;
      double[] zeta = new double[s+1];
      for (int j=0; j<=s; j++) 
         zeta[j] = (double)j / (double)s;
      AsianQMC process = new AsianQMC (0.05, 0.5, 100.0, 100.0, s, zeta); 
      Tally statValue  = new Tally ("value of Asian option");
      Tally statQMC = new Tally ("QMC averages for Asian option");

      Chrono timer = Chrono.createForSingleThread();
      int n = 100000;
      System.out.println ("Ordinary MC:\n");
      process.simulateRuns (n, new MRG32k3a(), statValue);
      System.out.println (statValue.reportAndConfidenceIntervalStudent (0.95, 3));
      System.out.println ("Total CPU time: " + timer.format() + "\n");
      double varMC = statValue.variance();
      double cpuMC = timer.getSeconds() / n;  // CPU seconds per run. 

      timer.init();
      DigitalNet p = new SobolSequence (16, 31, s); // 2^{16} points.
      n = p.getNumPoints(); 
      int m = 20;                     // Number of QMC randomizations.
      process.simulateQMC (m, p, new MRG32k3a(), statQMC);
      System.out.println ("QMC with Sobol point set with " + n + 
          " points and affine matrix scramble:\n");
      System.out.println (statQMC.reportAndConfidenceIntervalStudent (0.95, 4));
      System.out.println ("Total CPU time: " + timer.format() + "\n");
      double varQMC = p.getNumPoints() * statQMC.variance(); 
      double cpuQMC = timer.getSeconds() / (m * n);
      System.out.println ("Variance ratio:  " + 
           PrintfFormat.format (10, 1, 4, varMC/varQMC));
      System.out.println ("Efficiency ratio:" + PrintfFormat.format
           (10, 1, 4, (varMC * cpuMC) / (varQMC * cpuQMC)) + "\n");
   }
}
