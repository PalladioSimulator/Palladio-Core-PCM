/**
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.ProbabilisticElement;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Probabilistic Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.ProbabilisticElementImpl#getPrecision <em>Precision</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.ProbabilisticElementImpl#getChildPEs <em>Child PEs</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.ProbabilisticElementImpl#getParentPE <em>Parent PE</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.ProbabilisticElementImpl#getQualityAnnotation <em>Quality Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ProbabilisticElementImpl extends EObjectImpl implements ProbabilisticElement {
	/**
	 * The cached value of the '{@link #getPrecision() <em>Precision</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecision()
	 * @generated
	 * @ordered
	 */
	protected Precision precision;

	/**
	 * The cached value of the '{@link #getChildPEs() <em>Child PEs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildPEs()
	 * @generated
	 * @ordered
	 */
	protected EList<ProbabilisticElement> childPEs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProbabilisticElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.PROBABILISTIC_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Precision getPrecision() {
		return precision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrecision(Precision newPrecision, NotificationChain msgs) {
		Precision oldPrecision = precision;
		precision = newPrecision;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION, oldPrecision, newPrecision);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecision(Precision newPrecision) {
		if (newPrecision != precision) {
			NotificationChain msgs = null;
			if (precision != null)
				msgs = ((InternalEObject)precision).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION, null, msgs);
			if (newPrecision != null)
				msgs = ((InternalEObject)newPrecision).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION, null, msgs);
			msgs = basicSetPrecision(newPrecision, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION, newPrecision, newPrecision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProbabilisticElement> getChildPEs() {
		if (childPEs == null) {
			childPEs = new EObjectContainmentWithInverseEList<ProbabilisticElement>(ProbabilisticElement.class, this, QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES, QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE);
		}
		return childPEs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilisticElement getParentPE() {
		if (eContainerFeatureID() != QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE) return null;
		return (ProbabilisticElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentPE(ProbabilisticElement newParentPE, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentPE, QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentPE(ProbabilisticElement newParentPE) {
		if (newParentPE != eInternalContainer() || (eContainerFeatureID() != QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE && newParentPE != null)) {
			if (EcoreUtil.isAncestor(this, newParentPE))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentPE != null)
				msgs = ((InternalEObject)newParentPE).eInverseAdd(this, QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES, ProbabilisticElement.class, msgs);
			msgs = basicSetParentPE(newParentPE, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE, newParentPE, newParentPE));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityAnnotation getQualityAnnotation() {
		if (eContainerFeatureID() != QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION) return null;
		return (QualityAnnotation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQualityAnnotation(QualityAnnotation newQualityAnnotation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newQualityAnnotation, QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualityAnnotation(QualityAnnotation newQualityAnnotation) {
		if (newQualityAnnotation != eInternalContainer() || (eContainerFeatureID() != QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION && newQualityAnnotation != null)) {
			if (EcoreUtil.isAncestor(this, newQualityAnnotation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newQualityAnnotation != null)
				msgs = ((InternalEObject)newQualityAnnotation).eInverseAdd(this, QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS, QualityAnnotation.class, msgs);
			msgs = basicSetQualityAnnotation(newQualityAnnotation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION, newQualityAnnotation, newQualityAnnotation));
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
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildPEs()).basicAdd(otherEnd, msgs);
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentPE((ProbabilisticElement)otherEnd, msgs);
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetQualityAnnotation((QualityAnnotation)otherEnd, msgs);
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
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION:
				return basicSetPrecision(null, msgs);
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
				return ((InternalEList<?>)getChildPEs()).basicRemove(otherEnd, msgs);
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
				return basicSetParentPE(null, msgs);
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
				return basicSetQualityAnnotation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
				return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES, ProbabilisticElement.class, msgs);
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
				return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS, QualityAnnotation.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION:
				return getPrecision();
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
				return getChildPEs();
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
				return getParentPE();
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
				return getQualityAnnotation();
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
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION:
				setPrecision((Precision)newValue);
				return;
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
				getChildPEs().clear();
				getChildPEs().addAll((Collection<? extends ProbabilisticElement>)newValue);
				return;
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
				setParentPE((ProbabilisticElement)newValue);
				return;
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
				setQualityAnnotation((QualityAnnotation)newValue);
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
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION:
				setPrecision((Precision)null);
				return;
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
				getChildPEs().clear();
				return;
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
				setParentPE((ProbabilisticElement)null);
				return;
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
				setQualityAnnotation((QualityAnnotation)null);
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
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION:
				return precision != null;
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
				return childPEs != null && !childPEs.isEmpty();
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
				return getParentPE() != null;
			case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
				return getQualityAnnotation() != null;
		}
		return super.eIsSet(featureID);
	}

} //ProbabilisticElementImpl
