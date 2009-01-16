/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Persistence Kind Options</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getPersistenceKindOptions()
 * @model
 * @generated
 */
public enum PersistenceKindOptions implements Enumerator {
	/**
	 * The '<em><b>Binary Long</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY_LONG_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_LONG(0, "BinaryLong", "BinaryLong"),

	/**
	 * The '<em><b>Binary Double</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BINARY_DOUBLE_VALUE
	 * @generated
	 * @ordered
	 */
	BINARY_DOUBLE(1, "BinaryDouble", "BinaryDouble"),

	/**
	 * The '<em><b>Xml JScience</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XML_JSCIENCE_VALUE
	 * @generated
	 * @ordered
	 */
	XML_JSCIENCE(2, "XmlJScience", "XmlJScience"),

	/**
	 * The '<em><b>Emf</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EMF_VALUE
	 * @generated
	 * @ordered
	 */
	EMF(3, "Emf", "Emf");

	/**
	 * The '<em><b>Binary Long</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Binary Long</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BINARY_LONG
	 * @model name="BinaryLong"
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_LONG_VALUE = 0;

	/**
	 * The '<em><b>Binary Double</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Binary Double</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BINARY_DOUBLE
	 * @model name="BinaryDouble"
	 * @generated
	 * @ordered
	 */
	public static final int BINARY_DOUBLE_VALUE = 1;

	/**
	 * The '<em><b>Xml JScience</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Xml JScience</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XML_JSCIENCE
	 * @model name="XmlJScience"
	 * @generated
	 * @ordered
	 */
	public static final int XML_JSCIENCE_VALUE = 2;

	/**
	 * The '<em><b>Emf</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Emf</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EMF
	 * @model name="Emf"
	 * @generated
	 * @ordered
	 */
	public static final int EMF_VALUE = 3;

	/**
	 * An array of all the '<em><b>Persistence Kind Options</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PersistenceKindOptions[] VALUES_ARRAY =
		new PersistenceKindOptions[] {
			BINARY_LONG,
			BINARY_DOUBLE,
			XML_JSCIENCE,
			EMF,
		};

	/**
	 * A public read-only list of all the '<em><b>Persistence Kind Options</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PersistenceKindOptions> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Persistence Kind Options</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PersistenceKindOptions get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PersistenceKindOptions result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Persistence Kind Options</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PersistenceKindOptions getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PersistenceKindOptions result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Persistence Kind Options</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PersistenceKindOptions get(int value) {
		switch (value) {
			case BINARY_LONG_VALUE: return BINARY_LONG;
			case BINARY_DOUBLE_VALUE: return BINARY_DOUBLE;
			case XML_JSCIENCE_VALUE: return XML_JSCIENCE;
			case EMF_VALUE: return EMF;
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
	private PersistenceKindOptions(int value, String name, String literal) {
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
	
} //PersistenceKindOptions
