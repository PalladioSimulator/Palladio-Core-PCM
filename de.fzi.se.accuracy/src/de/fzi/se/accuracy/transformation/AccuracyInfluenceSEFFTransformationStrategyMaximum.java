/**
 *
 */
package de.fzi.se.accuracy.transformation;

import org.apache.log4j.Logger;

import de.fzi.se.quality.qualityannotation.NoPrecision;
import de.fzi.se.quality.qualityannotation.REPrecision;
import de.fzi.se.quality.util.EcoreCopierCreatingNewIds;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.reliability.FailureType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.CallAction;
import de.uka.ipd.sdq.pcm.seff.CallReturnAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalCallAction;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.runconfig.AccuracyInfluenceAnalysisState;

/**
 * Implementing the transformation of given SEFFs for the state
 * {@link AccuracyInfluenceAnalysisState#MAXIMUM}. Start the transformation by
 * invoking {@link #doSwitch(org.eclipse.emf.ecore.EObject)} with a parameter of
 * type {@link ServiceEffectSpecification}.
 *
 * @author groenda
 *
 */
public class AccuracyInfluenceSEFFTransformationStrategyMaximum extends
		AbstractAccuracyInfluenceSEFFTransformationStrategy {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(AccuracyInfluenceSEFFTransformationStrategyMaximum.class);

	/** Copier for EMF elements. */
	private EcoreCopierCreatingNewIds copier = new EcoreCopierCreatingNewIds();

	/** Transformation of the specification of {@link PCMRandomVariable} for the maximum of a precision. */
	private final PCMRandomVariableSpecificationAccuracyMaximumTrafo randomVariableMaximumTrafo = new PCMRandomVariableSpecificationAccuracyMaximumTrafo();
	/** Returns the minimum value for a validation precision and provided absolute value. */
	private final ValidationPrecisionToMaximumLongValue precisionMaximalValue = new ValidationPrecisionToMaximumLongValue();

	/**Create a new instance using the given quality annotations.
	 * @param pcmPartition Partition containing the quality annotations.
	 */
	public AccuracyInfluenceSEFFTransformationStrategyMaximum(PCMResourceSetPartition pcmPartition) {
		super(pcmPartition);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractAccuracyInfluenceSEFFTransformationStrategy#modifyComponentExternalCall(de.uka.ipd.sdq.pcm.seff.ExternalCallAction, de.fzi.se.quality.qualityannotation.REPrecision)
	 */
	@Override
	protected void modifyComponentExternalCall(ExternalCallAction call,
			REPrecision precision) {
		// Call Parameters for an CallAction
		handleInputParametersOfCallAction(call, precision);
		// Number of Calls for an AbstractAction
		precisionMaximalValue.setAbsoluteValue(1l);
		long max = precisionMaximalValue.doSwitch(precision.getDefaultPrecisionNumberOfCalls());
		if (max > 1) {
			ExternalCallAction eca = null;
			AbstractAction predecessor = call;
			AbstractAction finalSuccessor = call.getSuccessor_AbstractAction();
			//replicate action
			for (int i = 1; i < max; i++) {
				eca = SeffFactory.eINSTANCE.createExternalCallAction();
				if (i == 1) { // special case for the first replica for correct control flow
					call.setSuccessor_AbstractAction(eca);
				}
				eca.setCalledService_ExternalService(call.getCalledService_ExternalService());
				eca.setEntityName(call.getEntityName() + " Accuracy Influence Replica " + i);
				eca.setRetryCount(eca.getRetryCount());
				copyInputVariableUsages(eca, call);
				copyReturnVariableUsage(eca, call);
				copyFailureTypes(eca, call);
				eca.setRole_ExternalService(call.getRole_ExternalService());
				eca.setPredecessor_AbstractAction(predecessor);
				predecessor = eca;
			}
			if (eca != null) {
				eca.setSuccessor_AbstractAction(finalSuccessor);
			} else {
				String msg = "Impossible control flow in implemenation. Correct implemenatation.";
				logger.fatal(msg);
				throw new IllegalArgumentException(msg);
			}
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractAccuracyInfluenceSEFFTransformationStrategy#modifyComponentInternalCall(de.uka.ipd.sdq.pcm.seff.InternalCallAction, de.fzi.se.quality.qualityannotation.REPrecision)
	 */
	@Override
	protected void modifyComponentInternalCall(InternalCallAction call,
			REPrecision precision) {
		// Call Parameters for an CallAction
		handleInputParametersOfCallAction(call, precision);
		// Number of Calls for an AbstractAction
		precisionMaximalValue.setAbsoluteValue(1l);
		long max = precisionMaximalValue.doSwitch(precision.getDefaultPrecisionNumberOfCalls());
		if (max > 1) {
			InternalCallAction ica = null;
			AbstractAction predecessor = call;
			AbstractAction finalSuccessor = call.getSuccessor_AbstractAction();
			//replicate action
			for (int i = 1; i < max; i++) {
				ica = SeffFactory.eINSTANCE.createInternalCallAction();
				if (i == 1) { // special case for the first replica for correct control flow
					call.setSuccessor_AbstractAction(ica);
				}
				ica.setCalledResourceDemandingInternalBehaviour(call.getCalledResourceDemandingInternalBehaviour());
				ica.setEntityName(call.getEntityName() + " Accuracy Influence Replica " + i);
				copyInputVariableUsages(ica, call);
				// not implemented although it should be copyReturnVariableUsage(ica, call);
				ica.setPredecessor_AbstractAction(predecessor);
				predecessor = ica;
			}
			if (ica != null) {
				ica.setSuccessor_AbstractAction(finalSuccessor);
			} else {
				String msg = "Impossible control flow in implemenation. Correct implemenatation.";
				logger.fatal(msg);
				throw new IllegalArgumentException(msg);
			}
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractAccuracyInfluenceSEFFTransformationStrategy#modifyInfrastructureCall(de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall, de.fzi.se.quality.qualityannotation.REPrecision)
	 */
	@Override
	protected void modifyInfrastructureCall(InfrastructureCall call,
			REPrecision precision) {
		// Number of Calls
		randomVariableMaximumTrafo.setModifiedVariable(call.getNumberOfCalls__InfrastructureCall());
		randomVariableMaximumTrafo.doSwitch(precision.getDefaultPrecisionNumberOfCalls());
		// Call parameters
		handleInputParametersOfCallAction(call, precision);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractAccuracyInfluenceSEFFTransformationStrategy#modifyResourceCall(de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall, de.fzi.se.quality.qualityannotation.REPrecision)
	 */
	@Override
	protected void modifyResourceCall(ResourceCall call, REPrecision precision) {
		// Number of Calls
		randomVariableMaximumTrafo.setModifiedVariable(call.getNumberOfCalls__ResourceCall());
		randomVariableMaximumTrafo.doSwitch(precision.getDefaultPrecisionNumberOfCalls());
		// Call parameters
		for (VariableUsage variableUsage : call.getInputVariableUsages__CallAction()) {
			for (VariableCharacterisation varChar : variableUsage.getVariableCharacterisation_VariableUsage()) {
				randomVariableMaximumTrafo.setModifiedVariable(varChar.getSpecification_VariableCharacterisation());
				randomVariableMaximumTrafo.doSwitch(precision.getDefaultPrecisionCallParameter());
			}
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractAccuracyInfluenceSEFFTransformationStrategy#modifyResourceDemand(de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand, de.fzi.se.quality.qualityannotation.REPrecision)
	 */
	@Override
	protected void modifyResourceDemand(ParametricResourceDemand demand,
			REPrecision precision) {
		// Number of Calls
		randomVariableMaximumTrafo.setModifiedVariable(demand.getSpecification_ParametericResourceDemand());
		randomVariableMaximumTrafo.doSwitch(precision.getDefaultPrecisionNumberOfCalls());
		// Call Parameters
		if (!(precision.getDefaultPrecisionCallParameter() instanceof NoPrecision)) {
			String msg = "A ResourceDemand has no parameters. The default precision for call parameters must be set to NoPrecision.";
			logger.error(msg);
			throw new IllegalArgumentException(msg);
		}
	}

	/**Handles the transformation for input parameters of call actions.
	 * @param call Call action to transform.
	 * @param precision Precision.
	 */
	private void handleInputParametersOfCallAction(CallAction call,
			REPrecision precision) {
		for (VariableUsage variableUsage : call.getInputVariableUsages__CallAction()) {
			for (VariableCharacterisation varChar : variableUsage.getVariableCharacterisation_VariableUsage()) {
				randomVariableMaximumTrafo.setModifiedVariable(varChar.getSpecification_VariableCharacterisation());
				randomVariableMaximumTrafo.doSwitch(precision.getDefaultPrecisionCallParameter());
			}
		}
	}

	/**Copy input variable usages from source to target.
	 * @param target Target.
	 * @param source Source.
	 */
	private void copyInputVariableUsages(CallAction target,
			CallAction source) {
		VariableUsage newVU;
		VariableCharacterisation newVC;
		for (VariableUsage variableUsage : source.getInputVariableUsages__CallAction()) {
			newVU = ParameterFactory.eINSTANCE.createVariableUsage();
			newVU.setNamedReference__VariableUsage((AbstractNamedReference) copier.copy(variableUsage.getNamedReference__VariableUsage()));
			for (VariableCharacterisation varChar : variableUsage.getVariableCharacterisation_VariableUsage()) {
				newVC = ParameterFactory.eINSTANCE.createVariableCharacterisation();
				newVC.setSpecification_VariableCharacterisation(varChar.getSpecification_VariableCharacterisation());
				newVU.getVariableCharacterisation_VariableUsage().add(newVC);
			}
			target.getInputVariableUsages__CallAction().add(newVU);
		}
	}

	/**Copy return variable usages from source to target.
	 * @param target Target.
	 * @param source Source.
	 */
	private void copyReturnVariableUsage(CallReturnAction target,
			CallReturnAction source) {
		VariableUsage newVU;
		VariableCharacterisation newVC;
		for (VariableUsage variableUsage : source.getReturnVariableUsage__CallReturnAction()) {
			newVU = ParameterFactory.eINSTANCE.createVariableUsage();
			newVU.setNamedReference__VariableUsage((AbstractNamedReference) copier.copy(variableUsage.getNamedReference__VariableUsage()));
			for (VariableCharacterisation varChar : variableUsage.getVariableCharacterisation_VariableUsage()) {
				newVC = ParameterFactory.eINSTANCE.createVariableCharacterisation();
				newVC.setSpecification_VariableCharacterisation(varChar.getSpecification_VariableCharacterisation());
				newVU.getVariableCharacterisation_VariableUsage().add(newVC);
			}
			target.getReturnVariableUsage__CallReturnAction().add(newVU);
		}
	}

	/**Copy failure types from source to target.
	 * @param target Target.
	 * @param source Source.
	 */
	private void copyFailureTypes(FailureHandlingEntity target,
			FailureHandlingEntity source) {
		for (FailureType failureType : source.getFailureTypes_FailureHandlingEntity()) {
			target.getFailureTypes_FailureHandlingEntity().add(failureType);
		}
	}


}
