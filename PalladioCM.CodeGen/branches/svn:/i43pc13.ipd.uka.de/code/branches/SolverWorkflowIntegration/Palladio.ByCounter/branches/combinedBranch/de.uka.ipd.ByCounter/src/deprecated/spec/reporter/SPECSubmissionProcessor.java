package deprecated.spec.reporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;

import deprecated.spec.harness.Constants;


public class SPECSubmissionProcessor {
    
    private static String inFileName = null;
    private static String reportRootDir = null;
    private static String reportRootName = null;
    private static String resultDirBase = null;
    private static String resultDirPeak = null;
    private static String mergedSubFileName = null;
    private static String baseRawFileName = null;
    private static String peakRawFileName = null;

    private static String specNonCompliance = null;
    private static String specNonComplianceReason = null;
    private static String specNonComplianceRemedy = null;

    public static void main(String[] args) throws Exception {
        
        if (args.length != 1) {
            System.out.println("Usage: spec.reporter.BasePeakReporter <merged raw file> ");
        }
        
        // Split incoming raw file
        splitMergedRawFile(args);

        
        // Update report generator for SPEC
        ReportGenerator.specLogo = System.getProperty("spec.jvm2008.result.logo", "docs/spec-sm.gif");
        ReportGenerator.specNonCompliance = System.getProperty("spec.jvm2008.result.noncompliant", specNonCompliance);
        ReportGenerator.specNonComplianceReason = System.getProperty("spec.jvm2008.result.noncompliant.reason", specNonComplianceReason);
        ReportGenerator.specNonComplianceRemedy = System.getProperty("spec.jvm2008.result.noncompliant.remedy", specNonComplianceRemedy);
        
        // generate base report
        if (baseRawFileName != null) {
            String [] rArgs = {baseRawFileName};
            ReportGenerator.main(rArgs);
        }
        
        // generate peak report
        if (peakRawFileName != null) {
            String [] rArgs = {peakRawFileName};
            ReportGenerator.main(rArgs);
        }

        // merge sub files
        createMergedSubFile();
        
        // create summary
        Properties p = new Properties();
        p.load(new FileInputStream(mergedSubFileName));
        createResultFile(p);

    }

    private static void createMergedSubFile() throws IOException {
        
        File baseSubFile = new File(reportRootDir + "/" + reportRootName + "_base/SPECjvm2008_base.sub");
        if (!baseSubFile.exists()) {
            baseSubFile = null;
        }

        File peakSubFile = new File(reportRootDir + "/" + reportRootName + "_peak/SPECjvm2008_peak.sub");
        if (!peakSubFile.exists()) {
            peakSubFile = null;
        }

        mergedSubFileName = reportRootDir + "/" + reportRootName + ".sub";
        PrintStream resultFileStream = new PrintStream(new FileOutputStream(mergedSubFileName));
        
        if (baseSubFile != null) {
            BufferedReader rawFileStream = new BufferedReader(new InputStreamReader(new FileInputStream(baseSubFile)));
            String line = rawFileStream.readLine();
            while (line != null) {
                resultFileStream.println("base." + line);
                line = rawFileStream.readLine();
            }
            rawFileStream.close();
        }

        if (peakSubFile != null) {
            BufferedReader rawFileStream = new BufferedReader(new InputStreamReader(new FileInputStream(peakSubFile)));
            String line = rawFileStream.readLine();
            while (line != null) {
                resultFileStream.println("peak." + line);
                line = rawFileStream.readLine();
            }
            rawFileStream.close();
        }

        resultFileStream.println("spec.jvm2008.result.noncompliant" + "=" + (specNonCompliance == null ? "no" : specNonCompliance));
        resultFileStream.println("spec.jvm2008.result.noncompliant.reason" + "=" + (specNonComplianceReason == null ? "" : specNonComplianceReason));
        resultFileStream.println("spec.jvm2008.result.noncompliant.remedy" + "=" + (specNonComplianceRemedy == null ? "" : specNonComplianceRemedy));

        resultFileStream.close();
    }

    private static String getResultFile(String workLoadLine, String resultDir) {
        String resultFile = null;
        if (workLoadLine != null && workLoadLine.indexOf("Base") != -1) {
            resultDirBase = reportRootDir + "/" + reportRootName + "_base";
            (new File(resultDirBase)).mkdir();
            resultFile = resultDirBase + "/" + "SPECjvm2008_base.raw";
            baseRawFileName = resultFile;
        } else if (workLoadLine != null && workLoadLine.indexOf("Peak") != -1) {
            resultDirPeak = reportRootDir + "/" + reportRootName + "_peak";
            (new File(resultDirPeak)).mkdir();
            resultFile = resultDirPeak + "/" + "SPECjvm2008_peak.raw";
            peakRawFileName = resultFile;
        } else {
            throw new UnsupportedOperationException("Unknown workload: " + workLoadLine);
        }
        return resultFile;
    }
    
