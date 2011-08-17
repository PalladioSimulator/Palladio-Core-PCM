/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Frequency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Defines the frequency of every element in the range.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Frequency#getUpperLimit <em>Upper Limit</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Frequency#getLowerLimit <em>Lower Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getFrequency()
 * @model
 * @generated
 */
public interface Frequency extends StochasticEvaluationAspect {
	/**
	 * Returns the value of the '<em><b>Upper Limit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Limit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Limit</em>' containment reference.
	 * @see #setUpperLimit(RangeValue)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getFrequency_UpperLimit()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	RangeValue getUpperLimit();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Frequency#getUpperLimit <em>Upper Limit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Limit</em>' containment reference.
	 * @see #getUpperLimit()
	 * @generated
	 */
	void setUpperLimit(RangeValue value);

	/**
	 * Returns the value of the '<em><b>Lower Limit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Limit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Limit</em>' containment reference.
	 * @see #setLowerLimit(RangeValue)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getFrequency_LowerLimit()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	RangeValue getLowerLimit();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Frequency#getLowerLimit <em>Lower Limit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Limit</em>' containment reference.
	 * @see #getLowerLimit()
	 * @generated
	 */
	void setLowerLimit(RangeValue value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * (self.lowerLimit <> null) or (self.upperLimit <> null)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='(self.lowerLimit <> null) or (self.upperLimit <> null)'"
	 * @generated
	 */
	boolean range_of_FREQUENCY_must_have_UPPERLIMIT_or_LOWERLIMIT(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Frequency
