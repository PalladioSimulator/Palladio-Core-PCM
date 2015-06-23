/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
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
                return "de.uka.ipd.sdq.pcm.gmf.resource"; //$NON-NLS-1$
            }
        };
        Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

            public Object getAdapter(Object adaptableObject, Class adapterType) {
                if (adaptableObject instanceof de.uka.ipd.sdq.pcm.gmf.resource.navigator.PalladioComponentModelAbstractNavigatorItem
                        && adapterType == ITabbedPropertySheetPageContributor.class) {
                    return propertySheetPageContributor;
                }
                return null;
            }

            public Class[] getAdapterList() {
                return supportedTypes;
            }
        }, de.uka.ipd.sdq.pcm.gmf.resource.navigator.PalladioComponentModelAbstractNavigatorItem.class);
    }

    /**
     * @generated
     */
    private Object myParent;

    /**
     * @generated
     */
    protected PalladioComponentModelAbstractNavigatorItem(Object parent) {
        myParent = parent;
    }

    /**
     * @generated
     */
    public Object getParent() {
        return myParent;
    }

}
