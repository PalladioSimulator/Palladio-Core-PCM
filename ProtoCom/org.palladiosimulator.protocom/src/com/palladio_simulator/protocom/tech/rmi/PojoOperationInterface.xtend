package com.palladio_simulator.protocom.tech.rmi

import com.palladio_simulator.protocom.lang.java.util.JavaNames
import com.palladio_simulator.protocom.lang.java.util.PcmCommons
import com.palladio_simulator.protocom.lang.java.impl.JMethod
import com.palladio_simulator.protocom.lang.java.util.JavaConstants
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface

/**
 * Defining the content of OperationInterface classes.
 * 
 * @author Thomas Zolynski
 */
class PojoInfrastructureInterface extends PojoInterface<InfrastructureInterface> {
	
	new(InfrastructureInterface entity) {
		super(entity)
	}
	
	override interfaces() {
		#[ JavaConstants::RMI_REMOTE_INTERFACE ]
	}
	
	override methods() {
		pcmEntity.infrastructureSignatures__InfrastructureInterface.map[
			new JMethod()
				.withName(JavaNames::javaSignature(it))
				.withReturnType(PcmCommons::stackframeType)
				.withParameters(PcmCommons::stackContextParameterList)
				.withThrows(JavaConstants::RMI_REMOTE_EXCEPTION)
		]
	}
}