/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.se.quality.parameters.ParameterInstance;
import de.fzi.se.quality.parameters.ParameterValue;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.impl.ParameterValueImpl#getParameterInstance <em>
 * Parameter Instance</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.impl.ParameterValueImpl#getParameterValueDeviation <em>
 * Parameter Value Deviation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterValueImpl extends IdentifierImpl implements ParameterValue {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ParameterValueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ParametersPackage.Literals.PARAMETER_VALUE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ParameterInstance getParameterInstance() {
        if (this.eContainerFeatureID() != ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE) {
            return null;
        }
        return (ParameterInstance) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParameterInstance(final ParameterInstance newParameterInstance,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newParameterInstance,
                ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParameterInstance(final ParameterInstance newParameterInstance) {
        if (newParameterInstance != this.eInternalContainer()
                || (this.eContainerFeatureID() != ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE && newParameterInstance != null)) {
            if (EcoreUtil.isAncestor(this, newParameterInstance)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newParameterInstance != null) {
                msgs = ((InternalEObject) newParameterInstance).eInverseAdd(this,
                        ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE, ParameterInstance.class, msgs);
            }
            msgs = this.basicSetParameterInstance(newParameterInstance, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE, newParameterInstance, newParameterInstance));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ParameterValueDeviation getParameterValueDeviation() {
        if (this.eContainerFeatureID() != ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION) {
            return null;
        }
        return (ParameterValueDeviation) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParameterValueDeviation(final ParameterValueDeviation newParameterValueDeviation,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newParameterValueDeviation,
                ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParameterValueDeviation(final ParameterValueDeviation newParameterValueDeviation) {
        if (newParameterValueDeviation != this.eInternalContainer()
                || (this.eContainerFeatureID() != ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION && newParameterValueDeviation != null)) {
            if (EcoreUtil.isAncestor(this, newParameterValueDeviation)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newParameterValueDeviation != null) {
                msgs = ((InternalEObject) newParameterValueDeviation).eInverseAdd(this,
                        QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE,
                        ParameterValueDeviation.class, msgs);
            }
            msgs = this.basicSetParameterValueDeviation(newParameterValueDeviation, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION, newParameterValueDeviation,
                    newParameterValueDeviation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetParameterInstance((ParameterInstance) otherEnd, msgs);
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetParameterValueDeviation((ParameterValueDeviation) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE:
            return this.basicSetParameterInstance(null, msgs);
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION:
            return this.basicSetParameterValueDeviation(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE:
            return this.eInternalContainer().eInverseRemove(this,
                    ParametersPackage.PARAMETER_INSTANCE__PARAMETER_VALUE, ParameterInstance.class, msgs);
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE, ParameterValueDeviation.class,
                    msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE:
            return this.getParameterInstance();
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION:
            return this.getParameterValueDeviation();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE:
            this.setParameterInstance((ParameterInstance) newValue);
            return;
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION:
            this.setParameterValueDeviation((ParameterValueDeviation) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE:
            this.setParameterInstance((ParameterInstance) null);
            return;
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION:
            this.setParameterValueDeviation((ParameterValueDeviation) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_INSTANCE:
            return this.getParameterInstance() != null;
        case ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION:
            return this.getParameterValueDeviation() != null;
        }
        return super.eIsSet(featureID);
    }

} // ParameterValueImpl
