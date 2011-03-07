/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.EnvironmentCharacterisation;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Environment Characterisation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.EnvironmentCharacterisationImpl#getBytecodeMonitoringRuns <em>Bytecode Monitoring Runs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EnvironmentCharacterisationImpl extends IdentifierImpl implements EnvironmentCharacterisation {
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
	protected EnvironmentCharacterisationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawResourceDemandCountsPackage.Literals.ENVIRONMENT_CHARACTERISATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BytecodeMonitoringRun> getBytecodeMonitoringRuns() {
		if (bytecodeMonitoringRuns == null) {
			bytecodeMonitoringRuns = new EObjectWithInverseResolvingEList<BytecodeMonitoringRun>(BytecodeMonitoringRun.class, this, RawResourceDemandCountsPackage.ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS, RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION);
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
			case RawResourceDemandCountsPackage.ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS:
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
			case RawResourceDemandCountsPackage.ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS:
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
			case RawResourceDemandCountsPackage.ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS:
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
			case RawResourceDemandCountsPackage.ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS:
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
			case RawResourceDemandCountsPackage.ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS:
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
			case RawResourceDemandCountsPackage.ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS:
				return bytecodeMonitoringRuns != null && !bytecodeMonitoringRuns.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EnvironmentCharacterisationImpl
