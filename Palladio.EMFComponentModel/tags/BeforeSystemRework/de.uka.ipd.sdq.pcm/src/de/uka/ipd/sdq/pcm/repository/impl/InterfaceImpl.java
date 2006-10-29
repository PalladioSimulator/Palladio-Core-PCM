
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.protocol.Protocol;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;

import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
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
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getParentInterface__Interface <em>Parent Interface Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getAnchestorInterfaces <em>Anchestor Interfaces</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getProtocols__Interface <em>Protocols Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getSignatures__Interface <em>Signatures Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceImpl extends EntityImpl implements Interface {
	/**
	 * The cached value of the '{@link #getParentInterface__Interface() <em>Parent Interface Interface</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentInterface__Interface()
	 * @generated
	 * @ordered
	 */
	protected EList parentInterface__Interface = null;

	/**
	 * The cached value of the '{@link #getAnchestorInterfaces() <em>Anchestor Interfaces</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnchestorInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList anchestorInterfaces = null;

	/**
	 * The cached value of the '{@link #getProtocols__Interface() <em>Protocols Interface</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocols__Interface()
	 * @generated
	 * @ordered
	 */
	protected EList protocols__Interface = null;


	/**
	 * The cached value of the '{@link #getSignatures__Interface() <em>Signatures Interface</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignatures__Interface()
	 * @generated
	 * @ordered
	 */
	protected EList signatures__Interface = null;


	/**
	 * The parsed OCL expression for the definition of the '{@link #noProtocolTypeIDUsedTwice <em>No Protocol Type ID Used Twice</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #noProtocolTypeIDUsedTwice
	 * @generated
	 */
	private static OCLExpression noProtocolTypeIDUsedTwiceInvOCL;
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #SignaturesHaveToBeUniqueForAnInterface <em>Signatures Have To Be Unique For An Interface</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SignaturesHaveToBeUniqueForAnInterface
	 * @generated
	 */
	private static OCLExpression SignaturesHaveToBeUniqueForAnInterfaceInvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParentInterface__Interface() {
		if (parentInterface__Interface == null) {
			parentInterface__Interface = new EObjectResolvingEList(Interface.class, this, RepositoryPackage.INTERFACE__PARENT_INTERFACE_INTERFACE);
		}
		return parentInterface__Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAnchestorInterfaces() {
		if (anchestorInterfaces == null) {
			anchestorInterfaces = new EObjectResolvingEList(Interface.class, this, RepositoryPackage.INTERFACE__ANCHESTOR_INTERFACES);
		}
		return anchestorInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getProtocols__Interface() {
		if (protocols__Interface == null) {
			protocols__Interface = new EObjectContainmentEList(Protocol.class, this, RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE);
		}
		return protocols__Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSignatures__Interface() {
		if (signatures__Interface == null) {
			signatures__Interface = new EObjectContainmentEList(Signature.class, this, RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE);
		}
		return signatures__Interface;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean noProtocolTypeIDUsedTwice(DiagnosticChain diagnostics, Map context) {
		if (noProtocolTypeIDUsedTwiceInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.protocols->forAll(p1, p2 |  p1.protocolTypeID <> p2.protocolTypeID)  ";
			
			try {
				noProtocolTypeIDUsedTwiceInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(noProtocolTypeIDUsedTwiceInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.INTERFACE__NO_PROTOCOL_TYPE_ID_USED_TWICE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "noProtocolTypeIDUsedTwice", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean SignaturesHaveToBeUniqueForAnInterface(DiagnosticChain diagnostics, Map context) {
		if (SignaturesHaveToBeUniqueForAnInterfaceInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "  let sigs : Bag(       Tuple(returnType : DataType, serviceName : String, parameters : Sequence(DataType) )   ) =   self.signatures->collect(sig : Signature |   Tuple{    returnType : DataType = sig.returntype,    serviceName : String = sig.serviceName,    parameters : Sequence(DataType) = sig.parameters.datatype   }  )  in  sigs->isUnique(sigs) ";
			
			try {
				SignaturesHaveToBeUniqueForAnInterfaceInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(SignaturesHaveToBeUniqueForAnInterfaceInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.INTERFACE__SIGNATURES_HAVE_TO_BE_UNIQUE_FOR_AN_INTERFACE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "SignaturesHaveToBeUniqueForAnInterface", EObjectValidator.getObjectLabel(this, context) }),
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
			case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
				return ((InternalEList)getProtocols__Interface()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE:
				return ((InternalEList)getSignatures__Interface()).basicRemove(otherEnd, msgs);
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
			case RepositoryPackage.INTERFACE__PARENT_INTERFACE_INTERFACE:
				return getParentInterface__Interface();
			case RepositoryPackage.INTERFACE__ANCHESTOR_INTERFACES:
				return getAnchestorInterfaces();
			case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
				return getProtocols__Interface();
			case RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE:
				return getSignatures__Interface();
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
			case RepositoryPackage.INTERFACE__PARENT_INTERFACE_INTERFACE:
				getParentInterface__Interface().clear();
				getParentInterface__Interface().addAll((Collection)newValue);
				return;
			case RepositoryPackage.INTERFACE__ANCHESTOR_INTERFACES:
				getAnchestorInterfaces().clear();
				getAnchestorInterfaces().addAll((Collection)newValue);
				return;
			case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
				getProtocols__Interface().clear();
				getProtocols__Interface().addAll((Collection)newValue);
				return;
			case RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE:
				getSignatures__Interface().clear();
				getSignatures__Interface().addAll((Collection)newValue);
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
			case RepositoryPackage.INTERFACE__PARENT_INTERFACE_INTERFACE:
				getParentInterface__Interface().clear();
				return;
			case RepositoryPackage.INTERFACE__ANCHESTOR_INTERFACES:
				getAnchestorInterfaces().clear();
				return;
			case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
				getProtocols__Interface().clear();
				return;
			case RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE:
				getSignatures__Interface().clear();
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
			case RepositoryPackage.INTERFACE__PARENT_INTERFACE_INTERFACE:
				return parentInterface__Interface != null && !parentInterface__Interface.isEmpty();
			case RepositoryPackage.INTERFACE__ANCHESTOR_INTERFACES:
				return anchestorInterfaces != null && !anchestorInterfaces.isEmpty();
			case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
				return protocols__Interface != null && !protocols__Interface.isEmpty();
			case RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE:
				return signatures__Interface != null && !signatures__Interface.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InterfaceImpl