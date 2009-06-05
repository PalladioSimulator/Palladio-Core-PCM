/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * Copyright (c) 1997,1998 Sun Microsystems, Inc. All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */

package spec.benchmarks.compress_inlined;

import spec.harness.SpecJVMBenchmarkBase;
import spec.harness.results.BenchmarkResult;

public class Main extends SpecJVMBenchmarkBase {
    //same-package harness
	public static final Harness COMPRESS_HARNESS = new Harness();
    
    /**
     * Called by SPECCompressCountingStarter
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //compress' main class
    	runSimple( Main.class, args );
    }
    
    @SuppressWarnings("static-access")
	public static void setupBenchmark() {
        COMPRESS_HARNESS.prepareBuffers();
    }
    
    /**
     * Run this in single mode.
     * No multi threading for this benchmark right now.
     */
    public static String testType() {
        return MULTI;
    }
    
    public Main(BenchmarkResult bmResult, int threadId) {
        super(bmResult, threadId);
    }
    
    /* (non-Javadoc)
     * @see spec.harness.BenchmarkThread#harnessMain()
     */
    public void harnessMain() { //called by SpecJVMBenchmarkBase
        runBenchmark();
    }
    
    public void Main() {//TODO : document: that this is a method, not a constructor
        runBenchmark();
    }
    
    public Main() {//TODO : document: added this constructor, but it has the same name as the above method...!
    	super();//implicit super-constructor is undefined, but must be called using super...
    }
    
    public long runBenchmark() {
        return COMPRESS_HARNESS.inst_main(super.getThreadId());
        
    }
}
