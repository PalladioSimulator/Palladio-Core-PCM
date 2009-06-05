/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * Copyright (c) 1997,1998 Sun Microsystems, Inc. All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */

package spec.benchmarks.scimark.monte_carlo;

import java.io.PrintStream;
import spec.benchmarks.scimark.utils.Constants;
import spec.benchmarks.scimark.utils.Random;
import spec.benchmarks.scimark.utils.Stopwatch;

/**
 * Estimate Pi by approximating the area of a circle.
 *
 * How: generate N random numbers in the unit square, (0,0) to (1,1)
 * and see how are within a radius of 1 or less, i.e.
 * <pre>
 *
 * sqrt(x^2 + y^2) < r
 *
 * </pre>
 * since the radius is 1.0, we can square both sides
 * and avoid a sqrt() computation:
 * <pre>
 *
 * x^2 + y^2 <= 1.0
 *
 * </pre>
 * this area under the curve is (Pi * r^2)/ 4.0,
 * and the area of the unit of square is 1.0,
 * so Pi can be approximated by
 * <pre>
 * # points with x^2+y^2 < 1
 * Pi =~ 		--------------------------  * 4.0
 * total # points
 *
 * </pre>
 *
 */

public class MonteCarlo {
    private final static PrintStream o = System.out;
    final static int SEED = 113;
    
    /**
     * @deprecated because not used by us ;-)
     */
    public static void main() {
        MonteCarlo mc = new MonteCarlo();
        mc.run_MK();
    }
    
    public static void main(String[] args) {
        MonteCarlo mc = new MonteCarlo();
        int cmdCycles = 0;
        if(args.length==1){
        	try{
        		cmdCycles = new Integer(args[0]);
        		mc.setCycles_MK(cmdCycles);
            	System.out.println("Command line arguments received, running with "+mc.getCycles_MK()+" cycles");
        	}catch (Exception e) {
				System.out.println("Command line parameter "+args[0]+" " +
						"could not be converted to a number; " +
						"taking the default ("+mc.getCycles_MK()+")");
			}
        }else{
        	System.out.println("No command line arguments received, running with "+mc.getCycles_MK()+" cycles");
        }
        mc.run_MK();
        System.out.println("MonteCarlo.main() finished");
    }
    
    private int cycles_MK = 10000;
//    private int cycles_MK = 100000;
//    private int cycles_MK = 1000000;
//    private int cycles_MK = 16777216; //default
    
    public int getCycles_MK() {
		return cycles_MK;
	}
    
    /**
     * @deprecated because not used by us ;-)
     * @param Num_samples
     * @return
     */
    public final double integrate(int Num_samples) {
        
        Random R = new Random(SEED); //TODO ausmessen... oder _MK anlegen und auslagern (als PRM submitten)
        
        int under_curve = 0;
        for (int count=0; count<Num_samples; count++) {
            double x= R.nextDouble(); //TODO: ausmessen? inlinen? auslagern? JIT?
            double y= R.nextDouble(); //TODO: ausmessen? inlinen? auslagern? JIT?
            
            if ( x*x + y*y <= 1.0)
                under_curve ++;
        }
        return ((double) under_curve / Num_samples) * 4.0;
    }
    
    /**@deprecated because not used by us ;-)
     * @param Num_samples
     * @return
     */
    public final double integrate_delegate(int Num_samples){
    	Random R = new Random(SEED);
    	return R.integrate_MK(Num_samples);
    }
    
    /** @deprecated because not used by us ;-)
     * @param Num_samples
     * @return
     */
    public final double integrate_delegate_inlined(int Num_samples){
    	Random R = new Random(SEED);
    	return R.integrate_MK_inlined(Num_samples);
    }
    
    public final double integrate_MK(int Num_samples) {
        
//    	long pointA=0L, pointB=0L, pointC=0L, pointD=0L, pointE=0L;
//    	pointA = System.nanoTime();
        Random R = new Random(SEED); //TODO ausmessen... oder _MK anlegen und auslagern (als PRM submitten)
//        pointB = System.nanoTime();
        int under_curve = 0;
        for (int count=0; count<Num_samples; count++) {
            double x= R.nextDouble(); //TODO: ausmessen? inlinen? auslagern? JIT?
            double y= R.nextDouble(); //TODO: ausmessen? inlinen? auslagern? JIT?
//            pointC = System.nanoTime();
            if ( x*x + y*y <= 1.0)
                under_curve ++;
//            pointD = System.nanoTime();
        }
//        pointE = System.nanoTime();
//        o.printl^n("B-A: "+(pointB-pointA));
//        o.println("C-A: "+(pointB-pointA));
//        o.println("D-A: "+(pointB-pointA));
//        o.println("E-A: "+(pointB-pointA));
        return ((double) under_curve / Num_samples) * 4.0;
    }
    
