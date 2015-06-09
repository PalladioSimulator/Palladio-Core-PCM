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
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.REPrecision;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.fzi.se.quality.qualityannotation.RequiredElementDeviation;
import de.fzi.se.quality.qualityannotation.util.QualityAnnotationValidator;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Required Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.RequiredElementImpl#getRequiredElementDeviation
 * <em>Required Element Deviation</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.RequiredElementImpl#getChildREs <em>Child REs
 * </em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.RequiredElementImpl#getParentRE <em>Parent RE
 * </em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.RequiredElementImpl#getPrecision <em>
 * Precision</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.RequiredElementImpl#getQualityAnnotation <em>
 * Quality Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RequiredElementImpl extends IdentifierImpl implements RequiredElement {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RequiredElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.REQUIRED_ELEMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RequiredElementDeviation getRequiredElementDeviation() {
        return (RequiredElementDeviation) this.eDynamicGet(
                QualityAnnotationPackage.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetRequiredElementDeviation(
            final RequiredElementDeviation newRequiredElementDeviation, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newRequiredElementDeviation,
                QualityAnnotationPackage.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRequiredElementDeviation(final RequiredElementDeviation newRequiredElementDeviation) {
        this.eDynamicSet(QualityAnnotationPackage.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION,
                newRequiredElementDeviation);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<RequiredElement> getChildREs() {
        return (EList<RequiredElement>) this.eDynamicGet(QualityAnnotationPackage.REQUIRED_ELEMENT__CHILD_RES,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__CHILD_RES, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RequiredElement getParentRE() {
        return (RequiredElement) this.eDynamicGet(QualityAnnotationPackage.REQUIRED_ELEMENT__PARENT_RE,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__PARENT_RE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParentRE(final RequiredElement newParentRE, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newParentRE,
                QualityAnnotationPackage.REQUIRED_ELEMENT__PARENT_RE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParentRE(final RequiredElement newParentRE) {
        this.eDynamicSet(QualityAnnotationPackage.REQUIRED_ELEMENT__PARENT_RE,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__PARENT_RE, newParentRE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public REPrecision getPrecision() {
        return (REPrecision) this.eDynamicGet(QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__PRECISION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetPrecision(final REPrecision newPrecision, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newPrecision,
                QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPrecision(final REPrecision newPrecision) {
        this.eDynamicSet(QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__PRECISION, newPrecision);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public QualityAnnotation getQualityAnnotation() {
        return (QualityAnnotation) this.eDynamicGet(QualityAnnotationPackage.REQUIRED_ELEMENT__QUALITY_ANNOTATION,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__QUALITY_ANNOTATION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetQualityAnnotation(final QualityAnnotation newQualityAnnotation,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newQualityAnnotation,
                QualityAnnotationPackage.REQUIRED_ELEMENT__QUALITY_ANNOTATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setQualityAnnotation(final QualityAnnotation newQualityAnnotation) {
        this.eDynamicSet(QualityAnnotationPackage.REQUIRED_ELEMENT__QUALITY_ANNOTATION,
                QualityAnnotationPackage.Literals.REQUIRED_ELEMENT__QUALITY_ANNOTATION, newQualityAnnotation);
    }

    /**
     * The cached OCL expression body for the '
     * {@link #StipulatedPrecisionMustBeSetInStipulationContext(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Stipulated Precision Must Be Set In Stipulation Context</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #StipulatedPrecisionMustBeSetInStipulationContext(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String STIPULATED_PRECISION_MUST_BE_SET_IN_STIPULATION_CONTEXT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.qualityAnnotation->size() = self.precision->size()";

    /**
     * The cached OCL invariant for the '
     * {@link #StipulatedPrecisionMustBeSetInStipulationContext(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Stipulated Precision Must Be Set In Stipulation Context</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #StipulatedPrecisionMustBeSetInStipulationContext(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint STIPULATED_PRECISION_MUST_BE_SET_IN_STIPULATION_CONTEXT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean StipulatedPrecisionMustBeSetInStipulationContext(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (STIPULATED_PRECISION_MUST_BE_SET_IN_STIPULATION_CONTEXT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(QualityAnnotationPackage.Literals.REQUIRED_ELEMENT);
            try {
                STIPULATED_PRECISION_MUST_BE_SET_IN_STIPULATION_CONTEXT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(STIPULATED_PRECISION_MUST_BE_SET_IN_STIPULATION_CONTEXT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                STIPULATED_PRECISION_MUST_BE_SET_IN_STIPULATION_CONTEXT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        QualityAnnotationValidator.DIAGNOSTIC_SOURCE,
                        QualityAnnotationValidator.REQUIRED_ELEMENT__STIPULATED_PRECISION_MUST_BE_SET_IN_STIPULATION_CONTEXT,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                new Object[] { "StipulatedPrecisionMustBeSetInStipulationContext",
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
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case QualityAnnotationPackage.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetRequiredElementDeviation((RequiredElementDeviation) otherEnd, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT__CHILD_RES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getChildREs()).basicAdd(otherEnd, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PARENT_RE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetParentRE((RequiredElement) otherEnd, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION:
            final REPrecision precision = this.getPrecision();
            if (precision != null) {
                msgs = ((InternalEObject) precision).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION, null, msgs);
            }
            return this.basicSetPrecision((REPrecision) otherEnd, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT__QUALITY_ANNOTATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetQualityAnnotation((QualityAnnotation) otherEnd, msgs);
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION:
            return this.basicSetRequiredElementDeviation(null, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT__CHILD_RES:
            return ((InternalEList<?>) this.getChildREs()).basicRemove(otherEnd, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PARENT_RE:
            return this.basicSetParentRE(null, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION:
            return this.basicSetPrecision(null, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT__QUALITY_ANNOTATION:
            return this.basicSetQualityAnnotation(null, msgs);
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__REQUIRED_ELEMENT,
                    RequiredElementDeviation.class, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PARENT_RE:
            return this.eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.REQUIRED_ELEMENT__CHILD_RES,
                    RequiredElement.class, msgs);
        case QualityAnnotationPackage.REQUIRED_ELEMENT__QUALITY_ANNOTATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS, QualityAnnotation.class,
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION:
            return this.getRequiredElementDeviation();
        case QualityAnnotationPackage.REQUIRED_ELEMENT__CHILD_RES:
            return this.getChildREs();
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PARENT_RE:
            return this.getParentRE();
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION:
            return this.getPrecision();
        case QualityAnnotationPackage.REQUIRED_ELEMENT__QUALITY_ANNOTATION:
            return this.getQualityAnnotation();
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION:
            this.setRequiredElementDeviation((RequiredElementDeviation) newValue);
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT__CHILD_RES:
            this.getChildREs().clear();
            this.getChildREs().addAll((Collection<? extends RequiredElement>) newValue);
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PARENT_RE:
            this.setParentRE((RequiredElement) newValue);
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION:
            this.setPrecision((REPrecision) newValue);
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT__QUALITY_ANNOTATION:
            this.setQualityAnnotation((QualityAnnotation) newValue);
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION:
            this.setRequiredElementDeviation((RequiredElementDeviation) null);
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT__CHILD_RES:
            this.getChildREs().clear();
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PARENT_RE:
            this.setParentRE((RequiredElement) null);
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION:
            this.setPrecision((REPrecision) null);
            return;
        case QualityAnnotationPackage.REQUIRED_ELEMENT__QUALITY_ANNOTATION:
            this.setQualityAnnotation((QualityAnnotation) null);
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
        case QualityAnnotationPackage.REQUIRED_ELEMENT__REQUIRED_ELEMENT_DEVIATION:
            return this.getRequiredElementDeviation() != null;
        case QualityAnnotationPackage.REQUIRED_ELEMENT__CHILD_RES:
            return !this.getChildREs().isEmpty();
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PARENT_RE:
            return this.getParentRE() != null;
        case QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION:
            return this.getPrecision() != null;
        case QualityAnnotationPackage.REQUIRED_ELEMENT__QUALITY_ANNOTATION:
            return this.getQualityAnnotation() != null;
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

} // RequiredElementImpl
