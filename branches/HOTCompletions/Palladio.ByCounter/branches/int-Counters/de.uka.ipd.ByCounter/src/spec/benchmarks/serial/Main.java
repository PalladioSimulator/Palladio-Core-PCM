/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package spec.benchmarks.serial;

import spec.harness.Context;
import spec.harness.SpecJVMBenchmarkBase;
import spec.harness.results.BenchmarkResult;

public class Main extends SpecJVMBenchmarkBase {
    
    /** Run this in mutli mode, next to each other. */
    public static String testType() {
        return MULTI;
    }
    
    static long runBenchmark() {
        long startTime = System.currentTimeMillis();
        try {
            new Harness();
        } catch (Exception e) {
            e.printStackTrace(Context.getOut());
        }
        return System.currentTimeMillis() - startTime;
    }
    
    public static void main(String[] args) {
        runSimple(Main.class, args);
    }
    
    
    public Main(BenchmarkResult bmResult, int threadId) {
        super(bmResult, threadId);
    }
    
    public void harnessMain() {
        runBenchmark();
    }
    
    public static void setupBenchmark() {
        try {
            Harness.initSockets();
        } catch (Exception e) {
            e.printStackTrace(Context.getOut());
        }
    }
    
    public static void tearDownBenchmark() {
        try {
            Harness.releaseResources();
        } catch (Exception e) {
            e.printStackTrace(Context.getOut());
        }
    }
    
}
