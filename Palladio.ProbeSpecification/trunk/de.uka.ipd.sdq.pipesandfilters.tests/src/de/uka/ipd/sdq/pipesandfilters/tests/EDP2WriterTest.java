/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters.tests;

import de.uka.ipd.sdq.pipesandfilters.EDP2Writer;
import de.uka.ipd.sdq.pipesandfilters.pipesandfiltersFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>EDP2 Writer</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EDP2WriterTest extends WriterTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(EDP2WriterTest.class);
	}

	/**
	 * Constructs a new EDP2 Writer test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDP2WriterTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this EDP2 Writer test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EDP2Writer getFixture() {
		return (EDP2Writer)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(pipesandfiltersFactory.eINSTANCE.createEDP2Writer());
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

} //EDP2WriterTest
