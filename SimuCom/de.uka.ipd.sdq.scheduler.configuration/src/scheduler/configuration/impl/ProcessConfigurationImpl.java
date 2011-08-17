/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.PriorityClass;
import scheduler.configuration.ProcessConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.ProcessConfigurationImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link scheduler.configuration.impl.ProcessConfigurationImpl#getReplicas <em>Replicas</em>}</li>
 *   <li>{@link scheduler.configuration.impl.ProcessConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.configuration.impl.ProcessConfigurationImpl#getAffinityList <em>Affinity List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessConfigurationImpl extends IdentifierImpl implements ProcessConfiguration {
	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final PriorityClass PRIORITY_EDEFAULT = PriorityClass.LOWEST;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected PriorityClass priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getReplicas() <em>Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplicas()
	 * @generated
	 * @ordered
	 */
	protected static final int REPLICAS_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getReplicas() <em>Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReplicas()
	 * @generated
	 * @ordered
	 */
	protected int replicas = REPLICAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAffinityList() <em>Affinity List</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffinityList()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> affinityList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.PROCESS_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PriorityClass getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(PriorityClass newPriority) {
		PriorityClass oldPriority = priority;
		priority = newPriority == null ? PRIORITY_EDEFAULT : newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PROCESS_CONFIGURATION__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getReplicas() {
		return replicas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReplicas(int newReplicas) {
		int oldReplicas = replicas;
		replicas = newReplicas;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PROCESS_CONFIGURATION__REPLICAS, oldReplicas, replicas));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PROCESS_CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getAffinityList() {
		if (affinityList == null) {
			affinityList = new EDataTypeUniqueEList<Integer>(Integer.class, this, ConfigurationPackage.PROCESS_CONFIGURATION__AFFINITY_LIST);
		}
		return affinityList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.PROCESS_CONFIGURATION__PRIORITY:
				return getPriority();
			case ConfigurationPackage.PROCESS_CONFIGURATION__REPLICAS:
				return getReplicas();
			case ConfigurationPackage.PROCESS_CONFIGURATION__NAME:
				return getName();
			case ConfigurationPackage.PROCESS_CONFIGURATION__AFFINITY_LIST:
				return getAffinityList();
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
			case ConfigurationPackage.PROCESS_CONFIGURATION__PRIORITY:
				setPriority((PriorityClass)newValue);
				return;
			case ConfigurationPackage.PROCESS_CONFIGURATION__REPLICAS:
				setReplicas((Integer)newValue);
				return;
			case ConfigurationPackage.PROCESS_CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case ConfigurationPackage.PROCESS_CONFIGURATION__AFFINITY_LIST:
				getAffinityList().clear();
				getAffinityList().addAll((Collection<? extends Integer>)newValue);
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
			case ConfigurationPackage.PROCESS_CONFIGURATION__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case ConfigurationPackage.PROCESS_CONFIGURATION__REPLICAS:
				setReplicas(REPLICAS_EDEFAULT);
				return;
			case ConfigurationPackage.PROCESS_CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigurationPackage.PROCESS_CONFIGURATION__AFFINITY_LIST:
				getAffinityList().clear();
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
			case ConfigurationPackage.PROCESS_CONFIGURATION__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case ConfigurationPackage.PROCESS_CONFIGURATION__REPLICAS:
				return replicas != REPLICAS_EDEFAULT;
			case ConfigurationPackage.PROCESS_CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigurationPackage.PROCESS_CONFIGURATION__AFFINITY_LIST:
				return affinityList != null && !affinityList.isEmpty();
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
		result.append(" (priority: ");
		result.append(priority);
		result.append(", replicas: ");
		result.append(replicas);
		result.append(", name: ");
		result.append(name);
		result.append(", affinityList: ");
		result.append(affinityList);
		result.append(')');
		return result.toString();
	}

} //ProcessConfigurationImpl
