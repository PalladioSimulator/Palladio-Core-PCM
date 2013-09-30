/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication;
import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand;
import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Execution Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ServiceExecutionContextImpl#getGlobalExecutionFrequency <em>Global Execution Frequency</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ServiceExecutionContextImpl#getAllocationContext_ServiceExecutionContext <em>Allocation Context Service Execution Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ServiceExecutionContextImpl#getDescribedSEFF_ServiceExecutionContext <em>Described SEFF Service Execution Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ServiceExecutionContextImpl#getAggregatedResourceDemands_ServiceExecutionContext <em>Aggregated Resource Demands Service Execution Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ServiceExecutionContextImpl#getUsageScenario_ServiceExecutionContext <em>Usage Scenario Service Execution Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ServiceExecutionContextImpl#getSentAggregatedCommunications_ServiceExecutionContext <em>Sent Aggregated Communications Service Execution Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ServiceExecutionContextImpl#getReceivedAggregatedCommunication_AggregatedCommunication <em>Received Aggregated Communication Aggregated Communication</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceExecutionContextImpl extends EObjectImpl implements ServiceExecutionContext {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The default value of the '{@link #getGlobalExecutionFrequency() <em>Global Execution Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalExecutionFrequency()
	 * @generated
	 * @ordered
	 */
	protected static final double GLOBAL_EXECUTION_FREQUENCY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getGlobalExecutionFrequency() <em>Global Execution Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalExecutionFrequency()
	 * @generated
	 * @ordered
	 */
	protected double globalExecutionFrequency = GLOBAL_EXECUTION_FREQUENCY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAllocationContext_ServiceExecutionContext() <em>Allocation Context Service Execution Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationContext_ServiceExecutionContext()
	 * @generated
	 * @ordered
	 */
	protected AllocationContext allocationContext_ServiceExecutionContext;

	/**
	 * The cached value of the '{@link #getDescribedSEFF_ServiceExecutionContext() <em>Described SEFF Service Execution Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescribedSEFF_ServiceExecutionContext()
	 * @generated
	 * @ordered
	 */
	protected ResourceDemandingSEFF describedSEFF_ServiceExecutionContext;

	/**
	 * The cached value of the '{@link #getAggregatedResourceDemands_ServiceExecutionContext() <em>Aggregated Resource Demands Service Execution Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregatedResourceDemands_ServiceExecutionContext()
	 * @generated
	 * @ordered
	 */
	protected EList<AggregatedResourceDemand> aggregatedResourceDemands_ServiceExecutionContext;

	/**
	 * The cached value of the '{@link #getUsageScenario_ServiceExecutionContext() <em>Usage Scenario Service Execution Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageScenario_ServiceExecutionContext()
	 * @generated
	 * @ordered
	 */
	protected UsageScenario usageScenario_ServiceExecutionContext;

	/**
	 * The cached value of the '{@link #getSentAggregatedCommunications_ServiceExecutionContext() <em>Sent Aggregated Communications Service Execution Context</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentAggregatedCommunications_ServiceExecutionContext()
	 * @generated
	 * @ordered
	 */
	protected EList<AggregatedCommunication> sentAggregatedCommunications_ServiceExecutionContext;

	/**
	 * The cached value of the '{@link #getReceivedAggregatedCommunication_AggregatedCommunication() <em>Received Aggregated Communication Aggregated Communication</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceivedAggregatedCommunication_AggregatedCommunication()
	 * @generated
	 * @ordered
	 */
	protected EList<AggregatedCommunication> receivedAggregatedCommunication_AggregatedCommunication;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceExecutionContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AggregatedUsageContextPackage.Literals.SERVICE_EXECUTION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getGlobalExecutionFrequency() {
		return globalExecutionFrequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalExecutionFrequency(double newGlobalExecutionFrequency) {
		double oldGlobalExecutionFrequency = globalExecutionFrequency;
		globalExecutionFrequency = newGlobalExecutionFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__GLOBAL_EXECUTION_FREQUENCY, oldGlobalExecutionFrequency, globalExecutionFrequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext getAllocationContext_ServiceExecutionContext() {
		if (allocationContext_ServiceExecutionContext != null && allocationContext_ServiceExecutionContext.eIsProxy()) {
			InternalEObject oldAllocationContext_ServiceExecutionContext = (InternalEObject)allocationContext_ServiceExecutionContext;
			allocationContext_ServiceExecutionContext = (AllocationContext)eResolveProxy(oldAllocationContext_ServiceExecutionContext);
			if (allocationContext_ServiceExecutionContext != oldAllocationContext_ServiceExecutionContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__ALLOCATION_CONTEXT_SERVICE_EXECUTION_CONTEXT, oldAllocationContext_ServiceExecutionContext, allocationContext_ServiceExecutionContext));
			}
		}
		return allocationContext_ServiceExecutionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext basicGetAllocationContext_ServiceExecutionContext() {
		return allocationContext_ServiceExecutionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocationContext_ServiceExecutionContext(AllocationContext newAllocationContext_ServiceExecutionContext) {
		AllocationContext oldAllocationContext_ServiceExecutionContext = allocationContext_ServiceExecutionContext;
		allocationContext_ServiceExecutionContext = newAllocationContext_ServiceExecutionContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__ALLOCATION_CONTEXT_SERVICE_EXECUTION_CONTEXT, oldAllocationContext_ServiceExecutionContext, allocationContext_ServiceExecutionContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingSEFF getDescribedSEFF_ServiceExecutionContext() {
		if (describedSEFF_ServiceExecutionContext != null && describedSEFF_ServiceExecutionContext.eIsProxy()) {
			InternalEObject oldDescribedSEFF_ServiceExecutionContext = (InternalEObject)describedSEFF_ServiceExecutionContext;
			describedSEFF_ServiceExecutionContext = (ResourceDemandingSEFF)eResolveProxy(oldDescribedSEFF_ServiceExecutionContext);
			if (describedSEFF_ServiceExecutionContext != oldDescribedSEFF_ServiceExecutionContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__DESCRIBED_SEFF_SERVICE_EXECUTION_CONTEXT, oldDescribedSEFF_ServiceExecutionContext, describedSEFF_ServiceExecutionContext));
			}
		}
		return describedSEFF_ServiceExecutionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingSEFF basicGetDescribedSEFF_ServiceExecutionContext() {
		return describedSEFF_ServiceExecutionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescribedSEFF_ServiceExecutionContext(ResourceDemandingSEFF newDescribedSEFF_ServiceExecutionContext) {
		ResourceDemandingSEFF oldDescribedSEFF_ServiceExecutionContext = describedSEFF_ServiceExecutionContext;
		describedSEFF_ServiceExecutionContext = newDescribedSEFF_ServiceExecutionContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__DESCRIBED_SEFF_SERVICE_EXECUTION_CONTEXT, oldDescribedSEFF_ServiceExecutionContext, describedSEFF_ServiceExecutionContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AggregatedResourceDemand> getAggregatedResourceDemands_ServiceExecutionContext() {
		if (aggregatedResourceDemands_ServiceExecutionContext == null) {
			aggregatedResourceDemands_ServiceExecutionContext = new EObjectContainmentEList<AggregatedResourceDemand>(AggregatedResourceDemand.class, this, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__AGGREGATED_RESOURCE_DEMANDS_SERVICE_EXECUTION_CONTEXT);
		}
		return aggregatedResourceDemands_ServiceExecutionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageScenario getUsageScenario_ServiceExecutionContext() {
		if (usageScenario_ServiceExecutionContext != null && usageScenario_ServiceExecutionContext.eIsProxy()) {
			InternalEObject oldUsageScenario_ServiceExecutionContext = (InternalEObject)usageScenario_ServiceExecutionContext;
			usageScenario_ServiceExecutionContext = (UsageScenario)eResolveProxy(oldUsageScenario_ServiceExecutionContext);
			if (usageScenario_ServiceExecutionContext != oldUsageScenario_ServiceExecutionContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__USAGE_SCENARIO_SERVICE_EXECUTION_CONTEXT, oldUsageScenario_ServiceExecutionContext, usageScenario_ServiceExecutionContext));
			}
		}
		return usageScenario_ServiceExecutionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageScenario basicGetUsageScenario_ServiceExecutionContext() {
		return usageScenario_ServiceExecutionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageScenario_ServiceExecutionContext(UsageScenario newUsageScenario_ServiceExecutionContext) {
		UsageScenario oldUsageScenario_ServiceExecutionContext = usageScenario_ServiceExecutionContext;
		usageScenario_ServiceExecutionContext = newUsageScenario_ServiceExecutionContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__USAGE_SCENARIO_SERVICE_EXECUTION_CONTEXT, oldUsageScenario_ServiceExecutionContext, usageScenario_ServiceExecutionContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AggregatedCommunication> getSentAggregatedCommunications_ServiceExecutionContext() {
		if (sentAggregatedCommunications_ServiceExecutionContext == null) {
			sentAggregatedCommunications_ServiceExecutionContext = new EObjectContainmentEList<AggregatedCommunication>(AggregatedCommunication.class, this, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__SENT_AGGREGATED_COMMUNICATIONS_SERVICE_EXECUTION_CONTEXT);
		}
		return sentAggregatedCommunications_ServiceExecutionContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AggregatedCommunication> getReceivedAggregatedCommunication_AggregatedCommunication() {
		if (receivedAggregatedCommunication_AggregatedCommunication == null) {
			receivedAggregatedCommunication_AggregatedCommunication = new EObjectWithInverseResolvingEList<AggregatedCommunication>(AggregatedCommunication.class, this, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION, AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION);
		}
		return receivedAggregatedCommunication_AggregatedCommunication;
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
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReceivedAggregatedCommunication_AggregatedCommunication()).basicAdd(otherEnd, msgs);
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
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__AGGREGATED_RESOURCE_DEMANDS_SERVICE_EXECUTION_CONTEXT:
				return ((InternalEList<?>)getAggregatedResourceDemands_ServiceExecutionContext()).basicRemove(otherEnd, msgs);
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__SENT_AGGREGATED_COMMUNICATIONS_SERVICE_EXECUTION_CONTEXT:
				return ((InternalEList<?>)getSentAggregatedCommunications_ServiceExecutionContext()).basicRemove(otherEnd, msgs);
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION:
				return ((InternalEList<?>)getReceivedAggregatedCommunication_AggregatedCommunication()).basicRemove(otherEnd, msgs);
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
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__GLOBAL_EXECUTION_FREQUENCY:
				return getGlobalExecutionFrequency();
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__ALLOCATION_CONTEXT_SERVICE_EXECUTION_CONTEXT:
				if (resolve) return getAllocationContext_ServiceExecutionContext();
				return basicGetAllocationContext_ServiceExecutionContext();
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__DESCRIBED_SEFF_SERVICE_EXECUTION_CONTEXT:
				if (resolve) return getDescribedSEFF_ServiceExecutionContext();
				return basicGetDescribedSEFF_ServiceExecutionContext();
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__AGGREGATED_RESOURCE_DEMANDS_SERVICE_EXECUTION_CONTEXT:
				return getAggregatedResourceDemands_ServiceExecutionContext();
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__USAGE_SCENARIO_SERVICE_EXECUTION_CONTEXT:
				if (resolve) return getUsageScenario_ServiceExecutionContext();
				return basicGetUsageScenario_ServiceExecutionContext();
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__SENT_AGGREGATED_COMMUNICATIONS_SERVICE_EXECUTION_CONTEXT:
				return getSentAggregatedCommunications_ServiceExecutionContext();
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION:
				return getReceivedAggregatedCommunication_AggregatedCommunication();
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
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__GLOBAL_EXECUTION_FREQUENCY:
				setGlobalExecutionFrequency((Double)newValue);
				return;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__ALLOCATION_CONTEXT_SERVICE_EXECUTION_CONTEXT:
				setAllocationContext_ServiceExecutionContext((AllocationContext)newValue);
				return;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__DESCRIBED_SEFF_SERVICE_EXECUTION_CONTEXT:
				setDescribedSEFF_ServiceExecutionContext((ResourceDemandingSEFF)newValue);
				return;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__AGGREGATED_RESOURCE_DEMANDS_SERVICE_EXECUTION_CONTEXT:
				getAggregatedResourceDemands_ServiceExecutionContext().clear();
				getAggregatedResourceDemands_ServiceExecutionContext().addAll((Collection<? extends AggregatedResourceDemand>)newValue);
				return;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__USAGE_SCENARIO_SERVICE_EXECUTION_CONTEXT:
				setUsageScenario_ServiceExecutionContext((UsageScenario)newValue);
				return;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__SENT_AGGREGATED_COMMUNICATIONS_SERVICE_EXECUTION_CONTEXT:
				getSentAggregatedCommunications_ServiceExecutionContext().clear();
				getSentAggregatedCommunications_ServiceExecutionContext().addAll((Collection<? extends AggregatedCommunication>)newValue);
				return;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION:
				getReceivedAggregatedCommunication_AggregatedCommunication().clear();
				getReceivedAggregatedCommunication_AggregatedCommunication().addAll((Collection<? extends AggregatedCommunication>)newValue);
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
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__GLOBAL_EXECUTION_FREQUENCY:
				setGlobalExecutionFrequency(GLOBAL_EXECUTION_FREQUENCY_EDEFAULT);
				return;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__ALLOCATION_CONTEXT_SERVICE_EXECUTION_CONTEXT:
				setAllocationContext_ServiceExecutionContext((AllocationContext)null);
				return;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__DESCRIBED_SEFF_SERVICE_EXECUTION_CONTEXT:
				setDescribedSEFF_ServiceExecutionContext((ResourceDemandingSEFF)null);
				return;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__AGGREGATED_RESOURCE_DEMANDS_SERVICE_EXECUTION_CONTEXT:
				getAggregatedResourceDemands_ServiceExecutionContext().clear();
				return;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__USAGE_SCENARIO_SERVICE_EXECUTION_CONTEXT:
				setUsageScenario_ServiceExecutionContext((UsageScenario)null);
				return;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__SENT_AGGREGATED_COMMUNICATIONS_SERVICE_EXECUTION_CONTEXT:
				getSentAggregatedCommunications_ServiceExecutionContext().clear();
				return;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION:
				getReceivedAggregatedCommunication_AggregatedCommunication().clear();
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
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__GLOBAL_EXECUTION_FREQUENCY:
				return globalExecutionFrequency != GLOBAL_EXECUTION_FREQUENCY_EDEFAULT;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__ALLOCATION_CONTEXT_SERVICE_EXECUTION_CONTEXT:
				return allocationContext_ServiceExecutionContext != null;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__DESCRIBED_SEFF_SERVICE_EXECUTION_CONTEXT:
				return describedSEFF_ServiceExecutionContext != null;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__AGGREGATED_RESOURCE_DEMANDS_SERVICE_EXECUTION_CONTEXT:
				return aggregatedResourceDemands_ServiceExecutionContext != null && !aggregatedResourceDemands_ServiceExecutionContext.isEmpty();
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__USAGE_SCENARIO_SERVICE_EXECUTION_CONTEXT:
				return usageScenario_ServiceExecutionContext != null;
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__SENT_AGGREGATED_COMMUNICATIONS_SERVICE_EXECUTION_CONTEXT:
				return sentAggregatedCommunications_ServiceExecutionContext != null && !sentAggregatedCommunications_ServiceExecutionContext.isEmpty();
			case AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION:
				return receivedAggregatedCommunication_AggregatedCommunication != null && !receivedAggregatedCommunication_AggregatedCommunication.isEmpty();
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
		result.append(" (globalExecutionFrequency: ");
		result.append(globalExecutionFrequency);
		result.append(')');
		return result.toString();
	}

} //ServiceExecutionContextImpl
