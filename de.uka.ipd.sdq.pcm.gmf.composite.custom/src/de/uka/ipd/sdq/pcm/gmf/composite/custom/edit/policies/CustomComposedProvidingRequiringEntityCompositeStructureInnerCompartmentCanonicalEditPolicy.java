/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy;

/**
 * The Class
 * CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy.
 */
public class CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy extends
        ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy {

    // Reverted to generated code, since original code works, as it calls modified
    // PalladioComponentModelDiagramUpdater.
    // /**
    // * Gets the semantic children list.
    // *
    // * Since GMF3, this modification has to be applied to PalladioComponentModelDiagramUpdater,
    // * instead of
    // ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy.
    // *
    // * @return the semantic children list
    // * @generated not
    // */
    // protected List getSemanticChildrenList() {
    // View viewObject = (View) getHost().getModel();
    // EObject modelObject = viewObject.getElement();
    // List result = new LinkedList();
    //
    // if (modelObject != null && modelObject instanceof ComposedStructure) {
    // for (AssemblyContext assemblyContext : ((ComposedStructure) modelObject)
    // .getAssemblyContexts__ComposedStructure()) {
    //
    // int assemblyNodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject,
    // assemblyContext);
    // if (AssemblyContextEditPart.VISUAL_ID == assemblyNodeVID) {
    // result.add(assemblyContext);
    // }
    // }
    // for (EventChannel eventChannel : ((ComposedStructure)
    // modelObject).getEventChannel__ComposedStructure()) {
    //
    // int channelNodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject,
    // eventChannel);
    // if (EventChannelEditPart.VISUAL_ID == channelNodeVID) {
    // result.add(eventChannel);
    // }
    // }
    // }
    // return result;
    // }

}
