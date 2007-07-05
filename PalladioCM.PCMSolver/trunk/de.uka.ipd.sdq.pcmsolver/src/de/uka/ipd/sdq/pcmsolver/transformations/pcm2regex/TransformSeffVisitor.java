package de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.actual_allocation.ActualAllocationContext;
import de.uka.ipd.sdq.context.actual_allocation.ActualResourceDemand;
import de.uka.ipd.sdq.context.usage.BranchProbability;
import de.uka.ipd.sdq.context.usage.LoopIteration;
import de.uka.ipd.sdq.context.usage.UsageContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.pcmsolver.visitors.ExpressionHelper;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.ProbabilityFunction;
import de.uka.ipd.sdq.probfunction.SamplePDF;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import de.uka.ipd.sdq.probfunction.math.PDFConfiguration;
import de.uka.ipd.sdq.probfunction.math.exception.ConfigurationNotSetException;
import de.uka.ipd.sdq.probfunction.math.exception.UnknownPDFTypeException;
import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.ExpressionFactory;
import de.uka.ipd.sdq.spa.expression.Option;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelFactory;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.stoex.Atom;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;

public class TransformSeffVisitor extends SeffSwitch{
	
	private static Logger logger = Logger.getLogger(TransformSeffVisitor.class.getName());
	
	private ExpressionFactory expFactory = ExpressionFactory.eINSTANCE;
	private ResourceModelFactory resFactory = ResourceModelFactory.eINSTANCE;
	private IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	private PCMInstance pcmInstance;
	private AssemblyContext assCtx;
	private HashMap<AbstractBranchTransition, Double> branchProbs;
	private HashMap<AbstractLoopAction, String> loopIters;
	private HashMap<ParametricResourceDemand, String> resDemands;
	
	public TransformSeffVisitor(PCMInstance pcm, AssemblyContext ctx){
		pcmInstance = pcm;
		assCtx = ctx;
		readUsageContexts();
		readActualAllocationContexts();
	}

	@Override
	public Object caseResourceDemandingSEFF(ResourceDemandingSEFF object) {
		ResourceDemandingBehaviour rdb = (ResourceDemandingBehaviour) object;
		return doSwitch(getStartAction(rdb));
	}

	@Override
	public Object caseResourceDemandingBehaviour(ResourceDemandingBehaviour object) {
		return doSwitch(getStartAction(object));
	}

	@Override
	public Object caseStartAction(StartAction object) {
		Symbol sym = expFactory.createSymbol();
		sym.setName("Start");
		
		Sequence seq = expFactory.createSequence();
		seq.setLeftRegExp(sym);
		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
		return seq;
	}

	@Override
	public Object caseStopAction(StopAction object) {
		Symbol sym = expFactory.createSymbol();
		sym.setName("Stop");
		return sym;
	}

	@Override
	public Object caseBranchAction(BranchAction object) {
		Alternative alt = expFactory.createAlternative();

		AbstractBranchTransition bt1 = (AbstractBranchTransition)object.getBranches_Branch().get(0);
		Option opt1 = expFactory.createOption();
		opt1.setProbability(branchProbs.get(bt1));
		Expression leftExpr = (Expression)doSwitch(bt1.getBranchBehaviour_BranchTransition());
		opt1.setRegexp(leftExpr);
		alt.setLeftOption(opt1);
		
		AbstractBranchTransition bt2 = (AbstractBranchTransition)object.getBranches_Branch().get(1);
		Option opt2 = expFactory.createOption();
		Expression rightExpr = (Expression)doSwitch(bt2.getBranchBehaviour_BranchTransition());
		opt2.setRegexp(rightExpr);
		opt2.setProbability(branchProbs.get(bt2));
		alt.setRightOption(opt2);
		
		Sequence seq = expFactory.createSequence();
		seq.setLeftRegExp(alt);
		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
		
		return seq;
	}

	@Override
	public Object caseCollectionIteratorAction(CollectionIteratorAction object) {
		de.uka.ipd.sdq.spa.expression.Loop loop = expFactory.createLoop();
		loop.setIterationsString(loopIters.get(object));
		loop.setRegExp((Expression)doSwitch(object.getBodyBehaviour_Loop()));
	
		Sequence seq = expFactory.createSequence();
		seq.setLeftRegExp(loop);
		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
		
		return seq;
	}
	
	
	@Override
	public Object caseLoopAction(LoopAction object) {
		de.uka.ipd.sdq.spa.expression.Loop loop = expFactory.createLoop();
		loop.setIterationsString(loopIters.get(object));
		loop.setRegExp((Expression)doSwitch(object.getBodyBehaviour_Loop()));
		
		Sequence seq = expFactory.createSequence();
		seq.setLeftRegExp(loop);
		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
		
		return seq;
	}

