/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import java.util.List;
import java.util.Collection;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.emf.ecore.EObject;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.AbstractUserActionSuccessorEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.OpenWorkloadEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;

import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.gef.EditPart;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class UsageScenarioCanonicalEditPolicy extends
		CanonicalConnectionEditPolicy {

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		List result = new LinkedList();
		EObject modelObject = ((View) getHost().getModel()).getElement();
		View viewObject = (View) getHost().getModel();
		EObject nextValue;
		int nodeVID;
		nextValue = ((UsageScenario) modelObject)
				.getScenarioBehaviour_UsageScenario();
		nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(
				viewObject, nextValue);
		if (ScenarioBehaviourEditPart.VISUAL_ID == nodeVID) {
			result.add(nextValue);
		}
		nextValue = ((UsageScenario) modelObject).getWorkload_UsageScenario();
		nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(
				viewObject, nextValue);
		switch (nodeVID) {
		case ClosedWorkloadEditPart.VISUAL_ID: {
			result.add(nextValue);
			break;
		}
		case OpenWorkloadEditPart.VISUAL_ID: {
			result.add(nextValue);
			break;
		}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean shouldDeleteView(View view) {
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			return view.isSetElement()
					&& (view.getElement() == null || view.getElement()
							.eIsProxy());
		}
		int nodeVID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
		switch (nodeVID) {
		case ScenarioBehaviourEditPart.VISUAL_ID:
		case ClosedWorkloadEditPart.VISUAL_ID:
		case OpenWorkloadEditPart.VISUAL_ID:
			return true;
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
	protected boolean shouldIncludeConnection(Edge connector,
			Collection children) {
		return false;
	}

	/**
	 * @generated
	 */
	protected void refreshSemantic() {
		List createdViews = new LinkedList();
		createdViews.addAll(refreshSemanticChildren());
		List createdConnectionViews = new LinkedList();
		createdConnectionViews.addAll(refreshSemanticConnections());
		createdConnectionViews.addAll(refreshConnections());

		if (createdViews.size() > 1) {
			// perform a layout of the container
			DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host()
					.getEditingDomain(), createdViews, host());
			executeCommand(new ICommandProxy(layoutCmd));
		}

		createdViews.addAll(createdConnectionViews);
		makeViewsImmutable(createdViews);
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
			for (Iterator diagramLinks = existingLinks.iterator(); diagramLinks
					.hasNext();) {
				Edge nextDiagramLink = (Edge) diagramLinks.next();
				EObject diagramLinkObject = nextDiagramLink.getElement();
				EObject diagramLinkSrc = nextDiagramLink.getSource()
						.getElement();
				EObject diagramLinkDst = nextDiagramLink.getTarget()
						.getElement();
				int diagramLinkVisualID = PalladioComponentModelVisualIDRegistry
						.getVisualID(nextDiagramLink);
				for (Iterator modelLinkDescriptors = myLinkDescriptors
						.iterator(); modelLinkDescriptors.hasNext();) {
					LinkDescriptor nextLinkDescriptor = (LinkDescriptor) modelLinkDescriptors
							.next();
					if (diagramLinkObject == nextLinkDescriptor
							.getLinkElement()
							&& diagramLinkSrc == nextLinkDescriptor.getSource()
							&& diagramLinkDst == nextLinkDescriptor
									.getDestination()
							&& diagramLinkVisualID == nextLinkDescriptor
									.getVisualID()) {
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
	 * @generated
	 */
	private void collectAllLinks(View view) {
		EObject modelElement = view.getElement();
		int diagramElementVisualID = PalladioComponentModelVisualIDRegistry
				.getVisualID(view);
		switch (diagramElementVisualID) {
		case ScenarioBehaviourEditPart.VISUAL_ID:
		case ClosedWorkloadEditPart.VISUAL_ID:
		case OpenWorkloadEditPart.VISUAL_ID:
		case StartEditPart.VISUAL_ID:
		case StopEditPart.VISUAL_ID:
		case EntryLevelSystemCallEditPart.VISUAL_ID:
		case VariableUsageEditPart.VISUAL_ID:
		case VariableCharacterisationEditPart.VISUAL_ID:
		case LoopEditPart.VISUAL_ID:
		case ScenarioBehaviour2EditPart.VISUAL_ID:
		case BranchEditPart.VISUAL_ID:
		case BranchTransitionEditPart.VISUAL_ID:
		case ScenarioBehaviour3EditPart.VISUAL_ID:
		case UsageScenarioEditPart.VISUAL_ID: {
			myEObject2ViewMap.put(modelElement, view);
			storeLinks(modelElement, getDiagram());
		}
		default: {
		}
			for (Iterator children = view.getChildren().iterator(); children
					.hasNext();) {
				View childView = (View) children.next();
				collectAllLinks(childView);
			}
		}
	}

	/**
	 * @generated
	 */
	private Collection createConnections(Collection linkDescriptors) {
		if (linkDescriptors.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		List adapters = new LinkedList();
		for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator
				.hasNext();) {
			final LinkDescriptor nextLinkDescriptor = (LinkDescriptor) linkDescriptorsIterator
					.next();
			EditPart sourceEditPart = getEditPartFor(nextLinkDescriptor
					.getSource());
			EditPart targetEditPart = getEditPartFor(nextLinkDescriptor
					.getDestination());
			if (sourceEditPart == null || targetEditPart == null) {
				continue;
			}
			CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(
					nextLinkDescriptor.getSemanticAdapter(), null,
					ViewUtil.APPEND, false, ((IGraphicalEditPart) getHost())
							.getDiagramPreferencesHint());
			CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(
					descriptor);
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
	 * @generated
	 */
	private EditPart getEditPartFor(EObject modelElement) {
		View view = (View) myEObject2ViewMap.get(modelElement);
		if (view != null) {
			return (EditPart) getHost().getViewer().getEditPartRegistry().get(
					view);
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
	private void storeTypeModelFacetLinks(EObject container,
			EClass containerMetaclass) {
	}

	/**
	 *@generated
	 */
	private void storeFeatureModelFacetLinks(EObject container,
			EClass containerMetaclass, Diagram diagram) {

		if (UsagemodelPackage.eINSTANCE.getAbstractUserAction().isSuperTypeOf(
				containerMetaclass)) {
			EObject nextDestination = (EObject) ((AbstractUserAction) container)
					.getSuccessor();
			myLinkDescriptors
					.add(new LinkDescriptor(
							container,
							nextDestination,
							PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002,
							AbstractUserActionSuccessorEditPart.VISUAL_ID));

		}
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
		protected LinkDescriptor(EObject source, EObject destination,
				EObject linkElement, IElementType elementType, int linkVID) {
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
		protected LinkDescriptor(EObject source, EObject destination,
				IElementType elementType, int linkVID) {
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
