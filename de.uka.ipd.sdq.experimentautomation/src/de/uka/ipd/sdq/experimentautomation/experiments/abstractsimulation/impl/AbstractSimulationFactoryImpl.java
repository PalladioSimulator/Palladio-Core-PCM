/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractSimulationFactoryImpl extends EFactoryImpl implements AbstractSimulationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AbstractSimulationFactory init() {
		try {
			AbstractSimulationFactory theAbstractSimulationFactory = (AbstractSimulationFactory)EPackage.Registry.INSTANCE.getEFactory(AbstractSimulationPackage.eNS_URI);
			if (theAbstractSimulationFactory != null) {
				return theAbstractSimulationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AbstractSimulationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractSimulationFactoryImpl() {
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
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED: return createRandomNumberGeneratorSeed();
			case AbstractSimulationPackage.PROBE_SPEC_CONFIGURATION: return createProbeSpecConfiguration();
			case AbstractSimulationPackage.SENSOR_FRAMEWORK: return createSensorFramework();
			case AbstractSimulationPackage.MEMORY_DATASOURCE: return createMemoryDatasource();
			case AbstractSimulationPackage.FILE_DATASOURCE: return createFileDatasource();
			case AbstractSimulationPackage.MEASUREMENT_COUNT_STOP_CONDITION: return createMeasurementCountStopCondition();
			case AbstractSimulationPackage.SIM_TIME_STOP_CONDITION: return createSimTimeStopCondition();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case AbstractSimulationPackage.BLACKBOARD_TYPE:
				return createBlackboardTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case AbstractSimulationPackage.BLACKBOARD_TYPE:
				return convertBlackboardTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomNumberGeneratorSeed createRandomNumberGeneratorSeed() {
		RandomNumberGeneratorSeedImpl randomNumberGeneratorSeed = new RandomNumberGeneratorSeedImpl();
		return randomNumberGeneratorSeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbeSpecConfiguration createProbeSpecConfiguration() {
		ProbeSpecConfigurationImpl probeSpecConfiguration = new ProbeSpecConfigurationImpl();
		return probeSpecConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorFramework createSensorFramework() {
		SensorFrameworkImpl sensorFramework = new SensorFrameworkImpl();
		return sensorFramework;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryDatasource createMemoryDatasource() {
		MemoryDatasourceImpl memoryDatasource = new MemoryDatasourceImpl();
		return memoryDatasource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileDatasource createFileDatasource() {
		FileDatasourceImpl fileDatasource = new FileDatasourceImpl();
		return fileDatasource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementCountStopCondition createMeasurementCountStopCondition() {
		MeasurementCountStopConditionImpl measurementCountStopCondition = new MeasurementCountStopConditionImpl();
		return measurementCountStopCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimTimeStopCondition createSimTimeStopCondition() {
		SimTimeStopConditionImpl simTimeStopCondition = new SimTimeStopConditionImpl();
		return simTimeStopCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlackboardType createBlackboardTypeFromString(EDataType eDataType, String initialValue) {
		BlackboardType result = BlackboardType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBlackboardTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractSimulationPackage getAbstractSimulationPackage() {
		return (AbstractSimulationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AbstractSimulationPackage getPackage() {
		return AbstractSimulationPackage.eINSTANCE;
	}

} //AbstractSimulationFactoryImpl
