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
import de.uka.ipd.sdq.pipesandfilters.framework.filters.Filter;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.RawRecorder;

import junit.framework.TestCase;

/**
 * This TestCase is supposed to check the performance of a filter chain
 * consisting of 10 filters and a raw recorder provided with a million data
 * objects.
 * 
 * @author Baum
 * 
 */
public class PipesAndFiltersPerformanceTest extends TestCase {

	private Filter[] filter = new ExampleFilter[9];
	private PipesAndFiltersManager manager;
	private DummyRawWriteStrategy writeStrategy;
	private RawRecorder recorder;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// Initializing meta data for the recorders is set.
		Vector<MeasurementMetric> measuredObjects = new Vector<MeasurementMetric>();
		MeasurementMetric o = new MeasurementMetric(CaptureType.REAL_NUMBER, SI
				.MILLI(SI.SECOND), Scale.ORDINAL);
		measuredObjects.add(o);
		EDP2MetaDataInit metaInit = new EDP2MetaDataInit(measuredObjects);

		manager = new PipesAndFiltersManager(new ExampleFilter());
		for (int i = 0; i < 9; i++) {
			// Add filters
			filter[i] = new ExampleFilter();
			manager.addElement(filter[i]);

			if (i > 0)
				manager.addConnection(filter[i - 1], filter[i]);
			else
				manager.addConnection(manager.getStartElement(), filter[i]);
		}

		writeStrategy = new DummyRawWriteStrategy();
		recorder = new RawRecorder(writeStrategy);
		manager.addElement(recorder);
		manager.addConnection(filter[8], recorder);

		manager.initialize(metaInit);
	}

	public void testPipesAndFiltersManager() {
		PipeData data;

		for (int i = 0; i < 1000000; i++) {
			Vector<Measure<?, ? extends Quantity>> m = new Vector<Measure<?, ? extends Quantity>>();
			m.add(Measure.valueOf(i, SI.SECOND));
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
