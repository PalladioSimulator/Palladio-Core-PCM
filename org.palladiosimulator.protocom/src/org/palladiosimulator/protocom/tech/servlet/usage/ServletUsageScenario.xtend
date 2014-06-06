package org.palladiosimulator.protocom.tech.servlet.usage

import org.palladiosimulator.protocom.tech.servlet.ServletClass
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.util.PcmCommons
import org.palladiosimulator.protocom.lang.java.impl.JAnnotation
import org.palladiosimulator.protocom.lang.java.impl.JMethod

class ServletUsageScenario extends ServletClass<UsageScenario> {
	new(UsageScenario pcmEntity) {
		super(pcmEntity)
	}
	
	override annotations() {
		#[
			new JAnnotation()
				.withName("WebServlet")
				.withValues(#['''urlPatterns = "«compilationUnitName»"'''])
		]
	}
	
	override fields() {
		#[
			new JField()
				.withName("ctx")
				.withType(PcmCommons::stackframeType)
		]
	}
	
	override constructors() {
		#[
			new JMethod()
				.withImplementation('''
					StackContext ctx;
					
					IProbabilityFunctionFactory probFunctionFactory = ProbabilityFunctionFactoryImpl.getInstance();
					probFunctionFactory.setRandomGenerator(new DefaultRandomGenerator());
					StoExCache.initialiseStoExCache(probFunctionFactory);
					
					ctx = new StackContext();
					ctx.getStack().createAndPushNewStackFrame();
					double result = ctx.evaluate("DoublePDF[(1;1.0)]", Double.class);
					ctx.getStack().removeStackFrame();
					System.out.println("Evaluated: " + result);
				''')
		]
	}
}