    public static void splitMergedRawFile(String [] args) throws IOException {

        // Check content, base and/or peak
        File inFile = new File(args[0]);
        inFileName = args[0];
        reportRootDir = new File(inFileName).getParent();
        reportRootName = inFileName.substring(reportRootDir.length(), inFileName.indexOf(".raw"));
        if (reportRootName.charAt(0) == '/' || reportRootName.charAt(0) == '\\' ) {
            reportRootName = reportRootName.substring(1);
        }
        BufferedReader rawFileStream = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
        String line = rawFileStream.readLine();
        String headerLine = line;
        String [] workLoadLines = new String[2];
        int i = 0;

        String stag1 = "<spec.jvm2008.result.noncompliant>";
        String etag1 = "</spec.jvm2008.result.noncompliant>";
        String stag2 = "<spec.jvm2008.result.noncompliant.reason>";
        String etag2 = "</spec.jvm2008.result.noncompliant.reason>";
        String stag3 = "<spec.jvm2008.result.noncompliant.remedy>";
        String etag3 = "</spec.jvm2008.result.noncompliant.remedy>";
        
        while (line != null) {
            
            // Example: <workload>SPECjvm2008 Peak</workload>
            if (line.indexOf("<workload>") != -1) {
                if (i > 1) {
                    System.out.println("Error: Finds more than 2 workloads in raw file.");
                    System.exit(-1);
                }
                workLoadLines[i++] = line;
            }
            
            // Example <spec.jvm2008.result.noncompliant>no</spec.jvm2008.result.noncompliant>
            if (line.indexOf(stag1) != -1) {
                specNonCompliance = line.substring(line.indexOf(stag1) + stag1.length(), line.indexOf(etag1));
                if (specNonCompliance == "no") {
                    specNonCompliance = null;
                }
            }

            // Example <spec.jvm2008.result.noncompliant.reason></spec.jvm2008.result.noncompliant.reason>
            if (line.indexOf(stag2) != -1) {
                specNonComplianceReason = line.substring(line.indexOf(stag2) + stag2.length(), line.indexOf(etag2));
            }

            // Example <spec.jvm2008.result.noncompliant.remedy></spec.jvm2008.result.noncompliant.remedy>
            if (line.indexOf(stag3) != -1) {
                specNonComplianceRemedy = line.substring(line.indexOf(stag3) + stag3.length(), line.indexOf(etag3));
            }

            line = rawFileStream.readLine();
        }
        rawFileStream.close();

        // Open file to produce first split raw file
        String resultDir = inFile.getParent();
        String resultFileName = getResultFile(workLoadLines[0], resultDir);
        System.out.println("Creating file " + resultFileName);
        File resultFile = new File(resultFileName);
        PrintStream resultFileStream = new PrintStream(new FileOutputStream(resultFile));

        // Start second pass in infile, this time to echo to result files
        inFile = new File(args[0]);
        rawFileStream = new BufferedReader(new InputStreamReader(new FileInputStream(inFile)));
        line = rawFileStream.readLine();

        // Find first result
        while (line != null && line.indexOf("<specjvm-result>") == -1) {
            line = rawFileStream.readLine();
        }
        
        // Print first result
        resultFileStream.println(headerLine);
        while (line != null && line.indexOf("</specjvm-result>") == -1) {
            resultFileStream.println(line);
            line = rawFileStream.readLine();
        }
        resultFileStream.println(line);
        resultFileStream.close();
        
        // Take care of second result (if there is any)
        if (workLoadLines[1] != null) {
            
            // Open file to produce first split raw file
            resultFileName = getResultFile(workLoadLines[1], resultDir);
            resultFile = new File(resultFileName);
            System.out.println("Creating file " + resultFileName);
            resultFile.createNewFile();
            resultFileStream = new PrintStream(new FileOutputStream(resultFile));

            // Find second result
            while (line != null && line.indexOf("<specjvm-result>") == -1) {
                line = rawFileStream.readLine();
            }

            // Print second result
            resultFileStream.println(headerLine);
            while (line != null && line.indexOf("</specjvm-result>") == -1) {
                resultFileStream.println(line);
                line = rawFileStream.readLine();
            }
            resultFileStream.println(line);
            resultFileStream.close();
        }
        rawFileStream.close();
    }

