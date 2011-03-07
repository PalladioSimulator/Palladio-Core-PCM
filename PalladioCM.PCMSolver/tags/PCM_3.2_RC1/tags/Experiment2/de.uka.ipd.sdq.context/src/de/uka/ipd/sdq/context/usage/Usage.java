/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.usage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.usage.Usage#getUsageContexts_Usage <em>Usage Contexts Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.usage.UsagePackage#getUsage()
 * @model
 * @generated
 */
public interface Usage extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Returns the value of the '<em><b>Usage Contexts Usage</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.usage.UsageContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Contexts Usage</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Contexts Usage</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.usage.UsagePackage#getUsage_UsageContexts_Usage()
	 * @model type="de.uka.ipd.sdq.context.usage.UsageContext" containment="true" ordered="false"
	 * @generated
	 */
	EList getUsageContexts_Usage();

} // Usage
