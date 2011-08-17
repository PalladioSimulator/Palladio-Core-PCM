/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

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
 * The DesignDecisions metamodel represents degrees of freedom that can be exploited for optimisation.
 * 
 * The core idea is each degree of freedom can be represented by a DegreeOfFreedom element. Each DegreeOfFreedom has two parts: It links a model element that is the changeable entity in this DegreeOfFreedom, and it specifies a Domain of possible values that the model element can take. 
 * 
 * The actual making of a decision is represented in the Choice element. For a specific candidate architecture, one Choice for each DegreeOfFreedom in the Problem as to be made. The Choice contains a reference to the DegreeOfFreedom that it decides and a reference to a value from the DegreeOfFreedom's Domain that represent the selected value.  See the diagram "Design and Choice" for an overview of DegreeOfFreedom, Domain and Choice.
 * 
 * All of the above mentioned elements are abstract and are subclassed for the different generic degrees of freedom. For example, the degree of freedom of "component allocation" is represented in the AllocationDegree. See the documentation of each subclass of design decision for details. The diagram AssembledComponentDegree visualises the subclassing for the example degree of freedom of "component selection". 
 * 
 * 
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory
 * @model kind="package"
 * @generated
 */
public interface designdecisionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "designdecision";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/DesignDecision/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "designdecision";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	designdecisionPackage eINSTANCE = de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DegreeOfFreedomImpl <em>Degree Of Freedom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DegreeOfFreedomImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDegreeOfFreedom()
	 * @generated
	 */
	int DEGREE_OF_FREEDOM = 0;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY = 0;

	/**
	 * The number of structural features of the '<em>Degree Of Freedom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEGREE_OF_FREEDOM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 1;

	/**
	 * The feature id for the '<em><b>Degree Of Freedom</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__DEGREE_OF_FREEDOM = 0;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.RangeDegreeImpl <em>Range Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.RangeDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getRangeDegree()
	 * @generated
	 */
	int RANGE_DEGREE = 2;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_DEGREE__CHANGEABLE_ENTITY = DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_DEGREE__UPPER_BOUND_INCLUDED = DEGREE_OF_FREEDOM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_DEGREE__LOWER_BOUND_INCLUDED = DEGREE_OF_FREEDOM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Range Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_DEGREE_FEATURE_COUNT = DEGREE_OF_FREEDOM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationDegreeImpl <em>Enumeration Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getEnumerationDegree()
	 * @generated
	 */
	int ENUMERATION_DEGREE = 3;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DEGREE__CHANGEABLE_ENTITY = DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Domain Of Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DEGREE__DOMAIN_OF_ENTITIES = DEGREE_OF_FREEDOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DEGREE_FEATURE_COUNT = DEGREE_OF_FREEDOM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationChoiceImpl <em>Enumeration Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationChoiceImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getEnumerationChoice()
	 * @generated
	 */
	int ENUMERATION_CHOICE = 4;

	/**
	 * The feature id for the '<em><b>Degree Of Freedom</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CHOICE__DEGREE_OF_FREEDOM = CHOICE__DEGREE_OF_FREEDOM;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CHOICE__ENTITY = CHOICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_CHOICE_FEATURE_COUNT = CHOICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ContinousRangeChoiceImpl <em>Continous Range Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ContinousRangeChoiceImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getContinousRangeChoice()
	 * @generated
	 */
	int CONTINOUS_RANGE_CHOICE = 5;

	/**
	 * The feature id for the '<em><b>Degree Of Freedom</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINOUS_RANGE_CHOICE__DEGREE_OF_FREEDOM = CHOICE__DEGREE_OF_FREEDOM;

	/**
	 * The feature id for the '<em><b>Chosen Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINOUS_RANGE_CHOICE__CHOSEN_VALUE = CHOICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Continous Range Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINOUS_RANGE_CHOICE_FEATURE_COUNT = CHOICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ContinuousRangeDegreeImpl <em>Continuous Range Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ContinuousRangeDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getContinuousRangeDegree()
	 * @generated
	 */
	int CONTINUOUS_RANGE_DEGREE = 7;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_RANGE_DEGREE__CHANGEABLE_ENTITY = RANGE_DEGREE__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_RANGE_DEGREE__UPPER_BOUND_INCLUDED = RANGE_DEGREE__UPPER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_RANGE_DEGREE__LOWER_BOUND_INCLUDED = RANGE_DEGREE__LOWER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_RANGE_DEGREE__TO = RANGE_DEGREE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_RANGE_DEGREE__FROM = RANGE_DEGREE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Continuous Range Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_RANGE_DEGREE_FEATURE_COUNT = RANGE_DEGREE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ContinuousProcessingRateDegreeImpl <em>Continuous Processing Rate Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ContinuousProcessingRateDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getContinuousProcessingRateDegree()
	 * @generated
	 */
	int CONTINUOUS_PROCESSING_RATE_DEGREE = 6;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_PROCESSING_RATE_DEGREE__CHANGEABLE_ENTITY = CONTINUOUS_RANGE_DEGREE__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_PROCESSING_RATE_DEGREE__UPPER_BOUND_INCLUDED = CONTINUOUS_RANGE_DEGREE__UPPER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_PROCESSING_RATE_DEGREE__LOWER_BOUND_INCLUDED = CONTINUOUS_RANGE_DEGREE__LOWER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_PROCESSING_RATE_DEGREE__TO = CONTINUOUS_RANGE_DEGREE__TO;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_PROCESSING_RATE_DEGREE__FROM = CONTINUOUS_RANGE_DEGREE__FROM;

	/**
	 * The feature id for the '<em><b>Processingresourcetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_PROCESSING_RATE_DEGREE__PROCESSINGRESOURCETYPE = CONTINUOUS_RANGE_DEGREE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Continuous Processing Rate Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_PROCESSING_RATE_DEGREE_FEATURE_COUNT = CONTINUOUS_RANGE_DEGREE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingResourceDegreeImpl <em>Processing Resource Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingResourceDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getProcessingResourceDegree()
	 * @generated
	 */
	int PROCESSING_RESOURCE_DEGREE = 8;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_DEGREE__CHANGEABLE_ENTITY = DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Processingresourcetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_DEGREE__PROCESSINGRESOURCETYPE = DEGREE_OF_FREEDOM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Processing Resource Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_DEGREE_FEATURE_COUNT = DEGREE_OF_FREEDOM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.AllocationDegreeImpl <em>Allocation Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.AllocationDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getAllocationDegree()
	 * @generated
	 */
	int ALLOCATION_DEGREE = 9;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_DEGREE__CHANGEABLE_ENTITY = ENUMERATION_DEGREE__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Domain Of Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_DEGREE__DOMAIN_OF_ENTITIES = ENUMERATION_DEGREE__DOMAIN_OF_ENTITIES;

	/**
	 * The number of structural features of the '<em>Allocation Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATION_DEGREE_FEATURE_COUNT = ENUMERATION_DEGREE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.AssembledComponentDegreeImpl <em>Assembled Component Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.AssembledComponentDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getAssembledComponentDegree()
	 * @generated
	 */
	int ASSEMBLED_COMPONENT_DEGREE = 10;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLED_COMPONENT_DEGREE__CHANGEABLE_ENTITY = ENUMERATION_DEGREE__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Domain Of Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLED_COMPONENT_DEGREE__DOMAIN_OF_ENTITIES = ENUMERATION_DEGREE__DOMAIN_OF_ENTITIES;

	/**
	 * The number of structural features of the '<em>Assembled Component Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSEMBLED_COMPONENT_DEGREE_FEATURE_COUNT = ENUMERATION_DEGREE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteRangeDegreeImpl <em>Discrete Range Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteRangeDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDiscreteRangeDegree()
	 * @generated
	 */
	int DISCRETE_RANGE_DEGREE = 11;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_RANGE_DEGREE__CHANGEABLE_ENTITY = RANGE_DEGREE__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_RANGE_DEGREE__UPPER_BOUND_INCLUDED = RANGE_DEGREE__UPPER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_RANGE_DEGREE__LOWER_BOUND_INCLUDED = RANGE_DEGREE__LOWER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_RANGE_DEGREE__TO = RANGE_DEGREE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_RANGE_DEGREE__FROM = RANGE_DEGREE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Discrete Range Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_RANGE_DEGREE_FEATURE_COUNT = RANGE_DEGREE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteRangeChoiceImpl <em>Discrete Range Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteRangeChoiceImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDiscreteRangeChoice()
	 * @generated
	 */
	int DISCRETE_RANGE_CHOICE = 12;

	/**
	 * The feature id for the '<em><b>Degree Of Freedom</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_RANGE_CHOICE__DEGREE_OF_FREEDOM = CHOICE__DEGREE_OF_FREEDOM;

	/**
	 * The feature id for the '<em><b>Chosen Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_RANGE_CHOICE__CHOSEN_VALUE = CHOICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Discrete Range Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_RANGE_CHOICE_FEATURE_COUNT = CHOICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationDegreeImpl <em>Resource Container Replication Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getResourceContainerReplicationDegree()
	 * @generated
	 */
	int RESOURCE_CONTAINER_REPLICATION_DEGREE = 13;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_REPLICATION_DEGREE__CHANGEABLE_ENTITY = DISCRETE_RANGE_DEGREE__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_REPLICATION_DEGREE__UPPER_BOUND_INCLUDED = DISCRETE_RANGE_DEGREE__UPPER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_REPLICATION_DEGREE__LOWER_BOUND_INCLUDED = DISCRETE_RANGE_DEGREE__LOWER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_REPLICATION_DEGREE__TO = DISCRETE_RANGE_DEGREE__TO;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_REPLICATION_DEGREE__FROM = DISCRETE_RANGE_DEGREE__FROM;

	/**
	 * The number of structural features of the '<em>Resource Container Replication Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_CONTAINER_REPLICATION_DEGREE_FEATURE_COUNT = DISCRETE_RANGE_DEGREE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProblemImpl <em>Problem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ProblemImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getProblem()
	 * @generated
	 */
	int PROBLEM = 14;

	/**
	 * The feature id for the '<em><b>Designdecision</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM__DESIGNDECISION = 0;

	/**
	 * The number of structural features of the '<em>Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBLEM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ConnectorConfigDegreeImpl <em>Connector Config Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ConnectorConfigDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getConnectorConfigDegree()
	 * @generated
	 */
	int CONNECTOR_CONFIG_DEGREE = 15;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_CONFIG_DEGREE__CHANGEABLE_ENTITY = ENUMERATION_DEGREE__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Domain Of Entities</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_CONFIG_DEGREE__DOMAIN_OF_ENTITIES = ENUMERATION_DEGREE__DOMAIN_OF_ENTITIES;

	/**
	 * The number of structural features of the '<em>Connector Config Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_CONFIG_DEGREE_FEATURE_COUNT = ENUMERATION_DEGREE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.CandidateImpl <em>Candidate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.CandidateImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getCandidate()
	 * @generated
	 */
	int CANDIDATE = 16;

	/**
	 * The feature id for the '<em><b>Choice</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANDIDATE__CHOICE = 0;

	/**
	 * The number of structural features of the '<em>Candidate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANDIDATE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.CandidatesImpl <em>Candidates</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.CandidatesImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getCandidates()
	 * @generated
	 */
	int CANDIDATES = 17;

	/**
	 * The feature id for the '<em><b>Candidate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANDIDATES__CANDIDATE = 0;

	/**
	 * The feature id for the '<em><b>Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANDIDATES__PROBLEM = 1;

	/**
	 * The number of structural features of the '<em>Candidates</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANDIDATES_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.FeatureConfigDegreeImpl <em>Feature Config Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.FeatureConfigDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getFeatureConfigDegree()
	 * @generated
	 */
	int FEATURE_CONFIG_DEGREE = 18;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIG_DEGREE__CHANGEABLE_ENTITY = DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY;

	/**
	 * The number of structural features of the '<em>Feature Config Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIG_DEGREE_FEATURE_COUNT = DEGREE_OF_FREEDOM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.FeatureGroupDegreeImpl <em>Feature Group Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.FeatureGroupDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getFeatureGroupDegree()
	 * @generated
	 */
	int FEATURE_GROUP_DEGREE = 19;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP_DEGREE__CHANGEABLE_ENTITY = FEATURE_CONFIG_DEGREE__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Featuregroup</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP_DEGREE__FEATUREGROUP = FEATURE_CONFIG_DEGREE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Of Feature Config Combinations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP_DEGREE__DOMAIN_OF_FEATURE_CONFIG_COMBINATIONS = FEATURE_CONFIG_DEGREE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature Group Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP_DEGREE_FEATURE_COUNT = FEATURE_CONFIG_DEGREE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.FeatureSubsetImpl <em>Feature Subset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.FeatureSubsetImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getFeatureSubset()
	 * @generated
	 */
	int FEATURE_SUBSET = 20;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SUBSET__FEATURE = 0;

	/**
	 * The number of structural features of the '<em>Feature Subset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_SUBSET_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.OptionalFeatureDegreeImpl <em>Optional Feature Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.OptionalFeatureDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getOptionalFeatureDegree()
	 * @generated
	 */
	int OPTIONAL_FEATURE_DEGREE = 21;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_FEATURE_DEGREE__CHANGEABLE_ENTITY = FEATURE_CONFIG_DEGREE__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Simple</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_FEATURE_DEGREE__SIMPLE = FEATURE_CONFIG_DEGREE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Optional Feature Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_FEATURE_DEGREE_FEATURE_COUNT = FEATURE_CONFIG_DEGREE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteProcessingRateDegreeImpl <em>Discrete Processing Rate Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteProcessingRateDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDiscreteProcessingRateDegree()
	 * @generated
	 */
	int DISCRETE_PROCESSING_RATE_DEGREE = 22;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_PROCESSING_RATE_DEGREE__CHANGEABLE_ENTITY = DISCRETE_RANGE_DEGREE__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_PROCESSING_RATE_DEGREE__UPPER_BOUND_INCLUDED = DISCRETE_RANGE_DEGREE__UPPER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_PROCESSING_RATE_DEGREE__LOWER_BOUND_INCLUDED = DISCRETE_RANGE_DEGREE__LOWER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_PROCESSING_RATE_DEGREE__TO = DISCRETE_RANGE_DEGREE__TO;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_PROCESSING_RATE_DEGREE__FROM = DISCRETE_RANGE_DEGREE__FROM;

	/**
	 * The feature id for the '<em><b>Processingresourcetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_PROCESSING_RATE_DEGREE__PROCESSINGRESOURCETYPE = DISCRETE_RANGE_DEGREE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Number Of Steps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_PROCESSING_RATE_DEGREE__NUMBER_OF_STEPS = DISCRETE_RANGE_DEGREE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Discrete Processing Rate Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISCRETE_PROCESSING_RATE_DEGREE_FEATURE_COUNT = DISCRETE_RANGE_DEGREE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.CapacityDegreeImpl <em>Capacity Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.CapacityDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getCapacityDegree()
	 * @generated
	 */
	int CAPACITY_DEGREE = 23;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPACITY_DEGREE__CHANGEABLE_ENTITY = DISCRETE_RANGE_DEGREE__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPACITY_DEGREE__UPPER_BOUND_INCLUDED = DISCRETE_RANGE_DEGREE__UPPER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPACITY_DEGREE__LOWER_BOUND_INCLUDED = DISCRETE_RANGE_DEGREE__LOWER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPACITY_DEGREE__TO = DISCRETE_RANGE_DEGREE__TO;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPACITY_DEGREE__FROM = DISCRETE_RANGE_DEGREE__FROM;

	/**
	 * The number of structural features of the '<em>Capacity Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPACITY_DEGREE_FEATURE_COUNT = DISCRETE_RANGE_DEGREE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.EnumDegreeImpl <em>Enum Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.EnumDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getEnumDegree()
	 * @generated
	 */
	int ENUM_DEGREE = 25;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.SchedulingPolicyDegreeImpl <em>Scheduling Policy Degree</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.SchedulingPolicyDegreeImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getSchedulingPolicyDegree()
	 * @generated
	 */
	int SCHEDULING_POLICY_DEGREE = 24;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_POLICY_DEGREE__CHANGEABLE_ENTITY = PROCESSING_RESOURCE_DEGREE__CHANGEABLE_ENTITY;

	/**
	 * The feature id for the '<em><b>Processingresourcetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_POLICY_DEGREE__PROCESSINGRESOURCETYPE = PROCESSING_RESOURCE_DEGREE__PROCESSINGRESOURCETYPE;

	/**
	 * The feature id for the '<em><b>Domain Of Allowed Scheduling Policies</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_POLICY_DEGREE__DOMAIN_OF_ALLOWED_SCHEDULING_POLICIES = PROCESSING_RESOURCE_DEGREE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Scheduling Policy Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_POLICY_DEGREE_FEATURE_COUNT = PROCESSING_RESOURCE_DEGREE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Changeable Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_DEGREE__CHANGEABLE_ENTITY = DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY;

	/**
	 * The number of structural features of the '<em>Enum Degree</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_DEGREE_FEATURE_COUNT = DEGREE_OF_FREEDOM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.SchedulingPolicyChoiceImpl <em>Scheduling Policy Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.SchedulingPolicyChoiceImpl
	 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getSchedulingPolicyChoice()
	 * @generated
	 */
	int SCHEDULING_POLICY_CHOICE = 26;

	/**
	 * The feature id for the '<em><b>Degree Of Freedom</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_POLICY_CHOICE__DEGREE_OF_FREEDOM = CHOICE__DEGREE_OF_FREEDOM;

	/**
	 * The feature id for the '<em><b>Chosen Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_POLICY_CHOICE__CHOSEN_VALUE = CHOICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Scheduling Policy Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_POLICY_CHOICE_FEATURE_COUNT = CHOICE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom <em>Degree Of Freedom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Degree Of Freedom</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom
	 * @generated
	 */
	EClass getDegreeOfFreedom();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom#getChangeableEntity <em>Changeable Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Changeable Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom#getChangeableEntity()
	 * @see #getDegreeOfFreedom()
	 * @generated
	 */
	EReference getDegreeOfFreedom_ChangeableEntity();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.Choice#getDegreeOfFreedom <em>Degree Of Freedom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Degree Of Freedom</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Choice#getDegreeOfFreedom()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_DegreeOfFreedom();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.RangeDegree <em>Range Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.RangeDegree
	 * @generated
	 */
	EClass getRangeDegree();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.RangeDegree#isUpperBoundIncluded <em>Upper Bound Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound Included</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.RangeDegree#isUpperBoundIncluded()
	 * @see #getRangeDegree()
	 * @generated
	 */
	EAttribute getRangeDegree_UpperBoundIncluded();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.RangeDegree#isLowerBoundIncluded <em>Lower Bound Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound Included</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.RangeDegree#isLowerBoundIncluded()
	 * @see #getRangeDegree()
	 * @generated
	 */
	EAttribute getRangeDegree_LowerBoundIncluded();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree <em>Enumeration Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree
	 * @generated
	 */
	EClass getEnumerationDegree();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree#getDomainOfEntities <em>Domain Of Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Domain Of Entities</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree#getDomainOfEntities()
	 * @see #getEnumerationDegree()
	 * @generated
	 */
	EReference getEnumerationDegree_DomainOfEntities();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice <em>Enumeration Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Choice</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice
	 * @generated
	 */
	EClass getEnumerationChoice();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Entity</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice#getEntity()
	 * @see #getEnumerationChoice()
	 * @generated
	 */
	EReference getEnumerationChoice_Entity();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice <em>Continous Range Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continous Range Choice</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice
	 * @generated
	 */
	EClass getContinousRangeChoice();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice#getChosenValue <em>Chosen Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chosen Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice#getChosenValue()
	 * @see #getContinousRangeChoice()
	 * @generated
	 */
	EAttribute getContinousRangeChoice_ChosenValue();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree <em>Continuous Processing Rate Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continuous Processing Rate Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree
	 * @generated
	 */
	EClass getContinuousProcessingRateDegree();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree <em>Continuous Range Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continuous Range Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree
	 * @generated
	 */
	EClass getContinuousRangeDegree();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree#getTo()
	 * @see #getContinuousRangeDegree()
	 * @generated
	 */
	EAttribute getContinuousRangeDegree_To();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree#getFrom()
	 * @see #getContinuousRangeDegree()
	 * @generated
	 */
	EAttribute getContinuousRangeDegree_From();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree <em>Processing Resource Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Resource Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree
	 * @generated
	 */
	EClass getProcessingResourceDegree();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree#getProcessingresourcetype <em>Processingresourcetype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Processingresourcetype</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree#getProcessingresourcetype()
	 * @see #getProcessingResourceDegree()
	 * @generated
	 */
	EReference getProcessingResourceDegree_Processingresourcetype();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.AllocationDegree <em>Allocation Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocation Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.AllocationDegree
	 * @generated
	 */
	EClass getAllocationDegree();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree <em>Assembled Component Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assembled Component Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree
	 * @generated
	 */
	EClass getAssembledComponentDegree();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree <em>Discrete Range Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Discrete Range Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree
	 * @generated
	 */
	EClass getDiscreteRangeDegree();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree#getTo()
	 * @see #getDiscreteRangeDegree()
	 * @generated
	 */
	EAttribute getDiscreteRangeDegree_To();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree#getFrom()
	 * @see #getDiscreteRangeDegree()
	 * @generated
	 */
	EAttribute getDiscreteRangeDegree_From();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice <em>Discrete Range Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Discrete Range Choice</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice
	 * @generated
	 */
	EClass getDiscreteRangeChoice();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice#getChosenValue <em>Chosen Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chosen Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice#getChosenValue()
	 * @see #getDiscreteRangeChoice()
	 * @generated
	 */
	EAttribute getDiscreteRangeChoice_ChosenValue();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree <em>Resource Container Replication Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Container Replication Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree
	 * @generated
	 */
	EClass getResourceContainerReplicationDegree();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.Problem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Problem</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Problem
	 * @generated
	 */
	EClass getProblem();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.designdecision.Problem#getDesigndecision <em>Designdecision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Designdecision</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Problem#getDesigndecision()
	 * @see #getProblem()
	 * @generated
	 */
	EReference getProblem_Designdecision();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.ConnectorConfigDegree <em>Connector Config Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Config Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.ConnectorConfigDegree
	 * @generated
	 */
	EClass getConnectorConfigDegree();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.Candidate <em>Candidate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Candidate</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Candidate
	 * @generated
	 */
	EClass getCandidate();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.designdecision.Candidate#getChoice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Choice</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Candidate#getChoice()
	 * @see #getCandidate()
	 * @generated
	 */
	EReference getCandidate_Choice();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.Candidates <em>Candidates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Candidates</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Candidates
	 * @generated
	 */
	EClass getCandidates();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.designdecision.Candidates#getCandidate <em>Candidate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Candidate</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Candidates#getCandidate()
	 * @see #getCandidates()
	 * @generated
	 */
	EReference getCandidates_Candidate();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.Candidates#getProblem <em>Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Problem</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.Candidates#getProblem()
	 * @see #getCandidates()
	 * @generated
	 */
	EReference getCandidates_Problem();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.FeatureConfigDegree <em>Feature Config Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Config Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.FeatureConfigDegree
	 * @generated
	 */
	EClass getFeatureConfigDegree();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree <em>Feature Group Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Group Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree
	 * @generated
	 */
	EClass getFeatureGroupDegree();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree#getFeaturegroup <em>Featuregroup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Featuregroup</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree#getFeaturegroup()
	 * @see #getFeatureGroupDegree()
	 * @generated
	 */
	EReference getFeatureGroupDegree_Featuregroup();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree#getDomainOfFeatureConfigCombinations <em>Domain Of Feature Config Combinations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domain Of Feature Config Combinations</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.FeatureGroupDegree#getDomainOfFeatureConfigCombinations()
	 * @see #getFeatureGroupDegree()
	 * @generated
	 */
	EReference getFeatureGroupDegree_DomainOfFeatureConfigCombinations();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.FeatureSubset <em>Feature Subset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Subset</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.FeatureSubset
	 * @generated
	 */
	EClass getFeatureSubset();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.designdecision.FeatureSubset#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Feature</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.FeatureSubset#getFeature()
	 * @see #getFeatureSubset()
	 * @generated
	 */
	EReference getFeatureSubset_Feature();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.OptionalFeatureDegree <em>Optional Feature Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Optional Feature Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.OptionalFeatureDegree
	 * @generated
	 */
	EClass getOptionalFeatureDegree();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.designdecision.OptionalFeatureDegree#getSimple <em>Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Simple</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.OptionalFeatureDegree#getSimple()
	 * @see #getOptionalFeatureDegree()
	 * @generated
	 */
	EReference getOptionalFeatureDegree_Simple();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree <em>Discrete Processing Rate Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Discrete Processing Rate Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree
	 * @generated
	 */
	EClass getDiscreteProcessingRateDegree();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree#getNumberOfSteps <em>Number Of Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Steps</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree#getNumberOfSteps()
	 * @see #getDiscreteProcessingRateDegree()
	 * @generated
	 */
	EAttribute getDiscreteProcessingRateDegree_NumberOfSteps();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.CapacityDegree <em>Capacity Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capacity Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.CapacityDegree
	 * @generated
	 */
	EClass getCapacityDegree();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree <em>Scheduling Policy Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Policy Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree
	 * @generated
	 */
	EClass getSchedulingPolicyDegree();

	/**
	 * Returns the meta object for the attribute list '{@link de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree#getDomainOfAllowedSchedulingPolicies <em>Domain Of Allowed Scheduling Policies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Domain Of Allowed Scheduling Policies</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree#getDomainOfAllowedSchedulingPolicies()
	 * @see #getSchedulingPolicyDegree()
	 * @generated
	 */
	EAttribute getSchedulingPolicyDegree_DomainOfAllowedSchedulingPolicies();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.EnumDegree <em>Enum Degree</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Degree</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.EnumDegree
	 * @generated
	 */
	EClass getEnumDegree();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyChoice <em>Scheduling Policy Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Policy Choice</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyChoice
	 * @generated
	 */
	EClass getSchedulingPolicyChoice();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyChoice#getChosenValue <em>Chosen Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chosen Value</em>'.
	 * @see de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyChoice#getChosenValue()
	 * @see #getSchedulingPolicyChoice()
	 * @generated
	 */
	EAttribute getSchedulingPolicyChoice_ChosenValue();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	designdecisionFactory getdesigndecisionFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DegreeOfFreedomImpl <em>Degree Of Freedom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DegreeOfFreedomImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDegreeOfFreedom()
		 * @generated
		 */
		EClass DEGREE_OF_FREEDOM = eINSTANCE.getDegreeOfFreedom();

		/**
		 * The meta object literal for the '<em><b>Changeable Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEGREE_OF_FREEDOM__CHANGEABLE_ENTITY = eINSTANCE.getDegreeOfFreedom_ChangeableEntity();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ChoiceImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '<em><b>Degree Of Freedom</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE__DEGREE_OF_FREEDOM = eINSTANCE.getChoice_DegreeOfFreedom();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.RangeDegreeImpl <em>Range Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.RangeDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getRangeDegree()
		 * @generated
		 */
		EClass RANGE_DEGREE = eINSTANCE.getRangeDegree();

		/**
		 * The meta object literal for the '<em><b>Upper Bound Included</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE_DEGREE__UPPER_BOUND_INCLUDED = eINSTANCE.getRangeDegree_UpperBoundIncluded();

		/**
		 * The meta object literal for the '<em><b>Lower Bound Included</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE_DEGREE__LOWER_BOUND_INCLUDED = eINSTANCE.getRangeDegree_LowerBoundIncluded();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationDegreeImpl <em>Enumeration Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getEnumerationDegree()
		 * @generated
		 */
		EClass ENUMERATION_DEGREE = eINSTANCE.getEnumerationDegree();

		/**
		 * The meta object literal for the '<em><b>Domain Of Entities</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_DEGREE__DOMAIN_OF_ENTITIES = eINSTANCE.getEnumerationDegree_DomainOfEntities();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationChoiceImpl <em>Enumeration Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationChoiceImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getEnumerationChoice()
		 * @generated
		 */
		EClass ENUMERATION_CHOICE = eINSTANCE.getEnumerationChoice();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_CHOICE__ENTITY = eINSTANCE.getEnumerationChoice_Entity();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ContinousRangeChoiceImpl <em>Continous Range Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ContinousRangeChoiceImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getContinousRangeChoice()
		 * @generated
		 */
		EClass CONTINOUS_RANGE_CHOICE = eINSTANCE.getContinousRangeChoice();

		/**
		 * The meta object literal for the '<em><b>Chosen Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTINOUS_RANGE_CHOICE__CHOSEN_VALUE = eINSTANCE.getContinousRangeChoice_ChosenValue();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ContinuousProcessingRateDegreeImpl <em>Continuous Processing Rate Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ContinuousProcessingRateDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getContinuousProcessingRateDegree()
		 * @generated
		 */
		EClass CONTINUOUS_PROCESSING_RATE_DEGREE = eINSTANCE.getContinuousProcessingRateDegree();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ContinuousRangeDegreeImpl <em>Continuous Range Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ContinuousRangeDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getContinuousRangeDegree()
		 * @generated
		 */
		EClass CONTINUOUS_RANGE_DEGREE = eINSTANCE.getContinuousRangeDegree();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTINUOUS_RANGE_DEGREE__TO = eINSTANCE.getContinuousRangeDegree_To();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTINUOUS_RANGE_DEGREE__FROM = eINSTANCE.getContinuousRangeDegree_From();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingResourceDegreeImpl <em>Processing Resource Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingResourceDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getProcessingResourceDegree()
		 * @generated
		 */
		EClass PROCESSING_RESOURCE_DEGREE = eINSTANCE.getProcessingResourceDegree();

		/**
		 * The meta object literal for the '<em><b>Processingresourcetype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSING_RESOURCE_DEGREE__PROCESSINGRESOURCETYPE = eINSTANCE.getProcessingResourceDegree_Processingresourcetype();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.AllocationDegreeImpl <em>Allocation Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.AllocationDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getAllocationDegree()
		 * @generated
		 */
		EClass ALLOCATION_DEGREE = eINSTANCE.getAllocationDegree();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.AssembledComponentDegreeImpl <em>Assembled Component Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.AssembledComponentDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getAssembledComponentDegree()
		 * @generated
		 */
		EClass ASSEMBLED_COMPONENT_DEGREE = eINSTANCE.getAssembledComponentDegree();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteRangeDegreeImpl <em>Discrete Range Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteRangeDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDiscreteRangeDegree()
		 * @generated
		 */
		EClass DISCRETE_RANGE_DEGREE = eINSTANCE.getDiscreteRangeDegree();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCRETE_RANGE_DEGREE__TO = eINSTANCE.getDiscreteRangeDegree_To();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCRETE_RANGE_DEGREE__FROM = eINSTANCE.getDiscreteRangeDegree_From();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteRangeChoiceImpl <em>Discrete Range Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteRangeChoiceImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDiscreteRangeChoice()
		 * @generated
		 */
		EClass DISCRETE_RANGE_CHOICE = eINSTANCE.getDiscreteRangeChoice();

		/**
		 * The meta object literal for the '<em><b>Chosen Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCRETE_RANGE_CHOICE__CHOSEN_VALUE = eINSTANCE.getDiscreteRangeChoice_ChosenValue();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationDegreeImpl <em>Resource Container Replication Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ResourceContainerReplicationDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getResourceContainerReplicationDegree()
		 * @generated
		 */
		EClass RESOURCE_CONTAINER_REPLICATION_DEGREE = eINSTANCE.getResourceContainerReplicationDegree();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProblemImpl <em>Problem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ProblemImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getProblem()
		 * @generated
		 */
		EClass PROBLEM = eINSTANCE.getProblem();

		/**
		 * The meta object literal for the '<em><b>Designdecision</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBLEM__DESIGNDECISION = eINSTANCE.getProblem_Designdecision();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.ConnectorConfigDegreeImpl <em>Connector Config Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.ConnectorConfigDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getConnectorConfigDegree()
		 * @generated
		 */
		EClass CONNECTOR_CONFIG_DEGREE = eINSTANCE.getConnectorConfigDegree();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.CandidateImpl <em>Candidate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.CandidateImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getCandidate()
		 * @generated
		 */
		EClass CANDIDATE = eINSTANCE.getCandidate();

		/**
		 * The meta object literal for the '<em><b>Choice</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CANDIDATE__CHOICE = eINSTANCE.getCandidate_Choice();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.CandidatesImpl <em>Candidates</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.CandidatesImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getCandidates()
		 * @generated
		 */
		EClass CANDIDATES = eINSTANCE.getCandidates();

		/**
		 * The meta object literal for the '<em><b>Candidate</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CANDIDATES__CANDIDATE = eINSTANCE.getCandidates_Candidate();

		/**
		 * The meta object literal for the '<em><b>Problem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CANDIDATES__PROBLEM = eINSTANCE.getCandidates_Problem();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.FeatureConfigDegreeImpl <em>Feature Config Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.FeatureConfigDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getFeatureConfigDegree()
		 * @generated
		 */
		EClass FEATURE_CONFIG_DEGREE = eINSTANCE.getFeatureConfigDegree();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.FeatureGroupDegreeImpl <em>Feature Group Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.FeatureGroupDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getFeatureGroupDegree()
		 * @generated
		 */
		EClass FEATURE_GROUP_DEGREE = eINSTANCE.getFeatureGroupDegree();

		/**
		 * The meta object literal for the '<em><b>Featuregroup</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_GROUP_DEGREE__FEATUREGROUP = eINSTANCE.getFeatureGroupDegree_Featuregroup();

		/**
		 * The meta object literal for the '<em><b>Domain Of Feature Config Combinations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_GROUP_DEGREE__DOMAIN_OF_FEATURE_CONFIG_COMBINATIONS = eINSTANCE.getFeatureGroupDegree_DomainOfFeatureConfigCombinations();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.FeatureSubsetImpl <em>Feature Subset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.FeatureSubsetImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getFeatureSubset()
		 * @generated
		 */
		EClass FEATURE_SUBSET = eINSTANCE.getFeatureSubset();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_SUBSET__FEATURE = eINSTANCE.getFeatureSubset_Feature();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.OptionalFeatureDegreeImpl <em>Optional Feature Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.OptionalFeatureDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getOptionalFeatureDegree()
		 * @generated
		 */
		EClass OPTIONAL_FEATURE_DEGREE = eINSTANCE.getOptionalFeatureDegree();

		/**
		 * The meta object literal for the '<em><b>Simple</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPTIONAL_FEATURE_DEGREE__SIMPLE = eINSTANCE.getOptionalFeatureDegree_Simple();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteProcessingRateDegreeImpl <em>Discrete Processing Rate Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.DiscreteProcessingRateDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getDiscreteProcessingRateDegree()
		 * @generated
		 */
		EClass DISCRETE_PROCESSING_RATE_DEGREE = eINSTANCE.getDiscreteProcessingRateDegree();

		/**
		 * The meta object literal for the '<em><b>Number Of Steps</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISCRETE_PROCESSING_RATE_DEGREE__NUMBER_OF_STEPS = eINSTANCE.getDiscreteProcessingRateDegree_NumberOfSteps();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.CapacityDegreeImpl <em>Capacity Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.CapacityDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getCapacityDegree()
		 * @generated
		 */
		EClass CAPACITY_DEGREE = eINSTANCE.getCapacityDegree();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.SchedulingPolicyDegreeImpl <em>Scheduling Policy Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.SchedulingPolicyDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getSchedulingPolicyDegree()
		 * @generated
		 */
		EClass SCHEDULING_POLICY_DEGREE = eINSTANCE.getSchedulingPolicyDegree();

		/**
		 * The meta object literal for the '<em><b>Domain Of Allowed Scheduling Policies</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_POLICY_DEGREE__DOMAIN_OF_ALLOWED_SCHEDULING_POLICIES = eINSTANCE.getSchedulingPolicyDegree_DomainOfAllowedSchedulingPolicies();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.EnumDegreeImpl <em>Enum Degree</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.EnumDegreeImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getEnumDegree()
		 * @generated
		 */
		EClass ENUM_DEGREE = eINSTANCE.getEnumDegree();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.designdecision.impl.SchedulingPolicyChoiceImpl <em>Scheduling Policy Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.SchedulingPolicyChoiceImpl
		 * @see de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionPackageImpl#getSchedulingPolicyChoice()
		 * @generated
		 */
		EClass SCHEDULING_POLICY_CHOICE = eINSTANCE.getSchedulingPolicyChoice();

		/**
		 * The meta object literal for the '<em><b>Chosen Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULING_POLICY_CHOICE__CHOSEN_VALUE = eINSTANCE.getSchedulingPolicyChoice_ChosenValue();

	}

} //designdecisionPackage
