/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The ComplexDataType entity is defining complex structures similar to structures in C language.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.ComplexDataType#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getComplexDataType()
 * @model
 * @generated
 */
public interface ComplexDataType extends Type {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.StaticStructure.InnerElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property defines members of structure defined by ComplexDataType.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getComplexDataType_Elements()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<InnerElement> getElements();

} // ComplexDataType
