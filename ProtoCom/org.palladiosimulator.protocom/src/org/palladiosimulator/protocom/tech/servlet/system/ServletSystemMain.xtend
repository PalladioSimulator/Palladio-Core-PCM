package org.palladiosimulator.protocom.tech.servlet.system

import org.palladiosimulator.protocom.tech.servlet.ServletClass
import de.uka.ipd.sdq.pcm.system.System;
import org.palladiosimulator.protocom.lang.java.impl.JAnnotation
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.impl.JField
import org.palladiosimulator.protocom.lang.java.util.JavaNames

class ServletSystemMain extends ServletClass<System> {
	new(System pcmEntity) {
		super(pcmEntity)
	}	
	
	override superClass() {
		'''«frameworkBase».ui.Main'''
	}
	
	override annotations() {
		#[new JAnnotation().withName("javax.servlet.annotation.WebServlet").withValues(#['''urlPatterns = "", loadOnStartup = 0'''])]
	}
	
	override compilationUnitName() {
		"Main"
	}
	
	override packageName() {
		"main"
	}
	
	override fields() {
		#[
			new JField().asDefaultSerialVersionUID()
		]
	}
	
	override methods() {
		val system = JavaNames::javaName(pcmEntity)
		val systemClass = JavaNames::fqn(pcmEntity)
		
		#[
			new JMethod()
				.withVisibilityModifier("protected")
				.withReturnType("void")
				.withName("initPrototype")
				.withImplementation('''
					«frameworkBase».prototype.Prototype prototype = «frameworkBase».prototype.Prototype.getInstance();

					prototype.setSystem(new «frameworkBase».prototype.System("«system»", "«systemClass»"));
					prototype.setUsageScenarios(getUsageScenarios());

					ResourceEnvironment.init();
					ComponentAllocation.init();
				'''),
				
			new JMethod()
				.withVisibilityModifier("private")
				.withReturnType('''«frameworkBase».prototype.IUsageScenario[]''')
				.withName("getUsageScenarios")
				.withImplementation('''
					Class<?>[] classes = «frameworkBase».prototype.ClassHelper.getClassesInPackage("usagescenarios");
					«frameworkBase».prototype.IUsageScenario[] scenarios = new «frameworkBase».prototype.IUsageScenario[classes.length];

					try {
						for (int i = 0; i < classes.length; i++) {
							scenarios[i] = («frameworkBase».prototype.IUsageScenario) classes[i].newInstance();
						}
					} catch (Exception e) {
						throw new RuntimeException(e);
					}

					return scenarios;
				''')
				
			/*new JMethod()
				.withName("initAllocationStorage")
				.withImplementation('''AllocationStorage.initSingleton(new AllocationStorage());'''), 
				
			new JMethod()
				.withVisibilityModifier("protected")
				.withReturnType("String[]")
				.withName("getSystem")
				.withImplementation('''
					return new String[] {"«JavaNames::fqn(pcmEntity)»", "«JavaNames::javaName(pcmEntity)»"};
				''')*/
		]
	}
	
	override filePath() {
		"/src/main/Main.java"
	}
}
