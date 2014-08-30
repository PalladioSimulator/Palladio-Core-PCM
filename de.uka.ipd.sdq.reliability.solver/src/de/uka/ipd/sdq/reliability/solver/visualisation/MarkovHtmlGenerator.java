package de.uka.ipd.sdq.reliability.solver.visualisation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReportItem;
import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReporting;
import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReportingTable;

/**
 * Class that is responsible for generating HTML code from a given MarkovReporting instance.
 * 
 * @author Daniel Patejdl
 * 
 */
public class MarkovHtmlGenerator {
    /**
     * A MarkovReporting instance; serves as central data source of this class.
     */
    private List<MarkovReportItem> markovReportItems;

    /**
     * Generates a new instance that is responsible for creating a HTML page, given a
     * MarkovReporting instance as data source.
     * 
     * @param markovReporting
     *            a MarkovReporting instance
     */
    public MarkovHtmlGenerator(MarkovReporting markovReporting) {
        this.markovReportItems = markovReporting.getMarkovReportItems();
    }

    /**
     * Creates and returns a String containing HTML code. The HTML code reflects the Markov
     * transformation results. All transformation results are represented as HTML tables.
     * 
     * @return a String containing HTML code
     */
    public String getHtml() {
        // Retrieve CSS and JavaScript source code for later use in HTML page:
        String cssCode = "";
        String jsCode = "";
        try {
            cssCode = getInputStreamContents(this.getClass().getResourceAsStream("/jsComponents.css"));
            jsCode = getInputStreamContents(this.getClass().getResourceAsStream("/jsComponents.js"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // create HTML page header
        StringBuilder htmlCode = new StringBuilder("<html><head>" + "<title>Markov Results</title>"
                + "<script type=\"text/javascript\">" + jsCode + "</script>" + "<style type=\"text/css\">" + cssCode
                + "		body { font-family: Lucida Grande, Arial, Tahoma, Verdana; font-size: 12px; }"
                + "		td, th { font-size: 11px; }"
                + "		th { background-color: c0c0c0; margin: 1px; padding: 3px 5px 3px 5px; border: 1px solid black; }"
                + "		td { background-color: dfdfdf; margin: 1px; padding: 3px 5px 3px 5px; }" + "</style>"
                + "</head><body>");
        for (MarkovReportItem item : markovReportItems) {
            htmlCode.append("<h2>Reliability results for UsageScenario: <font color=\"#606060\">"
                    + item.getScenarioName() + "</font></h2>");
            htmlCode.append("Scenario ID: <font color=\"#606060\">" + item.getScenarioId() + "</font><br />");
            htmlCode.append("Success probability: <font color=\"#606060\">" + item.getSuccessProbabilityString()
                    + "</font><br />");
            // create tables: failure mode tables first, then impact analysis
            // tables
            if (item.getFailureModeTables().size() != 0) {
                // draw horizontal separation line
                htmlCode.append("<hr />");
                htmlCode.append("<h3>Failure Mode Analysis</h3>");
            }
            for (MarkovReportingTable table : item.getFailureModeTables()) {
                if (table.getRows().size() == 0) {
                    continue; // table contains no rows, thus consider next
                    // table in list
                }
                htmlCode.append("<div class=\"JSTableStripe\"><div class=\"JSTableSort\">");
                htmlCode.append("<b>" + table.getTableName() + ":</b><br />");
                htmlCode.append("<table border=\"0\" style=\"margin-top: 1mm; border: 1px solid black;\">");
                // create header row
                htmlCode.append("<thead><tr>");
                for (String headerEntry : table.getHeaderRow()) {
                    htmlCode.append("<th class=\"SortString\" onselectstart=\"return false;\">" + headerEntry + "</th>");
                }
                htmlCode.append("</tr></thead><tbody>");
                // create table data rows
                for (List<String> row : table.getRows()) {
                    htmlCode.append("<tr>");
                    for (String entry : row) {
                        htmlCode.append("<td>" + entry + "</td>");
                    }
                    htmlCode.append("</tr>");
                }
                // finish table HTML code
                htmlCode.append("</tbody></table>");
                htmlCode.append("</div></div><br />");
            }
            if (item.getImpactAnalysisTables().size() != 0) {
                // draw horizontal separation line
                htmlCode.append("<hr />");
                // now, consider impact analysis tables
                htmlCode.append("<h3>Impact Analysis</h3>");
                for (MarkovReportingTable table : item.getImpactAnalysisTables()) {
                    if (table.getRows().size() == 0) {
                        continue; // table contains no rows, thus consider next
                        // table in list
                    }
                    htmlCode.append("<div class=\"JSTableStripe\"><div class=\"JSTableSort\">");
                    htmlCode.append("<b>" + table.getTableName() + ":</b><br />");
                    htmlCode.append("<table border=\"0\" style=\"margin-top: 1mm; border: 1px solid black;\">");
                    // create header row
                    htmlCode.append("<thead><tr>");
                    for (String headerEntry : table.getHeaderRow()) {
                        htmlCode.append("<th class=\"SortString\" onselectstart=\"return false;\">" + headerEntry
                                + "</th>");
                    }
                    htmlCode.append("</tr></thead><tbody>");
                    // create table data rows
                    for (List<String> row : table.getRows()) {
                        htmlCode.append("<tr>");
                        for (String entry : row) {
                            htmlCode.append("<td>" + entry + "</td>");
                        }
                        htmlCode.append("</tr>");
                    }
                    // finish table HTML code
                    htmlCode.append("</tbody></table>");
                    htmlCode.append("</div></div><br />");
                }
            }
            // draw horizontal separation lines
            htmlCode.append("<hr>");
            htmlCode.append("<hr>");
        }

        // finish page
        htmlCode.append("</body></html>");
        return htmlCode.toString();
    }

    /**
     * Retrieves the contents of an InputStream as a String.
     * 
     * @param is
     *            the InputStream
     * @return the resulting String
     * @throws IOException
     */
    private String getInputStreamContents(final InputStream is) throws IOException {
        if (is != null) {
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }
}
