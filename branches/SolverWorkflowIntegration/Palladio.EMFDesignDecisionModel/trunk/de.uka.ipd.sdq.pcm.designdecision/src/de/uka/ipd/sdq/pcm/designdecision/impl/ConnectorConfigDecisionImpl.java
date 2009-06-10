/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.pcm.designdecision.ConnectorConfigDecision;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connector Config Decision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ConnectorConfigDecisionImpl#getFeatureconfig <em>Featureconfig</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectorConfigDecisionImpl extends DesignDecisionImpl implements ConnectorConfigDecision {
	/**
	 * The cached value of the '{@link #getFeatureconfig() <em>Featureconfig</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureconfig()
	 * @generated
	 * @ordered
	 */
	protected FeatureConfig featureconfig;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectorConfigDecisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.CONNECTOR_CONFIG_DECISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureConfig getFeatureconfig() {
		if (featureconfig != null && featureconfig.eIsProxy()) {
			InternalEObject oldFeatureconfig = (InternalEObject)featureconfig;
			featureconfig = (FeatureConfig)eResolveProxy(oldFeatureconfig);
			if (featureconfig != oldFeatureconfig) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.CONNECTOR_CONFIG_DECISION__FEATURECONFIG, oldFeatureconfig, featureconfig));
			}
		}
		return featureconfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureConfig basicGetFeatureconfig() {
		return featureconfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureconfig(FeatureConfig newFeatureconfig) {
		FeatureConfig oldFeatureconfig = featureconfig;
		featureconfig = newFeatureconfig;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.CONNECTOR_CONFIG_DECISION__FEATURECONFIG, oldFeatureconfig, featureconfig));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.CONNECTOR_CONFIG_DECISION__FEATURECONFIG:
				if (resolve) return getFeatureconfig();
				return basicGetFeatureconfig();
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
			case designdecisionPackage.CONNECTOR_CONFIG_DECISION__FEATURECONFIG:
				setFeatureconfig((FeatureConfig)newValue);
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
			case designdecisionPackage.CONNECTOR_CONFIG_DECISION__FEATURECONFIG:
				setFeatureconfig((FeatureConfig)null);
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
			case designdecisionPackage.CONNECTOR_CONFIG_DECISION__FEATURECONFIG:
				return featureconfig != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * @generated not
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.impl.BasicEObjectImpl#toString()
	 */
	@Override
	public String toString(){
		return "SOAP or RMI";
		
	}

} //ConnectorConfigDecisionImpl
