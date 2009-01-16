/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.AdvancedStatistics;
import de.uka.ipd.sdq.sensorframework.AggregatedMeasurements;
import de.uka.ipd.sdq.sensorframework.CollectedData;
import de.uka.ipd.sdq.sensorframework.DoubleEventTimes;
import de.uka.ipd.sdq.sensorframework.DoubleMeasurements;
import de.uka.ipd.sdq.sensorframework.EventTimeAggregation;
import de.uka.ipd.sdq.sensorframework.ExperimentGroup;
import de.uka.ipd.sdq.sensorframework.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.ExperimentSetting;
import de.uka.ipd.sdq.sensorframework.FixedWidthAggregation;
import de.uka.ipd.sdq.sensorframework.IncreasingMeasurableSensor;
import de.uka.ipd.sdq.sensorframework.Intervals;
import de.uka.ipd.sdq.sensorframework.JSXmlEventTimes;
import de.uka.ipd.sdq.sensorframework.JSXmlMeasurements;
import de.uka.ipd.sdq.sensorframework.LongMeasurements;
import de.uka.ipd.sdq.sensorframework.MeasurableSensor;
import de.uka.ipd.sdq.sensorframework.MeasureCharacterization;
import de.uka.ipd.sdq.sensorframework.MeasurementRange;
import de.uka.ipd.sdq.sensorframework.PersistenceKindOptions;
import de.uka.ipd.sdq.sensorframework.Propertyable;
import de.uka.ipd.sdq.sensorframework.RawMeasurements;
import de.uka.ipd.sdq.sensorframework.RawXValues;
import de.uka.ipd.sdq.sensorframework.RawYValues;
import de.uka.ipd.sdq.sensorframework.SensorDeclaration;
import de.uka.ipd.sdq.sensorframework.State;
import de.uka.ipd.sdq.sensorframework.StateMeasurements;
import de.uka.ipd.sdq.sensorframework.StateSensor;
import de.uka.ipd.sdq.sensorframework.Statistics;
import de.uka.ipd.sdq.sensorframework.ValueAggregation;
import de.uka.ipd.sdq.sensorframework.sensorframeworkFactory;
import de.uka.ipd.sdq.sensorframework.sensorframeworkPackage;

import de.uka.ipd.sdq.sensorframework.util.sensorframeworkValidator;

import java.util.Map;

import javax.measure.Measure;

import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;

