/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.MethodLevelSourceCodeLink;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SEFF Method Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink#getMethodlevelsourcecodelink <em>Methodlevelsourcecodelink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink#getServiceeffectspecification <em>Serviceeffectspecification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getSEFFMethodLink()
 * @model
 * @generated
 */
public interface SEFFMethodLink extends Identifier {
	/**
	 * Returns the value of the '<em><b>Methodlevelsourcecodelink</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methodlevelsourcecodelink</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methodlevelsourcecodelink</em>' reference.
	 * @see #setMethodlevelsourcecodelink(MethodLevelSourceCodeLink)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getSEFFMethodLink_Methodlevelsourcecodelink()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MethodLevelSourceCodeLink getMethodlevelsourcecodelink();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink#getMethodlevelsourcecodelink <em>Methodlevelsourcecodelink</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Methodlevelsourcecodelink</em>' reference.
	 * @see #getMethodlevelsourcecodelink()
	 * @generated
	 */
	void setMethodlevelsourcecodelink(MethodLevelSourceCodeLink value);

	/**
	 * Returns the value of the '<em><b>Serviceeffectspecification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serviceeffectspecification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serviceeffectspecification</em>' reference.
	 * @see #setServiceeffectspecification(ServiceEffectSpecification)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getSEFFMethodLink_Serviceeffectspecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ServiceEffectSpecification getServiceeffectspecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink#getServiceeffectspecification <em>Serviceeffectspecification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serviceeffectspecification</em>' reference.
	 * @see #getServiceeffectspecification()
	 * @generated
	 */
	void setServiceeffectspecification(ServiceEffectSpecification value);

} // SEFFMethodLink
