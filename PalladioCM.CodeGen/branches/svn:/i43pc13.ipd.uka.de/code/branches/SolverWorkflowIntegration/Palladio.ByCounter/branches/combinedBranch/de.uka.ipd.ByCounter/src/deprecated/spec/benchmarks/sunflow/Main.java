/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * Copyright (c) 2007 Sun Microsystems, Inc. All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */

package deprecated.spec.benchmarks.sunflow;


import org.sunflow.Benchmark;
import org.sunflow.system.UI;
import org.sunflow.system.UI.Module;
import org.sunflow.system.UI.PrintLevel;

import deprecated.spec.harness.Constants;
import deprecated.spec.harness.Context;
import deprecated.spec.harness.Launch;
import deprecated.spec.harness.SpecJVMBenchmarkBase;
import deprecated.spec.harness.Util;
import deprecated.spec.harness.results.BenchmarkResult;



public class Main extends SpecJVMBenchmarkBase {
    public static final int resolution = 128;
    private static Benchmark[] benchmarks;
    protected final static int threads = Util.getIntProperty(Constants.SUNFLOW_THREADS, null);
    
    /** Run this in single mode, multi threading is handled by the benchmark. */
    public static String testType() {
        return MULTI;
    }
    
    static class BenchmarkImpl extends Benchmark{
        public BenchmarkImpl(int resolution, boolean showOutput, boolean showBenchmarkOutput,
                boolean saveOutput, int threads) {
            super(resolution, showOutput, showBenchmarkOutput, saveOutput, threads);
        }
        
        public void print(Module m, PrintLevel level, String s) {
            if (!s.startsWith("Loading reference image from") && m == Module.BENCH) {
                Context.getOut().println(UI.formatOutput(m, level, s));
            }
            if (level == PrintLevel.ERROR)
                Context.getOut().println("ERROR...");
        }
    }
    
    Benchmark benchmark;
    
    public Main(BenchmarkResult bmResult, int threadId) {
        super(bmResult, threadId);
        benchmark = benchmarks[threadId - 1];
    }
    
    public static void setupBenchmark() {
        int threads = Launch.currentNumberBmThreads;
        benchmarks = new Benchmark[threads];
        for (int i = 0; i < threads; i ++) {
            benchmarks[i] = new BenchmarkImpl(resolution, false, true, false, threads);
            benchmarks[i].kernelBegin();
        }
    }
    
    public void harnessMain() {
        benchmark.kernelMain();
        benchmark.kernelEnd();
    }
    
    public static void main(String[] args) throws Exception {
        runSimple(Main.class, args);
    }
}
