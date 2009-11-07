/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.scheduler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Resource Strategy Demand</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.measurements.scheduler.schedulerPackage#getResourceStrategyDemand()
 * @model
 * @generated
 */
public enum ResourceStrategyDemand implements Enumerator {
	/**
	 * The '<em><b>Wait Demand</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WAIT_DEMAND_VALUE
	 * @generated
	 * @ordered
	 */
	WAIT_DEMAND(0, "WaitDemand", "WaitDemand"),

	/**
	 * The '<em><b>Mandelbrot Demand</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANDELBROT_DEMAND_VALUE
	 * @generated
	 * @ordered
	 */
	MANDELBROT_DEMAND(1, "MandelbrotDemand", "MandelbrotDemand"),

	/**
	 * The '<em><b>Fibonacci Demand</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIBONACCI_DEMAND_VALUE
	 * @generated
	 * @ordered
	 */
	FIBONACCI_DEMAND(2, "FibonacciDemand", "FibonacciDemand");

	/**
	 * The '<em><b>Wait Demand</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Wait Demand</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WAIT_DEMAND
	 * @model name="WaitDemand"
	 * @generated
	 * @ordered
	 */
	public static final int WAIT_DEMAND_VALUE = 0;

	/**
	 * The '<em><b>Mandelbrot Demand</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mandelbrot Demand</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MANDELBROT_DEMAND
	 * @model name="MandelbrotDemand"
	 * @generated
	 * @ordered
	 */
	public static final int MANDELBROT_DEMAND_VALUE = 1;

	/**
	 * The '<em><b>Fibonacci Demand</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fibonacci Demand</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIBONACCI_DEMAND
	 * @model name="FibonacciDemand"
	 * @generated
	 * @ordered
	 */
	public static final int FIBONACCI_DEMAND_VALUE = 2;

	/**
	 * An array of all the '<em><b>Resource Strategy Demand</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ResourceStrategyDemand[] VALUES_ARRAY =
		new ResourceStrategyDemand[] {
			WAIT_DEMAND,
			MANDELBROT_DEMAND,
			FIBONACCI_DEMAND,
		};

	/**
	 * A public read-only list of all the '<em><b>Resource Strategy Demand</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ResourceStrategyDemand> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Resource Strategy Demand</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourceStrategyDemand get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResourceStrategyDemand result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Resource Strategy Demand</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourceStrategyDemand getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ResourceStrategyDemand result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Resource Strategy Demand</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResourceStrategyDemand get(int value) {
		switch (value) {
			case WAIT_DEMAND_VALUE: return WAIT_DEMAND;
			case MANDELBROT_DEMAND_VALUE: return MANDELBROT_DEMAND;
			case FIBONACCI_DEMAND_VALUE: return FIBONACCI_DEMAND;
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
	private ResourceStrategyDemand(int value, String name, String literal) {
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
	
} //ResourceStrategyDemand
