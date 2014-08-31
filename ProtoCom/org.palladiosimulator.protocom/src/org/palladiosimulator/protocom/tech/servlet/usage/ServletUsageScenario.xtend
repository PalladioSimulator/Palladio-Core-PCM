package org.palladiosimulator.protocom.tech.servlet.usage

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import org.palladiosimulator.protocom.tech.servlet.ServletClass
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.impl.JMethod

/**
 * @author Christian Klaussner
 */
class ServletUsageScenario extends ServletClass<UsageScenario> {
	new(UsageScenario pcmEntity) {
		super(pcmEntity)
	}
	
	/**
	 * 
	 */
	private def testPlanPath() {
		'''/usagescenarios/jmx/«JavaNames::javaName(pcmEntity)».jmx'''
	}
	
	override packageName() {
		"usagescenarios"
	}
	
	override interfaces() {
		#['''«frameworkBase».prototype.IUsageScenario''']
	}
	
	override methods() {
		#[
			new JMethod()
				.withVisibilityModifier("public")
				.withReturnType("String")
				.withName("getId")
				.withImplementation('''
					return "«pcmEntity.id»";
				'''),
				
			new JMethod()
				.withVisibilityModifier("public")
				.withReturnType("String")
				.withName("getName")
				.withImplementation('''
					return "«pcmEntity.entityName»";
				'''),
				
			new JMethod()
				.withVisibilityModifier("public")
				.withReturnType("java.net.URL")
				.withName("getFileUrl")
				.withImplementation('''
					ClassLoader classLoader = getClass().getClassLoader();
					return classLoader.getResource("«testPlanPath»");
				'''),
				
			new JMethod()
				.withVisibilityModifier("public")
				.withReturnType("String")
				.withName("getFileName")
				.withImplementation('''
					return "«JavaNames::javaName(pcmEntity)».jmx";
				''')
		]
	}
	
	override filePath() {
		"/src/usagescenarios/" + JavaNames::javaName(pcmEntity) + ".java";
	}
}
