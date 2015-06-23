/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Operation Interface</b></em>
 * '. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> The OperationInterface is a specific type of interface related to
 * operation calls. For this, it also refereferences a set of operation interfaces. Operations can
 * represent methods, functions or any comparable concept. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.repository.OperationInterface#getSignatures__OperationInterface
 * <em>Signatures Operation Interface</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.pcm.repository.RepositoryPackage#getOperationInterface()
 * @model
 * @generated
 */
public interface OperationInterface extends Interface {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Signatures Operation Interface</b></em>' containment
     * reference list. The list contents are of type
     * {@link org.palladiosimulator.pcm.repository.OperationSignature}. It is bidirectional and its
     * opposite is '
     * {@link org.palladiosimulator.pcm.repository.OperationSignature#getInterface__OperationSignature
     * <em>Interface Operation Signature</em>}'. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
     * begin-model-doc --> This property represents the set of signatures of which the interface
     * consists. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Signatures Operation Interface</em>' containment reference
     *         list.
     * @see org.palladiosimulator.pcm.repository.RepositoryPackage#getOperationInterface_Signatures__OperationInterface()
     * @see org.palladiosimulator.pcm.repository.OperationSignature#getInterface__OperationSignature
     * @model opposite="interface__OperationSignature" containment="true" ordered="false"
     * @generated
     */
    EList<OperationSignature> getSignatures__OperationInterface();

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @model annotation=
     *        "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='-- full signature has to be unique \n-- (use of ocl-tupels) #\nlet sigs : Bag(\n\t-- parameters: Sequence of DataType, NOT name #\n\t-- exceptions have not to be considered #\n\tTuple(returnType : DataType, serviceName : String, parameters : Sequence(DataType) ) \n) = \nself.signatures__OperationInterface->collect(sig : OperationSignature |\n\tTuple{\n\t\treturnType : DataType = sig.returnType__OperationSignature,\n\t\tserviceName : String = sig.entityName,\n\t\tparameters : Sequence(DataType) = sig.parameters__OperationSignature.dataType__Parameter\n\t}\n)\nin\nsigs->isUnique(s|s)'"
     * @generated
     */
    boolean SignaturesHaveToBeUniqueForAnInterface(DiagnosticChain diagnostics, Map<Object, Object> context);

} // OperationInterface
