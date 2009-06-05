
/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.List;
import java.util.Collection;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntity2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredDelegationConnectorEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.RequiredRoleEditPart;

import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.repository.Role;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.gef.EditPart;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ComposedProvidingRequiringEntityCanonicalEditPolicy extends CanonicalConnectionEditPolicy {
	
/**
 */
protected List getSemanticChildrenList() {
	List result = new LinkedList();
	EObject modelObject = ((View) getHost().getModel()).getElement();
	View viewObject = (View) getHost().getModel();
	result.add(modelObject);
	return result;
}

/**
 */
protected boolean shouldDeleteView(View view) {
	if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
		return view.isSetElement() && (view.getElement() == null || view.getElement().eIsProxy());
	}
	return false;
}

/**
 * @generated
 */
protected String getDefaultFactoryHint() {
	return null;
}

	/**
	 * @generated
	 */
	protected List getSemanticConnectionsList() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	protected EObject getSourceElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected EObject getTargetElement(EObject relationship) {
		return null;
	}

	/**
	 * @generated
	 */
	protected boolean shouldIncludeConnection(Edge connector, Collection children) {
		return false;
	}


	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		List createdViews = new LinkedList();
		createdViews.addAll(refreshSemanticChildren());
		createdViews.addAll(refreshPhantoms());
		List createdConnectionViews = new LinkedList();
		createdConnectionViews.addAll(refreshSemanticConnections());
		createdConnectionViews.addAll(refreshConnections());

		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}

		createdViews.addAll(createdConnectionViews);
		makeViewsImmutable(createdViews);
	}
	
	/**
	 * @generated
	 */
	private Collection refreshPhantoms() {
		Collection phantomNodes = new LinkedList();
		EObject diagramModelObject = ((View) getHost().getModel()).getElement();
		Diagram diagram = getDiagram();
Resource resource = diagramModelObject.eResource();
for (Iterator it = resource.getContents().iterator(); it.hasNext();) {
	EObject nextResourceObject = (EObject) it.next();
	if (nextResourceObject == diagramModelObject) {
		continue;
	}
	int nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(diagram, nextResourceObject);
	switch (nodeVID) {
	case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID: {
			phantomNodes.add(nextResourceObject);
		break;
	}	}
}

for (Iterator diagramNodes = getDiagram().getChildren().iterator(); diagramNodes.hasNext();) {
	View nextView = (View) diagramNodes.next();
	EObject nextViewElement = nextView.getElement();
	if (phantomNodes.contains(nextViewElement)) {
		phantomNodes.remove(nextViewElement);
	}	
}
		return createPhantomNodes(phantomNodes);
	}

/**
 * @generated
 */
private Collection createPhantomNodes(Collection nodes) {
	if (nodes.isEmpty()) {
		return Collections.EMPTY_LIST;
	}
	List descriptors = new ArrayList();
	for (Iterator elements = nodes.iterator(); elements.hasNext();) {
		EObject element = (EObject)elements.next();
		CreateViewRequest.ViewDescriptor descriptor = getViewDescriptor(element);
		descriptors.add(descriptor);
	}
	Diagram diagram = getDiagram();
	EditPart diagramEditPart = getDiagramEditPart();
	
	CreateViewRequest request = getCreateViewRequest(descriptors);
	Command cmd = diagramEditPart.getCommand(request);
	if (cmd == null) {
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		for (Iterator descriptorsIterator = descriptors.iterator(); descriptorsIterator.hasNext();) {
			CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor) descriptorsIterator.next();
			ICommand createCommand = new CreateCommand(((IGraphicalEditPart) getHost()).getEditingDomain(), descriptor, diagram);
			cc.compose(createCommand);
		}
		cmd = new ICommandProxy(cc);
	}	
	
	List adapters = Collections.EMPTY_LIST;
	if ( cmd != null && cmd.canExecute() ) {
		SetViewMutabilityCommand.makeMutable(new EObjectAdapter(((IGraphicalEditPart) diagramEditPart).getNotationView())).execute();
		executeCommand(cmd);
		adapters = (List) request.getNewObject();
	}
	diagramEditPart.refresh();
	return adapters;
}

/**
 * @generated
 */
