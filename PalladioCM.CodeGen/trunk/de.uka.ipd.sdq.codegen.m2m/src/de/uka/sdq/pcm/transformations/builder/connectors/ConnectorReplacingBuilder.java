package de.uka.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.sdq.pcm.transformations.builder.IBuilder;
import de.uka.sdq.pcm.transformations.builder.IComponentBuilder;

/**
 * This builder replaces a given connector with a component built by the given component builder.
 * @author Snowball
 *
 */
public class ConnectorReplacingBuilder implements IBuilder {

	private IComponentBuilder componentBuilder;
	private AssemblyConnector connector;
	private ComposedStructure parent;

	public ConnectorReplacingBuilder(AssemblyConnector con, IComponentBuilder componentBuilder) {
		this.componentBuilder = componentBuilder;
		this.connector = con;
		this.parent = con.getParentStructure_AssemblyConnector();
	}
	
	public void build() {
		// First build the component
		componentBuilder.build();

		// Then integrate the component in the structure instead of the AssemblyConnector
		parent.getChildComponentContexts_ComposedStructure().add(componentBuilder.getAssemblyContext());
		
		AssemblyConnector toCompletionConnector = CompositionFactory.eINSTANCE.createAssemblyConnector();
		AssemblyConnector fromCompletionConnector = CompositionFactory.eINSTANCE.createAssemblyConnector();
		
		toCompletionConnector.setRequiredRole_CompositeAssemblyConnector(connector.getRequiredRole_CompositeAssemblyConnector());
		toCompletionConnector.setRequiringChildComponentContext_CompositeAssemblyConnector(connector.getRequiringChildComponentContext_CompositeAssemblyConnector());
		toCompletionConnector.setProvidedRole_CompositeAssemblyConnector(componentBuilder.getProvidedRole());
		toCompletionConnector.setProvidingChildComponentContext_CompositeAssemblyConnector(componentBuilder.getAssemblyContext());

		fromCompletionConnector.setRequiredRole_CompositeAssemblyConnector(componentBuilder.getRequiredRole());
		fromCompletionConnector.setRequiringChildComponentContext_CompositeAssemblyConnector(componentBuilder.getAssemblyContext());
		fromCompletionConnector.setProvidedRole_CompositeAssemblyConnector(connector.getProvidedRole_CompositeAssemblyConnector());
		fromCompletionConnector.setProvidingChildComponentContext_CompositeAssemblyConnector(connector.getProvidingChildComponentContext_CompositeAssemblyConnector());
		
		parent.getCompositeAssemblyConnectors_ComposedStructure().add(toCompletionConnector);
		parent.getCompositeAssemblyConnectors_ComposedStructure().add(fromCompletionConnector);
		parent.getCompositeAssemblyConnectors_ComposedStructure().remove(connector);
	}

}
