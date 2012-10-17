/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability.impl;

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
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.util.ReliabilityValidator;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hardware Induced Failure Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.impl.HardwareInducedFailureTypeImpl#getProcessingResourceType__HardwareInducedFailureType <em>Processing Resource Type Hardware Induced Failure Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HardwareInducedFailureTypeImpl extends FailureTypeImpl implements HardwareInducedFailureType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getProcessingResourceType__HardwareInducedFailureType() <em>Processing Resource Type Hardware Induced Failure Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingResourceType__HardwareInducedFailureType()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResourceType processingResourceType__HardwareInducedFailureType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HardwareInducedFailureTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReliabilityPackage.Literals.HARDWARE_INDUCED_FAILURE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceType getProcessingResourceType__HardwareInducedFailureType() {
		if (processingResourceType__HardwareInducedFailureType != null && processingResourceType__HardwareInducedFailureType.eIsProxy()) {
			InternalEObject oldProcessingResourceType__HardwareInducedFailureType = (InternalEObject)processingResourceType__HardwareInducedFailureType;
			processingResourceType__HardwareInducedFailureType = (ProcessingResourceType)eResolveProxy(oldProcessingResourceType__HardwareInducedFailureType);
			if (processingResourceType__HardwareInducedFailureType != oldProcessingResourceType__HardwareInducedFailureType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE, oldProcessingResourceType__HardwareInducedFailureType, processingResourceType__HardwareInducedFailureType));
			}
		}
		return processingResourceType__HardwareInducedFailureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceType basicGetProcessingResourceType__HardwareInducedFailureType() {
		return processingResourceType__HardwareInducedFailureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcessingResourceType__HardwareInducedFailureType(ProcessingResourceType newProcessingResourceType__HardwareInducedFailureType, NotificationChain msgs) {
		ProcessingResourceType oldProcessingResourceType__HardwareInducedFailureType = processingResourceType__HardwareInducedFailureType;
		processingResourceType__HardwareInducedFailureType = newProcessingResourceType__HardwareInducedFailureType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE, oldProcessingResourceType__HardwareInducedFailureType, newProcessingResourceType__HardwareInducedFailureType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingResourceType__HardwareInducedFailureType(ProcessingResourceType newProcessingResourceType__HardwareInducedFailureType) {
		if (newProcessingResourceType__HardwareInducedFailureType != processingResourceType__HardwareInducedFailureType) {
			NotificationChain msgs = null;
			if (processingResourceType__HardwareInducedFailureType != null)
				msgs = ((InternalEObject)processingResourceType__HardwareInducedFailureType).eInverseRemove(this, ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE, ProcessingResourceType.class, msgs);
			if (newProcessingResourceType__HardwareInducedFailureType != null)
				msgs = ((InternalEObject)newProcessingResourceType__HardwareInducedFailureType).eInverseAdd(this, ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE, ProcessingResourceType.class, msgs);
			msgs = basicSetProcessingResourceType__HardwareInducedFailureType(newProcessingResourceType__HardwareInducedFailureType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE, newProcessingResourceType__HardwareInducedFailureType, newProcessingResourceType__HardwareInducedFailureType));
	}

	/**
	 * The cached OCL expression body for the '{@link #HardwareInducedFailureTypeHasProcessingResourceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Hardware Induced Failure Type Has Processing Resource Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HardwareInducedFailureTypeHasProcessingResourceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String HARDWARE_INDUCED_FAILURE_TYPE_HAS_PROCESSING_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "( self.processingResourceType__HardwareInducedFailureType <> null ) and ( not ( self.processingResourceType__HardwareInducedFailureType.oclIsTypeOf( pcm::resourcetype::CommunicationLinkResourceType ) ) )";

	/**
	 * The cached OCL invariant for the '{@link #HardwareInducedFailureTypeHasProcessingResourceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Hardware Induced Failure Type Has Processing Resource Type</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HardwareInducedFailureTypeHasProcessingResourceType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint HARDWARE_INDUCED_FAILURE_TYPE_HAS_PROCESSING_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean HardwareInducedFailureTypeHasProcessingResourceType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (HARDWARE_INDUCED_FAILURE_TYPE_HAS_PROCESSING_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(ReliabilityPackage.Literals.HARDWARE_INDUCED_FAILURE_TYPE);
			try {
				HARDWARE_INDUCED_FAILURE_TYPE_HAS_PROCESSING_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(HARDWARE_INDUCED_FAILURE_TYPE_HAS_PROCESSING_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(HARDWARE_INDUCED_FAILURE_TYPE_HAS_PROCESSING_RESOURCE_TYPE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ReliabilityValidator.DIAGNOSTIC_SOURCE,
						 ReliabilityValidator.HARDWARE_INDUCED_FAILURE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_HAS_PROCESSING_RESOURCE_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "HardwareInducedFailureTypeHasProcessingResourceType", EObjectValidator.getObjectLabel(this, context) }),
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE:
				if (processingResourceType__HardwareInducedFailureType != null)
					msgs = ((InternalEObject)processingResourceType__HardwareInducedFailureType).eInverseRemove(this, ResourcetypePackage.PROCESSING_RESOURCE_TYPE__HARDWARE_INDUCED_FAILURE_TYPE_PROCESSING_RESOURCE_TYPE, ProcessingResourceType.class, msgs);
				return basicSetProcessingResourceType__HardwareInducedFailureType((ProcessingResourceType)otherEnd, msgs);
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
			case ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE:
				return basicSetProcessingResourceType__HardwareInducedFailureType(null, msgs);
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
			case ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE:
				if (resolve) return getProcessingResourceType__HardwareInducedFailureType();
				return basicGetProcessingResourceType__HardwareInducedFailureType();
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
			case ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE:
				setProcessingResourceType__HardwareInducedFailureType((ProcessingResourceType)newValue);
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
			case ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE:
				setProcessingResourceType__HardwareInducedFailureType((ProcessingResourceType)null);
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
			case ReliabilityPackage.HARDWARE_INDUCED_FAILURE_TYPE__PROCESSING_RESOURCE_TYPE_HARDWARE_INDUCED_FAILURE_TYPE:
				return processingResourceType__HardwareInducedFailureType != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //HardwareInducedFailureTypeImpl
