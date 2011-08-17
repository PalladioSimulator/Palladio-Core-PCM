/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.impl;

import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclaration;
import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarations;
import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarationsPackage;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>QML Declarations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.impl.QMLDeclarationsImpl#getQmlDeclarations <em>Qml Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QMLDeclarationsImpl extends IdentifierImpl implements QMLDeclarations {
	/**
	 * The cached value of the '{@link #getQmlDeclarations() <em>Qml Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQmlDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<QMLDeclaration> qmlDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QMLDeclarationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QMLDeclarationsPackage.Literals.QML_DECLARATIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QMLDeclaration> getQmlDeclarations() {
		if (qmlDeclarations == null) {
			qmlDeclarations = new EObjectContainmentEList<QMLDeclaration>(QMLDeclaration.class, this, QMLDeclarationsPackage.QML_DECLARATIONS__QML_DECLARATIONS);
		}
		return qmlDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QMLDeclarationsPackage.QML_DECLARATIONS__QML_DECLARATIONS:
				return ((InternalEList<?>)getQmlDeclarations()).basicRemove(otherEnd, msgs);
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
			case QMLDeclarationsPackage.QML_DECLARATIONS__QML_DECLARATIONS:
				return getQmlDeclarations();
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
			case QMLDeclarationsPackage.QML_DECLARATIONS__QML_DECLARATIONS:
				getQmlDeclarations().clear();
				getQmlDeclarations().addAll((Collection<? extends QMLDeclaration>)newValue);
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
			case QMLDeclarationsPackage.QML_DECLARATIONS__QML_DECLARATIONS:
				getQmlDeclarations().clear();
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
			case QMLDeclarationsPackage.QML_DECLARATIONS__QML_DECLARATIONS:
				return qmlDeclarations != null && !qmlDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //QMLDeclarationsImpl
