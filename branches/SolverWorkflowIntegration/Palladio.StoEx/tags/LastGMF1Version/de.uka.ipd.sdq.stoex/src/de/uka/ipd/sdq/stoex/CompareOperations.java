/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Compare Operations</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.stoex.StoexPackage#getCompareOperations()
 * @model
 * @generated
 */
public final class CompareOperations extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ, IPD, U Karlsruhe (TH)";

	/**
	 * The '<em><b>GREATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GREATER = 0;

	/**
	 * The '<em><b>EQUALS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUALS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUALS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EQUALS = 1;

	/**
	 * The '<em><b>LESS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LESS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LESS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LESS = 2;

	/**
	 * The '<em><b>NOTEQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOTEQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOTEQUAL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTEQUAL = 3;

	/**
	 * The '<em><b>LESSEQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LESSEQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LESSEQUAL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LESSEQUAL = 4;

	/**
	 * The '<em><b>GREATEREQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREATEREQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATEREQUAL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GREATEREQUAL = 5;

	/**
	 * The '<em><b>GREATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER
	 * @generated
	 * @ordered
	 */
	public static final CompareOperations GREATER_LITERAL = new CompareOperations(GREATER, "GREATER", "GREATER");

	/**
	 * The '<em><b>EQUALS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUALS
	 * @generated
	 * @ordered
	 */
	public static final CompareOperations EQUALS_LITERAL = new CompareOperations(EQUALS, "EQUALS", "EQUALS");

	/**
	 * The '<em><b>LESS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LESS
	 * @generated
	 * @ordered
	 */
	public static final CompareOperations LESS_LITERAL = new CompareOperations(LESS, "LESS", "LESS");

	/**
	 * The '<em><b>NOTEQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTEQUAL
	 * @generated
	 * @ordered
	 */
	public static final CompareOperations NOTEQUAL_LITERAL = new CompareOperations(NOTEQUAL, "NOTEQUAL", "NOTEQUAL");

	/**
	 * The '<em><b>LESSEQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LESSEQUAL
	 * @generated
	 * @ordered
	 */
	public static final CompareOperations LESSEQUAL_LITERAL = new CompareOperations(LESSEQUAL, "LESSEQUAL", "LESSEQUAL");

	/**
	 * The '<em><b>GREATEREQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATEREQUAL
	 * @generated
	 * @ordered
	 */
	public static final CompareOperations GREATEREQUAL_LITERAL = new CompareOperations(GREATEREQUAL, "GREATEREQUAL", "GREATEREQUAL");

	/**
	 * An array of all the '<em><b>Compare Operations</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CompareOperations[] VALUES_ARRAY =
		new CompareOperations[] {
			GREATER_LITERAL,
			EQUALS_LITERAL,
			LESS_LITERAL,
			NOTEQUAL_LITERAL,
			LESSEQUAL_LITERAL,
			GREATEREQUAL_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Compare Operations</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Compare Operations</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompareOperations get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompareOperations result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Compare Operations</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompareOperations getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompareOperations result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Compare Operations</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompareOperations get(int value) {
		switch (value) {
			case GREATER: return GREATER_LITERAL;
			case EQUALS: return EQUALS_LITERAL;
			case LESS: return LESS_LITERAL;
			case NOTEQUAL: return NOTEQUAL_LITERAL;
			case LESSEQUAL: return LESSEQUAL_LITERAL;
			case GREATEREQUAL: return GREATEREQUAL_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CompareOperations(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CompareOperations
