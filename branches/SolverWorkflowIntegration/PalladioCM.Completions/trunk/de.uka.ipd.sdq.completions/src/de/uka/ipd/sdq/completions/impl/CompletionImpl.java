/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.completions.impl;

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

import de.uka.ipd.sdq.completions.Completion;
import de.uka.ipd.sdq.completions.CompletionsPackage;
import de.uka.ipd.sdq.pcm.core.entity.impl.ComposedProvidingRequiringEntityImpl;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.completions.impl.CompletionImpl#getRepository_RepositoryComponent <em>Repository Repository Component</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.completions.impl.CompletionImpl#getParentCompleteComponentTypes <em>Parent Complete Component Types</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.completions.impl.CompletionImpl#getComponentParameterUsage_ImplementationComponentType <em>Component Parameter Usage Implementation Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompletionImpl extends ComposedProvidingRequiringEntityImpl implements Completion {
	/**
	 * The cached value of the '{@link #getParentCompleteComponentTypes() <em>Parent Complete Component Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentCompleteComponentTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<CompleteComponentType> parentCompleteComponentTypes;

	/**
	 * The cached value of the '{@link #getComponentParameterUsage_ImplementationComponentType() <em>Component Parameter Usage Implementation Component Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentParameterUsage_ImplementationComponentType()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableUsage> componentParameterUsage_ImplementationComponentType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompletionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompletionsPackage.Literals.COMPLETION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository getRepository_RepositoryComponent() {
		if (eContainerFeatureID != CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT) return null;
		return (Repository)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository_RepositoryComponent(Repository newRepository_RepositoryComponent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepository_RepositoryComponent, CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepository_RepositoryComponent(Repository newRepository_RepositoryComponent) {
		if (newRepository_RepositoryComponent != eInternalContainer() || (eContainerFeatureID != CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT && newRepository_RepositoryComponent != null)) {
			if (EcoreUtil.isAncestor(this, newRepository_RepositoryComponent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepository_RepositoryComponent != null)
				msgs = ((InternalEObject)newRepository_RepositoryComponent).eInverseAdd(this, RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY, Repository.class, msgs);
			msgs = basicSetRepository_RepositoryComponent(newRepository_RepositoryComponent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT, newRepository_RepositoryComponent, newRepository_RepositoryComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CompleteComponentType> getParentCompleteComponentTypes() {
		if (parentCompleteComponentTypes == null) {
			parentCompleteComponentTypes = new EObjectResolvingEList<CompleteComponentType>(CompleteComponentType.class, this, CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES);
		}
		return parentCompleteComponentTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableUsage> getComponentParameterUsage_ImplementationComponentType() {
		if (componentParameterUsage_ImplementationComponentType == null) {
			componentParameterUsage_ImplementationComponentType = new EObjectContainmentEList<VariableUsage>(VariableUsage.class, this, CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE);
		}
		return componentParameterUsage_ImplementationComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean RequiredInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__REQUIRED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "RequiredInterfacesHaveToConformToCompleteType", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean providedInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.IMPLEMENTATION_COMPONENT_TYPE__PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_COMPLETE_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "providedInterfacesHaveToConformToCompleteType", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRepository_RepositoryComponent((Repository)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				return basicSetRepository_RepositoryComponent(null, msgs);
			case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				return ((InternalEList<?>)getComponentParameterUsage_ImplementationComponentType()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__COMPONENTS_REPOSITORY, Repository.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				return getRepository_RepositoryComponent();
			case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
				return getParentCompleteComponentTypes();
			case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				return getComponentParameterUsage_ImplementationComponentType();
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
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				setRepository_RepositoryComponent((Repository)newValue);
				return;
			case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
				getParentCompleteComponentTypes().clear();
				getParentCompleteComponentTypes().addAll((Collection<? extends CompleteComponentType>)newValue);
				return;
			case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				getComponentParameterUsage_ImplementationComponentType().clear();
				getComponentParameterUsage_ImplementationComponentType().addAll((Collection<? extends VariableUsage>)newValue);
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
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				setRepository_RepositoryComponent((Repository)null);
				return;
			case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
				getParentCompleteComponentTypes().clear();
				return;
			case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				getComponentParameterUsage_ImplementationComponentType().clear();
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
			case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT:
				return getRepository_RepositoryComponent() != null;
			case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES:
				return parentCompleteComponentTypes != null && !parentCompleteComponentTypes.isEmpty();
			case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE:
				return componentParameterUsage_ImplementationComponentType != null && !componentParameterUsage_ImplementationComponentType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == RepositoryComponent.class) {
			switch (derivedFeatureID) {
				case CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT: return RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT;
				default: return -1;
			}
		}
		if (baseClass == ImplementationComponentType.class) {
			switch (derivedFeatureID) {
				case CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES: return RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES;
				case CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE: return RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == RepositoryComponent.class) {
			switch (baseFeatureID) {
				case RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT: return CompletionsPackage.COMPLETION__REPOSITORY_REPOSITORY_COMPONENT;
				default: return -1;
			}
		}
		if (baseClass == ImplementationComponentType.class) {
			switch (baseFeatureID) {
				case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES: return CompletionsPackage.COMPLETION__PARENT_COMPLETE_COMPONENT_TYPES;
				case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE: return CompletionsPackage.COMPLETION__COMPONENT_PARAMETER_USAGE_IMPLEMENTATION_COMPONENT_TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CompletionImpl
