/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel.impl;

import de.uka.ipd.sdq.sensorframework.models.emfmodel.AdvancedStatistics;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.AggregatedMeasurements;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.AggregationCharacterization;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.CollectedData;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.DoubleBinaryEventTimes;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.DoubleBinaryMeasurements;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.EventTimeAggregation;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.ExperimentSetting;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.FixedWidthAggregation;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.Identifiable;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.IncreasingMeasurableSensor;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.Intervals;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.JSXmlMeasurements;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.LongBinaryMeasurements;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasurableSensor;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasureCharacterization;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.MeasurementRange;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.PersistenceKindOptions;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.Propertyable;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.RawMeasurements;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.RawXValues;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.RawYValues;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.SensorDeclaration;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.State;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.StateMeasurements;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.StateSensor;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.Statistics;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.ValueAggregation;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelFactory;
import de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage;

import de.uka.ipd.sdq.sensorframework.models.emfmodel.util.emfmodelValidator;

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
public class emfmodelPackageImpl extends EPackageImpl implements emfmodelPackage {
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
	private EClass identifiableEClass = null;

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
	private EClass aggregationCharacterizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longBinaryMeasurementsEClass = null;

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
	private EClass doubleBinaryMeasurementsEClass = null;

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
	private EClass doubleBinaryEventTimesEClass = null;

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
	 * @see de.uka.ipd.sdq.sensorframework.models.emfmodel.emfmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private emfmodelPackageImpl() {
		super(eNS_URI, emfmodelFactory.eINSTANCE);
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
	public static emfmodelPackage init() {
		if (isInited) return (emfmodelPackage)EPackage.Registry.INSTANCE.getEPackage(emfmodelPackage.eNS_URI);

		// Obtain or create and register package
		emfmodelPackageImpl theemfmodelPackage = (emfmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof emfmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new emfmodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theemfmodelPackage.createPackageContents();

		// Initialize created meta-data
		theemfmodelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theemfmodelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return emfmodelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theemfmodelPackage.freeze();

		return theemfmodelPackage;
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
	public EReference getAggregatedMeasurements_AggregationCharacterization() {
		return (EReference)aggregatedMeasurementsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiable() {
		return identifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifiable_Id() {
		return (EAttribute)identifiableEClass.getEStructuralFeatures().get(0);
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
	public EReference getRawXValues_RawMeasurements() {
		return (EReference)rawXValuesEClass.getEStructuralFeatures().get(0);
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
	public EReference getRawYValues_AggregatedMeasurements() {
		return (EReference)rawYValuesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawYValues_RawMeasurements() {
		return (EReference)rawYValuesEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getStatistics_Sum() {
		return (EAttribute)statisticsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStatistics_Count() {
		return (EAttribute)statisticsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStatistics_RawYValues() {
		return (EReference)statisticsEClass.getEStructuralFeatures().get(5);
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
	public EReference getFixedWidthAggregation_RawXValues() {
		return (EReference)fixedWidthAggregationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFixedWidthAggregation_RawYValues() {
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
	public EAttribute getIntervals_LowerBound() {
		return (EAttribute)intervalsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntervals_Width() {
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
	public EReference getIntervals_AggregatedMeasurements() {
		return (EReference)intervalsEClass.getEStructuralFeatures().get(3);
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
	public EReference getCollectedData_SensorDeclaration() {
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
	public EReference getSensorDeclaration_ExperimentSetting() {
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
	public EClass getAggregationCharacterization() {
		return aggregationCharacterizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAggregationCharacterization_Function() {
		return (EAttribute)aggregationCharacterizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregationCharacterization_AggregatedMeasurements() {
		return (EReference)aggregationCharacterizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongBinaryMeasurements() {
		return longBinaryMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongBinaryMeasurements_Unit() {
		return (EAttribute)longBinaryMeasurementsEClass.getEStructuralFeatures().get(0);
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
	public EClass getDoubleBinaryMeasurements() {
		return doubleBinaryMeasurementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleBinaryMeasurements_Unit() {
		return (EAttribute)doubleBinaryMeasurementsEClass.getEStructuralFeatures().get(0);
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
	public EReference getExperimentGroup_ExperimentSettings() {
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
	public EAttribute getJSXmlMeasurements_Values() {
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
	public EClass getDoubleBinaryEventTimes() {
		return doubleBinaryEventTimesEClass;
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
	public emfmodelFactory getemfmodelFactory() {
		return (emfmodelFactory)getEFactoryInstance();
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
		createEReference(aggregatedMeasurementsEClass, AGGREGATED_MEASUREMENTS__AGGREGATION_CHARACTERIZATION);

		identifiableEClass = createEClass(IDENTIFIABLE);
		createEAttribute(identifiableEClass, IDENTIFIABLE__ID);

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
		createEReference(rawXValuesEClass, RAW_XVALUES__RAW_MEASUREMENTS);

		rawYValuesEClass = createEClass(RAW_YVALUES);
		createEReference(rawYValuesEClass, RAW_YVALUES__STATISTICS);
		createEReference(rawYValuesEClass, RAW_YVALUES__AGGREGATED_MEASUREMENTS);
		createEReference(rawYValuesEClass, RAW_YVALUES__RAW_MEASUREMENTS);

		statisticsEClass = createEClass(STATISTICS);
		createEAttribute(statisticsEClass, STATISTICS__MINIMUM);
		createEAttribute(statisticsEClass, STATISTICS__MEAN);
		createEAttribute(statisticsEClass, STATISTICS__MAXIMUM);
		createEAttribute(statisticsEClass, STATISTICS__SUM);
		createEAttribute(statisticsEClass, STATISTICS__COUNT);
		createEReference(statisticsEClass, STATISTICS__RAW_YVALUES);

		fixedWidthAggregationEClass = createEClass(FIXED_WIDTH_AGGREGATION);
		createEReference(fixedWidthAggregationEClass, FIXED_WIDTH_AGGREGATION__RAW_XVALUES);
		createEReference(fixedWidthAggregationEClass, FIXED_WIDTH_AGGREGATION__RAW_YVALUES);

		intervalsEClass = createEClass(INTERVALS);
		createEAttribute(intervalsEClass, INTERVALS__LOWER_BOUND);
		createEAttribute(intervalsEClass, INTERVALS__WIDTH);
		createEAttribute(intervalsEClass, INTERVALS__NUMBER_OF_INTERVALS);
		createEReference(intervalsEClass, INTERVALS__AGGREGATED_MEASUREMENTS);

		collectedDataEClass = createEClass(COLLECTED_DATA);
		createEReference(collectedDataEClass, COLLECTED_DATA__SENSOR_DECLARATION);
		createEReference(collectedDataEClass, COLLECTED_DATA__EXPERIMENT_RUN);
		createEReference(collectedDataEClass, COLLECTED_DATA__MEASUREMENT_RANGE);

		propertyableEClass = createEClass(PROPERTYABLE);
		createEReference(propertyableEClass, PROPERTYABLE__ADDITIONAL_INFORMATION);

		eStringtoEObjectMapEntryEClass = createEClass(ESTRINGTO_EOBJECT_MAP_ENTRY);
		createEAttribute(eStringtoEObjectMapEntryEClass, ESTRINGTO_EOBJECT_MAP_ENTRY__KEY);
		createEAttribute(eStringtoEObjectMapEntryEClass, ESTRINGTO_EOBJECT_MAP_ENTRY__VALUE);

		sensorDeclarationEClass = createEClass(SENSOR_DECLARATION);
		createEReference(sensorDeclarationEClass, SENSOR_DECLARATION__EXPERIMENT_SETTING);
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

		aggregationCharacterizationEClass = createEClass(AGGREGATION_CHARACTERIZATION);
		createEAttribute(aggregationCharacterizationEClass, AGGREGATION_CHARACTERIZATION__FUNCTION);
		createEReference(aggregationCharacterizationEClass, AGGREGATION_CHARACTERIZATION__AGGREGATED_MEASUREMENTS);

		longBinaryMeasurementsEClass = createEClass(LONG_BINARY_MEASUREMENTS);
		createEAttribute(longBinaryMeasurementsEClass, LONG_BINARY_MEASUREMENTS__UNIT);

		stateEClass = createEClass(STATE);
		createEAttribute(stateEClass, STATE__STATE_LITERAL);

		stateMeasurementsEClass = createEClass(STATE_MEASUREMENTS);
		createEReference(stateMeasurementsEClass, STATE_MEASUREMENTS__OBSERVED_STATES);

		stateSensorEClass = createEClass(STATE_SENSOR);
		createEReference(stateSensorEClass, STATE_SENSOR__DEFINED_SENSOR_STATES);
		createEReference(stateSensorEClass, STATE_SENSOR__INITIAL_STATE);

		doubleBinaryMeasurementsEClass = createEClass(DOUBLE_BINARY_MEASUREMENTS);
		createEAttribute(doubleBinaryMeasurementsEClass, DOUBLE_BINARY_MEASUREMENTS__UNIT);

		experimentGroupEClass = createEClass(EXPERIMENT_GROUP);
		createEReference(experimentGroupEClass, EXPERIMENT_GROUP__EXPERIMENT_SETTINGS);

		measurableSensorEClass = createEClass(MEASURABLE_SENSOR);
		createEAttribute(measurableSensorEClass, MEASURABLE_SENSOR__UNIT_OF_MEASUREMENTS);

		jsXmlMeasurementsEClass = createEClass(JS_XML_MEASUREMENTS);
		createEAttribute(jsXmlMeasurementsEClass, JS_XML_MEASUREMENTS__VALUES);

		eventTimeAggregationEClass = createEClass(EVENT_TIME_AGGREGATION);

		valueAggregationEClass = createEClass(VALUE_AGGREGATION);

		increasingMeasurableSensorEClass = createEClass(INCREASING_MEASURABLE_SENSOR);

		advancedStatisticsEClass = createEClass(ADVANCED_STATISTICS);
		createEAttribute(advancedStatisticsEClass, ADVANCED_STATISTICS__MEDIAN);
		createEAttribute(advancedStatisticsEClass, ADVANCED_STATISTICS__VARIANCE);
		createEAttribute(advancedStatisticsEClass, ADVANCED_STATISTICS__STANDARD_DEVIATION);

		doubleBinaryEventTimesEClass = createEClass(DOUBLE_BINARY_EVENT_TIMES);

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
		aggregatedMeasurementsEClass.getESuperTypes().add(this.getIdentifiable());
		rawMeasurementsEClass.getESuperTypes().add(this.getIdentifiable());
		rawYValuesEClass.getESuperTypes().add(this.getIdentifiable());
		fixedWidthAggregationEClass.getESuperTypes().add(this.getAggregatedMeasurements());
		intervalsEClass.getESuperTypes().add(this.getRawXValues());
		collectedDataEClass.getESuperTypes().add(this.getPropertyable());
		experimentSettingEClass.getESuperTypes().add(this.getPropertyable());
		experimentRunEClass.getESuperTypes().add(this.getIdentifiable());
		experimentRunEClass.getESuperTypes().add(this.getPropertyable());
		measureCharacterizationEClass.getESuperTypes().add(this.getPropertyable());
		longBinaryMeasurementsEClass.getESuperTypes().add(this.getRawYValues());
		stateMeasurementsEClass.getESuperTypes().add(this.getRawYValues());
		stateSensorEClass.getESuperTypes().add(this.getSensorDeclaration());
		doubleBinaryMeasurementsEClass.getESuperTypes().add(this.getRawYValues());
		experimentGroupEClass.getESuperTypes().add(this.getIdentifiable());
		experimentGroupEClass.getESuperTypes().add(this.getPropertyable());
		measurableSensorEClass.getESuperTypes().add(this.getSensorDeclaration());
		jsXmlMeasurementsEClass.getESuperTypes().add(this.getRawYValues());
		eventTimeAggregationEClass.getESuperTypes().add(this.getFixedWidthAggregation());
		valueAggregationEClass.getESuperTypes().add(this.getFixedWidthAggregation());
		increasingMeasurableSensorEClass.getESuperTypes().add(this.getMeasurableSensor());
		advancedStatisticsEClass.getESuperTypes().add(this.getStatistics());
		doubleBinaryEventTimesEClass.getESuperTypes().add(this.getRawXValues());

		// Initialize classes and features; add operations and parameters
		initEClass(aggregatedMeasurementsEClass, AggregatedMeasurements.class, "AggregatedMeasurements", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregatedMeasurements_MeasurementRange(), this.getMeasurementRange(), this.getMeasurementRange_AggregatedMeasurements(), "measurementRange", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAggregatedMeasurements_DistinctValuesBeforeAggregation(), ecorePackage.getELong(), "distinctValuesBeforeAggregation", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAggregatedMeasurements_DistinctValuesAfterAggregation(), ecorePackage.getELong(), "distinctValuesAfterAggregation", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAggregatedMeasurements_AggregationCharacterization(), this.getAggregationCharacterization(), this.getAggregationCharacterization_AggregatedMeasurements(), "aggregationCharacterization", null, 1, 1, AggregatedMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifiable_Id(), ecorePackage.getEString(), "id", null, 1, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measurementRangeEClass, MeasurementRange.class, "MeasurementRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeasurementRange_RawMeasurements(), this.getRawMeasurements(), this.getRawMeasurements_MeasurementRange(), "rawMeasurements", null, 0, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeasurementRange_EndTime(), this.getEJSDurationMeasure(), "endTime", null, 1, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeasurementRange_StartTime(), this.getEJSDurationMeasure(), "startTime", null, 1, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurementRange_CollectedData(), this.getCollectedData(), this.getCollectedData_MeasurementRange(), "collectedData", null, 1, 1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasurementRange_AggregatedMeasurements(), this.getAggregatedMeasurements(), this.getAggregatedMeasurements_MeasurementRange(), "aggregatedMeasurements", null, 0, -1, MeasurementRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rawMeasurementsEClass, RawMeasurements.class, "RawMeasurements", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRawMeasurements_RawXValues(), this.getRawXValues(), this.getRawXValues_RawMeasurements(), "rawXValues", null, 1, 1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawMeasurements_RawYValues(), this.getRawYValues(), this.getRawYValues_RawMeasurements(), "rawYValues", null, 1, 1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawMeasurements_MeasurementRange(), this.getMeasurementRange(), this.getMeasurementRange_RawMeasurements(), "measurementRange", null, 1, 1, RawMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rawXValuesEClass, RawXValues.class, "RawXValues", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRawXValues_RawMeasurements(), this.getRawMeasurements(), this.getRawMeasurements_RawXValues(), "rawMeasurements", null, 1, 1, RawXValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rawYValuesEClass, RawYValues.class, "RawYValues", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRawYValues_Statistics(), this.getStatistics(), this.getStatistics_RawYValues(), "statistics", null, 0, 1, RawYValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawYValues_AggregatedMeasurements(), this.getFixedWidthAggregation(), this.getFixedWidthAggregation_RawYValues(), "aggregatedMeasurements", null, 1, 1, RawYValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawYValues_RawMeasurements(), this.getRawMeasurements(), this.getRawMeasurements_RawYValues(), "rawMeasurements", null, 1, 1, RawYValues.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(rawYValuesEClass, ecorePackage.getEBoolean(), "Statisticsonlyformeasurablevalues", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(statisticsEClass, Statistics.class, "Statistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatistics_Minimum(), this.getEJSMeasure(), "minimum", null, 1, 1, Statistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStatistics_Mean(), this.getEJSMeasure(), "mean", null, 1, 1, Statistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStatistics_Maximum(), this.getEJSMeasure(), "maximum", null, 1, 1, Statistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStatistics_Sum(), this.getEJSMeasure(), "sum", null, 1, 1, Statistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStatistics_Count(), ecorePackage.getELong(), "count", null, 1, 1, Statistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStatistics_RawYValues(), this.getRawYValues(), this.getRawYValues_Statistics(), "rawYValues", null, 1, 1, Statistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fixedWidthAggregationEClass, FixedWidthAggregation.class, "FixedWidthAggregation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFixedWidthAggregation_RawXValues(), this.getIntervals(), this.getIntervals_AggregatedMeasurements(), "rawXValues", null, 1, 1, FixedWidthAggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFixedWidthAggregation_RawYValues(), this.getRawYValues(), this.getRawYValues_AggregatedMeasurements(), "rawYValues", null, 1, 1, FixedWidthAggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(intervalsEClass, Intervals.class, "Intervals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntervals_LowerBound(), this.getEJSMeasure(), "lowerBound", null, 1, 1, Intervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervals_Width(), this.getEJSMeasure(), "width", null, 1, 1, Intervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getIntervals_NumberOfIntervals(), ecorePackage.getELong(), "numberOfIntervals", null, 1, 1, Intervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIntervals_AggregatedMeasurements(), this.getFixedWidthAggregation(), this.getFixedWidthAggregation_RawXValues(), "aggregatedMeasurements", null, 1, 1, Intervals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(collectedDataEClass, CollectedData.class, "CollectedData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectedData_SensorDeclaration(), this.getSensorDeclaration(), null, "sensorDeclaration", null, 1, 1, CollectedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollectedData_ExperimentRun(), this.getExperimentRun(), this.getExperimentRun_CollectedData(), "experimentRun", null, 1, 1, CollectedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollectedData_MeasurementRange(), this.getMeasurementRange(), this.getMeasurementRange_CollectedData(), "measurementRange", null, 0, -1, CollectedData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyableEClass, Propertyable.class, "Propertyable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyable_AdditionalInformation(), this.getEStringtoEObjectMapEntry(), null, "additionalInformation", null, 0, -1, Propertyable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(eStringtoEObjectMapEntryEClass, Map.Entry.class, "EStringtoEObjectMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEStringtoEObjectMapEntry_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEStringtoEObjectMapEntry_Value(), ecorePackage.getEJavaObject(), "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sensorDeclarationEClass, SensorDeclaration.class, "SensorDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSensorDeclaration_ExperimentSetting(), this.getExperimentSetting(), this.getExperimentSetting_Sensors(), "experimentSetting", null, 1, 1, SensorDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSensorDeclaration_MeasureCharacterization(), this.getMeasureCharacterization(), this.getMeasureCharacterization_SensorDeclaration(), "measureCharacterization", null, 1, 1, SensorDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSensorDeclaration_PersistencyKind(), this.getPersistenceKindOptions(), "persistencyKind", null, 1, 1, SensorDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(experimentSettingEClass, ExperimentSetting.class, "ExperimentSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExperimentSetting_ExperimentName(), ecorePackage.getEString(), "experimentName", null, 1, 1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentSetting_ExperimentRuns(), this.getExperimentRun(), this.getExperimentRun_ExperimentSetting(), "experimentRuns", null, 0, -1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExperimentSetting_Sensors(), this.getSensorDeclaration(), this.getSensorDeclaration_ExperimentSetting(), "sensors", null, 0, -1, ExperimentSetting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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

		initEClass(aggregationCharacterizationEClass, AggregationCharacterization.class, "AggregationCharacterization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAggregationCharacterization_Function(), ecorePackage.getEString(), "function", null, 1, 1, AggregationCharacterization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAggregationCharacterization_AggregatedMeasurements(), this.getAggregatedMeasurements(), this.getAggregatedMeasurements_AggregationCharacterization(), "aggregatedMeasurements", null, 1, 1, AggregationCharacterization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(longBinaryMeasurementsEClass, LongBinaryMeasurements.class, "LongBinaryMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLongBinaryMeasurements_Unit(), this.getEJSUnit(), "unit", null, 1, 1, LongBinaryMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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

		initEClass(doubleBinaryMeasurementsEClass, DoubleBinaryMeasurements.class, "DoubleBinaryMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleBinaryMeasurements_Unit(), this.getEJSUnit(), "unit", null, 1, 1, DoubleBinaryMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(experimentGroupEClass, ExperimentGroup.class, "ExperimentGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExperimentGroup_ExperimentSettings(), this.getExperimentSetting(), null, "experimentSettings", null, 0, -1, ExperimentGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measurableSensorEClass, MeasurableSensor.class, "MeasurableSensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasurableSensor_UnitOfMeasurements(), this.getEJSUnit(), "unitOfMeasurements", null, 1, 1, MeasurableSensor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(measurableSensorEClass, ecorePackage.getEBoolean(), "PersistencyKindNotEmf", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEMap(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jsXmlMeasurementsEClass, JSXmlMeasurements.class, "JSXmlMeasurements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJSXmlMeasurements_Values(), this.getEJSMeasure(), "values", null, 1, 1, JSXmlMeasurements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventTimeAggregationEClass, EventTimeAggregation.class, "EventTimeAggregation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueAggregationEClass, ValueAggregation.class, "ValueAggregation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(increasingMeasurableSensorEClass, IncreasingMeasurableSensor.class, "IncreasingMeasurableSensor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(advancedStatisticsEClass, AdvancedStatistics.class, "AdvancedStatistics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdvancedStatistics_Median(), this.getEJSMeasure(), "median", null, 1, 1, AdvancedStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAdvancedStatistics_Variance(), ecorePackage.getEDouble(), "variance", null, 1, 1, AdvancedStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAdvancedStatistics_StandardDeviation(), ecorePackage.getEDouble(), "standardDeviation", null, 1, 1, AdvancedStatistics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(doubleBinaryEventTimesEClass, DoubleBinaryEventTimes.class, "DoubleBinaryEventTimes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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

} //emfmodelPackageImpl
