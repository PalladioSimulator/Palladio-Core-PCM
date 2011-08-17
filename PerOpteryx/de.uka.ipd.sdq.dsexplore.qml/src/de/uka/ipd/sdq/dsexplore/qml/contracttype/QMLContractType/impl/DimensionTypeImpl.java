/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl;

import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionType;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.RelationSemantics;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dimension Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeImpl#getRelationSemantics <em>Relation Semantics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DimensionTypeImpl extends IdentifierImpl implements DimensionType {
	/**
	 * The cached value of the '{@link #getRelationSemantics() <em>Relation Semantics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationSemantics()
	 * @generated
	 * @ordered
	 */
	protected RelationSemantics relationSemantics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DimensionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QMLContractTypePackage.Literals.DIMENSION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationSemantics getRelationSemantics() {
		return relationSemantics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelationSemantics(RelationSemantics newRelationSemantics, NotificationChain msgs) {
		RelationSemantics oldRelationSemantics = relationSemantics;
		relationSemantics = newRelationSemantics;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QMLContractTypePackage.DIMENSION_TYPE__RELATION_SEMANTICS, oldRelationSemantics, newRelationSemantics);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelationSemantics(RelationSemantics newRelationSemantics) {
		if (newRelationSemantics != relationSemantics) {
			NotificationChain msgs = null;
			if (relationSemantics != null)
				msgs = ((InternalEObject)relationSemantics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QMLContractTypePackage.DIMENSION_TYPE__RELATION_SEMANTICS, null, msgs);
			if (newRelationSemantics != null)
				msgs = ((InternalEObject)newRelationSemantics).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QMLContractTypePackage.DIMENSION_TYPE__RELATION_SEMANTICS, null, msgs);
			msgs = basicSetRelationSemantics(newRelationSemantics, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QMLContractTypePackage.DIMENSION_TYPE__RELATION_SEMANTICS, newRelationSemantics, newRelationSemantics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QMLContractTypePackage.DIMENSION_TYPE__RELATION_SEMANTICS:
				return basicSetRelationSemantics(null, msgs);
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
			case QMLContractTypePackage.DIMENSION_TYPE__RELATION_SEMANTICS:
				return getRelationSemantics();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QMLContractTypePackage.DIMENSION_TYPE__RELATION_SEMANTICS:
				setRelationSemantics((RelationSemantics)newValue);
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
			case QMLContractTypePackage.DIMENSION_TYPE__RELATION_SEMANTICS:
				setRelationSemantics((RelationSemantics)null);
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
			case QMLContractTypePackage.DIMENSION_TYPE__RELATION_SEMANTICS:
				return relationSemantics != null;
		}
		return super.eIsSet(featureID);
	}

} //DimensionTypeImpl
