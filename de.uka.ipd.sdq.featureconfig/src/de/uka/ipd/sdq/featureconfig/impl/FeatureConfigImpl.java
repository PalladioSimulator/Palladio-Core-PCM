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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.ocl.expressions.OCLExpression;

import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featureconfig.FeatureConfigState;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featureconfig.util.featureconfigValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Feature Config</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl#getFeatureConfigState <em>Feature Config State</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl#getConfignode <em>Confignode</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.FeatureConfigImpl#getAnnotatedElement <em>Annotated Element</em>}</li>
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
	 * The cached value of the '{@link #getFeatureConfigState() <em>Feature Config State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureConfigState()
	 * @generated
	 * @ordered
	 */
	protected FeatureConfigState featureConfigState = FEATURE_CONFIG_STATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConfignode() <em>Confignode</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConfignode()
	 * @generated
	 * @ordered
	 */
	protected EList<ConfigNode> confignode;

	/**
	 * The cached value of the '{@link #getAnnotatedElement() <em>Annotated Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotatedElement()
	 * @generated
	 * @ordered
	 */
	protected FeatureDiagram annotatedElement;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureConfigState getFeatureConfigState() {
		return featureConfigState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureConfigState(FeatureConfigState newFeatureConfigState) {
		FeatureConfigState oldFeatureConfigState = featureConfigState;
		featureConfigState = newFeatureConfigState == null ? FEATURE_CONFIG_STATE_EDEFAULT : newFeatureConfigState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.FEATURE_CONFIG__FEATURE_CONFIG_STATE, oldFeatureConfigState, featureConfigState));
	}

	/**
	 * <!-- begin-user-doc --> 
	 * returns the result of showFeatureConfigState()
	 * showFeatureConfigState is defined by an OCL expression.
	 * The FeatureConfigState of a FeatureConfig is DEFAULT, if the FeatureConfig equals its configurationDefault.defaultConfig.
	 * It is OVERRIDE, if it is included in its configurationOverrides.configOverrides.
	 * If neither of these conditions applies, the FeatureConfigState is NOT_SET.
	 * @generated not
	 */
	public FeatureConfigState getFeatureConfigStateOld() {
		return showFeatureConfigState();
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureDiagram getAnnotatedElement() {
		if (annotatedElement != null && annotatedElement.eIsProxy()) {
			InternalEObject oldAnnotatedElement = (InternalEObject)annotatedElement;
			annotatedElement = (FeatureDiagram)eResolveProxy(oldAnnotatedElement);
			if (annotatedElement != oldAnnotatedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, featureconfigPackage.FEATURE_CONFIG__ANNOTATED_ELEMENT, oldAnnotatedElement, annotatedElement));
			}
		}
		return annotatedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureDiagram basicGetAnnotatedElement() {
		return annotatedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotatedElement(FeatureDiagram newAnnotatedElement) {
		FeatureDiagram oldAnnotatedElement = annotatedElement;
		annotatedElement = newAnnotatedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.FEATURE_CONFIG__ANNOTATED_ELEMENT, oldAnnotatedElement, annotatedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration getConfigurationOverrides() {
		if (eContainerFeatureID() != featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES) return null;
		return (Configuration)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfigurationOverrides(Configuration newConfigurationOverrides, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConfigurationOverrides, featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurationOverrides(Configuration newConfigurationOverrides) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration getConfigurationDefault() {
		if (eContainerFeatureID() != featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT) return null;
		return (Configuration)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfigurationDefault(Configuration newConfigurationDefault, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConfigurationDefault, featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * The cached OCL expression body for the '{@link #showFeatureConfigState() <em>Show Feature Config State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #showFeatureConfigState()
	 * @generated
	 * @ordered
	 */
	protected static final String SHOW_FEATURE_CONFIG_STATE__EOCL_EXP = "if (configurationDefault->size() = 1 and configurationDefault.defaultConfig = self) then FeatureConfigState::DEFAULT"+
" else ("+
" if (configurationOverrides->size() = 1 and configurationOverrides.configOverrides->size() > 0 and configurationOverrides.configOverrides->includes(self)) then FeatureConfigState::OVERRIDE"+
" else FeatureConfigState::NOT_SET"+
" endif"+
" ) endif";

	/**
	 * The cached OCL query for the '{@link #showFeatureConfigState() <em>Show Feature Config State</em>}' query operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #showFeatureConfigState()
	 * @generated
	 * @ordered
	 */
	protected static OCLExpression<EClassifier> SHOW_FEATURE_CONFIG_STATE__EOCL_QRY;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureConfigState showFeatureConfigState() {
		if (SHOW_FEATURE_CONFIG_STATE__EOCL_QRY == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setOperationContext(featureconfigPackage.Literals.FEATURE_CONFIG, featureconfigPackage.Literals.FEATURE_CONFIG.getEAllOperations().get(0));
			try {
				SHOW_FEATURE_CONFIG_STATE__EOCL_QRY = helper.createQuery(SHOW_FEATURE_CONFIG_STATE__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		OCL.Query query = EOCL_ENV.createQuery(SHOW_FEATURE_CONFIG_STATE__EOCL_QRY);
		return (FeatureConfigState) query.evaluate(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
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
			case featureconfigPackage.FEATURE_CONFIG__ANNOTATED_ELEMENT:
				if (resolve) return getAnnotatedElement();
				return basicGetAnnotatedElement();
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
			case featureconfigPackage.FEATURE_CONFIG__FEATURE_CONFIG_STATE:
				setFeatureConfigState((FeatureConfigState)newValue);
				return;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				getConfignode().clear();
				getConfignode().addAll((Collection<? extends ConfigNode>)newValue);
				return;
			case featureconfigPackage.FEATURE_CONFIG__ANNOTATED_ELEMENT:
				setAnnotatedElement((FeatureDiagram)newValue);
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
			case featureconfigPackage.FEATURE_CONFIG__FEATURE_CONFIG_STATE:
				setFeatureConfigState(FEATURE_CONFIG_STATE_EDEFAULT);
				return;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				getConfignode().clear();
				return;
			case featureconfigPackage.FEATURE_CONFIG__ANNOTATED_ELEMENT:
				setAnnotatedElement((FeatureDiagram)null);
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
				return featureConfigState != FEATURE_CONFIG_STATE_EDEFAULT;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGNODE:
				return confignode != null && !confignode.isEmpty();
			case featureconfigPackage.FEATURE_CONFIG__ANNOTATED_ELEMENT:
				return annotatedElement != null;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_OVERRIDES:
				return getConfigurationOverrides() != null;
			case featureconfigPackage.FEATURE_CONFIG__CONFIGURATION_DEFAULT:
				return getConfigurationDefault() != null;
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
		result.append(" (featureConfigState: ");
		result.append(featureConfigState);
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

} // FeatureConfigImpl
