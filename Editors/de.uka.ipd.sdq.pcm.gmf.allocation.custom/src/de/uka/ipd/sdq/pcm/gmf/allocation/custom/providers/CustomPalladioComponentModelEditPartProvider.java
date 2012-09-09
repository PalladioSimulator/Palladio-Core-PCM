/*
 * Copyright 2007, SDQ, IPD, UKA
 */

package de.uka.ipd.sdq.pcm.gmf.allocation.custom.providers;

import java.lang.ref.WeakReference;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.allocation.custom.edit.parts.CustomPalladioComponentModelEditPartFactory;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry;

public class CustomPalladioComponentModelEditPartProvider extends AbstractEditPartProvider {

    private EditPartFactory factory;

    private boolean allowCaching;

    private WeakReference<IGraphicalEditPart> cachedPart;

    private WeakReference<View> cachedView;

    public CustomPalladioComponentModelEditPartProvider() {
        // use our custom factory instead of the generated one
        setFactory(new CustomPalladioComponentModelEditPartFactory());
        setAllowCaching(true);
    }

    public final EditPartFactory getFactory() {
        return factory;
    }

    protected void setFactory(EditPartFactory factory) {
        this.factory = factory;
    }

    public final boolean isAllowCaching() {
        return allowCaching;
    }

    protected synchronized void setAllowCaching(boolean allowCaching) {
        this.allowCaching = allowCaching;
        if (!allowCaching) {
            cachedPart = null;
            cachedView = null;
        }
    }

    protected IGraphicalEditPart createEditPart(View view) {
        EditPart part = factory.createEditPart(null, view);
        if (part instanceof IGraphicalEditPart) {
            return (IGraphicalEditPart) part;
        }
        return null;
    }

    protected IGraphicalEditPart getCachedPart(View view) {
        if (cachedView != null && cachedView.get() == view) {
            return cachedPart.get();
        }
        return null;
    }

    public synchronized IGraphicalEditPart createGraphicEditPart(View view) {
        if (isAllowCaching()) {
            IGraphicalEditPart part = getCachedPart(view);
            cachedPart = null;
            cachedView = null;
            if (part != null) {
                return part;
            }
        }
        return createEditPart(view);
    }

    public synchronized boolean provides(IOperation operation) {
        if (operation instanceof CreateGraphicEditPartOperation) {
            View view = ((IEditPartOperation) operation).getView();
            if (!AllocationEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry.getModelID(view))) {
                return false;
            }
            if (isAllowCaching() && getCachedPart(view) != null) {
                return true;
            }
            IGraphicalEditPart part = createEditPart(view);
            if (part != null) {
                if (isAllowCaching()) {
                    cachedPart = new WeakReference<IGraphicalEditPart>(part);
                    cachedView = new WeakReference<View>(view);
                }
                return true;
            }
        }
        return false;
    }
}
