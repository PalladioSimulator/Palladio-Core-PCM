/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import de.uka.ipd.sdq.featuremodel.ChildRelation;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.Simple;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ConfigurationImpl#getDefaultConfig <em>Default Config</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ConfigurationImpl#getConfigOverrides <em>Config Overrides</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ConfigurationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends EObjectImpl implements Configuration {
	/**
	 * The cached value of the '{@link #getDefaultConfig() <em>Default Config</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultConfig()
	 * @generated
	 * @ordered
	 */
	protected FeatureConfig defaultConfig;
	
	private DiagnosticChain currentDiagnostics;
	private Map<Object, Object> currentContext;

	/**
	 * The cached value of the '{@link #getConfigOverrides() <em>Config Overrides</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigOverrides()
	 * @generated
	 * @ordered
	 */
	protected FeatureConfig configOverrides;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featureconfigPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureConfig getDefaultConfig() {
		return defaultConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultConfig(FeatureConfig newDefaultConfig, NotificationChain msgs) {
		FeatureConfig oldDefaultConfig = defaultConfig;
		defaultConfig = newDefaultConfig;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, featureconfigPackage.CONFIGURATION__DEFAULT_CONFIG, oldDefaultConfig, newDefaultConfig);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultConfig(FeatureConfig newDefaultConfig) {
		if (newDefaultConfig != defaultConfig) {
			NotificationChain msgs = null;
			if (defaultConfig != null)
				msgs = ((InternalEObject)defaultConfig).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - featureconfigPackage.CONFIGURATION__DEFAULT_CONFIG, null, msgs);
			if (newDefaultConfig != null)
				msgs = ((InternalEObject)newDefaultConfig).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - featureconfigPackage.CONFIGURATION__DEFAULT_CONFIG, null, msgs);
			msgs = basicSetDefaultConfig(newDefaultConfig, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.CONFIGURATION__DEFAULT_CONFIG, newDefaultConfig, newDefaultConfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureConfig getConfigOverrides() {
		return configOverrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfigOverrides(FeatureConfig newConfigOverrides, NotificationChain msgs) {
		FeatureConfig oldConfigOverrides = configOverrides;
		configOverrides = newConfigOverrides;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, featureconfigPackage.CONFIGURATION__CONFIG_OVERRIDES, oldConfigOverrides, newConfigOverrides);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigOverrides(FeatureConfig newConfigOverrides) {
		if (newConfigOverrides != configOverrides) {
			NotificationChain msgs = null;
			if (configOverrides != null)
				msgs = ((InternalEObject)configOverrides).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - featureconfigPackage.CONFIGURATION__CONFIG_OVERRIDES, null, msgs);
			if (newConfigOverrides != null)
				msgs = ((InternalEObject)newConfigOverrides).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - featureconfigPackage.CONFIGURATION__CONFIG_OVERRIDES, null, msgs);
			msgs = basicSetConfigOverrides(newConfigOverrides, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.CONFIGURATION__CONFIG_OVERRIDES, newConfigOverrides, newConfigOverrides));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featureconfigPackage.CONFIGURATION__DEFAULT_CONFIG:
				return basicSetDefaultConfig(null, msgs);
			case featureconfigPackage.CONFIGURATION__CONFIG_OVERRIDES:
				return basicSetConfigOverrides(null, msgs);
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
			case featureconfigPackage.CONFIGURATION__DEFAULT_CONFIG:
				return getDefaultConfig();
			case featureconfigPackage.CONFIGURATION__CONFIG_OVERRIDES:
				return getConfigOverrides();
			case featureconfigPackage.CONFIGURATION__NAME:
				return getName();
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
			case featureconfigPackage.CONFIGURATION__DEFAULT_CONFIG:
				setDefaultConfig((FeatureConfig)newValue);
				return;
			case featureconfigPackage.CONFIGURATION__CONFIG_OVERRIDES:
				setConfigOverrides((FeatureConfig)newValue);
				return;
			case featureconfigPackage.CONFIGURATION__NAME:
				setName((String)newValue);
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
			case featureconfigPackage.CONFIGURATION__DEFAULT_CONFIG:
				setDefaultConfig((FeatureConfig)null);
				return;
			case featureconfigPackage.CONFIGURATION__CONFIG_OVERRIDES:
				setConfigOverrides((FeatureConfig)null);
				return;
			case featureconfigPackage.CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
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
			case featureconfigPackage.CONFIGURATION__DEFAULT_CONFIG:
				return defaultConfig != null;
			case featureconfigPackage.CONFIGURATION__CONFIG_OVERRIDES:
				return configOverrides != null;
			case featureconfigPackage.CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean mandatoryFeaturesChecked(Configuration configuration,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		
		this.currentDiagnostics = diagnostics;
		this.currentContext = context;
		
		// try to get any ConfigNode to any Feature, so that 
		//navigation to the FeatureDiagram-model is possible
		boolean valid = true;
		FeatureConfig defaultConfig = configuration.getDefaultConfig();
		FeatureConfig configOverrides = configuration.getConfigOverrides();
		
		Feature referenceFeature = null;
		
		for (ConfigNode currentNode : configOverrides.getConfignode()) {
			if (currentNode.getOrigin() != null) {
				referenceFeature = currentNode.getOrigin();
			}
		}
		
		if (referenceFeature == null) {
			for (ConfigNode currentNode : defaultConfig.getConfignode()) {
				if (currentNode.getOrigin() != null) {
					referenceFeature = currentNode.getOrigin();
				}
			}
		}
		
		//Navigate from the referenceFeature to the FeatureDiagram object
		if (referenceFeature != null) {
			EObject diagram = referenceFeature.eContainer();
			
			while (!(diagram instanceof FeatureDiagram) && (diagram != null)) {
				diagram = diagram.eContainer();
			}
			
			if (diagram != null) {
				//get the ChildRelation object for the root Feature and check recursively
				//, if every mandatory subfeature in the Diagram is selected
				ChildRelation rootRelation = ((FeatureDiagram)diagram).getRootFeature().getChildrelation();
				valid = checkForMandatorySelected(rootRelation);
			}
		}
		return valid;
	}

	/**
	 * Checks recursively if every mandatory feature in the subtree is selected
	 * 
	 * Helper method for boolean:mandatoryFeaturesChecked(Configuration, DiagnosticChain, Map<Object,Object>)
	 * @param relation the root ChildRelation object of the current subtree
	 * @return <code>true</code> if every mandatory Feature in this subtree is selected
	 * <code>false</code> else
	 */
	private boolean checkForMandatorySelected(ChildRelation relation) {
		//Get every sub-ChildRelation object and call this method recursively with it
		boolean valid = true;
		if (relation == null) {
			return valid;
		} else if (relation instanceof Simple) {
			//if the ChildRelation is of type Simple, check if 
			//every mandatory child is selected; using UsageCrossReferencer
			EList<Feature> mandatory = ((Simple)relation).getMandatoryChildren();
			for (Feature current : mandatory) {
				Collection<Setting> featureSettings = EcoreUtil.UsageCrossReferencer.find(current, current.eResource().getResourceSet());
				for (Setting currentSetting : featureSettings) {
					if (currentSetting.getEObject().eClass().getClassifierID() == de.uka.ipd.sdq.featureconfig.featureconfigPackage.Literals.CONFIG_NODE.getClassifierID()) {
						EObject currentConfigNode = currentSetting.getEObject();
						if (((ConfigNode)currentConfigNode).getConfigState() != ConfigState.SELECTED) {
							valid = false;
							if (currentDiagnostics != null) {
								currentDiagnostics.add
								(new BasicDiagnostic
										(Diagnostic.ERROR,
												de.uka.ipd.sdq.featureconfig.util.featureconfigValidator.DIAGNOSTIC_SOURCE,
												de.uka.ipd.sdq.featureconfig.util.featureconfigValidator.CONFIGURATION__MANDATORY_ELIMINATED,
												EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {"Mandatory features selected", EObjectValidator.getObjectLabel(current, currentContext) }),
												new Object [] { this }));
							}
						}
					}
				}
				valid = valid && checkForMandatorySelected(current.getChildrelation());
			}
			EList<Feature> optional = ((Simple)relation).getOptionalChildren();
			for (Feature current : optional) {
				valid = valid && checkForMandatorySelected(current.getChildrelation());
			}	
		} else if (relation instanceof FeatureGroup) {
			List<Feature> children = ((FeatureGroup)relation).getChildren();
			
			for (Feature current : children) {
				//check recursive for non-selected mandatory features
				valid = valid && checkForMandatorySelected(current.getChildrelation());
			}
		}
		return valid;
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean minMaxCorrect(Configuration configuration,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		
		this.currentDiagnostics = diagnostics;
		this.currentContext = context;
		
		// try to get any ConfigNode to any Feature, so that 
		//navigation to the FeatureDiagram-model is possible
		boolean valid = true;
		FeatureConfig defaultConfig = configuration.getDefaultConfig();
		FeatureConfig configOverrides = configuration.getConfigOverrides();
		
		Feature referenceFeature = null;
		
		for (ConfigNode currentNode : configOverrides.getConfignode()) {
			if (currentNode.getOrigin() != null) {
				referenceFeature = currentNode.getOrigin();
			}
		}
		
		if (referenceFeature == null) {
			for (ConfigNode currentNode : defaultConfig.getConfignode()) {
				if (currentNode.getOrigin() != null) {
					referenceFeature = currentNode.getOrigin();
				}
			}
		}
		
		//Navigate from the referenceFeature to the FeatureDiagram object
		if (referenceFeature != null) {
			EObject diagram = referenceFeature.eContainer();
			
			while (!(diagram instanceof FeatureDiagram) && (diagram != null)) {
				diagram = diagram.eContainer();
			}
			
			if (diagram != null) {
				//get the ChildRelation object for the root Feature and check recursively
				//, if every Min:Max range in the Diagram is valid
				ChildRelation rootRelation = ((FeatureDiagram)diagram).getRootFeature().getChildrelation();
				valid = checkForMinMaxCorrect(rootRelation);
			}
		}
		return valid;
	}

	/**
	 * Checks recursively if every FeatureGroup in this subtree has selected Features in its Min:Max range
	 * 
	 * Helper method for boolean:minMaxCorrect(Configuration, DiagnosticChain, Map<Object,Object>)
	 * @param relation the root ChildRelation object of the current subtree
	 * @return <code>true</code> if every FeatureGroup in this subtree has selected Features in its Min:Max range
	 * <code>false</code> else
	 */
	private boolean checkForMinMaxCorrect(ChildRelation relation) {
		//Get every sub-ChildRelation object and call this method recursively with it
		boolean valid = true;
		
		if (relation == null) {
			return valid;
		} else if (relation instanceof Simple) {
			EList<Feature> mandatory = ((Simple)relation).getMandatoryChildren();
			for (Feature current : mandatory) {
				valid = valid && checkForMinMaxCorrect(current.getChildrelation());
			}
			EList<Feature> optional = ((Simple)relation).getOptionalChildren();
			for (Feature current : optional) {
				valid = valid && checkForMinMaxCorrect(current.getChildrelation());
			}	
		} else if (relation instanceof FeatureGroup) {
			//if the ChildRelation is of type FeatureGroup, count
			//the selected Features and check with Min:Max
			List<Feature> children = ((FeatureGroup)relation).getChildren();
			
			int min = ((FeatureGroup)relation).getMin();
			int max = ((FeatureGroup)relation).getMax();
			int selected = 0;
			
			for (Feature current : children) {
				Collection<Setting> featureSettings = EcoreUtil.UsageCrossReferencer.find(current, current.eResource().getResourceSet());
				for (Setting currentSetting : featureSettings) {
					if (currentSetting.getEObject().eClass().getClassifierID() == de.uka.ipd.sdq.featureconfig.featureconfigPackage.Literals.CONFIG_NODE.getClassifierID()) {
						EObject currentConfigNode = currentSetting.getEObject();
						if (((ConfigNode)currentConfigNode).getConfigState() == ConfigState.SELECTED) {
							selected++;
						}
					}
				}
			}
			if (selected < min || selected > max) {
				valid = false;
				if (currentDiagnostics != null) {
					currentDiagnostics.add
					(new BasicDiagnostic
							(Diagnostic.ERROR,
									de.uka.ipd.sdq.featureconfig.util.featureconfigValidator.DIAGNOSTIC_SOURCE,
									de.uka.ipd.sdq.featureconfig.util.featureconfigValidator.CONFIGURATION__MANDATORY_ELIMINATED,
									EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {"FeatureGroup: Min:Max Correct", EObjectValidator.getObjectLabel(relation, currentContext) }),
									new Object [] { this }));
				}
			}
			for (Feature current : children) {
				valid = valid && checkForMinMaxCorrect(current.getChildrelation());
			}
		}
		return valid;
	}

} //ConfigurationImpl
