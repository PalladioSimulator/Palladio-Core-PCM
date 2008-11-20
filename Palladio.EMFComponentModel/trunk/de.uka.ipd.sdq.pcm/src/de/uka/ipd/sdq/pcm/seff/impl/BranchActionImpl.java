/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.BranchActionImpl#getBranches_Branch <em>Branches Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchActionImpl extends AbstractInternalControlFlowActionImpl implements BranchAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getBranches_Branch() <em>Branches Branch</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranches_Branch()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractBranchTransition> branches_Branch;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.BRANCH_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractBranchTransition> getBranches_Branch() {
		if (branches_Branch == null) {
			branches_Branch = new EObjectContainmentEList<AbstractBranchTransition>(AbstractBranchTransition.class, this, SeffPackage.BRANCH_ACTION__BRANCHES_BRANCH);
		}
		return branches_Branch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean EitherGuardedBranchesOrProbabilisiticBranchTransitions(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SeffValidator.DIAGNOSTIC_SOURCE,
						 SeffValidator.BRANCH_ACTION__EITHER_GUARDED_BRANCHES_OR_PROBABILISITIC_BRANCH_TRANSITIONS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "EitherGuardedBranchesOrProbabilisiticBranchTransitions", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean AllProbabilisticBranchProbabilitiesMustSumUpTo1(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 SeffValidator.DIAGNOSTIC_SOURCE,
						 SeffValidator.BRANCH_ACTION__ALL_PROBABILISTIC_BRANCH_PROBABILITIES_MUST_SUM_UP_TO1,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AllProbabilisticBranchProbabilitiesMustSumUpTo1", EObjectValidator.getObjectLabel(this, context) }),
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.BRANCH_ACTION__BRANCHES_BRANCH:
				return ((InternalEList<?>)getBranches_Branch()).basicRemove(otherEnd, msgs);
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
			case SeffPackage.BRANCH_ACTION__BRANCHES_BRANCH:
				return getBranches_Branch();
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
			case SeffPackage.BRANCH_ACTION__BRANCHES_BRANCH:
				getBranches_Branch().clear();
				getBranches_Branch().addAll((Collection<? extends AbstractBranchTransition>)newValue);
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
			case SeffPackage.BRANCH_ACTION__BRANCHES_BRANCH:
				getBranches_Branch().clear();
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
			case SeffPackage.BRANCH_ACTION__BRANCHES_BRANCH:
				return branches_Branch != null && !branches_Branch.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BranchActionImpl
