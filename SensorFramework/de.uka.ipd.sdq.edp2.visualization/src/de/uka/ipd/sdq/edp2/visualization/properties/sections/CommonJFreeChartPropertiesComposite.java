package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInputHandle;

public class CommonJFreeChartPropertiesComposite extends Composite {

	private DataBindingContext m_bindingContext;
	private Text labelXAxisText;
	private Text labelYAxisText;
	private Button showLabelXAxisButton;
	private Button showLabelYAxisButton;
	private Button showTitleButton;
	private Text titleText;
	private Button btnShowLegend;
	private JFreeChartEditorInputHandle handle;
	private JFreeChartEditorInput firstInput;

	public CommonJFreeChartPropertiesComposite(
			Composite parent,
			int style,
			JFreeChartEditorInputHandle handle) {
		this(parent, style);
		setHandle(handle);
	}

	public CommonJFreeChartPropertiesComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		setLayoutData(new GridData(GridData.FILL, GridData.FILL, false, false, 1, 1));
		
		Group grpDescriptions = new Group(this, SWT.NONE);
		grpDescriptions.setText("Diagram Settings");
		grpDescriptions.setLayout(new GridLayout(3, false));

		Label label_5 = new Label(grpDescriptions, SWT.NONE);
		label_5.setText("Title:");

		titleText = new Text(grpDescriptions, SWT.BORDER | SWT.SINGLE);

		showTitleButton = new Button(grpDescriptions, SWT.CHECK);
		showTitleButton.setText("Show diagram title");

		Label label = new Label(grpDescriptions, SWT.NONE);
		label.setText("X-axis label:");

		labelXAxisText = new Text(grpDescriptions, SWT.BORDER | SWT.SINGLE);

		showLabelXAxisButton = new Button(grpDescriptions, SWT.CHECK);
		showLabelXAxisButton.setText("Show X-axis label");

		Label label_1 = new Label(grpDescriptions, SWT.NONE);
		label_1.setText("Y-axis label:");

		labelYAxisText = new Text(grpDescriptions, SWT.BORDER | SWT.SINGLE);

		showLabelYAxisButton = new Button(grpDescriptions, SWT.CHECK);
		showLabelYAxisButton.setText("Show Y-axis label");

		btnShowLegend = new Button(grpDescriptions, SWT.CHECK);
		btnShowLegend.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		btnShowLegend.setText("Show legend");
		new Label(grpDescriptions, SWT.NONE);

		if (handle != null) {
			m_bindingContext = initDataBindings();
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public JFreeChartEditorInputHandle getHandle() {
		return handle;
	}

	public void setHandle(
			JFreeChartEditorInputHandle handle) {
		setHandle(handle, true);
	}

	public void setHandle(
			JFreeChartEditorInputHandle handle,			boolean update) {
		this.handle = handle;
		this.firstInput = handle.getInputs().get(0);
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (handle != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue titleTextObserveTextObserveWidget = SWTObservables.observeText(titleText, new int[]{SWT.Modify, SWT.FocusOut});
		IObservableValue handleTitleObserveValue = PojoObservables.observeValue(handle, "title");
		bindingContext.bindValue(titleTextObserveTextObserveWidget, handleTitleObserveValue, null, null);
		//
		IObservableValue showTitleButtonObserveSelectionObserveWidget = SWTObservables.observeSelection(showTitleButton);
		IObservableValue handleShowTitleObserveValue = PojoObservables.observeValue(handle, "showTitle");
		bindingContext.bindValue(showTitleButtonObserveSelectionObserveWidget, handleShowTitleObserveValue, null, null);
		//
		IObservableValue labelXAxisTextObserveTextObserveWidget = SWTObservables.observeText(labelXAxisText, new int[]{SWT.Modify, SWT.FocusOut});
		IObservableValue handleDomainAxisLabelObserveValue = PojoObservables.observeValue(handle, "domainAxisLabel");
		bindingContext.bindValue(labelXAxisTextObserveTextObserveWidget, handleDomainAxisLabelObserveValue, null, null);
		//
		IObservableValue showLabelXAxisButtonObserveSelectionObserveWidget = SWTObservables.observeSelection(showLabelXAxisButton);
		IObservableValue handleShowDomainAxisLabelObserveValue = PojoObservables.observeValue(handle, "showDomainAxisLabel");
		bindingContext.bindValue(showLabelXAxisButtonObserveSelectionObserveWidget, handleShowDomainAxisLabelObserveValue, null, null);
		//
		IObservableValue labelYAxisTextObserveTextObserveWidget = SWTObservables.observeText(labelYAxisText, new int[]{SWT.Modify, SWT.FocusOut});
		IObservableValue handleRangeAxisLabelObserveValue = PojoObservables.observeValue(handle, "rangeAxisLabel");
		bindingContext.bindValue(labelYAxisTextObserveTextObserveWidget, handleRangeAxisLabelObserveValue, null, null);
		//
		IObservableValue showLabelYAxisButtonObserveSelectionObserveWidget = SWTObservables.observeSelection(showLabelYAxisButton);
		IObservableValue handleShowRangeAxisLabelObserveValue = PojoObservables.observeValue(handle, "showRangeAxisLabel");
		bindingContext.bindValue(showLabelYAxisButtonObserveSelectionObserveWidget, handleShowRangeAxisLabelObserveValue, null, null);
		//
		IObservableValue btnShowLegendObserveSelectionObserveWidget = SWTObservables.observeSelection(btnShowLegend);
		IObservableValue handleShowLegendObserveValue = PojoObservables.observeValue(handle, "showLegend");
		bindingContext.bindValue(btnShowLegendObserveSelectionObserveWidget, handleShowLegendObserveValue, null, null);
		//
		return bindingContext;
	}
}
