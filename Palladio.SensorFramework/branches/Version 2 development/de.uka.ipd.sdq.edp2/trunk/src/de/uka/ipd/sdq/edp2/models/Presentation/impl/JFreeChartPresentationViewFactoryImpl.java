/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation.impl;

import de.uka.ipd.sdq.edp2.models.Presentation.JFreeChartHistogramView;
import de.uka.ipd.sdq.edp2.models.Presentation.JFreeChartPresentationViewFactory;
import de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JFree Chart Presentation View Factory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.impl.JFreeChartPresentationViewFactoryImpl#getGenerates <em>Generates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JFreeChartPresentationViewFactoryImpl extends EObjectImpl implements JFreeChartPresentationViewFactory {
	/**
	 * The cached value of the '{@link #getGenerates() <em>Generates</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerates()
	 * @generated
	 * @ordered
	 */
	protected JFreeChartHistogramView generates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JFreeChartPresentationViewFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PresentationPackage.Literals.JFREE_CHART_PRESENTATION_VIEW_FACTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JFreeChartHistogramView getGenerates() {
		if (generates != null && generates.eIsProxy()) {
			InternalEObject oldGenerates = (InternalEObject)generates;
			generates = (JFreeChartHistogramView)eResolveProxy(oldGenerates);
			if (generates != oldGenerates) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PresentationPackage.JFREE_CHART_PRESENTATION_VIEW_FACTORY__GENERATES, oldGenerates, generates));
			}
		}
		return generates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JFreeChartHistogramView basicGetGenerates() {
		return generates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerates(JFreeChartHistogramView newGenerates) {
		JFreeChartHistogramView oldGenerates = generates;
		generates = newGenerates;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.JFREE_CHART_PRESENTATION_VIEW_FACTORY__GENERATES, oldGenerates, generates));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PresentationPackage.JFREE_CHART_PRESENTATION_VIEW_FACTORY__GENERATES:
				if (resolve) return getGenerates();
				return basicGetGenerates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PresentationPackage.JFREE_CHART_PRESENTATION_VIEW_FACTORY__GENERATES:
				setGenerates((JFreeChartHistogramView)newValue);
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
			case PresentationPackage.JFREE_CHART_PRESENTATION_VIEW_FACTORY__GENERATES:
				setGenerates((JFreeChartHistogramView)null);
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
			case PresentationPackage.JFREE_CHART_PRESENTATION_VIEW_FACTORY__GENERATES:
				return generates != null;
		}
		return super.eIsSet(featureID);
	}

} //JFreeChartPresentationViewFactoryImpl
