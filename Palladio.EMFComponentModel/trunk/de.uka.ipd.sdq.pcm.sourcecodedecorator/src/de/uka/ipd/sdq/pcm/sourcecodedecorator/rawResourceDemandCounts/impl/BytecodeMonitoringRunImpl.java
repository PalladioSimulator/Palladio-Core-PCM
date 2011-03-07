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
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCharacterisationValue;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCount;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink;

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
 * An implementation of the model object '<em><b>Bytecode Monitoring Run</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.BytecodeMonitoringRunImpl#getMeasuredCounts <em>Measured Counts</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.BytecodeMonitoringRunImpl#getInputParameterCharacterisations <em>Input Parameter Characterisations</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.BytecodeMonitoringRunImpl#getEnvironmentCharacterisation <em>Environment Characterisation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.BytecodeMonitoringRunImpl#getRawResourceDemandsLink <em>Raw Resource Demands Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BytecodeMonitoringRunImpl extends IdentifierImpl implements BytecodeMonitoringRun {
	/**
	 * The cached value of the '{@link #getMeasuredCounts() <em>Measured Counts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasuredCounts()
	 * @generated
	 * @ordered
	 */
	protected EList<MeasuredCount> measuredCounts;

	/**
	 * The cached value of the '{@link #getInputParameterCharacterisations() <em>Input Parameter Characterisations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputParameterCharacterisations()
	 * @generated
	 * @ordered
	 */
	protected EList<MeasuredCharacterisationValue> inputParameterCharacterisations;

	/**
	 * The cached value of the '{@link #getEnvironmentCharacterisation() <em>Environment Characterisation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironmentCharacterisation()
	 * @generated
	 * @ordered
	 */
	protected EnvironmentCharacterisation environmentCharacterisation;

	/**
	 * The cached value of the '{@link #getRawResourceDemandsLink() <em>Raw Resource Demands Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRawResourceDemandsLink()
	 * @generated
	 * @ordered
	 */
	protected RawResourceDemandsLink rawResourceDemandsLink;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BytecodeMonitoringRunImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RawResourceDemandCountsPackage.Literals.BYTECODE_MONITORING_RUN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MeasuredCount> getMeasuredCounts() {
		if (measuredCounts == null) {
			measuredCounts = new EObjectContainmentEList<MeasuredCount>(MeasuredCount.class, this, RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__MEASURED_COUNTS);
		}
		return measuredCounts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MeasuredCharacterisationValue> getInputParameterCharacterisations() {
		if (inputParameterCharacterisations == null) {
			inputParameterCharacterisations = new EObjectContainmentEList<MeasuredCharacterisationValue>(MeasuredCharacterisationValue.class, this, RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__INPUT_PARAMETER_CHARACTERISATIONS);
		}
		return inputParameterCharacterisations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentCharacterisation getEnvironmentCharacterisation() {
		if (environmentCharacterisation != null && environmentCharacterisation.eIsProxy()) {
			InternalEObject oldEnvironmentCharacterisation = (InternalEObject)environmentCharacterisation;
			environmentCharacterisation = (EnvironmentCharacterisation)eResolveProxy(oldEnvironmentCharacterisation);
			if (environmentCharacterisation != oldEnvironmentCharacterisation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION, oldEnvironmentCharacterisation, environmentCharacterisation));
			}
		}
		return environmentCharacterisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnvironmentCharacterisation basicGetEnvironmentCharacterisation() {
		return environmentCharacterisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnvironmentCharacterisation(EnvironmentCharacterisation newEnvironmentCharacterisation, NotificationChain msgs) {
		EnvironmentCharacterisation oldEnvironmentCharacterisation = environmentCharacterisation;
		environmentCharacterisation = newEnvironmentCharacterisation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION, oldEnvironmentCharacterisation, newEnvironmentCharacterisation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnvironmentCharacterisation(EnvironmentCharacterisation newEnvironmentCharacterisation) {
		if (newEnvironmentCharacterisation != environmentCharacterisation) {
			NotificationChain msgs = null;
			if (environmentCharacterisation != null)
				msgs = ((InternalEObject)environmentCharacterisation).eInverseRemove(this, RawResourceDemandCountsPackage.ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS, EnvironmentCharacterisation.class, msgs);
			if (newEnvironmentCharacterisation != null)
				msgs = ((InternalEObject)newEnvironmentCharacterisation).eInverseAdd(this, RawResourceDemandCountsPackage.ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS, EnvironmentCharacterisation.class, msgs);
			msgs = basicSetEnvironmentCharacterisation(newEnvironmentCharacterisation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION, newEnvironmentCharacterisation, newEnvironmentCharacterisation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawResourceDemandsLink getRawResourceDemandsLink() {
		if (rawResourceDemandsLink != null && rawResourceDemandsLink.eIsProxy()) {
			InternalEObject oldRawResourceDemandsLink = (InternalEObject)rawResourceDemandsLink;
			rawResourceDemandsLink = (RawResourceDemandsLink)eResolveProxy(oldRawResourceDemandsLink);
			if (rawResourceDemandsLink != oldRawResourceDemandsLink) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK, oldRawResourceDemandsLink, rawResourceDemandsLink));
			}
		}
		return rawResourceDemandsLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawResourceDemandsLink basicGetRawResourceDemandsLink() {
		return rawResourceDemandsLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawResourceDemandsLink(RawResourceDemandsLink newRawResourceDemandsLink, NotificationChain msgs) {
		RawResourceDemandsLink oldRawResourceDemandsLink = rawResourceDemandsLink;
		rawResourceDemandsLink = newRawResourceDemandsLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK, oldRawResourceDemandsLink, newRawResourceDemandsLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawResourceDemandsLink(RawResourceDemandsLink newRawResourceDemandsLink) {
		if (newRawResourceDemandsLink != rawResourceDemandsLink) {
			NotificationChain msgs = null;
			if (rawResourceDemandsLink != null)
				msgs = ((InternalEObject)rawResourceDemandsLink).eInverseRemove(this, RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS, RawResourceDemandsLink.class, msgs);
			if (newRawResourceDemandsLink != null)
				msgs = ((InternalEObject)newRawResourceDemandsLink).eInverseAdd(this, RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS, RawResourceDemandsLink.class, msgs);
			msgs = basicSetRawResourceDemandsLink(newRawResourceDemandsLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK, newRawResourceDemandsLink, newRawResourceDemandsLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION:
				if (environmentCharacterisation != null)
					msgs = ((InternalEObject)environmentCharacterisation).eInverseRemove(this, RawResourceDemandCountsPackage.ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS, EnvironmentCharacterisation.class, msgs);
				return basicSetEnvironmentCharacterisation((EnvironmentCharacterisation)otherEnd, msgs);
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK:
				if (rawResourceDemandsLink != null)
					msgs = ((InternalEObject)rawResourceDemandsLink).eInverseRemove(this, RawResourceDemandCountsPackage.RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS, RawResourceDemandsLink.class, msgs);
				return basicSetRawResourceDemandsLink((RawResourceDemandsLink)otherEnd, msgs);
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
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__MEASURED_COUNTS:
				return ((InternalEList<?>)getMeasuredCounts()).basicRemove(otherEnd, msgs);
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__INPUT_PARAMETER_CHARACTERISATIONS:
				return ((InternalEList<?>)getInputParameterCharacterisations()).basicRemove(otherEnd, msgs);
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION:
				return basicSetEnvironmentCharacterisation(null, msgs);
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK:
				return basicSetRawResourceDemandsLink(null, msgs);
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
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__MEASURED_COUNTS:
				return getMeasuredCounts();
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__INPUT_PARAMETER_CHARACTERISATIONS:
				return getInputParameterCharacterisations();
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION:
				if (resolve) return getEnvironmentCharacterisation();
				return basicGetEnvironmentCharacterisation();
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK:
				if (resolve) return getRawResourceDemandsLink();
				return basicGetRawResourceDemandsLink();
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
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__MEASURED_COUNTS:
				getMeasuredCounts().clear();
				getMeasuredCounts().addAll((Collection<? extends MeasuredCount>)newValue);
				return;
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__INPUT_PARAMETER_CHARACTERISATIONS:
				getInputParameterCharacterisations().clear();
				getInputParameterCharacterisations().addAll((Collection<? extends MeasuredCharacterisationValue>)newValue);
				return;
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION:
				setEnvironmentCharacterisation((EnvironmentCharacterisation)newValue);
				return;
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK:
				setRawResourceDemandsLink((RawResourceDemandsLink)newValue);
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
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__MEASURED_COUNTS:
				getMeasuredCounts().clear();
				return;
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__INPUT_PARAMETER_CHARACTERISATIONS:
				getInputParameterCharacterisations().clear();
				return;
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION:
				setEnvironmentCharacterisation((EnvironmentCharacterisation)null);
				return;
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK:
				setRawResourceDemandsLink((RawResourceDemandsLink)null);
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
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__MEASURED_COUNTS:
				return measuredCounts != null && !measuredCounts.isEmpty();
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__INPUT_PARAMETER_CHARACTERISATIONS:
				return inputParameterCharacterisations != null && !inputParameterCharacterisations.isEmpty();
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION:
				return environmentCharacterisation != null;
			case RawResourceDemandCountsPackage.BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK:
				return rawResourceDemandsLink != null;
		}
		return super.eIsSet(featureID);
	}

} //BytecodeMonitoringRunImpl
