/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Degree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.EnumerationDegreeImpl#getDomainOfEntities <em>Domain Of Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EnumerationDegreeImpl extends DegreeOfFreedomImpl implements EnumerationDegree {
	/**
	 * The cached value of the '{@link #getDomainOfEntities() <em>Domain Of Entities</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainOfEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<Entity> domainOfEntities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationDegreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.ENUMERATION_DEGREE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Entity> getDomainOfEntities() {
		if (domainOfEntities == null) {
			domainOfEntities = new EObjectResolvingEList<Entity>(Entity.class, this, designdecisionPackage.ENUMERATION_DEGREE__DOMAIN_OF_ENTITIES);
		}
		return domainOfEntities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.ENUMERATION_DEGREE__DOMAIN_OF_ENTITIES:
				return getDomainOfEntities();
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
			case designdecisionPackage.ENUMERATION_DEGREE__DOMAIN_OF_ENTITIES:
				getDomainOfEntities().clear();
				getDomainOfEntities().addAll((Collection<? extends Entity>)newValue);
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
			case designdecisionPackage.ENUMERATION_DEGREE__DOMAIN_OF_ENTITIES:
				getDomainOfEntities().clear();
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
			case designdecisionPackage.ENUMERATION_DEGREE__DOMAIN_OF_ENTITIES:
				return domainOfEntities != null && !domainOfEntities.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EnumerationDegreeImpl
