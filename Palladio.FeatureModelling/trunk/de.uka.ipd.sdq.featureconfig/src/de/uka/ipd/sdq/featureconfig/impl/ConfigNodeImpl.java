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
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
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
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.ProhibitsConstraint;
import de.uka.ipd.sdq.featuremodel.RequiredConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ConfigNodeImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ConfigNodeImpl#getConfigState <em>Config State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigNodeImpl extends EObjectImpl implements ConfigNode {
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean prohibitsFeaturesUnchecked(ConfigNode configNode,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean valid = true;
		
		//Check first, if the fiven node is selected at all
		if (configNode.getConfigState() != ConfigState.SELECTED) {
			return valid;
		}
		
		Feature origin = configNode.getOrigin();
		
		//Using the UsageCrossReferencer to check if there is a 
		//ProhibitsConstraint object referencing the given ConfigNode as source
		Collection<Setting> settings = EcoreUtil.UsageCrossReferencer.find(origin, origin.eResource().getResourceSet());

		for (Setting setting : settings) {
			//Prohibits-Reference-Source found
			if (setting.getEObject().eClass().getClassifierID() == de.uka.ipd.sdq.featuremodel.featuremodelPackage.Literals.PROHIBITS_CONSTRAINT.getClassifierID() && setting.getEStructuralFeature().getName().equals("source")) {
				EObject constraint = setting.getEObject();
				List<Feature> targetFeatures = ((ProhibitsConstraint)constraint).getTarget();
				//Iterate over Features to check if every prohibits Feature is eliminated
				for (Feature currentFeature : targetFeatures) {
					//using the usagecrossreferencer to check for existing confignodes to the required Features
					Collection<Setting> featureSettings = EcoreUtil.UsageCrossReferencer.find(currentFeature, currentFeature.eResource().getResourceSet());
					for (Setting currentSetting : featureSettings) {
						if (currentSetting.getEObject().eClass().getClassifierID() == de.uka.ipd.sdq.featureconfig.featureconfigPackage.Literals.CONFIG_NODE.getClassifierID()) {
							EObject currentConfigNode = currentSetting.getEObject();
							if (((ConfigNode)currentConfigNode).getConfigState() == ConfigState.SELECTED) {
								valid = false;
								if (diagnostics != null) {
									diagnostics.add
									(new BasicDiagnostic
											(Diagnostic.ERROR,
													de.uka.ipd.sdq.featureconfig.util.featureconfigValidator.DIAGNOSTIC_SOURCE,
													de.uka.ipd.sdq.featureconfig.util.featureconfigValidator.CONFIG_NODE__PROHIBITS_FEATURE_SELECTED,
													EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {"Prohibts Features eliminated", EObjectValidator.getObjectLabel(this, context) }),
													new Object [] { this }));
								}
							}
						}
					}
				}
			}
		}
		
		return valid;
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean requiresFeaturesChecked(ConfigNode configNode,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean valid = true;
		
		//Check first, if the fiven node is selected at all
		if (configNode.getConfigState() != ConfigState.SELECTED) {
			return valid;
		}
		
		Feature origin = configNode.getOrigin();
		
		//Using the UsageCrossReferencer to check if there is a 
		//RequiresConstraint object referencing the given ConfigNode as source
		Collection<Setting> settings = EcoreUtil.UsageCrossReferencer.find(origin, origin.eResource().getResourceSet());

		for (Setting setting : settings) {
			//Requires-Reference-Source found
			if (setting.getEObject().eClass().getClassifierID() == de.uka.ipd.sdq.featuremodel.featuremodelPackage.Literals.REQUIRED_CONSTRAINT.getClassifierID() && setting.getEStructuralFeature().getName().equals("source")) {
				EObject constraint = setting.getEObject();
				List<Feature> targetFeatures = ((RequiredConstraint)constraint).getTarget();
				//Iterate over Features to check if every requires Feature is selected
				for (Feature currentFeature : targetFeatures) {
					boolean visited = false;
					
					//using the usagecrossreferencer to check for existing confignodes to the prohibted Features
					Collection<Setting> featureSettings = EcoreUtil.UsageCrossReferencer.find(currentFeature, currentFeature.eResource().getResourceSet());
					for (Setting currentSetting : featureSettings) {
						if (currentSetting.getEObject().eClass().getClassifierID() == de.uka.ipd.sdq.featureconfig.featureconfigPackage.Literals.CONFIG_NODE.getClassifierID()) {
							visited = true;
							EObject currentConfigNode = currentSetting.getEObject();
							if (((ConfigNode)currentConfigNode).getConfigState() != ConfigState.SELECTED) {
								valid = false;
								if (diagnostics != null) {
									diagnostics.add
									(new BasicDiagnostic
											(Diagnostic.ERROR,
													de.uka.ipd.sdq.featureconfig.util.featureconfigValidator.DIAGNOSTIC_SOURCE,
													de.uka.ipd.sdq.featureconfig.util.featureconfigValidator.CONFIG_NODE__REQUIRED_FEATURE_ELIMINATED,
													EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {"Required Features selected", EObjectValidator.getObjectLabel(this, context) }),
													new Object [] { this }));
								}
							}
						}
					}
					//Feature got no ConfigNode => eliminated
					if (!visited) {
						System.out.println(currentFeature.getName());
						valid = false;
						if (diagnostics != null) {
							diagnostics.add
							(new BasicDiagnostic
									(Diagnostic.ERROR,
											de.uka.ipd.sdq.featureconfig.util.featureconfigValidator.DIAGNOSTIC_SOURCE,
											de.uka.ipd.sdq.featureconfig.util.featureconfigValidator.CONFIG_NODE__REQUIRED_FEATURE_ELIMINATED,
											EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {"Required Features selected", EObjectValidator.getObjectLabel(this, context) }),
											new Object [] { this }));
						}
					}
					
				}
			}
		}
		
		return valid;
	}

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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case featureconfigPackage.CONFIG_NODE__ORIGIN:
				if (resolve) return getOrigin();
				return basicGetOrigin();
			case featureconfigPackage.CONFIG_NODE__CONFIG_STATE:
				return getConfigState();
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
			case featureconfigPackage.CONFIG_NODE__ORIGIN:
				setOrigin((Feature)newValue);
				return;
			case featureconfigPackage.CONFIG_NODE__CONFIG_STATE:
				setConfigState((ConfigState)newValue);
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

} //ConfigNodeImpl
