/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.PCMREResourceInterface;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCMRE Resource Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.PCMREResourceInterfaceImpl#getResourceInterface <em>Resource Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMREResourceInterfaceImpl extends PCMREImpl implements PCMREResourceInterface {
	/**
	 * The cached value of the '{@link #getResourceInterface() <em>Resource Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceInterface()
	 * @generated
	 * @ordered
	 */
	protected ResourceInterface resourceInterface;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMREResourceInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.PCMRE_RESOURCE_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInterface getResourceInterface() {
		if (resourceInterface != null && resourceInterface.eIsProxy()) {
			InternalEObject oldResourceInterface = (InternalEObject)resourceInterface;
			resourceInterface = (ResourceInterface)eResolveProxy(oldResourceInterface);
			if (resourceInterface != oldResourceInterface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE, oldResourceInterface, resourceInterface));
			}
		}
		return resourceInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInterface basicGetResourceInterface() {
		return resourceInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceInterface(ResourceInterface newResourceInterface) {
		ResourceInterface oldResourceInterface = resourceInterface;
		resourceInterface = newResourceInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE, oldResourceInterface, resourceInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE:
				if (resolve) return getResourceInterface();
				return basicGetResourceInterface();
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE:
				setResourceInterface((ResourceInterface)newValue);
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE:
				setResourceInterface((ResourceInterface)null);
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
			case QualityAnnotationPackage.PCMRE_RESOURCE_INTERFACE__RESOURCE_INTERFACE:
				return resourceInterface != null;
		}
		return super.eIsSet(featureID);
	}

} //PCMREResourceInterfaceImpl
