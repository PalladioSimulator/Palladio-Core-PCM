/**
 */
package org.palladiosimulator.pcm.resultdecorator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.palladiosimulator.pcm.core.entity.NamedElement;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Result Decorator Repository</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository#getComponentResults_ResultDecoratorRepository
 * <em>Component Results Result Decorator Repository</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository#getUtilisationResults_ResultDecoratorRepository
 * <em>Utilisation Results Result Decorator Repository</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.ResultDecoratorRepository#getServiceResult_ResultDecoratorRepository
 * <em>Service Result Result Decorator Repository</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.pcm.resultdecorator.ResultdecoratorPackage#getResultDecoratorRepository()
 * @model
 * @generated
 */
public interface ResultDecoratorRepository extends EObject, NamedElement {

    /**
     * Returns the value of the '<em><b>Component Results Result Decorator Repository</b></em>'
     * containment reference list. The list contents are of type
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Component Results Result Decorator Repository</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Component Results Result Decorator Repository</em>' containment
     *         reference list.
     * @see org.palladiosimulator.pcm.resultdecorator.ResultdecoratorPackage#getResultDecoratorRepository_ComponentResults_ResultDecoratorRepository()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<ComponentResult> getComponentResults_ResultDecoratorRepository();

    /**
     * Returns the value of the '<em><b>Utilisation Results Result Decorator Repository</b></em>'
     * containment reference list. The list contents are of type
     * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult}
     * . <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Utilisation Results Result Decorator Repository</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Utilisation Results Result Decorator Repository</em>'
     *         containment reference list.
     * @see org.palladiosimulator.pcm.resultdecorator.ResultdecoratorPackage#getResultDecoratorRepository_UtilisationResults_ResultDecoratorRepository()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<UtilisationResult> getUtilisationResults_ResultDecoratorRepository();

    /**
     * Returns the value of the '<em><b>Service Result Result Decorator Repository</b></em>'
     * containment reference list. The list contents are of type
     * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Result Result Decorator Repository</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     *
     * @return the value of the '<em>Service Result Result Decorator Repository</em>' containment
     *         reference list.
     * @see org.palladiosimulator.pcm.resultdecorator.ResultdecoratorPackage#getResultDecoratorRepository_ServiceResult_ResultDecoratorRepository()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<ServiceResult> getServiceResult_ResultDecoratorRepository();

} // ResultDecoratorRepository