	@Override
	public Object caseInternalAction(InternalAction object) {
		return handleSymbol(object);
	}

	@Override
	public Object caseSetVariableAction(SetVariableAction object) {
		return handleSymbol(object);
	}
	
	private Object handleSymbol(AbstractResourceDemandingAction object){
		Symbol sym = expFactory.createSymbol();
		sym.setName(object.getEntityName());
		
		EList resourceDemands = object.getResourceDemand_Action();
		for (Object o : resourceDemands){
			ParametricResourceDemand prd = (ParametricResourceDemand)o;
			String spec = resDemands.get(prd);
			
			Atom resDemExpression = (Atom)ExpressionHelper.parseToExpression(spec);
			ProbabilityDensityFunction pdf = null;
			if (resDemExpression instanceof DoubleLiteral){
				DoubleLiteral resDemDouble = (DoubleLiteral)resDemExpression;
				pdf = getPDFForDouble(pdf, resDemDouble);
			} else if (resDemExpression instanceof ProbabilityFunctionLiteral){
				ProbabilityFunctionLiteral probFuncLiteral = (ProbabilityFunctionLiteral) resDemExpression;
				ProbabilityFunction probFunc = probFuncLiteral
					.getFunction_ProbabilityFunctionLiteral();
				if (probFunc instanceof ProbabilityDensityFunction){
					pdf = (ProbabilityDensityFunction)probFunc;	
				} else{
					logger.error("Invalid Resource Demand: ("+probFunc.getClass().getSimpleName()+"). Only DoublePDF is valid.");
					return null;
				}
			} else {
				logger.error("Invalid Resource Demand: ("+resDemExpression.getClass().getSimpleName()+"). Only DoublePDF is valid.");
				return null;
			}

			ResourceUsage ru = resFactory.createResourceUsage();
			ru.setUsageTime(pdf);
			
			sym.getResourceUsages().add(ru);
		}
	
		Sequence seq = expFactory.createSequence();
		seq.setLeftRegExp(sym);
		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
		return seq;
	}

	private ProbabilityDensityFunction getPDFForDouble(
			ProbabilityDensityFunction pdf, DoubleLiteral resDemDouble) {
		
		PDFConfiguration config = null;
		try {
			config = PDFConfiguration.getCurrentConfiguration();
		} catch (ConfigurationNotSetException e) {
			e.printStackTrace();
		}

		double distance = config.getDistance();
		int numOfSamples = config.getNumSamplingPoints();
		IUnit unit = config.getUnit();
		
		double value = resDemDouble.getValue() / distance;

		if (value != 0.0){
			if (value > numOfSamples){
				numOfSamples = (int)value+1;
				PDFConfiguration.setCurrentConfiguration(numOfSamples, distance, unit);
				logger.info("Reset PDFConfiguration: numOfSamples=" +
						numOfSamples+", distance="+distance+", unit="+unit.getUnitName());
			} else if (value < distance){
				PDFConfiguration.setCurrentConfiguration(numOfSamples, value, unit);
				logger.info("Reset PDFConfiguration: numOfSamples=" +
						numOfSamples+", distance="+value+", unit="+unit.getUnitName());
		
			}
		}
		
		List<Double> sampleList = new ArrayList<Double>();
		for (int i=0; i<numOfSamples; i++){
			if (i == (int)value){
				sampleList.add(new Double(1.0));
			} else {
				sampleList.add(new Double(0.0));	
			}
		}
		
		ISamplePDF iSamplePDF = pfFactory.createSamplePDFFromDouble(distance, sampleList, unit);
		try {
			SamplePDF samplePDF = pfFactory.transformToModelSamplePDF(iSamplePDF);
			pdf = samplePDF;
		} catch (UnknownPDFTypeException e) {
			e.printStackTrace();
		}
		return pdf;
	}


