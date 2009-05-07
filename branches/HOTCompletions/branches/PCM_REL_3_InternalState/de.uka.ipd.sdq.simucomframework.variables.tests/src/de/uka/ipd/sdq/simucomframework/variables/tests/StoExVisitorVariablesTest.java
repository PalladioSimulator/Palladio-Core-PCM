package de.uka.ipd.sdq.simucomframework.variables.tests;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.StochasticExpressionEvaluationFailedException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode;

public class StoExVisitorVariablesTest extends TestCase {
	private static Logger logger = 
		Logger.getLogger(StoExVisitorTests.class.getName());
	private SimulatedStackframe<Object> stackFrame;

	public void setUp() {
		PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %m [%c]%n");
		ConsoleAppender ca = new ConsoleAppender(myLayout);
		ca.setThreshold(Priority.INFO);
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure(ca);
		
		stackFrame = new SimulatedStackframe<Object>();
		stackFrame.addValue("anInt.BYTESIZE", 10);
		stackFrame.addValue("anBoolean.VALUE", false);
		stackFrame.addValue("anDouble.VALUE", 10.0);
	}
	
	public void testStackEvaluate() {
		int i = (Integer)StackContext.evaluateStatic("anInt.BYTESIZE", stackFrame);
		Assert.assertEquals(i, 10);
		boolean b = (Boolean)StackContext.evaluateStatic("anBoolean.VALUE", stackFrame);
		Assert.assertEquals(b, false);
		double d = (Double)StackContext.evaluateStatic("anDouble.VALUE", stackFrame);
		Assert.assertEquals(d, 10.0);
	}
	
	public void testInvalidAccess() {
		try {
			StackContext.evaluateStatic("sssdffg.VALUE", stackFrame);
		} catch (Exception ex){
			Assert.assertEquals(StochasticExpressionEvaluationFailedException.class, ex.getClass());
			return;
		}
		Assert.fail("Parser error expected, but did not occur");
	}

	public void testReturnDefault() {
		int bs = (Integer)StackContext.evaluateStatic("a.BYTESIZE", stackFrame, VariableMode.RETURN_DEFAULT_ON_NOT_FOUND);
		Assert.assertEquals(bs, 0);
	}

}
