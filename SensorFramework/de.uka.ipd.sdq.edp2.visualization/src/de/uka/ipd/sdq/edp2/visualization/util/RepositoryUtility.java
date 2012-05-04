package de.uka.ipd.sdq.edp2.visualization.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.edp2.NominalMeasurementsDao;
import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.DataNotAccessibleException;
import de.uka.ipd.sdq.edp2.impl.Measurement;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.MetricDescriptionUtility;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Description;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Edp2Measure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifierBasedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.edp2.models.Repository.Repository;

/**
 * Utility class, which can be used to copy data, metrics and other relevant
 * Experiment data of a Repository in an easy way. Order in which different data
 * of a {@link Repository} must be copied (every element needs references on
 * previously copied ones):
 * <ol>
 * <li>{@link ExperimentGroup}</li>
 * <li>{@link ExperimentSetting}</li>
 * <li>{@link ExperimentRun}</li>
 * <li>{@link MetricDescription}</li>
 * <li>{@link Edp2Measure}</li>
 * <li>{@link Measurements}</li>
 * <li>{@link MeasurementsRange}</li>
 * <li>{@link RawMeasurements}</li>
 * <li>{@link DataSeries}</li>
 * </ol>
 * 
 * @author Dominik Ernst
 * 
 */
public class RepositoryUtility {
	/**
	 * Logger for this utility class.
	 */
	private static final Logger logger = Logger
			.getLogger(RepositoryUtility.class.getCanonicalName());

	/**
	 * Reference to the instance of {@link ExperimentDataFactory}.
	 */
	private final static ExperimentDataFactory factory = ExperimentDataFactory.eINSTANCE;

	/**
	 * Path to a {@link LocalDirectoryRepository}, which is typically used for
	 * temporary storage.
	 */
	private final static File LOCAL_REPO_URI = new File("C:\\Temp");

	/**
	 * The initialization of the local Repository.
	 */
	private final static Repository LOCAL_REPO = RepositoryManager
			.initializeLocalDirectoryRepository(LOCAL_REPO_URI);

	/**
	 * One-time initialization is done here.
	 */
	public RepositoryUtility() {
		RepositoryManager.addRepository(
				RepositoryManager.getCentralRepository(), LOCAL_REPO);
		LOCAL_REPO_URI.deleteOnExit();
	}

	/**
	 * 
	 * @return The URI (String) to the static local repository.
	 */
	public static String getDefaultLocalRepositoryURI() {
		return LOCAL_REPO_URI.getAbsolutePath();
	}

	/**
	 * 
	 * @return The reference to the static local repository.
	 */
	public static Repository getDefaultLocalRepository() {
		RepositoryManager.addRepository(
				RepositoryManager.getCentralRepository(), LOCAL_REPO);
		return LOCAL_REPO;
	}

	/**
	 * Method which closes the local repository. Should be called as soon as no
	 * longer any date are required, i.e. the editor/view is closed.
	 */
	public static void closeDefaultRepository() {
		try {
			MeasurementsUtility.ensureClosedRepository(LOCAL_REPO);
		} catch (DataNotAccessibleException e) {
			logger.log(Level.SEVERE,
					"local default repository could not be closed!");
			throw new RuntimeException();
		}
	}

	/**
	 * Creates a copy of an {@link ExperimentGroup}.
	 * 
	 * @param groupToCopy
	 *            the {@link ExperimentGroup}, which is to be copied.
	 * @param targetRepository
	 *            the {@link Repository} where the {@link ExperimentGroup} is to
	 *            be stored.
	 * @return reference to the newly created {@link ExperimentGroup}
	 */
	public static ExperimentGroup copyExperimentGroup(
			ExperimentGroup groupToCopy, Repository targetRepository) {
		ExperimentGroup experimentGroup = factory.createExperimentGroup();
		experimentGroup.setPurpose(groupToCopy.getPurpose());
		targetRepository.getExperimentGroups().add(experimentGroup);
		return experimentGroup;
	}

