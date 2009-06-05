/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package deprecated.spec.reporter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;

import deprecated.spec.harness.Constants;
import deprecated.spec.harness.results.TestResult;


public class HTMLWriter extends Writer {

    static String indentStep = "    ";
    String[] indents = initIndents();

    private static String[] initIndents() {
        String[] results = new String[20];
        results[0] = "";
        for (int i = 1; i < results.length; i++) {
            results[i] = results[i - 1] + indentStep;
        }
        return results;
    }
    int indentIndex = 0;
    String currentIndent = "";

    public HTMLWriter(String outputFileName) {
        super(outputFileName);
        setType(Utils.HTML_WRITER_TYPE);
    }

    public void startTable(String header, boolean isBorderVisible,
            boolean needHeader, boolean putOnlyTableTag) {
        putTABLE(true, "WIDTH=100% " + (isBorderVisible ? "BORDER=1" : ""));
        if (!putOnlyTableTag) {
            putTHEAD(true);
            putColumnsSpec(new int[]{50, 50});
            if (needHeader) {
                insertHeaderRecord(header, "CENTER", true, 2, 1);
            }
            putTHEAD(false);
            putTBODY(true);
        }
    }

    public void startTable(String header, boolean needHeader) {
        startTable(header, true, true, false);
    }

    private void startTable(boolean isBorderVisible) {
        startTable(null, isBorderVisible, false, true);
    }

    private void insertImgData(String imgName, String alignment, int rowSpan) {
        insertHeaderData("<IMG src=\"images/" + imgName + ".jpg\"> </IMG>", alignment,
                false, rowSpan, 0);

    }

    public void startDetailsTable() {
        startTable(true);
        putTHEAD(true);
        putColumnsSpec(new int[] {10, //name
        15, //conf
        10, //iteration
        10, //exp run time
        10, // acual run time
        10, //operations
        10, //ops/min
        25}); //result's graph
        insertHeaderRecord("Details of Runs", "CENTER", true, 8, 3);
        startRecord();
        for (int i = 0; i < 8; i++) {
            insertHeaderData(Utils.DETAILS_TABLE_COLUMNS_NAMES[i], "LEFT", true, 1, 1);
        }
        endRecord();
        putTHEAD(false);
        putTBODY(true);
    }

    private void insertData(String data) {
        putString("<TD>" + data + "</TD>");
    }

    private void insertData(String data, int incFont) {
        insertData("<FONT SIZE=+" + incFont + ">" + data + "</FONT>");
    }

    public void insertRecord(String prop, String value) {
        startRecord();
        putString("<TD ALIGN=LEFT>" + prop + "</TD>");
        putString("<TD ALIGN=LEFT>" + value + "</TD>");
        endRecord();
    }

    private void insertHeaderData(String value, String alignment, boolean isColSpan, int colSpan, int incFont, String attrs) {
        putString("<TD "
                + attrs
                + " ALIGN=" + alignment + " "
                + (colSpan > 1 ?  ((isColSpan ? "COL" : "ROW")+ "SPAN=" + colSpan + "> ") : ">")
                + (incFont != 0 ? ("<FONT SIZE=+" + incFont + ">") : "")
                + value
                + (incFont != 0 ? ("</FONT>"):"") + "</TD>");
    }

    private void insertHeaderData(String value, String alignment, boolean isColSpan, int colSpan, int incFont) {
        insertHeaderData(value, alignment, isColSpan, colSpan, incFont, "");
    }

    private void insertHeaderRecord(String value, String alignment, boolean isColumnSpan, int span, int fontInc) {
        putString("<TR>");
        incIndent();
        insertHeaderData(value, alignment, isColumnSpan, span, fontInc);
        decIndent();
        putString("</TR>");
    }

    private void startRecord() {
        putString("<TR>");
        incIndent();
    }

    private void endRecord() {
        decIndent();
        putString("</TR>");
    }

    private void endAndStartRecord() {
        endRecord();
        startRecord();
    }

    private void putColumnsSpec(int[] percents) {
        for (int i = 0; i < percents.length; i++) {
            putString("   <COL width = " + percents[i] + "%>");
        }
    }

