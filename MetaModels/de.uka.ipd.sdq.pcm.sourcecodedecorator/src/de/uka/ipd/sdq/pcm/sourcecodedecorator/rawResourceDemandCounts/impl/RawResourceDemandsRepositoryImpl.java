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
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Raw Resource Demands Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsRepositoryImpl#getBytecodeMonitoringRuns <em>Bytecode Monitoring Runs</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsRepositoryImpl#getRawResourceDemandsLinks <em>Raw Resource Demands Links</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandsRepositoryImpl#getEnvironmentCharacterisations <em>Environment Characterisations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RawResourceDemandsRepositoryImpl extends IdentifierImpl implements RawResourceDemandsRepository {
	/**
	 * The cached value of the '{@link #getBytecodeMonitoringRuns() <em>Bytecode Monitoring Runs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBytecodeMonitoringRuns()
	 * @generated
	 * @ordered
	 */
	protected EList<BytecodeMonitoringRun> bytecodeMonitoringRuns;

	/**
	 * The cached value of the '{@link #getRawResourceDemandsLinks() <em>Raw Resource Demands Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawResourceDemandsLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<RawResourceDemandsLink> rawResourceDemandsLinks;

	/**
	 * The cached value of the '{@link #getEnvironmentCharacterisations() <em>Environment Characterisations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironmentCharacterisations()
	 * @generated
	 * @ordered
	 */
	protected EList<EnvironmentCharacterisation> environmentCharacterisations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RawResourceDemandsRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawResourceDemandCountsPackage.Literals.RAW_RESOURCE_DEMANDS_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BytecodeMonitoringRun> getBytecodeMonitoringRuns() {
		if (bytecodeMonitoringRuns == null) {
			bytecodeMonitoringRuns = new EObjectContainmentEList<BytecodeMonitoringRun>(BytecodeMonitoringRun.class, this, RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__BYTECODE_MONITORING_RUNS);
		}
		return bytecodeMonitoringRuns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RawResourceDemandsLink> getRawResourceDemandsLinks() {
		if (rawResourceDemandsLinks == null) {
			rawResourceDemandsLinks = new EObjectContainmentEList<RawResourceDemandsLink>(RawResourceDemandsLink.class, this, RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__RAW_RESOURCE_DEMANDS_LINKS);
		}
		return rawResourceDemandsLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnvironmentCharacterisation> getEnvironmentCharacterisations() {
		if (environmentCharacterisations == null) {
			environmentCharacterisations = new EObjectContainmentEList<EnvironmentCharacterisation>(EnvironmentCharacterisation.class, this, RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__ENVIRONMENT_CHARACTERISATIONS);
		}
		return environmentCharacterisations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__BYTECODE_MONITORING_RUNS:
				return ((InternalEList<?>)getBytecodeMonitoringRuns()).basicRemove(otherEnd, msgs);
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__RAW_RESOURCE_DEMANDS_LINKS:
				return ((InternalEList<?>)getRawResourceDemandsLinks()).basicRemove(otherEnd, msgs);
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__ENVIRONMENT_CHARACTERISATIONS:
				return ((InternalEList<?>)getEnvironmentCharacterisations()).basicRemove(otherEnd, msgs);
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
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__BYTECODE_MONITORING_RUNS:
				return getBytecodeMonitoringRuns();
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__RAW_RESOURCE_DEMANDS_LINKS:
				return getRawResourceDemandsLinks();
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__ENVIRONMENT_CHARACTERISATIONS:
				return getEnvironmentCharacterisations();
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
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__BYTECODE_MONITORING_RUNS:
				getBytecodeMonitoringRuns().clear();
				getBytecodeMonitoringRuns().addAll((Collection<? extends BytecodeMonitoringRun>)newValue);
				return;
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__RAW_RESOURCE_DEMANDS_LINKS:
				getRawResourceDemandsLinks().clear();
				getRawResourceDemandsLinks().addAll((Collection<? extends RawResourceDemandsLink>)newValue);
				return;
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__ENVIRONMENT_CHARACTERISATIONS:
				getEnvironmentCharacterisations().clear();
				getEnvironmentCharacterisations().addAll((Collection<? extends EnvironmentCharacterisation>)newValue);
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
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__BYTECODE_MONITORING_RUNS:
				getBytecodeMonitoringRuns().clear();
				return;
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__RAW_RESOURCE_DEMANDS_LINKS:
				getRawResourceDemandsLinks().clear();
				return;
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__ENVIRONMENT_CHARACTERISATIONS:
				getEnvironmentCharacterisations().clear();
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
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__BYTECODE_MONITORING_RUNS:
				return bytecodeMonitoringRuns != null && !bytecodeMonitoringRuns.isEmpty();
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__RAW_RESOURCE_DEMANDS_LINKS:
				return rawResourceDemandsLinks != null && !rawResourceDemandsLinks.isEmpty();
			case RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_REPOSITORY__ENVIRONMENT_CHARACTERISATIONS:
				return environmentCharacterisations != null && !environmentCharacterisations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RawResourceDemandsRepositoryImpl
