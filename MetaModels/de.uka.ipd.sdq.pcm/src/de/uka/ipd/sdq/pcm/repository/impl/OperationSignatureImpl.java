/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Operation Signature</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.OperationSignatureImpl#getInterface__OperationSignature <em>Interface Operation Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.OperationSignatureImpl#getParameters__OperationSignature <em>Parameters Operation Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.OperationSignatureImpl#getReturnType__OperationSignature <em>Return Type Operation Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationSignatureImpl extends SignatureImpl implements OperationSignature {
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
	 * The cached value of the '{@link #getParameters__OperationSignature() <em>Parameters Operation Signature</em>}' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see #getParameters__OperationSignature()
	 * @generated
	 * @ordered
	 */
    protected EList<Parameter> parameters__OperationSignature;

    /**
	 * The cached value of the '{@link #getReturnType__OperationSignature() <em>Return Type Operation Signature</em>}' reference.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @see #getReturnType__OperationSignature()
	 * @generated
	 * @ordered
	 */
    protected DataType returnType__OperationSignature;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    protected OperationSignatureImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    protected EClass eStaticClass() {
		return RepositoryPackage.Literals.OPERATION_SIGNATURE;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public OperationInterface getInterface__OperationSignature() {
		if (eContainerFeatureID() != RepositoryPackage.OPERATION_SIGNATURE__INTERFACE_OPERATION_SIGNATURE) return null;
		return (OperationInterface)eContainer();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public NotificationChain basicSetInterface__OperationSignature(OperationInterface newInterface__OperationSignature,
            NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInterface__OperationSignature, RepositoryPackage.OPERATION_SIGNATURE__INTERFACE_OPERATION_SIGNATURE, msgs);
		return msgs;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setInterface__OperationSignature(OperationInterface newInterface__OperationSignature) {
		if (newInterface__OperationSignature != eInternalContainer() || (eContainerFeatureID() != RepositoryPackage.OPERATION_SIGNATURE__INTERFACE_OPERATION_SIGNATURE && newInterface__OperationSignature != null)) {
			if (EcoreUtil.isAncestor(this, newInterface__OperationSignature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInterface__OperationSignature != null)
				msgs = ((InternalEObject)newInterface__OperationSignature).eInverseAdd(this, RepositoryPackage.OPERATION_INTERFACE__SIGNATURES_OPERATION_INTERFACE, OperationInterface.class, msgs);
			msgs = basicSetInterface__OperationSignature(newInterface__OperationSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.OPERATION_SIGNATURE__INTERFACE_OPERATION_SIGNATURE, newInterface__OperationSignature, newInterface__OperationSignature));
	}

    /**
	 * The cached OCL expression body for the '{@link #ParameterNamesHaveToBeUniqueForASignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Parameter Names Have To Be Unique For ASignature</em>}' operation.
	 * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
	 * @see #ParameterNamesHaveToBeUniqueForASignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
    protected static final String PARAMETER_NAMES_HAVE_TO_BE_UNIQUE_FOR_ASIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.parameters__OperationSignature->isUnique(p : Parameter |\n"+"	p.parameterName\n"+")";

    /**
     * The cached OCL invariant for the '
     * {@link #ParameterNamesHaveToBeUniqueForASignature(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Parameter Names Have To Be Unique For ASignature</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ParameterNamesHaveToBeUniqueForASignature(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint PARAMETER_NAMES_HAVE_TO_BE_UNIQUE_FOR_ASIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public boolean ParameterNamesHaveToBeUniqueForASignature(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (PARAMETER_NAMES_HAVE_TO_BE_UNIQUE_FOR_ASIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.OPERATION_SIGNATURE);
			try {
				PARAMETER_NAMES_HAVE_TO_BE_UNIQUE_FOR_ASIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(PARAMETER_NAMES_HAVE_TO_BE_UNIQUE_FOR_ASIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(PARAMETER_NAMES_HAVE_TO_BE_UNIQUE_FOR_ASIGNATURE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.OPERATION_SIGNATURE__PARAMETER_NAMES_HAVE_TO_BE_UNIQUE_FOR_ASIGNATURE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ParameterNamesHaveToBeUniqueForASignature", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public DataType getReturnType__OperationSignature() {
		if (returnType__OperationSignature != null && returnType__OperationSignature.eIsProxy()) {
			InternalEObject oldReturnType__OperationSignature = (InternalEObject)returnType__OperationSignature;
			returnType__OperationSignature = (DataType)eResolveProxy(oldReturnType__OperationSignature);
			if (returnType__OperationSignature != oldReturnType__OperationSignature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.OPERATION_SIGNATURE__RETURN_TYPE_OPERATION_SIGNATURE, oldReturnType__OperationSignature, returnType__OperationSignature));
			}
		}
		return returnType__OperationSignature;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public DataType basicGetReturnType__OperationSignature() {
		return returnType__OperationSignature;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public void setReturnType__OperationSignature(DataType newReturnType__OperationSignature) {
		DataType oldReturnType__OperationSignature = returnType__OperationSignature;
		returnType__OperationSignature = newReturnType__OperationSignature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.OPERATION_SIGNATURE__RETURN_TYPE_OPERATION_SIGNATURE, oldReturnType__OperationSignature, returnType__OperationSignature));
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EList<Parameter> getParameters__OperationSignature() {
		if (parameters__OperationSignature == null) {
			parameters__OperationSignature = new EObjectContainmentWithInverseEList<Parameter>(Parameter.class, this, RepositoryPackage.OPERATION_SIGNATURE__PARAMETERS_OPERATION_SIGNATURE, RepositoryPackage.PARAMETER__OPERATION_SIGNATURE_PARAMETER);
		}
		return parameters__OperationSignature;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.OPERATION_SIGNATURE__INTERFACE_OPERATION_SIGNATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInterface__OperationSignature((OperationInterface)otherEnd, msgs);
			case RepositoryPackage.OPERATION_SIGNATURE__PARAMETERS_OPERATION_SIGNATURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters__OperationSignature()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.OPERATION_SIGNATURE__INTERFACE_OPERATION_SIGNATURE:
				return basicSetInterface__OperationSignature(null, msgs);
			case RepositoryPackage.OPERATION_SIGNATURE__PARAMETERS_OPERATION_SIGNATURE:
				return ((InternalEList<?>)getParameters__OperationSignature()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RepositoryPackage.OPERATION_SIGNATURE__INTERFACE_OPERATION_SIGNATURE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.OPERATION_INTERFACE__SIGNATURES_OPERATION_INTERFACE, OperationInterface.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.OPERATION_SIGNATURE__INTERFACE_OPERATION_SIGNATURE:
				return getInterface__OperationSignature();
			case RepositoryPackage.OPERATION_SIGNATURE__PARAMETERS_OPERATION_SIGNATURE:
				return getParameters__OperationSignature();
			case RepositoryPackage.OPERATION_SIGNATURE__RETURN_TYPE_OPERATION_SIGNATURE:
				if (resolve) return getReturnType__OperationSignature();
				return basicGetReturnType__OperationSignature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RepositoryPackage.OPERATION_SIGNATURE__INTERFACE_OPERATION_SIGNATURE:
				setInterface__OperationSignature((OperationInterface)newValue);
				return;
			case RepositoryPackage.OPERATION_SIGNATURE__PARAMETERS_OPERATION_SIGNATURE:
				getParameters__OperationSignature().clear();
				getParameters__OperationSignature().addAll((Collection<? extends Parameter>)newValue);
				return;
			case RepositoryPackage.OPERATION_SIGNATURE__RETURN_TYPE_OPERATION_SIGNATURE:
				setReturnType__OperationSignature((DataType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public void eUnset(int featureID) {
		switch (featureID) {
			case RepositoryPackage.OPERATION_SIGNATURE__INTERFACE_OPERATION_SIGNATURE:
				setInterface__OperationSignature((OperationInterface)null);
				return;
			case RepositoryPackage.OPERATION_SIGNATURE__PARAMETERS_OPERATION_SIGNATURE:
				getParameters__OperationSignature().clear();
				return;
			case RepositoryPackage.OPERATION_SIGNATURE__RETURN_TYPE_OPERATION_SIGNATURE:
				setReturnType__OperationSignature((DataType)null);
				return;
		}
		super.eUnset(featureID);
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RepositoryPackage.OPERATION_SIGNATURE__INTERFACE_OPERATION_SIGNATURE:
				return getInterface__OperationSignature() != null;
			case RepositoryPackage.OPERATION_SIGNATURE__PARAMETERS_OPERATION_SIGNATURE:
				return parameters__OperationSignature != null && !parameters__OperationSignature.isEmpty();
			case RepositoryPackage.OPERATION_SIGNATURE__RETURN_TYPE_OPERATION_SIGNATURE:
				return returnType__OperationSignature != null;
		}
		return super.eIsSet(featureID);
	}

    /**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc --> <!--
     * end-user-doc -->
	 * @generated
	 * @ordered
	 */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // OperationSignatureImpl
