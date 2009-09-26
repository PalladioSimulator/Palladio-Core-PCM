package de.uka.ipd.sdq.statistics.independence.test;

import java.util.List;

import junit.framework.TestCase;
import de.uka.ipd.sdq.statistics.independence.IIndependenceTest;
import de.uka.ipd.sdq.statistics.independence.RunUpTest;
import de.uka.ipd.sdq.statistics.test.TestUtils;

public class TestRunUpTest extends TestCase {

	private IIndependenceTest indTest;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		this.indTest = new RunUpTest();
	}

	public void testDependence() {
		int desiredLag = 2;
		int numberOfSamples = indTest.getLowerSampleLimit();
		int repititions = 100;

		List<Double> samples = null;
		int indepCnt = 0;
		int depCnt = 0;
		for (int i = 0; i < repititions; i++) {
			samples = TestUtils.createSampleSequence(numberOfSamples,
					desiredLag);
			if (indTest.testIndependence(samples)) {
				++indepCnt;
			} else {
				++depCnt;
			}
		}

		System.out.println("Dependent: " + depCnt + ", Independent: "
				+ indepCnt);
		assertTrue(depCnt > indepCnt);
	}

	public void testIndependence() {
		int desiredLag = 1;
		int numberOfSamples = indTest.getLowerSampleLimit();
		int repititions = 100;

		List<Double> samples = null;
		int indepCnt = 0;
		int depCnt = 0;
		for (int i = 0; i < repititions; i++) {
			samples = TestUtils.createSampleSequence(numberOfSamples,
					desiredLag);
			if (indTest.testIndependence(samples)) {
				++indepCnt;
			} else {
				++depCnt;
			}
		}

		System.out.println("Dependent: " + depCnt + ", Independent: "
				+ indepCnt);
		assertTrue(depCnt < indepCnt);
	}

}
