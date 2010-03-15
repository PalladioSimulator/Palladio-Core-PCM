package de.uka.ipd.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.transformations.builder.IComponentBuilder;

/**
 * Interface callable for a builder after running its build method to retrieve the created
 * objects
 * @author Snowball
 *
 */
public interface IClientServerConnectorCompletionComponentBuilder 
extends IComponentBuilder {
	RequiredRole getClientSideMiddlewareRole();
	RequiredRole getServerSideMiddlewareRole();
}
