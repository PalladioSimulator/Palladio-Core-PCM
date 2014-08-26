/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.EStereotypableObject;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Data Type</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc --> This entity represents a data type that can be stored in a repository
 * and used for specification and modeling of interface signatures. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.DataType#getRepository__DataType <em>Repository Data
 * Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getDataType()
 * @model abstract="true"
 * @extends EStereotypableObject
 * @generated
 */
public interface DataType extends EStereotypableObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Repository Data Type</b></em>' container reference. It is
     * bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.pcm.repository.Repository#getDataTypes__Repository
     * <em>Data Types Repository</em>}'. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
     * begin-model-doc --> This property specifies the repository to which this data type belongs.
     * <!-- end-model-doc -->
     *
     * @return the value of the '<em>Repository Data Type</em>' container reference.
     * @see #setRepository__DataType(Repository)
     * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getDataType_Repository__DataType()
     * @see de.uka.ipd.sdq.pcm.repository.Repository#getDataTypes__Repository
     * @model opposite="dataTypes__Repository" required="true" transient="false" ordered="false"
     * @generated
     */
    Repository getRepository__DataType();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.DataType#getRepository__DataType
     * <em>Repository Data Type</em>}' container reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Repository Data Type</em>' container reference.
     * @see #getRepository__DataType()
     * @generated
     */
    void setRepository__DataType(Repository value);

} // DataType
