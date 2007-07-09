
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import de.uka.ipd.sdq.pcm.repository.Signature;

import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Call Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl#getCalledService_ExternalService <em>Called Service External Service</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl#getParameterUsage_ExternalCallAction <em>Parameter Usage External Call Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl#getOutputVariableUsage_ExternalCallAction <em>Output Variable Usage External Call Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalCallActionImpl extends AbstractActionImpl implements ExternalCallAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getCalledService_ExternalService() <em>Called Service External Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCalledService_ExternalService()
	 * @generated
	 * @ordered
	 */
	protected Signature calledService_ExternalService;

	/**
	 * The cached value of the '{@link #getParameterUsage_ExternalCallAction() <em>Parameter Usage External Call Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterUsage_ExternalCallAction()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableUsage> parameterUsage_ExternalCallAction;


	/**
	 * The cached value of the '{@link #getOutputVariableUsage_ExternalCallAction() <em>Output Variable Usage External Call Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVariableUsage_ExternalCallAction()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableUsage> outputVariableUsage_ExternalCallAction;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalCallActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.EXTERNAL_CALL_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature getCalledService_ExternalService() {
		if (calledService_ExternalService != null && calledService_ExternalService.eIsProxy()) {
			InternalEObject oldCalledService_ExternalService = (InternalEObject)calledService_ExternalService;
			calledService_ExternalService = (Signature)eResolveProxy(oldCalledService_ExternalService);
			if (calledService_ExternalService != oldCalledService_ExternalService) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE, oldCalledService_ExternalService, calledService_ExternalService));
			}
		}
		return calledService_ExternalService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Signature basicGetCalledService_ExternalService() {
		return calledService_ExternalService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCalledService_ExternalService(Signature newCalledService_ExternalService) {
		Signature oldCalledService_ExternalService = calledService_ExternalService;
		calledService_ExternalService = newCalledService_ExternalService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE, oldCalledService_ExternalService, calledService_ExternalService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableUsage> getParameterUsage_ExternalCallAction() {
		if (parameterUsage_ExternalCallAction == null) {
			parameterUsage_ExternalCallAction = new EObjectContainmentEList<VariableUsage>(VariableUsage.class, this, SeffPackage.EXTERNAL_CALL_ACTION__PARAMETER_USAGE_EXTERNAL_CALL_ACTION);
		}
		return parameterUsage_ExternalCallAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableUsage> getOutputVariableUsage_ExternalCallAction() {
		if (outputVariableUsage_ExternalCallAction == null) {
			outputVariableUsage_ExternalCallAction = new EObjectContainmentEList<VariableUsage>(VariableUsage.class, this, SeffPackage.EXTERNAL_CALL_ACTION__OUTPUT_VARIABLE_USAGE_EXTERNAL_CALL_ACTION);
		}
		return outputVariableUsage_ExternalCallAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SeffPackage.EXTERNAL_CALL_ACTION__PARAMETER_USAGE_EXTERNAL_CALL_ACTION:
				return ((InternalEList<?>)getParameterUsage_ExternalCallAction()).basicRemove(otherEnd, msgs);
			case SeffPackage.EXTERNAL_CALL_ACTION__OUTPUT_VARIABLE_USAGE_EXTERNAL_CALL_ACTION:
				return ((InternalEList<?>)getOutputVariableUsage_ExternalCallAction()).basicRemove(otherEnd, msgs);
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
			case SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE:
				if (resolve) return getCalledService_ExternalService();
				return basicGetCalledService_ExternalService();
			case SeffPackage.EXTERNAL_CALL_ACTION__PARAMETER_USAGE_EXTERNAL_CALL_ACTION:
				return getParameterUsage_ExternalCallAction();
			case SeffPackage.EXTERNAL_CALL_ACTION__OUTPUT_VARIABLE_USAGE_EXTERNAL_CALL_ACTION:
				return getOutputVariableUsage_ExternalCallAction();
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
			case SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE:
				setCalledService_ExternalService((Signature)newValue);
				return;
			case SeffPackage.EXTERNAL_CALL_ACTION__PARAMETER_USAGE_EXTERNAL_CALL_ACTION:
				getParameterUsage_ExternalCallAction().clear();
				getParameterUsage_ExternalCallAction().addAll((Collection<? extends VariableUsage>)newValue);
				return;
			case SeffPackage.EXTERNAL_CALL_ACTION__OUTPUT_VARIABLE_USAGE_EXTERNAL_CALL_ACTION:
				getOutputVariableUsage_ExternalCallAction().clear();
				getOutputVariableUsage_ExternalCallAction().addAll((Collection<? extends VariableUsage>)newValue);
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
			case SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE:
				setCalledService_ExternalService((Signature)null);
				return;
			case SeffPackage.EXTERNAL_CALL_ACTION__PARAMETER_USAGE_EXTERNAL_CALL_ACTION:
				getParameterUsage_ExternalCallAction().clear();
				return;
			case SeffPackage.EXTERNAL_CALL_ACTION__OUTPUT_VARIABLE_USAGE_EXTERNAL_CALL_ACTION:
				getOutputVariableUsage_ExternalCallAction().clear();
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
			case SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE:
				return calledService_ExternalService != null;
			case SeffPackage.EXTERNAL_CALL_ACTION__PARAMETER_USAGE_EXTERNAL_CALL_ACTION:
				return parameterUsage_ExternalCallAction != null && !parameterUsage_ExternalCallAction.isEmpty();
			case SeffPackage.EXTERNAL_CALL_ACTION__OUTPUT_VARIABLE_USAGE_EXTERNAL_CALL_ACTION:
				return outputVariableUsage_ExternalCallAction != null && !outputVariableUsage_ExternalCallAction.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExternalCallActionImpl
