/**
 *
 */
package de.fzi.se.quality.util;

import java.util.zip.Checksum;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.InternalCallAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;

/**
 * Builds the checksum for the content of an action. Structure and
 * performance-relevant behavior differences lead to a different checksum,
 * entity name and identifier changes don't.
 * 
 * @author groenda
 * 
 */
public class ActionChecksumSwitch extends SeffSwitch<Boolean> {
	/** Checksum generator used to calculate the checksum. */
	private Checksum checksum;

	/**
	 * Initializes the checksum calculator switch.
	 * 
	 * @param checksum
	 *            Instance of the checksum generator.
	 */
	public ActionChecksumSwitch(Checksum checksum) {
		this.checksum = checksum;
	}

	/**
	 * Updates the checksum with the information that the provided action is
	 * next in the order.
	 * 
	 * @param action
	 */
	protected void updateChecksumWithOrder(AbstractAction action) {
		Checksum_PCM_10.updateChecksum(checksum, Checksum_PCM_10.SEPARATOR
				+ action.eClass().getName());
	}

	/**
	 * Updates the checksum with the specifications for the provided variable
	 * usage.
	 * 
	 * @param variableUsage
	 *            The usage.
	 */
	protected void updateChecksumWithVariableUsage(VariableUsage variableUsage) {
		Checksum_PCM_10.updateChecksum(
				checksum,
				Checksum_PCM_10.SEPARATOR_HIERARCHY_START
						+ PCMUtil.getQualifiedName(variableUsage));
		for (VariableCharacterisation varChar : variableUsage
				.getVariableCharacterisation_VariableUsage()) {
			Checksum_PCM_10
					.updateChecksum(
							checksum,
							Checksum_PCM_10.SEPARATOR
									+ varChar.getType().getLiteral()
									+ "="
									+ toUnformattedSpecification(varChar
											.getSpecification_VariableCharacterisation()));
		}
		Checksum_PCM_10.updateChecksum(checksum,
				Checksum_PCM_10.SEPARATOR_HIERARCHY_END);
	}

	/**
	 * Updates the checksum with the information on internal resource demand for
	 * {@link AbstractInternalControlFlowAction}s.
	 * 
	 * @param action
	 *            The action.
	 */
	protected void updateChecksumWithAICFACalls(
			AbstractInternalControlFlowAction action) {
		for (InfrastructureCall infrastructureCall : action
				.getInfrastructureCall__Action()) {
			Checksum_PCM_10.updateChecksum(checksum, Checksum_PCM_10.SEPARATOR
					+ infrastructureCall.getSignature__InfrastructureCall()
							.getId());
			Checksum_PCM_10.updateChecksum(checksum, Checksum_PCM_10.SEPARATOR
					+ infrastructureCall.getRequiredRole__InfrastructureCall()
							.getId());
			Checksum_PCM_10.updateChecksum(
					checksum,
					Checksum_PCM_10.SEPARATOR
							+ toUnformattedSpecification(infrastructureCall
									.getNumberOfCalls__InfrastructureCall()));
			for (VariableUsage variableUsage : infrastructureCall
					.getInputVariableUsages__CallAction()) {
				updateChecksumWithVariableUsage(variableUsage);
			}
		}
		for (ResourceCall resourceCall : action.getResourceCall__Action()) {
			Checksum_PCM_10.updateChecksum(checksum, Checksum_PCM_10.SEPARATOR
					+ resourceCall.getSignature__ResourceCall().getId());
			Checksum_PCM_10.updateChecksum(checksum, Checksum_PCM_10.SEPARATOR
					+ resourceCall.getResourceRequiredRole__ResourceCall()
							.getId());
			Checksum_PCM_10.updateChecksum(
					checksum,
					Checksum_PCM_10.SEPARATOR
							+ toUnformattedSpecification(resourceCall
									.getNumberOfCalls__ResourceCall()));
			for (VariableUsage variableUsage : resourceCall
					.getInputVariableUsages__CallAction()) {
				updateChecksumWithVariableUsage(variableUsage);
			}
		}
		for (ParametricResourceDemand demand : action
				.getResourceDemand_Action()) {
			Checksum_PCM_10
					.updateChecksum(
							checksum,
							demand.eClass().getName()
									+ Checksum_PCM_10.SEPARATOR
									+ demand.getRequiredResource_ParametricResourceDemand()
											.getId()
									+ Checksum_PCM_10.SEPARATOR
									+ demand.getRequiredResource_ParametricResourceDemand()
											.getEntityName()
									+ Checksum_PCM_10.SEPARATOR_HIERARCHY_END
									+ toUnformattedSpecification(demand
											.getSpecification_ParametericResourceDemand()));
		}
	}

