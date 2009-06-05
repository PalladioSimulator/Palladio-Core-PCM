/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * Copyright (c) 1997,1998 Sun Microsystems, Inc. All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package deprecated.spec.benchmarks.mpegaudio;

import deprecated.spec.harness.Context;
import deprecated.spec.harness.SpecJVMBenchmarkBase;
import deprecated.spec.harness.results.BenchmarkResult;

public class Main extends SpecJVMBenchmarkBase {
    
    public static final String prefix = Context.getSpecBasePath() + "/resources/mpegaudio/input/";
    
    /** Run this in multi mode, next to each other. */
    public static String testType() {
        return MULTI;
    }
    
    static long runBenchmark(int btid) {
        long startTime = System.currentTimeMillis();
        try {
            new Harness().inst_main(btid);
        } catch (Exception e) {
            e.printStackTrace(Context.getOut());
        }
        return System.currentTimeMillis() - startTime;
    }
    
    public Main(BenchmarkResult bmResult, int threadId) {
        super(bmResult, threadId);
    }
    
    public static void main(String[] args) {
        runSimple(Main.class, args);
    }
    
    public void harnessMain() {
        runBenchmark(super.getThreadId());
    }
}
