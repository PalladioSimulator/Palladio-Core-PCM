/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp.internal.EmfmodelAddMeasurementToDataSeriesSwitch;
import de.uka.ipd.sdq.edp.internal.EmfmodelDataSeriesFromMetricSwitch;
import de.uka.ipd.sdq.edp.internal.EmfmodelDataSeriesFromReferenceSwitch;
import de.uka.ipd.sdq.edp2.MeasurementsDaoFactory;
import de.uka.ipd.sdq.edp2.MeasurementsDaoRegistry;
import de.uka.ipd.sdq.edp2.NominalMeasurementsDao;
import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.models.emfmodel.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries;
import de.uka.ipd.sdq.edp2.models.emfmodel.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.emfmodel.FixedIntervals;
import de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.Measurement;
import de.uka.ipd.sdq.edp2.models.emfmodel.MeasurementRange;
import de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.util.EmfmodelSwitch;

/**This class provides utility functions to handle measurements.
 * @author groenda
 */
public class MeasurementsUtility {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(MeasurementsUtility.class.getCanonicalName());
	/** EMF factory used by this instance. */
	private static final EmfmodelFactory factory = EmfmodelFactory.eINSTANCE;

	/**Creates a new MeasurementRange and contained elements if there
	 * are already existing elements in another MeasurementRange.
	 * Does not set the startTime and endTime properties.
	 * @param measurement Location to add the range.
	 * @return The newly created measurement range.
	 */
	public static MeasurementRange addMeasurementRange(Measurement measurement) {
		MeasurementsDaoFactory daoFactory = measurement.getMeasure().getExperimentGroup().getRepository().getMeasurementsDaoFactory();
		MeasurementRange mr = factory.createMeasurementRange();
		measurement.getMeasurementRange().add(mr);
		if (measurement.getMeasurementRange().size() > 1) { // copy contents from existing templates
			MeasurementRange template = measurement.getMeasurementRange().get(0);
			if (template.getRawMeasurements() != null) {
				mr.setRawMeasurements(factory.createRawMeasurements());
				addDataSeries(mr.getRawMeasurements());
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
	 */
	public static void addDataSeries(RawMeasurements rm) {
		MeasurementsDaoFactory daoFactory = rm.getMeasurementRange().getMeasurement().getMeasure().getExperimentGroup().getRepository().getMeasurementsDaoFactory();
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

	/**Stores a new measurement at the last existing range.
	 * @param measurement The measurement of the experiment run for which a new measurement exists.
	 * @param data The measurement (data) itself.
	 */
	public static void storeMeasurement(Measurement measurement, final Object[] data) {
		MeasurementsDaoRegistry daoRegistry = measurement.getMeasure().getExperimentGroup().getRepository().getMeasurementsDaoFactory().getDaoRegistry();
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
	
	/**Requests a DAO for a nominal measurement.
	 * If the DAO does not exists it is created and opened automatically (if possible).
	 * @param ds The data series for which the DAO should be created.
	 * @return DAO for nominal measurements.
	 */
	public static NominalMeasurementsDao getNominalMeasurementsDao(final DataSeries ds) {
		final MeasurementsDaoFactory daoFactory = ds.getRawMeasurements()
				.getMeasurementRange().getMeasurement().getMeasure()
				.getExperimentGroup().getRepository()
				.getMeasurementsDaoFactory();
		if (daoFactory.getDaoRegistry().isRegistered(ds.getValuesUuid())) {
			return (NominalMeasurementsDao) daoFactory.getDaoRegistry().getMeasurementsDao(ds.getValuesUuid());
		} else {
			NominalMeasurementsDao nmd = new EmfmodelSwitch<NominalMeasurementsDao>() {
				public NominalMeasurementsDao caseNominalMeasurements(de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasurements object) {
					return daoFactory.createNominalMeasurementsDao(ds.getValuesUuid());
				};
				public NominalMeasurementsDao caseJSXmlMeasurements(de.uka.ipd.sdq.edp2.models.emfmodel.JSXmlMeasurements object) {
					String msg = "Tried to request nominal measurements for a data series which should contain ordinal measurements.";
					logger.log(Level.WARNING, msg);
					throw new IllegalArgumentException(msg);
				};
				public NominalMeasurementsDao caseDoubleBinaryMeasurements(de.uka.ipd.sdq.edp2.models.emfmodel.DoubleBinaryMeasurements object) {
					String msg = "Tried to request nominal measurements for a data series which should contain ordinal measurements.";
					logger.log(Level.WARNING, msg);
					throw new IllegalArgumentException(msg);
				};
				public NominalMeasurementsDao caseLongBinaryMeasurements(de.uka.ipd.sdq.edp2.models.emfmodel.LongBinaryMeasurements object) {
					String msg = "Tried to request nominal measurements for a data series which should contain ordinal measurements.";
					logger.log(Level.WARNING, msg);
					throw new IllegalArgumentException(msg);
				};
			}.doSwitch(ds);
			if (!nmd.isOpen() && nmd.canOpen()) {
				try {
					nmd.open();
				} catch (DataNotAccessibleException e) {
					// Do nothing. Could simply not open the DAO.
				}
			}
			return nmd;
		}
	}
	
	/**Requests a DAO for a ordinal measurement.
	 * If the DAO does not exists it is created and opened automatically (if possible).
	 * @param ds The data series for which the DAO should be created.
	 * @return DAO for ordinal measurements.
	 */
	@SuppressWarnings("unchecked")
	public static OrdinalMeasurementsDao getOrdinalMeasurementsDao(
			final DataSeries ds) {
		final MeasurementsDaoFactory daoFactory = ds.getRawMeasurements()
				.getMeasurementRange().getMeasurement().getMeasure()
				.getExperimentGroup().getRepository()
				.getMeasurementsDaoFactory();
		if (daoFactory.getDaoRegistry().isRegistered(ds.getValuesUuid())) {
			return (OrdinalMeasurementsDao) daoFactory.getDaoRegistry().getMeasurementsDao(ds
					.getValuesUuid());
		} else {
			OrdinalMeasurementsDao omd = new EmfmodelSwitch<OrdinalMeasurementsDao>() {
				public OrdinalMeasurementsDao caseNominalMeasurements(de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasurements object) {
					String msg = "Tried to request ordinal measurements for a data series which should contain nominal measurements.";
					logger.log(Level.WARNING, msg);
					throw new IllegalArgumentException(msg);
				};
				public OrdinalMeasurementsDao caseJSXmlMeasurements(de.uka.ipd.sdq.edp2.models.emfmodel.JSXmlMeasurements object) {
					return daoFactory.createJScienceXmlMeasurementsDao(ds.getValuesUuid());
				};
				public OrdinalMeasurementsDao caseDoubleBinaryMeasurements(de.uka.ipd.sdq.edp2.models.emfmodel.DoubleBinaryMeasurements object) {
					BinaryMeasurementsDao bmd = daoFactory.createDoubleMeasurementsDao(ds.getValuesUuid());
					bmd.setUnit(object.getStorageUnit());
					return bmd;
				};
				public OrdinalMeasurementsDao caseLongBinaryMeasurements(de.uka.ipd.sdq.edp2.models.emfmodel.LongBinaryMeasurements object) {
					BinaryMeasurementsDao bmd = daoFactory.createLongMeasurementsDao(ds.getValuesUuid());
					bmd.setUnit(object.getStorageUnit());
					return bmd;
				};
			}.doSwitch(ds);
			if (!omd.isOpen() && omd.canOpen()) {
				try {
					omd.open();
				} catch (DataNotAccessibleException e) {
					// Do nothing. Could simply not open the DAO.
				}
			}
			return omd;
		}
	}
}
