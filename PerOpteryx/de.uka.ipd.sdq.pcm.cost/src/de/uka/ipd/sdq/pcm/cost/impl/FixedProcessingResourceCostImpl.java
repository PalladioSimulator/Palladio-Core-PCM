/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.costPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fixed Processing Resource Cost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.FixedProcessingResourceCostImpl#getProcessingresourcespecification <em>Processingresourcespecification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.FixedProcessingResourceCostImpl#getFixedOperatingCost <em>Fixed Operating Cost</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.FixedProcessingResourceCostImpl#getFixedInitialCost <em>Fixed Initial Cost</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FixedProcessingResourceCostImpl extends CostImpl implements FixedProcessingResourceCost {
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
	 * The default value of the '{@link #getFixedOperatingCost() <em>Fixed Operating Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedOperatingCost()
	 * @generated
	 * @ordered
	 */
	protected static final double FIXED_OPERATING_COST_EDEFAULT = 0.0;
	/**
	 * The cached value of the '{@link #getFixedOperatingCost() <em>Fixed Operating Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedOperatingCost()
	 * @generated
	 * @ordered
	 */
	protected double fixedOperatingCost = FIXED_OPERATING_COST_EDEFAULT;
	/**
	 * The default value of the '{@link #getFixedInitialCost() <em>Fixed Initial Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedInitialCost()
	 * @generated
	 * @ordered
	 */
	protected static final double FIXED_INITIAL_COST_EDEFAULT = 0.0;
	/**
	 * The cached value of the '{@link #getFixedInitialCost() <em>Fixed Initial Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedInitialCost()
	 * @generated
	 * @ordered
	 */
	protected double fixedInitialCost = FIXED_INITIAL_COST_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FixedProcessingResourceCostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return costPackage.Literals.FIXED_PROCESSING_RESOURCE_COST;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, costPackage.FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION, oldProcessingresourcespecification, processingresourcespecification));
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
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION, oldProcessingresourcespecification, processingresourcespecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFixedOperatingCost() {
		return fixedOperatingCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedOperatingCost(double newFixedOperatingCost) {
		double oldFixedOperatingCost = fixedOperatingCost;
		fixedOperatingCost = newFixedOperatingCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.FIXED_PROCESSING_RESOURCE_COST__FIXED_OPERATING_COST, oldFixedOperatingCost, fixedOperatingCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFixedInitialCost() {
		return fixedInitialCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedInitialCost(double newFixedInitialCost) {
		double oldFixedInitialCost = fixedInitialCost;
		fixedInitialCost = newFixedInitialCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.FIXED_PROCESSING_RESOURCE_COST__FIXED_INITIAL_COST, oldFixedInitialCost, fixedInitialCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				if (resolve) return getProcessingresourcespecification();
				return basicGetProcessingresourcespecification();
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__FIXED_OPERATING_COST:
				return getFixedOperatingCost();
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__FIXED_INITIAL_COST:
				return getFixedInitialCost();
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
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				setProcessingresourcespecification((ProcessingResourceSpecification)newValue);
				return;
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__FIXED_OPERATING_COST:
				setFixedOperatingCost((Double)newValue);
				return;
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__FIXED_INITIAL_COST:
				setFixedInitialCost((Double)newValue);
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
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				setProcessingresourcespecification((ProcessingResourceSpecification)null);
				return;
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__FIXED_OPERATING_COST:
				setFixedOperatingCost(FIXED_OPERATING_COST_EDEFAULT);
				return;
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__FIXED_INITIAL_COST:
				setFixedInitialCost(FIXED_INITIAL_COST_EDEFAULT);
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
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				return processingresourcespecification != null;
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__FIXED_OPERATING_COST:
				return fixedOperatingCost != FIXED_OPERATING_COST_EDEFAULT;
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__FIXED_INITIAL_COST:
				return fixedInitialCost != FIXED_INITIAL_COST_EDEFAULT;
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
		result.append(" (fixedOperatingCost: ");
		result.append(fixedOperatingCost);
		result.append(", fixedInitialCost: ");
		result.append(fixedInitialCost);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public double getOperatingCost() {
		return this.getFixedOperatingCost();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public double getInitialCost() {
		return this.getFixedInitialCost();
	}

	@Override
	public EObject basicGetAnnotatedElement() {
		return this.getProcessingresourcespecification();
	}

} //FixedProcessingResourceCostImpl
