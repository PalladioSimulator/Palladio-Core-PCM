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
public final class PcmEditorPlugin extends EMFPlugin {
    /**
     * @generated
     */
    public static final PcmEditorPlugin INSTANCE = new PcmEditorPlugin();

    /**
     * @generated
     */
    private static Implementation plugin;

    /**
     * @generated
     */
    public PcmEditorPlugin() {
        super(new ResourceLocator[] { IdentifierEditPlugin.INSTANCE, ProbabilityFunctionEditPlugin.INSTANCE,
                StoexEditPlugin.INSTANCE, });
    }

    /**
     * @generated
     */
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
