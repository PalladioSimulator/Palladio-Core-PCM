/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Passive Resource Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.PassiveResourceResultImpl#getPassiveResource_PassiveResourceResult <em>Passive Resource Passive Resource Result</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.PassiveResourceResultImpl#getAssemblyContext_PassiveResourceResult <em>Assembly Context Passive Resource Result</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.PassiveResourceResultImpl#getAverageHoldingTime <em>Average Holding Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PassiveResourceResultImpl extends UtilisationResultImpl implements PassiveResourceResult {
	/**
	 * The cached value of the '{@link #getPassiveResource_PassiveResourceResult() <em>Passive Resource Passive Resource Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPassiveResource_PassiveResourceResult()
	 * @generated
	 * @ordered
	 */
	protected PassiveResource passiveResource_PassiveResourceResult;
	/**
	 * The cached value of the '{@link #getAssemblyContext_PassiveResourceResult() <em>Assembly Context Passive Resource Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContext_PassiveResourceResult()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblyContext_PassiveResourceResult;
	/**
	 * The default value of the '{@link #getAverageHoldingTime() <em>Average Holding Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageHoldingTime()
	 * @generated
	 * @ordered
	 */
	protected static final double AVERAGE_HOLDING_TIME_EDEFAULT = 0.0;
	/**
	 * The cached value of the '{@link #getAverageHoldingTime() <em>Average Holding Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAverageHoldingTime()
	 * @generated
	 * @ordered
	 */
	protected double averageHoldingTime = AVERAGE_HOLDING_TIME_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PassiveResourceResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentdecoratorPackage.Literals.PASSIVE_RESOURCE_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResource getPassiveResource_PassiveResourceResult() {
		if (passiveResource_PassiveResourceResult != null && passiveResource_PassiveResourceResult.eIsProxy()) {
			InternalEObject oldPassiveResource_PassiveResourceResult = (InternalEObject)passiveResource_PassiveResourceResult;
			passiveResource_PassiveResourceResult = (PassiveResource)eResolveProxy(oldPassiveResource_PassiveResourceResult);
			if (passiveResource_PassiveResourceResult != oldPassiveResource_PassiveResourceResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT, oldPassiveResource_PassiveResourceResult, passiveResource_PassiveResourceResult));
			}
		}
		return passiveResource_PassiveResourceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResource basicGetPassiveResource_PassiveResourceResult() {
		return passiveResource_PassiveResourceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPassiveResource_PassiveResourceResult(PassiveResource newPassiveResource_PassiveResourceResult) {
		PassiveResource oldPassiveResource_PassiveResourceResult = passiveResource_PassiveResourceResult;
		passiveResource_PassiveResourceResult = newPassiveResource_PassiveResourceResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT, oldPassiveResource_PassiveResourceResult, passiveResource_PassiveResourceResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext_PassiveResourceResult() {
		if (assemblyContext_PassiveResourceResult != null && assemblyContext_PassiveResourceResult.eIsProxy()) {
			InternalEObject oldAssemblyContext_PassiveResourceResult = (InternalEObject)assemblyContext_PassiveResourceResult;
			assemblyContext_PassiveResourceResult = (AssemblyContext)eResolveProxy(oldAssemblyContext_PassiveResourceResult);
			if (assemblyContext_PassiveResourceResult != oldAssemblyContext_PassiveResourceResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT, oldAssemblyContext_PassiveResourceResult, assemblyContext_PassiveResourceResult));
			}
		}
		return assemblyContext_PassiveResourceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext_PassiveResourceResult() {
		return assemblyContext_PassiveResourceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext_PassiveResourceResult(AssemblyContext newAssemblyContext_PassiveResourceResult) {
		AssemblyContext oldAssemblyContext_PassiveResourceResult = assemblyContext_PassiveResourceResult;
		assemblyContext_PassiveResourceResult = newAssemblyContext_PassiveResourceResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT, oldAssemblyContext_PassiveResourceResult, assemblyContext_PassiveResourceResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAverageHoldingTime() {
		return averageHoldingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAverageHoldingTime(double newAverageHoldingTime) {
		double oldAverageHoldingTime = averageHoldingTime;
		averageHoldingTime = newAverageHoldingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME, oldAverageHoldingTime, averageHoldingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT:
				if (resolve) return getPassiveResource_PassiveResourceResult();
				return basicGetPassiveResource_PassiveResourceResult();
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT:
				if (resolve) return getAssemblyContext_PassiveResourceResult();
				return basicGetAssemblyContext_PassiveResourceResult();
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME:
				return getAverageHoldingTime();
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
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT:
				setPassiveResource_PassiveResourceResult((PassiveResource)newValue);
				return;
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT:
				setAssemblyContext_PassiveResourceResult((AssemblyContext)newValue);
				return;
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME:
				setAverageHoldingTime((Double)newValue);
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
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT:
				setPassiveResource_PassiveResourceResult((PassiveResource)null);
				return;
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT:
				setAssemblyContext_PassiveResourceResult((AssemblyContext)null);
				return;
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME:
				setAverageHoldingTime(AVERAGE_HOLDING_TIME_EDEFAULT);
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
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT:
				return passiveResource_PassiveResourceResult != null;
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT:
				return assemblyContext_PassiveResourceResult != null;
			case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME:
				return averageHoldingTime != AVERAGE_HOLDING_TIME_EDEFAULT;
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
		result.append(" (averageHoldingTime: ");
		result.append(averageHoldingTime);
		result.append(')');
		return result.toString();
	}

} //PassiveResourceResultImpl
