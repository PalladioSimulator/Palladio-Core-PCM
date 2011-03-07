/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.taskmodel;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;

import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Representation of a task in the performance model. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getProbabilityOfExecution <em>Probability Of Execution</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getFailureProbability <em>Failure Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getMeanDemandedTime <em>Mean Demanded Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getRepositorycomponent <em>Repositorycomponent</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getAllocationcontext <em>Allocationcontext</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getEdge_Task <em>Edge Task</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getAbstractaction <em>Abstractaction</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTask_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Probability Of Execution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Gives the overall probability of execution, which can be derived from the transition probability of the edges leading to this Task. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Probability Of Execution</em>' attribute.
	 * @see #setProbabilityOfExecution(double)
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTask_ProbabilityOfExecution()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getProbabilityOfExecution();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getProbabilityOfExecution <em>Probability Of Execution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability Of Execution</em>' attribute.
	 * @see #getProbabilityOfExecution()
	 * @generated
	 */
	void setProbabilityOfExecution(double value);

	/**
	 * Returns the value of the '<em><b>Failure Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The software failure probability of this task. This does not take into account hardware failures. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Failure Probability</em>' attribute.
	 * @see #setFailureProbability(double)
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTask_FailureProbability()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getFailureProbability();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getFailureProbability <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Failure Probability</em>' attribute.
	 * @see #getFailureProbability()
	 * @generated
	 */
	void setFailureProbability(double value);

	/**
	 * Returns the value of the '<em><b>Mean Demanded Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The mean demanded time that this task demands from the CPU it is deployed on. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Mean Demanded Time</em>' attribute.
	 * @see #setMeanDemandedTime(double)
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTask_MeanDemandedTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getMeanDemandedTime();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getMeanDemandedTime <em>Mean Demanded Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mean Demanded Time</em>' attribute.
	 * @see #getMeanDemandedTime()
	 * @generated
	 */
	void setMeanDemandedTime(double value);

	/**
	 * Returns the value of the '<em><b>Repositorycomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The PCM component that this Task derives from. This association is needed to determine which tasks can be deployed on which hardware nodes (servers, ResourceContainers). The design decision model defines the allocation of components only. With this link, you can derive the allocation of tasks. Also, this link is needed to map the results of the optmisation back to the PCM model later. Results that allocate two Tasks belonging to the same PCM component to different servers is not valid in the PCM. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Repositorycomponent</em>' reference.
	 * @see #setRepositorycomponent(RepositoryComponent)
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTask_Repositorycomponent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RepositoryComponent getRepositorycomponent();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getRepositorycomponent <em>Repositorycomponent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repositorycomponent</em>' reference.
	 * @see #getRepositorycomponent()
	 * @generated
	 */
	void setRepositorycomponent(RepositoryComponent value);

	/**
	 * Returns the value of the '<em><b>Allocationcontext</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This association points to the AllocationContext of this Task the PCM model. Using it, you can determine the ResourceContainer (i.e. hardware node, the server) that this Task is deployed on. Use myTask.getAllocationcontext.getResourceContainer_AllocationContext to retrieve the hardware node. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Allocationcontext</em>' reference.
	 * @see #setAllocationcontext(AllocationContext)
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTask_Allocationcontext()
	 * @model ordered="false"
	 * @generated
	 */
	AllocationContext getAllocationcontext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getAllocationcontext <em>Allocationcontext</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocationcontext</em>' reference.
	 * @see #getAllocationcontext()
	 * @generated
	 */
	void setAllocationcontext(AllocationContext value);

	/**
	 * Returns the value of the '<em><b>Edge Task</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.taskmodel.Edge}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The outgoing Edges of this Task. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Edge Task</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTask_Edge_Task()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Edge> getEdge_Task();

	/**
	 * Returns the value of the '<em><b>Abstractaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The SEFF action that this Task was transformed from. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Abstractaction</em>' reference.
	 * @see #setAbstractaction(AbstractAction)
	 * @see de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage#getTask_Abstractaction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractAction getAbstractaction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.taskmodel.Task#getAbstractaction <em>Abstractaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstractaction</em>' reference.
	 * @see #getAbstractaction()
	 * @generated
	 */
	void setAbstractaction(AbstractAction value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.edge_Task->collect(e|e.transitionProbability)->sum()=1 or self.edge_Task->isEmpty() 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean sumOfProbabilitiesMustBeOne(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Task
