package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.rosuda.JRI.REXP;

import de.uka.ipd.sdq.codegen.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection;

/**Report item used to display statistical values. The last result 
 * returned from R is considered to be the value of interest.
 * @author groenda (comments, refactoring)
 */
public class StatisticsReportItem implements IReportItem {

	private REXP statisticalValue;
	private String rCommands;
	private String contentDescription;

	/**Initializes a new report item.
	 * @param rCommands R commands that lead to the calculation of the statistical value.
	 * @param description Description of this report item.
	 */
	public StatisticsReportItem(String rCommands, String description){
		this.rCommands = rCommands;
		this.contentDescription = description;
	}
	
	/**
	 * @return the statistical value.
	 */
	public String getResult() {
		if (statisticalValue.rtype == REXP.INTSXP)
			return "" + statisticalValue.asInt();
		else if (statisticalValue.rtype == REXP.REALSXP)
			return "" + statisticalValue.asDouble();
		else if (statisticalValue.rtype == REXP.STRSXP)
			return "" + statisticalValue.asString();
		else
			return "N/A";
	}
	

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem#getDescription()
	 */
	public String getDescription(){
		return contentDescription;
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem#visit(de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportRenderingVisitor)
	 */
	public void visit(IReportRenderingVisitor renderingVisitor) {
		renderingVisitor.visitStatisticsItem(this);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem#executeRCommands(de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection)
	 */
	public void generateData(RConnection rConnection) {
		Vector<REXP> result = rConnection.execute(rCommands);
		if (!result.isEmpty())
			statisticalValue = result.lastElement();
		else
			RVisualisationPlugin.log(
					IStatus.WARNING,
					"The calculation of the statistic report item \"" + contentDescription + "\" yield to no result. " +
					"Most probably data import or the calculation in R went wrong. " +
					"Details: lastConsoleMessage=" + rConnection.getLastConsoleMessage());			
	}

}
