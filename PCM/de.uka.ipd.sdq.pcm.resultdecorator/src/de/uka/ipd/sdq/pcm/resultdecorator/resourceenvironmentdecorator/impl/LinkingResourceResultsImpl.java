/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Linking Resource Results</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.LinkingResourceResultsImpl#getLinkingResource_LinkingResourceResults <em>Linking Resource Linking Resource Results</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkingResourceResultsImpl extends ActiveResourceUtilisationResultImpl implements LinkingResourceResults {
	/**
	 * The cached value of the '{@link #getLinkingResource_LinkingResourceResults() <em>Linking Resource Linking Resource Results</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkingResource_LinkingResourceResults()
	 * @generated
	 * @ordered
	 */
	protected LinkingResource linkingResource_LinkingResourceResults;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkingResourceResultsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourceenvironmentdecoratorPackage.Literals.LINKING_RESOURCE_RESULTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkingResource getLinkingResource_LinkingResourceResults() {
		if (linkingResource_LinkingResourceResults != null && linkingResource_LinkingResourceResults.eIsProxy()) {
			InternalEObject oldLinkingResource_LinkingResourceResults = (InternalEObject)linkingResource_LinkingResourceResults;
			linkingResource_LinkingResourceResults = (LinkingResource)eResolveProxy(oldLinkingResource_LinkingResourceResults);
			if (linkingResource_LinkingResourceResults != oldLinkingResource_LinkingResourceResults) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS, oldLinkingResource_LinkingResourceResults, linkingResource_LinkingResourceResults));
			}
		}
		return linkingResource_LinkingResourceResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkingResource basicGetLinkingResource_LinkingResourceResults() {
		return linkingResource_LinkingResourceResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkingResource_LinkingResourceResults(LinkingResource newLinkingResource_LinkingResourceResults) {
		LinkingResource oldLinkingResource_LinkingResourceResults = linkingResource_LinkingResourceResults;
		linkingResource_LinkingResourceResults = newLinkingResource_LinkingResourceResults;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS, oldLinkingResource_LinkingResourceResults, linkingResource_LinkingResourceResults));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS:
				if (resolve) return getLinkingResource_LinkingResourceResults();
				return basicGetLinkingResource_LinkingResourceResults();
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
			case ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS:
				setLinkingResource_LinkingResourceResults((LinkingResource)newValue);
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
			case ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS:
				setLinkingResource_LinkingResourceResults((LinkingResource)null);
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
			case ResourceenvironmentdecoratorPackage.LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS:
				return linkingResource_LinkingResourceResults != null;
		}
		return super.eIsSet(featureID);
	}

} //LinkingResourceResultsImpl