    public final double integrate_MK_AE(int Num_samples) {
        
    	long pointA=0L;
    	@SuppressWarnings("unused")
		long pointB=0L;
    	@SuppressWarnings("unused")
		long pointC=0L;
    	@SuppressWarnings("unused")
		long pointD=0L;
    	long pointE=0L;
    	
    	pointA = System.nanoTime();
        Random R = new Random(SEED); //TODO ausmessen... oder _MK anlegen und auslagern (als PRM submitten)
//        pointB = System.nanoTime();
        int under_curve = 0;
        for (int count=0; count<Num_samples; count++) {
            double x= R.nextDouble(); //TODO: ausmessen? inlinen? auslagern? JIT?
            double y= R.nextDouble(); //TODO: ausmessen? inlinen? auslagern? JIT?
//            pointC = System.nanoTime();
            if ( x*x + y*y <= 1.0)
                under_curve ++;
//            pointD = System.nanoTime();
        }
        pointE = System.nanoTime();
        o.println("E-A: "+(pointE-pointA));
        return ((double) under_curve / Num_samples) * 4.0;
    }
    
    
    /**@deprecated because not used by us ;-)
     * @param Num_samples
     * @return
     */
    public final double integrate_MK_BE(int Num_samples) {
        
    	@SuppressWarnings("unused")
		long pointA=0L, pointB=0L, pointC=0L, pointD=0L, pointE=0L;
    	
//    	pointA = System.nanoTime();
        Random R = new Random(SEED); //TODO ausmessen... oder _MK anlegen und auslagern (als PRM submitten)
        pointB = System.nanoTime();
        int under_curve = 0;
        for (int count=0; count<Num_samples; count++) {
            double x= R.nextDouble(); //TODO: ausmessen? inlinen? auslagern? JIT?
            double y= R.nextDouble(); //TODO: ausmessen? inlinen? auslagern? JIT?
//            pointC = System.nanoTime();
            if ( x*x + y*y <= 1.0)
                under_curve ++;
//            pointD = System.nanoTime();
        }
        pointE = System.nanoTime();
        o.println("E-B: "+(pointE-pointB));
        return ((double) under_curve / Num_samples) * 4.0;
    }
    
    /**@deprecated because not used by us ;-)
     * @param min_time
     * @param R
     * @return
     */
    public double measureMonteCarlo(double min_time, Random R) {
        PrintStream p = spec.harness.Context.getOut();
        Stopwatch Q = new Stopwatch();
        
        // Cycles set to integrate into SPECjvm2008 benchmark harness.  Testing done on
        // Apple Macbook Pro 2.0Ghz Intel Core Duo, 1GB 667mhz SODIMM
        // J2SE 5.0_06 (Apple)
        // Tuning: -server
        int cycles=16777216; //original
        double x =0.0;
        
        Q.start();
        x = integrate(cycles);
        Q.stop();
        
        p.println(x);
        return num_flops(cycles) / Q.read() * 1.0e-6;
    }
    
    public double measureMonteCarlo_MK(double min_time, Random R) {
        PrintStream p = spec.harness.Context.getOut();
        Stopwatch Q = new Stopwatch();
        
        // Cycles set to integrate into SPECjvm2008 benchmark harness.  Testing done on
        // Apple Macbook Pro 2.0Ghz Intel Core Duo, 1GB 667mhz SODIMM
        // J2SE 5.0_06 (Apple)
        // Tuning: -server
        //MKint cycles=16777216;
        double x =0.0;
        
        Q.start();
        int cyclesForMeasurement = this.getCycles_MK();
        long start = System.nanoTime();
        x = integrate_MK(cyclesForMeasurement);
        long stop = System.nanoTime();
        Q.stop();
        
        p.println(x);
        o.println((stop-start)+" to compute "+this.getCycles_MK()+" cycles in MonteCarlo.integrate_MK(...)");
        return num_flops(this.getCycles_MK()) / Q.read() * 1.0e-6;
    }
    
    public final double num_flops(int Num_samples) {
        // 3 flops in x^2+y^2 and 1 flop in random routine
        
        return ((double) Num_samples)* 4.0;
    }
    
    /**
     * @deprecated because not used by us ;-)
     */
    public void run() {
        double min_time = Constants.RESOLUTION_DEFAULT;
        
        // run the benchmark
        @SuppressWarnings("unused")
		double res = 0.0;
        Random R = new Random(Constants.RANDOM_SEED);
        res = measureMonteCarlo(min_time, R);
    }

	/**
	 * 
	 */
	public void run_MK() {
        double min_time = Constants.RESOLUTION_DEFAULT;
        
        // run the benchmark
        
        @SuppressWarnings("unused")
		double res = 0.0;
        Random R = new Random(Constants.RANDOM_SEED);
        res = measureMonteCarlo_MK(min_time, R);
    }

	public void setCycles_MK(int cycles_MK) {
		this.cycles_MK = cycles_MK;
	}
}



