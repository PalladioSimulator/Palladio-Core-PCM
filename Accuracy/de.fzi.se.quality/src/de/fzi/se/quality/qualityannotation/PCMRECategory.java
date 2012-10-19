/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCMRE Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.PCMRECategory#getCategory <em>Category</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMRECategory()
 * @model
 * @generated
 */
public interface PCMRECategory extends PCMRE {
	/**
	 * Returns the value of the '<em><b>Category</b></em>' attribute.
	 * The literals are from the enumeration {@link de.fzi.se.quality.qualityannotation.PCMRERequestCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category</em>' attribute.
	 * @see de.fzi.se.quality.qualityannotation.PCMRERequestCategory
	 * @see #setCategory(PCMRERequestCategory)
	 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMRECategory_Category()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PCMRERequestCategory getCategory();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.qualityannotation.PCMRECategory#getCategory <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category</em>' attribute.
	 * @see de.fzi.se.quality.qualityannotation.PCMRERequestCategory
	 * @see #getCategory()
	 * @generated
	 */
	void setCategory(PCMRERequestCategory value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.childREs->forAll(child | child.oclIsTypeOf(PCMREInterface))'"
	 * @generated
	 */
	boolean NextLowerHierarchyLevelIsInterface(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.parentRE.oclIsUndefined()'"
	 * @generated
	 */
	boolean ThisIsHighestHierarchyLevel(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.category = PCMRERequestCategory::ResourceDemand implies self.childREs->size() = 0'"
	 * @generated
	 */
	boolean NoSublevelsForCategoryResourceDemand(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='(self.precision->size() > 0 and category = PCMRERequestCategory::ResourceDemand) implies self.precision.defaultPrecisionCallParameter.oclIsTypeOf(NoPrecision)\r\n'"
	 * @generated
	 */
	boolean ExistingREPrecisionCallParameterMustBeNoPrecisionDueToTheNonExistenceOfParametersForCategoryResourceDemand(DiagnosticChain diagnostics, Map<Object, Object> context);

} // PCMRECategory
