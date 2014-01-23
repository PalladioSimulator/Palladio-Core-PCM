package org.palladiosimulator.protocom.lang.java

import org.palladiosimulator.protocom.lang.ICompilationUnit

interface IJeeEjbDescriptor extends ICompilationUnit {
	
	def String displayName()
	
	def String ejbClientJar()	
	
}