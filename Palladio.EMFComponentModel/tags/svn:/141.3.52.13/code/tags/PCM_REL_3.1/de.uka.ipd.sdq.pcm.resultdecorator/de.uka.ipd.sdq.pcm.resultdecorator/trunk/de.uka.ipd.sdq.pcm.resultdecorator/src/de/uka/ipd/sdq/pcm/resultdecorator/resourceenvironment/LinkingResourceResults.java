/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment;

import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Linking Resource Results</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.LinkingResourceResults#getLinkingresource <em>Linkingresource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.resourceenvironmentdecoratorPackage#getLinkingResourceResults()
 * @model
 * @generated
 */
public interface LinkingResourceResults extends UtilisationResult {
	/**
	 * Returns the value of the '<em><b>Linkingresource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linkingresource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linkingresource</em>' reference.
	 * @see #setLinkingresource(LinkingResource)
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.resourceenvironmentdecoratorPackage#getLinkingResourceResults_Linkingresource()
	 * @model ordered="false"
	 * @generated
	 */
	LinkingResource getLinkingresource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.LinkingResourceResults#getLinkingresource <em>Linkingresource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linkingresource</em>' reference.
	 * @see #getLinkingresource()
	 * @generated
	 */
	void setLinkingresource(LinkingResource value);

} // LinkingResourceResults