private EditPart getDiagramEditPart() {
	return (EditPart) getHost().getViewer().getEditPartRegistry().get(getDiagram());
}
	
	/**
	 * @generated
	 */
	private Collection myLinkDescriptors = new LinkedList();
	
	/**
	 * @generated
	 */
	private Map myEObject2ViewMap = new HashMap();

	/**
	 * @generated
	 */
	private Collection refreshConnections() {
		try {
			collectAllLinks(getDiagram());
			Collection existingLinks = new LinkedList(getDiagram().getEdges());
			for (Iterator diagramLinks = existingLinks.iterator(); diagramLinks.hasNext();) {
				Edge nextDiagramLink = (Edge) diagramLinks.next();
				EObject diagramLinkObject = nextDiagramLink.getElement();
				EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
				EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
				int diagramLinkVisualID = PalladioComponentModelVisualIDRegistry.getVisualID(nextDiagramLink);
				for (Iterator modelLinkDescriptors = myLinkDescriptors.iterator(); modelLinkDescriptors.hasNext();) {
					LinkDescriptor nextLinkDescriptor = (LinkDescriptor) modelLinkDescriptors.next();
					if (diagramLinkObject == nextLinkDescriptor.getLinkElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination() && diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
						diagramLinks.remove();
						modelLinkDescriptors.remove();
					}
				}
			}
			deleteViews(existingLinks.iterator());
			return createConnections(myLinkDescriptors);
		} finally {
			myLinkDescriptors.clear();
			myEObject2ViewMap.clear();
		}
	}
	
	/**
	 * @generated not
	 */
	private void collectAllLinks(View view) {
		EObject modelElement = view.getElement();
		int diagramElementVisualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
		switch (diagramElementVisualID) {
		case ComposedProvidingRequiringEntity2EditPart.VISUAL_ID:
		case AssemblyContextEditPart.VISUAL_ID:
		case ProvidedRoleEditPart.VISUAL_ID:
		case RequiredRoleEditPart.VISUAL_ID:
		case ProvidedRole2EditPart.VISUAL_ID:
		case RequiredRole2EditPart.VISUAL_ID:
		case ComposedProvidingRequiringEntityEditPart.VISUAL_ID: { myEObject2ViewMap.put(modelElement, view);
			storeLinks(modelElement, getDiagram());
		}
		default: {
		}
//		for (Iterator children = view.getChildren().iterator(); children.hasNext();) {
//			View childView = (View) children.next();
//			collectAllLinks(childView);
//		}
		}
	}

	/**
	 * @generated not
	 */
	private Collection createConnections(Collection linkDescriptors) {
		if (linkDescriptors.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		List adapters = new LinkedList();
		for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {
			final LinkDescriptor nextLinkDescriptor = (LinkDescriptor) linkDescriptorsIterator.next();
			
			EditPart sourceEditPart = null;
			EditPart targetEditPart = null;
			
			if (nextLinkDescriptor.getLinkElement() instanceof AssemblyConnector) {
				AssemblyConnector ctx = (AssemblyConnector) nextLinkDescriptor.getLinkElement();
				sourceEditPart = myGetEditPartFor((Role)nextLinkDescriptor.getSource(),ctx.getRequiringAssemblyContext_AssemblyConnector());
				targetEditPart = myGetEditPartFor((Role)nextLinkDescriptor.getDestination(),ctx.getProvidingAssemblyContext_AssemblyConnector());
			} else if (nextLinkDescriptor.getLinkElement() instanceof ProvidedDelegationConnector) {
				ProvidedDelegationConnector ctx = (ProvidedDelegationConnector) nextLinkDescriptor.getLinkElement();
				sourceEditPart = myGetEditPartFor((Role)nextLinkDescriptor.getSource(),null);
				targetEditPart = myGetEditPartFor((Role)nextLinkDescriptor.getDestination(),ctx.getChildComponentContext_ProvidedDelegationConnector());
			} else {
				RequiredDelegationConnector ctx = (RequiredDelegationConnector) nextLinkDescriptor.getLinkElement();
				sourceEditPart = myGetEditPartFor((Role)nextLinkDescriptor.getSource(),ctx.getChildComponentContext_RequiredDelegationConnector());
				targetEditPart = myGetEditPartFor((Role)nextLinkDescriptor.getDestination(),null);
			}
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), null, ViewUtil.APPEND, false, ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
			ccr.setType(RequestConstants.REQ_CONNECTION_START);
			ccr.setSourceEditPart(sourceEditPart);
			sourceEditPart.getCommand(ccr);
			ccr.setTargetEditPart(targetEditPart);
			ccr.setType(RequestConstants.REQ_CONNECTION_END);
			Command cmd = targetEditPart.getCommand(ccr);
			if (cmd != null && cmd.canExecute()) {
				executeCommand(cmd);
				IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
				if (viewAdapter != null) {
					adapters.add(viewAdapter);
				}
			}
		}
		return adapters;
	}
	
	/**
	 * @generated not
	 */
	private EditPart myGetEditPartFor(Role modelElement, AssemblyContext ctx) {
		View view = null;
		Diagram dia = (Diagram) getHost().getModel();
		Node pseudoNode =  (Node) dia.getChildren().get(0);
		if (ctx == null) {
			for (Object n : pseudoNode.getChildren()) {
				if (n instanceof Node){
					Node node = (Node) n;
					if (!node.getType().equals("7001") && node.getElement() == modelElement)
						view = node;
				}
			}
		} else {
			Node compartment = getCompartmentNode(pseudoNode.getChildren());
			for (Object n : compartment.getChildren()) {
				if (n instanceof Node){
					Node node = (Node) n;
					if (node.getElement() == ctx){
						view = getRoleChild(node,modelElement);
					}
				}
			}
		}
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
		}
		return null;
	}
	
