/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure.impl;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.CompositeStructure;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.Connector;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;
import eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance;

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
 * An implementation of the model object '<em><b>Composite Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CompositeStructureImpl#getSubcomponents <em>Subcomponents</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.CompositeStructureImpl#getConnector <em>Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CompositeStructureImpl extends ComponentTypeImpl implements CompositeStructure {
	/**
	 * The cached value of the '{@link #getSubcomponents() <em>Subcomponents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<SubcomponentInstance> subcomponents;

	/**
	 * The cached value of the '{@link #getConnector() <em>Connector</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnector()
	 * @generated
	 * @ordered
	 */
	protected EList<Connector> connector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeStructureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StaticStructurePackage.Literals.COMPOSITE_STRUCTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubcomponentInstance> getSubcomponents() {
		if (subcomponents == null) {
			subcomponents = new EObjectContainmentEList<SubcomponentInstance>(SubcomponentInstance.class, this, StaticStructurePackage.COMPOSITE_STRUCTURE__SUBCOMPONENTS);
		}
		return subcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Connector> getConnector() {
		if (connector == null) {
			connector = new EObjectContainmentEList<Connector>(Connector.class, this, StaticStructurePackage.COMPOSITE_STRUCTURE__CONNECTOR);
		}
		return connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean InnerComponentsOfCompositeComponentsCanNotBeServicesAgain(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 StaticStructureValidator.COMPOSITE_STRUCTURE__INNER_COMPONENTS_OF_COMPOSITE_COMPONENTS_CAN_NOT_BE_SERVICES_AGAIN,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "InnerComponentsOfCompositeComponentsCanNotBeServicesAgain", EObjectValidator.getObjectLabel(this, context) }),
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
			case StaticStructurePackage.COMPOSITE_STRUCTURE__SUBCOMPONENTS:
				return ((InternalEList<?>)getSubcomponents()).basicRemove(otherEnd, msgs);
			case StaticStructurePackage.COMPOSITE_STRUCTURE__CONNECTOR:
				return ((InternalEList<?>)getConnector()).basicRemove(otherEnd, msgs);
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
			case StaticStructurePackage.COMPOSITE_STRUCTURE__SUBCOMPONENTS:
				return getSubcomponents();
			case StaticStructurePackage.COMPOSITE_STRUCTURE__CONNECTOR:
				return getConnector();
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
			case StaticStructurePackage.COMPOSITE_STRUCTURE__SUBCOMPONENTS:
				getSubcomponents().clear();
				getSubcomponents().addAll((Collection<? extends SubcomponentInstance>)newValue);
				return;
			case StaticStructurePackage.COMPOSITE_STRUCTURE__CONNECTOR:
				getConnector().clear();
				getConnector().addAll((Collection<? extends Connector>)newValue);
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
			case StaticStructurePackage.COMPOSITE_STRUCTURE__SUBCOMPONENTS:
				getSubcomponents().clear();
				return;
			case StaticStructurePackage.COMPOSITE_STRUCTURE__CONNECTOR:
				getConnector().clear();
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
			case StaticStructurePackage.COMPOSITE_STRUCTURE__SUBCOMPONENTS:
				return subcomponents != null && !subcomponents.isEmpty();
			case StaticStructurePackage.COMPOSITE_STRUCTURE__CONNECTOR:
				return connector != null && !connector.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeStructureImpl
