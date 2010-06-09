/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.DataTypeImpl#getCharacterisationDefinitions__Datatype <em>Characterisation Definitions Datatype</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.DataTypeImpl#getRepository_DataType <em>Repository Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DataTypeImpl extends EntityImpl implements DataType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getCharacterisationDefinitions__Datatype() <em>Characterisation Definitions Datatype</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCharacterisationDefinitions__Datatype()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableCharacterisationType> characterisationDefinitions__Datatype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableCharacterisationType> getCharacterisationDefinitions__Datatype() {
		if (characterisationDefinitions__Datatype == null) {
			characterisationDefinitions__Datatype = new EDataTypeUniqueEList<VariableCharacterisationType>(VariableCharacterisationType.class, this, RepositoryPackage.DATA_TYPE__CHARACTERISATION_DEFINITIONS_DATATYPE);
		}
		return characterisationDefinitions__Datatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository getRepository_DataType() {
		if (eContainerFeatureID() != RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE) return null;
		return (Repository)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository_DataType(Repository newRepository_DataType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepository_DataType, RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepository_DataType(Repository newRepository_DataType) {
		if (newRepository_DataType != eInternalContainer() || (eContainerFeatureID() != RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE && newRepository_DataType != null)) {
			if (EcoreUtil.isAncestor(this, newRepository_DataType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRepository_DataType != null)
				msgs = ((InternalEObject)newRepository_DataType).eInverseAdd(this, RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY, Repository.class, msgs);
			msgs = basicSetRepository_DataType(newRepository_DataType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE, newRepository_DataType, newRepository_DataType));
	}

	/**
	 * The cached OCL expression body for the '{@link #DataTypeMustNotHaveAvailableCharacterisationsWithIdenticalNameToBeParsableAsCode(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Type Must Not Have Available Characterisations With Identical Name To Be Parsable As Code</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DataTypeMustNotHaveAvailableCharacterisationsWithIdenticalNameToBeParsableAsCode(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_TYPE_MUST_NOT_HAVE_AVAILABLE_CHARACTERISATIONS_WITH_IDENTICAL_NAME_TO_BE_PARSABLE_AS_CODE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "--self.characterisationDefinitions_Datatype.entityName->asSet()->size() = self.characterisationDefinitions_Datatype->size()\n"+"true";

	/**
	 * The cached OCL invariant for the '{@link #DataTypeMustNotHaveAvailableCharacterisationsWithIdenticalNameToBeParsableAsCode(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Data Type Must Not Have Available Characterisations With Identical Name To Be Parsable As Code</em>}' invariant operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DataTypeMustNotHaveAvailableCharacterisationsWithIdenticalNameToBeParsableAsCode(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 * @ordered
	 */
	protected static Constraint DATA_TYPE_MUST_NOT_HAVE_AVAILABLE_CHARACTERISATIONS_WITH_IDENTICAL_NAME_TO_BE_PARSABLE_AS_CODE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean DataTypeMustNotHaveAvailableCharacterisationsWithIdenticalNameToBeParsableAsCode(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (DATA_TYPE_MUST_NOT_HAVE_AVAILABLE_CHARACTERISATIONS_WITH_IDENTICAL_NAME_TO_BE_PARSABLE_AS_CODE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
			OCL.Helper helper = EOCL_ENV.createOCLHelper();
			helper.setContext(RepositoryPackage.Literals.DATA_TYPE);
			try {
				DATA_TYPE_MUST_NOT_HAVE_AVAILABLE_CHARACTERISATIONS_WITH_IDENTICAL_NAME_TO_BE_PARSABLE_AS_CODE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(DATA_TYPE_MUST_NOT_HAVE_AVAILABLE_CHARACTERISATIONS_WITH_IDENTICAL_NAME_TO_BE_PARSABLE_AS_CODE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
			}
			catch (ParserException pe) {
				throw new UnsupportedOperationException(pe.getLocalizedMessage());
			}
		}
		if (!EOCL_ENV.createQuery(DATA_TYPE_MUST_NOT_HAVE_AVAILABLE_CHARACTERISATIONS_WITH_IDENTICAL_NAME_TO_BE_PARSABLE_AS_CODE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 RepositoryValidator.DIAGNOSTIC_SOURCE,
						 RepositoryValidator.DATA_TYPE__DATA_TYPE_MUST_NOT_HAVE_AVAILABLE_CHARACTERISATIONS_WITH_IDENTICAL_NAME_TO_BE_PARSABLE_AS_CODE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "DataTypeMustNotHaveAvailableCharacterisationsWithIdenticalNameToBeParsableAsCode", EObjectValidator.getObjectLabel(this, context) }),
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
			case RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRepository_DataType((Repository)otherEnd, msgs);
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
			case RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE:
				return basicSetRepository_DataType(null, msgs);
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
		switch (eContainerFeatureID()) {
			case RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY, Repository.class, msgs);
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
			case RepositoryPackage.DATA_TYPE__CHARACTERISATION_DEFINITIONS_DATATYPE:
				return getCharacterisationDefinitions__Datatype();
			case RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE:
				return getRepository_DataType();
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
			case RepositoryPackage.DATA_TYPE__CHARACTERISATION_DEFINITIONS_DATATYPE:
				getCharacterisationDefinitions__Datatype().clear();
				getCharacterisationDefinitions__Datatype().addAll((Collection<? extends VariableCharacterisationType>)newValue);
				return;
			case RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE:
				setRepository_DataType((Repository)newValue);
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
			case RepositoryPackage.DATA_TYPE__CHARACTERISATION_DEFINITIONS_DATATYPE:
				getCharacterisationDefinitions__Datatype().clear();
				return;
			case RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE:
				setRepository_DataType((Repository)null);
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
			case RepositoryPackage.DATA_TYPE__CHARACTERISATION_DEFINITIONS_DATATYPE:
				return characterisationDefinitions__Datatype != null && !characterisationDefinitions__Datatype.isEmpty();
			case RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE:
				return getRepository_DataType() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (characterisationDefinitions__Datatype: ");
		result.append(characterisationDefinitions__Datatype);
		result.append(')');
		return result.toString();
	}

	/**
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

} //DataTypeImpl
