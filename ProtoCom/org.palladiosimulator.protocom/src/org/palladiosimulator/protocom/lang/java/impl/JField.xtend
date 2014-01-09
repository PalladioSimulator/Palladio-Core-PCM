package org.palladiosimulator.protocom.lang.java.impl

import org.palladiosimulator.protocom.lang.java.IJField

/**
 * Class representing a field in Java. 
 *
 * This is a data class. Since methods are not a compilation unit, they do not
 * inherit GeneratedFile.
 * 
 * TODO: Change class to @Data
 * 
 * @author Thomas Zolynski 
 */
class JField implements IJField {
	
	private String name
	private String type
	private String visibility
	
	override name() {
		name	
	}
	
	override type() {
		type
	}
	
	override visibility() {
		'''«IF visibility != null»«visibility»«ELSE»protected«ENDIF»'''
	}


	def withName(String name) {
		this.name = name
		this
	}
	
	def withType(String type) {
		this.type = type
		this
	}
	
	def withModifierVisibility(String visibility) {
		this.visibility = visibility
		this
	}
	
}
