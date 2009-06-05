package de.uka.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.completions.Completion;
import de.uka.ipd.sdq.completions.CompletionsFactory;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.sdq.pcm.transformations.builder.abstractbuilder.AbstractCompositeStructureBuilder;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public abstract class AbstractConnectorCompletionBuilder 
extends AbstractCompositeStructureBuilder {

	protected AssemblyConnector connectorToReplace;
	private static long contextID = 0;

	public AbstractConnectorCompletionBuilder(PCMAndCompletionModelHolder models, AssemblyConnector con){
		super(models);
		this.connectorToReplace = con;
	}
	
	@Override
	protected ProvidesComponentType createComponent() {
		Completion completion = CompletionsFactory.eINSTANCE.createCompletion();
		completion.setEntityName("ConnectorCompletion"+getNextCounter() );
		
		return completion;
	}

	@Override
	public void build() {
		super.build();
		myProvidedRole = addProvidedRole(connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),"ProvidedRole");
		myRequiredRole = addRequiredRole(connectorToReplace.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),"RequiredRole");

		myAssemblyContext = CompositionFactory.eINSTANCE.createAssemblyContext(); 
		myAssemblyContext.setEntityName("CompletionComponentContext"+contextID);
		contextID++;
		myAssemblyContext.setEncapsulatedComponent_ChildComponentContext(myComponent);
	}
	
}
