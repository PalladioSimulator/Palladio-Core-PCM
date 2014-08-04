package de.uka.ipd.sdq.simucomframework.variables.tests;

import java.util.Arrays;

import junit.framework.TestCase;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.simucomframework.SimuComDefaultRandomNumberGenerator;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.variables.functions.MaxDeviationFunction;
import de.uka.ipd.sdq.simucomframework.variables.functions.MaxFunction;
import de.uka.ipd.sdq.simucomframework.variables.functions.MinDeviationFunction;
import de.uka.ipd.sdq.simucomframework.variables.functions.MinFunction;

public class StoExVisitorTests extends TestCase {
    private static final Logger LOGGER = Logger.getLogger(StoExVisitorTests.class.getName());

    @Override
    public void setUp() {
        IProbabilityFunctionFactory probFunctionFactory = ProbabilityFunctionFactoryImpl.getInstance();
        probFunctionFactory.setRandomGenerator(new SimuComDefaultRandomNumberGenerator(new long[] {
                1, 2, 3, 4, 5, 6
        }));
        StoExCache.initialiseStoExCache(probFunctionFactory);

        PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %m [%c]%n");
        ConsoleAppender ca = new ConsoleAppender(myLayout);
        ca.setThreshold(Level.INFO);
        BasicConfigurator.resetConfiguration();
        BasicConfigurator.configure(ca);
    }

    public void testDoubleOperations() {
        LOGGER.debug("Running Double Op Test");
        for (int i = 0; i < 2000; i++) {
            double result = (Double) StackContext
                    .evaluateStatic("( ( DoublePDF[ (1.0; 0.02236114450589084) (2.0; 0.04664582832411637) (3.0; 0.10387112286607357) (4.0; 0.1606155325799471) (5.0; 0.20389516710747776) (6.0; 0.18826641019475834) (7.0; 0.11372926184178889) (8.0; 0.06852608800192354) (9.0; 0.02933397451310411) (10.0; 0.017311853811012263) (11.0; 0.009377254147631643) (12.0; 0.008896369319547967) (13.0; 0.004327963452753066) (14.0; 0.005049290694878576) (15.0; 0.0019235393123346958) (16.0; 0.002163981726376533) (17.0; 0.0012022120702091848) ] * 0.04 ) + 0.18 ) * 14");
            assertTrue("Result must be greater 0, but was " + result, result >= 0);
            assertTrue(result <= 12.1);
        }
    }

    public void testUnaryOperator() {
        int result = (Integer) StackContext.evaluateStatic("-4");
        assertEquals(-4, result);
        boolean result2 = (Boolean) StackContext.evaluateStatic("NOT true");
        assertEquals(result2, false);
    }

    public void testPow1() {
        double result3 = (Double) StackContext.evaluateStatic("10^3");
        assertEquals(1000.0, result3);
    }

    public void testPow2() {
        double result3 = (Double) StackContext.evaluateStatic("10^-3");
        assertEquals(0.001, result3);
    }

    public void testDouble() {
        double result3 = (Double) StackContext.evaluateStatic("1.0E-3");
        assertEquals(0.001, result3);
        result3 = (Double) StackContext.evaluateStatic("0.4 + 0.6");
        assertEquals(1.0, result3);
        result3 = (Double) StackContext.evaluateStatic("5 * 10.0");
        assertEquals(50.0, result3);
        result3 = (Double) StackContext.evaluateStatic("20.0 / 10");
        assertEquals(2.0, result3);
        result3 = (Double) StackContext.evaluateStatic("4.0^0.5");
        assertEquals(2.0, result3);
    }

    public void testIntegerDivisionSemantics() {
        double i = 25 + 15 * 10 / 1000;
        double result3 = (Integer) StackContext.evaluateStatic("25 + 15 * 10 / 1000");
        assertEquals(result3, i);

        i = 25 + 15 * 10 / 1000.0;
        result3 = (Double) StackContext.evaluateStatic("25 + 15 * 10 / 1000.0");
        assertEquals(result3, i);
        assertEquals(result3, 25.15);
    }

    public void testBool() {
        boolean result = (Boolean) StackContext.evaluateStatic("true");
        assertEquals(true, result);
        result = (Boolean) StackContext.evaluateStatic("5 > 4");
        assertEquals(true, result);
        result = (Boolean) StackContext.evaluateStatic("NOT (5 <= 4)");
        assertEquals(true, result);
        result = (Boolean) StackContext.evaluateStatic("true AND false");
        assertEquals(false, result);
        result = (Boolean) StackContext.evaluateStatic("true AND true");
        assertEquals(true, result);
        result = (Boolean) StackContext.evaluateStatic("true OR false");
        assertEquals(true, result);
        result = (Boolean) StackContext.evaluateStatic("true XOR true");
        assertEquals(false, result);
    }

