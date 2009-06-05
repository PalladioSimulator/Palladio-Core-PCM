
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ocl.expressions.OCLExpression;

import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;

import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ImplementationComponentTypeImpl#getParentCompleteComponentTypes <em>Parent Complete Component Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplementationComponentTypeImpl extends CompleteComponentTypeImpl implements ImplementationComponentType {
	/**
	 * The cached value of the '{@link #getParentCompleteComponentTypes() <em>Parent Complete Component Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentCompleteComponentTypes()
	 * @generated
	 * @ordered
	 */
	protected EList parentCompleteComponentTypes = null;


	/**
	 * The parsed OCL expression for the definition of the '{@link #RequiredInterfacesHaveToConformToCompleteType <em>Required Interfaces Have To Conform To Complete Type</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RequiredInterfacesHaveToConformToCompleteType
	 * @generated
	 */
	private static OCLExpression RequiredInterfacesHaveToConformToCompleteTypeInvOCL;
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #providedInterfacesHaveToConformToCompleteType <em>Provided Interfaces Have To Conform To Complete Type</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #providedInterfacesHaveToConformToCompleteType
	 * @generated
	 */
	private static OCLExpression providedInterfacesHaveToConformToCompleteTypeInvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplementationComponentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.IMPLEMENTATION_COMPONENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParentCompleteComponentTypes() {
		if (parentCompleteComponentTypes == null) {
			parentCompleteComponentTypes = new EObjectResolvingEList(CompleteComponentType.class, this, RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES);
		}
		return parentCompleteComponentTypes;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean RequiredInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics, Map context) {
		if (RequiredInterfacesHaveToConformToCompleteTypeInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "       let parentInterfaces : Bag(Interface) =   self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc1 : Bag(Interface) = Bag{} |    acc1->union(pt.requiredRoles->iterate(r : RequiredRole; acc2 : Bag(Interface) = Bag{} |     acc2->union(r.requiredInterface.parentInterface->asBag())    ))   ) in  let anchestorInterfaces : Bag(Interface) =   self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc3 : Bag(Interface) = Bag{} |    acc3->union(pt.requiredRoles->iterate(r : RequiredRole; acc4 : Bag(Interface) = Bag{} |     acc4->union(r.requiredInterface.parentInterface->asBag())    ))   )->union(    self.parentCompleteComponentTypes->iterate(pt : CompleteComponentType; acc5 : Bag(Interface) = Bag{} |     acc5->union(pt.requiredRoles->iterate(r : RequiredRole; acc6 : Bag(Interface) = Bag{} |      acc6->union(r.requiredInterface.parentInterface.anchestorInterfaces)     ))    )   ) in   anchestorInterfaces.identifier.id->includesAll(   self.requiredRoles->iterate(p : RequiredRole; acc7 : Bag(String) = Bag{} |    acc7->union(p.requiredInterface.identifier.id->asBag())   )   ) ";
			
			try {
				RequiredInterfacesHaveToConformToCompleteTypeInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(RequiredInterfacesHaveToConformToCompleteTypeInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
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
	public boolean providedInterfacesHaveToConformToCompleteType(DiagnosticChain diagnostics, Map context) {
		if (providedInterfacesHaveToConformToCompleteTypeInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "        let parentInterfaces : Bag(Interface) =   self.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(Interface) = Bag{} |    acc2->union(r.providedInterface.parentInterface->asBag())   ) in  let anchestorInterfaces : Bag(Interface) =   self.providedRoles->iterate(r : ProvidedRole; acc4 : Bag(Interface) = Bag{} |    acc4->union(r.providedInterface.parentInterface->asBag())   )->union(    self.providedRoles->iterate(r : ProvidedRole; acc6 : Bag(Interface) = Bag{} |     acc6->union(r.providedInterface.parentInterface.anchestorInterfaces)    )   ) in     anchestorInterfaces.identifier.id->includesAll(    self.parentProvidesComponentTypes->iterate(pt : ProvidesComponentType; acc1 : Bag(String) = Bag{} |     pt.providedRoles->iterate(r : ProvidedRole; acc2 : Bag(String) = Bag{} |      acc2->union(r.providedInterface.identifier.id->asBag())     )    )   ) ";
			
			try {
				providedInterfacesHaveToConformToCompleteTypeInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(providedInterfacesHaveToConformToCompleteTypeInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES:
				return getParentCompleteComponentTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES:
				getParentCompleteComponentTypes().clear();
				getParentCompleteComponentTypes().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES:
				getParentCompleteComponentTypes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RepositoryPackage.IMPLEMENTATION_COMPONENT_TYPE__PARENT_COMPLETE_COMPONENT_TYPES:
				return parentCompleteComponentTypes != null && !parentCompleteComponentTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ImplementationComponentTypeImpl