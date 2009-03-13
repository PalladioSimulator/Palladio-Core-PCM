/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.ByBench.impl;

import de.uka.ipd.sdq.ByBench.AtomicInstruction;
import de.uka.ipd.sdq.ByBench.ByBenchPackage;
import de.uka.ipd.sdq.ByBench.MeasurementEnd;
import de.uka.ipd.sdq.ByBench.MeasurementStart;
import de.uka.ipd.sdq.ByBench.NamedCardinality;
import de.uka.ipd.sdq.ByBench.Scenario;
import de.uka.ipd.sdq.ByBench.ScenarioCore;
import de.uka.ipd.sdq.ByBench.ScenarioPostcondition;
import de.uka.ipd.sdq.ByBench.ScenarioPrecondition;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

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
 * An implementation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.ScenarioImpl#getScenarioprecondition <em>Scenarioprecondition</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.ScenarioImpl#getMeasurementstart <em>Measurementstart</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.ScenarioImpl#getScenariocore <em>Scenariocore</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.ScenarioImpl#getMeasurementend <em>Measurementend</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.ScenarioImpl#getScenariopostcondition <em>Scenariopostcondition</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.ScenarioImpl#getNamedcardinality <em>Namedcardinality</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.ByBench.impl.ScenarioImpl#getBenchmarkedInstruction <em>Benchmarked Instruction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScenarioImpl extends IdentifierImpl implements Scenario {
	/**
	 * The cached value of the '{@link #getScenarioprecondition() <em>Scenarioprecondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarioprecondition()
	 * @generated
	 * @ordered
	 */
	protected ScenarioPrecondition scenarioprecondition;

	/**
	 * The cached value of the '{@link #getMeasurementstart() <em>Measurementstart</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurementstart()
	 * @generated
	 * @ordered
	 */
	protected MeasurementStart measurementstart;

	/**
	 * The cached value of the '{@link #getScenariocore() <em>Scenariocore</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenariocore()
	 * @generated
	 * @ordered
	 */
	protected ScenarioCore scenariocore;

	/**
	 * The cached value of the '{@link #getMeasurementend() <em>Measurementend</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurementend()
	 * @generated
	 * @ordered
	 */
	protected MeasurementEnd measurementend;

	/**
	 * The cached value of the '{@link #getScenariopostcondition() <em>Scenariopostcondition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenariopostcondition()
	 * @generated
	 * @ordered
	 */
	protected ScenarioPostcondition scenariopostcondition;

	/**
	 * The cached value of the '{@link #getNamedcardinality() <em>Namedcardinality</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamedcardinality()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedCardinality> namedcardinality;

	/**
	 * The cached value of the '{@link #getBenchmarkedInstruction() <em>Benchmarked Instruction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBenchmarkedInstruction()
	 * @generated
	 * @ordered
	 */
	protected AtomicInstruction benchmarkedInstruction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ByBenchPackage.Literals.SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioPrecondition getScenarioprecondition() {
		return scenarioprecondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScenarioprecondition(ScenarioPrecondition newScenarioprecondition, NotificationChain msgs) {
		ScenarioPrecondition oldScenarioprecondition = scenarioprecondition;
		scenarioprecondition = newScenarioprecondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByBenchPackage.SCENARIO__SCENARIOPRECONDITION, oldScenarioprecondition, newScenarioprecondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScenarioprecondition(ScenarioPrecondition newScenarioprecondition) {
		if (newScenarioprecondition != scenarioprecondition) {
			NotificationChain msgs = null;
			if (scenarioprecondition != null)
				msgs = ((InternalEObject)scenarioprecondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ByBenchPackage.SCENARIO__SCENARIOPRECONDITION, null, msgs);
			if (newScenarioprecondition != null)
				msgs = ((InternalEObject)newScenarioprecondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ByBenchPackage.SCENARIO__SCENARIOPRECONDITION, null, msgs);
			msgs = basicSetScenarioprecondition(newScenarioprecondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ByBenchPackage.SCENARIO__SCENARIOPRECONDITION, newScenarioprecondition, newScenarioprecondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementStart getMeasurementstart() {
		return measurementstart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeasurementstart(MeasurementStart newMeasurementstart, NotificationChain msgs) {
		MeasurementStart oldMeasurementstart = measurementstart;
		measurementstart = newMeasurementstart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByBenchPackage.SCENARIO__MEASUREMENTSTART, oldMeasurementstart, newMeasurementstart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurementstart(MeasurementStart newMeasurementstart) {
		if (newMeasurementstart != measurementstart) {
			NotificationChain msgs = null;
			if (measurementstart != null)
				msgs = ((InternalEObject)measurementstart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ByBenchPackage.SCENARIO__MEASUREMENTSTART, null, msgs);
			if (newMeasurementstart != null)
				msgs = ((InternalEObject)newMeasurementstart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ByBenchPackage.SCENARIO__MEASUREMENTSTART, null, msgs);
			msgs = basicSetMeasurementstart(newMeasurementstart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ByBenchPackage.SCENARIO__MEASUREMENTSTART, newMeasurementstart, newMeasurementstart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioCore getScenariocore() {
		return scenariocore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScenariocore(ScenarioCore newScenariocore, NotificationChain msgs) {
		ScenarioCore oldScenariocore = scenariocore;
		scenariocore = newScenariocore;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByBenchPackage.SCENARIO__SCENARIOCORE, oldScenariocore, newScenariocore);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScenariocore(ScenarioCore newScenariocore) {
		if (newScenariocore != scenariocore) {
			NotificationChain msgs = null;
			if (scenariocore != null)
				msgs = ((InternalEObject)scenariocore).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ByBenchPackage.SCENARIO__SCENARIOCORE, null, msgs);
			if (newScenariocore != null)
				msgs = ((InternalEObject)newScenariocore).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ByBenchPackage.SCENARIO__SCENARIOCORE, null, msgs);
			msgs = basicSetScenariocore(newScenariocore, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ByBenchPackage.SCENARIO__SCENARIOCORE, newScenariocore, newScenariocore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementEnd getMeasurementend() {
		return measurementend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeasurementend(MeasurementEnd newMeasurementend, NotificationChain msgs) {
		MeasurementEnd oldMeasurementend = measurementend;
		measurementend = newMeasurementend;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByBenchPackage.SCENARIO__MEASUREMENTEND, oldMeasurementend, newMeasurementend);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurementend(MeasurementEnd newMeasurementend) {
		if (newMeasurementend != measurementend) {
			NotificationChain msgs = null;
			if (measurementend != null)
				msgs = ((InternalEObject)measurementend).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ByBenchPackage.SCENARIO__MEASUREMENTEND, null, msgs);
			if (newMeasurementend != null)
				msgs = ((InternalEObject)newMeasurementend).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ByBenchPackage.SCENARIO__MEASUREMENTEND, null, msgs);
			msgs = basicSetMeasurementend(newMeasurementend, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ByBenchPackage.SCENARIO__MEASUREMENTEND, newMeasurementend, newMeasurementend));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScenarioPostcondition getScenariopostcondition() {
		return scenariopostcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScenariopostcondition(ScenarioPostcondition newScenariopostcondition, NotificationChain msgs) {
		ScenarioPostcondition oldScenariopostcondition = scenariopostcondition;
		scenariopostcondition = newScenariopostcondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ByBenchPackage.SCENARIO__SCENARIOPOSTCONDITION, oldScenariopostcondition, newScenariopostcondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScenariopostcondition(ScenarioPostcondition newScenariopostcondition) {
		if (newScenariopostcondition != scenariopostcondition) {
			NotificationChain msgs = null;
			if (scenariopostcondition != null)
				msgs = ((InternalEObject)scenariopostcondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ByBenchPackage.SCENARIO__SCENARIOPOSTCONDITION, null, msgs);
			if (newScenariopostcondition != null)
				msgs = ((InternalEObject)newScenariopostcondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ByBenchPackage.SCENARIO__SCENARIOPOSTCONDITION, null, msgs);
			msgs = basicSetScenariopostcondition(newScenariopostcondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ByBenchPackage.SCENARIO__SCENARIOPOSTCONDITION, newScenariopostcondition, newScenariopostcondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedCardinality> getNamedcardinality() {
		if (namedcardinality == null) {
			namedcardinality = new EObjectContainmentEList<NamedCardinality>(NamedCardinality.class, this, ByBenchPackage.SCENARIO__NAMEDCARDINALITY);
		}
		return namedcardinality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicInstruction getBenchmarkedInstruction() {
		if (benchmarkedInstruction != null && benchmarkedInstruction.eIsProxy()) {
			InternalEObject oldBenchmarkedInstruction = (InternalEObject)benchmarkedInstruction;
			benchmarkedInstruction = (AtomicInstruction)eResolveProxy(oldBenchmarkedInstruction);
			if (benchmarkedInstruction != oldBenchmarkedInstruction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ByBenchPackage.SCENARIO__BENCHMARKED_INSTRUCTION, oldBenchmarkedInstruction, benchmarkedInstruction));
			}
		}
		return benchmarkedInstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicInstruction basicGetBenchmarkedInstruction() {
		return benchmarkedInstruction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBenchmarkedInstruction(AtomicInstruction newBenchmarkedInstruction) {
		AtomicInstruction oldBenchmarkedInstruction = benchmarkedInstruction;
		benchmarkedInstruction = newBenchmarkedInstruction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ByBenchPackage.SCENARIO__BENCHMARKED_INSTRUCTION, oldBenchmarkedInstruction, benchmarkedInstruction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ByBenchPackage.SCENARIO__SCENARIOPRECONDITION:
				return basicSetScenarioprecondition(null, msgs);
			case ByBenchPackage.SCENARIO__MEASUREMENTSTART:
				return basicSetMeasurementstart(null, msgs);
			case ByBenchPackage.SCENARIO__SCENARIOCORE:
				return basicSetScenariocore(null, msgs);
			case ByBenchPackage.SCENARIO__MEASUREMENTEND:
				return basicSetMeasurementend(null, msgs);
			case ByBenchPackage.SCENARIO__SCENARIOPOSTCONDITION:
				return basicSetScenariopostcondition(null, msgs);
			case ByBenchPackage.SCENARIO__NAMEDCARDINALITY:
				return ((InternalEList<?>)getNamedcardinality()).basicRemove(otherEnd, msgs);
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
			case ByBenchPackage.SCENARIO__SCENARIOPRECONDITION:
				return getScenarioprecondition();
			case ByBenchPackage.SCENARIO__MEASUREMENTSTART:
				return getMeasurementstart();
			case ByBenchPackage.SCENARIO__SCENARIOCORE:
				return getScenariocore();
			case ByBenchPackage.SCENARIO__MEASUREMENTEND:
				return getMeasurementend();
			case ByBenchPackage.SCENARIO__SCENARIOPOSTCONDITION:
				return getScenariopostcondition();
			case ByBenchPackage.SCENARIO__NAMEDCARDINALITY:
				return getNamedcardinality();
			case ByBenchPackage.SCENARIO__BENCHMARKED_INSTRUCTION:
				if (resolve) return getBenchmarkedInstruction();
				return basicGetBenchmarkedInstruction();
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
			case ByBenchPackage.SCENARIO__SCENARIOPRECONDITION:
				setScenarioprecondition((ScenarioPrecondition)newValue);
				return;
			case ByBenchPackage.SCENARIO__MEASUREMENTSTART:
				setMeasurementstart((MeasurementStart)newValue);
				return;
			case ByBenchPackage.SCENARIO__SCENARIOCORE:
				setScenariocore((ScenarioCore)newValue);
				return;
			case ByBenchPackage.SCENARIO__MEASUREMENTEND:
				setMeasurementend((MeasurementEnd)newValue);
				return;
			case ByBenchPackage.SCENARIO__SCENARIOPOSTCONDITION:
				setScenariopostcondition((ScenarioPostcondition)newValue);
				return;
			case ByBenchPackage.SCENARIO__NAMEDCARDINALITY:
				getNamedcardinality().clear();
				getNamedcardinality().addAll((Collection<? extends NamedCardinality>)newValue);
				return;
			case ByBenchPackage.SCENARIO__BENCHMARKED_INSTRUCTION:
				setBenchmarkedInstruction((AtomicInstruction)newValue);
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
			case ByBenchPackage.SCENARIO__SCENARIOPRECONDITION:
				setScenarioprecondition((ScenarioPrecondition)null);
				return;
			case ByBenchPackage.SCENARIO__MEASUREMENTSTART:
				setMeasurementstart((MeasurementStart)null);
				return;
			case ByBenchPackage.SCENARIO__SCENARIOCORE:
				setScenariocore((ScenarioCore)null);
				return;
			case ByBenchPackage.SCENARIO__MEASUREMENTEND:
				setMeasurementend((MeasurementEnd)null);
				return;
			case ByBenchPackage.SCENARIO__SCENARIOPOSTCONDITION:
				setScenariopostcondition((ScenarioPostcondition)null);
				return;
			case ByBenchPackage.SCENARIO__NAMEDCARDINALITY:
				getNamedcardinality().clear();
				return;
			case ByBenchPackage.SCENARIO__BENCHMARKED_INSTRUCTION:
				setBenchmarkedInstruction((AtomicInstruction)null);
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
			case ByBenchPackage.SCENARIO__SCENARIOPRECONDITION:
				return scenarioprecondition != null;
			case ByBenchPackage.SCENARIO__MEASUREMENTSTART:
				return measurementstart != null;
			case ByBenchPackage.SCENARIO__SCENARIOCORE:
				return scenariocore != null;
			case ByBenchPackage.SCENARIO__MEASUREMENTEND:
				return measurementend != null;
			case ByBenchPackage.SCENARIO__SCENARIOPOSTCONDITION:
				return scenariopostcondition != null;
			case ByBenchPackage.SCENARIO__NAMEDCARDINALITY:
				return namedcardinality != null && !namedcardinality.isEmpty();
			case ByBenchPackage.SCENARIO__BENCHMARKED_INSTRUCTION:
				return benchmarkedInstruction != null;
		}
		return super.eIsSet(featureID);
	}

} //ScenarioImpl
