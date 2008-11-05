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
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
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

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.protocol.Protocol;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#isIsResourceInterface <em>Is Resource Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getParentInterface__Interface <em>Parent Interface Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getAncestorInterfaces_Interface <em>Ancestor Interfaces Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getProtocols__Interface <em>Protocols Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getSignatures__Interface <em>Signatures Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getRepository_Interface <em>Repository Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InterfaceImpl extends EntityImpl implements Interface {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The default value of the '{@link #isIsResourceInterface() <em>Is Resource Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsResourceInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_RESOURCE_INTERFACE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsResourceInterface() <em>Is Resource Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsResourceInterface()
	 * @generated
	 * @ordered
	 */
	protected boolean isResourceInterface = IS_RESOURCE_INTERFACE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParentInterface__Interface() <em>Parent Interface Interface</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentInterface__Interface()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> parentInterface__Interface;

	/**
	 * The cached value of the '{@link #getProtocols__Interface() <em>Protocols Interface</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocols__Interface()
	 * @generated
	 * @ordered
	 */
	protected EList<Protocol> protocols__Interface;

	/**
	 * The cached value of the '{@link #getSignatures__Interface() <em>Signatures Interface</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignatures__Interface()
	 * @generated
	 * @ordered
	 */
	protected EList<Signature> signatures__Interface;

	/**
	 * The parsed OCL expression for the definition of the '{@link #NoProtocolTypeIDUsedTwice <em>No Protocol Type ID Used Twice</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NoProtocolTypeIDUsedTwice
	 * @generated
	 */
	private static OCLExpression NoProtocolTypeIDUsedTwiceInvOCL;
	
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
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsResourceInterface() {
		return isResourceInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsResourceInterface(boolean newIsResourceInterface) {
		boolean oldIsResourceInterface = isResourceInterface;
		isResourceInterface = newIsResourceInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.INTERFACE__IS_RESOURCE_INTERFACE, oldIsResourceInterface, isResourceInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getParentInterface__Interface() {
		if (parentInterface__Interface == null) {
			parentInterface__Interface = new EObjectResolvingEList<Interface>(Interface.class, this, RepositoryPackage.INTERFACE__PARENT_INTERFACE_INTERFACE);
		}
		return parentInterface__Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Interface> getAncestorInterfaces_Interface() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Protocol> getProtocols__Interface() {
		if (protocols__Interface == null) {
			protocols__Interface = new EObjectContainmentEList<Protocol>(Protocol.class, this, RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE);
		}
		return protocols__Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Signature> getSignatures__Interface() {
		if (signatures__Interface == null) {
			signatures__Interface = new EObjectContainmentWithInverseEList<Signature>(Signature.class, this, RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE, RepositoryPackage.SIGNATURE__INTERFACE_SIGNATURE);
		}
		return signatures__Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository getRepository_Interface() {
		if (eContainerFeatureID != RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE) return null;
		return (Repository)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository_Interface(Repository newRepository_Interface, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepository_Interface, RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepository_Interface(Repository newRepository_Interface) {
		if (newRepository_Interface != eInternalContainer() || (eContainerFeatureID != RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE && newRepository_Interface != null)) {
			if (EcoreUtil.isAncestor(this, newRepository_Interface))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepository_Interface != null)
				msgs = ((InternalEObject)newRepository_Interface).eInverseAdd(this, RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY, Repository.class, msgs);
			msgs = basicSetRepository_Interface(newRepository_Interface, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE, newRepository_Interface, newRepository_Interface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean NoProtocolTypeIDUsedTwice(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (NoProtocolTypeIDUsedTwiceInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.protocols__Interface->forAll(p1, p2 |  p1.protocolTypeID <> p2.protocolTypeID)  ";
			
			try {
				NoProtocolTypeIDUsedTwiceInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(NoProtocolTypeIDUsedTwiceInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.INTERFACE__NO_PROTOCOL_TYPE_ID_USED_TWICE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "NoProtocolTypeIDUsedTwice", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean SignaturesHaveToBeUniqueForAnInterface(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (SignaturesHaveToBeUniqueForAnInterfaceInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "  let sigs : Bag(  	 	 	Tuple(returnType : DataType, serviceName : String, parameters : Sequence(DataType) )   ) =   self.signatures__Interface->collect(sig : Signature |  	Tuple{  		returnType : DataType = sig.returntype__Signature,  		serviceName : String = sig.serviceName,  		parameters : Sequence(DataType) = sig.parameters__Signature.datatype__Parameter  	}  )  in  sigs->isUnique(s|s) ";
			
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSignatures__Interface()).basicAdd(otherEnd, msgs);
			case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRepository_Interface((Repository)otherEnd, msgs);
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
			case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
				return ((InternalEList<?>)getProtocols__Interface()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE:
				return ((InternalEList<?>)getSignatures__Interface()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
				return basicSetRepository_Interface(null, msgs);
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
			case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY, Repository.class, msgs);
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
			case RepositoryPackage.INTERFACE__IS_RESOURCE_INTERFACE:
				return isIsResourceInterface() ? Boolean.TRUE : Boolean.FALSE;
			case RepositoryPackage.INTERFACE__PARENT_INTERFACE_INTERFACE:
				return getParentInterface__Interface();
			case RepositoryPackage.INTERFACE__ANCESTOR_INTERFACES_INTERFACE:
				return getAncestorInterfaces_Interface();
			case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
				return getProtocols__Interface();
			case RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE:
				return getSignatures__Interface();
			case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
				return getRepository_Interface();
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
			case RepositoryPackage.INTERFACE__IS_RESOURCE_INTERFACE:
				setIsResourceInterface(((Boolean)newValue).booleanValue());
				return;
			case RepositoryPackage.INTERFACE__PARENT_INTERFACE_INTERFACE:
				getParentInterface__Interface().clear();
				getParentInterface__Interface().addAll((Collection<? extends Interface>)newValue);
				return;
			case RepositoryPackage.INTERFACE__ANCESTOR_INTERFACES_INTERFACE:
				getAncestorInterfaces_Interface().clear();
				getAncestorInterfaces_Interface().addAll((Collection<? extends Interface>)newValue);
				return;
			case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
				getProtocols__Interface().clear();
				getProtocols__Interface().addAll((Collection<? extends Protocol>)newValue);
				return;
			case RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE:
				getSignatures__Interface().clear();
				getSignatures__Interface().addAll((Collection<? extends Signature>)newValue);
				return;
			case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
				setRepository_Interface((Repository)newValue);
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
			case RepositoryPackage.INTERFACE__IS_RESOURCE_INTERFACE:
				setIsResourceInterface(IS_RESOURCE_INTERFACE_EDEFAULT);
				return;
			case RepositoryPackage.INTERFACE__PARENT_INTERFACE_INTERFACE:
				getParentInterface__Interface().clear();
				return;
			case RepositoryPackage.INTERFACE__ANCESTOR_INTERFACES_INTERFACE:
				getAncestorInterfaces_Interface().clear();
				return;
			case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
				getProtocols__Interface().clear();
				return;
			case RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE:
				getSignatures__Interface().clear();
				return;
			case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
				setRepository_Interface((Repository)null);
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
			case RepositoryPackage.INTERFACE__IS_RESOURCE_INTERFACE:
				return isResourceInterface != IS_RESOURCE_INTERFACE_EDEFAULT;
			case RepositoryPackage.INTERFACE__PARENT_INTERFACE_INTERFACE:
				return parentInterface__Interface != null && !parentInterface__Interface.isEmpty();
			case RepositoryPackage.INTERFACE__ANCESTOR_INTERFACES_INTERFACE:
				return !getAncestorInterfaces_Interface().isEmpty();
			case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
				return protocols__Interface != null && !protocols__Interface.isEmpty();
			case RepositoryPackage.INTERFACE__SIGNATURES_INTERFACE:
				return signatures__Interface != null && !signatures__Interface.isEmpty();
			case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
				return getRepository_Interface() != null;
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
		result.append(" (isResourceInterface: ");
		result.append(isResourceInterface);
		result.append(')');
		return result.toString();
	}

} //InterfaceImpl
