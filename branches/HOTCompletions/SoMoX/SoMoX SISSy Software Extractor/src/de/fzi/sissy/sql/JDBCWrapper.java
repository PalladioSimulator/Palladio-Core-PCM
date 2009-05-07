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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.net.MalformedURLException;


import org.postgresql.util.PSQLException;

/**
 * @author Mircea Trifu
 * @author Christoph Andriessens
 * @author Thorsten Blum
 *
 */
public class JDBCWrapper {

    private String dbURL;
    private String dbUser;
    private String dbPass;
    private String driverName;
	private String initScript;
	private String emptyScript;
    private Connection jdbcConnection;

    public JDBCWrapper() {
        loadConfigFile("jdbc.cfg");
    }

    /**
     * @author Thorsten Blum
     * 
     * Providing no file name loads the standard "jdbc.cfg" config file
     */
    public JDBCWrapper(String fileName) {
        try
        {
	    	if (fileName == null)
	            loadConfigFile("jdbc.cfg");
	        else
	            loadConfigFile(fileName);
        }
        catch(JDBCError jerr)
        {
        	System.out.println("Warning: JDBC configuration not loaded");
        }
    }

    public JDBCWrapper(String fileName, String dbName) {
    	this(fileName);
        if (dbName != null) {
        	try {
        		JDBCURL tempURL = new JDBCURL(dbURL);
        		tempURL.setDBName(dbName);
        		dbURL = tempURL.toString();
        	}
        	catch (MalformedURLException e) {
        		e.printStackTrace();
        		throw new JDBCError(e);
        	}
        	
        }	
    }

