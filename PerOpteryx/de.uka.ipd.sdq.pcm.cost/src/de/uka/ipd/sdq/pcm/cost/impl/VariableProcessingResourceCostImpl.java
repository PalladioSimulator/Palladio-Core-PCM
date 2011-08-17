/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import de.uka.ipd.sdq.pcm.cost.ProcessingResourceCost;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.cost.ScalarFunction;
import de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.costPackage;
import de.uka.ipd.sdq.pcm.cost.helper.CostUtil;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Processing Resource Cost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.VariableProcessingResourceCostImpl#getProcessingresourcespecification <em>Processingresourcespecification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.VariableProcessingResourceCostImpl#getProcessingRateInitialFunction <em>Processing Rate Initial Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.VariableProcessingResourceCostImpl#getProcessingRateOperatingFunction <em>Processing Rate Operating Function</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableProcessingResourceCostImpl extends VariableCostImpl implements VariableProcessingResourceCost {
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
	 * The cached value of the '{@link #getProcessingRateInitialFunction() <em>Processing Rate Initial Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingRateInitialFunction()
	 * @generated
	 * @ordered
	 */
	protected ScalarFunction processingRateInitialFunction;

	/**
	 * The cached value of the '{@link #getProcessingRateOperatingFunction() <em>Processing Rate Operating Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingRateOperatingFunction()
	 * @generated
	 * @ordered
	 */
	protected ScalarFunction processingRateOperatingFunction;

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
	public ScalarFunction getProcessingRateInitialFunction() {
		return processingRateInitialFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcessingRateInitialFunction(ScalarFunction newProcessingRateInitialFunction, NotificationChain msgs) {
		ScalarFunction oldProcessingRateInitialFunction = processingRateInitialFunction;
		processingRateInitialFunction = newProcessingRateInitialFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION, oldProcessingRateInitialFunction, newProcessingRateInitialFunction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingRateInitialFunction(ScalarFunction newProcessingRateInitialFunction) {
		if (newProcessingRateInitialFunction != processingRateInitialFunction) {
			NotificationChain msgs = null;
			if (processingRateInitialFunction != null)
				msgs = ((InternalEObject)processingRateInitialFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION, null, msgs);
			if (newProcessingRateInitialFunction != null)
				msgs = ((InternalEObject)newProcessingRateInitialFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION, null, msgs);
			msgs = basicSetProcessingRateInitialFunction(newProcessingRateInitialFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION, newProcessingRateInitialFunction, newProcessingRateInitialFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScalarFunction getProcessingRateOperatingFunction() {
		return processingRateOperatingFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcessingRateOperatingFunction(ScalarFunction newProcessingRateOperatingFunction, NotificationChain msgs) {
		ScalarFunction oldProcessingRateOperatingFunction = processingRateOperatingFunction;
		processingRateOperatingFunction = newProcessingRateOperatingFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION, oldProcessingRateOperatingFunction, newProcessingRateOperatingFunction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingRateOperatingFunction(ScalarFunction newProcessingRateOperatingFunction) {
		if (newProcessingRateOperatingFunction != processingRateOperatingFunction) {
			NotificationChain msgs = null;
			if (processingRateOperatingFunction != null)
				msgs = ((InternalEObject)processingRateOperatingFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION, null, msgs);
			if (newProcessingRateOperatingFunction != null)
				msgs = ((InternalEObject)newProcessingRateOperatingFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION, null, msgs);
			msgs = basicSetProcessingRateOperatingFunction(newProcessingRateOperatingFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION, newProcessingRateOperatingFunction, newProcessingRateOperatingFunction));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION:
				return basicSetProcessingRateInitialFunction(null, msgs);
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION:
				return basicSetProcessingRateOperatingFunction(null, msgs);
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
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				if (resolve) return getProcessingresourcespecification();
				return basicGetProcessingresourcespecification();
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION:
				return getProcessingRateInitialFunction();
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION:
				return getProcessingRateOperatingFunction();
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
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				setProcessingresourcespecification((ProcessingResourceSpecification)newValue);
				return;
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION:
				setProcessingRateInitialFunction((ScalarFunction)newValue);
				return;
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION:
				setProcessingRateOperatingFunction((ScalarFunction)newValue);
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
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				setProcessingresourcespecification((ProcessingResourceSpecification)null);
				return;
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION:
				setProcessingRateInitialFunction((ScalarFunction)null);
				return;
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION:
				setProcessingRateOperatingFunction((ScalarFunction)null);
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
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION:
				return processingresourcespecification != null;
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION:
				return processingRateInitialFunction != null;
			case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION:
				return processingRateOperatingFunction != null;
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
		if (baseClass == ProcessingResourceCost.class) {
			switch (derivedFeatureID) {
				case costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION: return costPackage.PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION;
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
		if (baseClass == ProcessingResourceCost.class) {
			switch (baseFeatureID) {
				case costPackage.PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION: return costPackage.VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public double getOperatingCost() {
		return CostUtil.getInstance().getOperatingCost(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public double getInitialCost() {
		return CostUtil.getInstance().getInitialCost(this);
	}



	@Override
	public EObject basicGetAnnotatedElement() {
		return this.getProcessingresourcespecification();
	}

} //VariableProcessingResourceCostImpl
