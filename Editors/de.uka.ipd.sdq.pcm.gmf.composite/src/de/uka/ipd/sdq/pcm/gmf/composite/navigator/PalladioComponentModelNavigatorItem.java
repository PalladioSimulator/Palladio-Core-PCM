/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.navigator;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

/**
 * The Class PalladioComponentModelNavigatorItem.
 * 
 * @generated
 */
public class PalladioComponentModelNavigatorItem extends PalladioComponentModelAbstractNavigatorItem {

    /**
     * @generated
     */
    static {
        final Class[] supportedTypes = new Class[] { View.class, EObject.class };
        Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

            public Object getAdapter(Object adaptableObject, Class adapterType) {
                if (adaptableObject instanceof de.uka.ipd.sdq.pcm.gmf.composite.navigator.PalladioComponentModelNavigatorItem
                        && (adapterType == View.class || adapterType == EObject.class)) {
                    return ((de.uka.ipd.sdq.pcm.gmf.composite.navigator.PalladioComponentModelNavigatorItem) adaptableObject)
                            .getView();
                }
                return null;
            }

            public Class[] getAdapterList() {
                return supportedTypes;
            }
        }, de.uka.ipd.sdq.pcm.gmf.composite.navigator.PalladioComponentModelNavigatorItem.class);
    }

    /** The my view. @generated */
    private View myView;

    /** The my leaf. @generated */
    private boolean myLeaf = false;

    /**
     * Instantiates a new palladio component model navigator item.
     * 
     * @param view
     *            the view
     * @param parent
     *            the parent
     * @param isLeaf
     *            the is leaf
     * @generated
     */
    public PalladioComponentModelNavigatorItem(View view, Object parent, boolean isLeaf) {
        super(parent);
        myView = view;
        myLeaf = isLeaf;
    }

    /**
     * Gets the view.
     * 
     * @return the view
     * @generated
     */
    public View getView() {
        return myView;
    }

    /**
     * Checks if is leaf.
     * 
     * @return true, if is leaf
     * @generated
     */
    public boolean isLeaf() {
        return myLeaf;
    }

    /**
     * Equals.
     * 
     * @param obj
     *            the obj
     * @return true, if successful
     * @generated
     */
    public boolean equals(Object obj) {
        if (obj instanceof de.uka.ipd.sdq.pcm.gmf.composite.navigator.PalladioComponentModelNavigatorItem) {
            return EcoreUtil
                    .getURI(getView())
                    .equals(EcoreUtil
                            .getURI(((de.uka.ipd.sdq.pcm.gmf.composite.navigator.PalladioComponentModelNavigatorItem) obj)
                                    .getView()));
        }
        return super.equals(obj);
    }

    /**
     * Hash code.
     * 
     * @return the int
     * @generated
     */
    public int hashCode() {
        return EcoreUtil.getURI(getView()).hashCode();
    }

}
