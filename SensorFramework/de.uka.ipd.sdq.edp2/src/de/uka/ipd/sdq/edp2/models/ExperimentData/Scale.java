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
 * A representation of the literals of the enumeration '<em><b>Scale</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Mathematical scales.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage#getScale()
 * @model
 * @generated
 */
public enum Scale implements Enumerator {
	/**
     * The '<em><b>Nominal</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #NOMINAL_VALUE
     * @generated
     * @ordered
     */
	NOMINAL(0, "Nominal", "Nominal"),

	/**
     * The '<em><b>Ordinal</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #ORDINAL_VALUE
     * @generated
     * @ordered
     */
	ORDINAL(1, "Ordinal", "Ordinal"),

	/**
     * The '<em><b>Interval</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INTERVAL_VALUE
     * @generated
     * @ordered
     */
	INTERVAL(2, "Interval", "Interval"),

	/**
     * The '<em><b>Ratio</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #RATIO_VALUE
     * @generated
     * @ordered
     */
	RATIO(3, "Ratio", "Ratio");

	/**
     * The '<em><b>Nominal</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Supports an equality operation on one-to-one object basis. Often used in conjunction with categorized data. Supported mathematical operations: =/?. Mathematically, it is considered an unordered set.
     * 
     * For example, dots with the colors RED, BLUE, and PURPLE can be related to their color but nothing more can be said.
     * <!-- end-model-doc -->
     * @see #NOMINAL
     * @model name="Nominal"
     * @generated
     * @ordered
     */
	public static final int NOMINAL_VALUE = 0;

	/**
     * The '<em><b>Ordinal</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Supports&nbsp;an&nbsp;equality&nbsp;operation&nbsp;as&nbsp;well&nbsp;as&nbsp;a&nbsp;monotonic&nbsp;increasing&nbsp;order.&nbsp;Supported&nbsp;mathematical&nbsp;operations:&nbsp;=/?&nbsp;;&nbsp;&lt;/&gt;.&nbsp;Mathematically,&nbsp;it&nbsp;is&nbsp;considered&nbsp;an&nbsp;ordered&nbsp;set.<br />
     * <br />
     * For&nbsp;example,&nbsp;the&nbsp;rank&nbsp;of&nbsp;a&nbsp;sports&nbsp;team&nbsp;in&nbsp;a&nbsp;18-members&nbsp;league&nbsp;is&nbsp;on&nbsp;an&nbsp;ordinal&nbsp;scale.
     * However, the teams with the same difference in rank does not mean that&nbsp;the difference of their&nbsp;achievements or
     * performance is/was equal.
     * <!-- end-model-doc -->
     * @see #ORDINAL
     * @model name="Ordinal"
     * @generated
     * @ordered
     */
	public static final int ORDINAL_VALUE = 1;

	/**
     * The '<em><b>Interval</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Supports the same as the ordinal scale but the magnitude of the difference between two values is comparable. Values can be negative. Supported mathematical operations: =/? ; </> ; +/? . Mathematically, it is considered an affine space or line.
     * 
     * For example, the temperature in degress Celcius is an interval measure. If you have two temperatures you can quantify the difference.
     * <!-- end-model-doc -->
     * @see #INTERVAL
     * @model name="Interval"
     * @generated
     * @ordered
     */
	public static final int INTERVAL_VALUE = 2;

	/**
     * The '<em><b>Ratio</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Supports the same as an interval scale and additionally has an non-abitrary zero-point. Supported mathematical operations: =/? ; </> ; +/? ; ?/?. Mathematically, it is considered a field.
     * 
     * For example, the temperature in degress Fahrenheit is a ratio scale. It's zero point is non arbitrary as the particles which comprise matter at this temperature have zero kinetic energy.
     * <!-- end-model-doc -->
     * @see #RATIO
     * @model name="Ratio"
     * @generated
     * @ordered
     */
	public static final int RATIO_VALUE = 3;

	/**
     * An array of all the '<em><b>Scale</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final Scale[] VALUES_ARRAY =
		new Scale[] {
            NOMINAL,
            ORDINAL,
            INTERVAL,
            RATIO,
        };

	/**
     * A public read-only list of all the '<em><b>Scale</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<Scale> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>Scale</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static Scale get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            Scale result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Scale</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static Scale getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            Scale result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>Scale</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static Scale get(int value) {
        switch (value) {
            case NOMINAL_VALUE: return NOMINAL;
            case ORDINAL_VALUE: return ORDINAL;
            case INTERVAL_VALUE: return INTERVAL;
            case RATIO_VALUE: return RATIO;
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
	private Scale(int value, String name, String literal) {
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
	
} //Scale
