/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand;
import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregated Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedResourceDemandImpl#getAggregatedResourceDemand <em>Aggregated Resource Demand</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedResourceDemandImpl#getResourceType_AggregatedResourceDemand <em>Resource Type Aggregated Resource Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregatedResourceDemandImpl extends EObjectImpl implements AggregatedResourceDemand {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The default value of the '{@link #getAggregatedResourceDemand() <em>Aggregated Resource Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregatedResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected static final double AGGREGATED_RESOURCE_DEMAND_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAggregatedResourceDemand() <em>Aggregated Resource Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregatedResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected double aggregatedResourceDemand = AGGREGATED_RESOURCE_DEMAND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResourceType_AggregatedResourceDemand() <em>Resource Type Aggregated Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceType_AggregatedResourceDemand()
	 * @generated
	 * @ordered
	 */
	protected ResourceType resourceType_AggregatedResourceDemand;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatedResourceDemandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AggregatedUsageContextPackage.Literals.AGGREGATED_RESOURCE_DEMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAggregatedResourceDemand() {
		return aggregatedResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregatedResourceDemand(double newAggregatedResourceDemand) {
		double oldAggregatedResourceDemand = aggregatedResourceDemand;
		aggregatedResourceDemand = newAggregatedResourceDemand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatedUsageContextPackage.AGGREGATED_RESOURCE_DEMAND__AGGREGATED_RESOURCE_DEMAND, oldAggregatedResourceDemand, aggregatedResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType getResourceType_AggregatedResourceDemand() {
		if (resourceType_AggregatedResourceDemand != null && resourceType_AggregatedResourceDemand.eIsProxy()) {
			InternalEObject oldResourceType_AggregatedResourceDemand = (InternalEObject)resourceType_AggregatedResourceDemand;
			resourceType_AggregatedResourceDemand = (ResourceType)eResolveProxy(oldResourceType_AggregatedResourceDemand);
			if (resourceType_AggregatedResourceDemand != oldResourceType_AggregatedResourceDemand) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AggregatedUsageContextPackage.AGGREGATED_RESOURCE_DEMAND__RESOURCE_TYPE_AGGREGATED_RESOURCE_DEMAND, oldResourceType_AggregatedResourceDemand, resourceType_AggregatedResourceDemand));
			}
		}
		return resourceType_AggregatedResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceType basicGetResourceType_AggregatedResourceDemand() {
		return resourceType_AggregatedResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceType_AggregatedResourceDemand(ResourceType newResourceType_AggregatedResourceDemand) {
		ResourceType oldResourceType_AggregatedResourceDemand = resourceType_AggregatedResourceDemand;
		resourceType_AggregatedResourceDemand = newResourceType_AggregatedResourceDemand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatedUsageContextPackage.AGGREGATED_RESOURCE_DEMAND__RESOURCE_TYPE_AGGREGATED_RESOURCE_DEMAND, oldResourceType_AggregatedResourceDemand, resourceType_AggregatedResourceDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AggregatedUsageContextPackage.AGGREGATED_RESOURCE_DEMAND__AGGREGATED_RESOURCE_DEMAND:
				return getAggregatedResourceDemand();
			case AggregatedUsageContextPackage.AGGREGATED_RESOURCE_DEMAND__RESOURCE_TYPE_AGGREGATED_RESOURCE_DEMAND:
				if (resolve) return getResourceType_AggregatedResourceDemand();
				return basicGetResourceType_AggregatedResourceDemand();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AggregatedUsageContextPackage.AGGREGATED_RESOURCE_DEMAND__AGGREGATED_RESOURCE_DEMAND:
				setAggregatedResourceDemand((Double)newValue);
				return;
			case AggregatedUsageContextPackage.AGGREGATED_RESOURCE_DEMAND__RESOURCE_TYPE_AGGREGATED_RESOURCE_DEMAND:
				setResourceType_AggregatedResourceDemand((ResourceType)newValue);
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
			case AggregatedUsageContextPackage.AGGREGATED_RESOURCE_DEMAND__AGGREGATED_RESOURCE_DEMAND:
				setAggregatedResourceDemand(AGGREGATED_RESOURCE_DEMAND_EDEFAULT);
				return;
			case AggregatedUsageContextPackage.AGGREGATED_RESOURCE_DEMAND__RESOURCE_TYPE_AGGREGATED_RESOURCE_DEMAND:
				setResourceType_AggregatedResourceDemand((ResourceType)null);
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
			case AggregatedUsageContextPackage.AGGREGATED_RESOURCE_DEMAND__AGGREGATED_RESOURCE_DEMAND:
				return aggregatedResourceDemand != AGGREGATED_RESOURCE_DEMAND_EDEFAULT;
			case AggregatedUsageContextPackage.AGGREGATED_RESOURCE_DEMAND__RESOURCE_TYPE_AGGREGATED_RESOURCE_DEMAND:
				return resourceType_AggregatedResourceDemand != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (aggregatedResourceDemand: ");
		result.append(aggregatedResourceDemand);
		result.append(')');
		return result.toString();
	}

} //AggregatedResourceDemandImpl
