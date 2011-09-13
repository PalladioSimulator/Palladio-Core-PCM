package de.uka.ipd.sdq.reliability.solver.reporting;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates abstract tables (consisting of rows and columns).
 * 
 * @author Daniel Patejdl
 *
 */
public class MarkovReportTableItem extends MarkovReportItem {
	
	/**
	 * Each table has a general header ("table name").
	 */
	private List<String> tableNames;
	
	/**
	 * Each table has its own header (header row / column names).
	 */
	private List<List<String>> headerRows;
	
	/**
	 * Each table has its own data, according to the structure of the header rows.
	 */
	// List<String>: a row
	// List<row>: a table
	// List<table>: several tables
	private List<List<List<String>>> tables;	// TODO kapseln! "MarkovReportingTable"
	
	public MarkovReportTableItem(String scenarioName, String scenarioId, double successProbability) {
		super(scenarioName, scenarioId, successProbability);
		tableNames = new ArrayList<String>();
		headerRows = new ArrayList<List<String>>();
		tables = new ArrayList<List<List<String>>>();
	}
	
	/**
	 * Adds a name for a new table.
	 * @param tableName the table's name
	 */
	public void addTableName(String tableName) {
		tableNames.add(tableName);
	}
	
	/**
	 * Gets all table names.
	 * @return the table names
	 */
	public List<String> getTableNames() {
		return tableNames;
	}
	
	/**
	 * Adds a header row for a new table.
	 * @param headerRow the header's row
	 */
	public void addHeaderRow(List<String> headerRow) {
		headerRows.add(headerRow);
	}
	
	/**
	 * Gets all header rows.
	 * @return the header rows
	 */
	public List<List<String>> getHeaderRows() {
		return headerRows;
	}
	
	/**
	 * Adds a table to the list of tables.
	 * @param table the table
	 */
	public void addTable(List<List<String>> table){
		tables.add(table);
	}
	
	/**
	 * Returns all tables in the list.
	 * @return all tables
	 */
	public List<List<List<String>>> getTables() {
		return tables;
	}
}
