
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;

import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
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
 * An implementation of the model object '<em><b>Provides Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidesComponentTypeImpl#getProvidedRoles__ProvidesComponentType <em>Provided Roles Provides Component Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ProvidesComponentTypeImpl#getRequiredRoles_ProvidesComponentType <em>Required Roles Provides Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProvidesComponentTypeImpl extends EntityImpl implements ProvidesComponentType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getProvidedRoles__ProvidesComponentType() <em>Provided Roles Provides Component Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedRoles__ProvidesComponentType()
	 * @generated
	 * @ordered
	 */
	protected EList providedRoles__ProvidesComponentType = null;

	/**
	 * The cached value of the '{@link #getRequiredRoles_ProvidesComponentType() <em>Required Roles Provides Component Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredRoles_ProvidesComponentType()
	 * @generated
	 * @ordered
	 */
	protected EList requiredRoles_ProvidesComponentType = null;


	/**
	 * The parsed OCL expression for the definition of the '{@link #AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType <em>At Least One Interface Has To Be Provided By AUsefull Provides Component Type</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType
	 * @generated
	 */
	private static OCLExpression AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentTypeInvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProvidesComponentTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.PROVIDES_COMPONENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getProvidedRoles__ProvidesComponentType() {
		if (providedRoles__ProvidesComponentType == null) {
			providedRoles__ProvidesComponentType = new EObjectContainmentWithInverseEList(ProvidedRole.class, this, RepositoryPackage.PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE, RepositoryPackage.PROVIDED_ROLE__PROVIDING_COMPONENT_PROVIDED_ROLE);
		}
		return providedRoles__ProvidesComponentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRequiredRoles_ProvidesComponentType() {
		if (requiredRoles_ProvidesComponentType == null) {
			requiredRoles_ProvidesComponentType = new EObjectContainmentEList(RequiredRole.class, this, RepositoryPackage.PROVIDES_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE);
		}
		return requiredRoles_ProvidesComponentType;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(DiagnosticChain diagnostics, Map context) {
		if (AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentTypeInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.oclIsTypeOf(ProvidesComponentType)  implies  self.providedRoles->size() >= 1 ";
			
			try {
				AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentTypeInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentTypeInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.PROVIDES_COMPONENT_TYPE__AT_LEAST_ONE_INTERFACE_HAS_TO_BE_PROVIDED_BY_AUSEFULL_PROVIDES_COMPONENT_TYPE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType", EObjectValidator.getObjectLabel(this, context) }),
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE:
				return ((InternalEList)getProvidedRoles__ProvidesComponentType()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE:
				return ((InternalEList)getProvidedRoles__ProvidesComponentType()).basicRemove(otherEnd, msgs);
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE:
				return ((InternalEList)getRequiredRoles_ProvidesComponentType()).basicRemove(otherEnd, msgs);
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
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE:
				return getProvidedRoles__ProvidesComponentType();
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE:
				return getRequiredRoles_ProvidesComponentType();
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
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE:
				getProvidedRoles__ProvidesComponentType().clear();
				getProvidedRoles__ProvidesComponentType().addAll((Collection)newValue);
				return;
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE:
				getRequiredRoles_ProvidesComponentType().clear();
				getRequiredRoles_ProvidesComponentType().addAll((Collection)newValue);
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
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE:
				getProvidedRoles__ProvidesComponentType().clear();
				return;
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE:
				getRequiredRoles_ProvidesComponentType().clear();
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
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE__PROVIDED_ROLES_PROVIDES_COMPONENT_TYPE:
				return providedRoles__ProvidesComponentType != null && !providedRoles__ProvidesComponentType.isEmpty();
			case RepositoryPackage.PROVIDES_COMPONENT_TYPE__REQUIRED_ROLES_PROVIDES_COMPONENT_TYPE:
				return requiredRoles_ProvidesComponentType != null && !requiredRoles_ProvidesComponentType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProvidesComponentTypeImpl