/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package deprecated.spec.reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.tools.javac.util.Pair;

import deprecated.spec.harness.Constants;
import deprecated.spec.harness.results.TestResult;


public class ReportGenerator {
	
    private ArrayList<Writer> writer = new ArrayList<Writer>();
    private Element root;    
    private ArrayList<BenchmarkRecord> benchmarksRecords = new ArrayList<BenchmarkRecord>();
    private double compositeScore;
    private String metric;
    TreeMap<String, Double> subGroupScores;
    private ArrayList<String> violations;
    private ArrayList<String> configs;    
    public boolean debug = false;
    private int validBenchmarksNum; 
    private String subFileName = null;
    private String summaryFileName = null;
    protected static String reporterDir = null;
    
    protected static String specNonCompliance = System.getProperty("spec.jvm2008.result.noncompliant");
    protected static String specNonComplianceReason = System.getProperty("spec.jvm2008.result.noncompliant.reason");
    protected static String specNonComplianceRemedy = System.getProperty("spec.jvm2008.result.noncompliant.remedy");
    protected static String specLogo = System.getProperty("spec.jvm2008.result.logo");
        
    public ReportGenerator(String ifn, boolean doHtml, boolean doTxt, boolean doSub, boolean doSummary) {

    	subGroupScores = new TreeMap<String, Double>();
        subGroupScores.put(Utils.SCIMARK_LARGE_SBNAME, (Double) null);
        subGroupScores.put(Utils.SCIMARK_SMALL_SBNAME, (Double) null);
        subGroupScores.put(Utils.CRYPTO_SBNAME, (Double)null);
        subGroupScores.put(Utils.COMPILER_SBNAME, (Double)null);
        subGroupScores.put(Utils.XML_SBNAME, (Double)null);
        subGroupScores.put(Utils.STARTUP_SBNAME, (Double)null);
        String inputFileName = ifn;
        reporterDir = new File(inputFileName).getAbsoluteFile().getParent();
        Utils.REPORTER_DIR = reporterDir;
        Utils.IMAGES_DIR = reporterDir + "/images";
        File images = new File(Utils.IMAGES_DIR);
        if (!images.exists()) {
            new File(Utils.IMAGES_DIR).mkdir();
        }
        FileInputStream rawFileIS = null;
        root = null;
        int index = inputFileName.lastIndexOf(".");
        String prefix = inputFileName.substring(0, index);
        if (doSub) {
            subFileName = prefix + ".sub";
        }
        if (doSummary) {
            summaryFileName = prefix + ".summary";
        }
        try { 
            if (doHtml) {
                System.out.println("Generate " + prefix + ".html" + " report.");
                writer.add(Writer.getInstance(Utils.HTML_WRITER_TYPE, prefix + ".html"));
            }
            if (doTxt) {
                System.out.println("Generate " + prefix + ".txt" + " report.");
                writer.add(Writer.getInstance(Utils.PLAIN_WRITER_TYPE, prefix + ".txt"));
            }
            rawFileIS = new FileInputStream(inputFileName);
            root = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(rawFileIS).getDocumentElement();
            handleBenchmarksResults(getChildByName(Utils.BM_RESULTS_ENAME));
        } catch (Exception e) {
            try {
                rawFileIS.close();
            } catch (IOException ioe) { }
            System.out.println("ERROR: Reporter cannot be initialized (" + e + ")");
            System.exit(-1);
        } finally {
            try {
                rawFileIS.close();
            } catch (IOException e) { }
        }
    }
    
