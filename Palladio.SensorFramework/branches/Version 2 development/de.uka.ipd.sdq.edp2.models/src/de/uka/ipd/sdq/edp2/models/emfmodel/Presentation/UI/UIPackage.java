/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI;

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
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIFactory
 * @model kind="package"
 * @generated
 */
public interface UIPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "UI";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///EDP2/Presentation/UI.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "EDP2.Presentation.UI";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UIPackage eINSTANCE = de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationConfigurationImpl <em>Presentation Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationConfigurationImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationConfiguration()
	 * @generated
	 */
	int PRESENTATION_CONFIGURATION = 0;

	/**
	 * The number of structural features of the '<em>Presentation Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationControllerImpl <em>Presentation Controller</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationControllerImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationController()
	 * @generated
	 */
	int PRESENTATION_CONTROLLER = 1;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_CONTROLLER__CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>View</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_CONTROLLER__VIEW = 1;

	/**
	 * The feature id for the '<em><b>Property Pane</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_CONTROLLER__PROPERTY_PANE = 2;

	/**
	 * The feature id for the '<em><b>Data Reader</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_CONTROLLER__DATA_READER = 3;

	/**
	 * The number of structural features of the '<em>Presentation Controller</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_CONTROLLER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationPropertyPaneImpl <em>Presentation Property Pane</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationPropertyPaneImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationPropertyPane()
	 * @generated
	 */
	int PRESENTATION_PROPERTY_PANE = 2;

	/**
	 * The number of structural features of the '<em>Presentation Property Pane</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_PROPERTY_PANE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationInputImpl <em>Presentation Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationInputImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationInput()
	 * @generated
	 */
	int PRESENTATION_INPUT = 3;

	/**
	 * The feature id for the '<em><b>Data Source Description</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_INPUT__DATA_SOURCE_DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Presentation Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_INPUT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationTypeImpl <em>Presentation Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationTypeImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationType()
	 * @generated
	 */
	int PRESENTATION_TYPE = 4;

	/**
	 * The number of structural features of the '<em>Presentation Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationViewImpl <em>Presentation View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationViewImpl
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationView()
	 * @generated
	 */
	int PRESENTATION_VIEW = 5;

	/**
	 * The number of structural features of the '<em>Presentation View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRESENTATION_VIEW_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationConfiguration <em>Presentation Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Configuration</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationConfiguration
	 * @generated
	 */
	EClass getPresentationConfiguration();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController <em>Presentation Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Controller</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController
	 * @generated
	 */
	EClass getPresentationController();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Configuration</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getConfiguration()
	 * @see #getPresentationController()
	 * @generated
	 */
	EReference getPresentationController_Configuration();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getView <em>View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>View</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getView()
	 * @see #getPresentationController()
	 * @generated
	 */
	EReference getPresentationController_View();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getPropertyPane <em>Property Pane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Pane</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getPropertyPane()
	 * @see #getPresentationController()
	 * @generated
	 */
	EReference getPresentationController_PropertyPane();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getDataReader <em>Data Reader</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Reader</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController#getDataReader()
	 * @see #getPresentationController()
	 * @generated
	 */
	EReference getPresentationController_DataReader();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationPropertyPane <em>Presentation Property Pane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Property Pane</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationPropertyPane
	 * @generated
	 */
	EClass getPresentationPropertyPane();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationInput <em>Presentation Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Input</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationInput
	 * @generated
	 */
	EClass getPresentationInput();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationInput#getDataSourceDescription <em>Data Source Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Source Description</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationInput#getDataSourceDescription()
	 * @see #getPresentationInput()
	 * @generated
	 */
	EReference getPresentationInput_DataSourceDescription();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationType <em>Presentation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation Type</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationType
	 * @generated
	 */
	EClass getPresentationType();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationView <em>Presentation View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Presentation View</em>'.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationView
	 * @generated
	 */
	EClass getPresentationView();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UIFactory getUIFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationConfigurationImpl <em>Presentation Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationConfigurationImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationConfiguration()
		 * @generated
		 */
		EClass PRESENTATION_CONFIGURATION = eINSTANCE.getPresentationConfiguration();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationControllerImpl <em>Presentation Controller</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationControllerImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationController()
		 * @generated
		 */
		EClass PRESENTATION_CONTROLLER = eINSTANCE.getPresentationController();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION_CONTROLLER__CONFIGURATION = eINSTANCE.getPresentationController_Configuration();

		/**
		 * The meta object literal for the '<em><b>View</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION_CONTROLLER__VIEW = eINSTANCE.getPresentationController_View();

		/**
		 * The meta object literal for the '<em><b>Property Pane</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION_CONTROLLER__PROPERTY_PANE = eINSTANCE.getPresentationController_PropertyPane();

		/**
		 * The meta object literal for the '<em><b>Data Reader</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION_CONTROLLER__DATA_READER = eINSTANCE.getPresentationController_DataReader();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationPropertyPaneImpl <em>Presentation Property Pane</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationPropertyPaneImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationPropertyPane()
		 * @generated
		 */
		EClass PRESENTATION_PROPERTY_PANE = eINSTANCE.getPresentationPropertyPane();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationInputImpl <em>Presentation Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationInputImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationInput()
		 * @generated
		 */
		EClass PRESENTATION_INPUT = eINSTANCE.getPresentationInput();

		/**
		 * The meta object literal for the '<em><b>Data Source Description</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRESENTATION_INPUT__DATA_SOURCE_DESCRIPTION = eINSTANCE.getPresentationInput_DataSourceDescription();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationTypeImpl <em>Presentation Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationTypeImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationType()
		 * @generated
		 */
		EClass PRESENTATION_TYPE = eINSTANCE.getPresentationType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationViewImpl <em>Presentation View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.PresentationViewImpl
		 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.UIPackageImpl#getPresentationView()
		 * @generated
		 */
		EClass PRESENTATION_VIEW = eINSTANCE.getPresentationView();

	}

} //UIPackage
