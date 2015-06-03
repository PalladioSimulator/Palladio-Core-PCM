/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Component</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc --> Abstract superclass of all component types which can be part of a
 * component repository <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.RepositoryComponent#getRepository__RepositoryComponent
 * <em>Repository Repository Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepositoryComponent()
 * @model abstract="true"
 * @generated
 */
public interface RepositoryComponent extends InterfaceProvidingRequiringEntity {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Repository Repository Component</b></em> ' container
     * reference. It is bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.repository.Repository#getComponents__Repository
     * <em>Components Repository</em>}'. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
     * begin-model-doc --> This property represents the repository where this entity is stored. <!--
     * end-model-doc -->
     *
     * @return the value of the '<em>Repository Repository Component</em>' container reference.
     * @see #setRepository__RepositoryComponent(Repository)
     * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getRepositoryComponent_Repository__RepositoryComponent()
     * @see de.uka.ipd.sdq.pcm.repository.Repository#getComponents__Repository
     * @model opposite="components__Repository" required="true" transient="false" ordered="false"
     * @generated
     */
    Repository getRepository__RepositoryComponent();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.repository.RepositoryComponent#getRepository__RepositoryComponent
     * <em>Repository Repository Component</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Repository Repository Component</em>' container
     *            reference.
     * @see #getRepository__RepositoryComponent()
     * @generated
     */
    void setRepository__RepositoryComponent(Repository value);

} // RepositoryComponent
