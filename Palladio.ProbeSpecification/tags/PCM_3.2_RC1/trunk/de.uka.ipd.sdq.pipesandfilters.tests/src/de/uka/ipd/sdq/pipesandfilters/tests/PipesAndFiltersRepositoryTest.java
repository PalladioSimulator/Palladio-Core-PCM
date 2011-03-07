/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters.tests;

import de.uka.ipd.sdq.pipesandfilters.PipesAndFiltersRepository;
import de.uka.ipd.sdq.pipesandfilters.pipesandfiltersFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Pipes And Filters Repository</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PipesAndFiltersRepositoryTest extends TestCase {

	/**
	 * The fixture for this Pipes And Filters Repository test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipesAndFiltersRepository fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PipesAndFiltersRepositoryTest.class);
	}

	/**
	 * Constructs a new Pipes And Filters Repository test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipesAndFiltersRepositoryTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Pipes And Filters Repository test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PipesAndFiltersRepository fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Pipes And Filters Repository test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipesAndFiltersRepository getFixture() {
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
		setFixture(pipesandfiltersFactory.eINSTANCE.createPipesAndFiltersRepository());
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

} //PipesAndFiltersRepositoryTest
