package de.uka.sdq.pcm.transformations.builder;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

public interface IComponentBuilder extends IBuilder {

	AssemblyContext getAssemblyContext();
	
	ProvidedRole getProvidedRole();

	RequiredRole getRequiredRole();

	RepositoryComponent getComponent();
}
