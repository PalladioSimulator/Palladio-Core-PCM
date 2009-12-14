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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import QVTRelation.Relation;
import de.uka.ipd.sdq.featuremodel.Attribute;
import de.uka.ipd.sdq.featuremodel.ChildRelation;
import de.uka.ipd.sdq.featuremodel.DisambiguationRule;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureState;
import de.uka.ipd.sdq.featuremodel.Simple;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Feature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getFeatureState <em>Feature State</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getChildrelation <em>Childrelation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getDisambiguation <em>Disambiguation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getTransformationFragment <em>Transformation Fragment</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getCopyException <em>Copy Exception</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getSimpleMandatory <em>Simple Mandatory</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getSimpleOptional <em>Simple Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends NamedElementImpl implements Feature {
	/**
	 * The default value of the '{@link #getFeatureState() <em>Feature State</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getFeatureState()
	 * @generated
	 * @ordered
	 */
	protected static final FeatureState FEATURE_STATE_EDEFAULT = FeatureState.NOT_SET;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getChildrelation() <em>Childrelation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildrelation()
	 * @generated
	 * @ordered
	 */
	protected ChildRelation childrelation;

	/**
	 * The cached value of the '{@link #getDisambiguation() <em>Disambiguation</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getDisambiguation()
	 * @generated
	 * @ordered
	 */
	protected EList<DisambiguationRule> disambiguation;

	/**
	 * The cached value of the '{@link #getTransformationFragment() <em>Transformation Fragment</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getTransformationFragment()
	 * @generated
	 * @ordered
	 */
	protected EList<Relation> transformationFragment;

	/**
	 * The cached value of the '{@link #getCopyException() <em>Copy Exception</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getCopyException()
	 * @generated
	 * @ordered
	 */
	protected EList<copyException.Exception> copyException;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return featuremodelPackage.Literals.FEATURE;
	}

	/**
	 * <!-- begin-user-doc --> Checks if the Simple Object contains this Object
	 * in its mandatoryChildren or its optionalChildren list. Out of that
	 * information, the FeatureState is set to Mandatory or Optional. If none of
	 * the conditions matches, FeatureState.NOT_SET is returned. The null-checks should not be necessary
	 * System.err only for testing<!-- end-user-doc
	 * -->
	 * 
	 * @generated NOT
	 */
	public FeatureState getFeatureState() {
		if (this.getSimpleMandatory() != null
				&& this.getSimpleMandatory().getMandatoryChildren() != null
				&& this.getSimpleMandatory().getMandatoryChildren().contains(
						this)) {
			System.err.println("it's a mandatory feature");
			return FeatureState.MANDATORY;
		} else if (this.getSimpleOptional() != null
				&& this.getSimpleOptional().getOptionalChildren() != null
				&& this.getSimpleOptional().getOptionalChildren()
						.contains(this)) {
			System.err.println("it's an optional feature");
			return FeatureState.OPTIONAL;
		} else {
			System.err.println("its feature is'nt set");
			return FeatureState.NOT_SET;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method does nothing. See {@link #getFeatureState()} for description
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setFeatureState(FeatureState newFeatureState) {
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, featuremodelPackage.FEATURE__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ChildRelation getChildrelation() {
		return childrelation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChildrelation(
			ChildRelation newChildrelation, NotificationChain msgs) {
		ChildRelation oldChildrelation = childrelation;
		childrelation = newChildrelation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, featuremodelPackage.FEATURE__CHILDRELATION, oldChildrelation, newChildrelation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setChildrelation(ChildRelation newChildrelation) {
		if (newChildrelation != childrelation) {
			NotificationChain msgs = null;
			if (childrelation != null)
				msgs = ((InternalEObject)childrelation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - featuremodelPackage.FEATURE__CHILDRELATION, null, msgs);
			if (newChildrelation != null)
				msgs = ((InternalEObject)newChildrelation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - featuremodelPackage.FEATURE__CHILDRELATION, null, msgs);
			msgs = basicSetChildrelation(newChildrelation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.FEATURE__CHILDRELATION, newChildrelation, newChildrelation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DisambiguationRule> getDisambiguation() {
		if (disambiguation == null) {
			disambiguation = new EObjectContainmentEList<DisambiguationRule>(DisambiguationRule.class, this, featuremodelPackage.FEATURE__DISAMBIGUATION);
		}
		return disambiguation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Relation> getTransformationFragment() {
		if (transformationFragment == null) {
			transformationFragment = new EObjectContainmentEList<Relation>(Relation.class, this, featuremodelPackage.FEATURE__TRANSFORMATION_FRAGMENT);
		}
		return transformationFragment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<copyException.Exception> getCopyException() {
		if (copyException == null) {
			copyException = new EObjectContainmentEList<copyException.Exception>(copyException.Exception.class, this, featuremodelPackage.FEATURE__COPY_EXCEPTION);
		}
		return copyException;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Simple getSimpleMandatory() {
		if (eContainerFeatureID() != featuremodelPackage.FEATURE__SIMPLE_MANDATORY) return null;
		return (Simple)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleMandatory(Simple newSimpleMandatory,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSimpleMandatory, featuremodelPackage.FEATURE__SIMPLE_MANDATORY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleMandatory(Simple newSimpleMandatory) {
		if (newSimpleMandatory != eInternalContainer() || (eContainerFeatureID() != featuremodelPackage.FEATURE__SIMPLE_MANDATORY && newSimpleMandatory != null)) {
			if (EcoreUtil.isAncestor(this, newSimpleMandatory))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSimpleMandatory != null)
				msgs = ((InternalEObject)newSimpleMandatory).eInverseAdd(this, featuremodelPackage.SIMPLE__MANDATORY_CHILDREN, Simple.class, msgs);
			msgs = basicSetSimpleMandatory(newSimpleMandatory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.FEATURE__SIMPLE_MANDATORY, newSimpleMandatory, newSimpleMandatory));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Simple getSimpleOptional() {
		if (eContainerFeatureID() != featuremodelPackage.FEATURE__SIMPLE_OPTIONAL) return null;
		return (Simple)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSimpleOptional(Simple newSimpleOptional,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSimpleOptional, featuremodelPackage.FEATURE__SIMPLE_OPTIONAL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleOptional(Simple newSimpleOptional) {
		if (newSimpleOptional != eInternalContainer() || (eContainerFeatureID() != featuremodelPackage.FEATURE__SIMPLE_OPTIONAL && newSimpleOptional != null)) {
			if (EcoreUtil.isAncestor(this, newSimpleOptional))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSimpleOptional != null)
				msgs = ((InternalEObject)newSimpleOptional).eInverseAdd(this, featuremodelPackage.SIMPLE__OPTIONAL_CHILDREN, Simple.class, msgs);
			msgs = basicSetSimpleOptional(newSimpleOptional, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.FEATURE__SIMPLE_OPTIONAL, newSimpleOptional, newSimpleOptional));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featuremodelPackage.FEATURE__SIMPLE_MANDATORY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSimpleMandatory((Simple)otherEnd, msgs);
			case featuremodelPackage.FEATURE__SIMPLE_OPTIONAL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSimpleOptional((Simple)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case featuremodelPackage.FEATURE__CHILDRELATION:
				return basicSetChildrelation(null, msgs);
			case featuremodelPackage.FEATURE__DISAMBIGUATION:
				return ((InternalEList<?>)getDisambiguation()).basicRemove(otherEnd, msgs);
			case featuremodelPackage.FEATURE__TRANSFORMATION_FRAGMENT:
				return ((InternalEList<?>)getTransformationFragment()).basicRemove(otherEnd, msgs);
			case featuremodelPackage.FEATURE__COPY_EXCEPTION:
				return ((InternalEList<?>)getCopyException()).basicRemove(otherEnd, msgs);
			case featuremodelPackage.FEATURE__SIMPLE_MANDATORY:
				return basicSetSimpleMandatory(null, msgs);
			case featuremodelPackage.FEATURE__SIMPLE_OPTIONAL:
				return basicSetSimpleOptional(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case featuremodelPackage.FEATURE__SIMPLE_MANDATORY:
				return eInternalContainer().eInverseRemove(this, featuremodelPackage.SIMPLE__MANDATORY_CHILDREN, Simple.class, msgs);
			case featuremodelPackage.FEATURE__SIMPLE_OPTIONAL:
				return eInternalContainer().eInverseRemove(this, featuremodelPackage.SIMPLE__OPTIONAL_CHILDREN, Simple.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case featuremodelPackage.FEATURE__FEATURE_STATE:
				return getFeatureState();
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				return getAttributes();
			case featuremodelPackage.FEATURE__CHILDRELATION:
				return getChildrelation();
			case featuremodelPackage.FEATURE__DISAMBIGUATION:
				return getDisambiguation();
			case featuremodelPackage.FEATURE__TRANSFORMATION_FRAGMENT:
				return getTransformationFragment();
			case featuremodelPackage.FEATURE__COPY_EXCEPTION:
				return getCopyException();
			case featuremodelPackage.FEATURE__SIMPLE_MANDATORY:
				return getSimpleMandatory();
			case featuremodelPackage.FEATURE__SIMPLE_OPTIONAL:
				return getSimpleOptional();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case featuremodelPackage.FEATURE__FEATURE_STATE:
				setFeatureState((FeatureState)newValue);
				return;
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case featuremodelPackage.FEATURE__CHILDRELATION:
				setChildrelation((ChildRelation)newValue);
				return;
			case featuremodelPackage.FEATURE__DISAMBIGUATION:
				getDisambiguation().clear();
				getDisambiguation().addAll((Collection<? extends DisambiguationRule>)newValue);
				return;
			case featuremodelPackage.FEATURE__TRANSFORMATION_FRAGMENT:
				getTransformationFragment().clear();
				getTransformationFragment().addAll((Collection<? extends Relation>)newValue);
				return;
			case featuremodelPackage.FEATURE__COPY_EXCEPTION:
				getCopyException().clear();
				getCopyException().addAll((Collection<? extends copyException.Exception>)newValue);
				return;
			case featuremodelPackage.FEATURE__SIMPLE_MANDATORY:
				setSimpleMandatory((Simple)newValue);
				return;
			case featuremodelPackage.FEATURE__SIMPLE_OPTIONAL:
				setSimpleOptional((Simple)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case featuremodelPackage.FEATURE__FEATURE_STATE:
				setFeatureState(FEATURE_STATE_EDEFAULT);
				return;
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				getAttributes().clear();
				return;
			case featuremodelPackage.FEATURE__CHILDRELATION:
				setChildrelation((ChildRelation)null);
				return;
			case featuremodelPackage.FEATURE__DISAMBIGUATION:
				getDisambiguation().clear();
				return;
			case featuremodelPackage.FEATURE__TRANSFORMATION_FRAGMENT:
				getTransformationFragment().clear();
				return;
			case featuremodelPackage.FEATURE__COPY_EXCEPTION:
				getCopyException().clear();
				return;
			case featuremodelPackage.FEATURE__SIMPLE_MANDATORY:
				setSimpleMandatory((Simple)null);
				return;
			case featuremodelPackage.FEATURE__SIMPLE_OPTIONAL:
				setSimpleOptional((Simple)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case featuremodelPackage.FEATURE__FEATURE_STATE:
				return getFeatureState() != FEATURE_STATE_EDEFAULT;
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case featuremodelPackage.FEATURE__CHILDRELATION:
				return childrelation != null;
			case featuremodelPackage.FEATURE__DISAMBIGUATION:
				return disambiguation != null && !disambiguation.isEmpty();
			case featuremodelPackage.FEATURE__TRANSFORMATION_FRAGMENT:
				return transformationFragment != null && !transformationFragment.isEmpty();
			case featuremodelPackage.FEATURE__COPY_EXCEPTION:
				return copyException != null && !copyException.isEmpty();
			case featuremodelPackage.FEATURE__SIMPLE_MANDATORY:
				return getSimpleMandatory() != null;
			case featuremodelPackage.FEATURE__SIMPLE_OPTIONAL:
				return getSimpleOptional() != null;
		}
		return super.eIsSet(featureID);
	}

} // FeatureImpl
