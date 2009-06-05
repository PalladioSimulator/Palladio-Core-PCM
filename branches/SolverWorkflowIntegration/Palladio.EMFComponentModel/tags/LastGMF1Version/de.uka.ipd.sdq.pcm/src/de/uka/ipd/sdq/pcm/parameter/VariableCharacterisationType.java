/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Variable Characterisation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableCharacterisationType()
 * @model
 * @generated
 */
public final class VariableCharacterisationType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The '<em><b>STRUCTURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRUCTURE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRUCTURE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRUCTURE = 0;

	/**
	 * The '<em><b>NUMBER OF ELEMENTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NUMBER OF ELEMENTS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NUMBER_OF_ELEMENTS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NUMBER_OF_ELEMENTS = 1;

	/**
	 * The '<em><b>VALUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VALUE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VALUE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VALUE = 2;

	/**
	 * The '<em><b>BYTESIZE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BYTESIZE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BYTESIZE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BYTESIZE = 3;

	/**
	 * The '<em><b>DATATYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATATYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATATYPE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATATYPE = 4;

	/**
	 * The '<em><b>STRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCTURE
	 * @generated
	 * @ordered
	 */
	public static final VariableCharacterisationType STRUCTURE_LITERAL = new VariableCharacterisationType(STRUCTURE, "STRUCTURE", "STRUCTURE");

	/**
	 * The '<em><b>NUMBER OF ELEMENTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NUMBER_OF_ELEMENTS
	 * @generated
	 * @ordered
	 */
	public static final VariableCharacterisationType NUMBER_OF_ELEMENTS_LITERAL = new VariableCharacterisationType(NUMBER_OF_ELEMENTS, "NUMBER_OF_ELEMENTS", "NUMBER_OF_ELEMENTS");

	/**
	 * The '<em><b>VALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE
	 * @generated
	 * @ordered
	 */
	public static final VariableCharacterisationType VALUE_LITERAL = new VariableCharacterisationType(VALUE, "VALUE", "VALUE");

	/**
	 * The '<em><b>BYTESIZE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BYTESIZE
	 * @generated
	 * @ordered
	 */
	public static final VariableCharacterisationType BYTESIZE_LITERAL = new VariableCharacterisationType(BYTESIZE, "BYTESIZE", "BYTESIZE");

	/**
	 * The '<em><b>DATATYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATATYPE
	 * @generated
	 * @ordered
	 */
	public static final VariableCharacterisationType DATATYPE_LITERAL = new VariableCharacterisationType(DATATYPE, "DATATYPE", "DATATYPE");

	/**
	 * An array of all the '<em><b>Variable Characterisation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VariableCharacterisationType[] VALUES_ARRAY =
		new VariableCharacterisationType[] {
			STRUCTURE_LITERAL,
			NUMBER_OF_ELEMENTS_LITERAL,
			VALUE_LITERAL,
			BYTESIZE_LITERAL,
			DATATYPE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Variable Characterisation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Variable Characterisation Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableCharacterisationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariableCharacterisationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variable Characterisation Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableCharacterisationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VariableCharacterisationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Variable Characterisation Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VariableCharacterisationType get(int value) {
		switch (value) {
			case STRUCTURE: return STRUCTURE_LITERAL;
			case NUMBER_OF_ELEMENTS: return NUMBER_OF_ELEMENTS_LITERAL;
			case VALUE: return VALUE_LITERAL;
			case BYTESIZE: return BYTESIZE_LITERAL;
			case DATATYPE: return DATATYPE_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private VariableCharacterisationType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //VariableCharacterisationType
