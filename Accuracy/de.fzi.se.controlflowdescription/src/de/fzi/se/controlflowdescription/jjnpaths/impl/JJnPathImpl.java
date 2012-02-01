/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths.impl;

import de.fzi.se.controlflowdescription.graph.Vertex;
import de.fzi.se.controlflowdescription.jjnpaths.JJPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JJn Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathImpl#getJjnpathset <em>Jjnpathset</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathImpl#getJjpaths <em>Jjpaths</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathImpl#getFrom <em>From</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathImpl#getJumpTo <em>Jump To</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathImpl#getJjnpathtestset <em>Jjnpathtestset</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JJnPathImpl extends EObjectImpl implements JJnPath {

	/**
	 * The cached value of the '{@link #getJjpaths() <em>Jjpaths</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJjpaths()
	 * @generated
	 * @ordered
	 */
	protected EList<JJPath> jjpaths;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JJnPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JJnPathsPackage.Literals.JJN_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathSet getJjnpathset() {
		if (eContainerFeatureID() != JJnPathsPackage.JJN_PATH__JJNPATHSET) return null;
		return (JJnPathSet)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJjnpathset(JJnPathSet newJjnpathset, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newJjnpathset, JJnPathsPackage.JJN_PATH__JJNPATHSET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJjnpathset(JJnPathSet newJjnpathset) {
		if (newJjnpathset != eInternalContainer() || (eContainerFeatureID() != JJnPathsPackage.JJN_PATH__JJNPATHSET && newJjnpathset != null)) {
			if (EcoreUtil.isAncestor(this, newJjnpathset))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newJjnpathset != null)
				msgs = ((InternalEObject)newJjnpathset).eInverseAdd(this, JJnPathsPackage.JJN_PATH_SET__JJNPATHS, JJnPathSet.class, msgs);
			msgs = basicSetJjnpathset(newJjnpathset, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJN_PATH__JJNPATHSET, newJjnpathset, newJjnpathset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex getFrom() {
		Vertex from = basicGetFrom();
		return from != null && from.eIsProxy() ? (Vertex)eResolveProxy((InternalEObject)from) : from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Return the starting vertex in the sequence of paths.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Vertex basicGetFrom() {
		if (getJjpaths().size() > 0)
			return getJjpaths().get(0).getFrom();
		else
			return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setFrom(Vertex newFrom) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex getJumpTo() {
		Vertex jumpTo = basicGetJumpTo();
		return jumpTo != null && jumpTo.eIsProxy() ? (Vertex)eResolveProxy((InternalEObject)jumpTo) : jumpTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Return the final jump in the sequence of paths.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Vertex basicGetJumpTo() {
		if (getJjpaths().size() > 0)
			return getJjpaths().get(getJjpaths().size()-1).getJumpTo();
		else
			return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setJumpTo(Vertex newJumpTo) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathTestSuite getJjnpathtestset() {
		if (eContainerFeatureID() != JJnPathsPackage.JJN_PATH__JJNPATHTESTSET) return null;
		return (JJnPathTestSuite)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJjnpathtestset(JJnPathTestSuite newJjnpathtestset, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newJjnpathtestset, JJnPathsPackage.JJN_PATH__JJNPATHTESTSET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJjnpathtestset(JJnPathTestSuite newJjnpathtestset) {
		if (newJjnpathtestset != eInternalContainer() || (eContainerFeatureID() != JJnPathsPackage.JJN_PATH__JJNPATHTESTSET && newJjnpathtestset != null)) {
			if (EcoreUtil.isAncestor(this, newJjnpathtestset))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newJjnpathtestset != null)
				msgs = ((InternalEObject)newJjnpathtestset).eInverseAdd(this, JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNHELPERPATHS, JJnPathTestSuite.class, msgs);
			msgs = basicSetJjnpathtestset(newJjnpathtestset, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJN_PATH__JJNPATHTESTSET, newJjnpathtestset, newJjnpathtestset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JJPath> getJjpaths() {
		if (jjpaths == null) {
			jjpaths = new EObjectContainmentWithInverseEList<JJPath>(JJPath.class, this, JJnPathsPackage.JJN_PATH__JJPATHS, JJnPathsPackage.JJ_PATH__JJNPATH);
		}
		return jjpaths;
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
			case JJnPathsPackage.JJN_PATH__JJNPATHSET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetJjnpathset((JJnPathSet)otherEnd, msgs);
			case JJnPathsPackage.JJN_PATH__JJPATHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getJjpaths()).basicAdd(otherEnd, msgs);
			case JJnPathsPackage.JJN_PATH__JJNPATHTESTSET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetJjnpathtestset((JJnPathTestSuite)otherEnd, msgs);
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
			case JJnPathsPackage.JJN_PATH__JJNPATHSET:
				return basicSetJjnpathset(null, msgs);
			case JJnPathsPackage.JJN_PATH__JJPATHS:
				return ((InternalEList<?>)getJjpaths()).basicRemove(otherEnd, msgs);
			case JJnPathsPackage.JJN_PATH__JJNPATHTESTSET:
				return basicSetJjnpathtestset(null, msgs);
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
			case JJnPathsPackage.JJN_PATH__JJNPATHSET:
				return eInternalContainer().eInverseRemove(this, JJnPathsPackage.JJN_PATH_SET__JJNPATHS, JJnPathSet.class, msgs);
			case JJnPathsPackage.JJN_PATH__JJNPATHTESTSET:
				return eInternalContainer().eInverseRemove(this, JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNHELPERPATHS, JJnPathTestSuite.class, msgs);
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
			case JJnPathsPackage.JJN_PATH__JJNPATHSET:
				return getJjnpathset();
			case JJnPathsPackage.JJN_PATH__JJPATHS:
				return getJjpaths();
			case JJnPathsPackage.JJN_PATH__FROM:
				if (resolve) return getFrom();
				return basicGetFrom();
			case JJnPathsPackage.JJN_PATH__JUMP_TO:
				if (resolve) return getJumpTo();
				return basicGetJumpTo();
			case JJnPathsPackage.JJN_PATH__JJNPATHTESTSET:
				return getJjnpathtestset();
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
			case JJnPathsPackage.JJN_PATH__JJNPATHSET:
				setJjnpathset((JJnPathSet)newValue);
				return;
			case JJnPathsPackage.JJN_PATH__JJPATHS:
				getJjpaths().clear();
				getJjpaths().addAll((Collection<? extends JJPath>)newValue);
				return;
			case JJnPathsPackage.JJN_PATH__FROM:
				setFrom((Vertex)newValue);
				return;
			case JJnPathsPackage.JJN_PATH__JUMP_TO:
				setJumpTo((Vertex)newValue);
				return;
			case JJnPathsPackage.JJN_PATH__JJNPATHTESTSET:
				setJjnpathtestset((JJnPathTestSuite)newValue);
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
			case JJnPathsPackage.JJN_PATH__JJNPATHSET:
				setJjnpathset((JJnPathSet)null);
				return;
			case JJnPathsPackage.JJN_PATH__JJPATHS:
				getJjpaths().clear();
				return;
			case JJnPathsPackage.JJN_PATH__FROM:
				setFrom((Vertex)null);
				return;
			case JJnPathsPackage.JJN_PATH__JUMP_TO:
				setJumpTo((Vertex)null);
				return;
			case JJnPathsPackage.JJN_PATH__JJNPATHTESTSET:
				setJjnpathtestset((JJnPathTestSuite)null);
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
			case JJnPathsPackage.JJN_PATH__JJNPATHSET:
				return getJjnpathset() != null;
			case JJnPathsPackage.JJN_PATH__JJPATHS:
				return jjpaths != null && !jjpaths.isEmpty();
			case JJnPathsPackage.JJN_PATH__FROM:
				return basicGetFrom() != null;
			case JJnPathsPackage.JJN_PATH__JUMP_TO:
				return basicGetJumpTo() != null;
			case JJnPathsPackage.JJN_PATH__JJNPATHTESTSET:
				return getJjnpathtestset() != null;
		}
		return super.eIsSet(featureID);
	}

} //JJnPathImpl
