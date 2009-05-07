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
 * A representation of the literals of the enumeration '<em><b>Process Selection</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see scheduler.configuration.ConfigurationPackage#getProcessSelection()
 * @model
 * @generated
 */
public enum ProcessSelection implements Enumerator {
	/**
	 * The '<em><b>PREFER IDEAL AND LAST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PREFER_IDEAL_AND_LAST_VALUE
	 * @generated
	 * @ordered
	 */
	PREFER_IDEAL_AND_LAST(0, "PREFER_IDEAL_AND_LAST", "PREFER_IDEAL_AND_LAST"),

	/**
	 * The '<em><b>NEXT RUNNABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NEXT_RUNNABLE_VALUE
	 * @generated
	 * @ordered
	 */
	NEXT_RUNNABLE(1, "NEXT_RUNNABLE", "NEXT_RUNNABLE");

	/**
	 * The '<em><b>PREFER IDEAL AND LAST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PREFER IDEAL AND LAST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PREFER_IDEAL_AND_LAST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PREFER_IDEAL_AND_LAST_VALUE = 0;

	/**
	 * The '<em><b>NEXT RUNNABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NEXT RUNNABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NEXT_RUNNABLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NEXT_RUNNABLE_VALUE = 1;

	/**
	 * An array of all the '<em><b>Process Selection</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ProcessSelection[] VALUES_ARRAY =
		new ProcessSelection[] {
			PREFER_IDEAL_AND_LAST,
			NEXT_RUNNABLE,
		};

	/**
	 * A public read-only list of all the '<em><b>Process Selection</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ProcessSelection> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Process Selection</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProcessSelection get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProcessSelection result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Process Selection</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProcessSelection getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProcessSelection result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Process Selection</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProcessSelection get(int value) {
		switch (value) {
			case PREFER_IDEAL_AND_LAST_VALUE: return PREFER_IDEAL_AND_LAST;
			case NEXT_RUNNABLE_VALUE: return NEXT_RUNNABLE;
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
	private ProcessSelection(int value, String name, String literal) {
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
	
} //ProcessSelection
