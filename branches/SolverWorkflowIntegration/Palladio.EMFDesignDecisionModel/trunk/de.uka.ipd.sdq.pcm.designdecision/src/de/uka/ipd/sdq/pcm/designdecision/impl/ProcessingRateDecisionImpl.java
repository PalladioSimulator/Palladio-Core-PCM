/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processing Rate Decision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingRateDecisionImpl#getProcessingresourcespecification <em>Processingresourcespecification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ProcessingRateDecisionImpl#getResourcecontainer <em>Resourcecontainer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessingRateDecisionImpl extends DesignDecisionImpl implements ProcessingRateDecision {
	/**
	 * The cached value of the '{@link #getProcessingresourcespecification() <em>Processingresourcespecification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingresourcespecification()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResourceSpecification processingresourcespecification;

	/**
	 * The cached value of the '{@link #getResourcecontainer() <em>Resourcecontainer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourcecontainer()
	 * @generated
	 * @ordered
	 */
	protected ResourceContainer resourcecontainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessingRateDecisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.PROCESSING_RATE_DECISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification getProcessingresourcespecification() {
		if (processingresourcespecification != null && processingresourcespecification.eIsProxy()) {
			InternalEObject oldProcessingresourcespecification = (InternalEObject)processingresourcespecification;
			processingresourcespecification = (ProcessingResourceSpecification)eResolveProxy(oldProcessingresourcespecification);
			if (processingresourcespecification != oldProcessingresourcespecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.PROCESSING_RATE_DECISION__PROCESSINGRESOURCESPECIFICATION, oldProcessingresourcespecification, processingresourcespecification));
			}
		}
		return processingresourcespecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification basicGetProcessingresourcespecification() {
		return processingresourcespecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingresourcespecification(ProcessingResourceSpecification newProcessingresourcespecification) {
		ProcessingResourceSpecification oldProcessingresourcespecification = processingresourcespecification;
		processingresourcespecification = newProcessingresourcespecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.PROCESSING_RATE_DECISION__PROCESSINGRESOURCESPECIFICATION, oldProcessingresourcespecification, processingresourcespecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer getResourcecontainer() {
		if (resourcecontainer != null && resourcecontainer.eIsProxy()) {
			InternalEObject oldResourcecontainer = (InternalEObject)resourcecontainer;
			resourcecontainer = (ResourceContainer)eResolveProxy(oldResourcecontainer);
			if (resourcecontainer != oldResourcecontainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.PROCESSING_RATE_DECISION__RESOURCECONTAINER, oldResourcecontainer, resourcecontainer));
			}
		}
		return resourcecontainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainer basicGetResourcecontainer() {
		return resourcecontainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourcecontainer(ResourceContainer newResourcecontainer) {
		ResourceContainer oldResourcecontainer = resourcecontainer;
		resourcecontainer = newResourcecontainer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.PROCESSING_RATE_DECISION__RESOURCECONTAINER, oldResourcecontainer, resourcecontainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.PROCESSING_RATE_DECISION__PROCESSINGRESOURCESPECIFICATION:
				if (resolve) return getProcessingresourcespecification();
				return basicGetProcessingresourcespecification();
			case designdecisionPackage.PROCESSING_RATE_DECISION__RESOURCECONTAINER:
				if (resolve) return getResourcecontainer();
				return basicGetResourcecontainer();
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
			case designdecisionPackage.PROCESSING_RATE_DECISION__PROCESSINGRESOURCESPECIFICATION:
				setProcessingresourcespecification((ProcessingResourceSpecification)newValue);
				return;
			case designdecisionPackage.PROCESSING_RATE_DECISION__RESOURCECONTAINER:
				setResourcecontainer((ResourceContainer)newValue);
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
			case designdecisionPackage.PROCESSING_RATE_DECISION__PROCESSINGRESOURCESPECIFICATION:
				setProcessingresourcespecification((ProcessingResourceSpecification)null);
				return;
			case designdecisionPackage.PROCESSING_RATE_DECISION__RESOURCECONTAINER:
				setResourcecontainer((ResourceContainer)null);
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
			case designdecisionPackage.PROCESSING_RATE_DECISION__PROCESSINGRESOURCESPECIFICATION:
				return processingresourcespecification != null;
			case designdecisionPackage.PROCESSING_RATE_DECISION__RESOURCECONTAINER:
				return resourcecontainer != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * @generated not
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.impl.BasicEObjectImpl#toString()
	 */
	@Override
	public String toString(){
		return "rate of "+this.getProcessingresourcespecification().getActiveResourceType_ActiveResourceSpecification().getEntityName() + " in "+this.getResourcecontainer().getEntityName();
		
	}

} //ProcessingRateDecisionImpl
