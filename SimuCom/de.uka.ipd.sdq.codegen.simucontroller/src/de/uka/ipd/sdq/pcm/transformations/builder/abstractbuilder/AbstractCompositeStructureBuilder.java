package de.uka.ipd.sdq.pcm.transformations.builder.abstractbuilder;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public abstract class AbstractCompositeStructureBuilder 
extends AbstractComponentBuilder {

	
	public AbstractCompositeStructureBuilder(PCMAndCompletionModelHolder models) {
		super(models);
	}

	protected void addRequiredDelegationConnector(OperationRequiredRole innerRole, AssemblyContext innerContext, OperationRequiredRole outerRole) {
		if (innerRole == null || innerContext == null || outerRole == null)
			throw new IllegalArgumentException("At least on argument is null in delegation connector creation.");
		RequiredDelegationConnector reqDelCon = CompositionFactory.eINSTANCE.createRequiredDelegationConnector();
		reqDelCon.setAssemblyContext_RequiredDelegationConnector(innerContext);
		reqDelCon.setInnerRequiredRole_RequiredDelegationConnector(innerRole);
		reqDelCon.setOuterRequiredRole_RequiredDelegationConnector(outerRole);
		
		getComposedStructure().getRequiredDelegationConnectors_ComposedStructure().add(reqDelCon);
	}

	protected void addProvidedDelegationConnector(OperationProvidedRole innerRole, AssemblyContext innerContext, OperationProvidedRole outerRole) {
		if (innerRole == null || innerContext == null || outerRole == null)
			throw new IllegalArgumentException("At least on argument is null in delegation connector creation.");
		ProvidedDelegationConnector delCon = CompositionFactory.eINSTANCE.createProvidedDelegationConnector();
		delCon.setAssemblyContext_ProvidedDelegationConnector(innerContext);
		delCon.setInnerProvidedRole_ProvidedDelegationConnector(innerRole);
		delCon.setOuterProvidedRole_ProvidedDelegationConnector(outerRole);
		
		getComposedStructure().getProvidedDelegationConnectors_ComposedStructure().add(delCon);
	}

	protected void addAssemblyConnector(OperationRequiredRole from, AssemblyContext fromContext, OperationProvidedRole to, AssemblyContext toContext){
		AssemblyConnector acon = CompositionFactory.eINSTANCE.createAssemblyConnector();
		acon.setParentStructure_AssemblyConnector(getComposedStructure());
		acon.setRequiredRole_AssemblyConnector(from);
		acon.setRequiringAssemblyContext_AssemblyConnector(fromContext);
		acon.setProvidedRole_AssemblyConnector(to);
		acon.setProvidingAssemblyContext_AssemblyConnector(toContext);
	}
	
	
	protected ComposedStructure getComposedStructure(){
		return (ComposedStructure) myComponent;
	}

}
