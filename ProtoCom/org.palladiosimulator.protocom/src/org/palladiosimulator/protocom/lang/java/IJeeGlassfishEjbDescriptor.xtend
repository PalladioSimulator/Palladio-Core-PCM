package org.palladiosimulator.protocom.lang.java

import org.palladiosimulator.protocom.lang.ICompilationUnit

interface IJeeGlassfishEjbDescriptor extends ICompilationUnit {
	
	def String ejbName()
	
	def String ejbRefName()
	 
	def String jndiName()
}