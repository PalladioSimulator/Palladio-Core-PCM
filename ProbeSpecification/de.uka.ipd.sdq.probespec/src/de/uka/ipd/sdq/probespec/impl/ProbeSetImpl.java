/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.probespec.Probe;
import de.uka.ipd.sdq.probespec.ProbeSet;
import de.uka.ipd.sdq.probespec.ProbeSetPosition;
import de.uka.ipd.sdq.probespec.probespecPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Probe Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.probespec.impl.ProbeSetImpl#getProbes <em>Probes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.probespec.impl.ProbeSetImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.probespec.impl.ProbeSetImpl#getAnnotatedElement <em>Annotated Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProbeSetImpl extends IdentifierImpl implements ProbeSet {
	/**
	 * The cached value of the '{@link #getProbes() <em>Probes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProbes()
	 * @generated
	 * @ordered
	 */
	protected EList<Probe> probes;

	/**
	 * The default value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected static final ProbeSetPosition POSITION_EDEFAULT = ProbeSetPosition.BEFORE;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected ProbeSetPosition position = POSITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnnotatedElement() <em>Annotated Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotatedElement()
	 * @generated
	 * @ordered
	 */
	protected EObject annotatedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProbeSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return probespecPackage.Literals.PROBE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Probe> getProbes() {
		if (probes == null) {
			probes = new EObjectContainmentEList<Probe>(Probe.class, this, probespecPackage.PROBE_SET__PROBES);
		}
		return probes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbeSetPosition getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(ProbeSetPosition newPosition) {
		ProbeSetPosition oldPosition = position;
		position = newPosition == null ? POSITION_EDEFAULT : newPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, probespecPackage.PROBE_SET__POSITION, oldPosition, position));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getAnnotatedElement() {
		if (annotatedElement != null && annotatedElement.eIsProxy()) {
			InternalEObject oldAnnotatedElement = (InternalEObject)annotatedElement;
			annotatedElement = eResolveProxy(oldAnnotatedElement);
			if (annotatedElement != oldAnnotatedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, probespecPackage.PROBE_SET__ANNOTATED_ELEMENT, oldAnnotatedElement, annotatedElement));
			}
		}
		return annotatedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetAnnotatedElement() {
		return annotatedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotatedElement(EObject newAnnotatedElement) {
		EObject oldAnnotatedElement = annotatedElement;
		annotatedElement = newAnnotatedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, probespecPackage.PROBE_SET__ANNOTATED_ELEMENT, oldAnnotatedElement, annotatedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case probespecPackage.PROBE_SET__PROBES:
				return ((InternalEList<?>)getProbes()).basicRemove(otherEnd, msgs);
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
			case probespecPackage.PROBE_SET__PROBES:
				return getProbes();
			case probespecPackage.PROBE_SET__POSITION:
				return getPosition();
			case probespecPackage.PROBE_SET__ANNOTATED_ELEMENT:
				if (resolve) return getAnnotatedElement();
				return basicGetAnnotatedElement();
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
			case probespecPackage.PROBE_SET__PROBES:
				getProbes().clear();
				getProbes().addAll((Collection<? extends Probe>)newValue);
				return;
			case probespecPackage.PROBE_SET__POSITION:
				setPosition((ProbeSetPosition)newValue);
				return;
			case probespecPackage.PROBE_SET__ANNOTATED_ELEMENT:
				setAnnotatedElement((EObject)newValue);
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
			case probespecPackage.PROBE_SET__PROBES:
				getProbes().clear();
				return;
			case probespecPackage.PROBE_SET__POSITION:
				setPosition(POSITION_EDEFAULT);
				return;
			case probespecPackage.PROBE_SET__ANNOTATED_ELEMENT:
				setAnnotatedElement((EObject)null);
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
			case probespecPackage.PROBE_SET__PROBES:
				return probes != null && !probes.isEmpty();
			case probespecPackage.PROBE_SET__POSITION:
				return position != POSITION_EDEFAULT;
			case probespecPackage.PROBE_SET__ANNOTATED_ELEMENT:
				return annotatedElement != null;
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
		result.append(" (position: ");
		result.append(position);
		result.append(')');
		return result.toString();
	}

} //ProbeSetImpl
