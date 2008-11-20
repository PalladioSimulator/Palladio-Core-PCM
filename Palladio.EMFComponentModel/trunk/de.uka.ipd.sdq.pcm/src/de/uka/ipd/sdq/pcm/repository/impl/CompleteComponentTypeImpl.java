/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

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

import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complete Component Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompleteComponentTypeImpl#getParentProvidesComponentTypes <em>Parent Provides Component Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompleteComponentTypeImpl extends RepositoryComponentImpl implements CompleteComponentType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getParentProvidesComponentTypes() <em>Parent Provides Component Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentProvidesComponentTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ProvidesComponentType> parentProvidesComponentTypes;

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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
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
			case RepositoryPackage.COMPLETE_COMPONENT_TYPE__PARENT_PROVIDES_COMPONENT_TYPES:
				return parentProvidesComponentTypes != null && !parentProvidesComponentTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompleteComponentTypeImpl
