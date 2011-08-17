/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.FileLevelSourceCodeLink;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component File Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink#getFilelevelsourcecodelink <em>Filelevelsourcecodelink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink#getRepositorycomponent <em>Repositorycomponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getComponentFileLink()
 * @model
 * @generated
 */
public interface ComponentFileLink extends Identifier {
	/**
	 * Returns the value of the '<em><b>Filelevelsourcecodelink</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filelevelsourcecodelink</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filelevelsourcecodelink</em>' reference.
	 * @see #setFilelevelsourcecodelink(FileLevelSourceCodeLink)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getComponentFileLink_Filelevelsourcecodelink()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FileLevelSourceCodeLink getFilelevelsourcecodelink();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink#getFilelevelsourcecodelink <em>Filelevelsourcecodelink</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filelevelsourcecodelink</em>' reference.
	 * @see #getFilelevelsourcecodelink()
	 * @generated
	 */
	void setFilelevelsourcecodelink(FileLevelSourceCodeLink value);

	/**
	 * Returns the value of the '<em><b>Repositorycomponent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repositorycomponent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repositorycomponent</em>' reference.
	 * @see #setRepositorycomponent(RepositoryComponent)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getComponentFileLink_Repositorycomponent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RepositoryComponent getRepositorycomponent();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink#getRepositorycomponent <em>Repositorycomponent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repositorycomponent</em>' reference.
	 * @see #getRepositorycomponent()
	 * @generated
	 */
	void setRepositorycomponent(RepositoryComponent value);

} // ComponentFileLink
