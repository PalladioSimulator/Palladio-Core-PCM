package de.uka.ipd.sdq.edp2.visualization.editors;

import java.awt.Color;
import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartColor;
import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.statistics.HistogramDataset;

import de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DataSeriesImpl;

public class BasicDataset<T extends AbstractSeriesDataset> {
	private T dataset;
	private List<JFreeChartEditorInput> dataSeriesItems;
	private boolean datasetChanged;

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
				for (int i = 0; i < dataSeriesItems.size(); i++) {
					hds.addSeries(
							dataSeriesItems.get(i).getInputName(),
							(double[]) dataSeriesItems.get(i).getData(),
							Integer.parseInt(dataSeriesItems.get(i).getProperties()
									.get("numberOfBins").toString()));
				}
				dataset = (T) hds;
			}
		}
		return dataset;
	}

	public boolean checkInputCompatibility(JFreeChartEditorInput withInput) {
		return dataset.getClass().getName()
				.equals(withInput.getDataTypeInstance().getClass().getName());
	}
	
	public String[] getColorProperties(){
		String[] hexColors = new String[dataSeriesItems.size()];
		for (int i = 0; i<dataSeriesItems.size();i++){
			hexColors[i]= dataSeriesItems.get(i).getColor();
		}
		return hexColors;
	}
}
