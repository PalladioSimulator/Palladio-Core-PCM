/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.FileLevelSourceCodeLink;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component File Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.ComponentFileLinkImpl#getFilelevelsourcecodelink <em>Filelevelsourcecodelink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.ComponentFileLinkImpl#getRepositorycomponent <em>Repositorycomponent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentFileLinkImpl extends IdentifierImpl implements ComponentFileLink {
	/**
	 * The cached value of the '{@link #getFilelevelsourcecodelink() <em>Filelevelsourcecodelink</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilelevelsourcecodelink()
	 * @generated
	 * @ordered
	 */
	protected FileLevelSourceCodeLink filelevelsourcecodelink;

	/**
	 * The cached value of the '{@link #getRepositorycomponent() <em>Repositorycomponent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositorycomponent()
	 * @generated
	 * @ordered
	 */
	protected RepositoryComponent repositorycomponent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentFileLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PCMLinkPackage.Literals.COMPONENT_FILE_LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileLevelSourceCodeLink getFilelevelsourcecodelink() {
		if (filelevelsourcecodelink != null && filelevelsourcecodelink.eIsProxy()) {
			InternalEObject oldFilelevelsourcecodelink = (InternalEObject)filelevelsourcecodelink;
			filelevelsourcecodelink = (FileLevelSourceCodeLink)eResolveProxy(oldFilelevelsourcecodelink);
			if (filelevelsourcecodelink != oldFilelevelsourcecodelink) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMLinkPackage.COMPONENT_FILE_LINK__FILELEVELSOURCECODELINK, oldFilelevelsourcecodelink, filelevelsourcecodelink));
			}
		}
		return filelevelsourcecodelink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileLevelSourceCodeLink basicGetFilelevelsourcecodelink() {
		return filelevelsourcecodelink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilelevelsourcecodelink(FileLevelSourceCodeLink newFilelevelsourcecodelink) {
		FileLevelSourceCodeLink oldFilelevelsourcecodelink = filelevelsourcecodelink;
		filelevelsourcecodelink = newFilelevelsourcecodelink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCMLinkPackage.COMPONENT_FILE_LINK__FILELEVELSOURCECODELINK, oldFilelevelsourcecodelink, filelevelsourcecodelink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryComponent getRepositorycomponent() {
		if (repositorycomponent != null && repositorycomponent.eIsProxy()) {
			InternalEObject oldRepositorycomponent = (InternalEObject)repositorycomponent;
			repositorycomponent = (RepositoryComponent)eResolveProxy(oldRepositorycomponent);
			if (repositorycomponent != oldRepositorycomponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PCMLinkPackage.COMPONENT_FILE_LINK__REPOSITORYCOMPONENT, oldRepositorycomponent, repositorycomponent));
			}
		}
		return repositorycomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryComponent basicGetRepositorycomponent() {
		return repositorycomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositorycomponent(RepositoryComponent newRepositorycomponent) {
		RepositoryComponent oldRepositorycomponent = repositorycomponent;
		repositorycomponent = newRepositorycomponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PCMLinkPackage.COMPONENT_FILE_LINK__REPOSITORYCOMPONENT, oldRepositorycomponent, repositorycomponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PCMLinkPackage.COMPONENT_FILE_LINK__FILELEVELSOURCECODELINK:
				if (resolve) return getFilelevelsourcecodelink();
				return basicGetFilelevelsourcecodelink();
			case PCMLinkPackage.COMPONENT_FILE_LINK__REPOSITORYCOMPONENT:
				if (resolve) return getRepositorycomponent();
				return basicGetRepositorycomponent();
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
			case PCMLinkPackage.COMPONENT_FILE_LINK__FILELEVELSOURCECODELINK:
				setFilelevelsourcecodelink((FileLevelSourceCodeLink)newValue);
				return;
			case PCMLinkPackage.COMPONENT_FILE_LINK__REPOSITORYCOMPONENT:
				setRepositorycomponent((RepositoryComponent)newValue);
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
			case PCMLinkPackage.COMPONENT_FILE_LINK__FILELEVELSOURCECODELINK:
				setFilelevelsourcecodelink((FileLevelSourceCodeLink)null);
				return;
			case PCMLinkPackage.COMPONENT_FILE_LINK__REPOSITORYCOMPONENT:
				setRepositorycomponent((RepositoryComponent)null);
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
			case PCMLinkPackage.COMPONENT_FILE_LINK__FILELEVELSOURCECODELINK:
				return filelevelsourcecodelink != null;
			case PCMLinkPackage.COMPONENT_FILE_LINK__REPOSITORYCOMPONENT:
				return repositorycomponent != null;
		}
		return super.eIsSet(featureID);
	}

} //ComponentFileLinkImpl
