/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage
 * @generated
 */
public interface MeasurementsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MeasurementsFactory eINSTANCE = de.uka.ipd.sdq.measurements.impl.MeasurementsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Virtual Machine Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Virtual Machine Reference</em>'.
	 * @generated
	 */
	VirtualMachineReference createVirtualMachineReference();

	/**
	 * Returns a new object of class '<em>Plain Machine Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plain Machine Reference</em>'.
	 * @generated
	 */
	PlainMachineReference createPlainMachineReference();

	/**
	 * Returns a new object of class '<em>Task Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Set</em>'.
	 * @generated
	 */
	TaskSet createTaskSet();

	/**
	 * Returns a new object of class '<em>Sequence Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Task</em>'.
	 * @generated
	 */
	SequenceTask createSequenceTask();

	/**
	 * Returns a new object of class '<em>Parallel Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parallel Task</em>'.
	 * @generated
	 */
	ParallelTask createParallelTask();

	/**
	 * Returns a new object of class '<em>Measurement Script</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Measurement Script</em>'.
	 * @generated
	 */
	MeasurementScript createMeasurementScript();

	/**
	 * Returns a new object of class '<em>Machine Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Machine Description</em>'.
	 * @generated
	 */
	MachineDescription createMachineDescription();

	/**
	 * Returns a new object of class '<em>Machine Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Machine Mapping</em>'.
	 * @generated
	 */
	MachineMapping createMachineMapping();

	/**
	 * Returns a new object of class '<em>Loop Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Task</em>'.
	 * @generated
	 */
	LoopTask createLoopTask();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MeasurementsPackage getMeasurementsPackage();

} //MeasurementsFactory
