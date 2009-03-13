/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.tests;

import de.uka.ipd.sdq.ByBench.ByBenchFactory;
import de.uka.ipd.sdq.ByBench.InstructionSequence;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Instruction Sequence</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class InstructionSequenceTest extends TestCase {

	/**
	 * The fixture for this Instruction Sequence test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstructionSequence fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(InstructionSequenceTest.class);
	}

	/**
	 * Constructs a new Instruction Sequence test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstructionSequenceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Instruction Sequence test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(InstructionSequence fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Instruction Sequence test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstructionSequence getFixture() {
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
		setFixture(ByBenchFactory.eINSTANCE.createInstructionSequence());
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

} //InstructionSequenceTest
