/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pipesandfilters.impl;

import de.uka.ipd.sdq.pipesandfilters.AggregationRecorder;
import de.uka.ipd.sdq.pipesandfilters.Writer;
import de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregation Recorder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pipesandfilters.impl.AggregationRecorderImpl#getWriter <em>Writer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AggregationRecorderImpl extends RecorderImpl implements AggregationRecorder {
	/**
	 * The cached value of the '{@link #getWriter() <em>Writer</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWriter()
	 * @generated
	 * @ordered
	 */
	protected EList<Writer> writer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregationRecorderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return pipesandfiltersPackage.Literals.AGGREGATION_RECORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Writer> getWriter() {
		if (writer == null) {
			writer = new EObjectContainmentEList<Writer>(Writer.class, this, pipesandfiltersPackage.AGGREGATION_RECORDER__WRITER);
		}
		return writer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case pipesandfiltersPackage.AGGREGATION_RECORDER__WRITER:
				return ((InternalEList<?>)getWriter()).basicRemove(otherEnd, msgs);
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
			case pipesandfiltersPackage.AGGREGATION_RECORDER__WRITER:
				return getWriter();
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
			case pipesandfiltersPackage.AGGREGATION_RECORDER__WRITER:
				getWriter().clear();
				getWriter().addAll((Collection<? extends Writer>)newValue);
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
			case pipesandfiltersPackage.AGGREGATION_RECORDER__WRITER:
				getWriter().clear();
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
			case pipesandfiltersPackage.AGGREGATION_RECORDER__WRITER:
				return writer != null && !writer.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AggregationRecorderImpl
