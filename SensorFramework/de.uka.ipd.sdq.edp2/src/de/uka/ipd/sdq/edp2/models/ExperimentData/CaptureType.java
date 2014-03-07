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
 * A representation of the literals of the enumeration '<em><b>Capture Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Type of the captured data. E.g. if the data describes identifiers, integer numbers or real numbers.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getCaptureType()
 * @model
 * @generated
 */
public enum CaptureType implements Enumerator {
	/**
     * The '<em><b>Identifier</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #IDENTIFIER_VALUE
     * @generated
     * @ordered
     */
	IDENTIFIER(0, "Identifier", "Identifier"),

	/**
     * The '<em><b>Integer Number</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INTEGER_NUMBER_VALUE
     * @generated
     * @ordered
     */
	INTEGER_NUMBER(1, "IntegerNumber", "IntegerNumber"), /**
     * The '<em><b>Real Number</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #REAL_NUMBER_VALUE
     * @generated
     * @ordered
     */
	REAL_NUMBER(2, "RealNumber", "RealNumber");

	/**
     * The '<em><b>Identifier</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Identifier</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Identifiers are textual representations for different observable states. Examples are 'very bad', 'bad', 'okay', 'good',
     * 'very good' in a questionaire, 'red', 'yellow', 'green' for a traffic light.
     * <!-- end-model-doc -->
     * @see #IDENTIFIER
     * @model name="Identifier"
     * @generated
     * @ordered
     */
	public static final int IDENTIFIER_VALUE = 0;

	/**
     * The '<em><b>Integer Number</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * <p>
     *     Unlimited integer numbers can contain integers in the range of [-\infty, ..., -1, 0, 1, ... , +\infty].
     * </p>
     * <!-- end-model-doc -->
     * @see #INTEGER_NUMBER
     * @model name="IntegerNumber"
     * @generated
     * @ordered
     */
	public static final int INTEGER_NUMBER_VALUE = 1;

	/**
     * The '<em><b>Real Number</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Real Number</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Real numbers can contain any real number in the range of [-\infty, ..., 0, ..., +infty], e.g. -0.28796398424897234897.
     * <!-- end-model-doc -->
     * @see #REAL_NUMBER
     * @model name="RealNumber"
     * @generated
     * @ordered
     */
	public static final int REAL_NUMBER_VALUE = 2;

	/**
     * An array of all the '<em><b>Capture Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final CaptureType[] VALUES_ARRAY =
		new CaptureType[] {
            IDENTIFIER,
            INTEGER_NUMBER,
            REAL_NUMBER,
        };

	/**
     * A public read-only list of all the '<em><b>Capture Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<CaptureType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Capture Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static CaptureType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            CaptureType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Capture Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static CaptureType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            CaptureType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Capture Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static CaptureType get(int value) {
        switch (value) {
            case IDENTIFIER_VALUE: return IDENTIFIER;
            case INTEGER_NUMBER_VALUE: return INTEGER_NUMBER;
            case REAL_NUMBER_VALUE: return REAL_NUMBER;
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
	private CaptureType(int value, String name, String literal) {
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
	
} //CaptureType
