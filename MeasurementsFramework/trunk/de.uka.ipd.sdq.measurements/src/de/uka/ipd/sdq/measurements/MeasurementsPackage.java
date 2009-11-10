/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.measurements.MeasurementsFactory
 * @model kind="package"
 * @generated
 */
public interface MeasurementsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "measurements";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/MeasurementsFramework/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "measurements";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MeasurementsPackage eINSTANCE = de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.impl.MachineReferenceImpl <em>Machine Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.impl.MachineReferenceImpl
	 * @see de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl#getMachineReference()
	 * @generated
	 */
	int MACHINE_REFERENCE = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.impl.VirtualMachineReferenceImpl <em>Virtual Machine Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.impl.VirtualMachineReferenceImpl
	 * @see de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl#getVirtualMachineReference()
	 * @generated
	 */
	int VIRTUAL_MACHINE_REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_REFERENCE__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_REFERENCE__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Machine Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_REFERENCE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_REFERENCE__ID = MACHINE_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_REFERENCE__NAME = MACHINE_REFERENCE__NAME;

	/**
	 * The feature id for the '<em><b>Host Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_REFERENCE__HOST_MACHINE = MACHINE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Virtual Machine Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_REFERENCE_FEATURE_COUNT = MACHINE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.impl.PlainMachineReferenceImpl <em>Plain Machine Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.impl.PlainMachineReferenceImpl
	 * @see de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl#getPlainMachineReference()
	 * @generated
	 */
	int PLAIN_MACHINE_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_MACHINE_REFERENCE__ID = MACHINE_REFERENCE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_MACHINE_REFERENCE__NAME = MACHINE_REFERENCE__NAME;

	/**
	 * The number of structural features of the '<em>Plain Machine Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAIN_MACHINE_REFERENCE_FEATURE_COUNT = MACHINE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.impl.MeasurementScriptImpl <em>Measurement Script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.impl.MeasurementScriptImpl
	 * @see de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl#getMeasurementScript()
	 * @generated
	 */
	int MEASUREMENT_SCRIPT = 3;

	/**
	 * The feature id for the '<em><b>Task Sets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_SCRIPT__TASK_SETS = 0;

	/**
	 * The feature id for the '<em><b>Machine Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_SCRIPT__MACHINE_DESCRIPTIONS = 1;

	/**
	 * The number of structural features of the '<em>Measurement Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_SCRIPT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.impl.MachineDescriptionImpl <em>Machine Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.impl.MachineDescriptionImpl
	 * @see de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl#getMachineDescription()
	 * @generated
	 */
	int MACHINE_DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_DESCRIPTION__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_DESCRIPTION__PORT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_DESCRIPTION__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_DESCRIPTION__IP = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Machine Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_DESCRIPTION__MACHINE_MAPPINGS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Machine Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_DESCRIPTION_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.impl.MachineMappingImpl <em>Machine Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.impl.MachineMappingImpl
	 * @see de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl#getMachineMapping()
	 * @generated
	 */
	int MACHINE_MAPPING = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_MAPPING__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Machine Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_MAPPING__MACHINE_REFERENCE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Machine Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_MAPPING_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.VirtualMachineReference <em>Virtual Machine Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Machine Reference</em>'.
	 * @see de.uka.ipd.sdq.measurements.VirtualMachineReference
	 * @generated
	 */
	EClass getVirtualMachineReference();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.measurements.VirtualMachineReference#getHostMachine <em>Host Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Host Machine</em>'.
	 * @see de.uka.ipd.sdq.measurements.VirtualMachineReference#getHostMachine()
	 * @see #getVirtualMachineReference()
	 * @generated
	 */
	EReference getVirtualMachineReference_HostMachine();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.MachineReference <em>Machine Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Reference</em>'.
	 * @see de.uka.ipd.sdq.measurements.MachineReference
	 * @generated
	 */
	EClass getMachineReference();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.measurements.MachineReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.measurements.MachineReference#getName()
	 * @see #getMachineReference()
	 * @generated
	 */
	EAttribute getMachineReference_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.PlainMachineReference <em>Plain Machine Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plain Machine Reference</em>'.
	 * @see de.uka.ipd.sdq.measurements.PlainMachineReference
	 * @generated
	 */
	EClass getPlainMachineReference();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.MeasurementScript <em>Measurement Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement Script</em>'.
	 * @see de.uka.ipd.sdq.measurements.MeasurementScript
	 * @generated
	 */
	EClass getMeasurementScript();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.measurements.MeasurementScript#getTaskSets <em>Task Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Task Sets</em>'.
	 * @see de.uka.ipd.sdq.measurements.MeasurementScript#getTaskSets()
	 * @see #getMeasurementScript()
	 * @generated
	 */
	EReference getMeasurementScript_TaskSets();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.measurements.MeasurementScript#getMachineDescriptions <em>Machine Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machine Descriptions</em>'.
	 * @see de.uka.ipd.sdq.measurements.MeasurementScript#getMachineDescriptions()
	 * @see #getMeasurementScript()
	 * @generated
	 */
	EReference getMeasurementScript_MachineDescriptions();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.MachineDescription <em>Machine Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Description</em>'.
	 * @see de.uka.ipd.sdq.measurements.MachineDescription
	 * @generated
	 */
	EClass getMachineDescription();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.measurements.MachineDescription#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see de.uka.ipd.sdq.measurements.MachineDescription#getPort()
	 * @see #getMachineDescription()
	 * @generated
	 */
	EAttribute getMachineDescription_Port();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.measurements.MachineDescription#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.measurements.MachineDescription#getName()
	 * @see #getMachineDescription()
	 * @generated
	 */
	EAttribute getMachineDescription_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.measurements.MachineDescription#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see de.uka.ipd.sdq.measurements.MachineDescription#getIp()
	 * @see #getMachineDescription()
	 * @generated
	 */
	EAttribute getMachineDescription_Ip();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.measurements.MachineDescription#getMachineMappings <em>Machine Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machine Mappings</em>'.
	 * @see de.uka.ipd.sdq.measurements.MachineDescription#getMachineMappings()
	 * @see #getMachineDescription()
	 * @generated
	 */
	EReference getMachineDescription_MachineMappings();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.MachineMapping <em>Machine Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Mapping</em>'.
	 * @see de.uka.ipd.sdq.measurements.MachineMapping
	 * @generated
	 */
	EClass getMachineMapping();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.measurements.MachineMapping#getMachineReference <em>Machine Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Machine Reference</em>'.
	 * @see de.uka.ipd.sdq.measurements.MachineMapping#getMachineReference()
	 * @see #getMachineMapping()
	 * @generated
	 */
	EReference getMachineMapping_MachineReference();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MeasurementsFactory getMeasurementsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.impl.VirtualMachineReferenceImpl <em>Virtual Machine Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.impl.VirtualMachineReferenceImpl
		 * @see de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl#getVirtualMachineReference()
		 * @generated
		 */
		EClass VIRTUAL_MACHINE_REFERENCE = eINSTANCE.getVirtualMachineReference();

		/**
		 * The meta object literal for the '<em><b>Host Machine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VIRTUAL_MACHINE_REFERENCE__HOST_MACHINE = eINSTANCE.getVirtualMachineReference_HostMachine();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.impl.MachineReferenceImpl <em>Machine Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.impl.MachineReferenceImpl
		 * @see de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl#getMachineReference()
		 * @generated
		 */
		EClass MACHINE_REFERENCE = eINSTANCE.getMachineReference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE_REFERENCE__NAME = eINSTANCE.getMachineReference_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.impl.PlainMachineReferenceImpl <em>Plain Machine Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.impl.PlainMachineReferenceImpl
		 * @see de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl#getPlainMachineReference()
		 * @generated
		 */
		EClass PLAIN_MACHINE_REFERENCE = eINSTANCE.getPlainMachineReference();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.impl.MeasurementScriptImpl <em>Measurement Script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.impl.MeasurementScriptImpl
		 * @see de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl#getMeasurementScript()
		 * @generated
		 */
		EClass MEASUREMENT_SCRIPT = eINSTANCE.getMeasurementScript();

		/**
		 * The meta object literal for the '<em><b>Task Sets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT_SCRIPT__TASK_SETS = eINSTANCE.getMeasurementScript_TaskSets();

		/**
		 * The meta object literal for the '<em><b>Machine Descriptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT_SCRIPT__MACHINE_DESCRIPTIONS = eINSTANCE.getMeasurementScript_MachineDescriptions();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.impl.MachineDescriptionImpl <em>Machine Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.impl.MachineDescriptionImpl
		 * @see de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl#getMachineDescription()
		 * @generated
		 */
		EClass MACHINE_DESCRIPTION = eINSTANCE.getMachineDescription();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE_DESCRIPTION__PORT = eINSTANCE.getMachineDescription_Port();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE_DESCRIPTION__NAME = eINSTANCE.getMachineDescription_Name();

		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE_DESCRIPTION__IP = eINSTANCE.getMachineDescription_Ip();

		/**
		 * The meta object literal for the '<em><b>Machine Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_DESCRIPTION__MACHINE_MAPPINGS = eINSTANCE.getMachineDescription_MachineMappings();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.impl.MachineMappingImpl <em>Machine Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.impl.MachineMappingImpl
		 * @see de.uka.ipd.sdq.measurements.impl.MeasurementsPackageImpl#getMachineMapping()
		 * @generated
		 */
		EClass MACHINE_MAPPING = eINSTANCE.getMachineMapping();

		/**
		 * The meta object literal for the '<em><b>Machine Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_MAPPING__MACHINE_REFERENCE = eINSTANCE.getMachineMapping_MachineReference();

	}

} //MeasurementsPackage
