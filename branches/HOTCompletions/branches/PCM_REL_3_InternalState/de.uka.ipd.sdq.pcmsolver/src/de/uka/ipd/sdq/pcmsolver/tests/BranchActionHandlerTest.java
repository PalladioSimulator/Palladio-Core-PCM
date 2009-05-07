package de.uka.ipd.sdq.pcmsolver.tests;


public class BranchActionHandlerTest {

//	private BranchActionHandler branchActionHandler = null;
//	private BranchAction branchAction = null;
//	
//	@Before
//	public void setUp(){
//		Context context = new Context();
//		
//		UsageFactory uf = UsageFactory.eINSTANCE;
//		context.setUsageContext(uf.createUsageContext());
//		context.setCurrentEvaluatedBranchConditions(new ArrayList());
//		
//		SeffVisitor visitor = new SeffVisitor(null, context);
//
//		branchActionHandler = new BranchActionHandler(context, visitor, null);
//		
//		
//		SeffFactory sf = SeffFactory.eINSTANCE;
//		branchAction = sf.createBranchAction();
//		
//		BranchTransition bt1 = sf.createBranchTransition();
//		bt1.setBranchProbability(0.3);
//		branchAction.getBranches_Branch().add(bt1);
//		
//		BranchTransition bt2 = sf.createBranchTransition();
//		BranchCondition branchCondition2 = sf.createBranchCondition();
//		branchCondition2.setSpecification("3<4");
//		bt2.setBranchCondition_BranchTransition(branchCondition2);
//		branchAction.getBranches_Branch().add(bt2);
//		
//		BranchTransition bt3 = sf.createBranchTransition();
//		BranchCondition branchCondition3 = sf.createBranchCondition();
//		branchCondition3.setSpecification("IntPMF(unit=\"unit\")[ (0.1; 1) (0.2; 2) (0.7; 3) ] > 1");
//		bt3.setBranchCondition_BranchTransition(branchCondition3);
//		branchAction.getBranches_Branch().add(bt3);
//	}
//	
//	/**
//	 * Tests, whether branch probabilities are correctly stored
//	 * into the usage context.
//	 */
//	@Test
//	public void handle(){
//		branchActionHandler.handle(branchAction);
//		
//		EList branchProbs = branchActionHandler.getMyContext()
//				.getUsageContext().getBranchprobabilities_UsageContext();
//		assertFalse(branchProbs.isEmpty());
//		
//		BranchProbability bp1 = (BranchProbability)branchProbs.get(0);
//		assertTrue(bp1.getProbability() == 0.3);
//		
//		BranchProbability bp2 = (BranchProbability)branchProbs.get(1);
//		assertTrue(bp2.getProbability() == 1.0);
//		
//		BranchProbability bp3 = (BranchProbability)branchProbs.get(2);
//		assertTrue(bp3.getProbability() == 0.9);
//		
//	}
//	
//	
//	public static junit.framework.Test suite() {
//		return new JUnit4TestAdapter(LoopActionHandlerTest.class);
//	}
}
