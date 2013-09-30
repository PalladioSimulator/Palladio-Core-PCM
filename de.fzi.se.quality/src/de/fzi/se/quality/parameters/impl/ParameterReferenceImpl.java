/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import de.fzi.se.quality.parameters.ParameterInstance;
import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.CallParameterDeviation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ParameterReferenceImpl#getParameterPartition <em>Parameter Partition</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ParameterReferenceImpl#getParameterInstance <em>Parameter Instance</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ParameterReferenceImpl#getParameterValueDeviation <em>Parameter Value Deviation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterReferenceImpl extends IdentifierImpl implements ParameterReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParametersPackage.Literals.PARAMETER_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterPartition getParameterPartition() {
		if (eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION) return null;
		return (ParameterPartition)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterPartition(ParameterPartition newParameterPartition, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParameterPartition, ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterPartition(ParameterPartition newParameterPartition) {
		if (newParameterPartition != eInternalContainer() || (eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION && newParameterPartition != null)) {
			if (EcoreUtil.isAncestor(this, newParameterPartition))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParameterPartition != null)
				msgs = ((InternalEObject)newParameterPartition).eInverseAdd(this, ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE, ParameterPartition.class, msgs);
			msgs = basicSetParameterPartition(newParameterPartition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION, newParameterPartition, newParameterPartition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterInstance getParameterInstance() {
		if (eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE) return null;
		return (ParameterInstance)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterInstance(ParameterInstance newParameterInstance, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParameterInstance, ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterInstance(ParameterInstance newParameterInstance) {
		if (newParameterInstance != eInternalContainer() || (eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE && newParameterInstance != null)) {
			if (EcoreUtil.isAncestor(this, newParameterInstance))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParameterInstance != null)
				msgs = ((InternalEObject)newParameterInstance).eInverseAdd(this, ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, ParameterInstance.class, msgs);
			msgs = basicSetParameterInstance(newParameterInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE, newParameterInstance, newParameterInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterValueDeviation getParameterValueDeviation() {
		if (eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION) return null;
		return (ParameterValueDeviation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterValueDeviation(ParameterValueDeviation newParameterValueDeviation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParameterValueDeviation, ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterValueDeviation(ParameterValueDeviation newParameterValueDeviation) {
		if (newParameterValueDeviation != eInternalContainer() || (eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION && newParameterValueDeviation != null)) {
			if (EcoreUtil.isAncestor(this, newParameterValueDeviation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParameterValueDeviation != null)
				msgs = ((InternalEObject)newParameterValueDeviation).eInverseAdd(this, QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE, ParameterValueDeviation.class, msgs);
			msgs = basicSetParameterValueDeviation(newParameterValueDeviation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION, newParameterValueDeviation, newParameterValueDeviation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParameterPartition((ParameterPartition)otherEnd, msgs);
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParameterInstance((ParameterInstance)otherEnd, msgs);
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParameterValueDeviation((ParameterValueDeviation)otherEnd, msgs);
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
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
				return basicSetParameterPartition(null, msgs);
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				return basicSetParameterInstance(null, msgs);
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
				return basicSetParameterValueDeviation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
				return eInternalContainer().eInverseRemove(this, ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE, ParameterPartition.class, msgs);
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				return eInternalContainer().eInverseRemove(this, ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, ParameterInstance.class, msgs);
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
				return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE, ParameterValueDeviation.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
				return getParameterPartition();
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				return getParameterInstance();
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
				return getParameterValueDeviation();
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
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
				setParameterPartition((ParameterPartition)newValue);
				return;
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				setParameterInstance((ParameterInstance)newValue);
				return;
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
				setParameterValueDeviation((ParameterValueDeviation)newValue);
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
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
				setParameterPartition((ParameterPartition)null);
				return;
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				setParameterInstance((ParameterInstance)null);
				return;
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
				setParameterValueDeviation((ParameterValueDeviation)null);
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
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
				return getParameterPartition() != null;
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				return getParameterInstance() != null;
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
				return getParameterValueDeviation() != null;
		}
		return super.eIsSet(featureID);
	}

} //ParameterReferenceImpl
