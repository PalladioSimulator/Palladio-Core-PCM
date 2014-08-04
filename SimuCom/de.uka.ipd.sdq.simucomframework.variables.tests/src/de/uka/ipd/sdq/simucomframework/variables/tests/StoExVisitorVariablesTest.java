package de.uka.ipd.sdq.simucomframework.variables.tests;

import junit.framework.TestCase;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.impl.DefaultRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.StochasticExpressionEvaluationFailedException;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode;

public class StoExVisitorVariablesTest extends TestCase {
    /** Logger for this class. */
    @SuppressWarnings("unused")
    private static final Logger LOGGER = Logger.getLogger(StoExVisitorTests.class.getName());
    private SimulatedStackframe<Object> stackFrame;
    private ConsoleAppender ca;

    @Override
    public void setUp() {
        PatternLayout myLayout = new PatternLayout("%d{HH:mm:ss,SSS} [%t] %-5p %m [%c]%n");
        ca = new ConsoleAppender(myLayout);
        ca.setThreshold(Level.INFO);
        BasicConfigurator.resetConfiguration();
        BasicConfigurator.configure(ca);

        IProbabilityFunctionFactory probFunctionFactory = ProbabilityFunctionFactoryImpl.getInstance();
        probFunctionFactory.setRandomGenerator(new DefaultRandomGenerator());
        StoExCache.initialiseStoExCache(probFunctionFactory);
        stackFrame = new SimulatedStackframe<Object>();
        stackFrame.addValue("anInt.BYTESIZE", 10);
        stackFrame.addValue("anBoolean.VALUE", false);
        stackFrame.addValue("anDouble.VALUE", 10.0);
    }

    public void testStackEvaluate() {
        int i = (Integer) StackContext.evaluateStatic("anInt.BYTESIZE", stackFrame);
        assertEquals(i, 10);
        boolean b = (Boolean) StackContext.evaluateStatic("anBoolean.VALUE", stackFrame);
        assertEquals(b, false);
        double d = (Double) StackContext.evaluateStatic("anDouble.VALUE", stackFrame);
        assertEquals(d, 10.0);
    }

