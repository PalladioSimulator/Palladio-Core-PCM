/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * UML-like&nbsp;container&nbsp;of&nbsp;a&nbsp;number&nbsp;of&nbsp;processing&nbsp;resources (e.g. hardware server)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getOperatingSystem_ResourceContainer <em>Operating System Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getActiveResourceSpecifications_ResourceContainer <em>Active Resource Specifications Resource Container</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getResourceEnvironment_ResourceContainer <em>Resource Environment Resource Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer()
 * @model
 * @generated
 */
public interface ResourceContainer extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Operating System Resource Container</b></em>' attribute.
	 * The default value is <code>"ABSTRACT"</code>.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.resourceenvironment.ContainerOperatingSystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operating System Resource Container</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operating System Resource Container</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ContainerOperatingSystem
	 * @see #setOperatingSystem_ResourceContainer(ContainerOperatingSystem)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer_OperatingSystem_ResourceContainer()
	 * @model default="ABSTRACT" required="true" ordered="false"
	 * @generated
	 */
	ContainerOperatingSystem getOperatingSystem_ResourceContainer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getOperatingSystem_ResourceContainer <em>Operating System Resource Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operating System Resource Container</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ContainerOperatingSystem
	 * @see #getOperatingSystem_ResourceContainer()
	 * @generated
	 */
	void setOperatingSystem_ResourceContainer(ContainerOperatingSystem value);

	/**
	 * Returns the value of the '<em><b>Active Resource Specifications Resource Container</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getResourceContainer_ProcessingResourceSpecification <em>Resource Container Processing Resource Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Resource Specifications Resource Container</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Resource Specifications Resource Container</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer_ActiveResourceSpecifications_ResourceContainer()
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification#getResourceContainer_ProcessingResourceSpecification
	 * @model opposite="resourceContainer_ProcessingResourceSpecification" containment="true" ordered="false"
	 * @generated
	 */
	EList<ProcessingResourceSpecification> getActiveResourceSpecifications_ResourceContainer();

	/**
	 * Returns the value of the '<em><b>Resource Environment Resource Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment#getResourceContainer_ResourceEnvironment <em>Resource Container Resource Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Environment Resource Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Environment Resource Container</em>' container reference.
	 * @see #setResourceEnvironment_ResourceContainer(ResourceEnvironment)
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getResourceContainer_ResourceEnvironment_ResourceContainer()
	 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment#getResourceContainer_ResourceEnvironment
	 * @model opposite="resourceContainer_ResourceEnvironment" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ResourceEnvironment getResourceEnvironment_ResourceContainer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer#getResourceEnvironment_ResourceContainer <em>Resource Environment Resource Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Environment Resource Container</em>' container reference.
	 * @see #getResourceEnvironment_ResourceContainer()
	 * @generated
	 */
	void setResourceEnvironment_ResourceContainer(ResourceEnvironment value);

} // ResourceContainer
