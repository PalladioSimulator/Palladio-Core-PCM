/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.ResourceEnvironment;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * The ResourceEnvironment package specifies Hardware- and Software-Resources and is used as Allocation Target. Supports Modelling of CPUs, Disks, Network Links, and Main Memory.
 * <!-- end-model-doc -->
 * @see eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.ResourceEnvironmentFactory
 * @model kind="package"
 * @generated
 */
public interface ResourceEnvironmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ResourceEnvironment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///CoreModel/ResourceEnvironment.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "CoreModel.ResourceEnvironment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourceEnvironmentPackage eINSTANCE = eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.impl.ResourceEnvironmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.impl.NodeImpl
	 * @see eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.impl.ResourceEnvironmentPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResourceEnvironmentFactory getResourceEnvironmentFactory();

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
		 * The meta object literal for the '{@link eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.impl.NodeImpl
		 * @see eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.impl.ResourceEnvironmentPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

	}

} //ResourceEnvironmentPackage
