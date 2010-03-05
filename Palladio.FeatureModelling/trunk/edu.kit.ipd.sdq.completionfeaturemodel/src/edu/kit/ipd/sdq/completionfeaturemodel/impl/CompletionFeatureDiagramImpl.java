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
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Completion Feature Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureDiagramImpl#getAnnotatableType <em>Annotatable Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompletionFeatureDiagramImpl extends FeatureDiagramImpl implements CompletionFeatureDiagram {
	/**
	 * The default value of the '{@link #getAnnotatableType() <em>Annotatable Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotatableType()
	 * @generated
	 * @ordered
	 */
	protected static final String ANNOTATABLE_TYPE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getAnnotatableType() <em>Annotatable Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotatableType()
	 * @generated
	 * @ordered
	 */
	protected String annotatableType = ANNOTATABLE_TYPE_EDEFAULT;

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
	public String getAnnotatableType() {
		return annotatableType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotatableType(String newAnnotatableType) {
		String oldAnnotatableType = annotatableType;
		annotatableType = newAnnotatableType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, completionfeaturemodelPackage.COMPLETION_FEATURE_DIAGRAM__ANNOTATABLE_TYPE, oldAnnotatableType, annotatableType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case completionfeaturemodelPackage.COMPLETION_FEATURE_DIAGRAM__ANNOTATABLE_TYPE:
				return getAnnotatableType();
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
			case completionfeaturemodelPackage.COMPLETION_FEATURE_DIAGRAM__ANNOTATABLE_TYPE:
				setAnnotatableType((String)newValue);
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
			case completionfeaturemodelPackage.COMPLETION_FEATURE_DIAGRAM__ANNOTATABLE_TYPE:
				setAnnotatableType(ANNOTATABLE_TYPE_EDEFAULT);
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
			case completionfeaturemodelPackage.COMPLETION_FEATURE_DIAGRAM__ANNOTATABLE_TYPE:
				return ANNOTATABLE_TYPE_EDEFAULT == null ? annotatableType != null : !ANNOTATABLE_TYPE_EDEFAULT.equals(annotatableType);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (annotatableType: ");
		result.append(annotatableType);
		result.append(')');
		return result.toString();
	}

} //CompletionFeatureDiagramImpl
