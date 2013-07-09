package de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim

import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.RepositoryXpt
import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.repository.Interface

class SimRepositoryXpt extends RepositoryXpt {
	@Inject SimJavaCoreXpt simJavaCoreXpt
	
	override interfaceHelperMethodsDeclarationTM(Interface ii) {
		simJavaCoreXpt.interfaceHelperMethodsDeclaration(ii)
	}
	
}