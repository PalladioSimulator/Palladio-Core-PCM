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
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The class Interafce provides the description of an Interface that is mapping the SOA terminology. Service Interface ist described by the Service Architecture Model. WSDL PortTypes could by mapped to the Interfaces.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface#getSignatures <em>Signatures</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getInterface()
 * @model
 * @generated
 */
public interface Interface extends NamedEntity, FirstClassEntity {
	/**
	 * Returns the value of the '<em><b>Signatures</b></em>' containment reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property associates operations with certain interface.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Signatures</em>' containment reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getInterface_Signatures()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Operation> getSignatures();

	/**
	 * Returns the value of the '<em><b>Inheritance</b></em>' reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Interface}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property allows extending the interface with new operations.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inheritance</em>' reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getInterface_Inheritance()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Interface> getInheritance();

} // Interface
