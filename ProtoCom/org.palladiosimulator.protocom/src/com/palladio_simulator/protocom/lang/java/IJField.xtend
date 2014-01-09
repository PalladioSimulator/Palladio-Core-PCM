package com.palladio_simulator.protocom.lang.java

interface IJField {
	
	/**
	 * The name of the field.
	 */
	def String name()
	
	/**
	 * Type of the field.
	 */
	def String type()	
	
	/**
	 * The visibility modifier of this field.
	 * 
	 * Default value is PROTECTED.
	 */
	def String visibility()
	
}