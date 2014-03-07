/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Textual Base Metric Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.TextualBaseMetricDescriptionImpl#getIdentifiers <em>Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextualBaseMetricDescriptionImpl extends BaseMetricDescriptionImpl implements TextualBaseMetricDescription {
	/**
     * The cached value of the '{@link #getIdentifiers() <em>Identifiers</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIdentifiers()
     * @generated
     * @ordered
     */
	protected EList<Identifier> identifiers;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TextualBaseMetricDescriptionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.TEXTUAL_BASE_METRIC_DESCRIPTION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Identifier> getIdentifiers() {
        if (identifiers == null) {
            identifiers = new EObjectContainmentWithInverseEList<Identifier>(Identifier.class, this, ExperimentDataPackage.TEXTUAL_BASE_METRIC_DESCRIPTION__IDENTIFIERS, ExperimentDataPackage.IDENTIFIER__TEXTUAL_BASE_METRIC_DESCRIPTION);
        }
        return identifiers;
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
            case ExperimentDataPackage.TEXTUAL_BASE_METRIC_DESCRIPTION__IDENTIFIERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getIdentifiers()).basicAdd(otherEnd, msgs);
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
            case ExperimentDataPackage.TEXTUAL_BASE_METRIC_DESCRIPTION__IDENTIFIERS:
                return ((InternalEList<?>)getIdentifiers()).basicRemove(otherEnd, msgs);
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
            case ExperimentDataPackage.TEXTUAL_BASE_METRIC_DESCRIPTION__IDENTIFIERS:
                return getIdentifiers();
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
            case ExperimentDataPackage.TEXTUAL_BASE_METRIC_DESCRIPTION__IDENTIFIERS:
                getIdentifiers().clear();
                getIdentifiers().addAll((Collection<? extends Identifier>)newValue);
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
            case ExperimentDataPackage.TEXTUAL_BASE_METRIC_DESCRIPTION__IDENTIFIERS:
                getIdentifiers().clear();
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
            case ExperimentDataPackage.TEXTUAL_BASE_METRIC_DESCRIPTION__IDENTIFIERS:
                return identifiers != null && !identifiers.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //TextualBaseMetricDescriptionImpl
