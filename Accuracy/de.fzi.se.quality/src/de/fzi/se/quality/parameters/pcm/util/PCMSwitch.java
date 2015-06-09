/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.fzi.se.quality.parameters.ComponentReference;
import de.fzi.se.quality.parameters.OperationReference;
import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParameterValue;
import de.fzi.se.quality.parameters.pcm.PCMBusinessOperationReference;
import de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMComponentReference;
import de.fzi.se.quality.parameters.pcm.PCMInfrastructureOperationReference;
import de.fzi.se.quality.parameters.pcm.PCMOperationParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.fzi.se.quality.parameters.pcm.PCMParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMParameterValue;
import de.fzi.se.quality.parameters.pcm.PCMRequiredBusinessOperationReturnParameterReference;
import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see de.fzi.se.quality.parameters.pcm.PCMPackage
 * @generated
 */
public class PCMSwitch<T> {

    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static PCMPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PCMSwitch() {
        if (modelPackage == null) {
            modelPackage = PCMPackage.eINSTANCE;
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
        case PCMPackage.PCM_PARAMETER_REFERENCE: {
            final PCMParameterReference pcmParameterReference = (PCMParameterReference) theEObject;
            T result = this.casePCMParameterReference(pcmParameterReference);
            if (result == null) {
                result = this.caseParameterReference(pcmParameterReference);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmParameterReference);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PCMPackage.PCM_PARAMETER_VALUE: {
            final PCMParameterValue pcmParameterValue = (PCMParameterValue) theEObject;
            T result = this.casePCMParameterValue(pcmParameterValue);
            if (result == null) {
                result = this.caseParameterValue(pcmParameterValue);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmParameterValue);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PCMPackage.PCM_INFRASTRUCTURE_OPERATION_REFERENCE: {
            final PCMInfrastructureOperationReference pcmInfrastructureOperationReference = (PCMInfrastructureOperationReference) theEObject;
            T result = this.casePCMInfrastructureOperationReference(pcmInfrastructureOperationReference);
            if (result == null) {
                result = this.caseOperationReference(pcmInfrastructureOperationReference);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmInfrastructureOperationReference);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PCMPackage.PCM_BUSINESS_OPERATION_REFERENCE: {
            final PCMBusinessOperationReference pcmBusinessOperationReference = (PCMBusinessOperationReference) theEObject;
            T result = this.casePCMBusinessOperationReference(pcmBusinessOperationReference);
            if (result == null) {
                result = this.caseOperationReference(pcmBusinessOperationReference);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmBusinessOperationReference);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PCMPackage.PCM_COMPONENT_REFERENCE: {
            final PCMComponentReference pcmComponentReference = (PCMComponentReference) theEObject;
            T result = this.casePCMComponentReference(pcmComponentReference);
            if (result == null) {
                result = this.caseComponentReference(pcmComponentReference);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmComponentReference);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE: {
            final PCMComponentParameterReference pcmComponentParameterReference = (PCMComponentParameterReference) theEObject;
            T result = this.casePCMComponentParameterReference(pcmComponentParameterReference);
            if (result == null) {
                result = this.casePCMParameterReference(pcmComponentParameterReference);
            }
            if (result == null) {
                result = this.caseParameterReference(pcmComponentParameterReference);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmComponentParameterReference);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PCMPackage.PCM_OPERATION_PARAMETER_REFERENCE: {
            final PCMOperationParameterReference pcmOperationParameterReference = (PCMOperationParameterReference) theEObject;
            T result = this.casePCMOperationParameterReference(pcmOperationParameterReference);
            if (result == null) {
                result = this.casePCMParameterReference(pcmOperationParameterReference);
            }
            if (result == null) {
                result = this.caseParameterReference(pcmOperationParameterReference);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmOperationParameterReference);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case PCMPackage.PCM_REQUIRED_BUSINESS_OPERATION_RETURN_PARAMETER_REFERENCE: {
            final PCMRequiredBusinessOperationReturnParameterReference pcmRequiredBusinessOperationReturnParameterReference = (PCMRequiredBusinessOperationReturnParameterReference) theEObject;
            T result = this
                    .casePCMRequiredBusinessOperationReturnParameterReference(pcmRequiredBusinessOperationReturnParameterReference);
            if (result == null) {
                result = this.casePCMParameterReference(pcmRequiredBusinessOperationReturnParameterReference);
            }
            if (result == null) {
                result = this.caseParameterReference(pcmRequiredBusinessOperationReturnParameterReference);
            }
            if (result == null) {
                result = this.caseIdentifier(pcmRequiredBusinessOperationReturnParameterReference);
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
    public T casePCMParameterReference(final PCMParameterReference object) {
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
    public T casePCMParameterValue(final PCMParameterValue object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Infrastructure Operation Reference</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Infrastructure Operation Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMInfrastructureOperationReference(final PCMInfrastructureOperationReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Business Operation Reference</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Business Operation Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMBusinessOperationReference(final PCMBusinessOperationReference object) {
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
    public T casePCMComponentReference(final PCMComponentReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Component Parameter Reference</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Component Parameter Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMComponentParameterReference(final PCMComponentParameterReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Operation Parameter Reference</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Operation Parameter Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMOperationParameterReference(final PCMOperationParameterReference object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Required Business Operation Return Parameter Reference</em>'. <!-- begin-user-doc -->
     * This implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Required Business Operation Return Parameter Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePCMRequiredBusinessOperationReturnParameterReference(
            final PCMRequiredBusinessOperationReturnParameterReference object) {
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

} // PCMSwitch
