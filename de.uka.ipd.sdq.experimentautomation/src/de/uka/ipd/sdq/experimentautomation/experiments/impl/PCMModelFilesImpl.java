/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.impl;

import de.uka.ipd.sdq.experimentautomation.experiments.ExperimentsPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PCM Model Files</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getAllocationFile <em>Allocation File</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getUsagemodelFile <em>Usagemodel File</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getSystemFile <em>System File</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getRepositoryFile <em>Repository File</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getResourceenvironmentFile <em>Resourceenvironment File</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getMiddlewareRepositoryFile <em>Middleware Repository File</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.experimentautomation.experiments.impl.PCMModelFilesImpl#getEventMiddlewareRepositoryFile <em>Event Middleware Repository File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMModelFilesImpl extends EObjectImpl implements PCMModelFiles {
	/**
	 * The default value of the '{@link #getAllocationFile() <em>Allocation File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationFile()
	 * @generated
	 * @ordered
	 */
	protected static final String ALLOCATION_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAllocationFile() <em>Allocation File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationFile()
	 * @generated
	 * @ordered
	 */
	protected String allocationFile = ALLOCATION_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsagemodelFile() <em>Usagemodel File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsagemodelFile()
	 * @generated
	 * @ordered
	 */
	protected static final String USAGEMODEL_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsagemodelFile() <em>Usagemodel File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsagemodelFile()
	 * @generated
	 * @ordered
	 */
	protected String usagemodelFile = USAGEMODEL_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSystemFile() <em>System File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemFile()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemFile() <em>System File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemFile()
	 * @generated
	 * @ordered
	 */
	protected String systemFile = SYSTEM_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepositoryFile() <em>Repository File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryFile()
	 * @generated
	 * @ordered
	 */
	protected static final String REPOSITORY_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRepositoryFile() <em>Repository File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryFile()
	 * @generated
	 * @ordered
	 */
	protected String repositoryFile = REPOSITORY_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceenvironmentFile() <em>Resourceenvironment File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceenvironmentFile()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCEENVIRONMENT_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceenvironmentFile() <em>Resourceenvironment File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceenvironmentFile()
	 * @generated
	 * @ordered
	 */
	protected String resourceenvironmentFile = RESOURCEENVIRONMENT_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMiddlewareRepositoryFile() <em>Middleware Repository File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiddlewareRepositoryFile()
	 * @generated
	 * @ordered
	 */
	protected static final String MIDDLEWARE_REPOSITORY_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMiddlewareRepositoryFile() <em>Middleware Repository File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiddlewareRepositoryFile()
	 * @generated
	 * @ordered
	 */
	protected String middlewareRepositoryFile = MIDDLEWARE_REPOSITORY_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEventMiddlewareRepositoryFile() <em>Event Middleware Repository File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventMiddlewareRepositoryFile()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENT_MIDDLEWARE_REPOSITORY_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEventMiddlewareRepositoryFile() <em>Event Middleware Repository File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventMiddlewareRepositoryFile()
	 * @generated
	 * @ordered
	 */
	protected String eventMiddlewareRepositoryFile = EVENT_MIDDLEWARE_REPOSITORY_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PCMModelFilesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExperimentsPackage.Literals.PCM_MODEL_FILES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAllocationFile() {
		return allocationFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocationFile(String newAllocationFile) {
		String oldAllocationFile = allocationFile;
		allocationFile = newAllocationFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.PCM_MODEL_FILES__ALLOCATION_FILE, oldAllocationFile, allocationFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsagemodelFile() {
		return usagemodelFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsagemodelFile(String newUsagemodelFile) {
		String oldUsagemodelFile = usagemodelFile;
		usagemodelFile = newUsagemodelFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.PCM_MODEL_FILES__USAGEMODEL_FILE, oldUsagemodelFile, usagemodelFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemFile() {
		return systemFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemFile(String newSystemFile) {
		String oldSystemFile = systemFile;
		systemFile = newSystemFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.PCM_MODEL_FILES__SYSTEM_FILE, oldSystemFile, systemFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRepositoryFile() {
		return repositoryFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryFile(String newRepositoryFile) {
		String oldRepositoryFile = repositoryFile;
		repositoryFile = newRepositoryFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.PCM_MODEL_FILES__REPOSITORY_FILE, oldRepositoryFile, repositoryFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResourceenvironmentFile() {
		return resourceenvironmentFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceenvironmentFile(String newResourceenvironmentFile) {
		String oldResourceenvironmentFile = resourceenvironmentFile;
		resourceenvironmentFile = newResourceenvironmentFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE, oldResourceenvironmentFile, resourceenvironmentFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMiddlewareRepositoryFile() {
		return middlewareRepositoryFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMiddlewareRepositoryFile(String newMiddlewareRepositoryFile) {
		String oldMiddlewareRepositoryFile = middlewareRepositoryFile;
		middlewareRepositoryFile = newMiddlewareRepositoryFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE, oldMiddlewareRepositoryFile, middlewareRepositoryFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEventMiddlewareRepositoryFile() {
		return eventMiddlewareRepositoryFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventMiddlewareRepositoryFile(String newEventMiddlewareRepositoryFile) {
		String oldEventMiddlewareRepositoryFile = eventMiddlewareRepositoryFile;
		eventMiddlewareRepositoryFile = newEventMiddlewareRepositoryFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentsPackage.PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE, oldEventMiddlewareRepositoryFile, eventMiddlewareRepositoryFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExperimentsPackage.PCM_MODEL_FILES__ALLOCATION_FILE:
				return getAllocationFile();
			case ExperimentsPackage.PCM_MODEL_FILES__USAGEMODEL_FILE:
				return getUsagemodelFile();
			case ExperimentsPackage.PCM_MODEL_FILES__SYSTEM_FILE:
				return getSystemFile();
			case ExperimentsPackage.PCM_MODEL_FILES__REPOSITORY_FILE:
				return getRepositoryFile();
			case ExperimentsPackage.PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE:
				return getResourceenvironmentFile();
			case ExperimentsPackage.PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE:
				return getMiddlewareRepositoryFile();
			case ExperimentsPackage.PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE:
				return getEventMiddlewareRepositoryFile();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExperimentsPackage.PCM_MODEL_FILES__ALLOCATION_FILE:
				setAllocationFile((String)newValue);
				return;
			case ExperimentsPackage.PCM_MODEL_FILES__USAGEMODEL_FILE:
				setUsagemodelFile((String)newValue);
				return;
			case ExperimentsPackage.PCM_MODEL_FILES__SYSTEM_FILE:
				setSystemFile((String)newValue);
				return;
			case ExperimentsPackage.PCM_MODEL_FILES__REPOSITORY_FILE:
				setRepositoryFile((String)newValue);
				return;
			case ExperimentsPackage.PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE:
				setResourceenvironmentFile((String)newValue);
				return;
			case ExperimentsPackage.PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE:
				setMiddlewareRepositoryFile((String)newValue);
				return;
			case ExperimentsPackage.PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE:
				setEventMiddlewareRepositoryFile((String)newValue);
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
			case ExperimentsPackage.PCM_MODEL_FILES__ALLOCATION_FILE:
				setAllocationFile(ALLOCATION_FILE_EDEFAULT);
				return;
			case ExperimentsPackage.PCM_MODEL_FILES__USAGEMODEL_FILE:
				setUsagemodelFile(USAGEMODEL_FILE_EDEFAULT);
				return;
			case ExperimentsPackage.PCM_MODEL_FILES__SYSTEM_FILE:
				setSystemFile(SYSTEM_FILE_EDEFAULT);
				return;
			case ExperimentsPackage.PCM_MODEL_FILES__REPOSITORY_FILE:
				setRepositoryFile(REPOSITORY_FILE_EDEFAULT);
				return;
			case ExperimentsPackage.PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE:
				setResourceenvironmentFile(RESOURCEENVIRONMENT_FILE_EDEFAULT);
				return;
			case ExperimentsPackage.PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE:
				setMiddlewareRepositoryFile(MIDDLEWARE_REPOSITORY_FILE_EDEFAULT);
				return;
			case ExperimentsPackage.PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE:
				setEventMiddlewareRepositoryFile(EVENT_MIDDLEWARE_REPOSITORY_FILE_EDEFAULT);
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
			case ExperimentsPackage.PCM_MODEL_FILES__ALLOCATION_FILE:
				return ALLOCATION_FILE_EDEFAULT == null ? allocationFile != null : !ALLOCATION_FILE_EDEFAULT.equals(allocationFile);
			case ExperimentsPackage.PCM_MODEL_FILES__USAGEMODEL_FILE:
				return USAGEMODEL_FILE_EDEFAULT == null ? usagemodelFile != null : !USAGEMODEL_FILE_EDEFAULT.equals(usagemodelFile);
			case ExperimentsPackage.PCM_MODEL_FILES__SYSTEM_FILE:
				return SYSTEM_FILE_EDEFAULT == null ? systemFile != null : !SYSTEM_FILE_EDEFAULT.equals(systemFile);
			case ExperimentsPackage.PCM_MODEL_FILES__REPOSITORY_FILE:
				return REPOSITORY_FILE_EDEFAULT == null ? repositoryFile != null : !REPOSITORY_FILE_EDEFAULT.equals(repositoryFile);
			case ExperimentsPackage.PCM_MODEL_FILES__RESOURCEENVIRONMENT_FILE:
				return RESOURCEENVIRONMENT_FILE_EDEFAULT == null ? resourceenvironmentFile != null : !RESOURCEENVIRONMENT_FILE_EDEFAULT.equals(resourceenvironmentFile);
			case ExperimentsPackage.PCM_MODEL_FILES__MIDDLEWARE_REPOSITORY_FILE:
				return MIDDLEWARE_REPOSITORY_FILE_EDEFAULT == null ? middlewareRepositoryFile != null : !MIDDLEWARE_REPOSITORY_FILE_EDEFAULT.equals(middlewareRepositoryFile);
			case ExperimentsPackage.PCM_MODEL_FILES__EVENT_MIDDLEWARE_REPOSITORY_FILE:
				return EVENT_MIDDLEWARE_REPOSITORY_FILE_EDEFAULT == null ? eventMiddlewareRepositoryFile != null : !EVENT_MIDDLEWARE_REPOSITORY_FILE_EDEFAULT.equals(eventMiddlewareRepositoryFile);
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
		result.append(" (allocationFile: ");
		result.append(allocationFile);
		result.append(", usagemodelFile: ");
		result.append(usagemodelFile);
		result.append(", systemFile: ");
		result.append(systemFile);
		result.append(", repositoryFile: ");
		result.append(repositoryFile);
		result.append(", resourceenvironmentFile: ");
		result.append(resourceenvironmentFile);
		result.append(", middlewareRepositoryFile: ");
		result.append(middlewareRepositoryFile);
		result.append(", eventMiddlewareRepositoryFile: ");
		result.append(eventMiddlewareRepositoryFile);
		result.append(')');
		return result.toString();
	}

} //PCMModelFilesImpl
