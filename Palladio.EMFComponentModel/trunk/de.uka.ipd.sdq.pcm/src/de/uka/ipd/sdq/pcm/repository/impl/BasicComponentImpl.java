
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;

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
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.OCLExpression;

import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;

import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.BasicComponentImpl#getImplementationComponentType <em>Implementation Component Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.BasicComponentImpl#getServiceEffectSpecifications__BasicComponent <em>Service Effect Specifications Basic Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BasicComponentImpl extends ImplementationComponentTypeImpl implements BasicComponent {
	/**
	 * The cached value of the '{@link #getImplementationComponentType() <em>Implementation Component Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationComponentType()
	 * @generated
	 * @ordered
	 */
	protected ImplementationComponentType implementationComponentType = null;

	/**
	 * The cached value of the '{@link #getServiceEffectSpecifications__BasicComponent() <em>Service Effect Specifications Basic Component</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceEffectSpecifications__BasicComponent()
	 * @generated
	 * @ordered
	 */
	protected EList serviceEffectSpecifications__BasicComponent = null;


	/**
	 * The parsed OCL expression for the definition of the '{@link #noSeffTypeUsedTwice <em>No Seff Type Used Twice</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #noSeffTypeUsedTwice
	 * @generated
	 */
	private static OCLExpression noSeffTypeUsedTwiceInvOCL;
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #ProvideSameInterfaces <em>Provide Same Interfaces</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ProvideSameInterfaces
	 * @generated
	 */
	private static OCLExpression ProvideSameInterfacesInvOCL;
	
	/**
	 * The parsed OCL expression for the definition of the '{@link #RequireSameInterfaces <em>Require Same Interfaces</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RequireSameInterfaces
	 * @generated
	 */
	private static OCLExpression RequireSameInterfacesInvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.BASIC_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationComponentType getImplementationComponentType() {
		if (implementationComponentType != null && implementationComponentType.eIsProxy()) {
			InternalEObject oldImplementationComponentType = (InternalEObject)implementationComponentType;
			implementationComponentType = (ImplementationComponentType)eResolveProxy(oldImplementationComponentType);
			if (implementationComponentType != oldImplementationComponentType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositoryPackage.BASIC_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE, oldImplementationComponentType, implementationComponentType));
			}
		}
		return implementationComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationComponentType basicGetImplementationComponentType() {
		return implementationComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationComponentType(ImplementationComponentType newImplementationComponentType) {
		ImplementationComponentType oldImplementationComponentType = implementationComponentType;
		implementationComponentType = newImplementationComponentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.BASIC_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE, oldImplementationComponentType, implementationComponentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getServiceEffectSpecifications__BasicComponent() {
		if (serviceEffectSpecifications__BasicComponent == null) {
			serviceEffectSpecifications__BasicComponent = new EObjectContainmentEList(ServiceEffectSpecification.class, this, RepositoryPackage.BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT);
		}
		return serviceEffectSpecifications__BasicComponent;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean noSeffTypeUsedTwice(DiagnosticChain diagnostics, Map context) {
		if (noSeffTypeUsedTwiceInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.serviceEffectSpecifications->forAll(p1, p2 |  p1.seffTypeID <> p2.seffTypeID) ";
			
			try {
				noSeffTypeUsedTwiceInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(noSeffTypeUsedTwiceInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.BASIC_COMPONENT__NO_SEFF_TYPE_USED_TWICE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "noSeffTypeUsedTwice", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean ProvideSameInterfaces(DiagnosticChain diagnostics, Map context) {
		if (ProvideSameInterfacesInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = " self.providedRoles->iterate(pr : ProvidedRole; acc1 : Bag(String) = Bag{} |   acc1->union(pr.providedInterface.identifier.id->asBag())  )  =  if      self.implementationComponentType->notEmpty()  then   self.implementationComponentType.providedRoles->iterate(pr : ProvidedRole; acc2 : Bag(String) = Bag{} |    acc2->union(pr.providedInterface.identifier.id->asBag())   )  else   Bag{}  endif ";
			
			try {
				ProvideSameInterfacesInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ProvideSameInterfacesInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.BASIC_COMPONENT__PROVIDE_SAME_INTERFACES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ProvideSameInterfaces", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean RequireSameInterfaces(DiagnosticChain diagnostics, Map context) {
		if (RequireSameInterfacesInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = " self.requiredRoles->iterate(pr : RequiredRole; acc1 : Bag(String) = Bag{} |   acc1->union(pr.requiredInterface.identifier.id->asBag())  )  =  if      self.implementationComponentType->notEmpty()  then   self.implementationComponentType.requiredRoles->iterate(pr : RequiredRole; acc2 : Bag(String) = Bag{} |    acc2->union(pr.requiredInterface.identifier.id->asBag())   )  else   Bag{}  endif ";
			
			try {
				RequireSameInterfacesInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(RequireSameInterfacesInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.BASIC_COMPONENT__REQUIRE_SAME_INTERFACES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "RequireSameInterfaces", EObjectValidator.getObjectLabel(this, context) }),
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT:
				return ((InternalEList)getServiceEffectSpecifications__BasicComponent()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.BASIC_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE:
				if (resolve) return getImplementationComponentType();
				return basicGetImplementationComponentType();
			case RepositoryPackage.BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT:
				return getServiceEffectSpecifications__BasicComponent();
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
			case RepositoryPackage.BASIC_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE:
				setImplementationComponentType((ImplementationComponentType)newValue);
				return;
			case RepositoryPackage.BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT:
				getServiceEffectSpecifications__BasicComponent().clear();
				getServiceEffectSpecifications__BasicComponent().addAll((Collection)newValue);
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
			case RepositoryPackage.BASIC_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE:
				setImplementationComponentType((ImplementationComponentType)null);
				return;
			case RepositoryPackage.BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT:
				getServiceEffectSpecifications__BasicComponent().clear();
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
			case RepositoryPackage.BASIC_COMPONENT__IMPLEMENTATION_COMPONENT_TYPE:
				return implementationComponentType != null;
			case RepositoryPackage.BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT:
				return serviceEffectSpecifications__BasicComponent != null && !serviceEffectSpecifications__BasicComponent.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BasicComponentImpl