/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package deprecated.spec.benchmarks.scimark.utils;

import java.io.PrintStream;

/*
 * Random.java based on Java Numerical Toolkit (JNT) Random.UniformSequence
 * class.  We do not use Java's own java.util.Random so that we can compare
 * results with equivalent C and Fortran coces.
 */

public class Random {
    private final static PrintStream o = System.out;
    private static final int mdig = 32;
    private static final int one = 1;
    
    private static final int m1 = (one << mdig - 2) + ((one << mdig - 2) - one);
    
    private static final int m2 = one << mdig / 2;

    
        /* ------------------------------------------------------------------------------
         CLASS VARIABLES
         ------------------------------------------------------------------------------ */
    
    public static void main(String[] args) {
        Random rd = new Random();
        int times = 10000;
        rd.measure_nextDouble(times);
        int cmdCycles = 0;
        if(args.length==1){
        	try{
        		cmdCycles = new Integer(args[0]);
        		rd.setCycles_MK(cmdCycles);
            	System.out.println("Command line arguments received, running with "+rd.getCycles_MK()+" cycles");
        	}catch (Exception e) {
				System.out.println("Command line parameter "+args[0]+" " +
						"could not be converted to a number; " +
						"taking the default ("+rd.getCycles_MK()+")");
			}
        }else{
        	System.out.println("No command line arguments received, running with "+rd.getCycles_MK()+" cycles");
        }
        rd.run_MK();
        System.out.println("Random.main() finished");
    }
    
    private void measure_nextDouble(int times) {
		double[] res = new double[times];
		long start = 0L;
		long stop = 0L;
		for(int i=0; i<times; i++){
			res[i] = this.nextDouble();
		}
		
		start = System.nanoTime();
		for(int i=0; i<times; i++){
			res[i] += this.nextDouble();
		}
		stop  = System.nanoTime();
		long res1 = stop-start;
		
		start = System.nanoTime();
		for(int i=0; i<times; i++){
			res[i] += this.nextDouble();
			res[i] += this.nextDouble();
		}
		stop  = System.nanoTime();
		long res2 = stop-start;
		System.out.println("Measuring spec.*.utils.Random.nextDouble():" +
				"\n "+times+" loops with one nextDouble: "+res1+"; " +
				""+times+" loops with two nextDouble: "+res2+"; " +
				"leads to \n"+(((double)(res2-res1))/((double)(times)))+" ns for nextDouble");
	}

	int seed = 0;
    
    private int m[];
    
    private int i = 4;
    
	public void setCycles_MK(int cycles_MK) {
		this.cycles_MK = cycles_MK;
	}
    
    private int cycles_MK = 10000;
//  private int cycles_MK = 100000;
//  private int cycles_MK = 1000000;
//  private int cycles_MK = 16777216; //default
    
	public int getCycles_MK() {
		return cycles_MK;
	}

    private int j = 16;
    
    private double dm1 = 1.0 / (double) m1;
    
    private boolean haveRange = false;
    
    private double left = 0.0;
    
        /* For mdig = 32 : m1 =          2147483647, m2 =      65536
         For mdig = 64 : m1 = 9223372036854775807, m2 = 4294967296
         */
    
    @SuppressWarnings("unused")
	private double right = 1.0;
    
    private double width = 1.0;
    
    /**
     * Initializes a sequence of uniformly distributed quasi random numbers with a
     * seed based on the system clock.
     */
    public Random() {
        initialize((int) System.currentTimeMillis());
    }
    
    /**
     *
     * Initializes a sequence of uniformly distributed quasi random numbers on a
     * given half-open interval [left,right) with a seed based on the system
     * clock.
     *
     * @param left The left endpoint of the half-open interval [left,right).
     * @param right The right endpoint of the half-open interval [left,right).
     * @deprecated because not used by us ;-)
     */
    public Random(double left, double right) {
        initialize((int) System.currentTimeMillis());
        this.left = left;
        this.right = right;
        width = right - left;
        haveRange = true;
    }
    
    /**
     * Initializes a sequence of uniformly distributed quasi random numbers with a
     * given seed.
     *
     * @param seed The seed of the random number generator.
     * Two sequences with the same seed will be identical.
     */
    public Random(int seed) {
        initialize(seed);
    }
    
        /* ------------------------------------------------------------------------------
         CONSTRUCTORS
         ------------------------------------------------------------------------------ */
    
