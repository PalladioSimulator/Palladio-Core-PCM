/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
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

import de.uka.ipd.sdq.pcm.repository.EnvironmentFailureType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment Failure Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.EnvironmentFailureTypeImpl#getProcessingresourcetype <em>Processingresourcetype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnvironmentFailureTypeImpl extends StopFailureTypeImpl implements EnvironmentFailureType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getProcessingresourcetype() <em>Processingresourcetype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingresourcetype()
	 * @generated
	 * @ordered
	 */
	protected ProcessingResourceType processingresourcetype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnvironmentFailureTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.ENVIRONMENT_FAILURE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceType getProcessingresourcetype() {
		if (processingresourcetype != null && processingresourcetype.eIsProxy()) {
			InternalEObject oldProcessingresourcetype = (InternalEObject)processingresourcetype;
			processingresourcetype = (ProcessingResourceType)eResolveProxy(oldProcessingresourcetype);
			if (processingresourcetype != oldProcessingresourcetype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.ENVIRONMENT_FAILURE_TYPE__PROCESSINGRESOURCETYPE, oldProcessingresourcetype, processingresourcetype));
			}
		}
		return processingresourcetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingResourceType basicGetProcessingresourcetype() {
		return processingresourcetype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingresourcetype(ProcessingResourceType newProcessingresourcetype) {
		ProcessingResourceType oldProcessingresourcetype = processingresourcetype;
		processingresourcetype = newProcessingresourcetype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.ENVIRONMENT_FAILURE_TYPE__PROCESSINGRESOURCETYPE, oldProcessingresourcetype, processingresourcetype));
	}

	/**
	 * The cached OCL expression body for the '{@link #ExactlyOneResource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactly One Resource</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ExactlyOneResource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String EXACTLY_ONE_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.processingresourcetype <> null";

	/**
	 * The cached OCL invariant for the '{@link #ExactlyOneResource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Exactly One Resource</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ExactlyOneResource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint EXACTLY_ONE_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ExactlyOneResource(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (EXACTLY_ONE_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.ENVIRONMENT_FAILURE_TYPE);
			try {
				EXACTLY_ONE_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(EXACTLY_ONE_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(EXACTLY_ONE_RESOURCE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.ENVIRONMENT_FAILURE_TYPE__EXACTLY_ONE_RESOURCE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ExactlyOneResource", EObjectValidator.getObjectLabel(this, context) }),
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
			case RepositoryPackage.ENVIRONMENT_FAILURE_TYPE__PROCESSINGRESOURCETYPE:
				if (resolve) return getProcessingresourcetype();
				return basicGetProcessingresourcetype();
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
			case RepositoryPackage.ENVIRONMENT_FAILURE_TYPE__PROCESSINGRESOURCETYPE:
				setProcessingresourcetype((ProcessingResourceType)newValue);
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
			case RepositoryPackage.ENVIRONMENT_FAILURE_TYPE__PROCESSINGRESOURCETYPE:
				setProcessingresourcetype((ProcessingResourceType)null);
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
			case RepositoryPackage.ENVIRONMENT_FAILURE_TYPE__PROCESSINGRESOURCETYPE:
				return processingresourcetype != null;
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

} //EnvironmentFailureTypeImpl
