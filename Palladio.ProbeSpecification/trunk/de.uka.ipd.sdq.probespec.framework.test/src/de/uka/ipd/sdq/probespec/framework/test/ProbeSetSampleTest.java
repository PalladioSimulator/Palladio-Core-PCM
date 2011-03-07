package de.uka.ipd.sdq.probespec.framework.test;

import java.util.Vector;

import javax.measure.quantity.Quantity;

import junit.framework.TestCase;
import de.uka.ipd.sdq.probespec.framework.IMatchRule;
import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.ProbeTypeMatchRule;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.probes.AProbeStrategyFactory;
import de.uka.ipd.sdq.probespec.framework.probes.example.ExampleProbeStrategyRegistry;
import de.uka.ipd.sdq.probespec.framework.probes.example.SimpleSimulationContext;

public class ProbeSetSampleTest extends TestCase {

	private AProbeStrategyFactory factory;

	private SimpleSimulationContext simCtx;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		simCtx = new SimpleSimulationContext();

		// Obtain the suitable probeFactory
		factory = new ExampleProbeStrategyRegistry(simCtx);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testProbeSetSample() {
		simCtx.setSimulatedTime(100);

		Vector<ProbeSample<?, ? extends Quantity>> v = new Vector<ProbeSample<?, ? extends Quantity>>();

		// Take a sample of the current simulation time
		v.add(factory.getTakeCurrentTime().takeSample("theProbeID"));

		// Create a ProbeSetSample
		RequestContext ctxID = new RequestContext("1");
		ProbeSetSample pss = new ProbeSetSample(v, ctxID, "x", "y");

		// Check, whether the probeSetSample returns the correct value for the
		// previously measured simulation time
		IMatchRule[] rules = { new ProbeTypeMatchRule(ProbeType.CURRENT_TIME) };
		assertEquals(100l, pss.getProbeSamples(rules).get(0).getMeasure()
				.getValue());
	}

}
