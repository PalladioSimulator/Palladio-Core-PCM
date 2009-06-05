/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.connectors;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO: We might want to add a constraint that both sides of the connector must be not null. Then, we don't have to specify that for example for ComposedProvidingRequiringEntities that the ProvidedDelegationConnector actually points to something inner. If you decide not to add a constraint here, then we need a constraint there and maybe at other places -- Anne
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage#getConnector()
 * @model abstract="true"
 * @generated
 */
public interface Connector extends Entity {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

} // Connector
