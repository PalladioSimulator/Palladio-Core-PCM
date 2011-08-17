/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.impl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.PassiveResourceConfiguration;
import scheduler.configuration.PassiveResourceType;
import scheduler.configuration.StaticPriorityBoost;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Passive Resource Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.PassiveResourceConfigurationImpl#getStaticPriorityBoostConfiguration <em>Static Priority Boost Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.impl.PassiveResourceConfigurationImpl#getCapacity <em>Capacity</em>}</li>
 *   <li>{@link scheduler.configuration.impl.PassiveResourceConfigurationImpl#getType <em>Type</em>}</li>
 *   <li>{@link scheduler.configuration.impl.PassiveResourceConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.configuration.impl.PassiveResourceConfigurationImpl#getManagingResource <em>Managing Resource</em>}</li>
 *   <li>{@link scheduler.configuration.impl.PassiveResourceConfigurationImpl#getAcquisitionDemand <em>Acquisition Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PassiveResourceConfigurationImpl extends IdentifierImpl implements PassiveResourceConfiguration {
	/**
	 * The cached value of the '{@link #getStaticPriorityBoostConfiguration() <em>Static Priority Boost Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStaticPriorityBoostConfiguration()
	 * @generated
	 * @ordered
	 */
	protected StaticPriorityBoost staticPriorityBoostConfiguration;

	/**
	 * The default value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final int CAPACITY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getCapacity() <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapacity()
	 * @generated
	 * @ordered
	 */
	protected int capacity = CAPACITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final PassiveResourceType TYPE_EDEFAULT = PassiveResourceType.FAIR;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected PassiveResourceType type = TYPE_EDEFAULT;

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
	 * The cached value of the '{@link #getManagingResource() <em>Managing Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagingResource()
	 * @generated
	 * @ordered
	 */
	protected ActiveResourceConfiguration managingResource;

	/**
	 * The default value of the '{@link #getAcquisitionDemand() <em>Acquisition Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcquisitionDemand()
	 * @generated
	 * @ordered
	 */
	protected static final double ACQUISITION_DEMAND_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAcquisitionDemand() <em>Acquisition Demand</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcquisitionDemand()
	 * @generated
	 * @ordered
	 */
	protected double acquisitionDemand = ACQUISITION_DEMAND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PassiveResourceConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.PASSIVE_RESOURCE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticPriorityBoost getStaticPriorityBoostConfiguration() {
		return staticPriorityBoostConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStaticPriorityBoostConfiguration(StaticPriorityBoost newStaticPriorityBoostConfiguration, NotificationChain msgs) {
		StaticPriorityBoost oldStaticPriorityBoostConfiguration = staticPriorityBoostConfiguration;
		staticPriorityBoostConfiguration = newStaticPriorityBoostConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__STATIC_PRIORITY_BOOST_CONFIGURATION, oldStaticPriorityBoostConfiguration, newStaticPriorityBoostConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStaticPriorityBoostConfiguration(StaticPriorityBoost newStaticPriorityBoostConfiguration) {
		if (newStaticPriorityBoostConfiguration != staticPriorityBoostConfiguration) {
			NotificationChain msgs = null;
			if (staticPriorityBoostConfiguration != null)
				msgs = ((InternalEObject)staticPriorityBoostConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__STATIC_PRIORITY_BOOST_CONFIGURATION, null, msgs);
			if (newStaticPriorityBoostConfiguration != null)
				msgs = ((InternalEObject)newStaticPriorityBoostConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__STATIC_PRIORITY_BOOST_CONFIGURATION, null, msgs);
			msgs = basicSetStaticPriorityBoostConfiguration(newStaticPriorityBoostConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__STATIC_PRIORITY_BOOST_CONFIGURATION, newStaticPriorityBoostConfiguration, newStaticPriorityBoostConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapacity(int newCapacity) {
		int oldCapacity = capacity;
		capacity = newCapacity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__CAPACITY, oldCapacity, capacity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PassiveResourceType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(PassiveResourceType newType) {
		PassiveResourceType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActiveResourceConfiguration getManagingResource() {
		if (managingResource != null && managingResource.eIsProxy()) {
			InternalEObject oldManagingResource = (InternalEObject)managingResource;
			managingResource = (ActiveResourceConfiguration)eResolveProxy(oldManagingResource);
			if (managingResource != oldManagingResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__MANAGING_RESOURCE, oldManagingResource, managingResource));
			}
		}
		return managingResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActiveResourceConfiguration basicGetManagingResource() {
		return managingResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagingResource(ActiveResourceConfiguration newManagingResource) {
		ActiveResourceConfiguration oldManagingResource = managingResource;
		managingResource = newManagingResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__MANAGING_RESOURCE, oldManagingResource, managingResource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAcquisitionDemand() {
		return acquisitionDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAcquisitionDemand(double newAcquisitionDemand) {
		double oldAcquisitionDemand = acquisitionDemand;
		acquisitionDemand = newAcquisitionDemand;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__ACQUISITION_DEMAND, oldAcquisitionDemand, acquisitionDemand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__STATIC_PRIORITY_BOOST_CONFIGURATION:
				return basicSetStaticPriorityBoostConfiguration(null, msgs);
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
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__STATIC_PRIORITY_BOOST_CONFIGURATION:
				return getStaticPriorityBoostConfiguration();
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__CAPACITY:
				return getCapacity();
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__TYPE:
				return getType();
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__NAME:
				return getName();
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__MANAGING_RESOURCE:
				if (resolve) return getManagingResource();
				return basicGetManagingResource();
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__ACQUISITION_DEMAND:
				return getAcquisitionDemand();
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
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__STATIC_PRIORITY_BOOST_CONFIGURATION:
				setStaticPriorityBoostConfiguration((StaticPriorityBoost)newValue);
				return;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__CAPACITY:
				setCapacity((Integer)newValue);
				return;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__TYPE:
				setType((PassiveResourceType)newValue);
				return;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__MANAGING_RESOURCE:
				setManagingResource((ActiveResourceConfiguration)newValue);
				return;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__ACQUISITION_DEMAND:
				setAcquisitionDemand((Double)newValue);
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
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__STATIC_PRIORITY_BOOST_CONFIGURATION:
				setStaticPriorityBoostConfiguration((StaticPriorityBoost)null);
				return;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__CAPACITY:
				setCapacity(CAPACITY_EDEFAULT);
				return;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__MANAGING_RESOURCE:
				setManagingResource((ActiveResourceConfiguration)null);
				return;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__ACQUISITION_DEMAND:
				setAcquisitionDemand(ACQUISITION_DEMAND_EDEFAULT);
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
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__STATIC_PRIORITY_BOOST_CONFIGURATION:
				return staticPriorityBoostConfiguration != null;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__CAPACITY:
				return capacity != CAPACITY_EDEFAULT;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__TYPE:
				return type != TYPE_EDEFAULT;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__MANAGING_RESOURCE:
				return managingResource != null;
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION__ACQUISITION_DEMAND:
				return acquisitionDemand != ACQUISITION_DEMAND_EDEFAULT;
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
		result.append(" (capacity: ");
		result.append(capacity);
		result.append(", type: ");
		result.append(type);
		result.append(", name: ");
		result.append(name);
		result.append(", acquisitionDemand: ");
		result.append(acquisitionDemand);
		result.append(')');
		return result.toString();
	}

} //PassiveResourceConfigurationImpl