    /**
     * Initializes a sequence of uniformly distributed quasi random numbers
     * with a given seed on a given half-open interval [left,right).
     * @param seed The seed of the random number generator.  Two sequences
     * with the same seed will be identical.
     * @param left The left endpoint of the half-open interval [left,right).
     * @param right The right endpoint of the half-open interval [left,right).
     * @deprecated because not used by us ;-)
     */
    public Random(int seed, double left, double right) {
        initialize(seed);
        this.left = left;
        this.right = right;
        width = right - left;
        haveRange = true;
    }
    
    private void initialize(int seed) { //TODO quantify
        
        int jseed, k0, k1, j0, j1, iloop;
        
        this.seed = seed;
        
        m = new int[17];
        
        jseed = Math.min(Math.abs(seed), m1);
        if (jseed % 2 == 0)
            --jseed;
        k0 = 9069 % m2;
        k1 = 9069 / m2;
        j0 = jseed % m2;
        j1 = jseed / m2;
        for (iloop = 0; iloop < 17; ++iloop) {
            jseed = j0 * k0;
            j1 = (jseed / m2 + j0 * k1 + j1 * k0) % (m2 / 2);
            j0 = jseed % m2;
            m[iloop] = j0 + m2 * j1;
        }
        i = 4;
        j = 16;
        
    }
    
    /**
     * @param Num_samples
     * @return
     * @deprecated because not used by us ;-)
     */
    public final double integrate_MK(int Num_samples) {
        
        int under_curve = 0;
        for (int count=0; count<Num_samples; count++) {
            double x= this.nextDouble(); //TODO: ausmessen? inlinen? auslagern? JIT?
            double y= this.nextDouble(); //TODO: ausmessen? inlinen? auslagern? JIT?
            
            if ( x*x + y*y <= 1.0)
                under_curve ++;
        }
        return ((double) under_curve / Num_samples) * 4.0;
    }
    
    /**
     * @param Num_samples
     * @return
     */
    public final double integrate_MK_inlined(int Num_samples) {
        
        int under_curve = 0;
        for (int count=0; count<Num_samples; count++) {
            double x = 0D; //inlined below
            double y = 0D; //inlined below
            
            int k;
            @SuppressWarnings("unused")
			double nextValue;
            
            k = m[i] - m[j];
            if (k < 0)
                k += m1;
            m[j] = k;
            
            if (i == 0)
                i = 16;
            else
                i--;
            
            if (j == 0)
                j = 16;
            else
                j--;
            
            if (haveRange)
                x = left + dm1 * (double) k * width;
            else
                x = dm1 * (double) k;
            
            k = m[i] - m[j];
            if (k < 0)
                k += m1;
            m[j] = k;
            
            if (i == 0)
                i = 16;
            else
                i--;
            
            if (j == 0)
                j = 16;
            else
                j--;
            
            if (haveRange)
                y = left + dm1 * (double) k * width;
            else
                y = dm1 * (double) k;
            
            if ( x*x + y*y <= 1.0)
                under_curve ++;
        }
        return ((double) under_curve / Num_samples) * 4.0;
    }
    
        /* ------------------------------------------------------------------------------
         PUBLIC METHODS
         ------------------------------------------------------------------------------ */
    
    /**
     * @param min_time
     * @param R
     * @return
     * @deprecated because not used by us ;-)
     */
    public double measureMonteCarlo_MK(double min_time, Random R) {
        PrintStream p = deprecated.spec.harness.Context.getOut();
        Stopwatch Q = new Stopwatch();
        
        // Cycles set to integrate into SPECjvm2008 benchmark harness.  Testing done on
        // Apple Macbook Pro 2.0Ghz Intel Core Duo, 1GB 667mhz SODIMM
        // J2SE 5.0_06 (Apple)
        // Tuning: -server
        int cycles=16777216;
        double x =0.0;
        
        Q.start();
        long start = System.nanoTime();
        x = integrate_MK(cycles);
        long stop = System.nanoTime();
        Q.stop();
        
        p.println(x);
        o.println((stop-start)+" to compute "+cycles+" cycles");
        return num_flops(cycles) / Q.read() * 1.0e-6;
    }
    