	/**
	 * 
	 * @param settingToCopy
	 *            the {@link ExperimentSetting}, which is to be copied.
	 * @param targetGroup
	 *            the {@link ExperimentGroup} to which the
	 *            {@link ExperimentSetting} is to be copied.
	 * @return reference to the newly created {@link ExperimentSetting}
	 */
	public static ExperimentSetting copyExperimentSetting(
			ExperimentSetting settingToCopy, ExperimentGroup targetGroup) {
		ExperimentSetting experimentSetting = factory.createExperimentSetting(
				targetGroup, settingToCopy.getDescription());
		return experimentSetting;
	}

	/**
	 * 
	 * @param runToCopy
	 *            the {@link ExperimentRun}, which is to be copied.
	 * @param targetSetting
	 *            the {@link ExperimentSetting} to which the
	 *            {@link ExperimentRun} is to be copied.
	 * @return reference to the newly created {@link ExperimentRun}
	 */
	public static ExperimentRun copyExperimentRun(ExperimentRun runToCopy,
			ExperimentSetting targetSetting) {
		ExperimentRun experimentRun = factory
				.createExperimentRun(targetSetting);
		experimentRun.setStartTime((Date) runToCopy.getStartTime().clone());
		// FIXME the getDuration method must be executed on the copied measure!
		experimentRun.setDuration(runToCopy.getDuration());
		return experimentRun;
	}

	/**
	 * Creates a copy of a {@link MetricDescription} in the target
	 * {@link Repository}. Uses recursion, if the {@link MetricDescription} is a
	 * {@link MetricSetDescription}. Returns null if the input is neither a
	 * {@link BaseMetricDescription} nor a {@link MetricSetDescription}.
	 * 
	 * @param metricDescriptionToCopy
	 *            the {@link MetricDescription}, which is to be copied.
	 * @param targetRepository
	 *            the {@link Repository} to which the {@link MetricDescription}
	 *            is to be copied.
	 * @return reference to the newly created {@link MetricDescription}
	 */
	public static MetricDescription copyMetricDescription(
			MetricDescription metricDescriptionToCopy,
			Repository targetRepository) {
		if (metricDescriptionToCopy instanceof BaseMetricDescription) {
			BaseMetricDescription baseDescToCopy = (BaseMetricDescription) metricDescriptionToCopy;
			if (baseDescToCopy instanceof NumericalBaseMetricDescription) {
				NumericalBaseMetricDescription numDescToCopy = (NumericalBaseMetricDescription) baseDescToCopy;
				NumericalBaseMetricDescription metricDescription = factory
						.createNumericalBaseMetricDescription(
								numDescToCopy.getName(),
								numDescToCopy.getTextualDescription(),
								numDescToCopy.getCaptureType(),
								numDescToCopy.getScale(),
								numDescToCopy.getDataType(),
								numDescToCopy.getDefaultUnit(),
								numDescToCopy.getMonotonic(),
								numDescToCopy.getPersistenceKind());
				targetRepository.getDescriptions().add(metricDescription);
				return metricDescription;
			} else if (baseDescToCopy instanceof TextualBaseMetricDescription) {
				TextualBaseMetricDescription textDescToCopy = (TextualBaseMetricDescription) baseDescToCopy;
				TextualBaseMetricDescription metricDescription = factory
						.createTextualBaseMetricDescription(
								textDescToCopy.getName(),
								textDescToCopy.getTextualDescription(),
								textDescToCopy.getScale(),
								textDescToCopy.getDataType(),
								textDescToCopy.getMonotonic());
				targetRepository.getDescriptions().add(metricDescription);
				return metricDescription;
			}
		} else if (metricDescriptionToCopy instanceof MetricSetDescription) {
			MetricSetDescription metricDescription = factory
					.createMetricSetDescription(
							metricDescriptionToCopy.getName(),
							metricDescriptionToCopy.getTextualDescription());
			for (MetricDescription metricsToCopy : ((MetricSetDescription) metricDescriptionToCopy)
					.getSubsumedMetrics()) {
				metricDescription.getSubsumedMetrics().add(
						copyMetricDescription(metricsToCopy, targetRepository));
			}
			targetRepository.getDescriptions().add(metricDescription);
			return metricDescription;
		}

		return null;

	}

