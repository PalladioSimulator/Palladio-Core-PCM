/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.BranchImpl#getBranchTransitions_Branch <em>Branch Transitions Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchImpl extends AbstractUserActionImpl implements Branch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getBranchTransitions_Branch() <em>Branch Transitions Branch</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchTransitions_Branch()
	 * @generated
	 * @ordered
	 */
	protected EList<BranchTransition> branchTransitions_Branch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsagemodelPackage.Literals.BRANCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BranchTransition> getBranchTransitions_Branch() {
		if (branchTransitions_Branch == null) {
			branchTransitions_Branch = new EObjectContainmentWithInverseEList<BranchTransition>(BranchTransition.class, this, UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH, UsagemodelPackage.BRANCH_TRANSITION__BRANCH_BRANCH_TRANSITION);
		}
		return branchTransitions_Branch;
	}

	/**
	 * The cached OCL expression body for the '{@link #AllBranchProbabilitiesMustSumUpTo1(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>All Branch Probabilities Must Sum Up To1</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AllBranchProbabilitiesMustSumUpTo1(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ALL_BRANCH_PROBABILITIES_MUST_SUM_UP_TO1__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self->collect(branchTransitions_Branch.branchProbability)->sum() > 0.999 and self->collect(branchTransitions_Branch.branchProbability)->sum() <1.001";

	/**
	 * The cached OCL invariant for the '{@link #AllBranchProbabilitiesMustSumUpTo1(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>All Branch Probabilities Must Sum Up To1</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AllBranchProbabilitiesMustSumUpTo1(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint ALL_BRANCH_PROBABILITIES_MUST_SUM_UP_TO1__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean AllBranchProbabilitiesMustSumUpTo1(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ALL_BRANCH_PROBABILITIES_MUST_SUM_UP_TO1__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(UsagemodelPackage.Literals.BRANCH);
			try {
				ALL_BRANCH_PROBABILITIES_MUST_SUM_UP_TO1__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ALL_BRANCH_PROBABILITIES_MUST_SUM_UP_TO1__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(ALL_BRANCH_PROBABILITIES_MUST_SUM_UP_TO1__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 UsagemodelValidator.DIAGNOSTIC_SOURCE,
						 UsagemodelValidator.BRANCH__ALL_BRANCH_PROBABILITIES_MUST_SUM_UP_TO1,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AllBranchProbabilitiesMustSumUpTo1", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBranchTransitions_Branch()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH:
				return ((InternalEList<?>)getBranchTransitions_Branch()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH:
				return getBranchTransitions_Branch();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH:
				getBranchTransitions_Branch().clear();
				getBranchTransitions_Branch().addAll((Collection<? extends BranchTransition>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH:
				getBranchTransitions_Branch().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UsagemodelPackage.BRANCH__BRANCH_TRANSITIONS_BRANCH:
				return branchTransitions_Branch != null && !branchTransitions_Branch.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //BranchImpl
