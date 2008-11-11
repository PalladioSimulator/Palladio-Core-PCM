/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import de.uka.ipd.sdq.pcm.resourceenvironment.Controller;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Controller</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ControllerImpl#getController_ProcessingResourceSpecification <em>Controller Processing Resource Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ControllerImpl extends EObjectImpl implements Controller {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getController_ProcessingResourceSpecification() <em>Controller Processing Resource Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getController_ProcessingResourceSpecification()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResourceSpecification controller_ProcessingResourceSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControllerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.CONTROLLER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification getController_ProcessingResourceSpecification() {
		if (controller_ProcessingResourceSpecification != null && controller_ProcessingResourceSpecification.eIsProxy()) {
			InternalEObject oldController_ProcessingResourceSpecification = (InternalEObject)controller_ProcessingResourceSpecification;
			controller_ProcessingResourceSpecification = (ProcessingResourceSpecification)eResolveProxy(oldController_ProcessingResourceSpecification);
			if (controller_ProcessingResourceSpecification != oldController_ProcessingResourceSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentPackage.CONTROLLER__CONTROLLER_PROCESSING_RESOURCE_SPECIFICATION, oldController_ProcessingResourceSpecification, controller_ProcessingResourceSpecification));
			}
		}
		return controller_ProcessingResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification basicGetController_ProcessingResourceSpecification() {
		return controller_ProcessingResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetController_ProcessingResourceSpecification(ProcessingResourceSpecification newController_ProcessingResourceSpecification, NotificationChain msgs) {
		ProcessingResourceSpecification oldController_ProcessingResourceSpecification = controller_ProcessingResourceSpecification;
		controller_ProcessingResourceSpecification = newController_ProcessingResourceSpecification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.CONTROLLER__CONTROLLER_PROCESSING_RESOURCE_SPECIFICATION, oldController_ProcessingResourceSpecification, newController_ProcessingResourceSpecification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setController_ProcessingResourceSpecification(ProcessingResourceSpecification newController_ProcessingResourceSpecification) {
		if (newController_ProcessingResourceSpecification != controller_ProcessingResourceSpecification) {
			NotificationChain msgs = null;
			if (controller_ProcessingResourceSpecification != null)
				msgs = ((InternalEObject)controller_ProcessingResourceSpecification).eInverseRemove(this, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RESOURCE_SPECIFICATION_CONTROLLER, ProcessingResourceSpecification.class, msgs);
			if (newController_ProcessingResourceSpecification != null)
				msgs = ((InternalEObject)newController_ProcessingResourceSpecification).eInverseAdd(this, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RESOURCE_SPECIFICATION_CONTROLLER, ProcessingResourceSpecification.class, msgs);
			msgs = basicSetController_ProcessingResourceSpecification(newController_ProcessingResourceSpecification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.CONTROLLER__CONTROLLER_PROCESSING_RESOURCE_SPECIFICATION, newController_ProcessingResourceSpecification, newController_ProcessingResourceSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourceenvironmentPackage.CONTROLLER__CONTROLLER_PROCESSING_RESOURCE_SPECIFICATION:
				if (controller_ProcessingResourceSpecification != null)
					msgs = ((InternalEObject)controller_ProcessingResourceSpecification).eInverseRemove(this, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RESOURCE_SPECIFICATION_CONTROLLER, ProcessingResourceSpecification.class, msgs);
				return basicSetController_ProcessingResourceSpecification((ProcessingResourceSpecification)otherEnd, msgs);
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
			case ResourceenvironmentPackage.CONTROLLER__CONTROLLER_PROCESSING_RESOURCE_SPECIFICATION:
				return basicSetController_ProcessingResourceSpecification(null, msgs);
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
			case ResourceenvironmentPackage.CONTROLLER__CONTROLLER_PROCESSING_RESOURCE_SPECIFICATION:
				if (resolve) return getController_ProcessingResourceSpecification();
				return basicGetController_ProcessingResourceSpecification();
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
			case ResourceenvironmentPackage.CONTROLLER__CONTROLLER_PROCESSING_RESOURCE_SPECIFICATION:
				setController_ProcessingResourceSpecification((ProcessingResourceSpecification)newValue);
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
			case ResourceenvironmentPackage.CONTROLLER__CONTROLLER_PROCESSING_RESOURCE_SPECIFICATION:
				setController_ProcessingResourceSpecification((ProcessingResourceSpecification)null);
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
			case ResourceenvironmentPackage.CONTROLLER__CONTROLLER_PROCESSING_RESOURCE_SPECIFICATION:
				return controller_ProcessingResourceSpecification != null;
		}
		return super.eIsSet(featureID);
	}

} //ControllerImpl
