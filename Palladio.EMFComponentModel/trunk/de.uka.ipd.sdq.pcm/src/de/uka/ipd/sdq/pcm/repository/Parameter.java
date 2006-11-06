
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Parameter#getDatatype__Parameter <em>Datatype Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Parameter#getParameterName <em>Parameter Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Parameter#getModifier__Parameter <em>Modifier Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Datatype Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatype Parameter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datatype Parameter</em>' containment reference.
	 * @see #setDatatype__Parameter(DataType)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getParameter_Datatype__Parameter()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	DataType getDatatype__Parameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.Parameter#getDatatype__Parameter <em>Datatype Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datatype Parameter</em>' containment reference.
	 * @see #getDatatype__Parameter()
	 * @generated
	 */
	void setDatatype__Parameter(DataType value);

	/**
	 * Returns the value of the '<em><b>Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Name</em>' attribute.
	 * @see #setParameterName(String)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getParameter_ParameterName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getParameterName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.Parameter#getParameterName <em>Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Name</em>' attribute.
	 * @see #getParameterName()
	 * @generated
	 */
	void setParameterName(String value);

	/**
	 * Returns the value of the '<em><b>Modifier Parameter</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.repository.ParameterModifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier Parameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier Parameter</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.repository.ParameterModifier
	 * @see #setModifier__Parameter(ParameterModifier)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getParameter_Modifier__Parameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ParameterModifier getModifier__Parameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.Parameter#getModifier__Parameter <em>Modifier Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modifier Parameter</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.repository.ParameterModifier
	 * @see #getModifier__Parameter()
	 * @generated
	 */
	void setModifier__Parameter(ParameterModifier value);

} // Parameter