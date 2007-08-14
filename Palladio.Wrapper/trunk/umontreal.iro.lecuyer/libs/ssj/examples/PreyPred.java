import umontreal.iro.lecuyer.simevents.*;

public class PreyPred {
   double r  = 0.005,      c  = 0.00001,
          s  = 0.01,       d  = 0.000005,     h = 5.0;
   double x0 = 2000.0,     z0 = 150.0;
   double horizon = 501.0;
   Continuous x = new Preys();
   Continuous z = new Preds();

   public static void main (String[] args) { new PreyPred(); }

   public PreyPred() {
      Sim.init();
      new EndOfSim().schedule (horizon);
      new PrintPoint().schedule (h);
      Continuous.selectRungeKutta4 (h);
      x.startInteg (x0);    z.startInteg (z0);
      Sim.start();
   }

   public class Preys extends Continuous {
      public double derivative (double t) {
         return (r * value() - c * value() * z.value());
      }
   }

   public class Preds extends Continuous {
      public double derivative (double t) {
         return (-s * value() + d * x.value() * value());
      }
   }

   class PrintPoint extends Event {
      public void actions() { 
         System.out.println (Sim.time() + "  " 
               + x.value() + "  " + z.value());
         this.schedule (h);
      }
   }

   class EndOfSim extends Event {
      public void actions() { Sim.stop(); }
   }
}
