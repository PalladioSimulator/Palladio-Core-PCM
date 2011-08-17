/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * <!-- begin-model-doc -->
 * Decorator&nbsp;models&nbsp;which&nbsp;annotate&nbsp;raw&nbsp;resource&nbsp;demands&nbsp;to&nbsp;AbstractInternalControlFlowActions.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsFactory
 * @model kind="package"
 * @generated
 */
public interface RawResourceDemandCountsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "rawResourceDemandCounts";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///SourceCodeDecorator/rawResourceDemandCounts.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SourceCodeDecorator.rawResourceDemandCounts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RawResourceDemandCountsPackage eINSTANCE = de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsLinkImpl <em>Raw Resource Demands Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getRawResourceDemandsLink()
	 * @generated
	 */
	int RAW_RESOURCE_DEMANDS_LINK = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_RESOURCE_DEMANDS_LINK__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Internal Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_RESOURCE_DEMANDS_LINK__INTERNAL_ACTION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bytecode Monitoring Runs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Raw Resource Demands Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_RESOURCE_DEMANDS_LINK_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.BytecodeMonitoringRunImpl <em>Bytecode Monitoring Run</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.BytecodeMonitoringRunImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getBytecodeMonitoringRun()
	 * @generated
	 */
	int BYTECODE_MONITORING_RUN = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTECODE_MONITORING_RUN__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Measured Counts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTECODE_MONITORING_RUN__MEASURED_COUNTS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Input Parameter Characterisations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTECODE_MONITORING_RUN__INPUT_PARAMETER_CHARACTERISATIONS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Environment Characterisation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Raw Resource Demands Link</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Bytecode Monitoring Run</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTECODE_MONITORING_RUN_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.MeasuredCountImpl <em>Measured Count</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.MeasuredCountImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getMeasuredCount()
	 * @generated
	 */
	int MEASURED_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURED_COUNT__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURED_COUNT__COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURED_COUNT__SIGNATURE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURED_COUNT__PARAMETER_VALUES = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Measured Count</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURED_COUNT_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.ParameterValueImpl <em>Parameter Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.ParameterValueImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getParameterValue()
	 * @generated
	 */
	int PARAMETER_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Described Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE__DESCRIBED_PARAMETER = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Measured Characterisation Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE__MEASURED_CHARACTERISATION_VALUE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VALUE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.MeasuredCharacterisationValueImpl <em>Measured Characterisation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.MeasuredCharacterisationValueImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getMeasuredCharacterisationValue()
	 * @generated
	 */
	int MEASURED_CHARACTERISATION_VALUE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURED_CHARACTERISATION_VALUE__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Required Characterisation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURED_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Measured Characterisation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASURED_CHARACTERISATION_VALUE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.EnvironmentCharacterisationImpl <em>Environment Characterisation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.EnvironmentCharacterisationImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getEnvironmentCharacterisation()
	 * @generated
	 */
	int ENVIRONMENT_CHARACTERISATION = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CHARACTERISATION__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Bytecode Monitoring Runs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Environment Characterisation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_CHARACTERISATION_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsRepositoryImpl <em>Raw Resource Demands Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsRepositoryImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getRawResourceDemandsRepository()
	 * @generated
	 */
	int RAW_RESOURCE_DEMANDS_REPOSITORY = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_RESOURCE_DEMANDS_REPOSITORY__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Bytecode Monitoring Runs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_RESOURCE_DEMANDS_REPOSITORY__BYTECODE_MONITORING_RUNS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Raw Resource Demands Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_RESOURCE_DEMANDS_REPOSITORY__RAW_RESOURCE_DEMANDS_LINKS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Environment Characterisations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_RESOURCE_DEMANDS_REPOSITORY__ENVIRONMENT_CHARACTERISATIONS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Raw Resource Demands Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_RESOURCE_DEMANDS_REPOSITORY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.DoubleCharacterisationValueImpl <em>Double Characterisation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.DoubleCharacterisationValueImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getDoubleCharacterisationValue()
	 * @generated
	 */
	int DOUBLE_CHARACTERISATION_VALUE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CHARACTERISATION_VALUE__ID = MEASURED_CHARACTERISATION_VALUE__ID;

	/**
	 * The feature id for the '<em><b>Required Characterisation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION = MEASURED_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CHARACTERISATION_VALUE__VALUE = MEASURED_CHARACTERISATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Characterisation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_CHARACTERISATION_VALUE_FEATURE_COUNT = MEASURED_CHARACTERISATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.LongCharacterisationValueImpl <em>Long Characterisation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.LongCharacterisationValueImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getLongCharacterisationValue()
	 * @generated
	 */
	int LONG_CHARACTERISATION_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHARACTERISATION_VALUE__ID = MEASURED_CHARACTERISATION_VALUE__ID;

	/**
	 * The feature id for the '<em><b>Required Characterisation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION = MEASURED_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHARACTERISATION_VALUE__VALUE = MEASURED_CHARACTERISATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Long Characterisation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_CHARACTERISATION_VALUE_FEATURE_COUNT = MEASURED_CHARACTERISATION_VALUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.BooleanCharacterisationValueImpl <em>Boolean Characterisation Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.BooleanCharacterisationValueImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getBooleanCharacterisationValue()
	 * @generated
	 */
	int BOOLEAN_CHARACTERISATION_VALUE = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CHARACTERISATION_VALUE__ID = MEASURED_CHARACTERISATION_VALUE__ID;

	/**
	 * The feature id for the '<em><b>Required Characterisation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION = MEASURED_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CHARACTERISATION_VALUE__VALUE = MEASURED_CHARACTERISATION_VALUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Characterisation Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_CHARACTERISATION_VALUE_FEATURE_COUNT = MEASURED_CHARACTERISATION_VALUE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink <em>Raw Resource Demands Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Raw Resource Demands Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink
	 * @generated
	 */
	EClass getRawResourceDemandsLink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink#getInternalAction <em>Internal Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Internal Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink#getInternalAction()
	 * @see #getRawResourceDemandsLink()
	 * @generated
	 */
	EReference getRawResourceDemandsLink_InternalAction();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink#getBytecodeMonitoringRuns <em>Bytecode Monitoring Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Bytecode Monitoring Runs</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink#getBytecodeMonitoringRuns()
	 * @see #getRawResourceDemandsLink()
	 * @generated
	 */
	EReference getRawResourceDemandsLink_BytecodeMonitoringRuns();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun <em>Bytecode Monitoring Run</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bytecode Monitoring Run</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun
	 * @generated
	 */
	EClass getBytecodeMonitoringRun();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getMeasuredCounts <em>Measured Counts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measured Counts</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getMeasuredCounts()
	 * @see #getBytecodeMonitoringRun()
	 * @generated
	 */
	EReference getBytecodeMonitoringRun_MeasuredCounts();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getInputParameterCharacterisations <em>Input Parameter Characterisations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Parameter Characterisations</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getInputParameterCharacterisations()
	 * @see #getBytecodeMonitoringRun()
	 * @generated
	 */
	EReference getBytecodeMonitoringRun_InputParameterCharacterisations();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getEnvironmentCharacterisation <em>Environment Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Environment Characterisation</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getEnvironmentCharacterisation()
	 * @see #getBytecodeMonitoringRun()
	 * @generated
	 */
	EReference getBytecodeMonitoringRun_EnvironmentCharacterisation();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getRawResourceDemandsLink <em>Raw Resource Demands Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Raw Resource Demands Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun#getRawResourceDemandsLink()
	 * @see #getBytecodeMonitoringRun()
	 * @generated
	 */
	EReference getBytecodeMonitoringRun_RawResourceDemandsLink();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCount <em>Measured Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measured Count</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCount
	 * @generated
	 */
	EClass getMeasuredCount();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCount#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCount#getCount()
	 * @see #getMeasuredCount()
	 * @generated
	 */
	EAttribute getMeasuredCount_Count();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCount#getSignature <em>Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signature</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCount#getSignature()
	 * @see #getMeasuredCount()
	 * @generated
	 */
	EReference getMeasuredCount_Signature();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCount#getParameterValues <em>Parameter Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Values</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCount#getParameterValues()
	 * @see #getMeasuredCount()
	 * @generated
	 */
	EReference getMeasuredCount_ParameterValues();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.ParameterValue <em>Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.ParameterValue
	 * @generated
	 */
	EClass getParameterValue();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.ParameterValue#getDescribedParameter <em>Described Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Described Parameter</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.ParameterValue#getDescribedParameter()
	 * @see #getParameterValue()
	 * @generated
	 */
	EReference getParameterValue_DescribedParameter();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.ParameterValue#getMeasuredCharacterisationValue <em>Measured Characterisation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Measured Characterisation Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.ParameterValue#getMeasuredCharacterisationValue()
	 * @see #getParameterValue()
	 * @generated
	 */
	EReference getParameterValue_MeasuredCharacterisationValue();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCharacterisationValue <em>Measured Characterisation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measured Characterisation Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCharacterisationValue
	 * @generated
	 */
	EClass getMeasuredCharacterisationValue();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCharacterisationValue#getRequiredCharacterisation <em>Required Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Characterisation</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCharacterisationValue#getRequiredCharacterisation()
	 * @see #getMeasuredCharacterisationValue()
	 * @generated
	 */
	EReference getMeasuredCharacterisationValue_RequiredCharacterisation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.EnvironmentCharacterisation <em>Environment Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment Characterisation</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.EnvironmentCharacterisation
	 * @generated
	 */
	EClass getEnvironmentCharacterisation();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.EnvironmentCharacterisation#getBytecodeMonitoringRuns <em>Bytecode Monitoring Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Bytecode Monitoring Runs</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.EnvironmentCharacterisation#getBytecodeMonitoringRuns()
	 * @see #getEnvironmentCharacterisation()
	 * @generated
	 */
	EReference getEnvironmentCharacterisation_BytecodeMonitoringRuns();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository <em>Raw Resource Demands Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Raw Resource Demands Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository
	 * @generated
	 */
	EClass getRawResourceDemandsRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository#getBytecodeMonitoringRuns <em>Bytecode Monitoring Runs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bytecode Monitoring Runs</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository#getBytecodeMonitoringRuns()
	 * @see #getRawResourceDemandsRepository()
	 * @generated
	 */
	EReference getRawResourceDemandsRepository_BytecodeMonitoringRuns();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository#getRawResourceDemandsLinks <em>Raw Resource Demands Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Raw Resource Demands Links</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository#getRawResourceDemandsLinks()
	 * @see #getRawResourceDemandsRepository()
	 * @generated
	 */
	EReference getRawResourceDemandsRepository_RawResourceDemandsLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository#getEnvironmentCharacterisations <em>Environment Characterisations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Environment Characterisations</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository#getEnvironmentCharacterisations()
	 * @see #getRawResourceDemandsRepository()
	 * @generated
	 */
	EReference getRawResourceDemandsRepository_EnvironmentCharacterisations();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.DoubleCharacterisationValue <em>Double Characterisation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Characterisation Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.DoubleCharacterisationValue
	 * @generated
	 */
	EClass getDoubleCharacterisationValue();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.DoubleCharacterisationValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.DoubleCharacterisationValue#getValue()
	 * @see #getDoubleCharacterisationValue()
	 * @generated
	 */
	EAttribute getDoubleCharacterisationValue_Value();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.LongCharacterisationValue <em>Long Characterisation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Characterisation Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.LongCharacterisationValue
	 * @generated
	 */
	EClass getLongCharacterisationValue();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.LongCharacterisationValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.LongCharacterisationValue#getValue()
	 * @see #getLongCharacterisationValue()
	 * @generated
	 */
	EAttribute getLongCharacterisationValue_Value();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BooleanCharacterisationValue <em>Boolean Characterisation Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Characterisation Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BooleanCharacterisationValue
	 * @generated
	 */
	EClass getBooleanCharacterisationValue();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BooleanCharacterisationValue#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BooleanCharacterisationValue#isValue()
	 * @see #getBooleanCharacterisationValue()
	 * @generated
	 */
	EAttribute getBooleanCharacterisationValue_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RawResourceDemandCountsFactory getRawResourceDemandCountsFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsLinkImpl <em>Raw Resource Demands Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getRawResourceDemandsLink()
		 * @generated
		 */
		EClass RAW_RESOURCE_DEMANDS_LINK = eINSTANCE.getRawResourceDemandsLink();

		/**
		 * The meta object literal for the '<em><b>Internal Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAW_RESOURCE_DEMANDS_LINK__INTERNAL_ACTION = eINSTANCE.getRawResourceDemandsLink_InternalAction();

		/**
		 * The meta object literal for the '<em><b>Bytecode Monitoring Runs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS = eINSTANCE.getRawResourceDemandsLink_BytecodeMonitoringRuns();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.BytecodeMonitoringRunImpl <em>Bytecode Monitoring Run</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.BytecodeMonitoringRunImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getBytecodeMonitoringRun()
		 * @generated
		 */
		EClass BYTECODE_MONITORING_RUN = eINSTANCE.getBytecodeMonitoringRun();

		/**
		 * The meta object literal for the '<em><b>Measured Counts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BYTECODE_MONITORING_RUN__MEASURED_COUNTS = eINSTANCE.getBytecodeMonitoringRun_MeasuredCounts();

		/**
		 * The meta object literal for the '<em><b>Input Parameter Characterisations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BYTECODE_MONITORING_RUN__INPUT_PARAMETER_CHARACTERISATIONS = eINSTANCE.getBytecodeMonitoringRun_InputParameterCharacterisations();

		/**
		 * The meta object literal for the '<em><b>Environment Characterisation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION = eINSTANCE.getBytecodeMonitoringRun_EnvironmentCharacterisation();

		/**
		 * The meta object literal for the '<em><b>Raw Resource Demands Link</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK = eINSTANCE.getBytecodeMonitoringRun_RawResourceDemandsLink();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.MeasuredCountImpl <em>Measured Count</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.MeasuredCountImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getMeasuredCount()
		 * @generated
		 */
		EClass MEASURED_COUNT = eINSTANCE.getMeasuredCount();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASURED_COUNT__COUNT = eINSTANCE.getMeasuredCount_Count();

		/**
		 * The meta object literal for the '<em><b>Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURED_COUNT__SIGNATURE = eINSTANCE.getMeasuredCount_Signature();

		/**
		 * The meta object literal for the '<em><b>Parameter Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURED_COUNT__PARAMETER_VALUES = eINSTANCE.getMeasuredCount_ParameterValues();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.ParameterValueImpl <em>Parameter Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.ParameterValueImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getParameterValue()
		 * @generated
		 */
		EClass PARAMETER_VALUE = eINSTANCE.getParameterValue();

		/**
		 * The meta object literal for the '<em><b>Described Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_VALUE__DESCRIBED_PARAMETER = eINSTANCE.getParameterValue_DescribedParameter();

		/**
		 * The meta object literal for the '<em><b>Measured Characterisation Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_VALUE__MEASURED_CHARACTERISATION_VALUE = eINSTANCE.getParameterValue_MeasuredCharacterisationValue();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.MeasuredCharacterisationValueImpl <em>Measured Characterisation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.MeasuredCharacterisationValueImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getMeasuredCharacterisationValue()
		 * @generated
		 */
		EClass MEASURED_CHARACTERISATION_VALUE = eINSTANCE.getMeasuredCharacterisationValue();

		/**
		 * The meta object literal for the '<em><b>Required Characterisation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASURED_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION = eINSTANCE.getMeasuredCharacterisationValue_RequiredCharacterisation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.EnvironmentCharacterisationImpl <em>Environment Characterisation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.EnvironmentCharacterisationImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getEnvironmentCharacterisation()
		 * @generated
		 */
		EClass ENVIRONMENT_CHARACTERISATION = eINSTANCE.getEnvironmentCharacterisation();

		/**
		 * The meta object literal for the '<em><b>Bytecode Monitoring Runs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS = eINSTANCE.getEnvironmentCharacterisation_BytecodeMonitoringRuns();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsRepositoryImpl <em>Raw Resource Demands Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsRepositoryImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getRawResourceDemandsRepository()
		 * @generated
		 */
		EClass RAW_RESOURCE_DEMANDS_REPOSITORY = eINSTANCE.getRawResourceDemandsRepository();

		/**
		 * The meta object literal for the '<em><b>Bytecode Monitoring Runs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAW_RESOURCE_DEMANDS_REPOSITORY__BYTECODE_MONITORING_RUNS = eINSTANCE.getRawResourceDemandsRepository_BytecodeMonitoringRuns();

		/**
		 * The meta object literal for the '<em><b>Raw Resource Demands Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAW_RESOURCE_DEMANDS_REPOSITORY__RAW_RESOURCE_DEMANDS_LINKS = eINSTANCE.getRawResourceDemandsRepository_RawResourceDemandsLinks();

		/**
		 * The meta object literal for the '<em><b>Environment Characterisations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RAW_RESOURCE_DEMANDS_REPOSITORY__ENVIRONMENT_CHARACTERISATIONS = eINSTANCE.getRawResourceDemandsRepository_EnvironmentCharacterisations();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.DoubleCharacterisationValueImpl <em>Double Characterisation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.DoubleCharacterisationValueImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getDoubleCharacterisationValue()
		 * @generated
		 */
		EClass DOUBLE_CHARACTERISATION_VALUE = eINSTANCE.getDoubleCharacterisationValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_CHARACTERISATION_VALUE__VALUE = eINSTANCE.getDoubleCharacterisationValue_Value();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.LongCharacterisationValueImpl <em>Long Characterisation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.LongCharacterisationValueImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getLongCharacterisationValue()
		 * @generated
		 */
		EClass LONG_CHARACTERISATION_VALUE = eINSTANCE.getLongCharacterisationValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_CHARACTERISATION_VALUE__VALUE = eINSTANCE.getLongCharacterisationValue_Value();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.BooleanCharacterisationValueImpl <em>Boolean Characterisation Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.BooleanCharacterisationValueImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl#getBooleanCharacterisationValue()
		 * @generated
		 */
		EClass BOOLEAN_CHARACTERISATION_VALUE = eINSTANCE.getBooleanCharacterisationValue();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_CHARACTERISATION_VALUE__VALUE = eINSTANCE.getBooleanCharacterisationValue_Value();

	}

} //RawResourceDemandCountsPackage
