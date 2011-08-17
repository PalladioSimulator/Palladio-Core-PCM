/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl;

import de.fzi.gast.statements.Statement;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.pcm.seff.InternalAction;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.GastPcmLinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Action Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.InternalActionLinkImpl#getLinkedInternalAction <em>Linked Internal Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.InternalActionLinkImpl#getInternalActionStatements <em>Internal Action Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalActionLinkImpl extends IdentifierImpl implements InternalActionLink {
	/**
	 * The cached value of the '{@link #getLinkedInternalAction() <em>Linked Internal Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedInternalAction()
	 * @generated
	 * @ordered
	 */
	protected InternalAction linkedInternalAction;

	/**
	 * The cached value of the '{@link #getInternalActionStatements() <em>Internal Action Statements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalActionStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> internalActionStatements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalActionLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GastPcmLinkPackage.Literals.INTERNAL_ACTION_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalAction getLinkedInternalAction() {
		if (linkedInternalAction != null && linkedInternalAction.eIsProxy()) {
			InternalEObject oldLinkedInternalAction = (InternalEObject)linkedInternalAction;
			linkedInternalAction = (InternalAction)eResolveProxy(oldLinkedInternalAction);
			if (linkedInternalAction != oldLinkedInternalAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GastPcmLinkPackage.INTERNAL_ACTION_LINK__LINKED_INTERNAL_ACTION, oldLinkedInternalAction, linkedInternalAction));
			}
		}
		return linkedInternalAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalAction basicGetLinkedInternalAction() {
		return linkedInternalAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkedInternalAction(InternalAction newLinkedInternalAction) {
		InternalAction oldLinkedInternalAction = linkedInternalAction;
		linkedInternalAction = newLinkedInternalAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GastPcmLinkPackage.INTERNAL_ACTION_LINK__LINKED_INTERNAL_ACTION, oldLinkedInternalAction, linkedInternalAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getInternalActionStatements() {
		if (internalActionStatements == null) {
			internalActionStatements = new EObjectResolvingEList<Statement>(Statement.class, this, GastPcmLinkPackage.INTERNAL_ACTION_LINK__INTERNAL_ACTION_STATEMENTS);
		}
		return internalActionStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GastPcmLinkPackage.INTERNAL_ACTION_LINK__LINKED_INTERNAL_ACTION:
				if (resolve) return getLinkedInternalAction();
				return basicGetLinkedInternalAction();
			case GastPcmLinkPackage.INTERNAL_ACTION_LINK__INTERNAL_ACTION_STATEMENTS:
				return getInternalActionStatements();
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
			case GastPcmLinkPackage.INTERNAL_ACTION_LINK__LINKED_INTERNAL_ACTION:
				setLinkedInternalAction((InternalAction)newValue);
				return;
			case GastPcmLinkPackage.INTERNAL_ACTION_LINK__INTERNAL_ACTION_STATEMENTS:
				getInternalActionStatements().clear();
				getInternalActionStatements().addAll((Collection<? extends Statement>)newValue);
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
			case GastPcmLinkPackage.INTERNAL_ACTION_LINK__LINKED_INTERNAL_ACTION:
				setLinkedInternalAction((InternalAction)null);
				return;
			case GastPcmLinkPackage.INTERNAL_ACTION_LINK__INTERNAL_ACTION_STATEMENTS:
				getInternalActionStatements().clear();
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
			case GastPcmLinkPackage.INTERNAL_ACTION_LINK__LINKED_INTERNAL_ACTION:
				return linkedInternalAction != null;
			case GastPcmLinkPackage.INTERNAL_ACTION_LINK__INTERNAL_ACTION_STATEMENTS:
				return internalActionStatements != null && !internalActionStatements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InternalActionLinkImpl
