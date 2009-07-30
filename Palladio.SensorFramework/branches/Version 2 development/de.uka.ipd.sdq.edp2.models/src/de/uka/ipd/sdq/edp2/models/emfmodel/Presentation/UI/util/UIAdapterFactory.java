/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.util;

import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage
 * @generated
 */
public class UIAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UIPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UIAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UIPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UISwitch<Adapter> modelSwitch =
		new UISwitch<Adapter>() {
			@Override
			public Adapter casePresentationView(PresentationView object) {
				return createPresentationViewAdapter();
			}
			@Override
			public Adapter casePresentationType(PresentationType object) {
				return createPresentationTypeAdapter();
			}
			@Override
			public Adapter casePresentationConfiguration(PresentationConfiguration object) {
				return createPresentationConfigurationAdapter();
			}
			@Override
			public Adapter casePresentationController(PresentationController object) {
				return createPresentationControllerAdapter();
			}
			@Override
			public Adapter casePresentationPropertyPane(PresentationPropertyPane object) {
				return createPresentationPropertyPaneAdapter();
			}
			@Override
			public Adapter casePresentationInput(PresentationInput object) {
				return createPresentationInputAdapter();
			}
			@Override
			public Adapter caseLocalFileStorage(LocalFileStorage object) {
				return createLocalFileStorageAdapter();
			}
			@Override
			public Adapter caseLocalMemoryStorage(LocalMemoryStorage object) {
				return createLocalMemoryStorageAdapter();
			}
			@Override
			public Adapter caseRemoteStorage(RemoteStorage object) {
				return createRemoteStorageAdapter();
			}
			@Override
			public Adapter caseSensorFrameworkVersion1Storage(SensorFrameworkVersion1Storage object) {
				return createSensorFrameworkVersion1StorageAdapter();
			}
			@Override
			public Adapter caseStorageNodes(StorageNodes object) {
				return createStorageNodesAdapter();
			}
			@Override
			public Adapter caseStorageNode(StorageNode object) {
				return createStorageNodeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationConfiguration <em>Presentation Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationConfiguration
	 * @generated
	 */
	public Adapter createPresentationConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController <em>Presentation Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationController
	 * @generated
	 */
	public Adapter createPresentationControllerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationPropertyPane <em>Presentation Property Pane</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationPropertyPane
	 * @generated
	 */
	public Adapter createPresentationPropertyPaneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationInput <em>Presentation Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationInput
	 * @generated
	 */
	public Adapter createPresentationInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationType <em>Presentation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationType
	 * @generated
	 */
	public Adapter createPresentationTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNode <em>Storage Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNode
	 * @generated
	 */
	public Adapter createStorageNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalFileStorage <em>Local File Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalFileStorage
	 * @generated
	 */
	public Adapter createLocalFileStorageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalMemoryStorage <em>Local Memory Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalMemoryStorage
	 * @generated
	 */
	public Adapter createLocalMemoryStorageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.RemoteStorage <em>Remote Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.RemoteStorage
	 * @generated
	 */
	public Adapter createRemoteStorageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage <em>Sensor Framework Version1 Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.SensorFrameworkVersion1Storage
	 * @generated
	 */
	public Adapter createSensorFrameworkVersion1StorageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNodes <em>Storage Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.StorageNodes
	 * @generated
	 */
	public Adapter createStorageNodesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationView <em>Presentation View</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.PresentationView
	 * @generated
	 */
	public Adapter createPresentationViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //UIAdapterFactory
