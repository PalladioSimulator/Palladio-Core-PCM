/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntity2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelComposedStructureDiagramEditorPlugin;

/**
 * @generated
 */
public class PalladioComponentModelModelingAssistantProvider extends ModelingAssistantProvider {

    /**
     * Get the types to provide within a pop-up bar (hover context menu) in the editor.
     * 
     * This method has manually be adopted to disable the creation of new Composed Providing
     * Requiring Entities within the same system.
     * 
     * @param host
     *            the host
     * @return the types for popup bar
     * @generated not
     */
    public List getTypesForPopupBar(IAdaptable host) {
        IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
        if (editPart instanceof ComposedProvidingRequiringEntity2EditPart) {
            ArrayList types = new ArrayList(2);
            types.add(PalladioComponentModelElementTypes.OperationProvidedRole_3011);
            types.add(PalladioComponentModelElementTypes.OperationRequiredRole_3012);
            return types;
        }
        if (editPart instanceof AssemblyContextEditPart) {
            ArrayList types = new ArrayList(2);
            types.add(PalladioComponentModelElementTypes.OperationProvidedRole_3007);
            types.add(PalladioComponentModelElementTypes.OperationRequiredRole_3008);
            return types;
        }
        if (editPart instanceof ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart) {
            ArrayList types = new ArrayList(1);
            types.add(PalladioComponentModelElementTypes.AssemblyContext_3006);
            types.add(PalladioComponentModelElementTypes.EventChannel_3017);
            return types;
        }
        if (editPart instanceof ComposedProvidingRequiringEntityEditPart) {
            return Collections.EMPTY_LIST;
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getRelTypesOnSource(IAdaptable source) {
        IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
        if (sourceEditPart instanceof OperationProvidedRoleEditPart) {
            return ((OperationProvidedRoleEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof OperationRequiredRoleEditPart) {
            return ((OperationRequiredRoleEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof SourceRoleEditPart) {
            return ((SourceRoleEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof SinkRoleEditPart) {
            return ((SinkRoleEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof InfrastructureRequiredRoleEditPart) {
            return ((InfrastructureRequiredRoleEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof OperationProvidedRole2EditPart) {
            return ((OperationProvidedRole2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof OperationRequiredRole2EditPart) {
            return ((OperationRequiredRole2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getRelTypesOnTarget(IAdaptable target) {
        IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
        if (targetEditPart instanceof OperationProvidedRoleEditPart) {
            return ((OperationProvidedRoleEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof OperationRequiredRoleEditPart) {
            return ((OperationRequiredRoleEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof SinkRoleEditPart) {
            return ((SinkRoleEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof InfrastructureProvidedRoleEditPart) {
            return ((InfrastructureProvidedRoleEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof OperationProvidedRole2EditPart) {
            return ((OperationProvidedRole2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof OperationRequiredRole2EditPart) {
            return ((OperationRequiredRole2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof EventChannelEditPart) {
            return ((EventChannelEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
        IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
        IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
        if (sourceEditPart instanceof OperationProvidedRoleEditPart) {
            return ((OperationProvidedRoleEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof OperationRequiredRoleEditPart) {
            return ((OperationRequiredRoleEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof SourceRoleEditPart) {
            return ((SourceRoleEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof SinkRoleEditPart) {
            return ((SinkRoleEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof InfrastructureRequiredRoleEditPart) {
            return ((InfrastructureRequiredRoleEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof OperationProvidedRole2EditPart) {
            return ((OperationProvidedRole2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof OperationRequiredRole2EditPart) {
            return ((OperationRequiredRole2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
        IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
        if (targetEditPart instanceof OperationProvidedRoleEditPart) {
            return ((OperationProvidedRoleEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof OperationRequiredRoleEditPart) {
            return ((OperationRequiredRoleEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof SinkRoleEditPart) {
            return ((SinkRoleEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof InfrastructureProvidedRoleEditPart) {
            return ((InfrastructureProvidedRoleEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof OperationProvidedRole2EditPart) {
            return ((OperationProvidedRole2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof OperationRequiredRole2EditPart) {
            return ((OperationRequiredRole2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof EventChannelEditPart) {
            return ((EventChannelEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
        IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
        if (sourceEditPart instanceof OperationProvidedRoleEditPart) {
            return ((OperationProvidedRoleEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof OperationRequiredRoleEditPart) {
            return ((OperationRequiredRoleEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof SourceRoleEditPart) {
            return ((SourceRoleEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof SinkRoleEditPart) {
            return ((SinkRoleEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof InfrastructureRequiredRoleEditPart) {
            return ((InfrastructureRequiredRoleEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof OperationProvidedRole2EditPart) {
            return ((OperationProvidedRole2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof OperationRequiredRole2EditPart) {
            return ((OperationRequiredRole2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
        return selectExistingElement(target, getTypesForSource(target, relationshipType));
    }

    /**
     * @generated
     */
    public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
        return selectExistingElement(source, getTypesForTarget(source, relationshipType));
    }

    /**
     * @generated
     */
    protected EObject selectExistingElement(IAdaptable host, Collection types) {
        if (types.isEmpty()) {
            return null;
        }
        IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
        if (editPart == null) {
            return null;
        }
        Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
        Collection elements = new HashSet();
        for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
            EObject element = (EObject) it.next();
            if (isApplicableElement(element, types)) {
                elements.add(element);
            }
        }
        if (elements.isEmpty()) {
            return null;
        }
        return selectElement((EObject[]) elements.toArray(new EObject[elements.size()]));
    }

    /**
     * @generated
     */
    protected boolean isApplicableElement(EObject element, Collection types) {
        IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
        return types.contains(type);
    }

    /**
     * @generated
     */
    protected EObject selectElement(EObject[] elements) {
        Shell shell = Display.getCurrent().getActiveShell();
        ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
                PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance()
                        .getItemProvidersAdapterFactory());
        ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
        dialog.setMessage(Messages.PalladioComponentModelModelingAssistantProviderMessage);
        dialog.setTitle(Messages.PalladioComponentModelModelingAssistantProviderTitle);
        dialog.setMultipleSelection(false);
        dialog.setElements(elements);
        EObject selected = null;
        if (dialog.open() == Window.OK) {
            selected = (EObject) dialog.getFirstResult();
        }
        return selected;
    }
}
