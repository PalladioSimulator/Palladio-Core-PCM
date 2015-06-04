/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;
import de.uka.ipd.sdq.pcm.qosannotations.QoSAnnotations;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction;
import de.uka.ipd.sdq.pcm.qosannotations.SpecifiedQoSAnnotation;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage
 * @generated
 */
public class QosannotationsSwitch<T> {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static QosannotationsPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public QosannotationsSwitch() {
        if (modelPackage == null) {
            modelPackage = QosannotationsPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(final EObject theEObject) {
        return this.doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(final EClass theEClass, final EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return this.doSwitch(theEClass.getClassifierID(), theEObject);
        } else {
            final List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? this.defaultCase(theEObject) : this.doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case QosannotationsPackage.SPECIFIED_QO_SANNOTATION: {
            final SpecifiedQoSAnnotation specifiedQoSAnnotation = (SpecifiedQoSAnnotation) theEObject;
            T result = this.caseSpecifiedQoSAnnotation(specifiedQoSAnnotation);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QosannotationsPackage.QO_SANNOTATIONS: {
            final QoSAnnotations qoSAnnotations = (QoSAnnotations) theEObject;
            T result = this.caseQoSAnnotations(qoSAnnotations);
            if (result == null) {
                result = this.caseEntity(qoSAnnotations);
            }
            if (result == null) {
                result = this.caseIdentifier(qoSAnnotations);
            }
            if (result == null) {
                result = this.caseNamedElement(qoSAnnotations);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION: {
            final SpecifiedOutputParameterAbstraction specifiedOutputParameterAbstraction = (SpecifiedOutputParameterAbstraction) theEObject;
            T result = this.caseSpecifiedOutputParameterAbstraction(specifiedOutputParameterAbstraction);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        default:
            return this.defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Specified Qo SAnnotation</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Specified Qo SAnnotation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSpecifiedQoSAnnotation(final SpecifiedQoSAnnotation object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Qo SAnnotations</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Qo SAnnotations</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseQoSAnnotations(final QoSAnnotations object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Specified Output Parameter Abstraction</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Specified Output Parameter Abstraction</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSpecifiedOutputParameterAbstraction(final SpecifiedOutputParameterAbstraction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of ' <em>Identifier</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of ' <em>Identifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdentifier(final Identifier object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(final NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of ' <em>Entity</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of ' <em>Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEntity(final Entity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of ' <em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of ' <em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(final EObject object) {
        return null;
    }

} // QosannotationsSwitch
