/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.providers;

/**
 * @generated
 */
public class PalladioComponentModelEditPartProvider
		extends org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider {

	/**
 * @generated
 */
	private org.eclipse.gef.EditPartFactory factory;

	/**
 * @generated
 */
	private boolean allowCaching;

	/**
 * @generated
 */
	private java.lang.ref.WeakReference cachedPart;

	/**
 * @generated
 */
	private java.lang.ref.WeakReference cachedView;

	/**
 * @generated
 */
	public PalladioComponentModelEditPartProvider() {
		setFactory(new de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.PalladioComponentModelEditPartFactory());
		setAllowCaching(true);
	}

	/**
 * @generated
 */
	public final org.eclipse.gef.EditPartFactory getFactory() {
		return factory;
	}

	/**
 * @generated
 */
	protected void setFactory(org.eclipse.gef.EditPartFactory factory) {
		this.factory = factory;
	}

	/**
 * @generated
 */
	public final boolean isAllowCaching() {
		return allowCaching;
	}

	/**
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
 * @generated
 */
	protected org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart createEditPart(
			org.eclipse.gmf.runtime.notation.View view) {
		org.eclipse.gef.EditPart part = factory.createEditPart(null, view);
		if (part instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) {
			return (org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) part;
		}
		return null;
	}

	/**
 * @generated
 */
	protected org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart getCachedPart(
			org.eclipse.gmf.runtime.notation.View view) {
		if (cachedView != null && cachedView.get() == view) {
			return (org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart) cachedPart.get();
		}
		return null;
	}

	/**
 * @generated
 */
	public synchronized org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart createGraphicEditPart(
			org.eclipse.gmf.runtime.notation.View view) {
		if (isAllowCaching()) {
			org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart part = getCachedPart(view);
			cachedPart = null;
			cachedView = null;
			if (part != null) {
				return part;
			}
		}
		return createEditPart(view);
	}

	/**
 * @generated
 */
	public synchronized boolean provides(org.eclipse.gmf.runtime.common.core.service.IOperation operation) {
		if (operation instanceof org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation) {
			org.eclipse.gmf.runtime.notation.View view =
					((org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation) operation).getView();
			if (!de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.MODEL_ID.equals(
					de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getModelID(view))) {
				return false;
			}
			if (isAllowCaching() && getCachedPart(view) != null) {
				return true;
			}
			org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart part = createEditPart(view);
			if (part != null) {
				if (isAllowCaching()) {
					cachedPart = new java.lang.ref.WeakReference(part);
					cachedView = new java.lang.ref.WeakReference(view);
				}
				return true;
			}
		}
		return false;
	}
	}
