/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Primitive Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getPrimitiveTypeEnum()
 * @model
 * @generated
 */
public final class PrimitiveTypeEnum extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The '<em><b>INT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INT = 0;

	/**
	 * The '<em><b>STRING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRING = 1;

	/**
	 * The '<em><b>BOOL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOOL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOOL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOOL = 2;

	/**
	 * The '<em><b>DOUBLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLE = 3;

	/**
	 * The '<em><b>CHAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHAR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHAR = 4;

	/**
	 * The '<em><b>BYTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BYTE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BYTE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BYTE = 5;

	/**
	 * The '<em><b>INT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INT
	 * @generated
	 * @ordered
	 */
	public static final PrimitiveTypeEnum INT_LITERAL = new PrimitiveTypeEnum(INT, "INT", "INT");

	/**
	 * The '<em><b>STRING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRING
	 * @generated
	 * @ordered
	 */
	public static final PrimitiveTypeEnum STRING_LITERAL = new PrimitiveTypeEnum(STRING, "STRING", "STRING");

	/**
	 * The '<em><b>BOOL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOL
	 * @generated
	 * @ordered
	 */
	public static final PrimitiveTypeEnum BOOL_LITERAL = new PrimitiveTypeEnum(BOOL, "BOOL", "BOOL");

	/**
	 * The '<em><b>DOUBLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLE
	 * @generated
	 * @ordered
	 */
	public static final PrimitiveTypeEnum DOUBLE_LITERAL = new PrimitiveTypeEnum(DOUBLE, "DOUBLE", "DOUBLE");

	/**
	 * The '<em><b>CHAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHAR
	 * @generated
	 * @ordered
	 */
	public static final PrimitiveTypeEnum CHAR_LITERAL = new PrimitiveTypeEnum(CHAR, "CHAR", "CHAR");

	/**
	 * The '<em><b>BYTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BYTE
	 * @generated
	 * @ordered
	 */
	public static final PrimitiveTypeEnum BYTE_LITERAL = new PrimitiveTypeEnum(BYTE, "BYTE", "BYTE");

	/**
	 * An array of all the '<em><b>Primitive Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PrimitiveTypeEnum[] VALUES_ARRAY =
		new PrimitiveTypeEnum[] {
			INT_LITERAL,
			STRING_LITERAL,
			BOOL_LITERAL,
			DOUBLE_LITERAL,
			CHAR_LITERAL,
			BYTE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Primitive Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Primitive Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrimitiveTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PrimitiveTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Primitive Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrimitiveTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PrimitiveTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Primitive Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrimitiveTypeEnum get(int value) {
		switch (value) {
			case INT: return INT_LITERAL;
			case STRING: return STRING_LITERAL;
			case BOOL: return BOOL_LITERAL;
			case DOUBLE: return DOUBLE_LITERAL;
			case CHAR: return CHAR_LITERAL;
			case BYTE: return BYTE_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private PrimitiveTypeEnum(int value, String name, String literal) {
		super(value, name, literal);
	}

} //PrimitiveTypeEnum
