package org.palladiosimulator.protocom.tech.servlet.usage

import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction
import de.uka.ipd.sdq.pcm.usagemodel.Branch
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition
import de.uka.ipd.sdq.pcm.usagemodel.Delay
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
import de.uka.ipd.sdq.pcm.usagemodel.Loop
import de.uka.ipd.sdq.pcm.usagemodel.Start
import de.uka.ipd.sdq.pcm.usagemodel.Stop
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import java.math.BigDecimal
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.xml.ITestPlan
import org.palladiosimulator.protocom.tech.ConceptMapping
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload

/**
 * @author Christian Klaussner
 */
class ServletTestPlan extends ConceptMapping<UsageScenario> implements ITestPlan {
	new(UsageScenario pcmEntity) {
		super(pcmEntity)
	}
	
	// Action transformations.
	
	private def buildRequest(String method) {
		val formalTypes = '''["org.palladiosimulator.protocom.framework.java.ee.stubs.StackContext"]'''
		val actualTypes = formalTypes
		
		'''{"name":"«method»","formalTypes":«formalTypes»,"actualTypes":«actualTypes»,"arguments":[{}]}'''
	}
	
	private def getStartAction(BranchTransition branch) {
		var transition = branch.branchedBehaviour_BranchTransition
		transition.actions_ScenarioBehaviour.findFirst[Start.isInstance(it)]
	}
	
	/**
	 * @param action
	 */
	private def String userActions(AbstractUserAction action) {
		'''
		«userAction(action)»
		«IF !Stop.isInstance(action)»
			«userActions(action.successor)»
		«ENDIF»
		'''
	}
	
	private def dispatch userAction(Start action) {
	}
	
	private def dispatch userAction(Stop action) {
	}
	
	/**
	 * 
	 */
	private def dispatch userAction(EntryLevelSystemCall action) {
		val port = JavaNames::portClassName(action.providedRole_EntryLevelSystemCall);
		val method = JavaNames::javaSignature(action.operationSignature__EntryLevelSystemCall)
		
		val name = 
			JavaNames::javaName(action.providedRole_EntryLevelSystemCall.providedInterface__OperationProvidedRole)
			+ "." + 
			action.operationSignature__EntryLevelSystemCall.entityName
		
		val request = buildRequest(method)
		 	
		'''
		<HTTPSamplerProxy guiclass="HttpTestSampleGui" testclass="HTTPSamplerProxy" testname="«name»" enabled="true">
		  <boolProp name="HTTPSampler.postBodyRaw">true</boolProp>
		  <elementProp name="HTTPsampler.Arguments" elementType="Arguments">
		    <collectionProp name="Arguments.arguments">
		      <elementProp name="" elementType="HTTPArgument">
		        <boolProp name="HTTPArgument.always_encode">false</boolProp>
		        <stringProp name="Argument.value">«request»</stringProp>
		        <stringProp name="Argument.metadata"></stringProp>
		      </elementProp>
		    </collectionProp>
		  </elementProp>
		  <stringProp name="HTTPSampler.domain"></stringProp>
		  <stringProp name="HTTPSampler.port"></stringProp>
		  <stringProp name="HTTPSampler.connect_timeout"></stringProp>
		  <stringProp name="HTTPSampler.response_timeout"></stringProp>
		  <stringProp name="HTTPSampler.protocol"></stringProp>
		  <stringProp name="HTTPSampler.contentEncoding"></stringProp>
		  <stringProp name="HTTPSampler.path">org.palladiosimulator.temporary/«port»</stringProp>
		  <stringProp name="HTTPSampler.method">POST</stringProp>
		  <boolProp name="HTTPSampler.follow_redirects">true</boolProp>
		  <boolProp name="HTTPSampler.auto_redirects">false</boolProp>
		  <boolProp name="HTTPSampler.use_keepalive">true</boolProp>
		  <boolProp name="HTTPSampler.DO_MULTIPART_POST">false</boolProp>
		  <boolProp name="HTTPSampler.monitor">false</boolProp>
		  <stringProp name="HTTPSampler.embedded_url_re"></stringProp>
		</HTTPSamplerProxy>
		<hashTree/>
		'''
	}
	
