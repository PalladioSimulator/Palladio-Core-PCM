package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.rosuda.JRI.REXP;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;

/**Report item used to display statistical values. The last result 
 * returned from R is considered to be the value of interest.
 * @author groenda (comments, refactoring)
 */
public class RCommandRReportItem extends AbstractGeneratedTextRReportItem {

	/** The value returned from R after executing the provided command. */
	protected REXP returnedValue = new REXP();
	/** The R command which execution yields to the required value. */
	protected String rCommands;

	/**Initializes a new report item.
	 * @param rCommands R commands that lead to the calculation of the 
	 *        statistical value.
	 * @param description Description of this report item.
	 */
	public RCommandRReportItem(final String rCommands, 
			final String description) {
		super(description);
		this.rCommands = rCommands;
	}
	
	/** {@inheritDoc}
	 */
	@Override
	public String getText() {
		System.out.println("Type: " + returnedValue.rtype);
		// Returns the saved value
		if (returnedValue.rtype == REXP.INTSXP) {
			return "" + returnedValue.asInt();
		} else if (returnedValue.rtype == REXP.REALSXP) {
			return "" + returnedValue.asDouble();
		} else if (returnedValue.rtype == REXP.STRSXP) {
			return "" + returnedValue.asString();
		} else {
			return "N/A";
		}
	}
	
	/** {@inheritDoc}
	 */
	@Override
	public void visit(final IReportRenderingVisitor renderingVisitor) {
		renderingVisitor.visitGeneratedTextReportItem(this);
	}


	/** {@inheritDoc}
	 */
	@Override
	public void generateData(final RConnection rConnection) {
		Vector<REXP> result = rConnection.execute(rCommands);
		if (!result.isEmpty()) {
			returnedValue = result.lastElement();
		} else {
			returnedValue = new REXP();
			RVisualisationPlugin.log(
					IStatus.WARNING,
					"The calculation of the R command report item \"" 
					+ getDescription() + "\" yield to no result. "
					+ "Most probably data import or the calculation in R "
					+ "went wrong. Details: lastConsoleMessage=" 
					+ rConnection.getLastConsoleMessage());
		}
	}
}
