
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.stochastics.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage;
import de.uka.ipd.sdq.pcm.core.stochastics.Variable;

import de.uka.ipd.sdq.pcm.parameter.AbstractNamedReference;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.VariableImpl#getId_Variable <em>Id Variable</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.impl.VariableImpl#getCharacterisationType <em>Characterisation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableImpl extends AtomImpl implements Variable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getId_Variable() <em>Id Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId_Variable()
	 * @generated
	 * @ordered
	 */
	protected AbstractNamedReference id_Variable = null;


	/**
	 * The default value of the '{@link #getCharacterisationType() <em>Characterisation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterisationType()
	 * @generated
	 * @ordered
	 */
	protected static final VariableCharacterisationType CHARACTERISATION_TYPE_EDEFAULT = VariableCharacterisationType.STRUCTURE_LITERAL;

	/**
	 * The cached value of the '{@link #getCharacterisationType() <em>Characterisation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterisationType()
	 * @generated
	 * @ordered
	 */
	protected VariableCharacterisationType characterisationType = CHARACTERISATION_TYPE_EDEFAULT;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return StochasticsPackage.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNamedReference getId_Variable() {
		if (id_Variable != null && id_Variable.eIsProxy()) {
			InternalEObject oldId_Variable = (InternalEObject)id_Variable;
			id_Variable = (AbstractNamedReference)eResolveProxy(oldId_Variable);
			if (id_Variable != oldId_Variable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StochasticsPackage.VARIABLE__ID_VARIABLE, oldId_Variable, id_Variable));
			}
		}
		return id_Variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractNamedReference basicGetId_Variable() {
		return id_Variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId_Variable(AbstractNamedReference newId_Variable) {
		AbstractNamedReference oldId_Variable = id_Variable;
		id_Variable = newId_Variable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StochasticsPackage.VARIABLE__ID_VARIABLE, oldId_Variable, id_Variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCharacterisationType getCharacterisationType() {
		return characterisationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCharacterisationType(VariableCharacterisationType newCharacterisationType) {
		VariableCharacterisationType oldCharacterisationType = characterisationType;
		characterisationType = newCharacterisationType == null ? CHARACTERISATION_TYPE_EDEFAULT : newCharacterisationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StochasticsPackage.VARIABLE__CHARACTERISATION_TYPE, oldCharacterisationType, characterisationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StochasticsPackage.VARIABLE__ID_VARIABLE:
				if (resolve) return getId_Variable();
				return basicGetId_Variable();
			case StochasticsPackage.VARIABLE__CHARACTERISATION_TYPE:
				return getCharacterisationType();
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
			case StochasticsPackage.VARIABLE__ID_VARIABLE:
				setId_Variable((AbstractNamedReference)newValue);
				return;
			case StochasticsPackage.VARIABLE__CHARACTERISATION_TYPE:
				setCharacterisationType((VariableCharacterisationType)newValue);
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
			case StochasticsPackage.VARIABLE__ID_VARIABLE:
				setId_Variable((AbstractNamedReference)null);
				return;
			case StochasticsPackage.VARIABLE__CHARACTERISATION_TYPE:
				setCharacterisationType(CHARACTERISATION_TYPE_EDEFAULT);
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
			case StochasticsPackage.VARIABLE__ID_VARIABLE:
				return id_Variable != null;
			case StochasticsPackage.VARIABLE__CHARACTERISATION_TYPE:
				return characterisationType != CHARACTERISATION_TYPE_EDEFAULT;
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
		result.append(" (characterisationType: ");
		result.append(characterisationType);
		result.append(')');
		return result.toString();
	}

} //VariableImpl