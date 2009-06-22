/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.impl;

import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage;

import de.uka.ipd.sdq.pcm.resultdecorator.repository.InterfaceProvidingRequiringEntityResults;

import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.UtilisationResult;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result Decorator Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl#getInterfaceprovidingrequiringentityresults <em>Interfaceprovidingrequiringentityresults</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultDecoratorRepositoryImpl#getUtilisationresult <em>Utilisationresult</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResultDecoratorRepositoryImpl extends EObjectImpl implements ResultDecoratorRepository {
	/**
	 * The cached value of the '{@link #getInterfaceprovidingrequiringentityresults() <em>Interfaceprovidingrequiringentityresults</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceprovidingrequiringentityresults()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceProvidingRequiringEntityResults> interfaceprovidingrequiringentityresults;

	/**
	 * The cached value of the '{@link #getUtilisationresult() <em>Utilisationresult</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUtilisationresult()
	 * @generated
	 * @ordered
	 */
	protected EList<UtilisationResult> utilisationresult;

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
	public EList<InterfaceProvidingRequiringEntityResults> getInterfaceprovidingrequiringentityresults() {
		if (interfaceprovidingrequiringentityresults == null) {
			interfaceprovidingrequiringentityresults = new EObjectContainmentEList<InterfaceProvidingRequiringEntityResults>(InterfaceProvidingRequiringEntityResults.class, this, ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__INTERFACEPROVIDINGREQUIRINGENTITYRESULTS);
		}
		return interfaceprovidingrequiringentityresults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UtilisationResult> getUtilisationresult() {
		if (utilisationresult == null) {
			utilisationresult = new EObjectContainmentEList<UtilisationResult>(UtilisationResult.class, this, ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATIONRESULT);
		}
		return utilisationresult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__INTERFACEPROVIDINGREQUIRINGENTITYRESULTS:
				return ((InternalEList<?>)getInterfaceprovidingrequiringentityresults()).basicRemove(otherEnd, msgs);
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATIONRESULT:
				return ((InternalEList<?>)getUtilisationresult()).basicRemove(otherEnd, msgs);
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
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__INTERFACEPROVIDINGREQUIRINGENTITYRESULTS:
				return getInterfaceprovidingrequiringentityresults();
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATIONRESULT:
				return getUtilisationresult();
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
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__INTERFACEPROVIDINGREQUIRINGENTITYRESULTS:
				getInterfaceprovidingrequiringentityresults().clear();
				getInterfaceprovidingrequiringentityresults().addAll((Collection<? extends InterfaceProvidingRequiringEntityResults>)newValue);
				return;
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATIONRESULT:
				getUtilisationresult().clear();
				getUtilisationresult().addAll((Collection<? extends UtilisationResult>)newValue);
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
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__INTERFACEPROVIDINGREQUIRINGENTITYRESULTS:
				getInterfaceprovidingrequiringentityresults().clear();
				return;
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATIONRESULT:
				getUtilisationresult().clear();
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
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__INTERFACEPROVIDINGREQUIRINGENTITYRESULTS:
				return interfaceprovidingrequiringentityresults != null && !interfaceprovidingrequiringentityresults.isEmpty();
			case ResultdecoratorPackage.RESULT_DECORATOR_REPOSITORY__UTILISATIONRESULT:
				return utilisationresult != null && !utilisationresult.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResultDecoratorRepositoryImpl
