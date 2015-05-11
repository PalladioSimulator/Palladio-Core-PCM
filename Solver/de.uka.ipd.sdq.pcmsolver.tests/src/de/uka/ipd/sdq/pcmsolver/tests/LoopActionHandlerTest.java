package de.uka.ipd.sdq.pcmsolver.tests;


public class LoopActionHandlerTest {

//	private LoopActionHandler loopActionHandler = null;
//	private LoopAction loopAction = null;
//	
//	@Before
//	public void setUp(){
//		Context context = new Context();
//		
//		UsageFactory uf = UsageFactory.eINSTANCE;
//		context.setUsageContext(uf.createUsageContext());
//		context.setCurrentLoopIterationNumber(new ArrayList());
//		
//		SeffVisitor visitor = new SeffVisitor(null, context);
//
//		loopActionHandler = new LoopActionHandler(context,visitor,null);
//		
//		SeffFactory sf = SeffFactory.eINSTANCE;
//		loopAction = sf.createLoopAction();
//		
//		IterationCount iterCount = sf.createIterationCount();
//		iterCount.setSpecification("5");
//		loopAction.setIterations_LoopAction(iterCount);
//		
//	}
//	
//	/**
//	 * Tests, whether the loop action handler correctly stores the given
//	 * specification for the number of loop iterations in the usage context.
//	 */
//	@Test
//	public void handle(){
//		loopActionHandler.handle(loopAction);
//		
//		EList loopIterations = loopActionHandler.getMyContext().getUsageContext().getLoopiterations_UsageContext();
//		
//		// loop iterations in usage context should not be empty
//		assertFalse(loopIterations.isEmpty());
//		
//		// loop iterations in usage context should contain "5" as first element
//		assertTrue(((LoopIteration) loopIterations.get(0)).getSpecification()
//				.equals("5"));
//		
//		// memorized loop iteration numbers should have been removed from the context 
//		assertTrue(loopActionHandler.getMyContext()
//				.getCurrentLoopIterationNumber().size() == 0);
//	}
//	
//	/**
//	 * Test whether the upper bound of a loop can be found if 
//	 * the number of loop iterations is specified as an expression.
//	 */
//	@Test
//	public void getUpperBound(){
//		// Should get highest value of IntPMF as upperBound
//		String pmf = "IntPMF(unit=\"unit\")[ (0.1; 1) (0.2; 2) (0.7; 3) ]";
//		Expression expr = ExpressionHelper.parseToExpression(pmf);
//		int upperBound = loopActionHandler.getUpperBound(expr);
//		assertTrue(upperBound == 3);
//
//		// Should get the constant as upperBound
//		pmf = "5";
//		expr = ExpressionHelper.parseToExpression(pmf);
//		upperBound = loopActionHandler.getUpperBound(expr);
//		assertTrue(upperBound == 5);
//		
//		// DoublePMF do not work, because the loop cannot be executed 3.1 times
//		pmf = "DoublePMF(unit=\"unit\")[ (0.1; 1.1) (0.2; 2.1) (0.7; 3.1) ]";
//		expr = ExpressionHelper.parseToExpression(pmf);
//		upperBound = loopActionHandler.getUpperBound(expr);
//		assertTrue(upperBound == 0);
//		
//		// DoublePDF do not work either
//		pmf = "DoublePDF(unit=\"unit\")[ (0.1; 1.1) (0.2; 2.1) (0.7; 3.1) ]";
//		expr = ExpressionHelper.parseToExpression(pmf);
//		upperBound = loopActionHandler.getUpperBound(expr);
//		assertTrue(upperBound == 0);
//	}
//	
//	public static junit.framework.Test suite() {
//		return new JUnit4TestAdapter(LoopActionHandlerTest.class);
//	}
	
}
