package de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn;

import java.math.BigInteger;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import LqnCore.ActivityMakingCallType;
import LqnCore.ActivityPhasesType;
import LqnCore.EntryActivityGraph;
import LqnCore.EntryType;
import LqnCore.LqnCoreFactory;
import LqnCore.LqnModelType;
import LqnCore.PhaseActivities;
import LqnCore.ProcessorType;
import LqnCore.SchedulingType;
import LqnCore.SolverParamsType;
import LqnCore.TaskSchedulingType;
import LqnCore.TaskType;
import LqnCore.TypeType;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcm.usagemodel.Workload;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex.TransformSeffVisitor;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex.TransformUsageModelVisitor;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.ExpressionFactory;
import de.uka.ipd.sdq.spa.expression.Option;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.stoex.RandomVariable;

public class UsageModel2Lqn extends UsagemodelSwitch {

	private static Logger logger = Logger.getLogger(UsageModel2Lqn.class.getName());
	
	private IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	private LqnCoreFactory lqnFactory = LqnCoreFactory.eINSTANCE;
	
	private PCMInstance pcmInstance;
	private ContextWrapper contextWrapper = null;
	
	public UsageModel2Lqn(PCMInstance pcm){
		pcmInstance = pcm;
	}

	@Override
	public Object caseStart(Start object) {
//		Symbol sym = expFactory.createSymbol();
//		sym.setName("Start");
//	
//		Sequence seq = expFactory.createSequence();
//		seq.setLeftRegExp(sym);
//		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor()));
//	
//		return seq;
		return null;
	}

	@Override
	public Object caseStop(Stop object) {
//		Symbol sym = expFactory.createSymbol();
//		sym.setName("Stop");
//		return sym;
		return null;
	}

	@Override
	public Object caseEntryLevelSystemCall(EntryLevelSystemCall object) {
		if (contextWrapper == null)
			contextWrapper = new ContextWrapper(object, pcmInstance);
		else
			contextWrapper = contextWrapper.getContextWrapperFor(object);

//		Sequence seq = expFactory.createSequence();
//		seq.setLeftRegExp(getEntryExpression(object));
//		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor()));
//		
//		return seq;
		return null;
	}

	private Expression getEntryExpression(EntryLevelSystemCall object) {
		Signature signature = object.getSignature_EntryLevelSystemCall();
		ProvidedRole role = object.getProvidedRole_EntryLevelSystemCall();
		ProvidedDelegationConnector delegationConnector = getDelegationConnector(role);
		ProvidesComponentType offeringComponent = delegationConnector
				.getChildComponentContext_ProvidedDelegationConnector()
				.getEncapsulatedComponent_ChildComponentContext();
	
		Expression expr = null;
		if (offeringComponent instanceof BasicComponent){
			ServiceEffectSpecification seff = getSeff(signature, (BasicComponent)offeringComponent);
			TransformSeffVisitor seffVisitor = new TransformSeffVisitor(contextWrapper);
			try {
				expr = (Expression)seffVisitor.doSwitch((ResourceDemandingSEFF) seff);
			} catch (Exception e) {
				logger.error("Error while visiting RDSEFF");
				e.printStackTrace();
			}
		} else {
			logger.error("Composite Component type not yet supported.");
			return null;
		}
		return expr;
	}

	@Override
	public Object caseBranch(Branch object) {
//		Alternative alt = expFactory.createAlternative();
//
//		BranchTransition bt1 = (BranchTransition) object.getBranchTransitions_Branch().get(0);
//		Option opt1 = expFactory.createOption();
//		opt1.setProbability(bt1.getBranchProbability());
//		Expression leftExpr = (Expression)doSwitch(bt1.getBranchedBehaviour_BranchTransition());
//		opt1.setRegexp(leftExpr);
//		alt.setLeftOption(opt1);
//		
//		BranchTransition bt2 = (BranchTransition) object.getBranchTransitions_Branch().get(1);
//		Option opt2 = expFactory.createOption();
//		opt2.setProbability(bt2.getBranchProbability());
//		Expression rightExpr = (Expression)doSwitch(bt2.getBranchedBehaviour_BranchTransition());
//		opt2.setRegexp(rightExpr);
//		alt.setRightOption(opt2);
//		
//		Sequence seq = expFactory.createSequence();
//		seq.setLeftRegExp(alt);
//		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor()));
//		
//		return seq;
		return null;
	}

