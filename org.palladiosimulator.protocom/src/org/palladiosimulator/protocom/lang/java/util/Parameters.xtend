package org.palladiosimulator.protocom.lang.java.util

import de.uka.ipd.sdq.pcm.repository.Signature
import de.uka.ipd.sdq.pcm.repository.OperationSignature
import org.palladiosimulator.protocom.lang.java.util.DataTypes

/**
 * Utility class for creating parameter strings.
 * 
 * @author Sebastian Lehrig
 */
class Parameters {
	
	def static dispatch String getParameterList(Signature s) {
	}
	
	def static dispatch String getParameterList(OperationSignature s) {
		'''
			«FOR parameter : s.parameters__OperationSignature SEPARATOR ", "»
				«DataTypes::getDataType(parameter.dataType__Parameter)» «parameter.parameterName»
			«ENDFOR»
		'''
	}
	
	def static dispatch String getParameterUsageList(Signature s) {
	}
	
	def static dispatch String getParameterUsageList(OperationSignature s) {
		'''
			«FOR parameter : s.parameters__OperationSignature SEPARATOR ", "»
				param_«parameter.parameterName»
			«ENDFOR»
		'''
	}
}