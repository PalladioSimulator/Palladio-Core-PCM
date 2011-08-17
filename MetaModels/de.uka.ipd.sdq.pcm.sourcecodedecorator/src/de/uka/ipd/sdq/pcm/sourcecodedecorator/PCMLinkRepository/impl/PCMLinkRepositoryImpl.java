/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepositoryPackage;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCM Link Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl.PCMLinkRepositoryImpl#getLoggingPositionLinks <em>Logging Position Links</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl.PCMLinkRepositoryImpl#getInternalActionLinks <em>Internal Action Links</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl.PCMLinkRepositoryImpl#getInputParameterLinks <em>Input Parameter Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMLinkRepositoryImpl extends IdentifierImpl implements PCMLinkRepository {
	/**
	 * The cached value of the '{@link #getLoggingPositionLinks() <em>Logging Position Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoggingPositionLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<LoggingPositionIdLink> loggingPositionLinks;

	/**
	 * The cached value of the '{@link #getInternalActionLinks() <em>Internal Action Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalActionLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<InternalActionLink> internalActionLinks;

	/**
	 * The cached value of the '{@link #getInputParameterLinks() <em>Input Parameter Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParameterLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterLink> inputParameterLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMLinkRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PCMLinkRepositoryPackage.Literals.PCM_LINK_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LoggingPositionIdLink> getLoggingPositionLinks() {
		if (loggingPositionLinks == null) {
			loggingPositionLinks = new EObjectContainmentEList<LoggingPositionIdLink>(LoggingPositionIdLink.class, this, PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_LINKS);
		}
		return loggingPositionLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InternalActionLink> getInternalActionLinks() {
		if (internalActionLinks == null) {
			internalActionLinks = new EObjectContainmentEList<InternalActionLink>(InternalActionLink.class, this, PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__INTERNAL_ACTION_LINKS);
		}
		return internalActionLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterLink> getInputParameterLinks() {
		if (inputParameterLinks == null) {
			inputParameterLinks = new EObjectContainmentEList<ParameterLink>(ParameterLink.class, this, PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__INPUT_PARAMETER_LINKS);
		}
		return inputParameterLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_LINKS:
				return ((InternalEList<?>)getLoggingPositionLinks()).basicRemove(otherEnd, msgs);
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__INTERNAL_ACTION_LINKS:
				return ((InternalEList<?>)getInternalActionLinks()).basicRemove(otherEnd, msgs);
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__INPUT_PARAMETER_LINKS:
				return ((InternalEList<?>)getInputParameterLinks()).basicRemove(otherEnd, msgs);
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
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_LINKS:
				return getLoggingPositionLinks();
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__INTERNAL_ACTION_LINKS:
				return getInternalActionLinks();
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__INPUT_PARAMETER_LINKS:
				return getInputParameterLinks();
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
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_LINKS:
				getLoggingPositionLinks().clear();
				getLoggingPositionLinks().addAll((Collection<? extends LoggingPositionIdLink>)newValue);
				return;
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__INTERNAL_ACTION_LINKS:
				getInternalActionLinks().clear();
				getInternalActionLinks().addAll((Collection<? extends InternalActionLink>)newValue);
				return;
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__INPUT_PARAMETER_LINKS:
				getInputParameterLinks().clear();
				getInputParameterLinks().addAll((Collection<? extends ParameterLink>)newValue);
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
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_LINKS:
				getLoggingPositionLinks().clear();
				return;
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__INTERNAL_ACTION_LINKS:
				getInternalActionLinks().clear();
				return;
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__INPUT_PARAMETER_LINKS:
				getInputParameterLinks().clear();
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
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_LINKS:
				return loggingPositionLinks != null && !loggingPositionLinks.isEmpty();
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__INTERNAL_ACTION_LINKS:
				return internalActionLinks != null && !internalActionLinks.isEmpty();
			case PCMLinkRepositoryPackage.PCM_LINK_REPOSITORY__INPUT_PARAMETER_LINKS:
				return inputParameterLinks != null && !inputParameterLinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PCMLinkRepositoryImpl
