/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

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
        return (Precision) this.eDynamicGet(QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS,
                QualityAnnotationPackage.Literals.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetDefaultPrecisionNumberOfCalls(final Precision newDefaultPrecisionNumberOfCalls,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newDefaultPrecisionNumberOfCalls,
                QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDefaultPrecisionNumberOfCalls(final Precision newDefaultPrecisionNumberOfCalls) {
        this.eDynamicSet(QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS,
                QualityAnnotationPackage.Literals.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS,
                newDefaultPrecisionNumberOfCalls);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Precision getDefaultPrecisionCallParameter() {
        return (Precision) this.eDynamicGet(QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER,
                QualityAnnotationPackage.Literals.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetDefaultPrecisionCallParameter(final Precision newDefaultPrecisionCallParameter,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newDefaultPrecisionCallParameter,
                QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDefaultPrecisionCallParameter(final Precision newDefaultPrecisionCallParameter) {
        this.eDynamicSet(QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER,
                QualityAnnotationPackage.Literals.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER,
                newDefaultPrecisionCallParameter);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RequiredElement getRequiredElement() {
        return (RequiredElement) this.eDynamicGet(QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT,
                QualityAnnotationPackage.Literals.RE_PRECISION__REQUIRED_ELEMENT, true, true);
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
        this.eDynamicSet(QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT,
                QualityAnnotationPackage.Literals.RE_PRECISION__REQUIRED_ELEMENT, newRequiredElement);
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
            return this.getDefaultPrecisionNumberOfCalls() != null;
        case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER:
            return this.getDefaultPrecisionCallParameter() != null;
        case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
            return this.getRequiredElement() != null;
        }
        return super.eIsSet(featureID);
    }

} // REPrecisionImpl
