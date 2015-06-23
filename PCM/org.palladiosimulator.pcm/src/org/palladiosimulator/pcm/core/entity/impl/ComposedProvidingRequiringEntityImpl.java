/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.core.entity.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.pcm.core.composition.impl.ComposedStructureImpl;
import org.palladiosimulator.pcm.core.entity.ComposedProvidingRequiringEntity;
import org.palladiosimulator.pcm.core.entity.EntityPackage;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingEntity;
import org.palladiosimulator.pcm.core.entity.InterfaceProvidingRequiringEntity;
import org.palladiosimulator.pcm.core.entity.InterfaceRequiringEntity;
import org.palladiosimulator.pcm.core.entity.ResourceInterfaceRequiringEntity;
import org.palladiosimulator.pcm.core.entity.ResourceRequiredRole;
import org.palladiosimulator.pcm.core.entity.util.EntityValidator;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.RequiredRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Composed Providing Requiring Entity</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl#getProvidedRoles_InterfaceProvidingEntity
 * <em>Provided Roles Interface Providing Entity</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl#getResourceRequiredRoles__ResourceInterfaceRequiringEntity
 * <em>Resource Required Roles Resource Interface Requiring Entity</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl#getRequiredRoles_InterfaceRequiringEntity
 * <em>Required Roles Interface Requiring Entity</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ComposedProvidingRequiringEntityImpl extends ComposedStructureImpl
        implements ComposedProvidingRequiringEntity {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ComposedProvidingRequiringEntityImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EntityPackage.Literals.COMPOSED_PROVIDING_REQUIRING_ENTITY;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<ProvidedRole> getProvidedRoles_InterfaceProvidingEntity() {
        return (EList<ProvidedRole>) this.eDynamicGet(
                EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY,
                EntityPackage.Literals.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<ResourceRequiredRole> getResourceRequiredRoles__ResourceInterfaceRequiringEntity() {
        return (EList<ResourceRequiredRole>) this.eDynamicGet(
                EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY,
                EntityPackage.Literals.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<RequiredRole> getRequiredRoles_InterfaceRequiringEntity() {
        return (EList<RequiredRole>) this.eDynamicGet(
                EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY,
                EntityPackage.Literals.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean ProvidedRolesMustBeBound(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, EntityValidator.DIAGNOSTIC_SOURCE,
                                EntityValidator.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_MUST_BE_BOUND,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "ProvidedRolesMustBeBound",
                                                EObjectValidator.getObjectLabel(this, context) }),
                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getProvidedRoles_InterfaceProvidingEntity()).basicAdd(otherEnd, msgs);
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getResourceRequiredRoles__ResourceInterfaceRequiringEntity()).basicAdd(otherEnd, msgs);
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getRequiredRoles_InterfaceRequiringEntity()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return ((InternalEList<?>) this.getProvidedRoles_InterfaceProvidingEntity()).basicRemove(otherEnd, msgs);
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            return ((InternalEList<?>) this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity())
                    .basicRemove(otherEnd, msgs);
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            return ((InternalEList<?>) this.getRequiredRoles_InterfaceRequiringEntity()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return this.getProvidedRoles_InterfaceProvidingEntity();
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            return this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity();
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            return this.getRequiredRoles_InterfaceRequiringEntity();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            this.getProvidedRoles_InterfaceProvidingEntity().clear();
            this.getProvidedRoles_InterfaceProvidingEntity().addAll((Collection<? extends ProvidedRole>) newValue);
            return;
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity().clear();
            this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity()
                    .addAll((Collection<? extends ResourceRequiredRole>) newValue);
            return;
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            this.getRequiredRoles_InterfaceRequiringEntity().clear();
            this.getRequiredRoles_InterfaceRequiringEntity().addAll((Collection<? extends RequiredRole>) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            this.getProvidedRoles_InterfaceProvidingEntity().clear();
            return;
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity().clear();
            return;
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            this.getRequiredRoles_InterfaceRequiringEntity().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
            return !this.getProvidedRoles_InterfaceProvidingEntity().isEmpty();
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
            return !this.getResourceRequiredRoles__ResourceInterfaceRequiringEntity().isEmpty();
        case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
            return !this.getRequiredRoles_InterfaceRequiringEntity().isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(final int derivedFeatureID, final Class<?> baseClass) {
        if (baseClass == InterfaceProvidingEntity.class) {
            switch (derivedFeatureID) {
            case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
                return EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;
            default:
                return -1;
            }
        }
        if (baseClass == ResourceInterfaceRequiringEntity.class) {
            switch (derivedFeatureID) {
            case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
                return EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;
            default:
                return -1;
            }
        }
        if (baseClass == InterfaceRequiringEntity.class) {
            switch (derivedFeatureID) {
            case EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
                return EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;
            default:
                return -1;
            }
        }
        if (baseClass == InterfaceProvidingRequiringEntity.class) {
            switch (derivedFeatureID) {
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(final int baseFeatureID, final Class<?> baseClass) {
        if (baseClass == InterfaceProvidingEntity.class) {
            switch (baseFeatureID) {
            case EntityPackage.INTERFACE_PROVIDING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY:
                return EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__PROVIDED_ROLES_INTERFACE_PROVIDING_ENTITY;
            default:
                return -1;
            }
        }
        if (baseClass == ResourceInterfaceRequiringEntity.class) {
            switch (baseFeatureID) {
            case EntityPackage.RESOURCE_INTERFACE_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY:
                return EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__RESOURCE_REQUIRED_ROLES_RESOURCE_INTERFACE_REQUIRING_ENTITY;
            default:
                return -1;
            }
        }
        if (baseClass == InterfaceRequiringEntity.class) {
            switch (baseFeatureID) {
            case EntityPackage.INTERFACE_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY:
                return EntityPackage.COMPOSED_PROVIDING_REQUIRING_ENTITY__REQUIRED_ROLES_INTERFACE_REQUIRING_ENTITY;
            default:
                return -1;
            }
        }
        if (baseClass == InterfaceProvidingRequiringEntity.class) {
            switch (baseFeatureID) {
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

} // ComposedProvidingRequiringEntityImpl
