/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.PCMLink.impl;

import SourceCodeDecorator.PCMLink.PCMLinkPackage;
import SourceCodeDecorator.PCMLink.SEFFMethodLink;

import SourceCodeDecorator.sourcecodedecorator.MethodLevelSourceCodeLink;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SEFF Method Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SourceCodeDecorator.PCMLink.impl.SEFFMethodLinkImpl#getMethodlevelsourcecodelink <em>Methodlevelsourcecodelink</em>}</li>
 *   <li>{@link SourceCodeDecorator.PCMLink.impl.SEFFMethodLinkImpl#getServiceeffectspecification <em>Serviceeffectspecification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SEFFMethodLinkImpl extends IdentifierImpl implements SEFFMethodLink {
	/**
	 * The cached value of the '{@link #getMethodlevelsourcecodelink() <em>Methodlevelsourcecodelink</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodlevelsourcecodelink()
	 * @generated
	 * @ordered
	 */
	protected MethodLevelSourceCodeLink methodlevelsourcecodelink;

	/**
	 * The cached value of the '{@link #getServiceeffectspecification() <em>Serviceeffectspecification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceeffectspecification()
	 * @generated
	 * @ordered
	 */
	protected ServiceEffectSpecification serviceeffectspecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SEFFMethodLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PCMLinkPackage.Literals.SEFF_METHOD_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodLevelSourceCodeLink getMethodlevelsourcecodelink() {
		if (methodlevelsourcecodelink != null && methodlevelsourcecodelink.eIsProxy()) {
			InternalEObject oldMethodlevelsourcecodelink = (InternalEObject)methodlevelsourcecodelink;
			methodlevelsourcecodelink = (MethodLevelSourceCodeLink)eResolveProxy(oldMethodlevelsourcecodelink);
			if (methodlevelsourcecodelink != oldMethodlevelsourcecodelink) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMLinkPackage.SEFF_METHOD_LINK__METHODLEVELSOURCECODELINK, oldMethodlevelsourcecodelink, methodlevelsourcecodelink));
			}
		}
		return methodlevelsourcecodelink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodLevelSourceCodeLink basicGetMethodlevelsourcecodelink() {
		return methodlevelsourcecodelink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodlevelsourcecodelink(MethodLevelSourceCodeLink newMethodlevelsourcecodelink) {
		MethodLevelSourceCodeLink oldMethodlevelsourcecodelink = methodlevelsourcecodelink;
		methodlevelsourcecodelink = newMethodlevelsourcecodelink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCMLinkPackage.SEFF_METHOD_LINK__METHODLEVELSOURCECODELINK, oldMethodlevelsourcecodelink, methodlevelsourcecodelink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceEffectSpecification getServiceeffectspecification() {
		if (serviceeffectspecification != null && serviceeffectspecification.eIsProxy()) {
			InternalEObject oldServiceeffectspecification = (InternalEObject)serviceeffectspecification;
			serviceeffectspecification = (ServiceEffectSpecification)eResolveProxy(oldServiceeffectspecification);
			if (serviceeffectspecification != oldServiceeffectspecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMLinkPackage.SEFF_METHOD_LINK__SERVICEEFFECTSPECIFICATION, oldServiceeffectspecification, serviceeffectspecification));
			}
		}
		return serviceeffectspecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceEffectSpecification basicGetServiceeffectspecification() {
		return serviceeffectspecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceeffectspecification(ServiceEffectSpecification newServiceeffectspecification) {
		ServiceEffectSpecification oldServiceeffectspecification = serviceeffectspecification;
		serviceeffectspecification = newServiceeffectspecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCMLinkPackage.SEFF_METHOD_LINK__SERVICEEFFECTSPECIFICATION, oldServiceeffectspecification, serviceeffectspecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PCMLinkPackage.SEFF_METHOD_LINK__METHODLEVELSOURCECODELINK:
				if (resolve) return getMethodlevelsourcecodelink();
				return basicGetMethodlevelsourcecodelink();
			case PCMLinkPackage.SEFF_METHOD_LINK__SERVICEEFFECTSPECIFICATION:
				if (resolve) return getServiceeffectspecification();
				return basicGetServiceeffectspecification();
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
			case PCMLinkPackage.SEFF_METHOD_LINK__METHODLEVELSOURCECODELINK:
				setMethodlevelsourcecodelink((MethodLevelSourceCodeLink)newValue);
				return;
			case PCMLinkPackage.SEFF_METHOD_LINK__SERVICEEFFECTSPECIFICATION:
				setServiceeffectspecification((ServiceEffectSpecification)newValue);
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
			case PCMLinkPackage.SEFF_METHOD_LINK__METHODLEVELSOURCECODELINK:
				setMethodlevelsourcecodelink((MethodLevelSourceCodeLink)null);
				return;
			case PCMLinkPackage.SEFF_METHOD_LINK__SERVICEEFFECTSPECIFICATION:
				setServiceeffectspecification((ServiceEffectSpecification)null);
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
			case PCMLinkPackage.SEFF_METHOD_LINK__METHODLEVELSOURCECODELINK:
				return methodlevelsourcecodelink != null;
			case PCMLinkPackage.SEFF_METHOD_LINK__SERVICEEFFECTSPECIFICATION:
				return serviceeffectspecification != null;
		}
		return super.eIsSet(featureID);
	}

} //SEFFMethodLinkImpl
