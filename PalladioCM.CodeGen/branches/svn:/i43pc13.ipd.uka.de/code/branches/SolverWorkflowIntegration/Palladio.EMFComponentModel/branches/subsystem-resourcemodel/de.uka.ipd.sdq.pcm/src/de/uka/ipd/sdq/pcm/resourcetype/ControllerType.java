/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype;

import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Controller Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The ControllerType specifies different types of controllers. A Controller type provides ResourceInterfaces which are used for controller access.
 * It also requires ResourceInterfaces which are used for accessing another controller or a processing resource.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage#getControllerType()
 * @model
 * @generated
 */
public interface ControllerType extends ResourceInterfaceRequiringEntity, ResourceInterfaceProvidingEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

} // ControllerType
