package de.uka.ipd.sdq.simucomframework.variables.tests;

import junit.framework.Assert;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode;

public class StoExVisitorVariablesTest {
	private static Logger logger = 
		Logger.getLogger(StoExVisitorTests.class.getName());
	private SimulatedStackframe<Object> stackFrame;

	@Before public void setup() {
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
	
	@Test public void stackEvaluate() {
		int i = (Integer)StackContext.evaluateStatic("anInt.BYTESIZE", stackFrame);
		Assert.assertEquals(i, 10);
		boolean b = (Boolean)StackContext.evaluateStatic("anBoolean.VALUE", stackFrame);
		Assert.assertEquals(b, false);
		double d = (Double)StackContext.evaluateStatic("anDouble.VALUE", stackFrame);
		Assert.assertEquals(d, 10.0);
	}
	
	@Test(expected=RuntimeException.class) public void invalidAccess() {
		StackContext.evaluateStatic("sssdffg.VALUE", stackFrame);
	}

	@Test public void returnDefault() {
		int bs = (Integer)StackContext.evaluateStatic("a.BYTESIZE", stackFrame, VariableMode.RETURN_DEFAULT_ON_NOT_FOUND);
		Assert.assertEquals(bs, 0);
	}

}
