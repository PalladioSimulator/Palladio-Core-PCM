/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package de.uka.ipd.sdq.pcm.seff.seff_reliability.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage
 * @generated
 */
public class SeffReliabilitySwitch<T> {
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
    protected static SeffReliabilityPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SeffReliabilitySwitch() {
        if (modelPackage == null) {
            modelPackage = SeffReliabilityPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        } else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case SeffReliabilityPackage.RECOVERY_ACTION_BEHAVIOUR: {
            RecoveryActionBehaviour recoveryActionBehaviour = (RecoveryActionBehaviour) theEObject;
            T result = caseRecoveryActionBehaviour(recoveryActionBehaviour);
            if (result == null)
                result = caseFailureHandlingEntity(recoveryActionBehaviour);
            if (result == null)
                result = caseResourceDemandingBehaviour(recoveryActionBehaviour);
            if (result == null)
                result = caseEntity(recoveryActionBehaviour);
            if (result == null)
                result = caseIdentifier(recoveryActionBehaviour);
            if (result == null)
                result = caseNamedElement(recoveryActionBehaviour);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case SeffReliabilityPackage.RECOVERY_ACTION: {
            RecoveryAction recoveryAction = (RecoveryAction) theEObject;
            T result = caseRecoveryAction(recoveryAction);
            if (result == null)
                result = caseAbstractInternalControlFlowAction(recoveryAction);
            if (result == null)
                result = caseAbstractAction(recoveryAction);
            if (result == null)
                result = caseEntity(recoveryAction);
            if (result == null)
                result = caseIdentifier(recoveryAction);
            if (result == null)
                result = caseNamedElement(recoveryAction);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case SeffReliabilityPackage.FAILURE_HANDLING_ENTITY: {
            FailureHandlingEntity failureHandlingEntity = (FailureHandlingEntity) theEObject;
            T result = caseFailureHandlingEntity(failureHandlingEntity);
            if (result == null)
                result = caseEntity(failureHandlingEntity);
            if (result == null)
                result = caseIdentifier(failureHandlingEntity);
            if (result == null)
                result = caseNamedElement(failureHandlingEntity);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Recovery Action Behaviour</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Recovery Action Behaviour</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRecoveryActionBehaviour(RecoveryActionBehaviour object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Recovery Action</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Recovery Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRecoveryAction(RecoveryAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Failure Handling Entity</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Failure Handling Entity</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFailureHandlingEntity(FailureHandlingEntity object) {
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
    public T caseIdentifier(Identifier object) {
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
    public T caseNamedElement(NamedElement object) {
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
    public T caseEntity(Entity object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Resource Demanding Behaviour</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Resource Demanding Behaviour</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResourceDemandingBehaviour(ResourceDemandingBehaviour object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractAction(AbstractAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Abstract Internal Control Flow Action</em>'. <!-- begin-user-doc --> This implementation
     * returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Abstract Internal Control Flow Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractInternalControlFlowAction(AbstractInternalControlFlowAction object) {
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
    public T defaultCase(EObject object) {
        return null;
    }

} // SeffReliabilitySwitch
