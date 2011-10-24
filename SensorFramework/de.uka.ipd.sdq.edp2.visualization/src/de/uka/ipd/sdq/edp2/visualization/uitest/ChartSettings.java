package de.uka.ipd.sdq.edp2.visualization.uitest;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.jfree.chart.JFreeChart;

public class ChartSettings extends Composite {
	private DataBindingContext m_bindingContext;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtCaption;
	private Text txtXaxisText;
	private Text txtYaxisText;
	private Button btnShowCaption;
	private JFreeChart chart;
	private Button btnShowXaxisTitle;
	private Button btnShowYaxisTitle;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ChartSettings(Composite parent, int style, JFreeChart chart) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		this.chart = chart;
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		toolkit.adapt(tabFolder);
		toolkit.paintBordersFor(tabFolder);
		
		TabItem tbtmCaption = new TabItem(tabFolder, SWT.NONE);
		tbtmCaption.setText("Caption");
		
		Composite compositeCaption = new Composite(tabFolder, SWT.NONE);
		tbtmCaption.setControl(compositeCaption);
		toolkit.paintBordersFor(compositeCaption);
		
		Group grpCaption = new Group(compositeCaption, SWT.NONE);
		grpCaption.setText("Caption");
		grpCaption.setBounds(10, 0, 208, 170);
		toolkit.adapt(grpCaption);
		toolkit.paintBordersFor(grpCaption);
		
		txtCaption = new Text(grpCaption, SWT.BORDER);
		txtCaption.setBounds(51, 46, 106, 21);
		txtCaption.setText(chart.getTitle().getText());
		toolkit.adapt(txtCaption, true, true);
		
		Label lblCaptionText = new Label(grpCaption, SWT.NONE);
		lblCaptionText.setBounds(20, 49, 25, 15);
		toolkit.adapt(lblCaptionText, true, true);
		lblCaptionText.setText("Text:");
		
		btnShowCaption = new Button(grpCaption, SWT.CHECK);
		btnShowCaption.setBounds(10, 21, 93, 16);
		toolkit.adapt(btnShowCaption, true, true);
		btnShowCaption.setText("Show caption");
		
		Group grpXaxis = new Group(compositeCaption, SWT.NONE);
		grpXaxis.setText("x-Axis");
		grpXaxis.setBounds(223, 0, 193, 82);
		toolkit.adapt(grpXaxis);
		toolkit.paintBordersFor(grpXaxis);
		
		btnShowXaxisTitle = new Button(grpXaxis, SWT.CHECK);
		btnShowXaxisTitle.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnShowXaxisTitle.setBounds(10, 20, 103, 16);
		btnShowXaxisTitle.setText("Show axis title");
		toolkit.adapt(btnShowXaxisTitle, true, true);
		
		Label lblXaxisText = new Label(grpXaxis, SWT.NONE);
		lblXaxisText.setText("Text:");
		lblXaxisText.setBounds(20, 45, 25, 15);
		toolkit.adapt(lblXaxisText, true, true);
		
		txtXaxisText = new Text(grpXaxis, SWT.BORDER);
		txtXaxisText.setText("x-Axis");
		txtXaxisText.setBounds(53, 42, 106, 21);
		toolkit.adapt(txtXaxisText, true, true);
		
		Group grpYaxis = new Group(compositeCaption, SWT.NONE);
		grpYaxis.setText("y-Axis");
		grpYaxis.setBounds(224, 88, 192, 82);
		toolkit.adapt(grpYaxis);
		toolkit.paintBordersFor(grpYaxis);
		
		btnShowYaxisTitle = new Button(grpYaxis, SWT.CHECK);
		btnShowYaxisTitle.setBounds(10, 21, 95, 16);
		btnShowYaxisTitle.setText("Show axis title");
		toolkit.adapt(btnShowYaxisTitle, true, true);
		
