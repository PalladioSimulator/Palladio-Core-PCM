package de.uka.ipd.sdq.reliability.solver.reporting;

import java.util.ArrayList;
import java.util.List;

public class MarkovReportingTable {

	private String tableName;

	private List<String> headerRow;
	
	private List<List<String>> rows;

	public MarkovReportingTable(String tableName) {
		this.tableName = tableName;
		headerRow = new ArrayList<String>();
		rows = new ArrayList<List<String>>();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getHeaderRow() {
		return headerRow;
	}

	public void setHeaderRow(List<String> headerRow) {
		this.headerRow = headerRow;
	}
	
	public List<List<String>> getRows() {
		return rows;
	}
	
	public void addRow(List<String> row) {
		rows.add(row);
	}

}
