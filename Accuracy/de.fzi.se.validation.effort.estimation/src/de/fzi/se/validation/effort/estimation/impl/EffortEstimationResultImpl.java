/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.effort.estimation.impl;

import de.fzi.se.validation.effort.estimation.EffortEstimationResult;
import de.fzi.se.validation.effort.estimation.EstimationPackage;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Effort Estimation Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.effort.estimation.impl.EffortEstimationResultImpl#getNumberTestcases <em>Number Testcases</em>}</li>
 *   <li>{@link de.fzi.se.validation.effort.estimation.impl.EffortEstimationResultImpl#getTargetId <em>Target Id</em>}</li>
 *   <li>{@link de.fzi.se.validation.effort.estimation.impl.EffortEstimationResultImpl#getAlpha <em>Alpha</em>}</li>
 *   <li>{@link de.fzi.se.validation.effort.estimation.impl.EffortEstimationResultImpl#getTargetUri <em>Target Uri</em>}</li>
 *   <li>{@link de.fzi.se.validation.effort.estimation.impl.EffortEstimationResultImpl#getResourceDemandingBehaviour <em>Resource Demanding Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EffortEstimationResultImpl extends EObjectImpl implements EffortEstimationResult {
	/**
	 * The default value of the '{@link #getNumberTestcases() <em>Number Testcases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberTestcases()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_TESTCASES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberTestcases() <em>Number Testcases</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberTestcases()
	 * @generated
	 * @ordered
	 */
	protected int numberTestcases = NUMBER_TESTCASES_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetId() <em>Target Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetId()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetId() <em>Target Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetId()
	 * @generated
	 * @ordered
	 */
	protected String targetId = TARGET_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha()
	 * @generated
	 * @ordered
	 */
	protected static final double ALPHA_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAlpha() <em>Alpha</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlpha()
	 * @generated
	 * @ordered
	 */
	protected double alpha = ALPHA_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetUri() <em>Target Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetUri()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetUri() <em>Target Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetUri()
	 * @generated
	 * @ordered
	 */
	protected String targetUri = TARGET_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResourceDemandingBehaviour() <em>Resource Demanding Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceDemandingBehaviour()
	 * @generated
	 * @ordered
	 */
	protected ResourceDemandingBehaviour resourceDemandingBehaviour;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EffortEstimationResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EstimationPackage.Literals.EFFORT_ESTIMATION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberTestcases() {
		return numberTestcases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberTestcases(int newNumberTestcases) {
		int oldNumberTestcases = numberTestcases;
		numberTestcases = newNumberTestcases;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EstimationPackage.EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES, oldNumberTestcases, numberTestcases));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetId() {
		return targetId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetId(String newTargetId) {
		String oldTargetId = targetId;
		targetId = newTargetId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EstimationPackage.EFFORT_ESTIMATION_RESULT__TARGET_ID, oldTargetId, targetId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAlpha() {
		return alpha;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlpha(double newAlpha) {
		double oldAlpha = alpha;
		alpha = newAlpha;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EstimationPackage.EFFORT_ESTIMATION_RESULT__ALPHA, oldAlpha, alpha));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetUri() {
		return targetUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetUri(String newTargetUri) {
		String oldTargetUri = targetUri;
		targetUri = newTargetUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EstimationPackage.EFFORT_ESTIMATION_RESULT__TARGET_URI, oldTargetUri, targetUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingBehaviour getResourceDemandingBehaviour() {
		if (resourceDemandingBehaviour != null && resourceDemandingBehaviour.eIsProxy()) {
			InternalEObject oldResourceDemandingBehaviour = (InternalEObject)resourceDemandingBehaviour;
			resourceDemandingBehaviour = (ResourceDemandingBehaviour)eResolveProxy(oldResourceDemandingBehaviour);
			if (resourceDemandingBehaviour != oldResourceDemandingBehaviour) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EstimationPackage.EFFORT_ESTIMATION_RESULT__RESOURCE_DEMANDING_BEHAVIOUR, oldResourceDemandingBehaviour, resourceDemandingBehaviour));
			}
		}
		return resourceDemandingBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingBehaviour basicGetResourceDemandingBehaviour() {
		return resourceDemandingBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceDemandingBehaviour(ResourceDemandingBehaviour newResourceDemandingBehaviour) {
		ResourceDemandingBehaviour oldResourceDemandingBehaviour = resourceDemandingBehaviour;
		resourceDemandingBehaviour = newResourceDemandingBehaviour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EstimationPackage.EFFORT_ESTIMATION_RESULT__RESOURCE_DEMANDING_BEHAVIOUR, oldResourceDemandingBehaviour, resourceDemandingBehaviour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES:
				return getNumberTestcases();
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__TARGET_ID:
				return getTargetId();
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__ALPHA:
				return getAlpha();
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__TARGET_URI:
				return getTargetUri();
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__RESOURCE_DEMANDING_BEHAVIOUR:
				if (resolve) return getResourceDemandingBehaviour();
				return basicGetResourceDemandingBehaviour();
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
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES:
				setNumberTestcases((Integer)newValue);
				return;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__TARGET_ID:
				setTargetId((String)newValue);
				return;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__ALPHA:
				setAlpha((Double)newValue);
				return;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__TARGET_URI:
				setTargetUri((String)newValue);
				return;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__RESOURCE_DEMANDING_BEHAVIOUR:
				setResourceDemandingBehaviour((ResourceDemandingBehaviour)newValue);
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
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES:
				setNumberTestcases(NUMBER_TESTCASES_EDEFAULT);
				return;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__TARGET_ID:
				setTargetId(TARGET_ID_EDEFAULT);
				return;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__ALPHA:
				setAlpha(ALPHA_EDEFAULT);
				return;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__TARGET_URI:
				setTargetUri(TARGET_URI_EDEFAULT);
				return;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__RESOURCE_DEMANDING_BEHAVIOUR:
				setResourceDemandingBehaviour((ResourceDemandingBehaviour)null);
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
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES:
				return numberTestcases != NUMBER_TESTCASES_EDEFAULT;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__TARGET_ID:
				return TARGET_ID_EDEFAULT == null ? targetId != null : !TARGET_ID_EDEFAULT.equals(targetId);
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__ALPHA:
				return alpha != ALPHA_EDEFAULT;
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__TARGET_URI:
				return TARGET_URI_EDEFAULT == null ? targetUri != null : !TARGET_URI_EDEFAULT.equals(targetUri);
			case EstimationPackage.EFFORT_ESTIMATION_RESULT__RESOURCE_DEMANDING_BEHAVIOUR:
				return resourceDemandingBehaviour != null;
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
		result.append(" (numberTestcases: ");
		result.append(numberTestcases);
		result.append(", targetId: ");
		result.append(targetId);
		result.append(", alpha: ");
		result.append(alpha);
		result.append(", targetUri: ");
		result.append(targetUri);
		result.append(')');
		return result.toString();
	}

} //EffortEstimationResultImpl
