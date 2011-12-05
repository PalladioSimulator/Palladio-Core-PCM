package de.uka.ipd.sdq.edp2.visualization;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2Source;

/**
 * An {@link AbstractDataSource} serves as preceding element of an {@link IDataSink}.
 * It has in particular a reference on the {@link DataSeries} attributes of some
 * experiment data. The only implementing classes of this interface should be {@link AbstractTransformation}
 * and {@link EDP2Source}. All other classes should extend {@link AbstractTransformation} or implement
 * {@link IVisualizationInput} if they represent a transformation or an editor input, respectively.
 * 
 * @author Dominik Ernst, Roland Richter
 */
public abstract class AbstractDataSource extends Observable implements IDataFlow {

	/**
	 * An {@link EList} of (@link DataSeries} objects.
	 */
	protected EList<DataSeries> dataSeries;
	/**
	 * A reference on the {@link MeasurementsRange} of the
	 * {@link RawMeasurements} of the original data.
	 */
	protected MeasurementsRange originalMeasurementsRange;
	/**
	 * A local copy of the {@link MeasurementsRange}. Has no references on the
	 * original {@link Measurements}.
	 */
	protected MeasurementsRange measurementsRange;
	/**
	 * {@link Map}, which stores the properties of {@link AbstractDataSource} objects.
	 */
	protected HashMap<String, Object> properties;

	/**
	 * A default constructor, only initializing an instance of {@link HashMap}
	 * for the properties of this {@link AbstractDataSource}.
	 */
	public AbstractDataSource() {
		properties = new HashMap<String, Object>();
	}

	/**
	 * Returns the reference on the list of {@link DataSeries}.
	 * 
	 * @return A List of {@link DataSeries}, which represents one dimension.
	 */
	public EList<DataSeries> getOutput() {
		return dataSeries;
	}

	/**
	 * Returns the reference on the {@link MeasurementsRange} .
	 * 
	 * @return The {@link MeasurementsRange} for this {@link AbstractDataSource} .
	 */
	public MeasurementsRange getMeasurementsRange() {
		return measurementsRange;
	}

	/**
	 * Provides a reference on the original {@link MeasurementsRange} (i.e. of
	 * the underlying {@link EDP2Source}). Can be used to get Information on the
	 * original experiment data.
	 * 
	 * @return the originalMeasurementsRange
	 */
	public MeasurementsRange getOriginalMeasurementsRange() {
		return originalMeasurementsRange;
	}

}
