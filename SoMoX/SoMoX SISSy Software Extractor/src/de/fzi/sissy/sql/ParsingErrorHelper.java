package de.fzi.sissy.sql;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ParsingErrorHelper implements Runnable {

    static ParsingErrorHelper instance = null;
    static Thread t = null;
    private Date now = new Date();
    
    private String currentFile = "";
    
    public static ParsingErrorHelper getInstance() {
        if (instance == null)
            instance = new ParsingErrorHelper();
        return instance;
    }
    
    BufferedReader reader;
    PipedInputStream inPipe;
    PrintStream statements;
    
    List elements;

    public ParsingErrorHelper() {
        elements = new ArrayList();
    }
    
    public class TErrorElement {
        String timestamp;
        int kindOfError;
        String filename;
        int lineNumber;
        String message;
    }
    
    public void addError(String timestamp, int kindOfEror, String filename, int lineNumber, String message) {
        TErrorElement elem = new TErrorElement();
        elem.timestamp = timestamp;
        elem.kindOfError = kindOfEror;
        elem.filename = filename;
        elem.lineNumber = lineNumber;
        elem.message = message;
        elements.add(elem);
    }

    public Date getAnalysisTimeStamp() {
    	return now;
    }
    
    public void setCurrentFile(String file) {
    	currentFile = file;
    }
    
    public String getCurrentFile() {
    	return currentFile;
    }
    
    public void clear() {
        elements.clear();
    }
    
    public Iterator iterator() {
        return elements.iterator();
    }
    
    public void addError(String msg) {
        String text = msg;
        String filename = "";
        int line = 0;
        String timestamp;
        try {
            int a = msg.indexOf(" in file: ");
            if (a != -1) {
                text = msg.substring(0, a);
                String temp = msg.substring(a+10);
                int b = temp.indexOf(" on line: ");
                filename = temp.substring(0, b);
                temp = temp.substring(b+10);
                temp = temp.replace(".", "");
                temp = temp.trim();
                line = Integer.parseInt(temp);
            } else {
               	a = msg.indexOf(" in FILE:");
               	if (a != -1) {
                	a = msg.lastIndexOf(" @", a);                	
                    text = msg.substring(0, a);
                    String temp = msg.substring(a+2);
                    int b = temp.indexOf("/");
                    String linestr = temp.substring(0, b).trim();
                    b = temp.indexOf(" in FILE:");
                    int c = temp.indexOf(" ", b);
                    if (c > b)
                    	filename = temp.substring(b+9, c).trim();
                    else
                    	filename = temp.substring(b+9).trim();
                    line = Integer.parseInt(linestr);                	
                }
               	else {
               		text = msg;
               	}
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }

        if (filename.length() == 0)
        	filename = currentFile;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        timestamp = sdf.format(now);
            
        addError(timestamp, 0, filename, line, text);
    }
    
    public PrintStream startCollectErrors() {
        try {
            inPipe = new PipedInputStream();
            reader = new BufferedReader(new InputStreamReader(inPipe));
            PipedOutputStream outPipe = new PipedOutputStream(inPipe);
            statements = new PrintStream(new BufferedOutputStream(outPipe));
            if (t == null) {
                t = new Thread(instance);
                t.setPriority(Thread.MIN_PRIORITY);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    	return statements;
    }
    
    public void endCollectErrors() {
        try {
        	statements.close();
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void run() {
        String line = null;
        try {
            while (true) {
                if (reader.ready()) {
                    line = reader.readLine();
                    addError(line);
                }
            }
        } catch (IOException e) {
        }
    }
}