	/**
	 * 
	 */
	private dispatch def userAction(Branch action) {
		val branches = action.branchTransitions_Branch.sortBy[it.branchProbability]
		
		var value = 0;
		var p = new BigDecimal("0.0")

		// Generate code for the branch selection BeanShell script.

		val script = '''
		double val = new Random().nextDouble();
		
		«FOR branch : branches SEPARATOR " else "»if (val &lt; «(p = p.add(new BigDecimal(branch.branchProbability.toString))).toPlainString») {
			vars.put(&quot;BRANCH&quot;, &quot;«value++»&quot;);
		}«ENDFOR»
		'''

		// Generate the branch XML.

		'''
		<BeanShellSampler guiclass="BeanShellSamplerGui" testclass="BeanShellSampler" testname="Branch Selector" enabled="true">
		  <stringProp name="BeanShellSampler.query">«script»</stringProp>
		  <stringProp name="BeanShellSampler.filename"></stringProp>
		  <stringProp name="BeanShellSampler.parameters"></stringProp>
		  <boolProp name="BeanShellSampler.resetInterpreter">false</boolProp>
		</BeanShellSampler>
		<hashTree/>
		<SwitchController guiclass="SwitchControllerGui" testclass="SwitchController" testname="Branch" enabled="true">
		  <stringProp name="SwitchController.value">${BRANCH}</stringProp>
		</SwitchController>
		<hashTree>
		  «FOR branch : branches»
		  <GenericController guiclass="LogicControllerGui" testclass="GenericController" testname="p = «branch.branchProbability»" enabled="true"/>
		  <hashTree>
		    «userActions(branch.startAction)»
		  </hashTree>
		  «ENDFOR»
		</hashTree>
		'''
	}
	
	/**
	 * 
	 */
	private def dispatch userAction(Loop action) {
		
		// Currently, StoEx loop counts are not supported.
		// Default to 1 if a non-static loop count is specified.
		
		val iterations = try {
			val spec = JavaNames::specificationString(action.loopIteration_Loop.specification)
			Integer.parseInt(spec)
		} catch (NumberFormatException e) {
			1
		}
		
		// Find the start action of the loop.
		
		val actions = action.bodyBehaviour_Loop.actions_ScenarioBehaviour
		val startAction = actions.findFirst[Start.isInstance(it)]
		
		'''
		<LoopController guiclass="LoopControlPanel" testclass="LoopController" testname="Loop" enabled="true">
		  <boolProp name="LoopController.continue_forever">true</boolProp>
		  <stringProp name="LoopController.loops">«iterations»</stringProp>
		</LoopController>
		<hashTree>
		  «userActions(startAction)»
		</hashTree>
		'''
	}
	
	private def dispatch userAction(Delay action) {
		
		// Currently, StoEx delays are not supported.
		// Default to 0 if a non-static delay is specified.
		// Furthermore, the delay is rounded because JMeter supports only integer delays. 
		
		var delay = try {
			val spec = JavaNames::specificationString(action.timeSpecification_Delay.specification)
			(Double.parseDouble(spec) * 1000) as int
		} catch (NumberFormatException e) {
			0
		}
		
		'''
		<TestAction guiclass="TestActionGui" testclass="TestAction" testname="Delay" enabled="true">
		  <intProp name="ActionProcessor.action">1</intProp>
		  <intProp name="ActionProcessor.target">0</intProp>
		  <stringProp name="ActionProcessor.duration">«delay»</stringProp>
		</TestAction>
		<hashTree/>
		'''
	}
	
	override population() {
		var workload = pcmEntity.workload_UsageScenario
		
		switch workload {
			ClosedWorkload: workload.population
			default: 1
		}
	}
	
	override thinkTime() {
		var workload = pcmEntity.workload_UsageScenario
		
		switch workload {
			ClosedWorkload:
				try {
					val time = workload.thinkTime_ClosedWorkload
					val spec = JavaNames::specificationString(time.specification)
					
					(Double.parseDouble(spec) * 1000) as int
				} catch (NumberFormatException e) {
					0
				}
			default: 0
		}
	}
	
	override scenarioName() {
		pcmEntity.entityName
	}
	
	// 
	
	override filePath() {
		'''/src/usagescenarios/jmx/«JavaNames::javaName(pcmEntity)».jmx'''
	}
	
	override projectName() {
	}
	
	override content() {
		var actions = pcmEntity.scenarioBehaviour_UsageScenario.actions_ScenarioBehaviour
		var start = actions.findFirst[Start.isInstance(it)] as Start;
		
		userActions(start)
	}
}
