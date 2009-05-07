
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisation;

import de.uka.ipd.sdq.pcm.repository.Parameter;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.ParameterUsageImpl#getParameter_ParameterUsage <em>Parameter Parameter Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.ParameterUsageImpl#getParameterCharacterisation_ParameterUsage <em>Parameter Characterisation Parameter Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterUsageImpl extends EObjectImpl implements ParameterUsage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getParameter_ParameterUsage() <em>Parameter Parameter Usage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter_ParameterUsage()
	 * @generated
	 * @ordered
	 */
	protected Parameter parameter_ParameterUsage = null;

	/**
	 * The cached value of the '{@link #getParameterCharacterisation_ParameterUsage() <em>Parameter Characterisation Parameter Usage</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterCharacterisation_ParameterUsage()
	 * @generated
	 * @ordered
	 */
	protected EList parameterCharacterisation_ParameterUsage = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ParameterPackage.Literals.PARAMETER_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getParameter_ParameterUsage() {
		if (parameter_ParameterUsage != null && parameter_ParameterUsage.eIsProxy()) {
			InternalEObject oldParameter_ParameterUsage = (InternalEObject)parameter_ParameterUsage;
			parameter_ParameterUsage = (Parameter)eResolveProxy(oldParameter_ParameterUsage);
			if (parameter_ParameterUsage != oldParameter_ParameterUsage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ParameterPackage.PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE, oldParameter_ParameterUsage, parameter_ParameterUsage));
			}
		}
		return parameter_ParameterUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetParameter_ParameterUsage() {
		return parameter_ParameterUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter_ParameterUsage(Parameter newParameter_ParameterUsage) {
		Parameter oldParameter_ParameterUsage = parameter_ParameterUsage;
		parameter_ParameterUsage = newParameter_ParameterUsage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE, oldParameter_ParameterUsage, parameter_ParameterUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParameterCharacterisation_ParameterUsage() {
		if (parameterCharacterisation_ParameterUsage == null) {
			parameterCharacterisation_ParameterUsage = new EObjectContainmentEList(PrimitiveParameterCharacterisation.class, this, ParameterPackage.PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE);
		}
		return parameterCharacterisation_ParameterUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParameterPackage.PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE:
				return ((InternalEList)getParameterCharacterisation_ParameterUsage()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParameterPackage.PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE:
				if (resolve) return getParameter_ParameterUsage();
				return basicGetParameter_ParameterUsage();
			case ParameterPackage.PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE:
				return getParameterCharacterisation_ParameterUsage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ParameterPackage.PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE:
				setParameter_ParameterUsage((Parameter)newValue);
				return;
			case ParameterPackage.PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE:
				getParameterCharacterisation_ParameterUsage().clear();
				getParameterCharacterisation_ParameterUsage().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ParameterPackage.PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE:
				setParameter_ParameterUsage((Parameter)null);
				return;
			case ParameterPackage.PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE:
				getParameterCharacterisation_ParameterUsage().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ParameterPackage.PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE:
				return parameter_ParameterUsage != null;
			case ParameterPackage.PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE:
				return parameterCharacterisation_ParameterUsage != null && !parameterCharacterisation_ParameterUsage.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ParameterUsageImpl