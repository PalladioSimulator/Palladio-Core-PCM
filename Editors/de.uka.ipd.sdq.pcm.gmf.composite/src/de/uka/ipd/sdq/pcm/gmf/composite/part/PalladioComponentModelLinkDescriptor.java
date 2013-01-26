/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.part;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * The Class PalladioComponentModelLinkDescriptor.
 * 
 * @generated
 */
public class PalladioComponentModelLinkDescriptor extends PalladioComponentModelNodeDescriptor {

    /** The my source. @generated */
    private EObject mySource;

    /** The my destination. @generated */
    private EObject myDestination;

    /** The my semantic adapter. @generated */
    private IAdaptable mySemanticAdapter;

    /**
     * Instantiates a new palladio component model link descriptor.
     * 
     * @param source
     *            the source
     * @param destination
     *            the destination
     * @param linkElement
     *            the link element
     * @param linkVID
     *            the link vid
     * @generated
     */
    private PalladioComponentModelLinkDescriptor(EObject source, EObject destination, EObject linkElement, int linkVID) {
        super(linkElement, linkVID);
        mySource = source;
        myDestination = destination;
    }

    /**
     * Instantiates a new palladio component model link descriptor.
     * 
     * @param source
     *            the source
     * @param destination
     *            the destination
     * @param elementType
     *            the element type
     * @param linkVID
     *            the link vid
     * @generated
     */
    public PalladioComponentModelLinkDescriptor(EObject source, EObject destination, IElementType elementType,
            int linkVID) {
        this(source, destination, (EObject) null, linkVID);
        final IElementType elementTypeCopy = elementType;
        mySemanticAdapter = new IAdaptable() {
            public Object getAdapter(Class adapter) {
                if (IElementType.class.equals(adapter)) {
                    return elementTypeCopy;
                }
                return null;
            }
        };
    }

    /**
     * Instantiates a new palladio component model link descriptor.
     * 
     * @param source
     *            the source
     * @param destination
     *            the destination
     * @param linkElement
     *            the link element
     * @param elementType
     *            the element type
     * @param linkVID
     *            the link vid
     * @generated
     */
    public PalladioComponentModelLinkDescriptor(EObject source, EObject destination, EObject linkElement,
            IElementType elementType, int linkVID) {
        this(source, destination, linkElement, linkVID);
        final IElementType elementTypeCopy = elementType;
        mySemanticAdapter = new EObjectAdapter(linkElement) {
            public Object getAdapter(Class adapter) {
                if (IElementType.class.equals(adapter)) {
                    return elementTypeCopy;
                }
                return super.getAdapter(adapter);
            }
        };
    }

    /**
     * Gets the source.
     * 
     * @return the source
     * @generated
     */
    public EObject getSource() {
        return mySource;
    }

    /**
     * Gets the destination.
     * 
     * @return the destination
     * @generated
     */
    public EObject getDestination() {
        return myDestination;
    }

    /**
     * Gets the semantic adapter.
     * 
     * @return the semantic adapter
     * @generated
     */
    public IAdaptable getSemanticAdapter() {
        return mySemanticAdapter;
    }

}
