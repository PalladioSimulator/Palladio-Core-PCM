/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.measurements.MachineDescription;
import de.uka.ipd.sdq.measurements.MachineMapping;
import de.uka.ipd.sdq.measurements.MeasurementScript;
import de.uka.ipd.sdq.measurements.MeasurementsFactory;
import de.uka.ipd.sdq.measurements.MeasurementsPackage;
import de.uka.ipd.sdq.measurements.PlainMachineReference;
import de.uka.ipd.sdq.measurements.VirtualMachineReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MeasurementsFactoryImpl extends EFactoryImpl implements MeasurementsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MeasurementsFactory init() {
		try {
			MeasurementsFactory theMeasurementsFactory = (MeasurementsFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/MeasurementsFramework/1.0"); 
			if (theMeasurementsFactory != null) {
				return theMeasurementsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MeasurementsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MeasurementsPackage.VIRTUAL_MACHINE_REFERENCE: return createVirtualMachineReference();
			case MeasurementsPackage.PLAIN_MACHINE_REFERENCE: return createPlainMachineReference();
			case MeasurementsPackage.MEASUREMENT_SCRIPT: return createMeasurementScript();
			case MeasurementsPackage.MACHINE_DESCRIPTION: return createMachineDescription();
			case MeasurementsPackage.MACHINE_MAPPING: return createMachineMapping();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VirtualMachineReference createVirtualMachineReference() {
		VirtualMachineReferenceImpl virtualMachineReference = new VirtualMachineReferenceImpl();
		return virtualMachineReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlainMachineReference createPlainMachineReference() {
		PlainMachineReferenceImpl plainMachineReference = new PlainMachineReferenceImpl();
		return plainMachineReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementScript createMeasurementScript() {
		MeasurementScriptImpl measurementScript = new MeasurementScriptImpl();
		return measurementScript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MachineDescription createMachineDescription() {
		MachineDescriptionImpl machineDescription = new MachineDescriptionImpl();
		return machineDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MachineMapping createMachineMapping() {
		MachineMappingImpl machineMapping = new MachineMappingImpl();
		return machineMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementsPackage getMeasurementsPackage() {
		return (MeasurementsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MeasurementsPackage getPackage() {
		return MeasurementsPackage.eINSTANCE;
	}

} //MeasurementsFactoryImpl
