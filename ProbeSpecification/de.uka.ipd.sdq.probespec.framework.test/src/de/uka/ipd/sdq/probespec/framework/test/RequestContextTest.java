package de.uka.ipd.sdq.probespec.framework.test;

import junit.framework.TestCase;
import de.uka.ipd.sdq.probespec.framework.RequestContext;

public class RequestContextTest extends TestCase {

	public void testEquals() {
		RequestContext ctx1 = new RequestContext("1");
		RequestContext ctx2 = new RequestContext("2");
		RequestContext ctx3 = new RequestContext("1");
		
		assertFalse(ctx1.equals(ctx2));
		assertFalse(ctx2.equals(ctx1));
		
		assertFalse(ctx2.equals(ctx3));
		assertFalse(ctx3.equals(ctx2));
		
		assertTrue(ctx1.equals(ctx3));
		assertTrue(ctx3.equals(ctx1));
	}
	
	public void testAppendWithoutParent() {
		RequestContext sourceContext = new RequestContext("aContext");
		RequestContext extendedContext = sourceContext.append("_anAddition");

		String extendedContextId = "aContext" + "_anAddition";
		assertEquals(extendedContextId, extendedContext.getRequestContextId());
		assertEquals(new RequestContext(extendedContextId), extendedContext);
	}
	
	public void testAppendWithParent() {
		RequestContext parentContext = new RequestContext("aParentContext");

		RequestContext sourceContext = new RequestContext("aContext",
				parentContext);
		RequestContext extendedContext = sourceContext.append("_anAddition");

		String extendedContextId = "aContext" + "_anAddition";
		assertEquals(extendedContextId, extendedContext.getRequestContextId());
		assertEquals(new RequestContext(extendedContextId, parentContext),
				extendedContext);
	}
	
}