	/**
	 * 
	 * @param edp2measureToCopy
	 * @param targetMetricDescription
	 * @param targetExperimentGroup
	 *            {@link ExperimentGroup} to which the {@link Edp2Measure} is
	 *            assigned.
	 * @param targetExperimentSetting
	 *            {@link ExperimentSetting} to which the {@link Edp2Measure} is
	 *            assigned.
	 * 
	 * @return the copy of the {@link Edp2Measure}
	 */
	public static Edp2Measure copyEdp2Measure(Edp2Measure edp2measureToCopy,
			MetricDescription targetMetricDescription,
			ExperimentGroup targetExperimentGroup,
			ExperimentSetting targetExperimentSetting) {
		Edp2Measure edp2measure = factory.createEdp2Measure(
				edp2measureToCopy.getMeasuredObject(), targetMetricDescription);
		targetExperimentGroup.getMeasure().add(edp2measure);
		targetExperimentSetting.getMeasure().add(edp2measure);
		return edp2measure;
	}

	/**
	 * Creates a copy of a {@link Measurements} using the specified
	 * {@link MetricDescription} for an underlying {@link Edp2Measure}. !!the
	 * {@link MetricDescription}, {@link ExperimentSetting},
	 * {@link ExperimentGroup} and {@link ExperimentRun} should (or must??) be
	 * in the same repository!!
	 * 
	 * @param forEdp2measure
	 *            the {@link Edp2Measure}, for which the .
	 * @param targetMetricDescription
	 *            the {@link MetricDescription} which is to be used for the
	 *            {@link Edp2Measure}.
	 * @param targetExperimentRun
	 *            {@link ExperimentRun} to which the {@link Measurements} is
	 *            assigned.
	 * @return reference to the newly created {@link MetricDescription}
	 */
	public static Measurements copyMeasurements(Edp2Measure forEdp2measure,
			MetricDescription targetMetricDescription,
			ExperimentRun targetExperimentRun) {

		Measurements measurements = factory.createMeasurements(forEdp2measure);
		targetExperimentRun.getMeasurements().add(measurements);
		return measurements;
	}

	/**
	 * Creates a copy of a given {@link MeasurementsRange}.
	 * 
	 * @param rangeToCopy
	 *            the original {@link MeasurementsRange}, which is to be copied.
	 * @param targetMeasurements
	 *            the {@link Measurements} for which the copied range is
	 *            created.
	 * @return reference to the newly created {@link MeasurementsRange}
	 */
	public static MeasurementsRange copyMeasurementsRange(
			MeasurementsRange rangeToCopy, Measurements targetMeasurements) {
		MeasurementsRange range = factory
				.createMeasurementsRange(targetMeasurements);
		range.setStartTime(rangeToCopy.getStartTime());
		range.setEndTime(rangeToCopy.getEndTime());
		return range;
	}

	/**
	 * Creates a new instance of RawMeasurements for a given
	 * {@link MeasurementsRange}.
	 * 
	 * @param forMeasurementsRange
	 *            the {@link MeasurementsRange} for which the RawMeasurements
	 *            are created.
	 * @return reference to the newly created {@link RawMeasurements}.
	 */
	public static RawMeasurements createRawMeasurements(
			MeasurementsRange forMeasurementsRange) {
		RawMeasurements rawMeasurements = factory
				.createRawMeasurements(forMeasurementsRange);
		return rawMeasurements;
	}

