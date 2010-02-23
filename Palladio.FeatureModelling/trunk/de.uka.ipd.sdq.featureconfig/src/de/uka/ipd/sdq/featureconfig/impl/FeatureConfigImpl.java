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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featureconfig.FeatureConfigState;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import de.uka.ipd.sdq.featureconfig.util.featureconfigValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Feature Config</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl#getFeatureConfigState <em>Feature Config State</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl#getConfignode <em>Confignode</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl#getConfigurationOverrides <em>Configuration Overrides</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl#getConfigurationDefault <em>Configuration Default</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureConfigImpl extends EObjectImpl implements FeatureConfig {
	/**
	 * The default value of the '{@link #getFeatureConfigState() <em>Feature Config State</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFeatureConfigState()
	 * @generated
	 * @ordered
	 */
	protected static final FeatureConfigState FEATURE_CONFIG_STATE_EDEFAULT = FeatureConfigState.NOT_SET;

	/**
	 * The cached value of the '{@link #getConfignode() <em>Confignode</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConfignode()
	 * @generated
	 * @ordered
	 */
	protected EList<ConfigNode> confignode;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featureconfigPackage.Literals.FEATURE_CONFIG;
	}

	/**
	 * <!-- begin-user-doc --> Checks if the Configuration Object contains this
	 * Object in its defaultConfig or its configOverrides list. Out of that
	 * information, the FeatureConfigState is set to Default or Override. If
	 * none of the conditions matches, FeatureConfigState.NOT_SET is
	 * returned<!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public FeatureConfigState getFeatureConfigState() {
		if (this.getConfigurationDefault() != null
				&& this.getConfigurationDefault().getDefaultConfig() != null
				&& this.equals(this.getConfigurationDefault()
						.getDefaultConfig())) {
			System.err.println("it's the default FeatureConfig");
			return FeatureConfigState.DEFAULT;
		} else if (this.getConfigurationOverrides() != null
				&& this.getConfigurationOverrides().getConfigOverrides() != null
				&& this.getConfigurationOverrides().getConfigOverrides()
						.contains(this)) {
			System.err.println("it's an override FeatureConfig");
			return FeatureConfigState.OVERRIDE;
		} else {
			System.err.println("its FeatureConfig is'nt set");
			return FeatureConfigState.NOT_SET;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConfigNode> getConfignode() {
		if (confignode == null) {
			confignode = new EObjectContainmentEList<ConfigNode>(ConfigNode.class, this, featureconfigPackage.FEATURE_CONFIG__CONFIGNODE);
		}
		return confignode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration getConfigurationOverrides() {
		if (eContainerFeatureID() != featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES) return null;
		return (Configuration)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfigurationOverrides(
			Configuration newConfigurationOverrides, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConfigurationOverrides, featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationOverrides(
			Configuration newConfigurationOverrides) {
		if (newConfigurationOverrides != eInternalContainer() || (eContainerFeatureID() != featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES && newConfigurationOverrides != null)) {
			if (EcoreUtil.isAncestor(this, newConfigurationOverrides))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConfigurationOverrides != null)
				msgs = ((InternalEObject)newConfigurationOverrides).eInverseAdd(this, featureconfigPackage.CONFIGURATION__CONFIG_OVERRIDES, Configuration.class, msgs);
			msgs = basicSetConfigurationOverrides(newConfigurationOverrides, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES, newConfigurationOverrides, newConfigurationOverrides));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration getConfigurationDefault() {
		if (eContainerFeatureID() != featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT) return null;
		return (Configuration)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfigurationDefault(
			Configuration newConfigurationDefault, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConfigurationDefault, featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationDefault(Configuration newConfigurationDefault) {
		if (newConfigurationDefault != eInternalContainer() || (eContainerFeatureID() != featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT && newConfigurationDefault != null)) {
			if (EcoreUtil.isAncestor(this, newConfigurationDefault))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConfigurationDefault != null)
				msgs = ((InternalEObject)newConfigurationDefault).eInverseAdd(this, featureconfigPackage.CONFIGURATION__DEFAULT_CONFIG, Configuration.class, msgs);
			msgs = basicSetConfigurationDefault(newConfigurationDefault, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT, newConfigurationDefault, newConfigurationDefault));
	}

	/**
	 * The cached OCL expression body for the '{@link #RootIsFeatureModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Root Is Feature Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RootIsFeatureModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_IS_FEATURE_MODEL__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.origin.oclIsTypeOf(featuremodel::FeatureDiagram)";

	/**
	 * The cached OCL invariant for the '{@link #RootIsFeatureModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Root Is Feature Model</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RootIsFeatureModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint ROOT_IS_FEATURE_MODEL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean RootIsFeatureModel(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (ROOT_IS_FEATURE_MODEL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(featureconfigPackage.Literals.FEATURE_CONFIG);
			try {
				ROOT_IS_FEATURE_MODEL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ROOT_IS_FEATURE_MODEL__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(ROOT_IS_FEATURE_MODEL__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featureconfigValidator.DIAGNOSTIC_SOURCE,
						 featureconfigValidator.FEATURE_CONFIG__ROOT_IS_FEATURE_MODEL,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "RootIsFeatureModel", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConfigurationOverrides((Configuration)otherEnd, msgs);
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConfigurationDefault((Configuration)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				return ((InternalEList<?>)getConfignode()).basicRemove(otherEnd, msgs);
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES:
				return basicSetConfigurationOverrides(null, msgs);
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT:
				return basicSetConfigurationDefault(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES:
				return eInternalContainer().eInverseRemove(this, featureconfigPackage.CONFIGURATION__CONFIG_OVERRIDES, Configuration.class, msgs);
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT:
				return eInternalContainer().eInverseRemove(this, featureconfigPackage.CONFIGURATION__DEFAULT_CONFIG, Configuration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case featureconfigPackage.FEATURE_CONFIG__FEATURE_CONFIG_STATE:
				return getFeatureConfigState();
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				return getConfignode();
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES:
				return getConfigurationOverrides();
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT:
				return getConfigurationDefault();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				getConfignode().clear();
				getConfignode().addAll((Collection<? extends ConfigNode>)newValue);
				return;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES:
				setConfigurationOverrides((Configuration)newValue);
				return;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT:
				setConfigurationDefault((Configuration)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				getConfignode().clear();
				return;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES:
				setConfigurationOverrides((Configuration)null);
				return;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT:
				setConfigurationDefault((Configuration)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case featureconfigPackage.FEATURE_CONFIG__FEATURE_CONFIG_STATE:
				return getFeatureConfigState() != FEATURE_CONFIG_STATE_EDEFAULT;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				return confignode != null && !confignode.isEmpty();
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES:
				return getConfigurationOverrides() != null;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT:
				return getConfigurationDefault() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} // FeatureConfigImpl
