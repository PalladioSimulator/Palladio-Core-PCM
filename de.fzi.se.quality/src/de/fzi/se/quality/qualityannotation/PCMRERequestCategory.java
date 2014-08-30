/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>PCMRE Request Category</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.fzi.se.quality.qualityannotation.QualityAnnotationPackage#getPCMRERequestCategory()
 * @model
 * @generated
 */
public enum PCMRERequestCategory implements Enumerator {
	/**
     * The '<em><b>Resource</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #RESOURCE_VALUE
     * @generated
     * @ordered
     */
	RESOURCE(1, "Resource", "Resource"),

	/**
     * The '<em><b>Infrastructure</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #INFRASTRUCTURE_VALUE
     * @generated
     * @ordered
     */
	INFRASTRUCTURE(2, "Infrastructure", "Infrastructure"),

	/**
     * The '<em><b>Component</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #COMPONENT_VALUE
     * @generated
     * @ordered
     */
	COMPONENT(3, "Component", "Component"),

	/**
     * The '<em><b>Resource Demand</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #RESOURCE_DEMAND_VALUE
     * @generated
     * @ordered
     */
	RESOURCE_DEMAND(4, "ResourceDemand", "ResourceDemand"),

	/**
     * The '<em><b>Component Internal</b></em>' literal object.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #COMPONENT_INTERNAL_VALUE
     * @generated
     * @ordered
     */
	COMPONENT_INTERNAL(5, "ComponentInternal", "ComponentInternal");

	/**
     * The '<em><b>Resource</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Resource</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #RESOURCE
     * @model name="Resource"
     * @generated
     * @ordered
     */
	public static final int RESOURCE_VALUE = 1;

	/**
     * The '<em><b>Infrastructure</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Infrastructure</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #INFRASTRUCTURE
     * @model name="Infrastructure"
     * @generated
     * @ordered
     */
	public static final int INFRASTRUCTURE_VALUE = 2;

	/**
     * The '<em><b>Component</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Component</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #COMPONENT
     * @model name="Component"
     * @generated
     * @ordered
     */
	public static final int COMPONENT_VALUE = 3;

	/**
     * The '<em><b>Resource Demand</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Resource Demand</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #RESOURCE_DEMAND
     * @model name="ResourceDemand"
     * @generated
     * @ordered
     */
	public static final int RESOURCE_DEMAND_VALUE = 4;

	/**
     * The '<em><b>Component Internal</b></em>' literal value.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Component Internal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @see #COMPONENT_INTERNAL
     * @model name="ComponentInternal"
     * @generated
     * @ordered
     */
	public static final int COMPONENT_INTERNAL_VALUE = 5;

	/**
     * An array of all the '<em><b>PCMRE Request Category</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private static final PCMRERequestCategory[] VALUES_ARRAY =
		new PCMRERequestCategory[] {
            RESOURCE,
            INFRASTRUCTURE,
            COMPONENT,
            RESOURCE_DEMAND,
            COMPONENT_INTERNAL,
        };

	/**
     * A public read-only list of all the '<em><b>PCMRE Request Category</b></em>' enumerators.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final List<PCMRERequestCategory> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
     * Returns the '<em><b>PCMRE Request Category</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static PCMRERequestCategory get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PCMRERequestCategory result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>PCMRE Request Category</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static PCMRERequestCategory getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PCMRERequestCategory result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

	/**
     * Returns the '<em><b>PCMRE Request Category</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static PCMRERequestCategory get(int value) {
        switch (value) {
            case RESOURCE_VALUE: return RESOURCE;
            case INFRASTRUCTURE_VALUE: return INFRASTRUCTURE;
            case COMPONENT_VALUE: return COMPONENT;
            case RESOURCE_DEMAND_VALUE: return RESOURCE_DEMAND;
            case COMPONENT_INTERNAL_VALUE: return COMPONENT_INTERNAL;
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
	private PCMRERequestCategory(int value, String name, String literal) {
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
	
} //PCMRERequestCategory
