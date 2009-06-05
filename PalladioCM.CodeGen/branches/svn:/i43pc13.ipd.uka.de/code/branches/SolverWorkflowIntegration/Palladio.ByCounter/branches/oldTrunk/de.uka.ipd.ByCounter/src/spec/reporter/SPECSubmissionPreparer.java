package spec.reporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import spec.harness.Launch;
import spec.harness.results.TestResult;

public class SPECSubmissionPreparer {
    
    public static void mergeFiles(String [] args) throws IOException {

        int files = 0;
        
        for (int i = 0; i < args.length; i++) {
            if (!(new File(args[i]).exists())) {
                System.out.println("Cannot find file '" + args[0] + "'");
                return;
            } else {
                files++;
            }
        }

        File [] rawFiles = new File[files];
        for (int i = 0; i < files; i++) {
            rawFiles[i] = new File(args[i]);
        }
        
        BufferedReader [] rawFileStreams = new BufferedReader[files];
        for (int i = 0; i < files; i++) {
            rawFileStreams[i] = new BufferedReader(new InputStreamReader(new FileInputStream(rawFiles[i])));
        }

        String [] headerLines = new String[files];
        for (int i = 0; i < files; i++) {
            headerLines[i] = rawFileStreams[i].readLine();
        }
        
        for (int i = 0; i < files; i++) {
            String line = headerLines[i];
            if (line == null || line.indexOf("xml") == -1) {
                System.out.println("Error: '" + args[i] + "' is not a raw file on correct format.");
                System.out.println("Expected header '" + TestResult.XML_HEADER + "'");
                return;
            }
        }
        
        if (files > 1 && !headerLines[0].equals(headerLines[1])) {
            System.out.println("Error: '" + args[0] + "' and  '" + args[1] + "' does not have the same format.");
        }

        String resultFileName = Launch.getNextRawFileInDir();
        System.out.println("Creating file " + resultFileName);
        File resultFile = new File(resultFileName);
        PrintStream resultFileStream = new PrintStream(new FileOutputStream(resultFile));
        
        resultFileStream.println(headerLines[0]);
        resultFileStream.println("<specjvm-results>");
        resultFileStream.println("  <spec.jvm2008.result.noncompliant>no</spec.jvm2008.result.noncompliant>");
        resultFileStream.println("  <spec.jvm2008.result.noncompliant.reason></spec.jvm2008.result.noncompliant.reason>");
        resultFileStream.println("  <spec.jvm2008.result.noncompliant.remedy></spec.jvm2008.result.noncompliant.remedy>");
        
        for (int i = 0; i < files; i++) {
            String line = rawFileStreams[i].readLine();
            while (line != null) {
                resultFileStream.println("  " + line);                
                line = rawFileStreams[i].readLine();
            }
        }

        resultFileStream.println("</specjvm-results>");
        resultFileStream.close();

        for (int i = 0; i < files; i++) {
            rawFileStreams[i].close();
        }
    }
    

    public static void main(String[] args) throws Exception {

        if (args.length < 1 || args.length > 2) {
            System.out.println("Usage: spec.reporter.Merger <raw file 1> <raw file 2 (optional)>");
        }
        mergeFiles(args);
    }
}