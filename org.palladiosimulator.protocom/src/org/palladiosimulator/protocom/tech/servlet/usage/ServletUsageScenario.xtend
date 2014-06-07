package org.palladiosimulator.protocom.tech.servlet.usage

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import org.palladiosimulator.protocom.lang.java.impl.JAnnotation
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.tech.servlet.ServletClass

class ServletUsageScenario extends ServletClass<UsageScenario> {
	new(UsageScenario pcmEntity) {
		super(pcmEntity)
	}
	
	override superClass() {
		"javax.servlet.http.HttpServlet"
	}
	
	override annotations() {
		#[
			new JAnnotation()
				.withName("javax.servlet.annotation.WebServlet")
				.withValues(#['''urlPatterns = "/«compilationUnitName»"''', "loadOnStartup = 0"])
		]
	}
	
	override fields() {
		#[
			new JField()
				.withName("ctx")
				.withType('''«frameworkBase».stubs.StackContext''')
		]
	}
	
	override constructors() {
		#[
			new JMethod()
				.withImplementation('''
					«frameworkBase».stubs.IProbabilityFunctionFactory probFunctionFactory = «frameworkBase».stubs.ProbabilityFunctionFactoryImpl.getInstance();
					probFunctionFactory.setRandomGenerator(new «frameworkBase».stubs.DefaultRandomGenerator());
					«frameworkBase».stubs.StoExCache.initialiseStoExCache(probFunctionFactory);
					
					ctx = new «frameworkBase».stubs.StackContext();
					ctx.getStack().createAndPushNewStackFrame();
					double result = ctx.evaluate("DoublePDF[(1;1.0)]", Double.class);
					ctx.getStack().removeStackFrame();
					System.out.println("Evaluated: " + result);
				''')
		]
	}
}
