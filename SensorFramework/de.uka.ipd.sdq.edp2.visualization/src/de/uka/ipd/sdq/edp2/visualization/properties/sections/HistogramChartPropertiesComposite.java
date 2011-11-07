package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Group;

import de.uka.ipd.sdq.edp2.visualization.properties.HistogramChartProperties;

public class HistogramChartPropertiesComposite extends Composite {

	private DataBindingContext m_bindingContext;
	private de.uka.ipd.sdq.edp2.visualization.properties.HistogramChartProperties histogramChartProperties = new de.uka.ipd.sdq.edp2.visualization.properties.HistogramChartProperties();
	private Text numberOfBinsText;

	public HistogramChartPropertiesComposite(
			Composite parent,
			int style,
			de.uka.ipd.sdq.edp2.visualization.properties.HistogramChartProperties newHistogramChartProperties) {
		this(parent, style);
		setHistogramChartProperties(newHistogramChartProperties);
	}

	public HistogramChartPropertiesComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		
		Group grpHistogram = new Group(this, SWT.NONE);
		GridData gd_grpHistogram = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_grpHistogram.widthHint = 169;
		grpHistogram.setLayoutData(gd_grpHistogram);
		grpHistogram.setText("Histogram");
		
				Label label = new Label(grpHistogram, SWT.NONE);
				label.setLocation(10, 24);
				label.setSize(86, 15);
				label.setText("Number of bins:");
				
						numberOfBinsText = new Text(grpHistogram, SWT.BORDER | SWT.SINGLE);
						numberOfBinsText.setLocation(115, 22);
						numberOfBinsText.setSize(40, 21);

		if (histogramChartProperties != null) {
			m_bindingContext = initDataBindings();
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	private DataBindingContext initDataBindings() {
		IObservableValue numberOfBinsObserveWidget = SWTObservables
				.observeText(numberOfBinsText, SWT.Modify);
		IObservableValue numberOfBinsObserveValue = PojoObservables
				.observeValue(histogramChartProperties, "numberOfBins");
		//
		DataBindingContext bindingContext = new DataBindingContext();
		//
		bindingContext.bindValue(numberOfBinsObserveWidget,
				numberOfBinsObserveValue, null, null);
		//
		return bindingContext;
	}

	public de.uka.ipd.sdq.edp2.visualization.properties.HistogramChartProperties getHistogramChartProperties() {
		return histogramChartProperties;
	}

	public void setHistogramChartProperties(
			de.uka.ipd.sdq.edp2.visualization.properties.HistogramChartProperties newHistogramChartProperties) {
		setHistogramChartProperties(newHistogramChartProperties, true);
	}

	public void setHistogramChartProperties(
			de.uka.ipd.sdq.edp2.visualization.properties.HistogramChartProperties newHistogramChartProperties,
			boolean update) {
		histogramChartProperties = newHistogramChartProperties;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (histogramChartProperties != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}

}
