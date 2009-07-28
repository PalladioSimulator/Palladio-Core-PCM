/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.sourcecodedecorator;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Code Decorator Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.SourceCodeDecoratorRepository#getFilelevelsourcecodelink <em>Filelevelsourcecodelink</em>}</li>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.SourceCodeDecoratorRepository#getMethodlevelsourcecodelink <em>Methodlevelsourcecodelink</em>}</li>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.SourceCodeDecoratorRepository#getControlflowlevelsourcecodelink <em>Controlflowlevelsourcecodelink</em>}</li>
 * </ul>
 * </p>
 *
 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getSourceCodeDecoratorRepository()
 * @model
 * @generated
 */
public interface SourceCodeDecoratorRepository extends Identifier {
	/**
	 * Returns the value of the '<em><b>Filelevelsourcecodelink</b></em>' containment reference list.
	 * The list contents are of type {@link SourceCodeDecorator.sourcecodedecorator.FileLevelSourceCodeLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filelevelsourcecodelink</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filelevelsourcecodelink</em>' containment reference list.
	 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getSourceCodeDecoratorRepository_Filelevelsourcecodelink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FileLevelSourceCodeLink> getFilelevelsourcecodelink();

	/**
	 * Returns the value of the '<em><b>Methodlevelsourcecodelink</b></em>' containment reference list.
	 * The list contents are of type {@link SourceCodeDecorator.sourcecodedecorator.MethodLevelSourceCodeLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methodlevelsourcecodelink</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methodlevelsourcecodelink</em>' containment reference list.
	 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getSourceCodeDecoratorRepository_Methodlevelsourcecodelink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MethodLevelSourceCodeLink> getMethodlevelsourcecodelink();

	/**
	 * Returns the value of the '<em><b>Controlflowlevelsourcecodelink</b></em>' containment reference list.
	 * The list contents are of type {@link SourceCodeDecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controlflowlevelsourcecodelink</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controlflowlevelsourcecodelink</em>' containment reference list.
	 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getSourceCodeDecoratorRepository_Controlflowlevelsourcecodelink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ControlFlowLevelSourceCodeLink> getControlflowlevelsourcecodelink();

} // SourceCodeDecoratorRepository
