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
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends Criterion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.aspects->forAll(a|a.aspectRequirement<>null and a.aspectRequirement.oclIsTypeOf(QMLContract::Restriction))
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.aspects->forAll(a|a.aspectRequirement<>null and a.aspectRequirement.oclIsTypeOf(QMLContract::Restriction))'"
	 * @generated
	 */
	boolean All_ASPECTS_of_CONSTRAINTS_have_RESTRICTIONS(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Constraint