    public void testUniIntFunction() {
        LOGGER.info("UniInt");
        int[] uiv;
        int min = 1;
        int max = 4;
        uiv = new int[max];

        for (int i = 0; i < 2000; i++) {
            int result = (Integer) StackContext.evaluateStatic("UniInt(" + min + "," + max + ")");
            assertTrue("Value of UniInt(1,4) out of borders: value is " + result, result >= min && result <= max);
            ++uiv[result - 1];
        }

        // Check for the uniformity of the distribution
        int[] sorted = Arrays.copyOf(uiv, 4);
        Arrays.sort(sorted);
        int median = sorted[(max - 1) / 2];
        double percentile = 0.10;
        int lowerBound = (int) (median * (1.0 - percentile));
        int upperBound = (int) (median * (1.0 + percentile));

        for (int i = 0; i < max; i++) {
            assertTrue("Frequency of " + i + " is not within 10% of the median frequency ", uiv[i] > lowerBound
                    && uiv[i] < upperBound);
        }

    }

    public void testFunctions() {
        LOGGER.info("UniDouble");
        for (int i = 0; i < 2000; i++) {
            double result3 = (Double) StackContext.evaluateStatic("UniDouble(1,4)");
            assertTrue(result3 >= 1 && result3 <= 4);
        }

        LOGGER.info("Norm");
        for (int i = 0; i < 200; i++) {
            double result3 = (Double) StackContext.evaluateStatic("Norm(0,1)");
            LOGGER.debug(result3);
            assertTrue(result3 >= -5 && result3 <= 5);
        }
        LOGGER.info("Exp");
        for (int i = 0; i < 200; i++) {
            double result3 = (Double) StackContext.evaluateStatic("Exp(1)");
            assertTrue(result3 >= 0);
        }
        LOGGER.info("Trunc");
        int result4 = (Integer) StackContext.evaluateStatic("Trunc(2.5)");
        assertEquals(2, result4);
        result4 = (Integer) StackContext.evaluateStatic("Trunc(2)");
        assertEquals(2, result4);
        LOGGER.info("Round");
        result4 = (Integer) StackContext.evaluateStatic("Round(2.5)");
        assertEquals(3, result4);
        result4 = (Integer) StackContext.evaluateStatic("Round(3)");
        assertEquals(3, result4);
        LOGGER.info(MinFunction.MIN_FUNCTION_NAME);
        assertEquals(2, StackContext.evaluateStatic("Min(2,5)"));
        assertEquals(2.3, StackContext.evaluateStatic("Min(2.3,5.3)"));
        LOGGER.info(MaxFunction.MAX_FUNCTION_NAME);
        assertEquals(5, StackContext.evaluateStatic("Max(2,5)"));
        assertEquals(5.3, StackContext.evaluateStatic("Max(2.3,5.3)"));
        LOGGER.info(MinDeviationFunction.MIN_DEVIATION_FUNCTION_NAME);
        assertEquals(5, StackContext.evaluateStatic("MinDeviation(10, 5.0, 0.1)"));
        assertEquals(4, StackContext.evaluateStatic("MinDeviation(10, 5.0, 0.6)"));
        assertEquals(5.0, StackContext.evaluateStatic("MinDeviation(10.0, 5.0, 0.1)"));
        assertEquals(4.0, StackContext.evaluateStatic("MinDeviation(10.0, 5.0, 0.6)"));
        LOGGER.info(MaxDeviationFunction.MAX_DEVIATION_FUNCTION_NAME);
        assertEquals(15, StackContext.evaluateStatic("MaxDeviation(10, 5.0, 0.1)"));
        assertEquals(16, StackContext.evaluateStatic("MaxDeviation(10, 5.0, 0.6)"));
        assertEquals(15.0, StackContext.evaluateStatic("MaxDeviation(10.0, 5.0, 0.1)"));
        assertEquals(16.0, StackContext.evaluateStatic("MaxDeviation(10.0, 5.0, 0.6)"));
    }

    public void testIfelse() {
        int result = (Integer) StackContext.evaluateStatic("true ? 3 : 4");
        assertEquals(3, result);
        result = (Integer) StackContext.evaluateStatic("false ? 3 : 4");
        assertEquals(4, result);
    }
}
