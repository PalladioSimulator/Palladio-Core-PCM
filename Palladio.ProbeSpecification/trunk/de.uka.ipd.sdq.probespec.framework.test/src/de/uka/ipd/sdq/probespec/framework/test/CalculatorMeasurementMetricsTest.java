package de.uka.ipd.sdq.probespec.framework.test;

import junit.framework.TestCase;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.calculator.CPUStateCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.Calculator;
import de.uka.ipd.sdq.probespec.framework.calculator.ResponseTimeCalculator;

public class CalculatorMeasurementMetricsTest extends TestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testMeasurementMetrics() {
		SampleBlackboard bb = new SampleBlackboard();
		Calculator response = new ResponseTimeCalculator(bb, "", "");
		Calculator cpu = new CPUStateCalculator(bb, "");
		
		assertEquals(2, cpu.getMeasurementMetrics().size());
		System.out.println(cpu.getMeasurementMetrics().get(0).getDescription() + ";  " + cpu.getMeasurementMetrics().get(0).getName());
		System.out.println(cpu.getMeasurementMetrics().get(1).getDescription() + ";  " + cpu.getMeasurementMetrics().get(1).getName());
		assertEquals(1, response.getMeasurementMetrics().size()) ;
		System.out.println(response.getMeasurementMetrics().get(0).getDescription() + ";  " + response.getMeasurementMetrics().get(0).getName());		
	}
	
}
