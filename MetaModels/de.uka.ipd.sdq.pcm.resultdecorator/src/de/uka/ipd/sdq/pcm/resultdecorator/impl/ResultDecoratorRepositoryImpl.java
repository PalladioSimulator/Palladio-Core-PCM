/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.impl.NamedElementImpl;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ServiceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Decorator Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl#getComponentResults_ResultDecoratorRepository <em>Component Results Result Decorator Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl#getUtilisationResults_ResultDecoratorRepository <em>Utilisation Results Result Decorator Repository</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl#getServiceResult_ResultDecoratorRepository <em>Service Result Result Decorator Repository</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultDecoratorRepositoryImpl extends NamedElementImpl implements ResultDecoratorRepository {
	/**
	 * The cached value of the '{@link #getComponentResults_ResultDecoratorRepository() <em>Component Results Result Decorator Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentResults_ResultDecoratorRepository()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentResult> componentResults_ResultDecoratorRepository;

	/**
	 * The cached value of the '{@link #getUtilisationResults_ResultDecoratorRepository() <em>Utilisation Results Result Decorator Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilisationResults_ResultDecoratorRepository()
	 * @generated
	 * @ordered
	 */
	protected EList<UtilisationResult> utilisationResults_ResultDecoratorRepository;

	/**
	 * The cached value of the '{@link #getServiceResult_ResultDecoratorRepository() <em>Service Result Result Decorator Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceResult_ResultDecoratorRepository()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceResult> serviceResult_ResultDecoratorRepository;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResultDecoratorRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultdecoratorPackage.Literals.RESULT_DECORATOR_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentResult> getComponentResults_ResultDecoratorRepository() {
		if (componentResults_ResultDecoratorRepository == null) {
			componentResults_ResultDecoratorRepository = new EObjectContainmentEList<ComponentResult>(ComponentResult.class, this, ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY);
		}
		return componentResults_ResultDecoratorRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UtilisationResult> getUtilisationResults_ResultDecoratorRepository() {
		if (utilisationResults_ResultDecoratorRepository == null) {
			utilisationResults_ResultDecoratorRepository = new EObjectContainmentEList<UtilisationResult>(UtilisationResult.class, this, ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY);
		}
		return utilisationResults_ResultDecoratorRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceResult> getServiceResult_ResultDecoratorRepository() {
		if (serviceResult_ResultDecoratorRepository == null) {
			serviceResult_ResultDecoratorRepository = new EObjectContainmentEList<ServiceResult>(ServiceResult.class, this, ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY);
		}
		return serviceResult_ResultDecoratorRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY:
				return ((InternalEList<?>)getComponentResults_ResultDecoratorRepository()).basicRemove(otherEnd, msgs);
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY:
				return ((InternalEList<?>)getUtilisationResults_ResultDecoratorRepository()).basicRemove(otherEnd, msgs);
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY:
				return ((InternalEList<?>)getServiceResult_ResultDecoratorRepository()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY:
				return getComponentResults_ResultDecoratorRepository();
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY:
				return getUtilisationResults_ResultDecoratorRepository();
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY:
				return getServiceResult_ResultDecoratorRepository();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY:
				getComponentResults_ResultDecoratorRepository().clear();
				getComponentResults_ResultDecoratorRepository().addAll((Collection<? extends ComponentResult>)newValue);
				return;
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY:
				getUtilisationResults_ResultDecoratorRepository().clear();
				getUtilisationResults_ResultDecoratorRepository().addAll((Collection<? extends UtilisationResult>)newValue);
				return;
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY:
				getServiceResult_ResultDecoratorRepository().clear();
				getServiceResult_ResultDecoratorRepository().addAll((Collection<? extends ServiceResult>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY:
				getComponentResults_ResultDecoratorRepository().clear();
				return;
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY:
				getUtilisationResults_ResultDecoratorRepository().clear();
				return;
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY:
				getServiceResult_ResultDecoratorRepository().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__COMPONENT_RESULTS_RESULT_DECORATOR_REPOSITORY:
				return componentResults_ResultDecoratorRepository != null && !componentResults_ResultDecoratorRepository.isEmpty();
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATION_RESULTS_RESULT_DECORATOR_REPOSITORY:
				return utilisationResults_ResultDecoratorRepository != null && !utilisationResults_ResultDecoratorRepository.isEmpty();
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__SERVICE_RESULT_RESULT_DECORATOR_REPOSITORY:
				return serviceResult_ResultDecoratorRepository != null && !serviceResult_ResultDecoratorRepository.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResultDecoratorRepositoryImpl
