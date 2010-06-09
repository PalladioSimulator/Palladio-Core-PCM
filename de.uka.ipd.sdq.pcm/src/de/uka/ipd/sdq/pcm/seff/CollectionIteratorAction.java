/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.repository.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Iterator Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Collection Iterator Action Models the repeated execution of its inner ResourceDemandingBehaviour for each element of a collection data type. Therefore it contains a reference to an input parameter of the service’s signature, which must be of type CollectionDataType. The NUMBER OF ELEMENTS must be specified from the outside of the component, either by another RDSEFF or by an usage model calling this service. It can be of type integer or IntPMF. Besides the source of the number of iterations, CollectionIteratorActions differ from LoopAction only in their allowed stochastic dependence of random variables inside the loop body’s ResourceDemandingBehaviour. If the same random variable occurs twice in such a loop body, analysis tools must evaluate the second occurrence in stochastic dependence to the first occurrence. This complicates the involved calculation and might lead to the intractability of the model, therefore component developers should use CollectionIteratorActions with care and only include them if they expect that the prediction results would be vastly inaccurate without it.
 * <!-- end-model-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getCollectionIteratorAction()
 * @model
 * @generated
 */
public interface CollectionIteratorAction extends AbstractLoopAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

} // CollectionIteratorAction
