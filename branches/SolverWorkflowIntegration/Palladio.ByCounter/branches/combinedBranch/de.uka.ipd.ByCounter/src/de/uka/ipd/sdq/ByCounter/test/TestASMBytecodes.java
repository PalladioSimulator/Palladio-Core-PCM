package de.uka.ipd.sdq.ByCounter.test;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import de.uka.ipd.sdq.ByCounter.execution.BytecodeClassLoader;
import de.uka.ipd.sdq.ByCounter.execution.BytecodeCounter;
import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.execution.CountingResultCollector;
import de.uka.ipd.sdq.ByCounter.instrumentation.InstrumentationParameters;
import de.uka.ipd.sdq.ByCounter.utils.ASMOpcodesMapper;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * A test suite providing testcases for de.uka.ipd.sdq.ByCount all different 
 * bytecodes that ASM can differentiate.
 * 
 * _Not_ covered by test cases are:
 * A*: ATHROW
 * D*: DUP_*, DUP2*
 * J*: JSR*
 * L*: LDC_W, LDC2_W (hidden as LDC by ASM)
 * N*: NOP
 * R*: RET
 * S*: SWAP
 * W*: WIDE (hidden by ASM)
 * 'unused opcodes': BREAKPOINT, IMPDEP1, IMPDEP2, XXXUNUSEDXXX

 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
@RunWith(Parameterized.class)
public class TestASMBytecodes {
	private static Logger log = Logger.getLogger(TestASMBytecodes.class.getCanonicalName());
	private static String testClassName = ASMBytecodeOccurences.class.getCanonicalName();
	
	private static CountingResultCollector resultCollector;
	private BytecodeCounter counter;
	
	/**
	 * This constructor is used by the Parametrized runner 
	 * for running tests with different parameters.
	 * @param params {@link InstrumentationParameters} for the counting setup.
	 */
	public TestASMBytecodes(InstrumentationParameters params) {
		// create a BytecodeCounter
		this.counter = new BytecodeCounter();
		this.counter.setInstrumentationParams(params);
	}
	

