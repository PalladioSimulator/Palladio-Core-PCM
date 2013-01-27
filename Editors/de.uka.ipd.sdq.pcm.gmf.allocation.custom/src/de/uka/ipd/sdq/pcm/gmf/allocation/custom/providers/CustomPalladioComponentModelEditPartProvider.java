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

/**
 * A custom Palladio component model EditPart provider.
 */
public class CustomPalladioComponentModelEditPartProvider extends AbstractEditPartProvider {

    /**
     * An EditPart factory.
     */
    private EditPartFactory factory;

    /**
     * signals if caching is allowed.
     */
    private boolean allowCaching;

    /**
     * A reference to an IGraphicalEditPart.
     */
    private WeakReference<IGraphicalEditPart> cachedPart;

    /**
     * A reference to a View.
     */
    private WeakReference<View> cachedView;

    /**
     * The constructor.
     */
    public CustomPalladioComponentModelEditPartProvider() {
        // use our custom factory instead of the generated one
        setFactory(new CustomPalladioComponentModelEditPartFactory());
        setAllowCaching(true);
    }

    /**
     * gets the EditPart factory.
     * 
     * @return the EditPart factory
     */
    public final EditPartFactory getFactory() {
        return factory;
    }

    /**
     * Sets the EditPart factory.
     * 
     * @param factory
     *            the factory
     */
    protected void setFactory(EditPartFactory factory) {
        this.factory = factory;
    }

    /**
     * Returns if caching is allowed.
     * 
     * @return a boolean value
     */
    public final boolean isAllowCaching() {
        return allowCaching;
    }

    /**
     * Sets if caching is allowed.
     * 
     * @param allowCaching
     *            a boolean value.
     */
    protected synchronized void setAllowCaching(boolean allowCaching) {
        this.allowCaching = allowCaching;
        if (!allowCaching) {
            cachedPart = null;
            cachedView = null;
        }
    }

    /**
     * Creates an EditPart.
     * 
     * @param view
     *            a View
     * @return the created EditPart
     */
    protected IGraphicalEditPart createEditPart(View view) {
        EditPart part = factory.createEditPart(null, view);
        if (part instanceof IGraphicalEditPart) {
            return (IGraphicalEditPart) part;
        }
        return null;
    }

    /**
     * Gets the cached EditPart.
     * 
     * @param view
     *            a View
     * @return the EditPart
     */
    protected IGraphicalEditPart getCachedPart(View view) {
        if (cachedView != null && cachedView.get() == view) {
            return cachedPart.get();
        }
        return null;
    }

    /**
     * Creates a graphic EditPart.
     * 
     * @param view
     *            a View
     * @return a EditPart
     */
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

    /**
     * Returns a boolean value.
     * 
     * @param operation
     *            an IOperation
     * @return a boolean value
     */
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
