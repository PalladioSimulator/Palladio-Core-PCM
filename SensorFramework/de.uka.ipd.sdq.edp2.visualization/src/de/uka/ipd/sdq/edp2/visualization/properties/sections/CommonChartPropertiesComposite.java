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

public class CommonChartPropertiesComposite extends Composite {

	private DataBindingContext m_bindingContext;
	private de.uka.ipd.sdq.edp2.visualization.properties.CommonChartProperties commonChartProperties;
	private Text labelXAxisText;
	private Text labelYAxisText;
	private Button showLabelXAxisButton;
	private Button showLabelYAxisButton;
	private Button showTitleButton;
	private Text titleText;
	private Button btnShowLegend;

	public CommonChartPropertiesComposite(
			Composite parent,
			int style,
			de.uka.ipd.sdq.edp2.visualization.properties.CommonChartProperties newCommonChartProperties) {
		this(parent, style);
		setCommonChartProperties(newCommonChartProperties);
	}

	public CommonChartPropertiesComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));

		Group grpDescriptions = new Group(this, SWT.NONE);
		grpDescriptions.setText("Descriptions");
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

		if (commonChartProperties != null) {
			m_bindingContext = initDataBindings();
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public de.uka.ipd.sdq.edp2.visualization.properties.CommonChartProperties getCommonChartProperties() {
		return commonChartProperties;
	}

	public void setCommonChartProperties(
			de.uka.ipd.sdq.edp2.visualization.properties.CommonChartProperties newCommonChartProperties) {
		setCommonChartProperties(newCommonChartProperties, true);
	}

	public void setCommonChartProperties(
			de.uka.ipd.sdq.edp2.visualization.properties.CommonChartProperties newCommonChartProperties,
			boolean update) {
		commonChartProperties = newCommonChartProperties;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (commonChartProperties != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue labelXAxisObserveWidget = SWTObservables.observeText(
				labelXAxisText, SWT.FocusOut);
		IObservableValue labelXAxisObserveValue = PojoObservables.observeValue(
				commonChartProperties, "labelXAxis");
		bindingContext.bindValue(labelXAxisObserveWidget,
				labelXAxisObserveValue, null, null);
		//
		IObservableValue labelYAxisObserveWidget = SWTObservables.observeText(
				labelYAxisText, SWT.FocusOut);
		IObservableValue labelYAxisObserveValue = PojoObservables.observeValue(
				commonChartProperties, "labelYAxis");
		bindingContext.bindValue(labelYAxisObserveWidget,
				labelYAxisObserveValue, null, null);
		//
		IObservableValue showLabelXAxisObserveWidget = SWTObservables
				.observeSelection(showLabelXAxisButton);
		IObservableValue showLabelXAxisObserveValue = PojoObservables
				.observeValue(commonChartProperties, "showLabelXAxis");
		bindingContext.bindValue(showLabelXAxisObserveWidget,
				showLabelXAxisObserveValue, null, null);
		//
		IObservableValue showLabelYAxisObserveWidget = SWTObservables
				.observeSelection(showLabelYAxisButton);
		IObservableValue showLabelYAxisObserveValue = PojoObservables
				.observeValue(commonChartProperties, "showLabelYAxis");
		bindingContext.bindValue(showLabelYAxisObserveWidget,
				showLabelYAxisObserveValue, null, null);
		//
		IObservableValue showTitleObserveWidget = SWTObservables
				.observeSelection(showTitleButton);
		IObservableValue showTitleObserveValue = PojoObservables.observeValue(
				commonChartProperties, "showTitle");
		bindingContext.bindValue(showTitleObserveWidget, showTitleObserveValue,
				null, null);
		//
		IObservableValue titleObserveWidget = SWTObservables.observeText(
				titleText, SWT.FocusOut);
		IObservableValue titleObserveValue = PojoObservables.observeValue(
				commonChartProperties, "title");
		bindingContext.bindValue(titleObserveWidget, titleObserveValue, null,
				null);
		//
		IObservableValue btnShowLegendObserveSelectionObserveWidget = SWTObservables
				.observeSelection(btnShowLegend);
		IObservableValue commonChartPropertiesShowLegendObserveValue = PojoObservables
				.observeValue(commonChartProperties, "showLegend");
		bindingContext.bindValue(btnShowLegendObserveSelectionObserveWidget,
				commonChartPropertiesShowLegendObserveValue, null, null);
		//
		return bindingContext;
	}
}
