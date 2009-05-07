/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package deprecated.spec.harness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import deprecated.spec.benchmarks.startup.StartupBenchmarkOutput;
import deprecated.spec.harness.analyzer.AnalyzersRunner;
import deprecated.spec.harness.results.BenchmarkResult;
import deprecated.spec.harness.results.SuiteResult;
import deprecated.spec.harness.results.TestResult;
import deprecated.spec.reporter.Reporter;


public class Launch {
    
    private final static boolean DEBUG = false;
    private final static String specjvmHomeDir = System.getProperty(Constants.HOMEDIR_PROP, ".");    
    public static int currentNumberBmThreads;
    public static boolean verbose = false;
    private static boolean parseDefaultArgs = false;
    private static String workLoad = Constants.WORKLOAD_NAME_NOT_SET;
    
    static int defaultMode = 1;
    static int startupMode = 2;
    static int scimarkMode = 3;
    
    
    // package private, to be accessed via Util
    static Properties userProperties;
    static Properties invalidProperties;
    static Properties additionalConfigurationProperties;
    static Properties defaultProperties;
    private static Properties defaultPropertiesSPECbase;
    private static Properties defaultPropertiesSPECpeak;
    private static Properties defaultPropertiesLagom;
    private static HashMap<String, String> propsRequirements;
    private static HashMap<String, String> propsRequirementsSPECbase;
    private static HashMap<String, String> propsRequirementsSPECpeak;
    private static HashMap<String, String> propsRequirementsLagom;
    
