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
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;

/**Abstract class with basic capabilities to show reports containing 
 * data of the SensorFramework in R.
 * @author groenda
 */
public abstract class AbstractRReportView extends AbstractReportView implements
	IVisualisation < SensorAndMeasurements > {

	/**Reference to the browser window in which the report is displayed.
	 */
	private Browser browser;

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
				RConnection rConnection = RConnection.getRConnection();
				ArrayList<IReportItem> items = 
					prepareReportItems(c, rConnection);
	
				HTMLVisitor visitor = new HTMLVisitor();
				for (IReportItem item : items) {
					item.generateData(rConnection);
					item.visit(visitor);
				}
				browser.setText(visitor.getHTML());
			}
		} else {
			browser.setText("<html><body><h1>Error! </h1>Connection to R "
					+ "engine is not available!</body></html>");
		}
	}

	/**Export the measurements of a sensor to R. 
	 * There are two alternatives. Normally, the measurements are transferred 
	 * via an array, which has certain size restrictions. An Alternative is 
	 * to use a temporary file and use the R command line to import this data 
	 * is returned. The behavior can only be switched in source code.
	 * 
	 * @param measurements Measurements for a sensor.
	 * @param sensorNumber number of the sensor vector in R.
	 * @return R command to read measurements. 
	 *         It is stored in the vector <code>sensor</code>i.
	 */
	protected String storeMeasurementsInRVector(
			final SensorAndMeasurements measurements, final int sensorNumber) {
		String rCommand = exportMeasurementsToR(measurements);
		if (rCommand == "") {
			return "";
		} else {
//			// activate to use file transfer. only possible in plug-in debug 
//			// mode of eclipse.
//			return "sensor" + sensorNumber + "<-" + rCommand + "\n";
			RConnection.getRConnection().assign(
					"sensor" + sensorNumber, measurementsArray);
			return "";
		}
	}
	
	/**represents an array in which all measurements for a sensor are stored.
	 * Used to transfer data to R.
	 */
	private double[] measurementsArray;

	/**Export the measurements of a sensor to R. Therefore a temporary 
	 * file is created and the R command line to import this data is 
	 * returned. Additionally an array is filled with the measurements 
	 * that can be used by other methods in this class.
	 * 
	 * @param measurements Measurements for a sensor.
	 * @return R command to read measurements. 
	 *         Can be used to store data in a r vector.
	 */
	protected String exportMeasurementsToR(
			final SensorAndMeasurements measurements) {
		File temporaryFile;
		try {
			temporaryFile = File.createTempFile("data", ".txt");
			temporaryFile.deleteOnExit();
			FileWriter temporaryFileWriter = new FileWriter(temporaryFile);
			StringBuffer result = new StringBuffer();
			measurementsArray = 
				new double[measurements.getMeasurements().size()];
			if (measurements.getMeasurements().size() == Integer.MAX_VALUE) {
				RVisualisationPlugin.log(IStatus.ERROR,
						"Too much measurements. Results might be inaccurate.");
			}
			int position = 0;
			
			for (Measurement time : measurements.getMeasurements()) {
				TimeSpanMeasurement tsm = (TimeSpanMeasurement) time;
				result.append(tsm.getTimeSpan());
				result.append(" ");
				measurementsArray[position++] = tsm.getTimeSpan();
			}
			temporaryFileWriter.write(result.toString());
			temporaryFileWriter.close();
			return "scan(file=\"" 
				+ temporaryFile.getAbsolutePath().replace(File.separator, 
						"\\\\")
				+ "\", dec=\".\")";
		} catch (IOException e) {
			RVisualisationPlugin.log(IStatus.ERROR,
				"Error accessing temporary file to transfer sensordata "
				+ "to R. Details: "	+ e.getMessage());
		}
		return "";
	}


	/** {@inheritDoc}
	 */
	@Override
	protected void setInput(final List < DataAdapter > list) {
		ArrayList<SensorAndMeasurements> viewerInput = 
			new ArrayList<SensorAndMeasurements>();
		for (DataAdapter a : list) {
			viewerInput.add((SensorAndMeasurements) a.getAdaptedObject());
		}
		this.setInput(viewerInput);
	}

	/**Template method for subclasses to implement. Subclasses can create
	 * IReportItems from the given <code>SensorAndMeasurements</code>. They 
	 * can use the <code>getRVector(SensorAndMeasurements, int)</code> 
	 * method to write files to a temporary file and create an R command 
	 * that reads in the sensor data.
	 * 
	 * @param measurements List of the measurements for a sensor.
	 * @param rConnection connection to the R engine.
	 * @return List of Items.
	 */
	protected abstract ArrayList<IReportItem> prepareReportItems(
			Collection<SensorAndMeasurements> measurements, 
			RConnection rConnection);

}
