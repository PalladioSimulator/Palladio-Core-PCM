/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Controller</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.Controller#getController_ProcessingResourceSpecification <em>Controller Processing Resource Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getController()
 * @model
 * @generated
 */
public interface Controller extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Controller Processing Resource Specification</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getProcessingResourceSpecification_Controller <em>Processing Resource Specification Controller</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controller Processing Resource Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controller Processing Resource Specification</em>' reference.
	 * @see #setController_ProcessingResourceSpecification(ProcessingResourceSpecification)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getController_Controller_ProcessingResourceSpecification()
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getProcessingResourceSpecification_Controller
	 * @model opposite="processingResourceSpecification_Controller" required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceSpecification getController_ProcessingResourceSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.Controller#getController_ProcessingResourceSpecification <em>Controller Processing Resource Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controller Processing Resource Specification</em>' reference.
	 * @see #getController_ProcessingResourceSpecification()
	 * @generated
	 */
	void setController_ProcessingResourceSpecification(ProcessingResourceSpecification value);

} // Controller
