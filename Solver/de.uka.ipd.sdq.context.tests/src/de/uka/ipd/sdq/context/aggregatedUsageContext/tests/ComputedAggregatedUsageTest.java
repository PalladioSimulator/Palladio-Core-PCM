/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext.tests;

import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextFactory;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Computed Aggregated Usage</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputedAggregatedUsageTest extends TestCase {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The fixture for this Computed Aggregated Usage test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputedAggregatedUsage fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ComputedAggregatedUsageTest.class);
	}

	/**
	 * Constructs a new Computed Aggregated Usage test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedAggregatedUsageTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Computed Aggregated Usage test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ComputedAggregatedUsage fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Computed Aggregated Usage test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputedAggregatedUsage getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(AggregatedUsageContextFactory.eINSTANCE.createComputedAggregatedUsage());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ComputedAggregatedUsageTest
