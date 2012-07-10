package de.uka.ipd.sdq.pcm.transformations.builder.connectors;

import de.uka.ipd.sdq.completions.Completion;
import de.uka.ipd.sdq.completions.CompletionsFactory;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.transformations.builder.abstractbuilder.AbstractCompositeStructureBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public abstract class AbstractConnectorCompletionBuilder 
extends AbstractCompositeStructureBuilder {

	protected AssemblyConnector connectorToReplace;
	private static long contextID = 0;

	public AbstractConnectorCompletionBuilder(PCMAndCompletionModelHolder models, AssemblyConnector con, String componentName){
		super(models, componentName);
		this.connectorToReplace = con;
	}
	
	@Override
	protected RepositoryComponent createComponent(String componentName) {
		Completion completion = CompletionsFactory.eINSTANCE.createCompletion();
		completion.setEntityName("ConnectorCompletion_"+componentName+getNextCounter() );
		
		return completion;
	}

	@Override
	public void build() {
		super.build();
		myOperationProvidedRole = addOperationProvidedRole(connectorToReplace.getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),"ProvidedRole");
		myOperationRequiredRole = addOperationRequiredRole(connectorToReplace.getRequiredRole_AssemblyConnector().getRequiredInterface__OperationRequiredRole(),"RequiredRole");

		myAssemblyContext = CompositionFactory.eINSTANCE.createAssemblyContext(); 
		myAssemblyContext.setEntityName("CompletionComponentContext"+contextID);
		contextID++;
		myAssemblyContext.setEncapsulatedComponent__AssemblyContext(myComponent);
	}
	
}
