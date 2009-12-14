/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import EssentialOCL.OperationCallExp;
import QVTRelation.Relation;
import de.uka.ipd.sdq.featuremodel.DisambiguationRule;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Disambiguation Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.DisambiguationRuleImpl#getTransformationFragment <em>Transformation Fragment</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.DisambiguationRuleImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.DisambiguationRuleImpl#getDisambiguationCondition <em>Disambiguation Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DisambiguationRuleImpl extends EObjectImpl implements DisambiguationRule {
	/**
	 * The cached value of the '{@link #getTransformationFragment() <em>Transformation Fragment</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformationFragment()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> transformationFragment;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected Feature feature;

	/**
	 * The cached value of the '{@link #getDisambiguationCondition() <em>Disambiguation Condition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisambiguationCondition()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationCallExp> disambiguationCondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DisambiguationRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featuremodelPackage.Literals.DISAMBIGUATION_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getTransformationFragment() {
		if (transformationFragment == null) {
			transformationFragment = new EObjectResolvingEList<Relation>(Relation.class, this, featuremodelPackage.DISAMBIGUATION_RULE__TRANSFORMATION_FRAGMENT);
		}
		return transformationFragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (Feature)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, featuremodelPackage.DISAMBIGUATION_RULE__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(Feature newFeature) {
		Feature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.DISAMBIGUATION_RULE__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationCallExp> getDisambiguationCondition() {
		if (disambiguationCondition == null) {
			disambiguationCondition = new EObjectContainmentEList<OperationCallExp>(OperationCallExp.class, this, featuremodelPackage.DISAMBIGUATION_RULE__DISAMBIGUATION_CONDITION);
		}
		return disambiguationCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featuremodelPackage.DISAMBIGUATION_RULE__DISAMBIGUATION_CONDITION:
				return ((InternalEList<?>)getDisambiguationCondition()).basicRemove(otherEnd, msgs);
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
			case featuremodelPackage.DISAMBIGUATION_RULE__TRANSFORMATION_FRAGMENT:
				return getTransformationFragment();
			case featuremodelPackage.DISAMBIGUATION_RULE__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case featuremodelPackage.DISAMBIGUATION_RULE__DISAMBIGUATION_CONDITION:
				return getDisambiguationCondition();
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
			case featuremodelPackage.DISAMBIGUATION_RULE__TRANSFORMATION_FRAGMENT:
				getTransformationFragment().clear();
				getTransformationFragment().addAll((Collection<? extends Relation>)newValue);
				return;
			case featuremodelPackage.DISAMBIGUATION_RULE__FEATURE:
				setFeature((Feature)newValue);
				return;
			case featuremodelPackage.DISAMBIGUATION_RULE__DISAMBIGUATION_CONDITION:
				getDisambiguationCondition().clear();
				getDisambiguationCondition().addAll((Collection<? extends OperationCallExp>)newValue);
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
			case featuremodelPackage.DISAMBIGUATION_RULE__TRANSFORMATION_FRAGMENT:
				getTransformationFragment().clear();
				return;
			case featuremodelPackage.DISAMBIGUATION_RULE__FEATURE:
				setFeature((Feature)null);
				return;
			case featuremodelPackage.DISAMBIGUATION_RULE__DISAMBIGUATION_CONDITION:
				getDisambiguationCondition().clear();
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
			case featuremodelPackage.DISAMBIGUATION_RULE__TRANSFORMATION_FRAGMENT:
				return transformationFragment != null && !transformationFragment.isEmpty();
			case featuremodelPackage.DISAMBIGUATION_RULE__FEATURE:
				return feature != null;
			case featuremodelPackage.DISAMBIGUATION_RULE__DISAMBIGUATION_CONDITION:
				return disambiguationCondition != null && !disambiguationCondition.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DisambiguationRuleImpl
