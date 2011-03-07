package de.uka.ipd.sdq.probespec.framework.test;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Quantity;

import junit.framework.TestCase;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.IMatchRule;
import de.uka.ipd.sdq.probespec.framework.ProbeIDMatchRule;
import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.ProbeTypeMatchRule;

public class MatchRulesTest extends TestCase {

	private ProbeSample<Integer, Dimensionless> ps1;

	private ProbeSample<Integer, Dimensionless> ps2;

	private Vector<ProbeSample<?, ? extends Quantity>> v;

	private ProbeSetSample pss;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// Create first probeSample
		Measure<Integer, Dimensionless> measure1 = Measure.valueOf(100,
				Dimensionless.UNIT);
		ps1 = new ProbeSample<Integer, Dimensionless>(measure1,
				"CPUCore1Probe", ProbeType.RESOURCE_STATE);

		// Create second probeSample
		Measure<Integer, Dimensionless> measure2 = Measure.valueOf(100,
				Dimensionless.UNIT);
		ps2 = new ProbeSample<Integer, Dimensionless>(measure2,
				"CPUCore2Probe", ProbeType.RESOURCE_STATE);

		// Create a probe set sample from the probe samples
		v = new Vector<ProbeSample<?, ? extends Quantity>>();
		v.add(ps1);
		v.add(ps2);
		pss = new ProbeSetSample(v, new RequestContext("1"),
				"modelElementID", 1);
	}

	public void testProbeIDMatchRule1() {
		IMatchRule[] rules = { new ProbeIDMatchRule("CPUCore1Probe") };
		Vector<ProbeSample<?, ? extends Quantity>> result = pss
				.getProbeSamples(rules);

		assertTrue(result.size() == 1);
		assertTrue(result.get(0) == ps1);
	}

	public void testProbeIDMatchRule2() {
		IMatchRule[] rules = { new ProbeIDMatchRule("CPUCore2Probe") };
		Vector<ProbeSample<?, ? extends Quantity>> result = pss
				.getProbeSamples(rules);

		assertTrue(result.size() == 1);
		assertTrue(result.get(0) == ps2);
	}

	public void testProbeTypeMatchRule() {
		IMatchRule[] rules = { new ProbeTypeMatchRule(
				ProbeType.RESOURCE_STATE) };
		Vector<ProbeSample<?, ? extends Quantity>> result = pss
				.getProbeSamples(rules);

		assertTrue(result.size() == 2);
		assertTrue(result.contains(ps1));
		assertTrue(result.contains(ps2));
	}

}
