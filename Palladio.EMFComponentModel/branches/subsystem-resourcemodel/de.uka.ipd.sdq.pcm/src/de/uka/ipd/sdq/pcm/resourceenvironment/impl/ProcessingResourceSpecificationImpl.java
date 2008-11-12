/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processing Resource Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getControllerSpecification <em>Controller Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getSchedulingPolicy <em>Scheduling Policy</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getActiveResourceType_ActiveResourceSpecification <em>Active Resource Type Active Resource Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getProcessingRate_ProcessingResourceSpecification <em>Processing Rate Processing Resource Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessingResourceSpecificationImpl extends EObjectImpl implements ProcessingResourceSpecification {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The default value of the '{@link #getControllerSpecification() <em>Controller Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerSpecification()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTROLLER_SPECIFICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControllerSpecification() <em>Controller Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControllerSpecification()
	 * @generated
	 * @ordered
	 */
	protected String controllerSpecification = CONTROLLER_SPECIFICATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchedulingPolicy() <em>Scheduling Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final SchedulingPolicy SCHEDULING_POLICY_EDEFAULT = SchedulingPolicy.DELAY;

	/**
	 * The cached value of the '{@link #getSchedulingPolicy() <em>Scheduling Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingPolicy()
	 * @generated
	 * @ordered
	 */
	protected SchedulingPolicy schedulingPolicy = SCHEDULING_POLICY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActiveResourceType_ActiveResourceSpecification() <em>Active Resource Type Active Resource Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveResourceType_ActiveResourceSpecification()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResourceType activeResourceType_ActiveResourceSpecification;

	/**
	 * The cached value of the '{@link #getProcessingRate_ProcessingResourceSpecification() <em>Processing Rate Processing Resource Specification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingRate_ProcessingResourceSpecification()
	 * @generated
	 * @ordered
	 */
	protected PCMRandomVariable processingRate_ProcessingResourceSpecification;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessingResourceSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getControllerSpecification() {
		return controllerSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControllerSpecification(String newControllerSpecification) {
		String oldControllerSpecification = controllerSpecification;
		controllerSpecification = newControllerSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__CONTROLLER_SPECIFICATION, oldControllerSpecification, controllerSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingPolicy getSchedulingPolicy() {
		return schedulingPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedulingPolicy(SchedulingPolicy newSchedulingPolicy) {
		SchedulingPolicy oldSchedulingPolicy = schedulingPolicy;
		schedulingPolicy = newSchedulingPolicy == null ? SCHEDULING_POLICY_EDEFAULT : newSchedulingPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY, oldSchedulingPolicy, schedulingPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceType getActiveResourceType_ActiveResourceSpecification() {
		if (activeResourceType_ActiveResourceSpecification != null && activeResourceType_ActiveResourceSpecification.eIsProxy()) {
			InternalEObject oldActiveResourceType_ActiveResourceSpecification = (InternalEObject)activeResourceType_ActiveResourceSpecification;
			activeResourceType_ActiveResourceSpecification = (ProcessingResourceType)eResolveProxy(oldActiveResourceType_ActiveResourceSpecification);
			if (activeResourceType_ActiveResourceSpecification != oldActiveResourceType_ActiveResourceSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION, oldActiveResourceType_ActiveResourceSpecification, activeResourceType_ActiveResourceSpecification));
			}
		}
		return activeResourceType_ActiveResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceType basicGetActiveResourceType_ActiveResourceSpecification() {
		return activeResourceType_ActiveResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveResourceType_ActiveResourceSpecification(ProcessingResourceType newActiveResourceType_ActiveResourceSpecification) {
		ProcessingResourceType oldActiveResourceType_ActiveResourceSpecification = activeResourceType_ActiveResourceSpecification;
		activeResourceType_ActiveResourceSpecification = newActiveResourceType_ActiveResourceSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION, oldActiveResourceType_ActiveResourceSpecification, activeResourceType_ActiveResourceSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMRandomVariable getProcessingRate_ProcessingResourceSpecification() {
		return processingRate_ProcessingResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcessingRate_ProcessingResourceSpecification(PCMRandomVariable newProcessingRate_ProcessingResourceSpecification, NotificationChain msgs) {
		PCMRandomVariable oldProcessingRate_ProcessingResourceSpecification = processingRate_ProcessingResourceSpecification;
		processingRate_ProcessingResourceSpecification = newProcessingRate_ProcessingResourceSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION, oldProcessingRate_ProcessingResourceSpecification, newProcessingRate_ProcessingResourceSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingRate_ProcessingResourceSpecification(PCMRandomVariable newProcessingRate_ProcessingResourceSpecification) {
		if (newProcessingRate_ProcessingResourceSpecification != processingRate_ProcessingResourceSpecification) {
			NotificationChain msgs = null;
			if (processingRate_ProcessingResourceSpecification != null)
				msgs = ((InternalEObject)processingRate_ProcessingResourceSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION, null, msgs);
			if (newProcessingRate_ProcessingResourceSpecification != null)
				msgs = ((InternalEObject)newProcessingRate_ProcessingResourceSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION, null, msgs);
			msgs = basicSetProcessingRate_ProcessingResourceSpecification(newProcessingRate_ProcessingResourceSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION, newProcessingRate_ProcessingResourceSpecification, newProcessingRate_ProcessingResourceSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
				return basicSetProcessingRate_ProcessingResourceSpecification(null, msgs);
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
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__CONTROLLER_SPECIFICATION:
				return getControllerSpecification();
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
				return getSchedulingPolicy();
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
				if (resolve) return getActiveResourceType_ActiveResourceSpecification();
				return basicGetActiveResourceType_ActiveResourceSpecification();
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
				return getProcessingRate_ProcessingResourceSpecification();
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
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__CONTROLLER_SPECIFICATION:
				setControllerSpecification((String)newValue);
				return;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
				setSchedulingPolicy((SchedulingPolicy)newValue);
				return;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
				setActiveResourceType_ActiveResourceSpecification((ProcessingResourceType)newValue);
				return;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
				setProcessingRate_ProcessingResourceSpecification((PCMRandomVariable)newValue);
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
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__CONTROLLER_SPECIFICATION:
				setControllerSpecification(CONTROLLER_SPECIFICATION_EDEFAULT);
				return;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
				setSchedulingPolicy(SCHEDULING_POLICY_EDEFAULT);
				return;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
				setActiveResourceType_ActiveResourceSpecification((ProcessingResourceType)null);
				return;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
				setProcessingRate_ProcessingResourceSpecification((PCMRandomVariable)null);
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
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__CONTROLLER_SPECIFICATION:
				return CONTROLLER_SPECIFICATION_EDEFAULT == null ? controllerSpecification != null : !CONTROLLER_SPECIFICATION_EDEFAULT.equals(controllerSpecification);
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
				return schedulingPolicy != SCHEDULING_POLICY_EDEFAULT;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
				return activeResourceType_ActiveResourceSpecification != null;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION:
				return processingRate_ProcessingResourceSpecification != null;
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
		result.append(" (controllerSpecification: ");
		result.append(controllerSpecification);
		result.append(", schedulingPolicy: ");
		result.append(schedulingPolicy);
		result.append(')');
		return result.toString();
	}

} //ProcessingResourceSpecificationImpl
