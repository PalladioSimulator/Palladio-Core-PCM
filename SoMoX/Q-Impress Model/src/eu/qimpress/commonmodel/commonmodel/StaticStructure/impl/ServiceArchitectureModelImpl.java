/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure.impl;

import eu.qimpress.commonmodel.commonmodel.Allocation.Service;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.ServiceArchitectureModel;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.util.StaticStructureValidator;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Architecture Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ServiceArchitectureModelImpl#getDeclaredInterfaces <em>Declared Interfaces</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.ServiceArchitectureModelImpl#getService <em>Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceArchitectureModelImpl extends CompositeStructureImpl implements ServiceArchitectureModel {
	/**
	 * The cached value of the '{@link #getDeclaredInterfaces() <em>Declared Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> declaredInterfaces;

	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> service;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceArchitectureModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticStructurePackage.Literals.SERVICE_ARCHITECTURE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getDeclaredInterfaces() {
		if (declaredInterfaces == null) {
			declaredInterfaces = new EObjectContainmentEList<Interface>(Interface.class, this, StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL__DECLARED_INTERFACES);
		}
		return declaredInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getService() {
		if (service == null) {
			service = new EObjectContainmentEList<Service>(Service.class, this, StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL__SERVICE);
		}
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean OnlyServicesOnTopLevel(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 StaticStructureValidator.DIAGNOSTIC_SOURCE,
						 StaticStructureValidator.SERVICE_ARCHITECTURE_MODEL__ONLY_SERVICES_ON_TOP_LEVEL,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "OnlyServicesOnTopLevel", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL__DECLARED_INTERFACES:
				return ((InternalEList<?>)getDeclaredInterfaces()).basicRemove(otherEnd, msgs);
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL__SERVICE:
				return ((InternalEList<?>)getService()).basicRemove(otherEnd, msgs);
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
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL__DECLARED_INTERFACES:
				return getDeclaredInterfaces();
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL__SERVICE:
				return getService();
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
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL__DECLARED_INTERFACES:
				getDeclaredInterfaces().clear();
				getDeclaredInterfaces().addAll((Collection<? extends Interface>)newValue);
				return;
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL__SERVICE:
				getService().clear();
				getService().addAll((Collection<? extends Service>)newValue);
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
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL__DECLARED_INTERFACES:
				getDeclaredInterfaces().clear();
				return;
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL__SERVICE:
				getService().clear();
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
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL__DECLARED_INTERFACES:
				return declaredInterfaces != null && !declaredInterfaces.isEmpty();
			case StaticStructurePackage.SERVICE_ARCHITECTURE_MODEL__SERVICE:
				return service != null && !service.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServiceArchitectureModelImpl
