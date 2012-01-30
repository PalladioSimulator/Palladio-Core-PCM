package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.ArrayList;
import java.util.List;

import org.jfree.data.general.AbstractSeriesDataset;
import org.jfree.data.statistics.HistogramDataset;

import de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DataSeriesImpl;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;

public class BasicDataset<T extends AbstractSeriesDataset> {
	private T dataset;
	private List<IVisualizationInput> dataSeriesItems;
	private boolean datasetChanged;

	public BasicDataset(T dataset) {
		this.dataset = dataset;
		this.dataSeriesItems = new ArrayList<IVisualizationInput>();
	}

	public boolean addDataSeries(IVisualizationInput fromInput) {
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
				for (IVisualizationInput input : dataSeriesItems) {
					hds.addSeries(
							input.getDefaultName(),
							(double[]) input.getData(),
							Integer.parseInt(input.getProperties()
									.get("numberOfBins").toString()));
				}
				dataset = (T) hds;
			}
		}
		return dataset;
	}

	public boolean checkInputCompatibility(IVisualizationInput withInput) {
		return dataset.getClass().getName()
				.equals(withInput.getDataTypeInstance().getClass().getName());
	}
}
