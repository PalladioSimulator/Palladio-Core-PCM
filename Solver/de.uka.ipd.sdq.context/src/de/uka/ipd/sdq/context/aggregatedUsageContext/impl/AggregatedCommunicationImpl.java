/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication;
import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregated Communication</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedCommunicationImpl#getAverageMessageSize <em>Average Message Size</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedCommunicationImpl#getAverageMessageFrequency <em>Average Message Frequency</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedCommunicationImpl#getReceiver_AggregatedCommunication <em>Receiver Aggregated Communication</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedCommunicationImpl#getUsedCommunicationLinkResourceSpecification_AggregatedCommunication <em>Used Communication Link Resource Specification Aggregated Communication</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AggregatedCommunicationImpl extends EObjectImpl implements AggregatedCommunication {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The default value of the '{@link #getAverageMessageSize() <em>Average Message Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageMessageSize()
	 * @generated
	 * @ordered
	 */
	protected static final double AVERAGE_MESSAGE_SIZE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAverageMessageSize() <em>Average Message Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageMessageSize()
	 * @generated
	 * @ordered
	 */
	protected double averageMessageSize = AVERAGE_MESSAGE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAverageMessageFrequency() <em>Average Message Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageMessageFrequency()
	 * @generated
	 * @ordered
	 */
	protected static final double AVERAGE_MESSAGE_FREQUENCY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAverageMessageFrequency() <em>Average Message Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageMessageFrequency()
	 * @generated
	 * @ordered
	 */
	protected double averageMessageFrequency = AVERAGE_MESSAGE_FREQUENCY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReceiver_AggregatedCommunication() <em>Receiver Aggregated Communication</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiver_AggregatedCommunication()
	 * @generated
	 * @ordered
	 */
	protected ServiceExecutionContext receiver_AggregatedCommunication;

	/**
	 * The cached value of the '{@link #getUsedCommunicationLinkResourceSpecification_AggregatedCommunication() <em>Used Communication Link Resource Specification Aggregated Communication</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedCommunicationLinkResourceSpecification_AggregatedCommunication()
	 * @generated
	 * @ordered
	 */
	protected CommunicationLinkResourceSpecification usedCommunicationLinkResourceSpecification_AggregatedCommunication;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregatedCommunicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AggregatedUsageContextPackage.Literals.AGGREGATED_COMMUNICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAverageMessageSize() {
		return averageMessageSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAverageMessageSize(double newAverageMessageSize) {
		double oldAverageMessageSize = averageMessageSize;
		averageMessageSize = newAverageMessageSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_SIZE, oldAverageMessageSize, averageMessageSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAverageMessageFrequency() {
		return averageMessageFrequency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAverageMessageFrequency(double newAverageMessageFrequency) {
		double oldAverageMessageFrequency = averageMessageFrequency;
		averageMessageFrequency = newAverageMessageFrequency;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_FREQUENCY, oldAverageMessageFrequency, averageMessageFrequency));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceExecutionContext getReceiver_AggregatedCommunication() {
		if (receiver_AggregatedCommunication != null && receiver_AggregatedCommunication.eIsProxy()) {
			InternalEObject oldReceiver_AggregatedCommunication = (InternalEObject)receiver_AggregatedCommunication;
			receiver_AggregatedCommunication = (ServiceExecutionContext)eResolveProxy(oldReceiver_AggregatedCommunication);
			if (receiver_AggregatedCommunication != oldReceiver_AggregatedCommunication) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION, oldReceiver_AggregatedCommunication, receiver_AggregatedCommunication));
			}
		}
		return receiver_AggregatedCommunication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceExecutionContext basicGetReceiver_AggregatedCommunication() {
		return receiver_AggregatedCommunication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReceiver_AggregatedCommunication(ServiceExecutionContext newReceiver_AggregatedCommunication, NotificationChain msgs) {
		ServiceExecutionContext oldReceiver_AggregatedCommunication = receiver_AggregatedCommunication;
		receiver_AggregatedCommunication = newReceiver_AggregatedCommunication;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION, oldReceiver_AggregatedCommunication, newReceiver_AggregatedCommunication);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceiver_AggregatedCommunication(ServiceExecutionContext newReceiver_AggregatedCommunication) {
		if (newReceiver_AggregatedCommunication != receiver_AggregatedCommunication) {
			NotificationChain msgs = null;
			if (receiver_AggregatedCommunication != null)
				msgs = ((InternalEObject)receiver_AggregatedCommunication).eInverseRemove(this, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION, ServiceExecutionContext.class, msgs);
			if (newReceiver_AggregatedCommunication != null)
				msgs = ((InternalEObject)newReceiver_AggregatedCommunication).eInverseAdd(this, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION, ServiceExecutionContext.class, msgs);
			msgs = basicSetReceiver_AggregatedCommunication(newReceiver_AggregatedCommunication, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION, newReceiver_AggregatedCommunication, newReceiver_AggregatedCommunication));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationLinkResourceSpecification getUsedCommunicationLinkResourceSpecification_AggregatedCommunication() {
		if (usedCommunicationLinkResourceSpecification_AggregatedCommunication != null && usedCommunicationLinkResourceSpecification_AggregatedCommunication.eIsProxy()) {
			InternalEObject oldUsedCommunicationLinkResourceSpecification_AggregatedCommunication = (InternalEObject)usedCommunicationLinkResourceSpecification_AggregatedCommunication;
			usedCommunicationLinkResourceSpecification_AggregatedCommunication = (CommunicationLinkResourceSpecification)eResolveProxy(oldUsedCommunicationLinkResourceSpecification_AggregatedCommunication);
			if (usedCommunicationLinkResourceSpecification_AggregatedCommunication != oldUsedCommunicationLinkResourceSpecification_AggregatedCommunication) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__USED_COMMUNICATION_LINK_RESOURCE_SPECIFICATION_AGGREGATED_COMMUNICATION, oldUsedCommunicationLinkResourceSpecification_AggregatedCommunication, usedCommunicationLinkResourceSpecification_AggregatedCommunication));
			}
		}
		return usedCommunicationLinkResourceSpecification_AggregatedCommunication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationLinkResourceSpecification basicGetUsedCommunicationLinkResourceSpecification_AggregatedCommunication() {
		return usedCommunicationLinkResourceSpecification_AggregatedCommunication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsedCommunicationLinkResourceSpecification_AggregatedCommunication(CommunicationLinkResourceSpecification newUsedCommunicationLinkResourceSpecification_AggregatedCommunication) {
		CommunicationLinkResourceSpecification oldUsedCommunicationLinkResourceSpecification_AggregatedCommunication = usedCommunicationLinkResourceSpecification_AggregatedCommunication;
		usedCommunicationLinkResourceSpecification_AggregatedCommunication = newUsedCommunicationLinkResourceSpecification_AggregatedCommunication;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__USED_COMMUNICATION_LINK_RESOURCE_SPECIFICATION_AGGREGATED_COMMUNICATION, oldUsedCommunicationLinkResourceSpecification_AggregatedCommunication, usedCommunicationLinkResourceSpecification_AggregatedCommunication));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION:
				if (receiver_AggregatedCommunication != null)
					msgs = ((InternalEObject)receiver_AggregatedCommunication).eInverseRemove(this, AggregatedUsageContextPackage.SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION, ServiceExecutionContext.class, msgs);
				return basicSetReceiver_AggregatedCommunication((ServiceExecutionContext)otherEnd, msgs);
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
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION:
				return basicSetReceiver_AggregatedCommunication(null, msgs);
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
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_SIZE:
				return getAverageMessageSize();
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_FREQUENCY:
				return getAverageMessageFrequency();
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION:
				if (resolve) return getReceiver_AggregatedCommunication();
				return basicGetReceiver_AggregatedCommunication();
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__USED_COMMUNICATION_LINK_RESOURCE_SPECIFICATION_AGGREGATED_COMMUNICATION:
				if (resolve) return getUsedCommunicationLinkResourceSpecification_AggregatedCommunication();
				return basicGetUsedCommunicationLinkResourceSpecification_AggregatedCommunication();
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
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_SIZE:
				setAverageMessageSize((Double)newValue);
				return;
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_FREQUENCY:
				setAverageMessageFrequency((Double)newValue);
				return;
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION:
				setReceiver_AggregatedCommunication((ServiceExecutionContext)newValue);
				return;
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__USED_COMMUNICATION_LINK_RESOURCE_SPECIFICATION_AGGREGATED_COMMUNICATION:
				setUsedCommunicationLinkResourceSpecification_AggregatedCommunication((CommunicationLinkResourceSpecification)newValue);
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
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_SIZE:
				setAverageMessageSize(AVERAGE_MESSAGE_SIZE_EDEFAULT);
				return;
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_FREQUENCY:
				setAverageMessageFrequency(AVERAGE_MESSAGE_FREQUENCY_EDEFAULT);
				return;
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION:
				setReceiver_AggregatedCommunication((ServiceExecutionContext)null);
				return;
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__USED_COMMUNICATION_LINK_RESOURCE_SPECIFICATION_AGGREGATED_COMMUNICATION:
				setUsedCommunicationLinkResourceSpecification_AggregatedCommunication((CommunicationLinkResourceSpecification)null);
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
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_SIZE:
				return averageMessageSize != AVERAGE_MESSAGE_SIZE_EDEFAULT;
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_FREQUENCY:
				return averageMessageFrequency != AVERAGE_MESSAGE_FREQUENCY_EDEFAULT;
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION:
				return receiver_AggregatedCommunication != null;
			case AggregatedUsageContextPackage.AGGREGATED_COMMUNICATION__USED_COMMUNICATION_LINK_RESOURCE_SPECIFICATION_AGGREGATED_COMMUNICATION:
				return usedCommunicationLinkResourceSpecification_AggregatedCommunication != null;
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
		result.append(" (averageMessageSize: ");
		result.append(averageMessageSize);
		result.append(", averageMessageFrequency: ");
		result.append(averageMessageFrequency);
		result.append(')');
		return result.toString();
	}

} //AggregatedCommunicationImpl
