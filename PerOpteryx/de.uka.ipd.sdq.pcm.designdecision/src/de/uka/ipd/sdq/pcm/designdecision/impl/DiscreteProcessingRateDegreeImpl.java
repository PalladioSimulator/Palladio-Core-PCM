/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Discrete Processing Rate Degree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteProcessingRateDegreeImpl#getProcessingresourcetype <em>Processingresourcetype</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteProcessingRateDegreeImpl#getNumberOfSteps <em>Number Of Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DiscreteProcessingRateDegreeImpl extends DiscreteRangeDegreeImpl implements DiscreteProcessingRateDegree {
	/**
	 * The cached value of the '{@link #getProcessingresourcetype() <em>Processingresourcetype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingresourcetype()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResourceType processingresourcetype;

	/**
	 * The default value of the '{@link #getNumberOfSteps() <em>Number Of Steps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfSteps()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_STEPS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberOfSteps() <em>Number Of Steps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberOfSteps()
	 * @generated
	 * @ordered
	 */
	protected int numberOfSteps = NUMBER_OF_STEPS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiscreteProcessingRateDegreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.DISCRETE_PROCESSING_RATE_DEGREE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceType getProcessingresourcetype() {
		if (processingresourcetype != null && processingresourcetype.eIsProxy()) {
			InternalEObject oldProcessingresourcetype = (InternalEObject)processingresourcetype;
			processingresourcetype = (ProcessingResourceType)eResolveProxy(oldProcessingresourcetype);
			if (processingresourcetype != oldProcessingresourcetype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__PROCESSINGRESOURCETYPE, oldProcessingresourcetype, processingresourcetype));
			}
		}
		return processingresourcetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceType basicGetProcessingresourcetype() {
		return processingresourcetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingresourcetype(ProcessingResourceType newProcessingresourcetype) {
		ProcessingResourceType oldProcessingresourcetype = processingresourcetype;
		processingresourcetype = newProcessingresourcetype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__PROCESSINGRESOURCETYPE, oldProcessingresourcetype, processingresourcetype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfSteps() {
		return numberOfSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfSteps(int newNumberOfSteps) {
		int oldNumberOfSteps = numberOfSteps;
		numberOfSteps = newNumberOfSteps;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__NUMBER_OF_STEPS, oldNumberOfSteps, numberOfSteps));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__PROCESSINGRESOURCETYPE:
				if (resolve) return getProcessingresourcetype();
				return basicGetProcessingresourcetype();
			case designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__NUMBER_OF_STEPS:
				return getNumberOfSteps();
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
			case designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__PROCESSINGRESOURCETYPE:
				setProcessingresourcetype((ProcessingResourceType)newValue);
				return;
			case designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__NUMBER_OF_STEPS:
				setNumberOfSteps((Integer)newValue);
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
			case designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__PROCESSINGRESOURCETYPE:
				setProcessingresourcetype((ProcessingResourceType)null);
				return;
			case designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__NUMBER_OF_STEPS:
				setNumberOfSteps(NUMBER_OF_STEPS_EDEFAULT);
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
			case designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__PROCESSINGRESOURCETYPE:
				return processingresourcetype != null;
			case designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__NUMBER_OF_STEPS:
				return numberOfSteps != NUMBER_OF_STEPS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ProcessingResourceDegree.class) {
			switch (derivedFeatureID) {
				case designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__PROCESSINGRESOURCETYPE: return designdecisionPackage.PROCESSING_RESOURCE_DEGREE__PROCESSINGRESOURCETYPE;
				default: return -1;
			}
		}
		if (baseClass == ProcessingRateDegree.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ProcessingResourceDegree.class) {
			switch (baseFeatureID) {
				case designdecisionPackage.PROCESSING_RESOURCE_DEGREE__PROCESSINGRESOURCETYPE: return designdecisionPackage.DISCRETE_PROCESSING_RATE_DEGREE__PROCESSINGRESOURCETYPE;
				default: return -1;
			}
		}
		if (baseClass == ProcessingRateDegree.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (numberOfSteps: ");
		result.append(numberOfSteps);
		result.append(')');
		return result.toString();
	}

} //DiscreteProcessingRateDegreeImpl
