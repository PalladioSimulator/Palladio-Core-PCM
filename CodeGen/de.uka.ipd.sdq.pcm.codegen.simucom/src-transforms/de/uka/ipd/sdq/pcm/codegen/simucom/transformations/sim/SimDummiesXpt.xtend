package de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.DummiesXpt
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.JavaNamesExt
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.SpecifiedExecutionTime
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.SystemSpecifiedExecutionTime
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.SpecifiedReliabilityAnnotation
import de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription
import de.uka.ipd.sdq.pcm.reliability.FailureType
import de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType
import de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType
import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature
import de.uka.ipd.sdq.pcm.repository.OperationInterface
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import de.uka.ipd.sdq.pcm.repository.OperationSignature
import de.uka.ipd.sdq.pcm.system.System

class SimDummiesXpt extends DummiesXpt {

	//-------------------------------
	// In the simulation, generate a time delay
	// and / or failure occurrences according
	// to the specification in the QoS annotations
	// of the system
	//-------------------------------
	@Inject extension JavaNamesExt

	def dispatch dummyMethodBody(OperationSignature os, System s, OperationRequiredRole r) '''
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe resultStackFrame = 
			new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe();
		«val annotations1 = s.qosAnnotations_System.map[specifiedQoSAnnotations_QoSAnnotations].flatten.filter[
			(it instanceof SpecifiedReliabilityAnnotation) && (it.role_SpecifiedQoSAnnotation == r) &&
				(it.signature_SpecifiedQoSAnnation == os)]»
		«IF annotations1.size == 1»
			// Simulate a failure that occurs with a predefined probability:
			if (ctx.getModel().getConfig().getSimulateFailures()) {   
				double accProbability = 0;
				double randValue = ctx.getModel().getConfiguration().getRandomGenerator().random();
				«FOR fod : (annotations1.head as SpecifiedReliabilityAnnotation).
			externalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation»«fod.failureOccurrence(r.id, os.id)»«ENDFOR»
			}
		«ENDIF»
		«val annotations2 = s.qosAnnotations_System.map[specifiedQoSAnnotations_QoSAnnotations].flatten.filter[
			(it instanceof SystemSpecifiedExecutionTime) && (it.role_SpecifiedQoSAnnotation == r) &&
				(it.signature_SpecifiedQoSAnnation == os)]»
		«IF annotations2.size == 1»
			double delay = de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter.toDouble(ctx.evaluate("«(annotations2.
			head as SpecifiedExecutionTime).specification_SpecifiedExecutionTime.specification.specificationString()»"));
			logger.info("SystemExternalCall «annotations2.head.signature_SpecifiedQoSAnnation.entityName» delaying execution for "+delay);
			ctx.getThread().hold(delay);
		«ENDIF»
		return resultStackFrame;
	'''

	def dispatch dummyMethodBody(InfrastructureSignature is, System s, InfrastructureRequiredRole r) '''
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe resultStackFrame = 
			new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe();
		«val annotations1 = s.qosAnnotations_System.map[specifiedQoSAnnotations_QoSAnnotations].flatten.filter[
			(it instanceof SpecifiedReliabilityAnnotation) && (it.role_SpecifiedQoSAnnotation == r) &&
				(it.signature_SpecifiedQoSAnnation == is)]»
		«IF annotations1.size == 1»
			// Simulate a failure that occurs with a predefined probability:
			if (ctx.getModel().getConfig().getSimulateFailures()) {   
				double accProbability = 0;
				double randValue = Math.random();
				«FOR fod : (annotations1.head as SpecifiedReliabilityAnnotation).
			externalFailureOccurrenceDescriptions__SpecifiedReliabilityAnnotation»«fod.failureOccurrence(r.id, is.id)»«ENDFOR»
			}
		«ENDIF»
		«««		«LET s.qosAnnotations_System.specifiedQoSAnnotations_QoSAnnotations.select(annotation | (SystemSpecifiedExecutionTime.isInstance(annotation)) && (annotation.role_SpecifiedQoSAnnotation==r) && (annotation.signature_SpecifiedQoSAnnation==this)) AS annotations»
		«val annotations2 = s.qosAnnotations_System.map[specifiedQoSAnnotations_QoSAnnotations].flatten.filter[
			(it instanceof SystemSpecifiedExecutionTime) && (it.role_SpecifiedQoSAnnotation == r) &&
				(it.signature_SpecifiedQoSAnnation == is)]»
		«IF annotations2.size == 1»
			double delay = de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter.toDouble(ctx.evaluate("«(annotations2.
			head as SpecifiedExecutionTime).specification_SpecifiedExecutionTime.specification.specificationString()»"));
			logger.info("SystemExternalCall «annotations2.head.signature_SpecifiedQoSAnnation.entityName» delaying execution for "+delay);
			ctx.getThread().hold(delay);
		«ENDIF»
		return resultStackFrame;
	'''

