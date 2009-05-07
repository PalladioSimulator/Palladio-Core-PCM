package de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
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
	
	private ContextWrapper contextWrapper;
	
	public TransformSeffVisitor(ContextWrapper ctxWrapper){
		contextWrapper = ctxWrapper;
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
	public Object caseInternalAction(InternalAction object) {
		return handleSymbol(object);
	}

	@Override
	public Object caseSetVariableAction(SetVariableAction object) {
		return handleSymbol(object);
	}

	@Override
	public Object caseExternalCallAction(ExternalCallAction object) {
		
		ResourceDemandingSEFF seff = (ResourceDemandingSEFF)contextWrapper.getNextSEFF(object);
		if (seff == null){
			// this is a system external call
			// we continue with the internal action added after this action
			return doSwitch(object.getSuccessor_AbstractAction());
		} else {
			ContextWrapper oldContextWrapper = (ContextWrapper)contextWrapper.clone();
			contextWrapper = contextWrapper.getContextWrapperFor(object);
	
			Sequence seq = expFactory.createSequence();
			seq.setLeftRegExp((Expression)doSwitch(seff));
			
			contextWrapper = oldContextWrapper;
	
			seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
	
			return seq;
		}
	}

	@Override
	public Object caseBranchAction(BranchAction object) {
		Alternative alt = expFactory.createAlternative();

		AbstractBranchTransition bt1 = (AbstractBranchTransition)object.getBranches_Branch().get(0);
		Option opt1 = expFactory.createOption();
		opt1.setProbability(contextWrapper.getBranchProbability(bt1));
		Expression leftExpr = (Expression)doSwitch(bt1.getBranchBehaviour_BranchTransition());
		opt1.setRegexp(leftExpr);
		alt.setLeftOption(opt1);
		
		AbstractBranchTransition bt2 = (AbstractBranchTransition)object.getBranches_Branch().get(1);
		Option opt2 = expFactory.createOption();
		Expression rightExpr = (Expression)doSwitch(bt2.getBranchBehaviour_BranchTransition());
		opt2.setRegexp(rightExpr);
		opt2.setProbability(contextWrapper.getBranchProbability(bt2));
		alt.setRightOption(opt2);
		
		Sequence seq = expFactory.createSequence();
		seq.setLeftRegExp(alt);
		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
		
		return seq;
	}

	@Override
	public Object caseCollectionIteratorAction(CollectionIteratorAction object) {
		de.uka.ipd.sdq.spa.expression.Loop loop = expFactory.createLoop();
		loop.setIterationsString(contextWrapper.getLoopIterations(object).toString());
		loop.setRegExp((Expression)doSwitch(object.getBodyBehaviour_Loop()));
	
		Sequence seq = expFactory.createSequence();
		seq.setLeftRegExp(loop);
		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
		
		return seq;
	}
	
	
	@Override
	public Object caseLoopAction(LoopAction object) {
		de.uka.ipd.sdq.spa.expression.Loop loop = expFactory.createLoop();
		loop.setIterationsString(contextWrapper.getLoopIterations(object).toString());
		loop.setRegExp((Expression)doSwitch(object.getBodyBehaviour_Loop()));
		
		Sequence seq = expFactory.createSequence();
		seq.setLeftRegExp(loop);
		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
		
		return seq;
	}

	private Object handleSymbol(AbstractInternalControlFlowAction object){
		Symbol sym = expFactory.createSymbol();
		sym.setName(object.getEntityName());
		
		EList<ParametricResourceDemand> prdList = object.getResourceDemand_Action();
		for (ParametricResourceDemand prd  : prdList){

			String spec = contextWrapper.getTimeConsumption(prd).toString(); 
			
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


	private StartAction getStartAction(ResourceDemandingBehaviour behaviour) {
		StartAction startAction = (StartAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		return startAction;
	}
	
}
