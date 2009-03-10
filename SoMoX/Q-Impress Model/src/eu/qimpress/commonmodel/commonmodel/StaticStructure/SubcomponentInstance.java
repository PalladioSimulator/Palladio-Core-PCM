/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subcomponent Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The entity SubcomponentInstance is specifying the Subcomponents of the CompositeStructure.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance#getRealizedBy <em>Realized By</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getSubcomponentInstance()
 * @model
 * @generated
 */
public interface SubcomponentInstance extends Entity {
	/**
	 * Returns the value of the '<em><b>Realized By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property assigns component type to subcomponent.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Realized By</em>' reference.
	 * @see #setRealizedBy(ComponentType)
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getSubcomponentInstance_RealizedBy()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ComponentType getRealizedBy();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.SubcomponentInstance#getRealizedBy <em>Realized By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realized By</em>' reference.
	 * @see #getRealizedBy()
	 * @generated
	 */
	void setRealizedBy(ComponentType value);

} // SubcomponentInstance
