package de.uka.sdq.pcm.transformations.builder.seff;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

public class MiddlewareComponentSeffBuilder extends DelegatorComponentSeffBuilder {

	protected RequiredRole middlewareRole;

	public MiddlewareComponentSeffBuilder(
			ProvidedRole domainProvRole,
			RequiredRole domainReqRole,
			RequiredRole middlewareReqRole) {
		super(domainProvRole, domainReqRole);
		this.middlewareRole = middlewareReqRole;
	}

}
