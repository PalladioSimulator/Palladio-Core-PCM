/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Persistence Kind Options</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getPersistenceKindOptions()
 * @model
 * @generated
 */
public enum PersistenceKindOptions implements Enumerator {
	/**
     * The '<em><b>Binary Preferred</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #BINARY_PREFERRED_VALUE
     * @generated
     * @ordered
     */
	BINARY_PREFERRED(0, "BinaryPreferred", "BinaryPreferred"), /**
     * The '<em><b>JS Xml Preferred</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #JS_XML_PREFERRED_VALUE
     * @generated
     * @ordered
     */
	JS_XML_PREFERRED(1, "JSXmlPreferred", "JSXmlPreferred");

	/**
     * The '<em><b>Binary Preferred</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Binary Preferred</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #BINARY_PREFERRED
     * @model name="BinaryPreferred"
     * @generated
     * @ordered
     */
	public static final int BINARY_PREFERRED_VALUE = 0;

	/**
     * The '<em><b>JS Xml Preferred</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JS Xml Preferred</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #JS_XML_PREFERRED
     * @model name="JSXmlPreferred"
     * @generated
     * @ordered
     */
	public static final int JS_XML_PREFERRED_VALUE = 1;

	/**
     * An array of all the '<em><b>Persistence Kind Options</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final PersistenceKindOptions[] VALUES_ARRAY =
		new PersistenceKindOptions[] {
            BINARY_PREFERRED,
            JS_XML_PREFERRED,
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
            case BINARY_PREFERRED_VALUE: return BINARY_PREFERRED;
            case JS_XML_PREFERRED_VALUE: return JS_XML_PREFERRED;
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
