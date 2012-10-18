/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.providers;

import java.lang.ref.WeakReference;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.ComposedProvidingRequiringEntityEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.PalladioComponentModelEditPartFactory;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class PalladioComponentModelEditPartProvider.
 *
 * @generated
 */
public class PalladioComponentModelEditPartProvider extends
		AbstractEditPartProvider {

	/** The factory. @generated */
	private EditPartFactory factory;

	/** The allow caching. @generated */
	private boolean allowCaching;

	/** The cached part. @generated */
	private WeakReference cachedPart;

	/** The cached view. @generated */
	private WeakReference cachedView;

	/**
	 * Instantiates a new palladio component model edit part provider.
	 *
	 * @generated
	 */
	public PalladioComponentModelEditPartProvider() {
		setFactory(new PalladioComponentModelEditPartFactory());
		setAllowCaching(true);
	}

	/**
	 * Gets the factory.
	 *
	 * @return the factory
	 * @generated
	 */
	public final EditPartFactory getFactory() {
		return factory;
	}

	/**
	 * Sets the factory.
	 *
	 * @param factory the new factory
	 * @generated
	 */
	protected void setFactory(EditPartFactory factory) {
		this.factory = factory;
	}

	/**
	 * Checks if is allow caching.
	 *
	 * @return true, if is allow caching
	 * @generated
	 */
	public final boolean isAllowCaching() {
		return allowCaching;
	}

	/**
	 * Sets the allow caching.
	 *
	 * @param allowCaching the new allow caching
	 * @generated
	 */
	protected synchronized void setAllowCaching(boolean allowCaching) {
		this.allowCaching = allowCaching;
		if (!allowCaching) {
			cachedPart = null;
			cachedView = null;
		}
	}

	/**
	 * Creates the edit part.
	 *
	 * @param view the view
	 * @return the i graphical edit part
	 * @generated
	 */
	protected IGraphicalEditPart createEditPart(View view) {
		EditPart part = factory.createEditPart(null, view);
		if (part instanceof IGraphicalEditPart) {
			return (IGraphicalEditPart) part;
		}
		return null;
	}

	/**
	 * Gets the cached part.
	 *
	 * @param view the view
	 * @return the cached part
	 * @generated
	 */
	protected IGraphicalEditPart getCachedPart(View view) {
		if (cachedView != null && cachedView.get() == view) {
			return (IGraphicalEditPart) cachedPart.get();
		}
		return null;
	}

	/**
	 * Creates the graphic edit part.
	 *
	 * @param view the view
	 * @return the i graphical edit part
	 * @generated
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
	 * Provides.
	 *
	 * @param operation the operation
	 * @return true, if successful
	 * @generated
	 */
	public synchronized boolean provides(IOperation operation) {
		if (operation instanceof CreateGraphicEditPartOperation) {
			View view = ((IEditPartOperation) operation).getView();
			if (!ComposedProvidingRequiringEntityEditPart.MODEL_ID
					.equals(PalladioComponentModelVisualIDRegistry
							.getModelID(view))) {
				return false;
			}
			if (isAllowCaching() && getCachedPart(view) != null) {
				return true;
			}
			IGraphicalEditPart part = createEditPart(view);
			if (part != null) {
				if (isAllowCaching()) {
					cachedPart = new WeakReference(part);
					cachedView = new WeakReference(view);
				}
				return true;
			}
		}
		return false;
	}
}