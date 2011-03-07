/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.taskmodel.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;

import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;

import de.uka.ipd.sdq.pcm.taskmodel.Edge;
import de.uka.ipd.sdq.pcm.taskmodel.Task;
import de.uka.ipd.sdq.pcm.taskmodel.taskmodelPackage;

import de.uka.ipd.sdq.pcm.taskmodel.util.taskmodelValidator;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskImpl#getProbabilityOfExecution <em>Probability Of Execution</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskImpl#getFailureProbability <em>Failure Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskImpl#getMeanDemandedTime <em>Mean Demanded Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskImpl#getRepositorycomponent <em>Repositorycomponent</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskImpl#getAllocationcontext <em>Allocationcontext</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskImpl#getEdge_Task <em>Edge Task</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.taskmodel.impl.TaskImpl#getAbstractaction <em>Abstractaction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImpl extends EObjectImpl implements Task {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProbabilityOfExecution() <em>Probability Of Execution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbabilityOfExecution()
	 * @generated
	 * @ordered
	 */
	protected static final double PROBABILITY_OF_EXECUTION_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProbabilityOfExecution() <em>Probability Of Execution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbabilityOfExecution()
	 * @generated
	 * @ordered
	 */
	protected double probabilityOfExecution = PROBABILITY_OF_EXECUTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getFailureProbability() <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double FAILURE_PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFailureProbability() <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureProbability()
	 * @generated
	 * @ordered
	 */
	protected double failureProbability = FAILURE_PROBABILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMeanDemandedTime() <em>Mean Demanded Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeanDemandedTime()
	 * @generated
	 * @ordered
	 */
	protected static final double MEAN_DEMANDED_TIME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMeanDemandedTime() <em>Mean Demanded Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeanDemandedTime()
	 * @generated
	 * @ordered
	 */
	protected double meanDemandedTime = MEAN_DEMANDED_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRepositorycomponent() <em>Repositorycomponent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositorycomponent()
	 * @generated
	 * @ordered
	 */
	protected RepositoryComponent repositorycomponent;

	/**
	 * The cached value of the '{@link #getAllocationcontext() <em>Allocationcontext</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationcontext()
	 * @generated
	 * @ordered
	 */
	protected AllocationContext allocationcontext;

	/**
	 * The cached value of the '{@link #getEdge_Task() <em>Edge Task</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdge_Task()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edge_Task;

	/**
	 * The cached value of the '{@link #getAbstractaction() <em>Abstractaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractaction()
	 * @generated
	 * @ordered
	 */
	protected AbstractAction abstractaction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return taskmodelPackage.Literals.TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, taskmodelPackage.TASK__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProbabilityOfExecution() {
		return probabilityOfExecution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbabilityOfExecution(double newProbabilityOfExecution) {
		double oldProbabilityOfExecution = probabilityOfExecution;
		probabilityOfExecution = newProbabilityOfExecution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, taskmodelPackage.TASK__PROBABILITY_OF_EXECUTION, oldProbabilityOfExecution, probabilityOfExecution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFailureProbability() {
		return failureProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureProbability(double newFailureProbability) {
		double oldFailureProbability = failureProbability;
		failureProbability = newFailureProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, taskmodelPackage.TASK__FAILURE_PROBABILITY, oldFailureProbability, failureProbability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMeanDemandedTime() {
		return meanDemandedTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeanDemandedTime(double newMeanDemandedTime) {
		double oldMeanDemandedTime = meanDemandedTime;
		meanDemandedTime = newMeanDemandedTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, taskmodelPackage.TASK__MEAN_DEMANDED_TIME, oldMeanDemandedTime, meanDemandedTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryComponent getRepositorycomponent() {
		if (repositorycomponent != null && repositorycomponent.eIsProxy()) {
			InternalEObject oldRepositorycomponent = (InternalEObject)repositorycomponent;
			repositorycomponent = (RepositoryComponent)eResolveProxy(oldRepositorycomponent);
			if (repositorycomponent != oldRepositorycomponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, taskmodelPackage.TASK__REPOSITORYCOMPONENT, oldRepositorycomponent, repositorycomponent));
			}
		}
		return repositorycomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryComponent basicGetRepositorycomponent() {
		return repositorycomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositorycomponent(RepositoryComponent newRepositorycomponent) {
		RepositoryComponent oldRepositorycomponent = repositorycomponent;
		repositorycomponent = newRepositorycomponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, taskmodelPackage.TASK__REPOSITORYCOMPONENT, oldRepositorycomponent, repositorycomponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext getAllocationcontext() {
		if (allocationcontext != null && allocationcontext.eIsProxy()) {
			InternalEObject oldAllocationcontext = (InternalEObject)allocationcontext;
			allocationcontext = (AllocationContext)eResolveProxy(oldAllocationcontext);
			if (allocationcontext != oldAllocationcontext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, taskmodelPackage.TASK__ALLOCATIONCONTEXT, oldAllocationcontext, allocationcontext));
			}
		}
		return allocationcontext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext basicGetAllocationcontext() {
		return allocationcontext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocationcontext(AllocationContext newAllocationcontext) {
		AllocationContext oldAllocationcontext = allocationcontext;
		allocationcontext = newAllocationcontext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, taskmodelPackage.TASK__ALLOCATIONCONTEXT, oldAllocationcontext, allocationcontext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdge_Task() {
		if (edge_Task == null) {
			edge_Task = new EObjectContainmentEList<Edge>(Edge.class, this, taskmodelPackage.TASK__EDGE_TASK);
		}
		return edge_Task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction getAbstractaction() {
		if (abstractaction != null && abstractaction.eIsProxy()) {
			InternalEObject oldAbstractaction = (InternalEObject)abstractaction;
			abstractaction = (AbstractAction)eResolveProxy(oldAbstractaction);
			if (abstractaction != oldAbstractaction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, taskmodelPackage.TASK__ABSTRACTACTION, oldAbstractaction, abstractaction));
			}
		}
		return abstractaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractAction basicGetAbstractaction() {
		return abstractaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstractaction(AbstractAction newAbstractaction) {
		AbstractAction oldAbstractaction = abstractaction;
		abstractaction = newAbstractaction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, taskmodelPackage.TASK__ABSTRACTACTION, oldAbstractaction, abstractaction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean sumOfProbabilitiesMustBeOne(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 taskmodelValidator.DIAGNOSTIC_SOURCE,
						 taskmodelValidator.TASK__SUM_OF_PROBABILITIES_MUST_BE_ONE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "sumOfProbabilitiesMustBeOne", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case taskmodelPackage.TASK__EDGE_TASK:
				return ((InternalEList<?>)getEdge_Task()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case taskmodelPackage.TASK__NAME:
				return getName();
			case taskmodelPackage.TASK__PROBABILITY_OF_EXECUTION:
				return getProbabilityOfExecution();
			case taskmodelPackage.TASK__FAILURE_PROBABILITY:
				return getFailureProbability();
			case taskmodelPackage.TASK__MEAN_DEMANDED_TIME:
				return getMeanDemandedTime();
			case taskmodelPackage.TASK__REPOSITORYCOMPONENT:
				if (resolve) return getRepositorycomponent();
				return basicGetRepositorycomponent();
			case taskmodelPackage.TASK__ALLOCATIONCONTEXT:
				if (resolve) return getAllocationcontext();
				return basicGetAllocationcontext();
			case taskmodelPackage.TASK__EDGE_TASK:
				return getEdge_Task();
			case taskmodelPackage.TASK__ABSTRACTACTION:
				if (resolve) return getAbstractaction();
				return basicGetAbstractaction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case taskmodelPackage.TASK__NAME:
				setName((String)newValue);
				return;
			case taskmodelPackage.TASK__PROBABILITY_OF_EXECUTION:
				setProbabilityOfExecution((Double)newValue);
				return;
			case taskmodelPackage.TASK__FAILURE_PROBABILITY:
				setFailureProbability((Double)newValue);
				return;
			case taskmodelPackage.TASK__MEAN_DEMANDED_TIME:
				setMeanDemandedTime((Double)newValue);
				return;
			case taskmodelPackage.TASK__REPOSITORYCOMPONENT:
				setRepositorycomponent((RepositoryComponent)newValue);
				return;
			case taskmodelPackage.TASK__ALLOCATIONCONTEXT:
				setAllocationcontext((AllocationContext)newValue);
				return;
			case taskmodelPackage.TASK__EDGE_TASK:
				getEdge_Task().clear();
				getEdge_Task().addAll((Collection<? extends Edge>)newValue);
				return;
			case taskmodelPackage.TASK__ABSTRACTACTION:
				setAbstractaction((AbstractAction)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case taskmodelPackage.TASK__NAME:
				setName(NAME_EDEFAULT);
				return;
			case taskmodelPackage.TASK__PROBABILITY_OF_EXECUTION:
				setProbabilityOfExecution(PROBABILITY_OF_EXECUTION_EDEFAULT);
				return;
			case taskmodelPackage.TASK__FAILURE_PROBABILITY:
				setFailureProbability(FAILURE_PROBABILITY_EDEFAULT);
				return;
			case taskmodelPackage.TASK__MEAN_DEMANDED_TIME:
				setMeanDemandedTime(MEAN_DEMANDED_TIME_EDEFAULT);
				return;
			case taskmodelPackage.TASK__REPOSITORYCOMPONENT:
				setRepositorycomponent((RepositoryComponent)null);
				return;
			case taskmodelPackage.TASK__ALLOCATIONCONTEXT:
				setAllocationcontext((AllocationContext)null);
				return;
			case taskmodelPackage.TASK__EDGE_TASK:
				getEdge_Task().clear();
				return;
			case taskmodelPackage.TASK__ABSTRACTACTION:
				setAbstractaction((AbstractAction)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case taskmodelPackage.TASK__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case taskmodelPackage.TASK__PROBABILITY_OF_EXECUTION:
				return probabilityOfExecution != PROBABILITY_OF_EXECUTION_EDEFAULT;
			case taskmodelPackage.TASK__FAILURE_PROBABILITY:
				return failureProbability != FAILURE_PROBABILITY_EDEFAULT;
			case taskmodelPackage.TASK__MEAN_DEMANDED_TIME:
				return meanDemandedTime != MEAN_DEMANDED_TIME_EDEFAULT;
			case taskmodelPackage.TASK__REPOSITORYCOMPONENT:
				return repositorycomponent != null;
			case taskmodelPackage.TASK__ALLOCATIONCONTEXT:
				return allocationcontext != null;
			case taskmodelPackage.TASK__EDGE_TASK:
				return edge_Task != null && !edge_Task.isEmpty();
			case taskmodelPackage.TASK__ABSTRACTACTION:
				return abstractaction != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", probabilityOfExecution: ");
		result.append(probabilityOfExecution);
		result.append(", failureProbability: ");
		result.append(failureProbability);
		result.append(", meanDemandedTime: ");
		result.append(meanDemandedTime);
		result.append(')');
		return result.toString();
	}

} //TaskImpl
