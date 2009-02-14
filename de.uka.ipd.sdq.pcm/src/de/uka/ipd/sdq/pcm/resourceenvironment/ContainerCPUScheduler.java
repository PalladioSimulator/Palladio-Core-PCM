/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Container CPU Scheduler</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#getContainerCPUScheduler()
 * @model
 * @generated
 */
public enum ContainerCPUScheduler implements Enumerator {
	/**
	 * The '<em><b>ABSTRACT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABSTRACT_VALUE
	 * @generated
	 * @ordered
	 */
	ABSTRACT(0, "ABSTRACT", "ABSTRACT"), /**
	 * The '<em><b>WINDOWS2003</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WINDOWS2003_VALUE
	 * @generated
	 * @ordered
	 */
	WINDOWS2003(1, "WINDOWS2003", "WINDOWS2003"), /**
	 * The '<em><b>LINUX26</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINUX26_VALUE
	 * @generated
	 * @ordered
	 */
	LINUX26(2, "LINUX26", "LINUX26"), /**
	 * The '<em><b>WINXP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WINXP_VALUE
	 * @generated
	 * @ordered
	 */
	WINXP(3, "WINXP", "WINXP");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The '<em><b>ABSTRACT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ABSTRACT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ABSTRACT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACT_VALUE = 0;

	/**
	 * The '<em><b>WINDOWS2003</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WINDOWS2003</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WINDOWS2003
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WINDOWS2003_VALUE = 1;

	/**
	 * The '<em><b>LINUX26</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LINUX26</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LINUX26
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINUX26_VALUE = 2;

	/**
	 * The '<em><b>WINXP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WINXP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WINXP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WINXP_VALUE = 3;

	/**
	 * An array of all the '<em><b>Container CPU Scheduler</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ContainerCPUScheduler[] VALUES_ARRAY =
		new ContainerCPUScheduler[] {
			ABSTRACT,
			WINDOWS2003,
			LINUX26,
			WINXP,
		};

	/**
	 * A public read-only list of all the '<em><b>Container CPU Scheduler</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ContainerCPUScheduler> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Container CPU Scheduler</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContainerCPUScheduler get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ContainerCPUScheduler result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Container CPU Scheduler</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContainerCPUScheduler getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ContainerCPUScheduler result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Container CPU Scheduler</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContainerCPUScheduler get(int value) {
		switch (value) {
			case ABSTRACT_VALUE: return ABSTRACT;
			case WINDOWS2003_VALUE: return WINDOWS2003;
			case LINUX26_VALUE: return LINUX26;
			case WINXP_VALUE: return WINXP;
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
	private ContainerCPUScheduler(int value, String name, String literal) {
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
	
} //ContainerCPUScheduler
