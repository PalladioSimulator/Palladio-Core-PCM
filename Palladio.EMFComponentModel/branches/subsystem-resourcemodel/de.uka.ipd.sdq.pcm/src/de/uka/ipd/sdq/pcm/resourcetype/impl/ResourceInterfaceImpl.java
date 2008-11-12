/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourcetype.impl;

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
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

import de.uka.ipd.sdq.pcm.repository.impl.AbstractInterfaceImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceService;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resourcetype.util.ResourcetypeValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resourcetype.impl.ResourceInterfaceImpl#getResourceServices_ResourceInterface <em>Resource Services Resource Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceInterfaceImpl extends AbstractInterfaceImpl implements ResourceInterface {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getResourceServices_ResourceInterface() <em>Resource Services Resource Interface</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceServices_ResourceInterface()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceService> resourceServices_ResourceInterface;

	/**
	 * The parsed OCL expression for the definition of the '{@link #ResourceServiceNamesHaveToBeUniqueForAResourceInterface <em>Resource Service Names Have To Be Unique For AResource Interface</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ResourceServiceNamesHaveToBeUniqueForAResourceInterface
	 * @generated
	 */
	private static OCLExpression ResourceServiceNamesHaveToBeUniqueForAResourceInterfaceInvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcetypePackage.Literals.RESOURCE_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceService> getResourceServices_ResourceInterface() {
		if (resourceServices_ResourceInterface == null) {
			resourceServices_ResourceInterface = new EObjectContainmentEList<ResourceService>(ResourceService.class, this, ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SERVICES_RESOURCE_INTERFACE);
		}
		return resourceServices_ResourceInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ResourceServiceNamesHaveToBeUniqueForAResourceInterface(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (ResourceServiceNamesHaveToBeUniqueForAResourceInterfaceInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.resourceServices_ResourceInterface->isUnique(r : ResourceService |  	r.serviceName) ";
			
			try {
				ResourceServiceNamesHaveToBeUniqueForAResourceInterfaceInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(ResourceServiceNamesHaveToBeUniqueForAResourceInterfaceInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ResourcetypeValidator.DIAGNOSTIC_SOURCE,
						 ResourcetypeValidator.RESOURCE_INTERFACE__RESOURCE_SERVICE_NAMES_HAVE_TO_BE_UNIQUE_FOR_ARESOURCE_INTERFACE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ResourceServiceNamesHaveToBeUniqueForAResourceInterface", EObjectValidator.getObjectLabel(this, context) }),
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SERVICES_RESOURCE_INTERFACE:
				return ((InternalEList<?>)getResourceServices_ResourceInterface()).basicRemove(otherEnd, msgs);
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
			case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SERVICES_RESOURCE_INTERFACE:
				return getResourceServices_ResourceInterface();
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
			case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SERVICES_RESOURCE_INTERFACE:
				getResourceServices_ResourceInterface().clear();
				getResourceServices_ResourceInterface().addAll((Collection<? extends ResourceService>)newValue);
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
			case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SERVICES_RESOURCE_INTERFACE:
				getResourceServices_ResourceInterface().clear();
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
			case ResourcetypePackage.RESOURCE_INTERFACE__RESOURCE_SERVICES_RESOURCE_INTERFACE:
				return resourceServices_ResourceInterface != null && !resourceServices_ResourceInterface.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResourceInterfaceImpl
