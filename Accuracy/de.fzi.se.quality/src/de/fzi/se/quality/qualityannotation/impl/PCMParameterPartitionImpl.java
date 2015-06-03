/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.fzi.se.quality.parameters.impl.ParameterPartitionImpl;
import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition;
import de.fzi.se.quality.qualityannotation.PCMParameterPartition;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>PCM Parameter Partition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.PCMParameterPartitionImpl#getCharacerisedParameterPartitions
 * <em>Characerised Parameter Partitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMParameterPartitionImpl extends ParameterPartitionImpl implements PCMParameterPartition {

    /**
     * The cached value of the '{@link #getCharacerisedParameterPartitions()
     * <em>Characerised Parameter Partitions</em>}' containment reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getCharacerisedParameterPartitions()
     * @generated
     * @ordered
     */
    protected EList<CharacterisedPCMParameterPartition> characerisedParameterPartitions;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PCMParameterPartitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PCM_PARAMETER_PARTITION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<CharacterisedPCMParameterPartition> getCharacerisedParameterPartitions() {
        if (this.characerisedParameterPartitions == null) {
            this.characerisedParameterPartitions = new EObjectContainmentWithInverseEList<CharacterisedPCMParameterPartition>(
                    CharacterisedPCMParameterPartition.class, this,
                    QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS,
                    QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION__PCM_PARAMETER_PARTITION);
        }
        return this.characerisedParameterPartitions;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #APCMParameterPartitionMustReferenceAPCMParameterReference(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>APCM Parameter Partition Must Reference APCM Parameter Reference</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #APCMParameterPartitionMustReferenceAPCMParameterReference(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String APCM_PARAMETER_PARTITION_MUST_REFERENCE_APCM_PARAMETER_REFERENCE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parameterReference.oclIsKindOf(quality::parameters::pcm::PCMParameterReference)";

    /**
     * The cached OCL invariant for the '
     * {@link #APCMParameterPartitionMustReferenceAPCMParameterReference(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>APCM Parameter Partition Must Reference APCM Parameter Reference</em>}' invariant
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #APCMParameterPartitionMustReferenceAPCMParameterReference(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint APCM_PARAMETER_PARTITION_MUST_REFERENCE_APCM_PARAMETER_REFERENCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean APCMParameterPartitionMustReferenceAPCMParameterReference(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (APCM_PARAMETER_PARTITION_MUST_REFERENCE_APCM_PARAMETER_REFERENCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.PCM_PARAMETER_PARTITION);
            try {
                APCM_PARAMETER_PARTITION_MUST_REFERENCE_APCM_PARAMETER_REFERENCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(APCM_PARAMETER_PARTITION_MUST_REFERENCE_APCM_PARAMETER_REFERENCE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                APCM_PARAMETER_PARTITION_MUST_REFERENCE_APCM_PARAMETER_REFERENCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.PCM_PARAMETER_PARTITION__APCM_PARAMETER_PARTITION_MUST_REFERENCE_APCM_PARAMETER_REFERENCE,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                new Object[] { "APCMParameterPartitionMustReferenceAPCMParameterReference",
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getCharacerisedParameterPartitions())
                    .basicAdd(otherEnd, msgs);
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
        case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS:
            return ((InternalEList<?>) this.getCharacerisedParameterPartitions()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS:
            return this.getCharacerisedParameterPartitions();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS:
            this.getCharacerisedParameterPartitions().clear();
            this.getCharacerisedParameterPartitions().addAll(
                    (Collection<? extends CharacterisedPCMParameterPartition>) newValue);
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
        case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS:
            this.getCharacerisedParameterPartitions().clear();
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
        case QualityAnnotationPackage.PCM_PARAMETER_PARTITION__CHARACERISED_PARAMETER_PARTITIONS:
            return this.characerisedParameterPartitions != null && !this.characerisedParameterPartitions.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // PCMParameterPartitionImpl
