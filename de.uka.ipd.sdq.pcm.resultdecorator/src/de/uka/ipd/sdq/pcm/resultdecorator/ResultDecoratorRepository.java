/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.core.entity.NamedElement;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ServiceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Decorator Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository#getComponentResults_ResultDecoratorRepository <em>Component Results Result Decorator Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository#getUtilisationResults_ResultDecoratorRepository <em>Utilisation Results Result Decorator Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository#getServiceResult_ResultDecoratorRepository <em>Service Result Result Decorator Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage#getResultDecoratorRepository()
 * @model
 * @generated
 */
public interface ResultDecoratorRepository extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Component Results Result Decorator Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Results Result Decorator Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Results Result Decorator Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage#getResultDecoratorRepository_ComponentResults_ResultDecoratorRepository()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ComponentResult> getComponentResults_ResultDecoratorRepository();

	/**
	 * Returns the value of the '<em><b>Utilisation Results Result Decorator Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilisation Results Result Decorator Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilisation Results Result Decorator Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage#getResultDecoratorRepository_UtilisationResults_ResultDecoratorRepository()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<UtilisationResult> getUtilisationResults_ResultDecoratorRepository();

	/**
	 * Returns the value of the '<em><b>Service Result Result Decorator Repository</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ServiceResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Result Result Decorator Repository</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Result Result Decorator Repository</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage#getResultDecoratorRepository_ServiceResult_ResultDecoratorRepository()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ServiceResult> getServiceResult_ResultDecoratorRepository();

} // ResultDecoratorRepository
