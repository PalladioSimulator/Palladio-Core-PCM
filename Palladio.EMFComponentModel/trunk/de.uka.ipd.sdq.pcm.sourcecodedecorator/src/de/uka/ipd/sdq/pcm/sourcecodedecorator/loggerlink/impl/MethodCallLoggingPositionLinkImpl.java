/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl;

import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Call Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.MethodCallLoggingPositionLinkImpl#getServiceEffectSpecification <em>Service Effect Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodCallLoggingPositionLinkImpl extends InputLoggingPositionLinkImpl implements MethodCallLoggingPositionLink {
	/**
	 * The cached value of the '{@link #getServiceEffectSpecification() <em>Service Effect Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceEffectSpecification()
	 * @generated
	 * @ordered
	 */
	protected ServiceEffectSpecification serviceEffectSpecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodCallLoggingPositionLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoggerlinkPackage.Literals.METHOD_CALL_LOGGING_POSITION_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceEffectSpecification getServiceEffectSpecification() {
		if (serviceEffectSpecification != null && serviceEffectSpecification.eIsProxy()) {
			InternalEObject oldServiceEffectSpecification = (InternalEObject)serviceEffectSpecification;
			serviceEffectSpecification = (ServiceEffectSpecification)eResolveProxy(oldServiceEffectSpecification);
			if (serviceEffectSpecification != oldServiceEffectSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__SERVICE_EFFECT_SPECIFICATION, oldServiceEffectSpecification, serviceEffectSpecification));
			}
		}
		return serviceEffectSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceEffectSpecification basicGetServiceEffectSpecification() {
		return serviceEffectSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceEffectSpecification(ServiceEffectSpecification newServiceEffectSpecification) {
		ServiceEffectSpecification oldServiceEffectSpecification = serviceEffectSpecification;
		serviceEffectSpecification = newServiceEffectSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__SERVICE_EFFECT_SPECIFICATION, oldServiceEffectSpecification, serviceEffectSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__SERVICE_EFFECT_SPECIFICATION:
				if (resolve) return getServiceEffectSpecification();
				return basicGetServiceEffectSpecification();
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
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__SERVICE_EFFECT_SPECIFICATION:
				setServiceEffectSpecification((ServiceEffectSpecification)newValue);
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
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__SERVICE_EFFECT_SPECIFICATION:
				setServiceEffectSpecification((ServiceEffectSpecification)null);
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
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__SERVICE_EFFECT_SPECIFICATION:
				return serviceEffectSpecification != null;
		}
		return super.eIsSet(featureID);
	}

} //MethodCallLoggingPositionLinkImpl
