
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

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

import org.eclipse.emf.ocl.expressions.OCLExpression;

import org.eclipse.emf.ocl.expressions.util.EvalEnvironment;
import org.eclipse.emf.ocl.expressions.util.ExpressionsUtil;

import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.ParserException;

import org.eclipse.emf.ocl.query.Query;
import org.eclipse.emf.ocl.query.QueryFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeDataTypeImpl#getRepository_DataType <em>Repository Data Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeDataTypeImpl#getParentType_CompositeDataType <em>Parent Type Composite Data Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.CompositeDataTypeImpl#getInnerDeclaration_CompositeDataType <em>Inner Declaration Composite Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeDataTypeImpl extends EntityImpl implements CompositeDataType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The cached value of the '{@link #getParentType_CompositeDataType() <em>Parent Type Composite Data Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentType_CompositeDataType()
	 * @generated
	 * @ordered
	 */
	protected EList parentType_CompositeDataType = null;

	/**
	 * The cached value of the '{@link #getInnerDeclaration_CompositeDataType() <em>Inner Declaration Composite Data Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerDeclaration_CompositeDataType()
	 * @generated
	 * @ordered
	 */
	protected EList innerDeclaration_CompositeDataType = null;


	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.COMPOSITE_DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repository getRepository_DataType() {
		if (eContainerFeatureID != RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE) return null;
		return (Repository)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepository_DataType(Repository newRepository_DataType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRepository_DataType, RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepository_DataType(Repository newRepository_DataType) {
		if (newRepository_DataType != eInternalContainer() || (eContainerFeatureID != RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE && newRepository_DataType != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE, newRepository_DataType, newRepository_DataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getParentType_CompositeDataType() {
		if (parentType_CompositeDataType == null) {
			parentType_CompositeDataType = new EObjectResolvingEList(CompositeDataType.class, this, RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE);
		}
		return parentType_CompositeDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getInnerDeclaration_CompositeDataType() {
		if (innerDeclaration_CompositeDataType == null) {
			innerDeclaration_CompositeDataType = new EObjectContainmentEList(InnerDeclaration.class, this, RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE);
		}
		return innerDeclaration_CompositeDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
				return basicSetRepository_DataType(null, msgs);
			case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
				return ((InternalEList)getInnerDeclaration_CompositeDataType()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.REPOSITORY__DATATYPES_REPOSITORY, Repository.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
				return getRepository_DataType();
			case RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE:
				return getParentType_CompositeDataType();
			case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
				return getInnerDeclaration_CompositeDataType();
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
			case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
				setRepository_DataType((Repository)newValue);
				return;
			case RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE:
				getParentType_CompositeDataType().clear();
				getParentType_CompositeDataType().addAll((Collection)newValue);
				return;
			case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
				getInnerDeclaration_CompositeDataType().clear();
				getInnerDeclaration_CompositeDataType().addAll((Collection)newValue);
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
			case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
				setRepository_DataType((Repository)null);
				return;
			case RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE:
				getParentType_CompositeDataType().clear();
				return;
			case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
				getInnerDeclaration_CompositeDataType().clear();
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
			case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE:
				return getRepository_DataType() != null;
			case RepositoryPackage.COMPOSITE_DATA_TYPE__PARENT_TYPE_COMPOSITE_DATA_TYPE:
				return parentType_CompositeDataType != null && !parentType_CompositeDataType.isEmpty();
			case RepositoryPackage.COMPOSITE_DATA_TYPE__INNER_DECLARATION_COMPOSITE_DATA_TYPE:
				return innerDeclaration_CompositeDataType != null && !innerDeclaration_CompositeDataType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == DataType.class) {
			switch (derivedFeatureID) {
				case RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE: return RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE;
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == DataType.class) {
			switch (baseFeatureID) {
				case RepositoryPackage.DATA_TYPE__REPOSITORY_DATA_TYPE: return RepositoryPackage.COMPOSITE_DATA_TYPE__REPOSITORY_DATA_TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CompositeDataTypeImpl