/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths.impl;

import de.fzi.se.controlflowdescription.jjnpaths.JJnPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestCase;
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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JJn Path Test Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestCaseImpl#getJjnpaths <em>Jjnpaths</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestCaseImpl#getJjnpathtestset <em>Jjnpathtestset</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JJnPathTestCaseImpl extends EObjectImpl implements JJnPathTestCase {
	/**
	 * The cached value of the '{@link #getJjnpaths() <em>Jjnpaths</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJjnpaths()
	 * @generated
	 * @ordered
	 */
	protected EList<JJnPath> jjnpaths;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JJnPathTestCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JJnPathsPackage.Literals.JJN_PATH_TEST_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JJnPath> getJjnpaths() {
		if (jjnpaths == null) {
			jjnpaths = new EObjectResolvingEList<JJnPath>(JJnPath.class, this, JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHS);
		}
		return jjnpaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathTestSuite getJjnpathtestset() {
		if (eContainerFeatureID() != JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHTESTSET) return null;
		return (JJnPathTestSuite)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJjnpathtestset(JJnPathTestSuite newJjnpathtestset, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newJjnpathtestset, JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHTESTSET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJjnpathtestset(JJnPathTestSuite newJjnpathtestset) {
		if (newJjnpathtestset != eInternalContainer() || (eContainerFeatureID() != JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHTESTSET && newJjnpathtestset != null)) {
			if (EcoreUtil.isAncestor(this, newJjnpathtestset))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newJjnpathtestset != null)
				msgs = ((InternalEObject)newJjnpathtestset).eInverseAdd(this, JJnPathsPackage.JJN_PATH_TEST_SUITE__TESTCASES, JJnPathTestSuite.class, msgs);
			msgs = basicSetJjnpathtestset(newJjnpathtestset, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHTESTSET, newJjnpathtestset, newJjnpathtestset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHTESTSET:
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
			case JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHTESTSET:
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
			case JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHTESTSET:
				return eInternalContainer().eInverseRemove(this, JJnPathsPackage.JJN_PATH_TEST_SUITE__TESTCASES, JJnPathTestSuite.class, msgs);
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
			case JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHS:
				return getJjnpaths();
			case JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHTESTSET:
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
			case JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHS:
				getJjnpaths().clear();
				getJjnpaths().addAll((Collection<? extends JJnPath>)newValue);
				return;
			case JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHTESTSET:
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
			case JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHS:
				getJjnpaths().clear();
				return;
			case JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHTESTSET:
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
			case JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHS:
				return jjnpaths != null && !jjnpaths.isEmpty();
			case JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHTESTSET:
				return getJjnpathtestset() != null;
		}
		return super.eIsSet(featureID);
	}

} //JJnPathTestCaseImpl
