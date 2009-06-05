
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Parameter Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.CompositeParameterUsage#getInnerParameters_ParameterUsage <em>Inner Parameters Parameter Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getCompositeParameterUsage()
 * @model
 * @generated
 */
public interface CompositeParameterUsage extends ParameterUsage {
	/**
	 * Returns the value of the '<em><b>Inner Parameters Parameter Usage</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.ParameterUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Parameters Parameter Usage</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Parameters Parameter Usage</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getCompositeParameterUsage_InnerParameters_ParameterUsage()
	 * @model type="de.uka.ipd.sdq.pcm.parameter.ParameterUsage" containment="true" ordered="false"
	 * @generated
	 */
	EList getInnerParameters_ParameterUsage();

} // CompositeParameterUsage