/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription;

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
 * Model of control-flow descriptions. Control-flow descriptions contain a control-flow graph and additional informations on
 * possible paths within that graph.
 * <!-- end-model-doc -->
 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptionFactory
 * @model kind="package"
 * @generated
 */
public interface ControlFlowDescriptionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "controlflowdescription";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.fzi.de/ControlFlowDescription/0.6";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "controlflowdescription";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ControlFlowDescriptionPackage eINSTANCE = de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionImpl <em>Control Flow Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionImpl
	 * @see de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionPackageImpl#getControlFlowDescription()
	 * @generated
	 */
	int CONTROL_FLOW_DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Jjnpathsets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_DESCRIPTION__JJNPATHSETS = 0;

	/**
	 * The feature id for the '<em><b>Jjpaths</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_DESCRIPTION__JJPATHS = 1;

	/**
	 * The feature id for the '<em><b>Controlflowdescriptions</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS = 2;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_DESCRIPTION__GRAPH = 3;

	/**
	 * The number of structural features of the '<em>Control Flow Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_DESCRIPTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionsImpl <em>Control Flow Descriptions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionsImpl
	 * @see de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionPackageImpl#getControlFlowDescriptions()
	 * @generated
	 */
	int CONTROL_FLOW_DESCRIPTIONS = 1;

	/**
	 * The feature id for the '<em><b>Control Flow Description</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_DESCRIPTIONS__CONTROL_FLOW_DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Control Flow Descriptions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_DESCRIPTIONS_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.fzi.se.controlflowdescription.ControlFlowDescription <em>Control Flow Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Flow Description</em>'.
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescription
	 * @generated
	 */
	EClass getControlFlowDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getJjnpathsets <em>Jjnpathsets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Jjnpathsets</em>'.
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescription#getJjnpathsets()
	 * @see #getControlFlowDescription()
	 * @generated
	 */
	EReference getControlFlowDescription_Jjnpathsets();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getJjpaths <em>Jjpaths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Jjpaths</em>'.
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescription#getJjpaths()
	 * @see #getControlFlowDescription()
	 * @generated
	 */
	EReference getControlFlowDescription_Jjpaths();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getControlflowdescriptions <em>Controlflowdescriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Controlflowdescriptions</em>'.
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescription#getControlflowdescriptions()
	 * @see #getControlFlowDescription()
	 * @generated
	 */
	EReference getControlFlowDescription_Controlflowdescriptions();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.se.controlflowdescription.ControlFlowDescription#getGraph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Graph</em>'.
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescription#getGraph()
	 * @see #getControlFlowDescription()
	 * @generated
	 */
	EReference getControlFlowDescription_Graph();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.controlflowdescription.ControlFlowDescriptions <em>Control Flow Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Flow Descriptions</em>'.
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptions
	 * @generated
	 */
	EClass getControlFlowDescriptions();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.controlflowdescription.ControlFlowDescriptions#getControlFlowDescription <em>Control Flow Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Control Flow Description</em>'.
	 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptions#getControlFlowDescription()
	 * @see #getControlFlowDescriptions()
	 * @generated
	 */
	EReference getControlFlowDescriptions_ControlFlowDescription();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ControlFlowDescriptionFactory getControlFlowDescriptionFactory();

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
		 * The meta object literal for the '{@link de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionImpl <em>Control Flow Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionImpl
		 * @see de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionPackageImpl#getControlFlowDescription()
		 * @generated
		 */
		EClass CONTROL_FLOW_DESCRIPTION = eINSTANCE.getControlFlowDescription();

		/**
		 * The meta object literal for the '<em><b>Jjnpathsets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_FLOW_DESCRIPTION__JJNPATHSETS = eINSTANCE.getControlFlowDescription_Jjnpathsets();

		/**
		 * The meta object literal for the '<em><b>Jjpaths</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_FLOW_DESCRIPTION__JJPATHS = eINSTANCE.getControlFlowDescription_Jjpaths();

		/**
		 * The meta object literal for the '<em><b>Controlflowdescriptions</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_FLOW_DESCRIPTION__CONTROLFLOWDESCRIPTIONS = eINSTANCE.getControlFlowDescription_Controlflowdescriptions();

		/**
		 * The meta object literal for the '<em><b>Graph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_FLOW_DESCRIPTION__GRAPH = eINSTANCE.getControlFlowDescription_Graph();

		/**
		 * The meta object literal for the '{@link de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionsImpl <em>Control Flow Descriptions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionsImpl
		 * @see de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionPackageImpl#getControlFlowDescriptions()
		 * @generated
		 */
		EClass CONTROL_FLOW_DESCRIPTIONS = eINSTANCE.getControlFlowDescriptions();

		/**
		 * The meta object literal for the '<em><b>Control Flow Description</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_FLOW_DESCRIPTIONS__CONTROL_FLOW_DESCRIPTION = eINSTANCE.getControlFlowDescriptions_ControlFlowDescription();

	}

} //ControlFlowDescriptionPackage
