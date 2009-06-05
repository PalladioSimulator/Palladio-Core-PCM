/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package deprecated.spec.harness.results;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import deprecated.spec.harness.Constants;
import deprecated.spec.harness.Context;
import deprecated.spec.harness.Launch;



public class SuiteResult extends TestResult {
    
    private String workloadName = Constants.WORKLOAD_NAME_NOT_SET;
    
    // Test run info
    private HashMap<String, String> runInfo = new HashMap<String, String>();
    // JVM info
    private HashMap<String, String> jvmInfo = new HashMap<String, String>();
    // Info about OS and other software
    private HashMap<String, String> swInfo = new HashMap<String, String>();
    // Hardware info
    private HashMap<String, String> hwInfo = new HashMap<String, String>();
    
    // Test run data
    List<BenchmarkResult> benchmarkResults = new LinkedList<BenchmarkResult>();
    List<String> violations = null;
    List<String> configurations = null;
    
    public String getWorkloadName() {
        return workloadName;
    }
    
    public void setWorkloadName(String workloadName) {
        this.workloadName = workloadName;
    }
        
    public void addJvmInfo(String key, Properties props, String def) {
        String value = (def == null ? "n/a" : def);
        if (props != null) {
            value = props.getProperty(key, value);
        }
        jvmInfo.put(key, value);
        
        if (Launch.verbose) {
            Context.getOut().println("  " + key + "=" + value);
        }

    }
    
    public void addJvmInfo(String key, String value) {
        jvmInfo.put(key, value);
        if (Launch.verbose) {
            Context.getOut().println("  " + key + "=" + value);
        }
    }
    
    public Map getJvmInfo() {
        return jvmInfo;
    }
    
    public void addRunInfo(String key, Properties props, String def) {
        String value = (def == null ? "n/a" : def);
        if (props != null) {
            value = props.getProperty(key, value);
        }
        runInfo.put(key, value);
        if (Launch.verbose) {
            Context.getOut().println("  " + key + "=" + value);
        }
     }
    
    public Map getRunInfo() {
        return runInfo;
    }
    
    public void addSwInfo(String key, Properties props, String def) {
        String value = (def == null ? "n/a" : def);
        if (props != null) {
            value = props.getProperty(key, value);
        }
        swInfo.put(key, value);

        if (Launch.verbose) {
            Context.getOut().println("  " + key + "=" + value);
        }
    }
    
    public Map getSwInfo() {
        return swInfo;
    }
    
    public void addHwInfo(String key, Properties props, String def) {
        String value = (def == null ? "n/a" : def);
        if (props != null) {
            value = props.getProperty(key, value);
        }
        hwInfo.put(key, value);

        if (Launch.verbose) {
            Context.getOut().println("  " + key + "=" + value);
        }
    }
    
    public Map getHwInfo() {
        return hwInfo;
    }
    
    public List<String> getViolations() {
        return violations;
    }
    
    public List<String> getConfigurations() {
        return configurations;
    }
    
    public List getBenchmarkResults() {
        return benchmarkResults;
    }
    
    public void addBenchmarkResults(BenchmarkResult benchmarkResult) {
        benchmarkResults.add(benchmarkResult);
    }
    
    public void addViolation(String violation) {
        if (this.violations == null) {
            this.violations = new LinkedList<String>();
        }
        this.violations.add(violation);
    }
    
    public void addConfiguration(String configuration) {
        if (this.configurations == null) {
            this.configurations = new LinkedList<String>();
        }
        this.configurations.add(configuration);
    }
    
    public boolean isCompliant() {
        return violations == null;
    }
    
    public boolean isValid() {
        if (hasErrors()) {
            return false;
        }
        for (Iterator iter = benchmarkResults.iterator(); iter.hasNext(); ) {
            BenchmarkResult res = (BenchmarkResult) iter.next();
            if (!res.isValid()) {
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
        for (Iterator iter = benchmarkResults.iterator(); iter.hasNext(); ) {
            BenchmarkResult br = (BenchmarkResult) iter.next();
            tmp.addAll(br.getAllErrors("[" + br.getLogicalName() + "]"));
        }
        return tmp;
    }
    
    public void headerToXml(PrintStream ps, int indent) {
        // Ignoring indent.
        ptxXmlHeader(ps);
        ptxElementOpen(ps, 0, "specjvm-result");
        ptxElement(ps, 1 * TAB, "workload", workloadName);
        ptxElementOpen(ps, TAB, "run-info");
        for (Iterator iter = runInfo.keySet().iterator(); iter.hasNext(); ) {
            String key = (String) iter.next();
            ptxElement(ps, 2 * TAB, (String) key, (String) runInfo.get(key));
        }
        ptxElementClose(ps, TAB, "run-info");
        
        ptxElementOpen(ps, TAB, "jvm-info");
        for (Iterator iter = jvmInfo.keySet().iterator(); iter.hasNext(); ) {
            String key = (String) iter.next();
            ptxElement(ps, 2 * TAB, (String) key, (String) jvmInfo.get(key));
        }
        ptxElementClose(ps, TAB, "jvm-info");
        
        ptxElementOpen(ps, TAB, "sw-info");
        for (Iterator iter = swInfo.keySet().iterator(); iter.hasNext(); ) {
            String key = (String) iter.next();
            ptxElement(ps, 2 * TAB, (String) key, (String) swInfo.get(key));
        }
        ptxElementClose(ps, TAB, "sw-info");
        
        ptxElementOpen(ps, TAB, "hw-info");
        for (Iterator iter = hwInfo.keySet().iterator(); iter.hasNext(); ) {
            String key = (String) iter.next();
            ptxElement(ps, 2 * TAB, (String) key, (String) hwInfo.get(key));
        }
        ptxElementClose(ps, TAB, "hw-info");
        
        
        if (!isCompliant()) {
            ptxElementOpen(ps, TAB, "violations");
            for (Iterator iter = violations.iterator(); iter.hasNext();) {
                ptxElement(ps, 2 * TAB, "violation", ((String) iter.next()));
            }
            ptxElementClose(ps, TAB, "violations");
        }
        if (configurations != null) {
            ptxElementOpen(ps, TAB, "configs");
            for (Iterator iter = configurations.iterator(); iter.hasNext();) {
                ptxElement(ps, 2 * TAB, "config", ((String) iter.next()));
            }
            ptxElementClose(ps, TAB, "configs");
        }
        
        ptxElementOpen(ps, TAB, "benchmark-results");
    }
    
   
    public void toXml(PrintStream ps, int indent) {
        for (Iterator iter = benchmarkResults.iterator(); iter.hasNext();) {
            ((BenchmarkResult) iter.next()).toXml(ps, 2 * TAB);
        }
    }
    
    public void footerToXml(PrintStream ps, int indent) {
        ptxElementClose(ps, TAB, "benchmark-results");
        printErrorsToXml(ps, TAB);
        ptxElementClose(ps, 0, "specjvm-result");
    }
        
    public String getCommandLineOptions() {
        return jvmInfo.get(Constants.REPORTER_JVM_COMMAND_LINE);
    }
}
