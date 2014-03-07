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
 * A representation of the literals of the enumeration '<em><b>Data Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Kind of a data type. E.g. if it is quantitative or qualitative data.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getDataType()
 * @model
 * @generated
 */
public enum DataType implements Enumerator {
	/**
     * The '<em><b>Quantitative</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #QUANTITATIVE_VALUE
     * @generated
     * @ordered
     */
	QUANTITATIVE(0, "Quantitative", "Quantitative"),

	/**
     * The '<em><b>Qualitative</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #QUALITATIVE_VALUE
     * @generated
     * @ordered
     */
	QUALITATIVE(1, "Qualitative", "Qualitative");

	/**
     * The '<em><b>Quantitative</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Quantitative</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #QUANTITATIVE
     * @model name="Quantitative"
     * @generated
     * @ordered
     */
	public static final int QUANTITATIVE_VALUE = 0;

	/**
     * The '<em><b>Qualitative</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Qualitative</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #QUALITATIVE
     * @model name="Qualitative"
     * @generated
     * @ordered
     */
	public static final int QUALITATIVE_VALUE = 1;

	/**
     * An array of all the '<em><b>Data Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final DataType[] VALUES_ARRAY =
		new DataType[] {
            QUANTITATIVE,
            QUALITATIVE,
        };

	/**
     * A public read-only list of all the '<em><b>Data Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<DataType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Data Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static DataType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            DataType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Data Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static DataType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            DataType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Data Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static DataType get(int value) {
        switch (value) {
            case QUANTITATIVE_VALUE: return QUANTITATIVE;
            case QUALITATIVE_VALUE: return QUALITATIVE;
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
	private DataType(int value, String name, String literal) {
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
	
} //DataType
