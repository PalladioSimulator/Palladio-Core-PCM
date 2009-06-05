
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.impl;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.identifier.util.IdentifierValidator;

import de.uka.ipd.sdq.pcm.allocation.Allocation;

import de.uka.ipd.sdq.pcm.core.composition.impl.ComposedStructureImpl;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemProvidedRole;
import de.uka.ipd.sdq.pcm.system.SystemRequiredRole;

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
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getEntityName <em>Entity Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getSystemProvidedRole_System <em>System Provided Role System</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getAllocation_System <em>Allocation System</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.impl.SystemImpl#getSystemRequiredRole_System <em>System Required Role System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends ComposedStructureImpl implements de.uka.ipd.sdq.pcm.system.System {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntityName()
	 * @generated
	 * @ordered
	 */
	protected static final String ENTITY_NAME_EDEFAULT = null;


	/**
	 * The cached value of the '{@link #getEntityName() <em>Entity Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntityName()
	 * @generated
	 * @ordered
	 */
	protected String entityName = ENTITY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSystemProvidedRole_System() <em>System Provided Role System</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemProvidedRole_System()
	 * @generated
	 * @ordered
	 */
	protected EList systemProvidedRole_System = null;

	/**
	 * The cached value of the '{@link #getAllocation_System() <em>Allocation System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocation_System()
	 * @generated
	 * @ordered
	 */
	protected Allocation allocation_System = null;

	/**
	 * The cached value of the '{@link #getSystemRequiredRole_System() <em>System Required Role System</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemRequiredRole_System()
	 * @generated
	 * @ordered
	 */
	protected EList systemRequiredRole_System = null;


	/**
	 * The parsed OCL expression for the definition of the '{@link #idHasToBeUnique <em>Id Has To Be Unique</em>}' invariant constraint.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #idHasToBeUnique
	 * @generated
	 */
	private static OCLExpression idHasToBeUniqueInvOCL;
	
	private static final String OCL_ANNOTATION_SOURCE = "http://www.eclipse.org/emf/2002/GenModel";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return SystemPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEntityName(String newEntityName) {
		String oldEntityName = entityName;
		entityName = newEntityName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__ENTITY_NAME, oldEntityName, entityName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSystemProvidedRole_System() {
		if (systemProvidedRole_System == null) {
			systemProvidedRole_System = new EObjectContainmentWithInverseEList(SystemProvidedRole.class, this, SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM, SystemPackage.SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE);
		}
		return systemProvidedRole_System;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Allocation getAllocation_System() {
		if (allocation_System != null && allocation_System.eIsProxy()) {
			InternalEObject oldAllocation_System = (InternalEObject)allocation_System;
			allocation_System = (Allocation)eResolveProxy(oldAllocation_System);
			if (allocation_System != oldAllocation_System) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SystemPackage.SYSTEM__ALLOCATION_SYSTEM, oldAllocation_System, allocation_System));
			}
		}
		return allocation_System;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Allocation basicGetAllocation_System() {
		return allocation_System;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocation_System(Allocation newAllocation_System) {
		Allocation oldAllocation_System = allocation_System;
		allocation_System = newAllocation_System;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SystemPackage.SYSTEM__ALLOCATION_SYSTEM, oldAllocation_System, allocation_System));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSystemRequiredRole_System() {
		if (systemRequiredRole_System == null) {
			systemRequiredRole_System = new EObjectContainmentWithInverseEList(SystemRequiredRole.class, this, SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM, SystemPackage.SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE);
		}
		return systemRequiredRole_System;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean idHasToBeUnique(DiagnosticChain diagnostics, Map context) {
		if (idHasToBeUniqueInvOCL == null) {
			Environment env = ExpressionsUtil.createClassifierContext(eClass());
			
			
			String body = "self.allInstances()->isUnique(p | p.id) ";
			
			try {
				idHasToBeUniqueInvOCL = ExpressionsUtil.createInvariant(env, body, true);
			} catch (ParserException e) {
				throw new UnsupportedOperationException(e.getLocalizedMessage());
			}
		}
		
		Query query = QueryFactory.eINSTANCE.createQuery(idHasToBeUniqueInvOCL);
		EvalEnvironment evalEnv = new EvalEnvironment();
		query.setEvaluationEnvironment(evalEnv);
		
		if (!query.check(this)) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 IdentifierValidator.DIAGNOSTIC_SOURCE,
						 IdentifierValidator.IDENTIFIER__ID_HAS_TO_BE_UNIQUE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "idHasToBeUnique", EObjectValidator.getObjectLabel(this, context) }),
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
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
				return ((InternalEList)getSystemProvidedRole_System()).basicAdd(otherEnd, msgs);
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				return ((InternalEList)getSystemRequiredRole_System()).basicAdd(otherEnd, msgs);
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
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
				return ((InternalEList)getSystemProvidedRole_System()).basicRemove(otherEnd, msgs);
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				return ((InternalEList)getSystemRequiredRole_System()).basicRemove(otherEnd, msgs);
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
			case SystemPackage.SYSTEM__ID:
				return getId();
			case SystemPackage.SYSTEM__ENTITY_NAME:
				return getEntityName();
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
				return getSystemProvidedRole_System();
			case SystemPackage.SYSTEM__ALLOCATION_SYSTEM:
				if (resolve) return getAllocation_System();
				return basicGetAllocation_System();
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				return getSystemRequiredRole_System();
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
			case SystemPackage.SYSTEM__ID:
				setId((String)newValue);
				return;
			case SystemPackage.SYSTEM__ENTITY_NAME:
				setEntityName((String)newValue);
				return;
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
				getSystemProvidedRole_System().clear();
				getSystemProvidedRole_System().addAll((Collection)newValue);
				return;
			case SystemPackage.SYSTEM__ALLOCATION_SYSTEM:
				setAllocation_System((Allocation)newValue);
				return;
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				getSystemRequiredRole_System().clear();
				getSystemRequiredRole_System().addAll((Collection)newValue);
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
			case SystemPackage.SYSTEM__ID:
				setId(ID_EDEFAULT);
				return;
			case SystemPackage.SYSTEM__ENTITY_NAME:
				setEntityName(ENTITY_NAME_EDEFAULT);
				return;
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
				getSystemProvidedRole_System().clear();
				return;
			case SystemPackage.SYSTEM__ALLOCATION_SYSTEM:
				setAllocation_System((Allocation)null);
				return;
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				getSystemRequiredRole_System().clear();
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
			case SystemPackage.SYSTEM__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SystemPackage.SYSTEM__ENTITY_NAME:
				return ENTITY_NAME_EDEFAULT == null ? entityName != null : !ENTITY_NAME_EDEFAULT.equals(entityName);
			case SystemPackage.SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM:
				return systemProvidedRole_System != null && !systemProvidedRole_System.isEmpty();
			case SystemPackage.SYSTEM__ALLOCATION_SYSTEM:
				return allocation_System != null;
			case SystemPackage.SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM:
				return systemRequiredRole_System != null && !systemRequiredRole_System.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == Identifier.class) {
			switch (derivedFeatureID) {
				case SystemPackage.SYSTEM__ID: return IdentifierPackage.IDENTIFIER__ID;
				default: return -1;
			}
		}
		if (baseClass == Entity.class) {
			switch (derivedFeatureID) {
				case SystemPackage.SYSTEM__ENTITY_NAME: return EntityPackage.ENTITY__ENTITY_NAME;
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
		if (baseClass == Identifier.class) {
			switch (baseFeatureID) {
				case IdentifierPackage.IDENTIFIER__ID: return SystemPackage.SYSTEM__ID;
				default: return -1;
			}
		}
		if (baseClass == Entity.class) {
			switch (baseFeatureID) {
				case EntityPackage.ENTITY__ENTITY_NAME: return SystemPackage.SYSTEM__ENTITY_NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", entityName: ");
		result.append(entityName);
		result.append(')');
		return result.toString();
	}

} //SystemImpl