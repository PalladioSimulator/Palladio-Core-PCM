package de.uka.ipd.sdq.pipesandfilters.framework.test;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.pipesandfilters.framework.CaptureType;
import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.PipesAndFiltersManager;
import de.uka.ipd.sdq.pipesandfilters.framework.Scale;
import de.uka.ipd.sdq.pipesandfilters.framework.edp2.EDP2MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.filters.ExampleFilter;
import de.uka.ipd.sdq.pipesandfilters.framework.filters.SimpleWarmUpFilter;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.SlidingMeanRecorder;

import junit.framework.TestCase;

/**
 * This TestCase tests the pipes and filters manager, and all so far implemented
 * filters and recorders.
 * 
 * @author Baum
 * 
 */
public class PipesAndFiltersManagerTest extends TestCase {

	private SimpleWarmUpFilter warmupFilter;
	private ExampleFilter exampleFilter;
	private PipesAndFiltersManager manager;
	private DummyAggregationWriteStrategy unfilteredAggWriteStrategy;
	private DummyAggregationWriteStrategy filteredAggWriteStrategy;
	private DummyAggregationWriteStrategy lastNAggWriteStrategy;
	private SlidingMeanRecorder unfilteredMeanRecorder;
	private SlidingMeanRecorder lastNRecorder;
	private SlidingMeanRecorder filteredMeanRecorder;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// Initializing meta data for the recorders is set.
		Vector<MeasurementMetric> measuredObjects = new Vector<MeasurementMetric>();
		MeasurementMetric o = new MeasurementMetric(CaptureType.REAL_NUMBER, SI
				.MILLI(SI.SECOND), Scale.ORDINAL);
		measuredObjects.add(o);
		EDP2MetaDataInit metaInit = new EDP2MetaDataInit(measuredObjects);

		// Create filters and recorders for the chain.
		warmupFilter = new SimpleWarmUpFilter(10);
		exampleFilter = new ExampleFilter();
		filteredAggWriteStrategy = new DummyAggregationWriteStrategy();
		unfilteredAggWriteStrategy = new DummyAggregationWriteStrategy();
		lastNAggWriteStrategy = new DummyAggregationWriteStrategy();
		filteredMeanRecorder = new SlidingMeanRecorder(
				filteredAggWriteStrategy, 20);
		unfilteredMeanRecorder = new SlidingMeanRecorder(
				unfilteredAggWriteStrategy, 20);
		lastNRecorder = new SlidingMeanRecorder(lastNAggWriteStrategy, 3);

		// Add filters and recorders to the manager.
		manager = new PipesAndFiltersManager(new ExampleFilter());
		manager.addElement(warmupFilter);
		manager.addElement(exampleFilter);
		manager.addElement(filteredMeanRecorder);
		manager.addElement(unfilteredMeanRecorder);
		manager.addElement(lastNRecorder);
		// Add pipes ( == connections) to the manager
		manager.addConnection(manager.getStartElement(), warmupFilter);
		manager.addConnection(warmupFilter, exampleFilter);
		manager.addConnection(warmupFilter, filteredMeanRecorder);
		manager
				.addConnection(manager.getStartElement(),
						unfilteredMeanRecorder);
		manager.addConnection(manager.getStartElement(), lastNRecorder);

		manager.initialize(metaInit);
	}

	public void testPipesAndFiltersManager() {
		PipeData data;
		double count = 0.0;

		for (int i = 0; i < 20; i++) {
			Vector<Measure<?, ? extends Quantity>> m = new Vector<Measure<?, ? extends Quantity>>();
			m.add(Measure.valueOf(i, SI.SECOND));

			data = new PipeData(m);
			manager.processData(data);

			count += i;

			// unfiltered recorder assertion:
			double expectedSlidingMean = count / (i + 1);
			assertEquals(expectedSlidingMean,
					(Double) unfilteredAggWriteStrategy
							.getLastArrivedPipeData().getTupleElement(0)
							.getValue());

			// last N recorder assertion:
			expectedSlidingMean = (double) (i + Math.max(i - 1, 0) + Math.max(
					i - 2, 0))
					/ Math.min(i + 1, 3);
			assertEquals(expectedSlidingMean, (Double) lastNAggWriteStrategy
					.getLastArrivedPipeData().getTupleElement(0).getValue());

		}
		manager.finalize();

		assertEquals(10, exampleFilter.getReceiveCount());
		assertEquals(14.5, (Double) filteredAggWriteStrategy
				.getLastArrivedPipeData().getTupleElement(0).getValue());

		System.out.println((Double) filteredAggWriteStrategy
				.getLastArrivedPipeData().getTupleElement(0).getValue());

	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
}