private View getRoleChild(Node myNode, Role modelElement) {
	for (Object n : myNode.getChildren()) {
		if (n instanceof Node){
			Node node = (Node) n;
			if (node.getElement() == modelElement){
				return node;
			}
		}
	}
		return null;
	}

private Node getCompartmentNode(EList children) {
	for (Object n : children) {
		if (n instanceof Node){
			Node node = (Node) n;
			if (node.getType().equals("7001"))
				return node;
				
		}
	}
	return null;
	}

/**
 *@generated
 */
private void storeLinks(EObject container, Diagram diagram) {
	EClass containerMetaclass = container.eClass();
	storeFeatureModelFacetLinks(container, containerMetaclass, diagram);
	storeTypeModelFacetLinks(container, containerMetaclass);
}
	
/**
 * @generated
 */
private void storeTypeModelFacetLinks(EObject container, EClass containerMetaclass) {	
	storeTypeModelFacetLinks_AssemblyConnector_4001(container, containerMetaclass);
	storeTypeModelFacetLinks_RequiredDelegationConnector_4002(container, containerMetaclass);
	storeTypeModelFacetLinks_ProvidedDelegationConnector_4003(container, containerMetaclass);
}
		
/**
 * @generated not
 */
private void storeTypeModelFacetLinks_AssemblyConnector_4001(EObject container, EClass containerMetaclass) {
	if (CompositionPackage.eINSTANCE.getComposedStructure().isSuperTypeOf(containerMetaclass)) {		
		for (Iterator values = ((ComposedStructure)container).getAssemblyConnectors_ComposedStructure().iterator(); values.hasNext();) {
			EObject nextValue = ((EObject) values.next());
		int linkVID = PalladioComponentModelVisualIDRegistry.getLinkWithClassVisualID(nextValue);
		if (AssemblyConnectorEditPart.VISUAL_ID == linkVID) {
			Object structuralFeatureResult = ((AssemblyConnector)nextValue).getRequiredRole_CompositeAssemblyConnector();				
			if (structuralFeatureResult instanceof EObject) {
				EObject dst = (EObject) structuralFeatureResult;
				structuralFeatureResult = ((AssemblyConnector)nextValue).getProvidedRole_CompositeAssemblyConnector();				
				if (structuralFeatureResult instanceof EObject) {
					EObject src = (EObject) structuralFeatureResult;
					myLinkDescriptors.add(new LinkDescriptor(dst, src, nextValue, de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes.AssemblyConnector_4001, linkVID));
				}
			}
		}
		}
	}
}		
/**
 * @generated
 */
private void storeTypeModelFacetLinks_RequiredDelegationConnector_4002(EObject container, EClass containerMetaclass) {
	if (CompositionPackage.eINSTANCE.getComposedStructure().isSuperTypeOf(containerMetaclass)) {		
		for (Iterator values = ((ComposedStructure)container).getRequiredDelegationConnectors_ComposedStructure().iterator(); values.hasNext();) {
			EObject nextValue = ((EObject) values.next());
		int linkVID = PalladioComponentModelVisualIDRegistry.getLinkWithClassVisualID(nextValue);
		if (RequiredDelegationConnectorEditPart.VISUAL_ID == linkVID) {
			Object structuralFeatureResult = ((RequiredDelegationConnector)nextValue).getOuterRequiredRole_RequiredDelegationConnector();				
			if (structuralFeatureResult instanceof EObject) {
				EObject dst = (EObject) structuralFeatureResult;
				structuralFeatureResult = ((RequiredDelegationConnector)nextValue).getInnerRequiredRole_RequiredDelegationConnector();				
				if (structuralFeatureResult instanceof EObject) {
					EObject src = (EObject) structuralFeatureResult;
					myLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes.RequiredDelegationConnector_4002, linkVID));
				}
			}
		}
		}
	}
}		
/**
 * @generated
 */
