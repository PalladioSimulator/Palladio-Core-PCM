
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Parameter Characterisation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getCollectionParameterCharacterisation()
 * @model
 * @generated
 */
public interface CollectionParameterCharacterisation extends RandomVariable {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType
	 * @see #setType(CollectionParameterCharacterisationType)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getCollectionParameterCharacterisation_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CollectionParameterCharacterisationType getType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType
	 * @see #getType()
	 * @generated
	 */
	void setType(CollectionParameterCharacterisationType value);

} // CollectionParameterCharacterisation