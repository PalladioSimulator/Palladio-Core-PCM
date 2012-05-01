package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;

import org.eclipse.ui.IMemento;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.statistics.HistogramDataset;

import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.MetricDescriptionUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.datasource.ElementFactory;

public class PieChartEditorInput extends JFreeChartEditorInput {

	/**
	 * Name constant, which is used to identify this class in properties and
	 * persistence.
	 */

	private final static Logger logger = Logger
			.getLogger(PieChartEditorInput.class.getCanonicalName());

	private static final String ELEMENT_NAME = "PieChartEditorInput";

	/**
	 * Keys for persistence of properties.
	 */
	public final static String SHOW_RELATIVE_AMOUNT_KEY = "showRelativeAmount";
	public final static String SHOW_ABSOLUTE_AMOUNT_KEY = "showAbsoluteAmount";

	private boolean showRelativeAmount;
	private boolean showAbsoluteAmount;

	private double[] data;

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
		return true;
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
		PieChartEditorInputFactory.saveState(memento, this);
	}

	@Override
	public JFreeChart getChart() {
		PiePlot plot = new PiePlot(getBasicDataset().getDataset());
		plot.setNoDataMessage("No data available.");
		JFreeChart chart = new JFreeChart(getBasicDataset().getHandle()
				.isShowTitle() ? getBasicDataset().getHandle().getTitle()
				: null, JFreeChart.DEFAULT_TITLE_FONT, plot, getBasicDataset()
				.getHandle().isShowLegend());
		return chart;
	}

	@Override
	public BasicDataset<PieDataset> getBasicDataset() {
		return dataset;
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
		return new DefaultPieDataset();
	}

	@Override
	public double[] getData() {
		return data;
	}

	@Override
	public void updateInputData() {
		logger.log(Level.INFO, "Transformation : BEGIN");
		DefaultPieDataset defaultDataset = new DefaultPieDataset();

		ArrayList<OrdinalMeasurementsDao<Measure>> listOfDaos = new ArrayList<OrdinalMeasurementsDao<Measure>>();
		ArrayList<List<Measure>> listOfMeasures = new ArrayList<List<Measure>>();
		for (DataSeries series : getSource().getOutput()) {
			listOfDaos.add(MeasurementsUtility
					.getOrdinalMeasurementsDao(series));
		}
		for (OrdinalMeasurementsDao<Measure> dao : listOfDaos) {
			listOfMeasures.add(dao.getMeasurements());
		}

		MetricDescription[] metrics = MetricDescriptionUtility
				.toBaseMetricDescriptions(getSource().getMeasurementsRange()
						.getMeasurements().getMeasure().getMetric());

		int length = listOfMeasures.get(0).size();
		
		double[] rawData = new double[length];
		for (int i = 0; i < length; i++) {
			rawData[i] = listOfMeasures.get(0).get(i)
					.doubleValue(listOfMeasures.get(0).get(i).getUnit());
		}
		//TODO count DIFFERENT values and add them to the list

		defaultDataset.setValue("value 1", 1.0);
		defaultDataset.setValue("value 2", 2.0);
		/*
		 * data = new double[listOfMeasures.get(0).size()];
		 * 
		 * for (int i = 0; i < listOfMeasures.get(0).size(); i++) { data[i] =
		 * listOfMeasures.get(0).get(i)
		 * .doubleValue(listOfMeasures.get(0).get(i).getUnit()); }
		 */

		if (dataset == null) {
			dataset = new BasicDataset<PieDataset>(getDataTypeInstance());
			dataset.addDataSeries(this);
		}
		setChanged();
		notifyObservers();
		logger.log(Level.INFO, "Transformation : END");

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
