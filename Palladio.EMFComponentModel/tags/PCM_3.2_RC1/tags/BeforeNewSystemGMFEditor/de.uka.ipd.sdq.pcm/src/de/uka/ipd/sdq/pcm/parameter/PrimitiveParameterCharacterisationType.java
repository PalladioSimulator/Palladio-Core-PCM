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
 * A representation of the literals of the enumeration '<em><b>Primitive Parameter Characterisation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getPrimitiveParameterCharacterisationType()
 * @model
 * @generated
 */
public final class PrimitiveParameterCharacterisationType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

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
	public static final int VALUE = 0;

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
	public static final int BYTESIZE = 1;

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
	public static final int DATATYPE = 2;

	/**
	 * The '<em><b>VALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALUE
	 * @generated
	 * @ordered
	 */
	public static final PrimitiveParameterCharacterisationType VALUE_LITERAL = new PrimitiveParameterCharacterisationType(VALUE, "VALUE", "VALUE");

	/**
	 * The '<em><b>BYTESIZE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BYTESIZE
	 * @generated
	 * @ordered
	 */
	public static final PrimitiveParameterCharacterisationType BYTESIZE_LITERAL = new PrimitiveParameterCharacterisationType(BYTESIZE, "BYTESIZE", "BYTESIZE");

	/**
	 * The '<em><b>DATATYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATATYPE
	 * @generated
	 * @ordered
	 */
	public static final PrimitiveParameterCharacterisationType DATATYPE_LITERAL = new PrimitiveParameterCharacterisationType(DATATYPE, "DATATYPE", "DATATYPE");

	/**
	 * An array of all the '<em><b>Primitive Parameter Characterisation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PrimitiveParameterCharacterisationType[] VALUES_ARRAY =
		new PrimitiveParameterCharacterisationType[] {
			VALUE_LITERAL,
			BYTESIZE_LITERAL,
			DATATYPE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Primitive Parameter Characterisation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Primitive Parameter Characterisation Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrimitiveParameterCharacterisationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PrimitiveParameterCharacterisationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Primitive Parameter Characterisation Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrimitiveParameterCharacterisationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PrimitiveParameterCharacterisationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Primitive Parameter Characterisation Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PrimitiveParameterCharacterisationType get(int value) {
		switch (value) {
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
	private PrimitiveParameterCharacterisationType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //PrimitiveParameterCharacterisationType
