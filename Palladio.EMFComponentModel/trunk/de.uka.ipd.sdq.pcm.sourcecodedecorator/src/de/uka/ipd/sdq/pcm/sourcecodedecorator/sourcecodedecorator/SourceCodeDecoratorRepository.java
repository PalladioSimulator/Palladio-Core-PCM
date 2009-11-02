/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Code Decorator Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository#getFilelevelsourcecodelink <em>Filelevelsourcecodelink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository#getMethodlevelsourcecodelink <em>Methodlevelsourcecodelink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository#getControlflowlevelsourcecodelink <em>Controlflowlevelsourcecodelink</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage#getSourceCodeDecoratorRepository()
 * @model
 * @generated
 */
public interface SourceCodeDecoratorRepository extends Identifier {
	/**
	 * Returns the value of the '<em><b>Filelevelsourcecodelink</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.FileLevelSourceCodeLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filelevelsourcecodelink</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filelevelsourcecodelink</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage#getSourceCodeDecoratorRepository_Filelevelsourcecodelink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FileLevelSourceCodeLink> getFilelevelsourcecodelink();

	/**
	 * Returns the value of the '<em><b>Methodlevelsourcecodelink</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.MethodLevelSourceCodeLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methodlevelsourcecodelink</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methodlevelsourcecodelink</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage#getSourceCodeDecoratorRepository_Methodlevelsourcecodelink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MethodLevelSourceCodeLink> getMethodlevelsourcecodelink();

	/**
	 * Returns the value of the '<em><b>Controlflowlevelsourcecodelink</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controlflowlevelsourcecodelink</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controlflowlevelsourcecodelink</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage#getSourceCodeDecoratorRepository_Controlflowlevelsourcecodelink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ControlFlowLevelSourceCodeLink> getControlflowlevelsourcecodelink();

} // SourceCodeDecoratorRepository
