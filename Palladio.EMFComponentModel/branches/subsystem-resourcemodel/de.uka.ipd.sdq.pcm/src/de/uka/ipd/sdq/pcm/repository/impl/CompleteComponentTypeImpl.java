/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import de.uka.ipd.sdq.pcm.core.entity.impl.InterfaceProvidingRequiringEntityImpl;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompleteComponentTypeImpl#getRepository_RepositoryComponent <em>Repository Repository Component</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompleteComponentTypeImpl#getParentProvidesComponentTypes <em>Parent Provides Component Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompleteComponentTypeImpl extends InterfaceProvidingRequiringEntityImpl implements CompleteComponentType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getParentProvidesComponentTypes() <em>Parent Provides Component Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentProvidesComponentTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ProvidesComponentType> parentProvidesComponentTypes;

	/**
	 * The parsed OCL expression for the definition of the '{@link #AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType <em>At Least One Interface Has To Be Provided Or Required By AUsefull Complete Component Type</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType
	 * @generated
	 */
	private static OCLExpression AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentTypeInvOCL;
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #providedInterfacesHaveToConformToProvidedType2 <em>Provided Interfaces Have To Conform To Provided Type2</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #providedInterfacesHaveToConformToProvidedType2
	 * @generated
	 */
	private static OCLExpression providedInterfacesHaveToConformToProvidedType2InvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompleteComponentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.COMPLETE_COMPONENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository getRepository_RepositoryComponent() {
		if (eContainerFeatureID != RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT) return null;
		return (Repository)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository_RepositoryComponent(Repository newRepository_RepositoryComponent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepository_RepositoryComponent, RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepository_RepositoryComponent(Repository newRepository_RepositoryComponent) {
		if (newRepository_RepositoryComponent != eInternalContainer() || (eContainerFeatureID != RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT && newRepository_RepositoryComponent != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT, newRepository_RepositoryComponent, newRepository_RepositoryComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProvidesComponentType> getParentProvidesComponentTypes() {
		if (parentProvidesComponentTypes == null) {
			parentProvidesComponentTypes = new EObjectResolvingEList<ProvidesComponentType>(ProvidesComponentType.class, this, RepositoryPackage.COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES);
		}
		return parentProvidesComponentTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentTypeInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "(  	self.oclIsTypeOf(CompleteComponentType)  	or  	self.oclIsTypeOf(ImplementationComponentType)  	or  	self.oclIsTypeOf(CompositeComponent)  	or  	self.oclIsTypeOf(BasicComponent)  )  implies  (  	self.providedRoles_InterfaceProvidingEntity->size() >= 1  	or  	self.requiredRoles_InterfaceRequiringEntity->size() >= 1  ) ";
			
			try {
				AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentTypeInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentTypeInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.COMPLETE_COMPONENT_TYPE__AT_LEAST_ONE_INTERFACE_HAS_TO_BE_PROVIDED_OR_REQUIRED_BY_AUSEFULL_COMPLETE_COMPONENT_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AtLeastOneInterfaceHasToBeProvidedOrRequiredByAUsefullCompleteComponentType", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean providedInterfacesHaveToConformToProvidedType2(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (providedInterfacesHaveToConformToProvidedType2InvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "                           true ";
			
			try {
				providedInterfacesHaveToConformToProvidedType2InvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(providedInterfacesHaveToConformToProvidedType2InvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.COMPLETE_COMPONENT_TYPE__PROVIDED_INTERFACES_HAVE_TO_CONFORM_TO_PROVIDED_TYPE2,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "providedInterfacesHaveToConformToProvidedType2", EObjectValidator.getObjectLabel(this, context) }),
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
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT:
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
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT:
				return basicSetRepository_RepositoryComponent(null, msgs);
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
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT:
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
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT:
				return getRepository_RepositoryComponent();
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES:
				return getParentProvidesComponentTypes();
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
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT:
				setRepository_RepositoryComponent((Repository)newValue);
				return;
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES:
				getParentProvidesComponentTypes().clear();
				getParentProvidesComponentTypes().addAll((Collection<? extends ProvidesComponentType>)newValue);
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
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT:
				setRepository_RepositoryComponent((Repository)null);
				return;
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES:
				getParentProvidesComponentTypes().clear();
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
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT:
				return getRepository_RepositoryComponent() != null;
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES:
				return parentProvidesComponentTypes != null && !parentProvidesComponentTypes.isEmpty();
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
				case RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT: return RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT;
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
				case RepositoryPackage.REPOSITORY_COMPONENT__REPOSITORY_REPOSITORY_COMPONENT: return RepositoryPackage.COMPLETE_COMPONENT_TYPE__REPOSITORY_REPOSITORY_COMPONENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CompleteComponentTypeImpl
