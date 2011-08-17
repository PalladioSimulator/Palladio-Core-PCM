/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Percentile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Percentile#getPercentile <em>Percentile</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getPercentile()
 * @model
 * @generated
 */
public interface Percentile extends PointEstimator {
	/**
	 * Returns the value of the '<em><b>Percentile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percentile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percentile</em>' attribute.
	 * @see #setPercentile(double)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getPercentile_Percentile()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getPercentile();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Percentile#getPercentile <em>Percentile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percentile</em>' attribute.
	 * @see #getPercentile()
	 * @generated
	 */
	void setPercentile(double value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.percentile.oclAsType(Real) > 0.0 and self.percentile.oclAsType(Real) < 100.0
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.percentile.oclAsType(Real) > 0.0 and self.percentile.oclAsType(Real) < 100.0'"
	 * @generated
	 */
	boolean PERCENTILE_between_0_and_100(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Percentile
