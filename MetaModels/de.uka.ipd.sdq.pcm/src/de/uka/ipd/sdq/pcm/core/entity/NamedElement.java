/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.entity;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The NamedElement meta class is inherited by all PCM classes whose instances bear a name. Thus, the semantic of "bearing a name" is given to all inheriting classes, so that the name can be used in visualisations, for example. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.entity.NamedElement#getEntityName <em>Entity Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Entity Name</b></em>' attribute.
     * The default value is <code>"aName"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entity Name</em>' attribute isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Entity Name</em>' attribute.
     * @see #setEntityName(String)
     * @see de.uka.ipd.sdq.pcm.core.entity.EntityPackage#getNamedElement_EntityName()
     * @model default="aName" required="true" ordered="false"
     * @generated
     */
    String getEntityName();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.entity.NamedElement#getEntityName <em>Entity Name</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @param value the new value of the '<em>Entity Name</em>' attribute.
     * @see #getEntityName()
     * @generated
     */
    void setEntityName(String value);

} // NamedElement