	@Override
	public Object caseLoop(Loop object) {
//		de.uka.ipd.sdq.spa.expression.Loop loop = expFactory.createLoop();
//		RandomVariable iterations = (RandomVariable)object.getLoopIteration_Loop();
//		loop.setIterationsString(iterations.getSpecification());
//		loop.setRegExp((Expression)doSwitch(object.getBodyBehaviour_Loop()));
//		
//		Sequence seq = expFactory.createSequence();		
//		seq.setLeftRegExp(loop);
//		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor()));
//		
//		return seq;
		return null;
	}

	
	
	@Override
	public Object caseUsageModel(UsageModel usageModel) {
		LqnModelType lmt = lqnFactory.createLqnModelType();
		lmt.setName("TODO_EnterUsageModelName");
		
		SolverParamsType spt = lqnFactory.createSolverParamsType();
		spt.setComment("blah");
		spt.setConvVal("1e-005");
		spt.setItLimit(50);
		spt.setPrintInt(10);
		spt.setUnderrelaxCoeff("0.5");
		lmt.setSolverParams(spt);

		EList<UsageScenario> scenList = usageModel.getUsageScenario_UsageModel();
		for (UsageScenario us : scenList){
			Object obj = doSwitch(us.getWorkload_UsageScenario());
			ProcessorType pt = (ProcessorType)obj;
			lmt.getProcessor().add(pt);
		}
	
		return lmt;
	}

	
	
	@Override
	public Object caseClosedWorkload(ClosedWorkload closedWorkload) {
		UsageScenario us = (UsageScenario)closedWorkload.eContainer();
		
		ProcessorType pt = lqnFactory.createProcessorType();
		pt.setName(us.getEntityName()+"_Processor");
		pt.setMultiplicity(new BigInteger("0"));
		pt.setScheduling(SchedulingType.FCFS);
		
		TaskType tt = lqnFactory.createTaskType();
		tt.setName(us.getEntityName()+"_Task");
		String population = new Integer(closedWorkload.getPopulation()).toString();
		tt.setMultiplicity(new BigInteger(population));
		
		PCMRandomVariable thinkTime = closedWorkload.getThinkTime_ClosedWorkload();
		tt.setThinkTime(thinkTime.getSpecification());
		tt.setScheduling(TaskSchedulingType.REF);
		pt.getTask().add(tt);
				
		EntryType et = lqnFactory.createEntryType();
		et.setName(us.getEntityName()+"_Entry");
		et.setType(TypeType.PH1PH2);
		tt.getEntry().add(et);
		
				
		Object obj = doSwitch(us.getScenarioBehaviour_UsageScenario());
		EntryActivityGraph eag = (EntryActivityGraph)obj;
		et.setEntryActivityGraph(eag);
		
		return pt;
	}

	@Override
	public Object caseOpenWorkload(OpenWorkload object) {
		// TODO Auto-generated method stub
		return super.caseOpenWorkload(object);
	}

	@Override
	public Object caseScenarioBehaviour(ScenarioBehaviour object) {
		EntryActivityGraph eag = lqnFactory.createEntryActivityGraph();
		
		return eag;
	}

	private Start getStartAction(ScenarioBehaviour object) {
		Start startAction = (Start) EMFHelper.getObjectByType(object
				.getActions_ScenarioBehaviour(), Start.class);
		return startAction;
	}

	
	private ProvidedDelegationConnector getDelegationConnector(
			ProvidedRole role) {
		ProvidedDelegationConnector delegationConnector = 
			(ProvidedDelegationConnector) EMFHelper
				.executeOCLQuery(
						pcmInstance.getSystem(),
						"self.providedDelegationConnectors_ComposedStructure->select(dc|dc.outerProvidedRole_ProvidedDelegationConnector.providedInterface__ProvidedRole.id = '"
								+ role.getProvidedInterface__ProvidedRole()
										.getId()
								+ "')->asOrderedSet()->first()");
		return delegationConnector;
		
	}
	
	/**
	 * @param method
	 * @param basicComponent
	 * @return
	 */
	private ServiceEffectSpecification getSeff(Signature method,
			BasicComponent basicComponent) {
		ServiceEffectSpecification seff = (ServiceEffectSpecification) EMFHelper
				.executeOCLQuery(
						basicComponent,
						"self.serviceEffectSpecifications__BasicComponent->select(seff|seff.describedService__SEFF.serviceName = '"
								+ method.getServiceName()
								+ "')->asOrderedSet()->first()");
		return seff;
	}

	
}
