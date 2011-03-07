/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.capra.core.CorePackage;
import de.uka.ipd.sdq.capra.core.ResourceUsage;
import de.uka.ipd.sdq.capra.resources.ProcessingResource;
import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.ResourceUsageImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.ResourceUsageImpl#getUsageTime <em>Usage Time</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.ResourceUsageImpl#getUsageTimeSpecification <em>Usage Time Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceUsageImpl extends AbstractResourceUsageImpl implements ResourceUsage {
	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResource resource;

	/**
	 * The default value of the '{@link #getUsageTimeSpecification() <em>Usage Time Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageTimeSpecification()
	 * @generated
	 * @ordered
	 */
	protected static final String USAGE_TIME_SPECIFICATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsageTimeSpecification() <em>Usage Time Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsageTimeSpecification()
	 * @generated
	 * @ordered
	 */
	protected String usageTimeSpecification = USAGE_TIME_SPECIFICATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceUsageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.RESOURCE_USAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResource getResource() {
		if (resource != null && resource.eIsProxy()) {
			InternalEObject oldResource = (InternalEObject)resource;
			resource = (ProcessingResource)eResolveProxy(oldResource);
			if (resource != oldResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CorePackage.RESOURCE_USAGE__RESOURCE, oldResource, resource));
			}
		}
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResource basicGetResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(ProcessingResource newResource) {
		ProcessingResource oldResource = resource;
		resource = newResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RESOURCE_USAGE__RESOURCE, oldResource, resource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilityDensityFunction getUsageTime() {
		ProbabilityDensityFunction usageTime = basicGetUsageTime();
		return usageTime != null && usageTime.eIsProxy() ? (ProbabilityDensityFunction)eResolveProxy((InternalEObject)usageTime) : usageTime;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public ProbabilityDensityFunction basicGetUsageTime() {
		try {
			return ManagedPDF.createFromString(this.usageTimeSpecification).getModelPdf();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setUsageTime(ProbabilityDensityFunction newUsageTime) {
		this.usageTimeSpecification = new ManagedPDF(newUsageTime).toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsageTimeSpecification() {
		return usageTimeSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsageTimeSpecification(String newUsageTimeSpecification) {
		String oldUsageTimeSpecification = usageTimeSpecification;
		usageTimeSpecification = newUsageTimeSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RESOURCE_USAGE__USAGE_TIME_SPECIFICATION, oldUsageTimeSpecification, usageTimeSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.RESOURCE_USAGE__RESOURCE:
				if (resolve) return getResource();
				return basicGetResource();
			case CorePackage.RESOURCE_USAGE__USAGE_TIME:
				if (resolve) return getUsageTime();
				return basicGetUsageTime();
			case CorePackage.RESOURCE_USAGE__USAGE_TIME_SPECIFICATION:
				return getUsageTimeSpecification();
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
			case CorePackage.RESOURCE_USAGE__RESOURCE:
				setResource((ProcessingResource)newValue);
				return;
			case CorePackage.RESOURCE_USAGE__USAGE_TIME:
				setUsageTime((ProbabilityDensityFunction)newValue);
				return;
			case CorePackage.RESOURCE_USAGE__USAGE_TIME_SPECIFICATION:
				setUsageTimeSpecification((String)newValue);
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
			case CorePackage.RESOURCE_USAGE__RESOURCE:
				setResource((ProcessingResource)null);
				return;
			case CorePackage.RESOURCE_USAGE__USAGE_TIME:
				setUsageTime((ProbabilityDensityFunction)null);
				return;
			case CorePackage.RESOURCE_USAGE__USAGE_TIME_SPECIFICATION:
				setUsageTimeSpecification(USAGE_TIME_SPECIFICATION_EDEFAULT);
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
			case CorePackage.RESOURCE_USAGE__RESOURCE:
				return resource != null;
			case CorePackage.RESOURCE_USAGE__USAGE_TIME:
				return basicGetUsageTime() != null;
			case CorePackage.RESOURCE_USAGE__USAGE_TIME_SPECIFICATION:
				return USAGE_TIME_SPECIFICATION_EDEFAULT == null ? usageTimeSpecification != null : !USAGE_TIME_SPECIFICATION_EDEFAULT.equals(usageTimeSpecification);
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
		result.append(" (usageTimeSpecification: ");
		result.append(usageTimeSpecification);
		result.append(')');
		return result.toString();
	}

} //ResourceUsageImpl
