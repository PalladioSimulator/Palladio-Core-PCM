package de.fzi.se.accuracy.util;

import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.util.RepositorySwitch;

public class RoleCategoryCheck extends RepositorySwitch<Boolean> {
	Boolean infrastructureRECategory = false;
	Boolean operationRECategory = false;

	@Override
	public Boolean caseInfrastructureRequiredRole(
			InfrastructureRequiredRole object) {
		infrastructureRECategory = true;
		return true;
	}

	@Override
	public Boolean caseOperationRequiredRole(
			OperationRequiredRole object) {
		operationRECategory = true;
		return true;
	}

}
