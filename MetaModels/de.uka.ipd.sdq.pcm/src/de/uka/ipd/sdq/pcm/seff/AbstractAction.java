/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * AbstractActions model either a service?s internal computations or calls to external (i.e., required) services, or describe some form of control flow alteration (i.e., branching, loop, or fork). The following first clarifies the notions of internal and external actions, whose meta-classes both inherit from AbstractAction.
 * The RDSEFF defines the control flow between internal and external actions with the predecessor/successor relationship between AbstractActions to model sequential executions. Additionally, special actions for branching, loops, and forks allow other kinds of control flow. Other than flowcharts or UML activity diagrams, the RDSEFF language (as well as the usage model language) requires developers to make the branching, loop, fork bodies explicit using nested ResourceDemandingBehaviours. It disallows backward references in the chain of AbstractActions, which are basically
 * goto statements and can lead to ambiguities and difficult maintainability. For example, this might lead to intertwined control flows as in the example in Fig. 4.9(a), where both the sequences ?abcabcdbcd? and ?abcdbcabcd? could be occur if each backward reference is executed once, which might lead to different execution times. Backward references also allow the specification of loops with multiple entry points as in Fig. 4.9(b). This is not desirable, as the number of loop iterations cannot be specified directly in these cases, which is however necessary for accurate performance prediction. If a developer would specify that each backward link in Fig. 4.9(b) is executed only once, both sequences ?ababc? and ?abcababc? would be possible although they would have different execution times, as ?a? is executed three times in the latter case. To avoid such ambiguities, control flow in the PCM RDSEFF and usage model must be specified without backward references in the chain of AbstractActions. Branches, loops, forks, and their respective bodies have to be made explicit in the specification using nested ResourceDemandingBehaviours.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getPredecessor_AbstractAction <em>Predecessor Abstract Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getSuccessor_AbstractAction <em>Successor Abstract Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getResourceDemandingBehaviour_AbstractAction <em>Resource Demanding Behaviour Abstract Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractAction()
 * @model abstract="true"
 * @generated
 */
public interface AbstractAction extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getSuccessor_AbstractAction <em>Successor Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessor Abstract Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessor Abstract Action</em>' reference.
	 * @see #setPredecessor_AbstractAction(AbstractAction)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractAction_Predecessor_AbstractAction()
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractAction#getSuccessor_AbstractAction
	 * @model opposite="successor_AbstractAction" ordered="false"
	 * @generated
	 */
	AbstractAction getPredecessor_AbstractAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getPredecessor_AbstractAction <em>Predecessor Abstract Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predecessor Abstract Action</em>' reference.
	 * @see #getPredecessor_AbstractAction()
	 * @generated
	 */
	void setPredecessor_AbstractAction(AbstractAction value);

	/**
	 * Returns the value of the '<em><b>Successor Abstract Action</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getPredecessor_AbstractAction <em>Predecessor Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor Abstract Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor Abstract Action</em>' reference.
	 * @see #setSuccessor_AbstractAction(AbstractAction)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractAction_Successor_AbstractAction()
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractAction#getPredecessor_AbstractAction
	 * @model opposite="predecessor_AbstractAction" ordered="false"
	 * @generated
	 */
	AbstractAction getSuccessor_AbstractAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getSuccessor_AbstractAction <em>Successor Abstract Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor Abstract Action</em>' reference.
	 * @see #getSuccessor_AbstractAction()
	 * @generated
	 */
	void setSuccessor_AbstractAction(AbstractAction value);

	/**
	 * Returns the value of the '<em><b>Resource Demanding Behaviour Abstract Action</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour#getSteps_Behaviour <em>Steps Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Demanding Behaviour Abstract Action</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Demanding Behaviour Abstract Action</em>' container reference.
	 * @see #setResourceDemandingBehaviour_AbstractAction(ResourceDemandingBehaviour)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractAction_ResourceDemandingBehaviour_AbstractAction()
	 * @see de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour#getSteps_Behaviour
	 * @model opposite="steps_Behaviour" transient="false" ordered="false"
	 * @generated
	 */
	ResourceDemandingBehaviour getResourceDemandingBehaviour_AbstractAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getResourceDemandingBehaviour_AbstractAction <em>Resource Demanding Behaviour Abstract Action</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Demanding Behaviour Abstract Action</em>' container reference.
	 * @see #getResourceDemandingBehaviour_AbstractAction()
	 * @generated
	 */
	void setResourceDemandingBehaviour_AbstractAction(ResourceDemandingBehaviour value);

} // AbstractAction
