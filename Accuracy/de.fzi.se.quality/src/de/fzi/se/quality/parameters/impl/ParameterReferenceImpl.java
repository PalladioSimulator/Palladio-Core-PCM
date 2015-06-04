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
import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Parameter Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.impl.ParameterReferenceImpl#getParameterPartition <em>
 * Parameter Partition</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.impl.ParameterReferenceImpl#getParameterInstance <em>
 * Parameter Instance</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.impl.ParameterReferenceImpl#getParameterValueDeviation
 * <em>Parameter Value Deviation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterReferenceImpl extends IdentifierImpl implements ParameterReference {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ParameterReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ParametersPackage.Literals.PARAMETER_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ParameterPartition getParameterPartition() {
        if (this.eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION) {
            return null;
        }
        return (ParameterPartition) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetParameterPartition(final ParameterPartition newParameterPartition,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newParameterPartition,
                ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setParameterPartition(final ParameterPartition newParameterPartition) {
        if (newParameterPartition != this.eInternalContainer()
                || (this.eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION && newParameterPartition != null)) {
            if (EcoreUtil.isAncestor(this, newParameterPartition)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newParameterPartition != null) {
                msgs = ((InternalEObject) newParameterPartition).eInverseAdd(this,
                        ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE, ParameterPartition.class, msgs);
            }
            msgs = this.basicSetParameterPartition(newParameterPartition, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION, newParameterPartition,
                    newParameterPartition));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ParameterInstance getParameterInstance() {
        if (this.eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE) {
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
                ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE, msgs);
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
                || (this.eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE && newParameterInstance != null)) {
            if (EcoreUtil.isAncestor(this, newParameterInstance)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newParameterInstance != null) {
                msgs = ((InternalEObject) newParameterInstance).eInverseAdd(this,
                        ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, ParameterInstance.class, msgs);
            }
            msgs = this.basicSetParameterInstance(newParameterInstance, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE, newParameterInstance,
                    newParameterInstance));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ParameterValueDeviation getParameterValueDeviation() {
        if (this.eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION) {
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
                ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION, msgs);
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
                || (this.eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION && newParameterValueDeviation != null)) {
            if (EcoreUtil.isAncestor(this, newParameterValueDeviation)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newParameterValueDeviation != null) {
                msgs = ((InternalEObject) newParameterValueDeviation).eInverseAdd(this,
                        QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE,
                        ParameterValueDeviation.class, msgs);
            }
            msgs = this.basicSetParameterValueDeviation(newParameterValueDeviation, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION, newParameterValueDeviation,
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
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetParameterPartition((ParameterPartition) otherEnd, msgs);
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetParameterInstance((ParameterInstance) otherEnd, msgs);
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
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
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
            return this.basicSetParameterPartition(null, msgs);
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
            return this.basicSetParameterInstance(null, msgs);
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
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
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
            return this.eInternalContainer().eInverseRemove(this,
                    ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE, ParameterPartition.class, msgs);
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
            return this.eInternalContainer().eInverseRemove(this,
                    ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, ParameterInstance.class, msgs);
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE,
                    ParameterValueDeviation.class, msgs);
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
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
            return this.getParameterPartition();
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
            return this.getParameterInstance();
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
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
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
            this.setParameterPartition((ParameterPartition) newValue);
            return;
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
            this.setParameterInstance((ParameterInstance) newValue);
            return;
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
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
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
            this.setParameterPartition((ParameterPartition) null);
            return;
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
            this.setParameterInstance((ParameterInstance) null);
            return;
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
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
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION:
            return this.getParameterPartition() != null;
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
            return this.getParameterInstance() != null;
        case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION:
            return this.getParameterValueDeviation() != null;
        }
        return super.eIsSet(featureID);
    }

} // ParameterReferenceImpl
