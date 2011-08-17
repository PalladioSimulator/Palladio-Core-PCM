/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Refined QML Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A&nbsp;refinement&nbsp;must&nbsp;be&nbsp;stronger&nbsp;that&nbsp;the&nbsp;contract&nbsp;it&nbsp;refines.
 * <p>
 *     Additional OCL needed:<br />
 *     dimensions must be of the same contract type as the dimensions of the refined contract
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RefinedQMLContract#getRefinedBy <em>Refined By</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RefinedQMLContract#getBaseContract <em>Base Contract</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getRefinedQMLContract()
 * @model
 * @generated
 */
public interface RefinedQMLContract extends GenericQMLContract {
	/**
	 * Returns the value of the '<em><b>Refined By</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined By</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined By</em>' containment reference list.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getRefinedQMLContract_RefinedBy()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Criterion> getRefinedBy();

	/**
	 * Returns the value of the '<em><b>Base Contract</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Contract</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Contract</em>' reference.
	 * @see #setBaseContract(GenericQMLContract)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getRefinedQMLContract_BaseContract()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	GenericQMLContract getBaseContract();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.RefinedQMLContract#getBaseContract <em>Base Contract</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Contract</em>' reference.
	 * @see #getBaseContract()
	 * @generated
	 */
	void setBaseContract(GenericQMLContract value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.baseContract <> self
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.baseContract <> self'"
	 * @generated
	 */
	boolean contract_cannot_refine_itself(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RefinedQMLContract
