/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.CategoryIdentifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Identifiable;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NominalMeasure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataValidator;


import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nominal Measure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NominalMeasureImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NominalMeasureImpl#getDefinedCategoryIdentifiers <em>Defined Category Identifiers</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NominalMeasureImpl#getInitialState <em>Initial State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NominalMeasureImpl extends Edp2MeasureImpl implements NominalMeasure {
	/**
	 * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected String uuid = UUID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefinedCategoryIdentifiers() <em>Defined Category Identifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinedCategoryIdentifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<CategoryIdentifier> definedCategoryIdentifiers;

	/**
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected CategoryIdentifier initialState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NominalMeasureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExperimentDataPackage.Literals.NOMINAL_MEASURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUuid(String newUuid) {
		String oldUuid = uuid;
		uuid = newUuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NOMINAL_MEASURE__UUID, oldUuid, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CategoryIdentifier> getDefinedCategoryIdentifiers() {
		if (definedCategoryIdentifiers == null) {
			definedCategoryIdentifiers = new EObjectContainmentEList<CategoryIdentifier>(CategoryIdentifier.class, this, ExperimentDataPackage.NOMINAL_MEASURE__DEFINED_CATEGORY_IDENTIFIERS);
		}
		return definedCategoryIdentifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryIdentifier getInitialState() {
		if (initialState != null && initialState.eIsProxy()) {
			InternalEObject oldInitialState = (InternalEObject)initialState;
			initialState = (CategoryIdentifier)eResolveProxy(oldInitialState);
			if (initialState != oldInitialState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.NOMINAL_MEASURE__INITIAL_STATE, oldInitialState, initialState));
			}
		}
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryIdentifier basicGetInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialState(CategoryIdentifier newInitialState) {
		CategoryIdentifier oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NOMINAL_MEASURE__INITIAL_STATE, oldInitialState, initialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean PersistenceKindOnlyEmfAllowed(DiagnosticChain diagnostics, Map context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ExperimentDataValidator.DIAGNOSTIC_SOURCE,
						 ExperimentDataValidator.NOMINAL_MEASURE__PERSISTENCE_KIND_ONLY_EMF_ALLOWED,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "PersistenceKindOnlyEmfAllowed", EObjectValidator.getObjectLabel(this, context) }),
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
			case ExperimentDataPackage.NOMINAL_MEASURE__DEFINED_CATEGORY_IDENTIFIERS:
				return ((InternalEList<?>)getDefinedCategoryIdentifiers()).basicRemove(otherEnd, msgs);
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
			case ExperimentDataPackage.NOMINAL_MEASURE__UUID:
				return getUuid();
			case ExperimentDataPackage.NOMINAL_MEASURE__DEFINED_CATEGORY_IDENTIFIERS:
				return getDefinedCategoryIdentifiers();
			case ExperimentDataPackage.NOMINAL_MEASURE__INITIAL_STATE:
				if (resolve) return getInitialState();
				return basicGetInitialState();
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
			case ExperimentDataPackage.NOMINAL_MEASURE__UUID:
				setUuid((String)newValue);
				return;
			case ExperimentDataPackage.NOMINAL_MEASURE__DEFINED_CATEGORY_IDENTIFIERS:
				getDefinedCategoryIdentifiers().clear();
				getDefinedCategoryIdentifiers().addAll((Collection<? extends CategoryIdentifier>)newValue);
				return;
			case ExperimentDataPackage.NOMINAL_MEASURE__INITIAL_STATE:
				setInitialState((CategoryIdentifier)newValue);
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
			case ExperimentDataPackage.NOMINAL_MEASURE__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case ExperimentDataPackage.NOMINAL_MEASURE__DEFINED_CATEGORY_IDENTIFIERS:
				getDefinedCategoryIdentifiers().clear();
				return;
			case ExperimentDataPackage.NOMINAL_MEASURE__INITIAL_STATE:
				setInitialState((CategoryIdentifier)null);
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
			case ExperimentDataPackage.NOMINAL_MEASURE__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case ExperimentDataPackage.NOMINAL_MEASURE__DEFINED_CATEGORY_IDENTIFIERS:
				return definedCategoryIdentifiers != null && !definedCategoryIdentifiers.isEmpty();
			case ExperimentDataPackage.NOMINAL_MEASURE__INITIAL_STATE:
				return initialState != null;
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
		if (baseClass == Identifiable.class) {
			switch (derivedFeatureID) {
				case ExperimentDataPackage.NOMINAL_MEASURE__UUID: return ExperimentDataPackage.IDENTIFIABLE__UUID;
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
		if (baseClass == Identifiable.class) {
			switch (baseFeatureID) {
				case ExperimentDataPackage.IDENTIFIABLE__UUID: return ExperimentDataPackage.NOMINAL_MEASURE__UUID;
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
		result.append(" (uuid: ");
		result.append(uuid);
		result.append(')');
		return result.toString();
	}

} //NominalMeasureImpl
