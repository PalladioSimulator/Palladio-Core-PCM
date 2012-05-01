package de.uka.ipd.sdq.edp2.visualization.editors;

import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jfree.chart.ChartColor;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.DefaultXYDataset;

import de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DataSeriesImpl;

public class BasicDataset<T extends Dataset> {
	private T dataset;
	private List<JFreeChartEditorInput> dataSeriesItems;
	private boolean datasetChanged;
	private JFreeChartEditorInputHandle handle;

	private final static Logger logger = Logger.getLogger(BasicDataset.class
			.getName());

	public BasicDataset(T dataset) {
		this.dataset = dataset;
		this.dataSeriesItems = new ArrayList<JFreeChartEditorInput>();
	}

	public boolean addDataSeries(JFreeChartEditorInput fromInput) {
		boolean compatible = checkInputCompatibility(fromInput);
		if (compatible) {
			dataSeriesItems.add(fromInput);
			datasetChanged = true;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retrieves the <code>dataset</code> of type <code>T</code>. Updates the
	 * set to contain all added <code>dataSeriesItems</code>, if necessary.
	 * 
	 * @return the up-to-date dataset
	 */
	public T getDataset() {
		if (datasetChanged) {
			if (dataset instanceof HistogramDataset) {
				
				HistogramDataset hds = new HistogramDataset();
				hds.setType(Boolean
						.parseBoolean(getSeriesProperties()[0].get(
								HistogramEditorInput.ABSOLUTE_FREQUENCY_KEY)
								.toString()) ? HistogramType.FREQUENCY
						: HistogramType.RELATIVE_FREQUENCY);
				for (int i = 0; i < dataSeriesItems.size(); i++) {
					logger.log(Level.INFO, getSeriesProperties()[i].toString());
					hds.addSeries(
							dataSeriesItems.get(i).getInputName(),
							(double[]) dataSeriesItems.get(i).getData(),
							Integer.parseInt(getSeriesProperties()[i].get(
									"numberOfBins").toString()));
				}
				dataset = (T) hds;
			} else if (dataset instanceof DefaultXYDataset) {
				DefaultXYDataset xyds = new DefaultXYDataset();
				for (int i = 0; i < dataSeriesItems.size(); i++) {
					xyds.addSeries(dataSeriesItems.get(i).getInputName(),
							(double[][]) dataSeriesItems.get(i).getData());
				}
				dataset = (T) xyds;
			}
		} else if (dataset instanceof PieDataset) {
			logger.log(Level.INFO, "reached Pie-chart branch");
			DefaultPieDataset pds = new DefaultPieDataset();
			HashMap<Double, Integer> data = ((PieChartEditorInput)(dataSeriesItems.get(0))).getData();
			for (double key : data.keySet()){
				pds.setValue(Double.valueOf(key), data.get(key));
			}
			dataset = (T) pds;
		}
		return dataset;
	}

	/**
	 * Method to validate the fact that two inputs, which add data to this
	 * {@link BasicDataset}, are compatible.
	 * 
	 * @param withInput
	 *            the input to compare with the calling input
	 * @return <code>true</code> if the inputs types match
	 */
	public boolean checkInputCompatibility(JFreeChartEditorInput withInput) {
		return dataset.getClass().getName()
				.equals(withInput.getDataTypeInstance().getClass().getName());
	}

	/**
	 * Returns an array of property-maps containing properties of inputs which
	 * are of relevance to the chart as a whole. TODO at the moment simply
	 * returns all properties.
	 * 
	 * @return an array of {@link HashMap}, containing the inputs' properties.
	 */
	public HashMap<String, Object>[] getSeriesProperties() {
		HashMap<String, Object>[] allProperties = new HashMap[dataSeriesItems
				.size()];
		for (int i = 0; i < dataSeriesItems.size(); i++) {
			allProperties[i] = dataSeriesItems.get(i).getProperties();
		}
		return allProperties;
	}

	public JFreeChartEditorInputHandle getHandle() {
		if (handle == null)
			throw new RuntimeException("No handle set!");
		return handle;
	}

	public void setHandle(JFreeChartEditorInputHandle handle) {
		this.handle = handle;
	}
}
