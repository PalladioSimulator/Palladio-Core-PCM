/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results;

import de.fzi.se.validation.testbased.trace.ExecutionTrace;

import de.uka.ipd.sdq.identifier.Identifier;

import edu.kit.ipd.sdq.bycounter.output.MeasurementRun;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Run Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Protocol of a validation run.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.results.RunProtocol#getValidationFailureNotices <em>Validation Failure Notices</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.RunProtocol#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.RunProtocol#getRandomSeed <em>Random Seed</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.RunProtocol#isValidationSuccessful <em>Validation Successful</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.RunProtocol#getInvalidMeasurementResults <em>Invalid Measurement Results</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.RunProtocol#getInvalidTraces <em>Invalid Traces</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getRunProtocol()
 * @model
 * @generated
 */
public interface RunProtocol extends Identifier {
	/**
	 * Returns the value of the '<em><b>Validation Failure Notices</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.validation.testbased.results.ValidationFailureNotice}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.validation.testbased.results.ValidationFailureNotice#getRunProtocol <em>Run Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validation Failure Notices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validation Failure Notices</em>' containment reference list.
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getRunProtocol_ValidationFailureNotices()
	 * @see de.fzi.se.validation.testbased.results.ValidationFailureNotice#getRunProtocol
	 * @model opposite="runProtocol" containment="true" ordered="false"
	 * @generated
	 */
	EList<ValidationFailureNotice> getValidationFailureNotices();

	/**
	 * Returns the value of the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     Instant when the protocol was created.
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Creation Time</em>' attribute.
	 * @see #setCreationTime(Date)
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getRunProtocol_CreationTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Date getCreationTime();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.results.RunProtocol#getCreationTime <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Time</em>' attribute.
	 * @see #getCreationTime()
	 * @generated
	 */
	void setCreationTime(Date value);

	/**
	 * Returns the value of the '<em><b>Random Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Initial seed for the random number generator. Important for reproducability as it allows to ensure that two runs of the
	 * same validation have the same parameters. Allows verifying the validation result.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Random Seed</em>' attribute.
	 * @see #setRandomSeed(long)
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getRunProtocol_RandomSeed()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getRandomSeed();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.results.RunProtocol#getRandomSeed <em>Random Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Random Seed</em>' attribute.
	 * @see #getRandomSeed()
	 * @generated
	 */
	void setRandomSeed(long value);

	/**
	 * Returns the value of the '<em><b>Validation Successful</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validation Successful</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validation Successful</em>' attribute.
	 * @see #setValidationSuccessful(boolean)
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getRunProtocol_ValidationSuccessful()
	 * @model default="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isValidationSuccessful();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.results.RunProtocol#isValidationSuccessful <em>Validation Successful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Successful</em>' attribute.
	 * @see #isValidationSuccessful()
	 * @generated
	 */
	void setValidationSuccessful(boolean value);

	/**
	 * Returns the value of the '<em><b>Invalid Measurement Results</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.bycounter.output.MeasurementRun}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invalid Measurement Results</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invalid Measurement Results</em>' containment reference list.
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getRunProtocol_InvalidMeasurementResults()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MeasurementRun> getInvalidMeasurementResults();

	/**
	 * Returns the value of the '<em><b>Invalid Traces</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.validation.testbased.trace.ExecutionTrace}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.validation.testbased.trace.ExecutionTrace#getRunProtocol <em>Run Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invalid Traces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invalid Traces</em>' containment reference list.
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getRunProtocol_InvalidTraces()
	 * @see de.fzi.se.validation.testbased.trace.ExecutionTrace#getRunProtocol
	 * @model opposite="runProtocol" containment="true" ordered="false"
	 * @generated
	 */
	EList<ExecutionTrace> getInvalidTraces();

} // RunProtocol
