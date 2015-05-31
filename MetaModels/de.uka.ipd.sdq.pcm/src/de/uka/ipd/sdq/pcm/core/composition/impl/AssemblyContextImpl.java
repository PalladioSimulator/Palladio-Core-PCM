/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Assembly Context</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyContextImpl#getParentStructure__AssemblyContext
 * <em>Parent Structure Assembly Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyContextImpl#getEncapsulatedComponent__AssemblyContext
 * <em>Encapsulated Component Assembly Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyContextImpl#getConfigParameterUsages__AssemblyContext
 * <em>Config Parameter Usages Assembly Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssemblyContextImpl extends EntityImpl implements AssemblyContext {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getEncapsulatedComponent__AssemblyContext()
     * <em>Encapsulated Component Assembly Context</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getEncapsulatedComponent__AssemblyContext()
     * @generated
     * @ordered
     */
    protected RepositoryComponent encapsulatedComponent__AssemblyContext;
    /**
     * The cached value of the '{@link #getConfigParameterUsages__AssemblyContext()
     * <em>Config Parameter Usages Assembly Context</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getConfigParameterUsages__AssemblyContext()
     * @generated
     * @ordered
     */
    protected EList<VariableUsage> configParameterUsages__AssemblyContext;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AssemblyContextImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.ASSEMBLY_CONTEXT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ComposedStructure getParentStructure__AssemblyContext() {
        if (this.eContainerFeatureID() != CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT) {
            return null;
        }
        return (ComposedStructure) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParentStructure__AssemblyContext(
            final ComposedStructure newParentStructure__AssemblyContext, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newParentStructure__AssemblyContext,
                CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParentStructure__AssemblyContext(final ComposedStructure newParentStructure__AssemblyContext) {
        if (newParentStructure__AssemblyContext != this.eInternalContainer()
                || (this.eContainerFeatureID() != CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT && newParentStructure__AssemblyContext != null)) {
            if (EcoreUtil.isAncestor(this, newParentStructure__AssemblyContext)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newParentStructure__AssemblyContext != null) {
                msgs = ((InternalEObject) newParentStructure__AssemblyContext).eInverseAdd(this,
                        CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE,
                        ComposedStructure.class, msgs);
            }
            msgs = this.basicSetParentStructure__AssemblyContext(newParentStructure__AssemblyContext, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT,
                    newParentStructure__AssemblyContext, newParentStructure__AssemblyContext));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RepositoryComponent getEncapsulatedComponent__AssemblyContext() {
        if (this.encapsulatedComponent__AssemblyContext != null
                && this.encapsulatedComponent__AssemblyContext.eIsProxy()) {
            final InternalEObject oldEncapsulatedComponent__AssemblyContext = (InternalEObject) this.encapsulatedComponent__AssemblyContext;
            this.encapsulatedComponent__AssemblyContext = (RepositoryComponent) this
                    .eResolveProxy(oldEncapsulatedComponent__AssemblyContext);
            if (this.encapsulatedComponent__AssemblyContext != oldEncapsulatedComponent__AssemblyContext) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT,
                            oldEncapsulatedComponent__AssemblyContext, this.encapsulatedComponent__AssemblyContext));
                }
            }
        }
        return this.encapsulatedComponent__AssemblyContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RepositoryComponent basicGetEncapsulatedComponent__AssemblyContext() {
        return this.encapsulatedComponent__AssemblyContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEncapsulatedComponent__AssemblyContext(
            final RepositoryComponent newEncapsulatedComponent__AssemblyContext) {
        final RepositoryComponent oldEncapsulatedComponent__AssemblyContext = this.encapsulatedComponent__AssemblyContext;
        this.encapsulatedComponent__AssemblyContext = newEncapsulatedComponent__AssemblyContext;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT,
                    oldEncapsulatedComponent__AssemblyContext, this.encapsulatedComponent__AssemblyContext));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<VariableUsage> getConfigParameterUsages__AssemblyContext() {
        if (this.configParameterUsages__AssemblyContext == null) {
            this.configParameterUsages__AssemblyContext = new EObjectContainmentWithInverseEList<VariableUsage>(
                    VariableUsage.class, this,
                    CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT,
                    ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE);
        }
        return this.configParameterUsages__AssemblyContext;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetParentStructure__AssemblyContext((ComposedStructure) otherEnd, msgs);
        case CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getConfigParameterUsages__AssemblyContext()).basicAdd(otherEnd, msgs);
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
        case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
            return this.basicSetParentStructure__AssemblyContext(null, msgs);
        case CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT:
            return ((InternalEList<?>) this.getConfigParameterUsages__AssemblyContext()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
            return this.eInternalContainer().eInverseRemove(this,
                    CompositionPackage.COMPOSED_STRUCTURE__ASSEMBLY_CONTEXTS_COMPOSED_STRUCTURE,
                    ComposedStructure.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
            return this.getParentStructure__AssemblyContext();
        case CompositionPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT:
            if (resolve) {
                return this.getEncapsulatedComponent__AssemblyContext();
            }
            return this.basicGetEncapsulatedComponent__AssemblyContext();
        case CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT:
            return this.getConfigParameterUsages__AssemblyContext();
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
        case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
            this.setParentStructure__AssemblyContext((ComposedStructure) newValue);
            return;
        case CompositionPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT:
            this.setEncapsulatedComponent__AssemblyContext((RepositoryComponent) newValue);
            return;
        case CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT:
            this.getConfigParameterUsages__AssemblyContext().clear();
            this.getConfigParameterUsages__AssemblyContext().addAll((Collection<? extends VariableUsage>) newValue);
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
        case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
            this.setParentStructure__AssemblyContext((ComposedStructure) null);
            return;
        case CompositionPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT:
            this.setEncapsulatedComponent__AssemblyContext((RepositoryComponent) null);
            return;
        case CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT:
            this.getConfigParameterUsages__AssemblyContext().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_CONTEXT__PARENT_STRUCTURE_ASSEMBLY_CONTEXT:
            return this.getParentStructure__AssemblyContext() != null;
        case CompositionPackage.ASSEMBLY_CONTEXT__ENCAPSULATED_COMPONENT_ASSEMBLY_CONTEXT:
            return this.encapsulatedComponent__AssemblyContext != null;
        case CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT:
            return this.configParameterUsages__AssemblyContext != null
                    && !this.configParameterUsages__AssemblyContext.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // AssemblyContextImpl