    public void putSummaryTable(ArrayList benchmarkRecords, double compositeScore, 
            String metric, TreeMap<String, Double> sbScores) {
        startTable(true);
        putTHEAD(true);
        putColumnsSpec(new int[]{20, //bmName
            20, //ops/min
            55 //picture
        });

        putTHEAD(false);
        putTBODY(true);
        startRecord();
        insertData("Benchmark", 1);
        insertData(Constants.WORKLOAD_METRIC, 1);
        insertImgData("all", "CENTER", benchmarkRecords.size() + 2);
        endRecord();
        String benchmarkDone = null;
        boolean done = false;

        for (int i = 0; i < benchmarkRecords.size(); i++) {
            BenchmarkRecord record = (BenchmarkRecord) benchmarkRecords.get(i);
            String[] recB = record.name.split("\\.");
            
            if (benchmarkDone != null) {
                if (recB[0].equals(benchmarkDone) == true) {
                    done = true;
                }
            }
            if (record.isSubgroupMember && false == done) {
                Iterator<String> iterator = sbScores.keySet().iterator();

                while (iterator.hasNext()) {
                    String key = iterator.next();
                    Object value = sbScores.get(key);
                    String[] benchmark = key.split("\\.");
                    String[] recordB = record.name.split("\\.");
                    if (value != null && benchmark[0].equals(recordB[0])) {
                        benchmarkDone = benchmark[0];
                        insertRecord(key,
                                Utils.df.format(((Double) value).doubleValue()));
                    }
                }
            }
            
            if (!Utils.isCheck(record) && !record.isSubgroupMember) {
                insertRecord(record.name,
                        record.isValidRun()
                        ? "" + Utils.df.format(record.maxScore) : "ERRORS");
            }
        }

        insertHeaderRecord("Composite result: " + Utils.df.format(compositeScore) + " " + metric,
                "RIGHT", true, 2, 1);

        endTable();
    }