    public void testStackEvaluateAutoTypeConversion() {
        // prepare stack with test values
        SimulatedStackframe<Object> stackFrame = new SimulatedStackframe<Object>();
        String CHAR_VALUE = "c.VALUE";
        String BYTE_VALUE = "b.VALUE";
        String SHORT_VALUE = "s.VALUE";
        String INTEGER_VALUE = "i.VALUE";
        String LONG_VALUE = "l.VALUE";
        String FLOAT_VALUE = "f.VALUE";
        String DOUBLE_VALUE = "d.VALUE";
        char c = 14;
        stackFrame.addValue(CHAR_VALUE, c);
        byte b = 15;
        stackFrame.addValue(BYTE_VALUE, b);
        short s = 16;
        stackFrame.addValue(SHORT_VALUE, s);
        int i = 17;
        stackFrame.addValue(INTEGER_VALUE, i);
        long l = 18;
        stackFrame.addValue(LONG_VALUE, l);
        float f = 19;
        stackFrame.addValue(FLOAT_VALUE, f);
        double d = 20;
        stackFrame.addValue(DOUBLE_VALUE, d);
        // test
        // byte/char
        assertEquals(Character.valueOf(c), StackContext.evaluateStatic(CHAR_VALUE, Character.class, stackFrame));
        assertEquals(Byte.valueOf(b), StackContext.evaluateStatic(BYTE_VALUE, Byte.class, stackFrame));
        // short
        assertEquals((Short) Byte.valueOf(b).shortValue(),
                StackContext.evaluateStatic(BYTE_VALUE, Short.class, stackFrame));
        assertEquals((Short) Byte.valueOf((byte) Character.valueOf(c).charValue()).shortValue(),
                StackContext.evaluateStatic(CHAR_VALUE, Short.class, stackFrame));
        // int
        assertEquals((Integer) Byte.valueOf(b).intValue(),
                StackContext.evaluateStatic(BYTE_VALUE, Integer.class, stackFrame));
        assertEquals((Integer) Byte.valueOf((byte) Character.valueOf(c).charValue()).intValue(),
                StackContext.evaluateStatic(CHAR_VALUE, Integer.class, stackFrame));
        assertEquals((Integer) Short.valueOf(s).intValue(),
                StackContext.evaluateStatic(SHORT_VALUE, Integer.class, stackFrame));
        // long
        assertEquals((Long) Byte.valueOf(b).longValue(),
                StackContext.evaluateStatic(BYTE_VALUE, Long.class, stackFrame));
        assertEquals((Long) Byte.valueOf((byte) Character.valueOf(c).charValue()).longValue(),
                StackContext.evaluateStatic(CHAR_VALUE, Long.class, stackFrame));
        assertEquals((Long) Short.valueOf(s).longValue(),
                StackContext.evaluateStatic(SHORT_VALUE, Long.class, stackFrame));
        assertEquals((Long) Integer.valueOf(i).longValue(),
                StackContext.evaluateStatic(INTEGER_VALUE, Long.class, stackFrame));
        // float
        assertEquals(Byte.valueOf(b).floatValue(), StackContext.evaluateStatic(BYTE_VALUE, Float.class, stackFrame));
        assertEquals(Byte.valueOf((byte) Character.valueOf(c).charValue()).floatValue(),
                StackContext.evaluateStatic(CHAR_VALUE, Float.class, stackFrame));
        assertEquals(Short.valueOf(s).floatValue(), StackContext.evaluateStatic(SHORT_VALUE, Float.class, stackFrame));
        assertEquals(Integer.valueOf(i).floatValue(),
                StackContext.evaluateStatic(INTEGER_VALUE, Float.class, stackFrame));
        assertEquals(Long.valueOf(l).floatValue(), StackContext.evaluateStatic(LONG_VALUE, Float.class, stackFrame));
        // double
        assertEquals(Byte.valueOf(b).doubleValue(), StackContext.evaluateStatic(BYTE_VALUE, Double.class, stackFrame));
        assertEquals(Byte.valueOf((byte) Character.valueOf(c).charValue()).doubleValue(),
                StackContext.evaluateStatic(CHAR_VALUE, Double.class, stackFrame));
        assertEquals(Short.valueOf(s).doubleValue(), StackContext.evaluateStatic(SHORT_VALUE, Double.class, stackFrame));
        assertEquals(Integer.valueOf(i).doubleValue(),
                StackContext.evaluateStatic(INTEGER_VALUE, Double.class, stackFrame));
        assertEquals(Long.valueOf(l).doubleValue(), StackContext.evaluateStatic(LONG_VALUE, Double.class, stackFrame));
        assertEquals(Float.valueOf(f).doubleValue(), StackContext.evaluateStatic(FLOAT_VALUE, Double.class, stackFrame));
    }

    /**
     * Test the detection of a wrong variable access. That means the expression tries to access a
     * variable which has never placed on the stack. This test method temporarly turns of the
     * logging, because a logging of the exception is expected and should not mess up the test
     * environment console.
     */
    public void testInvalidAccess() {
        try {
            ca.setThreshold(Level.OFF);
            StackContext.evaluateStatic("sssdffg.VALUE", stackFrame);
            ca.setThreshold(Level.INFO);
        } catch (Exception ex) {
            assertEquals("An unexpected type of exception has been thrown",
                    StochasticExpressionEvaluationFailedException.class, ex.getClass());
            return;
        }
        fail("Parser error expected, but did not occur");
    }

    public void testPowVar() {
        double result3 = (Double) StackContext.evaluateStatic("10^(anInt.BYTESIZE)", stackFrame);
        assertEquals(Math.pow(10, 10), result3);
    }

    public void testReturnDefault() {
        int bs = (Integer) StackContext.evaluateStatic("a.BYTESIZE", stackFrame,
                VariableMode.RETURN_DEFAULT_ON_NOT_FOUND);
        assertEquals(bs, 0);
    }

}
