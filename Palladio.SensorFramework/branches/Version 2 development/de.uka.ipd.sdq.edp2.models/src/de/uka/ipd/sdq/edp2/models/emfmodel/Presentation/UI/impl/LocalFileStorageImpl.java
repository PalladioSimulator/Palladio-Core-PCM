/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl;

import java.io.File;
import java.util.Iterator;

import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelFactory;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.LocalFileStorage;
import de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.UIPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.util.EmfmodelSwitch;
import de.uka.ipd.sdq.edp2.models.impl.EmfModelXMIResourceFactoryImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local File Storage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.Presentation.UI.impl.LocalFileStorageImpl#getFileSystemPath <em>File System Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalFileStorageImpl extends StorageNodeImpl implements LocalFileStorage {
	/**Factory used to register the EDP2 ExperimentGroup extension for loading the experimentGroups from file.
	 * @generated not
	 */
	protected final static EmfmodelFactory EmfModelFactory = EmfmodelFactory.eINSTANCE;
	/** Resource set of the loaded file. 
	 * @generated not*/
	protected static ResourceSet resourceSet = new ResourceSetImpl();
	/**Switch used to find all ExperimentGroup(s) in a resource.
	 * @generated not
	 */
	protected EmfmodelSwitch<ExperimentGroup> experimentGroupSwitch = new EmfmodelSwitch<ExperimentGroup>() {
		public ExperimentGroup caseExperimentGroup(ExperimentGroup object) {
			return object;
		};
	};

	/**
	 * The default value of the '{@link #getFileSystemPath() <em>File System Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileSystemPath()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_SYSTEM_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileSystemPath() <em>File System Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileSystemPath()
	 * @generated
	 * @ordered
	 */
	protected String fileSystemPath = FILE_SYSTEM_PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	protected LocalFileStorageImpl() {
		super();
		resourceSet
				.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put(
						EmfModelXMIResourceFactoryImpl.EDP2_EXPERIMENT_GROUP_EXTENSION,
						new EmfModelXMIResourceFactoryImpl());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UIPackage.Literals.LOCAL_FILE_STORAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileSystemPath() {
		return fileSystemPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	public void setFileSystemPath(String newFileSystemPath) {
		String oldFileSystemPath = fileSystemPath;
		fileSystemPath = newFileSystemPath;
		// update ExperimentGroups
		experimentGroup = new EObjectWithInverseResolvingEList<ExperimentGroup>(ExperimentGroup.class, this, UIPackage.STORAGE_NODE__EXPERIMENT_GROUP, EmfmodelPackage.EXPERIMENT_GROUP__STORAGE_NODE);
		URI uri = null;
		uri = URI.createFileURI(newFileSystemPath);
		if (uri != null && new File(uri.toFileString()).isFile()) {
			Resource resource = resourceSet.getResource(uri, true);
			Iterator<EObject> iter = resource.getContents().iterator();
			while (iter.hasNext()) {
				ExperimentGroup eg = experimentGroupSwitch.doSwitch(iter.next());
				if (eg!=null) {
					experimentGroup.add(eg);
				}
			}
		}
		// notify listeners of change
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UIPackage.LOCAL_FILE_STORAGE__FILE_SYSTEM_PATH, oldFileSystemPath, fileSystemPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UIPackage.LOCAL_FILE_STORAGE__FILE_SYSTEM_PATH:
				return getFileSystemPath();
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
			case UIPackage.LOCAL_FILE_STORAGE__FILE_SYSTEM_PATH:
				setFileSystemPath((String)newValue);
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
			case UIPackage.LOCAL_FILE_STORAGE__FILE_SYSTEM_PATH:
				setFileSystemPath(FILE_SYSTEM_PATH_EDEFAULT);
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
			case UIPackage.LOCAL_FILE_STORAGE__FILE_SYSTEM_PATH:
				return FILE_SYSTEM_PATH_EDEFAULT == null ? fileSystemPath != null : !FILE_SYSTEM_PATH_EDEFAULT.equals(fileSystemPath);
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
		result.append(" (fileSystemPath: ");
		result.append(fileSystemPath);
		result.append(')');
		return result.toString();
	}

} //LocalFileStorageImpl
