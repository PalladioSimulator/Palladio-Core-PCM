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
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.AbstractJFreeChartWidthViewer;

public abstract class AbstractJFreeChartWidthReport extends AbstractReportView implements IVisualisation<Histogram>{

	AbstractJFreeChartWidthViewer myViewer;
	protected Text widthInput;
	protected double histogramWidth = 1.0;
	public static final String HISTOGRAM_WIDTH = "HISTOGRAM_WIDTH";
	
	public AbstractJFreeChartWidthReport() {
		super();
	}
	
	protected abstract AbstractJFreeChartWidthViewer createViewer(Composite parent, int flags);

	public void createReportControls(Composite parent) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
	   	parent.setLayout(gridLayout);
		Composite histogramWidthPanel = new Composite(parent,SWT.NONE);
		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		histogramWidthPanel.setLayoutData(data);
	    RowLayout rowLayout = new RowLayout();
	    rowLayout.wrap = false;
	    rowLayout.pack = true;
	    histogramWidthPanel.setLayout(rowLayout);
		Label label = new Label(histogramWidthPanel,SWT.CENTER);
		label.setText("Sampling Rate");
		label.setLayoutData(new RowData(SWT.DEFAULT,SWT.DEFAULT));
		widthInput = new Text(histogramWidthPanel,SWT.BORDER);
		widthInput.setText("1");
		widthInput.setLayoutData(new RowData(60, SWT.DEFAULT));
		Listener listener = new Listener() {
	
			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.KeyDown:
					if (event.character == SWT.CR)
						setHistogramWidth(Double.parseDouble(widthInput.getText()));
					break;
				case SWT.FocusOut:
						setHistogramWidth(Double.parseDouble(widthInput.getText()));
					break;
				}
			}

		};
		widthInput.addListener(SWT.KeyDown, listener);
		widthInput.addListener(SWT.FocusOut, listener);
		
		myViewer = createViewer(parent,SWT.NONE);
		GridData data2 = new GridData();
		data2.grabExcessHorizontalSpace = true;
		data2.grabExcessVerticalSpace = true;
		data2.verticalAlignment = GridData.FILL;
		data2.horizontalAlignment = GridData.FILL;
		myViewer.setLayoutData(data2);
		histogramWidthPanel.setLayoutData(data);
	}

	private void setHistogramWidth(double newWidth) {
		this.histogramWidth = newWidth;
		((ConfigEditorInput)getEditorInput()).notifyObserver();
	}
	
	public void addInput(Collection<Histogram> c) {
	}

	public void deleteInput(Collection<Histogram> c) {
	}

	public void setInput(Collection<Histogram> c) {
		myViewer.setData(c);
		this.widthInput.setText(""+histogramWidth);
	}

	@Override
	protected void setInput(List<IAdapter> list) {
		ArrayList<Histogram> viewerInput = new ArrayList<Histogram>();
		for (IAdapter a : list) {
			Properties p = a.getProperties();
			p.put(HISTOGRAM_WIDTH, histogramWidth);
			a.setProperties(p);
			viewerInput.add((Histogram) a.getAdaptedObject());
		}
		this.setInput(viewerInput);
	}	
}