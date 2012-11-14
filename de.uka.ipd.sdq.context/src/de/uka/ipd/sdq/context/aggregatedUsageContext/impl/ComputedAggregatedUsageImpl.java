/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computed Aggregated Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ComputedAggregatedUsageImpl#getServiceExecutionContexts_ComputedAggregatedUsage <em>Service Execution Contexts Computed Aggregated Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputedAggregatedUsageImpl extends EObjectImpl implements ComputedAggregatedUsage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The cached value of the '{@link #getServiceExecutionContexts_ComputedAggregatedUsage() <em>Service Execution Contexts Computed Aggregated Usage</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceExecutionContexts_ComputedAggregatedUsage()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceExecutionContext> serviceExecutionContexts_ComputedAggregatedUsage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputedAggregatedUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AggregatedUsageContextPackage.Literals.COMPUTED_AGGREGATED_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceExecutionContext> getServiceExecutionContexts_ComputedAggregatedUsage() {
		if (serviceExecutionContexts_ComputedAggregatedUsage == null) {
			serviceExecutionContexts_ComputedAggregatedUsage = new EObjectContainmentEList<ServiceExecutionContext>(ServiceExecutionContext.class, this, AggregatedUsageContextPackage.COMPUTED_AGGREGATED_USAGE__SERVICE_EXECUTION_CONTEXTS_COMPUTED_AGGREGATED_USAGE);
		}
		return serviceExecutionContexts_ComputedAggregatedUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AggregatedUsageContextPackage.COMPUTED_AGGREGATED_USAGE__SERVICE_EXECUTION_CONTEXTS_COMPUTED_AGGREGATED_USAGE:
				return ((InternalEList<?>)getServiceExecutionContexts_ComputedAggregatedUsage()).basicRemove(otherEnd, msgs);
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
			case AggregatedUsageContextPackage.COMPUTED_AGGREGATED_USAGE__SERVICE_EXECUTION_CONTEXTS_COMPUTED_AGGREGATED_USAGE:
				return getServiceExecutionContexts_ComputedAggregatedUsage();
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
			case AggregatedUsageContextPackage.COMPUTED_AGGREGATED_USAGE__SERVICE_EXECUTION_CONTEXTS_COMPUTED_AGGREGATED_USAGE:
				getServiceExecutionContexts_ComputedAggregatedUsage().clear();
				getServiceExecutionContexts_ComputedAggregatedUsage().addAll((Collection<? extends ServiceExecutionContext>)newValue);
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
			case AggregatedUsageContextPackage.COMPUTED_AGGREGATED_USAGE__SERVICE_EXECUTION_CONTEXTS_COMPUTED_AGGREGATED_USAGE:
				getServiceExecutionContexts_ComputedAggregatedUsage().clear();
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
			case AggregatedUsageContextPackage.COMPUTED_AGGREGATED_USAGE__SERVICE_EXECUTION_CONTEXTS_COMPUTED_AGGREGATED_USAGE:
				return serviceExecutionContexts_ComputedAggregatedUsage != null && !serviceExecutionContexts_ComputedAggregatedUsage.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComputedAggregatedUsageImpl
