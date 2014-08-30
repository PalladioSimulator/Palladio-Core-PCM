package org.palladiosimulator.protocom.tech.servlet.usage

import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.usagemodel.Start
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import org.palladiosimulator.protocom.lang.java.impl.JAnnotation
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.util.PcmCalls
import org.palladiosimulator.protocom.tech.servlet.ServletClass
import org.palladiosimulator.protocom.tech.servlet.util.PcmServletProtoUserAction

class ServletUsageScenario extends ServletClass<UsageScenario> {
	new(UsageScenario pcmEntity) {
		super(pcmEntity)
	}
	
	override superClass() {
		'''«frameworkBase».usage.UsageScenario'''
	}
	
	override annotations() {
		#[
			new JAnnotation()
				.withName("javax.servlet.annotation.WebServlet")
				.withValues(#['''urlPatterns = "/«compilationUnitName»"''', "loadOnStartup = 0"])
		]
	}
	
	override fields() {
		var result = newLinkedList
		
		result += new JField()
			.asDefaultSerialVersionUID()
				
		result += new JField()
			.withName("ctx")
			.withType('''«frameworkBase».stubs.StackContext''')
		
		result += PcmCalls::querySystemCalls(pcmEntity.scenarioBehaviour_UsageScenario).map[it.providedRole_EntryLevelSystemCall].toSet.map[
			new JField()
				.withName(JavaNames::portMemberVar(it as OperationProvidedRole))
				.withType(JavaNames::fqn((it as OperationProvidedRole).providedInterface__OperationProvidedRole))]
		
		return result
	}
	
	override methods() {
		#[
			new JMethod()
				.withName("start")
				.withReturnType("void")
				.withThrows('''«frameworkBase».modules.ModuleStartException''')
				.withImplementation('''
					«frameworkBase».stubs.IProbabilityFunctionFactory probFunctionFactory = «frameworkBase».stubs.ProbabilityFunctionFactoryImpl.getInstance();
					probFunctionFactory.setRandomGenerator(new «frameworkBase».stubs.DefaultRandomGenerator());
					«frameworkBase».stubs.StoExCache.initialiseStoExCache(probFunctionFactory);
					
					ctx = new «frameworkBase».stubs.StackContext();
					ctx.getStack().createAndPushNewStackFrame();
					double result = ctx.evaluate("DoublePDF[(1;1.0)]", Double.class);
					ctx.getStack().removeStackFrame();
					System.out.println("Evaluated: " + result);
					
					try {
						«FOR providedRole : PcmCalls::querySystemCalls(pcmEntity.scenarioBehaviour_UsageScenario).map[it.providedRole_EntryLevelSystemCall].toSet»
							«generatePortLookup(providedRole)»
						«ENDFOR»
					} catch («frameworkBase».registry.RegistryException e) {
						throw new «frameworkBase».modules.ModuleStartException();
					}
				'''), 
				
				new JMethod()
					.withName("run")
					.withReturnType("void")
					.withImplementation('''
						«new PcmServletProtoUserAction().userActions(pcmEntity.scenarioBehaviour_UsageScenario.actions_ScenarioBehaviour.filter[Start.isInstance(it)].get(0))»
					''')
		]
	}
	
	private def generatePortLookup(OperationProvidedRole role) {
		'''
		«JavaNames::portMemberVar(role)» = («JavaNames::fqn(role.providedInterface__OperationProvidedRole)»)«frameworkBase».registry.Registry..getInstance().lookup("«JavaNames::portClassName(role)»_");
		'''
	}
}
