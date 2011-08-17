/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.impl;


import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.reliability.FailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.util.ReliabilityValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Failure Occurrence Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.impl.FailureOccurrenceDescriptionImpl#getFailureProbability <em>Failure Probability</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FailureOccurrenceDescriptionImpl extends EObjectImpl implements FailureOccurrenceDescription {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The default value of the '{@link #getFailureProbability() <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureProbability()
	 * @generated
	 * @ordered
	 */
	protected static final double FAILURE_PROBABILITY_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getFailureProbability() <em>Failure Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailureProbability()
	 * @generated
	 * @ordered
	 */
	protected double failureProbability = FAILURE_PROBABILITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FailureOccurrenceDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReliabilityPackage.Literals.FAILURE_OCCURRENCE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getFailureProbability() {
		return failureProbability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailureProbability(double newFailureProbability) {
		double oldFailureProbability = failureProbability;
		failureProbability = newFailureProbability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY, oldFailureProbability, failureProbability));
	}

	/**
	 * The cached OCL expression body for the '{@link #EnsureValidFailureProbabilityRange(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Ensure Valid Failure Probability Range</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EnsureValidFailureProbabilityRange(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String ENSURE_VALID_FAILURE_PROBABILITY_RANGE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "(self.failureProbability.oclAsType(Real) <= 1.0) and (self.failureProbability.oclAsType(Real) >= 0.0)";

	/**
	 * The cached OCL invariant for the '{@link #EnsureValidFailureProbabilityRange(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Ensure Valid Failure Probability Range</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EnsureValidFailureProbabilityRange(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint ENSURE_VALID_FAILURE_PROBABILITY_RANGE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean EnsureValidFailureProbabilityRange(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ENSURE_VALID_FAILURE_PROBABILITY_RANGE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(ReliabilityPackage.Literals.FAILURE_OCCURRENCE_DESCRIPTION);
			try {
				ENSURE_VALID_FAILURE_PROBABILITY_RANGE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ENSURE_VALID_FAILURE_PROBABILITY_RANGE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(ENSURE_VALID_FAILURE_PROBABILITY_RANGE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ReliabilityValidator.DIAGNOSTIC_SOURCE,
						 ReliabilityValidator.FAILURE_OCCURRENCE_DESCRIPTION__ENSURE_VALID_FAILURE_PROBABILITY_RANGE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "EnsureValidFailureProbabilityRange", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY:
				return getFailureProbability();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY:
				setFailureProbability((Double)newValue);
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
			case ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY:
				setFailureProbability(FAILURE_PROBABILITY_EDEFAULT);
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
			case ReliabilityPackage.FAILURE_OCCURRENCE_DESCRIPTION__FAILURE_PROBABILITY:
				return failureProbability != FAILURE_PROBABILITY_EDEFAULT;
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
		result.append(" (failureProbability: ");
		result.append(failureProbability);
		result.append(')');
		return result.toString();
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //FailureOccurrenceDescriptionImpl
