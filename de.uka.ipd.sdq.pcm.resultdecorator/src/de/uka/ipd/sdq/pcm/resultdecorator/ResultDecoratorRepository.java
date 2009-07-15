/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator;

import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult;

import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result Decorator Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository#getInterfaceprovidingrequiringentityresults <em>Interfaceprovidingrequiringentityresults</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository#getUtilisationresult <em>Utilisationresult</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage#getResultDecoratorRepository()
 * @model
 * @generated
 */
public interface ResultDecoratorRepository extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Interfaceprovidingrequiringentityresults</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interfaceprovidingrequiringentityresults</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interfaceprovidingrequiringentityresults</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage#getResultDecoratorRepository_Interfaceprovidingrequiringentityresults()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ComponentResult> getInterfaceprovidingrequiringentityresults();

	/**
	 * Returns the value of the '<em><b>Utilisationresult</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utilisationresult</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utilisationresult</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage#getResultDecoratorRepository_Utilisationresult()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<UtilisationResult> getUtilisationresult();

} // ResultDecoratorRepository