	@Override
	public Object caseExternalCallAction(ExternalCallAction object) {
		
		Signature serviceToBeCalled = object.getCalledService_ExternalService();
		Interface requiredInterface = (Interface) serviceToBeCalled.eContainer();
		
		AssemblyConnector foundAssemblyConnector = 
			findAssemblyConnector(requiredInterface);

		if (foundAssemblyConnector == null){
			// this is a system external call
			// we continue with the internal action added after this action
			return doSwitch(object.getSuccessor_AbstractAction());
		} else {
			ResourceDemandingSEFF seff = getTargetBehaviourFromAssemblyConnector(
					foundAssemblyConnector, serviceToBeCalled);
			
			// memorize current assembly context
			AssemblyContext oldctx = assCtx;
			// get new assembly context
			assCtx = foundAssemblyConnector.getProvidingChildComponentContext_CompositeAssemblyConnector();
			Sequence seq = expFactory.createSequence();
			seq.setLeftRegExp((Expression)doSwitch(seff));
			// restore current assembly context
			assCtx = oldctx;
			seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
			
			return seq;
		}
	
	}

	/**
	 * @param connector
	 * @param targetMethod
	 * @return
	 */
	private ResourceDemandingSEFF getTargetBehaviourFromAssemblyConnector(
			AssemblyConnector connector, Signature targetMethod) {
		BasicComponent targetBasicComponent = (BasicComponent) connector
				.getProvidingChildComponentContext_CompositeAssemblyConnector()
				.getEncapsulatedComponent_ChildComponentContext();
			
		// TODO: Über Interfaces suchen...
		ServiceEffectSpecification seff = (ServiceEffectSpecification) EMFHelper
				.executeOCLQuery(
						targetBasicComponent,
						"self.serviceEffectSpecifications__BasicComponent->select(seff|seff.describedService__SEFF.serviceName = '"
								+ targetMethod.getServiceName()
								+ "')->asOrderedSet()->first()");
	
		return (ResourceDemandingSEFF) seff;
	}
	
	
	/**
	 * @param requiredRole
	 * @return
	 */
	private AssemblyConnector findAssemblyConnector(
			Interface requiredRole) {
		Iterator connectorIterator = pcmInstance.getSystem()
				.getCompositeAssemblyConnectors_ComposedStructure().iterator();

		AssemblyConnector result = null;

		while (result == null && connectorIterator.hasNext()) {
			AssemblyConnector connector = (AssemblyConnector) connectorIterator
					.next();
			if (connector
					.getRequiringChildComponentContext_CompositeAssemblyConnector()
					.getId().equals(
							assCtx.getId())
					&& connector.getRequiredRole_CompositeAssemblyConnector()
							.getRequiredInterface__RequiredRole().getId()
							.equals(requiredRole.getId())) {
				result = connector;
			}
		}
		return result;
	}
	
	
	
	private StartAction getStartAction(ResourceDemandingBehaviour behaviour) {
		StartAction startAction = (StartAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		return startAction;
	}



	/**
	 * 
	 */
	private void readActualAllocationContexts() {
		resDemands = new HashMap<ParametricResourceDemand, String>();
		EList aacList = pcmInstance.getActualAllocation().getActualAllocationContexts_ActualAllocation();
		for (Object o : aacList){
			ActualAllocationContext aac = (ActualAllocationContext)o;
			EList actResDemands = aac.getActualResourceDemands_ActualAllocationContext();
			for (Object p : actResDemands){
				ActualResourceDemand actResDemand = (ActualResourceDemand)p;
				resDemands.put(actResDemand.getParametricResourceDemand_ActualResourceDemand(), actResDemand.getSpecification());
			}
		}
	}

	/**
	 * 
	 */
	private void readUsageContexts() {
		branchProbs = new HashMap<AbstractBranchTransition, Double>();
		loopIters = new HashMap<AbstractLoopAction, String>();
		EList ucList = pcmInstance.getUsage().getUsageContexts_Usage();
		for (Object o : ucList){
			UsageContext uc = (UsageContext)o;
			EList bProbs = uc.getBranchprobabilities_UsageContext();
			for (Object p : bProbs){
				BranchProbability branchProb = (BranchProbability)p;
				branchProbs.put(
						branchProb.getBranchtransition_BranchProbability(),
						branchProb.getProbability());
			}
			
			EList lIters = uc.getLoopiterations_UsageContext();
			for (Object q : lIters){
				LoopIteration loopIter = (LoopIteration)q;
				loopIters.put(loopIter.getLoopaction_LoopIteration(), loopIter.getSpecification());
			}
		}
	}

	
	
}
