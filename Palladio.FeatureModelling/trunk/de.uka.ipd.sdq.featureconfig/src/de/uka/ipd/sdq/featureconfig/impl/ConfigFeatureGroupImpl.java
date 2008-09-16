/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig.impl;

import java.util.Collection;
import java.util.Iterator;

import de.uka.ipd.sdq.featureconfig.ConfigFeatureGroup;
import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featureconfig.featureconfigPackage;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.Node;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Config Feature Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ConfigFeatureGroupImpl#getConfigStatus <em>Config Status</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featureconfig.impl.ConfigFeatureGroupImpl#getOrigin <em>Origin</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigFeatureGroupImpl extends EObjectImpl implements ConfigFeatureGroup {
	/**
	 * The default value of the '{@link #getConfigStatus() <em>Config Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ConfigState CONFIG_STATUS_EDEFAULT = ConfigState.SELECTED;

	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected EObject origin;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigFeatureGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featureconfigPackage.Literals.CONFIG_FEATURE_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Derives root node status from children status. If a single
	 * node is selected, the rest of the feature group will also be.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ConfigState getConfigStatus() {

		ConfigState featureGroupState = ConfigState.DEFAULT;
		FeatureGroup fg = null;
		
		if(this.getOrigin() instanceof FeatureGroup) {
			fg = (FeatureGroup)this.getOrigin();
		} else {
			throw new RuntimeException("ConfigFeatureGroup must reference a FeatureGroup as origin.");
		}
		if(fg != null) {
			Iterator<Feature> childrenIterator = fg.getChildren().iterator();
	
			while(childrenIterator.hasNext()) {
				Feature currentFeature = childrenIterator.next();			
				// collection of all incoming references:
				Collection<Setting> settings = EcoreUtil.UsageCrossReferencer.find (
						currentFeature, currentFeature.eResource().getResourceSet());
				
				ConfigState defaultState = null;
				ConfigState overridesState = null;
				
				// exactly one or two references should exist only  
				for (Iterator<Setting> iter = settings.iterator(); iter.hasNext(); ){
					EStructuralFeature.Setting setting = iter.next();
					
					//if (setting.getEStructuralFeature() ==
						//featureconfigPackage.Literals.CONFIG_NODE) {
					EStructuralFeature sf = setting.getEStructuralFeature();
					if (setting.getEObject() instanceof ConfigNode) {						
						ConfigNode configNode = (ConfigNode)setting.getEObject();					
	
						// depending on config type; save state in different variable
						if(isConfigOverridesNode(configNode)) {
							overridesState = configNode.getConfigState(); 
						} else {
							defaultState = configNode.getConfigState();
						}
					}
				}	
				featureGroupState = determineFeatureGroupState(defaultState, overridesState);
				// break loop if single node is selected
				if(featureGroupState.compareTo(ConfigState.SELECTED) == 0) {
					return featureGroupState;
				}
			}	
		}
		return featureGroupState;
	}

	/**
	 * Decision logic for FeatureGroup state. Override has priority over
	 * default. If either override or default have a non-default status,
	 * this will be selected.
	 * @param defaultState
	 * @param overridesState
	 * @return Effective ConfigState of a single node
	 */
	private ConfigState determineFeatureGroupState(ConfigState defaultState,
			ConfigState overridesState) {
		if(overridesState != null && 
				overridesState.compareTo(ConfigState.SELECTED) == 0) {
			return ConfigState.SELECTED;		
		} else if (defaultState != null &&
				defaultState.compareTo(ConfigState.SELECTED) == 0) {
			return ConfigState.SELECTED;
		} else if (overridesState != null && 
				overridesState.compareTo(ConfigState.ELIMINATED) == 0) {
			return ConfigState.ELIMINATED;
		} else if (defaultState != null && 
				defaultState.compareTo(ConfigState.ELIMINATED) == 0) {
			return ConfigState.ELIMINATED;
		} else {
			return ConfigState.DEFAULT;
		}
	}

	/**
	 * find out whether default or override config
	 * @param configNode
	 */
	private boolean isConfigOverridesNode(ConfigNode configNode) {
		
		FeatureConfig currentFC = (FeatureConfig)configNode.eContainer();
		Configuration currentConfiguration = (Configuration)currentFC.eContainer();
		if(currentFC.equals(currentConfiguration.getConfigOverrides())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOrigin() {
		if (origin != null && origin.eIsProxy()) {
			InternalEObject oldOrigin = (InternalEObject)origin;
			origin = eResolveProxy(oldOrigin);
			if (origin != oldOrigin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, featureconfigPackage.CONFIG_FEATURE_GROUP__ORIGIN, oldOrigin, origin));
			}
		}
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(EObject newOrigin) {
		EObject oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featureconfigPackage.CONFIG_FEATURE_GROUP__ORIGIN, oldOrigin, origin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case featureconfigPackage.CONFIG_FEATURE_GROUP__CONFIG_STATUS:
				return getConfigStatus();
			case featureconfigPackage.CONFIG_FEATURE_GROUP__ORIGIN:
				if (resolve) return getOrigin();
				return basicGetOrigin();
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
			case featureconfigPackage.CONFIG_FEATURE_GROUP__ORIGIN:
				setOrigin((EObject)newValue);
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
			case featureconfigPackage.CONFIG_FEATURE_GROUP__ORIGIN:
				setOrigin((EObject)null);
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
			case featureconfigPackage.CONFIG_FEATURE_GROUP__CONFIG_STATUS:
				return getConfigStatus() != CONFIG_STATUS_EDEFAULT;
			case featureconfigPackage.CONFIG_FEATURE_GROUP__ORIGIN:
				return origin != null;
		}
		return super.eIsSet(featureID);
	}

} //ConfigFeatureGroupImpl