import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class sensorframeworkPackageImpl extends EPackageImpl implements sensorframeworkPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregatedMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rawMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rawXValuesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rawYValuesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statisticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectedDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eStringtoEObjectMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sensorDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass experimentSettingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass experimentRunEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measureCharacterizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass experimentGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurableSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jsXmlMeasurementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventTimeAggregationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedWidthAggregationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intervalsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueAggregationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass increasingMeasurableSensorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass advancedStatisticsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jsXmlEventTimesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleEventTimesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ijsDurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ijsQuantityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum persistenceKindOptionsEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ejsMeasureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ejsDurationMeasureEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ejsUnitEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private sensorframeworkPackageImpl() {
		super(eNS_URI, sensorframeworkFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static sensorframeworkPackage init() {
		if (isInited) return (sensorframeworkPackage)EPackage.Registry.INSTANCE.getEPackage(sensorframeworkPackage.eNS_URI);

		// Obtain or create and register package
		sensorframeworkPackageImpl thesensorframeworkPackage = (sensorframeworkPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof sensorframeworkPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new sensorframeworkPackageImpl());

		isInited = true;

		// Create package meta-data objects
		thesensorframeworkPackage.createPackageContents();

		// Initialize created meta-data
		thesensorframeworkPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(thesensorframeworkPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return sensorframeworkValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		thesensorframeworkPackage.freeze();

		return thesensorframeworkPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregatedMeasurements() {
		return aggregatedMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregatedMeasurements_MeasurementRange() {
		return (EReference)aggregatedMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedMeasurements_DistinctValuesBeforeAggregation() {
		return (EAttribute)aggregatedMeasurementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregatedMeasurements_DistinctValuesAfterAggregation() {
		return (EAttribute)aggregatedMeasurementsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurementRange() {
		return measurementRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurementRange_RawMeasurements() {
		return (EReference)measurementRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurementRange_EndTime() {
		return (EAttribute)measurementRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurementRange_StartTime() {
		return (EAttribute)measurementRangeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurementRange_CollectedData() {
		return (EReference)measurementRangeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurementRange_AggregatedMeasurements() {
		return (EReference)measurementRangeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawMeasurements() {
		return rawMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawMeasurements_RawXValues() {
		return (EReference)rawMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawMeasurements_RawYValues() {
		return (EReference)rawMeasurementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawMeasurements_MeasurementRange() {
		return (EReference)rawMeasurementsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawXValues() {
		return rawXValuesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawYValues() {
		return rawYValuesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawYValues_Statistics() {
		return (EReference)rawYValuesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatistics() {
		return statisticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatistics_Minimum() {
		return (EAttribute)statisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatistics_Mean() {
		return (EAttribute)statisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatistics_Maximum() {
		return (EAttribute)statisticsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectedData() {
		return collectedDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectedData_Sensor() {
		return (EReference)collectedDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectedData_ExperimentRun() {
		return (EReference)collectedDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectedData_MeasurementRange() {
		return (EReference)collectedDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyable() {
		return propertyableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyable_AdditionalInformation() {
		return (EReference)propertyableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEStringtoEObjectMapEntry() {
		return eStringtoEObjectMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEStringtoEObjectMapEntry_Key() {
		return (EAttribute)eStringtoEObjectMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEStringtoEObjectMapEntry_Value() {
		return (EAttribute)eStringtoEObjectMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSensorDeclaration() {
		return sensorDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSensorDeclaration_OwningExperiment() {
		return (EReference)sensorDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSensorDeclaration_MeasureCharacterization() {
		return (EReference)sensorDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSensorDeclaration_PersistencyKind() {
		return (EAttribute)sensorDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExperimentSetting() {
		return experimentSettingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExperimentSetting_ExperimentName() {
		return (EAttribute)experimentSettingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperimentSetting_ExperimentRuns() {
		return (EReference)experimentSettingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperimentSetting_Sensors() {
		return (EReference)experimentSettingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExperimentRun() {
		return experimentRunEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperimentRun_CollectedData() {
		return (EReference)experimentRunEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExperimentRun_StartTime() {
		return (EAttribute)experimentRunEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExperimentRun_Duration() {
		return (EAttribute)experimentRunEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperimentRun_ExperimentSetting() {
		return (EReference)experimentRunEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasureCharacterization() {
		return measureCharacterizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureCharacterization_MeasuredObject() {
		return (EAttribute)measureCharacterizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasureCharacterization_Metric() {
		return (EAttribute)measureCharacterizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasureCharacterization_SensorDeclaration() {
		return (EReference)measureCharacterizationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongMeasurements() {
		return longMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongMeasurements_Value() {
		return (EAttribute)longMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getState() {
		return stateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_StateLiteral() {
		return (EAttribute)stateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateMeasurements() {
		return stateMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMeasurements_ObservedStates() {
		return (EReference)stateMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateSensor() {
		return stateSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateSensor_DefinedSensorStates() {
		return (EReference)stateSensorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateSensor_InitialState() {
		return (EReference)stateSensorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleMeasurements() {
		return doubleMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleMeasurements_Value() {
		return (EAttribute)doubleMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExperimentGroup() {
		return experimentGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperimentGroup_Experiments() {
		return (EReference)experimentGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurableSensor() {
		return measurableSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurableSensor_UnitOfMeasurements() {
		return (EAttribute)measurableSensorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJSXmlMeasurements() {
		return jsXmlMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJSXmlMeasurements_Value() {
		return (EAttribute)jsXmlMeasurementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventTimeAggregation() {
		return eventTimeAggregationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedWidthAggregation() {
		return fixedWidthAggregationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFixedWidthAggregation_RawYValues() {
		return (EReference)fixedWidthAggregationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFixedWidthAggregation_RawXValues() {
		return (EReference)fixedWidthAggregationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntervals() {
		return intervalsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervals_Offset() {
		return (EAttribute)intervalsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervals_IntervalWidth() {
		return (EAttribute)intervalsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervals_NumberOfIntervals() {
		return (EAttribute)intervalsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueAggregation() {
		return valueAggregationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIncreasingMeasurableSensor() {
		return increasingMeasurableSensorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdvancedStatistics() {
		return advancedStatisticsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdvancedStatistics_Median() {
		return (EAttribute)advancedStatisticsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdvancedStatistics_Variance() {
		return (EAttribute)advancedStatisticsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdvancedStatistics_StandardDeviation() {
		return (EAttribute)advancedStatisticsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJSXmlEventTimes() {
		return jsXmlEventTimesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJSXmlEventTimes_MeasurementTime() {
		return (EAttribute)jsXmlEventTimesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleEventTimes() {
		return doubleEventTimesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleEventTimes_MeasurementTime() {
		return (EAttribute)doubleEventTimesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIJSDuration() {
		return ijsDurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIJSQuantity() {
		return ijsQuantityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPersistenceKindOptions() {
		return persistenceKindOptionsEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEJSMeasure() {
		return ejsMeasureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEJSDurationMeasure() {
		return ejsDurationMeasureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEJSUnit() {
		return ejsUnitEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public sensorframeworkFactory getsensorframeworkFactory() {
		return (sensorframeworkFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		aggregatedMeasurementsEClass = createEClass(AGGREGATED_MEASUREMENTS);
		createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__MEASUREMENT_RANGE);
		createEAttribute(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_BEFORE_AGGREGATION);
		createEAttribute(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__DISTINCT_VALUES_AFTER_AGGREGATION);

		measurementRangeEClass = createEClass(MEASUREMENT_RANGE);
		createEReference(measurementRangeEClass, MEASUREMENT_RANGE__RAW_MEASUREMENTS);
		createEAttribute(measurementRangeEClass, MEASUREMENT_RANGE__END_TIME);
		createEAttribute(measurementRangeEClass, MEASUREMENT_RANGE__START_TIME);
		createEReference(measurementRangeEClass, MEASUREMENT_RANGE__COLLECTED_DATA);
		createEReference(measurementRangeEClass, MEASUREMENT_RANGE__AGGREGATED_MEASUREMENTS);

		rawMeasurementsEClass = createEClass(RAW_MEASUREMENTS);
		createEReference(rawMeasurementsEClass, RAW_MEASUREMENTS__RAW_XVALUES);
		createEReference(rawMeasurementsEClass, RAW_MEASUREMENTS__RAW_YVALUES);
		createEReference(rawMeasurementsEClass, RAW_MEASUREMENTS__MEASUREMENT_RANGE);

		rawXValuesEClass = createEClass(RAW_XVALUES);

		rawYValuesEClass = createEClass(RAW_YVALUES);
		createEReference(rawYValuesEClass, RAW_YVALUES__STATISTICS);

		statisticsEClass = createEClass(STATISTICS);
		createEAttribute(statisticsEClass, STATISTICS__MINIMUM);
		createEAttribute(statisticsEClass, STATISTICS__MEAN);
		createEAttribute(statisticsEClass, STATISTICS__MAXIMUM);

		collectedDataEClass = createEClass(COLLECTED_DATA);
		createEReference(collectedDataEClass, COLLECTED_DATA__SENSOR);
		createEReference(collectedDataEClass, COLLECTED_DATA__EXPERIMENT_RUN);
		createEReference(collectedDataEClass, COLLECTED_DATA__MEASUREMENT_RANGE);

		propertyableEClass = createEClass(PROPERTYABLE);
		createEReference(propertyableEClass, PROPERTYABLE__ADDITIONAL_INFORMATION);

		eStringtoEObjectMapEntryEClass = createEClass(ESTRINGTO_EOBJECT_MAP_ENTRY);
		createEAttribute(eStringtoEObjectMapEntryEClass, ESTRINGTO_EOBJECT_MAP_ENTRY__KEY);
		createEAttribute(eStringtoEObjectMapEntryEClass, ESTRINGTO_EOBJECT_MAP_ENTRY__VALUE);

		sensorDeclarationEClass = createEClass(SENSOR_DECLARATION);
		createEReference(sensorDeclarationEClass, SENSOR_DECLARATION__OWNING_EXPERIMENT);
		createEReference(sensorDeclarationEClass, SENSOR_DECLARATION__MEASURE_CHARACTERIZATION);
		createEAttribute(sensorDeclarationEClass, SENSOR_DECLARATION__PERSISTENCY_KIND);

		experimentSettingEClass = createEClass(EXPERIMENT_SETTING);
		createEAttribute(experimentSettingEClass, EXPERIMENT_SETTING__EXPERIMENT_NAME);
		createEReference(experimentSettingEClass, EXPERIMENT_SETTING__EXPERIMENT_RUNS);
		createEReference(experimentSettingEClass, EXPERIMENT_SETTING__SENSORS);

		experimentRunEClass = createEClass(EXPERIMENT_RUN);
		createEReference(experimentRunEClass, EXPERIMENT_RUN__COLLECTED_DATA);
		createEAttribute(experimentRunEClass, EXPERIMENT_RUN__START_TIME);
		createEAttribute(experimentRunEClass, EXPERIMENT_RUN__DURATION);
		createEReference(experimentRunEClass, EXPERIMENT_RUN__EXPERIMENT_SETTING);

		measureCharacterizationEClass = createEClass(MEASURE_CHARACTERIZATION);
		createEAttribute(measureCharacterizationEClass, MEASURE_CHARACTERIZATION__MEASURED_OBJECT);
		createEAttribute(measureCharacterizationEClass, MEASURE_CHARACTERIZATION__METRIC);
		createEReference(measureCharacterizationEClass, MEASURE_CHARACTERIZATION__SENSOR_DECLARATION);

		longMeasurementsEClass = createEClass(LONG_MEASUREMENTS);
		createEAttribute(longMeasurementsEClass, LONG_MEASUREMENTS__VALUE);

		stateEClass = createEClass(STATE);
		createEAttribute(stateEClass, STATE__STATE_LITERAL);

		stateMeasurementsEClass = createEClass(STATE_MEASUREMENTS);
		createEReference(stateMeasurementsEClass, STATE_MEASUREMENTS__OBSERVED_STATES);

		stateSensorEClass = createEClass(STATE_SENSOR);
		createEReference(stateSensorEClass, STATE_SENSOR__DEFINED_SENSOR_STATES);
		createEReference(stateSensorEClass, STATE_SENSOR__INITIAL_STATE);

		doubleMeasurementsEClass = createEClass(DOUBLE_MEASUREMENTS);
		createEAttribute(doubleMeasurementsEClass, DOUBLE_MEASUREMENTS__VALUE);

		experimentGroupEClass = createEClass(EXPERIMENT_GROUP);
		createEReference(experimentGroupEClass, EXPERIMENT_GROUP__EXPERIMENTS);

		measurableSensorEClass = createEClass(MEASURABLE_SENSOR);
		createEAttribute(measurableSensorEClass, MEASURABLE_SENSOR__UNIT_OF_MEASUREMENTS);

		jsXmlMeasurementsEClass = createEClass(JS_XML_MEASUREMENTS);
		createEAttribute(jsXmlMeasurementsEClass, JS_XML_MEASUREMENTS__VALUE);

		eventTimeAggregationEClass = createEClass(EVENT_TIME_AGGREGATION);

		fixedWidthAggregationEClass = createEClass(FIXED_WIDTH_AGGREGATION);
		createEReference(fixedWidthAggregationEClass, FIXED_WIDTH_AGGREGATION__RAW_YVALUES);
		createEReference(fixedWidthAggregationEClass, FIXED_WIDTH_AGGREGATION__RAW_XVALUES);

		intervalsEClass = createEClass(INTERVALS);
		createEAttribute(intervalsEClass, INTERVALS__OFFSET);
		createEAttribute(intervalsEClass, INTERVALS__INTERVAL_WIDTH);
		createEAttribute(intervalsEClass, INTERVALS__NUMBER_OF_INTERVALS);

		valueAggregationEClass = createEClass(VALUE_AGGREGATION);

		increasingMeasurableSensorEClass = createEClass(INCREASING_MEASURABLE_SENSOR);

		advancedStatisticsEClass = createEClass(ADVANCED_STATISTICS);
		createEAttribute(advancedStatisticsEClass, ADVANCED_STATISTICS__MEDIAN);
		createEAttribute(advancedStatisticsEClass, ADVANCED_STATISTICS__VARIANCE);
		createEAttribute(advancedStatisticsEClass, ADVANCED_STATISTICS__STANDARD_DEVIATION);

		jsXmlEventTimesEClass = createEClass(JS_XML_EVENT_TIMES);
		createEAttribute(jsXmlEventTimesEClass, JS_XML_EVENT_TIMES__MEASUREMENT_TIME);

		doubleEventTimesEClass = createEClass(DOUBLE_EVENT_TIMES);
		createEAttribute(doubleEventTimesEClass, DOUBLE_EVENT_TIMES__MEASUREMENT_TIME);

		ijsDurationEClass = createEClass(IJS_DURATION);

		ijsQuantityEClass = createEClass(IJS_QUANTITY);

		// Create enums
		persistenceKindOptionsEEnum = createEEnum(PERSISTENCE_KIND_OPTIONS);

		// Create data types
		ejsMeasureEDataType = createEDataType(EJS_MEASURE);
		ejsDurationMeasureEDataType = createEDataType(EJS_DURATION_MEASURE);
		ejsUnitEDataType = createEDataType(EJS_UNIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		collectedDataEClass.getESuperTypes().add(this.getPropertyable());
		experimentSettingEClass.getESuperTypes().add(this.getPropertyable());
		experimentRunEClass.getESuperTypes().add(this.getPropertyable());
		measureCharacterizationEClass.getESuperTypes().add(this.getPropertyable());
		longMeasurementsEClass.getESuperTypes().add(this.getRawYValues());
		stateMeasurementsEClass.getESuperTypes().add(this.getRawYValues());
		stateSensorEClass.getESuperTypes().add(this.getSensorDeclaration());
		doubleMeasurementsEClass.getESuperTypes().add(this.getRawYValues());
		experimentGroupEClass.getESuperTypes().add(this.getPropertyable());
		measurableSensorEClass.getESuperTypes().add(this.getSensorDeclaration());
		jsXmlMeasurementsEClass.getESuperTypes().add(this.getRawYValues());
		eventTimeAggregationEClass.getESuperTypes().add(this.getFixedWidthAggregation());
		fixedWidthAggregationEClass.getESuperTypes().add(this.getAggregatedMeasurements());
		intervalsEClass.getESuperTypes().add(this.getRawXValues());
		valueAggregationEClass.getESuperTypes().add(this.getFixedWidthAggregation());
		increasingMeasurableSensorEClass.getESuperTypes().add(this.getMeasurableSensor());
		advancedStatisticsEClass.getESuperTypes().add(this.getStatistics());
		jsXmlEventTimesEClass.getESuperTypes().add(this.getRawXValues());
		doubleEventTimesEClass.getESuperTypes().add(this.getRawXValues());

		// Initialize classes and features; add operations and parameters
		initEClass(aggregatedMeasurementsEClass, AggregatedMeasurements.class, "AggregatedMeasurements", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregatedMeasurements_MeasurementRange(), this.getMeasurementRange(), this.getMeasurementRange_AggregatedMeasurements(), "measurementRange", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAggregatedMeasurements_DistinctValuesBeforeAggregation(), ecorePackage.getELong(), "distinctValuesBeforeAggregation", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAggregatedMeasurements_DistinctValuesAfterAggregation(), ecorePackage.getELong(), "distinctValuesAfterAggregation", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measurementRangeEClass, MeasurementRange.class, "MeasurementRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeasurementRange_RawMeasurements(), this.getRawMeasurements(), this.getRawMeasurements_MeasurementRange(), "rawMeasurements", null, 0, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeasurementRange_EndTime(), this.getEJSDurationMeasure(), "endTime", null, 1, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeasurementRange_StartTime(), this.getEJSDurationMeasure(), "startTime", null, 1, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurementRange_CollectedData(), this.getCollectedData(), this.getCollectedData_MeasurementRange(), "collectedData", null, 1, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurementRange_AggregatedMeasurements(), this.getAggregatedMeasurements(), this.getAggregatedMeasurements_MeasurementRange(), "aggregatedMeasurements", null, 0, -1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rawMeasurementsEClass, RawMeasurements.class, "RawMeasurements", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRawMeasurements_RawXValues(), this.getRawXValues(), null, "rawXValues", null, 1, 1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawMeasurements_RawYValues(), this.getRawYValues(), null, "rawYValues", null, 1, 1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawMeasurements_MeasurementRange(), this.getMeasurementRange(), this.getMeasurementRange_RawMeasurements(), "measurementRange", null, 1, 1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rawXValuesEClass, RawXValues.class, "RawXValues", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rawYValuesEClass, RawYValues.class, "RawYValues", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRawYValues_Statistics(), this.getStatistics(), null, "statistics", null, 0, 1, RawYValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(rawYValuesEClass, ecorePackage.getEBoolean(), "Statisticsonlyformeasurablevalues", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(statisticsEClass, Statistics.class, "Statistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatistics_Minimum(), this.getEJSMeasure(), "minimum", null, 1, 1, Statistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStatistics_Mean(), this.getEJSMeasure(), "mean", null, 1, 1, Statistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStatistics_Maximum(), this.getEJSMeasure(), "maximum", null, 1, 1, Statistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(collectedDataEClass, CollectedData.class, "CollectedData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectedData_Sensor(), this.getSensorDeclaration(), null, "sensor", null, 1, 1, CollectedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollectedData_ExperimentRun(), this.getExperimentRun(), this.getExperimentRun_CollectedData(), "experimentRun", null, 1, 1, CollectedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollectedData_MeasurementRange(), this.getMeasurementRange(), this.getMeasurementRange_CollectedData(), "measurementRange", null, 0, -1, CollectedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyableEClass, Propertyable.class, "Propertyable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyable_AdditionalInformation(), this.getEStringtoEObjectMapEntry(), null, "additionalInformation", null, 0, -1, Propertyable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(eStringtoEObjectMapEntryEClass, Map.Entry.class, "EStringtoEObjectMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringtoEObjectMapEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEStringtoEObjectMapEntry_Value(), ecorePackage.getEJavaObject(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensorDeclarationEClass, SensorDeclaration.class, "SensorDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSensorDeclaration_OwningExperiment(), this.getExperimentSetting(), this.getExperimentSetting_Sensors(), "owningExperiment", null, 1, 1, SensorDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSensorDeclaration_MeasureCharacterization(), this.getMeasureCharacterization(), this.getMeasureCharacterization_SensorDeclaration(), "measureCharacterization", null, 1, 1, SensorDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSensorDeclaration_PersistencyKind(), this.getPersistenceKindOptions(), "persistencyKind", null, 1, 1, SensorDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(experimentSettingEClass, ExperimentSetting.class, "ExperimentSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExperimentSetting_ExperimentName(), ecorePackage.getEString(), "experimentName", null, 1, 1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentSetting_ExperimentRuns(), this.getExperimentRun(), this.getExperimentRun_ExperimentSetting(), "experimentRuns", null, 0, -1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentSetting_Sensors(), this.getSensorDeclaration(), this.getSensorDeclaration_OwningExperiment(), "sensors", null, 0, -1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(experimentRunEClass, ExperimentRun.class, "ExperimentRun", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExperimentRun_CollectedData(), this.getCollectedData(), this.getCollectedData_ExperimentRun(), "collectedData", null, 0, -1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExperimentRun_StartTime(), ecorePackage.getEDate(), "startTime", null, 1, 1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExperimentRun_Duration(), this.getEJSDurationMeasure(), "duration", null, 1, 1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentRun_ExperimentSetting(), this.getExperimentSetting(), this.getExperimentSetting_ExperimentRuns(), "experimentSetting", null, 1, 1, ExperimentRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(experimentRunEClass, ecorePackage.getEBoolean(), "ExactlyOneDataCollectionPerSensor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(measureCharacterizationEClass, MeasureCharacterization.class, "MeasureCharacterization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasureCharacterization_MeasuredObject(), ecorePackage.getEString(), "measuredObject", null, 1, 1, MeasureCharacterization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeasureCharacterization_Metric(), ecorePackage.getEString(), "metric", null, 1, 1, MeasureCharacterization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasureCharacterization_SensorDeclaration(), this.getSensorDeclaration(), this.getSensorDeclaration_MeasureCharacterization(), "sensorDeclaration", null, 1, 1, MeasureCharacterization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(longMeasurementsEClass, LongMeasurements.class, "LongMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLongMeasurements_Value(), ecorePackage.getELong(), "value", null, 0, -1, LongMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getState_StateLiteral(), ecorePackage.getEString(), "stateLiteral", null, 1, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stateMeasurementsEClass, StateMeasurements.class, "StateMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateMeasurements_ObservedStates(), this.getState(), null, "observedStates", null, 0, -1, StateMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stateSensorEClass, StateSensor.class, "StateSensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateSensor_DefinedSensorStates(), this.getState(), null, "definedSensorStates", null, 1, -1, StateSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStateSensor_InitialState(), this.getState(), null, "initialState", null, 1, 1, StateSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(stateSensorEClass, ecorePackage.getEBoolean(), "PersistenceKindOnlyEmfAllowed", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(doubleMeasurementsEClass, DoubleMeasurements.class, "DoubleMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleMeasurements_Value(), ecorePackage.getEDouble(), "value", null, 0, -1, DoubleMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(experimentGroupEClass, ExperimentGroup.class, "ExperimentGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExperimentGroup_Experiments(), this.getExperimentSetting(), null, "experiments", null, 0, -1, ExperimentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measurableSensorEClass, MeasurableSensor.class, "MeasurableSensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasurableSensor_UnitOfMeasurements(), this.getEJSUnit(), "unitOfMeasurements", null, 1, 1, MeasurableSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(measurableSensorEClass, ecorePackage.getEBoolean(), "PersistencyKindNotEmf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jsXmlMeasurementsEClass, JSXmlMeasurements.class, "JSXmlMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJSXmlMeasurements_Value(), this.getEJSMeasure(), "value", null, 1, 1, JSXmlMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(eventTimeAggregationEClass, EventTimeAggregation.class, "EventTimeAggregation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fixedWidthAggregationEClass, FixedWidthAggregation.class, "FixedWidthAggregation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFixedWidthAggregation_RawYValues(), this.getRawYValues(), null, "rawYValues", null, 1, 1, FixedWidthAggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFixedWidthAggregation_RawXValues(), this.getIntervals(), null, "rawXValues", null, 1, 1, FixedWidthAggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(intervalsEClass, Intervals.class, "Intervals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntervals_Offset(), this.getEJSMeasure(), "offset", null, 1, 1, Intervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervals_IntervalWidth(), this.getEJSMeasure(), "intervalWidth", null, 1, 1, Intervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervals_NumberOfIntervals(), ecorePackage.getELong(), "numberOfIntervals", null, 1, 1, Intervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(valueAggregationEClass, ValueAggregation.class, "ValueAggregation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(increasingMeasurableSensorEClass, IncreasingMeasurableSensor.class, "IncreasingMeasurableSensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(advancedStatisticsEClass, AdvancedStatistics.class, "AdvancedStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdvancedStatistics_Median(), this.getEJSMeasure(), "median", null, 1, 1, AdvancedStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAdvancedStatistics_Variance(), ecorePackage.getEDouble(), "variance", null, 1, 1, AdvancedStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAdvancedStatistics_StandardDeviation(), ecorePackage.getEDouble(), "standardDeviation", null, 1, 1, AdvancedStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(jsXmlEventTimesEClass, JSXmlEventTimes.class, "JSXmlEventTimes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJSXmlEventTimes_MeasurementTime(), this.getEJSDurationMeasure(), "measurementTime", null, 0, -1, JSXmlEventTimes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(doubleEventTimesEClass, DoubleEventTimes.class, "DoubleEventTimes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleEventTimes_MeasurementTime(), ecorePackage.getEDouble(), "measurementTime", null, 0, -1, DoubleEventTimes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ijsDurationEClass, Duration.class, "IJSDuration", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(ijsQuantityEClass, Quantity.class, "IJSQuantity", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(persistenceKindOptionsEEnum, PersistenceKindOptions.class, "PersistenceKindOptions");
		addEEnumLiteral(persistenceKindOptionsEEnum, PersistenceKindOptions.BINARY_LONG);
		addEEnumLiteral(persistenceKindOptionsEEnum, PersistenceKindOptions.BINARY_DOUBLE);
		addEEnumLiteral(persistenceKindOptionsEEnum, PersistenceKindOptions.XML_JSCIENCE);
		addEEnumLiteral(persistenceKindOptionsEEnum, PersistenceKindOptions.EMF);

		// Initialize data types
		initEDataType(ejsMeasureEDataType, Measure.class, "EJSMeasure", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ejsDurationMeasureEDataType, Measure.class, "EJSDurationMeasure", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ejsUnitEDataType, Unit.class, "EJSUnit", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //sensorframeworkPackageImpl
