/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl#getParameters__Signature <em>Parameters Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl#getInterface_Signature <em>Interface Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl#getReturntype__Signature <em>Returntype Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl#getExceptions__Signature <em>Exceptions Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignatureImpl extends AbstractServiceImpl implements Signature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getParameters__Signature() <em>Parameters Signature</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters__Signature()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters__Signature;

	/**
	 * The cached value of the '{@link #getReturntype__Signature() <em>Returntype Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturntype__Signature()
	 * @generated
	 * @ordered
	 */
	protected DataType returntype__Signature;

	/**
	 * The cached value of the '{@link #getExceptions__Signature() <em>Exceptions Signature</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptions__Signature()
	 * @generated
	 * @ordered
	 */
	protected EList<ExceptionType> exceptions__Signature;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ParameterNamesHaveToBeUniqueForASignature <em>Parameter Names Have To Be Unique For ASignature</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ParameterNamesHaveToBeUniqueForASignature
	 * @generated
	 */
	private static OCLExpression ParameterNamesHaveToBeUniqueForASignatureInvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SignatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.SIGNATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters__Signature() {
		if (parameters__Signature == null) {
			parameters__Signature = new EObjectContainmentWithInverseEList<Parameter>(Parameter.class, this, RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE, RepositoryPackage.PARAMETER__SIGNATURE_PARAMETER);
		}
		return parameters__Signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getInterface_Signature() {
		if (eContainerFeatureID != RepositoryPackage.SIGNATURE__INTERFACE_SIGNATURE) return null;
		return (Interface)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterface_Signature(Interface newInterface_Signature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInterface_Signature, RepositoryPackage.SIGNATURE__INTERFACE_SIGNATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterface_Signature(Interface newInterface_Signature) {
		if (newInterface_Signature != eInternalContainer() || (eContainerFeatureID != RepositoryPackage.SIGNATURE__INTERFACE_SIGNATURE && newInterface_Signature != null)) {
			if (EcoreUtil.isAncestor(this, newInterface_Signature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInterface_Signature != null)
				msgs = ((InternalEObject)newInterface_Signature).eInverseAdd(this, RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE, Interface.class, msgs);
			msgs = basicSetInterface_Signature(newInterface_Signature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.SIGNATURE__INTERFACE_SIGNATURE, newInterface_Signature, newInterface_Signature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getReturntype__Signature() {
		if (returntype__Signature != null && returntype__Signature.eIsProxy()) {
			InternalEObject oldReturntype__Signature = (InternalEObject)returntype__Signature;
			returntype__Signature = (DataType)eResolveProxy(oldReturntype__Signature);
			if (returntype__Signature != oldReturntype__Signature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE, oldReturntype__Signature, returntype__Signature));
			}
		}
		return returntype__Signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetReturntype__Signature() {
		return returntype__Signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturntype__Signature(DataType newReturntype__Signature) {
		DataType oldReturntype__Signature = returntype__Signature;
		returntype__Signature = newReturntype__Signature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE, oldReturntype__Signature, returntype__Signature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExceptionType> getExceptions__Signature() {
		if (exceptions__Signature == null) {
			exceptions__Signature = new EObjectContainmentEList<ExceptionType>(ExceptionType.class, this, RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE);
		}
		return exceptions__Signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ParameterNamesHaveToBeUniqueForASignature(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ParameterNamesHaveToBeUniqueForASignatureInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.parameters__Signature->isUnique(p : Parameter |  	p.parameterName  ) ";
			
			try {
				ParameterNamesHaveToBeUniqueForASignatureInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ParameterNamesHaveToBeUniqueForASignatureInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.SIGNATURE__PARAMETER_NAMES_HAVE_TO_BE_UNIQUE_FOR_ASIGNATURE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ParameterNamesHaveToBeUniqueForASignature", EObjectValidator.getObjectLabel(this, context) }),
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters__Signature()).basicAdd(otherEnd, msgs);
			case RepositoryPackage.SIGNATURE__INTERFACE_SIGNATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInterface_Signature((Interface)otherEnd, msgs);
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
			case RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE:
				return ((InternalEList<?>)getParameters__Signature()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.SIGNATURE__INTERFACE_SIGNATURE:
				return basicSetInterface_Signature(null, msgs);
			case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
				return ((InternalEList<?>)getExceptions__Signature()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case RepositoryPackage.SIGNATURE__INTERFACE_SIGNATURE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE, Interface.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE:
				return getParameters__Signature();
			case RepositoryPackage.SIGNATURE__INTERFACE_SIGNATURE:
				return getInterface_Signature();
			case RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE:
				if (resolve) return getReturntype__Signature();
				return basicGetReturntype__Signature();
			case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
				return getExceptions__Signature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE:
				getParameters__Signature().clear();
				getParameters__Signature().addAll((Collection<? extends Parameter>)newValue);
				return;
			case RepositoryPackage.SIGNATURE__INTERFACE_SIGNATURE:
				setInterface_Signature((Interface)newValue);
				return;
			case RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE:
				setReturntype__Signature((DataType)newValue);
				return;
			case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
				getExceptions__Signature().clear();
				getExceptions__Signature().addAll((Collection<? extends ExceptionType>)newValue);
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
			case RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE:
				getParameters__Signature().clear();
				return;
			case RepositoryPackage.SIGNATURE__INTERFACE_SIGNATURE:
				setInterface_Signature((Interface)null);
				return;
			case RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE:
				setReturntype__Signature((DataType)null);
				return;
			case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
				getExceptions__Signature().clear();
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
			case RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE:
				return parameters__Signature != null && !parameters__Signature.isEmpty();
			case RepositoryPackage.SIGNATURE__INTERFACE_SIGNATURE:
				return getInterface_Signature() != null;
			case RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE:
				return returntype__Signature != null;
			case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
				return exceptions__Signature != null && !exceptions__Signature.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SignatureImpl
