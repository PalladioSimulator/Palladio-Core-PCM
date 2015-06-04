/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.REPrecision;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>RE Precision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.REPrecisionImpl#getDefaultPrecisionNumberOfCalls
 * <em>Default Precision Number Of Calls</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.REPrecisionImpl#getDefaultPrecisionCallParameter
 * <em>Default Precision Call Parameter</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.REPrecisionImpl#getRequiredElement <em>
 * Required Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class REPrecisionImpl extends IdentifierImpl implements REPrecision {

    /**
     * The cached value of the '{@link #getDefaultPrecisionNumberOfCalls()
     * <em>Default Precision Number Of Calls</em>}' containment reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDefaultPrecisionNumberOfCalls()
     * @generated
     * @ordered
     */
    protected Precision defaultPrecisionNumberOfCalls;

    /**
     * The cached value of the '{@link #getDefaultPrecisionCallParameter()
     * <em>Default Precision Call Parameter</em>}' containment reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getDefaultPrecisionCallParameter()
     * @generated
     * @ordered
     */
    protected Precision defaultPrecisionCallParameter;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected REPrecisionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.RE_PRECISION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Precision getDefaultPrecisionNumberOfCalls() {
        return this.defaultPrecisionNumberOfCalls;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetDefaultPrecisionNumberOfCalls(final Precision newDefaultPrecisionNumberOfCalls,
            NotificationChain msgs) {
        final Precision oldDefaultPrecisionNumberOfCalls = this.defaultPrecisionNumberOfCalls;
        this.defaultPrecisionNumberOfCalls = newDefaultPrecisionNumberOfCalls;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS,
                    oldDefaultPrecisionNumberOfCalls, newDefaultPrecisionNumberOfCalls);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDefaultPrecisionNumberOfCalls(final Precision newDefaultPrecisionNumberOfCalls) {
        if (newDefaultPrecisionNumberOfCalls != this.defaultPrecisionNumberOfCalls) {
            NotificationChain msgs = null;
            if (this.defaultPrecisionNumberOfCalls != null) {
                msgs = ((InternalEObject) this.defaultPrecisionNumberOfCalls).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS, null, msgs);
            }
            if (newDefaultPrecisionNumberOfCalls != null) {
                msgs = ((InternalEObject) newDefaultPrecisionNumberOfCalls).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS, null, msgs);
            }
            msgs = this.basicSetDefaultPrecisionNumberOfCalls(newDefaultPrecisionNumberOfCalls, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS,
                    newDefaultPrecisionNumberOfCalls, newDefaultPrecisionNumberOfCalls));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Precision getDefaultPrecisionCallParameter() {
        return this.defaultPrecisionCallParameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetDefaultPrecisionCallParameter(final Precision newDefaultPrecisionCallParameter,
            NotificationChain msgs) {
        final Precision oldDefaultPrecisionCallParameter = this.defaultPrecisionCallParameter;
        this.defaultPrecisionCallParameter = newDefaultPrecisionCallParameter;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER,
                    oldDefaultPrecisionCallParameter, newDefaultPrecisionCallParameter);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDefaultPrecisionCallParameter(final Precision newDefaultPrecisionCallParameter) {
        if (newDefaultPrecisionCallParameter != this.defaultPrecisionCallParameter) {
            NotificationChain msgs = null;
            if (this.defaultPrecisionCallParameter != null) {
                msgs = ((InternalEObject) this.defaultPrecisionCallParameter).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER, null, msgs);
            }
            if (newDefaultPrecisionCallParameter != null) {
                msgs = ((InternalEObject) newDefaultPrecisionCallParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER, null, msgs);
            }
            msgs = this.basicSetDefaultPrecisionCallParameter(newDefaultPrecisionCallParameter, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER,
                    newDefaultPrecisionCallParameter, newDefaultPrecisionCallParameter));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RequiredElement getRequiredElement() {
        if (this.eContainerFeatureID() != QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT) {
            return null;
        }
        return (RequiredElement) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRequiredElement(final RequiredElement newRequiredElement, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newRequiredElement,
                QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRequiredElement(final RequiredElement newRequiredElement) {
        if (newRequiredElement != this.eInternalContainer()
                || (this.eContainerFeatureID() != QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT && newRequiredElement != null)) {
            if (EcoreUtil.isAncestor(this, newRequiredElement)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newRequiredElement != null) {
                msgs = ((InternalEObject) newRequiredElement).eInverseAdd(this,
                        QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION, RequiredElement.class, msgs);
            }
            msgs = this.basicSetRequiredElement(newRequiredElement, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT, newRequiredElement, newRequiredElement));
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
        case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetRequiredElement((RequiredElement) otherEnd, msgs);
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
        case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS:
            return this.basicSetDefaultPrecisionNumberOfCalls(null, msgs);
        case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER:
            return this.basicSetDefaultPrecisionCallParameter(null, msgs);
        case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
            return this.basicSetRequiredElement(null, msgs);
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
        case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
            return this.eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION,
                    RequiredElement.class, msgs);
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
        case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS:
            return this.getDefaultPrecisionNumberOfCalls();
        case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER:
            return this.getDefaultPrecisionCallParameter();
        case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
            return this.getRequiredElement();
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
        case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS:
            this.setDefaultPrecisionNumberOfCalls((Precision) newValue);
            return;
        case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER:
            this.setDefaultPrecisionCallParameter((Precision) newValue);
            return;
        case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
            this.setRequiredElement((RequiredElement) newValue);
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
        case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS:
            this.setDefaultPrecisionNumberOfCalls((Precision) null);
            return;
        case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER:
            this.setDefaultPrecisionCallParameter((Precision) null);
            return;
        case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
            this.setRequiredElement((RequiredElement) null);
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
        case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS:
            return this.defaultPrecisionNumberOfCalls != null;
        case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER:
            return this.defaultPrecisionCallParameter != null;
        case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
            return this.getRequiredElement() != null;
        }
        return super.eIsSet(featureID);
    }

} // REPrecisionImpl
