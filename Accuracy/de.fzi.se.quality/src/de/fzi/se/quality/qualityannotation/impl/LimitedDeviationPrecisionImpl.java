/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.se.quality.qualityannotation.LimitedDeviationPrecision;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Limited Deviation Precision</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.LimitedDeviationPrecisionImpl#getAbsolute
 * <em>Absolute</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.LimitedDeviationPrecisionImpl#getRelative
 * <em>Relative</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LimitedDeviationPrecisionImpl extends PrecisionImpl implements LimitedDeviationPrecision {

    /**
     * The default value of the '{@link #getAbsolute() <em>Absolute</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAbsolute()
     * @generated
     * @ordered
     */
    protected static final double ABSOLUTE_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getAbsolute() <em>Absolute</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAbsolute()
     * @generated
     * @ordered
     */
    protected double absolute = ABSOLUTE_EDEFAULT;

    /**
     * The default value of the '{@link #getRelative() <em>Relative</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRelative()
     * @generated
     * @ordered
     */
    protected static final double RELATIVE_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getRelative() <em>Relative</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRelative()
     * @generated
     * @ordered
     */
    protected double relative = RELATIVE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected LimitedDeviationPrecisionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.LIMITED_DEVIATION_PRECISION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public double getAbsolute() {
        return this.absolute;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAbsolute(final double newAbsolute) {
        final double oldAbsolute = this.absolute;
        this.absolute = newAbsolute;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__ABSOLUTE, oldAbsolute, this.absolute));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public double getRelative() {
        return this.relative;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRelative(final double newRelative) {
        final double oldRelative = this.relative;
        this.relative = newRelative;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE, oldRelative, this.relative));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__ABSOLUTE:
            return this.getAbsolute();
        case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE:
            return this.getRelative();
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
        case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__ABSOLUTE:
            this.setAbsolute((Double) newValue);
            return;
        case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE:
            this.setRelative((Double) newValue);
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
        case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__ABSOLUTE:
            this.setAbsolute(ABSOLUTE_EDEFAULT);
            return;
        case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE:
            this.setRelative(RELATIVE_EDEFAULT);
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
        case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__ABSOLUTE:
            return this.absolute != ABSOLUTE_EDEFAULT;
        case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE:
            return this.relative != RELATIVE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (absolute: ");
        result.append(this.absolute);
        result.append(", relative: ");
        result.append(this.relative);
        result.append(')');
        return result.toString();
    }

} // LimitedDeviationPrecisionImpl
