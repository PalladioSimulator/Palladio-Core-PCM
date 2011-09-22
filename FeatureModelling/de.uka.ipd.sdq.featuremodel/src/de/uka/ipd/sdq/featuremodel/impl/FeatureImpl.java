/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.featuremodel.Attribute;
import de.uka.ipd.sdq.featuremodel.ChildRelation;
import de.uka.ipd.sdq.featuremodel.Feature;
import de.uka.ipd.sdq.featuremodel.FeatureGroup;
import de.uka.ipd.sdq.featuremodel.Simple;
import de.uka.ipd.sdq.featuremodel.featuremodelPackage;
import de.uka.ipd.sdq.featuremodel.util.featuremodelValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Feature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getChildrelation <em>Childrelation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getSimpleMandatory <em>Simple Mandatory</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getSimpleOptional <em>Simple Optional</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl#getFeaturegroup <em>Featuregroup</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends NamedElementImpl implements Feature {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroup getFeaturegroup() {
		if (eContainerFeatureID() != featuremodelPackage.FEATURE__FEATUREGROUP) return null;
		return (FeatureGroup)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFeaturegroup(FeatureGroup newFeaturegroup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFeaturegroup, featuremodelPackage.FEATURE__FEATUREGROUP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeaturegroup(FeatureGroup newFeaturegroup) {
		if (newFeaturegroup != eInternalContainer() || (eContainerFeatureID() != featuremodelPackage.FEATURE__FEATUREGROUP && newFeaturegroup != null)) {
			if (EcoreUtil.isAncestor(this, newFeaturegroup))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFeaturegroup != null)
				msgs = ((InternalEObject)newFeaturegroup).eInverseAdd(this, featuremodelPackage.FEATURE_GROUP__CHILDREN, FeatureGroup.class, msgs);
			msgs = basicSetFeaturegroup(newFeaturegroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, featuremodelPackage.FEATURE__FEATUREGROUP, newFeaturegroup, newFeaturegroup));
	}

	/**
	 * The cached OCL expression body for the '{@link #EachAttributeNameDefinedJustOnce(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Each Attribute Name Defined Just Once</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EachAttributeNameDefinedJustOnce(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EACH_ATTRIBUTE_NAME_DEFINED_JUST_ONCE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "true "+
"--each attribute name is unique for this feature"+
"--self.attributes->isUnique(attr | attr.name)";

	/**
	 * The cached OCL invariant for the '{@link #EachAttributeNameDefinedJustOnce(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Each Attribute Name Defined Just Once</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EachAttributeNameDefinedJustOnce(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EACH_ATTRIBUTE_NAME_DEFINED_JUST_ONCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean EachAttributeNameDefinedJustOnce(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EACH_ATTRIBUTE_NAME_DEFINED_JUST_ONCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(featuremodelPackage.Literals.FEATURE);
			try {
				EACH_ATTRIBUTE_NAME_DEFINED_JUST_ONCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(EACH_ATTRIBUTE_NAME_DEFINED_JUST_ONCE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(EACH_ATTRIBUTE_NAME_DEFINED_JUST_ONCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 featuremodelValidator.DIAGNOSTIC_SOURCE,
						 featuremodelValidator.FEATURE__EACH_ATTRIBUTE_NAME_DEFINED_JUST_ONCE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "EachAttributeNameDefinedJustOnce", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
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
			case featuremodelPackage.FEATURE__FEATUREGROUP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFeaturegroup((FeatureGroup)otherEnd, msgs);
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
			case featuremodelPackage.FEATURE__SIMPLE_MANDATORY:
				return basicSetSimpleMandatory(null, msgs);
			case featuremodelPackage.FEATURE__SIMPLE_OPTIONAL:
				return basicSetSimpleOptional(null, msgs);
			case featuremodelPackage.FEATURE__FEATUREGROUP:
				return basicSetFeaturegroup(null, msgs);
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
			case featuremodelPackage.FEATURE__FEATUREGROUP:
				return eInternalContainer().eInverseRemove(this, featuremodelPackage.FEATURE_GROUP__CHILDREN, FeatureGroup.class, msgs);
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
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				return getAttributes();
			case featuremodelPackage.FEATURE__CHILDRELATION:
				return getChildrelation();
			case featuremodelPackage.FEATURE__SIMPLE_MANDATORY:
				return getSimpleMandatory();
			case featuremodelPackage.FEATURE__SIMPLE_OPTIONAL:
				return getSimpleOptional();
			case featuremodelPackage.FEATURE__FEATUREGROUP:
				return getFeaturegroup();
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
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case featuremodelPackage.FEATURE__CHILDRELATION:
				setChildrelation((ChildRelation)newValue);
				return;
			case featuremodelPackage.FEATURE__SIMPLE_MANDATORY:
				setSimpleMandatory((Simple)newValue);
				return;
			case featuremodelPackage.FEATURE__SIMPLE_OPTIONAL:
				setSimpleOptional((Simple)newValue);
				return;
			case featuremodelPackage.FEATURE__FEATUREGROUP:
				setFeaturegroup((FeatureGroup)newValue);
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
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				getAttributes().clear();
				return;
			case featuremodelPackage.FEATURE__CHILDRELATION:
				setChildrelation((ChildRelation)null);
				return;
			case featuremodelPackage.FEATURE__SIMPLE_MANDATORY:
				setSimpleMandatory((Simple)null);
				return;
			case featuremodelPackage.FEATURE__SIMPLE_OPTIONAL:
				setSimpleOptional((Simple)null);
				return;
			case featuremodelPackage.FEATURE__FEATUREGROUP:
				setFeaturegroup((FeatureGroup)null);
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
			case featuremodelPackage.FEATURE__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case featuremodelPackage.FEATURE__CHILDRELATION:
				return childrelation != null;
			case featuremodelPackage.FEATURE__SIMPLE_MANDATORY:
				return getSimpleMandatory() != null;
			case featuremodelPackage.FEATURE__SIMPLE_OPTIONAL:
				return getSimpleOptional() != null;
			case featuremodelPackage.FEATURE__FEATUREGROUP:
				return getFeaturegroup() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} // FeatureImpl
