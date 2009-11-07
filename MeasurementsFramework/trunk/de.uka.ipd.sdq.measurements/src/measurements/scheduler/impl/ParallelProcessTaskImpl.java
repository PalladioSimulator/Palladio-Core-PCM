/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package measurements.scheduler.impl;

import measurements.impl.ParallelTaskImpl;

import measurements.scheduler.ParallelProcessTask;
import measurements.scheduler.SchedulerPackage;

import org.eclipse.emf.ecore.EClass;

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
