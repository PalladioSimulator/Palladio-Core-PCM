/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import de.uka.ipd.sdq.pcm.repository.FailureType;
import de.uka.ipd.sdq.pcm.seff.FailureHandlingEntity;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Handling Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.FailureHandlingEntityImpl#getFailureTypes <em>Failure Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FailureHandlingEntityImpl extends EObjectImpl implements FailureHandlingEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getFailureTypes() <em>Failure Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<FailureType> failureTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FailureHandlingEntityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SeffPackage.Literals.FAILURE_HANDLING_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FailureType> getFailureTypes() {
		if (failureTypes == null) {
			failureTypes = new EObjectResolvingEList<FailureType>(FailureType.class, this, SeffPackage.FAILURE_HANDLING_ENTITY__FAILURE_TYPES);
		}
		return failureTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SeffPackage.FAILURE_HANDLING_ENTITY__FAILURE_TYPES:
				return getFailureTypes();
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
			case SeffPackage.FAILURE_HANDLING_ENTITY__FAILURE_TYPES:
				getFailureTypes().clear();
				getFailureTypes().addAll((Collection<? extends FailureType>)newValue);
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
			case SeffPackage.FAILURE_HANDLING_ENTITY__FAILURE_TYPES:
				getFailureTypes().clear();
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
			case SeffPackage.FAILURE_HANDLING_ENTITY__FAILURE_TYPES:
				return failureTypes != null && !failureTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FailureHandlingEntityImpl
