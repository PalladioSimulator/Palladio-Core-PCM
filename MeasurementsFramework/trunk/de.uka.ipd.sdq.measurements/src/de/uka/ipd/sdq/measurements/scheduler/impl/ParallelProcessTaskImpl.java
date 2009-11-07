/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.scheduler.impl;

import org.eclipse.emf.ecore.EClass;

import de.uka.ipd.sdq.measurements.scheduler.ParallelProcessTask;
import de.uka.ipd.sdq.measurements.scheduler.SchedulerPackage;
import de.uka.ipd.sdq.measurements.tasks.impl.ParallelTaskImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parallel Process Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ParallelProcessTaskImpl extends ParallelTaskImpl implements ParallelProcessTask {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParallelProcessTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.PARALLEL_PROCESS_TASK;
	}

} //ParallelProcessTaskImpl
