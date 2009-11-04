/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qo SAnnotations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.impl.QoSAnnotationsImpl#getSpecifiedQoSAnnotations_QoSAnnotations <em>Specified Qo SAnnotations Qo SAnnotations</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.impl.QoSAnnotationsImpl#getSpecifiedOutputParameterAbstractions_QoSAnnotations <em>Specified Output Parameter Abstractions Qo SAnnotations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QoSAnnotationsImpl extends EntityImpl implements QoSAnnotations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, Karlsruhe Institute of Technology / University of Karlsruhe, Germany and SE, FZI Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getSpecifiedQoSAnnotations_QoSAnnotations() <em>Specified Qo SAnnotations Qo SAnnotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifiedQoSAnnotations_QoSAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecifiedQoSAnnotation> specifiedQoSAnnotations_QoSAnnotations;

	/**
	 * The cached value of the '{@link #getSpecifiedOutputParameterAbstractions_QoSAnnotations() <em>Specified Output Parameter Abstractions Qo SAnnotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecifiedOutputParameterAbstractions_QoSAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecifiedOutputParameterAbstraction> specifiedOutputParameterAbstractions_QoSAnnotations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QoSAnnotationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QosannotationsPackage.Literals.QO_SANNOTATIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SpecifiedQoSAnnotation> getSpecifiedQoSAnnotations_QoSAnnotations() {
		if (specifiedQoSAnnotations_QoSAnnotations == null) {
			specifiedQoSAnnotations_QoSAnnotations = new EObjectContainmentEList<SpecifiedQoSAnnotation>(SpecifiedQoSAnnotation.class, this, QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS);
		}
		return specifiedQoSAnnotations_QoSAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SpecifiedOutputParameterAbstraction> getSpecifiedOutputParameterAbstractions_QoSAnnotations() {
		if (specifiedOutputParameterAbstractions_QoSAnnotations == null) {
			specifiedOutputParameterAbstractions_QoSAnnotations = new EObjectContainmentEList<SpecifiedOutputParameterAbstraction>(SpecifiedOutputParameterAbstraction.class, this, QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS);
		}
		return specifiedOutputParameterAbstractions_QoSAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS:
				return ((InternalEList<?>)getSpecifiedQoSAnnotations_QoSAnnotations()).basicRemove(otherEnd, msgs);
			case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS:
				return ((InternalEList<?>)getSpecifiedOutputParameterAbstractions_QoSAnnotations()).basicRemove(otherEnd, msgs);
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
			case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS:
				return getSpecifiedQoSAnnotations_QoSAnnotations();
			case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS:
				return getSpecifiedOutputParameterAbstractions_QoSAnnotations();
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
			case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS:
				getSpecifiedQoSAnnotations_QoSAnnotations().clear();
				getSpecifiedQoSAnnotations_QoSAnnotations().addAll((Collection<? extends SpecifiedQoSAnnotation>)newValue);
				return;
			case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS:
				getSpecifiedOutputParameterAbstractions_QoSAnnotations().clear();
				getSpecifiedOutputParameterAbstractions_QoSAnnotations().addAll((Collection<? extends SpecifiedOutputParameterAbstraction>)newValue);
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
			case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS:
				getSpecifiedQoSAnnotations_QoSAnnotations().clear();
				return;
			case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS:
				getSpecifiedOutputParameterAbstractions_QoSAnnotations().clear();
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
			case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_QO_SANNOTATIONS_QO_SANNOTATIONS:
				return specifiedQoSAnnotations_QoSAnnotations != null && !specifiedQoSAnnotations_QoSAnnotations.isEmpty();
			case QosannotationsPackage.QO_SANNOTATIONS__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTIONS_QO_SANNOTATIONS:
				return specifiedOutputParameterAbstractions_QoSAnnotations != null && !specifiedOutputParameterAbstractions_QoSAnnotations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //QoSAnnotationsImpl
