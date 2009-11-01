/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.sourcecodedecorator.impl;

import SourceCodeDecorator.sourcecodedecorator.Methods;
import SourceCodeDecorator.sourcecodedecorator.SourcecodedecoratorPackage;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Methods</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.impl.MethodsImpl#getRelativePathInFile <em>Relative Path In File</em>}</li>
 *   <li>{@link SourceCodeDecorator.sourcecodedecorator.impl.MethodsImpl#getMethodName <em>Method Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodsImpl extends IdentifierImpl implements Methods {
	/**
	 * The default value of the '{@link #getRelativePathInFile() <em>Relative Path In File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativePathInFile()
	 * @generated
	 * @ordered
	 */
	protected static final String RELATIVE_PATH_IN_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelativePathInFile() <em>Relative Path In File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativePathInFile()
	 * @generated
	 * @ordered
	 */
	protected String relativePathInFile = RELATIVE_PATH_IN_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected static final String METHOD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected String methodName = METHOD_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SourcecodedecoratorPackage.Literals.METHODS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelativePathInFile() {
		return relativePathInFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelativePathInFile(String newRelativePathInFile) {
		String oldRelativePathInFile = relativePathInFile;
		relativePathInFile = newRelativePathInFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcecodedecoratorPackage.METHODS__RELATIVE_PATH_IN_FILE, oldRelativePathInFile, relativePathInFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodName(String newMethodName) {
		String oldMethodName = methodName;
		methodName = newMethodName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SourcecodedecoratorPackage.METHODS__METHOD_NAME, oldMethodName, methodName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SourcecodedecoratorPackage.METHODS__RELATIVE_PATH_IN_FILE:
				return getRelativePathInFile();
			case SourcecodedecoratorPackage.METHODS__METHOD_NAME:
				return getMethodName();
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
			case SourcecodedecoratorPackage.METHODS__RELATIVE_PATH_IN_FILE:
				setRelativePathInFile((String)newValue);
				return;
			case SourcecodedecoratorPackage.METHODS__METHOD_NAME:
				setMethodName((String)newValue);
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
			case SourcecodedecoratorPackage.METHODS__RELATIVE_PATH_IN_FILE:
				setRelativePathInFile(RELATIVE_PATH_IN_FILE_EDEFAULT);
				return;
			case SourcecodedecoratorPackage.METHODS__METHOD_NAME:
				setMethodName(METHOD_NAME_EDEFAULT);
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
			case SourcecodedecoratorPackage.METHODS__RELATIVE_PATH_IN_FILE:
				return RELATIVE_PATH_IN_FILE_EDEFAULT == null ? relativePathInFile != null : !RELATIVE_PATH_IN_FILE_EDEFAULT.equals(relativePathInFile);
			case SourcecodedecoratorPackage.METHODS__METHOD_NAME:
				return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
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
		result.append(" (relativePathInFile: ");
		result.append(relativePathInFile);
		result.append(", methodName: ");
		result.append(methodName);
		result.append(')');
		return result.toString();
	}

} //MethodsImpl
