/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package deprecated.spec.harness.results;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import deprecated.spec.harness.Constants;
import deprecated.spec.harness.SpecJVMBenchmark;
import deprecated.spec.harness.analyzer.AnalyzerResult;
import deprecated.spec.harness.analyzer.TYInfo;


public class IterationResult extends TestResult {
    
    private int iteration = -1;
    private long expectedLoops = -1;
    private long expectedDuration = -1;
    private long startTime = -1;
    private long stopTime = -1;
    private long endTime = -1;
    private double operations = 0;
    private boolean isStartup = false;
    private boolean cont = true;
    private int numberBmThreadsDone = 0;
    private BenchmarkResult bmResult = null;
    private List<LoopResult> loopResults = new LinkedList<LoopResult>();
    private List<TYInfo> analyzers = new LinkedList<TYInfo>();
    private List<AnalyzerResult> analyzerSummaries = new LinkedList<AnalyzerResult>();
    
    public IterationResult() {
    	
    }
    
    public void setBenchmarkResult(BenchmarkResult bmResult) {
    	this.bmResult = bmResult;
    }

    public BenchmarkResult getBenchmarkResult() {
        return bmResult;
    }

    public synchronized long getExpectedDuration() {
        return expectedDuration;
    }
    public synchronized void setExpectedDuration(long expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public synchronized void abortRun() {
        cont = false;
    }
    public synchronized boolean continueToRun() {
        return cont;
    }

    public synchronized long getExpectedLoops() {
        return expectedLoops;
    }
    public synchronized void setExpectedLoops(long expectedLoops) {
        this.expectedLoops = expectedLoops;
    }
    public synchronized long getEndTime() {
        return endTime;
    }
    public synchronized void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    
    public synchronized long getStartTime() {
        return startTime;
    }
    public synchronized void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    
    public synchronized long getStopTime() {
        return stopTime;
    }
    public synchronized void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }
    public synchronized void setStartupTest(boolean isStartup){
        this.isStartup = isStartup;
    }
    public synchronized boolean getStartupTest(){
        return isStartup;
    }
    public synchronized double getOperations() {
        return operations;
    }
    public synchronized void incOperations(double operations) {
        this.operations += operations;
    }
    public synchronized int getIteration() {
        return iteration;
    }
    public synchronized void setIteration(int iteration) {
        this.iteration = iteration;
    }
    
    public synchronized List getLoopResults() {
        return loopResults;
    }
    public synchronized void addLoopResults(LoopResult loopResults) {
        this.loopResults.add(loopResults);
    }
    
    public synchronized int getNumberBmThreadsDone() {
        return numberBmThreadsDone;
    }
    
    /**
     * Flag that this benchmark thread is done with it's workload that is within
     * the measurement interval.
     * @return If this was the last thread to check in.
     */
    public synchronized boolean incNumberBmThreadsDone() {
        
        this.numberBmThreadsDone += 1;
        return this.numberBmThreadsDone == bmResult.getNumberBmThreads();
    }
    
    public synchronized long getDuration() {
        return endTime - startTime;
    }
    
    public synchronized  List getAnalyzers() {
        return analyzers;
    }
    
    public synchronized void addAnalyzer(TYInfo tyi) {
        analyzers.add(tyi);
    }

    public synchronized void addAnalyzerSummary(AnalyzerResult aResult) {
        analyzerSummaries.add(aResult);
    }

    public synchronized Iterator<AnalyzerResult> getAnalyzerSummaries() {
        return analyzerSummaries.iterator();
    }

    /**
     * Describe ops or time, for this iteration
     * @return String that describes in a human preferred format how long this run is.
     */
    public synchronized  String durDesc() {
        if (getExpectedLoops() <= 0) {
            return TestResult.millisAsSec(getExpectedDuration());
        } else if (getExpectedLoops() <= 1) {
            return getExpectedLoops() + " operation";
        } else {
            return getExpectedLoops() + " operations";
        }
    }
    
