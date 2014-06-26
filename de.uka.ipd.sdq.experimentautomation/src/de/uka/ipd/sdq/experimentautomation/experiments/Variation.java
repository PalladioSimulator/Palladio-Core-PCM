/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments;

import de.uka.ipd.sdq.experimentautomation.variation.VariationType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getType <em>Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getValueProvider <em>Value Provider</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getMinValue <em>Min Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getMaxValue <em>Max Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getMaxVariations <em>Max Variations</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getVariedObjectId <em>Varied Object Id</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getVariation()
 * @model
 * @generated
 */
public interface Variation extends EObject {
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
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getVariation_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	VariationType getType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(VariationType value);

	/**
	 * Returns the value of the '<em><b>Value Provider</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Provider</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Provider</em>' containment reference.
	 * @see #setValueProvider(ValueProvider)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getVariation_ValueProvider()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ValueProvider getValueProvider();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getValueProvider <em>Value Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Provider</em>' containment reference.
	 * @see #getValueProvider()
	 * @generated
	 */
	void setValueProvider(ValueProvider value);

	/**
	 * Returns the value of the '<em><b>Min Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Value</em>' attribute.
	 * @see #setMinValue(long)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getVariation_MinValue()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getMinValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getMinValue <em>Min Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Value</em>' attribute.
	 * @see #getMinValue()
	 * @generated
	 */
	void setMinValue(long value);

	/**
	 * Returns the value of the '<em><b>Max Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Value</em>' attribute.
	 * @see #setMaxValue(long)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getVariation_MaxValue()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getMaxValue();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getMaxValue <em>Max Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Value</em>' attribute.
	 * @see #getMaxValue()
	 * @generated
	 */
	void setMaxValue(long value);

	/**
	 * Returns the value of the '<em><b>Max Variations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Variations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Variations</em>' attribute.
	 * @see #setMaxVariations(long)
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getVariation_MaxVariations()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getMaxVariations();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getMaxVariations <em>Max Variations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Variations</em>' attribute.
	 * @see #getMaxVariations()
	 * @generated
	 */
	void setMaxVariations(long value);

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
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getVariation_VariedObjectId()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getVariedObjectId();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getVariedObjectId <em>Varied Object Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Varied Object Id</em>' attribute.
	 * @see #getVariedObjectId()
	 * @generated
	 */
	void setVariedObjectId(String value);

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
	 * @see de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage#getVariation_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.experimentautomation.experiments.Variation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Variation
