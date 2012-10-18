/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.GetIconOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider;
import org.eclipse.swt.graphics.Image;

/**
 * The Class PalladioComponentModelIconProvider.
 *
 * @generated
 */
public class PalladioComponentModelIconProvider extends AbstractProvider implements IIconProvider {

    /**
     * Gets the icon.
     *
     * @param hint the hint
     * @param flags the flags
     * @return the icon
     * @generated
     */
    public Image getIcon(IAdaptable hint, int flags) {
        return PalladioComponentModelElementTypes.getImage(hint);
    }

    /**
     * Provides.
     *
     * @param operation the operation
     * @return true, if successful
     * @generated
     */
    public boolean provides(IOperation operation) {
        if (operation instanceof GetIconOperation) {
            return ((GetIconOperation) operation).execute(this) != null;
        }
        return false;
    }
}
