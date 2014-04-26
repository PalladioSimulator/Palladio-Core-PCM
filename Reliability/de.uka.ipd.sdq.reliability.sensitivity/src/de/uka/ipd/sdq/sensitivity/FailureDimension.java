/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Failure Dimension</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Describes a dimension of failure types (software-induced, hardware-induced or network-induced).
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getFailureDimension()
 * @model
 * @generated
 */
public enum FailureDimension implements Enumerator {
	/**
     * The '<em><b>SOFTWARE</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #SOFTWARE_VALUE
     * @generated
     * @ordered
     */
	SOFTWARE(0, "SOFTWARE", "SOFTWARE"),

	/**
     * The '<em><b>HARDWARE</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #HARDWARE_VALUE
     * @generated
     * @ordered
     */
	HARDWARE(1, "HARDWARE", "HARDWARE"),

	/**
     * The '<em><b>NETWORK</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #NETWORK_VALUE
     * @generated
     * @ordered
     */
	NETWORK(2, "NETWORK", "NETWORK");

	/**
     * The '<em><b>SOFTWARE</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOFTWARE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #SOFTWARE
     * @model
     * @generated
     * @ordered
     */
	public static final int SOFTWARE_VALUE = 0;

	/**
     * The '<em><b>HARDWARE</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HARDWARE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #HARDWARE
     * @model
     * @generated
     * @ordered
     */
	public static final int HARDWARE_VALUE = 1;

	/**
     * The '<em><b>NETWORK</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NETWORK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #NETWORK
     * @model
     * @generated
     * @ordered
     */
	public static final int NETWORK_VALUE = 2;

	/**
     * An array of all the '<em><b>Failure Dimension</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final FailureDimension[] VALUES_ARRAY =
		new FailureDimension[] {
            SOFTWARE,
            HARDWARE,
            NETWORK,
        };

	/**
     * A public read-only list of all the '<em><b>Failure Dimension</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<FailureDimension> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Failure Dimension</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static FailureDimension get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            FailureDimension result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Failure Dimension</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static FailureDimension getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            FailureDimension result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Failure Dimension</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static FailureDimension get(int value) {
        switch (value) {
            case SOFTWARE_VALUE: return SOFTWARE;
            case HARDWARE_VALUE: return HARDWARE;
            case NETWORK_VALUE: return NETWORK;
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
	private FailureDimension(int value, String name, String literal) {
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
	
} //FailureDimension
