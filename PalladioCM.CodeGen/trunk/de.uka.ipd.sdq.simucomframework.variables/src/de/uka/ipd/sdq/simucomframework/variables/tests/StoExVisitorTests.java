package de.uka.ipd.sdq.simucomframework.variables.tests;

import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.ValueNotInFrameException;

public class StoExVisitorTests {
	private static Logger logger = 
		Logger.getLogger(StoExVisitorTests.class.getName());

	@Before public void setup() {
		PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %m [%c]%n");
		ConsoleAppender ca = new ConsoleAppender(myLayout);
		ca.setThreshold(Priority.INFO);
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure(ca);
	}
	
	@Test public void doubleOperationsTest() {
		logger.debug("Running Double Op Test");
		for (int i = 0; i < 2000; i++){
			double result = (Double)StackContext.evaluateStatic("( ( DoublePDF(unit=\"unit\")[ (1.0; 0.02236114450589084) (2.0; 0.04664582832411637) (3.0; 0.10387112286607357) (4.0; 0.1606155325799471) (5.0; 0.20389516710747776) (6.0; 0.18826641019475834) (7.0; 0.11372926184178889) (8.0; 0.06852608800192354) (9.0; 0.02933397451310411) (10.0; 0.017311853811012263) (11.0; 0.009377254147631643) (12.0; 0.008896369319547967) (13.0; 0.004327963452753066) (14.0; 0.005049290694878576) (15.0; 0.0019235393123346958) (16.0; 0.002163981726376533) (17.0; 0.0012022120702091848) ] * 0.04 ) + 0.18 ) * 14");
			Assert.assertTrue("Result must be greater 0, but was "+result,result >= 0);
			Assert.assertTrue(result <= 12.1);
		}
	}
	
	@Test public void unary() {
		int result = (Integer)StackContext.evaluateStatic("-4");
		Assert.assertEquals(-4, result);
		boolean result2 = (Boolean)StackContext.evaluateStatic("NOT true");
		Assert.assertEquals(result2, false);
	}
	
	@Test public void pow1() {
		double result3 = (Double)StackContext.evaluateStatic("10^3");
		Assert.assertEquals(1000.0, result3);
	}

	@Test public void pow2() {
		double result3 = (Double)StackContext.evaluateStatic("10^-3");
		Assert.assertEquals(0.001, result3);
	}

	@Test public void doubleTests() {
		double result3 = (Double)StackContext.evaluateStatic("1.0E-3");
		Assert.assertEquals(0.001, result3);
		result3 = (Double)StackContext.evaluateStatic("0.4 + 0.6");
		Assert.assertEquals(1.0, result3);
		result3 = (Double)StackContext.evaluateStatic("5 * 10.0");
		Assert.assertEquals(50.0, result3);
		result3 = (Double)StackContext.evaluateStatic("20.0 / 10");
		Assert.assertEquals(2.0, result3);
		result3 = (Double)StackContext.evaluateStatic("4.0^0.5");
		Assert.assertEquals(2.0, result3);
	}

	@Test public void integerDivisionSemantics() {
		double i = 25 + 15 * 10 / 1000;
		double result3 = (Integer)StackContext.evaluateStatic("25 + 15 * 10 / 1000");
		Assert.assertEquals(result3, i);
		Assert.assertEquals(result3, 25);

		i = 25 + 15 * 10 / 1000.0;
		result3 = (Double)StackContext.evaluateStatic("25 + 15 * 10 / 1000.0");
		Assert.assertEquals(result3, i);	
		Assert.assertEquals(result3, 25.15);	
	}
	
	@Test public void boolTests() {
		boolean result = (Boolean)StackContext.evaluateStatic("true");
		Assert.assertEquals(true, result);
		result = (Boolean)StackContext.evaluateStatic("5 > 4");
		Assert.assertEquals(true, result);
		result = (Boolean)StackContext.evaluateStatic("NOT (5 <= 4)");
		Assert.assertEquals(true, result);
		result = (Boolean)StackContext.evaluateStatic("true AND false");
		Assert.assertEquals(false, result);
		result = (Boolean)StackContext.evaluateStatic("true AND true");
		Assert.assertEquals(true, result);
		result = (Boolean)StackContext.evaluateStatic("true OR false");
		Assert.assertEquals(true, result);
		result = (Boolean)StackContext.evaluateStatic("true XOR true");
		Assert.assertEquals(false, result);
	}
	
	@Test public void functionsTest() {
		logger.info("UniDouble");
		for (int i=0; i<2000; i++) {
			double result3 = (Double)StackContext.evaluateStatic("UniDouble(1,4)");
			Assert.assertTrue(result3 >= 1 && result3 <= 4);
		}
		logger.info("UniInt");
		for (int i=0; i<2000; i++) {
			int result3 = (Integer)StackContext.evaluateStatic("UniInt(1,4)");
			Assert.assertTrue(result3 >= 1 && result3 <= 4);
		}
		logger.info("Norm");
		for (int i=0; i<200; i++) {
			double result3 = (Double)StackContext.evaluateStatic("Norm(0,1)");
			logger.debug(result3);
			Assert.assertTrue(result3 >= -5 && result3 <= 5);
		}
		logger.info("Exp");
		for (int i=0; i<200; i++) {
			double result3 = (Double)StackContext.evaluateStatic("Exp(1)");
			Assert.assertTrue(result3 >= 0);
		}
		logger.info("Trunc");
		int result4 = (Integer)StackContext.evaluateStatic("Trunc(2.5)");
		Assert.assertEquals(2, result4);
		result4 = (Integer)StackContext.evaluateStatic("Trunc(2)");
		Assert.assertEquals(2, result4);
		logger.info("Round");
		result4 = (Integer)StackContext.evaluateStatic("Round(2.5)");
		Assert.assertEquals(3, result4);
		result4 = (Integer)StackContext.evaluateStatic("Round(3)");
		Assert.assertEquals(3, result4);
	}
	
	@Test public void ifelseTest() {
		int result = (Integer)StackContext.evaluateStatic("true ? 3 : 4");
		Assert.assertEquals(3, result);
		result = (Integer)StackContext.evaluateStatic("false ? 3 : 4");
		Assert.assertEquals(4, result);
	}
	
	@Test public void getByteSizeFromStackframe(){
		
		SimulatedStackframe<Object> myFrame = new SimulatedStackframe<Object>();
		myFrame.addValue("a.BYTESIZE", new Integer(2));
		myFrame.addValue("b.BYTESIZE", new Integer(3));
		myFrame.addValue("c.INNER.BYTESIZE", new Double(5));
		myFrame.addValue("c.NUMBER_OF_ELEMENTS", new Double(10));
		myFrame.addValue("d.e.f.BYTESIZE", new Double(10));
		myFrame.addValue("g.h.BYTESIZE", new Double(10));
		
		SimulatedStackframe<Object> resultFrame = myFrame.getByteSizeOfFrame();
		
		try {
			Assert.assertEquals(new Double(75), resultFrame.getValue("transferData.BYTESIZE"));
		} catch (ValueNotInFrameException e1) {
			e1.printStackTrace();
		}
		
	}
}
