/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.EventChannel;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.AssemblyContextEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.EventChannelEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class
 * CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy.
 */
public class CustomComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy extends
        ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy {

    /**
     * Gets the semantic children list.
     * 
     * @return the semantic children list
     * @generated not
     */
    protected List getSemanticChildrenList() {
        View viewObject = (View) getHost().getModel();
        EObject modelObject = viewObject.getElement();
        List result = new LinkedList();

        if (modelObject != null && modelObject instanceof ComposedStructure) {
            for (AssemblyContext assemblyContext : ((ComposedStructure) modelObject)
                    .getAssemblyContexts__ComposedStructure()) {

                int assemblyNodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject,
                        assemblyContext);
                if (AssemblyContextEditPart.VISUAL_ID == assemblyNodeVID) {
                    result.add(assemblyContext);
                }
            }
            for (EventChannel eventChannel : ((ComposedStructure) modelObject).getEventChannel__ComposedStructure()) {

                int channelNodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject, eventChannel);
                if (EventChannelEditPart.VISUAL_ID == channelNodeVID) {
                    result.add(eventChannel);
                }
            }
        }
        return result;
    }
}
