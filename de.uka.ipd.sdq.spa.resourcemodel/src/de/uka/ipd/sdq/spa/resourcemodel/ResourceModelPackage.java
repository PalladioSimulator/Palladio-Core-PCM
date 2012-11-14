/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel;

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
 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelFactory
 * @model kind="package"
 * @generated
 */
public interface ResourceModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resourcemodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/ResourceModel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "resourcemodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourceModelPackage eINSTANCE = de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.AbstractResourceUsageImpl <em>Abstract Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.AbstractResourceUsageImpl
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getAbstractResourceUsage()
	 * @generated
	 */
	int ABSTRACT_RESOURCE_USAGE = 1;

	/**
	 * The number of structural features of the '<em>Abstract Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.SequentialResourceUsageImpl <em>Sequential Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.SequentialResourceUsageImpl
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getSequentialResourceUsage()
	 * @generated
	 */
	int SEQUENTIAL_RESOURCE_USAGE = 0;

	/**
	 * The feature id for the '<em><b>Resource Usages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_RESOURCE_USAGE__RESOURCE_USAGES = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sequential Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_RESOURCE_USAGE_FEATURE_COUNT = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceImpl
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Number Of Servers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NUMBER_OF_SERVERS = 1;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.AlternativeResourceUsageImpl <em>Alternative Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.AlternativeResourceUsageImpl
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getAlternativeResourceUsage()
	 * @generated
	 */
	int ALTERNATIVE_RESOURCE_USAGE = 3;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_RESOURCE_USAGE__OPTIONS = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Alternative Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALTERNATIVE_RESOURCE_USAGE_FEATURE_COUNT = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceUsageImpl <em>Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceUsageImpl
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getResourceUsage()
	 * @generated
	 */
	int RESOURCE_USAGE = 4;

	/**
	 * The feature id for the '<em><b>Usage Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__USAGE_TIME = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__RESOURCE = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE_FEATURE_COUNT = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ContentionResourceImpl <em>Contention Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ContentionResourceImpl
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getContentionResource()
	 * @generated
	 */
	int CONTENTION_RESOURCE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENTION_RESOURCE__NAME = RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Number Of Servers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENTION_RESOURCE__NUMBER_OF_SERVERS = RESOURCE__NUMBER_OF_SERVERS;

	/**
	 * The feature id for the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENTION_RESOURCE__NUM_REPLICAS = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Contention Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENTION_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.PassiveResourceImpl <em>Passive Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.PassiveResourceImpl
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getPassiveResource()
	 * @generated
	 */
	int PASSIVE_RESOURCE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__NAME = CONTENTION_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Number Of Servers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__NUMBER_OF_SERVERS = CONTENTION_RESOURCE__NUMBER_OF_SERVERS;

	/**
	 * The feature id for the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__NUM_REPLICAS = CONTENTION_RESOURCE__NUM_REPLICAS;

	/**
	 * The number of structural features of the '<em>Passive Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_FEATURE_COUNT = CONTENTION_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ProcessingResourceImpl <em>Processing Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ProcessingResourceImpl
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getProcessingResource()
	 * @generated
	 */
	int PROCESSING_RESOURCE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__NAME = CONTENTION_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Number Of Servers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__NUMBER_OF_SERVERS = CONTENTION_RESOURCE__NUMBER_OF_SERVERS;

	/**
	 * The feature id for the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__NUM_REPLICAS = CONTENTION_RESOURCE__NUM_REPLICAS;

	/**
	 * The number of structural features of the '<em>Processing Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_FEATURE_COUNT = CONTENTION_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ActiveResourceImpl <em>Active Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ActiveResourceImpl
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getActiveResource()
	 * @generated
	 */
	int ACTIVE_RESOURCE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE__NAME = RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Number Of Servers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE__NUMBER_OF_SERVERS = RESOURCE__NUMBER_OF_SERVERS;

	/**
	 * The number of structural features of the '<em>Active Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.DelayResourceImpl <em>Delay Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.DelayResourceImpl
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getDelayResource()
	 * @generated
	 */
	int DELAY_RESOURCE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_RESOURCE__NAME = ACTIVE_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Number Of Servers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_RESOURCE__NUMBER_OF_SERVERS = ACTIVE_RESOURCE__NUMBER_OF_SERVERS;

	/**
	 * The number of structural features of the '<em>Delay Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_RESOURCE_FEATURE_COUNT = ACTIVE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.OptionImpl <em>Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.OptionImpl
	 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getOption()
	 * @generated
	 */
	int OPTION = 10;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__PROBABILITY = 0;

	/**
	 * The feature id for the '<em><b>Resource Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION__RESOURCE_USAGE = 1;

	/**
	 * The number of structural features of the '<em>Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage <em>Sequential Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequential Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage
	 * @generated
	 */
	EClass getSequentialResourceUsage();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage#getResourceUsages <em>Resource Usages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Usages</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.SequentialResourceUsage#getResourceUsages()
	 * @see #getSequentialResourceUsage()
	 * @generated
	 */
	EReference getSequentialResourceUsage_ResourceUsages();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage <em>Abstract Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage
	 * @generated
	 */
	EClass getAbstractResourceUsage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.resourcemodel.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.resourcemodel.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.resourcemodel.Resource#getNumberOfServers <em>Number Of Servers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Servers</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.Resource#getNumberOfServers()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_NumberOfServers();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.resourcemodel.AlternativeResourceUsage <em>Alternative Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.AlternativeResourceUsage
	 * @generated
	 */
	EClass getAlternativeResourceUsage();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.spa.resourcemodel.AlternativeResourceUsage#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.AlternativeResourceUsage#getOptions()
	 * @see #getAlternativeResourceUsage()
	 * @generated
	 */
	EReference getAlternativeResourceUsage_Options();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage <em>Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage
	 * @generated
	 */
	EClass getResourceUsage();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage#getUsageTime <em>Usage Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Usage Time</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage#getUsageTime()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EReference getResourceUsage_UsageTime();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceUsage#getResource()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EReference getResourceUsage_Resource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.resourcemodel.PassiveResource <em>Passive Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Passive Resource</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.PassiveResource
	 * @generated
	 */
	EClass getPassiveResource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.resourcemodel.ContentionResource <em>Contention Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contention Resource</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ContentionResource
	 * @generated
	 */
	EClass getContentionResource();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.resourcemodel.ContentionResource#getNumReplicas <em>Num Replicas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Replicas</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ContentionResource#getNumReplicas()
	 * @see #getContentionResource()
	 * @generated
	 */
	EAttribute getContentionResource_NumReplicas();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.resourcemodel.ProcessingResource <em>Processing Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Resource</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ProcessingResource
	 * @generated
	 */
	EClass getProcessingResource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.resourcemodel.ActiveResource <em>Active Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Active Resource</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ActiveResource
	 * @generated
	 */
	EClass getActiveResource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.resourcemodel.DelayResource <em>Delay Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delay Resource</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.DelayResource
	 * @generated
	 */
	EClass getDelayResource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.resourcemodel.Option <em>Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.Option
	 * @generated
	 */
	EClass getOption();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.resourcemodel.Option#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.Option#getProbability()
	 * @see #getOption()
	 * @generated
	 */
	EAttribute getOption_Probability();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.resourcemodel.Option#getResourceUsage <em>Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.spa.resourcemodel.Option#getResourceUsage()
	 * @see #getOption()
	 * @generated
	 */
	EReference getOption_ResourceUsage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResourceModelFactory getResourceModelFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.SequentialResourceUsageImpl <em>Sequential Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.SequentialResourceUsageImpl
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getSequentialResourceUsage()
		 * @generated
		 */
		EClass SEQUENTIAL_RESOURCE_USAGE = eINSTANCE.getSequentialResourceUsage();

		/**
		 * The meta object literal for the '<em><b>Resource Usages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENTIAL_RESOURCE_USAGE__RESOURCE_USAGES = eINSTANCE.getSequentialResourceUsage_ResourceUsages();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.AbstractResourceUsageImpl <em>Abstract Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.AbstractResourceUsageImpl
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getAbstractResourceUsage()
		 * @generated
		 */
		EClass ABSTRACT_RESOURCE_USAGE = eINSTANCE.getAbstractResourceUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceImpl
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '<em><b>Number Of Servers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NUMBER_OF_SERVERS = eINSTANCE.getResource_NumberOfServers();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.AlternativeResourceUsageImpl <em>Alternative Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.AlternativeResourceUsageImpl
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getAlternativeResourceUsage()
		 * @generated
		 */
		EClass ALTERNATIVE_RESOURCE_USAGE = eINSTANCE.getAlternativeResourceUsage();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALTERNATIVE_RESOURCE_USAGE__OPTIONS = eINSTANCE.getAlternativeResourceUsage_Options();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceUsageImpl <em>Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceUsageImpl
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getResourceUsage()
		 * @generated
		 */
		EClass RESOURCE_USAGE = eINSTANCE.getResourceUsage();

		/**
		 * The meta object literal for the '<em><b>Usage Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_USAGE__USAGE_TIME = eINSTANCE.getResourceUsage_UsageTime();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_USAGE__RESOURCE = eINSTANCE.getResourceUsage_Resource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.PassiveResourceImpl <em>Passive Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.PassiveResourceImpl
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getPassiveResource()
		 * @generated
		 */
		EClass PASSIVE_RESOURCE = eINSTANCE.getPassiveResource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ContentionResourceImpl <em>Contention Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ContentionResourceImpl
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getContentionResource()
		 * @generated
		 */
		EClass CONTENTION_RESOURCE = eINSTANCE.getContentionResource();

		/**
		 * The meta object literal for the '<em><b>Num Replicas</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENTION_RESOURCE__NUM_REPLICAS = eINSTANCE.getContentionResource_NumReplicas();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ProcessingResourceImpl <em>Processing Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ProcessingResourceImpl
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getProcessingResource()
		 * @generated
		 */
		EClass PROCESSING_RESOURCE = eINSTANCE.getProcessingResource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.ActiveResourceImpl <em>Active Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ActiveResourceImpl
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getActiveResource()
		 * @generated
		 */
		EClass ACTIVE_RESOURCE = eINSTANCE.getActiveResource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.DelayResourceImpl <em>Delay Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.DelayResourceImpl
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getDelayResource()
		 * @generated
		 */
		EClass DELAY_RESOURCE = eINSTANCE.getDelayResource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.resourcemodel.impl.OptionImpl <em>Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.OptionImpl
		 * @see de.uka.ipd.sdq.spa.resourcemodel.impl.ResourceModelPackageImpl#getOption()
		 * @generated
		 */
		EClass OPTION = eINSTANCE.getOption();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION__PROBABILITY = eINSTANCE.getOption_Probability();

		/**
		 * The meta object literal for the '<em><b>Resource Usage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTION__RESOURCE_USAGE = eINSTANCE.getOption_ResourceUsage();

	}

} //ResourceModelPackage
