/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nominal Measure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Measure which allows to store predefined state(s).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasure#getDefinedCategoryIdentifiers <em>Defined Category Identifiers</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasure#getInitialState <em>Initial State</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getNominalMeasure()
 * @model
 * @generated
 */
public interface NominalMeasure extends Measure, Identifiable {
	/**
	 * Returns the value of the '<em><b>Defined Category Identifiers</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.edp2.models.emfmodel.CategoryIdentifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined Category Identifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defined Category Identifiers</em>' containment reference list.
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getNominalMeasure_DefinedCategoryIdentifiers()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<CategoryIdentifier> getDefinedCategoryIdentifiers();

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(CategoryIdentifier)
	 * @see de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage#getNominalMeasure_InitialState()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CategoryIdentifier getInitialState();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.emfmodel.NominalMeasure#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(CategoryIdentifier value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.persistencyKind = PersistenceKindOptions::Emf
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean PersistenceKindOnlyEmfAllowed(DiagnosticChain diagnostics, Map context);

} // NominalMeasure
