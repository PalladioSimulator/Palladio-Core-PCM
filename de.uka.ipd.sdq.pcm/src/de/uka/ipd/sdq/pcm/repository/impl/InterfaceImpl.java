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
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.protocol.Protocol;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getParentInterface__Interface <em>Parent Interface Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getAncestorInterfaces_Interface <em>Ancestor Interfaces Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getProtocols__Interface <em>Protocols Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getSignatures__Interface <em>Signatures Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getRepository_Interface <em>Repository Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getRequiredCharacterisations <em>Required Characterisations</em>}</li>
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
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

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
	 * The cached value of the '{@link #getAncestorInterfaces_Interface() <em>Ancestor Interfaces Interface</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAncestorInterfaces_Interface()
	 * @generated not
	 * @ordered
	 */
	protected EList<Interface> ancestorInterfaces_Interface;
	
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
	 * The cached value of the '{@link #getRequiredCharacterisations() <em>Required Characterisations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredCharacterisations()
	 * @generated
	 * @ordered
	 */
	protected EList<RequiredCharacterisation> requiredCharacterisations;

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
	public EList<Interface> getParentInterface__Interface() {
		if (parentInterface__Interface == null) {
			parentInterface__Interface = new EObjectResolvingEList<Interface>(Interface.class, this, RepositoryPackage.INTERFACE__PARENT_INTERFACE_INTERFACE);
		}
		return parentInterface__Interface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public EList<Interface> getAncestorInterfaces_Interface() {
		if (ancestorInterfaces_Interface == null) {
			ancestorInterfaces_Interface = new EObjectResolvingEList<Interface>(Interface.class, this, RepositoryPackage.INTERFACE__ANCESTOR_INTERFACES_INTERFACE);
		}
		return ancestorInterfaces_Interface;
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
		if (eContainerFeatureID() != RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE) return null;
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
		if (newRepository_Interface != eInternalContainer() || (eContainerFeatureID() != RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE && newRepository_Interface != null)) {
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
	public EList<RequiredCharacterisation> getRequiredCharacterisations() {
		if (requiredCharacterisations == null) {
			requiredCharacterisations = new EObjectContainmentWithInverseEList<RequiredCharacterisation>(RequiredCharacterisation.class, this, RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS, RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION);
		}
		return requiredCharacterisations;
	}

	/**
	 * The cached OCL expression body for the '{@link #NoProtocolTypeIDUsedTwice(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Protocol Type ID Used Twice</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NoProtocolTypeIDUsedTwice(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.protocols__Interface->forAll(p1, p2 |\n"+"p1.protocolTypeID <> p2.protocolTypeID)\n"+"";

	/**
	 * The cached OCL invariant for the '{@link #NoProtocolTypeIDUsedTwice(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Protocol Type ID Used Twice</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NoProtocolTypeIDUsedTwice(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean NoProtocolTypeIDUsedTwice(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.INTERFACE);
			try {
				NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
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
	 * The cached OCL expression body for the '{@link #SignaturesHaveToBeUniqueForAnInterface(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Signatures Have To Be Unique For An Interface</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SignaturesHaveToBeUniqueForAnInterface(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String SIGNATURES_HAVE_TO_BE_UNIQUE_FOR_AN_INTERFACE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "-- full signature has to be unique \n"+"-- (use of ocl-tupels) #\n"+"let sigs : Bag(\n"+"	-- parameters: Sequence of DataType, NOT name #\n"+"	-- exceptions have not to be considered #\n"+"	Tuple(returnType : DataType, serviceName : String, parameters : Sequence(DataType) ) \n"+") = \n"+"self.signatures__Interface->collect(sig : Signature |\n"+"	Tuple{\n"+"		returnType : DataType = sig.returntype__Signature,\n"+"		serviceName : String = sig.serviceName,\n"+"		parameters : Sequence(DataType) = sig.parameters__Signature.datatype__Parameter\n"+"	}\n"+")\n"+"in\n"+"sigs->isUnique(s|s)";

	/**
	 * The cached OCL invariant for the '{@link #SignaturesHaveToBeUniqueForAnInterface(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Signatures Have To Be Unique For An Interface</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SignaturesHaveToBeUniqueForAnInterface(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint SIGNATURES_HAVE_TO_BE_UNIQUE_FOR_AN_INTERFACE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean SignaturesHaveToBeUniqueForAnInterface(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (SIGNATURES_HAVE_TO_BE_UNIQUE_FOR_AN_INTERFACE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.INTERFACE);
			try {
				SIGNATURES_HAVE_TO_BE_UNIQUE_FOR_AN_INTERFACE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(SIGNATURES_HAVE_TO_BE_UNIQUE_FOR_AN_INTERFACE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(SIGNATURES_HAVE_TO_BE_UNIQUE_FOR_AN_INTERFACE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
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
			case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredCharacterisations()).basicAdd(otherEnd, msgs);
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
			case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
				return ((InternalEList<?>)getRequiredCharacterisations()).basicRemove(otherEnd, msgs);
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
		switch (eContainerFeatureID()) {
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
			case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
				return getRequiredCharacterisations();
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
			case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
				getRequiredCharacterisations().clear();
				getRequiredCharacterisations().addAll((Collection<? extends RequiredCharacterisation>)newValue);
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
			case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
				getRequiredCharacterisations().clear();
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
			case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
				return requiredCharacterisations != null && !requiredCharacterisations.isEmpty();
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

} //InterfaceImpl