    static {
        invalidProperties = new Properties();
        additionalConfigurationProperties = new Properties();
        defaultPropertiesSPECbase = new Properties();
        defaultPropertiesSPECpeak= new Properties();
        defaultPropertiesLagom = new Properties();
        defaultProperties = defaultPropertiesSPECbase;
        propsRequirementsSPECbase = new HashMap<String, String>();
        propsRequirementsSPECpeak = new HashMap<String, String>();
        propsRequirementsLagom = new HashMap<String, String>();
        propsRequirements = propsRequirementsSPECbase;
        
        // Run configuration
        setupProp(Constants.NAME_OF_RUN_PROP, Constants.WORKLOAD_NAME_SPEC_BASE, Constants.MATCH_REQ, Constants.WORKLOAD_NAME_SPEC_PEAK, Constants.MATCH_REQ, Constants.WORKLOAD_NAME_LAGOM, Constants.MATCH_REQ);
        setupProp(Constants.TYPE_OF_RUN_PROP, "" + TestResult.TIMED, Constants.MATCH_REQ, "" + TestResult.ITER, Constants.MATCH_REQ);
        setupProp(Constants.BENCHMARK_THREADS_PROP, Constants.HWT_VALUE, Constants.WHATEVER_REQ);
        setupProp(Constants.FIXED_OPERATIONS_PROP, null, Constants.NOT_SET_REQ, "-1", Constants.WHATEVER_REQ);
        setupProp(Constants.RUNTIME_PROP, "240s", Constants.MATCH_REQ, "240s", Constants.TIME_AT_LEAST_REQ, "0s", Constants.MATCH_REQ);
        setupProp(Constants.FORCED_RUNTIME_PROP, null, Constants.NOT_SET_REQ, null, Constants.NOT_SET_REQ);
        setupProp(Constants.WARMUPTIME_PROP, "120s", Constants.MATCH_REQ, "120s", Constants.WHATEVER_REQ, "0s", Constants.MATCH_REQ);
        setupProp(Constants.ITERATIONS_MINIMUM_PROP, "1", Constants.MATCH_REQ, "1", Constants.AT_LEAST_1_MARK_IF_HIGHER, "1", Constants.WHATEVER_REQ);
        setupProp(Constants.ITERATIONS_MAXIMUM_PROP, "1", Constants.MATCH_REQ, "1", Constants.AT_LEAST_1_MARK_IF_HIGHER, "1", Constants.WHATEVER_REQ);
        setupProp(Constants.ITERATIONS_MINIMUM_PROP + ".check", "1", Constants.MATCH_REQ, "1", Constants.MATCH_REQ);
        setupProp(Constants.ITERATIONS_MAXIMUM_PROP + ".check", "1", Constants.MATCH_REQ, "1", Constants.MATCH_REQ);
        setupProp(Constants.ITER_DO_SYSTEMGC_PROP, "false", Constants.MATCH_REQ, "false", Constants.MATCH_REQ);
        setupProp(Constants.ITER_DELAYTIME_PROP, "0s", Constants.TIME_MAX_5s_REQ, "0s", Constants.TIME_MAX_5s_REQ);
        setupProp(Constants.BM_DO_SYSTEMGC_PROP, "false", Constants.MATCH_REQ, "false", Constants.MATCH_REQ);
        setupProp(Constants.BM_DELAYTIME_PROP, "0s", Constants.TIME_MAX_5s_REQ, "0s", Constants.TIME_MAX_5s_REQ);
        setupProp(Constants.STARTUP_JVM_OPTIONS_PROP, null, Constants.NOT_SET_REQ, null, Constants.WHATEVER_REQ, null, Constants.WHATEVER_REQ);
        setupProp(Constants.STARTUP_LAUNCHER, null, Constants.SPECIAL_REQ, null, Constants.SPECIAL_REQ);
        
        // Benchmark specific run configuration for lagom workload
        setupProp(getFixedOperationsProp(Constants.COMPILER_COMPILER_BNAME), null, Constants.NOT_SET_REQ, "20", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.COMPILER_SUNFLOW_BNAME), null, Constants.NOT_SET_REQ, "20", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.COMPRESS_BNAME), null, Constants.NOT_SET_REQ, "50", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.CRYPTO_AES_BNAME), null, Constants.NOT_SET_REQ, "20", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.CRYPTO_RSA_BNAME), null, Constants.NOT_SET_REQ, "150", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.CRYPTO_SIGNVERIFY_BNAME), null, Constants.NOT_SET_REQ, "125", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.DERBY_BNAME), null, Constants.NOT_SET_REQ, "30", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.MPEGAUDIO_BNAME), null, Constants.NOT_SET_REQ, "50", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.SCIMARK_LARGE_FFT_BNAME), null, Constants.NOT_SET_REQ, "10", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.SCIMARK_LARGE_LU_BNAME), null, Constants.NOT_SET_REQ, "4", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.SCIMARK_MONTE_CARLO_BNAME), null, Constants.NOT_SET_REQ, "900", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.SCIMARK_LARGE_SOR_BNAME), null, Constants.NOT_SET_REQ, "15", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.SCIMARK_LARGE_SPARSE_BNAME), null, Constants.NOT_SET_REQ, "10", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.SCIMARK_SMALL_FFT_BNAME), null, Constants.NOT_SET_REQ, "100", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.SCIMARK_SMALL_LU_BNAME), null, Constants.NOT_SET_REQ, "125", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.SCIMARK_SMALL_SOR_BNAME), null, Constants.NOT_SET_REQ, "75", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.SCIMARK_SMALL_SPARSE_BNAME), null, Constants.NOT_SET_REQ, "25", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.SERIAL_BNAME), null, Constants.NOT_SET_REQ, "25", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.SUNFLOW_BNAME), null, Constants.NOT_SET_REQ, "30", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.XML_TRANSFORM_BNAME), null, Constants.NOT_SET_REQ, "7", Constants.MATCH_REQ);
        setupProp(getFixedOperationsProp(Constants.XML_VALIDATION_BNAME), null, Constants.NOT_SET_REQ, "40", Constants.MATCH_REQ);
        
        
        // Harness configuration
        setupProp(Constants.VERIFY_PROP, Constants.TRUE_VALUE, Constants.MATCH_REQ);
        setupProp(Constants.VALIDITY_CHECKSUM_PROP, Constants.TRUE_VALUE, Constants.MATCH_REQ);
        setupProp(Constants.VALID_SETUP_PROP, null, Constants.NOT_SET_REQ);
        setupProp(Constants.CREATE_XML_REPORT_PROP, Constants.TRUE_VALUE, Constants.MATCH_REQ);
        setupProp(Constants.CREATE_TXT_REPORT_PROP, Constants.TRUE_VALUE, Constants.WHATEVER_REQ);
        setupProp(Constants.CREATE_HTML_REPORT_PROP, Constants.TRUE_VALUE, Constants.WHATEVER_REQ);
        setupProp(Constants.GEN_VALIDITY_FILE_PROP, Constants.FALSE_VALUE, Constants.MATCH_REQ);
        setupProp(Constants.HARNESS_SPIN_AT_END_PROP, Constants.FALSE_VALUE, Constants.MATCH_REQ);
        setupProp(Constants.VERBOSE_PROP, Constants.FALSE_VALUE, Constants.WHATEVER_REQ);
        setupProp(Constants.PRINT_PROGRESS_PROP, Constants.FALSE_VALUE, Constants.WHATEVER_REQ);
        
        // Environment configuration
        setupProp(Constants.HOMEDIR_PROP, ".", Constants.WHATEVER_REQ, ".", Constants.WHATEVER_REQ);
        setupProp(Constants.RESULT_DIR_PROP, "./results", Constants.WHATEVER_REQ, "./results", Constants.WHATEVER_REQ);
        setupProp(Constants.PROPFILE_PROP, null, Constants.WHATEVER_REQ, null, Constants.WHATEVER_REQ);
        setupProp(Constants.PROPFILE_ADDITIONAL_PROP, null, Constants.WHATEVER_REQ, null, Constants.WHATEVER_REQ);
        setupProp(Constants.BENCHMARK_THREADS_HW_OVERRIDE_PROP, null, Constants.WHATEVER_REQ, null, Constants.NOT_SET_REQ);
        
        // Analyzer configuration
        setupProp(Constants.ANALYZER_NAMES_PROP, "", Constants.WHATEVER_REQ);
        setupProp(Constants.ANALYZER_FREQUENCY_PROP, "1s", Constants.WHATEVER_REQ);
        setupProp(Constants.ANALYZER_POWER_HOST, "127.0.0.1", Constants.WHATEVER_REQ);
        setupProp(Constants.ANALYZER_POWER_PORT, "8888", Constants.WHATEVER_REQ);
        setupProp(Constants.ANALYZER_POWER_VERBOSE, "false", Constants.WHATEVER_REQ);
        setupProp(Constants.ANALYZER_POWER_DUMMY, "false", Constants.WHATEVER_REQ);
		setupProp(Constants.ANALYZER_TEMP_HOST, "127.0.0.1", Constants.WHATEVER_REQ);
		setupProp(Constants.ANALYZER_TEMP_PORT, "8889", Constants.WHATEVER_REQ);
		setupProp(Constants.ANALYZER_TEMP_VERBOSE, "false", Constants.WHATEVER_REQ);
		setupProp(Constants.ANALYZER_TEMP_DUMMY, "false", Constants.WHATEVER_REQ);
		setupProp(Constants.ANALYZER_METER_VERBOSE, "false", Constants.WHATEVER_REQ);
		setupProp(Constants.ANALYZER_SENSOR_VERBOSE, "false", Constants.WHATEVER_REQ);
        
        
        // Benchmark configuration
        setupProp(Constants.BENCHMARKS_PROP, Constants.VALID_BENCHMARKS_SPEC, Constants.MATCH_REQ, Constants.VALID_BENCHMARKS_LAGOM, Constants.MATCH_REQ);
        setupProp(Constants.INITIAL_CHECK_PROP, Constants.TRUE_VALUE, Constants.MATCH_REQ);
        setupProp(Constants.BENCHMARK_THREADS_PROP + "." + Constants.CHECK_BNAME, "1", Constants.MATCH_REQ);
        setupProp(Constants.BENCHMARK_THREADS_PROP + "." + Constants.SUNFLOW_BNAME, "0.5x" + Constants.HWT_VALUE, Constants.WHATEVER_REQ);
        setupProp(Constants.SERIAL_STARTUP_PORT_PROP, "3000", Constants.WHATEVER_REQ);
        setupProp(Constants.SCIMARK_SIZE_PROP, "DEFAULT", Constants.MATCH_REQ);
        setupProp(Constants.SUNFLOW_THREADS, "4", Constants.MATCH_REQ);
        setupProp(Constants.XML_TRANSFORM_OUT_DIR_PROP, null, Constants.NOT_SET_REQ);
        setupProp(Constants.XML_TRANSFORM_LEAVE_OUT_DIR_PROP, null, Constants.NOT_SET_REQ);
        setupProp(Constants.XML_VALIDATION_INPUT_DIR_PROP, null, Constants.SPECIAL_REQ);
        setupProp(Constants.STARTUP_RUN_ALL_SCIMARK, null, Constants.NOT_SET_REQ);
        setupProp(Constants.STARTUP_RUN_ALL_CRYPTO, null, Constants.NOT_SET_REQ);
        setupProp(Constants.DEBUG_DERBY, null, Constants.WHATEVER_REQ);
        setupProp(Constants.DEBUG_STARTUP, null, Constants.WHATEVER_REQ);
        setupProp(Constants.DEBUG_VALIDATION, null, Constants.WHATEVER_REQ);       
    }
    
    public static void setupProp(String name, String defValueSPECbase, String requirementSPECbase, String defValueSPECpeak, String requirementSPECpeak, String defValueLagom, String requirementLagom) {
        defaultPropertiesSPECbase.put(name, (defValueSPECbase == null ? "null" : defValueSPECbase));
        propsRequirementsSPECbase.put(name, requirementSPECbase);
        defaultPropertiesSPECpeak.put(name, (defValueSPECpeak == null ? "null" : defValueSPECpeak));
        propsRequirementsSPECpeak.put(name, requirementSPECpeak);
        defaultPropertiesLagom.put(name, (defValueLagom == null ? "null" : defValueLagom));
        propsRequirementsLagom.put(name, requirementLagom);
    }
    
    public static void setupProp(String name, String defValueSPEC, String requirementSPEC, String defValueLagom, String requirementLagom) {
        setupProp(name, defValueSPEC, requirementSPEC, defValueSPEC, requirementSPEC, defValueLagom, requirementLagom);
    }
    
    public static void setupProp(String name, String defValue, String requirement) {
        setupProp(name, defValue, requirement, defValue, requirement);
    }
    
    public static String getFixedOperationsProp(String bname) {
        return Constants.FIXED_OPERATIONS_PROP + "." + bname;
    }

    public static void runBenchmarkSuite(Properties commandLineProps) {
        
        // Read run properties
        String pf = commandLineProps.getProperty(Constants.PROPFILE_PROP);
        try {
            userProperties = readProperties(pf);
        } catch (Exception e) {
            System.out.println("Error reading properites file '" + pf + "'");
            System.out.println(e.getMessage());
            return;
        }
        
        // Add command line props (which overrides property files props)
        userProperties.putAll(commandLineProps);
        userProperties.put(Constants.HOMEDIR_PROP, specjvmHomeDir);
        verbose = Util.getBoolProperty(Constants.VERBOSE_PROP, null);

        // Setup Context ++
        setupContext();
        SuiteResult sResult = Context.getSuiteResult();

        // Check properties
        try {
            checkSetup(sResult);
        } catch(StopBenchmarkException e) {
            // System.err.println(e.getMessage());
            e.printStackTrace();
            return;
        }
        
        
        ProgramRunner.setPrintProgress(Util.getBoolProperty(Constants.PRINT_PROGRESS_PROP, null));
        
        String benchmarks = Util.getProperty(Constants.BENCHMARKS_PROP, null);
        String propfile = Util.getProperty(Constants.PROPFILE_PROP, null);
        boolean doCheck = Util.getBoolProperty(Constants.INITIAL_CHECK_PROP, null);
        
        setupReportInfo(sResult, userProperties);
        sResult.setWorkloadName(Util.getProperty(Constants.NAME_OF_RUN_PROP, null));
        
        Context.getOut().println();
        Context.getOut().println(Util.getProperty(Constants.NAME_OF_RUN_PROP, null));
        Context.getOut().println("  Properties file:   " + (propfile != null ? propfile : "none"));
        if (Util.getProperty(Constants.PROPFILE_ADDITIONAL_PROP, null) != null) {
            Context.getOut().println("  Properties file 2: " + Util.getProperty(Constants.PROPFILE_ADDITIONAL_PROP, null));
        }
        if (AnalyzersRunner.getNoAnalyzer() > 0) {
            Context.getOut().println("  Analyzers:         " + AnalyzersRunner.getAnalyzerNames());
        }
        if (Context.getSpecBasePath().equals(".") == false) {
            Context.getOut().println("  Base dir:          " + Context.getSpecBasePath());
        }
        Context.getOut().println("  Benchmarks:        " + benchmarks);
        
        Context.getOut().println();
        if (!sResult.isCompliant()) {
            Context.getOut().println("  WARNING: Run will not be compliant.");
            Iterator<String> iter = sResult.getViolations().iterator();
            while (iter.hasNext()) {
                Context.getOut().println("  " + iter.next());
            }
            Context.getOut().println();
        }
        
        if (verbose) {
            Context.getOut().println("User defined properties:");
            Util.printProperties(userProperties);
            Context.getOut().println();
            
            Context.getOut().println("Default properties:");
            Util.printProperties(defaultProperties);
            Context.getOut().println();
            
            Context.getOut().println("Requirements:");
            Util.printReqs(propsRequirements);
            Context.getOut().println();
        }
        
        // Make sure the benchmarks exists (find typos early)
        boolean cont = true;
        for (StringTokenizer st = new StringTokenizer(benchmarks); st.hasMoreElements(); ) {
            String bm = st.nextToken().trim();
            if (!isBenchmark(bm)) {
                Context.getOut().println("Unknown benchmark: " + bm);
                cont = false;
            }
        }
        if (!cont) {
            Context.getOut().println("Aborting.");
            Context.getOut().println();
            return;
        }
        
        // Open file for raw results
        String resultFileName = null;        
        if (Util.getBoolProperty(Constants.CREATE_XML_REPORT_PROP, null)) {
            try {
                resultFileName = openResultFile(userProperties);                
            } catch (IOException ioe) {
                Context.getOut().println("Aborting.");
                Context.getOut().println();
                return;
            }
        }
        
        if (Util.getBoolProperty(Constants.CREATE_XML_REPORT_PROP, null)) {
            sResult.headerToXml(Context.getXmlResultFile(), 0);
        }
        
        // Run JVM check benchmark
        BenchmarkResult check = null;
        if (doCheck) {
            check = runOneBenchmark("check", TestResult.ITER, 1, defaultMode);
            sResult.addBenchmarkResults(check);
        }
        
        // Run benchmarks
        if (check == null || check.isValid()) {
            BenchmarkResult  res;
            StringTokenizer bmt = new StringTokenizer(benchmarks);
            while (bmt.hasMoreTokens()) {
                String benchmark = bmt.nextToken();
                int runType = Util.getIntProperty(Constants.TYPE_OF_RUN_PROP, null);
                int fixedOpsNumber = (runType == TestResult.TIMED ? -1 : Util.getIntProperty(Constants.FIXED_OPERATIONS_PROP, benchmark));
                
                if (BenchmarkThread.createValidityCheckFiles) {
                    runOneBenchmark(benchmark, TestResult.ITER, 1, defaultMode);
                    continue;
                }
                
                if(benchmark.startsWith(Constants.SCIMARK_BNAME_PREFIX)){
                    if(benchmark.endsWith(Constants.SCIMARK_BNAME_LARGE_POSTFIX)){
                        setupProp(Constants.SCIMARK_SIZE_PROP, "LARGE", Constants.WHATEVER_REQ, "LARGE", Constants.WHATEVER_REQ);
                    } else if(benchmark.endsWith(Constants.SCIMARK_BNAME_SMALL_POSTFIX)){
                        setupProp(Constants.SCIMARK_SIZE_PROP, "SMALL", Constants.WHATEVER_REQ, "SMALL", Constants.WHATEVER_REQ);
                    } else{
                        setupProp(Constants.SCIMARK_SIZE_PROP, "DEFAULT", Constants.WHATEVER_REQ, "DEFAULT", Constants.WHATEVER_REQ);
                    }
                    //benchmark = benchmark.substring(0,benchmark.lastIndexOf("."));
                    res = runOneBenchmark(benchmark, runType, fixedOpsNumber, scimarkMode);
                } else if( benchmark.startsWith(Constants.STARTUP_BNAME_PREFIX)){
                    res = runOneBenchmark(benchmark, TestResult.ITER, 1, startupMode);
                } else{
                    res = runOneBenchmark(benchmark, runType, fixedOpsNumber, defaultMode);
                }
                
                
                //res = benchmark.startsWith("startup")
                //? runOneBenchmark(benchmark, TestResult.ITER, Integer.parseInt(System.getProperty("stloops")), userProperties, true)
                // ? runOneBenchmark(benchmark, TestResult.ITER, 1, startupMode)
                // : runOneBenchmark(benchmark, runType, loopsNumber, defaultMode);
                sResult.addBenchmarkResults(res);
            }
        } else {
            Context.getOut().println("No benchmarks will be run, since startup failed.");
        }

        // Tear down analyzers.
        AnalyzersRunner.tearDownAnalyzerClasses();
        
        // Handle results
        if (Util.getBoolProperty(Constants.CREATE_XML_REPORT_PROP, null)) {
            sResult.footerToXml(Context.getXmlResultFile(), 0);
            closeResultFile(resultFileName);            
        }
        
        // Create fancy report (optional)
        if (Util.getBoolProperty(Constants.CREATE_XML_REPORT_PROP, null)
        && (Util.getBoolProperty(Constants.CREATE_HTML_REPORT_PROP, null)
        || Util.getBoolProperty(Constants.CREATE_TXT_REPORT_PROP, null))){
            try {
                String [] rArgs = {
                        resultFileName,
                        "-sub", "true",
                        "-summary", "true",
                        "-txt", Util.getProperty(Constants.CREATE_TXT_REPORT_PROP, null),
                        "-html", Util.getProperty(Constants.CREATE_TXT_REPORT_PROP, null)
                };
                createReport(rArgs);
            } catch (Exception e) {
                Context.getOut().println("Error while creating report: " + e.getMessage());
                e.printStackTrace(Context.getOut());
            }
        }
        
        if (Util.getBoolProperty(Constants.HARNESS_SPIN_AT_END_PROP, null)) {
            Context.getOut().println("Harness will sleep here.");
            // This is useful, if you want to attach to the process and look at what state it ended in.
            while (Util.sleep(1000));
        }
    }
    
    protected static String openResultFile(Properties userProperties) throws IOException, FileNotFoundException {
        File resultDir = new File(Util.getProperty(Constants.RESULT_DIR_PROP, null));
        if (resultDir.exists()) {
            if (!resultDir.isDirectory()) {
                throw new IOException("Result dir " + resultDir.getAbsolutePath() + " is a file and already exists.");
            }
        } else {
            if (!resultDir.mkdir()) {
                throw new IOException("Failed to create dir " + resultDir.getAbsolutePath());
            }
        }

        String xmlFileName = getNextRawFileInDir(resultDir);
        PrintStream xmlPs = new PrintStream(new FileOutputStream(xmlFileName));
        Context.setXmlResultFile(xmlPs);
        return xmlFileName;
    }   

    public static String getNextRawFileInDir() throws IOException {
        File resultDir = new File(Util.getProperty(Constants.RESULT_DIR_PROP, null));
        return getNextRawFileInDir(resultDir);
    }
    
    public static String getNextRawFileInDir(File resultDir) throws IOException {
        File resultFile = null;
        String localName = null;
        for (int i = 1; resultFile == null; i++) {
            String is = (i < 10 ? "00" + i : i < 100 ? "0" + i : "" + i);
            localName = "SPECjvm2008." + is;
            resultFile = new File(resultDir.getAbsolutePath() + "/" + localName);
            if (resultFile.exists()) {
                resultFile = null;
            }
        }
        
        if (!resultFile.mkdir()) {
            throw new IOException("Failed to create dir " + resultFile.getAbsolutePath());
        }
        return resultFile + "/" + localName + ".raw";
        
    }
    
    protected static void closeResultFile(String resultFile) {
        Context.getOut().println("Results are stored in: \n" + resultFile);
        Context.closeXmlResultFile();
    }
    
    protected static void closeSubmissionFile(String submissionFile) {
        Context.getOut().println("Results are stored in: \n" + submissionFile);
    }
    
    public static void createReport(String xmlFileName) throws Exception {
        createReport(new String[]{xmlFileName});
    }
    
    public static void createReport(String [] reporterArgs) throws Exception {
        Reporter.main(reporterArgs);
    }
    
    private static BenchmarkResult runOneBenchmark(String bm, int runMode, int fixedLoops, int mode) {
        BenchmarkResult bmResult = new BenchmarkResult();
        String args[] = null;
        //args = ((mode == startupMode)) ? new String[]{bm.substring(bm.indexOf(".") + 1)} :((mode == scimarkMode)) ? new String[]{bm.substring(0,bm.lastIndexOf("."))} : new String[0];
        if(mode == startupMode){
            args = new String[]{bm.substring(bm.indexOf(".")+1)};
        } else if(mode == scimarkMode){
            args = new String[]{bm.substring(0,bm.lastIndexOf("."))};
        } else {
            args = new String[0];
        }
        //System.out.println("args[0]: " + args[0] );
        bmResult.setNames(bm);
        bmResult.setArgs(args);
        bmResult.setRunMode(runMode);
        bmResult.setNumberOfLoops(fixedLoops);
        
        bmResult.setIterationTime(
                Util.getTimeProperty(Constants.RUNTIME_PROP, bm),
                Util.getBoolProperty(Constants.FORCED_RUNTIME_PROP, bm));
        
        int miniter = Util.getIntProperty(Constants.ITERATIONS_MINIMUM_PROP, bm);
        bmResult.setMinIter(miniter);
        
        int maxiter = Util.getIntProperty(Constants.ITERATIONS_MAXIMUM_PROP, bm);
        if (maxiter != -1 && maxiter < miniter) {
            // -1 means forever...
            maxiter = miniter;
        }
        bmResult.setMaxIter(maxiter);
        
        currentNumberBmThreads = Util.getHwtCalcProperty(Constants.BENCHMARK_THREADS_PROP, bm);
        bmResult.setNumberBmThreads((mode == startupMode) ? 1 : currentNumberBmThreads);
        bmResult.setWarmupTime(Util.getTimeProperty(Constants.WARMUPTIME_PROP, bm));
        bmResult.setIterationForcegc(Util.getBoolProperty(Constants.ITER_DO_SYSTEMGC_PROP, bm));
        bmResult.setIterationDelay(Util.getTimeProperty(Constants.ITER_DELAYTIME_PROP, bm));
        bmResult.setBenchmarkForcegc(Util.getBoolProperty(Constants.BM_DO_SYSTEMGC_PROP, bm));
        bmResult.setBenchmarkDelay(Util.getTimeProperty(Constants.BM_DELAYTIME_PROP, bm));
        bmResult.setChecksum(Util.getBoolProperty(Constants.VALIDITY_CHECKSUM_PROP, bm));
        bmResult.setAnalyzers(Util.getProperty(Constants.ANALYZER_NAMES_PROP, bm));
        bmResult.setAnalyzerFreq(Util.getTimeProperty(Constants.ANALYZER_FREQUENCY_PROP, bm));
        
        if (runMode == TestResult.ITER) {
            bmResult.setIterationTime(-1);
            bmResult.setNumberOfLoops(fixedLoops);
            bmResult.setWarmupTime(-1);
        }
        
        ProgramRunner runner = new ProgramRunner(bmResult, mode);
        runner.start();
        try {
            runner.join();
        } catch (InterruptedException e) {
            // Context.getOut().println(e.getClass().getName() + ": " + e.getMessage());
            e.printStackTrace(Context.getOut());
        }
        return bmResult;
    }
    
    public static Properties readProperties(String name) throws FileNotFoundException, IOException {
        
        Properties props = new Properties();
        
        if (name != null) {
            
            String fullFileName = null;
            {
                String potFullFileName;
            	potFullFileName = name;
            	if (new File(potFullFileName).exists()) {
            		fullFileName = potFullFileName;
                } else {
                    potFullFileName = specjvmHomeDir + "/props/" + name;
                    if (new File(potFullFileName).exists()) {
                        fullFileName = potFullFileName;
                	} 
                }
            }
            
            FileInputStream fisFullFileName = null;
            
            try {
                fisFullFileName = new FileInputStream(fullFileName);
                props.load(fisFullFileName);
                props.setProperty(Constants.PROPFILE_PROP, fullFileName);
                props.setProperty(Constants.HOMEDIR_PROP, specjvmHomeDir);
            } catch (FileNotFoundException fnfe) {
                throw new FileNotFoundException("Can't find properties file '" + name + "'");
            } finally {
                fisFullFileName.close();
            }
            
            String nextFileName = props.getProperty("specjvm.additional.properties.file");
            if (nextFileName != null) {
                String nextFileNameFull = null;
                String nextPotFullFileName = null; 
                nextPotFullFileName = nextFileName;
                if (new File(nextPotFullFileName).exists()) {
                    nextFileNameFull = nextPotFullFileName;
				} else {
					nextPotFullFileName = specjvmHomeDir + "/props/" + nextFileName;
					if (new File(nextPotFullFileName).exists()) {
						nextFileNameFull = nextPotFullFileName;
					}
				}
                
                FileInputStream fisFileNameFull = null;
                
                try {
                    fisFileNameFull = new FileInputStream(nextFileNameFull);
                    props.load(fisFileNameFull);
                } catch (FileNotFoundException fnfe) {
                    throw new FileNotFoundException("Can't find additional properties file '" + nextFileName + "'");
                } finally {
                    fisFileNameFull.close();
                }
            }
        }
        return props;
    }
    
    private static void addViolation(SuiteResult sResult, String key, String message) {
        if (invalidProperties.get(key) == null) {
            invalidProperties.put(key, message);
            sResult.addViolation(message);
        }
    }
    
    private static void addConfigurationDetail(SuiteResult sResult, String key, String message) {
        if (additionalConfigurationProperties.get(key) == null) {
            additionalConfigurationProperties.put(key, message);
            sResult.addConfiguration(message);
        }
    }
    
    private static void validateProperty(SuiteResult sResult, String key, String value, String defValue, String req, String baseKey) {
        if (req == null) {
            throw new StopBenchmarkException("Requirement for property " + key + " is not set.");
        }
        // Special case benchmarks string.
        if (key != null && key.equals(Constants.BENCHMARKS_PROP)) {
            if (req.equals(Constants.MATCH_REQ)) {
                if (value == null || !value.equals(defValue)) {
                    addViolation(sResult, baseKey, "Not a valid sequence of benchmarks for publication.");
                }
            } else {
                throw new StopBenchmarkException("Don't know how to handle requirement " + req + " for property " + key);
            }
        }
        
        if (req.equals(Constants.WHATEVER_REQ)) {
            if ((value == null && defValue != null)
            || (value != null && defValue == null)
            || (value != null && !value.equals(defValue))) {
                addConfigurationDetail(sResult, baseKey, key + "=" + value);
            }
        } else if (req.equals(Constants.NOT_SET_REQ)) {
            // This property may not be set.
            if (value != null) {
                addViolation(sResult, baseKey, "Property " + key + " not allowed in publication run.");
            }
        } else if (req.equals(Constants.MATCH_REQ)) {
            // This property must match.
            if (value == null || !value.equals(defValue)) {
                addViolation(sResult, baseKey, key + " must be " + defValue + " for publication.");
            }
        } else if (req.equals(Constants.TIME_MAX_5s_REQ)) {
            // This property must be no more than 5 seconds.
            if (value == null || Util.getTimeAsMillis(value) > 5000) {
                addViolation(sResult, baseKey, key + " may not be higher than 5 seconds for publication.");
            } else if (!value.equals(defValue)) {
                addConfigurationDetail(sResult, baseKey, key + "=" + value);
            }
        } else if (req.equals(Constants.AT_LEAST_1_MARK_IF_HIGHER)) {
            // This property must at least 1, comment if it is above.
        	try {
        		int i = Integer.parseInt(value);
        		if (i < 1) {
                    addViolation(sResult, baseKey, key + " must be at least 1.");
        		} else if (i > 1) {
                    addConfigurationDetail(sResult, baseKey, key + "=" + value);
        		}
        	} catch(Exception e) {
                addViolation(sResult, baseKey, key + " must be set to an integer.");
        	}
            
        } else if (req.equals(Constants.TIME_AT_LEAST_REQ)) {
            // This time property must be at least as much as default.
            if (value == null || Util.getTimeAsMillis(value) < Util.getTimeAsMillis(defValue)) {
                addViolation(sResult, baseKey, key + " must be at least " + Util.getTimeAsSeconds(defValue) + " seconds for publication.");
            } else if (!value.equals(defValue)) {
                addConfigurationDetail(sResult, baseKey, key + "=" + value);
            }
        } else if (req.equals(Constants.SPECIAL_REQ)) {
            if (key != null && key.startsWith(Constants.XML_VALIDATION_INPUT_DIR_PROP)) {
                if (value != null && !"resources/xml.validation".equals(value)) {
                    addViolation(sResult, baseKey, key + " should be either not set or equal to resources/xml.validation" + " for publication.");
                }
            } else {
                if (Constants.STARTUP_LAUNCHER.equals(key) && value != null && !checkLauncher(value)) {
                    addViolation(sResult, baseKey, key + " should be the same as a current launcher for publication.");
                }
            }
            
        } else {
            throw new StopBenchmarkException("Don't know how to handle requirement: " + req);
        }
    }
    
    public static void checkSetup(SuiteResult sResult) {
        
        String benchmarks = Util.getProperty(Constants.BENCHMARKS_PROP, null);
        if (benchmarks == null) {
            throw new StopBenchmarkException("No benchmarks specified, property is null.");
        }
        
        if (workLoad.equals(Constants.WORKLOAD_NAME_NOT_SET)) {
            // Check if this is a base or a peak run (lagom would not end up here)
        	String [] allJvmArgs = parseDefaultJvmArgs();
            String jvmOptionsStartup = Util.getProperty(Constants.STARTUP_JVM_OPTIONS_PROP, null);
            if (// If JVM arguments are used, it is a peak run.
            		(allJvmArgs[0] == null || allJvmArgs[0].equals("n/a")
            				|| allJvmArgs[0].equals("") || allJvmArgs[0].equals("-showversion"))
            	// If JVM arguments are used, it is a peak run.
                    && (jvmOptionsStartup == null || jvmOptionsStartup.equals("n/a")
                            || jvmOptionsStartup.equals("") || jvmOptionsStartup.equals("-showversion"))        	    
                // If iterations are more than one, it is a peak run.
            		&& (Util.getUserProperty(Constants.ITERATIONS_MINIMUM_PROP, null) == null 
            				|| Util.getUserProperty(Constants.ITERATIONS_MINIMUM_PROP, null)
            				.equals(Util.getDefaultProperty(Constants.ITERATIONS_MINIMUM_PROP, null)))
            		&& (Util.getUserProperty(Constants.ITERATIONS_MAXIMUM_PROP, null) == null 
            				|| Util.getUserProperty(Constants.ITERATIONS_MAXIMUM_PROP, null)
            				.equals(Util.getDefaultProperty(Constants.ITERATIONS_MAXIMUM_PROP, null)))
        	   // If warmup time or run time time is changed, it is a peak run.
            		&& (Util.getUserProperty(Constants.WARMUPTIME_PROP, null) == null 
            				|| Util.getUserProperty(Constants.WARMUPTIME_PROP, null)
            				.equals(Util.getDefaultProperty(Constants.WARMUPTIME_PROP, null)))
            		&& (Util.getUserProperty(Constants.RUNTIME_PROP, null) == null 
            				|| Util.getUserProperty(Constants.RUNTIME_PROP, null)
            				.equals(Util.getDefaultProperty(Constants.RUNTIME_PROP, null)))) {
                defaultProperties = defaultPropertiesSPECbase;
                propsRequirements = propsRequirementsSPECbase;
                workLoad = Constants.WORKLOAD_NAME_SPEC_BASE;
            } else {
                defaultProperties = defaultPropertiesSPECpeak;
                propsRequirements = propsRequirementsSPECpeak;
                workLoad = Constants.WORKLOAD_NAME_SPEC_PEAK;
            }
        }
        
        
        // Go through all properties in default and validate what you get in default.
        for (Enumeration dk = defaultProperties.keys(); dk.hasMoreElements(); ) {
            String key = (String) dk.nextElement();
            validateProperty(sResult, key, Util.getProperty(key, null), Util.getDefaultProperty(key, null), propsRequirements.get(key), key);
            // Go through all properties in default with benchmark addon and validate what you get in default.
            for (StringTokenizer st = new StringTokenizer(benchmarks); st.hasMoreElements(); ) {
                String bm = st.nextToken().trim();
                validateProperty(sResult, key + "." + bm, Util.getProperty(key, bm), Util.getDefaultProperty(key, bm), propsRequirements.get(key), key);
            }
        }
        
        // Don't accept unknown properties.
        // Go through all properties in jvm and make sure they are in default.
        for (Enumeration sk = userProperties.keys(); sk.hasMoreElements();) {
            String key = (String) sk.nextElement();
            if (key.startsWith("spec.jvm2008.report")) {
                continue;
            }

            boolean found = defaultProperties.containsKey(key);
            for (StringTokenizer st = new StringTokenizer(benchmarks); !found && st.hasMoreElements();) {
                String bm = st.nextToken().trim();
                if (key.endsWith("." + bm)) {
                    String shortKey = key.substring(0, key.length() - 1 - bm.length());
                    if (defaultProperties.containsKey(shortKey)) {
                        found = true;
                    }
                }
            }

            if (!found) {
                addViolation(sResult, key, "Property " + key + " unknown.");
            }
        }
        
        // Check that analyzer classes are sound (and initiate classes).
        try {
            AnalyzersRunner.setupAnalyzerClasses(Util.getProperty(Constants.ANALYZER_NAMES_PROP, null));
        } catch(Throwable t) {
            throw new StopBenchmarkException("Error setting up analyzers: " + t.getClass().getName() + ": " + t.getMessage(), t);
        }
    }
    
    public static void setupContext() {
        Context.setSpecBasePath(Util.getProperty(Constants.HOMEDIR_PROP, null));
        Context.setVerify(Util.getBoolProperty(Constants.VERIFY_PROP, null));
        if (DEBUG) {
            System.out.println(Context.staticToString());
        }
        Context.setSuiteResult(new SuiteResult());
    }
    
    private static void setupReportInfo(SuiteResult sr, Properties specjvmProps) {
        
        if (verbose) {
            Context.getOut().println("Report values: ");
        }

        sr.addRunInfo(Constants.REPORTER_RUN_DATE, null, new Date().toString());
        sr.addRunInfo(Constants.REPORTER_RUN_TESTER, specjvmProps, System.getProperty("user.name", "n/a"));
        sr.addRunInfo(Constants.REPORTER_RUN_SUBMITTER, specjvmProps, "n/a");
        sr.addRunInfo(Constants.REPORTER_RUN_SUBMITTER_URL,specjvmProps, "n/a");
        sr.addRunInfo(Constants.REPORTER_RUN_LOCATION, specjvmProps, "n/a");
        sr.addRunInfo(Constants.REPORTER_RUN_LICENSE, specjvmProps, "n/a");
        
        sr.addJvmInfo(Constants.REPORTER_JVM_NAME, specjvmProps, System.getProperty("java.vm.name", "n/a"));
        String jvv = System.getProperty("java.vm.version", "");
        String jvi = System.getProperty("java.vm.info", "");
        sr.addJvmInfo(Constants.REPORTER_JVM_VERSION, specjvmProps,  jvv + ((jvv.length() > 0 && jvi.length() > 0) ? " " : "") + jvi);
        sr.addJvmInfo(Constants.REPORTER_JVM_VENDOR, specjvmProps, System.getProperty("java.vm.vendor", System.getProperty("java.vendor", "n/a")));
        sr.addJvmInfo(Constants.REPORTER_JVM_VENDOR_URL, specjvmProps, System.getProperty("java.vm.vendor.url", System.getProperty("java.vendor.url", "n/a")));
        sr.addJvmInfo(Constants.REPORTER_JVM_JAVA_SPECIFICATION, specjvmProps, System.getProperty("java.specification.version", "n/a"));
        sr.addJvmInfo(Constants.REPORTER_JVM_ADDRESS_BITS,specjvmProps, System.getProperty("sun.arch.data.model", "n/a"));
        sr.addJvmInfo(Constants.REPORTER_JVM_AVAILABLE_DATE, specjvmProps, "n/a");
        
        String [] jvmArgs = parseDefaultJvmArgs();
        
        sr.addJvmInfo(Constants.REPORTER_JVM_COMMAND_LINE, specjvmProps, jvmArgs[0]);
        sr.addJvmInfo(Constants.REPORTER_JVM_COMMAND_LINE_INITIAL_HEAP_SIZE, specjvmProps, jvmArgs[1]);
        sr.addJvmInfo(Constants.REPORTER_JVM_COMMAND_LINE_MAX_HEAP_SIZE, specjvmProps, jvmArgs[2]);
        String scl = Util.getProperty(Constants.STARTUP_JVM_OPTIONS_PROP, null);
        sr.addJvmInfo(Constants.REPORTER_JVM_STARTUP_COMMAND_LINE, specjvmProps, scl != null ? scl : " ");
        String sl = Util.getProperty(Constants.STARTUP_LAUNCHER, null);
        sr.addJvmInfo(Constants.REPORTER_JVM_STARTUP_LAUNCHER, specjvmProps, sl != null ? sl : "default");
        sr.addJvmInfo(Constants.REPORTER_JVM_OTHER_TUNING, specjvmProps, " ");
        sr.addJvmInfo(Constants.REPORTER_JVM_APP_CLASS_PATH, null, System.getProperty("java.class.path", "n/a"));
        sr.addJvmInfo(Constants.REPORTER_JVM_BOOT_CLASS_PATH, null, System.getProperty("sun.boot.class.path", "n/a"));
        
        sr.addSwInfo(Constants.REPORTER_OS_NAME, specjvmProps, System.getProperty("os.name", "n/a"));
        sr.addSwInfo(Constants.REPORTER_OS_ADDRESS_BITS, specjvmProps, "n/a");
        sr.addSwInfo(Constants.REPORTER_OS_AVAILABLE_DATE, specjvmProps, "n/a");
        sr.addSwInfo(Constants.REPORTER_OS_TUNING, specjvmProps, " ");
        sr.addSwInfo(Constants.REPORTER_SW_FILESYSTEM, specjvmProps, "n/a");
        sr.addSwInfo(Constants.REPORTER_SW_OTHER_NAME, specjvmProps, " ");
        sr.addSwInfo(Constants.REPORTER_SW_OTHER_TUNING, specjvmProps, " ");
        sr.addSwInfo(Constants.REPORTER_SW_OTHER_AVAILABLE, specjvmProps, " ");
        
        sr.addHwInfo(Constants.REPORTER_HW_VENDOR, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_VENDOR_URL, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_MODEL, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_AVAILABLE, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_CPU_VENDOR, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_CPU_VENDOR_URL, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_CPU_NAME, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_CPU_SPEED, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_LOGICAL_CPUS, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_NUMBER_OF_CHIPS, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_NUMBER_OF_CORES, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_NUMBER_OF_CORES_PER_CHIP, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_THREADING_ENABLED, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_THREADS_PER_CORE, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_ADDRESS_BITS, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_CPU_CACHE_L1, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_CPU_CACHE_L2, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_CPU_CACHE_OTHER, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_MEMORY_SIZE, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_MEMORY_DETAILS, specjvmProps, "n/a");
        sr.addHwInfo(Constants.REPORTER_HW_DETAILS_OTHER, specjvmProps, "n/a");
        
    }

    private static String [] parseDefaultJvmArgs() {
        // Get command line details:
        String allArgs = Util.getProperty(Constants.REPORTER_JVM_COMMAND_LINE, "n/a");
        String msArg = Util.getProperty(Constants.REPORTER_JVM_COMMAND_LINE_INITIAL_HEAP_SIZE, "n/a");
        String mxArg = Util.getProperty(Constants.REPORTER_JVM_COMMAND_LINE_MAX_HEAP_SIZE, "n/a");
        
        if (parseDefaultArgs && (allArgs == null || allArgs.equals("n/a"))) {
            RuntimeMXBean rtMXBean = ManagementFactory.getRuntimeMXBean();
            List<String> args = rtMXBean.getInputArguments();
            StringBuilder sb = new StringBuilder();
            for (Iterator<String> iter = args.iterator(); iter.hasNext(); ) {
                String arg = iter.next();
                if (arg.indexOf("bootclasspath") != -1 
                        || arg.indexOf("sun.java.launcher") != -1
                        || arg.indexOf("-showversion") != -1
                        || arg.indexOf("java.home") != -1) {
                    continue;
                }

                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(arg);
                if (arg.indexOf("-Xms") != -1 || arg.indexOf("-ms") != -1) {
                    msArg = getSizeFromHeapArg(arg);
                }
                if (arg.indexOf("-Xmx") != -1 || arg.indexOf("-mx") != -1) {
                    mxArg = getSizeFromHeapArg(arg);
                }
            }
            allArgs = sb.toString();
        }
        String [] ret = new String[3];
        ret[0] = allArgs;
        ret[1] = msArg;
        ret[2] = mxArg;
        return ret; 
	}

	private static String getSizeFromHeapArg(String arg) {
        String msArg = null;
        if (arg == null) {
            return msArg;
        }
        for (int i = 1; i < arg.length(); i++) {
            if (Character.isDigit(arg.charAt(i))) {
                msArg = arg.substring(i);   
                break;
            }
        }
        return msArg;
    }
    
    public static boolean isBenchmark(String s) {
        if (Constants.CHECK_BNAME.equals(s)) {
            return false;
        } else if(s.startsWith(Constants.STARTUP_BNAME_PREFIX)) {
            int index=s.indexOf(".");
            if (index == -1) {
                return false;
            }
            String startupBenchmark = s.substring(index+1,s.length());
            if (startupBenchmark.startsWith(Constants.SCIMARK_BNAME_PREFIX)) {
                return new File(specjvmHomeDir + "/resources/" + startupBenchmark + "/validity." + startupBenchmark + ".dat").exists();
            }
            return isBenchmark(startupBenchmark);
        } else if(Util.isScimarkAndNotMonteCarlo(s)) {
            int index=s.lastIndexOf(".");
            if (index == -1) {
                return false;
            }
            String scimarkBenchmark = s.substring(0,index);
            return new File(specjvmHomeDir + "/resources/" + scimarkBenchmark + "/validity." + scimarkBenchmark + ".dat").exists();
        } else
            return new File(specjvmHomeDir + "/resources/" + s + "/validity." + s + ".dat").exists();
    }
    
    private static void usage(PrintStream ps) {
        ps.println("Usage: spec.harness.Launch <configuration>");
        ps.println("  -h,  --help                   Show this help.");
        ps.println("       --version                Print version and exit.");
        ps.println("  -sv, --showversion            Print version and continue.");
        ps.println("       --base                   Run the base compliant run of SPECjvm2008 ");
        ps.println("                                (default, unless jvm args are specified)");
        ps.println("       --peak                   Run the peak compliant run of SPECjvm2008");
        ps.println("       --lagom                  Run the Lagom benchmark suite, a version");
        ps.println("                                of SPECjvm2008 that uses a fixed workload.");
        ps.println("  -pf, --propfile <string>      Use this properties file.");
        ps.println("  -i,  --iterations <int>       How many iterations to run. ");
        ps.println("                                'inf' means an infinite number.");
        ps.println("  -mi, --miniter <int>          Minimum number of iterations.");
        ps.println("  -ma, --maxiter <int>          Maximum number of iterations.");
        ps.println("  -it, --iterationTime <time>   How long one iteration should be.");
        ps.println("                                The time is specified as an integer,");
        ps.println("                                and assumed to be in seconds, or an integer");
        ps.println("                                with unit, for example 4m (4 minutes).");
        ps.println("                                Units available are ms, s, m and h.");
        ps.println("                                If iteration time is too short, based on the");
        ps.println("                                warmup result, it will be adjusted to handle");
        ps.println("                                at least 5 operations.");
        ps.println("  -fit, --forceIterationTime    As iteration time, but not adjusting time.");
        ps.println("  -wt, --warmuptime <time>      How long warmup should be.");
        ps.println("                                Time format is the same as in iteration time.");
        ps.println("  -ops, --operations <int>      Hom many operations each iteration will consist");
        ps.println("                                of. It will then be a fixed workload and");
        ps.println("                                iteration time is ignored.");
        ps.println("  -bt, --benchmarkThreads <int> How many benchmark threads to use.");
        ps.println("  -ja, --jvmArgs \"options\"      JVM arguments used for startup subtests.");
        ps.println("  -jl, --jvmLauncher \"path\"     JVM launcher used for startup subtests.");
        ps.println("  -r,  --reporter <file name>   Invokes the reporter with given file(s).");
        ps.println("                                The benchmarks will not be run.");
        ps.println("  -v, --verbose                 Print verbose info.");
        ps.println("  -pja, --parseJvmArgs          Parse jvm arguments info for command line,");
        ps.println("                                including heap settings (uses JMXBean info)."); 
        ps.println("  -sp, --startport <int>        Start port number for serial benchmark.");
        ps.println("  -ic, --initialCheck <bool>)   Run check benchmark or not.");
        ps.println("  -crf, --createRawFile <bool>  Whether to generate a raw file.");
        ps.println("  -ctf, --createTextFile <bool> Whether to generate text report.");
        ps.println("  -chf, --createHtmlFile <bool> Whether to generate html report.");
        ps.println("                                If raw is disabled, so is text and html.");
        ps.println("  -xd, --xmlDir \"path\"          To set path to xml input files");
        ps.println("  <benchmark>                   Name of benchmark(s) to run. Benchmarks");
        ps.println("                                with sub-benchmarks is also possible to specify.");
        ps.println("                                By default all submission benchmarks will");
        ps.println("                                be selected.");
        ps.println("");
        ps.println("Benchmarks: " + Constants.VALID_BENCHMARKS_SPEC);
    }
    
    private static void version(PrintStream ps) {
        File vf = new File(specjvmHomeDir + "/version.txt");
        if (vf.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(vf));
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    ps.println(line);
                }
                br.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            ps.println("Version not available.");
        }
    }
    
    private static boolean parseArgs(String[] args, Properties props) {
        
        // if (args.length == 0) {
        // usage(System.out);
        // return false;
        // }
        
        for (int i = 0; i < args.length; i++) {
            // Help...
            if (args[i].equalsIgnoreCase("-h") || args[i].equalsIgnoreCase("--help") || args[i].equalsIgnoreCase("-help") || args[i].equals("/?") || args[i].equalsIgnoreCase("-?")) {
                usage(System.out);
                return false;
            }
            
            // Version...
            if (args[i].equalsIgnoreCase("-vs") || args[i].equalsIgnoreCase("-version") || args[i].equalsIgnoreCase("--version")) {
                version(System.out);
                return false;
            }
            
            // Invoke reporter...
            if (args[i].equalsIgnoreCase("-r") || args[i].equalsIgnoreCase("-reporter") || args[i].equalsIgnoreCase("--reporter")) {
                if (i + 1 < args.length) {
                    try {
                        String[] rArgs = new String[args.length - i - 1];
                        System.arraycopy(args, i + 1, rArgs, 0, rArgs.length);
                        createReport(rArgs);
                    } catch (Exception e) {
                        System.out.println("Error creating report: " + e.getMessage());
                    }
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                return false;
            }
            
            // Showversion...
            if (args[i].equalsIgnoreCase("-sv") || args[i].equalsIgnoreCase("-showversion") || args[i].equalsIgnoreCase("--showversion")) {
                version(System.out);
                
                // verbose
            } else if (args[i].equalsIgnoreCase("-v") || args[i].equalsIgnoreCase("-verbose") || args[i].equalsIgnoreCase("--verbose")) {
                verbose = true;
                props.setProperty(Constants.VERBOSE_PROP, Constants.TRUE_VALUE);
                props.setProperty(Constants.PRINT_PROGRESS_PROP, Constants.TRUE_VALUE);

                // Parse jvm command line args from RuntimeMXBean
            } else if (args[i].equalsIgnoreCase("-pja") || args[i].equalsIgnoreCase("--parseJvmArgs")) {
                parseDefaultArgs = true;
                
                // propfile
            } else if (args[i].equalsIgnoreCase("-pf") || args[i].equalsIgnoreCase("--propfile")) {
                if (i + 1 < args.length) {
                    props.setProperty(Constants.PROPFILE_PROP, args[++i]);
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                // result dir
            } else if (args[i].equalsIgnoreCase("-rd") || args[i].equalsIgnoreCase("--resultdir")) {
                if (i + 1 < args.length) {
                    props.setProperty(Constants.RESULT_DIR_PROP, args[++i]);
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                // startup jvm options
            }  else if (args[i].equalsIgnoreCase("-ja") || args[i].equalsIgnoreCase("--jvmArgs")) {
                if (i + 1 < args.length) {
                    props.setProperty(Constants.STARTUP_JVM_OPTIONS_PROP, args[++i]);
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                // startup jvm options
            } else if (args[i].equalsIgnoreCase("-jl") || args[i].equalsIgnoreCase("--jvmLauncher")) {
                if (i + 1 < args.length) {
                    props.setProperty(Constants.STARTUP_LAUNCHER, args[++i]);
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                // Run category
            } else if (args[i].equalsIgnoreCase("-i") || args[i].equalsIgnoreCase("--iterations")) {
                if (i + 1 < args.length) {
                    String s = args[++i];
                    if (s.equalsIgnoreCase("inf")) {
                        props.put(Constants.ITERATIONS_MINIMUM_PROP, "-1");
                        props.put(Constants.ITERATIONS_MAXIMUM_PROP, "-1");
                    } else {
                        try {
                            Integer.parseInt(s);
                            props.put(Constants.ITERATIONS_MINIMUM_PROP, s);
                            props.put(Constants.ITERATIONS_MAXIMUM_PROP, s);
                        } catch (NumberFormatException nfe) {
                            System.out.println("Error parsing " + args[i - 1] + ". Expects an integer: " + args[i]);
                        }
                    }
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                
                // set hardware threads override to say how many benchmark
                // threads to use
            } else if (args[i].equalsIgnoreCase("-bt") || args[i].equalsIgnoreCase("--benchmarkThreads")) {
                if (i + 1 < args.length) {
                    String s = args[++i];
                    try {
                        Integer.parseInt(s);
                        props.put(Constants.BENCHMARK_THREADS_HW_OVERRIDE_PROP, s);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error parsing " + args[i - 1] + ". Expects an integer, not: " + args[i]);
                        return false;
                    }
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                    return false;
                }
                
                // warmup time
            } else if (args[i].equalsIgnoreCase("-wt") || args[i].equalsIgnoreCase("--warmuptime")) {
                if (i + 1 < args.length) {
                    String s = args[++i];
                    try {
                        Util.getTimeAsMillis(s);
                        props.put(Constants.WARMUPTIME_PROP, s);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error parsing " + args[i - 1] + ". Expects a time string, not: " + args[i]);
                        return false;
                    }
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                    return false;
                }

                // Number of fixed operationds to make
            } else if (args[i].equalsIgnoreCase("-ops") || args[i].equalsIgnoreCase("--operations")) {
                if (i + 1 < args.length) {
                    String s = args[++i];
                    try {
                        Integer.parseInt(s);
                        props.put(Constants.FIXED_OPERATIONS_PROP, s);
                        props.put(Constants.TYPE_OF_RUN_PROP, "" + TestResult.ITER);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error parsing " + args[i - 1] + ". Expects an integer, not: " + args[i]);
                        return false;
                    }
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                    return false;
                }
                

            } else if (args[i].equalsIgnoreCase("-v") || args[i].equalsIgnoreCase("--verbose")) {
                if (i + 1 < args.length) {
                    String s = args[++i];
                    try {
                        Boolean.parseBoolean(s);
                        props.put(Constants.VERBOSE_PROP, s);
                    } catch (Exception e) {
                        System.out.println("Error parsing " + args[i - 1] + ". Expects a boolean value, not: " + args[i]);
                        return false;
                    }
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                    return false;
                }
                
            } else if (args[i].equalsIgnoreCase("-sp") || args[i].equalsIgnoreCase("--startport")) {
                if (i + 1 < args.length) {
                    String s = args[++i];
                    try {
                        Integer.parseInt(s);
                        props.put(Constants.SERIAL_STARTUP_PORT_PROP, s);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error parsing " + args[i - 1] + ". Expects a time string, not: " + args[i]);
                        return false;
                    }
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                    return false;
                }
                
                // run time of iteration
            } else if (args[i].equalsIgnoreCase("-it") || args[i].equalsIgnoreCase("--iterationTime")) {
                if (i + 1 < args.length) {
                    String s = args[++i];
                    try {
                        Util.getTimeAsMillis(s);
                        props.put(Constants.RUNTIME_PROP, s);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error parsing " + args[i - 1] + ". Expects a time string, not: " + args[i]);
                        return false;
                    }
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                    return false;
                }
                
                // forced time of iteration
            } else if (args[i].equalsIgnoreCase("-fit") || args[i].equalsIgnoreCase("--forceIterationTime")) {
                if (i + 1 < args.length) {
                    String s = args[++i];
                    try {
                        Util.getTimeAsMillis(s);
                        props.put(Constants.RUNTIME_PROP, s);
                        props.put(Constants.FORCED_RUNTIME_PROP, Constants.TRUE_VALUE);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error parsing " + args[i - 1] + ". Expects a time string, not: " + args[i]);
                        return false;
                    }
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                    return false;
                }
                
                // miniter
            } else if (args[i].equalsIgnoreCase("-mi") || args[i].equalsIgnoreCase("--minIter")) {
                if (i + 1 < args.length) {
                    String s = args[++i];
                    try {
                        Integer.parseInt(s);
                        props.put(Constants.ITERATIONS_MINIMUM_PROP, s);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error parsing " + args[i - 1] + ". Expects an integer: " + args[i]);
                    }
                } else {
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                
                // maxiter
            } else if (args[i].equalsIgnoreCase("-ma") || args[i].equalsIgnoreCase("--maxIter")) {
                if (i + 1 < args.length) {
                    String s = args[++i];
                    try {
                        Integer.parseInt(s);
                        props.put(Constants.ITERATIONS_MAXIMUM_PROP, s);
                    } catch (NumberFormatException nfe) {
                        System.out.println("Error parsing " + args[i - 1] + ". Expects an integer: " + args[i]);
                    }
                } else {
                    System.out.println();
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                
            } else if (args[i].equalsIgnoreCase("-ss") || args[i].equalsIgnoreCase("--scimarkSize")) {
                if (i + 1 < args.length) {
                    props.put(Constants.SCIMARK_SIZE_PROP, args[++i]);
                } else {
                    System.out.println();
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                
            } else if (args[i].equalsIgnoreCase("-xd") || args[i].equalsIgnoreCase("--xmlDir")) {
                if (i + 1 < args.length) {
                    props.put(Constants.XML_VALIDATION_INPUT_DIR_PROP, args[++i]);
                } else {
                    System.out.println();
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                
            } else if (args[i].equalsIgnoreCase("-xod") || args[i].equalsIgnoreCase("--xmlOutDir")) {
                if (i + 1 < args.length) {
                    props.put(Constants.XML_TRANSFORM_OUT_DIR_PROP, args[++i]);
                } else {
                    System.out.println();
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                
            } else if (args[i].equalsIgnoreCase("-xlod") || args[i].equalsIgnoreCase("--xmlLeaveOutDir")) {
                if (i + 1 < args.length) {
                    props.put(Constants.XML_TRANSFORM_LEAVE_OUT_DIR_PROP, args[++i]);
                } else {
                    System.out.println();
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                
            } else if (args[i].equalsIgnoreCase("-ic") || args[i].equalsIgnoreCase("--initialCheck")) {
                if (i + 1 < args.length) {
                    props.put(Constants.INITIAL_CHECK_PROP, args[++i]);
                } else {
                    System.out.println();
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                
            } else if (args[i].equalsIgnoreCase("-crf") || args[i].equalsIgnoreCase("--createRawFile")) {
                if (i + 1 < args.length) {
                    props.put(Constants.CREATE_XML_REPORT_PROP, args[++i]);
                } else {
                    System.out.println();
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                
            } else if (args[i].equalsIgnoreCase("-ctf") || args[i].equalsIgnoreCase("--createTextFile")) {
                if (i + 1 < args.length) {
                    props.put(Constants.CREATE_TXT_REPORT_PROP, args[++i]);
                } else {
                    System.out.println();
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                
            } else if (args[i].equalsIgnoreCase("-chf") || args[i].equalsIgnoreCase("--createHtmlFile")) {
                if (i + 1 < args.length) {
                    props.put(Constants.CREATE_HTML_REPORT_PROP, args[++i]);
                } else {
                    System.out.println();
                    System.out.println("Argument: " + args[i] + " expects a value.");
                }
                
                // Lagom workload
            } else if (args[i].equalsIgnoreCase("-lagom") || args[i].equalsIgnoreCase("--lagom")) {
                defaultProperties = defaultPropertiesLagom;
                propsRequirements = propsRequirementsLagom;
                workLoad = Constants.WORKLOAD_NAME_LAGOM;

                // Base workload
            } else if (args[i].equalsIgnoreCase("-base") || args[i].equalsIgnoreCase("--base")) {
                defaultProperties = defaultPropertiesSPECbase;
                propsRequirements = propsRequirementsSPECbase;
                workLoad = Constants.WORKLOAD_NAME_SPEC_BASE;

                // Peak workload
            } else if (args[i].equalsIgnoreCase("-peak") || args[i].equalsIgnoreCase("--peak")) {
                defaultProperties = defaultPropertiesSPECpeak;
                propsRequirements = propsRequirementsSPECpeak;
                workLoad = Constants.WORKLOAD_NAME_SPEC_PEAK;

                // arbitrary property
            } else if (args[i].length() > 2 && args[i].indexOf('=') > 0 && args[i].startsWith("-D")) {
                int ei = args[i].indexOf('=');
                String key = args[i].substring(2, ei);
                String value = args[i].substring(ei + 1, args[i].length());
                props.put(key, value);
                                
                
                // all benchmarks
            } else if (args[i].equalsIgnoreCase("all")) {
                props.put("specjvm.benchmarks", Constants.VALID_BENCHMARKS_SPEC);

                // shortcut all compiler benchmarks
            } else if (args[i].equalsIgnoreCase("compiler")) {
                String bms = props.getProperty("specjvm.benchmarks");
                bms = (bms == null ? Constants.BM_SHORTCUT_COMPILER : bms + " " + Constants.BM_SHORTCUT_COMPILER);
                props.put("specjvm.benchmarks", bms);

                // shortcut all crypto benchmarks
            } else if (args[i].equalsIgnoreCase("crypto")) {
                String bms = props.getProperty("specjvm.benchmarks");
                bms = (bms == null ? Constants.BM_SHORTCUT_CRYPTO : bms + " " + Constants.BM_SHORTCUT_CRYPTO);
                props.put("specjvm.benchmarks", bms);

                // shortcut all scimark benchmarks
            } else if (args[i].equalsIgnoreCase("scimark")) {
                String bms = props.getProperty("specjvm.benchmarks");
                bms = (bms == null ? Constants.BM_SHORTCUT_SCIMARK_ALL : bms + " " + Constants.BM_SHORTCUT_SCIMARK_ALL);
                props.put("specjvm.benchmarks", bms);
                
                // shortcut all scimark.small benchmarks
            } else if (args[i].equalsIgnoreCase("scimark.small")) {
                String bms = props.getProperty("specjvm.benchmarks");
                bms = (bms == null ? Constants.BM_SHORTCUT_SCIMARK_SMALL : bms + " " + Constants.BM_SHORTCUT_SCIMARK_SMALL);
                props.put("specjvm.benchmarks", bms);

                // shortcut all scimark.large benchmarks
            } else if (args[i].equalsIgnoreCase("scimark.large")) {
                String bms = props.getProperty("specjvm.benchmarks");
                bms = (bms == null ? Constants.BM_SHORTCUT_SCIMARK_LARGE : bms + " " + Constants.BM_SHORTCUT_SCIMARK_LARGE);
                props.put("specjvm.benchmarks", bms);

                // shortcut all startup benchmarks
            } else if (args[i].equalsIgnoreCase("startup")) {
                String bms = props.getProperty("specjvm.benchmarks");
                bms = (bms == null ? Constants.VALID_BENCHMARKS_STARTUP : bms + " " + Constants.VALID_BENCHMARKS_STARTUP);
                props.put("specjvm.benchmarks", bms);

            } else if (args[i].equalsIgnoreCase("throughput")) {
                String bms = props.getProperty("specjvm.benchmarks");
                bms = (bms == null ? Constants.VALID_BENCHMARKS_THROUGHPUT : bms + " " + Constants.VALID_BENCHMARKS_THROUGHPUT);
                props.put("specjvm.benchmarks", bms);

                // shortcut all xml benchmarks
            } else if (args[i].equalsIgnoreCase("xml")) {
                String bms = props.getProperty("specjvm.benchmarks");
                bms = (bms == null ? Constants.BM_SHORTCUT_XML : bms + " " + Constants.BM_SHORTCUT_XML);
                props.put("specjvm.benchmarks", bms);

                // benchmarks
            } else if (isBenchmark(args[i])) {
                String bms = props.getProperty("specjvm.benchmarks");
                bms = (bms == null ? args[i] : bms + " " + args[i]);
                props.put("specjvm.benchmarks", bms);
                
                // Giving up
            } else {
                System.out.println("Unknown argument or benchmark: " + args[i] + "\n");
                usage(System.out);
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String [] args) {
        Properties commandLineProps = new Properties();
        boolean cont = parseArgs(args, commandLineProps);
        if (cont == false) {
            return;
        }
        runBenchmarkSuite(commandLineProps);
    }
    
    /*
     * This method is used by BenchmarkThread.runSimple
     * and duplicates some of the code in runBenchmarkSuite (above)
     * It would be best to refactor things to avoid this duplication.
     */
    public static boolean setupSimple(String [] args) {
        Properties commandLineProps = new Properties();
        boolean cont = parseArgs(args, commandLineProps);
        if (cont == false) {
            return false;
        }
        // Read run properties
        try {
            userProperties = readProperties(commandLineProps.getProperty(Constants.PROPFILE_PROP));
        } catch (Exception e) {
            System.out.println("Error reading run properties: " + e.getMessage());
            return false;
        }
        
        // Add command line props (which overrides property files props)
        userProperties.putAll(commandLineProps);
        userProperties.put(Constants.HOMEDIR_PROP, specjvmHomeDir);
        userProperties.put(Constants.BENCHMARK_THREADS_PROP, "1");
        Launch.currentNumberBmThreads = 1;
        
        // Setup Context ++
        setupContext();
        return true;
    }
    
    public static boolean checkLauncher(String launcher) {
        Runtime run = Runtime.getRuntime();
        String launcherLog = "";
        try {
            Process p = run.exec(launcher
                    + " -classpath " + System.getProperty("java.class.path")
                    + " spec.harness.VMVersionTest");
            StartupBenchmarkOutput out = new StartupBenchmarkOutput(p
                    .getInputStream(), true);
            out.start();
            p.waitFor();
            launcherLog = out.log;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        return launcherLog.equals(VMVersionTest.getVersionInfo());
    }
}
