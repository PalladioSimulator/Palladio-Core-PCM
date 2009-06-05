import umontreal.iro.lecuyer.simevents.*;
import umontreal.iro.lecuyer.simprocs.*;
import umontreal.iro.lecuyer.rng.*;
import umontreal.iro.lecuyer.probdist.ExponentialDist;
import umontreal.iro.lecuyer.randvar.RandomVariateGen;
import umontreal.iro.lecuyer.stat.*;
// import umontreal.iro.lecuyer.simprocs.dsol.SimProcess;

public class QueueProc {
   Resource server = new Resource (1, "Server");
   RandomVariateGen genArr;
   RandomVariateGen genServ;

   public QueueProc (double lambda, double mu) {
      genArr = new RandomVariateGen (new MRG32k3a(), new ExponentialDist(lambda));
      genServ = new RandomVariateGen (new MRG32k3a(), new ExponentialDist (mu));
   }

   public void simulateOneRun (double timeHorizon) {
      SimProcess.init();
      server.setStatCollecting (true);
      new EndOfSim().schedule (timeHorizon);
      new Customer().schedule (genArr.nextDouble());
      Sim.start();
   }

   class Customer extends SimProcess {
      public void actions() {
         new Customer().schedule (genArr.nextDouble());
         server.request (1);
         delay (genServ.nextDouble());
         server.release (1);
      }
   }

   class EndOfSim extends Event {
      public void actions() {
         Sim.stop();
      }
   }

   public static void main (String[] args) { 
      QueueProc queue = new QueueProc (1.0, 2.0);
      queue.simulateOneRun (1000.0);
      System.out.println (queue.server.report());
   }
}
