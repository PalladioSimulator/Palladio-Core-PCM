package org.palladiosimulator.protocom.tech.servlet

import org.palladiosimulator.protocom.tech.ConceptMapping
import de.uka.ipd.sdq.pcm.system.System;
import org.palladiosimulator.protocom.lang.xml.IPluginXml

class ServletPlugin extends ConceptMapping<System> implements IPluginXml {
	
	new(System pcmEntity) {
		super(pcmEntity)
	}
	
	override extensionPoint() {
		'de.uka.ipd.sdq.simucomframework.controller'
	}
	
	override actionDelegateClass() {
		'main.SimuComControl'
	}
	
	override actionDelegateId() {
		'de.uka.ipd.sdq.codegen.simucominstance.actionDelegate'
	}
	
	override filePath() {
		'plugin.xml'
	}
	
	override projectName() {
	}	
}
