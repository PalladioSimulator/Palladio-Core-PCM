package de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.RepositoryXpt
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface
import de.uka.ipd.sdq.pcm.repository.OperationInterface

class SimRepositoryXpt extends RepositoryXpt {
	@Inject SimJavaCoreXpt simJavaCoreXpt

	override interfaceHelperMethodsDeclarationTM(OperationInterface oi) {
		simJavaCoreXpt.interfaceHelperMethodsDeclaration(oi)
	}

	override interfaceHelperMethodsDeclarationTM(InfrastructureInterface ii) {
		simJavaCoreXpt.interfaceHelperMethodsDeclaration(ii)
	}

}