    public void loadConfigFile(String fileName) {
        BufferedReader configFile;
        try {
            configFile = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = configFile.readLine()) != null) {
                if (!line.startsWith("#")) {
                    String arg = line.substring(line.indexOf("=") + 1).trim();
                    arg = arg.substring(1, arg.length() - 1);
                    if (line.trim().startsWith("JDBC_DRIVER")) {
                    	driverName = new String(arg);
                    } else if (line.trim().startsWith("JDBC_URL")) {
                        dbURL = new String(arg);
                    } else if (line.trim().startsWith("JDBC_USER")
                            && (dbUser == null)) {
                        dbUser = new String(arg);
                    } else if (line.trim().startsWith("JDBC_PASSWORD")
                            && (dbPass == null)) {
                        dbPass = new String(arg);
					} else if (line.trim().startsWith("JDBC_INIT_SCRIPT")) {
						initScript = new String(arg);
					} else if (line.trim().startsWith("JDBC_EMPTY_SCRIPT")) {
						emptyScript = new String(arg);
                    }
                }
            }
            configFile.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new JDBCError(e);
        }
    }

	public void runScripts() {
		try {
		    if ((emptyScript == null) && (initScript == null))
		        throw new JDBCError(new IllegalStateException("No scripts specified that could be run."));
			if (emptyScript != null)
			    if (emptyScript.length() > 0) {
					FileReader dbFile = new FileReader(emptyScript);
					runScript(dbFile);
				}
			if (initScript != null)
				if (initScript.length() > 0) {
					FileReader dbFile = new FileReader(initScript);
					runScript(dbFile);
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
            throw new JDBCError(e);
		}
	}
	
	public void printScripts(PrintWriter out) {
		try {
		    if ((emptyScript == null) && (initScript == null))
		        throw new JDBCError(new IllegalStateException("No scripts specified that could be printed."));
			if (emptyScript.length() > 0) {
				FileReader dbFile = new FileReader(emptyScript);
				printScript(dbFile, out);
			}
			if (initScript.length() > 0) {
				FileReader dbFile = new FileReader(initScript);
				printScript(dbFile, out);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
            throw new JDBCError(e);
		}		
	}

	private void printScript(Reader input, PrintWriter out) {
		try {
			BufferedReader inputFile = new BufferedReader(input);
			String line;
			StringBuffer stmtBuffer = new StringBuffer();
			while ((line = inputFile.readLine()) != null) {
				stmtBuffer.append(line.trim()).append(" ");
				if (line.indexOf(";") != -1) {
					stmtBuffer.delete(stmtBuffer.indexOf(";") + 1, stmtBuffer.length());
					out.println(stmtBuffer.toString().trim());
					stmtBuffer = new StringBuffer(line.substring(line.indexOf(";") + 1).trim());
					stmtBuffer.append(" ");
				}
			}
			inputFile.close();
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
            throw new JDBCError(ex);
		}
	}

	public void runScript(Reader input) {
		getConnection();
		try {
			BufferedReader inputFile = new BufferedReader(input);
			String line;
			jdbcConnection.setAutoCommit(true);
			Statement stmt = jdbcConnection.createStatement();
			StringBuffer stmtBuffer = new StringBuffer();
			while ((line = inputFile.readLine()) != null) {
				stmtBuffer.append(line.trim()).append(" ");
				if (line.indexOf(";") != -1) {
					stmtBuffer.delete(stmtBuffer.indexOf(";") + 1, stmtBuffer.length());
					try {
						stmt.execute(stmtBuffer.toString().trim());
					} catch (SQLException e) {
						// drop non-existing table or create existing table
						if (!(stmtBuffer.toString().toLowerCase().trim().startsWith("drop table") && e.getSQLState().equals("42P01")))
							if (!(stmtBuffer.toString().toLowerCase().trim().startsWith("create table") && e.getSQLState().equals("42P07")))							
								e.printStackTrace();
					}
					stmtBuffer = new StringBuffer(line.substring(line.indexOf(";") + 1).trim());
					stmtBuffer.append(" ");
				}
			}
			inputFile.close();
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
            throw new JDBCError(ex);
		} catch (SQLException ex) {
			ex.printStackTrace(System.err);
            throw new JDBCError(ex);
		}
	}

	
	public void runStatements(Reader input) {
		getConnection();
		try {
			BufferedReader inputFile = new BufferedReader(input);
			String line;
			long count = 0;
			jdbcConnection.setAutoCommit(false);
			Statement stmt = jdbcConnection.createStatement();
			while ((line = inputFile.readLine()) != null) {
				if (count == 10000) {
					count = 0;
					stmt.executeBatch();
					stmt.clearBatch();
				}
				count ++;
				stmt.addBatch(line);
			}
			inputFile.close();
			stmt.executeBatch();
			jdbcConnection.commit();
			jdbcConnection.setAutoCommit(true);
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
            throw new JDBCError(ex);
		} catch (SQLException e) {
			e.printStackTrace(System.err);
			// MB : Handle chained exception correctly
			SQLException e2 = e.getNextException();
			if (e2 != null)
				e2.printStackTrace(System.err);
            throw new JDBCError(e);
		}
	}

	public void runStatements(InputStream input) {
		runStatements(new InputStreamReader(input));
	}

    public Connection getConnection() throws JDBCError {
    	if (jdbcConnection == null) {    		
    		try{
        		Class.forName(driverName);
                jdbcConnection = DriverManager.getConnection(dbURL, dbUser, dbPass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new JDBCError(e);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new JDBCError(e);
            }    	
    	}    		
        return jdbcConnection;
    }
    
    /**
     * Use executeQuery() for small queries only. Other ones should use
     * runStatements() which is multithreaded and optimized for speed. 
     * 
     * @author Christoph Andriessens     
     * @param query Query to be executed
     * @return Result of the query
     */    
    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            Statement stmt = jdbcConnection.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
        	if (!e.getSQLState().equals("02000")) {
        		e.printStackTrace();
        		throw new JDBCError(e);            
        	}
        }
        return rs;
    }
    
    public String getDBName() {
    	try {
    		JDBCURL tempURL = new JDBCURL(dbURL);
    		return tempURL.getDBName();
    	}
    	catch (MalformedURLException e) {
            e.printStackTrace();
            throw new JDBCError(e);
    	}
    }
    
}
