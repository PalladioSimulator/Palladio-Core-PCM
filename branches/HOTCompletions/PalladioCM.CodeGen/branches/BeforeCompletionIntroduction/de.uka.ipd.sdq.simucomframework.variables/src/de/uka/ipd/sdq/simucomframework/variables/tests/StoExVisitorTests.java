package de.uka.ipd.sdq.simucomframework.variables.tests;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;

public class StoExVisitorTests {
	private static Logger logger = 
		Logger.getLogger(StoExVisitorTests.class.getName());

	@Before public void setup() {
		PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %m [%c]%n");
		ConsoleAppender ca = new ConsoleAppender(myLayout);
		ca.setThreshold(Priority.DEBUG);
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure(ca);
	}
	
	@Test public void doubleOperationsTest() {
		logger.debug("Running Double Op Test");
		for (int i = 0; i < 20000; i++){
			double result = (Double)StackContext.simpleEvaluate("( ( DoublePDF(unit=\"unit\")[ (1.0; 0.02236114450589084) (2.0; 0.04664582832411637) (3.0; 0.10387112286607357) (4.0; 0.1606155325799471) (5.0; 0.20389516710747776) (6.0; 0.18826641019475834) (7.0; 0.11372926184178889) (8.0; 0.06852608800192354) (9.0; 0.02933397451310411) (10.0; 0.017311853811012263) (11.0; 0.009377254147631643) (12.0; 0.008896369319547967) (13.0; 0.004327963452753066) (14.0; 0.005049290694878576) (15.0; 0.0019235393123346958) (16.0; 0.002163981726376533) (17.0; 0.0012022120702091848) ] * 0.04 ) + 0.18 ) * 14");
			Assert.assertTrue("Result must be greater 0, but was "+result,result >= 0);
			Assert.assertTrue(result <= 12.1);
		}
	}
}
