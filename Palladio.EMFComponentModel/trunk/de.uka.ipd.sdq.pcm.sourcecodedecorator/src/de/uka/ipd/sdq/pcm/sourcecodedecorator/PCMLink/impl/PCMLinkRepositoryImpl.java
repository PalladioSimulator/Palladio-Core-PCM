/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkRepositoryImpl#getComponentfilelink <em>Componentfilelink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkRepositoryImpl#getSeffmethodlink <em>Seffmethodlink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkRepositoryImpl#getActioncontrolflowlink <em>Actioncontrolflowlink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkRepositoryImpl#getLoggingPositionIds <em>Logging Position Ids</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMLinkRepositoryImpl extends IdentifierImpl implements PCMLinkRepository {
	/**
	 * The cached value of the '{@link #getComponentfilelink() <em>Componentfilelink</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentfilelink()
	 * @generated
	 * @ordered
	 */
	protected EList<ComponentFileLink> componentfilelink;

	/**
	 * The cached value of the '{@link #getSeffmethodlink() <em>Seffmethodlink</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeffmethodlink()
	 * @generated
	 * @ordered
	 */
	protected EList<SEFFMethodLink> seffmethodlink;

	/**
	 * The cached value of the '{@link #getActioncontrolflowlink() <em>Actioncontrolflowlink</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActioncontrolflowlink()
	 * @generated
	 * @ordered
	 */
	protected EList<ActionControlFlowLink> actioncontrolflowlink;

	/**
	 * The cached value of the '{@link #getLoggingPositionIds() <em>Logging Position Ids</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoggingPositionIds()
	 * @generated
	 * @ordered
	 */
	protected EList<LoggingPositionIdLink> loggingPositionIds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMLinkRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PCMLinkPackage.Literals.PCM_LINK_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComponentFileLink> getComponentfilelink() {
		if (componentfilelink == null) {
			componentfilelink = new EObjectContainmentEList<ComponentFileLink>(ComponentFileLink.class, this, PCMLinkPackage.PCM_LINK_REPOSITORY__COMPONENTFILELINK);
		}
		return componentfilelink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SEFFMethodLink> getSeffmethodlink() {
		if (seffmethodlink == null) {
			seffmethodlink = new EObjectContainmentEList<SEFFMethodLink>(SEFFMethodLink.class, this, PCMLinkPackage.PCM_LINK_REPOSITORY__SEFFMETHODLINK);
		}
		return seffmethodlink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActionControlFlowLink> getActioncontrolflowlink() {
		if (actioncontrolflowlink == null) {
			actioncontrolflowlink = new EObjectContainmentEList<ActionControlFlowLink>(ActionControlFlowLink.class, this, PCMLinkPackage.PCM_LINK_REPOSITORY__ACTIONCONTROLFLOWLINK);
		}
		return actioncontrolflowlink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LoggingPositionIdLink> getLoggingPositionIds() {
		if (loggingPositionIds == null) {
			loggingPositionIds = new EObjectContainmentEList<LoggingPositionIdLink>(LoggingPositionIdLink.class, this, PCMLinkPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_IDS);
		}
		return loggingPositionIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PCMLinkPackage.PCM_LINK_REPOSITORY__COMPONENTFILELINK:
				return ((InternalEList<?>)getComponentfilelink()).basicRemove(otherEnd, msgs);
			case PCMLinkPackage.PCM_LINK_REPOSITORY__SEFFMETHODLINK:
				return ((InternalEList<?>)getSeffmethodlink()).basicRemove(otherEnd, msgs);
			case PCMLinkPackage.PCM_LINK_REPOSITORY__ACTIONCONTROLFLOWLINK:
				return ((InternalEList<?>)getActioncontrolflowlink()).basicRemove(otherEnd, msgs);
			case PCMLinkPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_IDS:
				return ((InternalEList<?>)getLoggingPositionIds()).basicRemove(otherEnd, msgs);
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
			case PCMLinkPackage.PCM_LINK_REPOSITORY__COMPONENTFILELINK:
				return getComponentfilelink();
			case PCMLinkPackage.PCM_LINK_REPOSITORY__SEFFMETHODLINK:
				return getSeffmethodlink();
			case PCMLinkPackage.PCM_LINK_REPOSITORY__ACTIONCONTROLFLOWLINK:
				return getActioncontrolflowlink();
			case PCMLinkPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_IDS:
				return getLoggingPositionIds();
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
			case PCMLinkPackage.PCM_LINK_REPOSITORY__COMPONENTFILELINK:
				getComponentfilelink().clear();
				getComponentfilelink().addAll((Collection<? extends ComponentFileLink>)newValue);
				return;
			case PCMLinkPackage.PCM_LINK_REPOSITORY__SEFFMETHODLINK:
				getSeffmethodlink().clear();
				getSeffmethodlink().addAll((Collection<? extends SEFFMethodLink>)newValue);
				return;
			case PCMLinkPackage.PCM_LINK_REPOSITORY__ACTIONCONTROLFLOWLINK:
				getActioncontrolflowlink().clear();
				getActioncontrolflowlink().addAll((Collection<? extends ActionControlFlowLink>)newValue);
				return;
			case PCMLinkPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_IDS:
				getLoggingPositionIds().clear();
				getLoggingPositionIds().addAll((Collection<? extends LoggingPositionIdLink>)newValue);
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
			case PCMLinkPackage.PCM_LINK_REPOSITORY__COMPONENTFILELINK:
				getComponentfilelink().clear();
				return;
			case PCMLinkPackage.PCM_LINK_REPOSITORY__SEFFMETHODLINK:
				getSeffmethodlink().clear();
				return;
			case PCMLinkPackage.PCM_LINK_REPOSITORY__ACTIONCONTROLFLOWLINK:
				getActioncontrolflowlink().clear();
				return;
			case PCMLinkPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_IDS:
				getLoggingPositionIds().clear();
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
			case PCMLinkPackage.PCM_LINK_REPOSITORY__COMPONENTFILELINK:
				return componentfilelink != null && !componentfilelink.isEmpty();
			case PCMLinkPackage.PCM_LINK_REPOSITORY__SEFFMETHODLINK:
				return seffmethodlink != null && !seffmethodlink.isEmpty();
			case PCMLinkPackage.PCM_LINK_REPOSITORY__ACTIONCONTROLFLOWLINK:
				return actioncontrolflowlink != null && !actioncontrolflowlink.isEmpty();
			case PCMLinkPackage.PCM_LINK_REPOSITORY__LOGGING_POSITION_IDS:
				return loggingPositionIds != null && !loggingPositionIds.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PCMLinkRepositoryImpl
