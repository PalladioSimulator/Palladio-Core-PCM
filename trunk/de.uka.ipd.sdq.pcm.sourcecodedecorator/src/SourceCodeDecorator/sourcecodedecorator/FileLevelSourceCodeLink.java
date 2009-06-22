/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.sourcecodedecorator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Level Source Code Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Human readable information for the source code link
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.FileLevelSourceCodeLink#getSourcefiles <em>Sourcefiles</em>}</li>
 * </ul>
 * </p>
 *
 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getFileLevelSourceCodeLink()
 * @model
 * @generated
 */
public interface FileLevelSourceCodeLink extends SourceCodeID {
	/**
	 * Returns the value of the '<em><b>Sourcefiles</b></em>' reference list.
	 * The list contents are of type {@link SourceCodeDecorator.sourcecodedecorator.SourceFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sourcefiles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sourcefiles</em>' reference list.
	 * @see SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage#getFileLevelSourceCodeLink_Sourcefiles()
	 * @model ordered="false"
	 * @generated
	 */
	EList<SourceFile> getSourcefiles();

} // FileLevelSourceCodeLink
