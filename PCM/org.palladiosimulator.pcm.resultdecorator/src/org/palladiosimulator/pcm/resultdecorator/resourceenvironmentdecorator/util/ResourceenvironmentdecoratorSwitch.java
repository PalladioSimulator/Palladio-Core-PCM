/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

import org.palladiosimulator.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.
 *      ResourceenvironmentdecoratorPackage
 * @generated
 */
public class ResourceenvironmentdecoratorSwitch<T> extends Switch<T> {

    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static ResourceenvironmentdecoratorPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceenvironmentdecoratorSwitch() {
        if (modelPackage == null) {
            modelPackage = ResourceenvironmentdecoratorPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @param ePackage
     *            the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(final EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(final int classifierID, final EObject theEObject) {
        switch (classifierID) {
        case ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS: {
            final LinkingResourceResults linkingResourceResults = (LinkingResourceResults) theEObject;
            T result = this.caseLinkingResourceResults(linkingResourceResults);
            if (result == null) {
                result = this.caseActiveResourceUtilisationResult(linkingResourceResults);
            }
            if (result == null) {
                result = this.caseUtilisationResult(linkingResourceResults);
            }
            if (result == null) {
                result = this.caseNamedElement(linkingResourceResults);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT: {
            final ActiveResourceUtilisationResult activeResourceUtilisationResult = (ActiveResourceUtilisationResult) theEObject;
            T result = this.caseActiveResourceUtilisationResult(activeResourceUtilisationResult);
            if (result == null) {
                result = this.caseUtilisationResult(activeResourceUtilisationResult);
            }
            if (result == null) {
                result = this.caseNamedElement(activeResourceUtilisationResult);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT: {
            final UtilisationResult utilisationResult = (UtilisationResult) theEObject;
            T result = this.caseUtilisationResult(utilisationResult);
            if (result == null) {
                result = this.caseNamedElement(utilisationResult);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ResourceenvironmentdecoratorPackage.RESOURCE_CONTAINER_RESULTS: {
            final ResourceContainerResults resourceContainerResults = (ResourceContainerResults) theEObject;
            T result = this.caseResourceContainerResults(resourceContainerResults);
            if (result == null) {
                result = this.caseActiveResourceUtilisationResult(resourceContainerResults);
            }
            if (result == null) {
                result = this.caseUtilisationResult(resourceContainerResults);
            }
            if (result == null) {
                result = this.caseNamedElement(resourceContainerResults);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT: {
            final ProcessingResourceSpecificationResult processingResourceSpecificationResult = (ProcessingResourceSpecificationResult) theEObject;
            T result = this.caseProcessingResourceSpecificationResult(processingResourceSpecificationResult);
            if (result == null) {
                result = this.caseActiveResourceUtilisationResult(processingResourceSpecificationResult);
            }
            if (result == null) {
                result = this.caseUtilisationResult(processingResourceSpecificationResult);
            }
            if (result == null) {
                result = this.caseNamedElement(processingResourceSpecificationResult);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case ResourceenvironmentdecoratorPackage.PASSIVE_RESOURCE_RESULT: {
            final PassiveResourceResult passiveResourceResult = (PassiveResourceResult) theEObject;
            T result = this.casePassiveResourceResult(passiveResourceResult);
            if (result == null) {
                result = this.caseUtilisationResult(passiveResourceResult);
            }
            if (result == null) {
                result = this.caseNamedElement(passiveResourceResult);
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
     * Returns the result of interpreting the object as an instance of '
     * <em>Linking Resource Results</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Linking Resource Results</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLinkingResourceResults(final LinkingResourceResults object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Active Resource Utilisation Result</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Active Resource Utilisation Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseActiveResourceUtilisationResult(final ActiveResourceUtilisationResult object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Utilisation Result</em>
     * '. <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Utilisation Result</em>
     *         '.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUtilisationResult(final UtilisationResult object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Resource Container Results</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Resource Container Results</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceContainerResults(final ResourceContainerResults object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Processing Resource Specification Result</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Processing Resource Specification Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProcessingResourceSpecificationResult(final ProcessingResourceSpecificationResult object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Passive Resource Result</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Passive Resource Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePassiveResourceResult(final PassiveResourceResult object) {
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
    @Override
    public T defaultCase(final EObject object) {
        return null;
    }

} // ResourceenvironmentdecoratorSwitch
