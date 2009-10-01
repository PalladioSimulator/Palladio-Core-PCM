package de.uka.ipd.sdq.probespec.framework.test;

import junit.framework.TestCase;
import de.uka.ipd.sdq.probespec.framework.RequestContextID;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSampleID;
/**
 * 
 * @author Faber
 *
 */
public class ProbeSetSampleIDTest extends TestCase {
	ProbeSetSampleID pssID1_1_1;
	ProbeSetSampleID pssID1_1_2;
	ProbeSetSampleID pssID2_3_1;
	ProbeSetSampleID pssID1_3_1;
	ProbeSetSampleID pssID3_1_1;

	public ProbeSetSampleIDTest() {
	}

	@Override
	protected void setUp() throws Exception {
		pssID1_1_1 = new ProbeSetSampleID("1", new RequestContextID("1"));
		pssID1_1_2 = new ProbeSetSampleID("1", new RequestContextID("1"));
		pssID1_3_1 = new ProbeSetSampleID("1", new RequestContextID("3"));
		pssID3_1_1 = new ProbeSetSampleID("3", new RequestContextID("1"));
		pssID2_3_1 = new ProbeSetSampleID("2", new RequestContextID("3"));
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSame() {
		assertEquals(true, pssID1_1_1.equals(pssID1_1_1));
	}

	public void testDifferentTrue() {
		assertEquals(true, pssID1_1_1.equals(pssID1_1_2));
	}

	public void testDifferentFalse() {
		assertEquals(false, pssID1_1_1.equals(pssID2_3_1));
		assertEquals(false, pssID1_1_1.equals(pssID1_3_1));
		assertEquals(false, pssID1_1_1.equals(pssID3_1_1));
		
	}

	public void testToString() {
		assertEquals("1-1", pssID1_1_1.toString());
	}
}
