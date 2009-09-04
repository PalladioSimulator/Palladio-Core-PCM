/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IData Source Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Contains the information to identify a data source and get metainformation/descriptions on that particular source.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.IDataSourceDescription#getRegistry <em>Registry</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage#getIDataSourceDescription()
 * @model interface="true" abstract="true"
 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML interface='null' persistable='null'"
 * @generated
 */
public interface IDataSourceDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Registry</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * specifies information on the registry in which the data source can be found. In the SensorFramework, this would be the either the absolute Path on the file system or the number of the mounted dataset in the singleton of the SF's experiments view.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Registry</em>' attribute.
	 * @see #setRegistry(String)
	 * @see de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage#getIDataSourceDescription_Registry()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getRegistry();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.edp2.models.Presentation.IDataSourceDescription#getRegistry <em>Registry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registry</em>' attribute.
	 * @see #getRegistry()
	 * @generated
	 */
	void setRegistry(String value);

} // IDataSourceDescription
