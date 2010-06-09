/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeDataTypeImpl#getMembers__CompositeDataType <em>Members Composite Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeDataTypeImpl extends DataTypeImpl implements CompositeDataType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getMembers__CompositeDataType() <em>Members Composite Data Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMembers__CompositeDataType()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> members__CompositeDataType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.COMPOSITE_DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getMembers__CompositeDataType() {
		if (members__CompositeDataType == null) {
			members__CompositeDataType = new EObjectContainmentWithInverseEList<Variable>(Variable.class, this, RepositoryPackage.COMPOSITE_DATA_TYPE__MEMBERS_COMPOSITE_DATA_TYPE, ParameterPackage.VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE);
		}
		return members__CompositeDataType;
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
			case RepositoryPackage.COMPOSITE_DATA_TYPE__MEMBERS_COMPOSITE_DATA_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMembers__CompositeDataType()).basicAdd(otherEnd, msgs);
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
			case RepositoryPackage.COMPOSITE_DATA_TYPE__MEMBERS_COMPOSITE_DATA_TYPE:
				return ((InternalEList<?>)getMembers__CompositeDataType()).basicRemove(otherEnd, msgs);
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
			case RepositoryPackage.COMPOSITE_DATA_TYPE__MEMBERS_COMPOSITE_DATA_TYPE:
				return getMembers__CompositeDataType();
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
			case RepositoryPackage.COMPOSITE_DATA_TYPE__MEMBERS_COMPOSITE_DATA_TYPE:
				getMembers__CompositeDataType().clear();
				getMembers__CompositeDataType().addAll((Collection<? extends Variable>)newValue);
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
			case RepositoryPackage.COMPOSITE_DATA_TYPE__MEMBERS_COMPOSITE_DATA_TYPE:
				getMembers__CompositeDataType().clear();
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
			case RepositoryPackage.COMPOSITE_DATA_TYPE__MEMBERS_COMPOSITE_DATA_TYPE:
				return members__CompositeDataType != null && !members__CompositeDataType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeDataTypeImpl
