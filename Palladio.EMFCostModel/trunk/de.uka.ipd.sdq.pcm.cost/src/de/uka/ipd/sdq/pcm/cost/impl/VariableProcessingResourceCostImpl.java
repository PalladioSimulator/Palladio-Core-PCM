/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.costPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Processing Resource Cost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.VariableProcessingResourceCostImpl#getProcessingRateInitialFactor <em>Processing Rate Initial Factor</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.VariableProcessingResourceCostImpl#getProcessingRateOperatingFactor <em>Processing Rate Operating Factor</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.VariableProcessingResourceCostImpl#getProcessingresourcespecification <em>Processingresourcespecification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableProcessingResourceCostImpl extends VariableCostImpl implements VariableProcessingResourceCost {
	/**
	 * The default value of the '{@link #getProcessingRateInitialFactor() <em>Processing Rate Initial Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingRateInitialFactor()
	 * @generated
	 * @ordered
	 */
	protected static final double PROCESSING_RATE_INITIAL_FACTOR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProcessingRateInitialFactor() <em>Processing Rate Initial Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingRateInitialFactor()
	 * @generated
	 * @ordered
	 */
	protected double processingRateInitialFactor = PROCESSING_RATE_INITIAL_FACTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcessingRateOperatingFactor() <em>Processing Rate Operating Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingRateOperatingFactor()
	 * @generated
	 * @ordered
	 */
	protected static final double PROCESSING_RATE_OPERATING_FACTOR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProcessingRateOperatingFactor() <em>Processing Rate Operating Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingRateOperatingFactor()
	 * @generated
	 * @ordered
	 */
	protected double processingRateOperatingFactor = PROCESSING_RATE_OPERATING_FACTOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProcessingresourcespecification() <em>Processingresourcespecification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingresourcespecification()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResourceSpecification processingresourcespecification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableProcessingResourceCostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return costPackage.Literals.VARIABLE_PROCESSING_RESOURCE_COST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProcessingRateInitialFactor() {
		return processingRateInitialFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingRateInitialFactor(double newProcessingRateInitialFactor) {
		double oldProcessingRateInitialFactor = processingRateInitialFactor;
		processingRateInitialFactor = newProcessingRateInitialFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FACTOR, oldProcessingRateInitialFactor, processingRateInitialFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProcessingRateOperatingFactor() {
		return processingRateOperatingFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingRateOperatingFactor(double newProcessingRateOperatingFactor) {
		double oldProcessingRateOperatingFactor = processingRateOperatingFactor;
		processingRateOperatingFactor = newProcessingRateOperatingFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FACTOR, oldProcessingRateOperatingFactor, processingRateOperatingFactor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification getProcessingresourcespecification() {
		if (processingresourcespecification != null && processingresourcespecification.eIsProxy()) {
			InternalEObject oldProcessingresourcespecification = (InternalEObject)processingresourcespecification;
			processingresourcespecification = (ProcessingResourceSpecification)eResolveProxy(oldProcessingresourcespecification);
			if (processingresourcespecification != oldProcessingresourcespecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION, oldProcessingresourcespecification, processingresourcespecification));
			}
		}
		return processingresourcespecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification basicGetProcessingresourcespecification() {
		return processingresourcespecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingresourcespecification(ProcessingResourceSpecification newProcessingresourcespecification) {
		ProcessingResourceSpecification oldProcessingresourcespecification = processingresourcespecification;
		processingresourcespecification = newProcessingresourcespecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION, oldProcessingresourcespecification, processingresourcespecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FACTOR:
				return new Double(getProcessingRateInitialFactor());
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FACTOR:
				return new Double(getProcessingRateOperatingFactor());
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				if (resolve) return getProcessingresourcespecification();
				return basicGetProcessingresourcespecification();
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
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FACTOR:
				setProcessingRateInitialFactor(((Double)newValue).doubleValue());
				return;
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FACTOR:
				setProcessingRateOperatingFactor(((Double)newValue).doubleValue());
				return;
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				setProcessingresourcespecification((ProcessingResourceSpecification)newValue);
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
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FACTOR:
				setProcessingRateInitialFactor(PROCESSING_RATE_INITIAL_FACTOR_EDEFAULT);
				return;
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FACTOR:
				setProcessingRateOperatingFactor(PROCESSING_RATE_OPERATING_FACTOR_EDEFAULT);
				return;
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				setProcessingresourcespecification((ProcessingResourceSpecification)null);
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
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FACTOR:
				return processingRateInitialFactor != PROCESSING_RATE_INITIAL_FACTOR_EDEFAULT;
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FACTOR:
				return processingRateOperatingFactor != PROCESSING_RATE_OPERATING_FACTOR_EDEFAULT;
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				return processingresourcespecification != null;
		}
		return super.eIsSet(featureID);
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
		result.append(" (processingRateInitialFactor: ");
		result.append(processingRateInitialFactor);
		result.append(", processingRateOperatingFactor: ");
		result.append(processingRateOperatingFactor);
		result.append(')');
		return result.toString();
	}

	@Override
	public double getOperatingCost() {
		// TODO Auto-generated method stub
		return 0;
	}

} //VariableProcessingResourceCostImpl
