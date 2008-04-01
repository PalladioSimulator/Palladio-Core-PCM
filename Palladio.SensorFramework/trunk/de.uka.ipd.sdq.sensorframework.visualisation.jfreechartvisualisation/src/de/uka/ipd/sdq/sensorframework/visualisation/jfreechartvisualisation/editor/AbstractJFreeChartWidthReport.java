package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEntry;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.AbstractJFreeChartWidthViewer;

public abstract class AbstractJFreeChartWidthReport extends AbstractReportView implements IVisualisation<Histogram>{

	AbstractJFreeChartWidthViewer viewer;
	protected Text widthInput;
	protected double histogramWidth = 1.0;
	public static final String HISTOGRAM_WIDTH = "HISTOGRAM_WIDTH";
	
	public AbstractJFreeChartWidthReport() {
		super();
	}
	
	protected abstract AbstractJFreeChartWidthViewer createViewer(Composite parent, int flags);

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView#createReportControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createReportControls(Composite parent) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		parent.setLayout(gridLayout);
		Composite histogramWidthPanel = new Composite(parent, SWT.NONE);
		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		histogramWidthPanel.setLayoutData(data);
		RowLayout rowLayout = new RowLayout();
		rowLayout.wrap = false;
		rowLayout.pack = true;
		histogramWidthPanel.setLayout(rowLayout);
		Label label = new Label(histogramWidthPanel, SWT.CENTER);
		label.setText("Sampling Rate");
		label.setLayoutData(new RowData(SWT.DEFAULT, SWT.DEFAULT));
		widthInput = new Text(histogramWidthPanel, SWT.BORDER);
		widthInput.setText(Double.toString(histogramWidth));
		widthInput.setLayoutData(new RowData(60, SWT.DEFAULT));
		Listener listener = new Listener() {

			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.KeyDown:
					if (event.character == SWT.CR)
						setHistogramWidth(Double.parseDouble(widthInput
								.getText()));
					break;
				case SWT.FocusOut:
					setHistogramWidth(Double.parseDouble(widthInput.getText()));
					break;
				}
			}

		};
		widthInput.addListener(SWT.KeyDown, listener);
		widthInput.addListener(SWT.FocusOut, listener);

		viewer = createViewer(parent, SWT.NONE);
		GridData data2 = new GridData();
		data2.grabExcessHorizontalSpace = true;
		data2.grabExcessVerticalSpace = true;
		data2.verticalAlignment = GridData.FILL;
		data2.horizontalAlignment = GridData.FILL;
		viewer.setLayoutData(data2);
		histogramWidthPanel.setLayoutData(data);
	}

	private void setHistogramWidth(double newWidth) {
		this.histogramWidth = newWidth;
		((ConfigEditorInput)getEditorInput()).notifyObserver();
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#setInput(java.util.Collection)
	 */
	public void setInput(Collection<Histogram> c) {
		viewer.setData(c);
		this.widthInput.setText(""+histogramWidth);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView#setInput(java.util.List)
	 */
	@Override
	protected void setInput(List<IAdapter> list) {
		ArrayList<Histogram> viewerInput = new ArrayList<Histogram>();
		for (IAdapter a : list) {
			Properties p = a.getProperties();
			if (p == null)
				p = new Properties();
			// Check if there are at least to different buckets for the histogram
			// as JFreeChart otherwise displays a bar from -0.5 to 0.5 and small 
			// values cannot be restored, as the range is fixed by then.
			if (((Histogram) a.getAdaptedObject()).getEntityList().size() == 1) {
				TimeSpanMeasurement timeSpanMeasurement = null;
				double minValue = Double.MAX_VALUE, maxValue = Double.MIN_VALUE;
				List<ConfigEntry> entries = ((ConfigEditorInput)getEditorInput()).getConfigEntrys();
				for (ConfigEntry entry : entries) {
//					IDAOFactory sdjklf = entry.getDatasource();
					ExperimentRun experimentRun = entry.getExperimentRun();
					List<Sensor> sensors = entry.getSensors();
					for (Sensor sensor : sensors) {
						SensorAndMeasurements sam = experimentRun.getMeasurementsOfSensor(sensor);
						Collection<Measurement> measurements = sam.getMeasurements();
						for (Measurement measurement : measurements) {
							timeSpanMeasurement = (TimeSpanMeasurement) measurement;
							minValue = (minValue < timeSpanMeasurement.getTimeSpan()) ? minValue : timeSpanMeasurement.getTimeSpan();  
							maxValue = (maxValue > timeSpanMeasurement.getTimeSpan()) ? maxValue : timeSpanMeasurement.getTimeSpan();  
						}
					}
				}
				histogramWidth = (maxValue-minValue)/2;
			}
			p.put(HISTOGRAM_WIDTH, histogramWidth);
			a.setProperties(p);
			viewerInput.add((Histogram) a.getAdaptedObject());
		}
		this.setInput(viewerInput);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.setFocus();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#addInput(java.util.Collection)
	 */
	public void addInput(Collection<Histogram> c) {
		// The implementation is not necessary.
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#deleteInput(java.util.Collection)
	 */
	public void deleteInput(Collection<Histogram> c) {
		// The implementation is not necessary.
	}
}