/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equivalent Components</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.EquivalentComponentsImpl#getRepositorycomponent <em>Repositorycomponent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EquivalentComponentsImpl extends EnumerationImpl implements EquivalentComponents {
	/**
	 * The cached value of the '{@link #getRepositorycomponent() <em>Repositorycomponent</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositorycomponent()
	 * @generated
	 * @ordered
	 */
	protected EList<RepositoryComponent> repositorycomponent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquivalentComponentsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.EQUIVALENT_COMPONENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RepositoryComponent> getRepositorycomponent() {
		if (repositorycomponent == null) {
			repositorycomponent = new EObjectResolvingEList<RepositoryComponent>(RepositoryComponent.class, this, designdecisionPackage.EQUIVALENT_COMPONENTS__REPOSITORYCOMPONENT);
		}
		return repositorycomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.EQUIVALENT_COMPONENTS__REPOSITORYCOMPONENT:
				return getRepositorycomponent();
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
			case designdecisionPackage.EQUIVALENT_COMPONENTS__REPOSITORYCOMPONENT:
				getRepositorycomponent().clear();
				getRepositorycomponent().addAll((Collection<? extends RepositoryComponent>)newValue);
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
			case designdecisionPackage.EQUIVALENT_COMPONENTS__REPOSITORYCOMPONENT:
				getRepositorycomponent().clear();
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
			case designdecisionPackage.EQUIVALENT_COMPONENTS__REPOSITORYCOMPONENT:
				return repositorycomponent != null && !repositorycomponent.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EquivalentComponentsImpl
