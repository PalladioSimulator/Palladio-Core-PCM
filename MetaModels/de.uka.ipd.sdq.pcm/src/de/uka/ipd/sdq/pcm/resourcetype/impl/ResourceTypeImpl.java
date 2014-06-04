/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.ResourceProvidedRole;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.units.Unit;
import de.uka.ipd.sdq.units.UnitCarryingElement;
import de.uka.ipd.sdq.units.UnitsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Resource Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl#getUnitSpecification <em>Unit Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl#getResourceProvidedRoles__ResourceInterfaceProvidingEntity <em>Resource Provided Roles Resource Interface Providing Entity</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceTypeImpl#getResourceRepository_ResourceType <em>Resource Repository Resource Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ResourceTypeImpl extends EntityImpl implements ResourceType {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getUnitSpecification() <em>Unit Specification</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getUnitSpecification()
     * @generated
     * @ordered
     */
    protected static final String UNIT_SPECIFICATION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUnitSpecification() <em>Unit Specification</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getUnitSpecification()
     * @generated
     * @ordered
     */
    protected String unitSpecification = UNIT_SPECIFICATION_EDEFAULT;

    /**
     * The cached value of the '{@link #getResourceProvidedRoles__ResourceInterfaceProvidingEntity() <em>Resource Provided Roles Resource Interface Providing Entity</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getResourceProvidedRoles__ResourceInterfaceProvidingEntity()
     * @generated
     * @ordered
     */
    protected EList<ResourceProvidedRole> resourceProvidedRoles__ResourceInterfaceProvidingEntity;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ResourceTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourcetypePackage.Literals.RESOURCE_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Unit getUnit() {
        Unit unit = basicGetUnit();
        return unit != null && ((EObject)unit).eIsProxy() ? (Unit)eResolveProxy((InternalEObject)unit) : unit;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    public Unit basicGetUnit() {
        // TODO: implement this method to return the 'Unit' reference
        // -> do not perform proxy resolution
        // Ensure that you remove @generated or mark it @generated NOT
        // throw new UnsupportedOperationException();
        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated not
     */
    public void setUnit(Unit newUnit) {
        // TODO: implement this method to set the 'Unit' reference
        // Ensure that you remove @generated or mark it @generated NOT
        // throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public String getUnitSpecification() {
        return unitSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setUnitSpecification(String newUnitSpecification) {
        String oldUnitSpecification = unitSpecification;
        unitSpecification = newUnitSpecification;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION, oldUnitSpecification, unitSpecification));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<ResourceProvidedRole> getResourceProvidedRoles__ResourceInterfaceProvidingEntity() {
        if (resourceProvidedRoles__ResourceInterfaceProvidingEntity == null) {
            resourceProvidedRoles__ResourceInterfaceProvidingEntity = new EObjectContainmentWithInverseEList<ResourceProvidedRole>(ResourceProvidedRole.class, this, ResourcetypePackage.RESOURCE_TYPE__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY, EntityPackage.RESOURCE_PROVIDED_ROLE__RESOURCE_INTERFACE_PROVIDING_ENTITY_RESOURCE_PROVIDED_ROLE);
        }
        return resourceProvidedRoles__ResourceInterfaceProvidingEntity;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public ResourceRepository getResourceRepository_ResourceType() {
        if (eContainerFeatureID() != ResourcetypePackage.RESOURCE_TYPE__RESOURCE_REPOSITORY_RESOURCE_TYPE) return null;
        return (ResourceRepository)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetResourceRepository_ResourceType(
            ResourceRepository newResourceRepository_ResourceType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newResourceRepository_ResourceType, ResourcetypePackage.RESOURCE_TYPE__RESOURCE_REPOSITORY_RESOURCE_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setResourceRepository_ResourceType(ResourceRepository newResourceRepository_ResourceType) {
        if (newResourceRepository_ResourceType != eInternalContainer() || (eContainerFeatureID() != ResourcetypePackage.RESOURCE_TYPE__RESOURCE_REPOSITORY_RESOURCE_TYPE && newResourceRepository_ResourceType != null)) {
            if (EcoreUtil.isAncestor(this, (EObject)newResourceRepository_ResourceType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newResourceRepository_ResourceType != null)
                msgs = ((InternalEObject)newResourceRepository_ResourceType).eInverseAdd(this, ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY, ResourceRepository.class, msgs);
            msgs = basicSetResourceRepository_ResourceType(newResourceRepository_ResourceType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ResourcetypePackage.RESOURCE_TYPE__RESOURCE_REPOSITORY_RESOURCE_TYPE, newResourceRepository_ResourceType, newResourceRepository_ResourceType));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getResourceProvidedRoles__ResourceInterfaceProvidingEntity()).basicAdd(otherEnd, msgs);
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_REPOSITORY_RESOURCE_TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetResourceRepository_ResourceType((ResourceRepository)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY:
                return ((InternalEList<?>)getResourceProvidedRoles__ResourceInterfaceProvidingEntity()).basicRemove(otherEnd, msgs);
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_REPOSITORY_RESOURCE_TYPE:
                return basicSetResourceRepository_ResourceType(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_REPOSITORY_RESOURCE_TYPE:
                return eInternalContainer().eInverseRemove(this, ResourcetypePackage.RESOURCE_REPOSITORY__AVAILABLE_RESOURCE_TYPES_RESOURCE_REPOSITORY, ResourceRepository.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ResourcetypePackage.RESOURCE_TYPE__UNIT:
                if (resolve) return getUnit();
                return basicGetUnit();
            case ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION:
                return getUnitSpecification();
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY:
                return getResourceProvidedRoles__ResourceInterfaceProvidingEntity();
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_REPOSITORY_RESOURCE_TYPE:
                return getResourceRepository_ResourceType();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ResourcetypePackage.RESOURCE_TYPE__UNIT:
                setUnit((Unit)newValue);
                return;
            case ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION:
                setUnitSpecification((String)newValue);
                return;
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY:
                getResourceProvidedRoles__ResourceInterfaceProvidingEntity().clear();
                getResourceProvidedRoles__ResourceInterfaceProvidingEntity().addAll((Collection<? extends ResourceProvidedRole>)newValue);
                return;
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_REPOSITORY_RESOURCE_TYPE:
                setResourceRepository_ResourceType((ResourceRepository)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ResourcetypePackage.RESOURCE_TYPE__UNIT:
                setUnit((Unit)null);
                return;
            case ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION:
                setUnitSpecification(UNIT_SPECIFICATION_EDEFAULT);
                return;
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY:
                getResourceProvidedRoles__ResourceInterfaceProvidingEntity().clear();
                return;
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_REPOSITORY_RESOURCE_TYPE:
                setResourceRepository_ResourceType((ResourceRepository)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ResourcetypePackage.RESOURCE_TYPE__UNIT:
                return basicGetUnit() != null;
            case ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION:
                return UNIT_SPECIFICATION_EDEFAULT == null ? unitSpecification != null : !UNIT_SPECIFICATION_EDEFAULT.equals(unitSpecification);
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY:
                return resourceProvidedRoles__ResourceInterfaceProvidingEntity != null && !resourceProvidedRoles__ResourceInterfaceProvidingEntity.isEmpty();
            case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_REPOSITORY_RESOURCE_TYPE:
                return getResourceRepository_ResourceType() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == UnitCarryingElement.class) {
            switch (derivedFeatureID) {
                case ResourcetypePackage.RESOURCE_TYPE__UNIT: return UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT;
                case ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION: return UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT_SPECIFICATION;
                default: return -1;
            }
        }
        if (baseClass == ResourceInterfaceProvidingEntity.class) {
            switch (derivedFeatureID) {
                case ResourcetypePackage.RESOURCE_TYPE__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY: return EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == UnitCarryingElement.class) {
            switch (baseFeatureID) {
                case UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT: return ResourcetypePackage.RESOURCE_TYPE__UNIT;
                case UnitsPackage.UNIT_CARRYING_ELEMENT__UNIT_SPECIFICATION: return ResourcetypePackage.RESOURCE_TYPE__UNIT_SPECIFICATION;
                default: return -1;
            }
        }
        if (baseClass == ResourceInterfaceProvidingEntity.class) {
            switch (baseFeatureID) {
                case EntityPackage.RESOURCE_INTERFACE_PROVIDING_ENTITY__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY: return ResourcetypePackage.RESOURCE_TYPE__RESOURCE_PROVIDED_ROLES_RESOURCE_INTERFACE_PROVIDING_ENTITY;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (unitSpecification: ");
        result.append(unitSpecification);
        result.append(')');
        return result.toString();
    }

} // ResourceTypeImpl
