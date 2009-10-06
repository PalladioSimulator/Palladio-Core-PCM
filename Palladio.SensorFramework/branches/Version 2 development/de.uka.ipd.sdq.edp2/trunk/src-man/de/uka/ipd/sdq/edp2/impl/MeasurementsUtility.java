/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.MeasurementsDaoFactory;
import de.uka.ipd.sdq.edp2.MeasurementsDaoRegistry;
import de.uka.ipd.sdq.edp2.NominalMeasurementsDao;
import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.internal.DataSeriesFromMeasureSwitch;
import de.uka.ipd.sdq.edp2.internal.EmfmodelAddMeasurementToDataSeriesSwitch;
import de.uka.ipd.sdq.edp2.internal.EmfmodelDataSeriesFromReferenceSwitch;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.FixedIntervals;
import de.uka.ipd.sdq.edp2.models.ExperimentData.FixedWidthAggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;

/**This class provides utility functions to handle measurements.
 * @author groenda
 */
public class MeasurementsUtility {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(MeasurementsUtility.class.getCanonicalName());
	/** EMF factory used by this instance. */
	private static final ExperimentDataFactory factory = ExperimentDataFactory.eINSTANCE;

	/**Creates a new MeasurementRange and contained elements if there
	 * are already existing elements in another MeasurementRange.
	 * Does not set the startTime and endTime properties.
	 * @param measurements Location where to add the range.
	 * @return The newly created measurement range.
	 */
	public static MeasurementsRange addMeasurementRange(Measurements measurements) {
		MeasurementsDaoFactory daoFactory = measurements.getMeasure().getExperimentGroup().getRepository().getMeasurementsDaoFactory();
		MeasurementsRange mr = factory.createMeasurementsRange();
		measurements.getMeasurementsRange().add(mr);
		if (measurements.getMeasurementsRange().size() > 1) { // copy contents from existing templates
			MeasurementsRange template = measurements.getMeasurementsRange().get(0);
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
		// TODO: Add parameter currentTime to allow range(n-1).endtime=currentTime,range(n).starttime=currentTime
		// TODO: Create MeasurementsRange for all Measurements of an ExperimentRun -> Refactor from Measurements to ExperimentRun
	}

	/**Creates the model elements linked as data series corresponding
	 * to the definition in the metric and measure.
	 * If there are already existing definitions in another MeasurementRange
	 * these are used as templates during creation.
	 * @param rm Location at which the data series elements are added.
	 */
	public static void addDataSeries(RawMeasurements rm) {
		if (rm.getDataSeries().size() != 0) {
			String msg = "Adding of a data series on a raw measurement is only allowed once, " +
					"as this allows to initialize the raw measurement with exactly one data " +
					"series for each basic metric contained in the correspondig metric definition.";
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg);
		}
		// Test if Raw Measurements is assigned in the right place
		String msg = null;
		if (rm.getMeasurementsRange() == null) {
			msg = "RawMeasurements must be assigned to a measurement range.";
		} else if (rm.getMeasurementsRange().getMeasurements() == null) {
			msg = "RawMeasurements must be (indirectly) assigned to a measurement.";
		} else if (rm.getMeasurementsRange().getMeasurements().getMeasure() == null) {
			msg = "RawMeasuremnts must be (indirectly) assigned to a measure (definition).";
		} else if (rm.getMeasurementsRange().getMeasurements().getMeasure().getExperimentGroup() == null) {
			msg = "RawMeasuremnts must be (indirectly) assigned to an experiment group.";
		} else if (rm.getMeasurementsRange().getMeasurements().getMeasure().getExperimentGroup().getRepository() == null) {
			msg = "RawMeasuremnts must be (indirectly) assigned to an experiment group which must be assigned to a repository.";
		}
		if (msg != null) {
			logger.log(Level.SEVERE, msg);
			throw new IllegalStateException(msg);
		}
		// 
		MeasurementsDaoFactory daoFactory = rm.getMeasurementsRange().getMeasurements().getMeasure().getExperimentGroup().getRepository().getMeasurementsDaoFactory();
		/* check if there are already existing RawMeasurements in other MeasurementRanges.
		 * Option 1: Copy those types (if existing).
		 */
		boolean creationSuccesful = false;
		if (rm.getMeasurementsRange() != null &&
				rm.getMeasurementsRange().getMeasurements() != null &&
				rm.getMeasurementsRange().getMeasurements().getMeasurementsRange().size() > 1) {
			Iterator<MeasurementsRange> iter = rm.getMeasurementsRange().getMeasurements().getMeasurementsRange().iterator();
			MeasurementsRange mr;
			while (iter.hasNext() && !creationSuccesful) {
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
		// Option 2: Create data series from information about the measure definition
		if (creationSuccesful == false) {
			Edp2Measure measure = rm.getMeasurementsRange().getMeasurements().getMeasure();
			assert measure != null;
			new DataSeriesFromMeasureSwitch(rm, measure, daoFactory).doSwitch(measure.getMetric());
		}
	}

	/**Stores a new measurement at the last existing range.
	 * @param measurements The measurement of the experiment run for which a new measurement exists.
	 * @param data The measurement (data) itself.
	 */
	public static void storeMeasurement(Measurements measurements, Measurement measurement) {
		MeasurementsDaoRegistry daoRegistry = measurements.getMeasure().getExperimentGroup().getRepository().getMeasurementsDaoFactory().getDaoRegistry();
		int size = measurements.getMeasurementsRange().size();
		MeasurementsRange lastRange = measurements.getMeasurementsRange().get(size - 1);
		RawMeasurements rm = lastRange.getRawMeasurements();
		if (rm != null) { // Add raw measurements
			if (!measurement.getMetric().equals(measurements.getMeasure().getMetric())) {
				String msg = "Tried to store measurement with a wrong metric. Expected: "
					+ measurements.getMeasure().getMetric()
					+ ", provided: "
					+ measurement.getMetric()
					+ ".";
				logger.log(Level.SEVERE, msg);
				throw new IllegalArgumentException(msg);
			}
			Iterator<DataSeries> iter = rm.getDataSeries().iterator();
			DataSeries ds;
			int dimension = -1;
			EmfmodelAddMeasurementToDataSeriesSwitch addMmt = new EmfmodelAddMeasurementToDataSeriesSwitch(daoRegistry);
			while (iter.hasNext()) {
				ds = iter.next();
				dimension++;
				addMmt.setMeasurementToAdd(measurement.getMeasuredValue(dimension));
				addMmt.doSwitch(ds);
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
				.getMeasurementsRange().getMeasurements().getMeasure()
				.getExperimentGroup().getRepository()
				.getMeasurementsDaoFactory();
		if (daoFactory.getDaoRegistry().isRegistered(ds.getValuesUuid())) {
			return (NominalMeasurementsDao) daoFactory.getDaoRegistry().getMeasurementsDao(ds.getValuesUuid());
		} else {
			NominalMeasurementsDao nmd = new ExperimentDataSwitch<NominalMeasurementsDao>() {
				public NominalMeasurementsDao caseNominalMeasurements(de.uka.ipd.sdq.edp2.models.ExperimentData.NominalMeasurements object) {
					return daoFactory.createNominalMeasurementsDao(ds.getValuesUuid());
				};
				public NominalMeasurementsDao caseJSXmlMeasurements(de.uka.ipd.sdq.edp2.models.ExperimentData.JSXmlMeasurements object) {
					String msg = "Tried to request nominal measurements for a data series which should contain ordinal measurements.";
					logger.log(Level.WARNING, msg);
					throw new IllegalArgumentException(msg);
				};
				public NominalMeasurementsDao caseDoubleBinaryMeasurements(de.uka.ipd.sdq.edp2.models.ExperimentData.DoubleBinaryMeasurements object) {
					String msg = "Tried to request nominal measurements for a data series which should contain ordinal measurements.";
					logger.log(Level.WARNING, msg);
					throw new IllegalArgumentException(msg);
				};
				public NominalMeasurementsDao caseLongBinaryMeasurements(de.uka.ipd.sdq.edp2.models.ExperimentData.LongBinaryMeasurements object) {
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
				.getMeasurementsRange().getMeasurements().getMeasure()
				.getExperimentGroup().getRepository()
				.getMeasurementsDaoFactory();
		if (daoFactory.getDaoRegistry().isRegistered(ds.getValuesUuid())) {
			return (OrdinalMeasurementsDao) daoFactory.getDaoRegistry().getMeasurementsDao(ds
					.getValuesUuid());
		} else {
			OrdinalMeasurementsDao omd = new ExperimentDataSwitch<OrdinalMeasurementsDao>() {
				public OrdinalMeasurementsDao caseNominalMeasurements(de.uka.ipd.sdq.edp2.models.ExperimentData.NominalMeasurements object) {
					String msg = "Tried to request ordinal measurements for a data series which should contain nominal measurements.";
					logger.log(Level.WARNING, msg);
					throw new IllegalArgumentException(msg);
				};
				public OrdinalMeasurementsDao caseJSXmlMeasurements(de.uka.ipd.sdq.edp2.models.ExperimentData.JSXmlMeasurements object) {
					return daoFactory.createJScienceXmlMeasurementsDao(ds.getValuesUuid());
				};
				public OrdinalMeasurementsDao caseDoubleBinaryMeasurements(de.uka.ipd.sdq.edp2.models.ExperimentData.DoubleBinaryMeasurements object) {
					BinaryMeasurementsDao bmd = daoFactory.createDoubleMeasurementsDao(ds.getValuesUuid());
					bmd.setUnit(object.getStorageUnit());
					return bmd;
				};
				public OrdinalMeasurementsDao caseLongBinaryMeasurements(de.uka.ipd.sdq.edp2.models.ExperimentData.LongBinaryMeasurements object) {
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
