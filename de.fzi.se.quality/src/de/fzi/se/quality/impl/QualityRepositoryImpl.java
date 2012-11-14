/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.impl;

import de.fzi.se.quality.QualityPackage;
import de.fzi.se.quality.QualityRepository;
import de.fzi.se.quality.QualityStatement;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.impl.QualityRepositoryImpl#getQualityStatements <em>Quality Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualityRepositoryImpl extends IdentifierImpl implements QualityRepository {
	/**
	 * The cached value of the '{@link #getQualityStatements() <em>Quality Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<QualityStatement> qualityStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualityRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityPackage.Literals.QUALITY_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QualityStatement> getQualityStatements() {
		if (qualityStatements == null) {
			qualityStatements = new EObjectContainmentWithInverseEList<QualityStatement>(QualityStatement.class, this, QualityPackage.QUALITY_REPOSITORY__QUALITY_STATEMENTS, QualityPackage.QUALITY_STATEMENT__QUALITY_REPOSITORY);
		}
		return qualityStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QualityPackage.QUALITY_REPOSITORY__QUALITY_STATEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getQualityStatements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QualityPackage.QUALITY_REPOSITORY__QUALITY_STATEMENTS:
				return ((InternalEList<?>)getQualityStatements()).basicRemove(otherEnd, msgs);
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
			case QualityPackage.QUALITY_REPOSITORY__QUALITY_STATEMENTS:
				return getQualityStatements();
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
			case QualityPackage.QUALITY_REPOSITORY__QUALITY_STATEMENTS:
				getQualityStatements().clear();
				getQualityStatements().addAll((Collection<? extends QualityStatement>)newValue);
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
			case QualityPackage.QUALITY_REPOSITORY__QUALITY_STATEMENTS:
				getQualityStatements().clear();
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
			case QualityPackage.QUALITY_REPOSITORY__QUALITY_STATEMENTS:
				return qualityStatements != null && !qualityStatements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //QualityRepositoryImpl