	/**
	 * Generates the different parameters with which all tests are run.
	 * This is also used by other unit tests in the suite.
	 * @return The parameter collection for calling the test constructor.
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Parameters
	public static Collection parameterSetup() {
		InstrumentationParameters p1 = new InstrumentationParameters();
		InstrumentationParameters p2 = new InstrumentationParameters();
		InstrumentationParameters p3 = new InstrumentationParameters();
		InstrumentationParameters p4 = new InstrumentationParameters();
		p1.setUseHighRegistersForCounting(true);
		p2.setUseHighRegistersForCounting(false);
		p3.setCounterPrecision(InstrumentationParameters.COUNTER_PRECISION_LONG);
		p3.setUseHighRegistersForCounting(true);
		p4.setCounterPrecision(InstrumentationParameters.COUNTER_PRECISION_LONG);
		p4.setUseHighRegistersForCounting(false);

		return Arrays.asList(new Object[][] { {p1}, {p2}, {p3}, {p4} });
	}


	@AfterClass
	public static void runAfterAllTests() {
		resultCollector = null;
	}
	
	@BeforeClass
	public static void runOnceBeforeAllTests() {
		PropertyConfigurator.configure("log4j.properties");
		log.info("Running unittests.");
		// early CountingResultCollector construction; initialize the singleton
		resultCollector = CountingResultCollector.getInstance();
	}

	@After
	public void cleanResults() {
		// clear all collected results
		resultCollector.clearResults();
	}

	/**
	 * Tests for ANEWARRAY, ARRAYLENGTH, MULTINEWARRAY, 
	 * AA_LOAD, AA_STORE, 
	 * BALOAD, BASTORE, CALOAD, CASTORE, DALOAD, DASTORE,
	 * FALOAD, FASTORE, IALOAD, IASTORE, LALOAD, LASTORE.
	 *
	 */
	@Test
	public void testArrayOpcodes() {
		// make sure array parameters get recorded:
		boolean oldUseArrayParameterRecording = counter.getInstrumentationParams().getUseArrayParameterRecording();
		counter.getInstrumentationParams().setUseArrayParameterRecording(true);
		CountingResult r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static void arrayInstructions()"));

		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.ANEWARRAY));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.ARRAYLENGTH));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.MULTIANEWARRAY));
		
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.AALOAD));
		Assert.assertEquals(2, Utils.getOpcCount(r, ASMOpcodesMapper.AASTORE));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.BALOAD));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.BASTORE));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.CALOAD));
		Assert.assertEquals(2, Utils.getOpcCount(r, ASMOpcodesMapper.CASTORE));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.DALOAD));
		Assert.assertEquals(2, Utils.getOpcCount(r, ASMOpcodesMapper.DASTORE));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.FALOAD));
		Assert.assertEquals(2, Utils.getOpcCount(r, ASMOpcodesMapper.FASTORE));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IALOAD));
		Assert.assertEquals(2, Utils.getOpcCount(r, ASMOpcodesMapper.IASTORE));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.LALOAD));
		Assert.assertEquals(2, Utils.getOpcCount(r, ASMOpcodesMapper.LASTORE));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.SALOAD));
		Assert.assertEquals(2, Utils.getOpcCount(r, ASMOpcodesMapper.SASTORE));
		
		Assert.assertEquals("java/lang/Object", r.getNewArrayTypes()[0]);
		Assert.assertEquals(2, r.getNewArrayDim()[1]);
		Assert.assertEquals(9, r.getNewArrayCounts().length);
		for(int i = 0; i < r.getNewArrayCounts().length; i++) {
			Assert.assertEquals(1, r.getNewArrayCounts()[i]);
		}
		counter.getInstrumentationParams().setUseArrayParameterRecording(oldUseArrayParameterRecording);
	}

	/**
	 * Tests different kind of branching instructions 
	 * and comparisons.
	 * IF*, INSTANCEOF, DCMPG, DCMPL, FCMPG, FCMPL,
	 * GOTO, JSR, TABLESWITCH.
	 *
	 */
	@Test
	public void testBranches() {
		CountingResult r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static int branches()"));

		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IF_ACMPEQ));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IF_ACMPNE));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IFNULL));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IFNONNULL));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.INSTANCEOF));
		
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IF_ICMPEQ));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IF_ICMPNE));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IF_ICMPGT));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IF_ICMPLT));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IF_ICMPGE));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IF_ICMPLE));
		
		Assert.assertEquals(2, Utils.getOpcCount(r, ASMOpcodesMapper.IFEQ));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IFNE));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IFLT));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IFGT));
		Assert.assertEquals(3, Utils.getOpcCount(r, ASMOpcodesMapper.IFGE));
		Assert.assertEquals(3, Utils.getOpcCount(r, ASMOpcodesMapper.IFLE));

		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.DCMPG));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.DCMPL));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.FCMPG));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.FCMPL));

		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.GOTO));
