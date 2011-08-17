/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.impl;

import de.fzi.se.quality.impl.QualityStatementImpl;

import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;

import de.fzi.se.validation.testbased.InternalStateInfluenceAnalysisStrategy;
import de.fzi.se.validation.testbased.TBValidationQuality;
import de.fzi.se.validation.testbased.TestbasedPackage;
import de.fzi.se.validation.testbased.TestcaseExecutionStopStrategy;
import de.fzi.se.validation.testbased.TestcaseGenerationStrategy;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TB Validation Quality</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.impl.TBValidationQualityImpl#getStopStrategy <em>Stop Strategy</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.impl.TBValidationQualityImpl#getGenerationStrategy <em>Generation Strategy</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.impl.TBValidationQualityImpl#getInternalStateInfluenceAnalysisStrategy <em>Internal State Influence Analysis Strategy</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.impl.TBValidationQualityImpl#getQualityAnnotations <em>Quality Annotations</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.impl.TBValidationQualityImpl#getInternalStateInfluenceAnalysisAggregationResults <em>Internal State Influence Analysis Aggregation Results</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TBValidationQualityImpl extends QualityStatementImpl implements TBValidationQuality {
	/**
	 * The cached value of the '{@link #getStopStrategy() <em>Stop Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopStrategy()
	 * @generated
	 * @ordered
	 */
	protected TestcaseExecutionStopStrategy stopStrategy;

	/**
	 * The cached value of the '{@link #getGenerationStrategy() <em>Generation Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerationStrategy()
	 * @generated
	 * @ordered
	 */
	protected TestcaseGenerationStrategy generationStrategy;

	/**
	 * The cached value of the '{@link #getInternalStateInfluenceAnalysisStrategy() <em>Internal State Influence Analysis Strategy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalStateInfluenceAnalysisStrategy()
	 * @generated
	 * @ordered
	 */
	protected InternalStateInfluenceAnalysisStrategy internalStateInfluenceAnalysisStrategy;

	/**
	 * The cached value of the '{@link #getQualityAnnotations() <em>Quality Annotations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<QualityAnnotation> qualityAnnotations;

	/**
	 * The cached value of the '{@link #getInternalStateInfluenceAnalysisAggregationResults() <em>Internal State Influence Analysis Aggregation Results</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalStateInfluenceAnalysisAggregationResults()
	 * @generated
	 * @ordered
	 */
	protected EList<InternalStateInfluenceAnalysisAggregation> internalStateInfluenceAnalysisAggregationResults;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TBValidationQualityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestbasedPackage.Literals.TB_VALIDATION_QUALITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestcaseExecutionStopStrategy getStopStrategy() {
		return stopStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStopStrategy(TestcaseExecutionStopStrategy newStopStrategy, NotificationChain msgs) {
		TestcaseExecutionStopStrategy oldStopStrategy = stopStrategy;
		stopStrategy = newStopStrategy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestbasedPackage.TB_VALIDATION_QUALITY__STOP_STRATEGY, oldStopStrategy, newStopStrategy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStopStrategy(TestcaseExecutionStopStrategy newStopStrategy) {
		if (newStopStrategy != stopStrategy) {
			NotificationChain msgs = null;
			if (stopStrategy != null)
				msgs = ((InternalEObject)stopStrategy).eInverseRemove(this, TestbasedPackage.TESTCASE_EXECUTION_STOP_STRATEGY__VALIDATION_QUALITY, TestcaseExecutionStopStrategy.class, msgs);
			if (newStopStrategy != null)
				msgs = ((InternalEObject)newStopStrategy).eInverseAdd(this, TestbasedPackage.TESTCASE_EXECUTION_STOP_STRATEGY__VALIDATION_QUALITY, TestcaseExecutionStopStrategy.class, msgs);
			msgs = basicSetStopStrategy(newStopStrategy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestbasedPackage.TB_VALIDATION_QUALITY__STOP_STRATEGY, newStopStrategy, newStopStrategy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestcaseGenerationStrategy getGenerationStrategy() {
		return generationStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGenerationStrategy(TestcaseGenerationStrategy newGenerationStrategy, NotificationChain msgs) {
		TestcaseGenerationStrategy oldGenerationStrategy = generationStrategy;
		generationStrategy = newGenerationStrategy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestbasedPackage.TB_VALIDATION_QUALITY__GENERATION_STRATEGY, oldGenerationStrategy, newGenerationStrategy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerationStrategy(TestcaseGenerationStrategy newGenerationStrategy) {
		if (newGenerationStrategy != generationStrategy) {
			NotificationChain msgs = null;
			if (generationStrategy != null)
				msgs = ((InternalEObject)generationStrategy).eInverseRemove(this, TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY, TestcaseGenerationStrategy.class, msgs);
			if (newGenerationStrategy != null)
				msgs = ((InternalEObject)newGenerationStrategy).eInverseAdd(this, TestbasedPackage.TESTCASE_GENERATION_STRATEGY__VALIDATION_QUALITY, TestcaseGenerationStrategy.class, msgs);
			msgs = basicSetGenerationStrategy(newGenerationStrategy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestbasedPackage.TB_VALIDATION_QUALITY__GENERATION_STRATEGY, newGenerationStrategy, newGenerationStrategy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalStateInfluenceAnalysisStrategy getInternalStateInfluenceAnalysisStrategy() {
		return internalStateInfluenceAnalysisStrategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInternalStateInfluenceAnalysisStrategy(InternalStateInfluenceAnalysisStrategy newInternalStateInfluenceAnalysisStrategy, NotificationChain msgs) {
		InternalStateInfluenceAnalysisStrategy oldInternalStateInfluenceAnalysisStrategy = internalStateInfluenceAnalysisStrategy;
		internalStateInfluenceAnalysisStrategy = newInternalStateInfluenceAnalysisStrategy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY, oldInternalStateInfluenceAnalysisStrategy, newInternalStateInfluenceAnalysisStrategy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalStateInfluenceAnalysisStrategy(InternalStateInfluenceAnalysisStrategy newInternalStateInfluenceAnalysisStrategy) {
		if (newInternalStateInfluenceAnalysisStrategy != internalStateInfluenceAnalysisStrategy) {
			NotificationChain msgs = null;
			if (internalStateInfluenceAnalysisStrategy != null)
				msgs = ((InternalEObject)internalStateInfluenceAnalysisStrategy).eInverseRemove(this, TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY, InternalStateInfluenceAnalysisStrategy.class, msgs);
			if (newInternalStateInfluenceAnalysisStrategy != null)
				msgs = ((InternalEObject)newInternalStateInfluenceAnalysisStrategy).eInverseAdd(this, TestbasedPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY__TB_VALIDATION_QUALITY, InternalStateInfluenceAnalysisStrategy.class, msgs);
			msgs = basicSetInternalStateInfluenceAnalysisStrategy(newInternalStateInfluenceAnalysisStrategy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY, newInternalStateInfluenceAnalysisStrategy, newInternalStateInfluenceAnalysisStrategy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QualityAnnotation> getQualityAnnotations() {
		if (qualityAnnotations == null) {
			qualityAnnotations = new EObjectResolvingEList<QualityAnnotation>(QualityAnnotation.class, this, TestbasedPackage.TB_VALIDATION_QUALITY__QUALITY_ANNOTATIONS);
		}
		return qualityAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InternalStateInfluenceAnalysisAggregation> getInternalStateInfluenceAnalysisAggregationResults() {
		if (internalStateInfluenceAnalysisAggregationResults == null) {
			internalStateInfluenceAnalysisAggregationResults = new EObjectResolvingEList<InternalStateInfluenceAnalysisAggregation>(InternalStateInfluenceAnalysisAggregation.class, this, TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION_RESULTS);
		}
		return internalStateInfluenceAnalysisAggregationResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestbasedPackage.TB_VALIDATION_QUALITY__STOP_STRATEGY:
				if (stopStrategy != null)
					msgs = ((InternalEObject)stopStrategy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestbasedPackage.TB_VALIDATION_QUALITY__STOP_STRATEGY, null, msgs);
				return basicSetStopStrategy((TestcaseExecutionStopStrategy)otherEnd, msgs);
			case TestbasedPackage.TB_VALIDATION_QUALITY__GENERATION_STRATEGY:
				if (generationStrategy != null)
					msgs = ((InternalEObject)generationStrategy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestbasedPackage.TB_VALIDATION_QUALITY__GENERATION_STRATEGY, null, msgs);
				return basicSetGenerationStrategy((TestcaseGenerationStrategy)otherEnd, msgs);
			case TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY:
				if (internalStateInfluenceAnalysisStrategy != null)
					msgs = ((InternalEObject)internalStateInfluenceAnalysisStrategy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY, null, msgs);
				return basicSetInternalStateInfluenceAnalysisStrategy((InternalStateInfluenceAnalysisStrategy)otherEnd, msgs);
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
			case TestbasedPackage.TB_VALIDATION_QUALITY__STOP_STRATEGY:
				return basicSetStopStrategy(null, msgs);
			case TestbasedPackage.TB_VALIDATION_QUALITY__GENERATION_STRATEGY:
				return basicSetGenerationStrategy(null, msgs);
			case TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY:
				return basicSetInternalStateInfluenceAnalysisStrategy(null, msgs);
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
			case TestbasedPackage.TB_VALIDATION_QUALITY__STOP_STRATEGY:
				return getStopStrategy();
			case TestbasedPackage.TB_VALIDATION_QUALITY__GENERATION_STRATEGY:
				return getGenerationStrategy();
			case TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY:
				return getInternalStateInfluenceAnalysisStrategy();
			case TestbasedPackage.TB_VALIDATION_QUALITY__QUALITY_ANNOTATIONS:
				return getQualityAnnotations();
			case TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION_RESULTS:
				return getInternalStateInfluenceAnalysisAggregationResults();
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
			case TestbasedPackage.TB_VALIDATION_QUALITY__STOP_STRATEGY:
				setStopStrategy((TestcaseExecutionStopStrategy)newValue);
				return;
			case TestbasedPackage.TB_VALIDATION_QUALITY__GENERATION_STRATEGY:
				setGenerationStrategy((TestcaseGenerationStrategy)newValue);
				return;
			case TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY:
				setInternalStateInfluenceAnalysisStrategy((InternalStateInfluenceAnalysisStrategy)newValue);
				return;
			case TestbasedPackage.TB_VALIDATION_QUALITY__QUALITY_ANNOTATIONS:
				getQualityAnnotations().clear();
				getQualityAnnotations().addAll((Collection<? extends QualityAnnotation>)newValue);
				return;
			case TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION_RESULTS:
				getInternalStateInfluenceAnalysisAggregationResults().clear();
				getInternalStateInfluenceAnalysisAggregationResults().addAll((Collection<? extends InternalStateInfluenceAnalysisAggregation>)newValue);
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
			case TestbasedPackage.TB_VALIDATION_QUALITY__STOP_STRATEGY:
				setStopStrategy((TestcaseExecutionStopStrategy)null);
				return;
			case TestbasedPackage.TB_VALIDATION_QUALITY__GENERATION_STRATEGY:
				setGenerationStrategy((TestcaseGenerationStrategy)null);
				return;
			case TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY:
				setInternalStateInfluenceAnalysisStrategy((InternalStateInfluenceAnalysisStrategy)null);
				return;
			case TestbasedPackage.TB_VALIDATION_QUALITY__QUALITY_ANNOTATIONS:
				getQualityAnnotations().clear();
				return;
			case TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION_RESULTS:
				getInternalStateInfluenceAnalysisAggregationResults().clear();
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
			case TestbasedPackage.TB_VALIDATION_QUALITY__STOP_STRATEGY:
				return stopStrategy != null;
			case TestbasedPackage.TB_VALIDATION_QUALITY__GENERATION_STRATEGY:
				return generationStrategy != null;
			case TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_STRATEGY:
				return internalStateInfluenceAnalysisStrategy != null;
			case TestbasedPackage.TB_VALIDATION_QUALITY__QUALITY_ANNOTATIONS:
				return qualityAnnotations != null && !qualityAnnotations.isEmpty();
			case TestbasedPackage.TB_VALIDATION_QUALITY__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION_RESULTS:
				return internalStateInfluenceAnalysisAggregationResults != null && !internalStateInfluenceAnalysisAggregationResults.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TBValidationQualityImpl
