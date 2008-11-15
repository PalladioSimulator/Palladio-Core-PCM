/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Effect Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification#getSeffTypeID <em>Seff Type ID</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification#getDescribedService__SEFF <em>Described Service SEFF</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getServiceEffectSpecification()
 * @model abstract="true"
 * @generated
 */
public interface ServiceEffectSpecification extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Seff Type ID</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seff Type ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seff Type ID</em>' attribute.
	 * @see #setSeffTypeID(String)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getServiceEffectSpecification_SeffTypeID()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	String getSeffTypeID();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification#getSeffTypeID <em>Seff Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Seff Type ID</em>' attribute.
	 * @see #getSeffTypeID()
	 * @generated
	 */
	void setSeffTypeID(String value);

	/**
	 * Returns the value of the '<em><b>Described Service SEFF</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Described Service SEFF</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Described Service SEFF</em>' reference.
	 * @see #setDescribedService__SEFF(Signature)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getServiceEffectSpecification_DescribedService__SEFF()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Signature getDescribedService__SEFF();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification#getDescribedService__SEFF <em>Described Service SEFF</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Described Service SEFF</em>' reference.
	 * @see #getDescribedService__SEFF()
	 * @generated
	 */
	void setDescribedService__SEFF(Signature value);

} // ServiceEffectSpecification