//		Assert.assertEquals(1, getOpcCount(r, DisplayOpcodes.JSR));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.TABLESWITCH));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.LOOKUPSWITCH));
	}

	/**
	 * Tests CHECKCAST.
	 *
	 */
	@Test
	public void testCHECKCAST() {
		CountingResult r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static java.lang.String checkcast()"));
		
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.CHECKCAST));
	}

	/**
	 * Tests for opcode A_CONST_NULL, i.e. Object o = null;
	 * Tests for integer constant opcodes ICONST_M1 to ICONST_5.
	 * Tests for double constant opcodes DCONST_0 (0.0) and DCONST_1 (1.0).
	 * Tests for float constant opcodes FCONST_0 (0.0f),
	 * FCONST_1 (1.0f), FCONST_2 (2.0f).
	 * Tests for long constant opcodes LCONST_0 (0L) and LCONST_1(1L).
	 * Tests LDC.
	 *
	 */
	@Test
	public void testConstantOpcodes() {
		CountingResult r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static void constants()"));
	
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ACONST_NULL), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ICONST_M1), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ICONST_0), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ICONST_1), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ICONST_2), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ICONST_3), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ICONST_4), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ICONST_5), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.DCONST_0), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.DCONST_1), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.FCONST_0), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.FCONST_1), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.FCONST_2), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LCONST_0), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LCONST_1), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LDC), 1);
	}
	
	/**
	 * Tests D2F, D2I, D2L, F2D, F2I, F2L,
	 * I2D, I2F, I2B, I2C, I2L, I2S,
	 * L2D, L2F, L2I.
	 *
	 */
	@Test
	public void testConversions() {
		CountingResult r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static void conversions()"));

		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.D2F), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.D2I), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.D2L), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.F2D), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.F2I), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.F2L), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.I2D), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.I2F), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.I2B), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.I2C), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.I2L), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.I2S), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.L2D), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.L2F), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.L2I), 1);
	}
	
	/**
	 * Tests object duplication.
	 *
	 */
	@Test
	public void testDUP() {
		CountingResult r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static void dup()"));
		
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.DUP), 1);
	}
	
	/**
	 * Tests method invokations.
	 * INVOKEINTERFACE, INVOKESPECIAL, INVOKEVIRTUAL, INVOKESTATIC
	 * 
	 *
	 */
	@Test
	public void testInvokationsAndClasses() {
		CountingResult r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static void invokationsAndClasses()"));
		
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.INVOKEINTERFACE), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.INVOKESPECIAL), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.INVOKESTATIC), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.INVOKEVIRTUAL), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.PUTFIELD), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.PUTSTATIC), 1);
	}
	
	/**
	 * Tests for math operations on primitives.
	 * DADD, DDIV, DMUL, DNEG, DREM, DSUB,
	 * FADD, FDIV, FMUL, FNEG, FREM, FSUB,
	 * IADD, IAND, IOR, IXOR, IINC, IDIV, IMUL,
	 * INEG, IREM, ISUB, ISHL, ISHR, IUSHR,
	 * LADD, LAND, LOR, LXOR, LDIV, LMUL,
	 * LNEG, LREM, LSUB, LSHL, LSHR, LUSHR.
	 *
	 */
	@Test
	public void testMathOpcodes() {
		CountingResult r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static float math()"));
		
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.DADD), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.DDIV), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.DMUL), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.DNEG), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.DREM), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.DSUB), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.FADD), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.FDIV), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.FMUL), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.FNEG), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.FREM), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.FSUB), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.IADD), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.IAND), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.IOR), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.IXOR), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.IINC), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.IDIV), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.IMUL), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.INEG), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.IREM), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ISUB), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ISHL), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ISHR), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.IUSHR), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LADD), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LAND), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LOR), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LXOR), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LDIV), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LMUL), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LNEG), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LREM), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LSUB), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LSHL), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LSHR), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LUSHR), 1);
	}
	
	/**
	 * Tests MONITORENTER and MONITOREXIT.
	 *
	 */
	@Test
	public void testMonitor() {
		CountingResult r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static void monitor()"));
		
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.MONITORENTER), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.MONITOREXIT), 1);
	}
	
	@Test
	public void testNew() {
		CountingResult r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static void newObj()"));
		
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.NEW), 1);
	}

	/**
	 * Tests BIPUSH, SIPUSH, POP, POP2.
	 *
	 */
	@Test
	public void testPushPop() {
		CountingResult r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static void pushPop()"));

		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.POP), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.POP2), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.BIPUSH), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.SIPUSH), 1);
	}
	
	/**
	 * Tests ALOAD, ASTORE, DLOAD, DSTORE, FLOAD, FSTORE,
	 * LLOAD, LSTORE, ILOAD, ISTORE.
	 * Not specifically tested are xLOAD_0 to xLOAD_3 since 
	 * ASM groups them as xLOAD.
	 * The same goes for xSTORE_n.
	 *
	 */
	@Test
	public void testRefLoadStore() {
		CountingResult r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static void refLoadStore()"));
		
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ALOAD), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ASTORE), 2);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.DLOAD), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.DSTORE), 2);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.FLOAD), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.FSTORE), 2);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LLOAD), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.LSTORE), 2);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ILOAD), 1);
		Assert.assertEquals(Utils.getOpcCount(r, ASMOpcodesMapper.ISTORE), 2);
	}

	/**
	 * RETURN statements:
	 * RETURN, ARETURN, DRETURN, FRETURN, IRETURN
	 *
	 */
	@Test
	public void testReturn() {
		CountingResult r;
		// RETURN
		r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static void refLoadStore()"));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.RETURN));
		cleanResults();

		// ARETURN
		r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static java.lang.String checkcast()"));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.ARETURN));
		cleanResults();
		
		// DRETURN
		r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static double getaDouble()"));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.DRETURN));
		cleanResults();
		
		// FRETURN
		r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static float math()"));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.FRETURN));
		cleanResults();

		// IRETURN
		r = Utils.getCountingResultForTest(counter, 
				new MethodDescriptor(testClassName, "public static int branches()"));
		Assert.assertEquals(1, Utils.getOpcCount(r, ASMOpcodesMapper.IRETURN));
		cleanResults();
	}
}
