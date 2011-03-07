/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype;

import de.uka.ipd.sdq.pcm.repository.AbstractService;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This entity represents a single service of a ResourceInterface.
 * In contrast to signatures of interfaces, a ResourceService does not provide different parameters, but just one implicit demand parameter. It also does not support return types or modifiers.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceService#getResourceInterface_ResourceService <em>Resource Interface Resource Service</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceService()
 * @model
 * @generated
 */
public interface ResourceService extends AbstractService {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Resource Interface Resource Service</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getResourceServices_ResourceInterface <em>Resource Services Resource Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Interface Resource Service</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Interface Resource Service</em>' container reference.
	 * @see #setResourceInterface_ResourceService(ResourceInterface)
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getResourceService_ResourceInterface_ResourceService()
	 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface#getResourceServices_ResourceInterface
	 * @model opposite="resourceServices_ResourceInterface" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ResourceInterface getResourceInterface_ResourceService();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resourcetype.ResourceService#getResourceInterface_ResourceService <em>Resource Interface Resource Service</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Interface Resource Service</em>' container reference.
	 * @see #getResourceInterface_ResourceService()
	 * @generated
	 */
	void setResourceInterface_ResourceService(ResourceInterface value);

} // ResourceService
