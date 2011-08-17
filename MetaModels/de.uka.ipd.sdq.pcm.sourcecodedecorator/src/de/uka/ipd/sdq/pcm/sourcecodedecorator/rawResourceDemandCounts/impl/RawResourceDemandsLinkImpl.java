/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Raw Resource Demands Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsLinkImpl#getInternalAction <em>Internal Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsLinkImpl#getBytecodeMonitoringRuns <em>Bytecode Monitoring Runs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RawResourceDemandsLinkImpl extends IdentifierImpl implements RawResourceDemandsLink {
	/**
	 * The cached value of the '{@link #getInternalAction() <em>Internal Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalAction()
	 * @generated
	 * @ordered
	 */
	protected AbstractInternalControlFlowAction internalAction;

	/**
	 * The cached value of the '{@link #getBytecodeMonitoringRuns() <em>Bytecode Monitoring Runs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBytecodeMonitoringRuns()
	 * @generated
	 * @ordered
	 */
	protected EList<BytecodeMonitoringRun> bytecodeMonitoringRuns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RawResourceDemandsLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawResourceDemandCountsPackage.Literals.RAW_RESOURCE_DEMANDS_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractInternalControlFlowAction getInternalAction() {
		if (internalAction != null && internalAction.eIsProxy()) {
			InternalEObject oldInternalAction = (InternalEObject)internalAction;
			internalAction = (AbstractInternalControlFlowAction)eResolveProxy(oldInternalAction);
			if (internalAction != oldInternalAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__INTERNAL_ACTION, oldInternalAction, internalAction));
			}
		}
		return internalAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractInternalControlFlowAction basicGetInternalAction() {
		return internalAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalAction(AbstractInternalControlFlowAction newInternalAction) {
		AbstractInternalControlFlowAction oldInternalAction = internalAction;
		internalAction = newInternalAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__INTERNAL_ACTION, oldInternalAction, internalAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BytecodeMonitoringRun> getBytecodeMonitoringRuns() {
		if (bytecodeMonitoringRuns == null) {
			bytecodeMonitoringRuns = new EObjectWithInverseResolvingEList<BytecodeMonitoringRun>(BytecodeMonitoringRun.class, this, RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS, RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK);
		}
		return bytecodeMonitoringRuns;
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
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBytecodeMonitoringRuns()).basicAdd(otherEnd, msgs);
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
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS:
				return ((InternalEList<?>)getBytecodeMonitoringRuns()).basicRemove(otherEnd, msgs);
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
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__INTERNAL_ACTION:
				if (resolve) return getInternalAction();
				return basicGetInternalAction();
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS:
				return getBytecodeMonitoringRuns();
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
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__INTERNAL_ACTION:
				setInternalAction((AbstractInternalControlFlowAction)newValue);
				return;
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS:
				getBytecodeMonitoringRuns().clear();
				getBytecodeMonitoringRuns().addAll((Collection<? extends BytecodeMonitoringRun>)newValue);
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
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__INTERNAL_ACTION:
				setInternalAction((AbstractInternalControlFlowAction)null);
				return;
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS:
				getBytecodeMonitoringRuns().clear();
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
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__INTERNAL_ACTION:
				return internalAction != null;
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS:
				return bytecodeMonitoringRuns != null && !bytecodeMonitoringRuns.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RawResourceDemandsLinkImpl
