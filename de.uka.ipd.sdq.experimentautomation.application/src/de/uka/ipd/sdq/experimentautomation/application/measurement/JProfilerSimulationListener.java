package de.uka.ipd.sdq.experimentautomation.application.measurement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import com.jprofiler.api.agent.Controller;

import de.uka.ipd.sdq.experimentautomation.application.ExperimentBookkeeping;

public class JProfilerSimulationListener implements IResponseMeasurement {

    private ExperimentBookkeeping bookkeeping;
    private List<Long> variationValues;
    private URI variationFolderUri;
    private long id;
    private File beforeFile;

    public JProfilerSimulationListener(ExperimentBookkeeping bookkeeping, List<Long> variationValues,
            URI variationFolderUri) {
        this.bookkeeping = bookkeeping;
        this.variationValues = variationValues;
        this.variationFolderUri = variationFolderUri;
        Controller.stopAllocRecording();
        Controller.stopCallTracer();
        Controller.stopCPURecording();
        Controller.stopMethodStatsRecording();
        Controller.stopMonitorRecording();
        Controller.stopThreadProfiling();
        Controller.stopVMTelemetryRecording();
    }

    @Override
    public void simulationStart() {
        this.id = System.currentTimeMillis();
        File resultFile = new File(variationFolderUri.toFileString() + id + "_before.jps");
        this.beforeFile = resultFile;
        System.gc();
        Controller.startVMTelemetryRecording();
        // Controller.saveSnapshot(resultFile);
    }

    @Override
    public void simulationStop() {
        File resultFile = new File(variationFolderUri.toFileString() + id + "_after.jps");
        Controller.saveSnapshot(resultFile);
        Controller.stopVMTelemetryRecording();

        String csvFile = exportSnapshotToCSV(resultFile, this.bookkeeping);
        save(extractMeasurementsFromCSV(csvFile), bookkeeping);
        // Connection conn = null;
        // try {
        // // conn = ConnectionFactory.getLocalConnection()
        // conn = ConnectionFactory.createSnapshotConnection(beforeFile, new
        // File("C:/Users/pmerkle/.jprofiler6/config.xml"));
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        //
        // if (conn != null) {
        // Collection<ThreadInfo> threadInfo = conn.getThreadInfos();
        // for(ThreadInfo i : threadInfo) {
        // System.out.println(i.getThreadName());
        // }
        // }
    }

    private String exportSnapshotToCSV(File snapshotFile, ExperimentBookkeeping bookeeping) {
        // Execute JProfiler export command-line utility
        String inputFilePath = snapshotFile.toString();
        String outputFilePath = snapshotFile.toString().substring(0, snapshotFile.toString().length() - 4) + ".csv";

        String arguments = "";
        arguments = "\"" + inputFilePath + "\"" + " TelemetryThreads " + "-format=csv " + "\"" + outputFilePath + "\"";

        try {
            String exec = "\"C:/Program Files/jprofiler6/bin/jpexport.exe\" " + arguments;
            System.out.println("Executing " + exec + "...");
            Process p = Runtime.getRuntime().exec(exec);
            OutputStream stdin = p.getOutputStream();
            InputStream stderr = p.getErrorStream();
            InputStream stdout = p.getInputStream();

            new Thread(new StdoutRunnable(stdout)).start();
            new Thread(new StderrRunnable(stderr)).start();

            p.waitFor();

            stdout.close();
            stderr.close();
            stdin.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return outputFilePath;
    }

    private Map<String, List<Double>> extractMeasurementsFromCSV(String csvFile) {
        Map<String, List<Double>> result = new HashMap<String, List<Double>>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(csvFile)));
            String line;
            int lineNumber = 0;

            // read column headers
            line = reader.readLine();
            if (line == null)
                throw new RuntimeException("Could not read the column headers from file " + csvFile);
            String[] columHeaders = line.split(";");
            for (String h : columHeaders) {
                result.put(h, new ArrayList<Double>());
            }

            // read column line by line
            while ((line = reader.readLine()) != null) {
                String[] cols = line.split(";");
                for (int i = 0; i < cols.length; i++) {
                    result.get(columHeaders[i]).add(new Double(cols[i]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void save(Map<String, List<Double>> measurements, ExperimentBookkeeping bookkeeping) {
        List<Double> m = measurements.get("\"Total number of threads\"");
        Double mean = calculateMean(m);
        Double max = calculateMax(m);
        String[] factorLevels = new String[variationValues.size()];
        for (int i = 0; i < variationValues.size(); i++) {
            factorLevels[i] = variationValues.get(i).toString();
        }
        // variationValues.toArray(factorLevels);
        bookkeeping.addResult(new String[] { mean.toString(), max.toString() }, factorLevels);
    }

    private double calculateMax(List<Double> doubles) {
        double max = 0;
        for (Double d : doubles) {
            if (d > max)
                max = d;
        }
        return max;
    }

    private double calculateMean(List<Double> doubles) {
        double sum = calculateSum(doubles);
        int count = doubles.size();
        return sum / count;
    }

    private double calculateSum(List<Double> doubles) {
        double sum = 0;
        for (Double d : doubles) {
            sum += d;
        }
        return sum;
    }

    @Override
    public void prepareBookkeeping(ExperimentBookkeeping bookeeping, String[] factorNames) {
        bookkeeping.prepareResultFile(new String[] { "Mean", "Max" }, factorNames);
    }

    private class StdoutRunnable implements Runnable {

        private InputStream stdout;

        public StdoutRunnable(InputStream stdout) {
            this.stdout = stdout;
        }

        @Override
        public void run() {
            // Write R output to the specified file
            try {
                BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(stdout));
                int x;
                while ((x = stdoutReader.read()) != -1) {
                    System.out.print(x);
                }
                stdoutReader.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    private class StderrRunnable implements Runnable {

        private InputStream stderr;

        public StderrRunnable(InputStream stderr) {
            this.stderr = stderr;
        }

        @Override
        public void run() {
            // Write R error output to the console
            try {
                BufferedReader r2 = new BufferedReader(new InputStreamReader(stderr));
                String x2;
                while ((x2 = r2.readLine()) != null) {
                    System.err.println(x2);
                }
                r2.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

}
