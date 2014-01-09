package com.palladio_simulator.protocom.lang.java

import java.util.Collection

interface IJClass extends IJCompilationUnit {
	
	/**
	 * Inherited class name.
	 */
	def String superClass()
	
	/**
	 * Constructors of this class.
	 * 
	 * FIXME: JMethod is ok'ish, but not entirely correct.
	 */
	def Collection<? extends IJMethod> constructors()

}
