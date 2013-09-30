package de.uka.ipd.sdq.reliability.solver.reporting;

import java.util.ArrayList;
import java.util.List;

public class MarkovReportingTable {

    private List<String> headerRow;

    private List<List<String>> rows;

    private String tableName;

    public MarkovReportingTable(String tableName) {
        this.tableName = tableName;
        headerRow = new ArrayList<String>();
        rows = new ArrayList<List<String>>();
    }

    public void addRow(List<String> row) {
        rows.add(row);
    }

    public List<String> getHeaderRow() {
        return headerRow;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public String getTableName() {
        return tableName;
    }

    public void setHeaderRow(List<String> headerRow) {
        this.headerRow = headerRow;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

}
