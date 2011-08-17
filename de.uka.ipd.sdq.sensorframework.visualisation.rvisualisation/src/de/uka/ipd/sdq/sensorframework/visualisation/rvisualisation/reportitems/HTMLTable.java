package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;


/**
 * This class prints its input as a HTMLTable into Eclipse.
 * @author toms
 *
 */
public class HTMLTable extends StaticTextReportItem{

	private StringBuffer buf = new StringBuffer();
	private int runs;
	private int failures;
	
	public HTMLTable() {
		buf.append("<table border = \"1\"> \n");
		buf.append("<tr> <td> ID </td>");
		buf.append("<td> Literal </td> \n");
		buf.append("<td> Count </td> \n");
		buf.append("<td> relative Fehlerhäufigkeit </td> \n");
		buf.append("<td> gesamte Fehlerhäufigkeit </td> </tr> \n");
	}

	public String getText() {
		buf.append("</table> \n");
		String text = buf.toString();
		return text;
	}

	public void addRow(int id, String literal, int count) {
		buf.append("<tr> \n");
		buf.append("<td>" + id + "</td>" );
		buf.append("<td>" + literal + "</td>" );
		buf.append("<td>" + count + "</td>" );
		buf.append("<td>" + ((float) count/(float) failures)*100 + " % </td>" );
		buf.append("<td>" + ((float) count/ (float) runs)*100 + " % </td>" );
		buf.append("</tr> \n");
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getFailures() {
		return failures;
	}

	public void setFaults(int faults) {
		this.failures = faults;
	}
	
	
}
