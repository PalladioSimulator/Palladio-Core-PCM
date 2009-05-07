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
package de.fzi.sissy.sql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.sql.SQLException;

import de.fzi.sissy.util.Debug;

/**
 * @author Mircea Trifu
 *
 */
public class SQLCommandFileExporter implements Runnable {
	
	private PrintWriter outPipe;
	private PipedReader inPipe;
	private JDBCWrapper jdbcWrapper;
	private String inputFileName;
	
	public SQLCommandFileExporter(String configFile, String dbName, String inputFileName) {
		try {
			jdbcWrapper = new JDBCWrapper(configFile, dbName);
			jdbcWrapper.runScripts();
			this.inputFileName = inputFileName;
			inPipe = new PipedReader();
			outPipe = new PrintWriter(new PipedWriter(inPipe));
			Thread t = new Thread(this);
			t.start();
			export();
			outPipe.close();
			t.join();
			jdbcWrapper.getConnection().close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDBCError e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void export() {
		try {
			BufferedReader inputFile = new BufferedReader(new FileReader(inputFileName));
			
			System.out.println("SQL statement runner started...");
			int count = 0;
			String statement;
			while ((statement = inputFile.readLine()) != null) {
				count++;
				if (count % 5000 == 0) {
					System.out.println("\tRunning statement: " + count);
				}
				outPipe.println(statement);
			}
			System.out.println("SQL statement runner finished inserting " + count + " statements");			
			inputFile.close();
		} catch (IOException ex) {
			Debug.error(ex.toString());
		} catch (JDBCError ex) {
			Debug.error(ex.toString());
		}
	}

	public void run() {
		jdbcWrapper.runStatements(inPipe);
	}

	public static void main(String[] args) {
		String inputFileName = null;
		String configFileName = "jdbc.cfg";
		String dbName = null;
			
		Debug.setDebugLevel(6);
		if (args.length < 1) {
			printUsage();
			return;
		}
		inputFileName = args[0];
		for (int i = 1; i < args.length; i++) {
			if (args[i].equals("-cfg")) {
		    	i++;
		        configFileName = args[i];
		        Debug.info("Using alternate config file \"" + configFileName + "\"");
		    } else if (args[i].equals("-db")) {
		    	i++;
		    	dbName = args[i];
		        Debug.info("Using alternate database \"" + dbName + "\"");
		    } else {
		        printUsage();
		        System.exit(-3);
		    }
		} 
		if (args.length > 5) {
		    printUsage();
		    System.exit(-4);
		}
			    
		if ((inputFileName == null) && (dbName == null))
		    Debug.info("Using default database");
		
		SQLCommandFileExporter exporter = new SQLCommandFileExporter(configFileName, dbName, inputFileName);
	}

	private static void printUsage() {
		Debug.error("Wrong usage. See below:\n\n" + "" +
			"SISSy <sql_command_file> [-cfg configfile] [-db dbname]\n\n" + 
			"\t<sql_command_file>: the file containing the SQL commnads" +
			"\t-cfg configfile: an alternate jdbc config file. If this param is not\n\t\tsupplied the default config file is used.\n" +
			"\t-db dbname: the result will be stored in the specified database. If\n\t\tthis param is not given the output will be stored in the\n\t\tdefault database.\n");
	}
}
