package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.ui.IMemento;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.general.PieDataset;

import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.datasource.ElementFactory;

public class PieChartEditorInput extends JFreeChartEditorInput {

	/**
	 * Name constant, which is used to identify this class in properties and
	 * persistence.
	 */
	private static final String ELEMENT_NAME = "PieChartEditorInput";

	/**
	 * Keys for persistence of properties.
	 */
	public final static String SHOW_RELATIVE_AMOUNT_KEY = "showRelativeAmount";
	public final static String SHOW_ABSOLUTE_AMOUNT_KEY = "showAbsoluteAmount";

	private boolean showRelativeAmount;
	private boolean showAbsoluteAmount;

	private BasicDataset<PieDataset> dataset;

	public PieChartEditorInput() {
		super();
		new PieChartEditorInput(null);
	}

	public PieChartEditorInput(AbstractDataSource source) {
		if (source != null) {
			setSource(source);
			dataset = new BasicDataset<PieDataset>(getDataTypeInstance());
		}
		setShowAbsoluteAmount(false);
		setShowRelativeAmount(true);
	}

	@Override
	public ArrayList<MetricDescription> getMetricRoles() {
		throw new RuntimeException("Not implemented!");
	}

	@Override
	public boolean canAccept(AbstractDataSource source) {
		return source.getOutput().size() >= 2;
	}

	@Override
	public IDataSink createCopyForSource(AbstractDataSource source) {
		PieChartEditorInput copy = new PieChartEditorInput(source);
		return copy;
	}

	@Override
	public HashMap<String, Object> getProperties() {
		properties.put(ElementFactory.ELEMENT_KEY, ELEMENT_NAME);
		properties.put(SHOW_RELATIVE_AMOUNT_KEY, isShowRelativeAmount());
		properties.put(SHOW_ABSOLUTE_AMOUNT_KEY, isShowAbsoluteAmount());
		properties.put(COLOR_KEY, getColor());
		return properties;
	}

	@Override
	public void setProperties(HashMap<String, Object> newProperties) {
		if (newProperties.get(SHOW_RELATIVE_AMOUNT_KEY) != null)
			setShowRelativeAmount(Boolean.parseBoolean((newProperties
					.get(SHOW_RELATIVE_AMOUNT_KEY).toString())));
		if (newProperties.get(SHOW_ABSOLUTE_AMOUNT_KEY) != null)
			setShowAbsoluteAmount(Boolean.parseBoolean((newProperties
					.get(SHOW_ABSOLUTE_AMOUNT_KEY).toString())));
		if (newProperties.get(COLOR_KEY) != null)
			setColor(newProperties.get(COLOR_KEY).toString());
	}

	@Override
	public String getName() {
		return ELEMENT_NAME;
	}

	@Override
	public String getFactoryId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveState(IMemento memento) {
		// TODO Auto-generated method stub
	}

	@Override
	public JFreeChart getChart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicDataset<PieDataset> getBasicDataset() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultDomainAxisLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDefaultRangeAxisLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PieDataset getDataTypeInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInputData() {
		// TODO Auto-generated method stub

	}

	public boolean isShowRelativeAmount() {
		return showRelativeAmount;
	}

	public void setShowRelativeAmount(boolean showRelativeAmount) {
		this.showRelativeAmount = showRelativeAmount;
	}

	public boolean isShowAbsoluteAmount() {
		return showAbsoluteAmount;
	}

	public void setShowAbsoluteAmount(boolean showAbsoluteAmount) {
		this.showAbsoluteAmount = showAbsoluteAmount;
	}

}
