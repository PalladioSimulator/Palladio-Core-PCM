/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract;

import de.uka.ipd.sdq.identifier.Identifier;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evaluation Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect#getAspectRequirement <em>Aspect Requirement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getEvaluationAspect()
 * @model abstract="true"
 * @generated
 */
public interface EvaluationAspect extends Identifier {
	/**
	 * Returns the value of the '<em><b>Aspect Requirement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aspect Requirement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspect Requirement</em>' containment reference.
	 * @see #setAspectRequirement(AspectRequirement)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getEvaluationAspect_AspectRequirement()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	AspectRequirement getAspectRequirement();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect#getAspectRequirement <em>Aspect Requirement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aspect Requirement</em>' containment reference.
	 * @see #getAspectRequirement()
	 * @generated
	 */
	void setAspectRequirement(AspectRequirement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.oclIsTypeOf(QMLContract::Frequency) implies (
	 * 	self.aspectRequirement <> null implies (
	 * 		self.aspectRequirement.aspectRequirementLiteral.oclIsTypeOf(QMLContract::NumericLiteral)
	 * 	)
	 * )
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.oclIsTypeOf(QMLContract::Frequency) implies (\r\n\tself.aspectRequirement <> null implies (\r\n\t\tself.aspectRequirement.aspectRequirementLiteral.oclIsTypeOf(QMLContract::NumericLiteral)\r\n\t)\r\n)'"
	 * @generated
	 */
	boolean FREQUENCY_LIMIT_must_be_NUMERIC(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.oclIsTypeOf(QMLContract::Frequency) implies (
	 * 	self.aspectRequirement <> null implies (
	 * 		self.aspectRequirement.aspectRequirementLiteral.oclIsTypeOf(QMLContract::NumericLiteral) implies (
	 * 			self.aspectRequirement.aspectRequirementLiteral.oclAsType(QMLContract::NumericLiteral).value.oclAsType(Real) > 0 and
	 * 			self.aspectRequirement.aspectRequirementLiteral.oclAsType(QMLContract::NumericLiteral).value.oclAsType(Real) < 100
	 * 		)
	 * 	)
	 * )
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.oclIsTypeOf(QMLContract::Frequency) implies (\r\n\tself.aspectRequirement <> null implies (\r\n\t\tself.aspectRequirement.aspectRequirementLiteral.oclIsTypeOf(QMLContract::NumericLiteral) implies (\r\n\t\t\tself.aspectRequirement.aspectRequirementLiteral.oclAsType(QMLContract::NumericLiteral).value.oclAsType(Real) > 0 and\r\n\t\t\tself.aspectRequirement.aspectRequirementLiteral.oclAsType(QMLContract::NumericLiteral).value.oclAsType(Real) < 100\r\n\t\t)\r\n\t)\r\n)'"
	 * @generated
	 */
	boolean FREQUENCY_LIMIT_must_be_between_0_and_100(DiagnosticChain diagnostics, Map<Object, Object> context);

} // EvaluationAspect
