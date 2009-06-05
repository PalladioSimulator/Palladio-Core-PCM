/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * Copyright (c) 1997,1998 Sun Microsystems, Inc. All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */

package spec.benchmarks.compress;

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
    	System.out.println("MK calling Main.main");
		runSimple( Main.class, args );
    }
    
    /**
     * Called by SPECCompressCountingStarter
     * @param args
     * @param introduceMutation 
     * @throws Exception
     */
    public static void MK_main_mine(
    		String[] args, 
    		int index, 
    		boolean introduceMutation 
    		) throws Exception {
    	System.out.println("MK calling Main.main_mine");
    	if(introduceMutation){
    		Compress.MK_setMutatation(true);
    	}
		Harness.MK_setFileIndex(index/*Integer.parseInt(args[0])*/);
		runSimple( Main.class, args );
    }
    
    @SuppressWarnings("static-access")
	public static void setupBenchmark() {
    	System.out.println("MK calling Main.setupBenchmark");
        COMPRESS_HARNESS.prepareBuffers();
    }
    
    /**
     * Run this in single mode.
     * No multi threading for this benchmark right now.
     */
    public static String testType() {
    	System.out.println("MK calling Main.testType");
        return MULTI;
    }
    
    public Main() {//TODO : document: added this constructor, but it has the same name as the above method...!
    	super();//implicit super-constructor is undefined, but must be called using super...
    	System.out.println("MK called Main.Main() (constructor)");
    }
    
    public Main(BenchmarkResult bmResult, int threadId) {
        super(bmResult, threadId);
    	System.out.println("MK called Main.Main(BenchmarkResult bmResult, int threadId) (constructor)");
    }
    
    /* (non-Javadoc)
     * @see spec.harness.BenchmarkThread#harnessMain()
     */
    public void harnessMain() { //called by SpecJVMBenchmarkBase
    	System.out.println("MK calling Main.harnessMain()");
        runBenchmark();
    }
    
    public void Main() {//TODO : document: that this is a method, not a constructor
    	System.out.println("MK calling Main.Main() (method)");
        runBenchmark();
    }
    
    public long runBenchmark() {
    	System.out.println("MK calling Main.runBenchmark()");
        return COMPRESS_HARNESS.inst_main(super.getThreadId());
        
    }
}
