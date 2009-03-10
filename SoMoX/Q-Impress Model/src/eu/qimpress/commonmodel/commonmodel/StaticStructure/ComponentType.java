/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;

import eu.qimpress.commonmodel.commonmodel.Behavior.Behavior;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The abstract class ComponentType defines Components, that can be Black-Box or White-Box and Primitive or Composite.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType#getRequired <em>Required</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType#getProvided <em>Provided</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComponentType#getBehaviour <em>Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getComponentType()
 * @model abstract="true"
 * @generated
 */
public interface ComponentType extends NamedEntity, FirstClassEntity {
	/**
	 * Returns the value of the '<em><b>Required</b></em>' containment reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Port}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property associates required service ports of component.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Required</em>' containment reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getComponentType_Required()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Port> getRequired();

	/**
	 * Returns the value of the '<em><b>Provided</b></em>' containment reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Port}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property associates provided service ports of component.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Provided</em>' containment reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getComponentType_Provided()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Port> getProvided();

	/**
	 * Returns the value of the '<em><b>Behaviour</b></em>' reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.Behavior.Behavior}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property defines behavior model of component and information about internal control flow between actions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Behaviour</em>' reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getComponentType_Behaviour()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Behavior> getBehaviour();

} // ComponentType
