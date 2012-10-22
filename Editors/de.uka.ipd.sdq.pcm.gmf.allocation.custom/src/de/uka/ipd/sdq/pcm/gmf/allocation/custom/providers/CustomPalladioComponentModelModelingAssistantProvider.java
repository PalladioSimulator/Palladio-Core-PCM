package de.uka.ipd.sdq.pcm.gmf.allocation.custom.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelModelingAssistantProvider;

/**
 * A custom Palladio component model modeling assistant provider.
 */
public class CustomPalladioComponentModelModelingAssistantProvider extends
        PalladioComponentModelModelingAssistantProvider {

    @Override
    public List<IElementType> getTypesForPopupBar(IAdaptable host) {
        List<IElementType> types = new ArrayList<IElementType>();
        IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);

        if (editPart instanceof ResourceContainerAllocationCompartmentEditPart) {
            types.add(PalladioComponentModelElementTypes.AllocationContext_3002);
            return types;
        }
        return Collections.emptyList();
    }
}
