/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeID;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Code ID</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceCodeIDImpl#getSourceCodeID <em>Source Code ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SourceCodeIDImpl extends IdentifierImpl implements SourceCodeID {
	/**
	 * The default value of the '{@link #getSourceCodeID() <em>Source Code ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceCodeID()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_CODE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceCodeID() <em>Source Code ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceCodeID()
	 * @generated
	 * @ordered
	 */
	protected String sourceCodeID = SOURCE_CODE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceCodeIDImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcecodedecoratorPackage.Literals.SOURCE_CODE_ID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSourceCodeID() {
		return sourceCodeID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceCodeID(String newSourceCodeID) {
		String oldSourceCodeID = sourceCodeID;
		sourceCodeID = newSourceCodeID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcecodedecoratorPackage.SOURCE_CODE_ID__SOURCE_CODE_ID, oldSourceCodeID, sourceCodeID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SourcecodedecoratorPackage.SOURCE_CODE_ID__SOURCE_CODE_ID:
				return getSourceCodeID();
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
			case SourcecodedecoratorPackage.SOURCE_CODE_ID__SOURCE_CODE_ID:
				setSourceCodeID((String)newValue);
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
			case SourcecodedecoratorPackage.SOURCE_CODE_ID__SOURCE_CODE_ID:
				setSourceCodeID(SOURCE_CODE_ID_EDEFAULT);
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
			case SourcecodedecoratorPackage.SOURCE_CODE_ID__SOURCE_CODE_ID:
				return SOURCE_CODE_ID_EDEFAULT == null ? sourceCodeID != null : !SOURCE_CODE_ID_EDEFAULT.equals(sourceCodeID);
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
		result.append(" (sourceCodeID: ");
		result.append(sourceCodeID);
		result.append(')');
		return result.toString();
	}

} //SourceCodeIDImpl
