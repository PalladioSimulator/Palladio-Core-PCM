/**
 */
package de.uka.ipd.sdq.experimentautomation.variation;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.variation.VariationType#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.variation.VariationType#getStrategyClass <em>Strategy Class</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.variation.VariationType#getVariedEntityInterface <em>Varied Entity Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.experimentautomation.variation.VariationPackage#getVariationType()
 * @model abstract="true"
 * @generated
 */
public interface VariationType extends Identifier {
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
	 * @see de.uka.ipd.sdq.experimentautomation.variation.VariationPackage#getVariationType_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.variation.VariationType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Strategy Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strategy Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strategy Class</em>' attribute.
	 * @see #setStrategyClass(String)
	 * @see de.uka.ipd.sdq.experimentautomation.variation.VariationPackage#getVariationType_StrategyClass()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getStrategyClass();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.variation.VariationType#getStrategyClass <em>Strategy Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strategy Class</em>' attribute.
	 * @see #getStrategyClass()
	 * @generated
	 */
	void setStrategyClass(String value);

	/**
	 * Returns the value of the '<em><b>Varied Entity Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Varied Entity Interface</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Varied Entity Interface</em>' attribute.
	 * @see #setVariedEntityInterface(String)
	 * @see de.uka.ipd.sdq.experimentautomation.variation.VariationPackage#getVariationType_VariedEntityInterface()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getVariedEntityInterface();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.variation.VariationType#getVariedEntityInterface <em>Varied Entity Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Varied Entity Interface</em>' attribute.
	 * @see #getVariedEntityInterface()
	 * @generated
	 */
	void setVariedEntityInterface(String value);

} // VariationType
