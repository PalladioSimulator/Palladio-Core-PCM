
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.ParameterModifier;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl#getDatatype__Parameter <em>Datatype Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl#getParameterName <em>Parameter Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ParameterImpl#getModifier__Parameter <em>Modifier Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterImpl extends EObjectImpl implements Parameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getDatatype__Parameter() <em>Datatype Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatype__Parameter()
	 * @generated
	 * @ordered
	 */
	protected DataType datatype__Parameter = null;

	/**
	 * The default value of the '{@link #getParameterName() <em>Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterName()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAMETER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameterName() <em>Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterName()
	 * @generated
	 * @ordered
	 */
	protected String parameterName = PARAMETER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getModifier__Parameter() <em>Modifier Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier__Parameter()
	 * @generated
	 * @ordered
	 */
	protected static final ParameterModifier MODIFIER_PARAMETER_EDEFAULT = ParameterModifier.NONE_LITERAL;


	/**
	 * The cached value of the '{@link #getModifier__Parameter() <em>Modifier Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier__Parameter()
	 * @generated
	 * @ordered
	 */
	protected ParameterModifier modifier__Parameter = MODIFIER_PARAMETER_EDEFAULT;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDatatype__Parameter() {
		return datatype__Parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDatatype__Parameter(DataType newDatatype__Parameter, NotificationChain msgs) {
		DataType oldDatatype__Parameter = datatype__Parameter;
		datatype__Parameter = newDatatype__Parameter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepositoryPackage.PARAMETER__DATATYPE_PARAMETER, oldDatatype__Parameter, newDatatype__Parameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDatatype__Parameter(DataType newDatatype__Parameter) {
		if (newDatatype__Parameter != datatype__Parameter) {
			NotificationChain msgs = null;
			if (datatype__Parameter != null)
				msgs = ((InternalEObject)datatype__Parameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.PARAMETER__DATATYPE_PARAMETER, null, msgs);
			if (newDatatype__Parameter != null)
				msgs = ((InternalEObject)newDatatype__Parameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.PARAMETER__DATATYPE_PARAMETER, null, msgs);
			msgs = basicSetDatatype__Parameter(newDatatype__Parameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.PARAMETER__DATATYPE_PARAMETER, newDatatype__Parameter, newDatatype__Parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameterName() {
		return parameterName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterName(String newParameterName) {
		String oldParameterName = parameterName;
		parameterName = newParameterName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.PARAMETER__PARAMETER_NAME, oldParameterName, parameterName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterModifier getModifier__Parameter() {
		return modifier__Parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifier__Parameter(ParameterModifier newModifier__Parameter) {
		ParameterModifier oldModifier__Parameter = modifier__Parameter;
		modifier__Parameter = newModifier__Parameter == null ? MODIFIER_PARAMETER_EDEFAULT : newModifier__Parameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.PARAMETER__MODIFIER_PARAMETER, oldModifier__Parameter, modifier__Parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.PARAMETER__DATATYPE_PARAMETER:
				return basicSetDatatype__Parameter(null, msgs);
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
			case RepositoryPackage.PARAMETER__DATATYPE_PARAMETER:
				return getDatatype__Parameter();
			case RepositoryPackage.PARAMETER__PARAMETER_NAME:
				return getParameterName();
			case RepositoryPackage.PARAMETER__MODIFIER_PARAMETER:
				return getModifier__Parameter();
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
			case RepositoryPackage.PARAMETER__DATATYPE_PARAMETER:
				setDatatype__Parameter((DataType)newValue);
				return;
			case RepositoryPackage.PARAMETER__PARAMETER_NAME:
				setParameterName((String)newValue);
				return;
			case RepositoryPackage.PARAMETER__MODIFIER_PARAMETER:
				setModifier__Parameter((ParameterModifier)newValue);
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
			case RepositoryPackage.PARAMETER__DATATYPE_PARAMETER:
				setDatatype__Parameter((DataType)null);
				return;
			case RepositoryPackage.PARAMETER__PARAMETER_NAME:
				setParameterName(PARAMETER_NAME_EDEFAULT);
				return;
			case RepositoryPackage.PARAMETER__MODIFIER_PARAMETER:
				setModifier__Parameter(MODIFIER_PARAMETER_EDEFAULT);
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
			case RepositoryPackage.PARAMETER__DATATYPE_PARAMETER:
				return datatype__Parameter != null;
			case RepositoryPackage.PARAMETER__PARAMETER_NAME:
				return PARAMETER_NAME_EDEFAULT == null ? parameterName != null : !PARAMETER_NAME_EDEFAULT.equals(parameterName);
			case RepositoryPackage.PARAMETER__MODIFIER_PARAMETER:
				return modifier__Parameter != MODIFIER_PARAMETER_EDEFAULT;
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
		result.append(" (parameterName: ");
		result.append(parameterName);
		result.append(", modifier__Parameter: ");
		result.append(modifier__Parameter);
		result.append(')');
		return result.toString();
	}

} //ParameterImpl