package org.palladiosimulator.protocom.tech.servlet.resourceenvironment

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment
import org.palladiosimulator.protocom.lang.java.IJClass
import org.palladiosimulator.protocom.tech.ConceptMapping
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification

class ServletResourceEnvironment extends ConceptMapping<ResourceEnvironment> implements IJClass {
	protected val frameworkBase = "org.palladiosimulator.protocom.framework.java.ee"
	
	new(ResourceEnvironment pcmEntity) {
		super(pcmEntity)
	}
	
	/**
	 * 
	 */
	private def getRate(ResourceContainer container, String pattern) {
		val specifications = container.activeResourceSpecifications_ResourceContainer
		
		for (ProcessingResourceSpecification spec : specifications) {
			val type = spec.activeResourceType_ActiveResourceSpecification
			
			if (type.entityName.toLowerCase.contains(pattern)) {
				return spec.processingRate_ProcessingResourceSpecification.specification
			}
		}
	}
	
	override superClass() {
	}
	
	override packageName() {
		"main"
	}
	
	override compilationUnitName() {
		"ResourceEnvironment"
	}
	
	override constructors() {
		newLinkedList
	}
	
	override annotations() {
		newLinkedList
	}
	
	override interfaces() {
		newLinkedList
	}
	
	override methods() {
		val containers = pcmEntity.resourceContainer_ResourceEnvironment
		var i = 0
		
		#[
			new JMethod()
				.withVisibilityModifier("public")
				.withStaticModifier
				.withName("init")
				.withImplementation('''
					«frameworkBase».prototype.Prototype prototype = «frameworkBase».prototype.Prototype.getInstance();
					«frameworkBase».prototype.Container[] containers = new «frameworkBase».prototype.Container[«containers.length»];
					
					«FOR container : containers»
						containers[«i++»] = new «frameworkBase».prototype.Container("«container.id»", "«container.entityName»", "«getRate(container, "cpu")»", "«getRate(container, "hdd")»");
					«ENDFOR»
					
					prototype.setContainers(containers);
				''')
		]
	}
	
	override fields() {
		newLinkedList
	}
	
	override filePath() {
		"src/main/ResourceEnvironment.java"
	}
	
	override projectName() {
	}	
}
