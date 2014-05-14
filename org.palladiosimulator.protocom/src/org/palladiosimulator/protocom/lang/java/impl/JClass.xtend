package org.palladiosimulator.protocom.lang.java.impl

import java.util.Collection
import org.palladiosimulator.protocom.lang.java.IJClass
import org.palladiosimulator.protocom.lang.java.IJMethod
import org.palladiosimulator.protocom.lang.java.IJField

class JClass extends JCompilationUnit<IJClass> implements IJClass {

	override Collection<String> interfaces() {
		provider.interfaces
	}

	override String superClass() {
		provider.superClass
	}
	
	override constructors() {
		provider.constructors
	}

	override def String header() {
		'''
			package «packageName»;
			
			public class «compilationUnitName» «IF superClass != null»extends «superClass»«ENDIF» «implementedClasses»
		'''
	}

	override body() {
		'''		
			«FOR field : fields»
				«field(field)»
			«ENDFOR»
			
			«FOR constructor : constructors»
				«constructor(constructor)»
			«ENDFOR»
			
			«FOR method : methods»
				«method(method)»
			«ENDFOR»
			
		'''
	}
	

	def field(IJField field) {
		'''
		«field.visibility» «field.type» «field.name»;
		'''
	}
	
	def constructor(IJMethod method) {
		'''
		«method.visibilityModifier» «compilationUnitName»(«method.parameters») «IF method.throwsType != null»throws «method.throwsType»«ENDIF»
		{
			«method.body»
		}
		'''
	}
	
	def method(IJMethod method) {
		'''
		«method.visibilityModifier» «method.staticModifier» «method.returnType» «method.name»(«method.parameters») «IF method.throwsType != null»throws «method.throwsType»«ENDIF»
		«IF method.body != null»
		{
			«method.body»
		}
		«ELSE»
		;
		«ENDIF»

		'''
	}

}
