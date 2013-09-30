/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.providers;

/**
 * @generated
 */
public class PalladioComponentModelIconProvider extends org.eclipse.gmf.runtime.common.core.service.AbstractProvider
		implements org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider {

	/**
 * @generated
 */
	public org.eclipse.swt.graphics.Image getIcon(org.eclipse.core.runtime.IAdaptable hint, int flags) {
		return de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.getImage(hint);
	}

	/**
 * @generated
 */
	public boolean provides(org.eclipse.gmf.runtime.common.core.service.IOperation operation) {
		if (operation instanceof org.eclipse.gmf.runtime.common.ui.services.icon.GetIconOperation) {
			return ((org.eclipse.gmf.runtime.common.ui.services.icon.GetIconOperation) operation).execute(this) != null;
		}
		return false;
	}
	}
