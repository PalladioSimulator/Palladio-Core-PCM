/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */

package evaluation.spec.benchmarks.scimark.sor;

import evaluation.spec.benchmarks.scimark.utils.kernel;
import evaluation.spec.harness.SpecJVMBenchmarkBase;
import evaluation.spec.harness.results.BenchmarkResult;

public class Main extends SpecJVMBenchmarkBase {
    
    /** Run this in multi mode, next to each other. */
    public static String testType() {
        return MULTI;
    }
    
    static void runBenchmark() {
        for (int i = kernel.SOR_LOOPS; i > 0; i --) {
            SOR.main(i);
        }
    }
    
    public static void Main() {
        runBenchmark();
    }
    
    public void harnessMain() {
        runBenchmark();
    }
    
    public static void setupBenchmark() {
        kernel.init();
    }
    
    public Main(BenchmarkResult bmResult, int threadId) {
        super(bmResult, threadId);
    }

    public static void main(String[] args) throws Exception {
        runSimple( Main.class, args );
    }
    
}
