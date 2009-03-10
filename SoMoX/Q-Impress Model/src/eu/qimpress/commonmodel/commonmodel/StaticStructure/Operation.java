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
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The class Operation is describing the signatures of the methods and could be mapped to the WSDL Operation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation#getInput <em>Input</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation#getOutput <em>Output</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation#getThrowsExceptions <em>Throws Exceptions</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getOperation()
 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML variationPoint='null'"
 * @generated
 */
public interface Operation extends NamedEntity {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property defines input parameters of an operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input</em>' containment reference.
	 * @see #setInput(Message)
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getOperation_Input()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Message getInput();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation#getInput <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' containment reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(Message value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property specifies return or output values of an operation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output</em>' containment reference.
	 * @see #setOutput(Message)
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getOperation_Output()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Message getOutput();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Operation#getOutput <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' containment reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Message value);

	/**
	 * Returns the value of the '<em><b>Throws Exceptions</b></em>' containment reference list.
	 * The list contents are of type {@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property defines the association to possible exeptions related to an operation call.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Throws Exceptions</em>' containment reference list.
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getOperation_ThrowsExceptions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception> getThrowsExceptions();

} // Operation
