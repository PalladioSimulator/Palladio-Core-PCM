/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik, 
 * 10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.fzi.sissy.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Stack;

/**
 * @author szuli
 * @author andriess
 * 
 * Created on May 8, 2003
 *
 */
public class Debug {

	private static int debugLevel;

    private static PrintStream out;

    private static PrintStream err;
    
    private static Stack streamStack;
    
    private static Stack debugLevelStack;

    static {
        out = System.out;
        err = System.err;
        debugLevel = 6;
        streamStack = new Stack();
        debugLevelStack = new Stack(); 
    }
	
	
	/**
	 * 
	 */
	public Debug() {
		super();
	}
		
	public static PrintStream getOutStream() {
		return out;
	}
	
	public static PrintStream getErrStream() {
		return err;
	}
	
	/**
	 * @deprecated use error(), warning() and info() instead
	 */
	public static void debug(String debugMessage) {
		out.println(debugMessage);
		out.flush();
	}
	
	
	/**
	 * 
	 * @param warningMessage is a warning message to be printed on stderr
	 */
	public static void warning(String warningMessage) {
		if ((debugLevel & 2) != 0) {
			err.println("Warning: " + warningMessage);
			err.flush();
		}
	}
	
	/**
	 * 
	 * @param infoMessage will be printed on stdout
	 */
	public static void info(String infoMessage) {
		if ((debugLevel & 1) != 0) {
			out.println("Info: " + infoMessage);
			out.flush();
		}

	}

	/**
	 * 
	 * @param verboseMessage will be printed on stdout
	 */
	public static void verbose(String verboseMessage) {
		if ((debugLevel & 8) != 0) {
			out.println("Verbose: " + verboseMessage);
			out.flush();
		}
	}
	
    public static void cbinfo(Object cbinfoObject) {
        if ((debugLevel & 8) != 0)
            out.println(cbinfoObject);
    }
    
    public static void parserinfo(Object infoObject) {
        if ((debugLevel & 16) != 0)
            out.println(infoObject);
    }
    
    // debug info from MetamodVisitor
    public static void mminfo(Object o) {
        if ((debugLevel & 32) != 0)
            out.println("MetamodVisitor: " + o);
    }
    
    
	/**
	 * 
	 * @param errorMessage will be printed on stderr
	 */
	public static void error(String errorMessage) {
		if ((debugLevel & 4) != 0) {
			err.println("Error: " + errorMessage);
			err.flush();
		}
	}
	
	/**
	 * 
	 * @param newLevel is the new debug level, ranging from 0 to 7, in binary mode it looks like this:<br>
	 * 0010 - this is level 2 debug level. Here's what different levels do:<br>
	 * level 15 - binary 1111  = errors, warnings and information and verbose<br>
	 * level 14 - binary 1110  = errors and warnings and verbose<br>
	 * level 13 - binary 1101  = errors and information and verbose<br>
	 * level 12 - binary 1100  = errors and verbose<br>
	 * level 11 - binary 1011  = warnings and information and verbose<br>
	 * level 10 - binary 1010  = warnings and verbose<br>
	 * level  9 - binary 1001  = information and verbose<br>
	 * level  8 - binary 1000  = verbose
	 * level  7 - binary 0111  = errors, warnings and information<br>
	 * level  6 - binary 0110  = errors and warnings<br>
	 * level  5 - binary 0101  = errors and information<br>
	 * level  4 - binary 0100  = errors only<br>
	 * level  3 - binary 0011  = warnings and information<br>
	 * level  2 - binary 0010  = warnings only<br>
	 * level  1 - binary 0001  = information only<br>
	 * level  0 = no output
	 */
	public static void setDebugLevel(int newLevel) {
		if ((newLevel<16) && (newLevel >=0 ))
			debugLevel = newLevel;
		else throw new IllegalArgumentException("newLevel value must be between 3 and 0");
	}
	
	/**
	 * 
	 * @return the current debug level, for explanation see <b>setDebugLevel</b>
	 */
	public static int getDebugLevel() {
		return debugLevel;
	}
	
    public static void redirectOutputToWriterStream(OutputStream outs, OutputStream errs) {
        streamStack.push(out);
        streamStack.push(err);
        out = new PrintStream(outs);
        err = new PrintStream(errs);
    }

    public static void redirectOutputToFile(String outFile) {
        streamStack.push(out);
        streamStack.push(err);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            out = new PrintStream(fileOutputStream);
            err = out;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            err = (PrintStream) streamStack.pop();
            out = (PrintStream) streamStack.pop();
        }    	
    }
    
    public static void redirectOutputToFile(String outFile, String errFile) {
        streamStack.push(out);
        streamStack.push(err);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outFile);
            out = new PrintStream(fileOutputStream);
            FileOutputStream fileErrorStream = new FileOutputStream(errFile);
            err = new PrintStream(fileErrorStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            err = (PrintStream) streamStack.pop();
            out = (PrintStream) streamStack.pop();
        }
    }

    public static void redirectOutputToSystem() {
        streamStack.push(out);
        streamStack.push(err);
        out = System.out;
        err = System.err;
    }
    
    public static void endRedirect() {
        err = (PrintStream) streamStack.pop();
        out = (PrintStream) streamStack.pop();        
    }	
    
    public static PrintWriter getPrintWriter() {
        return new PrintWriter(out);
    }
    
    public static void pushDebugLevel() {
        debugLevelStack.push(new Integer(debugLevel));
    }
    
    public static void popDebugLevel() {
        debugLevel = ((Integer) debugLevelStack.pop()).intValue();
    }
}
