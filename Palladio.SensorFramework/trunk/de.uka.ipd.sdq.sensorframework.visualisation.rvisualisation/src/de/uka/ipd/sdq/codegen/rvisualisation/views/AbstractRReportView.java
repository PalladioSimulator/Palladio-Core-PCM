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
import de.uka.ipd.sdq.codegen.rvisualisation.actions.RInterface;
import de.uka.ipd.sdq.codegen.rvisualisation.reportitems.IReportItem;
import de.uka.ipd.sdq.codegen.rvisualisation.visitor.HTMLVisitor;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;

public abstract class AbstractRReportView extends AbstractReportView implements
		IVisualisation<SensorAndMeasurements> {

	private Browser browser;

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView#createReportControls(org.eclipse.swt.widgets.Composite)
	 */
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
		RInterface t = new RInterface();
		if (RInterface.isEngineAvailable()) {
			ArrayList<IReportItem> items = prepareReportItems(c, t);

			HTMLVisitor visitor = new HTMLVisitor();
			for (IReportItem item : items) {
//				System.out.println("Exec command");
				item.executeRCommands(t);
//				System.out.println("Render");
				item.visit(visitor);
			}
			browser.setText(visitor.getHTML());
		} else {
			browser
					.setText("<html><body><h1>Error! R-Engine unavailable!</h1></body></html>");
		}
	}

	protected String getRVector(SensorAndMeasurements sm, int i) {
		File temp;
		try {
			temp = File.createTempFile("data", ".txt");
			temp.deleteOnExit();
			FileWriter fw = new FileWriter(temp);
			StringBuffer result = new StringBuffer();
			for (Measurement time : sm.getMeasurements()) {
				TimeSpanMeasurement tsm = (TimeSpanMeasurement) time;
				result.append(tsm.getTimeSpan());
				result.append(" ");
			}
			fw.write(result.toString());
			fw.close();
			return "sensor" + i + "<-scan(\""
					+ temp.getAbsolutePath().replace(File.separator, "\\\\")
					+ "\")";
		} catch (IOException e) {
			RVisualisationPlugin.log(IStatus.ERROR,
					"Failed to transfer sensordata to R. Details: "
							+ e.getMessage());
		}
		return null;
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
			Collection<SensorAndMeasurements> c, RInterface t);

}
