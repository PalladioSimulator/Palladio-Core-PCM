
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import de.uka.ipd.sdq.pcm.parameter.CompositeParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterUsage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Parameter Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.impl.CompositeParameterUsageImpl#getInnerParameters_ParameterUsage <em>Inner Parameters Parameter Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeParameterUsageImpl extends ParameterUsageImpl implements CompositeParameterUsage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getInnerParameters_ParameterUsage() <em>Inner Parameters Parameter Usage</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerParameters_ParameterUsage()
	 * @generated
	 * @ordered
	 */
	protected EList innerParameters_ParameterUsage = null;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeParameterUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ParameterPackage.Literals.COMPOSITE_PARAMETER_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getInnerParameters_ParameterUsage() {
		if (innerParameters_ParameterUsage == null) {
			innerParameters_ParameterUsage = new EObjectContainmentEList(ParameterUsage.class, this, ParameterPackage.COMPOSITE_PARAMETER_USAGE__INNER_PARAMETERS_PARAMETER_USAGE);
		}
		return innerParameters_ParameterUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParameterPackage.COMPOSITE_PARAMETER_USAGE__INNER_PARAMETERS_PARAMETER_USAGE:
				return ((InternalEList)getInnerParameters_ParameterUsage()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ParameterPackage.COMPOSITE_PARAMETER_USAGE__INNER_PARAMETERS_PARAMETER_USAGE:
				return getInnerParameters_ParameterUsage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ParameterPackage.COMPOSITE_PARAMETER_USAGE__INNER_PARAMETERS_PARAMETER_USAGE:
				getInnerParameters_ParameterUsage().clear();
				getInnerParameters_ParameterUsage().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ParameterPackage.COMPOSITE_PARAMETER_USAGE__INNER_PARAMETERS_PARAMETER_USAGE:
				getInnerParameters_ParameterUsage().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ParameterPackage.COMPOSITE_PARAMETER_USAGE__INNER_PARAMETERS_PARAMETER_USAGE:
				return innerParameters_ParameterUsage != null && !innerParameters_ParameterUsage.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompositeParameterUsageImpl