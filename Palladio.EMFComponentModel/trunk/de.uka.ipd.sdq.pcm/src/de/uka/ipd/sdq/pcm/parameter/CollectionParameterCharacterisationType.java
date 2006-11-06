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
 * A representation of the literals of the enumeration '<em><b>Collection Parameter Characterisation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getCollectionParameterCharacterisationType()
 * @model
 * @generated
 */
public final class CollectionParameterCharacterisationType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

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
	public static final int NUMBER_OF_ELEMENTS = 0;

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
	public static final int STRUCTURE = 1;

	/**
	 * The '<em><b>NUMBER OF ELEMENTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NUMBER_OF_ELEMENTS
	 * @generated
	 * @ordered
	 */
	public static final CollectionParameterCharacterisationType NUMBER_OF_ELEMENTS_LITERAL = new CollectionParameterCharacterisationType(NUMBER_OF_ELEMENTS, "NUMBER_OF_ELEMENTS", "NUMBER_OF_ELEMENTS");

	/**
	 * The '<em><b>STRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCTURE
	 * @generated
	 * @ordered
	 */
	public static final CollectionParameterCharacterisationType STRUCTURE_LITERAL = new CollectionParameterCharacterisationType(STRUCTURE, "STRUCTURE", "STRUCTURE");

	/**
	 * An array of all the '<em><b>Collection Parameter Characterisation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CollectionParameterCharacterisationType[] VALUES_ARRAY =
		new CollectionParameterCharacterisationType[] {
			NUMBER_OF_ELEMENTS_LITERAL,
			STRUCTURE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Collection Parameter Characterisation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Collection Parameter Characterisation Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionParameterCharacterisationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollectionParameterCharacterisationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Parameter Characterisation Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionParameterCharacterisationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollectionParameterCharacterisationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Parameter Characterisation Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionParameterCharacterisationType get(int value) {
		switch (value) {
			case NUMBER_OF_ELEMENTS: return NUMBER_OF_ELEMENTS_LITERAL;
			case STRUCTURE: return STRUCTURE_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CollectionParameterCharacterisationType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CollectionParameterCharacterisationType
