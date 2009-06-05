/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */
package spec.reporter;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Formatter;

import spec.harness.Constants;
import spec.harness.results.TestResult;

public class PlainWriter extends Writer {

    public PlainWriter(String outputFileName) {
        super(outputFileName);
        setType(Utils.PLAIN_WRITER_TYPE);
    }

    public void endAndStartData() {

    }

    public void endAndStartRecordAndData() {

    }

    public void endRecordAndData() {

    }

    public void endTable() {

    }

    private void handleIterRecord(BenchmarkRecord records) {
        BenchmarkRecord.IterationRecord iterRecord;
        Formatter formatter = new Formatter(stream);
        for (int i = 0; i < records.iterRecords.size(); i++) {
            iterRecord = records.iterRecords.get(i);
            stream.println();
            formatter.format("%1$-30s%2$-15s%3$-15s%4$-15s", records.name, iterRecord.iterName, iterRecord.expectedRunTime, iterRecord.runTime);
            //formatter.format("%1$-10s%2$-10s%3$-10s", records.configuration[0], records.configuration[1], records.configuration[2]);
            if (iterRecord.isValidIteration()) {
                formatter.format("%1$-15.2f%2$-15.2f", iterRecord.operations, iterRecord.score);
            } else {
                stream.print(iterRecord.errors);
            }
        }
        stream.println();
    }

    private void createConfRecord(String[] props, String name) {
        Formatter formatter = new Formatter(stream);
        for (int i = 0; i < props.length; i++) {
            if (props[i] != null) {
                formatter.format("%1$-10s%2$-10s", Utils.DETAILS_TABLE_BM_CONF_NAMES[i] + ": ", props[i]);
                stream.println();
            }
        }
    }

    public void handleBenchmarkRecord(BenchmarkRecord record) {
        if (!Constants.CHECK_BNAME.equals(record.name)) {
            handleIterRecord(record);
        } else {
            if (record.isValidRun()) {
                stream.println("PASSED");
            } else {
                if (record.iterRecords != null && record.iterRecords.size() > 0) {
                    stream.println("FAILED");
                }
            }
            stream.println();
            Formatter formatter = new Formatter(stream);
            formatter.format("%1$-30s%2$-15s%3$-15s%4$-15s%5$-15s%6$-15s", "Benchmark", "Iteration", "Expected(ms)", "Actual(ms)", "Operations", Constants.WORKLOAD_METRIC);
            stream.println();
            stream.println("---------------------------------------------------------------------------------------------------");
        }
    }

    public void insertRecord(String prop, String value) {
        Formatter formatter = new Formatter(stream);
        formatter.format("%1$-30s%2$-40s", prop, value);
        stream.println();
    }

    public void putHat(String runStatus,
            String compositeScore, String workloadName, String category, String hwVendor,
            String jvmVendor, String hwModel, String jvmName,
            String submitter, String testDate, String jvmVersion) {
        stream.println("================================");
        stream.println(workloadName);
        stream.println("================================");
        stream.println(hwVendor + " " + hwModel);
        stream.println(jvmVendor + " " + jvmName /*+ " " + jvmVersion*/);
        stream.println("Tested by: " + submitter + " Test date: " + testDate);
        stream.println(runStatus);
    }

    public void putSummaryTable(ArrayList benchmarkRecords, double compositeScore,
            String metric, TreeMap<String, Double> sbScores) {
        stream.println();
        stream.println("================================");
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

        stream.println("Composite result: " + Utils.df.format((Double) compositeScore) + " " + Constants.WORKLOAD_METRIC);
        stream.println("================================");
        stream.println();
        stream.println();
    }

    public void startDetailsTable() {
        stream.println();
        stream.println("Details of Runs");
        stream.println("---------------");
    }

    public void startRecordAndData() {
    }

    public void startTable(String header, boolean needHeader) {
    }

    public void startTable(String header, boolean needHeader, boolean showBorder, boolean onlyTable) {
    }

    public static void main(String[] args) {
    }

    public void insertRecords(ArrayList violations) {
        if (violations != null) {
            stream.println();
            for (int i = 0; i < violations.size(); i++) {
                stream.println(TestResult.correctContent(((String) violations.get(i)), false));
            }
        }
        stream.print("");
    }

    public void startReport() {
    }

    public void endReport() {
    }
}







