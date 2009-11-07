/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.scheduler.impl;

import de.uka.ipd.sdq.measurements.impl.ParallelTaskImpl;

import de.uka.ipd.sdq.measurements.scheduler.ParallelProcessTask;
import de.uka.ipd.sdq.measurements.scheduler.schedulerPackage;

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
		return schedulerPackage.Literals.PARALLEL_PROCESS_TASK;
	}

} //ParallelProcessTaskImpl
