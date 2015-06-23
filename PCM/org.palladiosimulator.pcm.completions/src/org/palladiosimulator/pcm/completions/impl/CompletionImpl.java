/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 */
package org.palladiosimulator.pcm.completions.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.pcm.completions.Completion;
import org.palladiosimulator.pcm.completions.CompletionsPackage;
import org.palladiosimulator.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.repository.CompleteComponentType;
import org.palladiosimulator.pcm.repository.ComponentType;
import org.palladiosimulator.pcm.repository.ImplementationComponentType;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryComponent;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Completion</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.completions.impl.CompletionImpl#getRepository__RepositoryComponent
 * <em>Repository Repository Component</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.completions.impl.CompletionImpl#getParentCompleteComponentTypes
 * <em>Parent Complete Component Types</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.completions.impl.CompletionImpl#getComponentParameterUsage_ImplementationComponentType
 * <em>Component Parameter Usage Implementation Component Type</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.completions.impl.CompletionImpl#getComponentType
 * <em>Component Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompletionImpl extends ComposedProvidingRequiringEntityImpl implements Completion {

    /**
     * The cached value of the '{@link #getParentCompleteComponentTypes()
     * <em>Parent Complete Component Types</em>}' reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getParentCompleteComponentTypes()
     * @generated
     * @ordered
     */
    protected EList<CompleteComponentType> parentCompleteComponentTypes;

    /**
     * The cached value of the '{@link #getComponentParameterUsage_ImplementationComponentType()
     * <em>Component Parameter Usage Implementation Component Type</em>}' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getComponentParameterUsage_ImplementationComponentType()
     * @generated
     * @ordered
     */
    protected EList<VariableUsage> componentParameterUsage_ImplementationComponentType;

    /**
     * The default value of the '{@link #getComponentType() <em>Component Type</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getComponentType()
     * @generated
     * @ordered
     */
    protected static final ComponentType COMPONENT_TYPE_EDEFAULT = ComponentType.BUSINESS_COMPONENT;

    /**
     * The cached value of the '{@link #getComponentType() <em>Component Type</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getComponentType()
     * @generated
     * @ordered
     */
    protected ComponentType componentType = COMPONENT_TYPE_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected CompletionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompletionsPackage.Literals.COMPLETION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Repository getRepository__RepositoryComponent() {
        if (this.eContainerFeatureID() != CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT) {
            return null;
        }
        return (Repository) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetRepository__RepositoryComponent(
            final Repository newRepository__RepositoryComponent, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newRepository__RepositoryComponent,
                CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRepository__RepositoryComponent(final Repository newRepository__RepositoryComponent) {
        if (newRepository__RepositoryComponent != this.eInternalContainer()
                || (this.eContainerFeatureID() != CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT
                        && newRepository__RepositoryComponent != null)) {
            if (EcoreUtil.isAncestor(this, newRepository__RepositoryComponent)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newRepository__RepositoryComponent != null) {
                msgs = ((InternalEObject) newRepository__RepositoryComponent).eInverseAdd(this,
                        RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY, Repository.class, msgs);
            }
            msgs = this.basicSetRepository__RepositoryComponent(newRepository__RepositoryComponent, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT, newRepository__RepositoryComponent,
                    newRepository__RepositoryComponent));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<CompleteComponentType> getParentCompleteComponentTypes() {
        if (this.parentCompleteComponentTypes == null) {
            this.parentCompleteComponentTypes = new EObjectResolvingEList<CompleteComponentType>(
                    CompleteComponentType.class, this, CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES);
        }
        return this.parentCompleteComponentTypes;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<VariableUsage> getComponentParameterUsage_ImplementationComponentType() {
        if (this.componentParameterUsage_ImplementationComponentType == null) {
            this.componentParameterUsage_ImplementationComponentType = new EObjectContainmentEList<VariableUsage>(
                    VariableUsage.class, this,
                    CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE);
        }
        return this.componentParameterUsage_ImplementationComponentType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ComponentType getComponentType() {
        return this.componentType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setComponentType(final ComponentType newComponentType) {
        final ComponentType oldComponentType = this.componentType;
        this.componentType = newComponentType == null ? COMPONENT_TYPE_EDEFAULT : newComponentType;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET, CompletionsPackage.COMPLETION__COMPONENT_TYPE,
                    oldComponentType, this.componentType));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean RequiredInterfacesHaveToConformToCompleteType(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, RepositoryValidator.DIAGNOSTIC_SOURCE,
                                RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "RequiredInterfacesHaveToConformToCompleteType",
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
    @Override
    public boolean providedInterfacesHaveToConformToCompleteType(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, RepositoryValidator.DIAGNOSTIC_SOURCE,
                                RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "providedInterfacesHaveToConformToCompleteType",
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
    @Override
    public boolean ProvidedInterfaceHaveToConformToComponentType(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, RepositoryValidator.DIAGNOSTIC_SOURCE,
                                RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_INTERFACE_HAVE_TO_CONFORM_TO_COMPONENT_TYPE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "ProvidedInterfaceHaveToConformToComponentType",
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
    @Override
    public boolean ProvideSameOrMoreInterfacesAsCompleteComponentType(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, RepositoryValidator.DIAGNOSTIC_SOURCE,
                                RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__PROVIDE_SAME_OR_MORE_INTERFACES_AS_COMPLETE_COMPONENT_TYPE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "ProvideSameOrMoreInterfacesAsCompleteComponentType",
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
    @Override
    public boolean RequireSameOrFewerInterfacesAsCompleteComponentType(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, RepositoryValidator.DIAGNOSTIC_SOURCE,
                                RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__REQUIRE_SAME_OR_FEWER_INTERFACES_AS_COMPLETE_COMPONENT_TYPE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "RequireSameOrFewerInterfacesAsCompleteComponentType",
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
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetRepository__RepositoryComponent((Repository) otherEnd, msgs);
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
        case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
            return this.basicSetRepository__RepositoryComponent(null, msgs);
        case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
            return ((InternalEList<?>) this.getComponentParameterUsage_ImplementationComponentType())
                    .basicRemove(otherEnd, msgs);
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
        case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
            return this.eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY,
                    Repository.class, msgs);
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
        case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
            return this.getRepository__RepositoryComponent();
        case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
            return this.getParentCompleteComponentTypes();
        case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
            return this.getComponentParameterUsage_ImplementationComponentType();
        case CompletionsPackage.COMPLETION__COMPONENT_TYPE:
            return this.getComponentType();
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
        case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
            this.setRepository__RepositoryComponent((Repository) newValue);
            return;
        case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
            this.getParentCompleteComponentTypes().clear();
            this.getParentCompleteComponentTypes().addAll((Collection<? extends CompleteComponentType>) newValue);
            return;
        case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
            this.getComponentParameterUsage_ImplementationComponentType().clear();
            this.getComponentParameterUsage_ImplementationComponentType()
                    .addAll((Collection<? extends VariableUsage>) newValue);
            return;
        case CompletionsPackage.COMPLETION__COMPONENT_TYPE:
            this.setComponentType((ComponentType) newValue);
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
        case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
            this.setRepository__RepositoryComponent((Repository) null);
            return;
        case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
            this.getParentCompleteComponentTypes().clear();
            return;
        case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
            this.getComponentParameterUsage_ImplementationComponentType().clear();
            return;
        case CompletionsPackage.COMPLETION__COMPONENT_TYPE:
            this.setComponentType(COMPONENT_TYPE_EDEFAULT);
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
        case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
            return this.getRepository__RepositoryComponent() != null;
        case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
            return this.parentCompleteComponentTypes != null && !this.parentCompleteComponentTypes.isEmpty();
        case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
            return this.componentParameterUsage_ImplementationComponentType != null
                    && !this.componentParameterUsage_ImplementationComponentType.isEmpty();
        case CompletionsPackage.COMPLETION__COMPONENT_TYPE:
            return this.componentType != COMPONENT_TYPE_EDEFAULT;
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
        if (baseClass == RepositoryComponent.class) {
            switch (derivedFeatureID) {
            case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
                return RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT;
            default:
                return -1;
            }
        }
        if (baseClass == ImplementationComponentType.class) {
            switch (derivedFeatureID) {
            case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
                return RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES;
            case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
                return RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE;
            case CompletionsPackage.COMPLETION__COMPONENT_TYPE:
                return RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE;
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
        if (baseClass == RepositoryComponent.class) {
            switch (baseFeatureID) {
            case RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT:
                return CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT;
            default:
                return -1;
            }
        }
        if (baseClass == ImplementationComponentType.class) {
            switch (baseFeatureID) {
            case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES:
                return CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES;
            case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
                return CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE;
            case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_TYPE:
                return CompletionsPackage.COMPLETION__COMPONENT_TYPE;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (componentType: ");
        result.append(this.componentType);
        result.append(')');
        return result.toString();
    }

} // CompletionImpl