	def failureOccurrence(ExternalFailureOccurrenceDescription efod, String roleId, String signatureId) '''
		«val fp = "failureProbability" + efod.failureType__ExternalFailureOccurrenceDescription.javaName()»
			double «fp»;
			try {
				    «fp» = Double.parseDouble("«efod.failureProbability»");
			} catch (NumberFormatException exception) {
				    «fp» = 0.0;
			}
				accProbability += «fp»;
						if ((«fp» > 0.0) && (accProbability >= randValue)) {
					«efod.failureType__ExternalFailureOccurrenceDescription.raiseFailure(roleId, signatureId)»
			}
	'''

	def dispatch raiseFailure(FailureType ft, String roleId, String signatureId) '''
«««		«ERROR "OAW GENERATION ERROR [m2t_transforms/sim/dummies.xpt]: Unknown FailureType found: " + ft.entityName + " (type = " + ft.metaType + "; id = " + ft.id + ")"» 
	'''

	def dispatch raiseFailure(SoftwareInducedFailureType sift, String roleId, String signatureId) '''
		de.uka.ipd.sdq.simucomframework.exceptions.FailureException.raise(
		this.getModel(),this.getModel().getFailureStatistics().getExternalSoftwareFailureType(
			"«sift.id»", "«roleId»", "«signatureId»"));
	'''

	def dispatch raiseFailure(HardwareInducedFailureType hift, String roleId, String signatureId) '''
		    de.uka.ipd.sdq.simucomframework.exceptions.FailureException.raise(
		this.getModel(),this.getModel().getFailureStatistics().getExternalHardwareFailureType(
		    "«hift.processingResourceType__HardwareInducedFailureType.id»", "«roleId»", "«signatureId»"));
	'''

	def dispatch raiseFailure(NetworkInducedFailureType nift, String roleId, String signatureId) '''
		de.uka.ipd.sdq.simucomframework.exceptions.FailureException.raise(
		this.getModel(),this.getModel().getFailureStatistics().getExternalNetworkFailureType(
			"«nift.communicationLinkResourceType__NetworkInducedFailureType.id»", "«roleId»", "«signatureId»"));
	'''

	// overwrite template methods
	@Inject SimProvidedPortsXpt simProvidedPorts

	override dummyComponentPortHelperMethodTM(OperationInterface oi) {
		simProvidedPorts.dummyComponentPortHelperMethod(oi)
	}

	override dummyComponentPortHelperMethodTM(InfrastructureInterface oi) {
		simProvidedPorts.dummyComponentPortHelperMethod(oi)
	}

	override dummyMethodBodyTM(OperationSignature os, System s, OperationRequiredRole r) {
		dummyMethodBody(os, s, r)
	}

	override dummyMethodBodyTM(InfrastructureSignature os, System s, InfrastructureRequiredRole r) {
		dummyMethodBody(os, s, r)
	}

}
