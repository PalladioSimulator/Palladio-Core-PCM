package de.uka.ipd.sdq.edp2.visualization.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.impl.Measurement;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.MetricDescriptionUtility;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
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
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription;
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
	 * The initialization of the local Repository.
	 */
	private final static Repository LOCAL_REPO = createTemporaryRepository();

	/**
	 * One-time initialization is done here.
	 */
	public RepositoryUtility() {
		RepositoryManager.addRepository(
				RepositoryManager.getCentralRepository(), LOCAL_REPO);
	}

	/**
	 * Create a temporary directory. Only used once.
	 * 
	 * @return the {@link File}-reference to the temporary directory.
	 */
	private static Repository createTemporaryRepository() {
		File temp = null;
		try {
			temp = File
					.createTempFile("temp", Long.toString(System.nanoTime()));
			if (!(temp.delete())) {
				throw new IOException("Could not delete temp file: "
						+ temp.getAbsolutePath());
			}

			if (!(temp.mkdir())) {
				throw new IOException("Could not create temp directory: "
						+ temp.getAbsolutePath());
			}

		} catch (IOException ioe) {
			logger.log(Level.SEVERE,
					"Could not modify a temp-directory. Check the VMs user priviliges:"
							+ ioe.getMessage());
		}
		return RepositoryManager.initializeLocalDirectoryRepository(temp);
	}

	/**
	 * 
	 * @return The reference to the static local repository.
	 */
	private static Repository getDefaultLocalRepository() {
		RepositoryManager.addRepository(
				RepositoryManager.getCentralRepository(), LOCAL_REPO);
		return LOCAL_REPO;
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
	private static ExperimentGroup copyExperimentGroup(
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
	private static ExperimentSetting copyExperimentSetting(
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
	private static ExperimentRun copyExperimentRun(ExperimentRun runToCopy,
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
	private static MetricDescription copyMetricDescription(
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
	private static Edp2Measure copyEdp2Measure(Edp2Measure edp2measureToCopy,
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
	private static Measurements copyMeasurements(Edp2Measure forEdp2measure,
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
	 * {@link MeasurementsRange}. <b>Copies all subsumed DataSeries!</b> This
	 * method is used internally only. For a public method, see {@link RepositoryUtility#copyRawMeasurements(RawMeasurements)}
	 * 
	 * @param rawMeasurementsToCopy
	 *            the {@link RawMeasurements} which are to be copied.
	 * @param forMeasurementsRange
	 *            the {@link MeasurementsRange} for which the
	 *            {@link RawMeasurements} are copied (decisive for
	 *            {@link MetricDescription} and {@link Edp2Measure}.
	 * @return reference to the newly created {@link RawMeasurements}.
	 */
	private static RawMeasurements copyRawMeasurements(
			RawMeasurements rawMeasurementsToCopy,
			MeasurementsRange forMeasurementsRange) {

		RawMeasurements rawMeasurements = factory
				.createRawMeasurements(forMeasurementsRange);

		MeasurementsUtility.createDAOsForRawMeasurements(rawMeasurements);

		MetricDescription metric = forMeasurementsRange.getMeasurements()
				.getMeasure().getMetric();
		BaseMetricDescription[] baseMetrics = MetricDescriptionUtility
				.toBaseMetricDescriptions(metric);

		//check if the direct submetrics are BaseMetricDescriptions
		//throw an exception if not, because there will be problems with transformations
		if (metric instanceof MetricSetDescription) {
			MetricDescription[] subMetrics = ((MetricSetDescription)metric).getSubsumedMetrics().toArray(new MetricDescription[1]);
			for (MetricDescription subMetric : subMetrics){
				if (subMetric instanceof MetricSetDescription) {
					logger.log(
							Level.SEVERE,
							"Unsupported Base Metric: the selected measurements could not be opened, because it is not describe by a BaseMetricDescription");
					throw new RuntimeException("Unsupported Metric (MetricSetDescription).");
				}
			}
		}
		
		Measurement measurement = new Measurement(metric);

		int numberOfItems = new NumberOfMeasurementsSwitch(
				rawMeasurementsToCopy).doSwitch(baseMetrics[0]);

		for (int i = 0; i < numberOfItems; i++) {
			measurement = new Measurement(metric);
			for (int dimension = 0; dimension < rawMeasurementsToCopy
					.getDataSeries().size(); dimension++) {
				new CopyMeasurementsSwitch(rawMeasurementsToCopy, i, dimension,
						measurement).doSwitch(baseMetrics[dimension]);
			}
			MeasurementsUtility.storeMeasurement(
					forMeasurementsRange.getMeasurements(), measurement);
		}
		return rawMeasurements;
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

	/**
	 * Creates a full copy of a provided {@link RawMeasurements} instance, using
	 * the same {@link MetricDescription} as for the original measurements.
	 * 
	 * @param rmTocopy
	 *            the {@link RawMeasurements} to be copied
	 * @return reference to the associated copy of {@link MeasurementsRange}
	 */
	public static MeasurementsRange copyRawMeasurements(RawMeasurements rmTocopy) {
		ExperimentGroup copyOfExpGroup = copyExperimentGroup(rmTocopy
				.getMeasurementsRange().getMeasurements().getExperimentRun()
				.getExperimentSetting().getExperimentGroup(),
				getDefaultLocalRepository());
		ExperimentSetting copyOfExpSetting = copyExperimentSetting(rmTocopy
				.getMeasurementsRange().getMeasurements().getExperimentRun()
				.getExperimentSetting(), copyOfExpGroup);
		ExperimentRun copyOfExperimentRun = copyExperimentRun(rmTocopy
				.getMeasurementsRange().getMeasurements().getExperimentRun(),
				copyOfExpSetting);
		Edp2Measure copyOfMeasure = copyEdp2Measure(rmTocopy
				.getMeasurementsRange().getMeasurements().getMeasure(),
				rmTocopy.getMeasurementsRange().getMeasurements().getMeasure()
						.getMetric(), copyOfExpGroup, copyOfExpSetting);
		Measurements copyOfMeasurements = copyMeasurements(copyOfMeasure,
				rmTocopy.getMeasurementsRange().getMeasurements().getMeasure()
						.getMetric(), copyOfExperimentRun);
		MeasurementsRange copyOfMeasurementsRange = copyMeasurementsRange(
				rmTocopy.getMeasurementsRange(), copyOfMeasurements);
		copyRawMeasurements(rmTocopy, copyOfMeasurementsRange);
		return copyOfMeasurementsRange;
	}
}
