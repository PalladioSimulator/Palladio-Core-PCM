/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.markov;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '
 * <em><b>State Type</b></em>', and utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.markov.MarkovPackage#getStateType()
 * @model
 * @generated
 */
public enum StateType implements Enumerator {
    /**
     * The '<em><b>Default</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #DEFAULT_VALUE
     * @generated
     * @ordered
     */
    DEFAULT(0, "Default", "Default"),

    /**
     * The '<em><b>Start</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #START_VALUE
     * @generated
     * @ordered
     */
    START(1, "Start", "Start"),

    /**
     * The '<em><b>Success</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #SUCCESS_VALUE
     * @generated
     * @ordered
     */
    SUCCESS(2, "Success", "Success"),

    /**
     * The '<em><b>Failure</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #FAILURE_VALUE
     * @generated
     * @ordered
     */
    FAILURE(3, "Failure", "Failure");

    /**
     * The '<em><b>Default</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Default</b></em>' literal object isn't clear, there really should
     * be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #DEFAULT
     * @model name="Default"
     * @generated
     * @ordered
     */
    public static final int DEFAULT_VALUE = 0;

    /**
     * The '<em><b>Start</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Start</b></em>' literal object isn't clear, there really should be
     * more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #START
     * @model name="Start"
     * @generated
     * @ordered
     */
    public static final int START_VALUE = 1;

    /**
     * The '<em><b>Success</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Success</b></em>' literal object isn't clear, there really should
     * be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #SUCCESS
     * @model name="Success"
     * @generated
     * @ordered
     */
    public static final int SUCCESS_VALUE = 2;

    /**
     * The '<em><b>Failure</b></em>' literal value. <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>Failure</b></em>' literal object isn't clear, there really should
     * be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @see #FAILURE
     * @model name="Failure"
     * @generated
     * @ordered
     */
    public static final int FAILURE_VALUE = 3;

    /**
     * An array of all the '<em><b>State Type</b></em>' enumerators. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    private static final StateType[] VALUES_ARRAY = new StateType[] {
            DEFAULT, START, SUCCESS, FAILURE,
    };

    /**
     * A public read-only list of all the '<em><b>State Type</b></em>' enumerators. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List<StateType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>State Type</b></em>' literal with the specified literal value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static StateType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            StateType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>State Type</b></em>' literal with the specified name. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static StateType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            StateType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>State Type</b></em>' literal with the specified integer value. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static StateType get(int value) {
        switch (value) {
        case DEFAULT_VALUE:
            return DEFAULT;
        case START_VALUE:
            return START;
        case SUCCESS_VALUE:
            return SUCCESS;
        case FAILURE_VALUE:
            return FAILURE;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private StateType(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public int getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }

} // StateType
