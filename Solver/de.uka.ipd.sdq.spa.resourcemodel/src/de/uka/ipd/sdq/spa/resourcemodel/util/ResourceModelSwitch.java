/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.ActiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.AlternativeResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.ContentionResource;
import de.uka.ipd.sdq.spa.resourcemodel.DelayResource;
import de.uka.ipd.sdq.spa.resourcemodel.Option;
import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;
import de.uka.ipd.sdq.spa.resourcemodel.ProcessingResource;
import de.uka.ipd.sdq.spa.resourcemodel.Resource;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the
 * call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for
 * each class of the model, starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage
 * @generated
 */
public class ResourceModelSwitch {
    /**
     * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static ResourceModelPackage modelPackage;

    /**
     * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceModelSwitch() {
        if (modelPackage == null) {
            modelPackage = ResourceModelPackage.eINSTANCE;
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    public Object doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected Object doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        } else {
            List eSuperTypes = theEClass.getESuperTypes();
            return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch((EClass) eSuperTypes.get(0), theEObject);
        }
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result;
     * it yields that result. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    protected Object doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
        case ResourceModelPackage.SEQUENTIAL_RESOURCE_USAGE: {
            SequentialResourceUsage sequentialResourceUsage = (SequentialResourceUsage) theEObject;
            Object result = caseSequentialResourceUsage(sequentialResourceUsage);
            if (result == null)
                result = caseAbstractResourceUsage(sequentialResourceUsage);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ResourceModelPackage.ABSTRACT_RESOURCE_USAGE: {
            AbstractResourceUsage abstractResourceUsage = (AbstractResourceUsage) theEObject;
            Object result = caseAbstractResourceUsage(abstractResourceUsage);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ResourceModelPackage.RESOURCE: {
            Resource resource = (Resource) theEObject;
            Object result = caseResource(resource);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ResourceModelPackage.ALTERNATIVE_RESOURCE_USAGE: {
            AlternativeResourceUsage alternativeResourceUsage = (AlternativeResourceUsage) theEObject;
            Object result = caseAlternativeResourceUsage(alternativeResourceUsage);
            if (result == null)
                result = caseAbstractResourceUsage(alternativeResourceUsage);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ResourceModelPackage.RESOURCE_USAGE: {
            ResourceUsage resourceUsage = (ResourceUsage) theEObject;
            Object result = caseResourceUsage(resourceUsage);
            if (result == null)
                result = caseAbstractResourceUsage(resourceUsage);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ResourceModelPackage.PASSIVE_RESOURCE: {
            PassiveResource passiveResource = (PassiveResource) theEObject;
            Object result = casePassiveResource(passiveResource);
            if (result == null)
                result = caseContentionResource(passiveResource);
            if (result == null)
                result = caseResource(passiveResource);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ResourceModelPackage.CONTENTION_RESOURCE: {
            ContentionResource contentionResource = (ContentionResource) theEObject;
            Object result = caseContentionResource(contentionResource);
            if (result == null)
                result = caseResource(contentionResource);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ResourceModelPackage.PROCESSING_RESOURCE: {
            ProcessingResource processingResource = (ProcessingResource) theEObject;
            Object result = caseProcessingResource(processingResource);
            if (result == null)
                result = caseContentionResource(processingResource);
            if (result == null)
                result = caseActiveResource(processingResource);
            if (result == null)
                result = caseResource(processingResource);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ResourceModelPackage.ACTIVE_RESOURCE: {
            ActiveResource activeResource = (ActiveResource) theEObject;
            Object result = caseActiveResource(activeResource);
            if (result == null)
                result = caseResource(activeResource);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ResourceModelPackage.DELAY_RESOURCE: {
            DelayResource delayResource = (DelayResource) theEObject;
            Object result = caseDelayResource(delayResource);
            if (result == null)
                result = caseActiveResource(delayResource);
            if (result == null)
                result = caseResource(delayResource);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        case ResourceModelPackage.OPTION: {
            Option option = (Option) theEObject;
            Object result = caseOption(option);
            if (result == null)
                result = defaultCase(theEObject);
            return result;
        }
        default:
            return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpretting the object as an instance of '
     * <em>Sequential Resource Usage</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpretting the object as an instance of '
     *         <em>Sequential Resource Usage</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseSequentialResourceUsage(SequentialResourceUsage object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '
     * <em>Abstract Resource Usage</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpretting the object as an instance of '
     *         <em>Abstract Resource Usage</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseAbstractResourceUsage(AbstractResourceUsage object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Resource</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseResource(Resource object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '
     * <em>Alternative Resource Usage</em>'. <!-- begin-user-doc --> This implementation returns
     * null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpretting the object as an instance of '
     *         <em>Alternative Resource Usage</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseAlternativeResourceUsage(AlternativeResourceUsage object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Resource Usage</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Resource Usage</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseResourceUsage(ResourceUsage object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Passive Resource</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Passive Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object casePassiveResource(PassiveResource object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '
     * <em>Contention Resource</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpretting the object as an instance of '
     *         <em>Contention Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseContentionResource(ContentionResource object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '
     * <em>Processing Resource</em>'. <!-- begin-user-doc --> This implementation returns null;
     * returning a non-null result will terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpretting the object as an instance of '
     *         <em>Processing Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseProcessingResource(ProcessingResource object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Active Resource</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Active Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseActiveResource(ActiveResource object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Delay Resource</em>'.
     * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Delay Resource</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseDelayResource(DelayResource object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>Option</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>Option</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public Object caseOption(Option object) {
        return null;
    }

    /**
     * Returns the result of interpretting the object as an instance of '<em>EObject</em>'. <!--
     * begin-user-doc --> This implementation returns null; returning a non-null result will
     * terminate the switch, but this is the last case anyway. <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    public Object defaultCase(EObject object) {
        return null;
    }

} // ResourceModelSwitch
