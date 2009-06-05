import umontreal.iro.lecuyer.simevents.*;
import umontreal.iro.lecuyer.rng.*;
import umontreal.iro.lecuyer.randvar.*;
import umontreal.iro.lecuyer.probdist.*;
import umontreal.iro.lecuyer.stat.Tally;
import java.io.*;
import java.util.StringTokenizer;

public class CallEv {

   static final double HOUR = 3600.0;  // Time is in seconds. 

   // Data
   // Arrival rates are per hour, service and patience times are in seconds.
   int numDays;           // Number of days to simulate.
   double openingTime;    // Opening time of the center (in hours).
   int numPeriods;        // Number of working periods (hours) in the day.
   int[] numAgents;       // Number of agents for each period.   
   double[] lambda;       // Base arrival rate lambda_j for each j.
   double alpha0;         // Parameter of gamma distribution for W.
   double p;              // Probability that patience time is 0.
   double nu;             // Parameter of exponential for patience time.
   double alpha, beta;    // Parameters of gamma service time distribution. 
   double s;              // Want stats on waiting times smaller than s.

   // Variables
   double busyness;       // Current value of W.
   double arrRate = 0.0;  // Current arrival rate.
   int nAgents;           // Number of agents in current period.
   int nBusy;             // Number of agents occupied;
   int nArrivals;         // Number of arrivals today;
   int nAbandon;          // Number of abandonments during the day.
   int nGoodQoS;          // Number of waiting times less than s today.
   double nCallsExpected; // Expected number of calls per day.

   Event nextArrival = new Arrival();           // The next Arrival event.

   RandomStream streamW        = new MRG32k3a(); // For W.
   RandomStream streamArr      = new MRG32k3a(); // For arrivals.
   RandomStream streamPatience = new MRG32k3a(); // For patience times.
   GammaGen genServ;   // For service times; created in readData().
 
   LinkedListStat waitList = new LinkedListStat ("Waiting calls");

   Tally statArrivals = new Tally ("Number of arrivals per day");
   Tally statWaits    = new Tally ("Average waiting time per customer");
   Tally statWaitsDay = new Tally ("Waiting times within a day");
   Tally statGoodQoS  = new Tally ("Proportion of waiting times < s");
   Tally statAbandon  = new Tally ("Proportion of calls lost");

   class Call { double arrivTime, servTime, patienceTime; } 

   static public void main (String[] args) throws IOException { new CallEv(); }
  
   public CallEv() throws IOException {
      readData();
      for (int i=1; i <= numDays; i++)  simulOneDay();
      System.out.println ("\n Num. calls expected = " + nCallsExpected +"\n");
      System.out.println (statArrivals.reportAndConfidenceIntervalStudent (0.9, 3));
      System.out.println (statWaits.reportAndConfidenceIntervalStudent (0.9, 3));
      System.out.println (statGoodQoS.reportAndConfidenceIntervalStudent (0.9, 3));
      System.out.println (statAbandon.reportAndConfidenceIntervalStudent (0.9, 4));   
   }

   class NextPeriod extends Event {
      int j;     // Number of the new period.
      public NextPeriod (int period) { j = period; }
      public void actions() {
         if (j < numPeriods) {
            nAgents = numAgents[j];
            arrRate = busyness * lambda[j] / HOUR;
            if (j == 0) 
               nextArrival.schedule 
                  (ExponentialDist.inverseF (arrRate, streamArr.nextDouble()));
            else {
               checkQueue();
               nextArrival.reschedule ((nextArrival.time() - Sim.time()) 
                                       * lambda[j-1] / lambda[j]);
            }
            new NextPeriod(j+1).schedule (1.0 * HOUR);
         }
         else
            nextArrival.cancel();  // End of the day.
      }
   }

