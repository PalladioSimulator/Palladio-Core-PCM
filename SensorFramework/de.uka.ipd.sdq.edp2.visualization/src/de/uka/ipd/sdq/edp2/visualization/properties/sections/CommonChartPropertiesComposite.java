package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;
import org.eclipse.swt.widgets.Group;

public class CommonChartPropertiesComposite extends Composite {

	private DataBindingContext m_bindingContext;
	private de.uka.ipd.sdq.edp2.visualization.properties.sections.CommonChartProperties commonChartProperties = new de.uka.ipd.sdq.edp2.visualization.properties.sections.CommonChartProperties();
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
			de.uka.ipd.sdq.edp2.visualization.properties.sections.CommonChartProperties newCommonChartProperties) {
		this(parent, style);
		setCommonChartProperties(newCommonChartProperties);
	}

	public CommonChartPropertiesComposite(Composite parent, int style) {
		super(parent, style);

		Group grpDescriptions = new Group(this, SWT.NONE);
		grpDescriptions.setText("Descriptions");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				GroupLayout.LEADING).add(
				GroupLayout.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap().add(
						grpDescriptions, GroupLayout.DEFAULT_SIZE, 409,
						Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.LEADING).add(
				groupLayout.createSequentialGroup().addContainerGap().add(
						grpDescriptions, GroupLayout.PREFERRED_SIZE, 159,
						GroupLayout.PREFERRED_SIZE).addContainerGap(138,
						Short.MAX_VALUE)));

		labelYAxisText = new Text(grpDescriptions, SWT.BORDER | SWT.SINGLE);
		labelYAxisText.setBounds(72, 96, 169, 21);

		labelXAxisText = new Text(grpDescriptions, SWT.BORDER | SWT.SINGLE);
		labelXAxisText.setBounds(72, 62, 169, 21);

		titleText = new Text(grpDescriptions, SWT.BORDER | SWT.SINGLE);
		titleText.setBounds(72, 28, 169, 21);

		Label label_5 = new Label(grpDescriptions, SWT.NONE);
		label_5.setBounds(4, 31, 26, 15);
		label_5.setText("Title:");

		Label label = new Label(grpDescriptions, SWT.NONE);
		label.setBounds(4, 65, 62, 15);
		label.setText("X-axis label:");

		Label label_1 = new Label(grpDescriptions, SWT.NONE);
		label_1.setBounds(4, 99, 62, 15);
		label_1.setText("Y-axis label:");

		showLabelYAxisButton = new Button(grpDescriptions, SWT.CHECK);
		showLabelYAxisButton.setBounds(247, 98, 112, 16);
		showLabelYAxisButton.setText("Show Y-axis label");

		showLabelXAxisButton = new Button(grpDescriptions, SWT.CHECK);
		showLabelXAxisButton.setBounds(247, 64, 112, 16);
		showLabelXAxisButton.setText("Show X-axis label");

		showTitleButton = new Button(grpDescriptions, SWT.CHECK);
		showTitleButton.setBounds(247, 29, 120, 16);
		showTitleButton.setText("Show diagram title");
		
		btnShowLegend = new Button(grpDescriptions, SWT.CHECK);
		btnShowLegend.setText("Show legend");
		btnShowLegend.setBounds(4, 133, 112, 16);
		setLayout(groupLayout);

		if (commonChartProperties != null) {
			m_bindingContext = initDataBindings();
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public de.uka.ipd.sdq.edp2.visualization.properties.sections.CommonChartProperties getCommonChartProperties() {
		return commonChartProperties;
	}

	public void setCommonChartProperties(
			de.uka.ipd.sdq.edp2.visualization.properties.sections.CommonChartProperties newCommonChartProperties) {
		setCommonChartProperties(newCommonChartProperties, true);
	}

	public void setCommonChartProperties(
			de.uka.ipd.sdq.edp2.visualization.properties.sections.CommonChartProperties newCommonChartProperties,
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
		IObservableValue labelXAxisObserveWidget = SWTObservables.observeText(labelXAxisText, SWT.FocusOut);
		IObservableValue labelXAxisObserveValue = PojoObservables.observeValue(commonChartProperties, "labelXAxis");
		bindingContext.bindValue(labelXAxisObserveWidget, labelXAxisObserveValue, null, null);
		//
		IObservableValue labelYAxisObserveWidget = SWTObservables.observeText(labelYAxisText, SWT.FocusOut);
		IObservableValue labelYAxisObserveValue = PojoObservables.observeValue(commonChartProperties, "labelYAxis");
		bindingContext.bindValue(labelYAxisObserveWidget, labelYAxisObserveValue, null, null);
		//
		IObservableValue showLabelXAxisObserveWidget = SWTObservables.observeSelection(showLabelXAxisButton);
		IObservableValue showLabelXAxisObserveValue = PojoObservables.observeValue(commonChartProperties, "showLabelXAxis");
		bindingContext.bindValue(showLabelXAxisObserveWidget, showLabelXAxisObserveValue, null, null);
		//
		IObservableValue showLabelYAxisObserveWidget = SWTObservables.observeSelection(showLabelYAxisButton);
		IObservableValue showLabelYAxisObserveValue = PojoObservables.observeValue(commonChartProperties, "showLabelYAxis");
		bindingContext.bindValue(showLabelYAxisObserveWidget, showLabelYAxisObserveValue, null, null);
		//
		IObservableValue showTitleObserveWidget = SWTObservables.observeSelection(showTitleButton);
		IObservableValue showTitleObserveValue = PojoObservables.observeValue(commonChartProperties, "showTitle");
		bindingContext.bindValue(showTitleObserveWidget, showTitleObserveValue, null, null);
		//
		IObservableValue titleObserveWidget = SWTObservables.observeText(titleText, SWT.FocusOut);
		IObservableValue titleObserveValue = PojoObservables.observeValue(commonChartProperties, "title");
		bindingContext.bindValue(titleObserveWidget, titleObserveValue, null, null);
		//
		IObservableValue btnShowLegendObserveSelectionObserveWidget = SWTObservables.observeSelection(btnShowLegend);
		IObservableValue commonChartPropertiesShowLegendObserveValue = PojoObservables.observeValue(commonChartProperties, "showLegend");
		bindingContext.bindValue(btnShowLegendObserveSelectionObserveWidget, commonChartPropertiesShowLegendObserveValue, null, null);
		//
		return bindingContext;
	}
}
