/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Term Operations</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.stoex.StoexPackage#getTermOperations()
 * @model
 * @generated
 */
public final class TermOperations extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ, IPD, U Karlsruhe (TH)";

	/**
	 * The '<em><b>ADD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ADD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ADD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ADD = 0;

	/**
	 * The '<em><b>SUB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUB_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUB = 1;

	/**
	 * The '<em><b>ADD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ADD
	 * @generated
	 * @ordered
	 */
	public static final TermOperations ADD_LITERAL = new TermOperations(ADD, "ADD", "ADD");

	/**
	 * The '<em><b>SUB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUB
	 * @generated
	 * @ordered
	 */
	public static final TermOperations SUB_LITERAL = new TermOperations(SUB, "SUB", "SUB");

	/**
	 * An array of all the '<em><b>Term Operations</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TermOperations[] VALUES_ARRAY =
		new TermOperations[] {
			ADD_LITERAL,
			SUB_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Term Operations</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Term Operations</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TermOperations get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TermOperations result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Term Operations</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TermOperations getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TermOperations result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Term Operations</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TermOperations get(int value) {
		switch (value) {
			case ADD: return ADD_LITERAL;
			case SUB: return SUB_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TermOperations(int value, String name, String literal) {
		super(value, name, literal);
	}

} //TermOperations
