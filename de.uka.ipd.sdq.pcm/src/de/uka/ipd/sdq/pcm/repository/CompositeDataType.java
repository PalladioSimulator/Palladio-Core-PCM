/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.parameter.Variable;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This&nbsp;entity&nbsp;represents&nbsp;a&nbsp;complex&nbsp;data&nbsp;type&nbsp;containing&nbsp;which is composed by
 * Variables.&nbsp;This&nbsp;construct&nbsp;is&nbsp;common&nbsp;in&nbsp;higher&nbsp;programming&nbsp;languages&nbsp;as&nbsp;record,&nbsp;struct,&nbsp;or&nbsp;class.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.CompositeDataType#getMembers_CompositeDataType <em>Members Composite Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeDataType()
 * @model
 * @generated
 */
public interface CompositeDataType extends DataType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Members Composite Data Type</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.Variable}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getCompositeDataType_Variable <em>Composite Data Type Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members Composite Data Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members Composite Data Type</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getCompositeDataType_Members_CompositeDataType()
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getCompositeDataType_Variable
	 * @model opposite="compositeDataType_Variable" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Variable> getMembers_CompositeDataType();

} // CompositeDataType
