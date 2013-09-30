/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.seff_performance;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceSignature;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.CallAction;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Resource Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall#getAction__ResourceCall <em>Action Resource Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall#getResourceRequiredRole__ResourceCall <em>Resource Required Role Resource Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall#getSignature__ResourceCall <em>Signature Resource Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall#getNumberOfCalls__ResourceCall <em>Number Of Calls Resource Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage#getResourceCall()
 * @model
 * @generated
 */
public interface ResourceCall extends CallAction {
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
	 * Returns the value of the '<em><b>Action Resource Call</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction#getResourceCall__Action <em>Resource Call Action</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Action Resource Call</em>' container reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Resource Call</em>' container reference.
	 * @see #setAction__ResourceCall(AbstractInternalControlFlowAction)
	 * @see de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage#getResourceCall_Action__ResourceCall()
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction#getResourceCall__Action
	 * @model opposite="resourceCall__Action" required="true" transient="false" ordered="false"
	 * @generated
	 */
    AbstractInternalControlFlowAction getAction__ResourceCall();

    /**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall#getAction__ResourceCall <em>Action Resource Call</em>}' container reference.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @param value the new value of the '<em>Action Resource Call</em>' container reference.
	 * @see #getAction__ResourceCall()
	 * @generated
	 */
    void setAction__ResourceCall(AbstractInternalControlFlowAction value);

    /**
	 * Returns the value of the '<em><b>Resource Required Role Resource Call</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Required Role Resource Call</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Required Role Resource Call</em>' reference.
	 * @see #setResourceRequiredRole__ResourceCall(ResourceRequiredRole)
	 * @see de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage#getResourceCall_ResourceRequiredRole__ResourceCall()
	 * @model required="true" ordered="false"
	 * @generated
	 */
    ResourceRequiredRole getResourceRequiredRole__ResourceCall();

    /**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall#getResourceRequiredRole__ResourceCall <em>Resource Required Role Resource Call</em>}' reference.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @param value the new value of the '<em>Resource Required Role Resource Call</em>' reference.
	 * @see #getResourceRequiredRole__ResourceCall()
	 * @generated
	 */
    void setResourceRequiredRole__ResourceCall(ResourceRequiredRole value);

    /**
     * Returns the value of the '<em><b>Signature Resource Call</b></em>' reference. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Signature Resource Call</em>' reference isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Signature Resource Call</em>' reference.
     * @see #setSignature__ResourceCall(ResourceSignature)
     * @see de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage#getResourceCall_Signature__ResourceCall()
     * @model required="true" ordered="false"
     * @generated
     */
    ResourceSignature getSignature__ResourceCall();

    /**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall#getSignature__ResourceCall <em>Signature Resource Call</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature Resource Call</em>' reference.
	 * @see #getSignature__ResourceCall()
	 * @generated
	 */
    void setSignature__ResourceCall(ResourceSignature value);

    /**
	 * Returns the value of the '<em><b>Number Of Calls Resource Call</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getResourceCall__PCMRandomVariable <em>Resource Call PCM Random Variable</em>}'.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Number Of Calls Resource Call</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Calls Resource Call</em>' containment reference.
	 * @see #setNumberOfCalls__ResourceCall(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage#getResourceCall_NumberOfCalls__ResourceCall()
	 * @see de.uka.ipd.sdq.pcm.core.PCMRandomVariable#getResourceCall__PCMRandomVariable
	 * @model opposite="resourceCall__PCMRandomVariable" containment="true" required="true" ordered="false"
	 * @generated
	 */
    PCMRandomVariable getNumberOfCalls__ResourceCall();

    /**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall#getNumberOfCalls__ResourceCall <em>Number Of Calls Resource Call</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @param value the new value of the '<em>Number Of Calls Resource Call</em>' containment reference.
	 * @see #getNumberOfCalls__ResourceCall()
	 * @generated
	 */
    void setNumberOfCalls__ResourceCall(PCMRandomVariable value);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * 
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='self.resourceRequiredRole__ResourceCall.requiredResourceInterface__ResourceRequiredRole.resourceSignatures__ResourceInterface->includes(self.signature__ResourceCall)'"
     * @generated
     */
    boolean ResourceSignatureBelongsToResourceRequiredRole(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * 
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='self.oclAsType(ecore::EObject)->closure(eContainer())->select( entity | entity.oclIsKindOf(pcm::core::entity::ResourceInterfaceRequiringEntity)).oclAsType(pcm::core::entity::ResourceInterfaceRequiringEntity).resourceRequiredRoles__ResourceInterfaceRequiringEntity->includes(self.resourceRequiredRole__ResourceCall)'"
     * @generated
     */
    boolean ResourceRequiredRoleMustBeReferencedByComponent(DiagnosticChain diagnostics, Map<Object, Object> context);

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
     * 
     * @param diagnostics
     *            The chain of diagnostics to which problems are to be appended.
     * @param context
     *            The cache of context-specific information. <!-- end-model-doc -->
     * @model annotation=
     *        "http://www.eclipse.org/uml2/1.1.0/GenModel body='self.action__ResourceCall.resourceCall__Action->select(call | call.resourceRequiredRole__ResourceCall=self.resourceRequiredRole__ResourceCall and call.signature__ResourceCall=self.signature__ResourceCall)->size() = 1'"
     * @generated
     */
    boolean SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(DiagnosticChain diagnostics,
            Map<Object, Object> context);

} // ResourceCall