    public double measureMonteCarlo_MK_inlined(double min_time, Random R) {
        PrintStream p = deprecated.spec.harness.Context.getOut();
        Stopwatch Q = new Stopwatch();
        
        // Cycles set to integrate into SPECjvm2008 benchmark harness.  Testing done on
        // Apple Macbook Pro 2.0Ghz Intel Core Duo, 1GB 667mhz SODIMM
        // J2SE 5.0_06 (Apple)
        // Tuning: -server
        //MK int cycles=16777216;
        double x =0.0;
        
        int cyclesForMeasurement = this.getCycles_MK();
        Q.start();
        long start = System.nanoTime();
        x = integrate_MK_inlined(cyclesForMeasurement);
        long stop = System.nanoTime();
        Q.stop();
        
        p.println(x);
        o.println((stop-start)+" to compute "+this.getCycles_MK()+" cycles in Random.integrate_MK_inlined(...)");
        return num_flops(this.getCycles_MK()) / Q.read() * 1.0e-6;
    }
    
    /**
     * Returns the TODO
     */
    //next random number in the sequence.
    public final synchronized double nextDouble() {
        
        int k;
        @SuppressWarnings("unused")
		double nextValue;
        
        k = m[i] - m[j];
        if (k < 0)
            k += m1;
        m[j] = k;
        
        if (i == 0)
            i = 16;
        else
            i--;
        
        if (j == 0)
            j = 16;
        else
            j--;
        
        if (haveRange)
            return left + dm1 * (double) k * width;
        else
            return dm1 * (double) k;
        
    }
    
    /**
     * Returns the next N random numbers in the sequence, as
     * a vector.
     * @deprecated because not used by us ;-)
     */
    public final synchronized void nextDoubles(double x[]) {
        
        int N = x.length;
        int remainder = N & 3; // N mod 4
        
        if (haveRange) {
            for (int count = 0; count < N; count++) {
                int k = m[i] - m[j];
                
                if (i == 0)
                    i = 16;
                else
                    i--;
                
                if (k < 0)
                    k += m1;
                m[j] = k;
                
                if (j == 0)
                    j = 16;
                else
                    j--;
                
                x[count] = left + dm1 * (double) k * width;
            }
            
        } else {
            
            for (int count = 0; count < remainder; count++) {
                int k = m[i] - m[j];
                
                if (i == 0)
                    i = 16;
                else
                    i--;
                
                if (k < 0)
                    k += m1;
                m[j] = k;
                
                if (j == 0)
                    j = 16;
                else
                    j--;
                
                x[count] = dm1 * (double) k;
            }
            
            for (int count = remainder; count < N; count += 4) {
                int k = m[i] - m[j];
                if (i == 0)
                    i = 16;
                else
                    i--;
                if (k < 0)
                    k += m1;
                m[j] = k;
                if (j == 0)
                    j = 16;
                else
                    j--;
                x[count] = dm1 * (double) k;
                
                k = m[i] - m[j];
                if (i == 0)
                    i = 16;
                else
                    i--;
                if (k < 0)
                    k += m1;
                m[j] = k;
                if (j == 0)
                    j = 16;
                else
                    j--;
                x[count + 1] = dm1 * (double) k;
                
                k = m[i] - m[j];
                if (i == 0)
                    i = 16;
                else
                    i--;
                if (k < 0)
                    k += m1;
                m[j] = k;
                if (j == 0)
                    j = 16;
                else
                    j--;
                x[count + 2] = dm1 * (double) k;
                
                k = m[i] - m[j];
                if (i == 0)
                    i = 16;
                else
                    i--;
                if (k < 0)
                    k += m1;
                m[j] = k;
                if (j == 0)
                    j = 16;
                else
                    j--;
                x[count + 3] = dm1 * (double) k;
            }
        }
    }
    
    public final double num_flops(int Num_samples) {
        // 3 flops in x^2+y^2 and 1 flop in random routine
        
        return ((double) Num_samples)* 4.0;
    }
    
        /*----------------------------------------------------------------------------
         PRIVATE METHODS
         ------------------------------------------------------------------------ */
    
    public void run_MK() {
        double min_time = Constants.RESOLUTION_DEFAULT;
        
        // run the benchmark
        
        double res = 0.0;
        Random R = new Random(Constants.RANDOM_SEED);
        res = measureMonteCarlo_MK_inlined(min_time, R);
        System.out.println("Result in run_MK: "+res);
    }
    
}
