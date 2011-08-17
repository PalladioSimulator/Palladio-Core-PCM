package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views;

import java.util.ArrayList;
import java.util.Collection;


import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.RReport;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;

/**Abstract class with basic capabilities to show reports containing 
 * data of the SensorFramework in R.
 * @author groenda
 */
public abstract class AbstractHtmlRReportView extends AbstractHtmlReportView 
		implements IVisualisation < SensorAndMeasurements > {

	/**Delegates the creation to the ancestor and does nothing else.
	 */
	public AbstractHtmlRReportView() {
		super();
	}
	
	/**Used to ask for the report that should be displayed.
	 * @return The report that should be displayed by this view.
	 */
	abstract public RReport getReport();
	
	/** {@inheritDoc}
	 */
	public void setInput(final Collection < SensorAndMeasurements > c) {
		if (RConnection.isEngineAvailable()) {
			if (c.isEmpty()) {
				browser.setText("<html><body><h1>Error! </h1>At least "
						+ "the measurements for one sensor must be "
						+ "available!</body></html>");
			} else {
				if (getReport() == null) {
					browser.setText("<html><body><h1>Error!</h1> There "
							+ "is no report associated with this view. "
							+ "Ask the developer to correct this error. "
							+ "</body></html>");
				} else {
					RConnection rConnection = RConnection.getRConnection();
					ArrayList<IReportItem> items = 
						getReport().prepareReportItems(c, rConnection);
		
					HTMLVisitor visitor = new HTMLVisitor();
					for (IReportItem item : items) {
						item.generateData(rConnection);
						item.visit(visitor);
					}
					browser.setText(visitor.getHTML());
				}
			}
		} else {
			browser.setText("<html><body><h1>Error! </h1>Connection to R "
					+ "engine is not available!</body></html>");
		}
	}
}
