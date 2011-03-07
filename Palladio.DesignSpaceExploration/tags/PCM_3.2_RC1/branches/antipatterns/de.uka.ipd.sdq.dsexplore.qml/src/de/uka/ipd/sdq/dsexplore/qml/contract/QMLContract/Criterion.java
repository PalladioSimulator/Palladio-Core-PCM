/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract;

import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;

import de.uka.ipd.sdq.identifier.Identifier;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Criterion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion#getDimension <em>Dimension</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion#getAspects <em>Aspects</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getCriterion()
 * @model abstract="true"
 * @generated
 */
public interface Criterion extends Identifier {
	/**
	 * Returns the value of the '<em><b>Dimension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimension</em>' reference.
	 * @see #setDimension(Dimension)
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getCriterion_Dimension()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Dimension getDimension();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion#getDimension <em>Dimension</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dimension</em>' reference.
	 * @see #getDimension()
	 * @generated
	 */
	void setDimension(Dimension value);

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage#getCriterion_Aspects()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<EvaluationAspect> getAspects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.aspects->exists(a|a.aspectRequirement <> null and a.aspectRequirement.oclIsTypeOf(QMLContract::Restriction)) implies (
	 * 	self.oclIsTypeOf(QMLContract::Constraint)
	 * )
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.aspects->exists(a|a.aspectRequirement <> null and a.aspectRequirement.oclIsTypeOf(QMLContract::Restriction)) implies (\r\n\tself.oclIsTypeOf(QMLContract::Constraint)\r\n)'"
	 * @generated
	 */
	boolean Only_CONSTRAINTS_have_RESTRICTIONS(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.aspects->forAll(aspect|
	 * 	aspect.oclIsTypeOf(QMLContract::Frequency) implies (
	 * 		self.dimension.type.oclIsTypeOf(QMLContractType::DimensionTypeNumeric) or
	 * 		(self.dimension.type.oclIsTypeOf(QMLContractType::DimensionTypeEnum) and self.dimension.type.oclAsType(QMLContractType::DimensionTypeEnum).order->size()>0 ) or 
	 * 		(self.dimension.type.oclIsTypeOf(QMLContractType::DimensionTypeSet) and self.dimension.type.oclAsType(QMLContractType::DimensionTypeSet).order->size()>0 )
	 * 	)
	 * )
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.aspects->forAll(aspect|\r\n\taspect.oclIsTypeOf(QMLContract::Frequency) implies (\r\n\t\tself.dimension.type.oclIsTypeOf(QMLContractType::DimensionTypeNumeric) or\r\n\t\t(self.dimension.type.oclIsTypeOf(QMLContractType::DimensionTypeEnum) and self.dimension.type.oclAsType(QMLContractType::DimensionTypeEnum).order->size()>0 ) or \r\n\t\t(self.dimension.type.oclIsTypeOf(QMLContractType::DimensionTypeSet) and self.dimension.type.oclAsType(QMLContractType::DimensionTypeSet).order->size()>0 )\r\n\t)\r\n)'"
	 * @generated
	 */
	boolean FREQUENCY_only_possible_if_DIMENSION_is_ordered(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.aspects->forAll(aspect|
	 * 	aspect.oclIsTypeOf(QMLContract::PointEstimator) implies (
	 * 		self.dimension.type.oclIsTypeOf(QMLContractType::DimensionTypeNumeric)
	 * 	)
	 * )
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.aspects->forAll(aspect|\r\n\taspect.oclIsTypeOf(QMLContract::PointEstimator) implies (\r\n\t\tself.dimension.type.oclIsTypeOf(QMLContractType::DimensionTypeNumeric)\r\n\t)\r\n)'"
	 * @generated
	 */
	boolean POINTESTIMATOR_only_for_numeric_dimensions(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.aspects->exists(a|a.aspectRequirement <> null and a.aspectRequirement.oclIsTypeOf(QMLContract::Goal)) implies (
	 * 	self.oclIsTypeOf(QMLContract::Objective)
	 * )
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.aspects->exists(a|a.aspectRequirement <> null and a.aspectRequirement.oclIsTypeOf(QMLContract::Goal)) implies (\r\n\tself.oclIsTypeOf(QMLContract::Objective)\r\n)'"
	 * @generated
	 */
	boolean Only_OBJECTIVES_have_GOALS(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Criterion