private void storeTypeModelFacetLinks_ProvidedDelegationConnector_4003(EObject container, EClass containerMetaclass) {
	if (CompositionPackage.eINSTANCE.getComposedStructure().isSuperTypeOf(containerMetaclass)) {		
		for (Iterator values = ((ComposedStructure)container).getProvidedDelegationConnectors_ComposedStructure().iterator(); values.hasNext();) {
			EObject nextValue = ((EObject) values.next());
		int linkVID = PalladioComponentModelVisualIDRegistry.getLinkWithClassVisualID(nextValue);
		if (ProvidedDelegationConnectorEditPart.VISUAL_ID == linkVID) {
			Object structuralFeatureResult = ((ProvidedDelegationConnector)nextValue).getInnerProvidedRole_ProvidedDelegationConnector();				
			if (structuralFeatureResult instanceof EObject) {
				EObject dst = (EObject) structuralFeatureResult;
				structuralFeatureResult = ((ProvidedDelegationConnector)nextValue).getOuterProvidedRole_ProvidedDelegationConnector();				
				if (structuralFeatureResult instanceof EObject) {
					EObject src = (EObject) structuralFeatureResult;
					myLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes.ProvidedDelegationConnector_4003, linkVID));
				}
			}
		}
		}
	}
}

/**
 *@generated
 */
private void storeFeatureModelFacetLinks(EObject container, EClass containerMetaclass, Diagram diagram) {






}
	
/**
 * @generated
 */
private Diagram getDiagram() {
	return ((View) getHost().getModel()).getDiagram();
}

/**
 * @generated
 */
private class LinkDescriptor {
	
	/**
   	 * @generated
     */
	private EObject mySource;
		
	/**
   	 * @generated
     */
	private EObject myDestination;
	
	/**
   	 * @generated
     */
	private EObject myLinkElement;
	
	/**
   	 * @generated
     */
	private int myVisualID;
		
	/**
   	 * @generated
     */
	private IAdaptable mySemanticAdapter;
		
	/**
   	 * @generated
     */
	protected LinkDescriptor(EObject source, EObject destination, EObject linkElement, IElementType elementType, int linkVID) {
		this(source, destination, linkVID);
		myLinkElement = linkElement;
		final IElementType elementTypeCopy = elementType;
		mySemanticAdapter = new EObjectAdapter(linkElement) {
			public Object getAdapter(Class adapter) {
				if (IElementType.class.equals(adapter)) {
					return elementTypeCopy;
				}
				return super.getAdapter(adapter);
			}
		};
	}

	/**
   	 * @generated
     */
	protected LinkDescriptor(EObject source, EObject destination, IElementType elementType, int linkVID) {
		this(source, destination, linkVID);
		myLinkElement = null;
		final IElementType elementTypeCopy = elementType;
		mySemanticAdapter = new IAdaptable() {
			public Object getAdapter(Class adapter) {
				if (IElementType.class.equals(adapter)) {
					return elementTypeCopy;
				}
				return null;
			}
		};
	}
		
	/**
   	 * @generated
     */
	private LinkDescriptor(EObject source, EObject destination, int linkVID) {
		mySource = source;
		myDestination = destination;
		myVisualID = linkVID;
	}
		
	/**
   	 * @generated
     */
	protected EObject getSource() {
		return mySource;
	}
		
	/**
   	 * @generated
     */
	protected EObject getDestination() {
		return myDestination;
	}
	
	/**
   	 * @generated
     */
	protected EObject getLinkElement() {
		return myLinkElement;
	}
	
	/**
   	 * @generated
     */
	protected int getVisualID() {
		return myVisualID;
	}
		
	/**
   	 * @generated
     */
	protected IAdaptable getSemanticAdapter() {
		return mySemanticAdapter;
	}
}

}
