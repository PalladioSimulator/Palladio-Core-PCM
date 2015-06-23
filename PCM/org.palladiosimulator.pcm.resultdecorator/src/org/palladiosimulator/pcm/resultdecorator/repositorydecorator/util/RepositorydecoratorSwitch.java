/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationContextResults;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult;

import org.palladiosimulator.pcm.core.entity.NamedElement;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 *
 * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage
 * @generated
 */
public class RepositorydecoratorSwitch<T> extends Switch<T> {

    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected static RepositorydecoratorPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RepositorydecoratorSwitch() {
        if (modelPackage == null) {
            modelPackage = RepositorydecoratorPackage.eINSTANCE;
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
        case RepositorydecoratorPackage.INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS: {
            final InterfaceProvidingRequiringEntityResults interfaceProvidingRequiringEntityResults = (InterfaceProvidingRequiringEntityResults) theEObject;
            T result = this.caseInterfaceProvidingRequiringEntityResults(interfaceProvidingRequiringEntityResults);
            if (result == null) {
                result = this.caseComponentResult(interfaceProvidingRequiringEntityResults);
            }
            if (result == null) {
                result = this.caseNamedElement(interfaceProvidingRequiringEntityResults);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case RepositorydecoratorPackage.COMPONENT_RESULT: {
            final ComponentResult componentResult = (ComponentResult) theEObject;
            T result = this.caseComponentResult(componentResult);
            if (result == null) {
                result = this.caseNamedElement(componentResult);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS: {
            final AllocationContextResults allocationContextResults = (AllocationContextResults) theEObject;
            T result = this.caseAllocationContextResults(allocationContextResults);
            if (result == null) {
                result = this.caseComponentResult(allocationContextResults);
            }
            if (result == null) {
                result = this.caseNamedElement(allocationContextResults);
            }
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case RepositorydecoratorPackage.SERVICE_RESULT: {
            final ServiceResult serviceResult = (ServiceResult) theEObject;
            T result = this.caseServiceResult(serviceResult);
            if (result == null) {
                result = this.defaultCase(theEObject);
            }
            return result;
        }
        case RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT: {
            final AllocationServiceResult allocationServiceResult = (AllocationServiceResult) theEObject;
            T result = this.caseAllocationServiceResult(allocationServiceResult);
            if (result == null) {
                result = this.caseServiceResult(allocationServiceResult);
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
     * <em>Interface Providing Requiring Entity Results</em>'. <!-- begin-user-doc --> This
     * implementation returns null; returning a non-null result will terminate the switch. <!--
     * end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Interface Providing Requiring Entity Results</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInterfaceProvidingRequiringEntityResults(final InterfaceProvidingRequiringEntityResults object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Component Result</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Component Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComponentResult(final ComponentResult object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Allocation Context Results</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Allocation Context Results</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAllocationContextResults(final AllocationContextResults object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Service Result</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Service Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseServiceResult(final ServiceResult object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Allocation Service Result</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     *
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Allocation Service Result</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAllocationServiceResult(final AllocationServiceResult object) {
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

} // RepositorydecoratorSwitch