	/**
	 * Returns a textual representation stripped of whitespace and formatting
	 * characters.
	 * 
	 * @param specification
	 *            The specification.
	 * @return Stripped text.
	 */
	protected String toUnformattedSpecification(PCMRandomVariable specification) {
		return specification.getSpecification().replaceAll("[\t\n\f\r\u000B]",
				"");
	}

	@Override
	public Boolean caseResourceDemandingBehaviour(
			ResourceDemandingBehaviour object) {
		Checksum_PCM_10.updateChecksum(checksum,
				Checksum_PCM_10.SEPARATOR_HIERARCHY_START);
		AbstractAction action = PCMUtil.getInitialAction(object);
		while (action != null) {
			Checksum_PCM_10.updateChecksum(checksum, Checksum_PCM_10.SEPARATOR
					+ action.eClass().getName());
			doSwitch(action);
			action = action.getSuccessor_AbstractAction();
		}
		Checksum_PCM_10.updateChecksum(checksum,
				Checksum_PCM_10.SEPARATOR_HIERARCHY_END);
		return true;
	}

	@Override
	public Boolean caseStartAction(StartAction object) {
		updateChecksumWithOrder(object);
		updateChecksumWithAICFACalls(object);
		return true;
	}

	@Override
	public Boolean caseStopAction(StopAction object) {
		updateChecksumWithOrder(object);
		updateChecksumWithAICFACalls(object);
		return true;
	}

	@Override
	public Boolean caseInternalAction(InternalAction object) {
		updateChecksumWithOrder(object);
		updateChecksumWithAICFACalls(object);
		return true;
	}

	@Override
	public Boolean caseInternalCallAction(InternalCallAction object) {
		updateChecksumWithOrder(object);
		updateChecksumWithAICFACalls(object);
		doSwitch(object.getCalledResourceDemandingInternalBehaviour());
		return true;
	}

	@Override
	public Boolean caseExternalCallAction(ExternalCallAction object) {
		updateChecksumWithOrder(object);
		Checksum_PCM_10.updateChecksum(checksum, Checksum_PCM_10.SEPARATOR
				+ object.getCalledService_ExternalService().getId()
				+ Checksum_PCM_10.SEPARATOR + object.getRole_ExternalService()
				+ Checksum_PCM_10.SEPARATOR_HIERARCHY_START + "Input=");
		for (VariableUsage variableUsage : object
				.getInputVariableUsages__CallAction()) {
			updateChecksumWithVariableUsage(variableUsage);
		}
		Checksum_PCM_10.updateChecksum(checksum, Checksum_PCM_10.SEPARATOR
				+ "Output=");
		for (VariableUsage variableUsage : object
				.getReturnVariableUsage__CallReturnAction()) {
			updateChecksumWithVariableUsage(variableUsage);
		}
		Checksum_PCM_10.updateChecksum(checksum,
				Checksum_PCM_10.SEPARATOR_HIERARCHY_END);
		return true;
	}

	@Override
	public Boolean caseSetVariableAction(SetVariableAction object) {
		updateChecksumWithOrder(object);
		updateChecksumWithAICFACalls(object);
		for (VariableUsage variableUsage : object
				.getLocalVariableUsages_SetVariableAction()) {
			updateChecksumWithVariableUsage(variableUsage);
		}
		return true;
	}

