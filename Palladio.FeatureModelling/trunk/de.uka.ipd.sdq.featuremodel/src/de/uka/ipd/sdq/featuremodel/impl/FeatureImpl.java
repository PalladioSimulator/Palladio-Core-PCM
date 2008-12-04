/**
 * Copyright 2007-2008, SDQ, IPD, U Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.impl;

import de.uka.ipd.sdq.featuremodel.Attribute;
import de.uka.ipd.sdq.featuremodel.ChildRelation;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

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
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getChildrelation <em>Childrelation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends NamedElementImpl implements Feature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007-2008, SDQ, IPD, U Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getChildrelation() <em>Childrelation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrelation()
	 * @generated
	 * @ordered
	 */
	protected ChildRelation childrelation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featuremodelPackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, featuremodelPackage.FEATURE__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChildRelation getChildrelation() {
		return childrelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChildrelation(ChildRelation newChildrelation, NotificationChain msgs) {
		ChildRelation oldChildrelation = childrelation;
		childrelation = newChildrelation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, featuremodelPackage.FEATURE__CHILDRELATION, oldChildrelation, newChildrelation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildrelation(ChildRelation newChildrelation) {
		if (newChildrelation != childrelation) {
			NotificationChain msgs = null;
			if (childrelation != null)
				msgs = ((InternalEObject)childrelation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - featuremodelPackage.FEATURE__CHILDRELATION, null, msgs);
			if (newChildrelation != null)
				msgs = ((InternalEObject)newChildrelation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - featuremodelPackage.FEATURE__CHILDRELATION, null, msgs);
			msgs = basicSetChildrelation(newChildrelation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.FEATURE__CHILDRELATION, newChildrelation, newChildrelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case featuremodelPackage.FEATURE__CHILDRELATION:
				return basicSetChildrelation(null, msgs);
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
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				return getAttributes();
			case featuremodelPackage.FEATURE__CHILDRELATION:
				return getChildrelation();
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
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case featuremodelPackage.FEATURE__CHILDRELATION:
				setChildrelation((ChildRelation)newValue);
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
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				getAttributes().clear();
				return;
			case featuremodelPackage.FEATURE__CHILDRELATION:
				setChildrelation((ChildRelation)null);
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
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case featuremodelPackage.FEATURE__CHILDRELATION:
				return childrelation != null;
		}
		return super.eIsSet(featureID);
	}

} //FeatureImpl
