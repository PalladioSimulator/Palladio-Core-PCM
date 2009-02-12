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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
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
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
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
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
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
			case costPackage.FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				return processingresourcespecification != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public double getOperatingCost() {
		// TODO Auto-generated method stub
		return 0;
	}

} //FixedProcessingResourceCostImpl
