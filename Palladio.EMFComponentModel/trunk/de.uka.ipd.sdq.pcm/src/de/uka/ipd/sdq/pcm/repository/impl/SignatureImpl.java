
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;

import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

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
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.OCLExpression;

import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;

import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl#getParameters__Signature <em>Parameters Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl#getReturntype__Signature <em>Returntype Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.SignatureImpl#getExceptions__Signature <em>Exceptions Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignatureImpl extends EObjectImpl implements Signature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The default value of the '{@link #getServiceName() <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceName()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_NAME_EDEFAULT = null;


	/**
	 * The cached value of the '{@link #getServiceName() <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceName()
	 * @generated
	 * @ordered
	 */
	protected String serviceName = SERVICE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters__Signature() <em>Parameters Signature</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters__Signature()
	 * @generated
	 * @ordered
	 */
	protected EList parameters__Signature = null;

	/**
	 * The cached value of the '{@link #getReturntype__Signature() <em>Returntype Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturntype__Signature()
	 * @generated
	 * @ordered
	 */
	protected DataType returntype__Signature = null;

	/**
	 * The cached value of the '{@link #getExceptions__Signature() <em>Exceptions Signature</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptions__Signature()
	 * @generated
	 * @ordered
	 */
	protected EList exceptions__Signature = null;


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
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.SIGNATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceName(String newServiceName) {
		String oldServiceName = serviceName;
		serviceName = newServiceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.SIGNATURE__SERVICE_NAME, oldServiceName, serviceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParameters__Signature() {
		if (parameters__Signature == null) {
			parameters__Signature = new EObjectContainmentEList(Parameter.class, this, RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE);
		}
		return parameters__Signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getReturntype__Signature() {
		return returntype__Signature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturntype__Signature(DataType newReturntype__Signature, NotificationChain msgs) {
		DataType oldReturntype__Signature = returntype__Signature;
		returntype__Signature = newReturntype__Signature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE, oldReturntype__Signature, newReturntype__Signature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturntype__Signature(DataType newReturntype__Signature) {
		if (newReturntype__Signature != returntype__Signature) {
			NotificationChain msgs = null;
			if (returntype__Signature != null)
				msgs = ((InternalEObject)returntype__Signature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE, null, msgs);
			if (newReturntype__Signature != null)
				msgs = ((InternalEObject)newReturntype__Signature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE, null, msgs);
			msgs = basicSetReturntype__Signature(newReturntype__Signature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE, newReturntype__Signature, newReturntype__Signature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getExceptions__Signature() {
		if (exceptions__Signature == null) {
			exceptions__Signature = new EObjectContainmentEList(ExceptionType.class, this, RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE);
		}
		return exceptions__Signature;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ParameterNamesHaveToBeUniqueForASignature(DiagnosticChain diagnostics, Map context) {
		if (ParameterNamesHaveToBeUniqueForASignatureInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.parameters__Signature->isUnique(p : Parameter |   p.parameterName  ) ";
			
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE:
				return ((InternalEList)getParameters__Signature()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE:
				return basicSetReturntype__Signature(null, msgs);
			case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
				return ((InternalEList)getExceptions__Signature()).basicRemove(otherEnd, msgs);
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
			case RepositoryPackage.SIGNATURE__SERVICE_NAME:
				return getServiceName();
			case RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE:
				return getParameters__Signature();
			case RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE:
				return getReturntype__Signature();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RepositoryPackage.SIGNATURE__SERVICE_NAME:
				setServiceName((String)newValue);
				return;
			case RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE:
				getParameters__Signature().clear();
				getParameters__Signature().addAll((Collection)newValue);
				return;
			case RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE:
				setReturntype__Signature((DataType)newValue);
				return;
			case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
				getExceptions__Signature().clear();
				getExceptions__Signature().addAll((Collection)newValue);
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
			case RepositoryPackage.SIGNATURE__SERVICE_NAME:
				setServiceName(SERVICE_NAME_EDEFAULT);
				return;
			case RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE:
				getParameters__Signature().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RepositoryPackage.SIGNATURE__SERVICE_NAME:
				return SERVICE_NAME_EDEFAULT == null ? serviceName != null : !SERVICE_NAME_EDEFAULT.equals(serviceName);
			case RepositoryPackage.SIGNATURE__PARAMETERS_SIGNATURE:
				return parameters__Signature != null && !parameters__Signature.isEmpty();
			case RepositoryPackage.SIGNATURE__RETURNTYPE_SIGNATURE:
				return returntype__Signature != null;
			case RepositoryPackage.SIGNATURE__EXCEPTIONS_SIGNATURE:
				return exceptions__Signature != null && !exceptions__Signature.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (serviceName: ");
		result.append(serviceName);
		result.append(')');
		return result.toString();
	}

} //SignatureImpl