    private double computeCompositeScore() {
        double product = 1;
        dbgPrint("Computing composite score...");
        int scimarkLargeCount = 0;
        int scimarkSmallCount = 0;
        int cryptoCount = 0;
        int startupCount = 0;
        int compilerCount = 0;
        int xmlCount = 0;
        double scimarkLargeProduct = 1;
        double scimarkSmallProduct = 1;
        double cryptoProduct = 1;
        double startupProduct = 1;
        double compilerProduct = 1;
        double xmlProduct = 1;
        for (int i = 0; i < benchmarksRecords.size(); i ++) {
            BenchmarkRecord record = (BenchmarkRecord)benchmarksRecords.get(i);
            if (record.isValidRun()) {
                dbgPrint("record.name: " + record.name + " record.maxScore: " + record.maxScore);
                if(Utils.isScimarkMonteCarlo(record)){
                    // Monte_Carlo is only run once, but needs to have equal weight
                    // to other scimark workloads.  Need to count monte_carlo score
                    // in both the scimarkLarge and scimarkSmall products.
                    
                    scimarkLargeCount++;
                    scimarkLargeProduct *= record.maxScore;
                    scimarkSmallCount++;
                    scimarkSmallProduct *= record.maxScore;
                    validBenchmarksNum++;
                } else if(Utils.isScimarkLarge(record)) {
                    scimarkLargeCount++;
                    scimarkLargeProduct *= record.maxScore;
                } else if(Utils.isScimarkSmall(record)) {
                    scimarkSmallCount++;
                    scimarkSmallProduct *= record.maxScore;
                } else if(Utils.isCrypto(record)) {
                    cryptoCount++;
                    cryptoProduct *= record.maxScore;
                } else if(Utils.isStartup(record)) {
                    startupCount++;
                    startupProduct *= record.maxScore;
                } else if(Utils.isCompiler(record)) {
                    compilerCount++;
                    compilerProduct *= record.maxScore;
                } else if(Utils.isXML(record)) {
                    xmlCount++;
                    xmlProduct *= record.maxScore;
                } else if (!Utils.isCheck(record)) {
                    product *= record.maxScore;
                }
            }
        }
        double scimarkLargeGeomMean = 1;
        if (scimarkLargeCount > 0) {
            scimarkLargeGeomMean = Math.pow(scimarkLargeProduct, 1 / (double)scimarkLargeCount);
            subGroupScores.put(Utils.SCIMARK_LARGE_SBNAME, scimarkLargeGeomMean);
        }
        dbgPrint("scimark large geom mean: " + scimarkLargeGeomMean + " " + scimarkLargeCount + " " + scimarkLargeProduct);
        product *= scimarkLargeGeomMean;
        double scimarkSmallGeomMean = 1;
        if (scimarkSmallCount > 0) {
            scimarkSmallGeomMean = Math.pow(scimarkSmallProduct, 1 / (double)scimarkSmallCount);
            subGroupScores.put(Utils.SCIMARK_SMALL_SBNAME, scimarkSmallGeomMean);
        }
        dbgPrint("scimark small geom mean: " + scimarkSmallGeomMean + " " + scimarkSmallCount + " " + scimarkSmallProduct);
        product *= scimarkSmallGeomMean;
        double startupGeomMean = 1;
        if (startupCount > 0) {
            startupGeomMean = Math.pow(startupProduct, 1 / (double)startupCount);
            subGroupScores.put(Utils.STARTUP_SBNAME, startupGeomMean);
        }
        dbgPrint("startup's geom mean: " + startupGeomMean + " " + startupCount + " " + startupProduct);
        product *= startupGeomMean;
        double cryptoGeomMean = 1;
        if (cryptoCount > 0) {
            cryptoGeomMean = Math.pow(cryptoProduct, 1 / (double)cryptoCount);
            subGroupScores.put(Utils.CRYPTO_SBNAME, cryptoGeomMean);
        }
        dbgPrint("crypto's geom mean: " + cryptoGeomMean + " " + cryptoCount + " " + cryptoProduct);
        product *= cryptoGeomMean;
        double compilerGeomMean = 1;
        if (compilerCount > 0) {
            compilerGeomMean = Math.pow(compilerProduct, 1 / (double)compilerCount);
            subGroupScores.put(Utils.COMPILER_SBNAME, compilerGeomMean);
        }
        dbgPrint("compiler's geom mean: " + compilerGeomMean + " " + compilerCount + " " + compilerProduct);
        product *= compilerGeomMean;
        double xmlGeomMean = 1;
        if (xmlCount > 0) {
            xmlGeomMean = Math.pow(xmlProduct, 1 / (double)xmlCount);
            subGroupScores.put(Utils.XML_SBNAME, xmlGeomMean);
        }
        dbgPrint("product: " + product);
        dbgPrint("xml's geom mean: " + xmlGeomMean + " " + xmlCount + " " + xmlProduct);
        product *= xmlGeomMean;
        
        int totalNumber = scimarkLargeCount > 0 ? validBenchmarksNum - scimarkLargeCount + 1
                : validBenchmarksNum;
        totalNumber = scimarkSmallCount > 0 ? totalNumber - scimarkSmallCount + 1 : totalNumber;
        
        totalNumber = startupCount > 0 ? totalNumber - startupCount + 1 : totalNumber;
        
        totalNumber = cryptoCount > 0 ? totalNumber - cryptoCount + 1 : totalNumber;
        
        totalNumber = compilerCount > 0 ? totalNumber - compilerCount + 1 : totalNumber;
        
        totalNumber = xmlCount > 0 ? totalNumber - xmlCount + 1 : totalNumber;
        dbgPrint("totalNumber: " + totalNumber);
        double tempCompositeScore = (totalNumber == 0) ? 1
                : Math.pow(product, 1/(double)totalNumber);
        dbgPrint("composite score: " + tempCompositeScore);
        return tempCompositeScore;
    }
    
    private void handleBenchmarksResults(Node node) {
        Node current = node.getFirstChild();
        do {
            if (isNotTextNode(current)) {
                handleBenchmarkResult(current);
            }
        } while ((current = current.getNextSibling()) != null);
        validBenchmarksNum = computeValidBenchmarksNumber();
        
        compositeScore = computeCompositeScore();
        
        if (!(specNonCompliance == null || specNonCompliance.equals("no"))) {
            compositeScore = 0;
        }
    }
    
