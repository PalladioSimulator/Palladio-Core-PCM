
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import de.uka.ipd.sdq.pcm.usagemodel.InterArrivalTime;
import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelValidator;
import java.util.Map;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Open Workload</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.OpenWorkloadImpl#getInterArrivalTime_OpenWorkload <em>Inter Arrival Time Open Workload</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpenWorkloadImpl extends WorkloadImpl implements OpenWorkload {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getInterArrivalTime_OpenWorkload() <em>Inter Arrival Time Open Workload</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterArrivalTime_OpenWorkload()
	 * @generated
	 * @ordered
	 */
	protected InterArrivalTime interArrivalTime_OpenWorkload;


	/**
	 * The parsed OCL expression for the definition of the '{@link #InterArrivalTimeInOpenWorkloadNeedsToBeSpecified <em>Inter Arrival Time In Open Workload Needs To Be Specified</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #InterArrivalTimeInOpenWorkloadNeedsToBeSpecified
	 * @generated
	 */
	private static OCLExpression InterArrivalTimeInOpenWorkloadNeedsToBeSpecifiedInvOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpenWorkloadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsagemodelPackage.Literals.OPEN_WORKLOAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterArrivalTime getInterArrivalTime_OpenWorkload() {
		return interArrivalTime_OpenWorkload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterArrivalTime_OpenWorkload(InterArrivalTime newInterArrivalTime_OpenWorkload, NotificationChain msgs) {
		InterArrivalTime oldInterArrivalTime_OpenWorkload = interArrivalTime_OpenWorkload;
		interArrivalTime_OpenWorkload = newInterArrivalTime_OpenWorkload;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD, oldInterArrivalTime_OpenWorkload, newInterArrivalTime_OpenWorkload);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterArrivalTime_OpenWorkload(InterArrivalTime newInterArrivalTime_OpenWorkload) {
		if (newInterArrivalTime_OpenWorkload != interArrivalTime_OpenWorkload) {
			NotificationChain msgs = null;
			if (interArrivalTime_OpenWorkload != null)
				msgs = ((InternalEObject)interArrivalTime_OpenWorkload).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD, null, msgs);
			if (newInterArrivalTime_OpenWorkload != null)
				msgs = ((InternalEObject)newInterArrivalTime_OpenWorkload).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD, null, msgs);
			msgs = basicSetInterArrivalTime_OpenWorkload(newInterArrivalTime_OpenWorkload, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD, newInterArrivalTime_OpenWorkload, newInterArrivalTime_OpenWorkload));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean InterArrivalTimeInOpenWorkloadNeedsToBeSpecified(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (InterArrivalTimeInOpenWorkloadNeedsToBeSpecifiedInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "not self.interArrivalTime_OpenWorkload.oclIsUndefined() and self.interArrivalTime_OpenWorkload.specification <> '' ";
			
			try {
				InterArrivalTimeInOpenWorkloadNeedsToBeSpecifiedInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(InterArrivalTimeInOpenWorkloadNeedsToBeSpecifiedInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 UsagemodelValidator.DIAGNOSTIC_SOURCE,
						 UsagemodelValidator.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_IN_OPEN_WORKLOAD_NEEDS_TO_BE_SPECIFIED,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "InterArrivalTimeInOpenWorkloadNeedsToBeSpecified", EObjectValidator.getObjectLabel(this, context) }),
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD:
				return basicSetInterArrivalTime_OpenWorkload(null, msgs);
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
			case UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD:
				return getInterArrivalTime_OpenWorkload();
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
			case UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD:
				setInterArrivalTime_OpenWorkload((InterArrivalTime)newValue);
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
			case UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD:
				setInterArrivalTime_OpenWorkload((InterArrivalTime)null);
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
			case UsagemodelPackage.OPEN_WORKLOAD__INTER_ARRIVAL_TIME_OPEN_WORKLOAD:
				return interArrivalTime_OpenWorkload != null;
		}
		return super.eIsSet(featureID);
	}

} //OpenWorkloadImpl
