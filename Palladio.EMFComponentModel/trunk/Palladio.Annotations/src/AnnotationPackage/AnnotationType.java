/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Annotation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see AnnotationPackage.AnnotationPackagePackage#getAnnotationType()
 * @model
 * @generated
 */
public final class AnnotationType extends AbstractEnumerator {
	/**
	 * The '<em><b>Description</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Description</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESCRIPTION_LITERAL
	 * @model name="description"
	 * @generated
	 * @ordered
	 */
	public static final int DESCRIPTION = 0;

	/**
	 * The '<em><b>Description</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DESCRIPTION
	 * @generated
	 * @ordered
	 */
	public static final AnnotationType DESCRIPTION_LITERAL = new AnnotationType(DESCRIPTION, "description", "description");

	/**
	 * An array of all the '<em><b>Annotation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AnnotationType[] VALUES_ARRAY =
		new AnnotationType[] {
			DESCRIPTION_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Annotation Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Annotation Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnnotationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AnnotationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Annotation Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnnotationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AnnotationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Annotation Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnnotationType get(int value) {
		switch (value) {
			case DESCRIPTION: return DESCRIPTION_LITERAL;
		}
		return null;	
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AnnotationType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //AnnotationType