    private static void copyFile(String src, String dest) throws IOException {
        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);
        byte[] buffer = new byte[64000];
        int bytesRead;
        while ((bytesRead = is.read(buffer)) >= 0) {
            os.write(buffer, 0, bytesRead);
        }
        os.close();
        is.close();
    }

    public void putHat(String runStatus, String compositeScore,
            String workloadName,
            String category, String hwVendor,
            String jvmVendor, String hwModel, String jvmName, String submitter,
            String testDate, String jvmVersion) {
        
        startTable("", false, false, true);
        startRecord();
        startData();

        if (ReportGenerator.specLogo != null) {
            try {
                copyFile(ReportGenerator.specLogo , ReportGenerator.reporterDir + "/images/spec-sm.gif");
                insertHeaderData("<IMG SRC=\"images/spec-sm.gif\">&nbsp;&nbsp;", "CENTER", false, 2, 0);
            } catch(IOException e) {}
            endAndStartData();
        }

        startTable("", false, false, false);
        startRecord();
        insertHeaderData("<FONT SIZE=+3 COLOR=BLUE>" + workloadName + "</FONT>", "LEFT", false, 2, 0);
        insertHeaderData("<B>" + compositeScore, "RIGHT", true, 2, 1);
        endAndStartRecord();
        insertHeaderData("<FONT COLOR=BLACK><B>", "RIGHT", false, 1, 0, "BGCOLOR=LIGHTBLUE");
        endRecord();
        insertHeaderRecord(hwVendor + " " + hwModel, "LEFT", true, 1, 1);
        insertHeaderRecord(jvmVendor + " " + jvmName /*+ " " + jvmVersion*/, "LEFT", true, 1, 1);
        startRecord();
        insertHeaderData("Tested by: " + submitter, "LEFT", true, 1, 1);
        insertHeaderData(runStatus, "RIGHT", false, 2, 3);
        endRecord();
        insertHeaderRecord("Test date: " + testDate, "LEFT", true, 1, 1);
        endTable();

        endData();
        endRecord();
        endTable();
    }

    private void endData() {
        decIndent();
        putString("</TD>");
    }

    private void startData() {
        putString("<TD>");
        incIndent();
    }

    public void startRecordAndData() {
        startRecord();
        startData();
    }

    private void putTHEAD(boolean isStart) {
        if (isStart) {
            putString("<THEAD>");
            incIndent();
        } else {
            decIndent();
            putString("</THEAD>");
        }
    }

    private void putTBODY(boolean isStart) {
        if (isStart) {
            putString("<TBODY>");
            incIndent();
        } else {
            decIndent();
            putString("</TBODY>");
        }
    }

    private void putTABLE(boolean isStart, String attrs) {
        if (isStart) {
            putString("<TABLE " + attrs + ">");
            incIndent();
        } else {
            decIndent();
            putString("</TABLE>");
        }

    }

    public void endRecordAndData() {
        endData();
        endRecord();
    }

    public void endAndStartRecordAndData() {
        endData();
        endAndStartRecord();
        startData();
    }

    public void endAndStartData() {
        endData();
        startData();
    }

    public void endTable() {
        endTable(false);
    }

    public void endTable(boolean putOnlyTable) {
        if (putOnlyTable) {
            putTBODY(false);
        }
        putTABLE(false, "");
    }

    private void incIndent() {
        currentIndent = indents[++indentIndex];

    }

    private void decIndent() {
        currentIndent = indents[--indentIndex];
    }

    private void putString(String str) {
        stream.println(currentIndent + str);
    }

    private void handleIterRecord(ArrayList iterationsRecords, int index) {
        BenchmarkRecord.IterationRecord iterRecord =
                (BenchmarkRecord.IterationRecord) iterationsRecords.get(index);
        insertData(iterRecord.iterName);
        insertData(iterRecord.expectedRunTime == null ? "-" : iterRecord.expectedRunTime);
        insertData(Long.toString(iterRecord.runTime));
        if (iterRecord.isValidIteration()) {
            insertData(Utils.df.format(iterRecord.operations));
            insertData(Utils.df.format(iterRecord.score));
        } else {
            insertHeaderData(insertBRTags(iterRecord.errors), "LEFT", true, 3, 0);
        }
    }

    private String createConfRecord(String[] props) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < props.length; i++) {
            if (props[i] != null) {
                result.append(Utils.DETAILS_TABLE_BM_CONF_NAMES[i] + ": ");
                result.append(props[i]);
                if (i != props.length - 1) {
                    result.append("<BR>");
                }
            }
        }
        return result.toString();
    }

    public void handleBenchmarkRecord(BenchmarkRecord record) {
        startRecord();
        int iterations = record.iterRecords.size();
        insertHeaderData(record.name, "LEFT", false, iterations, 0);
        if (!Constants.CHECK_BNAME.equals(record.name) && iterations > 0) {
            insertHeaderData(createConfRecord(record.configuration),
                    "LEFT", false, iterations, 0);
            handleIterRecord(record.iterRecords, 0);
            if (record.isValidRun()) {
                insertHeaderData("<IMG src=\""
                        + Utils.getImageName(record.name + "_results")
                        + "\"> </IMG> <A href=\"" +
                        Utils.getImageName(record.name)
                        + "\"> details </A>", "LEFT",
                        false, iterations/* + 1*/, 0);
            }

            endRecord();
            for (int i = 1; i < record.iterRecords.size(); i++) {
                startRecord();
                handleIterRecord(record.iterRecords, i);
                endRecord();
            }

            String result = record.isValidRun()
                    ? Constants.WORKLOAD_METRIC + ": " + Utils.df.format(record.maxScore)
                    : "Invalid run";

            insertHeaderRecord(result, "RIGHT", true, 8, 1);
        } else {
            String data = "";
            if (record.isValidRun()) {
                data = "PASSED";
            } else {
                if (record.iterRecords != null && record.iterRecords.size() > 0) {
                    BenchmarkRecord.IterationRecord iterRecord =
                            (BenchmarkRecord.IterationRecord) record.iterRecords.get(0);
                    data = "FAILED: <BR>" + insertBRTags(iterRecord.errors);
                }
            }

            insertHeaderData(data, "Left", true, 7, 1);
            endRecord();
        }
    }

    private String insertBRTags(ArrayList values) {
        if (values != null) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < values.size(); i++) {
                if (i != 0) {
                    result.append("<BR>");
                }
                result.append(TestResult.correctContent((String) values.get(i), false));
            }
            return result.toString();
        }
        return "";
    }

    public void insertRecords(ArrayList violations) {
        insertHeaderRecord(insertBRTags(violations), "LEFT", true, 2, 0);
    }

    public void startReport() {
        putString("<HTML>");
        incIndent();
        putString("<HEAD>");
        incIndent();
        putString("<META NAME=\"GENERATOR\" CONTENT=\"SPEC Java Reporter\">");
        putString("<TITLE> SPECjvm2008</TITLE>");
        decIndent();
        putString("</HEAD>");
        putString("<BODY >");
        incIndent();
    }

    public void endReport() {
        decIndent();
        putString("</BODY>");
        decIndent();
        putString("</HTML>");
    }
}
