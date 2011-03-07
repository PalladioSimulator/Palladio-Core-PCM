package de.uka.ipd.sdq.pcm.transformations.builder;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

public interface IComponentBuilder extends IBuilder {

	AssemblyContext getAssemblyContext();
	
	OperationProvidedRole getOperationProvidedRole();

	OperationRequiredRole getOperationRequiredRole();

	RepositoryComponent getComponent();
}
