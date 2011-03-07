/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage.tests;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import de.uka.ipd.sdq.context.computed_allocation.tests.ComputedAllocationTests;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Context</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContextAllTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new ContextAllTests("Context Tests");
		suite.addTest(ComputedUsageTests.suite());
		suite.addTest(ComputedAllocationTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextAllTests(String name) {
		super(name);
	}

} //ContextAllTests
