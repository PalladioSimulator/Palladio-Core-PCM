package org.palladiosimulator.protocom.tech.rmi

import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.util.PcmCommons
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.JavaConstants
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