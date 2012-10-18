/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Processing Resource Specification Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ProcessingResourceSpecificationResultImpl#getProcessingResourceSpecification_ProcessingResourceSpecificationResult <em>Processing Resource Specification Processing Resource Specification Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessingResourceSpecificationResultImpl extends ActiveResourceUtilisationResultImpl implements ProcessingResourceSpecificationResult {
	/**
	 * The cached value of the '{@link #getProcessingResourceSpecification_ProcessingResourceSpecificationResult() <em>Processing Resource Specification Processing Resource Specification Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingResourceSpecification_ProcessingResourceSpecificationResult()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResourceSpecification processingResourceSpecification_ProcessingResourceSpecificationResult;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessingResourceSpecificationResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentdecoratorPackage.Literals.PROCESSING_RESOURCE_SPECIFICATION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification getProcessingResourceSpecification_ProcessingResourceSpecificationResult() {
		if (processingResourceSpecification_ProcessingResourceSpecificationResult != null && processingResourceSpecification_ProcessingResourceSpecificationResult.eIsProxy()) {
			InternalEObject oldProcessingResourceSpecification_ProcessingResourceSpecificationResult = (InternalEObject)processingResourceSpecification_ProcessingResourceSpecificationResult;
			processingResourceSpecification_ProcessingResourceSpecificationResult = (ProcessingResourceSpecification)eResolveProxy(oldProcessingResourceSpecification_ProcessingResourceSpecificationResult);
			if (processingResourceSpecification_ProcessingResourceSpecificationResult != oldProcessingResourceSpecification_ProcessingResourceSpecificationResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT, oldProcessingResourceSpecification_ProcessingResourceSpecificationResult, processingResourceSpecification_ProcessingResourceSpecificationResult));
			}
		}
		return processingResourceSpecification_ProcessingResourceSpecificationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceSpecification basicGetProcessingResourceSpecification_ProcessingResourceSpecificationResult() {
		return processingResourceSpecification_ProcessingResourceSpecificationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingResourceSpecification_ProcessingResourceSpecificationResult(ProcessingResourceSpecification newProcessingResourceSpecification_ProcessingResourceSpecificationResult) {
		ProcessingResourceSpecification oldProcessingResourceSpecification_ProcessingResourceSpecificationResult = processingResourceSpecification_ProcessingResourceSpecificationResult;
		processingResourceSpecification_ProcessingResourceSpecificationResult = newProcessingResourceSpecification_ProcessingResourceSpecificationResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT, oldProcessingResourceSpecification_ProcessingResourceSpecificationResult, processingResourceSpecification_ProcessingResourceSpecificationResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT:
				if (resolve) return getProcessingResourceSpecification_ProcessingResourceSpecificationResult();
				return basicGetProcessingResourceSpecification_ProcessingResourceSpecificationResult();
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
			case ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT:
				setProcessingResourceSpecification_ProcessingResourceSpecificationResult((ProcessingResourceSpecification)newValue);
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
			case ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT:
				setProcessingResourceSpecification_ProcessingResourceSpecificationResult((ProcessingResourceSpecification)null);
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
			case ResourceenvironmentdecoratorPackage.PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT:
				return processingResourceSpecification_ProcessingResourceSpecificationResult != null;
		}
		return super.eIsSet(featureID);
	}

} //ProcessingResourceSpecificationResultImpl
