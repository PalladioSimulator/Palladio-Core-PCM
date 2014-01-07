package com.palladio_simulator.protocom.lang.java.impl

import com.palladio_simulator.protocom.lang.java.IJInterface
import com.palladio_simulator.protocom.lang.java.IJMethod

class JInterface extends JCompilationUnit<IJInterface> implements IJInterface {
	
	override body() {
		'''
		«FOR method : methods»
			«signature(method)»
		«ENDFOR»
		'''
	}
	
	override header() {
		'''
		package «packageName»;
		
		public interface «compilationUnitName» «implementedClasses»
		'''
	}
	
	
	override implementedClasses() {
		'''
		«IF interfaces != null»
			«FOR implInterface : interfaces BEFORE ' extends ' SEPARATOR ', '»«implInterface»«ENDFOR»
		«ENDIF»
		'''
	}
	
	def signature (IJMethod method) {
		'''«method.visibilityModifier» «method.returnType» «method.name» («method.parameters») «IF method.throwsType != null»throws «method.throwsType»«ENDIF»;'''
	}
}