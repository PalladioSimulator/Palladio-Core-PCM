/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Constraint;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.util.QMLContractValidator;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.ocl.ParserException;

import org.eclipse.ocl.ecore.OCL;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends CriterionImpl implements Constraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QMLContractPackage.Literals.CONSTRAINT;
	}

	/**
	 * The cached OCL expression body for the '{@link #All_ASPECTS_of_CONSTRAINTS_have_RESTRICTIONS(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>All ASPECTS of CONSTRAINTS have RESTRICTIONS</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #All_ASPECTS_of_CONSTRAINTS_have_RESTRICTIONS(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ALL_ASPECTS_OF_CONSTRAINTS_HAVE_RESTRICTIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.aspects->forAll(a|a.aspectRequirement<>null and a.aspectRequirement.oclIsTypeOf(QMLContract::Restriction))";

	/**
	 * The cached OCL invariant for the '{@link #All_ASPECTS_of_CONSTRAINTS_have_RESTRICTIONS(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>All ASPECTS of CONSTRAINTS have RESTRICTIONS</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #All_ASPECTS_of_CONSTRAINTS_have_RESTRICTIONS(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static org.eclipse.ocl.ecore.Constraint ALL_ASPECTS_OF_CONSTRAINTS_HAVE_RESTRICTIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean All_ASPECTS_of_CONSTRAINTS_have_RESTRICTIONS(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ALL_ASPECTS_OF_CONSTRAINTS_HAVE_RESTRICTIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(QMLContractPackage.Literals.CONSTRAINT);
			try {
				ALL_ASPECTS_OF_CONSTRAINTS_HAVE_RESTRICTIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ALL_ASPECTS_OF_CONSTRAINTS_HAVE_RESTRICTIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(ALL_ASPECTS_OF_CONSTRAINTS_HAVE_RESTRICTIONS__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 QMLContractValidator.DIAGNOSTIC_SOURCE,
						 QMLContractValidator.CONSTRAINT__ALL_ASPECTS_OF_CONSTRAINTS_HAVE_RESTRICTIONS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "All_ASPECTS_of_CONSTRAINTS_have_RESTRICTIONS", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

} //ConstraintImpl
