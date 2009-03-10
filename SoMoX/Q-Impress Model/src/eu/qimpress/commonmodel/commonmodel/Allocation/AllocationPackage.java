/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.Allocation;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;

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
 * The package Allocation encapsulates allocation concerns of components. Deployed component on a deployment Node is Service and can be called by Clients (potentially over the Network).
 * 
 * <!-- end-model-doc -->
 * @see eu.qimpress.commonmodel.commonmodel.Allocation.AllocationFactory
 * @model kind="package"
 * @generated
 */
public interface AllocationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Allocation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///CoreModel/Allocation.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CoreModel.Allocation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AllocationPackage eINSTANCE = eu.qimpress.commonmodel.commonmodel.Allocation.impl.AllocationPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.Allocation.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.Allocation.impl.ServiceImpl
	 * @see eu.qimpress.commonmodel.commonmodel.Allocation.impl.AllocationPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__ID = StaticStructurePackage.COMPOSITE_STRUCTURE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NAME = StaticStructurePackage.COMPOSITE_STRUCTURE__NAME;

	/**
	 * The feature id for the '<em><b>Required</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__REQUIRED = StaticStructurePackage.COMPOSITE_STRUCTURE__REQUIRED;

	/**
	 * The feature id for the '<em><b>Provided</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PROVIDED = StaticStructurePackage.COMPOSITE_STRUCTURE__PROVIDED;

	/**
	 * The feature id for the '<em><b>Behaviour</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__BEHAVIOUR = StaticStructurePackage.COMPOSITE_STRUCTURE__BEHAVIOUR;

	/**
	 * The feature id for the '<em><b>Subcomponents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__SUBCOMPONENTS = StaticStructurePackage.COMPOSITE_STRUCTURE__SUBCOMPONENTS;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__CONNECTOR = StaticStructurePackage.COMPOSITE_STRUCTURE__CONNECTOR;

	/**
	 * The feature id for the '<em><b>Is Black Box</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__IS_BLACK_BOX = StaticStructurePackage.COMPOSITE_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__NODE = StaticStructurePackage.COMPOSITE_STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__COMPONENT = StaticStructurePackage.COMPOSITE_STRUCTURE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = StaticStructurePackage.COMPOSITE_STRUCTURE_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.Allocation.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.Allocation.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link eu.qimpress.commonmodel.commonmodel.Allocation.Service#isIsBlackBox <em>Is Black Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Black Box</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.Allocation.Service#isIsBlackBox()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_IsBlackBox();

	/**
	 * Returns the meta object for the reference list '{@link eu.qimpress.commonmodel.commonmodel.Allocation.Service#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Node</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.Allocation.Service#getNode()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Node();

	/**
	 * Returns the meta object for the reference '{@link eu.qimpress.commonmodel.commonmodel.Allocation.Service#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.Allocation.Service#getComponent()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Component();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AllocationFactory getAllocationFactory();

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
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.Allocation.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.Allocation.impl.ServiceImpl
		 * @see eu.qimpress.commonmodel.commonmodel.Allocation.impl.AllocationPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Is Black Box</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__IS_BLACK_BOX = eINSTANCE.getService_IsBlackBox();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__NODE = eINSTANCE.getService_Node();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__COMPONENT = eINSTANCE.getService_Component();

	}

} //AllocationPackage