	/**
	 * Creates a copy of a {@link RawMeasurements} for a given
	 * {@link MeasurementsRange}. <b>Copies all subsumed DataSeries!</b>
	 * Currently works for ordinal Measurements only!
	 * 
	 * @param rawMeasurementsToCopy
	 *            the {@link RawMeasurements} which are to be copied.
	 * @param forMeasurementsRange
	 *            the {@link MeasurementsRange} for which the
	 *            {@link RawMeasurements} are copied (decisive for
	 *            {@link MetricDescription} and {@link Edp2Measure}.
	 * @return reference to the newly created {@link RawMeasurements}.
	 */
	public static RawMeasurements copyRawMeasurements(
			RawMeasurements rawMeasurementsToCopy,
			MeasurementsRange forMeasurementsRange) {
		RawMeasurements rawMeasurements = factory
				.createRawMeasurements(forMeasurementsRange);

		MetricDescription metric = forMeasurementsRange.getMeasurements()
				.getMeasure().getMetric();

		if (metric instanceof TextualBaseMetricDescription) {
			ArrayList<ObservedIdentifierBasedMeasurements> listOfMeasures = new ArrayList<ObservedIdentifierBasedMeasurements>();
			ArrayList<NominalMeasurementsDao> listOfDaos = new ArrayList<NominalMeasurementsDao>();
			for (DataSeries series : rawMeasurementsToCopy.getDataSeries()) {
				listOfDaos.add(MeasurementsUtility
						.getNominalMeasurementsDao(series));
			}
			for (NominalMeasurementsDao dao : listOfDaos) {
				listOfMeasures.add(dao.getObservedIdentifierBasedMeasurements());
			}
			MeasurementsUtility.createDAOsForRawMeasurements(rawMeasurements);
			for (int i = 0; i < listOfMeasures.size(); i++) {
				throw new RuntimeException();
				//TODO copy Measurements!
			}
			
		} else if (metric instanceof NumericalBaseMetricDescription) {
			ArrayList<OrdinalMeasurementsDao<Measure>> listOfDaos = new ArrayList<OrdinalMeasurementsDao<Measure>>();
			ArrayList<List<Measure>> listOfMeasures = new ArrayList<List<Measure>>();

			for (DataSeries series : rawMeasurementsToCopy.getDataSeries()) {
				listOfDaos.add(MeasurementsUtility
						.getOrdinalMeasurementsDao(series));
				
			}
			for (OrdinalMeasurementsDao<Measure> dao : listOfDaos) {
				listOfMeasures.add(dao.getMeasurements());
			}
			MeasurementsUtility.createDAOsForRawMeasurements(rawMeasurements);
			for (int j = 0; j < listOfMeasures.get(0).size(); j++) {
				Measurement measurement = new Measurement(metric);
				for (int dimension = 0; dimension < listOfMeasures.size(); dimension++) {
					Measure m = listOfMeasures.get(dimension).get(j);
					measurement.setMeasuredValue(dimension, m);
				}
				MeasurementsUtility.storeMeasurement(
						forMeasurementsRange.getMeasurements(), measurement);
			}
		} else {
			logger.log(Level.SEVERE, "Unsupported Base Metric: the selected measurements could not be opened, because it is neither described by a TextualBaseMetricDescription nor a NumericalBaseMetricDescription.");
			throw new RuntimeException("Unsupported Base Metric.");
		}
		return rawMeasurements;
	}

