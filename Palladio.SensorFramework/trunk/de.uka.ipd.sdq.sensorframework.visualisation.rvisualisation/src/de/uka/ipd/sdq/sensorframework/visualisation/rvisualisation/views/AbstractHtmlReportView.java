package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.sensorframework.adapter.DataAdapter;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reports.RReport;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;

/**Abstract class with basic capabilities to show reports containing 
 * data of the SensorFramework in R.
 * @author groenda
 */
public abstract class AbstractHtmlReportView extends AbstractReportView 
		implements IVisualisation < SensorAndMeasurements > {

	/**Delegates the creation to the ancestor and does nothing else.
	 */
	public AbstractHtmlReportView() {
		super();
	}
	
	/**Reference to the browser window in which the report is displayed. */
	private Browser browser;

	/**Used to ask for the report that should be displayed.
	 * @return The report that should be displayed by this view.
	 */
	abstract public RReport getReport();
	
	/** {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void createReportControls(final Composite parent) {
		browser = new Browser(parent, SWT.BORDER);
		setInput(Collections.EMPTY_LIST);
	}

	/** {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		browser.setFocus();
	}

	/** {@inheritDoc}
	 */
	public void addInput(final Collection < SensorAndMeasurements > c) {
		// The implementation is not necessary.
	}

	/** {@inheritDoc}
	 */
	public void deleteInput(final Collection < SensorAndMeasurements > c) {
		// The implementation is not necessary.
	}

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

	/** {@inheritDoc}
	 */
	@Override
	protected void generateVisualization(final List < DataAdapter > list) {
		ArrayList<SensorAndMeasurements> viewerInput = 
			new ArrayList<SensorAndMeasurements>();
		for (DataAdapter a : list) {
			viewerInput.add((SensorAndMeasurements) a.getAdaptedObject());
		}
		this.setInput(viewerInput);
	}
}