    private String getValue(NamedNodeMap nodeMap, String name) {
        Node node = nodeMap.getNamedItem(name);
        return node == null ? null : node.getNodeValue();
    }
    
    private Node getChildByName(String name) {
        return root.getElementsByTagName(name).item(0);
    }  
    
    private void collectBmConfiguration(BenchmarkRecord record,
            NamedNodeMap attrs) {
        for (int i = 0; i < Utils.BM_CONFIGURATION_ENAMES.length; i ++) {
            record.configuration[i] = getValue(attrs,
                    Utils.BM_CONFIGURATION_ENAMES[i]);
        }
        
    }
    
    private void handleBenchmarkResult(Node node) {
        NamedNodeMap attrs = node.getAttributes();        
        String bmName = getValue(attrs, Utils.NAME_ENAME);
        String numberBmThreads = getValue(attrs, Utils.NUM_BM_THREADS_ENAME);
        
        BenchmarkRecord record = new BenchmarkRecord(bmName,
                Integer.parseInt(numberBmThreads));
        
        collectBmConfiguration(record, attrs);
        BenchmarkChart chart = new BenchmarkChart(bmName);
        dbgPrint(bmName + numberBmThreads);
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node current = children.item(i);
            if (isNotTextNode(current)) {
                dbgPrint("\t?:" + current.getNodeName());
                record.startHandling(current.getNodeName());
                NodeList children2 = current.getChildNodes();
                for (int j = 0; j < children2.getLength(); j++) {
                    Node current2 = children2.item(j);
                    if (isNotTextNode(current2)) {
                        handleIterationResult(record, chart, current2);
                    }
                }
            }
        }
        benchmarksRecords.add(record);
        Utils.createBmResultGraph(record);
        chart.buildJPEG();
    }
    
    private void generateHat(Writer w, String runStatus, String score, String workloadName) {        
        
        w.putHat(runStatus,
                 score,
                 workloadName,
                 "",
                 getProperty(Constants.REPORTER_HW_VENDOR),
                 getProperty(Constants.REPORTER_JVM_VENDOR),
                 getProperty(Constants.REPORTER_HW_MODEL),
                 getProperty(Constants.REPORTER_JVM_NAME),
                 getProperty(Constants.REPORTER_RUN_SUBMITTER),
                 getProperty(Constants.REPORTER_RUN_DATE),
                 getProperty(Constants.REPORTER_JVM_VERSION));
    }
    
    private void generateSummaryTable(Writer w) {
        w.putSummaryTable(benchmarksRecords, compositeScore, metric, subGroupScores);
    }
    
    String [] runInfoTableFields = {
    	    Constants.REPORTER_RUN_SUBMITTER,
    	    Constants.REPORTER_RUN_SUBMITTER_URL,
    	    Constants.REPORTER_RUN_LICENSE,
    	    Constants.REPORTER_RUN_TESTER,
    	    Constants.REPORTER_RUN_LOCATION,
    	    Constants.REPORTER_RUN_DATE
    };

    String [] jvmInfoTableFields = {
    	    Constants.REPORTER_JVM_VENDOR,
    	    Constants.REPORTER_JVM_VENDOR_URL,
    	    Constants.REPORTER_JVM_NAME,
    	    Constants.REPORTER_JVM_VERSION,
    	    Constants.REPORTER_JVM_AVAILABLE_DATE,
    	    Constants.REPORTER_JVM_JAVA_SPECIFICATION,
    	    Constants.REPORTER_JVM_ADDRESS_BITS,
    	    Constants.REPORTER_JVM_COMMAND_LINE_INITIAL_HEAP_SIZE,
    	    Constants.REPORTER_JVM_COMMAND_LINE_MAX_HEAP_SIZE,
    	    Constants.REPORTER_JVM_COMMAND_LINE,
            Constants.REPORTER_JVM_STARTUP_COMMAND_LINE,
            Constants.REPORTER_JVM_STARTUP_LAUNCHER,
    	    Constants.REPORTER_JVM_OTHER_TUNING,
    	    Constants.REPORTER_JVM_APP_CLASS_PATH,
    	    Constants.REPORTER_JVM_BOOT_CLASS_PATH
    };

    String [] swInfoTableFields = {
    	    Constants.REPORTER_OS_NAME,
    	    Constants.REPORTER_OS_AVAILABLE_DATE,
    	    Constants.REPORTER_OS_ADDRESS_BITS,
    	    Constants.REPORTER_OS_TUNING,
    	    Constants.REPORTER_SW_FILESYSTEM,
    	    Constants.REPORTER_SW_OTHER_NAME,
    	    Constants.REPORTER_SW_OTHER_TUNING,
    	    Constants.REPORTER_SW_OTHER_AVAILABLE
    };

    String [] hwInfoTableFields = {
    	    Constants.REPORTER_HW_VENDOR,
    	    Constants.REPORTER_HW_VENDOR_URL,
    	    Constants.REPORTER_HW_MODEL,
    	    Constants.REPORTER_HW_AVAILABLE,
    	    Constants.REPORTER_HW_CPU_VENDOR,
    	    Constants.REPORTER_HW_CPU_VENDOR_URL,
    	    Constants.REPORTER_HW_CPU_NAME,
    	    Constants.REPORTER_HW_CPU_SPEED,
    	    Constants.REPORTER_HW_LOGICAL_CPUS,
    	    Constants.REPORTER_HW_NUMBER_OF_CHIPS,
    	    Constants.REPORTER_HW_NUMBER_OF_CORES,
    	    Constants.REPORTER_HW_NUMBER_OF_CORES_PER_CHIP,
    	    Constants.REPORTER_HW_THREADS_PER_CORE,
    	    Constants.REPORTER_HW_THREADING_ENABLED,
    	    Constants.REPORTER_HW_ADDRESS_BITS,
    	    Constants.REPORTER_HW_CPU_CACHE_L1,
    	    Constants.REPORTER_HW_CPU_CACHE_L2,
    	    Constants.REPORTER_HW_CPU_CACHE_OTHER,
    	    Constants.REPORTER_HW_MEMORY_SIZE,
    	    Constants.REPORTER_HW_MEMORY_DETAILS,
    	    Constants.REPORTER_HW_DETAILS_OTHER
    };





    private void generateConfigTable(Writer w) {
        w.startTable("", false);
        w.startRecordAndData();
        //generateNodeTable(getChildByName(Utils.RUN_INFO), w);
        generateInfoTable(getChildByName(Utils.RUN_INFO), w, runInfoTableFields);
        w.endAndStartData();
        //generateNodeTable(getChildByName(Utils.SW_INFO), w);
        generateInfoTable(getChildByName(Utils.SW_INFO), w, swInfoTableFields);
        w.endAndStartRecordAndData();
        //generateNodeTable(getChildByName(Utils.JVM_INFO), w);
        generateInfoTable(getChildByName(Utils.JVM_INFO), w, jvmInfoTableFields);
        w.endAndStartData();
        //generateNodeTable(getChildByName(Utils.HW_INFO), w);
        generateInfoTable(getChildByName(Utils.HW_INFO), w, hwInfoTableFields);
        // w.endAndStartRecordAndData();
        w.endAndStartRecordAndData();
        generateViolationsTable();
        insertSuiteConfiguration();
        w.endRecordAndData();
        w.endTable();
    }   
    
    private ArrayList<String> findProperties(String ename, String subelementName) {
        NodeList currentNode = root.getElementsByTagName(ename);
        if (currentNode == null) {
            return null;
        }
        Node violation = currentNode.item(0);
        if (violation == null) {
            return null;
        }
        NodeList children = violation.getChildNodes();        
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < children.getLength(); i++) {
            Node current = children.item(i);            
            if (subelementName.equals(current.getNodeName())) {
                result.add(current.getTextContent());
            }
        }        
        return result;
    }
    
    private void generateViolationsTable() {
        for (int i = 0; i < writer.size(); i++) {
            writer.get(i).startTable(Utils.VIOLATIONS_ENAME, true);
            if (violations != null && violations.size() != 0) {
                writer.get(i).insertRecords(violations);
            }
            writer.get(i).endTable();
        }
    }
    
    private void generateDetailsTable(Writer w) {
        w.startDetailsTable();
        for (int i = 0; i < benchmarksRecords.size(); i++) {
            w.handleBenchmarkRecord((BenchmarkRecord) benchmarksRecords.get(i));
        }
        w.endTable();
    }
    
    public void generateCopyRightStatement(Writer w) {
        if (specLogo != null) {
            GregorianCalendar g = new GregorianCalendar();
            int year = g.get(Calendar.YEAR);
            ArrayList<String> al = new ArrayList<String>(1);
            if (year > 2008) {
                al.add("Copyright � 2008-" + year + " SPEC. All rights reserved");
            } else {
                al.add("Copyright � 2008 SPEC. All rights reserved");
            }
            w.startTable("", false, false, true);
            w.insertRecords(al);
            w.endTable();
        }
    }
        
    public void generateReport() {
    	violations = findProperties(Utils.VIOLATIONS_ENAME, Utils.VIOLATION_ENAME);    	
        configs = findProperties(Utils.CONFIGS_ENAME, Utils.CONFIG_ENAME);
        String workloadName = getProperty(Utils.WORKLOAD_ENAME);
        String workloadMode = workloadName;
        String score = Utils.df.format(compositeScore);
        String runStatus = Utils.getRunStatus(isValidRun(), isCompliantRun());
        metric = Constants.WORKLOAD_METRIC;
        if (Constants.WORKLOAD_NAME_LAGOM.equals(workloadMode)) {
            ; // Lagom workload get ops/m
        } else if (isValidRun() && isCompliantRun()) {
            metric = workloadName + " " + Constants.WORKLOAD_METRIC;
        } else {
            ; // Regular metric
        }
        
        if (!(specNonCompliance == null || specNonCompliance.equals("no"))) {
            System.out.println("specNOncom: '" + specNonCompliance + "'");
            if (specNonCompliance.equalsIgnoreCase("na")) {
                runStatus = "Not Available";
            } else if (specNonCompliance.equalsIgnoreCase("nc")) {
                runStatus = "Not Compliant";
            } else if (specNonCompliance.equalsIgnoreCase("cd")) {
                runStatus = "Code Defect";
            } 
            score = specNonCompliance;
            metric = "";
        }

        
        createSummary(runStatus, score, metric, workloadName, workloadMode);                
        createSubFile(runStatus, score, metric, workloadName, workloadMode);
        
        for (int i = 0; i < writer.size(); i++) {        	
            writer.get(i).startReport();            
            generateHat(writer.get(i), runStatus, score + " " + metric, workloadName);
            if (!(specNonCompliance == null || specNonCompliance.equals("no"))) {
                writer.get(i).startTable("", false);
                writer.get(i).startRecordAndData();
                writer.get(i).startTable("SPEC non-compliance", true);
                ArrayList<String> ncs = new ArrayList<String>(2);
                if (specNonComplianceReason != null) {
                    ncs.add(specNonComplianceReason);
                }
                if (specNonComplianceRemedy != null) {
                    ncs.add(specNonComplianceRemedy);
                }
                writer.get(i).insertRecords(ncs);
                writer.get(i).endTable();
                writer.get(i).endRecordAndData();
                writer.get(i).endTable();
            } else {
                Utils.generateMainChart(benchmarksRecords, compositeScore,
                        validBenchmarksNum, subGroupScores);
                generateSummaryTable(writer.get(i));
            }
                    
            generateConfigTable(writer.get(i));
            generateDetailsTable(writer.get(i));
            generateCopyRightStatement(writer.get(i));
            writer.get(i).endReport();
            writer.get(i).closeStream();
        }
    }
        
    private void generateInfoTable(Node base, Writer w, String [] fields) {
    	
    	// Put all info in list l1
    	LinkedList<Pair<String, String>> l1 = new LinkedList<Pair<String, String>>();
    	for (Node current = base.getFirstChild();
    		current != null;
    		current = current.getNextSibling()) {
			Pair<String, String> p = new Pair<String, String>(current.getNodeName(), current.getTextContent());
    		if (isNotTextNode(current)) {
    			l1.add(p);
    		} 
    	}
    	
    	// Sort the info in requested order into list l2
    	LinkedList<Pair<String, String>> l2 = new LinkedList<Pair<String, String>>();
    	for (int i = 0; i < fields.length; i++) {
    		for (Iterator<Pair<String, String>> iter = l1.iterator(); iter.hasNext(); ) {
    			Pair<String, String> p = iter.next();
    			if (p.fst != null && p.fst.equals(fields[i])) {
        			l2.add(p);
        			iter.remove();
        			break;
    			}
    		}
    	}
    	
    	// Add any (nonxpected) additional info
    	l2.addAll(l1);
    	
    	// Write info
        w.startTable(base.getNodeName(), true);
        for (Iterator<Pair<String, String>> iter = l2.iterator(); iter.hasNext(); ) {
			Pair<String, String> p = iter.next();
			w.insertRecord(Utils.getDescription(p.fst), insertBRTag(TestResult.correctContent(p.snd, false), w));
        }
        w.endTable();
        
    }
    
    private String insertBRTag(String text, Writer w) {
        if (text.length() < 50) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < text.length(); i ++) {
            char ch = text.charAt(i);
            sb.append(ch);
            count ++;
            if ((count > 40 && (ch == ';' || ch == ':'))) {
                if (w.getType().equals(Utils.HTML_WRITER_TYPE)) {
                    sb.append("<BR>");
                }
                count = 0;
            }
        }
        return sb.toString();
    }
    
    private void dbgPrint(String str) {
        if (debug) {
            System.out.println(str);
        }
    }
    
    private void handleIterationResult(BenchmarkRecord record,
            BenchmarkChart chart, Node node) {
        dbgPrint("\t\t:" + node.getNodeName());
        NamedNodeMap attrs = node.getAttributes();
        
        String startTime = getValue(attrs, Utils.START_TIME_ENAME);
        String endTime = getValue(attrs, Utils.END_TIME_ENAME);
        
        // Null check for startTime, endTime, and Operation added
        // to handle invalid startup benchmark result.
        
        if(startTime == null)startTime = "0";
        if(endTime == null)endTime = "0";
        chart.setStartTime(Long.parseLong(startTime));
        
        String operations = getValue(attrs, Utils.OPERATIONS_ENAME);
        if(operations == null) operations = "0";
        
        BenchmarkRecord.IterationRecord iterRecord
                = record.addIterationRecord(getValue(attrs, Utils.ITERATION_ENAME),
                getValue(attrs, Utils.EXPECTED_DURATION_ENAME),
                startTime, endTime, operations);
        if (checkName(Utils.ITERATIONS_ENAME, node.getParentNode())) {
            chart.addMarker(Long.parseLong(startTime),
                    Utils.df.format(iterRecord.operations) + " ops");
        }
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node currrent = children.item(i);
            if (checkName(Utils.LOOPS_ENAME, currrent)) {
                handleLoopsNode(iterRecord, chart, currrent);
            } else if (checkName(Utils.ANALYZERS_ENAME, currrent)) {
                handleAnalyzersNode(chart, currrent);
            }
        }
    }
    
    private boolean checkName(String name, Node node) {
        return name.equals(node.getNodeName());
    }
    
    private boolean isNotTextNode(Node node) {
        return node.getNodeType() != Node.TEXT_NODE;
    }
    
    private void handleLoopsNode(BenchmarkRecord.IterationRecord record,
            BenchmarkChart chart, Node node) {
        dbgPrint("\t\t\t:" + node.getNodeName());
        NodeList children = node.getChildNodes();
        dbgPrint("HandleLoopsNode");
        for (int i = 0; i < children.getLength(); i++) {
            Node current = children.item(i);
            if (checkName(Utils.LOOP_RESULT_ENAME, current)) {
                NamedNodeMap attrs = current.getAttributes();
                chart.addTimeInfo("bmThread" + getValue(attrs, Utils.BM_THREAD_ID_ENAME),
                        Long.parseLong(getValue(attrs, Utils.START_TIME_ENAME)),
                        Long.parseLong(getValue(attrs, Utils.END_TIME_ENAME)));
                                /*chart.addTimeInfo("bmThread" + getValue(attrs, Utils.BM_THREAD_ID_ENAME),
                                          Long.parseLong(getValue(attrs, Utils.START_TIME_ENAME)),
                                          Long.parseLong(getValue(attrs, Utils.END_TIME_ENAME)));*/
                checkErrors(record, current);
            }
        }
    }
    
    private void checkErrors(BenchmarkRecord.IterationRecord iterRecord, Node loopsNode) {
        NodeList children = loopsNode.getChildNodes();
        for (int i = 0; i < children.getLength(); i ++) {
            Node current = children.item(i);
            if (Utils.ERRORS_ENAME.equals(current.getNodeName())) {
                NodeList errors = current.getChildNodes();
                for (int j = 0; j < errors.getLength(); j ++) {
                    if (Utils.ERROR_ENAME.equals(errors.item(j).getNodeName())) {
                        iterRecord.addError(errors.item(j).getTextContent());
                    }
                }
            }
        }
    }
    
    private void createSummary(String runStatus, String compositeScore, String scorePrefix,
    		                   String workloadName, String workloadMode) {

        if (summaryFileName == null) {
            return;
        }
        
        System.out.println("Generate " + summaryFileName + " report.");
        
    	FileOutputStream fos = null;
    	try {
     	    fos = new FileOutputStream(summaryFileName);
     	    PrintStream ps = new PrintStream(fos);
     	    ps.println("Report:      " + workloadName + (workloadName.equals(workloadMode) ? "" : (", " + workloadMode)) + " summary");
     	    ps.println("Result:      " + scorePrefix + (scorePrefix.length() > 0 ? " " : "") + compositeScore + " (" + runStatus + ")");
     	    ps.println("HW Model:    " + getProperty(Constants.REPORTER_HW_VENDOR) + ", " + getProperty(Constants.REPORTER_HW_MODEL));
     	    ps.println("HW CPU:      " + getProperty(Constants.REPORTER_HW_CPU_VENDOR) + ", " + getProperty(Constants.REPORTER_HW_CPU_NAME));
     	    ps.println("OS:          " + getProperty(Constants.REPORTER_OS_NAME));
     	    ps.println("JVM:         " + getProperty(Constants.REPORTER_JVM_VENDOR) + ", " + getProperty(Constants.REPORTER_JVM_NAME) + ", " + getProperty(Constants.REPORTER_JVM_VERSION));
            ps.println("JVM tuning:  " + getProperty(Constants.REPORTER_JVM_COMMAND_LINE));
            ps.println("JVM startup: " + getProperty(Constants.REPORTER_JVM_STARTUP_COMMAND_LINE));
     	    ps.println("Tester:      " + getProperty(Constants.REPORTER_RUN_TESTER) + ", " + getProperty(Constants.REPORTER_RUN_SUBMITTER));
     	    ps.println("Run date:    " + getProperty(Constants.REPORTER_RUN_DATE));
    	} catch (IOException e) {
    		e.printStackTrace();
    	} finally {
    		try {
        	    fos.close();
    		} catch(IOException e) {}
    	}
    }
    
    private void printConstantProp(PrintStream ps, String prop) {
	    ps.println(prop + "=" + getProperty(prop));
    }

    private void createSubFile(String runStatus, String compositeScore, String metric, String workloadName,
            String workloadMode) {

        if (subFileName == null) {
            return;
        }
        
        System.out.println("Generate " + subFileName + " report.");
        
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(subFileName);
            PrintStream ps = new PrintStream(fos);
            ps.println(Utils.STATUS_PROPS + "=" + runStatus);
            ps.println(Utils.SCORE_PROPS + "=" + compositeScore);
            ps.println(Utils.METRIC_PROPS + "=" + metric);
            ps.println(Utils.WORKLOAD_NAME_PROPS + "=" + workloadName);
            ps.println(Utils.WORKLOAD_MODE_PROPS + "=" + workloadMode);

            printConstantProp(ps, Constants.REPORTER_RUN_DATE);
            printConstantProp(ps, Constants.REPORTER_RUN_TESTER);
            printConstantProp(ps, Constants.REPORTER_RUN_SUBMITTER);
            printConstantProp(ps, Constants.REPORTER_RUN_SUBMITTER_URL);
            printConstantProp(ps, Constants.REPORTER_RUN_LOCATION);
            printConstantProp(ps, Constants.REPORTER_RUN_LICENSE);
            printConstantProp(ps, Constants.REPORTER_JVM_NAME);
            printConstantProp(ps, Constants.REPORTER_JVM_VERSION);
            printConstantProp(ps, Constants.REPORTER_JVM_VENDOR);
            printConstantProp(ps, Constants.REPORTER_JVM_VENDOR_URL);
            printConstantProp(ps, Constants.REPORTER_JVM_JAVA_SPECIFICATION);
            printConstantProp(ps, Constants.REPORTER_JVM_ADDRESS_BITS);
            printConstantProp(ps, Constants.REPORTER_JVM_AVAILABLE_DATE);
            printConstantProp(ps, Constants.REPORTER_JVM_COMMAND_LINE);
            printConstantProp(ps, Constants.REPORTER_JVM_COMMAND_LINE_INITIAL_HEAP_SIZE);
            printConstantProp(ps, Constants.REPORTER_JVM_COMMAND_LINE_MAX_HEAP_SIZE);
            printConstantProp(ps, Constants.REPORTER_JVM_STARTUP_LAUNCHER);
            printConstantProp(ps, Constants.REPORTER_JVM_STARTUP_COMMAND_LINE);
            printConstantProp(ps, Constants.REPORTER_JVM_OTHER_TUNING);
            printConstantProp(ps, Constants.REPORTER_JVM_APP_CLASS_PATH);
            printConstantProp(ps, Constants.REPORTER_JVM_BOOT_CLASS_PATH);
            printConstantProp(ps, Constants.REPORTER_OS_NAME);
            printConstantProp(ps, Constants.REPORTER_OS_ADDRESS_BITS);
            printConstantProp(ps, Constants.REPORTER_OS_AVAILABLE_DATE);
            printConstantProp(ps, Constants.REPORTER_OS_TUNING);
            printConstantProp(ps, Constants.REPORTER_SW_FILESYSTEM);
            printConstantProp(ps, Constants.REPORTER_SW_OTHER_NAME);
            printConstantProp(ps, Constants.REPORTER_SW_OTHER_TUNING);
            printConstantProp(ps, Constants.REPORTER_SW_OTHER_AVAILABLE);
            printConstantProp(ps, Constants.REPORTER_HW_VENDOR);
            printConstantProp(ps, Constants.REPORTER_HW_VENDOR_URL);
            printConstantProp(ps, Constants.REPORTER_HW_MODEL);
            printConstantProp(ps, Constants.REPORTER_HW_AVAILABLE);
            printConstantProp(ps, Constants.REPORTER_HW_CPU_VENDOR);
            printConstantProp(ps, Constants.REPORTER_HW_CPU_VENDOR_URL);
            printConstantProp(ps, Constants.REPORTER_HW_CPU_NAME);
            printConstantProp(ps, Constants.REPORTER_HW_CPU_SPEED);
            printConstantProp(ps, Constants.REPORTER_HW_LOGICAL_CPUS);
            printConstantProp(ps, Constants.REPORTER_HW_NUMBER_OF_CHIPS);
            printConstantProp(ps, Constants.REPORTER_HW_NUMBER_OF_CORES);
            printConstantProp(ps, Constants.REPORTER_HW_NUMBER_OF_CORES_PER_CHIP);
            printConstantProp(ps, Constants.REPORTER_HW_THREADING_ENABLED);
            printConstantProp(ps, Constants.REPORTER_HW_THREADS_PER_CORE);
            printConstantProp(ps, Constants.REPORTER_HW_ADDRESS_BITS);
            printConstantProp(ps, Constants.REPORTER_HW_CPU_CACHE_L1);
            printConstantProp(ps, Constants.REPORTER_HW_CPU_CACHE_L2);
            printConstantProp(ps, Constants.REPORTER_HW_CPU_CACHE_OTHER);
            printConstantProp(ps, Constants.REPORTER_HW_MEMORY_SIZE);
            printConstantProp(ps, Constants.REPORTER_HW_MEMORY_DETAILS);
            printConstantProp(ps, Constants.REPORTER_HW_DETAILS_OTHER);
            
            ps.println("spec.jvm2008.result.noncompliant" + "=" + (specNonCompliance == null ? "no" : specNonCompliance));
            ps.println("spec.jvm2008.result.noncompliant.reason" + "=" + (specNonComplianceReason == null ? "" : specNonComplianceReason));
            ps.println("spec.jvm2008.result.noncompliant.remedy" + "=" + (specNonComplianceRemedy == null ? "" : specNonComplianceRemedy));

            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void handleAnalyzersNode(BenchmarkChart chart, Node node) {
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node current = children.item(i);
            if (checkName(Utils.TYINFO_ENAME, current)) {
                NamedNodeMap attrs = current.getAttributes();
                String name = getValue(attrs, Utils.NAME_ENAME);
                long time = Long.parseLong(getValue(attrs, Utils.TIME_ENAME));
                long value = Long.parseLong(getValue(attrs,Utils.VALUE_ENAME));
                String units = getValue(attrs, Utils.UNIT_ENAME);
                if (Utils.HEAP_SIZE_ENAME.equals(name)) {
                    chart.addTotalHeapInfo(time, value);
                } else if (Utils.FREE_MEMORY_ENAME.equals(name)) {
                    chart.addFreeHeapInfo(time, value);
                } else {
                    chart.addAnalyzerReport(name, units, time, value);
                }
            }
        }
    }
    
    private String getProperty(String prop) {
        return root.getElementsByTagName(prop).item(0).getTextContent();
    }
    
    private boolean isValidRun() {
        boolean result = true;
        for (int i = 0; i < benchmarksRecords.size(); i ++) {
            result = result && ((BenchmarkRecord)benchmarksRecords.get(i)).isValidRun();
        }
        return result;
    }
    
    private boolean isCompliantRun() {
        return violations == null || violations.size() == 0;
    }
    
    private void insertSuiteConfiguration() {
        for (int i = 0; i < writer.size(); i++) {
            writer.get(i).startTable("suite configuration", true);
            writer.get(i).insertRecords(configs);
            writer.get(i).endTable();
        }
    }
    
    private int computeValidBenchmarksNumber() {
        int count = 0;
        for (int i = 0; i < benchmarksRecords.size(); i ++) {
            BenchmarkRecord record = (BenchmarkRecord)benchmarksRecords.get(i);
            if (record.isValidRun() && !"check".equals(record.name)) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) throws Exception {

        String rawFile = null;
        boolean doSub = true;
        boolean doHtml = true;
        boolean doSummary = true;
        boolean doTxt = true;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-html")) {
                try {
                    doHtml = Boolean.parseBoolean(args[++i]);
                } catch (Exception e){
                    System.out.println("Error: Argument " + args[i-1] + " expects a boolean value.");
                }
            } else if (args[i].equalsIgnoreCase("-txt")) {
                try {
                    doTxt = Boolean.parseBoolean(args[++i]);
                } catch (Exception e){
                    System.out.println("Error: Argument " + args[i-1] + " expects a boolean value.");
                }
            } else if (args[i].equalsIgnoreCase("-summary")) {
                try {
                    doSummary = Boolean.parseBoolean(args[++i]);
                } catch (Exception e){
                    System.out.println("Error: Argument " + args[i-1] + " expects a boolean value.");
                }
            } else if (args[i].equalsIgnoreCase("-sub")) {
                try {
                    doSub = Boolean.parseBoolean(args[++i]);
                } catch (Exception e){
                    System.out.println("Error: Argument " + args[i-1] + " expects a boolean value.");
                }
            } else {
                if ((new File(args[i]).exists())) {
                    rawFile = args[i];
                } else {
                    System.out.println("Error: Cannot parse argument " + args[i] + ". Not a file.");
                }
            }
        }
        
        if (rawFile == null) {
            System.out.println("java spec.reporter.Reporter <raw file>");
            System.out.println("java spec.reporter.Reporter <raw file> [-html <bool>] [-txt <bool>] [-summary <bool>] [-sub <bool>]");
            return;
        }

        if (!(new File(rawFile).exists())) {
            System.out.println("Cannot find file '" + rawFile + "'");
            return;
        }
        
        ReportGenerator reporter = new ReportGenerator(rawFile, doHtml, doTxt, doSub, doSummary);
        reporter.generateReport();
    }
}