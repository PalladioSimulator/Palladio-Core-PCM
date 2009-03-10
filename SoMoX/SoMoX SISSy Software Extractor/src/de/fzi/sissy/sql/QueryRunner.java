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
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.postgresql.util.PSQLException;

import de.fzi.sissy.util.ArgParser;
import de.fzi.sissy.util.Debug;

/**
 * Helper application to run all the queries and dump the generated query
 * results
 * 
 * @author woelker
 * @author Mircea Trifu
 *
 */
public class QueryRunner {
	JDBCWrapper jdbcWrapper = null;

    String resDirName = "res/sql/";
    String sqlDirDefaultName = "queries";
    String sqlDirName = null;

	String outputPrefix = "out_";

	String outputExtension = ".txt";
	String csvExtension = ".csv";

    
	String dbName = null;
    
    int problemId = 0;
    int propId = 0;

    Date now = ParsingErrorHelper.getInstance().getAnalysisTimeStamp();
    
    String configFile = null;

	boolean writeCSV = false;
    boolean dbexport = false;
	
    List statements = new ArrayList();
    
	/**
	 * Creates a new QueryRunner object.
	 * 
	 * @param args
	 *            DOCUMENT ME!
	 */
	public QueryRunner(String[] args) {
		// -- Setup ArgParser
		ArgParser argParser = new ArgParser("SISSy",
				"SISSy -query [-cfg <cfg-file>] [-db <dbname>] [-d <querydir>] {-dbexport | -text | -csv}");
		argParser
				.addOption(
						"cfg",
						"cfg-file",
						"an alternate jdbc config file. If this param is not supplied the default config file is used.");
		argParser
				.addOption(
						"db",
						"dbname",
						"database to use. If the -db param is missing the default database specified in the <cfg-file> will be used.");
	    argParser.addOption("d", "querydir",
	        "directory containing the queries.\nNote: directroy is a subdirectory of res/sql.");	
		argParser
				.addOption(
						"csv",
						null,
						"export results to csv files.");
        argParser.addOption("dbexport", null, "export results to database.");
        argParser.addOption("text", null, "export results to text files.");
		argParser.parse(args);
		dbName = argParser.getParameter("db");
		configFile = argParser.getParameter("cfg");
        
        dbexport = argParser.hasParameter("dbexport");

		sqlDirName = argParser.getParameter("d");
        if(sqlDirName==null) 
        	sqlDirName = sqlDirDefaultName;
        sqlDirName = resDirName + sqlDirName;

		writeCSV = argParser.hasParameter("csv");
		
		if (!dbexport && !writeCSV && !argParser.hasParameter("text")) {
			argParser.printHelp();
		}
		else {
			
			// -- Setup JDBCWrapper
			jdbcWrapper = new JDBCWrapper(configFile, dbName);
			System.out.println("Database: " + jdbcWrapper.getDBName());
	        jdbcWrapper.getConnection();
		
	        if (dbexport) {
	        	Debug.info("Exporting problems to database.");
	        	try {
	            	ResultSet rs = jdbcWrapper.executeQuery("select max(id) from tproblems;");
	            	rs.next();
					problemId = rs.getInt(1) + 1;
					rs = jdbcWrapper.executeQuery("select max(id) from tproblemproperties;");
	            	rs.next();
					propId = rs.getInt(1) + 1;					
				} catch (SQLException e) {				
				}
	        }		

	        // -- Get Files
			File sqlDir = new File(sqlDirName);
			String[] sqlList = sqlDir.list(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					return (name.endsWith(".sql"));
				}
			});
	
	        // -- Run queries
			for (int i = 0; i < sqlList.length; i++) {
				System.out.println("SQL: " + sqlList[i]);
	            if (dbexport) {
					executeQuery(sqlDir.getPath() + "/" + sqlList[i]);
				}
	            else {
					// -- Create output Directory
					File outDir = new File(outputPrefix + jdbcWrapper.getDBName());
					outDir.mkdirs();	        	
					String filename = sqlList[i].substring(0, sqlList[i].lastIndexOf("."));
					if (writeCSV) {	            
						filename = filename + csvExtension;
						executeQuery2CSV(sqlDir.getPath() + "/" + sqlList[i], outDir.getPath()
							+ "/" + filename);
					} 
		            else {
			            filename = filename + outputExtension;
			            executeQuery(sqlDir.getPath() + "/" + sqlList[i], outDir.getPath()
			            + "/" + filename);
		            }
	            }
			}

