/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * The Class PalladioComponentModelAbstractNavigatorItem.
 *
 * @generated
 */
public abstract class PalladioComponentModelAbstractNavigatorItem extends PlatformObject {

    /**
     * @generated
     */
    static {
        final Class[] supportedTypes = new Class[] { ITabbedPropertySheetPageContributor.class };
        final ITabbedPropertySheetPageContributor propertySheetPageContributor = new ITabbedPropertySheetPageContributor() {
            public String getContributorId() {
                return "de.uka.ipd.sdq.pcm.gmf.usage"; //$NON-NLS-1$
            }
        };
        Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

            public Object getAdapter(Object adaptableObject, Class adapterType) {
                if (adaptableObject instanceof de.uka.ipd.sdq.pcm.gmf.usage.navigator.PalladioComponentModelAbstractNavigatorItem
                        && adapterType == ITabbedPropertySheetPageContributor.class) {
                    return propertySheetPageContributor;
                }
                return null;
            }

            public Class[] getAdapterList() {
                return supportedTypes;
            }
        }, de.uka.ipd.sdq.pcm.gmf.usage.navigator.PalladioComponentModelAbstractNavigatorItem.class);
    }

    /** The my parent. @generated */
    private Object myParent;

    /**
     * Instantiates a new palladio component model abstract navigator item.
     *
     * @param parent the parent
     * @generated
     */
    protected PalladioComponentModelAbstractNavigatorItem(Object parent) {
        myParent = parent;
    }

    /**
     * Gets the parent.
     *
     * @return the parent
     * @generated
     */
    public Object getParent() {
        return myParent;
    }

}