	/**
	 * This method copies one single {@link DataSeries} from the list of all
	 * available {@link DataSeries}. The {@link DataSeries} which is to be
	 * copied, is selected according to the specified {@link MetricDescription},
	 * i.e. the {@link DataSeries} element, which has the specified metric is
	 * selected. It is added to the data in {@link RawMeasurements}.
	 * 
	 * @param forMetric
	 *            the {@link MetricDescription} which is used for the copied
	 *            {@link DataSeries}
	 * @param fromDataSeries
	 *            the list of {@link DataSeries}
	 * @param toRawMeasurements
	 *            the target {@link RawMeasurements}
	 * @return reference to the list of {@link DataSeries}, to which the copied
	 *         element is added.
	 */
	public static EList<DataSeries> copySingleDataSeries(
			MetricDescription forMetric, EList<DataSeries> fromDataSeries,
			RawMeasurements toRawMeasurements) {

		throw new RuntimeException("Not working");

		/*
		 * ArrayList<MetricDescription> mds = new
		 * ArrayList<MetricDescription>(); BaseMetricDescription[] metrics =
		 * MetricDescriptionUtility
		 * .toBaseMetricDescriptions(fromDataSeries.get(0)
		 * .getRawMeasurements().getMeasurementsRange()
		 * .getMeasurements().getMeasure().getMetric()); for (int i = 0; i <
		 * metrics.length; i++) { mds.add(metrics[i]); } DataSeries selectedDS =
		 * null; for (MetricDescription md : mds) { if
		 * (md.getName().equals(forMetric.getName())) { logger.log(Level.FINE,
		 * "found a metric match"); } } OrdinalMeasurementsDao dao =
		 * MeasurementsUtility .getOrdinalMeasurementsDao(selectedDS); List<?>
		 * measures = dao.getMeasurements();
		 * 
		 * for (int j = 0; j < measures.size(); j++) { Measurement measurement =
		 * new Measurement(forMetric); Measure m = (Measure) measures.get(j);
		 * measurement.setMeasuredValue(0, m);
		 * MeasurementsUtility.storeMeasurement(toRawMeasurements
		 * .getMeasurementsRange().getMeasurements(), measurement); } return
		 * toRawMeasurements.getDataSeries();
		 */
	}

	/**
	 * Creates a new {@link Measurements} object, which needs a reference on an
	 * earlier created {@link Edp2Measure}.
	 * 
	 * @param forEdp2Measure
	 *            the referenced {@link Edp2Measure}
	 * @return the new {@link Measurements} object
	 */
	public static Measurements createMeasurements(Edp2Measure forEdp2Measure) {
		Measurements measurements = factory.createMeasurements();
		measurements.setMeasure(forEdp2Measure);
		return measurements;
	}

	/**
	 * Creates a copy of another {@link Edp2Measure} using the specified
	 * {@link MetricDescription}, but the same measured Object (only a
	 * {@link String} description of what is measured). The copy gets assigned a
	 * newly created {@link ExperimentGroup}, which is connected to the local,
	 * temporary {@link Repository}. This is required to allow further
	 * transformations to create DAOs (i.e. {@link DataSeries} which are
	 * connected possibly later on).
	 * 
	 * @param edp2measureToCopy
	 *            the "copied" {@link Edp2Measure}
	 * @param targetMetricDescription
	 *            the new {@link MetricDescription}
	 * @return reference
	 */
	public static Edp2Measure createEdp2Measure(Edp2Measure edp2measureToCopy,
			MetricDescription targetMetricDescription) {
		Edp2Measure edp2measure = factory.createEdp2Measure(
				edp2measureToCopy.getMeasuredObject(), targetMetricDescription);
		ExperimentGroup dummyGroup = factory.createExperimentGroup();
		dummyGroup.setRepository(getDefaultLocalRepository());
		edp2measure.setExperimentGroup(dummyGroup);

		return edp2measure;
	}

	/**
	 * Uses the {@link #copyMetricDescription(MetricDescription, Repository)}
	 * method with the default local repository (transparent for the user).
	 * 
	 * @param metricDescriptionToCopy
	 *            the {@link MetricDescription} to be copied
	 * @return a local copy of a {@link MetricDescription}
	 */
	public static MetricDescription copyMetricDescriptionSilent(
			MetricDescription metricDescriptionToCopy) {
		return copyMetricDescription(metricDescriptionToCopy,
				getDefaultLocalRepository());
	}
}
