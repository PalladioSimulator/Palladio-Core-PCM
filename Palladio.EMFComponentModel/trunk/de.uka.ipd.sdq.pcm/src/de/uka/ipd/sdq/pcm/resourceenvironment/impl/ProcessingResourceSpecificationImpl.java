
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;
import de.uka.ipd.sdq.pcm.resourceenvironment.util.ResourceenvironmentValidator;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

import java.util.Map;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
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
 * An implementation of the model object '<em><b>Processing Resource Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getSchedulingPolicy <em>Scheduling Policy</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getActiveResourceType_ActiveResourceSpecification <em>Active Resource Type Active Resource Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getProcessingRate <em>Processing Rate</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourceenvironment.impl.ProcessingResourceSpecificationImpl#getUnits <em>Units</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessingResourceSpecificationImpl extends EObjectImpl implements ProcessingResourceSpecification {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The default value of the '{@link #getSchedulingPolicy() <em>Scheduling Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final SchedulingPolicy SCHEDULING_POLICY_EDEFAULT = SchedulingPolicy.DELAY;

	/**
	 * The cached value of the '{@link #getSchedulingPolicy() <em>Scheduling Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulingPolicy()
	 * @generated
	 * @ordered
	 */
	protected SchedulingPolicy schedulingPolicy = SCHEDULING_POLICY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActiveResourceType_ActiveResourceSpecification() <em>Active Resource Type Active Resource Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveResourceType_ActiveResourceSpecification()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResourceType activeResourceType_ActiveResourceSpecification;

	/**
	 * The default value of the '{@link #getProcessingRate() <em>Processing Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingRate()
	 * @generated
	 * @ordered
	 */
	protected static final double PROCESSING_RATE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getProcessingRate() <em>Processing Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingRate()
	 * @generated
	 * @ordered
	 */
	protected double processingRate = PROCESSING_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnits() <em>Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnits()
	 * @generated
	 * @ordered
	 */
	protected static final String UNITS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnits() <em>Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnits()
	 * @generated
	 * @ordered
	 */
	protected String units = UNITS_EDEFAULT;


	/**
	 * The parsed OCL expression for the definition of the '{@link #ProcessingRatemustbelargerthanzero <em>Processing Ratemustbelargerthanzero</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ProcessingRatemustbelargerthanzero
	 * @generated
	 */
	private static OCLExpression ProcessingRatemustbelargerthanzeroInvOCL;

	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessingResourceSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulingPolicy getSchedulingPolicy() {
		return schedulingPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchedulingPolicy(SchedulingPolicy newSchedulingPolicy) {
		SchedulingPolicy oldSchedulingPolicy = schedulingPolicy;
		schedulingPolicy = newSchedulingPolicy == null ? SCHEDULING_POLICY_EDEFAULT : newSchedulingPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY, oldSchedulingPolicy, schedulingPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceType getActiveResourceType_ActiveResourceSpecification() {
		if (activeResourceType_ActiveResourceSpecification != null && activeResourceType_ActiveResourceSpecification.eIsProxy()) {
			InternalEObject oldActiveResourceType_ActiveResourceSpecification = (InternalEObject)activeResourceType_ActiveResourceSpecification;
			activeResourceType_ActiveResourceSpecification = (ProcessingResourceType)eResolveProxy(oldActiveResourceType_ActiveResourceSpecification);
			if (activeResourceType_ActiveResourceSpecification != oldActiveResourceType_ActiveResourceSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION, oldActiveResourceType_ActiveResourceSpecification, activeResourceType_ActiveResourceSpecification));
			}
		}
		return activeResourceType_ActiveResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceType basicGetActiveResourceType_ActiveResourceSpecification() {
		return activeResourceType_ActiveResourceSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveResourceType_ActiveResourceSpecification(ProcessingResourceType newActiveResourceType_ActiveResourceSpecification) {
		ProcessingResourceType oldActiveResourceType_ActiveResourceSpecification = activeResourceType_ActiveResourceSpecification;
		activeResourceType_ActiveResourceSpecification = newActiveResourceType_ActiveResourceSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION, oldActiveResourceType_ActiveResourceSpecification, activeResourceType_ActiveResourceSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getProcessingRate() {
		return processingRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingRate(double newProcessingRate) {
		double oldProcessingRate = processingRate;
		processingRate = newProcessingRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE, oldProcessingRate, processingRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnits() {
		return units;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnits(String newUnits) {
		String oldUnits = units;
		units = newUnits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__UNITS, oldUnits, units));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ProcessingRatemustbelargerthanzero(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ProcessingRatemustbelargerthanzeroInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.processingRate > 0.0 ";
			
			try {
				ProcessingRatemustbelargerthanzeroInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ProcessingRatemustbelargerthanzeroInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ResourceenvironmentValidator.DIAGNOSTIC_SOURCE,
						 ResourceenvironmentValidator.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATEMUSTBELARGERTHANZERO,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ProcessingRatemustbelargerthanzero", EObjectValidator.getObjectLabel(this, context) }),
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
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
				return getSchedulingPolicy();
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
				if (resolve) return getActiveResourceType_ActiveResourceSpecification();
				return basicGetActiveResourceType_ActiveResourceSpecification();
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE:
				return new Double(getProcessingRate());
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__UNITS:
				return getUnits();
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
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
				setSchedulingPolicy((SchedulingPolicy)newValue);
				return;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
				setActiveResourceType_ActiveResourceSpecification((ProcessingResourceType)newValue);
				return;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE:
				setProcessingRate(((Double)newValue).doubleValue());
				return;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__UNITS:
				setUnits((String)newValue);
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
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
				setSchedulingPolicy(SCHEDULING_POLICY_EDEFAULT);
				return;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
				setActiveResourceType_ActiveResourceSpecification((ProcessingResourceType)null);
				return;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE:
				setProcessingRate(PROCESSING_RATE_EDEFAULT);
				return;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__UNITS:
				setUnits(UNITS_EDEFAULT);
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
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY:
				return schedulingPolicy != SCHEDULING_POLICY_EDEFAULT;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION:
				return activeResourceType_ActiveResourceSpecification != null;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE:
				return processingRate != PROCESSING_RATE_EDEFAULT;
			case ResourceenvironmentPackage.PROCESSING_RESOURCE_SPECIFICATION__UNITS:
				return UNITS_EDEFAULT == null ? units != null : !UNITS_EDEFAULT.equals(units);
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
		result.append(" (schedulingPolicy: ");
		result.append(schedulingPolicy);
		result.append(", processingRate: ");
		result.append(processingRate);
		result.append(", units: ");
		result.append(units);
		result.append(')');
		return result.toString();
	}

} //ProcessingResourceSpecificationImpl
