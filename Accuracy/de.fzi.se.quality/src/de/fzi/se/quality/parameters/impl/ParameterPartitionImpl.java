/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.quality.qualityannotation.QualityAnnotation;
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
 * An implementation of the model object '<em><b>Parameter Partition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ParameterPartitionImpl#getQualityAnnotation <em>Quality Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterPartitionImpl extends IdentifierImpl implements ParameterPartition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParametersPackage.Literals.PARAMETER_PARTITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityAnnotation getQualityAnnotation() {
		if (eContainerFeatureID() != ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION) return null;
		return (QualityAnnotation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQualityAnnotation(QualityAnnotation newQualityAnnotation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newQualityAnnotation, ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualityAnnotation(QualityAnnotation newQualityAnnotation) {
		if (newQualityAnnotation != eInternalContainer() || (eContainerFeatureID() != ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION && newQualityAnnotation != null)) {
			if (EcoreUtil.isAncestor(this, newQualityAnnotation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newQualityAnnotation != null)
				msgs = ((InternalEObject)newQualityAnnotation).eInverseAdd(this, QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS, QualityAnnotation.class, msgs);
			msgs = basicSetQualityAnnotation(newQualityAnnotation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION, newQualityAnnotation, newQualityAnnotation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetQualityAnnotation((QualityAnnotation)otherEnd, msgs);
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
			case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
				return basicSetQualityAnnotation(null, msgs);
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
			case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
				return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS, QualityAnnotation.class, msgs);
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
			case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
				return getQualityAnnotation();
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
			case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
				setQualityAnnotation((QualityAnnotation)newValue);
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
			case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
				setQualityAnnotation((QualityAnnotation)null);
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
			case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
				return getQualityAnnotation() != null;
		}
		return super.eIsSet(featureID);
	}

} //ParameterPartitionImpl
