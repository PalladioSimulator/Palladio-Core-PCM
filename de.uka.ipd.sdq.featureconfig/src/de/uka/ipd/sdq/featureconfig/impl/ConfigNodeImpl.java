/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.impl;

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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.featureconfig.AttributeValue;
import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import de.uka.ipd.sdq.featureconfig.util.featureconfigValidator;
import de.uka.ipd.sdq.featuremodel.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ConfigNodeImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ConfigNodeImpl#getConfigState <em>Config State</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ConfigNodeImpl#getAttributevalue <em>Attributevalue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigNodeImpl extends EObjectImpl implements ConfigNode {
	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected Feature origin;

	/**
	 * The default value of the '{@link #getConfigState() <em>Config State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigState()
	 * @generated
	 * @ordered
	 */
	protected static final ConfigState CONFIG_STATE_EDEFAULT = ConfigState.DEFAULT;

	/**
	 * The cached value of the '{@link #getConfigState() <em>Config State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigState()
	 * @generated
	 * @ordered
	 */
	protected ConfigState configState = CONFIG_STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttributevalue() <em>Attributevalue</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributevalue()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeValue> attributevalue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featureconfigPackage.Literals.CONFIG_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getOrigin() {
		if (origin != null && origin.eIsProxy()) {
			InternalEObject oldOrigin = (InternalEObject)origin;
			origin = (Feature)eResolveProxy(oldOrigin);
			if (origin != oldOrigin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, featureconfigPackage.CONFIG_NODE__ORIGIN, oldOrigin, origin));
			}
		}
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(Feature newOrigin) {
		Feature oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.CONFIG_NODE__ORIGIN, oldOrigin, origin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigState getConfigState() {
		return configState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigState(ConfigState newConfigState) {
		ConfigState oldConfigState = configState;
		configState = newConfigState == null ? CONFIG_STATE_EDEFAULT : newConfigState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.CONFIG_NODE__CONFIG_STATE, oldConfigState, configState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeValue> getAttributevalue() {
		if (attributevalue == null) {
			attributevalue = new EObjectContainmentWithInverseEList<AttributeValue>(AttributeValue.class, this, featureconfigPackage.CONFIG_NODE__ATTRIBUTEVALUE, featureconfigPackage.ATTRIBUTE_VALUE__CONFIGNODE);
		}
		return attributevalue;
	}

	/**
	 * The cached OCL expression body for the '{@link #ConfigCardinalityInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Config Cardinality Invalid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ConfigCardinalityInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIG_CARDINALITY_INVALID__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "true "+
"--let childSelectedCount : Integer = self.children->select(c|c.configState = ConfigState::USER_SELECTED or c.configState = ConfigState::MASCHINE_SELECTED)->size() "+
"--in "+
"--	 if self.origin.oclIsTypeOf(featuremodel::FeatureGroup) then"+
"--	 	childSelectedCount >= self.origin.min and (childSelectedCount <= self.origin.max or self.origin.max = -1)"+
"--	 else"+
"--	 	self.origin.min  >= 1 implies (self.configState = ConfigState::USER_SELECTED or self.configState = ConfigState::MASCHINE_SELECTED)"+
"--	 endif";

	/**
	 * The cached OCL invariant for the '{@link #ConfigCardinalityInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Config Cardinality Invalid</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ConfigCardinalityInvalid(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint CONFIG_CARDINALITY_INVALID__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ConfigCardinalityInvalid(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (CONFIG_CARDINALITY_INVALID__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(featureconfigPackage.Literals.CONFIG_NODE);
			try {
				CONFIG_CARDINALITY_INVALID__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(CONFIG_CARDINALITY_INVALID__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(CONFIG_CARDINALITY_INVALID__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featureconfigValidator.DIAGNOSTIC_SOURCE,
						 featureconfigValidator.CONFIG_NODE__CONFIG_CARDINALITY_INVALID,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ConfigCardinalityInvalid", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * The cached OCL expression body for the '{@link #CheckMultiplicityOfFeatureGroup(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Multiplicity Of Feature Group</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CheckMultiplicityOfFeatureGroup(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String CHECK_MULTIPLICITY_OF_FEATURE_GROUP__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "true"+
"--not self.origin.featuregroup->isEmpty() implies (self.origin.featuregroup.children->size() <=  self.origin.featuregroup.max and self.origin.featuregroup.children->size() >=  self.origin.featuregroup.min)";

	/**
	 * The cached OCL invariant for the '{@link #CheckMultiplicityOfFeatureGroup(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Check Multiplicity Of Feature Group</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CheckMultiplicityOfFeatureGroup(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint CHECK_MULTIPLICITY_OF_FEATURE_GROUP__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean CheckMultiplicityOfFeatureGroup(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (CHECK_MULTIPLICITY_OF_FEATURE_GROUP__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(featureconfigPackage.Literals.CONFIG_NODE);
			try {
				CHECK_MULTIPLICITY_OF_FEATURE_GROUP__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(CHECK_MULTIPLICITY_OF_FEATURE_GROUP__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(CHECK_MULTIPLICITY_OF_FEATURE_GROUP__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featureconfigValidator.DIAGNOSTIC_SOURCE,
						 featureconfigValidator.CONFIG_NODE__CHECK_MULTIPLICITY_OF_FEATURE_GROUP,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "CheckMultiplicityOfFeatureGroup", EObjectValidator.getObjectLabel(this, context) }),
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featureconfigPackage.CONFIG_NODE__ATTRIBUTEVALUE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributevalue()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featureconfigPackage.CONFIG_NODE__ATTRIBUTEVALUE:
				return ((InternalEList<?>)getAttributevalue()).basicRemove(otherEnd, msgs);
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
			case featureconfigPackage.CONFIG_NODE__ORIGIN:
				if (resolve) return getOrigin();
				return basicGetOrigin();
			case featureconfigPackage.CONFIG_NODE__CONFIG_STATE:
				return getConfigState();
			case featureconfigPackage.CONFIG_NODE__ATTRIBUTEVALUE:
				return getAttributevalue();
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
			case featureconfigPackage.CONFIG_NODE__ORIGIN:
				setOrigin((Feature)newValue);
				return;
			case featureconfigPackage.CONFIG_NODE__CONFIG_STATE:
				setConfigState((ConfigState)newValue);
				return;
			case featureconfigPackage.CONFIG_NODE__ATTRIBUTEVALUE:
				getAttributevalue().clear();
				getAttributevalue().addAll((Collection<? extends AttributeValue>)newValue);
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
			case featureconfigPackage.CONFIG_NODE__ORIGIN:
				setOrigin((Feature)null);
				return;
			case featureconfigPackage.CONFIG_NODE__CONFIG_STATE:
				setConfigState(CONFIG_STATE_EDEFAULT);
				return;
			case featureconfigPackage.CONFIG_NODE__ATTRIBUTEVALUE:
				getAttributevalue().clear();
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
			case featureconfigPackage.CONFIG_NODE__ORIGIN:
				return origin != null;
			case featureconfigPackage.CONFIG_NODE__CONFIG_STATE:
				return configState != CONFIG_STATE_EDEFAULT;
			case featureconfigPackage.CONFIG_NODE__ATTRIBUTEVALUE:
				return attributevalue != null && !attributevalue.isEmpty();
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
		result.append(" (configState: ");
		result.append(configState);
		result.append(')');
		return result.toString();
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //ConfigNodeImpl
