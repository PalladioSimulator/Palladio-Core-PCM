/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Forked Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ForkedBehaviour can be considered as a program thread. All parameter characterisations from the surrounding RDSEFF are also valid inside the ForkedBehaviours and can be used to parameterise resource demands or control flow constructs. The parameter characterisations are the same in each ForkedBehaviour.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getForkedBehaviour()
 * @model
 * @generated
 */
public interface ForkedBehaviour extends ResourceDemandingBehaviour {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";

} // ForkedBehaviour
