package de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim

import com.google.inject.Inject
import de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference
import de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference
import de.fzi.se.quality.qualityannotation.PCMParameterPartition
import de.uka.ipd.sdq.completions.DelegatingExternalCallAction
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.JavaNamesExt
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.PCMext
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.SEFFBodyXpt
import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription
import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType
import de.uka.ipd.sdq.pcm.seff.AbstractAction
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition
import de.uka.ipd.sdq.pcm.seff.AcquireAction
import de.uka.ipd.sdq.pcm.seff.BranchAction
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction
import de.uka.ipd.sdq.pcm.seff.ForkAction
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition
import de.uka.ipd.sdq.pcm.seff.InternalAction
import de.uka.ipd.sdq.pcm.seff.LoopAction
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition
import de.uka.ipd.sdq.pcm.seff.ReleaseAction
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF
import de.uka.ipd.sdq.pcm.seff.SetVariableAction
import de.uka.ipd.sdq.pcm.seff.StartAction
import de.uka.ipd.sdq.pcm.seff.StopAction
import edu.kit.ipd.sdq.xtend2m.annotations.ModelIn

@ModelIn(#[
	"quality.parameters.pcm.PCMComponentParameterReference",
	"quality.parameters.pcm.PCMOperationParameterReference",
	"quality.qualityannotation.PCMParameterPartition",
	"completions.DelegatingExternalCallAction",
	"pcm.reliability.InternalFailureOccurrenceDescription",
	"pcm.reliability.SoftwareInducedFailureType",
	"pcm.seff.AbstractAction",
	"pcm.seff.AbstractBranchTransition",
	"pcm.seff.AcquireAction",
	"pcm.seff.BranchAction",
	"pcm.seff.CollectionIteratorAction",
	"pcm.seff.ForkAction",
	"pcm.seff.GuardedBranchTransition",
	"pcm.seff.InternalAction",
	"pcm.seff.LoopAction",
	"pcm.seff.ProbabilisticBranchTransition",
	"pcm.seff.ReleaseAction",
	"pcm.seff.ResourceDemandingSEFF",
	"pcm.seff.SetVariableAction",
	"pcm.seff.StartAction",
	"pcm.seff.StopAction"
])
class SimSEFFBodyXpt extends SEFFBodyXpt {
	@Inject extension JavaNamesExt
	@Inject extension PCMext
	@Inject extension SimAccuracyInfluenceExt
	@Inject extension SimJavaCoreXpt
	@Inject extension SimAccuracyXpt
	@Inject extension SimMeasuringPointExt
	
	// ----------------------------
	// SimuCom templates for parts of a SEFF
	// ----------------------------
	override dispatch action(CollectionIteratorAction cir) '''
		for (int iterationCount = 0, maxIterationCount = (Integer)ctx.evaluate("«cir.parameter_CollectionIteratorAction.parameterName».NUMBER_OF_ELEMENTS",Integer.class);
				iterationCount < maxIterationCount; iterationCount++) {
			de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> loopFrame = ctx.getStack().createAndPushNewStackFrame(ctx.getStack().currentStackFrame());
			ctx.evaluateInner(loopFrame, "«cir.parameter_CollectionIteratorAction.parameterName».INNER");

			«cir.bodyBehaviour_Loop.steps_Behaviour.findStart().actionsAsCalls»
			ctx.getStack().removeStackFrame();
		}
	'''
	
	// TODO: check if <<id>> translated correctly
	override dispatch action(LoopAction la) '''
	   for (int iterationCount«la.id.javaVariableName()» = 0, maxIterationCount«la.id.javaVariableName()» = (Integer)ctx.evaluate("«la.iterationCount_LoopAction.specification.specificationString()»",Integer.class);
	            iterationCount«la.id.javaVariableName()» < maxIterationCount«la.id.javaVariableName()»; iterationCount«la.id.javaVariableName()»++){
	       «la.bodyBehaviour_Loop.steps_Behaviour.findStart().actionsAsCalls»
	   }
	'''
	
	override failureInternalActionPreTM(InternalAction ia) '''
		«IF ia.internalFailureOccurrenceDescriptions__InternalAction.size > 0»
		// Simulate a failure that occurs with a predefined probability:
		if (ctx.getModel().getConfig().getSimulateFailures()) {
			double accProbability = 0;
			double randValue = ctx.getModel().getConfiguration().getRandomGenerator().random();
			«FOR ifod : ia.internalFailureOccurrenceDescriptions__InternalAction»«ifod.failureOccurrence»«ENDFOR»
		}
	    «ENDIF»
	'''
	
	def failureOccurrence(InternalFailureOccurrenceDescription ifod) '''
		«val fp = "failureProbability"+ifod.softwareInducedFailureType__InternalFailureOccurrenceDescription.javaName()»
		double «fp»;
		try {
			    «fp» = Double.parseDouble("«ifod.failureProbability»");
		} catch (NumberFormatException exception) {
			    «fp» = 0.0;
		}
			accProbability += «fp»;
			if ((«fp» > 0.0) && (accProbability >= randValue)) {
				«ifod.softwareInducedFailureType__InternalFailureOccurrenceDescription.raiseInternalSoftwareFailure(ifod.internalAction__InternalFailureOccurrenceDescription.id)»
		}
	'''
	
