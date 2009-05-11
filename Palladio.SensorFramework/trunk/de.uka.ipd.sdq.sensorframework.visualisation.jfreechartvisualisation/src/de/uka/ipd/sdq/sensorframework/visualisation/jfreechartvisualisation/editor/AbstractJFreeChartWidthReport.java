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
import de.uka.ipd.sdq.sensorframework.adapter.DataAdapter;
import de.uka.ipd.sdq.sensorframework.adapter.TimeSpanToHistogramAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.AbstractJFreeChartWidthViewer;

/**Report for Histograms.
 * Provides the basic possibilities to generate histograms and change their classes width.
 * @author groenda
 */
public abstract class AbstractJFreeChartWidthReport extends AbstractReportView implements IVisualisation<Histogram>{

	AbstractJFreeChartWidthViewer viewer;
	protected Text widthInput;
	protected double histogramWidth = Double.NaN;
	private List<DataAdapter> adapterList = null;
	
	public AbstractJFreeChartWidthReport() {
		super();
	}
	
	protected abstract AbstractJFreeChartWidthViewer createViewer(Composite parent, int flags);

	/** {@inheritDoc}
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
						updateHistogramWidth(Double.parseDouble(widthInput
							.getText()));
					break;
				case SWT.FocusOut:
					updateHistogramWidth(Double.parseDouble(widthInput
							.getText()));
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

	/**Updates the histogram width after a change on the gui.
	 * @param newWidth The new width to set.
	 */
	private void updateHistogramWidth(double newWidth) {
		this.histogramWidth = newWidth;

		setIgnoreDataSettingsChanged(true);
		// Set new histogram width on all adapters of this report
		for (DataAdapter adapter : adapterList) {
			Properties adapterProperties = adapter.getProperties();
			adapterProperties.put(TimeSpanToHistogramAdapter.HISTOGRAM_WIDTH, 
					histogramWidth);
			adapter.setProperties(adapterProperties);
		}
		setIgnoreDataSettingsChanged(false);
		generateVisualization(adapterList);
	}
	
	/** {@inheritDoc}
	 */
	public void setInput(Collection<Histogram> histograms) {
		viewer.setData(histograms);
		this.widthInput.setText(""+histogramWidth);
	}

	/** {@inheritDoc}
	 */
	@Override
	protected void generateVisualization(List<DataAdapter> newList) {
		if (newList == null || newList.isEmpty())
			throw new RuntimeException("Histogram reports must have at least one data input.");
		Properties adapterProperties = null;
		// Determine width of "old" histogram, if existing
		double newWidth = Double.NaN;
		if (adapterList != null && adapterList.isEmpty() == false) {
			DataAdapter adapter = adapterList.get(0);
			adapterProperties = adapter.getProperties();
			Double test = (Double) adapterProperties.get(TimeSpanToHistogramAdapter.HISTOGRAM_WIDTH); 
			newWidth = test;
		} else {
			// this is the first data added
			DataAdapter adapter = newList.get(0);
			adapterProperties = adapter.getProperties();
			newWidth = (Double) adapterProperties.get(TimeSpanToHistogramAdapter.HISTOGRAM_WIDTH);
		}
		
		boolean allSameWidth = isSameWidth(newList);
		
		/* Set all histograms to the same histogram width and add histograms
		 * to the current view.
		 */
		ArrayList<Histogram> newHistogramList = new ArrayList<Histogram>();
		for (DataAdapter adapter : newList) {
			if (!allSameWidth) {
				adapterProperties = adapter.getProperties();
				adapterProperties.put(TimeSpanToHistogramAdapter.HISTOGRAM_WIDTH, newWidth);
				// Note: The property change will notify all listeners, so be careful
				adapter.setProperties(adapterProperties);
			}
			newHistogramList.add((Histogram) adapter.getAdaptedObject());
		}
		histogramWidth = newWidth; // set view-local cached version to new value
		adapterList = newList;

		this.setInput(newHistogramList);
	}

	/**Checks if the adapters all have the same histogram width.
	 * @param adapterList The list of adapters to check.
	 * @return <code>true</code> if all have the same width.
	 */
	private boolean isSameWidth(List<DataAdapter> adapterList) {
		Properties adapterProperties;
		boolean allSameWidth = true;
		double width = Double.NaN;
		double currentWidth = Double.NaN;
		for (DataAdapter adapter : adapterList) {
			adapterProperties = adapter.getProperties();
			currentWidth = (Double) adapterProperties.get(TimeSpanToHistogramAdapter.HISTOGRAM_WIDTH);
			if (Double.isNaN(width)) {
				width = currentWidth;
			}
			if (width != currentWidth) {
				allSameWidth = false;
			}
		}
		return allSameWidth;
	}


	/** {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		viewer.setFocus();
	}

	/** {@inheritDoc}
	 */
	public void addInput(Collection<Histogram> c) {
		// The implementation is not necessary.
	}
	
	/** {@inheritDoc}
	 */
	public void deleteInput(Collection<Histogram> c) {
		// The implementation is not necessary.
	}
}