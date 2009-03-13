/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.tests;

import de.uka.ipd.sdq.ByBench.ByBenchFactory;
import de.uka.ipd.sdq.ByBench.InstructionChaining;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Instruction Chaining</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InstructionChainingTest extends SequenceElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InstructionChainingTest.class);
	}

	/**
	 * Constructs a new Instruction Chaining test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstructionChainingTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Instruction Chaining test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected InstructionChaining getFixture() {
		return (InstructionChaining)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ByBenchFactory.eINSTANCE.createInstructionChaining());
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

} //InstructionChainingTest
