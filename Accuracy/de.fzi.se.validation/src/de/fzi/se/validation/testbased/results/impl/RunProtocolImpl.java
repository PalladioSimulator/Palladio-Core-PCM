/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results.impl;

import de.fzi.se.validation.testbased.results.ResultsPackage;
import de.fzi.se.validation.testbased.results.RunProtocol;
import de.fzi.se.validation.testbased.results.ValidationFailureNotice;

import de.fzi.se.validation.testbased.trace.ExecutionTrace;
import de.fzi.se.validation.testbased.trace.TracePackage;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import edu.kit.ipd.sdq.bycounter.output.MeasurementRun;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Run Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.RunProtocolImpl#getValidationFailureNotices <em>Validation Failure Notices</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.RunProtocolImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.RunProtocolImpl#getRandomSeed <em>Random Seed</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.RunProtocolImpl#isValidationSuccessful <em>Validation Successful</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.RunProtocolImpl#getInvalidMeasurementResults <em>Invalid Measurement Results</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.RunProtocolImpl#getInvalidTraces <em>Invalid Traces</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RunProtocolImpl extends IdentifierImpl implements RunProtocol {
	/**
	 * The cached value of the '{@link #getValidationFailureNotices() <em>Validation Failure Notices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationFailureNotices()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidationFailureNotice> validationFailureNotices;

	/**
	 * The default value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATION_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected Date creationTime = CREATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRandomSeed() <em>Random Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRandomSeed()
	 * @generated
	 * @ordered
	 */
	protected static final long RANDOM_SEED_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getRandomSeed() <em>Random Seed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRandomSeed()
	 * @generated
	 * @ordered
	 */
	protected long randomSeed = RANDOM_SEED_EDEFAULT;

	/**
	 * The default value of the '{@link #isValidationSuccessful() <em>Validation Successful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidationSuccessful()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALIDATION_SUCCESSFUL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValidationSuccessful() <em>Validation Successful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValidationSuccessful()
	 * @generated
	 * @ordered
	 */
	protected boolean validationSuccessful = VALIDATION_SUCCESSFUL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInvalidMeasurementResults() <em>Invalid Measurement Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvalidMeasurementResults()
	 * @generated
	 * @ordered
	 */
	protected EList<MeasurementRun> invalidMeasurementResults;

	/**
	 * The cached value of the '{@link #getInvalidTraces() <em>Invalid Traces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvalidTraces()
	 * @generated
	 * @ordered
	 */
	protected EList<ExecutionTrace> invalidTraces;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RunProtocolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultsPackage.Literals.RUN_PROTOCOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValidationFailureNotice> getValidationFailureNotices() {
		if (validationFailureNotices == null) {
			validationFailureNotices = new EObjectContainmentWithInverseEList<ValidationFailureNotice>(ValidationFailureNotice.class, this, ResultsPackage.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES, ResultsPackage.VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL);
		}
		return validationFailureNotices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationTime(Date newCreationTime) {
		Date oldCreationTime = creationTime;
		creationTime = newCreationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RUN_PROTOCOL__CREATION_TIME, oldCreationTime, creationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getRandomSeed() {
		return randomSeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRandomSeed(long newRandomSeed) {
		long oldRandomSeed = randomSeed;
		randomSeed = newRandomSeed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RUN_PROTOCOL__RANDOM_SEED, oldRandomSeed, randomSeed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValidationSuccessful() {
		return validationSuccessful;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValidationSuccessful(boolean newValidationSuccessful) {
		boolean oldValidationSuccessful = validationSuccessful;
		validationSuccessful = newValidationSuccessful;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.RUN_PROTOCOL__VALIDATION_SUCCESSFUL, oldValidationSuccessful, validationSuccessful));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MeasurementRun> getInvalidMeasurementResults() {
		if (invalidMeasurementResults == null) {
			invalidMeasurementResults = new EObjectContainmentEList<MeasurementRun>(MeasurementRun.class, this, ResultsPackage.RUN_PROTOCOL__INVALID_MEASUREMENT_RESULTS);
		}
		return invalidMeasurementResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExecutionTrace> getInvalidTraces() {
		if (invalidTraces == null) {
			invalidTraces = new EObjectContainmentWithInverseEList<ExecutionTrace>(ExecutionTrace.class, this, ResultsPackage.RUN_PROTOCOL__INVALID_TRACES, TracePackage.EXECUTION_TRACE__RUN_PROTOCOL);
		}
		return invalidTraces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultsPackage.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getValidationFailureNotices()).basicAdd(otherEnd, msgs);
			case ResultsPackage.RUN_PROTOCOL__INVALID_TRACES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInvalidTraces()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultsPackage.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES:
				return ((InternalEList<?>)getValidationFailureNotices()).basicRemove(otherEnd, msgs);
			case ResultsPackage.RUN_PROTOCOL__INVALID_MEASUREMENT_RESULTS:
				return ((InternalEList<?>)getInvalidMeasurementResults()).basicRemove(otherEnd, msgs);
			case ResultsPackage.RUN_PROTOCOL__INVALID_TRACES:
				return ((InternalEList<?>)getInvalidTraces()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResultsPackage.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES:
				return getValidationFailureNotices();
			case ResultsPackage.RUN_PROTOCOL__CREATION_TIME:
				return getCreationTime();
			case ResultsPackage.RUN_PROTOCOL__RANDOM_SEED:
				return getRandomSeed();
			case ResultsPackage.RUN_PROTOCOL__VALIDATION_SUCCESSFUL:
				return isValidationSuccessful();
			case ResultsPackage.RUN_PROTOCOL__INVALID_MEASUREMENT_RESULTS:
				return getInvalidMeasurementResults();
			case ResultsPackage.RUN_PROTOCOL__INVALID_TRACES:
				return getInvalidTraces();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResultsPackage.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES:
				getValidationFailureNotices().clear();
				getValidationFailureNotices().addAll((Collection<? extends ValidationFailureNotice>)newValue);
				return;
			case ResultsPackage.RUN_PROTOCOL__CREATION_TIME:
				setCreationTime((Date)newValue);
				return;
			case ResultsPackage.RUN_PROTOCOL__RANDOM_SEED:
				setRandomSeed((Long)newValue);
				return;
			case ResultsPackage.RUN_PROTOCOL__VALIDATION_SUCCESSFUL:
				setValidationSuccessful((Boolean)newValue);
				return;
			case ResultsPackage.RUN_PROTOCOL__INVALID_MEASUREMENT_RESULTS:
				getInvalidMeasurementResults().clear();
				getInvalidMeasurementResults().addAll((Collection<? extends MeasurementRun>)newValue);
				return;
			case ResultsPackage.RUN_PROTOCOL__INVALID_TRACES:
				getInvalidTraces().clear();
				getInvalidTraces().addAll((Collection<? extends ExecutionTrace>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ResultsPackage.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES:
				getValidationFailureNotices().clear();
				return;
			case ResultsPackage.RUN_PROTOCOL__CREATION_TIME:
				setCreationTime(CREATION_TIME_EDEFAULT);
				return;
			case ResultsPackage.RUN_PROTOCOL__RANDOM_SEED:
				setRandomSeed(RANDOM_SEED_EDEFAULT);
				return;
			case ResultsPackage.RUN_PROTOCOL__VALIDATION_SUCCESSFUL:
				setValidationSuccessful(VALIDATION_SUCCESSFUL_EDEFAULT);
				return;
			case ResultsPackage.RUN_PROTOCOL__INVALID_MEASUREMENT_RESULTS:
				getInvalidMeasurementResults().clear();
				return;
			case ResultsPackage.RUN_PROTOCOL__INVALID_TRACES:
				getInvalidTraces().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ResultsPackage.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES:
				return validationFailureNotices != null && !validationFailureNotices.isEmpty();
			case ResultsPackage.RUN_PROTOCOL__CREATION_TIME:
				return CREATION_TIME_EDEFAULT == null ? creationTime != null : !CREATION_TIME_EDEFAULT.equals(creationTime);
			case ResultsPackage.RUN_PROTOCOL__RANDOM_SEED:
				return randomSeed != RANDOM_SEED_EDEFAULT;
			case ResultsPackage.RUN_PROTOCOL__VALIDATION_SUCCESSFUL:
				return validationSuccessful != VALIDATION_SUCCESSFUL_EDEFAULT;
			case ResultsPackage.RUN_PROTOCOL__INVALID_MEASUREMENT_RESULTS:
				return invalidMeasurementResults != null && !invalidMeasurementResults.isEmpty();
			case ResultsPackage.RUN_PROTOCOL__INVALID_TRACES:
				return invalidTraces != null && !invalidTraces.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (creationTime: ");
		result.append(creationTime);
		result.append(", randomSeed: ");
		result.append(randomSeed);
		result.append(", validationSuccessful: ");
		result.append(validationSuccessful);
		result.append(')');
		return result.toString();
	}

} //RunProtocolImpl
