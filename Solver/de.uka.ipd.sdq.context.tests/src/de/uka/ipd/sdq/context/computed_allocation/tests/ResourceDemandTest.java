/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_allocation.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory;
import de.uka.ipd.sdq.context.computed_allocation.ResourceDemand;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourceDemandTest extends TestCase {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The fixture for this Resource Demand test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDemand fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ResourceDemandTest.class);
	}

	/**
	 * Constructs a new Resource Demand test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Resource Demand test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ResourceDemand fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Resource Demand test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ResourceDemand getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(ComputedAllocationFactory.eINSTANCE.createResourceDemand());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //ResourceDemandTest
