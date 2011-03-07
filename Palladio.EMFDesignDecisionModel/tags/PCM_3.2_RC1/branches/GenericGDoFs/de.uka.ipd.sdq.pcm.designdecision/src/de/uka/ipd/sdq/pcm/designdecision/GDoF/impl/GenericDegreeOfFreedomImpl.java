/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.GDoF.impl;

import de.uka.ipd.sdq.pcm.designdecision.GDoF.ChangeableElementDescription;
import de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage;
import de.uka.ipd.sdq.pcm.designdecision.GDoF.GenericDegreeOfFreedom;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Degree Of Freedom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.impl.GenericDegreeOfFreedomImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.impl.GenericDegreeOfFreedomImpl#getAddedElements <em>Added Elements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.impl.GenericDegreeOfFreedomImpl#getChangeableElementDescription <em>Changeable Element Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.impl.GenericDegreeOfFreedomImpl#getInteractionConstraint <em>Interaction Constraint</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.impl.GenericDegreeOfFreedomImpl#getPrimaryChangeable <em>Primary Changeable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenericDegreeOfFreedomImpl extends EObjectImpl implements GenericDegreeOfFreedom {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAddedElements() <em>Added Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EClass> addedElements;

	/**
	 * The cached value of the '{@link #getChangeableElementDescription() <em>Changeable Element Description</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeableElementDescription()
	 * @generated
	 * @ordered
	 */
	protected EList<ChangeableElementDescription> changeableElementDescription;

	/**
	 * The cached value of the '{@link #getInteractionConstraint() <em>Interaction Constraint</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractionConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<EOperation> interactionConstraint;

	/**
	 * The cached value of the '{@link #getPrimaryChangeable() <em>Primary Changeable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryChangeable()
	 * @generated
	 * @ordered
	 */
	protected ChangeableElementDescription primaryChangeable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericDegreeOfFreedomImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GDoFPackage.Literals.GENERIC_DEGREE_OF_FREEDOM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClass> getAddedElements() {
		if (addedElements == null) {
			addedElements = new EObjectResolvingEList<EClass>(EClass.class, this, GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__ADDED_ELEMENTS);
		}
		return addedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChangeableElementDescription> getChangeableElementDescription() {
		if (changeableElementDescription == null) {
			changeableElementDescription = new EObjectContainmentEList<ChangeableElementDescription>(ChangeableElementDescription.class, this, GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__CHANGEABLE_ELEMENT_DESCRIPTION);
		}
		return changeableElementDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EOperation> getInteractionConstraint() {
		if (interactionConstraint == null) {
			interactionConstraint = new EObjectResolvingEList<EOperation>(EOperation.class, this, GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__INTERACTION_CONSTRAINT);
		}
		return interactionConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeableElementDescription getPrimaryChangeable() {
		if (primaryChangeable != null && primaryChangeable.eIsProxy()) {
			InternalEObject oldPrimaryChangeable = (InternalEObject)primaryChangeable;
			primaryChangeable = (ChangeableElementDescription)eResolveProxy(oldPrimaryChangeable);
			if (primaryChangeable != oldPrimaryChangeable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__PRIMARY_CHANGEABLE, oldPrimaryChangeable, primaryChangeable));
			}
		}
		return primaryChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeableElementDescription basicGetPrimaryChangeable() {
		return primaryChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryChangeable(ChangeableElementDescription newPrimaryChangeable) {
		ChangeableElementDescription oldPrimaryChangeable = primaryChangeable;
		primaryChangeable = newPrimaryChangeable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__PRIMARY_CHANGEABLE, oldPrimaryChangeable, primaryChangeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__CHANGEABLE_ELEMENT_DESCRIPTION:
				return ((InternalEList<?>)getChangeableElementDescription()).basicRemove(otherEnd, msgs);
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
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__NAME:
				return getName();
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__ADDED_ELEMENTS:
				return getAddedElements();
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__CHANGEABLE_ELEMENT_DESCRIPTION:
				return getChangeableElementDescription();
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__INTERACTION_CONSTRAINT:
				return getInteractionConstraint();
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__PRIMARY_CHANGEABLE:
				if (resolve) return getPrimaryChangeable();
				return basicGetPrimaryChangeable();
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
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__NAME:
				setName((String)newValue);
				return;
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__ADDED_ELEMENTS:
				getAddedElements().clear();
				getAddedElements().addAll((Collection<? extends EClass>)newValue);
				return;
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__CHANGEABLE_ELEMENT_DESCRIPTION:
				getChangeableElementDescription().clear();
				getChangeableElementDescription().addAll((Collection<? extends ChangeableElementDescription>)newValue);
				return;
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__INTERACTION_CONSTRAINT:
				getInteractionConstraint().clear();
				getInteractionConstraint().addAll((Collection<? extends EOperation>)newValue);
				return;
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__PRIMARY_CHANGEABLE:
				setPrimaryChangeable((ChangeableElementDescription)newValue);
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
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__ADDED_ELEMENTS:
				getAddedElements().clear();
				return;
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__CHANGEABLE_ELEMENT_DESCRIPTION:
				getChangeableElementDescription().clear();
				return;
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__INTERACTION_CONSTRAINT:
				getInteractionConstraint().clear();
				return;
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__PRIMARY_CHANGEABLE:
				setPrimaryChangeable((ChangeableElementDescription)null);
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
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__ADDED_ELEMENTS:
				return addedElements != null && !addedElements.isEmpty();
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__CHANGEABLE_ELEMENT_DESCRIPTION:
				return changeableElementDescription != null && !changeableElementDescription.isEmpty();
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__INTERACTION_CONSTRAINT:
				return interactionConstraint != null && !interactionConstraint.isEmpty();
			case GDoFPackage.GENERIC_DEGREE_OF_FREEDOM__PRIMARY_CHANGEABLE:
				return primaryChangeable != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //GenericDegreeOfFreedomImpl
