package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import com.google.inject.Inject
import de.uka.ipd.sdq.completions.DelegatingExternalCallAction
import de.uka.ipd.sdq.pcm.reliability.FailureType
import de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType
import de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType
import de.uka.ipd.sdq.pcm.reliability.ResourceTimeoutFailureType
import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType
import de.uka.ipd.sdq.pcm.seff.AbstractAction
import de.uka.ipd.sdq.pcm.seff.AcquireAction
import de.uka.ipd.sdq.pcm.seff.BranchAction
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction
import de.uka.ipd.sdq.pcm.seff.ForkAction
import de.uka.ipd.sdq.pcm.seff.InternalAction
import de.uka.ipd.sdq.pcm.seff.LoopAction
import de.uka.ipd.sdq.pcm.seff.ReleaseAction
import de.uka.ipd.sdq.pcm.seff.SetVariableAction
import de.uka.ipd.sdq.pcm.seff.StartAction
import de.uka.ipd.sdq.pcm.seff.StopAction
import de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour
import edu.kit.student.dwerle.xtendfw.annotations.ModelIn

@ModelIn(#[
	"completions.DelegatingExteralCallAction",
	"pcm.reliability.*",
	"pcm.seff.*"
])
abstract class SEFFBodyXpt {
	@Inject extension CallsXpt
	@Inject extension PCMext
	@Inject extension ResourcesXpt
	@Inject extension JavaNamesExt
	@Inject extension JavaCoreXpt
	
	def String action(AbstractAction action)
	def String action(StartAction action)
	def String action(StopAction action)
	def String action(CollectionIteratorAction action) 	
	def String action(LoopAction action)
	def String action(BranchAction action)
	def String action(AcquireAction action)
	def String action(ReleaseAction action)
	def String action(SetVariableAction action)
	def String action(ForkAction action)
	def String action(DelegatingExternalCallAction action)
	
	def String action(InternalAction action) '''
	/* InternalAction - START */
		// software failures:
		«action.failureInternalActionPreTM»
		// direct resource demands:
		«action.resourceDemands»
		// infrastructure calls:
		«FOR call : action.infrastructureCall__Action»
			«call.call(action)»
		«ENDFOR»
	/* InternalAction - END */
	'''
	
	def String action(ExternalCallAction action) '''
	/* ExternalCallAction - START */
		{ //this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.
			«action.calledService_ExternalService.call(action,
				"myContext.getRole"+action.role_ExternalService.javaName+"().",
				action.inputVariableUsages__CallAction,
				action.returnVariableUsage__CallReturnAction)»
		}
	/* ExternalCallAction - END */
	'''
	
	def String action(RecoveryAction action) '''
	{ /* RecoveryAction - START */
		«action.primaryBehaviour__RecoveryAction.recoveryActionAlternative»
	} /* RecoveryAction - END */
	'''

	private def String recoveryActionAlternative(RecoveryActionBehaviour behaviour) '''
	/* RecoveryActionBehaviour - START */
	«val id = behaviour.id.javaVariableName»
	«behaviour.initFailureHandling(id)»
	try {
		«behaviour.steps_Behaviour.findStart.actions»	
	} catch(de.uka.ipd.sdq.simucomframework.exceptions.FailureException ex_«id») {
			
		// Remember the type of the failure-on-demand occurrence:
		failureException_«id» = ex_«id»;

		// Remove all additional stack frames; they are invalid now:
		for(int frameCount_«id» = 0; frameCount_«id» < ctx.getStack().size() - stackSize_«id»; ++frameCount_«id») {
			ctx.getStack().removeStackFrame();
		}
	
		«FOR alternative:behaviour.failureHandlingAlternatives__RecoveryActionBehaviour»
			«alternative.nextRecoveryActionAlternative(id)»
		«ENDFOR»
	} finally {}

	// no more alternatives.
	if(failureException_«id»!=null) { // failure occurred? 
		throw failureException_«id»;
	}
	
	/* RecoveryActionBehaviour - END */
	'''
	
	def checkIfExceptionIsHandled(FailureHandlingEntity entity, String id) '''
		(
		«IF entity.failureTypes_FailureHandlingEntity.size == 0»
			false
		«ELSE»
			«entity.failureTypes_FailureHandlingEntity.map[checkFailureTypeMatch(it, id)].join("||")»
		«ENDIF»
		)
	'''
	
