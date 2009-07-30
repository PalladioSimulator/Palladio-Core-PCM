/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JFree Chart Presentation View Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartPresentationViewFactory#getGenerates <em>Generates</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage#getJFreeChartPresentationViewFactory()
 * @model
 * @generated
 */
public interface JFreeChartPresentationViewFactory extends EObject {
	/**
	 * Returns the value of the '<em><b>Generates</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generates</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generates</em>' reference.
	 * @see #setGenerates(JFreeChartHistogramView)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.PresentationPackage#getJFreeChartPresentationViewFactory_Generates()
	 * @model ordered="false"
	 * @generated
	 */
	JFreeChartHistogramView getGenerates();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.JFreeChartPresentationViewFactory#getGenerates <em>Generates</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generates</em>' reference.
	 * @see #getGenerates()
	 * @generated
	 */
	void setGenerates(JFreeChartHistogramView value);

} // JFreeChartPresentationViewFactory
