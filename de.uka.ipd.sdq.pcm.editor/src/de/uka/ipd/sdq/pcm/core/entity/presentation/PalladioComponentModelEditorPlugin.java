/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity.presentation;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

import de.uka.ipd.sdq.identifier.provider.IdentifierEditPlugin;
import de.uka.ipd.sdq.probfunction.provider.ProbabilityFunctionEditPlugin;
import de.uka.ipd.sdq.stoex.provider.StoexEditPlugin;

/**
 * @generated
 */
public final class PalladioComponentModelEditorPlugin extends EMFPlugin {
    /**
     * @generated
     */
    public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * @generated
     */
    public static final PalladioComponentModelEditorPlugin INSTANCE = new PalladioComponentModelEditorPlugin();

    /**
     * @generated
     */
    private static Implementation plugin;

    /**
     * @generated
     */
    public PalladioComponentModelEditorPlugin() {
        super(new ResourceLocator[] { IdentifierEditPlugin.INSTANCE, ProbabilityFunctionEditPlugin.INSTANCE,
                StoexEditPlugin.INSTANCE, });
    }

    /**
     * @generated
     */
    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    /**
     * @generated
     */
    public static Implementation getPlugin() {
        return plugin;
    }

    /**
     * @generated
     */
    public static class Implementation extends EclipseUIPlugin {
        /**
         * @generated
         */
        public Implementation() {
            super();

            // Remember the static instance.
            //
            plugin = this;
        }
    }

}
