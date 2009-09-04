/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation.UI.impl;

import de.uka.ipd.sdq.edp2.models.Presentation.DataReader;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationConfiguration;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationController;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationPropertyPane;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.PresentationView;
import de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Presentation Controller</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.UI.impl.PresentationControllerImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.UI.impl.PresentationControllerImpl#getView <em>View</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.UI.impl.PresentationControllerImpl#getPropertyPane <em>Property Pane</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.UI.impl.PresentationControllerImpl#getDataReader <em>Data Reader</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PresentationControllerImpl extends EObjectImpl implements PresentationController {
	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected PresentationConfiguration configuration;

	/**
	 * The cached value of the '{@link #getView() <em>View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getView()
	 * @generated
	 * @ordered
	 */
	protected PresentationView view;

	/**
	 * The cached value of the '{@link #getPropertyPane() <em>Property Pane</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyPane()
	 * @generated
	 * @ordered
	 */
	protected EList<PresentationPropertyPane> propertyPane;

	/**
	 * The cached value of the '{@link #getDataReader() <em>Data Reader</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataReader()
	 * @generated
	 * @ordered
	 */
	protected EList<DataReader> dataReader;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PresentationControllerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UIPackage.Literals.PRESENTATION_CONTROLLER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(PresentationConfiguration newConfiguration, NotificationChain msgs) {
		PresentationConfiguration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UIPackage.PRESENTATION_CONTROLLER__CONFIGURATION, oldConfiguration, newConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(PresentationConfiguration newConfiguration) {
		if (newConfiguration != configuration) {
			NotificationChain msgs = null;
			if (configuration != null)
				msgs = ((InternalEObject)configuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UIPackage.PRESENTATION_CONTROLLER__CONFIGURATION, null, msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UIPackage.PRESENTATION_CONTROLLER__CONFIGURATION, null, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UIPackage.PRESENTATION_CONTROLLER__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PresentationView getView() {
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetView(PresentationView newView, NotificationChain msgs) {
		PresentationView oldView = view;
		view = newView;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UIPackage.PRESENTATION_CONTROLLER__VIEW, oldView, newView);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setView(PresentationView newView) {
		if (newView != view) {
			NotificationChain msgs = null;
			if (view != null)
				msgs = ((InternalEObject)view).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UIPackage.PRESENTATION_CONTROLLER__VIEW, null, msgs);
			if (newView != null)
				msgs = ((InternalEObject)newView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UIPackage.PRESENTATION_CONTROLLER__VIEW, null, msgs);
			msgs = basicSetView(newView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UIPackage.PRESENTATION_CONTROLLER__VIEW, newView, newView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PresentationPropertyPane> getPropertyPane() {
		if (propertyPane == null) {
			propertyPane = new EObjectContainmentEList<PresentationPropertyPane>(PresentationPropertyPane.class, this, UIPackage.PRESENTATION_CONTROLLER__PROPERTY_PANE);
		}
		return propertyPane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataReader> getDataReader() {
		if (dataReader == null) {
			dataReader = new EObjectContainmentEList<DataReader>(DataReader.class, this, UIPackage.PRESENTATION_CONTROLLER__DATA_READER);
		}
		return dataReader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UIPackage.PRESENTATION_CONTROLLER__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
			case UIPackage.PRESENTATION_CONTROLLER__VIEW:
				return basicSetView(null, msgs);
			case UIPackage.PRESENTATION_CONTROLLER__PROPERTY_PANE:
				return ((InternalEList<?>)getPropertyPane()).basicRemove(otherEnd, msgs);
			case UIPackage.PRESENTATION_CONTROLLER__DATA_READER:
				return ((InternalEList<?>)getDataReader()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UIPackage.PRESENTATION_CONTROLLER__CONFIGURATION:
				return getConfiguration();
			case UIPackage.PRESENTATION_CONTROLLER__VIEW:
				return getView();
			case UIPackage.PRESENTATION_CONTROLLER__PROPERTY_PANE:
				return getPropertyPane();
			case UIPackage.PRESENTATION_CONTROLLER__DATA_READER:
				return getDataReader();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UIPackage.PRESENTATION_CONTROLLER__CONFIGURATION:
				setConfiguration((PresentationConfiguration)newValue);
				return;
			case UIPackage.PRESENTATION_CONTROLLER__VIEW:
				setView((PresentationView)newValue);
				return;
			case UIPackage.PRESENTATION_CONTROLLER__PROPERTY_PANE:
				getPropertyPane().clear();
				getPropertyPane().addAll((Collection<? extends PresentationPropertyPane>)newValue);
				return;
			case UIPackage.PRESENTATION_CONTROLLER__DATA_READER:
				getDataReader().clear();
				getDataReader().addAll((Collection<? extends DataReader>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UIPackage.PRESENTATION_CONTROLLER__CONFIGURATION:
				setConfiguration((PresentationConfiguration)null);
				return;
			case UIPackage.PRESENTATION_CONTROLLER__VIEW:
				setView((PresentationView)null);
				return;
			case UIPackage.PRESENTATION_CONTROLLER__PROPERTY_PANE:
				getPropertyPane().clear();
				return;
			case UIPackage.PRESENTATION_CONTROLLER__DATA_READER:
				getDataReader().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UIPackage.PRESENTATION_CONTROLLER__CONFIGURATION:
				return configuration != null;
			case UIPackage.PRESENTATION_CONTROLLER__VIEW:
				return view != null;
			case UIPackage.PRESENTATION_CONTROLLER__PROPERTY_PANE:
				return propertyPane != null && !propertyPane.isEmpty();
			case UIPackage.PRESENTATION_CONTROLLER__DATA_READER:
				return dataReader != null && !dataReader.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PresentationControllerImpl
