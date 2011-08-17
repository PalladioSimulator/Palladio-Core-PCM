package de.uka.ipd.sdq.probespec.framework.test;

import junit.framework.TestCase;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.ProbeSetAndRequestContext;

/**
 * 
 * @author Faber
 * 
 */
public class ProbeSetAndRequestContextTest extends TestCase {

	ProbeSetAndRequestContext pssID1_1_1;
	ProbeSetAndRequestContext pssID1_1_2;
	ProbeSetAndRequestContext pssID2_3_1;
	ProbeSetAndRequestContext pssID1_3_1;
	ProbeSetAndRequestContext pssID3_1_1;

	public ProbeSetAndRequestContextTest() {
	}

	@Override
	protected void setUp() throws Exception {
		pssID1_1_1 = new ProbeSetAndRequestContext(1, new RequestContext("1"));
		pssID1_1_2 = new ProbeSetAndRequestContext(1, new RequestContext("1"));
		pssID1_3_1 = new ProbeSetAndRequestContext(1, new RequestContext("3"));
		pssID3_1_1 = new ProbeSetAndRequestContext(3, new RequestContext("1"));
		pssID2_3_1 = new ProbeSetAndRequestContext(2, new RequestContext("3"));
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

}
