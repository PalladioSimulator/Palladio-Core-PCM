package de.uka.ipd.sdq.probfunction.math.test;

import junit.framework.Assert;

import org.junit.Test;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISample;


public class SampleTest{
	
	public static IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	
	@Test
	public void equals(){
		ISample s1a = pfFactory.createSample("Haus", 0.3);
		ISample s1b = pfFactory.createSample("Haus", 0.3);
		ISample s2 = pfFactory.createSample("Haus", 0.4);
		ISample s3 = pfFactory.createSample(0.5 , 0.4);
		
		Assert.assertTrue(s1a.equals(s1a));
		Assert.assertTrue(s1a.equals(s1b));
		Assert.assertFalse(s1a.equals(s2));
		Assert.assertFalse(s1a.equals(s3));
		Assert.assertFalse(s1a.equals("Haus"));
	}

}
