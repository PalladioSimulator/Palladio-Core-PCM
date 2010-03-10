/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel.impl;

import de.uka.ipd.sdq.featuremodel.impl.FeatureDiagramImpl;

import edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureDiagram;
import edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Completion Feature Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureDiagramImpl#getAnnotatableElementType <em>Annotatable Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompletionFeatureDiagramImpl extends FeatureDiagramImpl implements CompletionFeatureDiagram {
	/**
	 * The cached value of the '{@link #getAnnotatableElementType() <em>Annotatable Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotatableElementType()
	 * @generated
	 * @ordered
	 */
	protected EClass annotatableElementType;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompletionFeatureDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return completionfeaturemodelPackage.Literals.COMPLETION_FEATURE_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotatableElementType() {
		if (annotatableElementType != null && annotatableElementType.eIsProxy()) {
			InternalEObject oldAnnotatableElementType = (InternalEObject)annotatableElementType;
			annotatableElementType = (EClass)eResolveProxy(oldAnnotatableElementType);
			if (annotatableElementType != oldAnnotatableElementType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, completionfeaturemodelPackage.COMPLETION_FEATURE_DIAGRAM__ANNOTATABLE_ELEMENT_TYPE, oldAnnotatableElementType, annotatableElementType));
			}
		}
		return annotatableElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetAnnotatableElementType() {
		return annotatableElementType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotatableElementType(EClass newAnnotatableElementType) {
		EClass oldAnnotatableElementType = annotatableElementType;
		annotatableElementType = newAnnotatableElementType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, completionfeaturemodelPackage.COMPLETION_FEATURE_DIAGRAM__ANNOTATABLE_ELEMENT_TYPE, oldAnnotatableElementType, annotatableElementType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case completionfeaturemodelPackage.COMPLETION_FEATURE_DIAGRAM__ANNOTATABLE_ELEMENT_TYPE:
				if (resolve) return getAnnotatableElementType();
				return basicGetAnnotatableElementType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case completionfeaturemodelPackage.COMPLETION_FEATURE_DIAGRAM__ANNOTATABLE_ELEMENT_TYPE:
				setAnnotatableElementType((EClass)newValue);
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
			case completionfeaturemodelPackage.COMPLETION_FEATURE_DIAGRAM__ANNOTATABLE_ELEMENT_TYPE:
				setAnnotatableElementType((EClass)null);
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
			case completionfeaturemodelPackage.COMPLETION_FEATURE_DIAGRAM__ANNOTATABLE_ELEMENT_TYPE:
				return annotatableElementType != null;
		}
		return super.eIsSet(featureID);
	}

} //CompletionFeatureDiagramImpl
