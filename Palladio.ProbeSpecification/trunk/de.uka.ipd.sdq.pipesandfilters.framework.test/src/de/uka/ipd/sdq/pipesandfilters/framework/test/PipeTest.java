package de.uka.ipd.sdq.pipesandfilters.framework.test;

import java.io.File;
import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.SI;

import junit.framework.TestCase;
import de.uka.ipd.sdq.edp2.impl.RepositoryManager;
import de.uka.ipd.sdq.edp2.models.Repository.LocalDirectoryRepository;
import de.uka.ipd.sdq.pipesandfilters.framework.CaptureType;
import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.PipesAndFiltersManager;
import de.uka.ipd.sdq.pipesandfilters.framework.Scale;
import de.uka.ipd.sdq.pipesandfilters.framework.edp2.EDP2MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.filters.ExampleFilter;
import de.uka.ipd.sdq.pipesandfilters.framework.filters.Filter;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.RawRecorder;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.Recorder;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.edp2.Edp2RawWriteStrategy;

/**
 * A simple pipes and filters test, consisting of only an example filter and a
 * raw recorder. This test case actually stores the created measurements to
 * EDP2, so new files are generated whenever the test is executed.
 * 
 * @author Baum
 * 
 */
public class PipeTest extends TestCase {

	private Filter testfilter;
	private Recorder recorder;
	private Edp2RawWriteStrategy writeStrat;
	private PipesAndFiltersManager manager;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// Create a description of our calculator (the measured object)
		// Initializing meta data for the recorders is set.
		Vector<MeasurementMetric> measuredObjects = new Vector<MeasurementMetric>();
		MeasurementMetric o1 = new MeasurementMetric(CaptureType.REAL_NUMBER, SI
				.MILLI(SI.SECOND), Scale.ORDINAL);
		o1.setDescription("the simulated simulation time");
		o1.setMonotonic(false);
		o1.setName("time");
		o1.setStrongMonotonic(false);
		measuredObjects.add(o1);
		MeasurementMetric o2 = new MeasurementMetric(CaptureType.REAL_NUMBER, SI
				.MILLI(SI.SECOND), Scale.ORDINAL);
		measuredObjects.add(o2);
		MeasurementMetric o3 = new MeasurementMetric(CaptureType.REAL_NUMBER, SI
				.MILLI(SI.SECOND), Scale.ORDINAL);
		measuredObjects.add(o3);

		// Create filters and recorders for the chain.
		MetaDataInit metaInit = new EDP2MetaDataInit(measuredObjects);
		metaInit.setExperimentName("Experiment 1");
		metaInit.setMeasurementName("Calculator 1");

		// Set filters and recorders properties.
		testfilter = new ExampleFilter();
		writeStrat = new Edp2RawWriteStrategy();
		recorder = new RawRecorder(writeStrat);

		// Set filters and recorders properties.
		writeStrat.setDirectoryName("TestCaseMeasurements");

		manager = new PipesAndFiltersManager(testfilter);
		manager.addElement(recorder);
		manager.addConnection(testfilter, recorder);
		manager.initialize(metaInit);
	}
	
	/**Initializes the repository from which the data will be loaded.
	 */
	private void initializeRepository() {
		
		/**
		 * TODO: The local repository to save the data to, is hard coded now but should be retrieved 
		 * from settings. 
		 */
		//protected LocalDirectoryRepository ldRepo;
		LocalDirectoryRepository ldRepo = RepositoryManager.initializeLocalDirectoryRepository(new File("PipeTestMeasurements"));
		/* Add repository to a (optional) central directory of repositories. 
		 * This can be useful to manage more than one repository or have links
		 * between different existing repositories. 
		 * A repository must be connected to a instance of Repositories in order
		 * to be opened.*/
		RepositoryManager.addRepository(RepositoryManager.getCentralRepository(), ldRepo);
	}

	public void testPipe() {
		PipeData data;

		for (int i = 0; i < 10; i++) {
			Vector<Measure<?, ? extends Quantity>> m = new Vector<Measure<?, ? extends Quantity>>();
			m.add(Measure.valueOf(i, SI.SECOND));
			m.add(Measure.valueOf(200, SI.SECOND));
			m.add(Measure.valueOf(10 - i, SI.SECOND));

			data = new PipeData(m);

			manager.processData(data);
		}
		manager.finalize();
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
}
