/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import org.eclipse.emf.ecore.EClass;

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
     * The default value of the '{@link #getRelative() <em>Relative</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRelative()
     * @generated
     * @ordered
     */
    protected static final double RELATIVE_EDEFAULT = 0.0;

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
        return (Double) this.eDynamicGet(QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__ABSOLUTE,
                QualityAnnotationPackage.Literals.LIMITED_DEVIATION_PRECISION__ABSOLUTE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAbsolute(final double newAbsolute) {
        this.eDynamicSet(QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__ABSOLUTE,
                QualityAnnotationPackage.Literals.LIMITED_DEVIATION_PRECISION__ABSOLUTE, newAbsolute);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public double getRelative() {
        return (Double) this.eDynamicGet(QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE,
                QualityAnnotationPackage.Literals.LIMITED_DEVIATION_PRECISION__RELATIVE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRelative(final double newRelative) {
        this.eDynamicSet(QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE,
                QualityAnnotationPackage.Literals.LIMITED_DEVIATION_PRECISION__RELATIVE, newRelative);
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
            return this.getAbsolute() != ABSOLUTE_EDEFAULT;
        case QualityAnnotationPackage.LIMITED_DEVIATION_PRECISION__RELATIVE:
            return this.getRelative() != RELATIVE_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} // LimitedDeviationPrecisionImpl
