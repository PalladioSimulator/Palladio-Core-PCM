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
import org.jfree.data.general.DatasetGroup;
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

public class PieChartEditorInput extends JFreeChartEditorInput<DefaultPieDataset> {

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

	private HashMap<Double, Integer> data;

	public PieChartEditorInput() {
		super();
		new PieChartEditorInput(null);
	}

	public PieChartEditorInput(AbstractDataSource source) {
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
		PiePlot plot = new PiePlot(getDataset());
		plot.setNoDataMessage("No data available.");
		JFreeChart chart = new JFreeChart(
				getHandle().isShowTitle() ? getHandle().getTitle() : null,
				JFreeChart.DEFAULT_TITLE_FONT, plot, getHandle().isShowLegend());
		return chart;
	}

	@Override
	public String getDefaultTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Double, Integer> getData() {
		return data;
	}

	@Override
	public void updateInputData() {
		logger.log(Level.INFO, "Transformation : BEGIN");
		dataset = new DefaultPieDataset();

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

		data = new HashMap<Double, Integer>();

		/*double[] rawData = new double[listOfMeasures.get(0).size()];
		for (int i = 0; i < listOfMeasures.get(0).size(); i++) {
			rawData[i] = listOfMeasures.get(0).get(i)
					.doubleValue(listOfMeasures.get(0).get(i).getUnit());
			if (!data.containsKey(rawData[i])) {
				data.put(rawData[i], 1);
			} else {
				data.put(rawData[i], data.get(rawData[i]) + 1);
			}
		}*/
		
		data.put(20.0, 15);
		data.put(25.0, 10);
		data.put(30.0, 14);

		
		for (double key : data.keySet()) {
			dataset.setValue(Double.valueOf(key), data.get(key));
		}

		logger.log(Level.INFO, data.toString());

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

	@Override
	public boolean supportsMultipleInputs() {
		return false;
	}

}
