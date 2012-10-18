/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

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

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.BranchUsageBranchTransitionsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.EntryLevelSystemCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.LoopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StartEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.StopEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.UsageScenarioUsageScenarioCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.usage.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelUsageDiagramEditorPlugin;

/**
 * The Class PalladioComponentModelModelingAssistantProvider.
 *
 * @generated
 */
public class PalladioComponentModelModelingAssistantProvider extends ModelingAssistantProvider {

    /**
     * Gets the types for popup bar.
     *
     * @param host the host
     * @return the types for popup bar
     * @generated
     */
    public List getTypesForPopupBar(IAdaptable host) {
        IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
        if (editPart instanceof EntryLevelSystemCallEditPart) {
            ArrayList types = new ArrayList(1);
            types.add(PalladioComponentModelElementTypes.VariableUsage_3012);
            return types;
        }
        if (editPart instanceof VariableUsageEditPart) {
            ArrayList types = new ArrayList(1);
            types.add(PalladioComponentModelElementTypes.VariableCharacterisation_3013);
            return types;
        }
        if (editPart instanceof LoopEditPart) {
            ArrayList types = new ArrayList(1);
            types.add(PalladioComponentModelElementTypes.ScenarioBehaviour_3007);
            return types;
        }
        if (editPart instanceof BranchTransitionEditPart) {
            ArrayList types = new ArrayList(1);
            types.add(PalladioComponentModelElementTypes.ScenarioBehaviour_3010);
            return types;
        }
        if (editPart instanceof UsageScenarioUsageScenarioCompartmentEditPart) {
            ArrayList types = new ArrayList(3);
            types.add(PalladioComponentModelElementTypes.ScenarioBehaviour_3014);
            types.add(PalladioComponentModelElementTypes.ClosedWorkload_3015);
            types.add(PalladioComponentModelElementTypes.OpenWorkload_3016);
            return types;
        }
        if (editPart instanceof ScenarioBehaviourScenarioBehaviourStepsCompartmentEditPart) {
            ArrayList types = new ArrayList(6);
            types.add(PalladioComponentModelElementTypes.Start_3001);
            types.add(PalladioComponentModelElementTypes.Stop_3002);
            types.add(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
            types.add(PalladioComponentModelElementTypes.Loop_3005);
            types.add(PalladioComponentModelElementTypes.Branch_3008);
            types.add(PalladioComponentModelElementTypes.Delay_3017);
            return types;
        }
        if (editPart instanceof ScenarioBehaviourScenarioBehaviourStepsCompartment2EditPart) {
            ArrayList types = new ArrayList(6);
            types.add(PalladioComponentModelElementTypes.Start_3001);
            types.add(PalladioComponentModelElementTypes.Stop_3002);
            types.add(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
            types.add(PalladioComponentModelElementTypes.Loop_3005);
            types.add(PalladioComponentModelElementTypes.Branch_3008);
            types.add(PalladioComponentModelElementTypes.Delay_3017);
            return types;
        }
        if (editPart instanceof BranchUsageBranchTransitionsCompartmentEditPart) {
            ArrayList types = new ArrayList(1);
            types.add(PalladioComponentModelElementTypes.BranchTransition_3009);
            return types;
        }
        if (editPart instanceof ScenarioBehaviourScenarioBehaviourStepsCompartment3EditPart) {
            ArrayList types = new ArrayList(6);
            types.add(PalladioComponentModelElementTypes.Start_3001);
            types.add(PalladioComponentModelElementTypes.Stop_3002);
            types.add(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
            types.add(PalladioComponentModelElementTypes.Loop_3005);
            types.add(PalladioComponentModelElementTypes.Branch_3008);
            types.add(PalladioComponentModelElementTypes.Delay_3017);
            return types;
        }
        if (editPart instanceof UsageScenarioEditPart) {
            ArrayList types = new ArrayList(1);
            types.add(PalladioComponentModelElementTypes.UsageScenario_2004);
            return types;
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the rel types on source.
     *
     * @param source the source
     * @return the rel types on source
     * @generated
     */
    public List getRelTypesOnSource(IAdaptable source) {
        IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
        if (sourceEditPart instanceof StartEditPart) {
            return ((StartEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof StopEditPart) {
            return ((StopEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof EntryLevelSystemCallEditPart) {
            return ((EntryLevelSystemCallEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof LoopEditPart) {
            return ((LoopEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof BranchEditPart) {
            return ((BranchEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof DelayEditPart) {
            return ((DelayEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the rel types on target.
     *
     * @param target the target
     * @return the rel types on target
     * @generated
     */
    public List getRelTypesOnTarget(IAdaptable target) {
        IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
        if (targetEditPart instanceof StartEditPart) {
            return ((StartEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof StopEditPart) {
            return ((StopEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof EntryLevelSystemCallEditPart) {
            return ((EntryLevelSystemCallEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof LoopEditPart) {
            return ((LoopEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof BranchEditPart) {
            return ((BranchEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof DelayEditPart) {
            return ((DelayEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the rel types on source and target.
     *
     * @param source the source
     * @param target the target
     * @return the rel types on source and target
     * @generated
     */
    public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
        IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
        IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
        if (sourceEditPart instanceof StartEditPart) {
            return ((StartEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof StopEditPart) {
            return ((StopEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof EntryLevelSystemCallEditPart) {
            return ((EntryLevelSystemCallEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof LoopEditPart) {
            return ((LoopEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof BranchEditPart) {
            return ((BranchEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof DelayEditPart) {
            return ((DelayEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the types for source.
     *
     * @param target the target
     * @param relationshipType the relationship type
     * @return the types for source
     * @generated
     */
    public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
        IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
        if (targetEditPart instanceof StartEditPart) {
            return ((StartEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof StopEditPart) {
            return ((StopEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof EntryLevelSystemCallEditPart) {
            return ((EntryLevelSystemCallEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof LoopEditPart) {
            return ((LoopEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof BranchEditPart) {
            return ((BranchEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof DelayEditPart) {
            return ((DelayEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the types for target.
     *
     * @param source the source
     * @param relationshipType the relationship type
     * @return the types for target
     * @generated
     */
    public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
        IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
        if (sourceEditPart instanceof StartEditPart) {
            return ((StartEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof StopEditPart) {
            return ((StopEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof EntryLevelSystemCallEditPart) {
            return ((EntryLevelSystemCallEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof LoopEditPart) {
            return ((LoopEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof BranchEditPart) {
            return ((BranchEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof DelayEditPart) {
            return ((DelayEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Select existing element for source.
     *
     * @param target the target
     * @param relationshipType the relationship type
     * @return the e object
     * @generated
     */
    public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
        return selectExistingElement(target, getTypesForSource(target, relationshipType));
    }

    /**
     * Select existing element for target.
     *
     * @param source the source
     * @param relationshipType the relationship type
     * @return the e object
     * @generated
     */
    public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
        return selectExistingElement(source, getTypesForTarget(source, relationshipType));
    }

    /**
     * Select existing element.
     *
     * @param host the host
     * @param types the types
     * @return the e object
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
     * Checks if is applicable element.
     *
     * @param element the element
     * @param types the types
     * @return true, if is applicable element
     * @generated
     */
    protected boolean isApplicableElement(EObject element, Collection types) {
        IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
        return types.contains(type);
    }

    /**
     * Select element.
     *
     * @param elements the elements
     * @return the e object
     * @generated
     */
    protected EObject selectElement(EObject[] elements) {
        Shell shell = Display.getCurrent().getActiveShell();
        ILabelProvider labelProvider = new AdapterFactoryLabelProvider(PalladioComponentModelUsageDiagramEditorPlugin
                .getInstance().getItemProvidersAdapterFactory());
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
