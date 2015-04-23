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
import org.eclipse.emf.ecore.EObject;
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
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Interface</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getParentInterfaces__Interface <em>Parent Interfaces Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getProtocols__Interface <em>Protocols Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getRequiredCharacterisations <em>Required Characterisations</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.InterfaceImpl#getRepository__Interface <em>Repository Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InterfaceImpl extends EntityImpl implements Interface {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getParentInterfaces__Interface() <em>Parent Interfaces Interface</em>}' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getParentInterfaces__Interface()
	 * @generated
	 * @ordered
	 */
	protected EList<Interface> parentInterfaces__Interface;

	/**
	 * The cached value of the '{@link #getProtocols__Interface() <em>Protocols Interface</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProtocols__Interface()
	 * @generated
	 * @ordered
	 */
	protected EList<Protocol> protocols__Interface;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected InterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.INTERFACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Interface> getParentInterfaces__Interface() {
		if (parentInterfaces__Interface == null) {
			parentInterfaces__Interface = new EObjectResolvingEList<Interface>(
					Interface.class, this,
					RepositoryPackage.INTERFACE__PARENT_INTERFACES_INTERFACE);
		}
		return parentInterfaces__Interface;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Protocol> getProtocols__Interface() {
		if (protocols__Interface == null) {
			protocols__Interface = new EObjectContainmentEList<Protocol>(
					Protocol.class, this,
					RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE);
		}
		return protocols__Interface;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RequiredCharacterisation> getRequiredCharacterisations() {
		if (requiredCharacterisations == null) {
			requiredCharacterisations = new EObjectContainmentWithInverseEList<RequiredCharacterisation>(
					RequiredCharacterisation.class,
					this,
					RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS,
					RepositoryPackage.REQUIRED_CHARACTERISATION__INTERFACE_REQUIRED_CHARACTERISATION);
		}
		return requiredCharacterisations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Repository getRepository__Interface() {
		if (eContainerFeatureID() != RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE)
			return null;
		return (Repository) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository__Interface(
			Repository newRepository__Interface, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newRepository__Interface,
				RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepository__Interface(Repository newRepository__Interface) {
		if (newRepository__Interface != eInternalContainer()
				|| (eContainerFeatureID() != RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE && newRepository__Interface != null)) {
			if (EcoreUtil.isAncestor(this, (EObject) newRepository__Interface))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepository__Interface != null)
				msgs = ((InternalEObject) newRepository__Interface)
						.eInverseAdd(
								this,
								RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY,
								Repository.class, msgs);
			msgs = basicSetRepository__Interface(newRepository__Interface, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE,
					newRepository__Interface, newRepository__Interface));
	}

	/**
	 * The cached OCL expression body for the '{@link #NoProtocolTypeIDUsedTwice(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Protocol Type ID Used Twice</em>}' operation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #NoProtocolTypeIDUsedTwice(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.protocols__Interface->forAll(p1, p2 |\n"
			+ "p1.protocolTypeID <> p2.protocolTypeID)\n" + "";

	/**
	 * The cached OCL invariant for the '{@link #NoProtocolTypeIDUsedTwice(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>No Protocol Type ID Used Twice</em>}' invariant operation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #NoProtocolTypeIDUsedTwice(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean NoProtocolTypeIDUsedTwice(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.INTERFACE);
			try {
				NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
						.createInvariant(NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			} catch (ParserException pe) {
				throw new UnsupportedOperationException(
						pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(
				NO_PROTOCOL_TYPE_ID_USED_TWICE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
				.check(this)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(
								Diagnostic.ERROR,
								RepositoryValidator.DIAGNOSTIC_SOURCE,
								RepositoryValidator.INTERFACE__NO_PROTOCOL_TYPE_ID_USED_TWICE,
								EcorePlugin.INSTANCE.getString(
										"_UI_GenericInvariant_diagnostic",
										new Object[] {
												"NoProtocolTypeIDUsedTwice",
												EObjectValidator
														.getObjectLabel(this,
																context) }),
								new Object[] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRequiredCharacterisations())
					.basicAdd(otherEnd, msgs);
		case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetRepository__Interface((Repository) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
			return ((InternalEList<?>) getProtocols__Interface()).basicRemove(
					otherEnd, msgs);
		case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
			return ((InternalEList<?>) getRequiredCharacterisations())
					.basicRemove(otherEnd, msgs);
		case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
			return basicSetRepository__Interface(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
			return eInternalContainer().eInverseRemove(this,
					RepositoryPackage.REPOSITORY__INTERFACES_REPOSITORY,
					Repository.class, msgs);
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
		case RepositoryPackage.INTERFACE__PARENT_INTERFACES_INTERFACE:
			return getParentInterfaces__Interface();
		case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
			return getProtocols__Interface();
		case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
			return getRequiredCharacterisations();
		case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
			return getRepository__Interface();
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
		case RepositoryPackage.INTERFACE__PARENT_INTERFACES_INTERFACE:
			getParentInterfaces__Interface().clear();
			getParentInterfaces__Interface().addAll(
					(Collection<? extends Interface>) newValue);
			return;
		case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
			getProtocols__Interface().clear();
			getProtocols__Interface().addAll(
					(Collection<? extends Protocol>) newValue);
			return;
		case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
			getRequiredCharacterisations().clear();
			getRequiredCharacterisations().addAll(
					(Collection<? extends RequiredCharacterisation>) newValue);
			return;
		case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
			setRepository__Interface((Repository) newValue);
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
		case RepositoryPackage.INTERFACE__PARENT_INTERFACES_INTERFACE:
			getParentInterfaces__Interface().clear();
			return;
		case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
			getProtocols__Interface().clear();
			return;
		case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
			getRequiredCharacterisations().clear();
			return;
		case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
			setRepository__Interface((Repository) null);
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
		case RepositoryPackage.INTERFACE__PARENT_INTERFACES_INTERFACE:
			return parentInterfaces__Interface != null
					&& !parentInterfaces__Interface.isEmpty();
		case RepositoryPackage.INTERFACE__PROTOCOLS_INTERFACE:
			return protocols__Interface != null
					&& !protocols__Interface.isEmpty();
		case RepositoryPackage.INTERFACE__REQUIRED_CHARACTERISATIONS:
			return requiredCharacterisations != null
					&& !requiredCharacterisations.isEmpty();
		case RepositoryPackage.INTERFACE__REPOSITORY_INTERFACE:
			return getRepository__Interface() != null;
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

} // InterfaceImpl
