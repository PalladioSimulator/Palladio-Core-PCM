/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription.jjnpaths.impl;

import de.fzi.se.controlflowdescription.ControlFlowDescription;
import de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage;

import de.fzi.se.controlflowdescription.jjnpaths.JJnPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathSet;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsPackage;

import de.fzi.se.controlflowdescription.jjnpaths.util.JJnPathsValidator;

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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JJn Path Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathSetImpl#getJjnpaths <em>Jjnpaths</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathSetImpl#getJjnpathtestset <em>Jjnpathtestset</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathSetImpl#getN <em>N</em>}</li>
 *   <li>{@link de.fzi.se.controlflowdescription.jjnpaths.impl.JJnPathSetImpl#getControlflowdescription <em>Controlflowdescription</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JJnPathSetImpl extends EObjectImpl implements JJnPathSet {
	/**
	 * The cached value of the '{@link #getJjnpaths() <em>Jjnpaths</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJjnpaths()
	 * @generated
	 * @ordered
	 */
	protected EList<JJnPath> jjnpaths;

	/**
	 * The cached value of the '{@link #getJjnpathtestset() <em>Jjnpathtestset</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJjnpathtestset()
	 * @generated
	 * @ordered
	 */
	protected JJnPathTestSuite jjnpathtestset;

	/**
	 * The default value of the '{@link #getN() <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getN()
	 * @generated
	 * @ordered
	 */
	protected static final int N_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getN() <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getN()
	 * @generated
	 * @ordered
	 */
	protected int n = N_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JJnPathSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JJnPathsPackage.Literals.JJN_PATH_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JJnPath> getJjnpaths() {
		if (jjnpaths == null) {
			jjnpaths = new EObjectContainmentWithInverseEList<JJnPath>(JJnPath.class, this, JJnPathsPackage.JJN_PATH_SET__JJNPATHS, JJnPathsPackage.JJN_PATH__JJNPATHSET);
		}
		return jjnpaths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JJnPathTestSuite getJjnpathtestset() {
		return jjnpathtestset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJjnpathtestset(JJnPathTestSuite newJjnpathtestset, NotificationChain msgs) {
		JJnPathTestSuite oldJjnpathtestset = jjnpathtestset;
		jjnpathtestset = newJjnpathtestset;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJN_PATH_SET__JJNPATHTESTSET, oldJjnpathtestset, newJjnpathtestset);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJjnpathtestset(JJnPathTestSuite newJjnpathtestset) {
		if (newJjnpathtestset != jjnpathtestset) {
			NotificationChain msgs = null;
			if (jjnpathtestset != null)
				msgs = ((InternalEObject)jjnpathtestset).eInverseRemove(this, JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET, JJnPathTestSuite.class, msgs);
			if (newJjnpathtestset != null)
				msgs = ((InternalEObject)newJjnpathtestset).eInverseAdd(this, JJnPathsPackage.JJN_PATH_TEST_SUITE__JJNPATHSET, JJnPathTestSuite.class, msgs);
			msgs = basicSetJjnpathtestset(newJjnpathtestset, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJN_PATH_SET__JJNPATHTESTSET, newJjnpathtestset, newJjnpathtestset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getN() {
		return n;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setN(int newN) {
		int oldN = n;
		n = newN;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJN_PATH_SET__N, oldN, n));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ControlFlowDescription getControlflowdescription() {
		if (eContainerFeatureID() != JJnPathsPackage.JJN_PATH_SET__CONTROLFLOWDESCRIPTION) return null;
		return (ControlFlowDescription)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetControlflowdescription(ControlFlowDescription newControlflowdescription, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newControlflowdescription, JJnPathsPackage.JJN_PATH_SET__CONTROLFLOWDESCRIPTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlflowdescription(ControlFlowDescription newControlflowdescription) {
		if (newControlflowdescription != eInternalContainer() || (eContainerFeatureID() != JJnPathsPackage.JJN_PATH_SET__CONTROLFLOWDESCRIPTION && newControlflowdescription != null)) {
			if (EcoreUtil.isAncestor(this, newControlflowdescription))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newControlflowdescription != null)
				msgs = ((InternalEObject)newControlflowdescription).eInverseAdd(this, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJNPATHSETS, ControlFlowDescription.class, msgs);
			msgs = basicSetControlflowdescription(newControlflowdescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JJnPathsPackage.JJN_PATH_SET__CONTROLFLOWDESCRIPTION, newControlflowdescription, newControlflowdescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean NMustBeGreaterOrEqualToOne(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 JJnPathsValidator.DIAGNOSTIC_SOURCE,
						 JJnPathsValidator.JJN_PATH_SET__NMUST_BE_GREATER_OR_EQUAL_TO_ONE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "NMustBeGreaterOrEqualToOne", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
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
			case JJnPathsPackage.JJN_PATH_SET__JJNPATHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getJjnpaths()).basicAdd(otherEnd, msgs);
			case JJnPathsPackage.JJN_PATH_SET__JJNPATHTESTSET:
				if (jjnpathtestset != null)
					msgs = ((InternalEObject)jjnpathtestset).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JJnPathsPackage.JJN_PATH_SET__JJNPATHTESTSET, null, msgs);
				return basicSetJjnpathtestset((JJnPathTestSuite)otherEnd, msgs);
			case JJnPathsPackage.JJN_PATH_SET__CONTROLFLOWDESCRIPTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetControlflowdescription((ControlFlowDescription)otherEnd, msgs);
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
			case JJnPathsPackage.JJN_PATH_SET__JJNPATHS:
				return ((InternalEList<?>)getJjnpaths()).basicRemove(otherEnd, msgs);
			case JJnPathsPackage.JJN_PATH_SET__JJNPATHTESTSET:
				return basicSetJjnpathtestset(null, msgs);
			case JJnPathsPackage.JJN_PATH_SET__CONTROLFLOWDESCRIPTION:
				return basicSetControlflowdescription(null, msgs);
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
			case JJnPathsPackage.JJN_PATH_SET__CONTROLFLOWDESCRIPTION:
				return eInternalContainer().eInverseRemove(this, ControlFlowDescriptionPackage.CONTROL_FLOW_DESCRIPTION__JJNPATHSETS, ControlFlowDescription.class, msgs);
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
			case JJnPathsPackage.JJN_PATH_SET__JJNPATHS:
				return getJjnpaths();
			case JJnPathsPackage.JJN_PATH_SET__JJNPATHTESTSET:
				return getJjnpathtestset();
			case JJnPathsPackage.JJN_PATH_SET__N:
				return getN();
			case JJnPathsPackage.JJN_PATH_SET__CONTROLFLOWDESCRIPTION:
				return getControlflowdescription();
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
			case JJnPathsPackage.JJN_PATH_SET__JJNPATHS:
				getJjnpaths().clear();
				getJjnpaths().addAll((Collection<? extends JJnPath>)newValue);
				return;
			case JJnPathsPackage.JJN_PATH_SET__JJNPATHTESTSET:
				setJjnpathtestset((JJnPathTestSuite)newValue);
				return;
			case JJnPathsPackage.JJN_PATH_SET__N:
				setN((Integer)newValue);
				return;
			case JJnPathsPackage.JJN_PATH_SET__CONTROLFLOWDESCRIPTION:
				setControlflowdescription((ControlFlowDescription)newValue);
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
			case JJnPathsPackage.JJN_PATH_SET__JJNPATHS:
				getJjnpaths().clear();
				return;
			case JJnPathsPackage.JJN_PATH_SET__JJNPATHTESTSET:
				setJjnpathtestset((JJnPathTestSuite)null);
				return;
			case JJnPathsPackage.JJN_PATH_SET__N:
				setN(N_EDEFAULT);
				return;
			case JJnPathsPackage.JJN_PATH_SET__CONTROLFLOWDESCRIPTION:
				setControlflowdescription((ControlFlowDescription)null);
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
			case JJnPathsPackage.JJN_PATH_SET__JJNPATHS:
				return jjnpaths != null && !jjnpaths.isEmpty();
			case JJnPathsPackage.JJN_PATH_SET__JJNPATHTESTSET:
				return jjnpathtestset != null;
			case JJnPathsPackage.JJN_PATH_SET__N:
				return n != N_EDEFAULT;
			case JJnPathsPackage.JJN_PATH_SET__CONTROLFLOWDESCRIPTION:
				return getControlflowdescription() != null;
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
		result.append(" (n: ");
		result.append(n);
		result.append(')');
		return result.toString();
	}

} //JJnPathSetImpl
