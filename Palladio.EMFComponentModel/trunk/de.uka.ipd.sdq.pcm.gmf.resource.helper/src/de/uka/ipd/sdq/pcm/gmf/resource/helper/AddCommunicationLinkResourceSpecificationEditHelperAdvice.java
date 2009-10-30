package de.uka.ipd.sdq.pcm.gmf.resource.helper;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

public class AddCommunicationLinkResourceSpecificationEditHelperAdvice extends
		AbstractEditHelperAdvice implements IEditHelperAdvice {

	// id of LAN in PCM resource repository
	private static final String LAN_COMMUNICATION_LINK_RESOURCE_TYPE = "_o3sScH2AEdyH8uerKnHYug";

	@Override
	public ICommand getAfterEditCommand(IEditCommandRequest request) {
		CommunicationLinkResourceSpecification spec = ResourceenvironmentFactory.eINSTANCE
				.createCommunicationLinkResourceSpecification();

		//edited object should be a single element
		if(request.getElementsToEdit().size() != 1) {
			throw new RuntimeException("Did not expect more than one element in request.");
			//return new CommandResult(new).newErrorCommandResult("failed!"); //TODO
		}
	 	EObject requestElement = (EObject) request.getElementsToEdit().get(0);
	 	
		
		EditingDomain editingDomain = TransactionUtil.getEditingDomain(requestElement);		 
		EList<Resource> resources = editingDomain.getResourceSet().getResources();
		
		Collection<EObject> c = new ArrayList<EObject>();		
		for(Resource r : resources) {			
			c.addAll(r.getContents());			
		}

		SELECT statement = new SELECT(
		new FROM(c),
		new WHERE(
				new EObjectAttributeValueCondition(
						ResourcetypePackage.eINSTANCE.getCommunicationLinkResourceType().getEIDAttribute(),
						new org.eclipse.emf.query.conditions.strings.StringValue(LAN_COMMUNICATION_LINK_RESOURCE_TYPE) 
				))			
		);
		IQueryResult queryResult = statement.execute();
		CommunicationLinkResourceType lanType = (CommunicationLinkResourceType)queryResult.iterator().next();
		
		spec.setCommunicationLinkResourceType_CommunicationLinkResourceSpecification(lanType);
		
		
		SetRequest setRequest = new SetRequest(
				requestElement,
				ResourceenvironmentPackage.eINSTANCE
						.getLinkingResource_CommunicationLinkResourceSpecifications_LinkingResource(),
				spec);

		
		
		
		
		return new SetValueCommand(setRequest);
	}

//	@Override
//	public ICommand getBeforeEditCommand(IEditCommandRequest request) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void configureRequest(IEditCommandRequest request) {
//		//
//	}

//	@Override
//	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
//		CommunicationLinkResourceSpecification spec = ResourceenvironmentFactory.eINSTANCE
//				.createCommunicationLinkResourceSpecification();
//
//		SetRequest setRequest = new SetRequest(
//				(LinkingResource) request.getElementsToEdit(),
//				ResourceenvironmentPackage.eINSTANCE
//						.getLinkingResource_CommunicationLinkResourceSpecifications_LinkingResource(),
//				spec);
//
//		return new SetValueCommand(setRequest);
//	}

}
