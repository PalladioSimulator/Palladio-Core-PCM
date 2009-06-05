package de.uka.ipd.sdq.ByCounter.test;

import org.junit.Assert;

import org.junit.Test;

import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class TestMethodDescriptor {

	/**
	 * Test MethodDescriptor construction from a java signature.
	 */
	@Test
	public void testGetFromJavaSignature() {
		// TODO: add many more different signatures for testing.
		MethodDescriptor d = new MethodDescriptor("de.uka.ipd.sdq.ByCounter.test.Test",
				"public static void testVoid(int[][] a, org.junit.Test b)"
				);
		Assert.assertNotNull("Method descriptor was null. " + 
				"This means it could not be parsed correctly", d);
		Assert.assertEquals("Package name is not correct.", 
				"de.uka.ipd.sdq.ByCounter.test", d.getPackageName());
		Assert.assertEquals("Class name was not parsed correctly",
				"Test", d.getSimpleClassName());
		Assert.assertEquals("Canonical class name was not parsed correctly",
				"de.uka.ipd.sdq.ByCounter.test.Test", d.getCanonicalClassName());
		Assert.assertEquals("Method descriptor method name is not correct.", 
				"testVoid", d.getMethodName());
		Assert.assertEquals("Method descriptor is not correct.", 
				"([[ILorg/junit/Test;)V", d.getDescriptor());
		
		d = new MethodDescriptor("de.uka.ipd.sdq.ByCounter.test.Test",
				"public int factor(double A[][],  int pivot[])");
		Assert.assertNotNull("Method descriptor was null. " + 
				"This means it could not be parsed correctly", d);
		Assert.assertEquals("Method descriptor method name is not correct.", 
				"factor", d.getMethodName());
		Assert.assertEquals("Method descriptor is not correct.", 
				"([[D[I)I", d.getDescriptor());
		

		d = new MethodDescriptor("de.uka.ipd.sdq.ByCounter.test.Test",
				"public static java.util.List <Integer> factor(java.util.List<java.util.List<Double>> A,  int pivot[])");
		Assert.assertNotNull("Method descriptor was null. " + 
				"This means it could not be parsed correctly", d);
		Assert.assertEquals("Method descriptor method name is not correct.", 
				"factor", d.getMethodName());
		Assert.assertEquals("Method descriptor is not correct.", 
				"(Ljava/util/List;[I)Ljava/util/List;", d.getDescriptor());
		
		Assert.assertEquals("new ArrayList();", MethodDescriptor.removeGenericTyping("new ArrayList<List<Double>>();"));
	}
}
