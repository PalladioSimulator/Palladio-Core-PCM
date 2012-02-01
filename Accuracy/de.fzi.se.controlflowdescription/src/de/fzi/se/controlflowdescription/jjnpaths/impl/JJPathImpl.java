/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths.impl;

import de.fzi.se.controlflowdescription.ControlFlowDescription;
import de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage;

import de.fzi.se.controlflowdescription.graph.Vertex;

import de.fzi.se.controlflowdescription.jjnpaths.JJPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JJ Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJPathImpl#getFrom <em>From</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJPathImpl#getTo <em>To</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJPathImpl#getJumpTo <em>Jump To</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJPathImpl#getControlflowdescription <em>Controlflowdescription</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJPathImpl#getJjnpath <em>Jjnpath</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JJPathImpl extends EObjectImpl implements JJPath {
	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected Vertex from;

	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected Vertex to;

	/**
	 * The cached value of the '{@link #getJumpTo() <em>Jump To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJumpTo()
	 * @generated
	 * @ordered
	 */
	protected Vertex jumpTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JJPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JJnPathsPackage.Literals.JJ_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex getFrom() {
		if (from != null && from.eIsProxy()) {
			InternalEObject oldFrom = (InternalEObject)from;
			from = (Vertex)eResolveProxy(oldFrom);
			if (from != oldFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JJnPathsPackage.JJ_PATH__FROM, oldFrom, from));
			}
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex basicGetFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(Vertex newFrom) {
		Vertex oldFrom = from;
		from = newFrom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJ_PATH__FROM, oldFrom, from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex getTo() {
		if (to != null && to.eIsProxy()) {
			InternalEObject oldTo = (InternalEObject)to;
			to = (Vertex)eResolveProxy(oldTo);
			if (to != oldTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JJnPathsPackage.JJ_PATH__TO, oldTo, to));
			}
		}
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex basicGetTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(Vertex newTo) {
		Vertex oldTo = to;
		to = newTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJ_PATH__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex getJumpTo() {
		if (jumpTo != null && jumpTo.eIsProxy()) {
			InternalEObject oldJumpTo = (InternalEObject)jumpTo;
			jumpTo = (Vertex)eResolveProxy(oldJumpTo);
			if (jumpTo != oldJumpTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JJnPathsPackage.JJ_PATH__JUMP_TO, oldJumpTo, jumpTo));
			}
		}
		return jumpTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex basicGetJumpTo() {
		return jumpTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJumpTo(Vertex newJumpTo) {
		Vertex oldJumpTo = jumpTo;
		jumpTo = newJumpTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJ_PATH__JUMP_TO, oldJumpTo, jumpTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlowDescription getControlflowdescription() {
		if (eContainerFeatureID() != JJnPathsPackage.JJ_PATH__CONTROLFLOWDESCRIPTION) return null;
		return (ControlFlowDescription)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetControlflowdescription(ControlFlowDescription newControlflowdescription, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newControlflowdescription, JJnPathsPackage.JJ_PATH__CONTROLFLOWDESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlflowdescription(ControlFlowDescription newControlflowdescription) {
		if (newControlflowdescription != eInternalContainer() || (eContainerFeatureID() != JJnPathsPackage.JJ_PATH__CONTROLFLOWDESCRIPTION && newControlflowdescription != null)) {
			if (EcoreUtil.isAncestor(this, newControlflowdescription))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newControlflowdescription != null)
				msgs = ((InternalEObject)newControlflowdescription).eInverseAdd(this, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJPATHS, ControlFlowDescription.class, msgs);
			msgs = basicSetControlflowdescription(newControlflowdescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJ_PATH__CONTROLFLOWDESCRIPTION, newControlflowdescription, newControlflowdescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPath getJjnpath() {
		if (eContainerFeatureID() != JJnPathsPackage.JJ_PATH__JJNPATH) return null;
		return (JJnPath)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJjnpath(JJnPath newJjnpath, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newJjnpath, JJnPathsPackage.JJ_PATH__JJNPATH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJjnpath(JJnPath newJjnpath) {
		if (newJjnpath != eInternalContainer() || (eContainerFeatureID() != JJnPathsPackage.JJ_PATH__JJNPATH && newJjnpath != null)) {
			if (EcoreUtil.isAncestor(this, newJjnpath))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newJjnpath != null)
				msgs = ((InternalEObject)newJjnpath).eInverseAdd(this, JJnPathsPackage.JJN_PATH__JJPATHS, JJnPath.class, msgs);
			msgs = basicSetJjnpath(newJjnpath, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJ_PATH__JJNPATH, newJjnpath, newJjnpath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JJnPathsPackage.JJ_PATH__CONTROLFLOWDESCRIPTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetControlflowdescription((ControlFlowDescription)otherEnd, msgs);
			case JJnPathsPackage.JJ_PATH__JJNPATH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetJjnpath((JJnPath)otherEnd, msgs);
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
			case JJnPathsPackage.JJ_PATH__CONTROLFLOWDESCRIPTION:
				return basicSetControlflowdescription(null, msgs);
			case JJnPathsPackage.JJ_PATH__JJNPATH:
				return basicSetJjnpath(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case JJnPathsPackage.JJ_PATH__CONTROLFLOWDESCRIPTION:
				return eInternalContainer().eInverseRemove(this, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJPATHS, ControlFlowDescription.class, msgs);
			case JJnPathsPackage.JJ_PATH__JJNPATH:
				return eInternalContainer().eInverseRemove(this, JJnPathsPackage.JJN_PATH__JJPATHS, JJnPath.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JJnPathsPackage.JJ_PATH__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
			case JJnPathsPackage.JJ_PATH__TO:
				if (resolve) return getTo();
				return basicGetTo();
			case JJnPathsPackage.JJ_PATH__JUMP_TO:
				if (resolve) return getJumpTo();
				return basicGetJumpTo();
			case JJnPathsPackage.JJ_PATH__CONTROLFLOWDESCRIPTION:
				return getControlflowdescription();
			case JJnPathsPackage.JJ_PATH__JJNPATH:
				return getJjnpath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JJnPathsPackage.JJ_PATH__FROM:
				setFrom((Vertex)newValue);
				return;
			case JJnPathsPackage.JJ_PATH__TO:
				setTo((Vertex)newValue);
				return;
			case JJnPathsPackage.JJ_PATH__JUMP_TO:
				setJumpTo((Vertex)newValue);
				return;
			case JJnPathsPackage.JJ_PATH__CONTROLFLOWDESCRIPTION:
				setControlflowdescription((ControlFlowDescription)newValue);
				return;
			case JJnPathsPackage.JJ_PATH__JJNPATH:
				setJjnpath((JJnPath)newValue);
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
			case JJnPathsPackage.JJ_PATH__FROM:
				setFrom((Vertex)null);
				return;
			case JJnPathsPackage.JJ_PATH__TO:
				setTo((Vertex)null);
				return;
			case JJnPathsPackage.JJ_PATH__JUMP_TO:
				setJumpTo((Vertex)null);
				return;
			case JJnPathsPackage.JJ_PATH__CONTROLFLOWDESCRIPTION:
				setControlflowdescription((ControlFlowDescription)null);
				return;
			case JJnPathsPackage.JJ_PATH__JJNPATH:
				setJjnpath((JJnPath)null);
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
			case JJnPathsPackage.JJ_PATH__FROM:
				return from != null;
			case JJnPathsPackage.JJ_PATH__TO:
				return to != null;
			case JJnPathsPackage.JJ_PATH__JUMP_TO:
				return jumpTo != null;
			case JJnPathsPackage.JJ_PATH__CONTROLFLOWDESCRIPTION:
				return getControlflowdescription() != null;
			case JJnPathsPackage.JJ_PATH__JJNPATH:
				return getJjnpath() != null;
		}
		return super.eIsSet(featureID);
	}

} //JJPathImpl
