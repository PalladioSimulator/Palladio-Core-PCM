package de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFQueryHelper;
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
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.ExpressionFactory;
import de.uka.ipd.sdq.spa.expression.Option;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelFactory;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.stoex.Atom;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NumericLiteral;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;

public class TransformSeffVisitor extends SeffSwitch{
	
	private static Logger logger = Logger.getLogger(TransformSeffVisitor.class.getName());
	
	private ExpressionFactory expFactory = ExpressionFactory.eINSTANCE;
	private ResourceModelFactory resFactory = ResourceModelFactory.eINSTANCE;
	private IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	
	private ContextWrapper myContextWrapper;
	
	public TransformSeffVisitor(ContextWrapper ctxWrapper){
		myContextWrapper = ctxWrapper;
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
		sym.setName("Start_"+object.getId());
		
		Sequence seq = expFactory.createSequence();
		seq.setLeftRegExp(sym);
		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
		return seq;
	}

	@Override
	public Object caseStopAction(StopAction object) {
		Symbol sym = expFactory.createSymbol();
		sym.setName("Stop_"+object.getId());
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
		
		ResourceDemandingSEFF seff = (ResourceDemandingSEFF)myContextWrapper.getNextSEFF(object);
		if (seff == null){
			// this is a system external call
			// we continue with the internal action added after this action
			return doSwitch(object.getSuccessor_AbstractAction());
		} else {
			ContextWrapper oldContextWrapper = (ContextWrapper)myContextWrapper.clone();
			
			List<ContextWrapper> contextWrapperList = myContextWrapper.getContextWrapperFor(object);
			List<Option> optionsPerContextWrapperList = new LinkedList<Option>();
			for (ContextWrapper contextWrapper : contextWrapperList) {
				myContextWrapper = contextWrapper; 
				//Sequence seq = expFactory.createSequence();
				//seq.setLeftRegExp((Expression)doSwitch(seff));
				
				Option option = expFactory.createOption();
				option.setRegexp((Expression)doSwitch(seff));
				option.setProbability(1/contextWrapperList.size());
				optionsPerContextWrapperList.add(option);
			}	
			Expression exp = null;
			if (optionsPerContextWrapperList.size() == 1){
				exp = optionsPerContextWrapperList.get(0).getRegexp();
			} else {
				exp = Pcm2RegexHelper.createAlternativesForExpressions(optionsPerContextWrapperList);
			}
			
			myContextWrapper = oldContextWrapper;
			Sequence seq = expFactory.createSequence();
			seq.setLeftRegExp(exp);
			seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
	
			return seq;
		}
	}

	@Override
	public Object caseBranchAction(BranchAction object) {
		List<Option> optionsForBranches = new LinkedList<Option>();
		
		for (AbstractBranchTransition branch : object.getBranches_Branch()) {
			Option option = expFactory.createOption();
			option.setProbability(myContextWrapper.getBranchProbability(branch));
			Expression branchExpression = (Expression)doSwitch(branch.getBranchBehaviour_BranchTransition());
			option.setRegexp(branchExpression);
			
			optionsForBranches.add(option);
		}
		Expression alt = Pcm2RegexHelper.createAlternativesForExpressions(optionsForBranches);
		
		Sequence seq = expFactory.createSequence();
		seq.setLeftRegExp(alt);
		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
		
		return seq;
	}

	@Override
	public Object caseCollectionIteratorAction(CollectionIteratorAction object) {
		de.uka.ipd.sdq.spa.expression.Loop loop = expFactory.createLoop();
		loop.setIterationsString(myContextWrapper.getLoopIterations(object).toString());
		loop.setRegExp((Expression)doSwitch(object.getBodyBehaviour_Loop()));
	
		Sequence seq = expFactory.createSequence();
		seq.setLeftRegExp(loop);
		seq.setRightRegExp((Expression)doSwitch(object.getSuccessor_AbstractAction()));
		
		return seq;
	}
	
	
	@Override
	public Object caseLoopAction(LoopAction object) {
		de.uka.ipd.sdq.spa.expression.Loop loop = expFactory.createLoop();
		loop.setIterationsString(myContextWrapper.getLoopIterations(object).toString());
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

			String spec = myContextWrapper.getTimeConsumptionAsPDF(prd).toString(); 
			
			Atom resDemExpression = (Atom)ExpressionHelper.parseToExpression(spec);
			ProbabilityDensityFunction pdf = null;
			if (resDemExpression instanceof NumericLiteral){
				NumericLiteral resDemNumeric = (NumericLiteral)resDemExpression;
				pdf = getPDFForNumericLiteral(pdf, resDemNumeric);
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

	private ProbabilityDensityFunction getPDFForNumericLiteral(
			ProbabilityDensityFunction pdf, NumericLiteral resDemNumeric) {
		
		PDFConfiguration config = null;
		try {
			config = PDFConfiguration.getCurrentConfiguration();
		} catch (ConfigurationNotSetException e) {
			e.printStackTrace();
		}

		double distance = config.getDistance();
		int numOfSamples = config.getNumSamplingPoints();
		IUnit unit = config.getUnit();
		
		double value = 0;
		if (resDemNumeric instanceof DoubleLiteral){
			value = ((DoubleLiteral) resDemNumeric).getValue() ;
		} else if (resDemNumeric instanceof IntLiteral){
			value = ((IntLiteral) resDemNumeric).getValue(); 
		}
		value = value / distance;

		if (value != 0.0){
			if (value > numOfSamples){
				numOfSamples = (int)value+1;
				PDFConfiguration.setCurrentConfiguration(numOfSamples, distance, unit);
				logger.debug("Reset PDFConfiguration: numOfSamples=" +
						numOfSamples+", distance="+distance+", unit="+unit.getUnitName());
			} else if (value < distance){
				PDFConfiguration.setCurrentConfiguration(numOfSamples, value, unit);
				logger.debug("Reset PDFConfiguration: numOfSamples=" +
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
		StartAction startAction = (StartAction) EMFQueryHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		return startAction;
	}
	
}