	def raiseInternalSoftwareFailure(SoftwareInducedFailureType sift, String internalActionId) '''
		de.uka.ipd.sdq.simucomframework.exceptions.FailureException.raise(
			this.getModel(),this.getModel().getFailureStatistics().getInternalSoftwareFailureType(
				"«sift.id»", "«internalActionId»"));
	'''
	
	override dispatch action(BranchAction ba) '''
		{
			«val counterID = ba.id.javaVariableName»
			«IF ba.branches_Branch.head instanceof ProbabilisticBranchTransition»
				double u«counterID» = (Double)ctx.evaluate("DoublePDF[(1;1.0)]",Double.class);
				double sum«counterID» = 0;
				«FOR b : ba.branches_Branch SEPARATOR ""»«b.branchTransition(counterID)»«ENDFOR»
			«ELSE»
				«FOR b : ba.branches_Branch SEPARATOR " else "»«b.branchTransition(counterID)»«ENDFOR»
				else
				    logger.error("No branch condition evaluated to true in «ba.entityName» :-(");  
					
			«ENDIF»
		}
	'''
	
	// TODO: ERROR
	def dispatch branchTransition(AbstractBranchTransition abt, String counterNumber) '''
«««	   «ERROR "OAW GENERATION ERROR [m2t_transforms/sim/seff.xpt]: Unknown branch transition found!"»
	'''
	
	def dispatch branchTransition(GuardedBranchTransition gbt, String counterNumber) '''
		if ((Boolean)ctx.evaluate("«gbt.branchCondition_GuardedBranchTransition.specification.specificationString()»") == true)
		{
			«gbt.branchBehaviour_BranchTransition.steps_Behaviour.findStart().actionsAsCalls»
		}
	'''
	
	def dispatch branchTransition(ProbabilisticBranchTransition pbt, String counterNumber) '''
		if (sum«counterNumber» <= u«counterNumber» && u«counterNumber» < sum«counterNumber» + «pbt.branchProbability» )
		{
			«pbt.branchBehaviour_BranchTransition.steps_Behaviour.findStart().actionsAsCalls»
		}
		sum«counterNumber» += «pbt.branchProbability»;
	'''
	
	override dispatch action(AcquireAction aa) '''
			// Acquire «aa.passiveresource_AcquireAction»
	{
	  //TODO Here, a resource demand of 0 is issued to a hard-coded resource "CPU" (ID = "_oro4gG3fEdy4YaaT-RYrLQ")
	double demand = de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter.toDouble(ctx.evaluate("0", Double.class));
	ctx.findResource(this.assemblyContext.getId()).loadActiveResource(ctx.getThread(), "_oro4gG3fEdy4YaaT-RYrLQ", demand);
	}
	if (pr_«aa.passiveresource_AcquireAction.id.javaVariableName()» == null) {
		// Initialize Resource First...
		pr_«aa.passiveresource_AcquireAction.id.javaVariableName()» = ctx.getPassiveRessourceInContext(
			"«aa.passiveresource_AcquireAction.getResourceURI()»",
			this.assemblyContext,
			ctx.findResource(this.assemblyContext.getId()),
			(Integer)ctx.evaluate("«aa.passiveresource_AcquireAction.capacity_PassiveResource.specification.specificationString()»", Integer.class)
		);
	}
	pr_«aa.passiveresource_AcquireAction.id.javaVariableName()».acquire(ctx.getThread(), 1, «aa.timeout», «aa.timeoutValue»);
	'''
	
	override dispatch action(ReleaseAction ra) '''
	// Release «ra.passiveResource_ReleaseAction»
	if (pr_«ra.passiveResource_ReleaseAction.id.javaVariableName()» == null) {
		// Initialize Resource First...
		pr_«ra.passiveResource_ReleaseAction.id.javaVariableName()» = ctx.getPassiveRessourceInContext(
			"«ra.passiveResource_ReleaseAction.getResourceURI()»",
			this.assemblyContext,
			ctx.findResource(this.assemblyContext.getId()),
			(Integer)ctx.evaluate("«ra.passiveResource_ReleaseAction.capacity_PassiveResource.specification.specificationString()»",Integer.class)
		);
	}
	pr_«ra.passiveResource_ReleaseAction.id.javaVariableName()».release(ctx.getThread(), 1);
	'''
	