		txtYaxisText = new Text(grpYaxis, SWT.BORDER);
		txtYaxisText.setText("y-Axis");
		txtYaxisText.setBounds(53, 43, 106, 21);
		toolkit.adapt(txtYaxisText, true, true);
		
		Label lblYaxisText = new Label(grpYaxis, SWT.NONE);
		lblYaxisText.setText("Text:");
		lblYaxisText.setBounds(20, 46, 25, 15);
		toolkit.adapt(lblYaxisText, true, true);
		
		TabItem tbtmDiagram = new TabItem(tabFolder, SWT.NONE);
		tbtmDiagram.setText("Diagram");
		
		TabItem tbtmOther = new TabItem(tabFolder, SWT.NONE);
		tbtmOther.setText("Other");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.LEADING)
				.add(groupLayout.createSequentialGroup()
					.add(11)
					.add(tabFolder, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.LEADING)
				.add(groupLayout.createSequentialGroup()
					.add(13)
					.add(tabFolder, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
		m_bindingContext = initDataBindings();

	}
		
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue txtCaptionObserveTextObserveWidget = SWTObservables.observeText(txtCaption, new int[]{SWT.Modify, SWT.FocusOut});
		IObservableValue chartgetTitleTextObserveValue = PojoObservables.observeValue(chart.getTitle(), "text");
		bindingContext.bindValue(txtCaptionObserveTextObserveWidget, chartgetTitleTextObserveValue, null, null);
		//
		IObservableValue btnShowXaxisTitleObserveSelectionObserveWidget = SWTObservables.observeSelection(btnShowXaxisTitle);
		IObservableValue chartXYPlotXAxisVisibleObserveValue = PojoObservables.observeValue(chart.getXYPlot().getDomainAxis().isVisible(), "XYPlot.xAxisVisible");
		bindingContext.bindValue(btnShowXaxisTitleObserveSelectionObserveWidget, chartXYPlotXAxisVisibleObserveValue, null, null);
		//
		IObservableValue txtXaxisTextObserveTextObserveWidget = SWTObservables.observeText(txtXaxisText, SWT.Modify);
		IObservableValue chartXYPlotxAxisLabelObserveValue = PojoObservables.observeValue(chart.getXYPlot().getDomainAxis().getLabel(), "XYPlot.xAxisLabel");
		bindingContext.bindValue(txtXaxisTextObserveTextObserveWidget, chartXYPlotxAxisLabelObserveValue, null, null);
		//
		IObservableValue btnShowYaxisTitleObserveSelectionObserveWidget = SWTObservables.observeSelection(btnShowYaxisTitle);
		IObservableValue chartXYPlotYAxisVisibleObserveValue = PojoObservables.observeValue(chart.getXYPlot().getRangeAxis().isVisible(), "XYPlot.yAxisVisible");
		bindingContext.bindValue(btnShowYaxisTitleObserveSelectionObserveWidget, chartXYPlotYAxisVisibleObserveValue, null, null);
		//
		IObservableValue txtYaxisTextObserveTextObserveWidget = SWTObservables.observeText(txtYaxisText, SWT.Modify);
		IObservableValue chartXYPlotyAxisLabelObserveValue = PojoObservables.observeValue(chart.getXYPlot().getRangeAxis().getLabel(), "XYPlot.yAxisLabel");
		bindingContext.bindValue(txtYaxisTextObserveTextObserveWidget, chartXYPlotyAxisLabelObserveValue, null, null);
		//
		IObservableValue btnShowCaptionObserveSelectionObserveWidget = SWTObservables.observeSelection(btnShowCaption);
		IObservableValue chartTitleexpandToFitSpaceObserveValue = PojoObservables.observeValue(chart.getTitle(), "title.expandToFitSpace");
		bindingContext.bindValue(btnShowCaptionObserveSelectionObserveWidget, chartTitleexpandToFitSpaceObserveValue, null, null);
		//
		return bindingContext;
	}
}
