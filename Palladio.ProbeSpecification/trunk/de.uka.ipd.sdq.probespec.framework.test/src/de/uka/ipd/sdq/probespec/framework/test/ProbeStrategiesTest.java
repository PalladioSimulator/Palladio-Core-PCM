package de.uka.ipd.sdq.probespec.framework.test;

import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import junit.framework.TestCase;
import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.probes.AProbeStrategyFactory;
import de.uka.ipd.sdq.probespec.framework.probes.example.ASimpleActiveResource;
import de.uka.ipd.sdq.probespec.framework.probes.example.ASimplePassiveResource;
import de.uka.ipd.sdq.probespec.framework.probes.example.SimpleDemandingComponent;
import de.uka.ipd.sdq.probespec.framework.probes.example.ExampleProbeStrategyFactory;
import de.uka.ipd.sdq.probespec.framework.probes.example.SimpleSimulationContext;
import de.uka.ipd.sdq.probespec.framework.probes.example.SimpleCPUResource;
import de.uka.ipd.sdq.probespec.framework.probes.example.SimpleHDDResource;
import de.uka.ipd.sdq.probespec.framework.probes.example.SimpleMutEx;
import de.uka.ipd.sdq.probespec.framework.probes.example.SimpleSEFFParameter;
import de.uka.ipd.sdq.probespec.framework.probes.example.SimpleStoEx;

public class ProbeStrategiesTest extends TestCase {

	private AProbeStrategyFactory factory;

	private SimpleSimulationContext ctx;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		ctx = new SimpleSimulationContext();
		factory = new ExampleProbeStrategyFactory(ctx);
	}

	public void testTakeCPUDemandStrategy() {
		ASimpleActiveResource cpu = new SimpleCPUResource();
		SimpleDemandingComponent comp = new SimpleDemandingComponent();
		comp.setDemand(cpu, 10);

		ProbeSample<Double, Dimensionless> sample = factory.getTakeCPUDemand()
				.takeSample("probeId", cpu, comp);

		assertEquals(10d, sample.getMeasure().doubleValue(Dimensionless.UNIT));
	}

	public void testTakeCPUStateStrategy() {
		ASimpleActiveResource cpu = new SimpleCPUResource();
		cpu.setJobs(5);
		ctx.addActiveResource("CPU 1", cpu);

		ProbeSample<Integer, Dimensionless> sample = factory.getTakeCPUState()
				.takeSample("probeId", cpu);

		assertEquals(5, sample.getMeasure().intValue(Dimensionless.UNIT));
	}

	public void testTakeCurrentTimeStrategy() {
		ctx.setSimulatedTime(1500); // milliseconds

		ProbeSample<Long, Duration> sample = factory.getTakeCurrentTime()
				.takeSample("probeId");

		assertEquals(1500l, sample.getMeasure().longValue(SI.MILLI(SI.SECOND)));
	}

	public void testTakeHDDDemandStrategy() {
		ASimpleActiveResource hdd = new SimpleHDDResource();
		SimpleDemandingComponent comp = new SimpleDemandingComponent();
		comp.setDemand(hdd, 10);

		ProbeSample<Double, Dimensionless> sample = factory.getTakeHDDDemand()
				.takeSample("probeId", hdd, comp);

		assertEquals(10d, sample.getMeasure().doubleValue(Dimensionless.UNIT));
	}

	public void testTakeHDDStateStrategy() {
		ASimpleActiveResource hdd = new SimpleHDDResource();
		hdd.setJobs(5);
		ctx.addActiveResource("HDD 1", hdd);

		ProbeSample<Integer, Dimensionless> sample = factory.getTakeHDDState()
				.takeSample("probeId", hdd);

		assertEquals(5, sample.getMeasure().intValue(Dimensionless.UNIT));
	}

	public void testTakePassiveResourceStateStrategy() {
		ASimplePassiveResource mutex = new SimpleMutEx();
		if (mutex.canAcquire())
			mutex.acquire();

		ProbeSample<Integer, Dimensionless> sample1 = factory
				.getTakePassiveResourceStateStrategy().takeSample("probeId",
						mutex);

		assertEquals(0, sample1.getMeasure().intValue(Dimensionless.UNIT));

		mutex.release();

		ProbeSample<Integer, Dimensionless> sample2 = factory
				.getTakePassiveResourceStateStrategy().takeSample("probeId",
						mutex);

		assertEquals(1, sample2.getMeasure().intValue(Dimensionless.UNIT));
	}

	public void testTakeSEFFParameterStrategy() {
		SimpleSEFFParameter<Double> param = new SimpleSEFFParameter<Double>();
		param.setValue(2.345);

		ProbeSample<?, Dimensionless> sample = factory
				.getSEFFParameterStrategy().takeSample("probeId", param);

		assertEquals(2.345, sample.getMeasure().doubleValue(Dimensionless.UNIT));
	}

	public void testTakeStoExStrategy() {
		SimpleStoEx stoex = new SimpleStoEx();
		stoex.setEvaluatedExpression(10.2);

		ProbeSample<Double, Dimensionless> sample = factory.getStoExStrategy()
				.takeSample("probeId", stoex);

		assertEquals(10.2, sample.getMeasure().doubleValue(Dimensionless.UNIT));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
}