	def dispatch checkFailureTypeMatch(FailureType ft, String id) {
		// error
	}
	
	def dispatch checkFailureTypeMatch(SoftwareInducedFailureType ft, String id) '''
		«IF (ft instanceof ResourceTimeoutFailureType)»
			«val resourceFailureType = ft as ResourceTimeoutFailureType»
			(
			  (failureException_«id».getFailureType() instanceof
			  de.uka.ipd.sdq.reliability.core.MarkovResourceTimeoutFailureType)
			  &&
			  (((de.uka.ipd.sdq.reliability.core.MarkovResourceTimeoutFailureType)
			  failureException_«id».getFailureType()).getPassiveResourceId().equals(
			  "«resourceFailureType.passiveResource__ResourceTimeoutFailureType.id»"))
			)
		«ELSE»
			(
			  (failureException_«id».getFailureType() instanceof
			  de.uka.ipd.sdq.reliability.core.MarkovSoftwareInducedFailureType)
			  &&
			  (((de.uka.ipd.sdq.reliability.core.MarkovSoftwareInducedFailureType)
			  failureException_«id».getFailureType()).getSoftwareFailureId().equals("«ft.id»"))
			)
		«ENDIF»
	'''
	
	def dispatch checkFailureTypeMatch(HardwareInducedFailureType ft, String id) '''
		(
		  (failureException_«id».getFailureType() instanceof
		  de.uka.ipd.sdq.reliability.core.MarkovHardwareInducedFailureType)
		  &&
		  (((de.uka.ipd.sdq.reliability.core.MarkovHardwareInducedFailureType)
		  failureException_«id».getFailureType()).getResourceTypeId().equals(
		  "«ft.processingResourceType__HardwareInducedFailureType.id»"))
		)
	'''
	
	def dispatch checkFailureTypeMatch(NetworkInducedFailureType ft, String id) '''
		(
		  (failureException_«id».getFailureType() instanceof
		  de.uka.ipd.sdq.reliability.core.MarkovNetworkInducedFailureType)
		  &&
		  (((de.uka.ipd.sdq.reliability.core.MarkovNetworkInducedFailureType)
		  failureException_«id».getFailureType()).getCommLinkResourceTypeId().equals(
		  "«ft.communicationLinkResourceType__NetworkInducedFailureType.id»"))
		)
	'''
	
	def initFailureHandling(Object obj, String id) '''
		de.uka.ipd.sdq.simucomframework.exceptions.FailureException failureException_«id»=null;
		int stackSize_«id»=ctx.getStack().size();
	'''
	
	def nextRecoveryActionAlternative(RecoveryActionBehaviour behaviour, String id) '''
		// Let the next alternative behaviour handle the failure, if
		// (i)  the previous alternatives did not already handle it, and
		// (ii) the handled failure types of the next alternative include
		//      the occurred failure type:
		if(failureException_«id» != null)
		{
			if(«behaviour.checkIfExceptionIsHandled(id)») {
		
				// Mark the original exception as handled (even if the
				// handling alternative fails itself, this will be a new
				// failure, and the original failure is counted as handled):
				ctx.getModel().getFailureStatistics().increaseFailureCounter(de.uka.ipd.sdq.reliability.core.FailureStatistics.FailureType.HANDLED, failureException_«id».getFailureType());
				failureException_«id» = null;
		
				«behaviour.recoveryActionAlternative»
			}
		}
	'''
	
	def catchFailureExceptions(ExternalCallAction action, String id) '''
		«IF action != null»
			catch(de.uka.ipd.sdq.simucomframework.exceptions.FailureException ex) {
				
				// Remember the type of the failure-on-demand occurrence:
				failureException_«id» = ex;
				
				// Remove all additional stack frames; they are invalid now:
				for(int frameCount_«id» = 0; frameCount_«id» < ctx.getStack().size() - stackSize_«id»; ++frameCount_«id») {
					ctx.getStack().removeStackFrame();
				}
			}
		«ELSE»
			finally {}
		«ENDIF»
	'''
	
	def CharSequence failureInternalActionPreTM(InternalAction action)
}