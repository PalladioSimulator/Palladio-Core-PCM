/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric Set Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.MetricSetDescriptionImpl#getSubsumedMetrics <em>Subsumed Metrics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetricSetDescriptionImpl extends MetricDescriptionImpl implements MetricSetDescription {
	/**
	 * The cached value of the '{@link #getSubsumedMetrics() <em>Subsumed Metrics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsumedMetrics()
	 * @generated
	 * @ordered
	 */
	protected EList<MetricDescription> subsumedMetrics;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricSetDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExperimentDataPackage.Literals.METRIC_SET_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * TODO check whether this bug was solved:
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=89325
	 * @generated not Bug fix for the bug described above
	 */
	@Override
	public EList<MetricDescription> getSubsumedMetrics() {
		if (subsumedMetrics == null) {
			subsumedMetrics = new EObjectResolvingEList<MetricDescription>(MetricDescription.class, this, ExperimentDataPackage.METRIC_SET_DESCRIPTION__SUBSUMED_METRICS){
				private static final long serialVersionUID = -5838632964838752596L;

				@Override
				protected boolean isUnique() {
					return false;
				}
				
			};
		}
		return subsumedMetrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExperimentDataPackage.METRIC_SET_DESCRIPTION__SUBSUMED_METRICS:
				return getSubsumedMetrics();
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
			case ExperimentDataPackage.METRIC_SET_DESCRIPTION__SUBSUMED_METRICS:
				getSubsumedMetrics().clear();
				getSubsumedMetrics().addAll((Collection<? extends MetricDescription>)newValue);
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
			case ExperimentDataPackage.METRIC_SET_DESCRIPTION__SUBSUMED_METRICS:
				getSubsumedMetrics().clear();
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
			case ExperimentDataPackage.METRIC_SET_DESCRIPTION__SUBSUMED_METRICS:
				return subsumedMetrics != null && !subsumedMetrics.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MetricSetDescriptionImpl
