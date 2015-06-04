/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Composite Data Type</b></em> '. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> This entity represents a complex data type containing other data types.
 * This construct is common in higher programming languages as record, struct, or class. <!--
 * end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeDataType#getParentType_CompositeDataType <em>
 * Parent Type Composite Data Type</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeDataType#getInnerDeclaration_CompositeDataType
 * <em>Inner Declaration Composite Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeDataType()
 * @model
 * @generated
 */
public interface CompositeDataType extends Entity, DataType {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Parent Type Composite Data Type</b></em> ' reference list.
     * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.CompositeDataType}. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> This property represents
     * the parent type in the inheritance hierarchy. Null if there is no parent. <!-- end-model-doc
     * -->
     *
     * @return the value of the '<em>Parent Type Composite Data Type</em>' reference list.
     * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeDataType_ParentType_CompositeDataType()
     * @model ordered="false"
     * @generated
     */
    EList<CompositeDataType> getParentType_CompositeDataType();

    /**
     * Returns the value of the ' <em><b>Inner Declaration Composite Data Type</b></em>' containment
     * reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.pcm.repository.InnerDeclaration}. It is bidirectional and its opposite
     * is '
     * {@link de.uka.ipd.sdq.pcm.repository.InnerDeclaration#getCompositeDataType_InnerDeclaration
     * <em>Composite Data Type Inner Declaration</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
     * --> <!-- begin-model-doc --> This property represents the internals, i.e., named items, each
     * of a data type, forming this composite data type. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Inner Declaration Composite Data Type</em>' containment
     *         reference list.
     * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeDataType_InnerDeclaration_CompositeDataType()
     * @see de.uka.ipd.sdq.pcm.repository.InnerDeclaration#getCompositeDataType_InnerDeclaration
     * @model opposite="compositeDataType_InnerDeclaration" containment="true" ordered="false"
     * @generated
     */
    EList<InnerDeclaration> getInnerDeclaration_CompositeDataType();

} // CompositeDataType
