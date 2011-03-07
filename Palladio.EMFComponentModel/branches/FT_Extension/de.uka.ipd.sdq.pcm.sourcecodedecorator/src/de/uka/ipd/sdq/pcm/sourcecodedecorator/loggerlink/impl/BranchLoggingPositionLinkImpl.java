/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BranchLoggingPositionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BranchLoggingPositionLinkImpl#getLinkedGuardedBranchTransition <em>Linked Guarded Branch Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BranchLoggingPositionLinkImpl extends OutputLoggingPositionLinkImpl implements BranchLoggingPositionLink {
	/**
	 * The cached value of the '{@link #getLinkedGuardedBranchTransition() <em>Linked Guarded Branch Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedGuardedBranchTransition()
	 * @generated
	 * @ordered
	 */
	protected GuardedBranchTransition linkedGuardedBranchTransition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BranchLoggingPositionLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LoggerlinkPackage.Literals.BRANCH_LOGGING_POSITION_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardedBranchTransition getLinkedGuardedBranchTransition() {
		if (linkedGuardedBranchTransition != null && linkedGuardedBranchTransition.eIsProxy()) {
			InternalEObject oldLinkedGuardedBranchTransition = (InternalEObject)linkedGuardedBranchTransition;
			linkedGuardedBranchTransition = (GuardedBranchTransition)eResolveProxy(oldLinkedGuardedBranchTransition);
			if (linkedGuardedBranchTransition != oldLinkedGuardedBranchTransition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LoggerlinkPackage.BRANCH_LOGGING_POSITION_LINK__LINKED_GUARDED_BRANCH_TRANSITION, oldLinkedGuardedBranchTransition, linkedGuardedBranchTransition));
			}
		}
		return linkedGuardedBranchTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardedBranchTransition basicGetLinkedGuardedBranchTransition() {
		return linkedGuardedBranchTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkedGuardedBranchTransition(GuardedBranchTransition newLinkedGuardedBranchTransition) {
		GuardedBranchTransition oldLinkedGuardedBranchTransition = linkedGuardedBranchTransition;
		linkedGuardedBranchTransition = newLinkedGuardedBranchTransition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LoggerlinkPackage.BRANCH_LOGGING_POSITION_LINK__LINKED_GUARDED_BRANCH_TRANSITION, oldLinkedGuardedBranchTransition, linkedGuardedBranchTransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LoggerlinkPackage.BRANCH_LOGGING_POSITION_LINK__LINKED_GUARDED_BRANCH_TRANSITION:
				if (resolve) return getLinkedGuardedBranchTransition();
				return basicGetLinkedGuardedBranchTransition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LoggerlinkPackage.BRANCH_LOGGING_POSITION_LINK__LINKED_GUARDED_BRANCH_TRANSITION:
				setLinkedGuardedBranchTransition((GuardedBranchTransition)newValue);
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
			case LoggerlinkPackage.BRANCH_LOGGING_POSITION_LINK__LINKED_GUARDED_BRANCH_TRANSITION:
				setLinkedGuardedBranchTransition((GuardedBranchTransition)null);
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
			case LoggerlinkPackage.BRANCH_LOGGING_POSITION_LINK__LINKED_GUARDED_BRANCH_TRANSITION:
				return linkedGuardedBranchTransition != null;
		}
		return super.eIsSet(featureID);
	}

} //BranchLoggingPositionLinkImpl
