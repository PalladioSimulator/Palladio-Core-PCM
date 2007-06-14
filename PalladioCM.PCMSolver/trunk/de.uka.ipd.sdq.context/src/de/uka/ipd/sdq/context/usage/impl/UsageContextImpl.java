/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.usage.impl;

import de.uka.ipd.sdq.context.usage.BranchProbability;
import de.uka.ipd.sdq.context.usage.LoopIteration;
import de.uka.ipd.sdq.context.usage.UsageContext;
import de.uka.ipd.sdq.context.usage.UsagePackage;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.usage.impl.UsageContextImpl#getBranchprobabilities_UsageContext <em>Branchprobabilities Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.usage.impl.UsageContextImpl#getLoopiterations_UsageContext <em>Loopiterations Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.usage.impl.UsageContextImpl#getActualParameterUsage_UsageContext <em>Actual Parameter Usage Usage Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UsageContextImpl extends EObjectImpl implements UsageContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The cached value of the '{@link #getBranchprobabilities_UsageContext() <em>Branchprobabilities Usage Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchprobabilities_UsageContext()
	 * @generated
	 * @ordered
	 */
	protected EList branchprobabilities_UsageContext;

	/**
	 * The cached value of the '{@link #getLoopiterations_UsageContext() <em>Loopiterations Usage Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopiterations_UsageContext()
	 * @generated
	 * @ordered
	 */
	protected EList loopiterations_UsageContext;

	/**
	 * The cached value of the '{@link #getActualParameterUsage_UsageContext() <em>Actual Parameter Usage Usage Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualParameterUsage_UsageContext()
	 * @generated
	 * @ordered
	 */
	protected EList actualParameterUsage_UsageContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsageContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UsagePackage.Literals.USAGE_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBranchprobabilities_UsageContext() {
		if (branchprobabilities_UsageContext == null) {
			branchprobabilities_UsageContext = new EObjectContainmentEList(BranchProbability.class, this, UsagePackage.USAGE_CONTEXT__BRANCHPROBABILITIES_USAGE_CONTEXT);
		}
		return branchprobabilities_UsageContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLoopiterations_UsageContext() {
		if (loopiterations_UsageContext == null) {
			loopiterations_UsageContext = new EObjectContainmentEList(LoopIteration.class, this, UsagePackage.USAGE_CONTEXT__LOOPITERATIONS_USAGE_CONTEXT);
		}
		return loopiterations_UsageContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getActualParameterUsage_UsageContext() {
		if (actualParameterUsage_UsageContext == null) {
			actualParameterUsage_UsageContext = new EObjectContainmentEList(VariableUsage.class, this, UsagePackage.USAGE_CONTEXT__ACTUAL_PARAMETER_USAGE_USAGE_CONTEXT);
		}
		return actualParameterUsage_UsageContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagePackage.USAGE_CONTEXT__BRANCHPROBABILITIES_USAGE_CONTEXT:
				return ((InternalEList)getBranchprobabilities_UsageContext()).basicRemove(otherEnd, msgs);
			case UsagePackage.USAGE_CONTEXT__LOOPITERATIONS_USAGE_CONTEXT:
				return ((InternalEList)getLoopiterations_UsageContext()).basicRemove(otherEnd, msgs);
			case UsagePackage.USAGE_CONTEXT__ACTUAL_PARAMETER_USAGE_USAGE_CONTEXT:
				return ((InternalEList)getActualParameterUsage_UsageContext()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UsagePackage.USAGE_CONTEXT__BRANCHPROBABILITIES_USAGE_CONTEXT:
				return getBranchprobabilities_UsageContext();
			case UsagePackage.USAGE_CONTEXT__LOOPITERATIONS_USAGE_CONTEXT:
				return getLoopiterations_UsageContext();
			case UsagePackage.USAGE_CONTEXT__ACTUAL_PARAMETER_USAGE_USAGE_CONTEXT:
				return getActualParameterUsage_UsageContext();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UsagePackage.USAGE_CONTEXT__BRANCHPROBABILITIES_USAGE_CONTEXT:
				getBranchprobabilities_UsageContext().clear();
				getBranchprobabilities_UsageContext().addAll((Collection)newValue);
				return;
			case UsagePackage.USAGE_CONTEXT__LOOPITERATIONS_USAGE_CONTEXT:
				getLoopiterations_UsageContext().clear();
				getLoopiterations_UsageContext().addAll((Collection)newValue);
				return;
			case UsagePackage.USAGE_CONTEXT__ACTUAL_PARAMETER_USAGE_USAGE_CONTEXT:
				getActualParameterUsage_UsageContext().clear();
				getActualParameterUsage_UsageContext().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case UsagePackage.USAGE_CONTEXT__BRANCHPROBABILITIES_USAGE_CONTEXT:
				getBranchprobabilities_UsageContext().clear();
				return;
			case UsagePackage.USAGE_CONTEXT__LOOPITERATIONS_USAGE_CONTEXT:
				getLoopiterations_UsageContext().clear();
				return;
			case UsagePackage.USAGE_CONTEXT__ACTUAL_PARAMETER_USAGE_USAGE_CONTEXT:
				getActualParameterUsage_UsageContext().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UsagePackage.USAGE_CONTEXT__BRANCHPROBABILITIES_USAGE_CONTEXT:
				return branchprobabilities_UsageContext != null && !branchprobabilities_UsageContext.isEmpty();
			case UsagePackage.USAGE_CONTEXT__LOOPITERATIONS_USAGE_CONTEXT:
				return loopiterations_UsageContext != null && !loopiterations_UsageContext.isEmpty();
			case UsagePackage.USAGE_CONTEXT__ACTUAL_PARAMETER_USAGE_USAGE_CONTEXT:
				return actualParameterUsage_UsageContext != null && !actualParameterUsage_UsageContext.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UsageContextImpl
