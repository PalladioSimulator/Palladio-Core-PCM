package de.uka.ipd.sdq.probespec.framework.test;

import java.util.HashMap;

import junit.framework.TestCase;
import de.uka.ipd.sdq.probespec.framework.RequestContextID;

/**
 * 
 * @author Faber
 *
 */
public class ContextTest extends TestCase{

	public ContextTest() {
		
	}
	public void testEqual() {
		RequestContextID ctxID1 = new RequestContextID("1");
		RequestContextID ctxID2 = new RequestContextID("2");
		RequestContextID ctxID3 = new RequestContextID("1");
		
		assertEquals(false, ctxID1.equals(ctxID2));
		
		assertEquals(true, ctxID1.equals(ctxID3));
		HashMap<RequestContextID, String> map = new HashMap<RequestContextID, String>();
		
		map.put(ctxID1, "Test1");
		map.put(ctxID2, "Test2");
		
		assertEquals("Test1", (String)map.get(ctxID3));
		
		
	}
}
