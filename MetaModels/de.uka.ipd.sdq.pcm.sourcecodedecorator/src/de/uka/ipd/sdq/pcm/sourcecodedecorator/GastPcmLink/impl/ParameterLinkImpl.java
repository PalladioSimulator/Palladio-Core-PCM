/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl;

import de.fzi.gast.variables.FormalParameter;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.pcm.repository.Parameter;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.GastPcmLinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.ParameterLinkImpl#getLinkedParameter <em>Linked Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.ParameterLinkImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterLinkImpl extends IdentifierImpl implements ParameterLink {
	/**
	 * The cached value of the '{@link #getLinkedParameter() <em>Linked Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedParameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter linkedParameter;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected FormalParameter parameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GastPcmLinkPackage.Literals.PARAMETER_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getLinkedParameter() {
		if (linkedParameter != null && linkedParameter.eIsProxy()) {
			InternalEObject oldLinkedParameter = (InternalEObject)linkedParameter;
			linkedParameter = (Parameter)eResolveProxy(oldLinkedParameter);
			if (linkedParameter != oldLinkedParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GastPcmLinkPackage.PARAMETER_LINK__LINKED_PARAMETER, oldLinkedParameter, linkedParameter));
			}
		}
		return linkedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetLinkedParameter() {
		return linkedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkedParameter(Parameter newLinkedParameter) {
		Parameter oldLinkedParameter = linkedParameter;
		linkedParameter = newLinkedParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GastPcmLinkPackage.PARAMETER_LINK__LINKED_PARAMETER, oldLinkedParameter, linkedParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalParameter getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject)parameter;
			parameter = (FormalParameter)eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GastPcmLinkPackage.PARAMETER_LINK__PARAMETER, oldParameter, parameter));
			}
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FormalParameter basicGetParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter(FormalParameter newParameter) {
		FormalParameter oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GastPcmLinkPackage.PARAMETER_LINK__PARAMETER, oldParameter, parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GastPcmLinkPackage.PARAMETER_LINK__LINKED_PARAMETER:
				if (resolve) return getLinkedParameter();
				return basicGetLinkedParameter();
			case GastPcmLinkPackage.PARAMETER_LINK__PARAMETER:
				if (resolve) return getParameter();
				return basicGetParameter();
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
			case GastPcmLinkPackage.PARAMETER_LINK__LINKED_PARAMETER:
				setLinkedParameter((Parameter)newValue);
				return;
			case GastPcmLinkPackage.PARAMETER_LINK__PARAMETER:
				setParameter((FormalParameter)newValue);
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
			case GastPcmLinkPackage.PARAMETER_LINK__LINKED_PARAMETER:
				setLinkedParameter((Parameter)null);
				return;
			case GastPcmLinkPackage.PARAMETER_LINK__PARAMETER:
				setParameter((FormalParameter)null);
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
			case GastPcmLinkPackage.PARAMETER_LINK__LINKED_PARAMETER:
				return linkedParameter != null;
			case GastPcmLinkPackage.PARAMETER_LINK__PARAMETER:
				return parameter != null;
		}
		return super.eIsSet(featureID);
	}

} //ParameterLinkImpl
