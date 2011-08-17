/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl;

import de.fzi.gast.functions.Function;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Call Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.MethodCallLoggingPositionLinkImpl#getLinkedServiceEffectSpecification <em>Linked Service Effect Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.MethodCallLoggingPositionLinkImpl#getProvidedFunction <em>Provided Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.MethodCallLoggingPositionLinkImpl#getParameterLinks <em>Parameter Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodCallLoggingPositionLinkImpl extends InputLoggingPositionLinkImpl implements MethodCallLoggingPositionLink {
	/**
	 * The cached value of the '{@link #getLinkedServiceEffectSpecification() <em>Linked Service Effect Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedServiceEffectSpecification()
	 * @generated
	 * @ordered
	 */
	protected ResourceDemandingSEFF linkedServiceEffectSpecification;

	/**
	 * The cached value of the '{@link #getProvidedFunction() <em>Provided Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedFunction()
	 * @generated
	 * @ordered
	 */
	protected Function providedFunction;

	/**
	 * The cached value of the '{@link #getParameterLinks() <em>Parameter Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterLink> parameterLinks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodCallLoggingPositionLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoggerlinkPackage.Literals.METHOD_CALL_LOGGING_POSITION_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingSEFF getLinkedServiceEffectSpecification() {
		if (linkedServiceEffectSpecification != null && linkedServiceEffectSpecification.eIsProxy()) {
			InternalEObject oldLinkedServiceEffectSpecification = (InternalEObject)linkedServiceEffectSpecification;
			linkedServiceEffectSpecification = (ResourceDemandingSEFF)eResolveProxy(oldLinkedServiceEffectSpecification);
			if (linkedServiceEffectSpecification != oldLinkedServiceEffectSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__LINKED_SERVICE_EFFECT_SPECIFICATION, oldLinkedServiceEffectSpecification, linkedServiceEffectSpecification));
			}
		}
		return linkedServiceEffectSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingSEFF basicGetLinkedServiceEffectSpecification() {
		return linkedServiceEffectSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkedServiceEffectSpecification(ResourceDemandingSEFF newLinkedServiceEffectSpecification) {
		ResourceDemandingSEFF oldLinkedServiceEffectSpecification = linkedServiceEffectSpecification;
		linkedServiceEffectSpecification = newLinkedServiceEffectSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__LINKED_SERVICE_EFFECT_SPECIFICATION, oldLinkedServiceEffectSpecification, linkedServiceEffectSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getProvidedFunction() {
		if (providedFunction != null && providedFunction.eIsProxy()) {
			InternalEObject oldProvidedFunction = (InternalEObject)providedFunction;
			providedFunction = (Function)eResolveProxy(oldProvidedFunction);
			if (providedFunction != oldProvidedFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__PROVIDED_FUNCTION, oldProvidedFunction, providedFunction));
			}
		}
		return providedFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetProvidedFunction() {
		return providedFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvidedFunction(Function newProvidedFunction) {
		Function oldProvidedFunction = providedFunction;
		providedFunction = newProvidedFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__PROVIDED_FUNCTION, oldProvidedFunction, providedFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterLink> getParameterLinks() {
		if (parameterLinks == null) {
			parameterLinks = new EObjectContainmentEList<ParameterLink>(ParameterLink.class, this, LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__PARAMETER_LINKS);
		}
		return parameterLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__PARAMETER_LINKS:
				return ((InternalEList<?>)getParameterLinks()).basicRemove(otherEnd, msgs);
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
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__LINKED_SERVICE_EFFECT_SPECIFICATION:
				if (resolve) return getLinkedServiceEffectSpecification();
				return basicGetLinkedServiceEffectSpecification();
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__PROVIDED_FUNCTION:
				if (resolve) return getProvidedFunction();
				return basicGetProvidedFunction();
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__PARAMETER_LINKS:
				return getParameterLinks();
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
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__LINKED_SERVICE_EFFECT_SPECIFICATION:
				setLinkedServiceEffectSpecification((ResourceDemandingSEFF)newValue);
				return;
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__PROVIDED_FUNCTION:
				setProvidedFunction((Function)newValue);
				return;
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__PARAMETER_LINKS:
				getParameterLinks().clear();
				getParameterLinks().addAll((Collection<? extends ParameterLink>)newValue);
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
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__LINKED_SERVICE_EFFECT_SPECIFICATION:
				setLinkedServiceEffectSpecification((ResourceDemandingSEFF)null);
				return;
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__PROVIDED_FUNCTION:
				setProvidedFunction((Function)null);
				return;
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__PARAMETER_LINKS:
				getParameterLinks().clear();
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
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__LINKED_SERVICE_EFFECT_SPECIFICATION:
				return linkedServiceEffectSpecification != null;
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__PROVIDED_FUNCTION:
				return providedFunction != null;
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK__PARAMETER_LINKS:
				return parameterLinks != null && !parameterLinks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MethodCallLoggingPositionLinkImpl
