/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;
import de.uka.ipd.sdq.spa.resourcemodel.Option;
import de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.impl.OptionImpl#getProbability <em>Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.impl.OptionImpl#getResourceUsage <em>Resource Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OptionImpl extends EObjectImpl implements Option {
	/**
	 * The default value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProbability() <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected double probability = PROBABILITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResourceUsage() <em>Resource Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUsage()
	 * @generated
	 * @ordered
	 */
	protected AbstractResourceUsage resourceUsage = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResourceModelPackage.Literals.OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProbability(double newProbability) {
		double oldProbability = probability;
		probability = newProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceModelPackage.OPTION__PROBABILITY, oldProbability, probability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractResourceUsage getResourceUsage() {
		return resourceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceUsage(AbstractResourceUsage newResourceUsage, NotificationChain msgs) {
		AbstractResourceUsage oldResourceUsage = resourceUsage;
		resourceUsage = newResourceUsage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ResourceModelPackage.OPTION__RESOURCE_USAGE, oldResourceUsage, newResourceUsage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceUsage(AbstractResourceUsage newResourceUsage) {
		if (newResourceUsage != resourceUsage) {
			NotificationChain msgs = null;
			if (resourceUsage != null)
				msgs = ((InternalEObject)resourceUsage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ResourceModelPackage.OPTION__RESOURCE_USAGE, null, msgs);
			if (newResourceUsage != null)
				msgs = ((InternalEObject)newResourceUsage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ResourceModelPackage.OPTION__RESOURCE_USAGE, null, msgs);
			msgs = basicSetResourceUsage(newResourceUsage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceModelPackage.OPTION__RESOURCE_USAGE, newResourceUsage, newResourceUsage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourceModelPackage.OPTION__RESOURCE_USAGE:
				return basicSetResourceUsage(null, msgs);
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
			case ResourceModelPackage.OPTION__PROBABILITY:
				return new Double(getProbability());
			case ResourceModelPackage.OPTION__RESOURCE_USAGE:
				return getResourceUsage();
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
			case ResourceModelPackage.OPTION__PROBABILITY:
				setProbability(((Double)newValue).doubleValue());
				return;
			case ResourceModelPackage.OPTION__RESOURCE_USAGE:
				setResourceUsage((AbstractResourceUsage)newValue);
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
			case ResourceModelPackage.OPTION__PROBABILITY:
				setProbability(PROBABILITY_EDEFAULT);
				return;
			case ResourceModelPackage.OPTION__RESOURCE_USAGE:
				setResourceUsage((AbstractResourceUsage)null);
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
			case ResourceModelPackage.OPTION__PROBABILITY:
				return probability != PROBABILITY_EDEFAULT;
			case ResourceModelPackage.OPTION__RESOURCE_USAGE:
				return resourceUsage != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (probability: ");
		result.append(probability);
		result.append(')');
		return result.toString();
	}

} //OptionImpl
