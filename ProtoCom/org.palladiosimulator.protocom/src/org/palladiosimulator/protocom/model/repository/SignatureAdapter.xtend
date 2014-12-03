package org.palladiosimulator.protocom.model.repository

import org.palladiosimulator.protocom.model.ModelAdapter
import de.uka.ipd.sdq.pcm.repository.Signature
import de.uka.ipd.sdq.pcm.repository.OperationSignature
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature

/**
 * Adapter class for PCM Signature entities.
 * @author Christian Klaussner
 */
class SignatureAdapter extends ModelAdapter<Signature> {
	new(Signature entity) {
		super(entity)
	}
	
	/**
	 * Gets the name of the service.
	 * @return a string containing the name of the service
	 */
	def getServiceName() {
		switch entity {
			OperationSignature:
				entity.interface__OperationSignature.safeName.toFirstLower
				+ "_"
				+ entity.signatureName
				
			InfrastructureSignature:
				""
		}
	}
	
	/**
	 * Gets a unique signature name for the specified signature.
	 * @return a string containing the unique name of the signature
	 * @param signature the signature for which the unique name is generated
	 */
	private def getSignatureName(OperationSignature signature) {
		var position = -1
		var OperationSignature s
		
		do {
			position += 1
			s = signature.interface__OperationSignature.signatures__OperationInterface.get(position)
		} while (s != signature)
		
		signature.entityName + position
	}
}