			if (dbexport) {
	            Debug.info("Writing results into database...");
	            for (int i=0; i<statements.size(); i++) {
	                String line = (String) statements.get(i);
	                try {
	                    jdbcWrapper.executeQuery(line);
	                } catch (Exception e) {
	                    System.out.println(line);
	                }
	            }
	            statements.clear();
	        }
		}
	}

	public QueryRunner(String[] args, boolean runAllQueries) {
		// -- Setup ArgParser
		ArgParser argParser = new ArgParser("SISSy",
				"SISSy -query [-cfg <cfg-file>] [-db <dbname>] [-d <querydir>]");
		argParser
				.addOption(
						"cfg",
						"cfg-file",
						"an alternate jdbc config file. If this param is not supplied the default config file is used.");
		argParser
				.addOption(
						"db",
						"dbname",
						"the result will be stored in the specified database. If the -db param is missing the output will be stored in the default database specified in the <cfg-file>.");
        argParser.addOption("d", "querydir", "directory containing the queries.\nNote: directroy is a subdirectory of res/sql");
		argParser.parse(args);
		dbName = argParser.getParameter("db");
		configFile = argParser.getParameter("cfg");
        sqlDirName = argParser.getParameter("d");
        if(sqlDirName==null) sqlDirName = sqlDirDefaultName;
        sqlDirName = resDirName + sqlDirName;
        System.out.println("Directory: " +sqlDirName);

		// -- Setup JDBCWrapper
		jdbcWrapper = new JDBCWrapper(configFile, dbName);
		System.out.println("Database: " + jdbcWrapper.getDBName());
		jdbcWrapper.getConnection();
	}

	/**
     * Executes the query and dumps the result into the database. 
     * @param sqlFilename
	 */
    void executeQuery(String sqlFilename) {
        try {
            List sqlQuery = readFile(sqlFilename);
            if (sqlQuery == null || sqlQuery.size() <= 0) { // -- no queries found
                return;
            }

            ResultSet rs = null;

            for (int j = 0; j < sqlQuery.size(); j++) {
                
                // System.err.println("QUERY: " + sqlQuery.get(j));

                try {
                    rs = jdbcWrapper.executeQuery((String) sqlQuery.get(j));

                    if (rs != null) {
	                    ResultSetMetaData rsmd = rs.getMetaData();
	                    
	                    while (rs.next()) {
	                        File f = new File(sqlFilename);
	                        String kindOfProblem = f.getName();
	                        kindOfProblem = kindOfProblem.substring(0, kindOfProblem.indexOf('.'));
	                        String fileName = "";
	                        int lineNumber = 0;
	                        try {
	                            fileName = rs.getString("file_name");
	                            lineNumber = rs.getInt("line_number");
	                        } catch (Exception e) {}
	                        if ((fileName == null) || ((fileName != null) &&(fileName.equals(""))))
	                            fileName = "NULL";
	                        fileName = fileName.replace("\\", "\\\\");
	                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	                        String timestamp = sdf.format(now);
	                        String lineNumberStr = "NULL";
	                        if (lineNumber != 0)
	                            lineNumberStr = Integer.toString(lineNumber);
	                        String insert = "insert into TProblems values (" + problemId + ",\'" + timestamp + "\','" + kindOfProblem 
	                                            + "\', \'" + fileName + "\', " + lineNumberStr + ");";
	                        statements.add(insert);
	                        
	                        for (int i=1; i<=rsmd.getColumnCount(); i++) {
	//                            if ((rsmd.getColumnName(i).equals("file_name")) || (rsmd.getColumnName(i).equals("line_number")))
	//                                continue;
	                            String propName = rsmd.getColumnName(i);
	                            String propValue = rs.getString(i);
	                            if (propValue != null)
	                            	propValue = propValue.replace("\\", "\\\\");
	                            String insert2 = "insert into TProblemProperties values (" + propId + ", " + problemId + ", '" + propName + "\',\'" + propValue + "\');";	                            
	                            statements.add(insert2);
	                            propId++;
	                        }
	                        problemId++;
	                    }
                    }
                } catch (JDBCError e) {
                    System.err.println("JDBCError executing query "
                            + sqlFilename);
                    e.printStackTrace();
                } catch (SQLException e) {
                    System.err.println("SQLError executing query "
                            + sqlFilename);
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
	
	/**
	 * Exectus a query and dumps the results in a text file
	 * 
	 * @param sqlFilename
	 *            File with SQL Queries
	 * @param outFilename
	 *            Output Filename
	 */
	void executeQuery(String sqlFilename, String outFilename) {
		try {
			PrintStream out = new PrintStream(outFilename);
			List sqlQuery = readFile(sqlFilename);
			if (sqlQuery == null || sqlQuery.size() <= 0) { // -- no queries found
				return;
			}

			ResultSet rs = null;

			for (int j = 0; j < sqlQuery.size(); j++) {
				
				// System.err.println("QUERY: " + sqlQuery.get(j));

				try {
					rs = jdbcWrapper.executeQuery((String) sqlQuery.get(j));

					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					int[] columnSize = new int[columnCount + 1];

					for (int i = 1; i <= columnCount; i++) {
						String str = rsmd.getColumnLabel(i);
						columnSize[i] = Math.max(rsmd.getColumnDisplaySize(i),
								str.length());

						if (columnSize[i] > 40) {
							columnSize[i] = 40;
						}

						out.print(leftJustify(str, columnSize[i], ' ') + " | ");
					}

					out.println();

					for (int i = 1; i <= columnCount; i++) {
						out.print(leftJustify("", columnSize[i], '=') + "=+=");
					}

					out.println();

					while (rs.next()) {
						for (int i = 1; i <= columnCount; i++) {
							String str = rs.getString(i);
							out.print(leftJustify(str, columnSize[i], ' ')
									+ " | ");
						}

						out.println();
					}
				} catch (JDBCError e) {
					System.err.println("JDBCError executing query "
							+ sqlFilename);
					e.printStackTrace();
				} catch (SQLException e) {
					System.err.println("SQLError executing query "
							+ sqlFilename);
					e.printStackTrace();
				} catch (Exception e) {
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static private String leftJustify(String s, int length, char pad) {
		if (s == null) {
			s = "(NULL)";
		}

		StringBuffer buffer = new StringBuffer(s);

		while (buffer.length() < length) {
			buffer.append(pad);
		}

		return buffer.toString();
	}

	/**
	 * Exectus a query and dumps the results in a text file
	 * 
	 * @param sqlFilename
	 *            File with SQL Queries
	 * @param outFilename
	 *            Output Filename
	 */
	void executeQuery2CSV(String sqlFilename, String outFilename) {
		try {
			PrintStream out = new PrintStream(outFilename);
			List sqlQuery = readFile(sqlFilename);
			if (sqlQuery == null || sqlQuery.size() <= 0) { // -- no queries found
				return;
			}

			long startMillis = System.currentTimeMillis();
			
			long rowCount = 0;
			ResultSet rs = null;

			for (int j = 0; j < sqlQuery.size(); j++) {
				
				// System.err.println("QUERY: " + sqlQuery.get(j));

				try {
					rs = jdbcWrapper.executeQuery((String) sqlQuery.get(j));

					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();

					for (int i = 1; i <= columnCount; i++) {
						String str = rsmd.getColumnLabel(i);
						out.print(str + ";");
					}

					out.println();

					while (rs.next()) {
						for (int i = 1; i <= columnCount; i++) {
							String str = rs.getString(i);
							out.print(str + ";");
						}
						out.println();
						rowCount++;
					}
					
				} catch (JDBCError e) {
					System.err.println("JDBCError executing query "
							+ sqlFilename);
					e.printStackTrace();
					System.err.println("Query fragement: " + sqlQuery.get(j));
				} catch (SQLException e) {
					System.err.println("SQLError executing query "
							+ sqlFilename);
					e.printStackTrace();
					System.err.println("Query fragement: " + sqlQuery.get(j));
				} catch (Exception e) {
				}
			}
			long seconds = (System.currentTimeMillis() - startMillis) / 1000; 
			System.out.println("Query returned " + rowCount + " row(s) in " + seconds + " s.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	List readFile(String filename) throws IOException {
		StringBuffer buffer = new StringBuffer();
		BufferedReader inputFile = new BufferedReader(new FileReader(filename));
		String line;

		while ((line = inputFile.readLine()) != null) {
			int start = line.indexOf("--");
			if (start >= 0) {
				line = line.substring(0, start);
			}
			buffer.append(line);
			buffer.append(" ");
		}

		while (true) // -- Strip comments
		{
			int start = buffer.indexOf("/*");

			if (start == -1) {
				break;
			}

			int end = buffer.indexOf("*/", start) + 2;
			buffer.delete(start, end);
		}
		// -- Tokenize queries
		StringTokenizer tok = new StringTokenizer(buffer.toString(), ";");
		int count = tok.countTokens();

		if (count == 0) {
			return null;
		}
		
		List stmts = new ArrayList();
		String stmt;
		int i = 0;

		while (i < count) {
			stmt = tok.nextToken() ; // + ";";
			stmt = stmt.trim();
			
			if (!stmt.equals("")) {
				stmts.add(stmt);
				//System.out.println("TOKEN: " + stmt);
			}
			i++;
		}
		//System.err.println("Statements: " + stmts.size());

		return stmts;
	}

	public int executeQueryCounting(String sqlFilename) {
		int count = 0;
		try {
			List sqlQuery = readFile(sqlFilename);

			if (sqlQuery == null || sqlQuery.size() <= 0) { // -- no queries found
				return -1;
			}

			for (int k = 0; k < sqlQuery.size(); k++) {
				
				String stmt = (String) sqlQuery.get(k);
				if (!(stmt.toUpperCase().contains("CREATE") || stmt.toUpperCase().contains("DROP"))
						&& (stmt.toUpperCase().contains("SELECT"))) {
					ResultSet rs = jdbcWrapper.executeQuery(stmt);
					if (rs != null) {
						try {
							while (rs.next()) {
								count++;
							}
						} catch (SQLException e) {
							System.out.println("SQLError executing query "
									+ sqlFilename);
							e.printStackTrace();
						}
					}
				} else {

					try {
						jdbcWrapper.executeQuery(stmt);
					} catch (JDBCError e) {
						System.out.println();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDBCError e) {
			if (e.getException() instanceof PSQLException) {
				// -- Some queries (Create table) do not generate
				// ResultSets...this is probably one of those cases
			}
		}
		return count;
	}

	public int executeQueryReading(String sqlFilename, int row, int col) {

		try {
			List sqlQuery = readFile(sqlFilename);

			if (sqlQuery == null || sqlQuery.size() <= 0) { // -- no queries found
				return -1;
			}

			for (int k = 0; k < sqlQuery.size(); k++) {
				String stmt = (String) sqlQuery.get(k);
				if ((!(stmt.toUpperCase().contains("CREATE") || stmt.toUpperCase().contains("DROP")))
						&& (stmt.toUpperCase().contains("SELECT"))) {
					ResultSet rs = jdbcWrapper.executeQuery(stmt);
					try {
						// rs.absolute(row);
						for (int i = 1; i <= row; i++)
							rs.next();
						return rs.getInt(col);
					} catch (SQLException e) {
						System.out.println("SQLError executing query "
								+ sqlFilename);
						e.printStackTrace();
					}
				} else {

					try {
						jdbcWrapper.executeQuery(stmt);
					} catch (JDBCError e) {
						System.out.println();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDBCError e) {
			if (e.getException() instanceof PSQLException) {
				// -- Some queries (Create table) do not generate
				// ResultSets...this is probably one of those cases
			}
		}
		return -13; // this cannot by normally reached => indicates an error

	}
}