   class Arrival extends Event {
      public void actions() {
         nextArrival.schedule 
            (ExponentialDist.inverseF (arrRate, streamArr.nextDouble()));
         nArrivals++;
         Call call = new Call();               // Call just arrived.
         call.servTime = genServ.nextDouble(); // Generate service time.
         if (nBusy < nAgents) {          // Start service immediately.
            nBusy++;
            nGoodQoS++;
            statWaitsDay.add (0.0);
            new CallCompletion().schedule (call.servTime);
         } else {                        // Join the queue.
            call.patienceTime = generPatience();
            call.arrivTime = Sim.time();
            waitList.addLast (call);
         }
      }
   }

   class CallCompletion extends Event {
      public void actions() { nBusy--;   checkQueue(); }
   }

   public void checkQueue() {
      // Start answering new calls if agents are free and queue not empty.
      while ((waitList.size() > 0) && (nBusy < nAgents)) {
         Call call = (Call)waitList.removeFirst();
         double wait = Sim.time() - call.arrivTime;
         if (call.patienceTime < wait) { // Caller has abandoned.
            nAbandon++;
            wait = call.patienceTime;    // Effective waiting time.
         }
         else {
            nBusy++;
            new CallCompletion().schedule (call.servTime);
         }
         if (wait < s) nGoodQoS++;
         statWaitsDay.add (wait);
      }
   }

   public double generPatience() {
      // Generates the patience time for a call.
      double u = streamPatience.nextDouble();
      if (u <= p) 
         return 0.0;
      else 
         return ExponentialDist.inverseF (nu, (1.0-u) / (1.0-p));
   }

   public void readData() throws IOException {
      // Reads data and construct arrays.
      BufferedReader input = new BufferedReader (new FileReader ("CallEv.dat"));
      StringTokenizer line = new StringTokenizer (input.readLine());
      numDays     = Integer.parseInt (line.nextToken());
      line = new StringTokenizer (input.readLine());
      openingTime = Double.parseDouble (line.nextToken());
      line = new StringTokenizer (input.readLine());
      numPeriods  = Integer.parseInt (line.nextToken());

      numAgents = new int[numPeriods];
      lambda = new double[numPeriods];
      nCallsExpected = 0.0;
      for (int j=0; j < numPeriods; j++) {
         line = new StringTokenizer (input.readLine());
         numAgents[j] = Integer.parseInt (line.nextToken());
         lambda[j]    = Double.parseDouble (line.nextToken());
         nCallsExpected += lambda[j];
      }
      line = new StringTokenizer (input.readLine());
      alpha0 = Double.parseDouble (line.nextToken());
      line = new StringTokenizer (input.readLine());
      p = Double.parseDouble (line.nextToken());
      line = new StringTokenizer (input.readLine());
      nu = Double.parseDouble (line.nextToken());
      line = new StringTokenizer (input.readLine());
      alpha = Double.parseDouble (line.nextToken());
      line = new StringTokenizer (input.readLine());
      beta = Double.parseDouble (line.nextToken());
      // genServ can be created only after its parameters are known.
      genServ = new GammaAcceptanceRejectionGen (
                    new MRG32k3a(), new GammaDist (alpha, beta));
                                 // Faster than inversion.
      line = new StringTokenizer (input.readLine());
      s = Double.parseDouble (line.nextToken());
      input.close();
   }

   public void simulOneDay() { 
      Sim.init();        statWaitsDay.init();
      nArrivals = 0;     nAbandon = 0;     
      nGoodQoS = 0;      nBusy = 0;
      busyness = GammaDist.inverseF (alpha0, alpha0, 8, streamW.nextDouble());
      new NextPeriod(0).schedule (openingTime * HOUR);
      Sim.start();
      // Here the simulation is running...
      statArrivals.add ((double)nArrivals);
      statAbandon.add ((double)nAbandon / nCallsExpected);
      statGoodQoS.add ((double)nGoodQoS / nCallsExpected);
      statWaits.add (statWaitsDay.sum() / nCallsExpected);
   }
}
