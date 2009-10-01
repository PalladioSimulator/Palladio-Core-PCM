package de.uka.ipd.sdq.probespec.framework.test;

import java.util.Random;
import java.util.Vector;

import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;

import junit.framework.TestCase;
import de.uka.ipd.sdq.pipesandfilters.framework.PipesAndFiltersManager;
import de.uka.ipd.sdq.pipesandfilters.framework.filters.ExampleFilter;
import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.RequestContextID;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.calculator.CPUStateCalculator;
import de.uka.ipd.sdq.probespec.framework.probes.example.ASimpleActiveResource;
import de.uka.ipd.sdq.probespec.framework.probes.example.ExampleProbeStrategyFactory;
import de.uka.ipd.sdq.probespec.framework.probes.example.SimpleCPUResource;
import de.uka.ipd.sdq.probespec.framework.probes.example.SimpleSimulationContext;

public class FrameworkTest2 extends TestCase {

	private SampleBlackboard blackboard;
	private SimpleSimulationContext simCtx;
	private ExampleProbeStrategyFactory factory;

	private CPUStateCalculator[] cpuCalc;
	private PipesAndFiltersManager[] cpuPipeManager;

	private static final String CPU1_NAME = "CPU 1";

	private static final int CPU_STATE_CALC_AMOUNT = 40;

	public FrameworkTest2() {
		try {
			setUp();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		testFramework();
		
		try {
			tearDown();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// initialize the simulation and the measured model elements
		simCtx = new SimpleSimulationContext();
		SimpleCPUResource cpu = new SimpleCPUResource();
		simCtx.addActiveResource(CPU1_NAME, cpu);

		cpuPipeManager = new PipesAndFiltersManager[CPU_STATE_CALC_AMOUNT];
		cpuCalc = new CPUStateCalculator[CPU_STATE_CALC_AMOUNT];

		initialize();
	}

	private void initialize() {
		blackboard = new SampleBlackboard();
		factory = new ExampleProbeStrategyFactory(simCtx);

		for (int i = 0; i < CPU_STATE_CALC_AMOUNT; i++) {
			cpuPipeManager[i] = new PipesAndFiltersManager(new ExampleFilter());
			cpuCalc[i] = new CPUStateCalculator(blackboard, "cpuStateProbeSet"
					+ i);
			cpuCalc[i].setPipesAndFiltersManager(cpuPipeManager[i]);
		}

	}

	public void testFramework() {
		long simTime = 0;

		for (int i = 0; i < 10000; i++) {
			int duration = new Double(new Random(i).nextDouble() * 300.0)
					.intValue();

			// Simulate the CPU utilization
			int jobs = i % 100;
			simCtx.getActiveResource(CPU1_NAME).setJobs(jobs);

			for (int j = 0; j < CPU_STATE_CALC_AMOUNT; j++) {
				// ----------------------------------------------------------------
				// Take a CPU state measurement
				ASimpleActiveResource cpuToMeasure = simCtx
						.getActiveResource(CPU1_NAME);
				ProbeSample<Integer, Dimensionless> cpuSample = factory
						.getTakeCPUState().takeSample("cpuProbeSample" + j,
								cpuToMeasure);

				// Take a current time measurement
				ProbeSample<Long, Duration> timeSample2 = factory
						.getTakeCurrentTime().takeSample("timeProbeSample" + j);

				// Generate a probe set sample from the probe samples
				Vector<ProbeSample<?, ? extends Quantity>> v = new Vector<ProbeSample<?, ? extends Quantity>>();
				v.add(timeSample2);
				v.add(cpuSample);
				ProbeSetSample pss = new ProbeSetSample(v,
						new RequestContextID(String.valueOf(i)), "",
						"cpuStateProbeSet" + j);
				pss.addToTimeToLive(1);

				// Publish probe sample on blackboard
				blackboard.addProbeSetSample(pss);

				// Check whether correct values arrived at the first pipe
				// element
				ExampleFilter filter = (ExampleFilter) cpuPipeManager[j]
						.getStartElement();
				assertEquals(jobs, ((Integer) filter.getLastArrivedData()
						.getTupleElement(1).getValue()).intValue());
				// ----------------------------------------------------------------

			}

			simTime += duration;

		}
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public static void main(String[] args) {
		new FrameworkTest2();
	}

}
