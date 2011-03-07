/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Load Balancing Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see scheduler.configuration.ConfigurationPackage#getLoadBalancingType()
 * @model
 * @generated
 */
public enum LoadBalancingType implements Enumerator {
	/**
	 * The '<em><b>IDLE TO ONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IDLE_TO_ONE_VALUE
	 * @generated
	 * @ordered
	 */
	IDLE_TO_ONE(0, "IDLE_TO_ONE", "IDLE_TO_ONE"),

	/**
	 * The '<em><b>IDLE TO THRESHOLD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IDLE_TO_THRESHOLD_VALUE
	 * @generated
	 * @ordered
	 */
	IDLE_TO_THRESHOLD(1, "IDLE_TO_THRESHOLD", "IDLE_TO_THRESHOLD"),

	/**
	 * The '<em><b>ANY TO THRESHOLD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANY_TO_THRESHOLD_VALUE
	 * @generated
	 * @ordered
	 */
	ANY_TO_THRESHOLD(2, "ANY_TO_THRESHOLD", "ANY_TO_THRESHOLD");

	/**
	 * The '<em><b>IDLE TO ONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IDLE TO ONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IDLE_TO_ONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IDLE_TO_ONE_VALUE = 0;

	/**
	 * The '<em><b>IDLE TO THRESHOLD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IDLE TO THRESHOLD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IDLE_TO_THRESHOLD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IDLE_TO_THRESHOLD_VALUE = 1;

	/**
	 * The '<em><b>ANY TO THRESHOLD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANY TO THRESHOLD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANY_TO_THRESHOLD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANY_TO_THRESHOLD_VALUE = 2;

	/**
	 * An array of all the '<em><b>Load Balancing Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final LoadBalancingType[] VALUES_ARRAY =
		new LoadBalancingType[] {
			IDLE_TO_ONE,
			IDLE_TO_THRESHOLD,
			ANY_TO_THRESHOLD,
		};

	/**
	 * A public read-only list of all the '<em><b>Load Balancing Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<LoadBalancingType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Load Balancing Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LoadBalancingType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LoadBalancingType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Load Balancing Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LoadBalancingType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LoadBalancingType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Load Balancing Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LoadBalancingType get(int value) {
		switch (value) {
			case IDLE_TO_ONE_VALUE: return IDLE_TO_ONE;
			case IDLE_TO_THRESHOLD_VALUE: return IDLE_TO_THRESHOLD;
			case ANY_TO_THRESHOLD_VALUE: return ANY_TO_THRESHOLD;
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
	private LoadBalancingType(int value, String name, String literal) {
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
	
} //LoadBalancingType
