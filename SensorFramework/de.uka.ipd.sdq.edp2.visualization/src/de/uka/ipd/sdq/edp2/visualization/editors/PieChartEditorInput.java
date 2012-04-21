package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.ui.IMemento;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.AbstractSeriesDataset;

import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;

public class PieChartEditorInput extends JFreeChartEditorInput {

	@Override
	public ArrayList<MetricDescription> getMetricRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canAccept(AbstractDataSource source) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IDataSink createCopyForSource(AbstractDataSource source) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(HashMap<String, Object> newProperties) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
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
	public <T extends AbstractSeriesDataset> BasicDataset<T> getBasicDataset() {
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
	public <T extends AbstractSeriesDataset> T getDataTypeInstance() {
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

}
