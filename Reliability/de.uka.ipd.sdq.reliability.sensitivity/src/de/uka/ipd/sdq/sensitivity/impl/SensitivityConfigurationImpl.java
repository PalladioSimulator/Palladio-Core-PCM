/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.sensitivity.SensitivityConfiguration;
import de.uka.ipd.sdq.sensitivity.SensitivityPackage;
import de.uka.ipd.sdq.sensitivity.SensitivityParameter;
import de.uka.ipd.sdq.sensitivity.SensitivityResultSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.SensitivityConfigurationImpl#getSensitivityParameters__SensitivityConfiguration <em>Sensitivity Parameters Sensitivity Configuration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.impl.SensitivityConfigurationImpl#getSensitivityResultSpecifications__SensitivityConfiguration <em>Sensitivity Result Specifications Sensitivity Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SensitivityConfigurationImpl extends EntityImpl implements SensitivityConfiguration {
	/**
     * The cached value of the '{@link #getSensitivityParameters__SensitivityConfiguration() <em>Sensitivity Parameters Sensitivity Configuration</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSensitivityParameters__SensitivityConfiguration()
     * @generated
     * @ordered
     */
	protected SensitivityParameter sensitivityParameters__SensitivityConfiguration;

	/**
     * The cached value of the '{@link #getSensitivityResultSpecifications__SensitivityConfiguration() <em>Sensitivity Result Specifications Sensitivity Configuration</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSensitivityResultSpecifications__SensitivityConfiguration()
     * @generated
     * @ordered
     */
	protected EList<SensitivityResultSpecification> sensitivityResultSpecifications__SensitivityConfiguration;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected SensitivityConfigurationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return SensitivityPackage.Literals.SENSITIVITY_CONFIGURATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SensitivityParameter getSensitivityParameters__SensitivityConfiguration() {
        return sensitivityParameters__SensitivityConfiguration;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetSensitivityParameters__SensitivityConfiguration(SensitivityParameter newSensitivityParameters__SensitivityConfiguration, NotificationChain msgs) {
        SensitivityParameter oldSensitivityParameters__SensitivityConfiguration = sensitivityParameters__SensitivityConfiguration;
        sensitivityParameters__SensitivityConfiguration = newSensitivityParameters__SensitivityConfiguration;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION, oldSensitivityParameters__SensitivityConfiguration, newSensitivityParameters__SensitivityConfiguration);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setSensitivityParameters__SensitivityConfiguration(SensitivityParameter newSensitivityParameters__SensitivityConfiguration) {
        if (newSensitivityParameters__SensitivityConfiguration != sensitivityParameters__SensitivityConfiguration) {
            NotificationChain msgs = null;
            if (sensitivityParameters__SensitivityConfiguration != null)
                msgs = ((InternalEObject)sensitivityParameters__SensitivityConfiguration).eInverseRemove(this, SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER, SensitivityParameter.class, msgs);
            if (newSensitivityParameters__SensitivityConfiguration != null)
                msgs = ((InternalEObject)newSensitivityParameters__SensitivityConfiguration).eInverseAdd(this, SensitivityPackage.SENSITIVITY_PARAMETER__SENSITIVITY_CONFIGURATION_SENSITIVITY_PARAMETER, SensitivityParameter.class, msgs);
            msgs = basicSetSensitivityParameters__SensitivityConfiguration(newSensitivityParameters__SensitivityConfiguration, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION, newSensitivityParameters__SensitivityConfiguration, newSensitivityParameters__SensitivityConfiguration));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<SensitivityResultSpecification> getSensitivityResultSpecifications__SensitivityConfiguration() {
        if (sensitivityResultSpecifications__SensitivityConfiguration == null) {
            sensitivityResultSpecifications__SensitivityConfiguration = new EObjectContainmentEList<SensitivityResultSpecification>(SensitivityResultSpecification.class, this, SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_RESULT_SPECIFICATIONS_SENSITIVITY_CONFIGURATION);
        }
        return sensitivityResultSpecifications__SensitivityConfiguration;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION:
                if (sensitivityParameters__SensitivityConfiguration != null)
                    msgs = ((InternalEObject)sensitivityParameters__SensitivityConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION, null, msgs);
                return basicSetSensitivityParameters__SensitivityConfiguration((SensitivityParameter)otherEnd, msgs);
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
            case SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION:
                return basicSetSensitivityParameters__SensitivityConfiguration(null, msgs);
            case SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_RESULT_SPECIFICATIONS_SENSITIVITY_CONFIGURATION:
                return ((InternalEList<?>)getSensitivityResultSpecifications__SensitivityConfiguration()).basicRemove(otherEnd, msgs);
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
            case SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION:
                return getSensitivityParameters__SensitivityConfiguration();
            case SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_RESULT_SPECIFICATIONS_SENSITIVITY_CONFIGURATION:
                return getSensitivityResultSpecifications__SensitivityConfiguration();
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
            case SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION:
                setSensitivityParameters__SensitivityConfiguration((SensitivityParameter)newValue);
                return;
            case SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_RESULT_SPECIFICATIONS_SENSITIVITY_CONFIGURATION:
                getSensitivityResultSpecifications__SensitivityConfiguration().clear();
                getSensitivityResultSpecifications__SensitivityConfiguration().addAll((Collection<? extends SensitivityResultSpecification>)newValue);
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
            case SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION:
                setSensitivityParameters__SensitivityConfiguration((SensitivityParameter)null);
                return;
            case SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_RESULT_SPECIFICATIONS_SENSITIVITY_CONFIGURATION:
                getSensitivityResultSpecifications__SensitivityConfiguration().clear();
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
            case SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_PARAMETERS_SENSITIVITY_CONFIGURATION:
                return sensitivityParameters__SensitivityConfiguration != null;
            case SensitivityPackage.SENSITIVITY_CONFIGURATION__SENSITIVITY_RESULT_SPECIFICATIONS_SENSITIVITY_CONFIGURATION:
                return sensitivityResultSpecifications__SensitivityConfiguration != null && !sensitivityResultSpecifications__SensitivityConfiguration.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //SensitivityConfigurationImpl
