/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.Simple;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;
import de.uka.ipd.sdq.featuremodel.util.featuremodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.SimpleImpl#getOptionalChildren <em>Optional Children</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.SimpleImpl#getMandatoryChildren <em>Mandatory Children</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SimpleImpl extends ChildRelationImpl implements Simple {
	/**
	 * The cached value of the '{@link #getOptionalChildren() <em>Optional Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> optionalChildren;
	/**
	 * The cached value of the '{@link #getMandatoryChildren() <em>Mandatory Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMandatoryChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> mandatoryChildren;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featuremodelPackage.Literals.SIMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getMandatoryChildren() {
		if (mandatoryChildren == null) {
			mandatoryChildren = new EObjectContainmentWithInverseEList<Feature>(Feature.class, this, featuremodelPackage.SIMPLE__MANDATORY_CHILDREN, featuremodelPackage.FEATURE__SIMPLE_MANDATORY);
		}
		return mandatoryChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getOptionalChildren() {
		if (optionalChildren == null) {
			optionalChildren = new EObjectContainmentWithInverseEList<Feature>(Feature.class, this, featuremodelPackage.SIMPLE__OPTIONAL_CHILDREN, featuremodelPackage.FEATURE__SIMPLE_OPTIONAL);
		}
		return optionalChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean atLeastOneChild(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featuremodelValidator.DIAGNOSTIC_SOURCE,
						 featuremodelValidator.SIMPLE__AT_LEAST_ONE_CHILD,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "atLeastOneChild", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
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
			case featuremodelPackage.SIMPLE__OPTIONAL_CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOptionalChildren()).basicAdd(otherEnd, msgs);
			case featuremodelPackage.SIMPLE__MANDATORY_CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMandatoryChildren()).basicAdd(otherEnd, msgs);
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
			case featuremodelPackage.SIMPLE__OPTIONAL_CHILDREN:
				return ((InternalEList<?>)getOptionalChildren()).basicRemove(otherEnd, msgs);
			case featuremodelPackage.SIMPLE__MANDATORY_CHILDREN:
				return ((InternalEList<?>)getMandatoryChildren()).basicRemove(otherEnd, msgs);
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
			case featuremodelPackage.SIMPLE__OPTIONAL_CHILDREN:
				return getOptionalChildren();
			case featuremodelPackage.SIMPLE__MANDATORY_CHILDREN:
				return getMandatoryChildren();
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
			case featuremodelPackage.SIMPLE__OPTIONAL_CHILDREN:
				getOptionalChildren().clear();
				getOptionalChildren().addAll((Collection<? extends Feature>)newValue);
				return;
			case featuremodelPackage.SIMPLE__MANDATORY_CHILDREN:
				getMandatoryChildren().clear();
				getMandatoryChildren().addAll((Collection<? extends Feature>)newValue);
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
			case featuremodelPackage.SIMPLE__OPTIONAL_CHILDREN:
				getOptionalChildren().clear();
				return;
			case featuremodelPackage.SIMPLE__MANDATORY_CHILDREN:
				getMandatoryChildren().clear();
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
			case featuremodelPackage.SIMPLE__OPTIONAL_CHILDREN:
				return optionalChildren != null && !optionalChildren.isEmpty();
			case featuremodelPackage.SIMPLE__MANDATORY_CHILDREN:
				return mandatoryChildren != null && !mandatoryChildren.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SimpleImpl
