/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.tests;

import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.LinkingResourceResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.resourceenvironmentdecoratorFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Linking Resource Results</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LinkingResourceResultsTest extends UtilisationResultTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LinkingResourceResultsTest.class);
	}

	/**
	 * Constructs a new Linking Resource Results test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkingResourceResultsTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Linking Resource Results test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected LinkingResourceResults getFixture() {
		return (LinkingResourceResults)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(resourceenvironmentdecoratorFactory.eINSTANCE.createLinkingResourceResults());
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

} //LinkingResourceResultsTest
