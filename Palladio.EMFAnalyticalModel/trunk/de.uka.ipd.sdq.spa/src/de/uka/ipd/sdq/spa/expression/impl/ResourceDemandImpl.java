/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression.impl;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;

import de.uka.ipd.sdq.spa.expression.ExpressionPackage;
import de.uka.ipd.sdq.spa.expression.ResourceDemand;

import de.uka.ipd.sdq.spa.resource.ProcessingResource;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.ResourceDemandImpl#getPdf <em>Pdf</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.impl.ResourceDemandImpl#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceDemandImpl extends EObjectImpl implements ResourceDemand {
	/**
	 * The cached value of the '{@link #getPdf() <em>Pdf</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPdf()
	 * @generated
	 * @ordered
	 */
	protected ProbabilityDensityFunction pdf = null;

	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResource resource = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceDemandImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.RESOURCE_DEMAND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilityDensityFunction getPdf() {
		return pdf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPdf(ProbabilityDensityFunction newPdf, NotificationChain msgs) {
		ProbabilityDensityFunction oldPdf = pdf;
		pdf = newPdf;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.RESOURCE_DEMAND__PDF, oldPdf, newPdf);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPdf(ProbabilityDensityFunction newPdf) {
		if (newPdf != pdf) {
			NotificationChain msgs = null;
			if (pdf != null)
				msgs = ((InternalEObject)pdf).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.RESOURCE_DEMAND__PDF, null, msgs);
			if (newPdf != null)
				msgs = ((InternalEObject)newPdf).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.RESOURCE_DEMAND__PDF, null, msgs);
			msgs = basicSetPdf(newPdf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.RESOURCE_DEMAND__PDF, newPdf, newPdf));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionPackage.RESOURCE_DEMAND__RESOURCE, oldResource, resource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.RESOURCE_DEMAND__RESOURCE, oldResource, resource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.RESOURCE_DEMAND__PDF:
				return basicSetPdf(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionPackage.RESOURCE_DEMAND__PDF:
				return getPdf();
			case ExpressionPackage.RESOURCE_DEMAND__RESOURCE:
				if (resolve) return getResource();
				return basicGetResource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionPackage.RESOURCE_DEMAND__PDF:
				setPdf((ProbabilityDensityFunction)newValue);
				return;
			case ExpressionPackage.RESOURCE_DEMAND__RESOURCE:
				setResource((ProcessingResource)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpressionPackage.RESOURCE_DEMAND__PDF:
				setPdf((ProbabilityDensityFunction)null);
				return;
			case ExpressionPackage.RESOURCE_DEMAND__RESOURCE:
				setResource((ProcessingResource)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpressionPackage.RESOURCE_DEMAND__PDF:
				return pdf != null;
			case ExpressionPackage.RESOURCE_DEMAND__RESOURCE:
				return resource != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceDemandImpl