
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterUsage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Parameter Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.CollectionParameterUsageImpl#getInnerElement_ParameterUsage <em>Inner Element Parameter Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.CollectionParameterUsageImpl#getParameterCharacterisation_CollectionParameterUsage <em>Parameter Characterisation Collection Parameter Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionParameterUsageImpl extends ParameterUsageImpl implements CollectionParameterUsage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getInnerElement_ParameterUsage() <em>Inner Element Parameter Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerElement_ParameterUsage()
	 * @generated
	 * @ordered
	 */
	protected ParameterUsage innerElement_ParameterUsage = null;

	/**
	 * The cached value of the '{@link #getParameterCharacterisation_CollectionParameterUsage() <em>Parameter Characterisation Collection Parameter Usage</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterCharacterisation_CollectionParameterUsage()
	 * @generated
	 * @ordered
	 */
	protected EList parameterCharacterisation_CollectionParameterUsage = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionParameterUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ParameterPackage.Literals.COLLECTION_PARAMETER_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterUsage getInnerElement_ParameterUsage() {
		return innerElement_ParameterUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInnerElement_ParameterUsage(ParameterUsage newInnerElement_ParameterUsage, NotificationChain msgs) {
		ParameterUsage oldInnerElement_ParameterUsage = innerElement_ParameterUsage;
		innerElement_ParameterUsage = newInnerElement_ParameterUsage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParameterPackage.COLLECTION_PARAMETER_USAGE__INNER_ELEMENT_PARAMETER_USAGE, oldInnerElement_ParameterUsage, newInnerElement_ParameterUsage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerElement_ParameterUsage(ParameterUsage newInnerElement_ParameterUsage) {
		if (newInnerElement_ParameterUsage != innerElement_ParameterUsage) {
			NotificationChain msgs = null;
			if (innerElement_ParameterUsage != null)
				msgs = ((InternalEObject)innerElement_ParameterUsage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParameterPackage.COLLECTION_PARAMETER_USAGE__INNER_ELEMENT_PARAMETER_USAGE, null, msgs);
			if (newInnerElement_ParameterUsage != null)
				msgs = ((InternalEObject)newInnerElement_ParameterUsage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParameterPackage.COLLECTION_PARAMETER_USAGE__INNER_ELEMENT_PARAMETER_USAGE, null, msgs);
			msgs = basicSetInnerElement_ParameterUsage(newInnerElement_ParameterUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.COLLECTION_PARAMETER_USAGE__INNER_ELEMENT_PARAMETER_USAGE, newInnerElement_ParameterUsage, newInnerElement_ParameterUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParameterCharacterisation_CollectionParameterUsage() {
		if (parameterCharacterisation_CollectionParameterUsage == null) {
			parameterCharacterisation_CollectionParameterUsage = new EObjectContainmentEList(CollectionParameterCharacterisation.class, this, ParameterPackage.COLLECTION_PARAMETER_USAGE__PARAMETER_CHARACTERISATION_COLLECTION_PARAMETER_USAGE);
		}
		return parameterCharacterisation_CollectionParameterUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParameterPackage.COLLECTION_PARAMETER_USAGE__INNER_ELEMENT_PARAMETER_USAGE:
				return basicSetInnerElement_ParameterUsage(null, msgs);
			case ParameterPackage.COLLECTION_PARAMETER_USAGE__PARAMETER_CHARACTERISATION_COLLECTION_PARAMETER_USAGE:
				return ((InternalEList)getParameterCharacterisation_CollectionParameterUsage()).basicRemove(otherEnd, msgs);
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
			case ParameterPackage.COLLECTION_PARAMETER_USAGE__INNER_ELEMENT_PARAMETER_USAGE:
				return getInnerElement_ParameterUsage();
			case ParameterPackage.COLLECTION_PARAMETER_USAGE__PARAMETER_CHARACTERISATION_COLLECTION_PARAMETER_USAGE:
				return getParameterCharacterisation_CollectionParameterUsage();
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
			case ParameterPackage.COLLECTION_PARAMETER_USAGE__INNER_ELEMENT_PARAMETER_USAGE:
				setInnerElement_ParameterUsage((ParameterUsage)newValue);
				return;
			case ParameterPackage.COLLECTION_PARAMETER_USAGE__PARAMETER_CHARACTERISATION_COLLECTION_PARAMETER_USAGE:
				getParameterCharacterisation_CollectionParameterUsage().clear();
				getParameterCharacterisation_CollectionParameterUsage().addAll((Collection)newValue);
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
			case ParameterPackage.COLLECTION_PARAMETER_USAGE__INNER_ELEMENT_PARAMETER_USAGE:
				setInnerElement_ParameterUsage((ParameterUsage)null);
				return;
			case ParameterPackage.COLLECTION_PARAMETER_USAGE__PARAMETER_CHARACTERISATION_COLLECTION_PARAMETER_USAGE:
				getParameterCharacterisation_CollectionParameterUsage().clear();
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
			case ParameterPackage.COLLECTION_PARAMETER_USAGE__INNER_ELEMENT_PARAMETER_USAGE:
				return innerElement_ParameterUsage != null;
			case ParameterPackage.COLLECTION_PARAMETER_USAGE__PARAMETER_CHARACTERISATION_COLLECTION_PARAMETER_USAGE:
				return parameterCharacterisation_CollectionParameterUsage != null && !parameterCharacterisation_CollectionParameterUsage.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CollectionParameterUsageImpl