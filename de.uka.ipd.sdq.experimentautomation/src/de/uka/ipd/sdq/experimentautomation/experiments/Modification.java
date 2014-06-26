/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments;

import de.uka.ipd.sdq.experimentautomation.variation.VariationType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification#getType <em>Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification#getVariedObjectId <em>Varied Object Id</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getModification()
 * @model
 * @generated
 */
public interface Modification extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(VariationType)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getModification_Type()
	 * @model
	 * @generated
	 */
	VariationType getType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(VariationType value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getModification_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Varied Object Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Varied Object Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Varied Object Id</em>' attribute.
	 * @see #setVariedObjectId(String)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getModification_VariedObjectId()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getVariedObjectId();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification#getVariedObjectId <em>Varied Object Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Varied Object Id</em>' attribute.
	 * @see #getVariedObjectId()
	 * @generated
	 */
	void setVariedObjectId(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(long)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getModification_Value()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.Modification#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(long value);

} // Modification
