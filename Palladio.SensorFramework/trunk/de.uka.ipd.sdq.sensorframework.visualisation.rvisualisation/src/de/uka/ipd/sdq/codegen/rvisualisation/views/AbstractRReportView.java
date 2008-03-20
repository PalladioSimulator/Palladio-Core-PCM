package de.uka.ipd.sdq.codegen.rvisualisation.views;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.codegen.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.visitor.HTMLVisitor;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;

/**Abstract class with basic capabilities to show reports containing data of the sensorframework in R.
 * @author groenda
 */
public abstract class AbstractRReportView extends AbstractReportView implements
		IVisualisation<SensorAndMeasurements> {

	private Browser browser;

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView#createReportControls(org.eclipse.swt.widgets.Composite)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void createReportControls(Composite parent) {
		browser = new Browser(parent, SWT.BORDER);
		setInput(Collections.EMPTY_LIST);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		browser.setFocus();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#addInput(java.util.Collection)
	 */
	public void addInput(Collection<SensorAndMeasurements> c) {
		// The implementation is not necessary.
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#deleteInput(java.util.Collection)
	 */
	public void deleteInput(Collection<SensorAndMeasurements> c) {
		// The implementation is not necessary.
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#setInput(java.util.Collection)
	 */
	public void setInput(Collection<SensorAndMeasurements> c) {
		if (RConnection.isEngineAvailable()) {
			if (c.isEmpty()){
				browser.setText("<html><body><h1>Error! </h1>At least the measurements for one sensor must be available!</body></html>");
			} else {
				RConnection rConnection = RConnection.getRConnection();
				ArrayList<IReportItem> items = prepareReportItems(c, rConnection);
	
				HTMLVisitor visitor = new HTMLVisitor();
				for (IReportItem item : items) {
					item.generateData(rConnection);
					item.visit(visitor);
				}
				browser.setText(visitor.getHTML());
			}
		} else {
			browser.setText("<html><body><h1>Error! </h1>Connection to R engine is not available!</body></html>");
		}
	}

	/**Export the measurements of a sensor to R. Therefore a temporary file is created and 
	 * the R command line to import this data is returned.
	 * @param measurements Measurements for a sensor.
	 * @param sensorNumber number of the sensor vector in R.
	 * @return R command to read measurements. It is stored in the vector <code>sensor<code>i.
	 */
	protected String storeMeasurementsInRVector(SensorAndMeasurements measurements, int sensorNumber) {
		String rCommand = exportMeasurementsToR(measurements);
		if (rCommand == "")
			return "";
		else
			return "sensor" + sensorNumber + "<-" + rCommand;
	}

	/**Export the measurements of a sensor to R. Therefore a temporary file is created and 
	 * the R command line to import this data is returned.
	 * @param measurements Measurements for a sensor.
	 * @return R command to read measurements. Can be used to store data in a r vector.
	 */
	public String exportMeasurementsToR(SensorAndMeasurements measurements) {
		File temporaryFile;
		try {
			temporaryFile = File.createTempFile("data", ".txt");
			temporaryFile.deleteOnExit();
			FileWriter temporaryFileWriter = new FileWriter(temporaryFile);
			StringBuffer result = new StringBuffer();
			for (Measurement time : measurements.getMeasurements()) {
				TimeSpanMeasurement tsm = (TimeSpanMeasurement) time;
				result.append(String.valueOf(tsm.getTimeSpan()).replace('.', ','));
				//result.append(tsm.getTimeSpan());
				result.append(" ");
			}
			temporaryFileWriter.write(result.toString());
			temporaryFileWriter.close();
			return "scan(file=\"" + temporaryFile.getAbsolutePath().replace(File.separator, "\\\\")
					+ "\""; //, dec=\",\")
		} catch (IOException e) {
			RVisualisationPlugin.log(IStatus.ERROR,
					"Error accessing temporary file to transfer sensordata to R. Details: "
							+ e.getMessage());
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView#setInput(java.util.List)
	 */
	@Override
	protected void setInput(List<IAdapter> list) {
		ArrayList<SensorAndMeasurements> viewerInput = new ArrayList<SensorAndMeasurements>();
		for (IAdapter a : list) {
			viewerInput.add((SensorAndMeasurements) a.getAdaptedObject());
		}
		this.setInput(viewerInput);
	}

	/**
	 * Template method for subclasses to implement. Subclasses can create
	 * IReportItems from the given SensorAndMeasurements. They can use the
	 * getRVector(SensorAndMeasurements, int) method to write files to a
	 * temporary file and create an R command that reads in the sensor data.
	 * This command needs to be
	 * 
	 * @param c
	 * @param t
	 * @return
	 */
	abstract protected ArrayList<IReportItem> prepareReportItems(
			Collection<SensorAndMeasurements> c, RConnection t);

}
