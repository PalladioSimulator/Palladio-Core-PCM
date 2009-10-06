/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import de.uka.ipd.sdq.edp2.example.ExampleData;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementsRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;

/**Test of the utility class MeasurementsUtility.
 * @author groenda
 *
 */
public class MeasurementsUtilityTest {
	private static ExperimentDataFactory factory = ExperimentDataFactory.eINSTANCE;
	
	@Test (expected = IllegalStateException.class)
	public void addDataSeriesOnUnassignedRawMeasurements() {
		RawMeasurements rm = factory.createRawMeasurements();
		de.uka.ipd.sdq.edp2.impl.MeasurementsUtility.addDataSeries(rm);
	}
	
	@Test (expected = IllegalStateException.class)
	public void addDataSeriesTwiceOnSameRawMeasurements() throws IOException {
		LocalDirectoryRepository ldRepo = createRepository();
		MeasurementsRange range = createMeasurementsRangeFromScratch(ldRepo);
		// Create only raw measurements
		RawMeasurements rm = factory.createRawMeasurements();
		range.setRawMeasurements(rm);
		MeasurementsUtility.addDataSeries(rm);
		// Now: Add another time to check for error
		MeasurementsUtility.addDataSeries(rm);
	}

	private MeasurementsRange createMeasurementsRangeFromScratch(LocalDirectoryRepository ldRepo)
			throws IOException {
		// Add Descriptions
		ExampleData ed = new ExampleData();
		ldRepo.getDescriptions().addAll(ed.createDescriptions());
		// Add structure down to a measurement setting instance
		ldRepo.getExperimentGroups().add(ed.createExperimentalGroupAndSetting());
		// Create experiment run
		Measurements measurementServiceCallA = factory.createMeasurements();
		measurementServiceCallA.setMeasure(ldRepo.getExperimentGroups().get(0).getMeasure().get(0));
		ExperimentRun runA0 = factory.createExperimentRun();
		runA0.getMeasurements().add(measurementServiceCallA);
		ldRepo.getExperimentGroups().get(0).getExperimentSettings().get(0).getExperimentRuns().add(runA0);
		// Create measurement range
		MeasurementsRange range = MeasurementsUtility.addMeasurementRange(measurementServiceCallA);
		return range;
	}

	private LocalDirectoryRepository createRepository() throws IOException {
		// Initialize repository
		LocalDirectoryRepositoryTest ldrTest = new LocalDirectoryRepositoryTest();
		LocalDirectoryRepository ldRepo = (LocalDirectoryRepository) ldrTest.initializeRepository();
		RepositoryManager.addRepository(RepositoryManager.getCentralRepository(), ldRepo);
		return ldRepo;
	}
	
	@Test
	public void addMeasurementRangeWithPreexistingEmptyRange() throws IOException {
		LocalDirectoryRepository ldRepo = createRepository();
		MeasurementsRange range = createMeasurementsRangeFromScratch(ldRepo);
		MeasurementsRange range2 = MeasurementsUtility.addMeasurementRange(ldRepo.getExperimentGroups().get(0).getExperimentSettings().get(0).getExperimentRuns().get(0).getMeasurements().get(0));
		Assert.assertNull("Initialization of test failed.", range.getRawMeasurements());
		Assert.assertNull("Copy of empty measurement range contains raw measurements.", range2.getRawMeasurements());
		Assert.assertTrue("Initialization of test failed.", range.getAggregatedMeasurements().size() == 0);
		Assert.assertTrue("Copy of empty measurement range contains aggregated measurements.", range2.getAggregatedMeasurements().size() == 0);
	}
	
	@Test
	public void addMeasurementRangeWithPreexistingRange() throws IOException {
		LocalDirectoryRepository ldRepo = createRepository();
		MeasurementsRange range = createMeasurementsRangeFromScratch(ldRepo);
		// populate first range
		RawMeasurements rm = factory.createRawMeasurements();
		range.setRawMeasurements(rm);
		MeasurementsUtility.addDataSeries(rm);
		// copy
		MeasurementsRange range2 = MeasurementsUtility.addMeasurementRange(ldRepo.getExperimentGroups().get(0).getExperimentSettings().get(0).getExperimentRuns().get(0).getMeasurements().get(0));
		Assert.assertEquals("Number of data series must be equal.", range.getRawMeasurements().getDataSeries().size(), range2.getRawMeasurements().getDataSeries().size());
		Assert.assertNotNull("1st data series was not copied.", range2.getRawMeasurements().getDataSeries().get(0));
		Assert.assertFalse("1st data series must have another uuid.", range.getRawMeasurements().getDataSeries().get(0).getValuesUuid().equals(range2.getRawMeasurements().getDataSeries().get(0).getValuesUuid()));
		Assert.assertNotNull("2nd data series was not copied.", range2.getRawMeasurements().getDataSeries().get(1));
		Assert.assertFalse("2nd data series must have another uuid.", range.getRawMeasurements().getDataSeries().get(1).getValuesUuid().equals(range2.getRawMeasurements().getDataSeries().get(1).getValuesUuid()));
	}
}
