
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import de.uka.ipd.sdq.stoex.AbstractNamedReference;

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
 * An implementation of the model object '<em><b>Variable Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getVariableCharacterisation_VariableUsage <em>Variable Characterisation Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.VariableUsageImpl#getNamedReference_VariableUsage <em>Named Reference Variable Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableUsageImpl extends EObjectImpl implements VariableUsage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getVariableCharacterisation_VariableUsage() <em>Variable Characterisation Variable Usage</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableCharacterisation_VariableUsage()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableCharacterisation> variableCharacterisation_VariableUsage;

	/**
	 * The cached value of the '{@link #getNamedReference_VariableUsage() <em>Named Reference Variable Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedReference_VariableUsage()
	 * @generated
	 * @ordered
	 */
	protected AbstractNamedReference namedReference_VariableUsage;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParameterPackage.Literals.VARIABLE_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableCharacterisation> getVariableCharacterisation_VariableUsage() {
		if (variableCharacterisation_VariableUsage == null) {
			variableCharacterisation_VariableUsage = new EObjectContainmentEList<VariableCharacterisation>(VariableCharacterisation.class, this, ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE);
		}
		return variableCharacterisation_VariableUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNamedReference getNamedReference_VariableUsage() {
		return namedReference_VariableUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNamedReference_VariableUsage(AbstractNamedReference newNamedReference_VariableUsage, NotificationChain msgs) {
		AbstractNamedReference oldNamedReference_VariableUsage = namedReference_VariableUsage;
		namedReference_VariableUsage = newNamedReference_VariableUsage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE, oldNamedReference_VariableUsage, newNamedReference_VariableUsage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamedReference_VariableUsage(AbstractNamedReference newNamedReference_VariableUsage) {
		if (newNamedReference_VariableUsage != namedReference_VariableUsage) {
			NotificationChain msgs = null;
			if (namedReference_VariableUsage != null)
				msgs = ((InternalEObject)namedReference_VariableUsage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE, null, msgs);
			if (newNamedReference_VariableUsage != null)
				msgs = ((InternalEObject)newNamedReference_VariableUsage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE, null, msgs);
			msgs = basicSetNamedReference_VariableUsage(newNamedReference_VariableUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE, newNamedReference_VariableUsage, newNamedReference_VariableUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
				return ((InternalEList<?>)getVariableCharacterisation_VariableUsage()).basicRemove(otherEnd, msgs);
			case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
				return basicSetNamedReference_VariableUsage(null, msgs);
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
			case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
				return getVariableCharacterisation_VariableUsage();
			case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
				return getNamedReference_VariableUsage();
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
			case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
				getVariableCharacterisation_VariableUsage().clear();
				getVariableCharacterisation_VariableUsage().addAll((Collection<? extends VariableCharacterisation>)newValue);
				return;
			case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
				setNamedReference_VariableUsage((AbstractNamedReference)newValue);
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
			case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
				getVariableCharacterisation_VariableUsage().clear();
				return;
			case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
				setNamedReference_VariableUsage((AbstractNamedReference)null);
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
			case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
				return variableCharacterisation_VariableUsage != null && !variableCharacterisation_VariableUsage.isEmpty();
			case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
				return namedReference_VariableUsage != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableUsageImpl
