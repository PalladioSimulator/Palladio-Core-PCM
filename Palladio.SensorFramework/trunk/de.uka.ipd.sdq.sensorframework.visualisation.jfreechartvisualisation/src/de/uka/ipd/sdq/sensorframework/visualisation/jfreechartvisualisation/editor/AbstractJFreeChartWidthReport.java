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
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.adapter.TimeSpanToHistogramAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;
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

		// Set new histogram width on all adapters of this report
		for (DataAdapter adapter : adapterList) {
			Properties adapterProperties = adapter.getProperties();
			adapterProperties.put(TimeSpanToHistogramAdapter.HISTOGRAM_WIDTH, 
					histogramWidth);
			adapter.setProperties(adapterProperties);
		}
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
	protected void setInput(List<DataAdapter> list) {
		adapterList = list; 
		ArrayList<Histogram> histogramList = new ArrayList<Histogram>();
		// Determine minimal histogram width for all histograms
		double minimalWidth = Double.MAX_VALUE;
		double currentWidth = 0;
		boolean allSameWidth = true;
		for (DataAdapter adapter : list) {
			Properties histogramProperties = adapter.getProperties();
			assert(histogramProperties != null);
			currentWidth = (Double) histogramProperties.get(TimeSpanToHistogramAdapter.HISTOGRAM_WIDTH);
			if (minimalWidth > currentWidth) {
				if (minimalWidth != Double.MAX_VALUE)
					allSameWidth = false;
				minimalWidth = currentWidth;
			}
		}
		
		/* Set all histograms to the same histogram width and add histograms
		 * to the current view.
		 */
		for (DataAdapter adapter : list) {
			if (!allSameWidth) {
				Properties adapterProperties = adapter.getProperties();
				adapterProperties.put(TimeSpanToHistogramAdapter.HISTOGRAM_WIDTH, minimalWidth);
				adapter.setProperties(adapterProperties);
			}
			histogramList.add((Histogram) adapter.getAdaptedObject());
		}
		histogramWidth = minimalWidth; // is now true

		this.setInput(histogramList);
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