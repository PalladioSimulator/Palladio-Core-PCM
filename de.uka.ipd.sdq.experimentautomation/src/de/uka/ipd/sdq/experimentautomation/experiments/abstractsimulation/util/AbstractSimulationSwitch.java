/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.util;

import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;

import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage
 * @generated
 */
public class AbstractSimulationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AbstractSimulationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractSimulationSwitch() {
		if (modelPackage == null) {
			modelPackage = AbstractSimulationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AbstractSimulationPackage.ABSTRACT_SIMULATION_CONFIGURATION: {
				AbstractSimulationConfiguration abstractSimulationConfiguration = (AbstractSimulationConfiguration)theEObject;
				T result = caseAbstractSimulationConfiguration(abstractSimulationConfiguration);
				if (result == null) result = caseToolConfiguration(abstractSimulationConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractSimulationPackage.PERSISTENCE_FRAMEWORK: {
				PersistenceFramework persistenceFramework = (PersistenceFramework)theEObject;
				T result = casePersistenceFramework(persistenceFramework);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractSimulationPackage.RANDOM_NUMBER_GENERATOR_SEED: {
				RandomNumberGeneratorSeed randomNumberGeneratorSeed = (RandomNumberGeneratorSeed)theEObject;
				T result = caseRandomNumberGeneratorSeed(randomNumberGeneratorSeed);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractSimulationPackage.PROBE_SPEC_CONFIGURATION: {
				ProbeSpecConfiguration probeSpecConfiguration = (ProbeSpecConfiguration)theEObject;
				T result = caseProbeSpecConfiguration(probeSpecConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractSimulationPackage.SENSOR_FRAMEWORK: {
				SensorFramework sensorFramework = (SensorFramework)theEObject;
				T result = caseSensorFramework(sensorFramework);
				if (result == null) result = casePersistenceFramework(sensorFramework);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractSimulationPackage.SENSOR_FRAMEWORK_DATASOURCE: {
				SensorFrameworkDatasource sensorFrameworkDatasource = (SensorFrameworkDatasource)theEObject;
				T result = caseSensorFrameworkDatasource(sensorFrameworkDatasource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractSimulationPackage.MEMORY_DATASOURCE: {
				MemoryDatasource memoryDatasource = (MemoryDatasource)theEObject;
				T result = caseMemoryDatasource(memoryDatasource);
				if (result == null) result = caseSensorFrameworkDatasource(memoryDatasource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractSimulationPackage.FILE_DATASOURCE: {
				FileDatasource fileDatasource = (FileDatasource)theEObject;
				T result = caseFileDatasource(fileDatasource);
				if (result == null) result = caseSensorFrameworkDatasource(fileDatasource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractSimulationPackage.MEASUREMENT_COUNT_STOP_CONDITION: {
				MeasurementCountStopCondition measurementCountStopCondition = (MeasurementCountStopCondition)theEObject;
				T result = caseMeasurementCountStopCondition(measurementCountStopCondition);
				if (result == null) result = caseStopCondition(measurementCountStopCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractSimulationPackage.SIM_TIME_STOP_CONDITION: {
				SimTimeStopCondition simTimeStopCondition = (SimTimeStopCondition)theEObject;
				T result = caseSimTimeStopCondition(simTimeStopCondition);
				if (result == null) result = caseStopCondition(simTimeStopCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AbstractSimulationPackage.STOP_CONDITION: {
				StopCondition stopCondition = (StopCondition)theEObject;
				T result = caseStopCondition(stopCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractSimulationConfiguration(AbstractSimulationConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Persistence Framework</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Persistence Framework</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePersistenceFramework(PersistenceFramework object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Number Generator Seed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Number Generator Seed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomNumberGeneratorSeed(RandomNumberGeneratorSeed object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Probe Spec Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Probe Spec Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProbeSpecConfiguration(ProbeSpecConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor Framework</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor Framework</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensorFramework(SensorFramework object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor Framework Datasource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor Framework Datasource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensorFrameworkDatasource(SensorFrameworkDatasource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Datasource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Datasource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryDatasource(MemoryDatasource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File Datasource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File Datasource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFileDatasource(FileDatasource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement Count Stop Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement Count Stop Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurementCountStopCondition(MeasurementCountStopCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sim Time Stop Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sim Time Stop Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimTimeStopCondition(SimTimeStopCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stop Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stop Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStopCondition(StopCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tool Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tool Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToolConfiguration(ToolConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //AbstractSimulationSwitch
