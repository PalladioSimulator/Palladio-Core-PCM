/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.reliability.impl;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcm.reliability.FailureOccurrenceDescription;
import org.palladiosimulator.pcm.reliability.ReliabilityPackage;
import org.palladiosimulator.pcm.reliability.util.ReliabilityValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Failure Occurrence Description</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.reliability.impl.FailureOccurrenceDescriptionImpl#getFailureProbability
 * <em>Failure Probability</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FailureOccurrenceDescriptionImpl extends CDOObjectImpl implements FailureOccurrenceDescription {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getFailureProbability() <em>Failure Probability</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFailureProbability()
     * @generated
     * @ordered
     */
    protected static final double FAILURE_PROBABILITY_EDEFAULT = 0.0;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected FailureOccurrenceDescriptionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ReliabilityPackage.Literals.FAILURE_OCCURRENCE_DESCRIPTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getFailureProbability() {
        return (Double) this.eDynamicGet(ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY,
                ReliabilityPackage.Literals.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFailureProbability(final double newFailureProbability) {
        this.eDynamicSet(ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY,
                ReliabilityPackage.Literals.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY, newFailureProbability);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean EnsureValidFailureProbabilityRange(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, ReliabilityValidator.DIAGNOSTIC_SOURCE,
                                ReliabilityValidator.FAILURE_OCCURRENCE_DESCRIPTION__ENSURE_VALID_FAILURE_PROBABILITY_RANGE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "EnsureValidFailureProbabilityRange",
                                                EObjectValidator.getObjectLabel(this, context) }),
                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY:
            return this.getFailureProbability();
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
        case ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY:
            this.setFailureProbability((Double) newValue);
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
        case ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY:
            this.setFailureProbability(FAILURE_PROBABILITY_EDEFAULT);
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
        case ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY:
            return this.getFailureProbability() != FAILURE_PROBABILITY_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

} // FailureOccurrenceDescriptionImpl
