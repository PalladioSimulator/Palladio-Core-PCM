package com.palladio_simulator.protocom.tech.rmi

import de.uka.ipd.sdq.pcm.repository.OperationInterface
import com.palladio_simulator.protocom.lang.java.util.JavaNames
import com.palladio_simulator.protocom.lang.java.util.PcmCommons
import com.palladio_simulator.protocom.lang.java.impl.JMethod
import com.palladio_simulator.protocom.lang.java.util.JavaConstants

/**
 * Defining the content of OperationInterface classes.
 * 
 * @author Thomas Zolynski
 */
class PojoOperationInterface extends PojoInterface<OperationInterface> {
	
	new(OperationInterface entity) {
		super(entity)
	}
	
	override interfaces() {
		#[ JavaConstants::RMI_REMOTE_INTERFACE ]
	}
	
	override methods() {
		pcmEntity.signatures__OperationInterface.map[
			new JMethod()
				.withName(JavaNames::javaSignature(it))
				.withReturnType(PcmCommons::stackframeType)
				.withParameters(PcmCommons::stackContextParameterList)
				.withThrows(JavaConstants::RMI_REMOTE_EXCEPTION)
		]
	}
}