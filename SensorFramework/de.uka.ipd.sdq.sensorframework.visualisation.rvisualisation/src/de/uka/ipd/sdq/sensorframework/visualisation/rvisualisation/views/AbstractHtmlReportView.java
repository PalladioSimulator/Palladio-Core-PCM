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

public abstract class AbstractHtmlReportView extends AbstractReportView implements IVisualisation < SensorAndMeasurements >{

	/**Reference to the browser window in which the report is displayed. */
	protected Browser browser;

	public AbstractHtmlReportView() {
		super();
	}

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