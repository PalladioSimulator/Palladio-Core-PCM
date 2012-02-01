/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths.impl;

import de.fzi.se.controlflowdescription.jjnpaths.JJnPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet;
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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JJn Path Test Suite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestSuiteImpl#getJjnhelperpaths <em>Jjnhelperpaths</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestSuiteImpl#getJjnpathset <em>Jjnpathset</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestSuiteImpl#getTestcases <em>Testcases</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathTestSuiteImpl#getRequiredTests <em>Required Tests</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JJnPathTestSuiteImpl extends EObjectImpl implements JJnPathTestSuite {
	/**
	 * The cached value of the '{@link #getJjnhelperpaths() <em>Jjnhelperpaths</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJjnhelperpaths()
	 * @generated
	 * @ordered
	 */
	protected EList<JJnPath> jjnhelperpaths;

	/**
	 * The cached value of the '{@link #getTestcases() <em>Testcases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestcases()
	 * @generated
	 * @ordered
	 */
	protected EList<JJnPathTestCase> testcases;

	/**
	 * The default value of the '{@link #getRequiredTests() <em>Required Tests</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredTests()
	 * @generated
	 * @ordered
	 */
	protected static final int REQUIRED_TESTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRequiredTests() <em>Required Tests</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredTests()
	 * @generated
	 * @ordered
	 */
	protected int requiredTests = REQUIRED_TESTS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JJnPathTestSuiteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JJnPathsPackage.Literals.JJN_PATH_TEST_SUITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JJnPath> getJjnhelperpaths() {
		if (jjnhelperpaths == null) {
			jjnhelperpaths = new EObjectContainmentWithInverseEList<JJnPath>(JJnPath.class, this, JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNHELPERPATHS, JJnPathsPackage.JJN_PATH__JJNPATHTESTSET);
		}
		return jjnhelperpaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathSet getJjnpathset() {
		if (eContainerFeatureID() != JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET) return null;
		return (JJnPathSet)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJjnpathset(JJnPathSet newJjnpathset, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newJjnpathset, JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJjnpathset(JJnPathSet newJjnpathset) {
		if (newJjnpathset != eInternalContainer() || (eContainerFeatureID() != JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET && newJjnpathset != null)) {
			if (EcoreUtil.isAncestor(this, newJjnpathset))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newJjnpathset != null)
				msgs = ((InternalEObject)newJjnpathset).eInverseAdd(this, JJnPathsPackage.JJN_PATH_SET__JJNPATHTESTSET, JJnPathSet.class, msgs);
			msgs = basicSetJjnpathset(newJjnpathset, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET, newJjnpathset, newJjnpathset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JJnPathTestCase> getTestcases() {
		if (testcases == null) {
			testcases = new EObjectContainmentWithInverseEList<JJnPathTestCase>(JJnPathTestCase.class, this, JJnPathsPackage.JJN_PATH_TEST_SUITE__TESTCASES, JJnPathsPackage.JJN_PATH_TEST_CASE__JJNPATHTESTSET);
		}
		return testcases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRequiredTests() {
		return requiredTests;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredTests(int newRequiredTests) {
		int oldRequiredTests = requiredTests;
		requiredTests = newRequiredTests;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJN_PATH_TEST_SUITE__REQUIRED_TESTS, oldRequiredTests, requiredTests));
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
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNHELPERPATHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getJjnhelperpaths()).basicAdd(otherEnd, msgs);
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetJjnpathset((JJnPathSet)otherEnd, msgs);
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__TESTCASES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTestcases()).basicAdd(otherEnd, msgs);
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
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNHELPERPATHS:
				return ((InternalEList<?>)getJjnhelperpaths()).basicRemove(otherEnd, msgs);
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET:
				return basicSetJjnpathset(null, msgs);
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__TESTCASES:
				return ((InternalEList<?>)getTestcases()).basicRemove(otherEnd, msgs);
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
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET:
				return eInternalContainer().eInverseRemove(this, JJnPathsPackage.JJN_PATH_SET__JJNPATHTESTSET, JJnPathSet.class, msgs);
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
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNHELPERPATHS:
				return getJjnhelperpaths();
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET:
				return getJjnpathset();
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__TESTCASES:
				return getTestcases();
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__REQUIRED_TESTS:
				return getRequiredTests();
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
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNHELPERPATHS:
				getJjnhelperpaths().clear();
				getJjnhelperpaths().addAll((Collection<? extends JJnPath>)newValue);
				return;
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET:
				setJjnpathset((JJnPathSet)newValue);
				return;
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__TESTCASES:
				getTestcases().clear();
				getTestcases().addAll((Collection<? extends JJnPathTestCase>)newValue);
				return;
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__REQUIRED_TESTS:
				setRequiredTests((Integer)newValue);
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
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNHELPERPATHS:
				getJjnhelperpaths().clear();
				return;
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET:
				setJjnpathset((JJnPathSet)null);
				return;
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__TESTCASES:
				getTestcases().clear();
				return;
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__REQUIRED_TESTS:
				setRequiredTests(REQUIRED_TESTS_EDEFAULT);
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
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNHELPERPATHS:
				return jjnhelperpaths != null && !jjnhelperpaths.isEmpty();
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET:
				return getJjnpathset() != null;
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__TESTCASES:
				return testcases != null && !testcases.isEmpty();
			case JJnPathsPackage.JJN_PATH_TEST_SUITE__REQUIRED_TESTS:
				return requiredTests != REQUIRED_TESTS_EDEFAULT;
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
		result.append(" (requiredTests: ");
		result.append(requiredTests);
		result.append(')');
		return result.toString();
	}

} //JJnPathTestSuiteImpl
