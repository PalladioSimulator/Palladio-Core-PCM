package de.uka.ipd.sdq.dsolver.pcm2regex;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.dsolver.Context;
import de.uka.ipd.sdq.dsolver.PCMInstance;
import de.uka.ipd.sdq.dsolver.helper.EMFHelper;
import de.uka.ipd.sdq.dsolver.visitors.SeffVisitor;
import de.uka.ipd.sdq.dsolver.visitors.UsageModelVisitor;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.ExpressionFactory;
import de.uka.ipd.sdq.spa.expression.Option;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;
import de.uka.ipd.sdq.stoex.RandomVariable;

public class TransformUsageModelVisitor extends UsagemodelSwitch {
	
	private static Logger logger = Logger.getLogger(TransformUsageModelVisitor.class.getName());
	
	private ExpressionFactory expFactory = ExpressionFactory.eINSTANCE;
	private IProbabilityFunctionFactory pfFactory = IProbabilityFunctionFactory.eINSTANCE;
	
	private ExpressionBuilder expBuilder;
	private PCMInstance pcmInstance;
	
	
	public TransformUsageModelVisitor(PCMInstance pcm){
		expBuilder = new ExpressionBuilder();
		pcmInstance = pcm;
	}

	public Expression getResultExpression(){
		return expBuilder.getResultExpression();
	}
	
	@Override
	public Object caseBranch(Branch object) {
		Sequence seq = expFactory.createSequence();
		expBuilder.connectToExpression(seq);
		
		Alternative alt = expFactory.createAlternative();

		BranchTransition bt1 = (BranchTransition) object.getBranchTransitions_Branch().get(0);
		Option opt1 = expFactory.createOption();
		opt1.setProbability(bt1.getBranchProbability());
		alt.setLeftOption(opt1);
		
		BranchTransition bt2 = (BranchTransition) object.getBranchTransitions_Branch().get(1);
		Option opt2 = expFactory.createOption();
		opt2.setProbability(bt2.getBranchProbability());
		alt.setRightOption(opt2);
		
		expBuilder.connectToExpression(alt);
		
		doSwitch(bt1.getBranchedBehaviour_BranchTransition());
		doSwitch(bt2.getBranchedBehaviour_BranchTransition());
		doSwitch(object.getSuccessor());
		
		return object;
	}

	@Override
	public Object caseLoop(Loop object) {
		Sequence seq = expFactory.createSequence();
		expBuilder.connectToExpression(seq);
		
		de.uka.ipd.sdq.spa.expression.Loop loop = expFactory.createLoop();
		RandomVariable iterations = (RandomVariable)object.getIterations_Loop().get(0);
		loop.setIterationsString(iterations.getSpecification());
		
		expBuilder.connectToExpression(loop);
		
		doSwitch(object.getBodyBehaviour_Loop());
		doSwitch(object.getSuccessor());
		
		return object;
	}

	@Override
	public Object caseScenarioBehaviour(ScenarioBehaviour object) {
		doSwitch(getStartAction(object));
		return object;
	}

	@Override
	public Object caseEntryLevelSystemCall(EntryLevelSystemCall object) {
		Sequence seq = expFactory.createSequence();
		expBuilder.connectToExpression(seq);
		
		Signature signature = object.getSignature_EntryLevelSystemCall();
		ProvidedRole role = object.getProvidedRole_EntryLevelSystemCall();
		ProvidedDelegationConnector delegationConnector = getDelegationConnector(role);
		
		AssemblyContext assCtx = delegationConnector.getChildComponentContext_ProvidedDelegationConnector();
		
		
		ProvidesComponentType offeringComponent = delegationConnector
				.getChildComponentContext_ProvidedDelegationConnector()
				.getEncapsulatedComponent_ChildComponentContext();

		if (offeringComponent instanceof BasicComponent){
			ServiceEffectSpecification seff = getSeff(signature, (BasicComponent)offeringComponent);

			TransformSeffVisitor seffVisitor = new TransformSeffVisitor(expBuilder, pcmInstance, assCtx);
			try {
				seffVisitor.doSwitch((ResourceDemandingSEFF) seff);
			} catch (Exception e) {
				logger.error("Error while visiting RDSEFF");
				e.printStackTrace();
			}
		} else {
			logger.error("Composite Component type not yet supported.");
			System.exit(-1);
		}

		doSwitch(object.getSuccessor());
		return object;
	}

	@Override
	public Object caseStart(Start object) {
		Sequence seq = expFactory.createSequence();
		
		Symbol sym = expFactory.createSymbol();
		sym.setName("Start");
		//sym.getResourceUsages().add(pfFactory.createDiracImpulse(0, 1.0, pfFactory.createDefaultUnit()));
		//pfFactory.createDiracImpulse(numSamplingPoints, distance, unit);
		
		seq.setLeftRegExp(sym);
		expBuilder.connectToExpression(seq);
		doSwitch(object.getSuccessor());
		return object;
	}


	@Override
	public Object caseStop(Stop object) {
		Symbol sym = expFactory.createSymbol();
		sym.setName("Stop");
		//sym.getResourceUsages().add(pfFactory.createDiracImpulse(0, 1.0, pfFactory.createDefaultUnit()));
		//pfFactory.createDiracImpulse(numSamplingPoints, distance, unit);

		expBuilder.connectLastSymbol(sym);
	
		return object;
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
