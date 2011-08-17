/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Degree</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ClassDegreeImpl#getClassDesignOptions <em>Class Design Options</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ClassDegreeImpl extends DegreeOfFreedomInstanceImpl implements ClassDegree {
	/**
	 * The cached value of the '{@link #getClassDesignOptions() <em>Class Design Options</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassDesignOptions()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> classDesignOptions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDegreeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.CLASS_DEGREE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getClassDesignOptions() {
		if (classDesignOptions == null) {
			classDesignOptions = new EObjectResolvingEList<EObject>(EObject.class, this, designdecisionPackage.CLASS_DEGREE__CLASS_DESIGN_OPTIONS);
		}
		return classDesignOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.CLASS_DEGREE__CLASS_DESIGN_OPTIONS:
				return getClassDesignOptions();
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
			case designdecisionPackage.CLASS_DEGREE__CLASS_DESIGN_OPTIONS:
				getClassDesignOptions().clear();
				getClassDesignOptions().addAll((Collection<? extends EObject>)newValue);
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
			case designdecisionPackage.CLASS_DEGREE__CLASS_DESIGN_OPTIONS:
				getClassDesignOptions().clear();
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
			case designdecisionPackage.CLASS_DEGREE__CLASS_DESIGN_OPTIONS:
				return classDesignOptions != null && !classDesignOptions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassDegreeImpl
