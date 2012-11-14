/**
 *
 */
package de.fzi.se.accuracy.transformation;

import de.fzi.se.quality.qualityannotation.REPrecision;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.runconfig.AccuracyInfluenceAnalysisState;

/**
 * Implementing the transformation of given SEFFs for the state
 * {@link AccuracyInfluenceAnalysisState#AS_SPECIFIED}. Start the transformation by
 * invoking {@link #doSwitch(org.eclipse.emf.ecore.EObject)} with a parameter of
 * type {@link ServiceEffectSpecification}.
 *
 * @author groenda
 *
 */
public class AccuracyInfluenceSEFFTransformationStrategyAsSpecified extends
		AbstractAccuracyInfluenceSEFFTransformationStrategy {

	/**Create a new instance using the given quality annotations.
	 * @param pcmPartition Partition containing the quality annotations.
	 */
	public AccuracyInfluenceSEFFTransformationStrategyAsSpecified(
			PCMResourceSetPartition pcmPartition) {
		super(pcmPartition);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractAccuracyInfluenceSEFFTransformationStrategy#modifyComponentExternalCall(de.uka.ipd.sdq.pcm.seff.ExternalCallAction, de.fzi.se.quality.qualityannotation.REPrecision)
	 */
	@Override
	protected void modifyComponentExternalCall(ExternalCallAction call,
			REPrecision precision) {
		// nothing to do
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractAccuracyInfluenceSEFFTransformationStrategy#modifyComponentInternalCall(de.uka.ipd.sdq.pcm.seff.InternalCallAction, de.fzi.se.quality.qualityannotation.REPrecision)
	 */
	@Override
	protected void modifyComponentInternalCall(InternalCallAction call,
			REPrecision precision) {
		// nothing to do
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractAccuracyInfluenceSEFFTransformationStrategy#modifyInfrastructureCall(de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall, de.fzi.se.quality.qualityannotation.REPrecision)
	 */
	@Override
	protected void modifyInfrastructureCall(InfrastructureCall call,
			REPrecision precision) {
		// nothing to do
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractAccuracyInfluenceSEFFTransformationStrategy#modifyResourceCall(de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall, de.fzi.se.quality.qualityannotation.REPrecision)
	 */
	@Override
	protected void modifyResourceCall(ResourceCall call, REPrecision precision) {
		// nothing to do
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractAccuracyInfluenceSEFFTransformationStrategy#modifyResourceDemand(de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand, de.fzi.se.quality.qualityannotation.REPrecision)
	 */
	@Override
	protected void modifyResourceDemand(ParametricResourceDemand demand,
			REPrecision precision) {
		// nothing to do
	}
}
