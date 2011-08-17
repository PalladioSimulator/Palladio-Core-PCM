/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregation Recorder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pipesandfilters.AggregationRecorder#getWriter <em>Writer</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage#getAggregationRecorder()
 * @model abstract="true"
 * @generated
 */
public interface AggregationRecorder extends Recorder {
	/**
	 * Returns the value of the '<em><b>Writer</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pipesandfilters.Writer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Writer</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Writer</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage#getAggregationRecorder_Writer()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Writer> getWriter();

} // AggregationRecorder