	@Override
	public Boolean caseAcquireAction(AcquireAction object) {
		updateChecksumWithOrder(object);
		updateChecksumWithAICFACalls(object);
		Checksum_PCM_10.updateChecksum(checksum, object
				.getPassiveresource_AcquireAction().getId());
		return true;
	}

	@Override
	public Boolean caseReleaseAction(ReleaseAction object) {
		updateChecksumWithOrder(object);
		updateChecksumWithAICFACalls(object);
		Checksum_PCM_10.updateChecksum(checksum, object
				.getPassiveResource_ReleaseAction().getId());
		return true;
	}

	@Override
	public Boolean caseLoopAction(LoopAction object) {
		updateChecksumWithOrder(object);
		updateChecksumWithAICFACalls(object);
		Checksum_PCM_10.updateChecksum(
				checksum,
				Checksum_PCM_10.SEPARATOR
						+ toUnformattedSpecification(object
								.getIterationCount_LoopAction()));
		doSwitch(object.getBodyBehaviour_Loop());
		return true;
	}

	@Override
	public Boolean caseCollectionIteratorAction(CollectionIteratorAction object) {
		updateChecksumWithOrder(object);
		updateChecksumWithAICFACalls(object);
		Checksum_PCM_10.updateChecksum(checksum, Checksum_PCM_10.SEPARATOR
				+ object.getParameter_CollectionIteratorAction()
						.getParameterName());
		doSwitch(object.getBodyBehaviour_Loop());
		return true;
	}

	@Override
	public Boolean caseBranchAction(BranchAction object) {
		updateChecksumWithOrder(object);
		updateChecksumWithAICFACalls(object);
		int i = 0;
		for (AbstractBranchTransition abt : object.getBranches_Branch()) {
			Checksum_PCM_10.updateChecksum(checksum, Checksum_PCM_10.SEPARATOR
					+ Integer.toString(i++) + Checksum_PCM_10.SEPARATOR
					+ abt.eClass().getName());
			if (abt instanceof GuardedBranchTransition) {
				GuardedBranchTransition gbt = (GuardedBranchTransition) abt;
				Checksum_PCM_10
						.updateChecksum(
								checksum,
								Checksum_PCM_10.SEPARATOR
										+ toUnformattedSpecification(gbt
												.getBranchCondition_GuardedBranchTransition()));
			} else if (abt instanceof ProbabilisticBranchTransition) {
				ProbabilisticBranchTransition pbt = (ProbabilisticBranchTransition) abt;
				Checksum_PCM_10.updateChecksum(
						checksum,
						Checksum_PCM_10.SEPARATOR
								+ Double.toString(pbt.getBranchProbability()));
			} else {
				throw new IllegalArgumentException(
						"Branch transition must be guarded or probabilistic. Exprienced type: "
								+ abt.eClass().getName());
			}
			doSwitch(abt.getBranchBehaviour_BranchTransition());
		}
		return true;
	}

	@Override
	public Boolean caseForkAction(ForkAction object) {
		updateChecksumWithOrder(object);
		updateChecksumWithAICFACalls(object);
		int i = 0;
		for (ForkedBehaviour behavior : object
				.getAsynchronousForkedBehaviours_ForkAction()) {
			Checksum_PCM_10.updateChecksum(checksum, Checksum_PCM_10.SEPARATOR
					+ Integer.toString(i++) + Checksum_PCM_10.SEPARATOR
					+ "Asynchronous");
			doSwitch(behavior);
		}
		i = 0;
		for (ForkedBehaviour behavior : object
				.getSynchronisingBehaviours_ForkAction()
				.getSynchronousForkedBehaviours_SynchronisationPoint()) {
			Checksum_PCM_10.updateChecksum(checksum, Checksum_PCM_10.SEPARATOR
					+ Integer.toString(i++) + Checksum_PCM_10.SEPARATOR
					+ "Synchronized");
			doSwitch(behavior);
		}
		for (VariableUsage variableUsage : object
				.getSynchronisingBehaviours_ForkAction()
				.getOutputParameterUsage_SynchronisationPoint()) {
			updateChecksumWithVariableUsage(variableUsage);
		}
		return true;
	}
}