    private static String getAndCheckProp(String prop, Properties p, LinkedList<String> errors) {
        String base = p.getProperty("base." + prop);
        String peak = p.getProperty("peak." + prop);
        
        if (base == null) {
            errors.add("Base missing value for " + prop);
        }
        
        if (base != null && peak != null && !base.equals(peak)) {
            errors.add("Base and peak has different values for " + prop + "  base=" + base + "  peak=" + peak);
        }
        
        return base;
    }

    public static void createResultFile(Properties p) throws Exception {

        LinkedList<String> errors = new LinkedList<String>();

        String testerName = getAndCheckProp(Constants.REPORTER_RUN_SUBMITTER, p, errors);
        String testerUrl = getAndCheckProp(Constants.REPORTER_RUN_SUBMITTER_URL, p, errors);
        String jvmCompanyName = getAndCheckProp(Constants.REPORTER_JVM_VENDOR, p, errors);
        String jvmCompanyUrl = getAndCheckProp(Constants.REPORTER_JVM_VENDOR_URL, p, errors);
        String jvmName = getAndCheckProp(Constants.REPORTER_JVM_NAME, p, errors);
        String jvmVersion = getAndCheckProp(Constants.REPORTER_JVM_VERSION, p, errors);
        String hwCompanyName = getAndCheckProp(Constants.REPORTER_HW_VENDOR, p, errors);
        String hwCompanyUrl = getAndCheckProp(Constants.REPORTER_HW_VENDOR, p, errors);
        String hwSystemName = getAndCheckProp(Constants.REPORTER_HW_MODEL, p, errors);
        String noHWThreads = getAndCheckProp(Constants.REPORTER_HW_LOGICAL_CPUS, p, errors);
        String noCores = getAndCheckProp(Constants.REPORTER_HW_NUMBER_OF_CORES, p, errors);
        String noChips = getAndCheckProp(Constants.REPORTER_HW_NUMBER_OF_CHIPS, p, errors);
        String baseOps = p.getProperty("base." + "spec.jvm2008.report.result.score");
        String peakOps = p.getProperty("peak." + "spec.jvm2008.report.result.score");
        String baseMetric = p.getProperty("base." + "spec.jvm2008.report.result.metric");
        String peakMetric = p.getProperty("peak." + "spec.jvm2008.report.result.metric");
        
        String summaryLink = reportRootDir + "/" + reportRootName + ".html";
        String fdrLinkBaseHtml = (baseOps == null ? null : "./" + reportRootName + "_base/SPECjvm2008_base.html");
        String fdrLinkBaseTxt = (baseOps == null ? null : "./" + reportRootName + "_base/SPECjvm2008_base.txt");
        String fdrLinkPeakHtml = (peakOps == null ? null : "./" + reportRootName + "_peak/SPECjvm2008_peak.html");
        String fdrLinkPeakTxt = (peakOps == null ? null : "./" + reportRootName + "_peak/SPECjvm2008_peak.txt");


        String summaryHtmlName = reportRootDir + "/" + reportRootName + ".html";
        System.out.println("Creating report " + summaryHtmlName);
        PrintStream summaryHtmlStream = new PrintStream(new FileOutputStream(summaryHtmlName));
        summaryHtmlStream.println("<HTML>");
        summaryHtmlStream.println("  <HEAD>");
        summaryHtmlStream.println("    <META NAME=\"GENERATOR\" CONTENT=\"SPEC Java Reporter\">");
        summaryHtmlStream.println("    <TITLE>SPECjvm2008</TITLE>");
        summaryHtmlStream.println("  </HEAD>");
        summaryHtmlStream.println("  <BODY >");
        summaryHtmlStream.println("    <TABLE WIDTH=100% >");
        summaryHtmlStream.println("      <TR> ");
        summaryHtmlStream.println("        <TD ALIGN=LEFT ROWSPAN=2> <FONT SIZE=+3 COLOR=BLUE>SPECjvm2008 SPEC Summary Report</FONT></TD>");
        summaryHtmlStream.println("      </TR>");
        summaryHtmlStream.println("    </TABLE>");

        summaryHtmlStream.println("    <TABLE WIDTH=100% >");
        summaryHtmlStream.println("        <THEAD>");
        summaryHtmlStream.println("           <COL width = 30%>");
        summaryHtmlStream.println("           <COL width = 70%>");
        summaryHtmlStream.println("        </THEAD>");
        summaryHtmlStream.println("        <TBODY>");
        summaryHtmlStream.println("          <TR>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>Tester</TD>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT><A HREF=\"" + testerUrl + "\">" + testerName + "</A></TD>");
        summaryHtmlStream.println("          </TR>");
        summaryHtmlStream.println("          <TR>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>JVM Vendor</TD>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT><A HREF=\"" + jvmCompanyUrl + "\">" + jvmCompanyName + "</A></TD>");
        summaryHtmlStream.println("          </TR>");
        summaryHtmlStream.println("          <TR>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>JVM</TD>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>" + jvmName + " " + jvmVersion + "</TD>");
        summaryHtmlStream.println("          </TR>");
        summaryHtmlStream.println("          <TR>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>Hardware Company</TD>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT><A HREF=\"" + hwCompanyUrl + "\">" + hwCompanyName + "</A></TD>");
        summaryHtmlStream.println("          </TR>");
        summaryHtmlStream.println("          <TR>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>Hardware Model</TD>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>" + hwSystemName + "</TD>");
        summaryHtmlStream.println("          </TR>");
        summaryHtmlStream.println("          <TR>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>Number of chips</TD>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>" + noChips + "</TD>");
        summaryHtmlStream.println("          </TR>");
        summaryHtmlStream.println("          <TR>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>Number of cores</TD>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>" + noCores + "</TD>");
        summaryHtmlStream.println("          </TR>");
        summaryHtmlStream.println("          <TR>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>Number of logical CPUs</TD>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>" + noHWThreads + "</TD>");
        summaryHtmlStream.println("          </TR>");
        summaryHtmlStream.println("          <TR>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>Base result</TD>");
        if (baseOps != null) {
            summaryHtmlStream.println("            <TD ALIGN=LEFT>" + baseOps + " " + baseMetric + "</TD>");
        } else {
            summaryHtmlStream.println("            <TD ALIGN=LEFT>&nbsp;</TD>");
        }
        summaryHtmlStream.println("          </TR>");
        summaryHtmlStream.println("          <TR>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>Peak result</TD>");
        if (peakOps != null) {
            summaryHtmlStream.println("            <TD ALIGN=LEFT>" + peakOps + " " + peakMetric + "</TD>");
        } else {
            summaryHtmlStream.println("            <TD ALIGN=LEFT>&nbsp;</TD>");
        }
        summaryHtmlStream.println("          </TR>");
        summaryHtmlStream.println("          <TR>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>Base report</TD>");
        if (fdrLinkBaseHtml != null) {
            summaryHtmlStream.println("            <TD ALIGN=LEFT><A HREF=\"" + fdrLinkBaseHtml + "\">html</A>, <A HREF=\"" + fdrLinkBaseTxt + "\">txt</A></TD>");
        } else {
            summaryHtmlStream.println("            <TD ALIGN=LEFT>&nbsp;</TD>");
        }
        summaryHtmlStream.println("          </TR>");
        summaryHtmlStream.println("          <TR>");
        summaryHtmlStream.println("            <TD ALIGN=LEFT>Peak report</TD>");
        if (fdrLinkPeakHtml != null) {
            summaryHtmlStream.println("            <TD ALIGN=LEFT><A HREF=\"" + fdrLinkPeakHtml + "\">html</A>, <A HREF=\"" + fdrLinkPeakTxt + "\">txt</A></TD>");
        } else {
            summaryHtmlStream.println("            <TD ALIGN=LEFT>&nbsp;</TD>");
        }
        summaryHtmlStream.println("          </TR>");
        summaryHtmlStream.println("       </TBODY>");
        summaryHtmlStream.println("    </TABLE>");

        Iterator<String> i = errors.iterator(); 
        if (i.hasNext()) {
            summaryHtmlStream.println("    <BR><BR>");
            summaryHtmlStream.println("    <TABLE WIDTH=100% >");
            summaryHtmlStream.println("      <TR><TD>Warnings:</TD></TR>");
            while (i.hasNext()) {
                summaryHtmlStream.println("      <TR><TD>" + i.next() + "</TD></TR>");
            }
            summaryHtmlStream.println("    </TABLE>");
        }
        
        summaryHtmlStream.println("  </BODY>");
        summaryHtmlStream.println("</HTML>");
        summaryHtmlStream.close();
    }
}