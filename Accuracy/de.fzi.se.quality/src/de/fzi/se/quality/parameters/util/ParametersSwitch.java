/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.mdsdprofiles.StereotypableElement;

import de.fzi.se.quality.parameters.CallInstance;
import de.fzi.se.quality.parameters.ComponentInstance;
import de.fzi.se.quality.parameters.ComponentReference;
import de.fzi.se.quality.parameters.OperationReference;
import de.fzi.se.quality.parameters.ParameterInstance;
import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParameterValue;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see de.fzi.se.quality.parameters.ParametersPackage
 * @generated
 */
public class ParametersSwitch<T> {

    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static ParametersPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ParametersSwitch() {
        if (modelPackage == null) {
            modelPackage = ParametersPackage.eINSTANCE;
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
        case ParametersPackage.PARAMETER_PARTITION: {
            final ParameterPartition parameterPartition = (ParameterPartition) theEObject;
            T result = this.caseParameterPartition(parameterPartition);
            if (result == null) {
                result = this.caseIdentifier(parameterPartition);
            }
            if (result == null) {
                result = this.caseStereotypableElement(parameterPartition);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ParametersPackage.PARAMETER_VALUE: {
            final ParameterValue parameterValue = (ParameterValue) theEObject;
            T result = this.caseParameterValue(parameterValue);
            if (result == null) {
                result = this.caseIdentifier(parameterValue);
            }
            if (result == null) {
                result = this.caseStereotypableElement(parameterValue);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ParametersPackage.PARAMETER_INSTANCE: {
            final ParameterInstance parameterInstance = (ParameterInstance) theEObject;
            T result = this.caseParameterInstance(parameterInstance);
            if (result == null) {
                result = this.caseIdentifier(parameterInstance);
            }
            if (result == null) {
                result = this.caseStereotypableElement(parameterInstance);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ParametersPackage.CALL_INSTANCE: {
            final CallInstance callInstance = (CallInstance) theEObject;
            T result = this.caseCallInstance(callInstance);
            if (result == null) {
                result = this.caseIdentifier(callInstance);
            }
            if (result == null) {
                result = this.caseStereotypableElement(callInstance);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ParametersPackage.OPERATION_REFERENCE: {
            final OperationReference operationReference = (OperationReference) theEObject;
            T result = this.caseOperationReference(operationReference);
            if (result == null) {
                result = this.caseIdentifier(operationReference);
            }
            if (result == null) {
                result = this.caseStereotypableElement(operationReference);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ParametersPackage.COMPONENT_INSTANCE: {
            final ComponentInstance componentInstance = (ComponentInstance) theEObject;
            T result = this.caseComponentInstance(componentInstance);
            if (result == null) {
                result = this.caseIdentifier(componentInstance);
            }
            if (result == null) {
                result = this.caseStereotypableElement(componentInstance);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ParametersPackage.COMPONENT_REFERENCE: {
            final ComponentReference componentReference = (ComponentReference) theEObject;
            T result = this.caseComponentReference(componentReference);
            if (result == null) {
                result = this.caseIdentifier(componentReference);
            }
            if (result == null) {
                result = this.caseStereotypableElement(componentReference);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ParametersPackage.PARAMETER_REFERENCE: {
            final ParameterReference parameterReference = (ParameterReference) theEObject;
            T result = this.caseParameterReference(parameterReference);
            if (result == null) {
                result = this.caseIdentifier(parameterReference);
            }
            if (result == null) {
                result = this.caseStereotypableElement(parameterReference);
            }
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
     * Returns the result of interpreting the object as an instance of '<em>Parameter Partition</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter Partition</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParameterPartition(final ParameterPartition object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Parameter Value</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParameterValue(final ParameterValue object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Parameter Instance</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter Instance</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParameterInstance(final ParameterInstance object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Call Instance</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Call Instance</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCallInstance(final CallInstance object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Operation Reference</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Operation Reference</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOperationReference(final OperationReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Component Instance</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Component Instance</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComponentInstance(final ComponentInstance object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Component Reference</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Component Reference</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComponentReference(final ComponentReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Parameter Reference</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameter Reference</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseParameterReference(final ParameterReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Stereotypable Element</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Stereotypable Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStereotypableElement(final StereotypableElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIdentifier(final Identifier object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public T defaultCase(final EObject object) {
        return null;
    }

} // ParametersSwitch