	override dispatch action(StartAction sa) '''
		«IF sa.eContainer instanceof ResourceDemandingSEFF»
		«val rdseff = (sa.eContainer as ResourceDemandingSEFF)»
		«val qualityAnnotation = rdseff.getQualityAnnotation()»
«««			«REM»Handle accuracy influence analysis. «ENDREM»
				«IF qualityAnnotation != null»
					«FOR partition : rdseff.qualityAnnotation.validForParameterPartitions
						.filter(typeof(PCMParameterPartition))
						.filter[(parameterReference instanceof PCMOperationParameterReference) || (parameterReference instanceof PCMComponentParameterReference)]»
					«partition.checkAccuracy(rdseff, sa)»
					«ENDFOR»
«««					«EXPAND m2t_transforms::sim::accuracy::CheckAccuracy(rdseff, this) FOREACH getQualityAnnotation(rdseff).validForParameterPartitions.typeSelect(PCMParameterPartition).select(partition| PCMOperationParameterReference.isInstance(partition.parameterReference) || PCMComponentParameterReference.isInstance(partition.parameterReference))»
				«ELSE»
					«IF getQualityAnnotationRepository() != null»
«««						«REM»Accuracy analysis was requested but no quality annotation could be found for this RDSEFF«ENDREM»
						SeverityAndIssue issue = AccuracyIssueFactory.createMissingQualityAnnotationIssue("«rdseff.getResourceName()»", "«rdseff.id»");
						config.addIssue(issue);
					«ELSE»
«««						«REM»Accuracy analysis was not requested. Do nothing.«ENDREM»
					«ENDIF»
				«ENDIF»
		«ENDIF»
	'''
	
	override dispatch action(StopAction sa) '''
	'''
	
	override dispatch action(SetVariableAction sva) '''
		«FOR pu : sva.localVariableUsages_SetVariableAction»
			«FOR vc : pu.variableCharacterisation_VariableUsage»
				«IF pu.namedReference__VariableUsage.isInnerReference()»
					resultStackFrame.addValue("«pu.parameterUsageLHS()».«vc.type.toString()»",
					   	new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy("«vc.specification_VariableCharacterisation.specification.specificationString()»",methodBodyStackFrame.copyFrame()));
				«ELSE»
					resultStackFrame.addValue("«pu.parameterUsageLHS()».«vc.type.toString()»",
						ctx.evaluate("«vc.specification_VariableCharacterisation.specification.specificationString()»"));
				«ENDIF»
			«ENDFOR»
		«ENDFOR»
	'''
	
	override dispatch action(ForkAction fa) '''
	{
		de.uka.ipd.sdq.simucomframework.fork.ForkedBehaviourProcess[] forks =
			new de.uka.ipd.sdq.simucomframework.fork.ForkedBehaviourProcess[]{
			«FOR f : fa.asynchronousForkedBehaviours_ForkAction SEPARATOR ","»
				new de.uka.ipd.sdq.simucomframework.fork.ForkedBehaviourProcess(ctx, this.assemblyContext.getId(), true, ctx.getThread().getPriority()){
					public void executeBehaviour() {
						try {
							«f.steps_Behaviour.findStart()»
						} catch (de.uka.ipd.sdq.simucomframework.exceptions.FailureException exception) {
							if (ctx.getModel().getConfig().getSimulateFailures()) {
								ctx.getModel().getFailureStatistics().increaseUnhandledFailureCounter(exception.getFailureType(), ctx.getSessionId());
							}
						}
					}
				}
			«ENDFOR»
			«IF (fa.asynchronousForkedBehaviours_ForkAction.size > 0)»
			,
			«ENDIF»
			«IF (fa.synchronisingBehaviours_ForkAction != null)»
				«FOR f: fa.synchronisingBehaviours_ForkAction.synchronousForkedBehaviours_SynchronisationPoint SEPARATOR ","»
					new de.uka.ipd.sdq.simucomframework.fork.ForkedBehaviourProcess(ctx, this.assemblyContext.getId(), false){
						public void executeBehaviour() {
							try {
								«f.steps_Behaviour.findStart()»
							} catch (de.uka.ipd.sdq.simucomframework.exceptions.FailureException exception) {
								if (ctx.getModel().getConfig().getSimulateFailures()) {
									ctx.getModel().getFailureStatistics().increaseUnhandledFailureCounter(exception.getFailureType(), ctx.getSessionId());
								}
							}
						}
					}
				«ENDFOR»
			«ENDIF»
			};
		new de.uka.ipd.sdq.simucomframework.fork.ForkExecutor(ctx.getThread(),forks).run();
	}
	'''
	
	override dispatch action(DelegatingExternalCallAction deca) '''
	{
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx
				.getStack().currentStackFrame();
		// prepare stackframe
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx
				.getStack().createAndPushNewStackFrame(currentFrame);
		stackframe.addVariables(methodBodyStackFrame);
«««		«REM» It is also required to add the variables from the result stack here in the exceptional case of completions
«««		      because the bytesize data for the network load can only be stored there but at the same time needs
«««		      to be passed to the next component in the delegation chain. «ENDREM»
		stackframe.addVariables(resultStackFrame);
	
	
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> callResult =
	   	myContext.getRole«deca.role_ExternalService.javaName()»().«deca.calledService_ExternalService.javaSignature()»
		   	(«deca.calledService_ExternalService.parameterUsageListTM»);
		resultStackFrame.addVariables(callResult);
		// Copy the result variables in my own stack frame so that we can access them in the post actions
		methodBodyStackFrame.addVariables(callResult);
	
		ctx.getStack().removeStackFrame();
	}
	'''	
}