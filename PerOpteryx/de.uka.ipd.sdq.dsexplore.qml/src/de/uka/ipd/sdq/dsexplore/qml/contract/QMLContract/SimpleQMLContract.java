/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract;

import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractType;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple QML Contract</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     A contract defines simple or aspect constraints.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract#getCriteria <em>Criteria</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract#getContractType <em>Contract Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getSimpleQMLContract()
 * @model
 * @generated
 */
public interface SimpleQMLContract extends GenericQMLContract {
	/**
	 * Returns the value of the '<em><b>Criteria</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Criteria</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Criteria</em>' containment reference list.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getSimpleQMLContract_Criteria()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Criterion> getCriteria();

	/**
	 * Returns the value of the '<em><b>Contract Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contract Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contract Type</em>' reference.
	 * @see #setContractType(QMLContractType)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getSimpleQMLContract_ContractType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	QMLContractType getContractType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract#getContractType <em>Contract Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contract Type</em>' reference.
	 * @see #getContractType()
	 * @generated
	 */
	void setContractType(QMLContractType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * (self.contractType<> null) implies (
	 * 	self.criteria->forAll(c|
	 * 		self.contractType.dimensions->exists(dim|c.dimension=dim)
	 * 	)
	 * )
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='(self.contractType<> null) implies (\r\n\tself.criteria->forAll(c|\r\n\t\tself.contractType.dimensions->exists(dim|c.dimension=dim)\r\n\t)\r\n)'"
	 * @generated
	 */
	boolean all_DIMENSIONs_must_be_from_same_CONTRACTTYPE(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SimpleQMLContract
