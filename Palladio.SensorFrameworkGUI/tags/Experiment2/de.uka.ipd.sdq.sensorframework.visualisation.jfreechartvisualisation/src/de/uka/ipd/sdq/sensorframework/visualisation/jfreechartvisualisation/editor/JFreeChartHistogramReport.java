package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;


import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartHistogramViewer;

public class JFreeChartHistogramReport extends AbstractReportView implements
		ITabbedPropertySheetPageContributor,
		IVisualisation {

	public static String EDITOR_ID = "de.uka.ipd.sdq.simucomframework.visualisation.JFreeChartHistogramReport";
	
	JFreeChartHistogramViewer myViewer;
	
	public void createReportControls(Composite parent){
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
		label.setText("Histogram Width");
		label.setLayoutData(new RowData(SWT.DEFAULT,SWT.DEFAULT));
		final Text widthInput = new Text(histogramWidthPanel,SWT.BORDER);
		widthInput.setText("1");
		widthInput.setLayoutData(new RowData(60, SWT.DEFAULT));
		Listener listener = new Listener() {

			public void handleEvent(Event event) {
				switch (event.type) {
				case SWT.KeyDown:
					if (event.character == SWT.CR)
						myViewer.setHistogramWidth(Double.parseDouble(widthInput.getText()));
					break;
				case SWT.FocusOut:
						myViewer.setHistogramWidth(Double.parseDouble(widthInput.getText()));
					break;
				}
			}
		};
		widthInput.addListener(SWT.KeyDown, listener);
		widthInput.addListener(SWT.FocusOut, listener);
		
		myViewer = new JFreeChartHistogramViewer(parent,0);
		myViewer.setHistogramWidth(1);
		GridData data2 = new GridData();
		data2.grabExcessHorizontalSpace = true;
		data2.grabExcessVerticalSpace = true;
		data2.verticalAlignment = GridData.FILL;
		data2.horizontalAlignment = GridData.FILL;
		myViewer.setLayoutData(data2);
		histogramWidthPanel.setLayoutData(data);
	}
	
	public void addInput(Collection c) {
	}

	public void deleteInput(Collection c) {
	}

	public void setInput(Collection c) {
		ArrayList<IAdapter> adapters = new ArrayList<IAdapter>();
		for (Object o : c) {
			IAdapter adapter = AdapterRegistry.singleton().getAdapter(o,
					Histogram.class);
			if (adapter != null)
				adapters.add(adapter);
		}
		myViewer.setHistograms(adapters);
	}

}
