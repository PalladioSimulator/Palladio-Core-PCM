/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Parameter Modifier</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Parameter modifiers like known from C#.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getParameterModifier()
 * @model
 * @generated
 */
public final class ParameterModifier extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The '<em><b>None</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Use this value if no parameter modifier shall be applied.
	 * <!-- end-model-doc -->
	 * @see #NONE_LITERAL
	 * @model name="none"
	 * @generated
	 * @ordered
	 */
	public static final int NONE = 0;

	/**
	 * The '<em><b>In</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "in" according to C# semantics
	 * <!-- end-model-doc -->
	 * @see #IN_LITERAL
	 * @model name="in"
	 * @generated
	 * @ordered
	 */
	public static final int IN = 1;

	/**
	 * The '<em><b>Out</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * "out" according to C# semantics
	 * <!-- end-model-doc -->
	 * @see #OUT_LITERAL
	 * @model name="out"
	 * @generated
	 * @ordered
	 */
	public static final int OUT = 2;

	/**
	 * The '<em><b>Inout</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ref" according to C# semantics
	 * <!-- end-model-doc -->
	 * @see #INOUT_LITERAL
	 * @model name="inout"
	 * @generated
	 * @ordered
	 */
	public static final int INOUT = 3;

	/**
	 * The '<em><b>None</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @generated
	 * @ordered
	 */
	public static final ParameterModifier NONE_LITERAL = new ParameterModifier(NONE, "none", "none");

	/**
	 * The '<em><b>In</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IN
	 * @generated
	 * @ordered
	 */
	public static final ParameterModifier IN_LITERAL = new ParameterModifier(IN, "in", "in");

	/**
	 * The '<em><b>Out</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUT
	 * @generated
	 * @ordered
	 */
	public static final ParameterModifier OUT_LITERAL = new ParameterModifier(OUT, "out", "out");

	/**
	 * The '<em><b>Inout</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INOUT
	 * @generated
	 * @ordered
	 */
	public static final ParameterModifier INOUT_LITERAL = new ParameterModifier(INOUT, "inout", "inout");

	/**
	 * An array of all the '<em><b>Parameter Modifier</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ParameterModifier[] VALUES_ARRAY =
		new ParameterModifier[] {
			NONE_LITERAL,
			IN_LITERAL,
			OUT_LITERAL,
			INOUT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Parameter Modifier</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Parameter Modifier</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParameterModifier get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ParameterModifier result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Parameter Modifier</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParameterModifier getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ParameterModifier result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Parameter Modifier</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ParameterModifier get(int value) {
		switch (value) {
			case NONE: return NONE_LITERAL;
			case IN: return IN_LITERAL;
			case OUT: return OUT_LITERAL;
			case INOUT: return INOUT_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ParameterModifier(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ParameterModifier
