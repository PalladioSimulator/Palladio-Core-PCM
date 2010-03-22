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
 * <p>
 *     Abstract superclass for all connectors.
 * </p>
 * <p>
 *     TODO:&nbsp;We&nbsp;might&nbsp;want&nbsp;to&nbsp;add&nbsp;a&nbsp;constraint&nbsp;that&nbsp;both&nbsp;sides&nbsp;of&nbsp;the&nbsp;connector&nbsp;must&nbsp;be&nbsp;not&nbsp;null.&nbsp;Then,&nbsp;we&nbsp;don't&nbsp;have&nbsp;to&nbsp;specify&nbsp;that&nbsp;for&nbsp;example&nbsp;for&nbsp;ComposedProvidingRequiringEntities&nbsp;that&nbsp;the&nbsp;ProvidedDelegationConnector&nbsp;actually&nbsp;points&nbsp;to&nbsp;something&nbsp;inner.&nbsp;If&nbsp;you&nbsp;decide&nbsp;not&nbsp;to&nbsp;add&nbsp;a&nbsp;constraint&nbsp;here,&nbsp;then&nbsp;we&nbsp;need&nbsp;a&nbsp;constraint&nbsp;there&nbsp;and&nbsp;maybe&nbsp;at&nbsp;other&nbsp;places&nbsp;--&nbsp;Anne
 * </p>
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
