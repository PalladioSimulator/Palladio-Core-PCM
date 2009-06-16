/**
 * 
 */
package de.uka.ipd.sdq.edp2.util;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.DaoFactory;
import de.uka.ipd.sdq.edp2.DaoRegistry;
import de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.AggregationFunctionDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries;
import de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals;
import de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.Measurement;
import de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange;
import de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements;

/**Utility functions to ease creation and recording of measurements.
 * Note: All functions are not thread safe. Manipulation of EMF models should
 * only be done in corresponding EditingDomains. 
 * @author groenda
 */
public class StorageUtility {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(StorageUtility.class.getCanonicalName());
	private static final EmfmodelFactory factory = EmfmodelFactory.eINSTANCE;
	
	/**Stores a new measurement at the last existing range.
	 * @param measurement The measurement of the experiment run for which a new measurement exists.
	 * @param data The measurement (data) itself.
	 * @param daoRegistry The registry used to lookup DAOs for the measurements.
	 */
	public static void storeMeasurement(Measurement measurement, final Object[] data, final DaoRegistry daoRegistry) {
		int size = measurement.getMeasurementRange().size();
		MeasurementRange lastRange = measurement.getMeasurementRange().get(size - 1);
		RawMeasurements rm = lastRange.getRawMeasurements();
		if (rm != null) { // Add raw measurements
			if (data.length != rm.getDataSeries().size()) {
				String msg = "Tried to store raw measurements and provided an argument of invalid size (all data series must be stored at once). Should be "
						+ rm.getDataSeries().size()
						+ ", is "
						+ data.length
						+ ".";
				logger.log(Level.SEVERE, msg);
				throw new IllegalArgumentException(msg);
			} else {
				Iterator<DataSeries> iter = rm.getDataSeries().iterator();
				DataSeries ds;
				int dataPosition = -1;
				EmfmodelAddMeasurementToDataSeriesSwitch addMmt = new EmfmodelAddMeasurementToDataSeriesSwitch(daoRegistry);
				while (iter.hasNext()) {
					ds = iter.next();
					dataPosition++;
					addMmt.setMeasurementToAdd(data[dataPosition]);
					addMmt.doSwitch(ds);
				}
			}
		}
		// TODO handle aggregated measurements
	}
	
	/**Creates a new MeasurementRange and contained elements if there
	 * are already existing elements in another MeasurementRange.
	 * Does not set the startTime and endTime properties.
	 * @param measurement Location to add the range.
	 * @param daoFactory The factory used to create the DAOs for the DataSeries.
	 * @return The newly created measurement range.
	 */
	public static MeasurementRange addMeasurementRange(Measurement measurement, DaoFactory daoFactory) {
		MeasurementRange mr = factory.createMeasurementRange();
		measurement.getMeasurementRange().add(mr);
		if (measurement.getMeasurementRange().size() > 1) { // copy contents from existing templates
			MeasurementRange template = measurement.getMeasurementRange().get(0);
			if (template.getRawMeasurements() != null) {
				mr.setRawMeasurements(factory.createRawMeasurements());
				addDataSeries(mr.getRawMeasurements(), daoFactory);
			}
			Iterator<AggregatedMeasurements> iter = template.getAggregatedMeasurements().iterator();
			while (iter.hasNext()) {
				FixedWidthAggregatedMeasurements fwam = factory.createFixedWidthAggregatedMeasurements();
				FixedWidthAggregatedMeasurements fwtemplate = (FixedWidthAggregatedMeasurements) iter.next();
				fwam.setIntervals((FixedIntervals) EcoreUtil.copy(fwtemplate.getIntervals()));
				fwam.setAggregationOn(fwtemplate.getAggregationOn());
				Iterator<DataSeries> iter2 = fwtemplate.getDataSeries().iterator();
				while (iter2.hasNext()) {
					fwam.getDataSeries().add(
							new EmfmodelDataSeriesFromReferenceSwitch(daoFactory)
									.doSwitch(iter2.next()));
				}
			}
		}
		return mr;
	}

	/**Creates the model elements linked as data series corresponding
	 * to the definition in the metric and measure.
	 * If there are already existing definitions in another MeasurementRange
	 * these are used as templates during creation.
	 * @param rm Location at which the data series elements are added.
	 * @param daoFactory The factory used to create the DAOs for the DataSeries.
	 */
	public static void addDataSeries(RawMeasurements rm, DaoFactory daoFactory) {
		/*check if there are already existing RawMeasurements in other MeasurementRanges.
		 * Copy those types (if existing).
		 */
		boolean creationSuccesful = false;
		if (rm.getMeasurementRange() != null &&
				rm.getMeasurementRange().getMeasurement() != null &&
				rm.getMeasurementRange().getMeasurement().getMeasurementRange().size() > 1) {
			Iterator<MeasurementRange> iter = rm.getMeasurementRange().getMeasurement().getMeasurementRange().iterator();
			MeasurementRange mr;
			while (iter.hasNext()) {
				mr = iter.next();
				if (mr.getRawMeasurements() != null 
						&& mr.getRawMeasurements().getDataSeries().size() > 0) {
					// copy data series types
					for (int i = 0; i < mr.getRawMeasurements().getDataSeries().size(); i++) {
						rm.getDataSeries().add(
								new EmfmodelDataSeriesFromReferenceSwitch(daoFactory)
										.doSwitch(mr.getRawMeasurements()
												.getDataSeries().get(i)));
						creationSuccesful = true;
					}
				}
			}
		}
		if (creationSuccesful == false) {
			Edp2Measure measure = rm.getMeasurementRange().getMeasurement().getMeasure();
			assert measure != null;
			new EmfmodelDataSeriesFromMetricSwitch(rm, measure, daoFactory).doSwitch(measure.getMetric());
		}
	}
	
	public static void addDataSeries(AggregatedMeasurements am, AggregationFunctionDescription afd) {
		/* A) Use eclipse extension mechanism to lookup implementation
		 * for selected AggregationFunctionDescription.uuid.
		 * B) Especially for remote use: Provide implementation for
		 * a set of default AggregationFunctionDescription.uuids.
		 */
		throw new UnsupportedOperationException("Not implemented yet.");
	}
}