    public synchronized  String resultString(String testType) {
        if (testType.equals(SpecJVMBenchmark.FUNCTIONAL)) {
            return isValid() ? "PASSED" : "FAILED";
        }
        return doubleAsRes(getScore()) + " " + Constants.WORKLOAD_METRIC + (isValid() ? "" : " **NOT VALID**");
    }
    
    /**
     * @return Score, in operations/min.
     */
    public synchronized  double getScore() {
        return ((double) getOperations()) * 60 * 1000 / getDuration();
    }
    
    public synchronized  boolean isValid() {
        if(hasErrors()) {
            return false;
        }
        for (Iterator iter = loopResults.iterator(); iter.hasNext(); ) {
            LoopResult lr = (LoopResult) iter.next();
            if (!lr.isValid()) {
                return false;
            }
        }
        return true;
    }
    
    public List<String> getAllErrors(String tag) {
        List<String> tmp = new LinkedList<String>();
        if (errors != null) {
            for (Iterator eit = errors.iterator(); eit.hasNext();) {
                tmp.add(tag + " " + eit.next());
            }
        }
        for (Iterator iter = loopResults.iterator(); iter.hasNext(); ) {
            LoopResult lr = (LoopResult) iter.next();
            tmp.addAll(lr.getAllErrors(tag + "[bt:" + lr.getBmThreadId() + "|op:" + lr.getLoopCnt() + "]"));
        }
        return tmp;
    }
    
    
    public synchronized  void toXml(PrintStream ps, int indent) {
        ptxElementStartOpen(ps, indent, "iteration-result", true);
        indent += TAB;
        ptxAttrib(ps, indent, "iteration", iteration, true, "\n");
        ptxAttrib(ps, indent, "expectedLoops", expectedLoops, expectedLoops > 0, "\n");
        ptxAttrib(ps, indent, "expectedDuration", expectedDuration, expectedLoops <= 0, "\n");
        ptxAttrib(ps, indent, "startTime", startTime, true, "\n");
        ptxAttrib(ps, indent, "endTime", endTime, true, "\n");
        // Skip stop time, will only confuse
        ptxAttrib(ps, indent, "operations", operations, true, ">\n");
                
        printErrorsToXml(ps, indent);
        
        ptxElementOpen(ps, indent, "loops");
        for (Iterator<LoopResult> iter = loopResults.iterator(); iter.hasNext();) {
            (iter.next()).toXml(ps, indent + TAB);
        }
        ptxElementClose(ps, indent, "loops");
        ptxElementOpen(ps, indent, "analyzers");
        for (Iterator<TYInfo> iter = analyzers.iterator(); iter.hasNext();) {
            TYInfo tyi = iter.next();
            ptxElementStartOpen(ps, indent + TAB, "tyinfo", false);
            ptxAttrib(ps, 0, "name", tyi.getName(), true, " ");
            ptxAttrib(ps, 0, "unit", tyi.getUnit(), true, " ");
            ptxAttrib(ps, 0, "time", tyi.getTime(), true, " ");
            ptxAttrib(ps, 0, "value", tyi.getValue(), true, "/>\n");
        }
        ptxElementClose(ps, indent, "analyzers");
        ptxElementOpen(ps, indent, "analyzer-results");
        for (Iterator<AnalyzerResult> iter = analyzerSummaries.iterator(); iter.hasNext();) {
            AnalyzerResult ar = iter.next();
            ptxElementStartOpen(ps, indent + TAB, "result", false);
            ptxAttrib(ps, 0, "name", ar.getName(), true, " ");
            ptxAttrib(ps, 0, "unit", ar.getUnit(), true, " ");
            ptxAttrib(ps, 0, "time", ar.getResult(), true, "/>\n");
        }
        ptxElementClose(ps, indent, "analyzer-results");
        indent -= TAB;
        ptxElementClose(ps, indent, "iteration-result");
    }
}
