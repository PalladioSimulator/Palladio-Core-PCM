/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage.impl;

import de.uka.ipd.sdq.context.computed_usage.BranchProbability;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage;
import de.uka.ipd.sdq.context.computed_usage.LoopIteration;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
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
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl#getBranchProbabilities_ComputedUsageContext <em>Branch Probabilities Computed Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl#getLoopiterations_ComputedUsageContext <em>Loopiterations Computed Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl#getParameterUsages_ComputedUsageContext <em>Parameter Usages Computed Usage Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsageContextImpl#getAssemblyContext_ComputedUsageContext <em>Assembly Context Computed Usage Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputedUsageContextImpl extends EObjectImpl implements ComputedUsageContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The cached value of the '{@link #getBranchProbabilities_ComputedUsageContext() <em>Branch Probabilities Computed Usage Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchProbabilities_ComputedUsageContext()
	 * @generated
	 * @ordered
	 */
	protected EList branchProbabilities_ComputedUsageContext;

	/**
	 * The cached value of the '{@link #getLoopiterations_ComputedUsageContext() <em>Loopiterations Computed Usage Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopiterations_ComputedUsageContext()
	 * @generated
	 * @ordered
	 */
	protected EList loopiterations_ComputedUsageContext;

	/**
	 * The cached value of the '{@link #getParameterUsages_ComputedUsageContext() <em>Parameter Usages Computed Usage Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterUsages_ComputedUsageContext()
	 * @generated
	 * @ordered
	 */
	protected EList parameterUsages_ComputedUsageContext;

	/**
	 * The cached value of the '{@link #getAssemblyContext_ComputedUsageContext() <em>Assembly Context Computed Usage Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContext_ComputedUsageContext()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblyContext_ComputedUsageContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputedUsageContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ComputedUsagePackage.Literals.COMPUTED_USAGE_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBranchProbabilities_ComputedUsageContext() {
		if (branchProbabilities_ComputedUsageContext == null) {
			branchProbabilities_ComputedUsageContext = new EObjectContainmentEList(BranchProbability.class, this, ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT);
		}
		return branchProbabilities_ComputedUsageContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getLoopiterations_ComputedUsageContext() {
		if (loopiterations_ComputedUsageContext == null) {
			loopiterations_ComputedUsageContext = new EObjectContainmentEList(LoopIteration.class, this, ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT);
		}
		return loopiterations_ComputedUsageContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParameterUsages_ComputedUsageContext() {
		if (parameterUsages_ComputedUsageContext == null) {
			parameterUsages_ComputedUsageContext = new EObjectContainmentEList(VariableUsage.class, this, ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__PARAMETER_USAGES_COMPUTED_USAGE_CONTEXT);
		}
		return parameterUsages_ComputedUsageContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext_ComputedUsageContext() {
		if (assemblyContext_ComputedUsageContext != null && assemblyContext_ComputedUsageContext.eIsProxy()) {
			InternalEObject oldAssemblyContext_ComputedUsageContext = (InternalEObject)assemblyContext_ComputedUsageContext;
			assemblyContext_ComputedUsageContext = (AssemblyContext)eResolveProxy(oldAssemblyContext_ComputedUsageContext);
			if (assemblyContext_ComputedUsageContext != oldAssemblyContext_ComputedUsageContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT, oldAssemblyContext_ComputedUsageContext, assemblyContext_ComputedUsageContext));
			}
		}
		return assemblyContext_ComputedUsageContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext_ComputedUsageContext() {
		return assemblyContext_ComputedUsageContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext_ComputedUsageContext(AssemblyContext newAssemblyContext_ComputedUsageContext) {
		AssemblyContext oldAssemblyContext_ComputedUsageContext = assemblyContext_ComputedUsageContext;
		assemblyContext_ComputedUsageContext = newAssemblyContext_ComputedUsageContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT, oldAssemblyContext_ComputedUsageContext, assemblyContext_ComputedUsageContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT:
				return ((InternalEList)getBranchProbabilities_ComputedUsageContext()).basicRemove(otherEnd, msgs);
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT:
				return ((InternalEList)getLoopiterations_ComputedUsageContext()).basicRemove(otherEnd, msgs);
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__PARAMETER_USAGES_COMPUTED_USAGE_CONTEXT:
				return ((InternalEList)getParameterUsages_ComputedUsageContext()).basicRemove(otherEnd, msgs);
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
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT:
				return getBranchProbabilities_ComputedUsageContext();
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT:
				return getLoopiterations_ComputedUsageContext();
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__PARAMETER_USAGES_COMPUTED_USAGE_CONTEXT:
				return getParameterUsages_ComputedUsageContext();
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT:
				if (resolve) return getAssemblyContext_ComputedUsageContext();
				return basicGetAssemblyContext_ComputedUsageContext();
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
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT:
				getBranchProbabilities_ComputedUsageContext().clear();
				getBranchProbabilities_ComputedUsageContext().addAll((Collection)newValue);
				return;
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT:
				getLoopiterations_ComputedUsageContext().clear();
				getLoopiterations_ComputedUsageContext().addAll((Collection)newValue);
				return;
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__PARAMETER_USAGES_COMPUTED_USAGE_CONTEXT:
				getParameterUsages_ComputedUsageContext().clear();
				getParameterUsages_ComputedUsageContext().addAll((Collection)newValue);
				return;
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT:
				setAssemblyContext_ComputedUsageContext((AssemblyContext)newValue);
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
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT:
				getBranchProbabilities_ComputedUsageContext().clear();
				return;
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT:
				getLoopiterations_ComputedUsageContext().clear();
				return;
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__PARAMETER_USAGES_COMPUTED_USAGE_CONTEXT:
				getParameterUsages_ComputedUsageContext().clear();
				return;
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT:
				setAssemblyContext_ComputedUsageContext((AssemblyContext)null);
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
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT:
				return branchProbabilities_ComputedUsageContext != null && !branchProbabilities_ComputedUsageContext.isEmpty();
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT:
				return loopiterations_ComputedUsageContext != null && !loopiterations_ComputedUsageContext.isEmpty();
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__PARAMETER_USAGES_COMPUTED_USAGE_CONTEXT:
				return parameterUsages_ComputedUsageContext != null && !parameterUsages_ComputedUsageContext.isEmpty();
			case ComputedUsagePackage.COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT:
				return assemblyContext_ComputedUsageContext != null;
		}
		return super.eIsSet(featureID);
	}

} //ComputedUsageContextImpl
