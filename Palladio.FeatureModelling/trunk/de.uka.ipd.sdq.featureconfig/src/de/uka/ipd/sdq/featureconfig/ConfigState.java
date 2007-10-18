/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Config State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage#getConfigState()
 * @model
 * @generated
 */
public enum ConfigState implements Enumerator {
	/**
	 * The '<em><b>USER SELECTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USER_SELECTED_VALUE
	 * @generated
	 * @ordered
	 */
	USER_SELECTED(0, "USER_SELECTED", "USER_SELECTED"),

	/**
	 * The '<em><b>USER ELIMINATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USER_ELIMINATED_VALUE
	 * @generated
	 * @ordered
	 */
	USER_ELIMINATED(1, "USER_ELIMINATED", "USER_ELIMINATED"),

	/**
	 * The '<em><b>MASCHINE SELECTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASCHINE_SELECTED_VALUE
	 * @generated
	 * @ordered
	 */
	MASCHINE_SELECTED(2, "MASCHINE_SELECTED", "MASCHINE_SELECTED"),

	/**
	 * The '<em><b>MASCHINE ELIMINATED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASCHINE_ELIMINATED_VALUE
	 * @generated
	 * @ordered
	 */
	MASCHINE_ELIMINATED(3, "MASCHINE_ELIMINATED", "MASCHINE_ELIMINATED"),

	/**
	 * The '<em><b>UNSET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSET_VALUE
	 * @generated
	 * @ordered
	 */
	UNSET(4, "UNSET", "UNSET");

	/**
	 * The '<em><b>USER SELECTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USER SELECTED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USER_SELECTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USER_SELECTED_VALUE = 0;

	/**
	 * The '<em><b>USER ELIMINATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USER ELIMINATED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USER_ELIMINATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USER_ELIMINATED_VALUE = 1;

	/**
	 * The '<em><b>MASCHINE SELECTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MASCHINE SELECTED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASCHINE_SELECTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MASCHINE_SELECTED_VALUE = 2;

	/**
	 * The '<em><b>MASCHINE ELIMINATED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MASCHINE ELIMINATED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASCHINE_ELIMINATED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MASCHINE_ELIMINATED_VALUE = 3;

	/**
	 * The '<em><b>UNSET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNSET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSET
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNSET_VALUE = 4;

	/**
	 * An array of all the '<em><b>Config State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ConfigState[] VALUES_ARRAY =
		new ConfigState[] {
			USER_SELECTED,
			USER_ELIMINATED,
			MASCHINE_SELECTED,
			MASCHINE_ELIMINATED,
			UNSET,
		};

	/**
	 * A public read-only list of all the '<em><b>Config State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ConfigState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Config State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConfigState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConfigState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Config State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConfigState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConfigState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Config State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConfigState get(int value) {
		switch (value) {
			case USER_SELECTED_VALUE: return USER_SELECTED;
			case USER_ELIMINATED_VALUE: return USER_ELIMINATED;
			case MASCHINE_SELECTED_VALUE: return MASCHINE_SELECTED;
			case MASCHINE_ELIMINATED_VALUE: return MASCHINE_ELIMINATED;
			case UNSET_VALUE: return UNSET;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ConfigState(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ConfigState
